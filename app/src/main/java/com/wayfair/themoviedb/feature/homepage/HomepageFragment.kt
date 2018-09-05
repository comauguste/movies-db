package com.wayfair.themoviedb.feature.homepage

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.SearchView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pubbix.base.BaseFragment
import com.wayfair.themoviedb.R
import kotlinx.android.synthetic.main.fragment_homepage.*
import java.util.*

class HomepageFragment : BaseFragment<HomepagePresenter>(), HomepageContract.View {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_homepage, container, false)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        presenter.attachView(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(s: String): Boolean {
                presenter.search(s)
                return true
            }

            override fun onQueryTextChange(s: String): Boolean {
                return false
            }
        })
    }

    override fun onDetach() {
        super.onDetach()
        presenter.detachView()
    }

    override fun showMessage(message: String) {

    }

    companion object {
        fun newInstance(): Fragment {
            val bundle = Bundle()
            bundle.putString("instance_id", UUID.randomUUID().toString())
            val fragment = HomepageFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}
