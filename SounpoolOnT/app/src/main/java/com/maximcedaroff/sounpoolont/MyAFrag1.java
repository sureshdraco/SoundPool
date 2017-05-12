package com.maximcedaroff.sounpoolont;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by Develop on 02.08.2016.
 */
public class MyAFrag1 extends Fragment implements StateChangeListener {

	private SoundPool mySounds;
	private LoopMediaPlayer mp;
	private RadioButton toggleButton1, toggleButton2, toggleButton3;
	private int currentBeat = -1;
	private AActivity aActivity;

	public static MyAFrag1 newInstance() {

		MyAFrag1 fragment = new MyAFrag1();
		return fragment;
	}

	public MyAFrag1() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_a1, container, false);
		return rootView;
	}

	@Override
	public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		aActivity = (AActivity) getActivity();
		aActivity.addStateChangedListener(this);
		mySounds = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
		final int s1Id = mySounds.load(getContext(), R.raw.s1, 1);
		final int s2Id = mySounds.load(getContext(), R.raw.s2, 1);
		final int s3Id = mySounds.load(getContext(), R.raw.s3, 1);
		final int s4Id = mySounds.load(getContext(), R.raw.s4, 1);
		final int s5Id = mySounds.load(getContext(), R.raw.s5, 1);
		final int s6Id = mySounds.load(getContext(), R.raw.s6, 1);
		final int s7Id = mySounds.load(getContext(), R.raw.s7, 1);
		final int s8Id = mySounds.load(getContext(), R.raw.s8, 1);
		final int s9Id = mySounds.load(getContext(), R.raw.s9, 1);
		view.findViewById(R.id.button1).setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				return handleBtnClick(view, motionEvent, s1Id);
			}
		});
		view.findViewById(R.id.button2).setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				return handleBtnClick(view, motionEvent, s2Id);
			}
		});
		view.findViewById(R.id.button3).setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				return handleBtnClick(view, motionEvent, s3Id);
			}
		});
		view.findViewById(R.id.button4).setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				return handleBtnClick(view, motionEvent, s4Id);
			}
		});
		view.findViewById(R.id.button5).setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				return handleBtnClick(view, motionEvent, s5Id);
			}
		});
		view.findViewById(R.id.button6).setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				return handleBtnClick(view, motionEvent, s6Id);
			}
		});
		view.findViewById(R.id.button7).setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				return handleBtnClick(view, motionEvent, s7Id);
			}
		});
		view.findViewById(R.id.button8).setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				return handleBtnClick(view, motionEvent, s8Id);
			}
		});
		view.findViewById(R.id.button9).setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				return handleBtnClick(view, motionEvent, s9Id);
			}
		});
		toggleButton1 = (RadioButton) view.findViewById(R.id.button10);
		toggleButton2 = (RadioButton) view.findViewById(R.id.button11);
		toggleButton3 = (RadioButton) view.findViewById(R.id.button12);
		toggleButton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
				int beatInUse = R.raw.beat1;
				aActivity.initStateChange(MyAFrag1.this, b);
				aActivity.handleBeat(b, beatInUse);
			}
		});
		toggleButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
				int beatInUse = R.raw.beat2;
				aActivity.initStateChange(MyAFrag1.this, b);
				aActivity.handleBeat(b, beatInUse);
			}
		});
		toggleButton3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
				int beatInUse = R.raw.beat3;
				aActivity.initStateChange(MyAFrag1.this, b);
				aActivity.handleBeat(b, beatInUse);
			}
		});
	}

	private boolean handleBtnClick(View view, MotionEvent motionEvent, int s1Id) {
		Log.d("action", "Action:" + motionEvent.getAction());

		switch (motionEvent.getAction()) {
		case MotionEvent.ACTION_DOWN:
			mySounds.play(s1Id, 1, 1, 1, 0, 1);
			view.setBackgroundResource(R.drawable.button_press_w);
			break;

		case MotionEvent.ACTION_UP:
		case MotionEvent.ACTION_CANCEL:
			view.setBackgroundResource(R.drawable.button_unpress);
			break;
		}
		return true;
	}

	@Override
	public void onStateChangedListener(Fragment fragment, boolean state) {
		if (fragment != this && state && getView() != null) {
			int checkedId = ((RadioGroup) getView().findViewById(R.id.toggleGroup)).getCheckedRadioButtonId();
			if (checkedId == -1) {
				return;
			}
			((RadioButton) getView().findViewById(checkedId)).setChecked(false);
		}
	}
}
