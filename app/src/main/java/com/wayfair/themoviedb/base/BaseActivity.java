package com.wayfair.themoviedb.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.wayfair.themoviedb.R;
import com.wayfair.themoviedb.di.Injector;
import com.wayfair.themoviedb.di.ScreenInjector;
import com.wayfair.themoviedb.lifecycle.ActivityLifecycleTask;
import com.wayfair.themoviedb.ui.ActivityViewInterceptor;
import com.wayfair.themoviedb.ui.ScreenNavigator;
import com.wayfair.themoviedb.ui.ScreenProvider;

import java.util.Set;
import java.util.UUID;

import javax.inject.Inject;

public abstract class BaseActivity extends AppCompatActivity implements ScreenProvider {

    private static final String INSTANCE_ID_KEY = "instance_id";

    @Inject
    ScreenInjector screenInjector;
    @Inject
    ScreenNavigator screenNavigator;
    @Inject
    ActivityViewInterceptor activityViewInterceptor;
    @Inject
    Set<ActivityLifecycleTask> activityLifecycleTasks;

    private String instanceId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            instanceId = savedInstanceState.getString(INSTANCE_ID_KEY);
        } else {
            instanceId = UUID.randomUUID().toString();
        }
        Injector.inject(this);
        super.onCreate(savedInstanceState);

        activityViewInterceptor.setContentView(this, layoutRes());
        ViewGroup screenContainer = findViewById(R.id.screen_container);
        if (screenContainer == null) {
            throw new NullPointerException("Activity must have a view with id: screen_container");
        }

        for (ActivityLifecycleTask task : activityLifecycleTasks) {
            task.onCreate(this);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        for (ActivityLifecycleTask task : activityLifecycleTasks) {
            task.onStart(this);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        for (ActivityLifecycleTask task : activityLifecycleTasks) {
            task.onResume(this);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        for (ActivityLifecycleTask task : activityLifecycleTasks) {
            task.onPause(this);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        for (ActivityLifecycleTask task : activityLifecycleTasks) {
            task.onStop(this);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(INSTANCE_ID_KEY, instanceId);
    }

    @Override
    public void onBackPressed() {
        if (!screenNavigator.pop()) {
            super.onBackPressed();
        }
    }

    @LayoutRes
    protected abstract int layoutRes();

    public String getInstanceId() {
        return instanceId;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            Injector.clearComponent(this);
        }
        activityViewInterceptor.clear();
        for (ActivityLifecycleTask task : activityLifecycleTasks) {
            task.onDestroy(this);
        }
    }

    public ScreenInjector getScreenInjector() {
        return screenInjector;
    }
}
