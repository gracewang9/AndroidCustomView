package com.example.myapplication.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.myapplication.R
import com.example.myapplication.getAvatar

class ShaderView(context: Context?, attrs: AttributeSet?=null) : View(context, attrs) {
    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val linearGradient =
        LinearGradient(50f, 50f, 100f, 100f, Color.BLUE, Color.GREEN, Shader.TileMode.MIRROR)
    private val sweepGradient = SweepGradient(0f, 700f, Color.RED, Color.GREEN)
    private val radialGradient = RadialGradient(
        500f, 200f, 200f,
        Color.parseColor("#E91E63"), Color.parseColor("#2196F3"), Shader.TileMode.CLAMP
    )

    private val bitmap = BitmapFactory.decodeResource(resources, R.drawable.bitmap_1)

    private val bitmapGradient = BitmapShader(
        bitmap,//getAvatar(500,resources,R.drawable.bitmap_1),
        Shader.TileMode.CLAMP,
        Shader.TileMode.CLAMP
    )

    // 第一个 Shader：头像的 Bitmap
    private val bitmap1 = BitmapFactory.decodeResource(resources, R.drawable.bitmap)
    private val shader1 = BitmapShader(bitmap1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)

    // 第二个 Shader：从上到下的线性渐变（由透明到黑色）
    private val bitmap2 = BitmapFactory.decodeResource(resources, R.drawable.bitmap_1)
    private val shader2 = BitmapShader(bitmap2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)

    // ComposeShader：结合两个 Shader
    private val composeShader = ComposeShader(shader1, shader2, PorterDuff.Mode.DST_IN)

//    init {
//        setLayerType(LAYER_TYPE_SOFTWARE, mPaint)
//    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.translate(300f, 100f)//移动画布
        mPaint.shader = linearGradient
        canvas.drawCircle(0f, 200f, 200f, mPaint)
        mPaint.shader = radialGradient
        canvas.drawCircle(500f, 200f, 200f, mPaint)
        mPaint.shader = sweepGradient
        canvas.drawCircle(0f, 700f, 200f, mPaint)
        mPaint.shader = bitmapGradient
        canvas.drawCircle(500f, 700f, 200f, mPaint)
//        mPaint.shader = composeShader
//        canvas.drawCircle(0f, 1200f, 200f, mPaint)
        canvas.drawBitmap(getAvatar(400, resources, R.drawable.bitmap_1), 250f, 1000f, mPaint)

    }
}