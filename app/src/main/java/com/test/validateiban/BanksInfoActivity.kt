package com.test.validateiban

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import com.test.validateiban.base.BaseActivity
import com.test.validateiban.databinding.ActivityBanksInfoBinding
import com.test.validateiban.ui.SectionsPagerAdapter
import dagger.android.AndroidInjector

class BanksInfoActivity : BaseActivity<ActivityBanksInfoBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sectionsPagerAdapter = SectionsPagerAdapter(
            this,
            supportFragmentManager
        )
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)

    }

    override val layoutRes: Int
        get() = R.layout.activity_banks_info
}