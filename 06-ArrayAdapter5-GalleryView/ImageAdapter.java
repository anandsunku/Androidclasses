package csu.matos;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
	private Context mContext;
	private Integer[] thumbNail;
	
	public ImageAdapter(Context c, Integer[] thumbNail) {
		mContext = c;	
		this.thumbNail = thumbNail;
	}

	public int getCount() {
		return thumbNail.length;
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		// Get a View to display image data 		
		ImageView iv = new ImageView(mContext);

		iv.setImageResource(thumbNail[position]);
		// try other params (width, height) such as 200, 150
		// see the effect of those settings on a real device
		iv.setLayoutParams(new Gallery.LayoutParams(100, 90));
		iv.setScaleType(ImageView.ScaleType.FIT_XY);
		// Image should be scaled somehow (options are...) try...
		// iv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);		
		return iv;
	}

}//class
