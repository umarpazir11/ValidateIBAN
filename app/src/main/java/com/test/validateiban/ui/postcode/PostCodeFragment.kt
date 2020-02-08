package com.test.validateiban.ui.postcode

import android.os.Bundle
import androidx.lifecycle.Observer
import com.test.validateiban.R
import com.test.validateiban.base.BaseFragment
import com.test.validateiban.databinding.PostCodeFragmentBinding

class PostCodeFragment : BaseFragment<PostCodeViewModel,PostCodeFragmentBinding>() {

    companion object {
        fun newInstance() = PostCodeFragment()
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.btnValidate.setOnClickListener{
            viewModel.validatePostCode(binding.editTextCountryCode.text.toString().trim(),
                binding.editTextPostCode.text.toString())
        }

        viewModel.postCodeResponse.observe(this, Observer {
            binding.tvResponse.text = "Code: "+ it.code +"\nPost Code: "+it.data.postCode
        })
    }

    override val layoutRes: Int
        get() = R.layout.post_code_fragment

    override fun getViewModel(): Class<PostCodeViewModel> {
        return PostCodeViewModel::class.java
    }


}
