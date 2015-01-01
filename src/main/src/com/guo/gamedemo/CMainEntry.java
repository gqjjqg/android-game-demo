package com.guo.gamedemo;

import com.guo.gamedemo.R;
import com.guo.gamedemo.JNI.CCore;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;

public class CMainEntry extends Thread implements OnClickListener, OnTouchListener {

	private CCore mCore;
	private Canvas mCanvas;
	private SurfaceHolder mHolder;
	private Bitmap mBitmap;
	private int mWidth, mHeight;
	
    private volatile Thread mBlinker;
    
	public CMainEntry() {
		super();
		// TODO Auto-generated constructor stub
		mHolder = null;
		mWidth = 640;
		mHeight = 480;
		mBlinker = this;
	}
	
	@Override
	public void run() {
		mCore = new CCore();
		mCore.GEngine_Init(mWidth, mHeight);
		mBitmap = Bitmap.createBitmap(mWidth, mHeight, Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(mBitmap);
		canvas.drawColor(Color.WHITE);
		
		Thread thisThread = Thread.currentThread();
		while (mBlinker == thisThread) {
			try {
				if (mHolder != null) {
					synchronized (mHolder) {
						mCanvas = mHolder.lockCanvas();
						if (mCanvas != null) {
							mCore.GEngine_Render(mBitmap);
							mCanvas.drawBitmap(mBitmap, 0, 0, null);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (mCanvas != null) {
					mHolder.unlockCanvasAndPost(mCanvas);
				}
			}
		}
		mCore.GEngine_Destory();
	}
	
	public void setHolder(SurfaceHolder iholder) {
		mHolder = iholder;
	}
	
	public void shutDown() {
		mBlinker = null;
		try {
			this.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()) {
		case R.id.button1 :
			this.start();
			break;
		case R.id.button2 :
			mCore.GEngine_KeyMsg(CCore.GKEY_F1, CCore.GKEY_ACTION_CLICK);
			break;
		case R.id.button3 :
			mCore.GEngine_KeyMsg(CCore.GKEY_F2, CCore.GKEY_ACTION_CLICK);
			break;
		case R.id.button4 :
			mCore.GEngine_KeyMsg(CCore.GKEY_F3, CCore.GKEY_ACTION_CLICK);
			break;
		case R.id.button5 :
			mCore.GEngine_KeyMsg(CCore.GKEY_UP, CCore.GKEY_ACTION_CLICK);
			break;
		case R.id.button6 :
			mCore.GEngine_KeyMsg(CCore.GKEY_LEFT, CCore.GKEY_ACTION_CLICK);
			break;
		case R.id.button7 :
			mCore.GEngine_KeyMsg(CCore.GKEY_DOWN, CCore.GKEY_ACTION_CLICK);
			break;
		case R.id.button8 :
			mCore.GEngine_KeyMsg(CCore.GKEY_RIGHT, CCore.GKEY_ACTION_CLICK);
			break;
		case R.id.button9 :
			mCore.GEngine_KeyMsg(CCore.GKEY_SPACE, CCore.GKEY_ACTION_CLICK);
			break;
		default:;
		}
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		if (v.getId() == R.id.gameD1) {
			switch (event.getAction() & MotionEvent.ACTION_MASK) {
			case MotionEvent.ACTION_DOWN:
				mCore.GEngine_MotionMsg(CCore.GKEY_INPUT_FINGER, CCore.GKEY_ACTION_DOWN, (int)event.getX(), (int)event.getY());
				break;
			case MotionEvent.ACTION_MOVE:
				mCore.GEngine_MotionMsg(CCore.GKEY_INPUT_FINGER, CCore.GKEY_ACTION_MOVE, (int)event.getX(), (int)event.getY());
				break;
			case MotionEvent.ACTION_CANCEL:
			case MotionEvent.ACTION_UP:
				mCore.GEngine_MotionMsg(CCore.GKEY_INPUT_FINGER, CCore.GKEY_ACTION_UP, (int)event.getX(), (int)event.getY());
				break;
			default:;
			}
		}
		return true;
	}
}
