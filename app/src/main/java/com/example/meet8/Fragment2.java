package com.example.meet8;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

/**
 * Класс предназначен для вывод на фрагмент случайного числа в диапазоне до 1000. Происходит это
 * при помощи MyAsyncTask - в методе onCreateView происходит его [MyAsyncTask] вызов, а
 * уже в нем генерация числа и вывод в TextView. MyAsyncTask является вложенным классом.
 */

public class Fragment2 extends Fragment {

    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, container, false); //Инфлэйтим вид со 2 фрагмента
        textView = view.findViewById(R.id.textView);//объявление (связка) текстВью

        new MyAsyncTask().execute(); //запуск АсинкТаска

        return view;
    }

    @SuppressLint("StaticFieldLeak")
    private class MyAsyncTask extends AsyncTask<Void, Void, Integer> {

        @Override
        protected Integer doInBackground(Void... voids) {
            Random random = new Random();  //рандом до 1000
            return random.nextInt(1000);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            textView.setText(String.valueOf(integer));  //установка сгенерированного числа в текст. строку
        }
    }
}
