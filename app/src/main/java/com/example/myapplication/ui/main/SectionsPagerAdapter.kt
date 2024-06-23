package com.example.myapplication.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.myapplication.R
import com.example.myapplication.ui.PorterDuffFragment
import com.example.myapplication.ui.anim.AnimationFragment
import com.example.myapplication.ui.anim.AnimationPointFragment
import com.example.myapplication.ui.anim.AnimationSetFragment
import com.example.myapplication.ui.camera.CameraFragment
import com.example.myapplication.ui.dashboard.DashboardFragment
import com.example.myapplication.ui.drawable.DrawableFragment
import com.example.myapplication.ui.home.HomeFragment
import com.example.myapplication.ui.layout.LayoutFragment
import com.example.myapplication.ui.maskfilter.MaskFilterFragment
import com.example.myapplication.ui.material.MaterialEditTextFragment
import com.example.myapplication.ui.multiple.MultipleFragment
import com.example.myapplication.ui.multiple.StaticLayoutFragment
import com.example.myapplication.ui.pie.PieFragment
import com.example.myapplication.ui.shader.ShaderFragment
import com.example.myapplication.ui.xfermode.XfermodeFragment

private val TAB_TITLES = arrayOf(
    R.string.tab_text_layout,
    R.string.tab_text_material,
    R.string.tab_text_drawable,
    R.string.tab_text_animaPoint,
    R.string.tab_text_animaset,
    R.string.tab_text_anima,
    R.string.tab_text_camera,
    R.string.tab_text_static_layout,
    R.string.tab_text_multiple_linear,
    R.string.tab_text_maskFilter,
    R.string.tab_text_porter,
    R.string.tab_text_home,
    R.string.tab_text_dashboard,
    R.string.tab_text_pie,
    R.string.tab_text_xfermode,
    R.string.tab_text_shader,
    R.string.tab_text_1,
    R.string.tab_text_2
)
private val fragments = arrayOf(
    LayoutFragment(),
    MaterialEditTextFragment(),
    DrawableFragment(),
    AnimationPointFragment(),
    AnimationSetFragment(),
    AnimationFragment(),
    CameraFragment(),
    StaticLayoutFragment(),
    MultipleFragment(),
    MaskFilterFragment(),
    PorterDuffFragment(),
    HomeFragment(),
    DashboardFragment(),
    PieFragment(),
    XfermodeFragment(),
    ShaderFragment(),
    PlaceholderFragment.newInstance(0),
    PlaceholderFragment.newInstance(1)
)

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return fragments.size
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getPageTitle(position: Int): CharSequence {
        return context.resources.getString(TAB_TITLES[position])
    }
}