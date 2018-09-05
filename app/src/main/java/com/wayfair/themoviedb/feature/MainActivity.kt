package com.wayfair.themoviedb.feature

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.WindowManager
import com.wayfair.themoviedb.R
import com.wayfair.themoviedb.base.BaseActivity
import com.wayfair.themoviedb.feature.homepage.HomepageFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

    override fun layoutRes(): Int {
        return R.layout.activity_main
    }

    override fun initialScreen(): Fragment {
        return HomepageFragment.newInstance()
    }
}
