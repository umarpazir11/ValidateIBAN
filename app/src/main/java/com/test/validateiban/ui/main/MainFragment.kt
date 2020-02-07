package com.test.validateiban.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.validateiban.R
import com.test.validateiban.base.BaseFragment
import com.test.validateiban.databinding.MainFragmentBinding

class MainFragment : BaseFragment<MainViewModel, MainFragmentBinding>() {

    companion object {
        fun newInstance() = MainFragment()
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getBis()
    }

    override val layoutRes: Int
        get() = R.layout.main_fragment

    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

}
