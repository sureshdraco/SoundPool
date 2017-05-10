package com.maximcedaroff.sounpoolont;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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
		View rootView = inflater.inflate(R.layout.fragment_b2, container, false);
		return rootView;
	}

}
