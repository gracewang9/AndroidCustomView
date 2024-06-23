package com.example.myapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class TestView2(context:Context?,attributeSet: AttributeSet?=null):View(context,attributeSet) {
   private val mPaint=Paint(Paint.ANTI_ALIAS_FLAG)
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        mPaint.color= Color.RED
        canvas.drawRect(500f,500f,700f,700f,mPaint)
    }
}