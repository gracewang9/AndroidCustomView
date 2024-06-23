package com.example.myapplication.view

import android.content.Context
import android.graphics.Camera
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.graphics.withSave
import com.example.myapplication.R
import com.example.myapplication.getAvatar
import com.example.myapplication.px

private val BITMAP_SIZE = 200f.px
private val BITMAP_PADDING = 100f.px

class AnimationSetView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val camera = Camera()
    private val bitmap = getAvatar(BITMAP_SIZE.toInt(), resources, R.drawable.bitmap_1)
    var flipRotation = 30f
        set(value) {
            field = value
            invalidate()
        }
    var topFlipAnim = 0f
        set(value) {
            field = value
            invalidate()
        }
    var bottomFlipAnim = 0f
        set(value) {
            field = value
            invalidate()
        }

    init {
//        camera.rotateX(30f)
        camera.setLocation(0f, 0f, -6 * resources.displayMetrics.density)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.withSave {
            canvas.translate(BITMAP_PADDING + BITMAP_SIZE / 2, BITMAP_PADDING + BITMAP_SIZE / 2)
            canvas.rotate(-flipRotation)
            camera.save()
            camera.rotateX(topFlipAnim)
            camera.restore()
            canvas.clipRect(-BITMAP_SIZE, -BITMAP_SIZE, BITMAP_SIZE, 0f)
            canvas.rotate(flipRotation)
            canvas.translate(
                -(BITMAP_PADDING + BITMAP_SIZE / 2),
                -(BITMAP_PADDING + BITMAP_SIZE / 2)
            )
            canvas.drawBitmap(bitmap, BITMAP_PADDING, BITMAP_PADDING, paint)
        }

        canvas.withSave {
            canvas.translate(BITMAP_PADDING + BITMAP_SIZE / 2, BITMAP_PADDING + BITMAP_SIZE / 2)
            canvas.rotate(-flipRotation)
            camera.save()
            camera.rotateX(bottomFlipAnim)
            camera.applyToCanvas(canvas)
            camera.restore()
            canvas.clipRect(-BITMAP_SIZE, 0f, BITMAP_SIZE, BITMAP_SIZE)
            canvas.rotate(flipRotation)
            canvas.translate(
                -(BITMAP_PADDING + BITMAP_SIZE / 2),
                -(BITMAP_PADDING + BITMAP_SIZE / 2)
            )
            canvas.drawBitmap(bitmap, BITMAP_PADDING, BITMAP_PADDING, paint)
        }
    }
}