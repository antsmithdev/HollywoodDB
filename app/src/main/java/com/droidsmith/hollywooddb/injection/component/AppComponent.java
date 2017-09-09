package com.droidsmith.hollywooddb.injection.component;


import android.app.Application;

import com.droidsmith.hollywooddb.App;
import com.droidsmith.hollywooddb.injection.module.ActivityModule;
import com.droidsmith.hollywooddb.injection.module.AppModule;
import com.droidsmith.hollywooddb.injection.module.FragmentModule;
import com.droidsmith.hollywooddb.injection.module.TMDBClientModule;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        ActivityModule.class,
        FragmentModule.class,
        TMDBClientModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }

    void inject(App app);

}
