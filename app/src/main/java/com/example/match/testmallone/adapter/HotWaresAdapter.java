package com.example.match.testmallone.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.match.testmallone.R;
import com.example.match.testmallone.bean.Activity_mall;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;



public class HotWaresAdapter extends RecyclerView.Adapter<HotWaresAdapter.ViewHolder>  {



    private List<Activity_mall> mDatas;

    private LayoutInflater mInflater;

    public HotWaresAdapter(List<Activity_mall> wares){

        mDatas = wares;


    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mInflater = LayoutInflater.from(parent.getContext());
        View view = mInflater.inflate(R.layout.template_hot_wares,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Activity_mall wares = getData(position);

        holder.draweeView.setImageURI(Uri.parse(wares.getImgUrl()));
        holder.textTitle.setText(wares.getName());
        holder.textTitle2.setText(wares.getTimedata());

        holder.textPrice.setText("Hot:"+wares.getGread());


    }


    public Activity_mall getData(int position){

        return mDatas.get(position);
    }


    public List<Activity_mall> getDatas(){

        return  mDatas;
    }
    public void clearData(){

        mDatas.clear();
        notifyItemRangeRemoved(0,mDatas.size());
    }

    public void addData(List<Activity_mall> datas){

        addData(0,datas);
    }

    public void addData(int position,List<Activity_mall> datas){

        if(datas !=null && datas.size()>0) {

            mDatas.addAll(datas);
            notifyItemRangeChanged(position, mDatas.size());
        }

    }


    @Override
    public int getItemCount() {

        if(mDatas!=null && mDatas.size()>0)
            return mDatas.size();

        return 0;
    }



    class ViewHolder extends RecyclerView.ViewHolder{


        SimpleDraweeView draweeView;
        TextView textTitle;
        TextView textTitle2;
        TextView textPrice;


        public ViewHolder(View itemView) {
            super(itemView);


            draweeView = (SimpleDraweeView) itemView.findViewById(R.id.drawee_view);
            textTitle= (TextView) itemView.findViewById(R.id.text_title);
            textTitle2= (TextView) itemView.findViewById(R.id.text_title2);
            textPrice= (TextView) itemView.findViewById(R.id.text_price);
        }
    }
}
