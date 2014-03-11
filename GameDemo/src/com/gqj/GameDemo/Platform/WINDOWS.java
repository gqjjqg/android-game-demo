package com.gqj.GameDemo.Platform;

public class WINDOWS {
	int[] pData;
	private static int iWidth = 0;
	private static int iHeight = 0;
	private static WINDOWS instance = null;
	
	public WINDOWS() {
		
	}

	public void setWindows(int iWidth, int iHeight) {
		if (iWidth < 0 || iHeight < 0) {
			return;
		}
		WINDOWS.iWidth = iWidth;
		WINDOWS.iHeight = iHeight;
		pData = new int[WINDOWS.iWidth*WINDOWS.iHeight];
	}
	
	public static WINDOWS getInstance() {
		if (WINDOWS.instance == null) {
			WINDOWS.instance = new WINDOWS();
		}
		return instance;
	}
	
	public boolean display() {
		
		return true;
	}
}
