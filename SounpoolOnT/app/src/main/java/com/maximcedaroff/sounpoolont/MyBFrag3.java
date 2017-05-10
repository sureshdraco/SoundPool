package com.maximcedaroff.sounpoolont;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Develop on 02.08.2016.
 */
public class MyBFrag3 extends Fragment {

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

}
