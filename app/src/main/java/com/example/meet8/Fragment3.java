package com.example.meet8;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс служит для вывод чисел в 3-й фрагмент. В методе onCreateView инициализируется работа класса
 * MyLoader3. Этот класс выдает некоторое число и засовывает его в объект типа Message, далее в
 * классе LocalHandler происходит получение числа из этого Message, которое помещается с список.
 */

public class Fragment3 extends Fragment implements LoaderManager.LoaderCallbacks<Void> {

    protected static List<String> strings = new ArrayList<>();
    protected static RecyclerView.Adapter adapter;

    private LocalHandler handler;

    @SuppressLint("HandlerLeak")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3, container, false); //инфлэйтим вид 3 фрагмента
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        adapter = new ViewAdapter(strings); //объявление адаптера и его установка в Ресайклер
        recyclerView.setAdapter(adapter);

        handler = new LocalHandler(); //объявление Хандлера
        getLoaderManager().initLoader(1, null, this).forceLoad(); //вызов onCreateLoader
        return view;
    }

    //Имплементация методов

    @NonNull
    @Override
    public Loader<Void> onCreateLoader(int id, Bundle args) {
        return new MyLoader3(getContext(), handler); //Запуск
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Void> loader, Void data) {

    }

    @Override
    public void onLoaderReset(@NonNull Loader<Void> loader) {

    }
}

class LocalHandler extends Handler { //создание своего Хандлера с переопределенным методом
    @Override
    public void handleMessage(Message msg) {
        Fragment3.strings.add(String.valueOf(msg.what));    //добавление в список нового значения
        Fragment3.adapter.notifyDataSetChanged();
    }
}
