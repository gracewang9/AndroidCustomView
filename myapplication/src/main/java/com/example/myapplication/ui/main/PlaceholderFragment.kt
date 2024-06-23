package com.example.myapplication.ui.main

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.TestView
import com.example.myapplication.databinding.FragmentMainBinding

/**
 * A placeholder fragment containing a simple view.
 */
class PlaceholderFragment : Fragment() {

    private lateinit var pageViewModel: PageViewModel
    private var _binding: FragmentMainBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var sectionNumber: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProvider(this)[PageViewModel::class.java]
        sectionNumber = arguments?.getInt(ARG_SECTION_NUMBER) ?: 1
//            .apply {
//            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val root = binding.root
        pageViewModel.getItemView(this.requireContext())

//        val textView: TextView = binding.sectionLabel
//        pageViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
//        root.addView(TextView(this.context).also { textView ->
//            pageViewModel.text.observe(viewLifecycleOwner, Observer {
//                textView.text = it
//            })
//        })
        val frameLayout = ConstraintLayout(this.requireContext())
//        frameLayout.setBackgroundColor(Color.WHITE)
        frameLayout.addView(pageViewModel.views[sectionNumber])
        root.addView(frameLayout)
        return root

    }

    override fun onHiddenChanged(hidden: Boolean) {
        Log.d("fragmect","onHiddenChanged $hidden")

    }

    override fun onStart() {
        super.onStart()
        Log.d("fragmect","onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d("fragmect","onPause")
    }



    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"


        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}