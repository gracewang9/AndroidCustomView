package com.example.myapplication.view.evaluator

import android.animation.TypeEvaluator
import android.graphics.Color

class HsvEvaluator : TypeEvaluator<Int> {
    private val startHsv = ArrayList<Float>(3)
    private var endHsv = ArrayList<Float>(3)
    private val outHsv = ArrayList<Float>(3)

    override fun evaluate(fraction: Float, startValue: Int, endValue: Int): Int {
        Color.colorToHSV(startValue, startHsv.toFloatArray())
        Color.colorToHSV(endValue, endHsv.toFloatArray())

        if (endHsv[0] - startHsv[0] > 180) {
            endHsv[0] -= 360f
        } else if (endHsv[0] - startHsv[0] < -180) {
            endHsv[0] += 360f
        }
        outHsv[0] = startHsv[0] + (endHsv[0] - startHsv[0]) * fraction
        if (outHsv[0] > 360) {
            outHsv[0] -= 360f
        } else if (outHsv[0] < 0) {
            outHsv[0] += 360f
        }
        outHsv[1] = startHsv[1] + (endHsv[1] - startHsv[1]) * fraction
        outHsv[2] = startHsv[2] + (endHsv[2] - startHsv[2]) * fraction
        val alpha = (startValue shr (24 + (endValue shr 24 - startValue shr 24) * fraction).toInt())
        return Color.HSVToColor(alpha, outHsv.toFloatArray())
    }
}