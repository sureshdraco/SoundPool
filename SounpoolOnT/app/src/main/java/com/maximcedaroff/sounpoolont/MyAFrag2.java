package com.maximcedaroff.sounpoolont;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.ToggleButton;

/**
 * Created by Develop on 02.08.2016.
 */
public class MyAFrag2 extends Fragment {
	private SoundPool mySounds;
	private LoopMediaPlayer mp;
	private RadioButton toggleButton1, toggleButton2, toggleButton3;

	public static MyAFrag2 newInstance() {

		MyAFrag2 fragment = new MyAFrag2();
		return fragment;
	}

	public MyAFrag2() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_a1, container, false);
		return rootView;
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		((AActivity) getActivity()).onViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
			}

			@Override
			public void onPageSelected(int position) {
			}

			@Override
			public void onPageScrollStateChanged(int state) {
			}
		});
		mySounds = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
		final int s1Id = mySounds.load(getContext(), R.raw.s13, 1);
		final int s2Id = mySounds.load(getContext(), R.raw.s14, 1);
		final int s3Id = mySounds.load(getContext(), R.raw.s15, 1);
		final int s4Id = mySounds.load(getContext(), R.raw.s16, 1);
		final int s5Id = mySounds.load(getContext(), R.raw.s17, 1);
		final int s6Id = mySounds.load(getContext(), R.raw.s18, 1);
		final int s7Id = mySounds.load(getContext(), R.raw.s19, 1);
		final int s8Id = mySounds.load(getContext(), R.raw.s20, 1);
		final int s9Id = mySounds.load(getContext(), R.raw.s21, 1);
		view.findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mySounds.play(s1Id, 1, 1, 1, 0, 1);
			}
		});
		view.findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mySounds.play(s1Id, 1, 1, 1, 0, 1);
			}
		});
		view.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mySounds.play(s2Id, 1, 1, 1, 0, 1);
			}
		});
		view.findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mySounds.play(s3Id, 1, 1, 1, 0, 1);
			}
		});
		view.findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mySounds.play(s4Id, 1, 1, 1, 0, 1);
			}
		});
		view.findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mySounds.play(s5Id, 1, 1, 1, 0, 1);
			}
		});
		view.findViewById(R.id.button6).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mySounds.play(s6Id, 1, 1, 1, 0, 1);
			}
		});
		view.findViewById(R.id.button7).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mySounds.play(s7Id, 1, 1, 1, 0, 1);
			}
		});
		view.findViewById(R.id.button8).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mySounds.play(s8Id, 1, 1, 1, 0, 1);
			}
		});
		view.findViewById(R.id.button9).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mySounds.play(s9Id, 1, 1, 1, 0, 1);
			}
		});
		toggleButton1 = (RadioButton) view.findViewById(R.id.button10);
		toggleButton2 = (RadioButton) view.findViewById(R.id.button11);
		toggleButton3 = (RadioButton) view.findViewById(R.id.button12);
		toggleButton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
				if (b) {
					releasEmp();
					startemp(R.raw.beat1);
				} else {
					releasEmp();
				}
			}
		});
		toggleButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

				if (b) {
					releasEmp();
					startemp(R.raw.beat3);
				} else {
					releasEmp();
				}
			}
		});
		toggleButton3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
				if (b) {
					releasEmp();
					startemp(R.raw.beat1);
				} else {
					releasEmp();
				}
			}
		});
	}

	private void startemp(int beat2) {
		mp = LoopMediaPlayer.create(getContext(), beat2);
		if (mp == null) {
			return;
		}
	}

	private void releasEmp() {
		if (mp != null) {
			mp.release();
			mp = null;
		}
	}
}