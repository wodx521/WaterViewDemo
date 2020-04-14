package com.wanou.waterviewdemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wanou.testlib.base.BaseRecycleViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class OperateAdapter extends BaseRecycleViewAdapter {
    private List<String> contentList;

    public OperateAdapter(Context context) {
        super(context);
    }

    public List<String> getContentList() {
        if (contentList == null) {
            contentList = new ArrayList<>();
        }
        return contentList;
    }

    public void setContentList(List<String> contentList) {
        this.contentList = contentList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = inflater.inflate(R.layout.item_operate, parent, false);
        return new OperateViewHolder(inflate);
    }

    @Override
    public int getItemCount() {
        if (contentList != null && contentList.size() > 0) {
            return contentList.size();
        }
        return 0;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        OperateViewHolder operateViewHolder = (OperateViewHolder) holder;
        operateViewHolder.btOperate.setText(contentList.get(position));

    }

    static class OperateViewHolder extends RecyclerView.ViewHolder {
        private Button btOperate;

        public OperateViewHolder(@NonNull View itemView) {
            super(itemView);
            btOperate = itemView.findViewById(R.id.btOperate);
        }
    }
}
