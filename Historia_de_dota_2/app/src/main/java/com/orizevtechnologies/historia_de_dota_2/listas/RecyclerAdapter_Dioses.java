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

public class RecyclerAdapter_Dioses extends RecyclerView.Adapter<RecyclerAdapter_Dioses.RecyclerHolderDioses> {

    private List<lista_relacionados> items_dioses;
    private List<lista_relacionados> originalItems_dioses;
    private RecyclerItemClick itemClick_dioses;


    public RecyclerAdapter_Dioses(List<lista_relacionados> items_dioses, RecyclerItemClick itemClick_dioses) {
        this.items_dioses = items_dioses;
        this.itemClick_dioses = itemClick_dioses;
        this.originalItems_dioses = new ArrayList<>();
        originalItems_dioses.addAll(items_dioses);
    }


    @NonNull
    @Override
    public RecyclerHolderDioses onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_mundo, parent, false);
        return new RecyclerHolderDioses(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerHolderDioses holder, int position) {

        final lista_relacionados item = items_dioses.get(position);
        holder.imgdioses.setImageResource(item.getImg_principal());
        holder.nombre_es.setText(item.getNombre_principal());
        holder.nombre_en.setText(item.getNombre_secundario());

        holder.itemView.setOnClickListener(v -> itemClick_dioses.itemClick(item));
        
    }


    @Override
    public int getItemCount() {
        return items_dioses.size();
    }


    public void filter(final String strSearch) {
        if (strSearch.length() == 0) {
            items_dioses.clear();
            items_dioses.addAll(originalItems_dioses);
        }
        else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                items_dioses.clear();
                List<lista_relacionados> collect = originalItems_dioses.stream()
                        .filter(i -> i.getNombre_principal().toLowerCase().contains(strSearch) ||
                                i.getNombre_secundario().toLowerCase().contains(strSearch))
                        .collect(Collectors.toList());

                items_dioses.addAll(collect);
            }
            else {
                items_dioses.clear();
                for (lista_relacionados i : originalItems_dioses) {
                    if (i.getNombre_principal().toLowerCase().contains(strSearch) ||
                            i.getNombre_secundario().toLowerCase().contains(strSearch) ) {
                        items_dioses.add(i);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }
    

    public static class RecyclerHolderDioses extends RecyclerView.ViewHolder {

        private ImageView imgdioses;
        private TextView nombre_es;
        private TextView nombre_en;

        public RecyclerHolderDioses(@NonNull View itemView_2) {
            super(itemView_2);

            imgdioses = itemView_2.findViewById(R.id.lista_foto_mundo);
            nombre_es = itemView_2.findViewById(R.id.lista_espanol_mundo);
            nombre_en = itemView_2.findViewById(R.id.lista_ingles_mundo);
        }
    }


    public interface RecyclerItemClick {
        void itemClick(lista_relacionados item);
    }

}
