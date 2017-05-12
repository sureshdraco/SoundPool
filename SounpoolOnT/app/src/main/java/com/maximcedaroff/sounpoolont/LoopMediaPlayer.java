package com.maximcedaroff.sounpoolont;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Build;
import android.util.Log;

import java.io.IOException;

public class LoopMediaPlayer {

	public static final String TAG = LoopMediaPlayer.class.getSimpleName();
	private final boolean mCompatMode;

	private Context mContext = null;
	private int mResId = 0;
	private int mCounter = 1;

	private MediaPlayer mCurrentPlayer = null;
	private MediaPlayer mNextPlayer = null;

	public static LoopMediaPlayer create(Context context, int resId) {
		return new LoopMediaPlayer(context, resId);
	}

	public void onCompletion(MediaPlayer mp) {
		if (mCompatMode && mNextPlayer != null) {
			try {
				mNextPlayer.prepare();
			} catch (IOException e) {
				e.printStackTrace();
			}
			mNextPlayer.start();
		}
	}

	private LoopMediaPlayer(Context context, int resId) {
		mContext = context;
		mResId = resId;
		mCompatMode = Build.VERSION.SDK_INT < 16;
		mCurrentPlayer = MediaPlayer.create(mContext, mResId);
		mCurrentPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
			@Override
			public void onPrepared(MediaPlayer mediaPlayer) {
				mCurrentPlayer.start();
			}
		});

		createNextMediaPlayer();
	}

	public MediaPlayer getCurrentPlayer() {
		return mCurrentPlayer;
	}

	@SuppressLint("NewApi")
	public void setNextMediaPlayer(MediaPlayer next) {
		if (mCompatMode) {
			mNextPlayer = next;
		} else {
			mCurrentPlayer.setNextMediaPlayer(next);
		}
	}

	@SuppressLint("NewApi")
	private void createNextMediaPlayer() {
		mNextPlayer = MediaPlayer.create(mContext, mResId);
		setNextMediaPlayer(mNextPlayer);
		mCurrentPlayer.setOnCompletionListener(onCompletionListener);
	}

	private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mediaPlayer) {
			LoopMediaPlayer.this.onCompletion(mediaPlayer);
			mediaPlayer.release();
			mCurrentPlayer = mNextPlayer;

			createNextMediaPlayer();

			Log.d(TAG, String.format("Loop #%d", ++mCounter));
		}
	};

	public void release() {
		if (mCurrentPlayer != null) {
			mCurrentPlayer.reset();
			mCurrentPlayer.release();
		}
		if (mNextPlayer != null) {
			mNextPlayer.reset();
			mNextPlayer.release();
		}
	}
}
