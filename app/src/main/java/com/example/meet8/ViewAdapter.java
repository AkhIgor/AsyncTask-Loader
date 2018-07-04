package com.example.meet8;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * Класс необходим для работы с RecyckerView, которое применяется в 3-ем фрагменте. В классе
 * происходит переопределение методов в соответствии с созданным RecyckerView.
 */
public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder> {

    private List<String> strings;

    ViewAdapter(List<String> strings) {
        this.strings = strings;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String s = strings.get(position);   //установка значений в вывод в соответствии с их позицией
        holder.textView.setText(s);
    }

    @Override
    public int getItemCount() {//возвращаем текущий размер списка
        return strings.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        final TextView textView;

        ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item); //связка текстВью
        }
    }
}
