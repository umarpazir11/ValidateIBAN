package com.test.validateiban.ui.main

import android.os.Bundle
import com.test.validateiban.R
import com.test.validateiban.base.BaseFragment
import com.test.validateiban.databinding.MainFragmentBinding

class MainFragment : BaseFragment<MainViewModel, MainFragmentBinding>() {
    
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.fetchBis()
    }

    override val layoutRes: Int
        get() = R.layout.main_fragment

    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

}
