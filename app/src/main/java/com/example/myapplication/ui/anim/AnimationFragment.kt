package com.example.myapplication.ui.anim

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentAnimaBinding
import com.example.myapplication.view.evaluator.HsvEvaluator

class AnimationFragment : Fragment() {
    private var _binding: FragmentAnimaBinding? = null
    private val binding: FragmentAnimaBinding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnimaBinding.inflate(inflater, container, false)
        val root = binding.root
        val imageView = binding.imageView
//        imageView.animate().apply {
//            duration=5000
//            startDelay=200
//            this.translationXBy(270f)
//            this.rotationBy(180f)
//        }

//        val objectAnima=ObjectAnimator.ofFloat(imageView,"widthImage",500f)
//        objectAnima.duration=2000
//        objectAnima.startDelay=100
//        objectAnima.start()

        val objectAnimator = ObjectAnimator.ofArgb(imageView, "color", Color.RED,Color.GREEN)
        objectAnimator.duration=2000
        objectAnimator.startDelay=100
//        objectAnimator.setEvaluator(HsvEvaluator())
        objectAnimator.start()
        return root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}