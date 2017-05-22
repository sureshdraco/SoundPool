package com.maximcedaroff.sounpoolont;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
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
public class MyBFrag3 extends Fragment implements StateChangeListener {


	private RadioButton toggleButton1, toggleButton2, toggleButton3;
	private AActivity aActivity;

	public static MyBFrag3 newInstance() {

		MyBFrag3 fragment = new MyBFrag3();
		return fragment;
	}

	public MyBFrag3() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_b1, container, false);
		return rootView;
	}

	@Override
	public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		aActivity = (AActivity) getActivity();
		aActivity.addStateChangedListener(this);
		aActivity.onViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
			}

			@Override
			public void onPageSelected(int position) {
//				if (position != 0) {
//					releasEmp();
//					((RadioGroup) view.findViewById(R.id.toggleGroup)).clearCheck();
//				}
			}

			@Override
			public void onPageScrollStateChanged(int state) {
			}
		});
		view.findViewById(R.id.button1).setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				return handleBtnClick(view, motionEvent, R.raw.s21);
			}
		});
		view.findViewById(R.id.button2).setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				return handleBtnClick(view, motionEvent, R.raw.s27);
			}
		});
		view.findViewById(R.id.button3).setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				return handleBtnClick(view, motionEvent, R.raw.s8);
			}
		});
		view.findViewById(R.id.button4).setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				return handleBtnClick(view, motionEvent, R.raw.s19);
			}
		});
		view.findViewById(R.id.button5).setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				return handleBtnClick(view, motionEvent, R.raw.s28);
			}
		});
		view.findViewById(R.id.button6).setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				return handleBtnClick(view, motionEvent, R.raw.s33);
			}
		});
		view.findViewById(R.id.button7).setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				return handleBtnClick(view, motionEvent, R.raw.s42);
			}
		});
		view.findViewById(R.id.button8).setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				return handleBtnClick(view, motionEvent, R.raw.s39);
			}
		});
		view.findViewById(R.id.button9).setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				return handleBtnClick(view, motionEvent, R.raw.s4);
			}
		});
		toggleButton1 = (RadioButton) view.findViewById(R.id.button10);
		toggleButton2 = (RadioButton) view.findViewById(R.id.button11);
		toggleButton3 = (RadioButton) view.findViewById(R.id.button12);
		toggleButton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
				int beatInUse = R.raw.beat16;
				aActivity.initStateChange(MyBFrag3.this, b);
				aActivity.handleBeat(b, beatInUse);
			}
		});
		toggleButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
				int beatInUse = R.raw.beat17;
				aActivity.initStateChange(MyBFrag3.this, b);
				aActivity.handleBeat(b, beatInUse);
			}
		});
		toggleButton3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
				int beatInUse = R.raw.beat18;
				aActivity.initStateChange(MyBFrag3.this, b);
				aActivity.handleBeat(b, beatInUse);
			}
		});
	}

	private boolean handleBtnClick(View view, MotionEvent motionEvent, int s1Id) {
		switch (motionEvent.getAction()) {
			case MotionEvent.ACTION_DOWN:
				aActivity.playSound(s1Id);
				view.setBackgroundResource(R.drawable.buttonb_press_w);
				break;
			case MotionEvent.ACTION_UP:
			case MotionEvent.ACTION_CANCEL:
				view.setBackgroundResource(R.drawable.buttonb_unpress);
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
