package com.gqj.GameDemo;

import com.gqj.GameDemo.JNI.CMemManage;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;

public class CMainEntry extends Thread {
	private static final String TAG = "CMainEntry";
	SurfaceHolder holder = null;
	Canvas canvas = null;
	boolean isRun = true;
	Paint p = null;
	@Override
	public void run() {
		Log.i(TAG, "run start!");
		CMemManage pManage = new CMemManage();
		pManage.initEngine();
		p = new Paint();
		while (isRun) {
			try {
				if (holder != null) {
					synchronized (holder) {
						canvas = holder.lockCanvas();
						//Bitmap tp = null;
						//BitmapFactory.Options tp1 = new BitmapFactory.Options();

						// canvas draw;
						//canvas.drawBitmap(colors, offset, stride, x, y, width, height, false, null);
						canvas.drawColor(Color.WHITE);
						p.setColor(Color.BLACK);
						canvas.drawText("Test", 10, 10, p);
						Log.i(TAG, "run Test!");
						
						Thread.sleep(1000);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if (canvas != null) {
					holder.unlockCanvasAndPost(canvas);
				}
			}
		}
	}
	public void setHolder(SurfaceHolder iholder) {
		holder = iholder;
	}
	public void shutDown() {
		isRun = false;
	}
}
