package com.example.kuai.views.flowLayout;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class FlowLayout extends RecyclerView.LayoutManager {
    private int mSumDy = 0;
    private int mTotalHeight = 0;
    public int scrollDirection;
    private List<Object> list;
    private Context mContext;
    public FlowLayout(Context context,List<Object> list){
        this.list = list;
        this.mContext = context;
    }

    @Override
    public  RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(RecyclerView.LayoutParams.WRAP_CONTENT,
                RecyclerView.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {

        int screenWidth = mContext.getResources().getDisplayMetrics().widthPixels;
        int screenHeight = mContext.getResources().getDisplayMetrics().heightPixels;

        //定义竖直方向的偏移量
        int offsetY = 0;
        int offsetX = 0;

        int nextX = 0;
        int nextY = 0;
        int nextW = 0;


        for (int i = 0; i < getItemCount(); i++) {
            View view = recycler.getViewForPosition(i);
            addView(view);
            measureChildWithMargins(view, 0, 0);
            int width = getDecoratedMeasuredWidth(view);
            int height = getDecoratedMeasuredHeight(view);

            nextW = width;

            if (i > 0){


                if (nextX + nextW + width >= screenWidth) {
                    offsetX = 0;
                    offsetY = nextY + height;
                } else{
                    offsetX = nextX + width;
                    offsetY = nextY;
                    width += offsetX;
                }
            }

            nextX = offsetX;
            nextY = offsetY;

            layoutDecorated(view, offsetX, offsetY, width, offsetY + height);
            offsetY += height;
        }


        mTotalHeight = Math.max(offsetY, getVerticalSpace());
    }

    private int getVerticalSpace() {
        return getHeight() - getPaddingBottom() - getPaddingTop();
    }

    @Override
    public boolean canScrollVertically() {
        return true;
    }

    @Override
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int travel = dy;
        //如果滑动到最顶部
        if (mSumDy + dy < 0) {
            travel = -mSumDy;
        } else if (mSumDy + dy > mTotalHeight - getVerticalSpace()) {
            //如果滑动到最底部
            travel = mTotalHeight - getVerticalSpace() - mSumDy;
        }

        mSumDy += travel;
        // 平移容器内的item
        offsetChildrenVertical(-travel);
        return dy;
    }
}