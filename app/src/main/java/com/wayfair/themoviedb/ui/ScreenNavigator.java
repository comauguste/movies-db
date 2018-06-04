package com.wayfair.themoviedb.ui;

import android.support.v4.app.Fragment;

public interface ScreenNavigator {

    //void changeScreen(BaseFragment fragment);

    void changeScreen(Fragment fragment);

    boolean pop();
}
