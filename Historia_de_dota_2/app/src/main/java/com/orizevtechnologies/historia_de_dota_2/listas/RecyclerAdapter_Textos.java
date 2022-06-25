package com.orizevtechnologies.historia_de_dota_2.listas;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.orizevtechnologies.historia_de_dota_2.R;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RecyclerAdapter_Textos extends RecyclerView.Adapter<RecyclerAdapter_Textos.RecyclerHolderTextos> {

    private List<lista_relacionados> items_textos;
    private List<lista_relacionados> originalItems_textos;
    private RecyclerItemClick itemClick_textos;


    public RecyclerAdapter_Textos(List<lista_relacionados> items_textos, RecyclerItemClick itemClick_textos) {
        this.items_textos = items_textos;
        this.itemClick_textos = itemClick_textos;
        this.originalItems_textos = new ArrayList<>();
        originalItems_textos.addAll(items_textos);
    }


    @NonNull
    @Override
    public RecyclerHolderTextos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_mundo, parent, false);
        return new RecyclerHolderTextos(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerHolderTextos holder, int position) {

        final lista_relacionados item = items_textos.get(position);
        holder.imgtextos.setImageResource(item.getImg_principal());
        holder.nombre_es.setText(item.getNombre_principal());
        holder.nombre_en.setText(item.getNombre_secundario());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClick_textos.itemClick(item);
            }
        });
        
    }


    @Override
    public int getItemCount() {
        return items_textos.size();
    }


    public void filter(final String strSearch) {
        if (strSearch.length() == 0) {
            items_textos.clear();
            items_textos.addAll(originalItems_textos);
        }
        else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                items_textos.clear();
                List<lista_relacionados> collect = originalItems_textos.stream()
                        .filter(i -> i.getNombre_principal().toLowerCase().contains(strSearch) ||
                                i.getNombre_secundario().toLowerCase().contains(strSearch))
                        .collect(Collectors.toList());

                items_textos.addAll(collect);
            }
            else {
                items_textos.clear();
                for (lista_relacionados i : originalItems_textos) {
                    if (i.getNombre_principal().toLowerCase().contains(strSearch) ||
                            i.getNombre_secundario().toLowerCase().contains(strSearch) ) {
                        items_textos.add(i);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }
    

    public static class RecyclerHolderTextos extends RecyclerView.ViewHolder {

        private ImageView imgtextos;
        private TextView nombre_es;
        private TextView nombre_en;

        public RecyclerHolderTextos(@NonNull View itemView_2) {
            super(itemView_2);

            imgtextos = itemView_2.findViewById(R.id.lista_foto_mundo);
            nombre_es = itemView_2.findViewById(R.id.lista_espanol_mundo);
            nombre_en = itemView_2.findViewById(R.id.lista_ingles_mundo);
        }
    }


    public interface RecyclerItemClick {
        void itemClick(lista_relacionados item);
    }

}
