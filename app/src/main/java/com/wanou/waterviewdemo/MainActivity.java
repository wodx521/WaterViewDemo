package com.wanou.waterviewdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wanou.testlib.LibraryUtils;
import com.wanou.testlib.base.BaseActivity;
import com.wanou.waterview.bean.Water;
import com.wanou.waterview.widget.WaterView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private WaterView mWaterView;
    private List<Water> waterList = new ArrayList<>();
    private int textsize = 18;

    @Override
    protected int getResId() {
        LibraryUtils.init(getApplication());
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mWaterView = findViewById(R.id.water_view);
        Button mAll = findViewById(R.id.all);
        Button mCircle = findViewById(R.id.circle);
        Button mRightBottom = findViewById(R.id.right_bottom);
        Button mLeftBottom = findViewById(R.id.left_bottom);
        Button mTop = findViewById(R.id.top);
        Button mBottom = findViewById(R.id.bottom);
        Button mSelfNone = findViewById(R.id.self_none);
        Button mViewCenter = findViewById(R.id.view_center);
        Button mScaleAnimation = findViewById(R.id.scale_animation);
        Button mTranslateAnimation = findViewById(R.id.translate_animation);
        Button mChangeImage = findViewById(R.id.change_image);
        Button mDefaultImage = findViewById(R.id.default_image);
        Button mRightTop = findViewById(R.id.right_top);
        Button mLeftTop = findViewById(R.id.left_top);
        Button drawableBackground = findViewById(R.id.drawable_background);
        Button drawableTop = findViewById(R.id.drawable_top);
        Button randomColor = findViewById(R.id.random_color);
        Button defaultColor = findViewById(R.id.default_color);
        Button textsize = findViewById(R.id.textsize);
        Button defaultSize = findViewById(R.id.default_size);

        mAll.setOnClickListener(this);
        mCircle.setOnClickListener(this);
        mRightBottom.setOnClickListener(this);
        mLeftBottom.setOnClickListener(this);
        mTop.setOnClickListener(this);
        mBottom.setOnClickListener(this);
        mSelfNone.setOnClickListener(this);
        mViewCenter.setOnClickListener(this);
        mScaleAnimation.setOnClickListener(this);
        mTranslateAnimation.setOnClickListener(this);
        mChangeImage.setOnClickListener(this);
        mDefaultImage.setOnClickListener(this);
        mRightTop.setOnClickListener(this);
        mLeftTop.setOnClickListener(this);
        drawableBackground.setOnClickListener(this);
        drawableTop.setOnClickListener(this);
        randomColor.setOnClickListener(this);
        defaultColor.setOnClickListener(this);
        textsize.setOnClickListener(this);
        defaultSize.setOnClickListener(this);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        for (int i = 0; i < 10; i++) {
            waterList.add(new Water(i + 5 + "g", "测试"));
        }
    }

    @Override
    protected void setData() {
        mWaterView.setWaters(waterList);

        mWaterView.setClickListener(new WaterView.ClickListener() {
            @Override
            public void clickListener(View view, int finalI) {
                mWaterView.setViewInterpolator(null);
                mWaterView.animRemoveView(view);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.circle:
                mWaterView.setLayoutStyle(WaterView.CIRCLE_RANDOM);
                mWaterView.setWaters(waterList);
                break;
            case R.id.all:
                mWaterView.setLayoutStyle(WaterView.RECTANGLE_RANDOM);
                mWaterView.setWaters(waterList);
                break;
            case R.id.right_bottom:
                mWaterView.setDestroyPoint(WaterView.VIEW_RIGHT_BOTTOM);
                break;
            case R.id.left_bottom:
                mWaterView.setDestroyPoint(WaterView.VIEW_LEFT_BOTTOM);
                break;
            case R.id.top:
                mWaterView.setDestroyPoint(WaterView.VIEW_TOP);
                break;
            case R.id.bottom:
                mWaterView.setDestroyPoint(WaterView.VIEW_BOTTOM);
                break;
            case R.id.self_none:
                mWaterView.setDestroyPoint(WaterView.VIEW_SELF);
                break;
            case R.id.view_center:
                mWaterView.setDestroyPoint(WaterView.VIEW_CENTER);
                break;
            case R.id.right_top:
                mWaterView.setDestroyPoint(WaterView.VIEW_RIGHT_TOP);
                break;
            case R.id.left_top:
                mWaterView.setDestroyPoint(WaterView.VIEW_LEFT_TOP);
                break;
            case R.id.scale_animation:
                mWaterView.setViewAnimation(WaterView.SCALE);
                mWaterView.setWaters(waterList);
                break;
            case R.id.translate_animation:
                mWaterView.setViewAnimation(WaterView.TRANSLATE);
                mWaterView.setWaters(waterList);
                break;
            case R.id.change_image:
                mWaterView.setImageRes(R.drawable.water_icon);
                mWaterView.setWaters(waterList);
                break;
            case R.id.default_image:
                mWaterView.setImageRes(R.drawable.shape_view);
                mWaterView.setWaters(waterList);
                break;
            case R.id.drawable_background:
                mWaterView.setDrawablePosition(WaterView.BACKGROUND);
                mWaterView.setWaters(waterList);
                break;
            case R.id.drawable_top:
                mWaterView.setDrawablePosition(WaterView.DRAWABLE_TOP);
                mWaterView.setWaters(waterList);
                break;
            case R.id.random_color:
                int red = (int) (Math.random() * 200 + 10);
                int blue = (int) (Math.random() * 200 + 10);
                int green = (int) (Math.random() * 200 + 10);
                int rgb = Color.rgb(red, green, blue);
                mWaterView.setTextColor(rgb);
                mWaterView.setWaters(waterList);
                break;
            case R.id.default_color:
                mWaterView.setTextColor(Color.WHITE);
                mWaterView.setWaters(waterList);
                break;
            case R.id.textsize:
                textsize += 2;
                if (textsize >= 30) {
                    textsize = 30;
                }
                mWaterView.setTextSize(textsize);
                mWaterView.setWaters(waterList);
                break;
            case R.id.default_size:
            default:
                textsize = 18;
                mWaterView.setTextSize(textsize);
                mWaterView.setWaters(waterList);
                break;
        }
    }
}
