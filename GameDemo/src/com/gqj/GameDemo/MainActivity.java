package com.gqj.GameDemo;


import java.util.ArrayList;
import java.util.List;

import com.gqj.GameDemo.JNI.CMemManage;
import com.gqj.GameDemo.Platform.WINDOWS;
import com.gqj.GameDemo.UI.GButtons;

import Arcsoft.gqj.GameDemo.R;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	
	static String GButtonTag = "GButtons";
	
	GButtons GButtonStart;
	GButtons GButtonSet;
	GButtons GButtonExit;
	Game2D mainObj;
	//for test
	TextView textshow;
	WINDOWS pWINDOWS;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        mainObj = new Game2D(this);
        setContentView(mainObj);
        /**	initial the UI*/
		WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
		pWINDOWS = WINDOWS.getInstance();
		pWINDOWS.setWindows(wm.getDefaultDisplay().getWidth(), wm.getDefaultDisplay().getHeight());
		
        /*
        GButtonStart = (GButtons)findViewById(R.id.button1);
        GButtonStart.setOnClickListener(this);
         
        GButtonSet = (GButtons)findViewById(R.id.button2);
        GButtonSet.setOnClickListener(this);
        
        GButtonExit = (GButtons)findViewById(R.id.button3);
        GButtonExit.setOnClickListener(this);
        
        //test code
        //clear = (Button)findViewById(R.id.button3);
        //clear.setOnClickListener(this);
        textshow = (TextView)findViewById(R.id.Main_Text01);
        
        GButtonStart.animateStart();
		GButtonSet.animateStart();
		GButtonExit.animateStart();
		Log.i(GButtonTag, "focus in");*/
		
    }
    
	@Override
	public void onClick(View v) {

		Log.d(GButtonTag, "OnClick :" + v.getId());
		// TODO Auto-generated method stub
		switch (v.getId()) {
			case R.id.button1 : 
				textshow.setText("Start Game!"); 
				//GButtonStart.animateStop();
				//����Animation����
				Animation ani1 = AnimationUtils.loadAnimation(
						getApplicationContext(), R.anim.zoom_enter);
				//������Ŷ���
				GButtonStart.startAnimation(ani1);
				
				break;
			case R.id.button2 : 
				textshow.setText("Set Game!"); 
				//����Animation����
				Animation ani2 = AnimationUtils.loadAnimation(
						getApplicationContext(), R.anim.zoom_exit);
				//������Ŷ���
				GButtonSet.startAnimation(ani2);
				GButtonSet.animateStop();
				break;
			case R.id.button3 : 
				textshow.setText("Exit Game!"); 
				//����Animation����
				Animation ani3_1 = AnimationUtils.loadAnimation(
						getApplicationContext(), R.anim.stye2_1);
				Animation ani3_0 = AnimationUtils.loadAnimation(
						getApplicationContext(), R.anim.stye2_0);
				Animation ani3_2 = AnimationUtils.loadAnimation(
						getApplicationContext(), R.anim.stye2_2);
				List<Animation> tp = new ArrayList<Animation>();
				tp.add(ani3_0);
				tp.add(ani3_1);
				tp.add(ani3_2);
				GButtonExit.setmListAnimation(tp);
				//������Ŷ���
				GButtonExit.startAnimation(ani3_1);
				
				GButtonExit.animateStop();

				finish();
				break;
			default: ;
				
		}
	}
	
    @Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.i(GButtonTag, "OnResume");
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		// TODO Auto-generated method stub
		super.onWindowFocusChanged(hasFocus);
//		if (hasFocus) {
//			GButtonStart.animateStart();
//			GButtonSet.animateStart();
//			GButtonExit.animateStart();
//			Log.i(GButtonTag, "focus in");
//		}
	}
	
    
}