package edu.oit.CST407.hw2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class OpinionActivity extends Activity {
	Button b1 = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_opinion);
		
		b1 = (Button)findViewById(R.id.button1);
		
		b1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent launchPart2 = new Intent(OpinionActivity.this, StateActivity.class);
				OpinionActivity.this.startActivity(launchPart2);	
			}
			
		});
	}

}
