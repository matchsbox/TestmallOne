package com.example.match.testmallone.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.match.testmallone.R;
import com.example.match.testmallone.bean.Test_activity;

import java.util.List;

/**
 * Created by match on 2018/12/13.
 */

public class Mall_recvclerAdpater extends RecyclerView.Adapter<Mall_recvclerAdpater.ViewHolder> {

    private LayoutInflater mInflater;
    private List<Test_activity> mDatas;

    public Mall_recvclerAdpater(List<Test_activity> datas){
        mDatas=datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        mInflater=this.mInflater.from(parent.getContext());


        return new ViewHolder(mInflater.inflate(R.layout.mall_cardview,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        Test_activity activity=mDatas.get(i);
        viewHolder.category.setText(activity.getCategory());
        viewHolder.mallName.setText(activity.getMallName());
        viewHolder.gread.setText("HOT："+activity.getGread());
        viewHolder.image.setImageResource(activity.getImage());
        viewHolder.activityText.setText(activity.getText());
        viewHolder.time.setText("剩余时间"+activity.getTime()+"天");


    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView mallName;
        TextView gread;
        ImageView image;
        TextView activityText;
        TextView time;
        TextView category;

        public ViewHolder(View itemView){
            super(itemView);

            mallName= (TextView) itemView.findViewById(R.id.mallName);
            gread= (TextView) itemView.findViewById(R.id.gread);
            image= (ImageView) itemView.findViewById(R.id.activity_image);
            activityText= (TextView) itemView.findViewById(R.id.activity_Text);
            time= (TextView) itemView.findViewById(R.id.time);
            category= (TextView) itemView.findViewById(R.id.category);


        }
    }
}
