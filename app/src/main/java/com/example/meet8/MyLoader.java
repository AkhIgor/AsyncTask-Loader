package com.example.meet8;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

public class MyLoader extends AsyncTaskLoader<Integer> {

    MyLoader(@NonNull Context context) {
        super(context);
    }

    @Nullable
    @Override
    public Integer loadInBackground() {
        return R.color.colorPrimaryDark;
    }
}