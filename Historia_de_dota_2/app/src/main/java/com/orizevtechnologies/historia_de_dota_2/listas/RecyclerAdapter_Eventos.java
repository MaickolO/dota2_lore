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

public class RecyclerAdapter_Eventos extends RecyclerView.Adapter<RecyclerAdapter_Eventos.RecyclerHolderEventos> {

    private List<lista_relacionados> items_eventos;
    private List<lista_relacionados> originalItems_eventos;
    private RecyclerItemClick itemClick_eventos;


    public RecyclerAdapter_Eventos(List<lista_relacionados> items_eventos, RecyclerItemClick itemClick_eventos) {
        this.items_eventos = items_eventos;
        this.itemClick_eventos = itemClick_eventos;
        this.originalItems_eventos = new ArrayList<>();
        originalItems_eventos.addAll(items_eventos);
    }


    @NonNull
    @Override
    public RecyclerHolderEventos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_mundo, parent, false);
        return new RecyclerHolderEventos(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerHolderEventos holder, int position) {

        final lista_relacionados item = items_eventos.get(position);
        holder.imgeventos.setImageResource(item.getImg_principal());
        holder.nombre_es.setText(item.getNombre_principal());
        holder.nombre_en.setText(item.getNombre_secundario());

        holder.itemView.setOnClickListener(v -> itemClick_eventos.itemClick(item));
        
    }


    @Override
    public int getItemCount() {
        return items_eventos.size();
    }
    

    public void filter(final String strSearch) {
        if (strSearch.length() == 0) {
            items_eventos.clear();
            items_eventos.addAll(originalItems_eventos);
        }
        else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                items_eventos.clear();
                List<lista_relacionados> collect = originalItems_eventos.stream()
                        .filter(i -> i.getNombre_principal().toLowerCase().contains(strSearch) ||
                                i.getNombre_secundario().toLowerCase().contains(strSearch))
                        .collect(Collectors.toList());

                items_eventos.addAll(collect);
            }
            else {
                items_eventos.clear();
                for (lista_relacionados i : originalItems_eventos) {
                    if (i.getNombre_principal().toLowerCase().contains(strSearch) ||
                            i.getNombre_secundario().toLowerCase().contains(strSearch) ) {
                        items_eventos.add(i);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }
    

    public static class RecyclerHolderEventos extends RecyclerView.ViewHolder {

        private ImageView imgeventos;
        private TextView nombre_es;
        private TextView nombre_en;

        public RecyclerHolderEventos(@NonNull View itemView_2) {
            super(itemView_2);

            imgeventos = itemView_2.findViewById(R.id.lista_foto_mundo);
            nombre_es = itemView_2.findViewById(R.id.lista_espanol_mundo);
            nombre_en = itemView_2.findViewById(R.id.lista_ingles_mundo);
        }
    }


    public interface RecyclerItemClick {
        void itemClick(lista_relacionados item);
    }

}
