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

public class RecyclerAdapter_mundo extends RecyclerView.Adapter<RecyclerAdapter_mundo.RecyclerHolderMundo>{

    private List<lista_relacionados> items_mundo;
    private List<lista_relacionados> originalItems_mundo;
    private RecyclerAdapter_mundo.RecyclerItemClick itemClick_mundo;


    public RecyclerAdapter_mundo(List<lista_relacionados> items, RecyclerItemClick itemClick) {
        this.items_mundo = items;
        this.itemClick_mundo = itemClick;
        this.originalItems_mundo = new ArrayList<>();
        originalItems_mundo.addAll(items);
    }


    @NonNull
    @Override
    public RecyclerHolderMundo onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_mundo, parent, false);
        return new RecyclerHolderMundo(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerHolderMundo holder, int position) {

        final lista_relacionados lista_mundo = items_mundo.get(position);
        holder.imgMundo.setImageResource(lista_mundo.getImg_principal());
        holder.nombre_es.setText(lista_mundo.getNombre_principal());
        holder.nombre_en.setText(lista_mundo.getNombre_secundario());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClick_mundo.itemClick(lista_mundo);
            }
        });

    }


    @Override
    public int getItemCount() {
        return items_mundo.size();
    }


    public void filter(final String strSearch) {
        if (strSearch.length() == 0) {
            items_mundo.clear();
            items_mundo.addAll(originalItems_mundo);
        }
        else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                items_mundo.clear();
                List<lista_relacionados> collect = originalItems_mundo.stream()
                        .filter(i -> i.getNombre_principal().toLowerCase().contains(strSearch) ||
                                i.getNombre_secundario().toLowerCase().contains(strSearch))
                        .collect(Collectors.toList());

                items_mundo.addAll(collect);
            }
            else {
                items_mundo.clear();
                for (lista_relacionados i : originalItems_mundo) {
                    if (i.getNombre_principal().toLowerCase().contains(strSearch) ||
                            i.getNombre_secundario().toLowerCase().contains(strSearch) ) {
                        items_mundo.add(i);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }

    public static class RecyclerHolderMundo extends RecyclerView.ViewHolder {

        private ImageView imgMundo;
        private TextView nombre_es;
        private TextView nombre_en;

        public RecyclerHolderMundo(@NonNull View itemView_2) {
            super(itemView_2);

            imgMundo = itemView_2.findViewById(R.id.lista_foto_mundo);
            nombre_es = itemView_2.findViewById(R.id.lista_espanol_mundo);
            nombre_en = itemView_2.findViewById(R.id.lista_ingles_mundo);
        }
    }


    public interface RecyclerItemClick {
        void itemClick(lista_relacionados item);
    }


}
