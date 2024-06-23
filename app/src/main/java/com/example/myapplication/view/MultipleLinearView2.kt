package com.example.myapplication.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.text.StaticLayout
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import com.example.myapplication.px

class MultipleLinearView2(context: Context?, attributeSet: AttributeSet? = null) :
    View(context, attributeSet) {
    private val text = "adsbaadsbaadsba"
    private val textPaint = TextPaint().apply { textSize=50f }
    private val staticLayout = StaticLayout.Builder.obtain(text, 0, text.length, textPaint, width).build()

    override fun onDraw(canvas: Canvas) {
        staticLayout.draw(canvas)
    }
}