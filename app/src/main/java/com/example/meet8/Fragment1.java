package com.example.meet8;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment1 extends Fragment implements LoaderManager.LoaderCallbacks<Integer> {

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment1, container, false);
        getLoaderManager().initLoader(0, null, this).forceLoad();
        return view;
    }

    @NonNull
    @Override
    public Loader<Integer> onCreateLoader(int id, Bundle bundle) {
        return new MyLoader(view.getContext());
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Integer> loader, Integer color) {
        int Color = ContextCompat.getColor(view.getContext(), color);
        view.setBackgroundColor(Color);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Integer> loader) {

    }
}
