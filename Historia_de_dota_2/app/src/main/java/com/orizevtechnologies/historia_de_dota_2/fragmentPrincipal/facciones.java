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
import com.orizevtechnologies.historia_de_dota_2.Detalle.detalle_facciones;
import com.orizevtechnologies.historia_de_dota_2.R;
import com.orizevtechnologies.historia_de_dota_2.listas.RecyclerAdapter_facciones;
import com.orizevtechnologies.historia_de_dota_2.listas.lista_relacionados;

import java.util.ArrayList;
import java.util.List;

public class facciones extends Fragment implements RecyclerAdapter_facciones.RecyclerItemClick, SearchView.OnQueryTextListener {

    private AdView mAdView;
    private RecyclerView rvLista_facciones;
    private SearchView svSearch_facciones;
    private RecyclerAdapter_facciones adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_facciones, container, false);

        initViews(view);
        initValues();
        initListener();
        anuncio_banenr(view);

        return view;

    }

    private void initViews(View view) {
        rvLista_facciones = view.findViewById(R.id.recycler_view_facciones);
        svSearch_facciones = view.findViewById(R.id.svSearch_facciones);
        svSearch_facciones.setIconifiedByDefault(false);
    }


    private void initValues() {

        LinearLayoutManager manager = new LinearLayoutManager(getContext());

        rvLista_facciones.setLayoutManager(manager);

        List<lista_relacionados> items = getItems();
        adapter = new RecyclerAdapter_facciones(items, this);

        rvLista_facciones.setAdapter(adapter);

    }


    private List<lista_relacionados> getItems() {

        List<lista_relacionados> lista_facciones = new ArrayList<>();

        lista_facciones.add(new lista_relacionados("Horda Abisal", "Abyssal Horde", R.drawable.horda_abisal));
        lista_facciones.add(new lista_relacionados("Ascendidos", "Ascended Ones", R.drawable.ascendidos));
        lista_facciones.add(new lista_relacionados("Legion de Ceniza", "Ash Legion", R.drawable.legion_ceniza));
        lista_facciones.add(new lista_relacionados("Niebla Sangrienta y Niebla Roja", "Bloodmist and Red Mist", R.drawable.niebla_roja));
        lista_facciones.add(new lista_relacionados("Legión de Bronce", "Bronze Legion", R.drawable.legion_bronce));
        lista_facciones.add(new lista_relacionados("Armada de Claddish", "Claddish Navy", R.drawable.armada_claddish));
        lista_facciones.add(new lista_relacionados("Corte de Ristul", "Court of Ristul", R.drawable.corte_ristul));
        lista_facciones.add(new lista_relacionados("Profundos", "Deep Ones", R.drawable.profundos));
        lista_facciones.add(new lista_relacionados("Eldwurms", "Eldwurms", R.drawable.eldwurms));
        lista_facciones.add(new lista_relacionados("Casa Averno", "House Avernus", R.drawable.casa_averno));
        lista_facciones.add(new lista_relacionados("Casa de Ambry", "House Ambry", R.drawable.casa_ambry));
        lista_facciones.add(new lista_relacionados("Círculo de Jasper", "Jasper Circle", R.drawable.circulo_jasper));
        lista_facciones.add(new lista_relacionados("Monjes de Turstarkuri", "Monks of Turstarkuri", R.drawable.monjes));
        lista_facciones.add(new lista_relacionados("Galantes de Nivan", "Nivan Gallants", R.drawable.galantes_nivan));
        lista_facciones.add(new lista_relacionados("Radiante y Diabólico", "Radiant and Dire", R.drawable.radiant_dire));
        lista_facciones.add(new lista_relacionados("Hermanas del velo", "Sisters of the Veil", R.drawable.hermanas_velo));
        lista_facciones.add(new lista_relacionados("Guardia Slithereen", "Slithereen Guard", R.drawable.guardia));
        lista_facciones.add(new lista_relacionados("Continuum", "Continuum", R.drawable.continuum));
        lista_facciones.add(new lista_relacionados("Caballeros de la Vigilia", "Vigil Knights", R.drawable.caballeros_vigilia));

        return lista_facciones;
    }

    
    private void initListener() {
        svSearch_facciones.setOnQueryTextListener(this);
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
            Intent intent = new Intent(getContext(), detalle_facciones.class);
            intent.putExtra("itemDetail", item);
            getContext().startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        
    }

    private void anuncio_banenr(View view) {

        MobileAds.initialize(getActivity(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = view.findViewById(R.id.adView_facciones);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

}