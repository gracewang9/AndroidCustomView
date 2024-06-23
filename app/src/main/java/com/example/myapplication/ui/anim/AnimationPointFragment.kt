package com.example.myapplication.ui.anim

import android.animation.FloatEvaluator
import android.animation.ObjectAnimator
import android.animation.TypeEvaluator
import android.graphics.PointF
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentAnimaPointBinding
import com.example.myapplication.px

class AnimationPointFragment : Fragment() {
    private var _binding: FragmentAnimaPointBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnimaPointBinding.inflate(inflater, container, false)

        val evaluator = ObjectAnimator.ofObject(binding.pointView, "pointF", PointFEvaluator(),PointF(200f.px,500f.px))
        evaluator.startDelay = 1000
        evaluator.duration = 2000
        evaluator.start()
        return binding.root
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

class PointFEvaluator : TypeEvaluator<PointF> {
    override fun evaluate(fraction: Float, startValue: PointF, endValue: PointF): PointF {
        val startX = startValue.x
        val endX = endValue.x
        val currentX = startX + (endX - startX) * fraction

        val startY = startValue.y
        val endY = endValue.y
        val currentY = startY + (endY - startY) * fraction
        return PointF(currentX, currentY)
    }

}

