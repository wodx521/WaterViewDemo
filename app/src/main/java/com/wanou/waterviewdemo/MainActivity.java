package com.wanou.waterviewdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.wanou.testlib.LibraryUtils;
import com.wanou.testlib.base.BaseActivity;
import com.wanou.testlib.base.BaseRecycleViewAdapter;
import com.wanou.waterview.bean.Water;
import com.wanou.waterview.widget.WaterView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends BaseActivity {
    private WaterView waterView;
    private RecyclerView rvOperate;
    private List<Water> waterList = new ArrayList<>();
    private int textsize = 18;

    @Override
    protected int getResId() {
        LibraryUtils.init(getApplication());
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        waterView = findViewById(R.id.water_view);
        rvOperate = findViewById(R.id.rvOperate);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        for (int i = 0; i < 10; i++) {
            waterList.add(new Water(i + 5 + "g", "测试"));
        }
        String[] stringArray = getResources().getStringArray(R.array.operateContent);
        OperateAdapter operateAdapter = new OperateAdapter(this);
        rvOperate.setAdapter(operateAdapter);

        operateAdapter.setContentList(Arrays.asList(stringArray));
        operateAdapter.setOnItemClickListener(new BaseRecycleViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                switch (position) {
                    case 0:
                        // 全局随机
                        waterView.setLayoutStyle(WaterView.RECTANGLE_RANDOM);
                        waterView.setWaters(waterList);
                        break;
                    case 1:
                        // 中心随机
                        waterView.setLayoutStyle(WaterView.CIRCLE_RANDOM);
                        waterView.setWaters(waterList);
                        break;
                    case 2:
                        // 上
                        waterView.setDestroyPoint(WaterView.VIEW_TOP);
                        break;
                    case 3:
                        // 下
                        waterView.setDestroyPoint(WaterView.VIEW_BOTTOM);
                        break;
                    case 4:
                        // 左上
                        waterView.setDestroyPoint(WaterView.VIEW_LEFT_TOP);
                        break;
                    case 5:
                        // 右上
                        waterView.setDestroyPoint(WaterView.VIEW_RIGHT_TOP);
                        break;
                    case 6:
                        // 左下
                        waterView.setDestroyPoint(WaterView.VIEW_LEFT_BOTTOM);
                        break;
                    case 7:
                        // 右下
                        waterView.setDestroyPoint(WaterView.VIEW_RIGHT_BOTTOM);
                        break;
                    case 8:
                        // 自身中心
                        waterView.setDestroyPoint(WaterView.VIEW_SELF);
                        break;
                    case 9:
                        // 视图中心
                        waterView.setDestroyPoint(WaterView.VIEW_CENTER);
                        break;
                    case 10:
                        // 更新图片
                        waterView.setImageRes(R.drawable.water_icon);
                        waterView.setWaters(waterList);
                        break;
                    case 11:
                        // 默认图片
                        waterView.setImageRes(R.drawable.shape_view);
                        waterView.setWaters(waterList);
                        break;
                    case 12:
                        // 缩放动画
                        waterView.setViewAnimation(WaterView.SCALE);
                        waterView.setWaters(waterList);
                        break;
                    case 13:
                        // 平移动画
                        waterView.setViewAnimation(WaterView.TRANSLATE);
                        waterView.setWaters(waterList);
                        break;
                    case 14:
                        // 文字中心
                        waterView.setDrawablePosition(WaterView.BACKGROUND);
                        waterView.setWaters(waterList);
                        break;
                    case 15:
                        // 文字上部
                        waterView.setDrawablePosition(WaterView.DRAWABLE_TOP);
                        waterView.setWaters(waterList);
                        break;
                    case 16:
                        // 随机颜色
                        int red = (int) (Math.random() * 200 + 10);
                        int blue = (int) (Math.random() * 200 + 10);
                        int green = (int) (Math.random() * 200 + 10);
                        int rgb = Color.rgb(red, green, blue);
                        waterView.setTextColor(rgb);
                        waterView.setWaters(waterList);
                        break;
                    case 17:
                        // 默认颜色
                        waterView.setTextColor(Color.WHITE);
                        waterView.setWaters(waterList);
                        break;
                    case 18:
                        // 文字大小
                        textsize += 2;
                        if (textsize >= 30) {
                            textsize = 30;
                        }
                        waterView.setTextSize(textsize);
                        waterView.setWaters(waterList);
                        break;
                    case 19:
                    default:
                        // 默认文字大小
                        textsize = 18;
                        waterView.setTextSize(textsize);
                        waterView.setWaters(waterList);
                        break;
                }
            }
        });

    }

    @Override
    protected void setData() {
        waterView.setWaters(waterList);

        waterView.setClickListener(new WaterView.ClickListener() {
            @Override
            public void clickListener(View view, int finalI) {
                waterView.setViewInterpolator(null);
                waterView.animRemoveView(view);
            }
        });
    }
}
