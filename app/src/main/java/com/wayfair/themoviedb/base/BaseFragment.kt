package com.pubbix.base

import android.content.Context
import com.wayfair.brickkit.BrickFragment
import com.wayfair.themoviedb.di.Injector
import javax.inject.Inject

abstract class BaseFragment<P : Any>  : BrickFragment(){

    @Inject
    protected lateinit var presenter: P

    override fun onAttach(context: Context?) {
        Injector.inject(this)
        super.onAttach(context)
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (!activity!!.isChangingConfigurations) {
            Injector.clearComponent(this)
        }
    }
}
