package com.example.myapplication.view

import android.content.Context
import android.graphics.BlurMaskFilter
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.example.myapplication.R
import com.example.myapplication.getAvatar
import com.example.myapplication.px

class MaskFilterView(context: Context?, attributeSet: AttributeSet?=null) : View(context, attributeSet) {
    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val blurMaskFilterInner = BlurMaskFilter(20f, BlurMaskFilter.Blur.INNER)
    private val blurMaskFilterOuter = BlurMaskFilter(50f, BlurMaskFilter.Blur.OUTER)
    private val blurMaskFilterNormal = BlurMaskFilter(50f, BlurMaskFilter.Blur.NORMAL)
    private val blurMaskFilterSolid = BlurMaskFilter(50f, BlurMaskFilter.Blur.SOLID)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        mPaint.color = Color.RED
        mPaint.maskFilter = blurMaskFilterInner
        val bitmap = getAvatar(100f.px.toInt(), resources, R.drawable.bitmap_1)
        canvas.drawBitmap(bitmap, 50f.px, 50f.px, mPaint)
        mPaint.maskFilter=blurMaskFilterOuter
        val bitmap2 = getAvatar(100f.px.toInt(), resources, R.drawable.bitmap_1)
        canvas.drawBitmap(bitmap2, 200f.px, 50f.px, mPaint)

        mPaint.maskFilter=blurMaskFilterNormal
        val bitmap3 = getAvatar(100f.px.toInt(), resources, R.drawable.bitmap_1)
        canvas.drawBitmap(bitmap3, 50f.px, 200f.px, mPaint)

        mPaint.maskFilter=blurMaskFilterSolid
        val bitmap4 = getAvatar(100f.px.toInt(), resources, R.drawable.bitmap_1)
        canvas.drawBitmap(bitmap4, 200f.px, 200f.px, mPaint)
    }
}