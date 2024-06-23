package com.example.myapplication.ui.anim

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentAnimasetBinding

class AnimationSetFragment : Fragment() {
    private var _binding: FragmentAnimasetBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnimasetBinding.inflate(inflater, container, false)

        val bottomAnima = ObjectAnimator.ofFloat(binding.viewAnima, "bottomFlipAnim", 60f)
        bottomAnima.startDelay = 500
        bottomAnima.duration = 500

        val flipRotation = ObjectAnimator.ofFloat(binding.viewAnima, "flipRotation", 270f)
        flipRotation.startDelay = 200
        flipRotation.duration = 1000

        val topAnima = ObjectAnimator.ofFloat(binding.viewAnima, "topFlipAnim", -60f)
        topAnima.startDelay = 200
        topAnima.duration = 1500
        val animatorSet = AnimatorSet()
        animatorSet.playSequentially(topAnima, bottomAnima, flipRotation)
        animatorSet.start()
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}