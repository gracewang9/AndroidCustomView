package com.example.myapplication.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class PathView(context:Context?,attr:AttributeSet?=null):View(context,attr) {
    private val mPaint=Paint()
    private val mPath= Path()
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        mPaint.style=Paint.Style.STROKE
        mPath.moveTo(100f,0f)
        mPath.lineTo(100f,500f)
        mPath.lineTo(500f,500f)
//        mPath.addArc(100f,600f,300f,800f,60f,300f)
        mPath.arcTo(100f,600f,300f,800f,60f,180f,true)
        mPath.close()//关闭
        canvas.drawPath(mPath,mPaint)

        mPaint.style=Paint.Style.FILL
        mPath.addCircle(500f,800f,200f,Path.Direction.CW)
        mPath.addCircle(700f,800f,200f,Path.Direction.CW)
        mPath.fillType=Path.FillType.EVEN_ODD
        canvas.drawPath(mPath,mPaint)
    }
}