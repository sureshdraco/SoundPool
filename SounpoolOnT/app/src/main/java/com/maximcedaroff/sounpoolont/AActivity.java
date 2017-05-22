package com.maximcedaroff.sounpoolont;

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
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.maximcedaroff.sounpoolont.R.id.container;

public class AActivity extends AppCompatActivity {

	private Set<Integer> adShownA = new HashSet<>();
	private Set<Integer> adShownB = new HashSet<>();
	private InterstitialAd interstitial;
	private List<StateChangeListener> stateChangeListenerList;
	private OnSectionsPagerAdapter onSectionsPagerAdapter;
	OffSectionsPagerAdapter offSectionsPagerAdapter;

	public ViewPager onViewPager, offViewPager;
	private TabLayout tabLayout, tabLayout2;
	private int currentBeat;
	private LoopMediaPlayer mp;
	private ArrayList<Fragment> onFragments, offFragments;
	private SoundPool mySounds;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mySounds = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
		stateChangeListenerList = new ArrayList<>();
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_a);
		initFragments();
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
				handleAdA(position);
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
				handleAdB(position);
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

	private void handleAdA(int position) {
		if (position == 2 || position == 5 || position == 8) {
			if (adShownA.add(position)) {
				showAd();
			}
		}
	}

	public void playSound(final int sound) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				mySounds.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
					@Override
					public void onLoadComplete(SoundPool soundPool, int i, int i1) {
						soundPool.play(i, 1, 1, 1, 0, 1);
					}
				});
				mySounds.load(getApplicationContext(), sound, 1);
			}
		}).start();
	}

	private void handleAdB(int position) {
		if (position == 2 || position == 5 || position == 8) {
			if (adShownB.add(position)) {
				showAd();
			}
		}
	}

	private void showAd() {
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

	private void initFragments() {
		onFragments = new ArrayList<>();
		onFragments.add(MyAFrag1.newInstance());
		onFragments.add(MyAFrag2.newInstance());
		onFragments.add(MyAFrag3.newInstance());
		onFragments.add(MyAFrag1.newInstance());
		onFragments.add(MyAFrag1.newInstance());
		onFragments.add(MyAFrag1.newInstance());
		onFragments.add(MyAFrag1.newInstance());
		onFragments.add(MyAFrag1.newInstance());
		onFragments.add(MyAFrag1.newInstance());
		offFragments = new ArrayList<>();
		offFragments.add(MyBFrag1.newInstance());
		offFragments.add(MyBFrag3.newInstance());
		offFragments.add(MyBFrag3.newInstance());
		offFragments.add(MyBFrag1.newInstance());
		offFragments.add(MyBFrag3.newInstance());
		offFragments.add(MyBFrag3.newInstance());
		offFragments.add(MyBFrag1.newInstance());
		offFragments.add(MyBFrag3.newInstance());
		offFragments.add(MyBFrag3.newInstance());
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

	public int getCurrentBeat() {
		return currentBeat;
	}

	public class OnSectionsPagerAdapter extends FragmentPagerAdapter {

		public OnSectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			return onFragments.get(position);
		}

		public int getCount() {
			return onFragments.size();
		}

	}

	public class OffSectionsPagerAdapter extends FragmentPagerAdapter {

		public OffSectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			return offFragments.get(position);
		}

		public int getCount() {
			return offFragments.size();
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		releasEmp();
	}
}
