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

public class RecyclerAdapter_facciones extends RecyclerView.Adapter<RecyclerAdapter_facciones.RecyclerHolderFacciones>{

    private List<lista_relacionados> items_facciones;
    private List<lista_relacionados> originalItems_facciones;
    private RecyclerItemClick itemClick_facciones;

    public RecyclerAdapter_facciones(List<lista_relacionados> items_facciones, RecyclerItemClick itemClick_facciones) {
        this.items_facciones = items_facciones;
        this.itemClick_facciones = itemClick_facciones;
        this.originalItems_facciones = new ArrayList<>();
        originalItems_facciones.addAll(items_facciones);
    }
    
    
    @NonNull
    @Override
    public RecyclerHolderFacciones onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_mundo, parent, false);
        return new RecyclerHolderFacciones(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolderFacciones holder, int position) {

        final lista_relacionados item = items_facciones.get(position);
        holder.imgfacciones.setImageResource(item.getImg_principal());
        holder.nombre_es.setText(item.getNombre_principal());
        holder.nombre_en.setText(item.getNombre_secundario());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClick_facciones.itemClick(item);
            }
        });
        
    }

    @Override
    public int getItemCount() {
        return items_facciones.size();
    }


    public void filter(final String strSearch) {
        if (strSearch.length() == 0) {
            items_facciones.clear();
            items_facciones.addAll(originalItems_facciones);
        }
        else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                items_facciones.clear();
                List<lista_relacionados> collect = originalItems_facciones.stream()
                        .filter(i -> i.getNombre_principal().toLowerCase().contains(strSearch) ||
                                i.getNombre_secundario().toLowerCase().contains(strSearch))
                        .collect(Collectors.toList());

                items_facciones.addAll(collect);
            }
            else {
                items_facciones.clear();
                for (lista_relacionados i : originalItems_facciones) {
                    if (i.getNombre_principal().toLowerCase().contains(strSearch) ||
                            i.getNombre_secundario().toLowerCase().contains(strSearch) ) {
                        items_facciones.add(i);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }
    

    public static class RecyclerHolderFacciones extends RecyclerView.ViewHolder {

        private ImageView imgfacciones;
        private TextView nombre_es;
        private TextView nombre_en;

        public RecyclerHolderFacciones(@NonNull View itemView_2) {
            super(itemView_2);

            imgfacciones = itemView_2.findViewById(R.id.lista_foto_mundo);
            nombre_es = itemView_2.findViewById(R.id.lista_espanol_mundo);
            nombre_en = itemView_2.findViewById(R.id.lista_ingles_mundo);
        }
    }


    public interface RecyclerItemClick {
        void itemClick(lista_relacionados item);
    }
    
}
