package com.example.myapplication.view

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Camera
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.example.myapplication.R
import com.example.myapplication.dp
import com.example.myapplication.getAvatar
import com.example.myapplication.px

private val BITMAP_SIZE = 200f.px
private val BITMAP_PADDING = 100f.px

class CameraView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val camera = Camera()
    private val flipRotation=30f
    private val bitmap = getAvatar(BITMAP_SIZE.toInt(), resources, R.drawable.bitmap_1)

    init {
        camera.rotateX(30f)
        camera.setLocation(0f, 0f, -6 * resources.displayMetrics.density)
    }

    override fun onDraw(canvas: Canvas) {
        canvas.save()
        canvas.translate(BITMAP_PADDING + BITMAP_SIZE / 2, BITMAP_PADDING + BITMAP_SIZE / 2)
        canvas.rotate(-flipRotation)
        canvas.clipRect(-BITMAP_SIZE, -BITMAP_SIZE, BITMAP_SIZE, 0f)
        canvas.rotate(flipRotation)
        canvas.translate(-(BITMAP_PADDING + BITMAP_SIZE / 2), -(BITMAP_PADDING + BITMAP_SIZE / 2))
        canvas.drawBitmap(bitmap, BITMAP_PADDING, BITMAP_PADDING, paint)
        canvas.restore()

        canvas.save()
        canvas.translate(BITMAP_PADDING + BITMAP_SIZE / 2, BITMAP_PADDING + BITMAP_SIZE / 2)
        canvas.rotate(-flipRotation)
        camera.applyToCanvas(canvas)
        canvas.clipRect(-BITMAP_SIZE , 0f, BITMAP_SIZE , BITMAP_SIZE )
        canvas.rotate(flipRotation)
        canvas.translate(-(BITMAP_PADDING + BITMAP_SIZE / 2), -(BITMAP_PADDING + BITMAP_SIZE / 2))
        canvas.drawBitmap(bitmap, BITMAP_PADDING, BITMAP_PADDING, paint)
        canvas.restore()
    }
}