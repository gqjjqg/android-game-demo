package com.guo.gamedemo.data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

public class ResManger {
	private final String TAG = this.getClass().toString();
	
	private String SD_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/";
	private String ROOT_PATH = SD_PATH + "GameDemo/";
	private String RES_PATH = ROOT_PATH + "ResourceFile/";
	
	private String[] mAssetsFileNames = {
			"Actor_Stand.BMP",
			"Actor_Walk.BMP",
			"ASC16",
			"Hzk16",
			"AscSDF32",
			"HzkSDF32",
			"Map_grass.BMP",
			"Map_ground.BMP" };
	
	private Context mContext;
	
	public ResManger(Context context) {
		// TODO Auto-generated constructor stub
		Log.i(TAG, "Create");
		mContext = context;
	}

	public boolean install() {
		InputStream input;
		OutputStream output;
		byte[] buffer = new byte[1024];
		try {
			//Create root path
			File dir = new File(ROOT_PATH);
	        if (!dir.exists()) {
	             dir.mkdirs();
	        }
	        //Create resource path
	        dir = new File(RES_PATH);
	        if (!dir.exists()) {
	             dir.mkdirs();
	        }
	        //copy resource
			for (int i = 0; i < mAssetsFileNames.length; i++) {
				output = new FileOutputStream(RES_PATH + mAssetsFileNames[i]);
				input = mContext.getAssets().open(mAssetsFileNames[i]);
				int length;
				while ((length = input.read(buffer)) > 0) {
					output.write(buffer, 0, length);
				}
				output.flush();
				input.close();
				output.close();
			}
			buffer = null;
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
