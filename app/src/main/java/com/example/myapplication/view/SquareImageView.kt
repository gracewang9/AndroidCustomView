package com.example.myapplication.view

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

class SquareImageView(context: Context, attributeSet: AttributeSet) :
    AppCompatImageView(context, attributeSet) {
    override fun layout(l: Int, t: Int, r: Int, b: Int) {
        super.layout(l, t, r, b)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        getMeasuredHeight()//测量后的高度
        getMeasuredWidth()//测量后的宽度
        getHeight()//实际View的高度
        getWidth()//实际View的宽度
        setMeasuredDimension(measuredWidth,measuredHeight)//保存结果
    }
}