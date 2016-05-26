/*   Code adapted from ApiDemos sample located at 
 *   C:\Program Files (x86)\Android\android-sdk\samples\android-10\
 *   ApiDemos\src\com\example\android\apis\view\Gallery1
 */

package csu.matos;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class HelloLayoutActivity extends Activity {
	// list of images copied to your res/drawable app folder
	
	Integer[] thumbNail = { R.drawable.pic01_small,
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
	
	ImageView selectedImage;
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		selectedImage = (ImageView) findViewById(R.id.selected_image);
		
		Gallery g = (Gallery) findViewById(R.id.gallery);

		// Set the adapter to our custom adapter
		g.setAdapter(new ImageAdapter(this, thumbNail));

		// Set an item click-listener and wait for user to make selection
		g.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				// draw selected image (if possible use better resolution);
				BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources()
						.getDrawable(largeImages[position]);

				Bitmap b = Bitmap.createScaledBitmap(bitmapDrawable.getBitmap(),
						(int) (bitmapDrawable.getIntrinsicHeight() * 1.0),
						(int) (bitmapDrawable.getIntrinsicWidth() * 1.0), false);

				selectedImage.setImageBitmap(b);
				selectedImage.setScaleType(ScaleType.FIT_XY);
				
				//SIMILAR TO ==> selectedImage.setImageResource(largeImages[position]);
			}
		});

	}// onCreate


}//class
