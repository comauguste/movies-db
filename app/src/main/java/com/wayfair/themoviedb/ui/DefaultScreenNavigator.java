package com.wayfair.themoviedb.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.wayfair.themoviedb.R;
import com.wayfair.themoviedb.di.ActivityScope;
import com.wayfair.themoviedb.lifecycle.ActivityLifecycleTask;

import javax.inject.Inject;

@ActivityScope
public class DefaultScreenNavigator extends ActivityLifecycleTask implements ScreenNavigator {

    private FragmentManager fragmentManager;

    @Inject
    DefaultScreenNavigator() {

    }

    @Override
    public void onCreate(AppCompatActivity activity) {
        init(activity.getSupportFragmentManager(), ((ScreenProvider) activity).initialScreen());
    }

    void init(FragmentManager fragmentManager, Fragment rootScreen) {
        this.fragmentManager = fragmentManager;
        if (fragmentManager.getFragments().size() == 0) {
            fragmentManager.beginTransaction()
                    .replace(R.id.screen_container, rootScreen)
                    .commit();
        }
    }

    @Override
    public void changeScreen(Fragment fragment) {
        if (fragmentManager != null) {
            fragmentManager.beginTransaction()
                    .replace(R.id.screen_container, fragment)
                    .addToBackStack(null)
                    .commit();
        }
    }

    @Override
    public boolean pop() {
        return fragmentManager != null && fragmentManager.popBackStackImmediate();
    }

    @Override
    public void onDestroy(AppCompatActivity activity) {
        fragmentManager = null;
    }
}
