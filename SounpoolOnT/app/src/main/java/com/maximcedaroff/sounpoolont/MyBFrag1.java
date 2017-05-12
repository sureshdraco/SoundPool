package com.maximcedaroff.sounpoolont;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Develop on 02.08.2016.
 */
public class MyBFrag1 extends Fragment {

	public static MyBFrag1 newInstance() {

		MyBFrag1 fragment = new MyBFrag1();
		return fragment;
	}

	public MyBFrag1() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_b1, container, false);
		return rootView;
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		((AActivity) getActivity()).offViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
			}

			@Override
			public void onPageSelected(int position) {
				if (position != 0) {
					//releasEmp();
				}
			}

			@Override
			public void onPageScrollStateChanged(int state) {
			}
		});
	}
}
