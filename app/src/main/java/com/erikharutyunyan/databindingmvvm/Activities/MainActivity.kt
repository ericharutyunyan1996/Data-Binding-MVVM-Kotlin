package com.erikharutyunyan.databindingmvvm.Activities

import android.os.Bundle
import com.erikharutyunyan.databindingmvvm.Fragments.MainFragment
import com.erikharutyunyan.databindingmvvm.R

class MainActivity : BaseActivity() {
    private val mainFragment by lazy { MainFragment.newInstance() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openFragment(mainFragment, false)
    }
}
