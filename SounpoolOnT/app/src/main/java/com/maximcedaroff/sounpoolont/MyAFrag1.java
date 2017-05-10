package com.maximcedaroff.sounpoolont;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Develop on 02.08.2016.
 */
public class MyAFrag1 extends Fragment {

	private SoundPool mySounds;

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
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
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
		final int s10Id = mySounds.load(getContext(), R.raw.beat1, 1);
		final int s11Id = mySounds.load(getContext(), R.raw.beat2, 1);
		final int s12Id = mySounds.load(getContext(), R.raw.beat3, 1);
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
		view.findViewById(R.id.button10).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mySounds.play(s10Id, 1, 1, 1, 0, 1);
			}
		});
		view.findViewById(R.id.button11).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mySounds.play(s11Id, 1, 1, 1, 0, 1);
			}
		});
		view.findViewById(R.id.button12).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mySounds.play(s12Id, 1, 1, 1, 0, 1);
			}
		});
	}
}
