package com.example.bookplace.data.pref;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.bookplace.di.annotation.AppContext;

import javax.inject.Inject;

public class Pref implements IPref{
    private static final String PREF_NAME = "bookplace";
    private static final String SHOW_INTRO = "SHOW_INTRO";
    private SharedPreferences mPref;

    @Inject
    public Pref(@AppContext Context context) {
        mPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE) ;
    }

    @Override
    public boolean getShowIntroPref() {
        return mPref.getBoolean(SHOW_INTRO, true);
    }

    @Override
    public void setShowIntroPref(boolean showIntro) {
        mPref.edit()
                .putBoolean(SHOW_INTRO, showIntro)
                .apply();
    }
}
