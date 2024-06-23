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

private val XFERMODE = PorterDuffXfermode(PorterDuff.Mode.ADD)
private val WITH=250f.px
class XfermodeView(context: Context?, attrs: AttributeSet?=null) : View(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bounds = RectF(150f.px, 50f.px, 300f.px, 200f.px)
    private val circleBitmap =
        Bitmap.createBitmap(WITH.toInt(), WITH.toInt(), Bitmap.Config.ARGB_8888)
    private val squareBitmap =
        Bitmap.createBitmap(WITH.toInt(), WITH.toInt(), Bitmap.Config.ARGB_8888)

    init {
        val canvas = Canvas(circleBitmap)
        paint.color = Color.parseColor("#D81B60")
        canvas.drawOval(50f.px, 0f.px, 150f.px, 100f.px, paint)
        paint.color = Color.parseColor("#2196F3")
        canvas.setBitmap(squareBitmap)
        canvas.drawRect(0f.px, 50f.px, 100f.px, 150f.px, paint)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val count = canvas.saveLayer(bounds, null)
        canvas.drawBitmap(circleBitmap, 150f.px, 50f.px, paint)
        paint.xfermode = XFERMODE
        canvas.drawBitmap(squareBitmap,150f.px,50f.px,paint)
        paint.xfermode = null
        canvas.restoreToCount(count)
    }

}