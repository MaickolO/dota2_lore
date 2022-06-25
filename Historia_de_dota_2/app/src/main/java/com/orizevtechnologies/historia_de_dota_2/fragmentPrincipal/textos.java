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
import com.orizevtechnologies.historia_de_dota_2.Detalle.detalle_textos;
import com.orizevtechnologies.historia_de_dota_2.R;
import com.orizevtechnologies.historia_de_dota_2.listas.RecyclerAdapter_Textos;
import com.orizevtechnologies.historia_de_dota_2.listas.lista_relacionados;

import java.util.ArrayList;
import java.util.List;

public class textos extends Fragment implements RecyclerAdapter_Textos.RecyclerItemClick, SearchView.OnQueryTextListener{

    private AdView mAdView;
    private RecyclerView rvLista_textos;
    private SearchView svSearch_textos;
    private RecyclerAdapter_Textos adapter;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_textos, container, false);

        initViews(view);
        initValues();
        initListener();
        anuncio_banenr(view);

        return view;
    }


    private void initViews(View view) {
        rvLista_textos = view.findViewById(R.id.recycler_view_textos);
        svSearch_textos = view.findViewById(R.id.svSearch_textos);
        svSearch_textos.setIconifiedByDefault(false);
    }


    private void initValues() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        rvLista_textos.setLayoutManager(manager);
        List<lista_relacionados> items = getItems();
        adapter = new RecyclerAdapter_Textos(items, this);
        rvLista_textos.setAdapter(adapter);
    }


    private List<lista_relacionados> getItems() {

        List<lista_relacionados> lista_textos = new ArrayList<>();

        lista_textos.add(new lista_relacionados("Grimorio Negro", "Black Grimoire", R.drawable.grimorio_negro));
        lista_textos.add(new lista_relacionados("Libro de los Cielos", "Book of Heavens", R.drawable.libro_cielos));
        lista_textos.add(new lista_relacionados("Eddas de los Eldwurm", "Eldwurm Eddas", R.drawable.eldwurm_edda));
        lista_textos.add(new lista_relacionados("Tomo Graven", "Graventome", R.drawable.graven_tome));
        lista_textos.add(new lista_relacionados("Pergaminos de Haize", "Scrolls of Haize", R.drawable.pergaminos_haize));
        lista_textos.add(new lista_relacionados("Niebla Roja, Pasion Roja", "Red Mist, Red passion", R.drawable.goodkind));
        lista_textos.add(new lista_relacionados("Tael'Am", "Tael'Am", R.drawable.tael));
        lista_textos.add(new lista_relacionados("La Recompensa por la Muerte", "The Death bounty", R.drawable.recompensa_muerte));
        lista_textos.add(new lista_relacionados("Crepúsculo en la Fortaleza de Khorvin Wenn", "Twilight in the Keep of Khorvin Wenn", R.drawable.crepusculo));
        lista_textos.add(new lista_relacionados("Códice de la Vigilia", "Vigil Codex", R.drawable.codice_vigilia));

        return lista_textos;
    }


    private void initListener() {
        svSearch_textos.setOnQueryTextListener(this);
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
            Intent intent = new Intent(getContext(), detalle_textos.class);
            intent.putExtra("itemDetail", item);
            getContext().startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void anuncio_banenr(View view) {
        MobileAds.initialize(getActivity(), initializationStatus -> {
        });
        mAdView = view.findViewById(R.id.adView_textos);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }


}