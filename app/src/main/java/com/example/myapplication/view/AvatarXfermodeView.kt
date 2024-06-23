package com.example.myapplication.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.myapplication.R
import com.example.myapplication.getAvatar
import com.example.myapplication.px

private val IMAGE_WIDTH = 200f.px
private val IMAGE_PADDING = 20f.px

class AvatarXfermodeView(context: Context?, attrs: AttributeSet?=null) :
    View(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bounds =
        RectF(IMAGE_PADDING, IMAGE_PADDING, IMAGE_WIDTH + IMAGE_PADDING, IMAGE_WIDTH + IMAGE_PADDING)
    private val xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val count = canvas.saveLayer(bounds, null)
        canvas.drawOval(
            IMAGE_PADDING,
            IMAGE_PADDING,
            IMAGE_WIDTH + IMAGE_PADDING,
            IMAGE_WIDTH + IMAGE_PADDING,
            paint
        )
        paint.xfermode = xfermode
        canvas.drawBitmap(
            getAvatar(IMAGE_WIDTH.toInt(), resources, R.drawable.image),
            IMAGE_PADDING,
            IMAGE_PADDING,
            paint
        )
        paint.xfermode = null
        canvas.restoreToCount(count)
    }

}