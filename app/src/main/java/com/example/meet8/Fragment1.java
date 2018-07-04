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

/**
 *  Данный класс отвечает за раскрашивание фрагмента в случайный цвет. В нем
 *  запускается класс MyLoader, в котором происходит выбор цвета. Далее в методе onLoadFinished
 *  происходит окрашивание фона фрагмента.
 */

public class Fragment1 extends Fragment implements LoaderManager.LoaderCallbacks<Integer> {

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment1, container, false); //инфлэйтим фрагмент и присваиваем Виду
        getLoaderManager().initLoader(0, null, this).forceLoad(); //
        return view; //возвращаем Вид
    }

    @NonNull
    @Override
    public Loader<Integer> onCreateLoader(int id, Bundle bundle) {
        return new MyLoader(getActivity());
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Integer> loader, Integer color) {

        int Color = ContextCompat.getColor(getActivity(), color); //установка рандомного цвета
        view.setBackgroundColor(Color); //окрашивание фона в цвет
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Integer> loader) {

    }
}
