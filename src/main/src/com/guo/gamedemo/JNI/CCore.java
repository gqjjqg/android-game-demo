package com.guo.gamedemo.JNI;

import android.graphics.Bitmap;

public class CCore {
	
	public native int GEngine_Init(int width, int height);
	public native int GEngine_Destory();
	public native int GEngine_Render(Bitmap bitmap);
	public native int GEngine_KeyMsg(int key, int type);
	public native int GEngine_MotionMsg(int key, int type, int x, int y);
	
	public static int GKEY_UP = 			0;
	public static int GKEY_DOWN	= 			1;
	public static int GKEY_LEFT	= 			2;
	public static int GKEY_RIGHT = 			3;
	public static int GKEY_F1 = 			4;
	public static int GKEY_F2 = 			5;
	public static int GKEY_F3 = 			6;
	public static int GKEY_F4 = 			7;
	public static int GKEY_SPACE = 			8;
	public static int GKEY_NUM0	= 			9;
	public static int GKEY_NUM1	= 			10;
	public static int GKEY_NUM2	= 			11;
	public static int GKEY_NUM3	= 			12;
	public static int GKEY_NUM4	= 			13;
	public static int GKEY_NUM5	= 			14;
	public static int GKEY_NUM6	= 			15;
	public static int GKEY_NUM7	= 			16;
	public static int GKEY_NUM8	= 			17;
	public static int GKEY_NUM9	= 			18;

	public static int GKEY_ACTION_DOWN = 	0x1001;
	public static int GKEY_ACTION_MOVE = 	0x1002;
	public static int GKEY_ACTION_UP = 		0x1003;

	public static int GKEY_ACTION_CLICK	= 	0x2001;
	public static int GKEY_ACTION_LONGCLICK	=0x2002;
	
	public static int GKEY_INPUT_MOUSE_LEFT	=0x3001;
	public static int GKEY_INPUT_MOUSE_RIGHT=0x3002;
	public static int GKEY_INPUT_MOUSE_SCROLL=0x3003;
	public static int GKEY_INPUT_FINGER		=0x4001;
	
	public CCore() {
		super();
		// TODO Auto-generated constructor stub
	}

}
