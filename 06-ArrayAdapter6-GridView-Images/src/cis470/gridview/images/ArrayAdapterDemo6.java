package cis470.gridview.images;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;


public class ArrayAdapterDemo6 extends Activity 
                               implements OnItemClickListener {
	GridView gridview;
	TextView txtSoloMsg;
	
	// initialize array of smallImages & higher resolution images
	// This pictures are copied to your res/drawable app folder
	// pictures taken from Windows-Vista /My Documents/My Pictures/...
	Integer[] smallImages = { R.drawable.pic01_small,
			R.drawable.pic02_small, R.drawable.pic03_small,
			R.drawable.pic04_small, R.drawable.pic05_small,
			R.drawable.pic06_small, R.drawable.pic07_small,
			R.drawable.pic08_small, R.drawable.pic09_small, 
			R.drawable.pic10_small, R.drawable.pic11_small, 
			R.drawable.pic12_small, R.drawable.pic13_small, 
			R.drawable.pic14_small, R.drawable.pic15_small };
	
	Integer[] largeImages = { R.drawable.pic01_large,
			R.drawable.pic02_large, R.drawable.pic03_large,
			R.drawable.pic04_large, R.drawable.pic05_large,
			R.drawable.pic06_large, R.drawable.pic07_large,
			R.drawable.pic08_large, R.drawable.pic09_large, 
			R.drawable.pic10_large, R.drawable.pic11_large, 
			R.drawable.pic12_large, R.drawable.pic13_large, 
			R.drawable.pic14_large, R.drawable.pic15_large };
	
	ImageView imgSoloPhoto;
	Button btnBack;
	Bundle myOriginalMemoryBundle;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		myOriginalMemoryBundle = savedInstanceState;

		setContentView(R.layout.main);

		gridview = (GridView) findViewById(R.id.gridView1);
		gridview.setAdapter(new MyImageAdapter(this));
		gridview.setOnItemClickListener(this);

	}// onCreate
	
	
	// //////////////////////////////////////////////////////
	public class MyImageAdapter extends BaseAdapter {
		private Context mContext;

		public MyImageAdapter(Context c) {
			mContext = c;
		}

		public int getCount() {
			return smallImages.length;
		}

		public Object getItem(int position) {
			return null;
		}

		public long getItemId(int position) {
			return 0;
		}
		// create ImageViews for each thumbnail mentioned by the ArrayAdapter
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView;
			if (convertView == null) {
				imageView = new ImageView(mContext);
				imageView.setLayoutParams(
						new GridView.LayoutParams(150, 120)); 													// length
				imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
				imageView.setPadding(8, 8, 8, 8);
			} else {
				imageView = (ImageView) convertView;
			}
			imageView.setImageResource(smallImages[position]);
			return imageView;
		}

	}// ImageAdapter

	// /////////////////////////////////////////////////////////////////////////
	// a picture in the gallery view has been clicked
	@Override
	public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
		showBigScreen(position);
	}//onItemClick

	private void showBigScreen(int position) {
		// show the selected picture as a single frame
		setContentView(R.layout.solo_picture);
		txtSoloMsg = (TextView) findViewById(R.id.txtSoloMsg);
		imgSoloPhoto = (ImageView) findViewById(R.id.imgSoloPhoto);
		txtSoloMsg.setText("image " + position);

		imgSoloPhoto.setImageResource(largeImages[position]);

		btnBack = (Button) findViewById(R.id.btnBack);
		btnBack.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// redraw the main screen beginning the whole app.
				onCreate(myOriginalMemoryBundle);
			}
		});

	}// showBigScreen

}// class
