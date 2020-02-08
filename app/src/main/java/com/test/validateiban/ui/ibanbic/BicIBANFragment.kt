package com.test.validateiban.ui.ibanbic

import android.os.Bundle
import androidx.lifecycle.Observer
import com.test.validateiban.R
import com.test.validateiban.base.BaseFragment
import com.test.validateiban.databinding.BicIbanFragmentBinding

class BicIBANFragment : BaseFragment<BicIbanViewModel, BicIbanFragmentBinding>() {

    companion object {
        fun newInstance() = BicIBANFragment()
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.btnValidate.setOnClickListener{
            if(binding.editText.text.toString().trim().length>11) {
                viewModel.validateIBAN(binding.editText.text.toString().trim())
            }else {
                viewModel.validateBic(binding.editText.text.toString().trim())
            }
        }

        viewModel.ibanResponse.observe(this, Observer {
            if(binding.editText.text.toString().trim().length>11) {
                binding.tvResponse.text = "Code: " + it.code + "\nIBAN: " + it.data.iban
            }else{
                binding.tvResponse.text = "Code: " + it.code + "\nBIC: " + it.data.bic
            }
        })
    }

    override val layoutRes: Int
        get() = R.layout.bic_iban_fragment

    override fun getViewModel(): Class<BicIbanViewModel> {
        return BicIbanViewModel::class.java
    }

}
