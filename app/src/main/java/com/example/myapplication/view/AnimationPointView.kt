package com.example.myapplication.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.view.View
import com.example.myapplication.px

class AnimationPointView(context: Context, attributeSet: AttributeSet) :
    View(context, attributeSet) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        strokeWidth = 20f.px
        strokeCap = Paint.Cap.ROUND
    }
    var pointF = PointF(0f, 0f)
        set(value) {
            field = value
            invalidate()
        }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawPoint(pointF.x, pointF.y, paint)

    }
}