package edu.oit.cst407.hw3;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ToggleButton;

public class GenieActivity extends Activity {
	private ToggleButton tb1 = null;
	private ToggleButton tb2 = null;
	private ToggleButton tb3 = null;
	
	private static final String TB1_KEY = "TB1_ENABLED_KEY";
	private static final String TB2_KEY = "TB2_ENABLED_KEY";
	private static final String TB3_KEY = "TB3_ENABLED_KEY";
	
	private static SharedPreferences prefs;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_genie);
		
		prefs = this.getSharedPreferences(
			      "edu.oit.cst407.hw3", Context.MODE_PRIVATE);
		
		//Wish buttons
		tb1 = setUpButton(R.id.toggleButton01, TB1_KEY);
		tb2 = setUpButton(R.id.toggleButton02, TB2_KEY);
		tb3 = setUpButton(R.id.toggleButton03, TB3_KEY);
		
		//Reset button
		findViewById(R.id.button1).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				resetButton(tb1, TB1_KEY);
				resetButton(tb2, TB2_KEY);
				resetButton(tb3, TB3_KEY);	
			}
			
		});
	}

	//Sets up state of button and creates click listener for each
	private ToggleButton setUpButton(int ID, final String key) {
		ToggleButton tb = (ToggleButton)findViewById(ID);
		if (!prefs.getBoolean(key, true)) {
			tb.setEnabled(false);
			tb.setChecked(true);
		}
		
		//This is done as an anonymous inner class so the key can be passed in
		//through the set up function
		tb.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (arg0.isEnabled()) {	
					arg0.setEnabled(false);
					prefs.edit().putBoolean(key, false).commit();
				}
			}
		});
		
		return tb;
	}
	
	//Sets all wishes back to unused (for testing/demonstration purposes)
	private void resetButton(ToggleButton tb, String key) {
		tb.setEnabled(true);
		tb.setChecked(false);
		prefs.edit().putBoolean(key, true).commit();
	}
}
