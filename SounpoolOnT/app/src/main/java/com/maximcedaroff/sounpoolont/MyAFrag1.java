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
		view.findViewById(R.id.button1).setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				return handleBtnClick(view, motionEvent, R.raw.s1);
			}
		});
		view.findViewById(R.id.button2).setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				return handleBtnClick(view, motionEvent, R.raw.s2);
			}
		});
		view.findViewById(R.id.button3).setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				return handleBtnClick(view, motionEvent, R.raw.s3);
			}
		});
		view.findViewById(R.id.button4).setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				return handleBtnClick(view, motionEvent, R.raw.s4);
			}
		});
		view.findViewById(R.id.button5).setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				return handleBtnClick(view, motionEvent, R.raw.s5);
			}
		});
		view.findViewById(R.id.button6).setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				return handleBtnClick(view, motionEvent, R.raw.s6);
			}
		});
		view.findViewById(R.id.button7).setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				return handleBtnClick(view, motionEvent, R.raw.s7);
			}
		});
		view.findViewById(R.id.button8).setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				return handleBtnClick(view, motionEvent, R.raw.s8);
			}
		});
		view.findViewById(R.id.button9).setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				return handleBtnClick(view, motionEvent, R.raw.s9);
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
				aActivity.playSound(s1Id);
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
