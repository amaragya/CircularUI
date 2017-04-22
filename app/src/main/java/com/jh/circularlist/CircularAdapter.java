package com.jh.circularlist;

import android.content.Context;
import android.service.carrier.CarrierService;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by jh on 2017/4/15.
 *
 * using this custom adapter(not really an adapter) to set your items
 */

public class CircularAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<View> mItemViews;

    public int getCount() { return mItemViews.size(); }
    public View getItemAt(int position) { return mItemViews.get(position); }


    /**
     * constructor initialize items, using string array in this example
     */
    public CircularAdapter(Context context, ArrayList<String> data){

        this.mContext = context;
        mItemViews = new ArrayList<>();
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // just for demo fill with drawable
        ArrayList<Integer> drawableList = new ArrayList<>();
        drawableList.add(R.drawable.android);
        drawableList.add(R.drawable.camera);
        drawableList.add(R.drawable.cart);
        drawableList.add(R.drawable.cloud);
        drawableList.add(R.drawable.duck);
        drawableList.add(R.drawable.email);
        drawableList.add(R.drawable.facebook_box);
        drawableList.add(R.drawable.ghost);
        drawableList.add(R.drawable.home);
        drawableList.add(R.drawable.lightbulb);
        drawableList.add(R.drawable.message);


        // for each data, display using an custom view
        for(final String s : data){
            Log.d("TAG", s);
            View view = mInflater.inflate(R.layout.view_circular_item, null);
            ImageView image = (ImageView)view.findViewById(R.id.item_icon);
            image.setImageResource(drawableList.get(data.indexOf(s)));
            TextView title = (TextView) view.findViewById(R.id.item_title);
            title.setText(s);
            mItemViews.add(view);
        }

    }

}
