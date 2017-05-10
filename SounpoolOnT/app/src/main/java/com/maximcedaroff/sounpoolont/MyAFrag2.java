package com.maximcedaroff.sounpoolont;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Develop on 02.08.2016.
 */
public class MyAFrag2 extends Fragment {

	public static MyAFrag2 newInstance() {

		MyAFrag2 fragment = new MyAFrag2();
		return fragment;
	}

	public MyAFrag2() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_a3, container, false);
		return rootView;
	}

}
