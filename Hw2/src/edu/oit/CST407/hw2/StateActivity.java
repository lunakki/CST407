package edu.oit.CST407.hw2;

import java.math.BigInteger;
import java.security.SecureRandom;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class StateActivity extends Activity {
	private TextView tv1 = null;
	@SuppressLint("TrulyRandom")
	private SecureRandom random = new SecureRandom();
	private static final String TEXT_KEY = "TEXT_KEY";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_state);
		String text;
		
		if(savedInstanceState == null) {
			text = new BigInteger(130, random).toString(32);
		} else
		{
			text = savedInstanceState.getString(TEXT_KEY);
		}
		tv1 = (TextView)findViewById(R.id.textView1);
		tv1.setText(text);
	}
	
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		
		String changeText = tv1.getText().toString();
		outState.putString(TEXT_KEY, changeText);
	}
}
