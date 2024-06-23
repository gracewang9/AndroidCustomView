package com.example.myapplication.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class PaintStyleView(context: Context?, attributeSet: AttributeSet?=null) : View(context, attributeSet) {
    private val mPaint = Paint()


    override fun onDraw(canvas: Canvas) {

        super.onDraw(canvas)
        canvas.drawCircle(300f, 200f, 200f, mPaint)
        mPaint.color = Color.BLUE
        getStrokeStyle(mPaint)
        canvas.drawCircle(750f, 200f, 200f, mPaint)
        mPaint.color = Color.RED
        getFillStyle(mPaint)
        canvas.drawRect(100f, 450f, 450f, 800f, mPaint)
        getStrokeStyle(mPaint)
        canvas.drawRect(550f, 450f, 900f, 800f, mPaint)
        val points =
            arrayListOf(0f, 0f, 50f, 50f, 50f, 100f, 100f, 50f, 100f, 100f, 150f, 50f, 150f, 100f)
        canvas.drawPoints(points.toFloatArray(), 2, 8, mPaint)
        mPaint.color = Color.GREEN
        getFillStyle(mPaint)
        canvas.drawRoundRect(100f, 900f, 450f, 1200f, 50f, 50f, mPaint)
        getStrokeStyle(mPaint)
        canvas.drawRoundRect(550f, 900f, 900f, 1200f, 50f, 50f, mPaint)
        getFillStyle(mPaint)
        canvas.drawArc(100f, 1250f, 400f, 1550f, 60f, 300f, true, mPaint)
        getStrokeStyle(mPaint)
        canvas.drawArc(600f, 1250f, 900f, 1550f, 60f, 300f, true, mPaint)


    }

}

fun getStrokeStyle(mPaint: Paint) {
    mPaint.strokeWidth = 10f
    mPaint.style = Paint.Style.STROKE
}

fun getFillStyle(mPaint: Paint) {
    mPaint.strokeWidth = 0f
    mPaint.style = Paint.Style.FILL
}


