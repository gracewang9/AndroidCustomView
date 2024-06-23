package com.example.myapplication.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.Paint
import android.graphics.PixelFormat
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import androidx.core.graphics.toColorInt
import com.example.myapplication.R
import com.example.myapplication.dp
import com.example.myapplication.getAvatar

class DrawableView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    val drawable: Drawable = ConDrawable()
    val paint=Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawable.setBounds(0,0,width-50,height-500)
        drawable.draw(canvas)
        canvas.drawBitmap(getAvatar(200,resources, R.drawable.bitmap_1),0f,height-500f,paint)
    }

}

class ConDrawable : Drawable() {
    private val INTERVAL = 50.dp
    private val paint = Paint().apply {
        color = "#F9A825".toColorInt()
        strokeWidth = 5.dp
        strokeCap = Paint.Cap.ROUND
    }

    override fun draw(canvas: Canvas) {
        var x = bounds.left.toFloat()
        while (x <= bounds.right) {
            canvas.drawLine(x, bounds.top.toFloat(), x, bounds.bottom.toFloat(), paint)
            x += INTERVAL
        }
        var y = bounds.top.toFloat()
        while (y <= bounds.bottom) {
            canvas.drawLine(bounds.left.toFloat(), y, bounds.right.toFloat(), y, paint)
            y += INTERVAL
        }
    }

    override fun setAlpha(alpha: Int) {
        paint.alpha = alpha
    }

    override fun getAlpha(): Int {
        return paint.alpha
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        paint.colorFilter = colorFilter
    }

    override fun getColorFilter(): ColorFilter? {
        return paint.colorFilter
    }

    override fun getOpacity(): Int {
        return when (paint.alpha) {
            0 -> PixelFormat.TRANSPARENT
            0xff -> PixelFormat.OPAQUE
            else -> PixelFormat.TRANSLUCENT
        }
    }

}