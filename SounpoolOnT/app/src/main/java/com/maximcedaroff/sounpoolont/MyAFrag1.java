package com.maximcedaroff.sounpoolont;

import android.media.AudioManager;
import android.media.SoundPool;
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

/**
 * Created by Develop on 02.08.2016.
 */
public class MyAFrag1 extends Fragment {

	private SoundPool mySounds;
	private LoopMediaPlayer mp;
	private RadioButton toggleButton1, toggleButton2, toggleButton3;
	private int currentBeat = -1;

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
		((AActivity) getActivity()).onViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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
		view.findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mySounds.play(s1Id, 1, 1, 1, 0, 1);
			}
		});
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
				handleBeat(b, beatInUse);
			}
		});
		toggleButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
				int beatInUse = R.raw.beat3;
				handleBeat(b, beatInUse);
			}
		});
		toggleButton3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
				int beatInUse = R.raw.beat1;
				handleBeat(b, beatInUse);
			}
		});
	}

	private boolean handleBtnClick(View view, MotionEvent motionEvent, int s1Id) {
		switch (motionEvent.getAction()) {
			case MotionEvent.ACTION_DOWN:
				mySounds.play(s1Id, 1, 1, 1, 1, 1);
				view.setBackgroundResource(R.drawable.button_press_w);

				break;

			case MotionEvent.ACTION_UP:
				view.setBackgroundResource(R.drawable.button_unpress);
				break;
		}
		return true;
	}

	private void handleBeat(boolean b, int beatInUse) {
		if (b) {
			releasEmp();
			startemp(beatInUse);
		} else {
			if (currentBeat == beatInUse) {
				releasEmp();
			}
		}
	}

	private void startemp(int beat2) {
		currentBeat = beat2;
		mp = LoopMediaPlayer.create(getContext(), beat2);
	}

	private void dupStart(int beat2) {
//		if (mp != null && mp.getCurrentPlayer() != null) {
//			releasEmp();
//			mp = LoopMediaPlayer.create(getContext(), beat2);
//		}
	}


	@Override
	public void onDestroy() {
		super.onDestroy();
		releasEmp();
	}

	private void releasEmp() {
		currentBeat = -1;
		if (mp != null) {
			mp.release();
			mp = null;
		}
	}
}
