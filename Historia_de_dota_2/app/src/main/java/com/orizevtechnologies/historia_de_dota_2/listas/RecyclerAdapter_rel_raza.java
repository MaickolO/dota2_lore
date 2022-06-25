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

public class RecyclerAdapter_rel_raza extends RecyclerView.Adapter<RecyclerAdapter_rel_raza.RecyclerHolderRelacionados>{

    private List<lista_relacionados> items_relacionados;
    private List<lista_relacionados> original_items_relacionados;
    private RecyclerAdapter_rel_raza.RecyclerItemClick itemClick_relacionados;


    public RecyclerAdapter_rel_raza(List<lista_relacionados> items_relacionados, RecyclerItemClick itemClick_relacionados) {
        this.items_relacionados = items_relacionados;
        this.itemClick_relacionados = itemClick_relacionados;
        this.original_items_relacionados = new ArrayList<>();
        this.original_items_relacionados.addAll(items_relacionados);
    }

    @NonNull
    @Override
    public RecyclerHolderRelacionados onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_relacionados, parent, false);
        return new RecyclerHolderRelacionados(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolderRelacionados holder, int position) {
        final lista_relacionados listaRelacionados = items_relacionados.get(position);
        holder.img_pr.setImageResource(listaRelacionados.getImg_principal());
        holder.nombre_pr.setText(listaRelacionados.getNombre_principal());
        holder.nombre_sc.setText(listaRelacionados.getNombre_secundario());
        holder.itemView.setOnClickListener(view -> itemClick_relacionados.itemClick(listaRelacionados));
    }


    @Override
    public int getItemCount() {
        return items_relacionados.size();
    }

    public void filter(final String strSearch) {
        if (strSearch.length() == 0) {
            items_relacionados.clear();
            items_relacionados.addAll(original_items_relacionados);
        }
        else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                items_relacionados.clear();
                List<lista_relacionados> collect = original_items_relacionados.stream()
                        .filter(i -> i.getNombre_principal().toLowerCase().contains(strSearch) ||
                                i.getNombre_secundario().toLowerCase().contains(strSearch))
                        .collect(Collectors.toList());

                items_relacionados.addAll(collect);
            }
            else {
                items_relacionados.clear();
                for (lista_relacionados i : original_items_relacionados) {
                    if (i.getNombre_principal().toLowerCase().contains(strSearch) ||
                            i.getNombre_secundario().toLowerCase().contains(strSearch) ) {
                        items_relacionados.add(i);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }


    public static class RecyclerHolderRelacionados extends RecyclerView.ViewHolder {
        private ImageView img_pr;
        private TextView nombre_pr;
        private TextView nombre_sc;
        public RecyclerHolderRelacionados(@NonNull View itemView_4) {
            super(itemView_4);
            img_pr = itemView_4.findViewById(R.id.lista_relacionado_img);
            nombre_pr = itemView_4.findViewById(R.id.lista_pr_img);
            nombre_sc = itemView_4.findViewById(R.id.lista_sc_img);
        }
    }

    public interface RecyclerItemClick {
        void itemClick(lista_relacionados item);
    }

}
