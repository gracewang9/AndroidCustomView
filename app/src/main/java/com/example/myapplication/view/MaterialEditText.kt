package com.example.myapplication.view

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import com.example.myapplication.R
import com.example.myapplication.dp

private val HORIZONTAL_OFFSET = 5.dp
private val VERTICAL_OFFSET = 23.dp
private val TEXT_SIZE = 12.dp
private val TEXT_MARGIN = 8.dp
private val EXTRA_VERTICAL_OFFSET = 16.dp

class MaterialEditText(context: Context, attributeSet: AttributeSet) :
    AppCompatEditText(context, attributeSet) {
    private var floatingLabelShow = false
    var userLabelColor = Color.BLACK
        set(value) {
            field = value
            invalidate()
        }
    var userLabelSize = 0.dp
        set(value) {
            field = value
            invalidate()
        }
    var useFloatingLabel = false
        set(value) {
            if (field != value) {
                field = value
                if (field) {
                    setPadding(
                        paddingLeft,
                        (paddingTop + TEXT_SIZE + TEXT_MARGIN).toInt(),
                        paddingRight,
                        paddingBottom
                    )
                } else {
                    setPadding(
                        paddingLeft,
                        (paddingTop - TEXT_SIZE - TEXT_MARGIN).toInt(),
                        paddingRight,
                        paddingBottom
                    )
                }
            }
        }
    var floatingLabelFraction: Float = 0.dp
        set(value) {
            field = value
            invalidate()
        }
    private val animator by lazy {
        ObjectAnimator.ofFloat(this, "floatingLabelFraction", 0f, 1f)
    }

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        val typeArray = context.obtainStyledAttributes(attributeSet, R.styleable.MaterialEditText)
        useFloatingLabel = typeArray.getBoolean(R.styleable.MaterialEditText_useFloatingLabel, true)
        userLabelColor =
            typeArray.getColor(R.styleable.MaterialEditText_useLabelTextColor, Color.BLACK)
        userLabelSize =
            typeArray.getDimension(R.styleable.MaterialEditText_useLabelTextSize, TEXT_SIZE)
        typeArray.recycle()

        paint.textSize = userLabelSize
        paint.color = userLabelColor

    }

    override fun onTextChanged(
        text: CharSequence?,
        start: Int,
        lengthBefore: Int,
        lengthAfter: Int
    ) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter)
        if (floatingLabelShow && text.isNullOrEmpty() && useFloatingLabel) {
            floatingLabelShow = false
            animator.reverse()
        } else if (!floatingLabelShow && !text.isNullOrEmpty() && useFloatingLabel) {
            floatingLabelShow = true
            animator.start()
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.alpha = (floatingLabelFraction * 0xff).toInt()
        val currentVerticalValue =
            VERTICAL_OFFSET + EXTRA_VERTICAL_OFFSET * (1 - floatingLabelFraction)
        canvas.drawText(hint.toString(), HORIZONTAL_OFFSET, currentVerticalValue, paint)

    }
}