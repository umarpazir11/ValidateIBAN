package com.test.validateiban.ui.routingcode

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.validateiban.R
import com.test.validateiban.base.BaseFragment
import com.test.validateiban.databinding.FragmentRoutingCodesBinding
import com.test.validateiban.ui.routingcode.model.Bic


class SearchRoutingCodeFragment : BaseFragment<SearchRoutingCodeViewModel, FragmentRoutingCodesBinding>(),
    RoutingCodesRecyclerViewAdapter.RoutingCodesItemListener {

    companion object {
        fun newInstance() = SearchRoutingCodeFragment()
    }

    private lateinit var adapter: RoutingCodesRecyclerViewAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.btnSearch.setOnClickListener {
            if(binding.editTextRoutingCode.text.trim().toString().isNotEmpty())
                viewModel.fetchBics(binding.editTextRoutingCode.text.trim().toString())
            else
                Toast.makeText(requireContext(),getString(R.string.validation_routing_text),Toast.LENGTH_LONG).show()
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val dividerItemDecoration = DividerItemDecoration(binding.recyclerView.getContext(),DividerItemDecoration.VERTICAL)
        binding.recyclerView.addItemDecoration(dividerItemDecoration)
        viewModel.bankData.observe(viewLifecycleOwner, Observer {
            adapter = RoutingCodesRecyclerViewAdapter(this)
            binding.recyclerView.adapter = adapter
            adapter.updateBicList(it!!)

        })
    }

    override val layoutRes: Int
        get() = R.layout.fragment_routing_codes

    override fun getViewModel(): Class<SearchRoutingCodeViewModel> {
        return SearchRoutingCodeViewModel::class.java
    }

    override fun onRoutingCodeItemClick(bic: Bic) {
        Log.i("Text",bic.bicCode)
    }

}
