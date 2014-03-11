package com.gqj.GameDemo.UI;

import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.Animation;
import android.widget.Button;

public class GButtons extends Button{
	
	private static final String TAG = "GButton";
	AnimationDrawable mBgAnimationDrawable = null;
	List<Animation> mListAnimation = null;
	int iRunningCount = 0;

	public GButtons(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public GButtons(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	public GButtons(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	
	public void animateStart() {
		Log.i(TAG, "Start");
		if (mBgAnimationDrawable == null) {
			mBgAnimationDrawable = (AnimationDrawable) this.getBackground();
		} else if (!mBgAnimationDrawable.isRunning()) {
			mBgAnimationDrawable.start();
		} else {
			Log.i(TAG, "animate isRunning");
		}
	}
	
	public void animateStop() {
		Log.i(TAG, "Stop");
		if (mBgAnimationDrawable != null) {
			if (mBgAnimationDrawable.isRunning()) {
				mBgAnimationDrawable.stop();
				mBgAnimationDrawable.selectDrawable(0);
			} else {
				Log.i(TAG, "animate is NOT Running");
			}
		} else {
			Log.i(TAG, "animate is NULL");
		}
		
	}
	
	@Override
	protected void onAnimationEnd() {
		// TODO Auto-generated method stub
		super.onAnimationEnd();
		Log.i(TAG, "onAnimationEnd");
		if (this.mListAnimation == null) {
			Log.i(TAG, "mListAnimation null");
		} else if (iRunningCount < mListAnimation.size()){
			Animation animateDo = mListAnimation.get(iRunningCount);
			if ( animateDo != null ) {
				this.startAnimation(animateDo);
				iRunningCount++;
			} else {
				Log.i(TAG, "mListAnimation get null");
			}
		} else {
			iRunningCount = 0;
			Log.i(TAG, "mListAnimation get null");
		}
	}

	@Override
	protected void onAnimationStart() {
		// TODO Auto-generated method stub
		super.onAnimationStart();
		Log.i(TAG, "onAnimationStart" + iRunningCount);
	}
	public List<Animation> getmListAnimation() {
		return mListAnimation;
	}

	public void setmListAnimation(List<Animation> mListAnimation) {
		this.mListAnimation = mListAnimation;
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
	}
	
}
