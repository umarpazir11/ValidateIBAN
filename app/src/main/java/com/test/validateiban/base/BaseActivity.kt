package com.test.validateiban.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.DaggerAppCompatActivity
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * File Description
 *
 * Base for all activities
 * @param D is the layout view binding
 */
 abstract class BaseActivity<D : ViewDataBinding> : DaggerAppCompatActivity(), HasSupportFragmentInjector {

    lateinit var binding: D

    @get:LayoutRes
    protected abstract val layoutRes: Int

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutRes)


    }
    override fun supportFragmentInjector() = dispatchingAndroidInjector
}

