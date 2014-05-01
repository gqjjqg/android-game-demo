package com.gqj.GameDemo;

import com.gqj.GameDemo.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class MainActivity extends Activity {

	CSurfaceView mainObj;
	
	static {
		System.loadLibrary("DEBUG_LIB");
        System.loadLibrary("CCU_LIB");
        System.loadLibrary("CMM_LIB");
        System.loadLibrary("GEngine2D");
        System.loadLibrary("GameDemo");
        System.loadLibrary("native_adapter");
	}
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        setContentView(R.layout.demo);
        
        //mainObj = new Game2D(this);
        mainObj = (CSurfaceView) this.findViewById(R.id.gameD1);
        View v = this.findViewById(R.id.button1);
        mainObj.registeClickListener(v);
        v = this.findViewById(R.id.button2);
        mainObj.registeClickListener(v);
        v = this.findViewById(R.id.button3);
        mainObj.registeClickListener(v);
        v = this.findViewById(R.id.button4);
        mainObj.registeClickListener(v);
        v = this.findViewById(R.id.button5);
        mainObj.registeClickListener(v);
        v = this.findViewById(R.id.button6);
        mainObj.registeClickListener(v);
        v = this.findViewById(R.id.button7);
        mainObj.registeClickListener(v);
        v = this.findViewById(R.id.button8);
        mainObj.registeClickListener(v);
        v = this.findViewById(R.id.button9);
        mainObj.registeClickListener(v);
        
    }
    
    @Override
	protected void onStart() {
    	super.onStart();
    }
    
    @Override
	protected void onStop() {
    	mainObj.stop();
    	super.onStop();
    }
    
	/* (non-Javadoc)
	 * @see android.app.Activity#onDestroy()
	 */
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	
}