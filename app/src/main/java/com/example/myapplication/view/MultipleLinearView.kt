package com.example.myapplication.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import com.example.myapplication.px

class MultipleLinearView(context: Context?, attributeSet: AttributeSet? = null) :
    View(context, attributeSet) {

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        this.textAlign = Paint.Align.CENTER
    }
    private val radius = 120f.px
    private val bounds = Rect()
    private val fontMetrics = Paint.FontMetrics()

    override fun onDraw(canvas: Canvas) {
        mPaint.color = Color.GRAY
        mPaint.strokeWidth = 10f.px
        mPaint.style = Paint.Style.STROKE
        canvas.drawCircle(width / 2f, height / 2f-100f.px, radius, mPaint)

        mPaint.strokeCap = Paint.Cap.ROUND
        mPaint.color = Color.MAGENTA
        canvas.drawArc(
            width / 2f - radius,
            height / 2f - radius-100f.px,
            width / 2f + radius,
            height / 2f + radius-100f.px,
            -60f,
            180f,
            false,
            mPaint
        )

        val text = "aabb"
        mPaint.style = Paint.Style.FILL
        mPaint.textSize = 100f
        //静态文字居中处理方式
//        mPaint.getTextBounds(text, 0, text.length, bounds)
//        canvas.drawText(text, width / 2f, height / 2f - (bounds.bottom + bounds.top) / 2f, mPaint)

        //动态文字居中处理方式
        mPaint.getFontMetrics(fontMetrics)
        canvas.drawText(
            text,
            width / 2f,
            height / 2f - (fontMetrics.ascent + fontMetrics.descent) / 2-100f.px,
            mPaint
        )

        //左对齐
        mPaint.textSize=200f
        mPaint.textAlign=Paint.Align.LEFT
//        mPaint.getFontMetrics(fontMetrics)
//        canvas.drawText(text,0f,-fontMetrics.top,mPaint)
        //上左贴边
        mPaint.getTextBounds(text,0,text.length,bounds)
        canvas.drawText(text,-bounds.left.toFloat(),-bounds.top.toFloat(),mPaint)

    }
}