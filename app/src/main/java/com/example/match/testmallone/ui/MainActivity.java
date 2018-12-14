package com.example.match.testmallone.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.match.testmallone.R;
import com.example.match.testmallone.bean.Tab;
import com.example.match.testmallone.fragment.CollectFragment;
import com.example.match.testmallone.fragment.LBSFragment;
import com.example.match.testmallone.fragment.MallFragment;
import com.example.match.testmallone.fragment.MineFragment;
import com.example.match.testmallone.weiget.FragmentTabHost;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LayoutInflater mInflater;
    private FragmentTabHost mTabhost;
    private List<Tab> mTabs = new ArrayList<>(4);

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            initTab();

        }

    private void initTab() {
        Tab tab_mall = new Tab(R.string.mall, R.drawable.selector_icon_mall, MallFragment.class);
        Tab tab_lbs = new Tab(R.string.lbs, R.drawable.selector_icon_lbs, LBSFragment.class);
        Tab tab_collect = new Tab(R.string.collect, R.drawable.selector_icon_collect, CollectFragment.class);
        Tab tab_mine = new Tab(R.string.mine, R.drawable.select_icon_mine, MineFragment.class);

        mTabs.add(tab_mall);
        mTabs.add(tab_lbs);
        mTabs.add(tab_collect);
        mTabs.add(tab_mine);

        mInflater = LayoutInflater.from(this);
        mTabhost = (FragmentTabHost) this.findViewById(android.R.id.tabhost);
        mTabhost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        for (Tab tab : mTabs) {

            TabHost.TabSpec tabSpec = mTabhost.newTabSpec(getString(tab.getTitle()));
            tabSpec.setIndicator(buildIndicator(tab));
            mTabhost.addTab(tabSpec, tab.getFragment(), null);
        }
        mTabhost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        mTabhost.setCurrentTab(0);

    }

    private View buildIndicator(Tab tab) {


        View view = mInflater.inflate(R.layout.tab_indicator, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.icon_tab);
        TextView textView = (TextView) view.findViewById(R.id.txt_indicator);

        imageView.setBackgroundResource(tab.getIcon());
        textView.setText(tab.getTitle());
        return view;
    }


}
