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
import com.orizevtechnologies.historia_de_dota_2.Detalle.detalle_dioses;
import com.orizevtechnologies.historia_de_dota_2.R;
import com.orizevtechnologies.historia_de_dota_2.listas.RecyclerAdapter_Dioses;
import com.orizevtechnologies.historia_de_dota_2.listas.lista_relacionados;

import java.util.ArrayList;
import java.util.List;

public class dioses extends Fragment implements RecyclerAdapter_Dioses.RecyclerItemClick, SearchView.OnQueryTextListener{

    private AdView mAdView;
    private RecyclerView rvLista_dioses;
    private SearchView svSearch_dioses;
    private RecyclerAdapter_Dioses adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dioses, container, false);

        initViews(view);
        initValues();
        initListener();
        anuncio_banenr(view);
        return view;
    }


    private void initViews(View view) {
        rvLista_dioses = view.findViewById(R.id.recycler_view_dioses);
        svSearch_dioses = view.findViewById(R.id.svSearch_dioses);
        svSearch_dioses.setIconifiedByDefault(false);
    }

    private void initValues() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        rvLista_dioses.setLayoutManager(manager);
        List<lista_relacionados> items = getItems();
        adapter = new RecyclerAdapter_Dioses(items, this);
        rvLista_dioses.setAdapter(adapter);
    }

    private List<lista_relacionados> getItems() {

        List<lista_relacionados> lista_dioses= new ArrayList<>();

        lista_dioses.add(new lista_relacionados("Aethrak", "", R.drawable.aethrak));
        lista_dioses.add(new lista_relacionados("Aktok", "", R.drawable.aktok));
        lista_dioses.add(new lista_relacionados("Ascendentes", "Ascendants", R.drawable.ascendentes));
        lista_dioses.add(new lista_relacionados("Avilliva", "", R.drawable.avilliva));
        lista_dioses.add(new lista_relacionados("Belladonna", "", R.drawable.belladonna));
        lista_dioses.add(new lista_relacionados("Padre de Brewmaster", "Brewmaster's Father", R.drawable.brewmaster_father));
        lista_dioses.add(new lista_relacionados("Celestial Ardiente", "Burning Celestial", R.drawable.celestial_ardiente));
        lista_dioses.add(new lista_relacionados("Byssark", "", R.drawable.byssrak));
        lista_dioses.add(new lista_relacionados("Celestiales", "Celestials", R.drawable.celestiales));
        lista_dioses.add(new lista_relacionados("Clasz", "", R.drawable.clasz));
        lista_dioses.add(new lista_relacionados("Los Oscuros", "Dark Ones", R.drawable.oscuros));
        lista_dioses.add(new lista_relacionados("Ermarcor el Explorador", "Ermacor the Pathfinder", R.drawable.ermacor));
        lista_dioses.add(new lista_relacionados("Los Sin Rostro", "Faceless Ones", R.drawable.sin_rostro));
        lista_dioses.add(new lista_relacionados("Gemelos Despellejados", "Flayed Twins", R.drawable.gemelos_desollados));
        lista_dioses.add(new lista_relacionados("Fundamentales", "Fundamentals", R.drawable.fundamentales));
        lista_dioses.add(new lista_relacionados("Fymryn", "", R.drawable.fymryn));
        lista_dioses.add(new lista_relacionados("Diosa de la Suerte", "Goddess of Luck", R.drawable.diosa_suerte));
        lista_dioses.add(new lista_relacionados("Los Ocultos", "Hidden Ones", R.drawable.ocultos));
        lista_dioses.add(new lista_relacionados("Indrak", "", R.drawable.indrak));
        lista_dioses.add(new lista_relacionados("Ix'yxa el Destructor", "Ix'yxa the Destroyer", R.drawable.ixyxa));
        lista_dioses.add(new lista_relacionados("Lirrak", "", R.drawable.lirrak));
        lista_dioses.add(new lista_relacionados("Maelrawn el Tentacular", "Maelrawn the Tentacular", R.drawable.maelrawn));
        lista_dioses.add(new lista_relacionados("Forjador de Máscaras", "Maker of Masks", R.drawable.maker_masks));
        lista_dioses.add(new lista_relacionados("Mene", "", R.drawable.mene));
        lista_dioses.add(new lista_relacionados("Nyctasha", "", R.drawable.nyctasha));
        lista_dioses.add(new lista_relacionados("Nyx", "", R.drawable.diosa_nyx));
        lista_dioses.add(new lista_relacionados("Obelis", "", R.drawable.obelis));
        lista_dioses.add(new lista_relacionados("Omniciencia", "Omniscience", R.drawable.omniciencia));
        lista_dioses.add(new lista_relacionados("Orrak", "Aurak", R.drawable.orrak));
        lista_dioses.add(new lista_relacionados("Polymorphia", "", R.drawable.polymorphia));
        lista_dioses.add(new lista_relacionados("Poseidon", "", R.drawable.poseidon));
        lista_dioses.add(new lista_relacionados("Conciencia Primordial", "Primordial Consciousness", R.drawable.conciencia_primordial));
        lista_dioses.add(new lista_relacionados("Raijin", "", R.drawable.raijin));
        lista_dioses.add(new lista_relacionados("Scree'auk", "", R.drawable.screauk));
        lista_dioses.add(new lista_relacionados("Selemene (Dragon's Blood)", "", R.drawable.selemene2));
        lista_dioses.add(new lista_relacionados("Selemene", "", R.drawable.selemene));
        lista_dioses.add(new lista_relacionados("Sherzi", "", R.drawable.sherzi));
        lista_dioses.add(new lista_relacionados("Shiva", "", R.drawable.shiva));
        lista_dioses.add(new lista_relacionados("Skadi", "", R.drawable.skadi));
        lista_dioses.add(new lista_relacionados("Slyrak", "", R.drawable.slyrak));
        lista_dioses.add(new lista_relacionados("Diosa Solar", "Solar Goddess", R.drawable.diosa_solar));
        lista_dioses.add(new lista_relacionados("Espíritu de la Naturaleza", "Spirit of Nature", R.drawable.espiritu_naturaleza));
        lista_dioses.add(new lista_relacionados("El Dios Muerto", "The Dead God", R.drawable.dios_muerto));
        lista_dioses.add(new lista_relacionados("El Increado", "The Increate", R.drawable.increate));
        lista_dioses.add(new lista_relacionados("La Parca", "The Reaper", R.drawable.reaper));
        lista_dioses.add(new lista_relacionados("El Moldeador", "The Shaper", R.drawable.shaper));
        lista_dioses.add(new lista_relacionados("El Tendero", "The Shopkeeper", R.drawable.comerciante));
        lista_dioses.add(new lista_relacionados("Las Tres Sombras", "The Three Shades", R.drawable.tres_sombras));
        lista_dioses.add(new lista_relacionados("Los Siete Invisibles", "The Unseen Seven", R.drawable.siete_ocultos));
        lista_dioses.add(new lista_relacionados("El Doliente", "The Wailing One", R.drawable.wailing_one));
        lista_dioses.add(new lista_relacionados("Trascendentales", "Transcendencies", R.drawable.trascendentes));
        lista_dioses.add(new lista_relacionados("Tyrian", "", R.drawable.tyrian));
        lista_dioses.add(new lista_relacionados("Uldorak", "", R.drawable.uldorak));
        lista_dioses.add(new lista_relacionados("Vahdrak", "", R.drawable.vahdrak));
        lista_dioses.add(new lista_relacionados("Verodicia", "", R.drawable.verodicia));
        lista_dioses.add(new lista_relacionados("Vulcano", "Vulcan", R.drawable.vulcano));
        lista_dioses.add(new lista_relacionados("WorldWyrm", "", R.drawable.worldwyrm));
        lista_dioses.add(new lista_relacionados("Zal", "", R.drawable.zal));
        return lista_dioses;
    }

    private void initListener() {
        svSearch_dioses.setOnQueryTextListener(this);
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
            Intent intent = new Intent(getContext(), detalle_dioses.class);
            intent.putExtra("itemDetail", item);
            getContext().startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void anuncio_banenr(View view) {
        MobileAds.initialize(getActivity(), initializationStatus -> {
        });
        mAdView = view.findViewById(R.id.adView_dioses);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}