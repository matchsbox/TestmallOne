package com.example.match.testmallone.weiget;


import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.StringRes;
import android.support.v7.widget.TintTypedArray;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.match.testmallone.R;


/**
 * Created by match on 2018/11/28.
 */

public class MToolBar extends Toolbar {

    private View mView;
    private EditText mSearthView;
    private TextView mTextTitle;
    private Button mRightButton;
    private ImageView mRightImageButton;
    private LayoutInflater mInflater;


    public MToolBar(Context context) {this(context, null);}

    public MToolBar(Context context,AttributeSet attrs) {this(context, attrs, 0);}

    public MToolBar(Context context,AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
        setContentInsetsRelative(10,10);

        if(attrs !=null) {
            //获取值
            final TintTypedArray a = TintTypedArray.obtainStyledAttributes(getContext(), attrs,
                    R.styleable.MToolBar, defStyleAttr, 0);

            final Drawable rightIcon = a.getDrawable(R.styleable.MToolBar_rightButtonIcon);
            if (rightIcon != null) {
                //setNavigationIcon(navIcon);
                setRightButtonIcon(rightIcon);
            }
            boolean isShowSearchView = a.getBoolean(R.styleable.MToolBar_isShowSearchView,false);

            if(isShowSearchView){
                showSearchView();
                hideTitleView();
            }
            CharSequence rightButtonText = a.getText(R.styleable.MToolBar_rightButtonText);
            if(rightButtonText !=null){
                setRightButtonText(rightButtonText);
            }



            a.recycle();
        }


    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void  setRightButtonIcon(Drawable icon){

        if(mRightButton !=null){

            mRightButton.setBackground(icon);
            mRightButton.setVisibility(VISIBLE);
        }

    }

    public void  setRightButtonIcon(int icon){

        setRightButtonIcon(getResources().getDrawable(icon));
    }


    public  void setRightButtonOnClickListener(OnClickListener li){

        mRightButton.setOnClickListener(li);
    }

    public void setRightButtonText(CharSequence text){
        mRightButton.setText(text);
        mRightButton.setVisibility(VISIBLE);
    }

    public void setRightButtonText(int id){
        setRightButtonText(getResources().getString(id));
    }


    public Button getRightButton(){

        return this.mRightButton;
    }

    private void initView() {
        if(mView==null) {

            mInflater=LayoutInflater.from(getContext());
            mView = mInflater.inflate(R.layout.toolbar, null);

            mTextTitle = (TextView) mView.findViewById(R.id.toolbar_title);
            mSearthView = (EditText) mView.findViewById(R.id.toolbar_searchview);
            mRightImageButton = (ImageView) mView.findViewById(R.id.toolbar_rightButton);

            LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL);

            addView(mView,lp);
        }
    }

    @Override
    public void setTitle(@StringRes int resId) {
      setTitle(getContext().getText(resId));
    }

    @Override
    public void setTitle(CharSequence title) {
        initView();
        if(mTextTitle!=null)

            mTextTitle.setText(title);
            showTitleView();
    }

    public void showSearchView(){
        if(mSearthView!=null)
            mSearthView.setVisibility(VISIBLE);
    }

    public void hideSearchView(){
        if(mSearthView==null)
            mSearthView.setVisibility(GONE);
    }

    public void showTitleView(){
        if(mTextTitle!=null)
            mTextTitle.setVisibility(VISIBLE);
    }

    public void hideTitleView(){
        if(mTextTitle==null)
            mTextTitle.setVisibility(GONE);
    }


}
