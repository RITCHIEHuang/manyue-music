/*
 * Copyright (C) 2015 Naman Dwivedi
 *
 * Licensed under the GNU General Public License v3
 *
 * This is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 */

package com.wm.remusic.uitl;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public final class UserPreferencesUtil {

    public static final String USER_NAME = "user_name";
    public static final String PASSWORD = "password";


    private static UserPreferencesUtil sInstance;

    private static SharedPreferences mPreferences;

    private UserPreferencesUtil(final Context context) {
        mPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static UserPreferencesUtil getInstance(final Context context) {
        if (sInstance == null) {
            sInstance = new UserPreferencesUtil(context.getApplicationContext());
        }
        return sInstance;
    }

    public String getUsername(){
        return mPreferences.getString(USER_NAME, "");
    }


    public String getPassword(){
        return mPreferences.getString(PASSWORD, "");
    }


    public void setUserName(String userName){
        final SharedPreferences.Editor editor = mPreferences.edit();
        editor.putString(USER_NAME, userName);
        editor.apply();
    }

    public void setPassword(String password){
        final SharedPreferences.Editor editor = mPreferences.edit();
        editor.putString(PASSWORD, password);
        editor.apply();
    }

}