package com.maximcedaroff.sounpoolont;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class All extends AppCompatActivity implements View.OnClickListener {

	SoundPool mySounds;
	SoundPool myBsounds;
	int s1Id, s2Id, s3Id, s4Id, s5Id, s6Id, s7Id, s8Id, s9Id;
	int b10I, b11I, b12I;
	private Button _firstButton;
	private Button _secondButton;
	private Button _thirdButton;
	private boolean ifFirstPlaying, ifSecondPlaying, ifThirdPlaying = false;
	private int _streamID1;
	private int _streamID2;
	private int _streamID3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_all);
		mySounds = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
		s1Id = mySounds.load(this, R.raw.s1, 1);
		s2Id = mySounds.load(this, R.raw.s2, 1);
		s3Id = mySounds.load(this, R.raw.s3, 1);
		s4Id = mySounds.load(this, R.raw.s4, 1);
		s5Id = mySounds.load(this, R.raw.s5, 1);
		s6Id = mySounds.load(this, R.raw.s6, 1);
		s7Id = mySounds.load(this, R.raw.s7, 1);
		s8Id = mySounds.load(this, R.raw.s8, 1);
		s9Id = mySounds.load(this, R.raw.s9, 1);
		TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
		AdView adView = (AdView) findViewById(R.id.adView);
		AdRequest adRequest = new AdRequest.Builder()
				.setRequestAgent("android_studio:ad_template").build();
		adView.loadAd(adRequest);
		final Button b1 = (Button) findViewById(R.id.button1);
		b1.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				switch (motionEvent.getAction()) {
				case MotionEvent.ACTION_DOWN:

					mySounds.play(s1Id, 1, 1, 1, 1, 1);
					b1.setBackgroundResource(R.drawable.button_press_w);

					break;

				case MotionEvent.ACTION_UP:

					b1.setBackgroundResource(R.drawable.button_unpress);

					break;
				}
				return true;
			}
		});

		final Button b2 = (Button) findViewById(R.id.button2);
		b2.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				switch (motionEvent.getAction()) {
				case MotionEvent.ACTION_DOWN:

					mySounds.play(s2Id, 1, 1, 1, 1, 1);
					b2.setBackgroundResource(R.drawable.button_press_w);

					break;

				case MotionEvent.ACTION_UP:

					b2.setBackgroundResource(R.drawable.button_unpress);

					break;
				}
				return true;
			}
		});

		final Button b3 = (Button) findViewById(R.id.button3);
		b3.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				switch (motionEvent.getAction()) {
				case MotionEvent.ACTION_DOWN:

					mySounds.play(s3Id, 1, 1, 1, 1, 1);
					b3.setBackgroundResource(R.drawable.button_press_w);

					break;

				case MotionEvent.ACTION_UP:

					b3.setBackgroundResource(R.drawable.button_unpress);

					break;
				}
				return true;
			}
		});

		final Button b4 = (Button) findViewById(R.id.button4);
		b4.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				switch (motionEvent.getAction()) {
				case MotionEvent.ACTION_DOWN:

					mySounds.play(s4Id, 1, 1, 1, 1, 1);
					b4.setBackgroundResource(R.drawable.button_press_w);

					break;

				case MotionEvent.ACTION_UP:

					b4.setBackgroundResource(R.drawable.button_unpress);

					break;
				}
				return true;
			}
		});

		final Button b5 = (Button) findViewById(R.id.button5);
		b5.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				switch (motionEvent.getAction()) {
				case MotionEvent.ACTION_DOWN:

					mySounds.play(s5Id, 1, 1, 1, 1, 1);
					b5.setBackgroundResource(R.drawable.button_press_w);

					break;

				case MotionEvent.ACTION_UP:

					b5.setBackgroundResource(R.drawable.button_unpress);

					break;
				}
				return true;
			}
		});

		final Button b6 = (Button) findViewById(R.id.button6);
		b6.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				switch (motionEvent.getAction()) {
				case MotionEvent.ACTION_DOWN:

					mySounds.play(s6Id, 1, 1, 1, 1, 1);
					b6.setBackgroundResource(R.drawable.button_press_w);

					break;

				case MotionEvent.ACTION_UP:

					b6.setBackgroundResource(R.drawable.button_unpress);

					break;
				}
				return true;
			}
		});

		final Button b7 = (Button) findViewById(R.id.button7);
		b7.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				switch (motionEvent.getAction()) {
				case MotionEvent.ACTION_DOWN:

					mySounds.play(s7Id, 1, 1, 1, 1, 1);
					b7.setBackgroundResource(R.drawable.button_press_w);

					break;

				case MotionEvent.ACTION_UP:

					b7.setBackgroundResource(R.drawable.button_unpress);

					break;
				}
				return true;
			}
		});

		final Button b8 = (Button) findViewById(R.id.button8);
		b8.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				switch (motionEvent.getAction()) {
				case MotionEvent.ACTION_DOWN:

					mySounds.play(s8Id, 1, 1, 1, 1, 1);
					b8.setBackgroundResource(R.drawable.button_press_w);

					break;

				case MotionEvent.ACTION_UP:

					b8.setBackgroundResource(R.drawable.button_unpress);

					break;
				}
				return true;
			}
		});

		final Button b9 = (Button) findViewById(R.id.button9);
		b9.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				switch (motionEvent.getAction()) {
				case MotionEvent.ACTION_DOWN:

					mySounds.play(s9Id, 1, 1, 1, 1, 1);
					b9.setBackgroundResource(R.drawable.button_press_w);

					break;

				case MotionEvent.ACTION_UP:

					b9.setBackgroundResource(R.drawable.button_unpress);

					break;
				}
				return true;
			}
		});

		myBsounds = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);

		b10I = myBsounds.load(this, R.raw.beat1, 1);
		b11I = myBsounds.load(this, R.raw.beat2, 1);
		b12I = myBsounds.load(this, R.raw.beat3, 1);

		_firstButton = (Button) findViewById(R.id.button10);
		_secondButton = (Button) findViewById(R.id.button11);
		_thirdButton = (Button) findViewById(R.id.button12);

		_firstButton.setOnClickListener(this);
		_secondButton.setOnClickListener(this);
		_thirdButton.setOnClickListener(this);

	}

	@Override
	public void onClick(View view) {
		if (view == _firstButton) {
			// first stop second and third
			ifSecondPlaying = false;
			myBsounds.stop(_streamID2);
			_secondButton.setBackgroundResource(R.drawable.stop);
			ifThirdPlaying = false;
			myBsounds.stop(_streamID3);
			_thirdButton.setBackgroundResource(R.drawable.stop);
			// check for if all button not pressed
			if (!ifFirstPlaying && !ifSecondPlaying && !ifThirdPlaying) {
				ifFirstPlaying = true;

				_streamID1 = myBsounds.play(b10I, 1, 1, 1, -1, 1);
				_firstButton.setBackgroundResource(R.drawable.play);
			} else {
				// check for if already pressed of not
				if (ifFirstPlaying) {
					// if pressed then stop
					ifFirstPlaying = false;
					myBsounds.stop(_streamID1);
					_firstButton.setBackgroundResource(R.drawable.stop);
				} else {
					// otherwise play button shown
					ifFirstPlaying = true;
					_firstButton.setBackgroundResource(R.drawable.play);
					_streamID1 = myBsounds.play(b10I, 1, 1, 1, -1, 1);

				}

			}

		} else if (view == _secondButton) {
			ifFirstPlaying = false;
			myBsounds.stop(_streamID1);
			_firstButton.setBackgroundResource(R.drawable.stop);

			ifThirdPlaying = false;
			myBsounds.stop(_streamID3);
			_thirdButton.setBackgroundResource(R.drawable.stop);

			if (ifFirstPlaying && ifSecondPlaying && ifThirdPlaying) {
				ifSecondPlaying = true;

				_streamID2 = myBsounds.play(b12I, 1, 1, 1, -1, 1);
				_secondButton.setBackgroundResource(R.drawable.play);

			} else {
				if (ifSecondPlaying) {
					// if pressed then stop
					ifSecondPlaying = false;
					myBsounds.stop(_streamID2);
					_secondButton.setBackgroundResource(R.drawable.stop);
				} else {
					ifSecondPlaying = true;
					_streamID2 = myBsounds.play(b12I, 1, 1, 1, -1, 1);
					_secondButton.setBackgroundResource(R.drawable.play);
				}

			}

		} else if (view == _thirdButton) {
			{
				ifFirstPlaying = false;
				mySounds.stop(_streamID1);
				_firstButton.setBackgroundResource(R.drawable.stop);

				ifSecondPlaying = false;
				myBsounds.stop(_streamID2);
				_secondButton.setBackgroundResource(R.drawable.stop);

				if (ifFirstPlaying && ifSecondPlaying && ifThirdPlaying) {

					ifThirdPlaying = true;
					_streamID3 = myBsounds.play(b12I, 1, 1, 1, -1, 1);
					_thirdButton.setBackgroundResource(R.drawable.play);

				} else {
					if (ifThirdPlaying) {
						// if pressed then stop
						ifThirdPlaying = false;
						myBsounds.stop(_streamID3);
						_thirdButton.setBackgroundResource(R.drawable.stop);
					} else {
						ifThirdPlaying = true;
						_streamID3 = myBsounds.play(b12I, 1, 1, 1, -1, 1);
						_thirdButton.setBackgroundResource(R.drawable.play);
					}

				}

			}
		}

	}

	@Override
	public void onBackPressed() {
		finish();
	}
}
