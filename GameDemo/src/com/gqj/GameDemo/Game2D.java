package com.gqj.GameDemo;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


public class Game2D extends SurfaceView implements SurfaceHolder.Callback {
	SurfaceHolder holder;
	CMainEntry threadHandle;
	public Game2D(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		holder = this.getHolder();
		holder.addCallback(this);
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		threadHandle = new CMainEntry();
		threadHandle.setHolder(holder);
		threadHandle.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		 threadHandle.shutDown();
	}

}
