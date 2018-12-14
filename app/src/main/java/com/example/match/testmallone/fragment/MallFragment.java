package com.example.match.testmallone.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.match.testmallone.R;
import com.example.match.testmallone.adapter.DivideritemDecortion;
import com.example.match.testmallone.adapter.Mall_recvclerAdpater;
import com.example.match.testmallone.bean.Test_activity;
import com.example.match.testmallone.http.BaseCallback;
import com.example.match.testmallone.http.OkHttpHelper;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by match on 2018/11/28.
 */

public class MallFragment extends Fragment {


    private SliderLayout mSliderLyaout;
    private PagerIndicator mindicator;
    private OkHttpHelper httpHelper = OkHttpHelper.getInstance();
    private RecyclerView mRecyclerView;



    private Mall_recvclerAdpater mAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mall_fragment, container, false);
        inRecyclerView(view);
        initSlider(view);
        //     requestImageOK();
        return view;
    }


    public void inRecyclerView(View view) {

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);

        List<Test_activity> datas = new ArrayList<>(15);
        Test_activity activity = new Test_activity("XX店铺", 5.55, R.mipmap.icon_collect, "正常的美食文化与健康", 8,"餐饮");
        datas.add(activity);
        activity = new Test_activity("XX店铺1", 5.55, R.mipmap.aa2, "正常的美食文化与健康", 8,"餐饮");
        datas.add(activity);
        activity = new Test_activity("XX店铺2", 5.55, R.mipmap.icon_collect, "正常的美食文化与健康", 8,"餐饮");
        datas.add(activity);
        activity = new Test_activity("XX店铺3", 5.55, R.mipmap.icon_collect, "正常的美食文化与健康", 8,"餐饮");
        datas.add(activity);
        activity = new Test_activity("XX店铺4", 5.55, R.mipmap.aa2, "正常的美食文化与健康", 8,"餐饮");
        datas.add(activity);
        activity = new Test_activity("XX店铺13", 5.55, R.mipmap.icon_collect, "正常的美食文化与健康", 8,"餐饮");
        datas.add(activity);
        activity = new Test_activity("XX店铺14", 5.55, R.mipmap.aa2, "正常的美食文化与健康", 8,"餐饮");
        datas.add(activity);
        activity = new Test_activity("XX店铺23", 5.55, R.mipmap.icon_collect, "正常的美食文化与健康", 8,"餐饮");
        datas.add(activity);
        activity = new Test_activity("XX店铺34", 5.55, R.mipmap.icon_collect, "正常的美食文化与健康", 8,"餐饮");
        datas.add(activity);

        mAdapter=new Mall_recvclerAdpater(datas);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addItemDecoration(new DivideritemDecortion());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
    }




    private void initSlider(View view) {

        mSliderLyaout = (SliderLayout) view.findViewById(R.id.slider);
        mindicator = (PagerIndicator) view.findViewById(R.id.indicator);

        TextSliderView textSliderView = new TextSliderView(this.getActivity());
        textSliderView.image(R.mipmap.assemble);
        textSliderView.description("111");
        textSliderView.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView slider) {
                Toast.makeText(MallFragment.this.getActivity(), "111", Toast.LENGTH_LONG).show();

            }
        });

        TextSliderView textSliderView2 = new TextSliderView(this.getActivity());
        textSliderView2.image(R.mipmap.icon_lbs);
        textSliderView2.description("222");

        mSliderLyaout.addSlider(textSliderView);
        mSliderLyaout.addSlider(textSliderView2);

        mSliderLyaout.setCustomAnimation(new DescriptionAnimation());
        mSliderLyaout.setCustomIndicator(mindicator);
        mSliderLyaout.setPresetTransformer(SliderLayout.Transformer.RotateUp);
        mSliderLyaout.setDuration(3000);


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mSliderLyaout.stopAutoCycle();
    }

    private void requestImageOK() {

        String url = "http://matchsbox.cn/springMVC/Activity/selAll.do";

//        OkHttpClient client=new OkHttpClient();
//        final Request request=new Request.Builder()
//                .url(url)
//                .build();
//
//
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Request request, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Response response) throws IOException {
//
//                if(response.isSuccessful()){
//                    String json=response.body().string();
//                    Log.i("MallFragment","json="+json);
//                }
//            }
//        });

        httpHelper.get(url, new BaseCallback() {
            @Override
            public void onRequestbefroe(Request request) {

            }

            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) {

            }

            @Override
            public void onSuccess(Response response, Object o) {

            }

            @Override
            public void onError(Response response, int code, Exception e) {

            }
        });


    }


}
