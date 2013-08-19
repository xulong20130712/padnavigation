package com.example.myslide;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TitlesFragment extends ListFragment {
    private static final String[] TITLES = new String[] {"存储", "账号", "设置","联网状态", "任务"};

    // 初始化的选择位置
    int mCurCheckPosition = 0;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // 设置要显示的数据
        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_activated_1, android.R.id.text1, TITLES));
        showDetails(mCurCheckPosition);
    }

    private void showDetails(int index) {
       
    	// fragment的管理器
        FragmentManager fm = getFragmentManager();
        DetailsFragment details = (DetailsFragment) fm.findFragmentById(R.id.details);
        if (details == null || details.getShowIndex() != index) {
            // 设置为单选模式
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            // 指定条目被选中
            getListView().setItemChecked(index, true);
            // 新建DetailFragment的实例
            details = DetailsFragment.newInstance(index);
            FragmentTransaction ft = fm.beginTransaction();
            // 替换FrameLayout为DetailFragment 类似于 事务
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            // 将得到的fragment 替换当前的viewGroup内容，add则不替换会依次累加
            ft.replace(R.id.details, details);
            // 提交
            ft.commit();
            
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        showDetails(position);
    }
}