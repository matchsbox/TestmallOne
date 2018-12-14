package com.example.match.testmallone.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.match.testmallone.R;
import com.example.match.testmallone.weiget.MToolBar;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * Created by match on 2018/11/28.
 */

public class CollectFragment extends BaseFragment {

    @ViewInject(R.id.toolbar)
    protected MToolBar mToolbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.collect_fragment,container,false);
        return view;
    }

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }

    @Override
    public void init() {

    }


}
