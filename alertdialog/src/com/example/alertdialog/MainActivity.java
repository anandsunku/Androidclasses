package com.example.alertdialog;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);
		
		builder.setMessage("Do you want to close this application ?")
		    //.setCancelable(false)
		    
		  
		    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int id) {
		    finish();
		    }
		    });
		    
		    
		
		  
		    
		AlertDialog alert = builder.create();
		 alert.setTitle("AlertDialogExample");
		 alert.show();
		setContentView(R.layout.activity_main);
		    }

	}
		    
	
	


