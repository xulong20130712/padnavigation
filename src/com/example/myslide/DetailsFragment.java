package com.example.myslide;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 作为界面的一部分，为fragment 提供一个layout
 */
public class DetailsFragment extends Fragment {
	
    private static final String[] WEEKS = new String[] {"存储 detail", "账号 Detail", "设置 Detail", "联网状态 Detail", "任务 Detail"};

    public static DetailsFragment newInstance(int index) {
        DetailsFragment df = new DetailsFragment();
        Bundle args = new Bundle();
        args.putInt("index", index);
        df.setArguments(args);
        return df;
    }

    public int getShowIndex() {
        int index = getArguments().getInt("index", 0);
        return index;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	
    	int selectNum= -1;
    	selectNum= getShowIndex();
    	if(selectNum== 0) {
    		
    		View view= inflater.inflate(R.layout.storage, null);
    		return view;
    	}else{
    		
    		TextView tv = new TextView(getActivity());
	        tv.setText(WEEKS[selectNum]);
	        return tv;
    	}
        
    }
}