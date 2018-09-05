package com.wayfair.themoviedb.feature.detail

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pubbix.base.BaseFragment
import java.util.*

class DetailFragment : BaseFragment<DetailPresenter>(), DetailContract.View {

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun showMessage(message: String) {

    }

    companion object {


        fun newInstance(): Fragment {
            val bundle = Bundle()
            bundle.putString("instance_id", UUID.randomUUID().toString())
            val fragment = DetailFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}
