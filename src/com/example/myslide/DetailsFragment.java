package com.example.myslide;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 作为界面的一部分，为fragment 提供一个layout
 * @author leigo
 *
 */
@SuppressLint("NewApi")
public class DetailsFragment extends Fragment {
	
    private static final String[] WEEKS = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

    public static DetailsFragment newInstance(int index) {
        DetailsFragment df = new DetailsFragment();
        Bundle args = new Bundle();
        args.putInt("index", index);
        df.setArguments(args);
        Log.e("909090090", "9897875678");
        return df;
    }

    public int getShowIndex() {
        int index = getArguments().getInt("index", 0);
        return index;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        TextView tv = new TextView(getActivity());
        tv.setText(WEEKS[getShowIndex()]);
        return tv;
    }
}