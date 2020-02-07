package com.test.validateiban

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.internal.NavigationMenu
import com.test.validateiban.base.BaseActivity
import com.test.validateiban.databinding.MainActivityBinding

class MainActivity : BaseActivity<MainActivityBinding>() {

    //private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //navController = Navigation.findNavController(this, R.id.nav_menu)

    }

    override val layoutRes: Int
        get() = R.layout.main_activity

}
