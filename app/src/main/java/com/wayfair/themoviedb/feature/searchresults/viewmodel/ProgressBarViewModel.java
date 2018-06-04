package com.wayfair.themoviedb.feature.searchresults.viewmodel;

import android.support.annotation.Nullable;

import com.wayfair.brickkit.brick.ViewModel;
import com.wayfair.themoviedb.feature.searchresults.datamodel.ProgressBarDataModel;

public class ProgressBarViewModel extends ViewModel<ProgressBarDataModel> {
    //TODO Initial set up in order to set up advance progress with Lottie library.
    public ProgressBarViewModel(@Nullable ProgressBarDataModel dataModel) {
        super(dataModel);
    }
}
