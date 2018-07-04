package com.example.meet8;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;
import java.util.Random;

/**
 *В методе loadInBackground происходит генерация числа в пределах до 44. Затем в соответствии с полученным числом
 * происходит выбор цвета. Для того чтоб увеличить частоту смены цветов осуществленно деление сгенерированнного числа
 * и выбор цвета зависит от результата операции. После выбора результат возвращают в класс.
 */
public class MyLoader extends AsyncTaskLoader<Integer> {

    /**
     *
     * @param context
     */
    MyLoader(@NonNull Context context) {
        super(context);
    }

    @Nullable
    @Override
    public Integer loadInBackground() { //основной метод
        //генерим рандомные переменные красного, зелленого и синего, а затем
        //создаем на их основе цвет

        Random rand = new Random();
        int digit = rand.nextInt(44);

        switch (digit/11) {
            case 0:
                return R.color.MyColor1;
            case 1:
                return R.color.MyColor2;
            case 2:
                return R.color.MyColor3;
            case 3:
                return R.color.MyColor4;
            case 4:
                return R.color.MyColor5;

            default:
                return R.color.colorPrimaryDark;
        }
    }
}