package com.wayfair.themoviedb.feature.detail

import com.wayfair.themoviedb.base.BaseRouter
import com.wayfair.themoviedb.base.BaseView

interface DetailContract {
    interface View : BaseView

    interface Router : BaseRouter

    interface Presenter

    interface Interactor
}
