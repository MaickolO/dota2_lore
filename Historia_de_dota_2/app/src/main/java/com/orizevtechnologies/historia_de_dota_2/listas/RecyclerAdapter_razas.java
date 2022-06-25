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

public class RecyclerAdapter_razas extends RecyclerView.Adapter<RecyclerAdapter_razas.RecyclerHolderRazas> {

    private List<lista_relacionados> items_razas;
    private List<lista_relacionados> originalItems_razas;
    private RecyclerAdapter_razas.RecyclerItemClick itemClick_razas;

    public RecyclerAdapter_razas(List<lista_relacionados> items_razas, RecyclerItemClick itemClick_razas) {
        this.items_razas = items_razas;
        this.itemClick_razas = itemClick_razas;
        this.originalItems_razas = new ArrayList<>();
        originalItems_razas.addAll(items_razas);
    }


    @NonNull
    @Override
    public RecyclerHolderRazas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_razas, parent, false);
        return new RecyclerHolderRazas(view);

    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerHolderRazas holder, int position) {

        final lista_relacionados lista_razas = items_razas.get(position);
        holder.imgRazas.setImageResource(lista_razas.getImg_principal());
        holder.nombre_es_raza.setText(lista_razas.getNombre_principal());
        holder.nombre_en_raza.setText(lista_razas.getNombre_secundario());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClick_razas.itemClick(lista_razas);
            }
        });

    }


    @Override
    public int getItemCount() {
        return items_razas.size();
    }


    public void filter(final String strSearch) {
        if (strSearch.length() == 0) {
            items_razas.clear();
            items_razas.addAll(originalItems_razas);
        }
        else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                items_razas.clear();
                List<lista_relacionados> collect = originalItems_razas.stream()
                        .filter(i -> i.getNombre_principal().toLowerCase().contains(strSearch) ||
                                i.getNombre_secundario().toLowerCase().contains(strSearch))
                        .collect(Collectors.toList());

                items_razas.addAll(collect);
            }
            else {
                items_razas.clear();
                for (lista_relacionados i : originalItems_razas) {
                    if (i.getNombre_principal().toLowerCase().contains(strSearch) ||
                            i.getNombre_secundario().toLowerCase().contains(strSearch) ) {
                        items_razas.add(i);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }


    public static class RecyclerHolderRazas extends RecyclerView.ViewHolder {

        private ImageView imgRazas;
        private TextView nombre_es_raza;
        private TextView nombre_en_raza;

        public RecyclerHolderRazas(@NonNull View itemView_3) {
            super(itemView_3);

            imgRazas = itemView_3.findViewById(R.id.lista_foto_razas);
            nombre_es_raza = itemView_3.findViewById(R.id.lista_espanol_razas);
            nombre_en_raza = itemView_3.findViewById(R.id.lista_ingles_razas);

        }
    }


    public interface RecyclerItemClick {
        void itemClick(lista_relacionados item);
    }

}
