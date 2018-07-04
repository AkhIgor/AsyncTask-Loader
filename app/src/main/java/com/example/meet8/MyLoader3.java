package com.example.meet8;

import android.content.Context;
import android.os.Handler;
import android.support.v4.content.AsyncTaskLoader;

import java.util.concurrent.TimeUnit;

/**
 * Класс каждые 2 секунды выдает некоторое число из цикла и помещает его в Message.
 */

public class MyLoader3 extends AsyncTaskLoader<Void> {

    private Handler handler;

    public MyLoader3(Context context, Handler handler) {
        super(context);
        this.handler = handler;
    }

    @Override
    public Void loadInBackground() {
        for (int i = 0; i < 100; i++) { //Инкрементирование каждые 2 секунды
            handler.sendEmptyMessage(i);//вывод текущего значения
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
