package com.example.daggerexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ShareModule {
    private Context mContext;

    public ShareModule(Context mContext) {
        this.mContext = mContext;
    }

    @Singleton
    @Provides
    public Context getmContext() {
        return mContext;
    }

    @Singleton
    @Provides
    public SharedPreferences provideSharePreferences(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
}
