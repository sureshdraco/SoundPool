package com.maximcedaroff.sounpoolont;

import static com.maximcedaroff.sounpoolont.R.id.container;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class BActivity extends AppCompatActivity {

	private InterstitialAd interstitial;

	SoundPool mySounds;

	int s1Id, s2Id, s3Id, s4Id, s5Id, s6Id, s7Id, s8Id, s9Id, s10Id, s11Id, s12Id;
	int s13Id, s14Id, s15Id, s16Id, s17Id, s18Id, s19Id, s20Id, s21Id, s22Id, s23Id, s24Id;

	private SectionsPagerAdapter mSectionsPagerAdapter;

	private ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_b);

		mySounds = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
		s1Id = mySounds.load(this, R.raw.s13, 1);
		s2Id = mySounds.load(this, R.raw.s14, 1);
		s3Id = mySounds.load(this, R.raw.s15, 1);
		s4Id = mySounds.load(this, R.raw.s16, 1);
		s5Id = mySounds.load(this, R.raw.s17, 1);
		s6Id = mySounds.load(this, R.raw.s18, 1);
		s7Id = mySounds.load(this, R.raw.s19, 1);
		s8Id = mySounds.load(this, R.raw.s20, 1);
		s9Id = mySounds.load(this, R.raw.s21, 1);
		s10Id = mySounds.load(this, R.raw.s22, 1);
		s11Id = mySounds.load(this, R.raw.s23, 1);
		s12Id = mySounds.load(this, R.raw.s24, 1);
		s13Id = mySounds.load(this, R.raw.s13, 1);
		s14Id = mySounds.load(this, R.raw.s14, 1);
		s15Id = mySounds.load(this, R.raw.s15, 1);
		s16Id = mySounds.load(this, R.raw.s16, 1);
		s17Id = mySounds.load(this, R.raw.s17, 1);
		s18Id = mySounds.load(this, R.raw.s18, 1);
		s19Id = mySounds.load(this, R.raw.s19, 1);
		s20Id = mySounds.load(this, R.raw.s20, 1);
		s21Id = mySounds.load(this, R.raw.s21, 1);
		s22Id = mySounds.load(this, R.raw.s22, 1);
		s23Id = mySounds.load(this, R.raw.s23, 1);
		s24Id = mySounds.load(this, R.raw.s24, 1);

		mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(container);
		mViewPager.setAdapter(mSectionsPagerAdapter);

		TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout2);
		tabLayout.setupWithViewPager(mViewPager, true);

		AdView adView = (AdView) findViewById(R.id.adView);
		AdRequest adRequest = new AdRequest.Builder()
				.setRequestAgent("android_studio:ad_template").build();
		adView.loadAd(adRequest);

		Button a2 = (Button) findViewById(R.id.a2);
		a2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(BActivity.this, AActivity.class));
				finish();
			}
		});

	}

	public void b1(View view) {
		mySounds.play(s13Id, 1, 1, 1, 0, 1);
	}

	public void b2(View view) {
		mySounds.play(s14Id, 1, 1, 1, 0, 1);
	}

	public void b3(View view) {
		mySounds.play(s15Id, 1, 1, 1, 0, 1);
	}

	public void b4(View view) {
		mySounds.play(s16Id, 1, 1, 1, 0, 1);
	}

	public void b5(View view) {
		mySounds.play(s17Id, 1, 1, 1, 0, 1);
	}

	public void b6(View view) {
		mySounds.play(s18Id, 1, 1, 1, 0, 1);
	}

	public void b7(View view) {
		mySounds.play(s19Id, 1, 1, 1, 0, 1);
	}

	public void b8(View view) {
		mySounds.play(s20Id, 1, 1, 1, 0, 1);
	}

	public void b9(View view) {
		mySounds.play(s21Id, 1, 1, 1, 0, 1);
	}

	public void b10(View view) {
		mySounds.play(s22Id, 1, 1, 1, 0, 1);
	}

	public void b11(View view) {
		mySounds.play(s23Id, 1, 1, 1, 0, 1);
	}

	public void b12(View view) {
		mySounds.play(s24Id, 1, 1, 1, 0, 1);
	}

	public void b13(View view) {
		mySounds.play(s13Id, 1, 1, 1, 0, 1);
	}

	public void b14(View view) {
		mySounds.play(s14Id, 1, 1, 1, 0, 1);
	}

	public void b15(View view) {
		mySounds.play(s15Id, 1, 1, 1, 0, 1);
	}

	public void b16(View view) {
		mySounds.play(s16Id, 1, 1, 1, 0, 1);
	}

	public void b17(View view) {
		mySounds.play(s17Id, 1, 1, 1, 0, 1);
	}

	public void b18(View view) {
		mySounds.play(s18Id, 1, 1, 1, 0, 1);
	}

	public void b19(View view) {
		mySounds.play(s19Id, 1, 1, 1, 0, 1);
	}

	public void b20(View view) {
		mySounds.play(s20Id, 1, 1, 1, 0, 1);
	}

	public void b21(View view) {
		mySounds.play(s21Id, 1, 1, 1, 0, 1);
	}

	public void b22(View view) {
		mySounds.play(s22Id, 1, 1, 1, 0, 1);
	}

	public void b23(View view) {
		mySounds.play(s23Id, 1, 1, 1, 0, 1);
	}

	public void b24(View view) {
		mySounds.play(s24Id, 1, 1, 1, 0, 1);
	}

	public static class PlaceholderFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this fragment.
		 */
		private static final String ARG_SECTION_NUMBER = "section_number";

		public PlaceholderFragment() {
		}

		/**
		 * Returns a new instance of this fragment for the given section number.
		 */
		public static PlaceholderFragment newInstance(int sectionNumber) {
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_b, container, false);
			return rootView;
		}
	}

	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			switch (position) {
			case 0:
				return PlaceholderFragment.newInstance(position + 1);
			case 1:
				return MyBFrag1.newInstance();
			case 2:

				interstitial = new InterstitialAd(getApplicationContext());
				interstitial.setAdUnitId(getString(R.string.admob_interstitial_id));
				AdRequest adRequest = new AdRequest.Builder().build();
				interstitial.loadAd(adRequest);
				interstitial.setAdListener(new AdListener() {
					@Override
					public void onAdLoaded() {
						if (interstitial.isLoaded()) {
							interstitial.show();

						}

					}
				});

				return MyBFrag2.newInstance();

			}

			return null;

		}

		public int getCount() {
			return 3;
		}

	}

}
