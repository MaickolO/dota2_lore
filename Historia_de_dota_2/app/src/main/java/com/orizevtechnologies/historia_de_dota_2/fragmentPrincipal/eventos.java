package com.orizevtechnologies.historia_de_dota_2.fragmentPrincipal;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.orizevtechnologies.historia_de_dota_2.Detalle.detalle_eventos;
import com.orizevtechnologies.historia_de_dota_2.R;
import com.orizevtechnologies.historia_de_dota_2.listas.RecyclerAdapter_Eventos;
import com.orizevtechnologies.historia_de_dota_2.listas.lista_relacionados;

import java.util.ArrayList;
import java.util.List;

public class eventos extends Fragment implements RecyclerAdapter_Eventos.RecyclerItemClick, SearchView.OnQueryTextListener{

    private AdView mAdView;
    private RecyclerView rvLista_eventos;
    private SearchView svSearch_eventos;
    private RecyclerAdapter_Eventos adapter;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_eventos, container, false);

        initViews(view);
        initValues();
        initListener();
        anuncio_banenr(view);
        return view;
    }


    private void initViews(View view) {
        rvLista_eventos = view.findViewById(R.id.recycler_view_eventos);
        svSearch_eventos = view.findViewById(R.id.svSearch_eventos);
        svSearch_eventos.setIconifiedByDefault(false);
    }


    private void initValues() {

        LinearLayoutManager manager = new LinearLayoutManager(getContext());

        rvLista_eventos.setLayoutManager(manager);

        List<lista_relacionados> items = getItems();
        adapter = new RecyclerAdapter_Eventos(items, this);

        rvLista_eventos.setAdapter(adapter);

    }


    private List<lista_relacionados> getItems() {

        List<lista_relacionados> lista_eventos = new ArrayList<>();

        lista_eventos.add(new lista_relacionados("Batalla de la Puerta del Pez-Piedra", "Battle of Stonefish Gate", R.drawable.batalla_stonefish));
        lista_eventos.add(new lista_relacionados("Masacre de los Apóstatas", "Massacre of the Apostates", R.drawable.masacre));
        lista_eventos.add(new lista_relacionados("Qaz'hallaq", "Qaz'hallaq", R.drawable.qazhallaq));
        lista_eventos.add(new lista_relacionados("Guerra de los Siete Minutos", "Seven Minute War", R.drawable.guerra_siete_minutos));
        lista_eventos.add(new lista_relacionados("Era Sórdida", "Sordid Era", R.drawable.era_sordida));
        lista_eventos.add(new lista_relacionados("Batallas del Dios de la Guerra", "battles of the God of war", R.drawable.conquistas_estigia));
        lista_eventos.add(new lista_relacionados("Rebelion Vhoul", "Vhoul Rebellion", R.drawable.rebelion_vhoul));

        return lista_eventos;
    }


    private void initListener() {
        svSearch_eventos.setOnQueryTextListener(this);
    }
    
    
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    
    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.filter(newText);
        return false;
    }

    
    @Override
    public void itemClick(lista_relacionados item) {

        try {
            Intent intent = new Intent(getContext(), detalle_eventos.class);
            intent.putExtra("itemDetail", item);
            getContext().startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        
    }

    private void anuncio_banenr(View view) {

        MobileAds.initialize(getActivity(), initializationStatus -> {
        });

        mAdView = view.findViewById(R.id.adView_eventos);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

}