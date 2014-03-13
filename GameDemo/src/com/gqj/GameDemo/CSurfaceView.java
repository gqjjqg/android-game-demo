package com.gqj.GameDemo;

import com.gqj.GameDemo.data.ResManger;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class CSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
	private final String TAG = this.getClass().toString();
	
	private CMainEntry threadHandle;
	private ResManger mResManger;
	
	public CSurfaceView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		onCreate(context);
	}

	public CSurfaceView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		onCreate(context);
	}

	public CSurfaceView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		onCreate(context);
	}

	private void onCreate(Context context) {
		mResManger = new ResManger(context);
		threadHandle = new CMainEntry();
		threadHandle.setHolder(this.getHolder());
		this.setOnTouchListener(threadHandle);
		mResManger.install();
	}
	
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		holder.addCallback(this);
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		threadHandle.shutDown();
	}

	/**
	 * @param v
	 */
	public void registeClickListener(View v) {
		v.setOnClickListener(threadHandle);
	}
	
	public void stop() {
		threadHandle.shutDown();
	}
	
}
