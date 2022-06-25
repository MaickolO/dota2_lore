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
import com.orizevtechnologies.historia_de_dota_2.Detalle.detalle_mundo;
import com.orizevtechnologies.historia_de_dota_2.listas.RecyclerAdapter_mundo;
import com.orizevtechnologies.historia_de_dota_2.listas.lista_relacionados;
import com.orizevtechnologies.historia_de_dota_2.R;

import java.util.ArrayList;
import java.util.List;

public class regiones extends Fragment implements RecyclerAdapter_mundo.RecyclerItemClick, SearchView.OnQueryTextListener{

    private AdView mAdView;
    private RecyclerView rvLista_mundo;
    private SearchView svSearch_mundo;
    private RecyclerAdapter_mundo adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_regiones, container, false);

        initViews(view);
        initValues();
        initListener();
        anuncio_banenr(view);

        return view;
    }


    private void initViews(View view) {
        rvLista_mundo = view.findViewById(R.id.recycler_view_regiones);
        svSearch_mundo = view.findViewById(R.id.svSearch_mundo);
        svSearch_mundo.setIconifiedByDefault(false);
    }


    private void initValues() {

        LinearLayoutManager manager = new LinearLayoutManager(getContext());

        rvLista_mundo.setLayoutManager(manager);

        List<lista_relacionados> items = getItems();
        adapter = new RecyclerAdapter_mundo(items, this);


        rvLista_mundo.setAdapter(adapter);

    }


    private List<lista_relacionados> getItems() {

        List<lista_relacionados> lista_mundo_es= new ArrayList<>();

        lista_mundo_es.add(new lista_relacionados("Ashkavor", "Ashkavor", R.drawable.ashkavor));
        lista_mundo_es.add(new lista_relacionados("Aziyog", "Aziyog", R.drawable.aziyog));
        lista_mundo_es.add(new lista_relacionados("Catedral de Rumusque", "Cathedral of Rumusque", R.drawable.catedral));
        lista_mundo_es.add(new lista_relacionados("Claszureme", "Claszureme", R.drawable.claszureme));
        lista_mundo_es.add(new lista_relacionados("Arrecife Oscuro", "Dark Reef", R.drawable.arrecife_oscuro));
        lista_mundo_es.add(new lista_relacionados("Desierto de la Anarquía", "Desert of Misrule", R.drawable.desierto_misrule));
        lista_mundo_es.add(new lista_relacionados("Druud", "Druud", R.drawable.druud));
        lista_mundo_es.add(new lista_relacionados("Emauracus", "Emauracus", R.drawable.emauracus));
        lista_mundo_es.add(new lista_relacionados("Imperio de Huesos", "Empire of Bone", R.drawable.empire_bone));
        lista_mundo_es.add(new lista_relacionados("Campos de la Matanza sin Fin", "Fields of Endless Carnage", R.drawable.campos_carniceria_sin_fin));
        lista_mundo_es.add(new lista_relacionados("Fuente del Averno", "Font of Avernus", R.drawable.fuente_averno));
        lista_mundo_es.add(new lista_relacionados("Fortaleza de las Llamas", "Fortress of Flares", R.drawable.fortaleza_llamas));
        lista_mundo_es.add(new lista_relacionados("Foulfell", "Foulfell", R.drawable.foulfell));
        lista_mundo_es.add(new lista_relacionados("Corazón de la Naturaleza", "Hearth of Nature", R.drawable.corazon_naturaleza));
        lista_mundo_es.add(new lista_relacionados("Imperio Helio", "Helio Imperium", R.drawable.imperio_helio));
        lista_mundo_es.add(new lista_relacionados("Templo Escondido", "Hidden Temple", R.drawable.templo_oculto));
        lista_mundo_es.add(new lista_relacionados("Fisura de Hielo", "Icewrack", R.drawable.icewrack));
        lista_mundo_es.add(new lista_relacionados("Isla de las Máscaras", "Isle of Masks", R.drawable.isla_mascaras));
        lista_mundo_es.add(new lista_relacionados("Knollen", "Knollen", R.drawable.knollen));
        lista_mundo_es.add(new lista_relacionados("La Luna Loca", "The Mad Moon", R.drawable.mad_moon2));
        lista_mundo_es.add(new lista_relacionados("Monte Pyrotheos", "Mount Pyrotheos", R.drawable.monte_pyroteos));
        lista_mundo_es.add(new lista_relacionados("Confines Infernales", "Nether Reaches", R.drawable.confines_infernales));
        lista_mundo_es.add(new lista_relacionados("Bosque de la Noche Plateada", "Nightsilver Woods", R.drawable.bosque_noche_plateada));
        lista_mundo_es.add(new lista_relacionados("Reino de Nothl", "Nothl Realm", R.drawable.nothl));
        lista_mundo_es.add(new lista_relacionados("Revtel", "Revtel", R.drawable.revtel));
        lista_mundo_es.add(new lista_relacionados("Ruinas de Grietas Sombrías", "Riftshadow Ruins", R.drawable.riftshadow_ruins));
        lista_mundo_es.add(new lista_relacionados("Basurero Centelleante", "Scintillant Waste", R.drawable.basurero_centelleante));
        lista_mundo_es.add(new lista_relacionados("Siete Infiernos", "Seven Hells", R.drawable.seven_hells));
        lista_mundo_es.add(new lista_relacionados("Palacio de Piedra", "StoneHall", R.drawable.stonehall));
        lista_mundo_es.add(new lista_relacionados("El Horno", "The Hoven", R.drawable.hoven));
        lista_mundo_es.add(new lista_relacionados("Mundo Exterior", "The Outworld", R.drawable.outworld));
        lista_mundo_es.add(new lista_relacionados("Siete Planos", "Seven Planes", R.drawable.seven_planes));
        lista_mundo_es.add(new lista_relacionados("Isla Temblorosa", "Trembling Isle", R.drawable.isla_temblorosa));
        lista_mundo_es.add(new lista_relacionados("Estado Tyler", "Tyler Estate", R.drawable.tyler_state));
        lista_mundo_es.add(new lista_relacionados("Archivos de Ultimyr", "Ultimyr Archives", R.drawable.archivos_ultimyr));
        lista_mundo_es.add(new lista_relacionados("Underscape", "Underscape", R.drawable.underscape));
        lista_mundo_es.add(new lista_relacionados("Meseta Violeta", "Violet Plateau", R.drawable.violet_plateau));
        lista_mundo_es.add(new lista_relacionados("Rosa Llorona", "Weeping Rose", R.drawable.weeping_rose));


        return lista_mundo_es;
    }


    private void initListener() {
        svSearch_mundo.setOnQueryTextListener(this);
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
            Intent intent = new Intent(getContext(), detalle_mundo.class);
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

        mAdView = view.findViewById(R.id.adView_regiones);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }



}