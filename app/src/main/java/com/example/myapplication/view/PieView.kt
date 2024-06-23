package com.example.myapplication.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.example.myapplication.px
import kotlin.math.cos
import kotlin.math.sin

private val OFFSET_LENGTH = 20f.px
private val RADIUS = 150f.px
private val ANGLES = floatArrayOf(90f, 60f, 150f, 60f)
private val COLORS =
    listOf(
        Color.parseColor("#9ACD32"),
        Color.parseColor("#008B8B"),
        Color.parseColor("#00BFFF"),
        Color.parseColor("#6B8E23")
    )

class PieView(context: Context?, attrs: AttributeSet?=null) : View(context, attrs) {
    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    override fun onDraw(canvas: Canvas) {
        var startAngle = 0f
        for ((index, angle) in ANGLES.withIndex()) {
            if (index == 3) {
                canvas.save()
                canvas.translate(
                    OFFSET_LENGTH * cos(Math.toRadians(angle / 2f.toDouble()+startAngle)).toFloat(),
                    OFFSET_LENGTH * sin(Math.toRadians(angle / 2f.toDouble()+startAngle)).toFloat()
                )
            }
            mPaint.color = COLORS[index]
            canvas.drawArc(
                width / 2f - RADIUS,
                height / 2f - RADIUS,
                width / 2f + RADIUS,
                height / 2f + RADIUS,
                startAngle,
                angle,
                true,
                mPaint
            )
            startAngle += angle
            if (index == 3) {
                canvas.restore()
            }
        }
    }
}