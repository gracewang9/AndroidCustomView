package com.example.myapplication

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.TypedValue
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes

/**
 * 像素转换
 */
val Float.px
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this,
        Resources.getSystem().displayMetrics
    )
val Int.dp
    get() = this.toFloat().px

/**
 * 图片压缩
 */
fun getAvatar(width: Int, resources: Resources, @DrawableRes avatar: Int): Bitmap {
    val option = BitmapFactory.Options()
    option.inJustDecodeBounds = true
    BitmapFactory.decodeResource(resources, avatar, option)
    option.inJustDecodeBounds = false
    option.inDensity = option.outWidth
    option.inTargetDensity = width
    return BitmapFactory.decodeResource(resources, avatar, option)
}