package com.test.validateiban.ui.routingcode

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.validateiban.R
import com.test.validateiban.base.BaseFragment
import com.test.validateiban.databinding.MainFragmentBinding
import com.test.validateiban.ui.routingcode.model.Bic

class SearchRoutingCodeFragment : BaseFragment<SearchRoutingCodeViewModel, MainFragmentBinding>(),
    RoutingCodesRecyclerViewAdapter.RoutingCodesItemListener {

    companion object {
        fun newInstance() = SearchRoutingCodeFragment()
    }

    private lateinit var adapter: RoutingCodesRecyclerViewAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.editTextRoutingCode.setText("70020270")
        binding.btnSearch.setOnClickListener {
            viewModel.fetchBics(binding.editTextRoutingCode.text.toString())
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())


        viewModel.bankData.observe(this, Observer {
            adapter = RoutingCodesRecyclerViewAdapter(this)
            binding.recyclerView.adapter = adapter
            adapter.updateBicList(it!!)

        })
    }

    override val layoutRes: Int
        get() = R.layout.main_fragment

    override fun getViewModel(): Class<SearchRoutingCodeViewModel> {
        return SearchRoutingCodeViewModel::class.java
    }

    override fun onRoutingCodeItemClick(bic: Bic) {
        Log.i("Text",bic.bicCode)
    }

}
