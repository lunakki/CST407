package edu.oit.CST407.hw1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
//import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class CameraActivity extends Activity {
	private Button b1 = null;
	private ImageView iv1 = null;
	private static int CAMERA_REQUEST = 1234;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_camera);
		
		b1 = (Button)findViewById(R.id.button1);
		iv1 = (ImageView)findViewById(R.id.imageView1);
		
		b1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE); 
                startActivityForResult(cameraIntent, CAMERA_REQUEST); 	
			}
			
		});
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {  
            Bitmap photo = (Bitmap) data.getExtras().get("data"); 
            iv1.setImageBitmap(photo);
        }  
	}
}
