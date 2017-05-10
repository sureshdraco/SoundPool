package com.maximcedaroff.sounpoolont;

import static com.maximcedaroff.sounpoolont.R.id.container;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

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

public class AActivity extends AppCompatActivity {

	private InterstitialAd interstitial;

	private OnSectionsPagerAdapter onSectionsPagerAdapter;
	OffSectionsPagerAdapter offSectionsPagerAdapter;

	private ViewPager onViewPager, offViewPager;
	private TabLayout tabLayout, tabLayout2;
	private SoundPool mySounds;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_a);

		onSectionsPagerAdapter = new OnSectionsPagerAdapter(getSupportFragmentManager());

		onViewPager = (ViewPager) findViewById(container);
		onViewPager.setAdapter(onSectionsPagerAdapter);
		offSectionsPagerAdapter = new OffSectionsPagerAdapter(getSupportFragmentManager());
		tabLayout = (TabLayout) findViewById(R.id.tab_layout);
		tabLayout.setupWithViewPager(onViewPager, true);

		offViewPager = (ViewPager) findViewById(R.id.container2);
		offViewPager.setAdapter(offSectionsPagerAdapter);
		tabLayout2 = (TabLayout) findViewById(R.id.tab_layout2);
		tabLayout2.setupWithViewPager(offViewPager, true);

		AdView adView = (AdView) findViewById(R.id.adView);
		AdRequest adRequest = new AdRequest.Builder()
				.setRequestAgent("android_studio:ad_template").build();
		// adView.loadAd(adRequest);

		final Button b2 = (Button) findViewById(R.id.a2);
		final Button b1 = (Button) findViewById(R.id.a1);
		b2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				findViewById(R.id.offLayout).setVisibility(View.VISIBLE);
				findViewById(R.id.onLayout).setVisibility(View.GONE);
				tabLayout.setVisibility(View.GONE);
				tabLayout2.setVisibility(View.VISIBLE);
				b2.setBackgroundResource(R.drawable.b_press);
				b1.setBackgroundResource(R.drawable.a_unpress);
			}
		});

		b1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				findViewById(R.id.onLayout).setVisibility(View.VISIBLE);
				findViewById(R.id.offLayout).setVisibility(View.GONE);
				tabLayout2.setVisibility(View.GONE);
				tabLayout.setVisibility(View.VISIBLE);
				b2.setBackgroundResource(R.drawable.b_unpress);
				b1.setBackgroundResource(R.drawable.a_press);
			}
		});

	}

	public class OnSectionsPagerAdapter extends FragmentPagerAdapter {

		public OnSectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			switch (position) {
			case 0:
				return MyAFrag1.newInstance();
			case 1:
				return MyAFrag2.newInstance();
			case 2:

				interstitial = new InterstitialAd(getApplicationContext());
				interstitial.setAdUnitId(getString(R.string.admob_interstitial_id));
				AdRequest adRequest = new AdRequest.Builder().build();
				// interstitial.loadAd(adRequest);
				interstitial.setAdListener(new AdListener() {
					@Override
					public void onAdLoaded() {
						if (interstitial.isLoaded()) {
							interstitial.show();
						}
					}
				});
				return MyAFrag3.newInstance();
			}

			return null;

		}

		public int getCount() {
			return 3;
		}

	}

	public class OffSectionsPagerAdapter extends FragmentPagerAdapter {

		public OffSectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			switch (position) {
			case 0:
				return MyBFrag1.newInstance();
			case 1:
				return MyBFrag2.newInstance();
			case 2:

				interstitial = new InterstitialAd(getApplicationContext());
				interstitial.setAdUnitId(getString(R.string.admob_interstitial_id));
				AdRequest adRequest = new AdRequest.Builder().build();
				// interstitial.loadAd(adRequest);
				interstitial.setAdListener(new AdListener() {
					@Override
					public void onAdLoaded() {
						if (interstitial.isLoaded()) {
							interstitial.show();

						}

					}
				});

				return MyBFrag3.newInstance();

			}

			return null;

		}

		public int getCount() {
			return 3;
		}

	}
}
