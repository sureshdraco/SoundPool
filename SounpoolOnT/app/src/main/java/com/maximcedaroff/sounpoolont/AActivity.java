package com.maximcedaroff.sounpoolont;

import android.content.Intent;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;
import java.util.List;

import static com.maximcedaroff.sounpoolont.R.id.container;

public class AActivity extends AppCompatActivity {

	private InterstitialAd interstitial;
	private List<StateChangeListener> stateChangeListenerList;
	private OnSectionsPagerAdapter onSectionsPagerAdapter;
	OffSectionsPagerAdapter offSectionsPagerAdapter;

	public ViewPager onViewPager, offViewPager;
	private TabLayout tabLayout, tabLayout2;
	private SoundPool mySounds;
	private int currentBeat;
	private LoopMediaPlayer mp;
	int scrollCounter = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		stateChangeListenerList = new ArrayList<>();
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_a);
		onSectionsPagerAdapter = new OnSectionsPagerAdapter(getSupportFragmentManager());
		interstitial = new InterstitialAd(getApplicationContext());
		interstitial.setAdUnitId(getString(R.string.admob_interstitial_id));
		onViewPager = (ViewPager) findViewById(container);
		onViewPager.setAdapter(onSectionsPagerAdapter);
		offSectionsPagerAdapter = new OffSectionsPagerAdapter(getSupportFragmentManager());
		tabLayout = (TabLayout) findViewById(R.id.tab_layout);
		tabLayout.setupWithViewPager(onViewPager, true);

		offViewPager = (ViewPager) findViewById(R.id.container2);
		offViewPager.setAdapter(offSectionsPagerAdapter);
		tabLayout2 = (TabLayout) findViewById(R.id.tab_layout2);
		tabLayout2.setupWithViewPager(offViewPager, true);
		onViewPager.setOffscreenPageLimit(3);
		offViewPager.setOffscreenPageLimit(3);
		offViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
			}

			@Override
			public void onPageSelected(int position) {
				handleScrollCounter();
			}

			@Override
			public void onPageScrollStateChanged(int state) {
			}
		});
		onViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
			}

			@Override
			public void onPageSelected(int position) {
				handleScrollCounter();
			}

			@Override
			public void onPageScrollStateChanged(int state) {
			}
		});
		AdView adView = (AdView) findViewById(R.id.adView);
		AdRequest adRequest = new AdRequest.Builder()
				.setRequestAgent("android_studio:ad_template").build();
		adView.loadAd(adRequest);

		Button menu = (Button) findViewById(R.id.menu);
		menu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(AActivity.this, SettingsActivity.class));
			}
		});

		final Button b2 = (Button) findViewById(R.id.a2);
		final Button b1 = (Button) findViewById(R.id.a1);
		b2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				handleScrollCounter();
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
				handleScrollCounter();
				findViewById(R.id.onLayout).setVisibility(View.VISIBLE);
				findViewById(R.id.offLayout).setVisibility(View.GONE);
				tabLayout2.setVisibility(View.GONE);
				tabLayout.setVisibility(View.VISIBLE);
				b2.setBackgroundResource(R.drawable.b_unpress);
				b1.setBackgroundResource(R.drawable.a_press);
			}
		});

	}

	private void handleScrollCounter() {
		scrollCounter++;
		if (scrollCounter % 3 == 0) {
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
		}
	}

	public void addStateChangedListener(StateChangeListener stateChangeListener) {
		stateChangeListenerList.add(stateChangeListener);
	}

	public void initStateChange(Fragment fragment, boolean state) {
		for (StateChangeListener stateChangeListener : stateChangeListenerList) {
			stateChangeListener.onStateChangedListener(fragment, state);
		}
	}

	private void startemp(int beat2) {
		currentBeat = beat2;
		mp = LoopMediaPlayer.create(getApplicationContext(), beat2);
	}

	private void releasEmp() {
		currentBeat = -1;
		if (mp != null) {
			mp.release();
			mp = null;
		}
	}

	public void handleBeat(boolean b, int beatInUse) {
		if (b) {
			releasEmp();
			startemp(beatInUse);
		} else {
			if (currentBeat == beatInUse) {
				releasEmp();
			}
		}
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
					return MyBFrag3.newInstance();

			}

			return null;

		}

		public int getCount() {
			return 3;
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		releasEmp();
	}
}
