package com.orizevtechnologies.historia_de_dota_2.fragmentPrincipal;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
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
import com.orizevtechnologies.historia_de_dota_2.Detalle.detalle_razas;
import com.orizevtechnologies.historia_de_dota_2.listas.RecyclerAdapter_razas;
import com.orizevtechnologies.historia_de_dota_2.listas.lista_relacionados;
import com.orizevtechnologies.historia_de_dota_2.R;

import java.util.ArrayList;
import java.util.List;

public class razas extends Fragment implements RecyclerAdapter_razas.RecyclerItemClick, SearchView.OnQueryTextListener {

    private AdView mAdView;
    private RecyclerView rvLista_razas;
    private SearchView svSearch_razas;
    private RecyclerAdapter_razas adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_razas, container, false);

        initViews(view);
        initValues();
        initListener();
        anuncio_banenr(view);

        return view;
    }

    private void initViews(View view) {

        rvLista_razas = view.findViewById(R.id.recycler_view_razas);
        svSearch_razas = view.findViewById(R.id.svSearch_razas);
        svSearch_razas.setIconifiedByDefault(false);

    }

    private void initValues() {

        //LinearLayoutManager manager = new LinearLayoutManager(getContext());

        GridLayoutManager manager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);

        rvLista_razas.setLayoutManager(manager);

        List<lista_relacionados> items = getItems();
        adapter = new RecyclerAdapter_razas(items, this);


        rvLista_razas.setAdapter(adapter);

    }

    private List<lista_relacionados> getItems() {

        List<lista_relacionados> lista__razas__es = new ArrayList<>();

        lista__razas__es.add(new lista_relacionados("Centauros", "Centaurs", R.drawable.centauro));
        lista__razas__es.add(new lista_relacionados("Criaturas de las Oscuridad", "Creatures of Darkness", R.drawable.oscuridad));
        lista__razas__es.add(new lista_relacionados("Cocodrilianos", "Crocodylians", R.drawable.cocodrilianos));
        lista__razas__es.add(new lista_relacionados("Demonios", "Demons", R.drawable.demonios));
        lista__razas__es.add(new lista_relacionados("Dragones (Sangre de Dragón)", "Dragons (Dragon's Blood)", R.drawable.dragones_db));
        lista__razas__es.add(new lista_relacionados("Dragones", "Dragons", R.drawable.dragones));
        lista__razas__es.add(new lista_relacionados("Drows", "", R.drawable.drow));
        lista__razas__es.add(new lista_relacionados("Eimermoles", "", R.drawable.eimermole));
        lista__razas__es.add(new lista_relacionados("Elementales", "Elementals", R.drawable.elementales));
        lista__razas__es.add(new lista_relacionados("Elfos", "Elfs", R.drawable.elfos));
        lista__razas__es.add(new lista_relacionados("Hadas", "Faerys", R.drawable.fae));
        lista__razas__es.add(new lista_relacionados("Dragones Faéricos", "Faerie Dragons", R.drawable.dragones_faericos));
        lista__razas__es.add(new lista_relacionados("Greevils", "", R.drawable.greevils));
        lista__razas__es.add(new lista_relacionados("Arpías", "Harpys", R.drawable.arpias));
        lista__razas__es.add(new lista_relacionados("Osos Infernales", "Hellbears", R.drawable.osos_infernales));
        lista__razas__es.add(new lista_relacionados("Humanos", "Humans", R.drawable.humanos));
        lista__razas__es.add(new lista_relacionados("Keens", "", R.drawable.keen));
        lista__razas__es.add(new lista_relacionados("Kobolds", "", R.drawable.kobolds));
        lista__razas__es.add(new lista_relacionados("Leviatanes", "Levianths", R.drawable.leviatanes));
        lista__razas__es.add(new lista_relacionados("Magnoceros", "", R.drawable.magnoceros));
        lista__razas__es.add(new lista_relacionados("Enmascarados", "Masked Ones", R.drawable.mascara));
        lista__razas__es.add(new lista_relacionados("Meranths", "", R.drawable.meranths));
        lista__razas__es.add(new lista_relacionados("Mushlings", "", R.drawable.mushling));
        lista__razas__es.add(new lista_relacionados("Nagas", "", R.drawable.naga));
        lista__razas__es.add(new lista_relacionados("Netherdrakes", "", R.drawable.netherdrakes));
        lista__razas__es.add(new lista_relacionados("Oglodis", "", R.drawable.oglodi));
        lista__razas__es.add(new lista_relacionados("Ogros", "Ogres", R.drawable.ogro));
        lista__razas__es.add(new lista_relacionados("Merodeadores", "Prowlers", R.drawable.powlers));
        lista__razas__es.add(new lista_relacionados("Dragones Pyrexae", "Pyrexae Dragons", R.drawable.pyroxae_dragons));
        lista__razas__es.add(new lista_relacionados("Sátiros", "Satyrs", R.drawable.satiros));
        lista__razas__es.add(new lista_relacionados("Skywraths", "", R.drawable.skywraths));
        lista__razas__es.add(new lista_relacionados("Slithereen", "", R.drawable.slardar));
        lista__razas__es.add(new lista_relacionados("Smeevils", "", R.drawable.smeevils));
        lista__razas__es.add(new lista_relacionados("Estrellas", "Stars", R.drawable.estrellas));
        lista__razas__es.add(new lista_relacionados("Gigantes de Piedra", "Stone Giants", R.drawable.gigantes_piedra));
        lista__razas__es.add(new lista_relacionados("Titanes", "Titans", R.drawable.titans));
        lista__razas__es.add(new lista_relacionados("Protectores Treant", "Treant Protectors", R.drawable.treants));
        lista__razas__es.add(new lista_relacionados("Trolls", "", R.drawable.trolls));
        lista__razas__es.add(new lista_relacionados("Ursine", "", R.drawable.ursa));
        lista__razas__es.add(new lista_relacionados("Tejedores", "Weavers", R.drawable.weaver));
        lista__razas__es.add(new lista_relacionados("Escarabajos Zealots", "Zealots Scarabs", R.drawable.nyx));








        return lista__razas__es;
    }


    private void initListener() {
        svSearch_razas.setOnQueryTextListener(this);
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
            Intent intent = new Intent(getContext(), detalle_razas.class);
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

        mAdView = view.findViewById(R.id.adView_razas);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

}