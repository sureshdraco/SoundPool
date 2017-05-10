package com.maximcedaroff.sounpoolont;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Develop on 02.08.2016.
 */
public class MyAFrag1 extends Fragment {

	public static MyAFrag1 newInstance() {

		MyAFrag1 fragment = new MyAFrag1();
		return fragment;
	}

	public MyAFrag1() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_a2, container, false);
		return rootView;
	}

}
