package com.maximcedaroff.sounpoolont;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.RotateAnimation;

/**
 * Created by Develop on 12.05.2017.
 */

public class SettingsActivity extends AppCompatActivity {

	private double mCurrAngle;
	private double mPrevAngle;
	private final double MIN_ANGLE = 0;
	private final double MAX_ANGLE = -70;
	private ArcProgress arcProgress;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_settings);
		arcProgress = (ArcProgress) findViewById(R.id.arcProgress);
		arcProgress.setProgress(40);
		AudioManager audioManager = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
		final int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
		int max = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
		arcProgress.setMax(210);
		arcProgress.setProgress(0);
		findViewById(R.id.knob).setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				final float xc = v.getWidth() / 2;
				final float yc = v.getHeight() / 2;

				final float x = event.getX();
				final float y = event.getY();

				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN: {
					v.clearAnimation();
					mCurrAngle = Math.toDegrees(Math.atan2(x - xc, yc - y));
					break;
				}
				case MotionEvent.ACTION_MOVE: {
					Log.d("angle", "angle:" + mCurrAngle);
					mPrevAngle = mCurrAngle;
					mCurrAngle = Math.toDegrees(Math.atan2(x - xc, yc - y));
					animate(mPrevAngle, mCurrAngle, 0);
					break;
				}
				case MotionEvent.ACTION_UP: {
					break;
				}
				}
				return true;
			}
		});
	}

	private void animate(double fromDegrees, double toDegrees, long durationMillis) {
		if (toDegrees < MIN_ANGLE && toDegrees > -69) {
			mCurrAngle = mPrevAngle = -70;
			return;
		}
		mCurrAngle = mPrevAngle = toDegrees;
		arcProgress.setProgress(degreeToProgress(toDegrees));
		final RotateAnimation rotate = new RotateAnimation((float) fromDegrees, (float) toDegrees,
				RotateAnimation.RELATIVE_TO_SELF, 0.5f,
				RotateAnimation.RELATIVE_TO_SELF, 0.5f);
		rotate.setDuration(durationMillis);
		rotate.setFillEnabled(true);
		rotate.setFillAfter(true);
		findViewById(R.id.knob).startAnimation(rotate);
	}

	private int degreeToProgress(double toDegree) {
		if (toDegree >= 0) {
			return Double.valueOf(toDegree).intValue();
		} else {
			return Double.valueOf(Math.abs(toDegree)).intValue() + 180;
		}
	}

	public void back(View view) {
		onBackPressed();
	}
}
