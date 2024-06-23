package com.example.myapplication.view

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import com.example.myapplication.px

private val XFERMODE = PorterDuffXfermode(PorterDuff.Mode.XOR)
private val XFERMODE2 = PorterDuffXfermode(PorterDuff.Mode.XOR)

class PorterDuffView(context: Context?, attributeSet: AttributeSet?=null) : View(context, attributeSet) {
    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bounds = RectF(150f.px, 50f.px, 300f.px, 200f.px)
    private val bounds2 = RectF(150f.px, 50f.px, 300f.px, 200f.px)
    private val circleBitmap =
        Bitmap.createBitmap(150f.px.toInt(), 150f.px.toInt(), Bitmap.Config.ARGB_8888)
    private val squareBitmap =
        Bitmap.createBitmap(150f.px.toInt(), 150f.px.toInt(), Bitmap.Config.ARGB_8888)
    private val circleBitmap2 =
        Bitmap.createBitmap(300f.px.toInt(), 300f.px.toInt(), Bitmap.Config.ARGB_8888)
    private val squareBitmap2 =
        Bitmap.createBitmap(300f.px.toInt(), 300f.px.toInt(), Bitmap.Config.ARGB_8888)

    init {
        val canvas = Canvas(circleBitmap)
        mPaint.color = Color.RED
        canvas.drawOval(50f.px, 0f, 150f.px, 100f.px, mPaint)
        canvas.setBitmap(squareBitmap)
        mPaint.color = Color.BLUE
        canvas.drawRect(0f, 50f.px, 100f.px, 150f.px, mPaint)

        val canvas2 = Canvas(circleBitmap2)
        mPaint.color = Color.MAGENTA
        canvas2.drawOval(100f.px,250f.px,300f.px,450f.px, mPaint)
        canvas2.setBitmap(squareBitmap2)
        mPaint.color = Color.BLUE
        canvas2.drawRect(0f.px,350f.px,200f.px,550f.px, mPaint)
    }

    override fun onDraw(canvas: Canvas) {
        val count = canvas.saveLayer(bounds, null)//离平缓冲
        canvas.drawBitmap(circleBitmap, 150f.px, 50f.px, mPaint)
        mPaint.xfermode = XFERMODE
        canvas.drawBitmap(squareBitmap, 150f.px, 50f.px, mPaint)
        mPaint.xfermode = null
        canvas.restoreToCount(count)

        //画线
        mPaint.color = Color.BLACK
        canvas.drawLine(0f, 250f.px, width.toFloat(), 250f.px, mPaint)

        val count2 = canvas.saveLayer(bounds2, null)
//        canvas.drawOval(150f.px,300f.px,350f.px,500f.px,mPaint)
        canvas.drawBitmap(circleBitmap2,50f.px,50f.px,mPaint)
        mPaint.xfermode = XFERMODE2
//        canvas.drawRect(50f.px,400f.px,250f.px,600f.px,mPaint)
        canvas.drawBitmap(squareBitmap2,50f.px,50f.px,mPaint)
        mPaint.xfermode = null
        canvas.restoreToCount(count2)
    }
}