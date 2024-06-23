package com.example.myapplication.ui.material

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentMaterialEditTextBinding

class MaterialEditTextFragment : Fragment() {
    private var _binding: FragmentMaterialEditTextBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMaterialEditTextBinding.inflate(inflater, container, false)
//        binding.materialEdit.useFloatingLabel=true
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}