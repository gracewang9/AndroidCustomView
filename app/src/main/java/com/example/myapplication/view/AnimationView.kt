package com.example.myapplication.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.example.myapplication.R
import com.example.myapplication.getAvatar
import com.example.myapplication.px

class AnimationView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    private val paint = Paint()
    private val radius = 100f.px
    var color = Color.BLACK
        set(value) {
            field = value
            invalidate()
        }
    var widthImage: Float = 200f
        set(value) {
            field = value
            invalidate()
        }

    override fun onDraw(canvas: Canvas) {

//        canvas.drawBitmap(getAvatar(widthImage.toInt(), resources, R.drawable.bitmap_1), 100f, 100f, paint)
        paint.color=color
        canvas.drawCircle(width / 2f, height / 2f, radius, paint)
    }
}