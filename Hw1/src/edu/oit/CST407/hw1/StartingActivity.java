package edu.oit.CST407.hw1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class StartingActivity extends Activity{
	private Button b1 = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_starting);
		
		b1 = (Button)findViewById(R.id.button1);
		
		b1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent launchBetter = new Intent(StartingActivity.this, CameraActivity.class);
				StartingActivity.this.startActivity(launchBetter);	
			}
			
		});
	}

}
