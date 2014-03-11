package com.gqj.GameDemo.JNI;

import android.util.Log;

public class CMemManage {
	private static final String TAG = "CMemManage";
	byte[] pMem; 
	int iLength;
	int pAddree;
	public native int memInit(byte[] mem, int len);
	public native void destory(int pAddree);
	public native void show(int pAddree);
	
	public void initEngine() {
		this.iLength = 1024*1024;
		this.pMem = new byte[iLength];
		this.pAddree = memInit(pMem, iLength);
		Log.i(TAG, "memInit ok!" + this.iLength + " =" + this.pMem);
		show(this.pAddree);
		destory(pAddree);
	}
	static {
		System.loadLibrary("DEBUG_Linux_Dll");
        System.loadLibrary("CMM_Linux_Dll");
        System.loadLibrary("JNI_MMG_Dll");
	}
	public CMemManage() {
		super();
		this.pMem = null;
		this.iLength = 0;
		this.pAddree = 0;
	}
	
}
