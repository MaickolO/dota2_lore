package com.orizevtechnologies.historia_de_dota_2.Detalle;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.orizevtechnologies.historia_de_dota_2.listas.RecyclerAdapter_rel_heroes;
import com.orizevtechnologies.historia_de_dota_2.listas.RecyclerAdapter_rel_mundo;
import com.orizevtechnologies.historia_de_dota_2.listas.RecyclerAdapter_rel_raza;
import com.orizevtechnologies.historia_de_dota_2.listas.lista_relacionados;
import com.orizevtechnologies.historia_de_dota_2.R;

import java.util.ArrayList;
import java.util.List;

public class detalle_heroe extends AppCompatActivity implements RecyclerAdapter_rel_raza.RecyclerItemClick,
        RecyclerAdapter_rel_heroes.RecyclerItemClick_heroes, RecyclerAdapter_rel_mundo.RecyclerItemClick_mundo {

    private ImageView imgItemDetail;
    private ImageView imgFondo;
    private TextView nombre_heroe;
    private TextView apodo_heroe;
    private TextView frase_heroe;
    private String titpag;

    private TextView texto1;
    private TextView texto2;
    private TextView texto3;
    private TextView texto4;
    private TextView texto5;
    private TextView texto6;
    private TextView texto7;
    private TextView texto8;

    private TextView titulo1;
    private TextView titulo2;
    private TextView titulo3;
    private TextView titulo4;
    private TextView titulo5;
    private TextView titulo6;
    private TextView titulo7;

    private LinearLayout layout1;
    private LinearLayout layout2;
    private LinearLayout layout3;
    private LinearLayout layout4;
    private LinearLayout layout5;
    private LinearLayout layout6;
    private LinearLayout layout7;
    
    
    private LinearLayout layout_rel_mundo;
    private LinearLayout layout_detmundo_rel_razas;
    private LinearLayout layout_detmundo_rel_mundo;
    private LinearLayout layout_detmundo_rel_heroes;

    private InterstitialAd mInterstitialAd;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_heroe);

        try {
            initViews();
            initValues();
            ActionBar();
            rel_razas();
            anuncio_banenr();
            //inter_det_heroe();
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }



    }

    private void anuncio_banenr() {

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView_det_heroe);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }


    private void initViews() {
        imgItemDetail = findViewById(R.id.imagen_heroe_detalle);
        imgFondo = findViewById(R.id.fondo_heroe_detalle);
        nombre_heroe = findViewById(R.id.nombre_heroe_detalle);
        apodo_heroe = findViewById(R.id.apodo_heroe_detalle);
        frase_heroe = findViewById(R.id.frase_heroe_detalle);

        texto1 = findViewById(R.id.det_heroe_texto1);
        texto2 = findViewById(R.id.det_heroe_texto2);
        texto3 = findViewById(R.id.det_heroe_texto3);
        texto4 = findViewById(R.id.det_heroe_texto4);
        texto5 = findViewById(R.id.det_heroe_texto5);
        texto6 = findViewById(R.id.det_heroe_texto6);
        texto7 = findViewById(R.id.det_heroe_texto7);
        texto8 = findViewById(R.id.det_heroe_texto8);

        titulo1 = findViewById(R.id.det_heroe_titulo1);
        titulo2 = findViewById(R.id.det_heroe_titulo2);
        titulo3 = findViewById(R.id.det_heroe_titulo3);
        titulo4 = findViewById(R.id.det_heroe_titulo4);
        titulo5 = findViewById(R.id.det_heroe_titulo5);
        titulo6 = findViewById(R.id.det_heroe_titulo6);
        titulo7 = findViewById(R.id.det_heroe_titulo7);

        layout1 = findViewById(R.id.det_heroe_layout1);
        layout2 = findViewById(R.id.det_heroe_layout2);
        layout3 = findViewById(R.id.det_heroe_layout3);
        layout4 = findViewById(R.id.det_heroe_layout4);
        layout5 = findViewById(R.id.det_heroe_layout5);
        layout6 = findViewById(R.id.det_heroe_layout6);
        layout7 = findViewById(R.id.det_heroe_layout7);
        
        layout_rel_mundo = findViewById(R.id.layout_rel_heroe);
        layout_detmundo_rel_razas = findViewById(R.id.layout_detheroe_rel_razas);
        layout_detmundo_rel_mundo = findViewById(R.id.layout_detheroe_rel_mundo);
        layout_detmundo_rel_heroes = findViewById(R.id.layout_detheroe_rel_heroes);
        
    }
    
    
    private void rel_razas() {

        //Relaciones Razas
        RecyclerView rvLista_mundo_rel_razas = findViewById(R.id.recycler_view_heroe_rel_razas);
        LinearLayoutManager manager_razas = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rvLista_mundo_rel_razas.setLayoutManager(manager_razas);
        List<lista_relacionados> items = getItems_razas();
        RecyclerAdapter_rel_raza adapter_razas = new RecyclerAdapter_rel_raza(items, this);
        rvLista_mundo_rel_razas.setAdapter(adapter_razas);

        //Relaciones Heroes
        RecyclerView rvLista_mundo_rel_heroes = findViewById(R.id.recycler_view_heroe_rel_heroe);
        LinearLayoutManager manager_heroes = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rvLista_mundo_rel_heroes.setLayoutManager(manager_heroes);
        List<lista_relacionados> items_heroes = getItems_heroes();
        RecyclerAdapter_rel_heroes adapter_heroes = new RecyclerAdapter_rel_heroes(items_heroes, this);
        rvLista_mundo_rel_heroes.setAdapter(adapter_heroes);

        //Relaciones Mundo
        RecyclerView rvLista_mundo_rel_mundo = findViewById(R.id.recycler_view_heroe_rel_mundo);
        LinearLayoutManager manager_mundo = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rvLista_mundo_rel_mundo.setLayoutManager(manager_mundo);
        List<lista_relacionados> items_mundo = getItems_mundo();
        RecyclerAdapter_rel_mundo adapter_mundo = new RecyclerAdapter_rel_mundo(items_mundo, this);
        rvLista_mundo_rel_mundo.setAdapter(adapter_mundo);

    }

    private List<lista_relacionados> getItems_razas() {

        List<lista_relacionados> lista__razas__es= new ArrayList<>();


        switch (titpag) {

            case "Abbadon":
                break;

            case "Razzil Darkbrew":
                lista__razas__es.add(new lista_relacionados("Keens", "", R.drawable.keen));
                lista__razas__es.add(new lista_relacionados("Ogros", "Ogres", R.drawable.ogro));
                break;

            case "Kaldr":
                break;

            case "Magina":
                lista__razas__es.add(new lista_relacionados("Humanos", "Humans", R.drawable.humanos));
                break;

            case "Zet":
                break;

            case "Mogul Khan":
                lista__razas__es.add(new lista_relacionados("Oglodis", "", R.drawable.oglodi));
                break;

            case "Atropos":
                lista__razas__es.add(new lista_relacionados("Elementales", "Elementals", R.drawable.elementales));
                break;

            case "Batrider":
                break;

            case "karroch":
                lista__razas__es.add(new lista_relacionados("Humanos", "Humans", R.drawable.humanos));
                break;

            case "Strygwyr":
                break;

            case "Gondar":
                lista__razas__es.add(new lista_relacionados("Ursine", "", R.drawable.ursa));

                break;

            case "Mangix":
                break;

            case "Rigwarl":
                break;

            case "Black Arachnia":
                break;

            case "Bradwarden":
                lista__razas__es.add(new lista_relacionados("Centauros", "Centaurs", R.drawable.centauro));
                break;

            case "Nessaj":
                break;

            case "Chen":
                lista__razas__es.add(new lista_relacionados("Humanos", "Humans", R.drawable.humanos));
                break;

            case "Clinkz":
                lista__razas__es.add(new lista_relacionados("Smeevils", "", R.drawable.smeevils));
                break;

            case "Rattlerap":
                lista__razas__es.add(new lista_relacionados("Keens", "", R.drawable.keen));
                break;

            case "Rylai":
                lista__razas__es.add(new lista_relacionados("Humanos", "Humans", R.drawable.humanos));
                break;

            case "Ish'kafel":
                break;

            case "Mireska Sunbreeze":
                lista__razas__es.add(new lista_relacionados("Hadas", "Faerys", R.drawable.fae));
                break;

            case "Valora":
                lista__razas__es.add(new lista_relacionados("Criaturas de las Oscuridad", "Creatures of Darkness", R.drawable.oscuridad));
                lista__razas__es.add(new lista_relacionados("Estrellas", "Stars", R.drawable.estrellas));
                break;

            case "Dazzle":
                lista__razas__es.add(new lista_relacionados("Trolls", "", R.drawable.trolls));
                break;

            case "Krobelus":
                break;

            case "Disruptor":
                lista__razas__es.add(new lista_relacionados("Oglodis", "", R.drawable.oglodi));
                break;

            case "Lucifer":
                lista__razas__es.add(new lista_relacionados("Demonios", "Demons", R.drawable.demonios));
                break;

            case "Davion":
                lista__razas__es.add(new lista_relacionados("Humanos", "Humans", R.drawable.humanos));
                lista__razas__es.add(new lista_relacionados("Dragones", "Dragons", R.drawable.dragones));
                break;

            case "Traxex":
                lista__razas__es.add(new lista_relacionados("Humanos", "Humans", R.drawable.humanos));
                lista__razas__es.add(new lista_relacionados("Drows", "", R.drawable.drow));
                break;

            case "Kaolin":
                break;

            case "Raigor Stonehoof":
                break;

            case "Elder Titan":
                break;

            case "Xin":
                break;

            case "Aiushtha":
                break;

            case "Enigma":
                lista__razas__es.add(new lista_relacionados("Estrellas", "Stars", R.drawable.estrellas));
                break;

            case "Darkterror":
                break;

            case "Astral":
                break;

            case "Aurel":
                lista__razas__es.add(new lista_relacionados("Keens", "", R.drawable.keen));
                break;

            case "Hoodwink":
                lista__razas__es.add(new lista_relacionados("Hadas", "Faerys", R.drawable.fae));
                lista__razas__es.add(new lista_relacionados("Keens", "", R.drawable.keen));
                break;

            case "Huskar":
                break;

            case "Carl":
                break;

            case "Io":
                break;

            case "Jakiro":
                lista__razas__es.add(new lista_relacionados("Dragones", "Dragons", R.drawable.dragones));
                break;

            case "Yurnero":
                lista__razas__es.add(new lista_relacionados("Enmascarados", "Masked Ones", R.drawable.mascara));
                lista__razas__es.add(new lista_relacionados("Demonios", "Demons", R.drawable.demonios));
                lista__razas__es.add(new lista_relacionados("Dragones", "Dragons", R.drawable.dragones));
                break;

            case "Ezalor":
                lista__razas__es.add(new lista_relacionados("Estrellas", "Stars", R.drawable.estrellas));
                break;

            case "Kunkka":
                lista__razas__es.add(new lista_relacionados("Humanos", "Humans", R.drawable.humanos));
                break;

            case "Tresdin":
                lista__razas__es.add(new lista_relacionados("Humanos", "Humans", R.drawable.humanos));
                lista__razas__es.add(new lista_relacionados("Demonios", "Demons", R.drawable.demonios));
                break;

            case "Leshrac":
                lista__razas__es.add(new lista_relacionados("Oglodis", "", R.drawable.oglodi));
                break;

            case "Ethreain":
                break;

            case "N'aix":
                lista__razas__es.add(new lista_relacionados("Oglodis", "", R.drawable.oglodi));
                break;

            case "Lina":
                lista__razas__es.add(new lista_relacionados("Dragones", "Dragons", R.drawable.dragones));
                lista__razas__es.add(new lista_relacionados("Humanos", "Humans", R.drawable.humanos));
                break;

            case "Lion":
                lista__razas__es.add(new lista_relacionados("Demonios", "Demons", R.drawable.demonios));
                break;

            case "Sylla":
                break;

            case "Luna":
                break;

            case "Banehallow":
                break;

            case "Magnus":
                lista__razas__es.add(new lista_relacionados("Magnoceros", "", R.drawable.magnoceros));
                lista__razas__es.add(new lista_relacionados("Merodeadores", "Prowlers", R.drawable.powlers));
                break;

            case "Marci":
                lista__razas__es.add(new lista_relacionados("Humanos", "Humans", R.drawable.humanos));
                break;

            case "Mars":
                break;

            case "Medusa":
                break;

            case "Meepo":
                break;

            case "Mirana":
                lista__razas__es.add(new lista_relacionados("Humanos", "Humans", R.drawable.humanos));
                break;

            case "Sun Wukong":
                break;

            case "Morphling":
                lista__razas__es.add(new lista_relacionados("Elementales", "Elementals", R.drawable.elementales));
                break;

            case "Slithice":
                lista__razas__es.add(new lista_relacionados("Nagas", "", R.drawable.naga));
                lista__razas__es.add(new lista_relacionados("Slithereen", "", R.drawable.slardar));
                lista__razas__es.add(new lista_relacionados("Leviatanes", "Levianths", R.drawable.leviatanes));
                break;

            case "Furion":
                break;

            case "Rotund'jere":
                break;

            case "Balanar":
                lista__razas__es.add(new lista_relacionados("Criaturas de las Oscuridad", "Creatures of Darkness", R.drawable.oscuridad));
                break;

            case "Nyx Assassin":
                lista__razas__es.add(new lista_relacionados("Escarabajos Zealots", "Zealots Scarabs", R.drawable.nyx));
                break;

            case "Aggron Stonebreak":
                lista__razas__es.add(new lista_relacionados("Ogros", "Ogres", R.drawable.ogro));
                break;

            case "Purist Thunderwrath":
                break;

            case "Nerif":
                break;

            case "Harbinger":
                break;

            case "Donté Panlin":
                break;

            case "Mortred":
                break;

            case "Azwraith":
                break;

            case "Phoenix":
                lista__razas__es.add(new lista_relacionados("Estrellas", "Stars", R.drawable.estrellas));
                lista__razas__es.add(new lista_relacionados("Elementales", "Elementals", R.drawable.elementales));
                break;

            case "Primal Beast":
                break;

            case "Puck":
                lista__razas__es.add(new lista_relacionados("Dragones Faéricos", "Faerie Dragons", R.drawable.dragones_faericos));
                break;

            case "Pudge":
                lista__razas__es.add(new lista_relacionados("Humanos", "Humans", R.drawable.humanos));
                break;

            case "Pugna":
                break;

            case "Akasha":
                break;

            case "Razor":
                break;

            case "Riki":
                break;

            case "Rubick":
                break;

            case "Cryxalis":
                break;

            case "shadow Demon":
                lista__razas__es.add(new lista_relacionados("Demonios", "Demons", R.drawable.demonios));
                break;

            case "Nevermore":
                lista__razas__es.add(new lista_relacionados("Demonios", "Demons", R.drawable.demonios));
                break;

            case "Rhasta":
                lista__razas__es.add(new lista_relacionados("Trolls", "", R.drawable.trolls));
                break;

            case "Nortrom":
                break;

            case "Dragonus":
                lista__razas__es.add(new lista_relacionados("Skywraths", "", R.drawable.skywraths));
                break;

            case "Slardar":
                lista__razas__es.add(new lista_relacionados("Slithereen", "", R.drawable.slardar));
                lista__razas__es.add(new lista_relacionados("Nagas", "", R.drawable.naga));
                break;

            case "Slark":
                lista__razas__es.add(new lista_relacionados("Slithereen", "", R.drawable.slardar));
                lista__razas__es.add(new lista_relacionados("Meranths", "", R.drawable.meranths));
                break;

            case "Beatrix Snapfire":
                lista__razas__es.add(new lista_relacionados("Keens", "", R.drawable.keen));
                break;

            case "Kardel Sharpeye":
                lista__razas__es.add(new lista_relacionados("Keens", "", R.drawable.keen));
                break;

            case "Mercurial":
                break;

            case "Barathrum":
                lista__razas__es.add(new lista_relacionados("Elementales", "Elementals", R.drawable.elementales));
                break;

            case "Raijin Thunderkeg":
                break;

            case "Sven":
                lista__razas__es.add(new lista_relacionados("Meranths", "", R.drawable.meranths));
                lista__razas__es.add(new lista_relacionados("Humanos", "Humans", R.drawable.humanos));
                break;

            case "Squee, Spleen y Spoon":
                lista__razas__es.add(new lista_relacionados("Keens", "", R.drawable.keen));
                break;

            case "Lanaya":
                break;

            case "Terrorblade":
                lista__razas__es.add(new lista_relacionados("Demonios", "Demons", R.drawable.demonios));
                break;

            case "Leviathan":
                lista__razas__es.add(new lista_relacionados("Leviatanes", "Levianths", R.drawable.leviatanes));
                break;

            case "Rizzrack":
                lista__razas__es.add(new lista_relacionados("Keens", "", R.drawable.keen));
                break;

            case "Boush":
                lista__razas__es.add(new lista_relacionados("Keens", "", R.drawable.keen));
                break;

            case "Tiny":
                lista__razas__es.add(new lista_relacionados("Gigantes de Piedra", "Stone Giants", R.drawable.gigantes_piedra));
                break;

            case "Rooftrellen":
                lista__razas__es.add(new lista_relacionados("Protectores Treant", "Treant Protectors", R.drawable.treants));
                break;

            case "Jah'rakal":
                lista__razas__es.add(new lista_relacionados("Trolls", "", R.drawable.trolls));
                lista__razas__es.add(new lista_relacionados("Keens", "", R.drawable.keen));
                lista__razas__es.add(new lista_relacionados("Oglodis", "", R.drawable.oglodi));
                break;

            case "Ymir":
                break;

            case "Vrogros":
                lista__razas__es.add(new lista_relacionados("Demonios", "Demons", R.drawable.demonios));
                break;

            case "Undying":
                break;

            case "Ulfsaar":
                lista__razas__es.add(new lista_relacionados("Ursine", "", R.drawable.ursa));
                break;

            case "Shendelzare":
                lista__razas__es.add(new lista_relacionados("Skywraths", "", R.drawable.skywraths));
                break;

            case "Lesale Deathbringer":
                break;

            case "Viper":
                lista__razas__es.add(new lista_relacionados("Netherdrakes", "", R.drawable.netherdrakes));
                break;

            case "Visage":
                break;

            case "Inai":
                break;

            case "Demnok Lannik":
                lista__razas__es.add(new lista_relacionados("Oglodis", "", R.drawable.oglodi));
                lista__razas__es.add(new lista_relacionados("Demonios", "Demons", R.drawable.demonios));
                break;

            case "Skitskurr":
                lista__razas__es.add(new lista_relacionados("Tejedores", "Weavers", R.drawable.weaver));
                break;

            case "Lyralei":
                lista__razas__es.add(new lista_relacionados("Arpías", "Harpys", R.drawable.arpias));
                break;

            case "Auroth":
                lista__razas__es.add(new lista_relacionados("Dragones", "Dragons", R.drawable.dragones));
                break;

            case "Zharvakko":
                break;

            case "Ostarion":
                break;

            case "Zeus":
                lista__razas__es.add(new lista_relacionados("Titanes", "Titans", R.drawable.titans));
                break;

        }


        return lista__razas__es;
    }


    private List<lista_relacionados> getItems_heroes() {
        List<lista_relacionados> itemLists= new ArrayList<>();

        switch (titpag) {

            case "Abbadon":
                itemLists.add(new lista_relacionados("Nyx Assassin","Asesino de Nyx",R.drawable.perfil_nyx));
                break;

            case "Razzil Darkbrew":
                break;

            case "Kaldr":
                itemLists.add(new lista_relacionados("Enigma","Consumer of worlds",R.drawable.perfil_enigma));
                itemLists.add(new lista_relacionados("Rylai","Crystal Maiden",R.drawable.perfil_crystal));
                break;

            case "Magina":
                itemLists.add(new lista_relacionados("Nortrom","Silencer",R.drawable.perfil_silencer));
                break;

            case "Zet":
                itemLists.add(new lista_relacionados("Zeus","Lord of Heaven",R.drawable.perfil_zeus));
                break;

            case "Mogul Khan":
                itemLists.add(new lista_relacionados("Disruptor","Stormcrafter",R.drawable.perfil_disruptor));
                break;

            case "Atropos":
                break;

            case "Batrider":
                break;

            case "karroch":
                break;

            case "Strygwyr":
                break;

            case "Gondar":
                itemLists.add(new lista_relacionados("Meepo","Geomancer",R.drawable.perfil_meepo));
                itemLists.add(new lista_relacionados("Donté Panlin","Pangolier",R.drawable.perfil_pangolier));
                break;

            case "Mangix":
                itemLists.add(new lista_relacionados("Raijin Thunderkeg","Storm Spirit",R.drawable.perfil_storm));
                itemLists.add(new lista_relacionados("Xin","Ember Spirit",R.drawable.perfil_ember));
                itemLists.add(new lista_relacionados("Kaolin","Earth Spirit",R.drawable.perfil_earth));
                itemLists.add(new lista_relacionados("Inai","Void Spirit",R.drawable.perfil_void));
                break;

            case "Rigwarl":
                itemLists.add(new lista_relacionados("Ymir","Tusk",R.drawable.perfil_tusk));
                break;

            case "Black Arachnia":
                itemLists.add(new lista_relacionados("Sun Wukong","Monkey King",R.drawable.perfil_monkey));
                break;

            case "Bradwarden":
                itemLists.add(new lista_relacionados("Disruptor","Stormcrafter",R.drawable.perfil_disruptor));
                break;

            case "Nessaj":
                itemLists.add(new lista_relacionados("Io","Wisp",R.drawable.perfil_io));
                itemLists.add(new lista_relacionados("Enigma","Consumer of worlds",R.drawable.perfil_enigma));
                itemLists.add(new lista_relacionados("Ezalor","Keeper of the Light",R.drawable.perfil_keeper));
                itemLists.add(new lista_relacionados("Elder Titan","Worldsmith",R.drawable.perfil_titan));
                itemLists.add(new lista_relacionados("Valora","Dawnbreaker",R.drawable.perfil_dawnbreaker));
                break;

            case "Chen":
                break;

            case "Clinkz":
                itemLists.add(new lista_relacionados("Beatrix Snapfire","Snapfire",R.drawable.perfil_snapfire));
                break;

            case "Rattlerap":
                itemLists.add(new lista_relacionados("Kardel Sharpeye","Sniper",R.drawable.perfil_sniper));
                itemLists.add(new lista_relacionados("Boush","Tinker",R.drawable.perfil_tinker));
                itemLists.add(new lista_relacionados("Beatrix Snapfire","Snapfire",R.drawable.perfil_snapfire));
                break;

            case "Rylai":
                itemLists.add(new lista_relacionados("Lina","Slayer",R.drawable.perfil_lina));
                itemLists.add(new lista_relacionados("Sven","Rogue Knight",R.drawable.perfil_sven));
                itemLists.add(new lista_relacionados("Ymir","Tusk",R.drawable.perfil_tusk));
                itemLists.add(new lista_relacionados("Auroth","Winter Wyvern",R.drawable.perfil_ww));
                itemLists.add(new lista_relacionados("Donté Panlin","Pangolier",R.drawable.perfil_pangolier));
                itemLists.add(new lista_relacionados("Kaldr","Ancient Aparition",R.drawable.perfil_ancient));
                itemLists.add(new lista_relacionados("Davion","Dragon Knight",R.drawable.perfil_dragon));
                break;

            case "Ish'kafel":
                break;

            case "Mireska Sunbreeze":
                itemLists.add(new lista_relacionados("Meepo","Geomancer",R.drawable.perfil_meepo));
                itemLists.add(new lista_relacionados("Puck","Faerie Dragon",R.drawable.perfil_puck));
                itemLists.add(new lista_relacionados("Magina","Anti-Mage", R.drawable.perfil_antimage));
                itemLists.add(new lista_relacionados("Nortrom","Silencer",R.drawable.perfil_silencer));
                itemLists.add(new lista_relacionados("Donté Panlin","Pangolier",R.drawable.perfil_pangolier));
                itemLists.add(new lista_relacionados("Gondar","Bounty Hunter", R.drawable.perfil_bounty));
                itemLists.add(new lista_relacionados("Darkterror","Faceless Void",R.drawable.perfil_faceless));
                itemLists.add(new lista_relacionados("Rhasta","Shadow Shaman",R.drawable.perfil_ss));
                itemLists.add(new lista_relacionados("Riki","Stealth Assassin",R.drawable.perfil_riki));
                itemLists.add(new lista_relacionados("Kunkka","Admiral",R.drawable.perfil_kunkka));
                itemLists.add(new lista_relacionados("Leviathan","Tidehunter",R.drawable.perfil_tide));
                break;

            case "Valora":
                itemLists.add(new lista_relacionados("Ezalor","Keeper of the Light",R.drawable.perfil_keeper));
                itemLists.add(new lista_relacionados("Io","Wisp",R.drawable.perfil_io));
                itemLists.add(new lista_relacionados("Nessaj","Chaos Knight",R.drawable.perfil_chaos));
                itemLists.add(new lista_relacionados("Phoenix","Fenix",R.drawable.perfil_fenix));
                itemLists.add(new lista_relacionados("Morphling","The Morphling",R.drawable.perfil_morphling));
                itemLists.add(new lista_relacionados("Mars","First Son of Heaven",R.drawable.perfil_mars));
                itemLists.add(new lista_relacionados("Balanar","Night Stalker",R.drawable.perfil_balanar));
                break;

            case "Dazzle":
                itemLists.add(new lista_relacionados("Huskar","Sacred Warrior",R.drawable.perfil_huskar));
                break;

            case "Krobelus":
                itemLists.add(new lista_relacionados("Rhasta","Shadow Shaman",R.drawable.perfil_ss));
                break;

            case "Disruptor":
                itemLists.add(new lista_relacionados("Donté Panlin","Pangolier",R.drawable.perfil_pangolier));
                break;

            case "Lucifer":
                itemLists.add(new lista_relacionados("Nevermore","Shadow Fiend",R.drawable.perfil_sf));
                itemLists.add(new lista_relacionados("shadow Demon","Demonio Sombrío",R.drawable.perfil_shadow));
                break;

            case "Davion":
                itemLists.add(new lista_relacionados("Jakiro","Twin Head Dragon",R.drawable.perfil_jakiro));
                itemLists.add(new lista_relacionados("Ethreain","Lich",R.drawable.perfil_lich));
                itemLists.add(new lista_relacionados("Puck","Faerie Dragon",R.drawable.perfil_puck));
                itemLists.add(new lista_relacionados("Auroth","Winter Wyvern",R.drawable.perfil_ww));
                break;

            case "Traxex":
                itemLists.add(new lista_relacionados("Pudge","Butcher",R.drawable.perfil_pudge));
                itemLists.add(new lista_relacionados("Slark","Nightcrawler",R.drawable.perfil_slark));
                itemLists.add(new lista_relacionados("Lyralei","Windranger",R.drawable.perfil_windranger));
                break;

            case "Kaolin":
                itemLists.add(new lista_relacionados("Raijin Thunderkeg","Storm Spirit",R.drawable.perfil_storm));
                itemLists.add(new lista_relacionados("Xin","Ember Spirit",R.drawable.perfil_ember));
                itemLists.add(new lista_relacionados("Inai","Void Spirit",R.drawable.perfil_void));
                itemLists.add(new lista_relacionados("Mangix","Brewmaster", R.drawable.perfil_brewmaster));
                itemLists.add(new lista_relacionados("Astral","Grimstroke",R.drawable.perfil_grimstroke));
                break;

            case "Raigor Stonehoof":
                itemLists.add(new lista_relacionados("Io","Wisp",R.drawable.perfil_io));
                itemLists.add(new lista_relacionados("Inai","Void Spirit",R.drawable.perfil_void));
                break;

            case "Elder Titan":
                itemLists.add(new lista_relacionados("Io","Wisp",R.drawable.perfil_io));
                itemLists.add(new lista_relacionados("Nessaj","Chaos Knight",R.drawable.perfil_chaos));
                itemLists.add(new lista_relacionados("Ezalor","Keeper of the Light",R.drawable.perfil_keeper));
                itemLists.add(new lista_relacionados("Enigma","Consumer of worlds",R.drawable.perfil_enigma));
                break;

            case "Xin":
                itemLists.add(new lista_relacionados("Raijin Thunderkeg","Storm Spirit",R.drawable.perfil_storm));
                itemLists.add(new lista_relacionados("Kaolin","Earth Spirit",R.drawable.perfil_earth));
                itemLists.add(new lista_relacionados("Inai","Void Spirit",R.drawable.perfil_void));
                itemLists.add(new lista_relacionados("Mangix","Brewmaster", R.drawable.perfil_brewmaster));
                itemLists.add(new lista_relacionados("Astral","Grimstroke",R.drawable.perfil_grimstroke));
                itemLists.add(new lista_relacionados("Yurnero","Juggernatur",R.drawable.perfil_jugg));
                break;

            case "Aiushtha":
                itemLists.add(new lista_relacionados("Ulfsaar","Ursa Warrior",R.drawable.perfil_ursa));
                itemLists.add(new lista_relacionados("Darkterror","Faceless Void",R.drawable.perfil_faceless));
                itemLists.add(new lista_relacionados("Donté Panlin","Pangolier",R.drawable.perfil_pangolier));
                break;

            case "Enigma":
                itemLists.add(new lista_relacionados("Nessaj","Chaos Knight",R.drawable.perfil_chaos));
                itemLists.add(new lista_relacionados("Ezalor","Keeper of the Light",R.drawable.perfil_keeper));
                itemLists.add(new lista_relacionados("Io","Wisp",R.drawable.perfil_io));
                itemLists.add(new lista_relacionados("Elder Titan","Worldsmith",R.drawable.perfil_titan));
                itemLists.add(new lista_relacionados("Kaldr","Ancient Aparition",R.drawable.perfil_ancient));
                break;

            case "Darkterror":
                itemLists.add(new lista_relacionados("Ish'kafel","Dark Seer",R.drawable.perfil_dark));
                itemLists.add(new lista_relacionados("Mireska Sunbreeze","Dark Willow",R.drawable.perfil_willow));
                break;

            case "Astral":
                itemLists.add(new lista_relacionados("Xin","Ember Spirit",R.drawable.perfil_ember));
                itemLists.add(new lista_relacionados("Kaolin","Earth Spirit",R.drawable.perfil_earth));
                itemLists.add(new lista_relacionados("Raijin Thunderkeg","Storm Spirit",R.drawable.perfil_storm));
                break;

            case "Aurel":
                break;

            case "Hoodwink":
                itemLists.add(new lista_relacionados("Bradwarden","Centaur Warruner",R.drawable.perfil_centaur));
                itemLists.add(new lista_relacionados("Chen","Holy Knight",R.drawable.perfil_chen));
                itemLists.add(new lista_relacionados("Aiushtha","Enchantress",R.drawable.perfil_enchantress));
                itemLists.add(new lista_relacionados("Leshrac","Tormented Soul",R.drawable.perfil_leshrac));
                itemLists.add(new lista_relacionados("Meepo","Geomancer",R.drawable.perfil_meepo));
                itemLists.add(new lista_relacionados("Furion","Nature's Prophet",R.drawable.perfil_nature));
                itemLists.add(new lista_relacionados("Primal Beast","Bestia Primordial",R.drawable.perfil_primal));
                break;

            case "Huskar":
                itemLists.add(new lista_relacionados("Dazzle","Shadow Priest",R.drawable.perfil_dazzle));
                itemLists.add(new lista_relacionados("Strygwyr","Bloodseeker", R.drawable.perfil_bloodseeker));
                break;

            case "Carl":
                itemLists.add(new lista_relacionados("Rubick","Grand Magus",R.drawable.perfil_rubick));
                itemLists.add(new lista_relacionados("Demnok Lannik","Warlock",R.drawable.perfil_warlock));
                itemLists.add(new lista_relacionados("Undying","Almighty Dirge",R.drawable.perfil_zombie));
                itemLists.add(new lista_relacionados("Akasha","Queen of Pain",R.drawable.perfil_qop));
                itemLists.add(new lista_relacionados("Puck","Faerie Dragon",R.drawable.perfil_puck));
                itemLists.add(new lista_relacionados("Mogul Khan","Axe", R.drawable.perfil_axe));
                itemLists.add(new lista_relacionados("Magina","Anti-Mage", R.drawable.perfil_antimage));
                break;

            case "Io":
                itemLists.add(new lista_relacionados("Nessaj","Chaos Knight",R.drawable.perfil_chaos));
                itemLists.add(new lista_relacionados("Ezalor","Keeper of the Light",R.drawable.perfil_keeper));
                itemLists.add(new lista_relacionados("Enigma","Consumer of worlds",R.drawable.perfil_enigma));
                itemLists.add(new lista_relacionados("Elder Titan","Worldsmith",R.drawable.perfil_titan));
                break;

            case "Jakiro":
                itemLists.add(new lista_relacionados("Auroth","Winter Wyvern",R.drawable.perfil_ww));
                break;

            case "Yurnero":
                itemLists.add(new lista_relacionados("Lanaya","Templar Assassin",R.drawable.perfil_templar));
                itemLists.add(new lista_relacionados("Sven","Rogue Knight",R.drawable.perfil_sven));
                itemLists.add(new lista_relacionados("Azwraith","Phantom Lancer",R.drawable.perfil_pl));
                itemLists.add(new lista_relacionados("Xin","Ember Spirit",R.drawable.perfil_ember));
                itemLists.add(new lista_relacionados("Mars","First Son of Heaven",R.drawable.perfil_mars));
                break;

            case "Ezalor":
                itemLists.add(new lista_relacionados("Nessaj","Chaos Knight",R.drawable.perfil_chaos));
                itemLists.add(new lista_relacionados("Io","Wisp",R.drawable.perfil_io));
                itemLists.add(new lista_relacionados("Enigma","Consumer of worlds",R.drawable.perfil_enigma));
                itemLists.add(new lista_relacionados("Elder Titan","Worldsmith",R.drawable.perfil_titan));
                itemLists.add(new lista_relacionados("Phoenix","Fenix",R.drawable.perfil_fenix));
                itemLists.add(new lista_relacionados("Valora","Dawnbreaker",R.drawable.perfil_dawnbreaker));
                itemLists.add(new lista_relacionados("Mars","First Son of Heaven",R.drawable.perfil_mars));
                itemLists.add(new lista_relacionados("Tiny","Stone Giant",R.drawable.perfil_tiny));
                break;

            case "Kunkka":
                itemLists.add(new lista_relacionados("Leviathan","Tidehunter",R.drawable.perfil_tide));
                itemLists.add(new lista_relacionados("Mireska Sunbreeze","Dark Willow",R.drawable.perfil_willow));
                break;

            case "Tresdin":
                itemLists.add(new lista_relacionados("Vrogros","Underlord",R.drawable.perfil_underlord));
                break;

            case "Leshrac":
                itemLists.add(new lista_relacionados("Astral","Grimstroke",R.drawable.perfil_grimstroke));
                itemLists.add(new lista_relacionados("Donté Panlin","Pangolier",R.drawable.perfil_pangolier));
                itemLists.add(new lista_relacionados("Hoodwink","Hoodwink",R.drawable.perfil_hoodwink));
                break;

            case "Ethreain":
                itemLists.add(new lista_relacionados("Lion","Demon Witch",R.drawable.perfil_lion));
                itemLists.add(new lista_relacionados("Rylai","Crystal Maiden",R.drawable.perfil_crystal));
                break;

            case "N'aix":
                break;

            case "Lina":
                itemLists.add(new lista_relacionados("Rylai","Crystal Maiden",R.drawable.perfil_crystal));
                itemLists.add(new lista_relacionados("Donté Panlin","Pangolier",R.drawable.perfil_pangolier));
                break;

            case "Lion":
                itemLists.add(new lista_relacionados("Nyx Assassin","Asesino de Nyx",R.drawable.perfil_nyx));
                itemLists.add(new lista_relacionados("Donté Panlin","Pangolier",R.drawable.perfil_pangolier));
                itemLists.add(new lista_relacionados("Magina","Anti-Mage", R.drawable.perfil_antimage));
                itemLists.add(new lista_relacionados("Nortrom","Silencer",R.drawable.perfil_silencer));
                itemLists.add(new lista_relacionados("Ethreain","Lich",R.drawable.perfil_lich));
                break;

            case "Sylla":
                itemLists.add(new lista_relacionados("Ulfsaar","Ursa Warrior",R.drawable.perfil_ursa));
                break;

            case "Luna":
                itemLists.add(new lista_relacionados("Mirana","Princess of the Moon",R.drawable.perfil_mirana));
                itemLists.add(new lista_relacionados("Beatrix Snapfire","Snapfire",R.drawable.perfil_snapfire));
                break;

            case "Banehallow":
                break;

            case "Magnus":
                itemLists.add(new lista_relacionados("Rooftrellen","Treant Protector",R.drawable.perfil_arbol));
                itemLists.add(new lista_relacionados("Sven","Rogue Knight",R.drawable.perfil_sven));
                break;

            case "Marci":
                itemLists.add(new lista_relacionados("Mirana","Princess of the Moon",R.drawable.perfil_mirana));
                itemLists.add(new lista_relacionados("Davion","Dragon Knight",R.drawable.perfil_dragon));
                itemLists.add(new lista_relacionados("Luna","Moon Rider",R.drawable.perfil_luna));
                break;

            case "Mars":
                itemLists.add(new lista_relacionados("Zeus","Lord of Heaven",R.drawable.perfil_zeus));
                itemLists.add(new lista_relacionados("Io","Wisp",R.drawable.perfil_io));
                itemLists.add(new lista_relacionados("Black Arachnia","Broodmother", R.drawable.perfil_broodmother));
                break;

            case "Medusa":
                itemLists.add(new lista_relacionados("Zeus","Lord of Heaven",R.drawable.perfil_zeus));
                itemLists.add(new lista_relacionados("Donté Panlin","Pangolier",R.drawable.perfil_pangolier));
                break;

            case "Meepo":
                itemLists.add(new lista_relacionados("Gondar","Bounty Hunter", R.drawable.perfil_bounty));
                itemLists.add(new lista_relacionados("Rubick","Grand Magus",R.drawable.perfil_rubick));
                itemLists.add(new lista_relacionados("Mireska Sunbreeze","Dark Willow",R.drawable.perfil_willow));
                break;

            case "Mirana":
                itemLists.add(new lista_relacionados("Luna","Moon Rider",R.drawable.perfil_luna));
                itemLists.add(new lista_relacionados("Davion","Dragon Knight",R.drawable.perfil_dragon));
                itemLists.add(new lista_relacionados("Marci","Marci",R.drawable.perfil_marci));
                itemLists.add(new lista_relacionados("Lina","Slayer",R.drawable.perfil_lina));
                break;

            case "Sun Wukong":
                itemLists.add(new lista_relacionados("karroch","Beastmaster", R.drawable.perfil_beastmaster));
                itemLists.add(new lista_relacionados("Razor","Lightning Revenant",R.drawable.perfil_razor));
                itemLists.add(new lista_relacionados("Leviathan","Tidehunter",R.drawable.perfil_tide));
                itemLists.add(new lista_relacionados("Xin","Ember Spirit",R.drawable.perfil_ember));
                itemLists.add(new lista_relacionados("Black Arachnia","Broodmother", R.drawable.perfil_broodmother));
                itemLists.add(new lista_relacionados("Banehallow","Lycan",R.drawable.perfil_lycan));
                break;

            case "Morphling":
                break;

            case "Slithice":
                itemLists.add(new lista_relacionados("Slardar","Slithereen Guard",R.drawable.perfil_slardar));
                break;

            case "Furion":
                itemLists.add(new lista_relacionados("Traxex","Drow Ranger",R.drawable.perfil_drow));
                itemLists.add(new lista_relacionados("Kaolin","Earth Spirit",R.drawable.perfil_earth));
                itemLists.add(new lista_relacionados("Raigor Stonehoof","Earthshaker",R.drawable.perfil_shaker));
                itemLists.add(new lista_relacionados("Hoodwink","Hoodwink",R.drawable.perfil_hoodwink));
                itemLists.add(new lista_relacionados("Sylla","Lone Druid",R.drawable.perfil_lone));
                itemLists.add(new lista_relacionados("Rooftrellen","Treant Protector",R.drawable.perfil_arbol));
                itemLists.add(new lista_relacionados("Lesale Deathbringer","Venomancer",R.drawable.perfil_veno));
                itemLists.add(new lista_relacionados("Lyralei","Windranger",R.drawable.perfil_windranger));
                break;

            case "Rotund'jere":
                itemLists.add(new lista_relacionados("Pudge","Butcher",R.drawable.perfil_pudge));
                break;

            case "Balanar":
                itemLists.add(new lista_relacionados("Ezalor","Keeper of the Light",R.drawable.perfil_keeper));
                itemLists.add(new lista_relacionados("Valora","Dawnbreaker",R.drawable.perfil_dawnbreaker));
                itemLists.add(new lista_relacionados("Inai","Void Spirit",R.drawable.perfil_void));
                break;

            case "Nyx Assassin":
                itemLists.add(new lista_relacionados("Black Arachnia","Broodmother", R.drawable.perfil_broodmother));
                itemLists.add(new lista_relacionados("Abbadon", "Lord of Avernus", R.drawable.perfil_abbadon));
                itemLists.add(new lista_relacionados("Lanaya","Templar Assassin",R.drawable.perfil_templar));
                itemLists.add(new lista_relacionados("Inai","Void Spirit",R.drawable.perfil_void));
                break;

            case "Aggron Stonebreak":
                break;

            case "Purist Thunderwrath":
                itemLists.add(new lista_relacionados("Nessaj","Chaos Knight",R.drawable.perfil_chaos));
                itemLists.add(new lista_relacionados("Luna","Moon Rider",R.drawable.perfil_luna));
                break;

            case "Nerif":
                itemLists.add(new lista_relacionados("Mortred","Phantom Assassin",R.drawable.perfil_pa));
                itemLists.add(new lista_relacionados("Ish'kafel","Dark Seer",R.drawable.perfil_dark));
                break;

            case "Harbinger":
                itemLists.add(new lista_relacionados("Raigor Stonehoof","Earthshaker",R.drawable.perfil_shaker));
                break;

            case "Donté Panlin":
                itemLists.add(new lista_relacionados("Leshrac","Tormented Soul",R.drawable.perfil_leshrac));
                itemLists.add(new lista_relacionados("Lion","Demon Witch",R.drawable.perfil_lion));
                itemLists.add(new lista_relacionados("Ulfsaar","Ursa Warrior",R.drawable.perfil_ursa));
                itemLists.add(new lista_relacionados("Rigwarl","Bristleback", R.drawable.perfil_bristleback));
                itemLists.add(new lista_relacionados("Gondar","Bounty Hunter", R.drawable.perfil_bounty));
                itemLists.add(new lista_relacionados("Disruptor","Stormcrafter",R.drawable.perfil_disruptor));
                itemLists.add(new lista_relacionados("Aiushtha","Enchantress",R.drawable.perfil_enchantress));
                itemLists.add(new lista_relacionados("Medusa","Gorgon",R.drawable.perfil_medusa));
                itemLists.add(new lista_relacionados("Mireska Sunbreeze","Dark Willow",R.drawable.perfil_willow));
                break;

            case "Mortred":
                itemLists.add(new lista_relacionados("Nerif","Oracle",R.drawable.perfil_oracle));
                break;

            case "Azwraith":
                itemLists.add(new lista_relacionados("Mireska Sunbreeze","Dark Willow",R.drawable.perfil_willow));
                itemLists.add(new lista_relacionados("Yurnero","Juggernatur",R.drawable.perfil_jugg));
                break;

            case "Phoenix":
                itemLists.add(new lista_relacionados("Ezalor","Keeper of the Light",R.drawable.perfil_keeper));
                itemLists.add(new lista_relacionados("Valora","Dawnbreaker",R.drawable.perfil_dawnbreaker));
                itemLists.add(new lista_relacionados("Beatrix Snapfire","Snapfire",R.drawable.perfil_snapfire));
                break;

            case "Primal Beast":
                itemLists.add(new lista_relacionados("Hoodwink","Hoodwink",R.drawable.perfil_hoodwink));
                break;

            case "Puck":
                itemLists.add(new lista_relacionados("Io","Wisp",R.drawable.perfil_io));
                itemLists.add(new lista_relacionados("Shendelzare","Vengeful Spirit",R.drawable.perfil_venge));
                itemLists.add(new lista_relacionados("Mireska Sunbreeze","Dark Willow",R.drawable.perfil_willow));
                break;

            case "Pudge":
                itemLists.add(new lista_relacionados("Traxex","Drow Ranger",R.drawable.perfil_drow));
                itemLists.add(new lista_relacionados("Slark","Nightcrawler",R.drawable.perfil_slark));
                break;

            case "Pugna":
                itemLists.add(new lista_relacionados("Viper","Netherdrake",R.drawable.perfil_viper));
                break;

            case "Akasha":
                itemLists.add(new lista_relacionados("Ostarion","Wraith King",R.drawable.perfil_wk));
                break;

            case "Razor":
                itemLists.add(new lista_relacionados("Raijin Thunderkeg","Storm Spirit",R.drawable.perfil_storm));
                itemLists.add(new lista_relacionados("Visage","Bound Form of Necro'lic",R.drawable.perfil_visage));
                break;

            case "Riki":
                itemLists.add(new lista_relacionados("Mireska Sunbreeze","Dark Willow",R.drawable.perfil_willow));
                break;

            case "Rubick":
                itemLists.add(new lista_relacionados("Meepo","Geomancer",R.drawable.perfil_meepo));
                itemLists.add(new lista_relacionados("Mireska Sunbreeze","Dark Willow",R.drawable.perfil_willow));
                itemLists.add(new lista_relacionados("Pudge","Butcher",R.drawable.perfil_pudge));
                break;

            case "Cryxalis":
                break;

            case "shadow Demon":
                itemLists.add(new lista_relacionados("Nevermore","Shadow Fiend",R.drawable.perfil_sf));
                itemLists.add(new lista_relacionados("Lucifer","Doom",R.drawable.perfil_doom));
                break;

            case "Nevermore":
                itemLists.add(new lista_relacionados("Lucifer","Doom",R.drawable.perfil_doom));
                itemLists.add(new lista_relacionados("shadow Demon","Demonio Sombrío",R.drawable.perfil_shadow));
                break;

            case "Rhasta":
                itemLists.add(new lista_relacionados("Slithice","Naga Siren",R.drawable.perfil_naga));
                itemLists.add(new lista_relacionados("Mireska Sunbreeze","Dark Willow",R.drawable.perfil_willow));
                break;

            case "Nortrom":
                itemLists.add(new lista_relacionados("Magina","Anti-Mage", R.drawable.perfil_antimage));
                break;

            case "Dragonus":
                itemLists.add(new lista_relacionados("Shendelzare","Vengeful Spirit",R.drawable.perfil_venge));
                itemLists.add(new lista_relacionados("Terrorblade","Demon Marauder",R.drawable.perfil_tb));
                break;

            case "Slardar":
                itemLists.add(new lista_relacionados("Slithice","Naga Siren",R.drawable.perfil_naga));
                break;

            case "Slark":
                itemLists.add(new lista_relacionados("Slithice","Naga Siren",R.drawable.perfil_naga));
                itemLists.add(new lista_relacionados("Traxex","Drow Ranger",R.drawable.perfil_drow));
                itemLists.add(new lista_relacionados("Pudge","Butcher",R.drawable.perfil_pudge));
                break;

            case "Beatrix Snapfire":
                itemLists.add(new lista_relacionados("Rizzrack","Timbersaw",R.drawable.perfil_timber));
                itemLists.add(new lista_relacionados("Rattlerap","Clockwerk",R.drawable.perfil_clockwerk));
                itemLists.add(new lista_relacionados("Kardel Sharpeye","Sniper",R.drawable.perfil_sniper));
                itemLists.add(new lista_relacionados("Boush","Tinker",R.drawable.perfil_tinker));
                itemLists.add(new lista_relacionados("Luna","Moon Rider",R.drawable.perfil_luna));
                itemLists.add(new lista_relacionados("Auroth","Winter Wyvern",R.drawable.perfil_ww));
                break;

            case "Kardel Sharpeye":
                itemLists.add(new lista_relacionados("Kardel Sharpeye","Sniper",R.drawable.perfil_sniper));
                break;

            case "Mercurial":
                itemLists.add(new lista_relacionados("Puck","Faerie Dragon",R.drawable.perfil_puck));
                itemLists.add(new lista_relacionados("Mireska Sunbreeze","Dark Willow",R.drawable.perfil_willow));
                itemLists.add(new lista_relacionados("Inai","Void Spirit",R.drawable.perfil_void));
                itemLists.add(new lista_relacionados("Azwraith","Phantom Lancer",R.drawable.perfil_pl));
                itemLists.add(new lista_relacionados("Meepo","Geomancer",R.drawable.perfil_meepo));
                break;

            case "Barathrum":
                break;

            case "Raijin Thunderkeg":
                itemLists.add(new lista_relacionados("Kaolin","Earth Spirit",R.drawable.perfil_earth));
                itemLists.add(new lista_relacionados("Xin","Ember Spirit",R.drawable.perfil_ember));
                itemLists.add(new lista_relacionados("Inai","Void Spirit",R.drawable.perfil_void));
                itemLists.add(new lista_relacionados("Mangix","Brewmaster", R.drawable.perfil_brewmaster));
                itemLists.add(new lista_relacionados("Razor","Lightning Revenant",R.drawable.perfil_razor));
                itemLists.add(new lista_relacionados("Astral","Grimstroke",R.drawable.perfil_grimstroke));
                itemLists.add(new lista_relacionados("Zeus","Lord of Heaven",R.drawable.perfil_zeus));
                break;

            case "Sven":
                itemLists.add(new lista_relacionados("Rylai","Crystal Maiden",R.drawable.perfil_crystal));
                itemLists.add(new lista_relacionados("Yurnero","Juggernatur",R.drawable.perfil_jugg));
                break;

            case "Squee, Spleen y Spoon":
                break;

            case "Lanaya":
                itemLists.add(new lista_relacionados("Inai","Void Spirit",R.drawable.perfil_void));
                itemLists.add(new lista_relacionados("Yurnero","Juggernatur",R.drawable.perfil_jugg));
                break;

            case "Terrorblade":
                itemLists.add(new lista_relacionados("Dragonus","Skywrarth Mage",R.drawable.perfil_sky));
                itemLists.add(new lista_relacionados("Aiushtha","Enchantress",R.drawable.perfil_enchantress));
                itemLists.add(new lista_relacionados("Demnok Lannik","Warlock",R.drawable.perfil_warlock));
                break;

            case "Leviathan":
                itemLists.add(new lista_relacionados("Kunkka","Admiral",R.drawable.perfil_kunkka));
                itemLists.add(new lista_relacionados("Mireska Sunbreeze","Dark Willow",R.drawable.perfil_willow));
                break;

            case "Rizzrack":
                itemLists.add(new lista_relacionados("Beatrix Snapfire","Snapfire",R.drawable.perfil_snapfire));
                itemLists.add(new lista_relacionados("Rooftrellen","Treant Protector",R.drawable.perfil_arbol));
                break;

            case "Boush":
                itemLists.add(new lista_relacionados("Beatrix Snapfire","Snapfire",R.drawable.perfil_snapfire));
                break;

            case "Tiny":
                break;

            case "Rooftrellen":
                itemLists.add(new lista_relacionados("Rizzrack","Timbersaw",R.drawable.perfil_timber));
                break;

            case "Jah'rakal":
                itemLists.add(new lista_relacionados("Rhasta","Shadow Shaman",R.drawable.perfil_ss));
                break;

            case "Ymir":
                itemLists.add(new lista_relacionados("Rigwarl","Bristleback", R.drawable.perfil_bristleback));
                itemLists.add(new lista_relacionados("Rylai","Crystal Maiden",R.drawable.perfil_crystal));
                break;

            case "Vrogros":
                itemLists.add(new lista_relacionados("Tresdin","Legion Commander",R.drawable.perfil_legion_commander));
                itemLists.add(new lista_relacionados("Nevermore","Shadow Fiend",R.drawable.perfil_sf));
                itemLists.add(new lista_relacionados("Akasha","Queen of Pain",R.drawable.perfil_qop));
                itemLists.add(new lista_relacionados("Mars","First Son of Heaven",R.drawable.perfil_mars));
                break;

            case "Undying":
                itemLists.add(new lista_relacionados("Mireska Sunbreeze","Dark Willow",R.drawable.perfil_willow));
                break;

            case "Ulfsaar":
                itemLists.add(new lista_relacionados("Aiushtha","Enchantress",R.drawable.perfil_enchantress));
                itemLists.add(new lista_relacionados("Donté Panlin","Pangolier",R.drawable.perfil_pangolier));
                break;

            case "Shendelzare":
                itemLists.add(new lista_relacionados("Dragonus","Skywrarth Mage",R.drawable.perfil_sky));
                itemLists.add(new lista_relacionados("Puck","Faerie Dragon",R.drawable.perfil_puck));
                break;

            case "Lesale Deathbringer":
                break;

            case "Viper":
                itemLists.add(new lista_relacionados("Pugna","Oblivion",R.drawable.perfil_pugna));
                itemLists.add(new lista_relacionados("Magina","Anti-Mage", R.drawable.perfil_antimage));
                itemLists.add(new lista_relacionados("Auroth","Winter Wyvern",R.drawable.perfil_ww));
                itemLists.add(new lista_relacionados("Ethreain","Lich",R.drawable.perfil_lich));
                itemLists.add(new lista_relacionados("Rylai","Crystal Maiden",R.drawable.perfil_crystal));
                itemLists.add(new lista_relacionados("Chen","Holy Knight",R.drawable.perfil_chen));
                itemLists.add(new lista_relacionados("Aiushtha","Enchantress",R.drawable.perfil_enchantress));
                itemLists.add(new lista_relacionados("Lina","Slayer",R.drawable.perfil_lina));
                break;

            case "Visage":
                itemLists.add(new lista_relacionados("Razor","Lightning Revenant",R.drawable.perfil_razor));
                break;

            case "Inai":
                itemLists.add(new lista_relacionados("Kaolin","Earth Spirit",R.drawable.perfil_earth));
                itemLists.add(new lista_relacionados("Raijin Thunderkeg","Storm Spirit",R.drawable.perfil_storm));
                itemLists.add(new lista_relacionados("Xin","Ember Spirit",R.drawable.perfil_ember));
                itemLists.add(new lista_relacionados("Lanaya","Templar Assassin",R.drawable.perfil_templar));
                itemLists.add(new lista_relacionados("Mercurial","Spectre",R.drawable.perfil_spectre));
                itemLists.add(new lista_relacionados("Raigor Stonehoof","Earthshaker",R.drawable.perfil_shaker));
                break;

            case "Demnok Lannik":
                itemLists.add(new lista_relacionados("Carl","Invoker",R.drawable.perfil_invoker));
                itemLists.add(new lista_relacionados("Mogul Khan","Axe", R.drawable.perfil_axe));
                itemLists.add(new lista_relacionados("Disruptor","Stormcrafter",R.drawable.perfil_disruptor));
                itemLists.add(new lista_relacionados("Rubick","Grand Magus",R.drawable.perfil_rubick));
                itemLists.add(new lista_relacionados("Aggron Stonebreak","Ogre Magi",R.drawable.perfil_ogre));
                break;

            case "Skitskurr":
                break;

            case "Lyralei":
                itemLists.add(new lista_relacionados("Traxex","Drow Ranger",R.drawable.perfil_drow));
                break;

            case "Auroth":
                itemLists.add(new lista_relacionados("Mogul Khan","Axe", R.drawable.perfil_axe));
                itemLists.add(new lista_relacionados("Rylai","Crystal Maiden",R.drawable.perfil_crystal));
                itemLists.add(new lista_relacionados("Davion","Dragon Knight",R.drawable.perfil_dragon));
                itemLists.add(new lista_relacionados("Jakiro","Twin Head Dragon",R.drawable.perfil_jakiro));
                itemLists.add(new lista_relacionados("Ethreain","Lich",R.drawable.perfil_lich));
                itemLists.add(new lista_relacionados("Viper","Netherdrake",R.drawable.perfil_viper));
                break;

            case "Zharvakko":
                break;

            case "Ostarion":
                itemLists.add(new lista_relacionados("Akasha","Queen of Pain",R.drawable.perfil_qop));
                break;

            case "Zeus":
                itemLists.add(new lista_relacionados("Mars","First Son of Heaven",R.drawable.perfil_mars));
                itemLists.add(new lista_relacionados("Medusa","Gorgon",R.drawable.perfil_medusa));
                itemLists.add(new lista_relacionados("Raijin Thunderkeg","Storm Spirit",R.drawable.perfil_storm));
                itemLists.add(new lista_relacionados("Rigwarl","Bristleback", R.drawable.perfil_bristleback));
                itemLists.add(new lista_relacionados("Zet","Arc Warden", R.drawable.perfil_arc));
                break;

        }

        return itemLists;
    }


    private List<lista_relacionados> getItems_mundo() {

        List<lista_relacionados> lista_mundo_es= new ArrayList<>();

        switch (titpag) {

            case "Abbadon":
                lista_mundo_es.add(new lista_relacionados("Fuente del Averno", "Font of Avernus", R.drawable.fuente_averno));
                break;

            case "Razzil Darkbrew":
                break;

            case "Kaldr":
                lista_mundo_es.add(new lista_relacionados("Archivos de Ultimyr", "Ultimyr Archives", R.drawable.archivos_ultimyr));
                break;

            case "Magina":
                lista_mundo_es.add(new lista_relacionados("Estado Tyler", "Tyler Estate", R.drawable.tyler_state));
                break;

            case "Zet":
                lista_mundo_es.add(new lista_relacionados("La Luna Loca", "The Mad Moon", R.drawable.fondo_luna));
                break;

            case "Mogul Khan":
                break;

            case "Atropos":
                break;

            case "Batrider":
                break;

            case "karroch":
                break;

            case "Strygwyr":
                break;

            case "Gondar":
                lista_mundo_es.add(new lista_relacionados("Basurero Centelleante", "Scintillant Waste", R.drawable.basurero_centelleante));
                lista_mundo_es.add(new lista_relacionados("Revtel", "Revtel", R.drawable.revtel));
                break;

            case "Mangix":
                break;

            case "Rigwarl":
                break;

            case "Black Arachnia":
                lista_mundo_es.add(new lista_relacionados("Monte Pyrotheos", "Mount Pyrotheos", R.drawable.monte_pyroteos));
                break;

            case "Bradwarden":
                lista_mundo_es.add(new lista_relacionados("Druud", "Druud", R.drawable.druud));
                break;

            case "Nessaj":
                break;

            case "Chen":
                break;

            case "Clinkz":
                lista_mundo_es.add(new lista_relacionados("El Horno", "The Hoven", R.drawable.hoven));
                lista_mundo_es.add(new lista_relacionados("Siete Planos", "Seven Planes", R.drawable.seven_planes));
                break;

            case "Rattlerap":
                break;

            case "Rylai":
                lista_mundo_es.add(new lista_relacionados("Fisura de Hielo", "Icewrack", R.drawable.icewrack));
                break;

            case "Ish'kafel":
                break;

            case "Mireska Sunbreeze":
                lista_mundo_es.add(new lista_relacionados("Revtel", "Revtel", R.drawable.revtel));
                lista_mundo_es.add(new lista_relacionados("Estado Tyler", "Tyler Estate", R.drawable.tyler_state));
                lista_mundo_es.add(new lista_relacionados("Rosa Llorona", "Weeping Rose", R.drawable.weeping_rose));
                lista_mundo_es.add(new lista_relacionados("Isla Temblorosa", "Trembling Isle", R.drawable.isla_temblorosa));
                break;

            case "Valora":
                break;

            case "Dazzle":
                lista_mundo_es.add(new lista_relacionados("Reino de Nothl", "Nothl Realm", R.drawable.nothl));
                break;

            case "Krobelus":
                break;

            case "Disruptor":
                lista_mundo_es.add(new lista_relacionados("Druud", "Druud", R.drawable.druud));
                break;

            case "Lucifer":
                lista_mundo_es.add(new lista_relacionados("Siete Infiernos", "Seven Hells", R.drawable.seven_hells));
                break;

            case "Davion":
                break;

            case "Traxex":
                break;

            case "Kaolin":
                break;

            case "Raigor Stonehoof":
                break;

            case "Elder Titan":
                lista_mundo_es.add(new lista_relacionados("Siete Planos", "Seven Planes", R.drawable.seven_planes));
                break;

            case "Xin":
                lista_mundo_es.add(new lista_relacionados("Fortaleza de las Llamas", "Fortress of Flares", R.drawable.fortaleza_llamas));
                break;

            case "Aiushtha":
                break;

            case "Enigma":
                lista_mundo_es.add(new lista_relacionados("Corazón de la Naturaleza", "Hearth of Nature", R.drawable.corazon_naturaleza));
                lista_mundo_es.add(new lista_relacionados("Siete Planos", "Seven Planes", R.drawable.seven_planes));
                break;

            case "Darkterror":
                lista_mundo_es.add(new lista_relacionados("Claszureme", "Claszureme", R.drawable.claszureme));
                break;

            case "Astral":
                lista_mundo_es.add(new lista_relacionados("Ashkavor", "Ashkavor", R.drawable.ashkavor));
                break;

            case "Aurel":
                lista_mundo_es.add(new lista_relacionados("Archivos de Ultimyr", "Ultimyr Archives", R.drawable.archivos_ultimyr));
                break;

            case "Hoodwink":
                break;

            case "Huskar":
                lista_mundo_es.add(new lista_relacionados("Reino de Nothl", "Nothl Realm", R.drawable.nothl));
                break;

            case "Carl":
                lista_mundo_es.add(new lista_relacionados("Archivos de Ultimyr", "Ultimyr Archives", R.drawable.archivos_ultimyr));
                break;

            case "Io":
                break;

            case "Jakiro":
                lista_mundo_es.add(new lista_relacionados("Monte Pyrotheos", "Mount Pyrotheos", R.drawable.monte_pyroteos));
                break;

            case "Yurnero":
                break;

            case "Ezalor":
                lista_mundo_es.add(new lista_relacionados("Reino de Nothl", "Nothl Realm", R.drawable.nothl));
                lista_mundo_es.add(new lista_relacionados("Siete Planos", "Seven Planes", R.drawable.seven_planes));
                break;

            case "Kunkka":
                lista_mundo_es.add(new lista_relacionados("Isla Temblorosa", "Trembling Isle", R.drawable.isla_temblorosa));
                break;

            case "Tresdin":
                lista_mundo_es.add(new lista_relacionados("Palacio de Piedra", "StoneHall", R.drawable.stonehall));
                lista_mundo_es.add(new lista_relacionados("Siete Infiernos", "Seven Hells", R.drawable.seven_hells));
                break;

            case "Leshrac":
                lista_mundo_es.add(new lista_relacionados("Corazón de la Naturaleza", "Hearth of Nature", R.drawable.corazon_naturaleza));
                break;

            case "Ethreain":
                break;

            case "N'aix":
                break;

            case "Lina":
                lista_mundo_es.add(new lista_relacionados("Desierto de la Anarquía", "Desert of Misrule", R.drawable.desierto_misrule));
                lista_mundo_es.add(new lista_relacionados("Basurero Centelleante", "Scintillant Waste", R.drawable.basurero_centelleante));
                break;

            case "Lion":
                lista_mundo_es.add(new lista_relacionados("Rosa Llorona", "Weeping Rose", R.drawable.weeping_rose));
                break;

            case "Sylla":
                break;

            case "Luna":
                lista_mundo_es.add(new lista_relacionados("Bosque de la Noche Plateada", "Nightsilver Woods", R.drawable.bosque_noche_plateada));
                break;

            case "Banehallow":
                break;

            case "Magnus":
                break;

            case "Marci":
                lista_mundo_es.add(new lista_relacionados("Bosque de la Noche Plateada", "Nightsilver Woods", R.drawable.bosque_noche_plateada));
                break;

            case "Mars":
                break;

            case "Medusa":
                break;

            case "Meepo":
                lista_mundo_es.add(new lista_relacionados("Ruinas de Grietas Sombrías", "Riftshadow Ruins", R.drawable.riftshadow_ruins));
                break;

            case "Mirana":
                lista_mundo_es.add(new lista_relacionados("Bosque de la Noche Plateada", "Nightsilver Woods", R.drawable.bosque_noche_plateada));
                break;

            case "Sun Wukong":
                lista_mundo_es.add(new lista_relacionados("Underscape", "Underscape", R.drawable.underscape));
                lista_mundo_es.add(new lista_relacionados("Bosque de la Noche Plateada", "Nightsilver Woods", R.drawable.bosque_noche_plateada));
                break;

            case "Morphling":
                lista_mundo_es.add(new lista_relacionados("Siete Planos", "Seven Planes", R.drawable.seven_planes));
                break;

            case "Slithice":
                break;

            case "Furion":
                break;

            case "Rotund'jere":
                lista_mundo_es.add(new lista_relacionados("Catedral de Rumusque", "Cathedral of Rumusque", R.drawable.catedral));
                lista_mundo_es.add(new lista_relacionados("Underscape", "Underscape", R.drawable.underscape));
                break;

            case "Balanar":
                break;

            case "Nyx Assassin":
                lista_mundo_es.add(new lista_relacionados("Archivos de Ultimyr", "Ultimyr Archives", R.drawable.archivos_ultimyr));
                break;

            case "Aggron Stonebreak":
                break;

            case "Purist Thunderwrath":
                lista_mundo_es.add(new lista_relacionados("Emauracus", "Emauracus", R.drawable.emauracus));
                break;

            case "Nerif":
                break;

            case "Harbinger":
                lista_mundo_es.add(new lista_relacionados("Mundo Exterior", "The Outworld", R.drawable.outworld));
                break;

            case "Donté Panlin":
                lista_mundo_es.add(new lista_relacionados("Revtel", "Revtel", R.drawable.revtel));
                break;

            case "Mortred":
                break;

            case "Azwraith":
                break;

            case "Phoenix":
                lista_mundo_es.add(new lista_relacionados("Basurero Centelleante", "Scintillant Waste", R.drawable.basurero_centelleante));
                break;

            case "Primal Beast":
                break;

            case "Puck":
                lista_mundo_es.add(new lista_relacionados("Claszureme", "Claszureme", R.drawable.claszureme));
                break;

            case "Pudge":
                lista_mundo_es.add(new lista_relacionados("Campos de la Matanza sin Fin", "Fields of Endless Carnage", R.drawable.campos_carniceria_sin_fin));
                lista_mundo_es.add(new lista_relacionados("Catedral de Rumusque", "Cathedral of Rumusque", R.drawable.catedral));
                break;

            case "Pugna":
                lista_mundo_es.add(new lista_relacionados("Confines Infernales", "Nether Reaches", R.drawable.confines_infernales));
                lista_mundo_es.add(new lista_relacionados("Estado Tyler", "Tyler Estate", R.drawable.tyler_state));
                lista_mundo_es.add(new lista_relacionados("Rosa Llorona", "Weeping Rose", R.drawable.weeping_rose));
                break;

            case "Akasha":
                break;

            case "Razor":
                lista_mundo_es.add(new lista_relacionados("Underscape", "Underscape", R.drawable.underscape));
                break;

            case "Riki":
                break;

            case "Rubick":
                break;

            case "Cryxalis":
                lista_mundo_es.add(new lista_relacionados("Basurero Centelleante", "Scintillant Waste", R.drawable.basurero_centelleante));
                break;

            case "shadow Demon":
                lista_mundo_es.add(new lista_relacionados("Siete Infiernos", "Seven Hells", R.drawable.seven_hells));
                break;

            case "Nevermore":
                lista_mundo_es.add(new lista_relacionados("Siete Infiernos", "Seven Hells", R.drawable.seven_hells));
                break;

            case "Rhasta":
                break;

            case "Nortrom":
                lista_mundo_es.add(new lista_relacionados("Estado Tyler", "Tyler Estate", R.drawable.tyler_state));
                break;

            case "Dragonus":
                break;

            case "Slardar":
                break;

            case "Slark":
                lista_mundo_es.add(new lista_relacionados("Arrecife Oscuro", "Dark Reef", R.drawable.arrecife_oscuro));
                break;

            case "Beatrix Snapfire":
                break;

            case "Kardel Sharpeye":
                lista_mundo_es.add(new lista_relacionados("Knollen", "Knollen", R.drawable.knollen));
                break;

            case "Mercurial":
                lista_mundo_es.add(new lista_relacionados("Siete Planos", "Seven Planes", R.drawable.seven_planes));
                lista_mundo_es.add(new lista_relacionados("Templo Escondido", "Hidden Temple", R.drawable.templo_oculto));
                break;

            case "Barathrum":
                lista_mundo_es.add(new lista_relacionados("Siete Planos", "Seven Planes", R.drawable.seven_planes));
                break;

            case "Raijin Thunderkeg":
                break;

            case "Sven":
                break;

            case "Squee, Spleen y Spoon":
                break;

            case "Lanaya":
                lista_mundo_es.add(new lista_relacionados("Templo Escondido", "Hidden Temple", R.drawable.templo_oculto));
                lista_mundo_es.add(new lista_relacionados("Meseta Violeta", "Violet Plateau", R.drawable.violet_plateau));
                break;

            case "Terrorblade":
                lista_mundo_es.add(new lista_relacionados("Foulfell", "Foulfell", R.drawable.foulfell));
                lista_mundo_es.add(new lista_relacionados("Siete Infiernos", "Seven Hells", R.drawable.seven_hells));
                break;

            case "Leviathan":
                lista_mundo_es.add(new lista_relacionados("Isla Temblorosa", "Trembling Isle", R.drawable.isla_temblorosa));
                break;

            case "Rizzrack":
                break;

            case "Boush":
                lista_mundo_es.add(new lista_relacionados("Meseta Violeta", "Violet Plateau", R.drawable.violet_plateau));
                break;

            case "Tiny":
                break;

            case "Rooftrellen":
                break;

            case "Jah'rakal":
                lista_mundo_es.add(new lista_relacionados("El Horno", "The Hoven", R.drawable.hoven));
                break;

            case "Ymir":
                lista_mundo_es.add(new lista_relacionados("Fisura de Hielo", "Icewrack", R.drawable.icewrack));
                break;

            case "Vrogros":
                lista_mundo_es.add(new lista_relacionados("Aziyog", "Aziyog", R.drawable.aziyog));
                lista_mundo_es.add(new lista_relacionados("Palacio de Piedra", "StoneHall", R.drawable.stonehall));
                lista_mundo_es.add(new lista_relacionados("Siete Infiernos", "Seven Hells", R.drawable.seven_hells));
                break;

            case "Undying":
                break;

            case "Ulfsaar":
                break;

            case "Shendelzare":
                break;

            case "Lesale Deathbringer":
                break;

            case "Viper":
                lista_mundo_es.add(new lista_relacionados("Confines Infernales", "Nether Reaches", R.drawable.confines_infernales));
                lista_mundo_es.add(new lista_relacionados("Rosa Llorona", "Weeping Rose", R.drawable.weeping_rose));
                break;

            case "Visage":
                lista_mundo_es.add(new lista_relacionados("Underscape", "Underscape", R.drawable.underscape));
                break;

            case "Inai":
                lista_mundo_es.add(new lista_relacionados("Templo Escondido", "Hidden Temple", R.drawable.templo_oculto));
                lista_mundo_es.add(new lista_relacionados("Siete Planos", "Seven Planes", R.drawable.seven_planes));
                break;

            case "Demnok Lannik":
                lista_mundo_es.add(new lista_relacionados("Archivos de Ultimyr", "Ultimyr Archives", R.drawable.archivos_ultimyr));
                break;

            case "Skitskurr":
                break;

            case "Lyralei":
                break;

            case "Auroth":
                lista_mundo_es.add(new lista_relacionados("Fisura de Hielo", "Icewrack", R.drawable.icewrack));
                break;

            case "Zharvakko":
                break;

            case "Ostarion":
                lista_mundo_es.add(new lista_relacionados("Imperio de Huesos", "Empire of Bone", R.drawable.empire_bone));
                break;

            case "Zeus":
                break;

        }

        return lista_mundo_es;
    }

    
    private void initValues(){

        lista_relacionados itemDetail = (lista_relacionados) getIntent().getExtras().getSerializable("itemDetail");
        imgItemDetail.setImageResource(itemDetail.getImg_principal());
        nombre_heroe.setText(itemDetail.getNombre_principal());
        apodo_heroe.setText(itemDetail.getNombre_secundario());
        titpag = (String) nombre_heroe.getText();

        texto();
        
    }

    private void texto() {

        switch (titpag) {

            case "Abbadon":
                parrafos2(R.drawable.fondo_abbadon,"Curiosidades");
                rel("heroe_mundo");
                break;

            case "Razzil Darkbrew":
                parrafos2(R.drawable.fondo_alchemist,"Descripción");
                rel("raza");
                break;

            case "Kaldr":
                parrafos5(R.drawable.fondo_ancient,"Descripción", "Personalidad", "Relaciones", "Poderes y Habilidades");
                rel("heroe_mundo");
                break;

            case "Magina":
                parrafos3(R.drawable.fondo_antimage,"Curiosidades", "Relaciones");
                rel("heroe_mundo_raza");
                break;

            case "Zet":
                parrafos7(R.drawable.fondo_arc,"Detalles", "Zet y los Ancestros", "Sundered Moon (Luna Separada)", "Nemestice", "Personalidad", "Relaciones");
                rel("heroe_mundo");
                break;

            case "Mogul Khan":
                parrafos6(R.drawable.fondo_axe,"Niebla Roja (Red Mist)", "El Último Castillo (Last Castle)", "La Jungla", "Curiosidades");
                rel("heroe_raza");
                break;

            case "Atropos":
                parrafos2(R.drawable.fondo_bane,"Curiosidades");
                rel("mundo");
                break;

            case "Batrider":
                parrafos1(R.drawable.fondo_batrider);
                rel("vacio");
                break;

            case "karroch":
                parrafos3(R.drawable.fondo_beastmaster,"El Ciervo Blanco", "Curiosidades");
                rel("raza");
                break;

            case "Strygwyr":
                parrafos7(R.drawable.fondo_bloodseeker,"Descripción", "Estudio de Gallows", "Artifact", "Personalidad", "Relaciones", "Fisiología");
                rel("vacio");
                break;

            case "Gondar":
                parrafos4(R.drawable.fondo_bounty,"El Segundo Discípulo", "Curiosidades", "Relaciones");
                rel("heroe_mundo_raza");
                break;

            case "Mangix":
                parrafos2(R.drawable.fondo_brewmaster,"Descripción");
                rel("heroe");
                break;

            case "Rigwarl":
                parrafos2(R.drawable.fondo_bristleback,"Curiosidades");
                rel("heroe");
                break;

            case "Black Arachnia":
                parrafos5(R.drawable.fondo_broodmother,"Curiosidades", "Adoración", "El Herrero", "Relaciones");
                rel("heroe_mundo");
                break;

            case "Bradwarden":
                parrafos4(R.drawable.fondo_centaur,"Descripción", "Curiosidades", "Relaciones");
                rel("heroe_mundo_raza");
                break;

            case "Nessaj":
                parrafos4(R.drawable.fondo_chaos,"El Cisma", "Curiosidades", "Relaciones");
                rel("heroe");
                break;

            case "Chen":
                parrafos1(R.drawable.fondo_chen);
                rel("raza");
                break;

            case "Clinkz":
                parrafos5(R.drawable.fondo_clinkz,"Descripción", "Maraxiform y la Vida Eterna", "Personalidad", "Relaciones");
                rel("heroe_mundo_raza");
                break;

            case "Rattlerap":
                parrafos3(R.drawable.fondo_clockwerk,"Curiosidades", "Relaciones");
                rel("heroe_raza");
                break;

            case "Rylai":
                parrafos5(R.drawable.fondo_crystal,"Personalidad", "El Mar Hirviente (The Boiling Sea)", "Curiosidades", "Relaciones");
                rel("heroe_mundo_raza");
                break;

            case "Ish'kafel":
                parrafos1(R.drawable.fondo_dark);
                rel("vacio");
                break;

            case "Mireska Sunbreeze":
                parrafos8(R.drawable.fondo_willow, "Huida y Persecución", "Viajes", "La Isla Temblorosa", "Fellstrath y los Mo'rokai", "Hobbies y Actividades");
                rel("heroe_mundo_raza");
                break;

            case "Valora":
                parrafos7(R.drawable.fondo_dawnbreaker,"Descripción", "Creación", "Misión", "Despertar", "Personalidad", "Relaciones");
                rel("heroe_raza");
                break;

            case "Dazzle":
                parrafos3(R.drawable.fondo_dazzle,"Curiosidades", "Relaciones");
                rel("heroe_mundo_raza");
                break;

            case "Krobelus":
                parrafos2(R.drawable.fondo_death,"Curiosidades");
                rel("heroe");
                break;

            case "Disruptor":
                parrafos2(R.drawable.fondo_disruptor,"Curiosidades");
                rel("heroe_mundo_raza");
                break;

            case "Lucifer":
                parrafos2(R.drawable.fondo_doom,"Curiosidades");
                rel("heroe_mundo_raza");
                break;

            case "Davion":
                parrafos3(R.drawable.fondo_dragon,"Curiosidades", "Dota: Sagre de Dragón");
                rel("heroe_raza");
                break;

            case "Traxex":
                parrafos4(R.drawable.fondo_drow,"El Árbol de Raíces Sangrientas", "Curiosidades", "Relaciones");
                rel("heroe_raza");
                break;

            case "Kaolin":
                parrafos4(R.drawable.fondo_earth,"Curiosidades", "Especulación", "Relaciones");
                rel("heroe");
                break;

            case "Raigor Stonehoof":
                parrafos4(R.drawable.fondo_earthshaker,"Descripción", "La Tierra Hermana", "Otros");
                rel("heroe");
                break;

            case "Elder Titan":
                parrafos2(R.drawable.fondo_titan,"Curiosidades");
                rel("heroe_mundo");
                break;

            case "Xin":
                parrafos3(R.drawable.fondo_ember,"Curiosidades", "Relaciones");
                rel("heroe_mundo");
                break;

            case "Aiushtha":
                parrafos3(R.drawable.fondo_enchantress,"Curiosidades", "Relaciones");
                rel("heroe");
                break;

            case "Enigma":
                parrafos4(R.drawable.fondo_enigma,"Curiosidades", "El Cisma", "La Invocación");
                rel("heroe_mundo_raza");
                break;

            case "Darkterror":
                parrafos2(R.drawable.fondo_faceless,"Curiosidades");
                rel("heroe_mundo");
                break;

            case "Astral":
                parrafos8(R.drawable.fondo_grimstroke, "Antecedentes", "La Ascención", "Regreso y Consecuencias", "La Amante", "Aficiones");
                rel("heroe_mundo");
                break;

            case "Aurel":
                parrafos3(R.drawable.fondo_gyrocopter,"Curiosidades", "Relaciones");
                rel("mundo_raza");
                break;

            case "Hoodwink":
                parrafos2(R.drawable.fondo_hoodwink,"Relaciones");
                rel("heroe_raza");
                break;

            case "Huskar":
                parrafos5(R.drawable.fondo_huskar,"Descripción", "Curiosidades", "El Pueblo de Huskar", "Relaciones");
                rel("heroe_mundo");
                break;

            case "Carl":
                parrafos8(R.drawable.fondo_invoker, "Vida Académica (Línea de Tiempo Original)", "Vida Académica (Línea de Tiempo Alterna)", "Post-Graduación", "Dota: Sangre de Dragón", "Personalidad");
                rel("heroe_mundo");
                break;

            case "Io":
                parrafos3(R.drawable.fondo_io,"Curiosidades", "Relaciones");
                rel("heroe");
                break;

            case "Jakiro":
                parrafos5(R.drawable.fondo_jakiro,"Descripción", "Jakiro, El Protector", "Personalidad", "Relaciones");
                rel("heroe_mundo_raza");
                break;

            case "Yurnero":
                parrafos7(R.drawable.fondo_jugg,"Descripción", "Antes del Destierro", "Destierro", "La Ruptura", "Personalidad", "Relaciones");
                rel("heroe_raza");
                break;

            case "Ezalor":
                parrafos6(R.drawable.fondo_keeper,"Descripción", "La Chispa de los Soles", "Guardián de la Luz del Norte", "Personalidad");
                rel("heroe_mundo_raza");
                break;

            case "Kunkka":
                parrafos4(R.drawable.fondo_kunkka,"Descripción", "Curiosidades", "Caza de Tiburones");
                rel("heroe_mundo_raza");
                break;

            case "Tresdin":
                parrafos4(R.drawable.fondo_legion_commander,"Curiosidades", "Roseleaf", "Relaciones");
                rel("heroe_mundo_raza");
                break;

            case "Leshrac":
                parrafos7(R.drawable.fondo_leshrac,"Descripción", "Motivos de Caos y Desequilibrio", "Nihilosofía", "Personalidad", "Relaciones", "Forma Física");
                rel("heroe_mundo_raza");
                break;

            case "Ethreain":
                rel("heroe");
                parrafos3(R.drawable.fondo_lich,"Artifact", "Curiosidades");
                break;

            case "N'aix":
                parrafos5(R.drawable.fondo_life,"Descripción", "Mejoras Viles", "Personalidad", "Relaciones");
                rel("raza");
                break;

            case "Lina":
                parrafos3(R.drawable.fondo_lina,"Curiosidades", "Relaciones");
                rel("heroe_mundo_raza");
                break;

            case "Lion":
                parrafos4(R.drawable.fondo_lion,"Curiosdades", "Relaciones", "Artifact");
                rel("heroe_mundo_raza");
                break;

            case "Sylla":
                parrafos2(R.drawable.fondo_lone,"Curiosidades");
                rel("heroe");
                break;

            case "Luna":
                parrafos3(R.drawable.fondo_luna,"Curiosidades", "Relaciones");
                rel("heroe_mundo");
                break;

            case "Banehallow":
                parrafos3(R.drawable.fondo_lycan,"Curiosidades", "Relaciones");
                rel("vacio");
                break;

            case "Magnus":
                parrafos5(R.drawable.fondo_magnus,"Descripción", "Artifact", "Personalidad", "Relaciones");
                rel("heroe_raza");
                break;

            case "Marci":
                parrafos2(R.drawable.fondo_marci,"Descripción");
                rel("heroe_mundo_raza");
                break;

            case "Mars":
                parrafos5(R.drawable.fondo_mars,"Curiosidades", "Batallas", "La Legión de Cenizas", "Relaciones");
                rel("heroe");
                break;

            case "Medusa":
                parrafos2(R.drawable.fondo_medusa,"Curiosidades");
                rel("heroe");
                break;

            case "Meepo":
                parrafos5(R.drawable.fondo_meepo,"Curiosidades", "Las Ruinas de Hueso", "El Meepo Perdido", "Relaciones");
                rel("heroe_mundo");
                break;

            case "Mirana":
                parrafos4(R.drawable.fondo_mirana,"Axia", "Dota: Sangre de Dragón", "Curiosidades");
                rel("heroe_mundo_raza");
                break;

            case "Sun Wukong":
                parrafos6(R.drawable.fondo_monkey,"Habilidades", "Jingu Bang", "Laberinto Estrecho", "Curiosidades");
                rel("heroe_mundo");
                break;

            case "Morphling":
                parrafos2(R.drawable.fondo_morphling,"Curiosidades");
                rel("mundo_raza");
                break;

            case "Slithice":
                parrafos2(R.drawable.fondo_naga,"Curiosidades");
                rel("heroe_raza");
                break;

            case "Furion":
                parrafos5(R.drawable.fondo_nature,"Descripción", "Batallas", "Personalidad", "Relaciones");
                rel("heroe");
                break;

            case "Rotund'jere":
                parrafos3(R.drawable.fondo_necrophos,"Curiosidades", "Relaciones");
                rel("heroe_mundo");
                break;

            case "Balanar":
                parrafos6(R.drawable.fondo_balanar,"Descripción", "Grilletes de Ra´hul", "Artifact", "Personalidad");
                rel("heroe_raza");
                break;

            case "Nyx Assassin":
                parrafos3(R.drawable.fondo_nyx,"Curiosidades", "Relaciones");
                rel("heroe_mundo_raza");
                break;

            case "Aggron Stonebreak":
                parrafos2(R.drawable.fondo_ogre,"Las Alondras de Fuego");
                rel("raza");
                break;

            case "Purist Thunderwrath":
                parrafos3(R.drawable.fondo_omniknight,"Curiosidades", "Artifact");
                rel("heroe_mundo");
                break;

            case "Nerif":
                parrafos7(R.drawable.fondo_oracle,"Descripción", "Origen", "El Contrato", "Artifact", "Dota: Sangre de Dragón", "Relaciones");
                rel("heroe");
                break;

            case "Harbinger":
                parrafos5(R.drawable.fondo_od,"Descripción", "Artifact", "Personalidad", "Relaciones");
                rel("heroe_mundo");
                break;

            case "Donté Panlin":
                parrafos7(R.drawable.fondo_pangolier,"Descripción", "Vida Temprana", "El Honor y los Nivan Gallants", "Aventuras", "Hobbies y Actividades", "Relaciones");
                rel("heroe_mundo");
                break;

            case "Mortred":
                parrafos2(R.drawable.fondo_pa,"Curiosidades");
                rel("heroe");
                break;

            case "Azwraith":
                parrafos3(R.drawable.fondo_pl,"Curiosidades", "Relaciones");
                rel("heroe");
                break;

            case "Phoenix":
                parrafos3(R.drawable.fondo_fenix,"Curiosidades", "Relaciones");
                rel("heroe_mundo_raza");
                break;

            case "Primal Beast":
                parrafos3(R.drawable.fondo_primal,"Descripción", "Personalidad");
                rel("heroe");
                break;

            case "Puck":
                parrafos2(R.drawable.fondo_puck,"Curiosidades");
                rel("heroe_mundo_raza");
                break;

            case "Pudge":
                parrafos7(R.drawable.fondo_pudge,"Antecedentes", "Hábitos", "Las Cadenas de la Absolución", "El Carnicero de Juguete", "Mascota", "Relaciones");
                rel("heroe_mundo_raza");
                break;

            case "Pugna":
                parrafos4(R.drawable.fondo_pugna,"Descripción", "El Brujo y el Netherdrake", "Artifact");
                rel("heroe_mundo");
                break;

            case "Akasha":
                parrafos1(R.drawable.fondo_qop);
                rel("heroe");
                break;

            case "Razor":
                parrafos2(R.drawable.fondo_razor,"Curiosidades");
                rel("heroe_mundo");
                break;

            case "Riki":
                parrafos3(R.drawable.fondo_riki,"Curiosidades", "Círculo de Jasper");
                rel("heroe");
                break;

            case "Rubick":
                parrafos4(R.drawable.fondo_rubick,"Curiosidades", "EL Rompecabezas de Perplex", "Relaciones");
                rel("heroe");
                break;

            case "Cryxalis":
                parrafos1(R.drawable.fondo_sk);
                rel("mundo");
                break;

            case "shadow Demon":
                parrafos2(R.drawable.fondo_shadow,"Curiosidades");
                rel("heroe_mundo_raza");
                break;

            case "Nevermore":
                parrafos3(R.drawable.fondo_sf,"Curiosidades", "Artifact");
                rel("heroe_mundo_raza");
                break;

            case "Rhasta":
                parrafos4(R.drawable.fondo_ss,"Curiosidades", "La Era Sórdida", "El Sacerdote Serpiente");
                rel("heroe_raza");
                break;

            case "Nortrom":
                parrafos2(R.drawable.fondo_silencer,"Curiosidades");
                rel("heroe_mundo");
                break;

            case "Dragonus":
                parrafos2(R.drawable.fondo_sky,"Curiosidades");
                rel("heroe_raza");
                break;

            case "Slardar":
                parrafos2(R.drawable.fondo_slardar,"Curiosidades");
                rel("heroe_raza");
                break;

            case "Slark":
                parrafos2(R.drawable.fondo_slark,"Curiosidades");
                rel("heroe_mundo_raza");
                break;

            case "Beatrix Snapfire":
                parrafos7(R.drawable.fondo_snapfire,"Descripción", "Familia", "Partida y Outlands", "Mortimer", "Regreso", "Relaciones");
                rel("heroe_raza");
                break;

            case "Kardel Sharpeye":
                parrafos2(R.drawable.fondo_sniper,"Curiosidades");
                rel("heroe_mundo_raza");
                break;

            case "Mercurial":
                parrafos4(R.drawable.fondo_spectre,"Curiosidades", "El Advenimiento Fantasmal", "Relaciones");
                rel("heroe_mundo");
                break;

            case "Barathrum":
                parrafos2(R.drawable.fondo_bara,"Curiosidades");
                rel("mundo_raza");
                break;

            case "Raijin Thunderkeg":
                parrafos5(R.drawable.fondo_storm,"Curiosidades", "Personalidad", "Relaciones", "Artifact");
                rel("heroe");
                break;

            case "Sven":
                parrafos4(R.drawable.fondo_sven,"Curiosidades", "Relaciones", "Artifact");
                rel("heroe_raza");
                break;

            case "Squee, Spleen y Spoon":
                parrafos2(R.drawable.fondo_techies,"Curiosidades");
                rel("raza");
                break;

            case "Lanaya":
                parrafos4(R.drawable.fondo_templar,"Curiosidades", "Relaciones", "La Familia Sunbreeze");
                rel("heroe_mundo");
                break;

            case "Terrorblade":
                parrafos2(R.drawable.fondo_tb,"Curiosidades");
                rel("heroe_mundo_raza");
                break;

            case "Leviathan":
                parrafos2(R.drawable.fondo_tide,"Curiosidades");
                rel("heroe_mundo_raza");
                break;

            case "Rizzrack":
                parrafos5(R.drawable.fondo_timber,"Familia", "Estado Mental", "Curiosidades", "Relaciones");
                rel("heroe_raza");
                break;

            case "Boush":
                parrafos4(R.drawable.fondo_tinker,"La Meseta Violeta", "Curiosidades", "Relaciones");
                rel("heroe_mundo_raza");
                break;

            case "Tiny":
                parrafos2(R.drawable.fondo_tiny,"Curiosidades");
                rel("raza");
                break;

            case "Rooftrellen":
                parrafos2(R.drawable.fondo_arbol,"Descripción");
                rel("heroe_raza");
                break;

            case "Jah'rakal":
                parrafos2(R.drawable.fondo_troll,"Curiosidades");
                rel("heroe_mundo_raza");
                break;

            case "Ymir":
                parrafos2(R.drawable.fondo_tusk,"Curiosidades");
                rel("heroe_mundo");
                break;

            case "Vrogros":
                parrafos5(R.drawable.fondo_underlord,"Descripción", "Artifact", "Personalidad", "Relaciones");
                rel("heroe_mundo_raza");
                break;

            case "Undying":
                parrafos2(R.drawable.fondo_zombie,"Curiosidades");
                rel("heroe");
                break;

            case "Ulfsaar":
                parrafos5(R.drawable.fondo_ursa,"Curiosidades", "Presas", "El Shaman de Hielo", "Relaciones");
                rel("heroe_raza");
                break;

            case "Shendelzare":
                parrafos2(R.drawable.fondo_venge,"Curiosidades");
                rel("heroe_raza");
                break;

            case "Lesale Deathbringer":
                parrafos3(R.drawable.fondo_veno,"Curiosidades", "Encuentro con los cultistas de Aktok");
                rel("vacio");
                break;

            case "Viper":
                parrafos5(R.drawable.fondo_viper,"Descripción", "Artifact", "Personalidad", "Relaciones");
                rel("heroe_mundo_raza");
                break;

            case "Visage":
                parrafos2(R.drawable.fondo_visage,"Curiosidades");
                rel("heroe_mundo");
                break;

            case "Inai":
                parrafos4(R.drawable.fondo_void,"Descripción", "templo", "Relaciones");
                rel("heroe_mundo");
                break;

            case "Demnok Lannik":
                parrafos5(R.drawable.fondo_warlock,"Descripción", "Carrera", "Personalidad", "Relaciones");
                rel("heroe_mundo_raza");
                break;

            case "Skitskurr":
                parrafos2(R.drawable.fondo_weaver,"Curiosidades");
                rel("raza");
                break;

            case "Lyralei":
                parrafos4(R.drawable.fondo_windranger,"Antecedentes", "Relaciones", "Curiosidades");
                rel("heroe_raza");
                break;

            case "Auroth":
                parrafos2(R.drawable.fondo_ww,"Curiosidades");
                rel("heroe_mundo_raza");
                break;

            case "Zharvakko":
                parrafos1(R.drawable.fondo_wd);
                rel("vacio");
                break;

            case "Ostarion":
                parrafos3(R.drawable.fondo_wk,"El Duque de Levinthal", "Curiosidades");
                rel("heroe_mundo");
                break;

            case "Zeus":
                parrafos5(R.drawable.fondo_zeus,"Descripción", "Artifact", "Personalidad", "Relaciones");
                rel("heroe_raza");
                break;

        }

    }

    private String Historia(String nombre, String tipo) {
        String hist = "";

        switch (nombre) {

            case "Abbadon":

                switch(tipo) {

                    case "texto1":
                        hist = "La Fuente del Averno, una grieta en las rocas primigenias de la que han emanado vapores de profético poder durante generaciones, es el origen de la fuerza de una familia. Cada neonato de la cavernosa Casa del Averno es bañado en la niebla oscura y con este bautismo obtienen una conexión innata con las energías místicas de la tierra. Crecen creyendo que son los fieros protectores de las tradiciones de su linaje, las costumbres del reino; pero lo que verdaderamente protegen es a la propia Fuente, quien posee objetivos inciertos.\n" +
                                "\n" +
                                "Cuando el infante Abaddon fue bañado en la Fuente dicen que algo fue mal. En los ojos del joven brilló una luz de comprensión que espantó a todos los presentes e hizo susurrar a los sacerdotes. Fue criado con la expectativa de que siguiera la senda de todos los de la casta del Averno: Entrenar en el arte de la guerra para que en tiempos de necesidad pueda dirigir el ejército de su familia en defensa de las tierras ancestrales, pero Abaddon siempre fue distinto. Mientras que los otros entrenaban con armas, él se dedicó a la meditación en presencia de la niebla. Inhaló profundamente los vapores que emanaban de la Fuente, aprendiendo a mezclar su espíritu con el poder que surgía de debajo la Casa: se convirtió en una criatura de la niebla oscura.\n" +
                                "\n" +
                                "Los miembros de la Casa del Averno no estaban contentos: tanto jóvenes como ancestros le acusaban de ignorar sus responsabilidades. Pero todas las acusaciones se detuvieron cuando Abaddon cabalgó hacia la batalla y vieron cómo los poderes de la niebla le habían otorgado maestría sobre la vida y la muerte más allá de la otorgada a cualquier lord que jamás hubiera habido en la Casa.";
                        break;
                    case "texto2":
                        hist = "Abaddon posee al menos una de las tres espadas del Averno, el Rompenieblas (Mistbreaker).\n" +
                                "\n" +
                                "Debido a su conexión con la Fuente del Averno, Abaddon es odiado incluso por los demonios inmortales del infierno.\n" +
                                "\n" +
                                "Abaddon parece tener una relación antagónica con Nyx. Afirma haber derrotado a varios de sus emisarios en el pasado. Nyx Assassin también detesta a Abaddon.";
                        break;
                    case "frase":
                        hist = "\"La niebla de la guerra no es rival para la niebla del destino\"";
                        break;
                }
                break;

            case "Razzil Darkbrew":

                switch(tipo) {

                    case "texto1":
                        hist = "En un acto de audacia digno de su reputación, Razzil anunció que iba a transmutar una montaña entera en oro. Después de dos décadas de investigación, gastos y preparación, fracasó estrepitosamente, viéndose rápidamente encarcelado debido a la enorme destrucción que provocó su experimento. No obstante, Razzil no era de los que se toman un revés a la ligera, y trató de escapar para continuar su investigación.\n" +
                                "\n" +
                                "Cuando su nuevo compañero de celda resultó ser un feroz ogro, encontró la oportunidad que necesitaba. Tras convencer al ogro de que no se lo comiese, Razzil se puso a preparar una disolución para dársela de beber, hecha a partir del moho y el musgo que crecían en los muros de la prisión. En una semana parecía estar lista. Cuando el ogro bebió la poción, una furia imparable se apoderó de él, destruyendo los barrotes de la celda y atravesando los muros y a los guardias por igual.\n" +
                                "\n" +
                                "Pronto se encontraron perdidos en algún lugar del bosque que rodea la ciudad con un rastro de escombros detrás de ellos y ninguna señal de persecución. Al terminarse el efecto del tónico, el ogro parecía sereno, feliz e incluso entusiasmado. Acordando trabajar juntos, la pareja partió a recoger los materiales necesarios para intentar la transmutación alquímica de Razzil una vez más.";
                        break;
                    case "texto2":
                        hist = "Alchemist es un equipo de dos seres, el Keen Razzil Darkbrew y su compañero ogro. Razzil es un miembro de la familia Darkbrew, conocida por su interés en la alquimia. Siempre a la búsqueda de materiales para usar en la alquimia la pareja extrae ingredientes de los cadáveres de sus enemigos. Aunque se tranquiliza con la poción improvisada de Razzil, el ogro parece estar cansado de llevar a su compañero de un lado a otro y anhela unos zapatos nuevos, un corsé para la espalda y caminar menos.\n" +
                                "\n" +
                                "A pesar del distanciamiento de Razzil de su familia a veces sigue sirviendo como su guardián.\n" +
                                "\n" +
                                "Tinker cree que la alquimia es una ciencia ilegítima y piensa que Razzil es un loco por practicarla.";
                        break;
                    case "frase":
                        hist = "\"La sagrada ciencia de la química era una tradición de la familia Mezclaoscura, pero ningún Mezclaoscura había mostrado nunca la creatividad, ambición y temeridad del joven Razzil. Sin embargo, cuando la edad adulta llamó a su puerta, dejó a un lado el negocio familiar y probó suerte con la fabricación de oro mediante la alquimia\"";
                        break;
                }
                break;

            case "Kaldr":

                switch(tipo) {

                    case "texto1":
                        hist = "Kaldr, la Aparición Ancestral (Ancient Apparition), es una imagen proyectada desde fuera del tiempo. Proviene del frío e infinito vacío que tanto precede al universo como espera a su fin. Kaldr es, Kaldr era, Kaldr será... y lo que percibimos, poderoso como aparenta ser, no es más que el desvanecido eco del verdadero y eterno Kaldr. Algunos creen que, a medida que el cosmos envejezca y se acerque a su momento final, el brillo y poder de Kaldr también se intensificará, que la Aparición Ancestral se volverá más joven y fuerte cuando se aproxime el fin de la eternidad. Su gélido agarre detendrá toda la materia, su imagen proyectará una luz demasiado horrible de contemplar. ¡Ya no será más una Aparición!";
                        break;
                    case "texto2":
                        hist = "Kaldr, la Aparición Ancestral, es una débil y espeluznante proyección de un ser que existe fuera del tiempo. La razón de su participación en la guerra de los Ancestros es desconocida pero lo que debería preocuparnos más es el sombrío destino que trae a toda la creación.\n" +
                                "\n" +
                                "Kaldr aparece en el mundo como un elemental de hielo incorpóreo: Un ser que es uno con la naturaleza, pero en este caso es uno con los elementos helados de la naturaleza. Este elemental no es más que una imagen, una mera proyección de un ser superior que existe fuera del tiempo en el frío e infinito vacío, una presencia que precede al universo y que espera su fin en el momento del gran equilibrio.\n" +
                                "\n" +
                                "La mera apócrifa dicta que, a medida que el cosmos envejece y es conducido a sus últimos momentos por el tiempo, la luz y el poder de Kaldr serán cada vez más fuertes. Su antiguo apodo perderá su significado cuando desafíe el envejecimiento del tiempo y rejuvenezca, su dominio del hielo detendrá toda la materia, su imagen proyectará una luz demasiado terrible para contemplarla y anunciará la llegada del gran equilibrio.";
                        break;
                    case "texto3":
                        hist = "Probablemente como una broma sobre su nombre, Kaldr hablará a menudo sobre su edad y su naturaleza fantasmal, actuando a veces como un ser anciano o un fantasma espeluznante.";
                        break;
                    case "texto4":
                        hist = "Kaldr es un subordinado del Fundamental Enigma. Parece no admitirlo (probablemente a propósito), lo que hace que Enigma le recuerde su lugar.\n" +
                                "\n" +
                                "Según Wukong, Kaldr está enamorado de Crystal Maiden y desea pedirle una cita.";
                        break;
                    case "texto5":
                        hist = "Kaldr es, como su nombre indica, una aparición. Es un ser espiritual en un cuerpo de hielo fantasmal que está animado por el espíritu que lleva dentro. Como encarna y maneja el hielo y el frío, es un elemental de hielo.\n" +
                                "\n" +
                                "Sin embargo, esta no es su verdadera forma. Su historia sugiere que encarna la muerte térmica del universo, como se desprende de su biografía que menciona el cese de la materia en la época del gran equilibrio. Las primeras representaciones de Kaldr se registraron en su día en textos ilegibles escritos en una lengua extinta. Los archivistas de los Archivos de Ultimyr han encontrado estos textos y uno de ellos intentó utilizar un hechizo de descifrado para leerlo, pero se volvió loco como resultado.\n" +
                                "\n" +
                                "El poder que observamos de Kaldr no es más que un eco desmayado de su verdadera forma cósmica. Sus poderes se limitan a un elemental de hielo mundano que puede manipular el frío y el hielo pero pronto Kaldr se hará gradualmente más fuerte a medida que se acerque el fin del universo donde podrá detener la materia misma. Sin embargo, parece que no es un simple elemental, ya que puede controlar el tiempo en menor medida.\n" +
                                "\n" +
                                "Aparte del efecto de Pies Fríos (Cold Feet's) en el juego, la historia de la habilidad describe que su mera presencia puede atraer a los que le rodean a un vacío helado donde quedarán encerrados en una \"prisión de hielo\" para la eternidad. Este \"vacío helado\" podría ser el mismo vacío frío e infinito del que surge la imagen de Kaldr fuera del tiempo, lo que significa que esta habilidad no es un mero hechizo de congelación, sino una puerta más allá del tiempo y hacia el propio vacío.\n" +
                                "\n" +
                                "Kaldr manipula vientos helados y cáusticos a su antojo, creando un Vórtice de Hielo (Ice Vortex) que congela la zona y a cualquiera que quede atrapado en su área de efecto.\n" +
                                "\n" +
                                "Toque escalofriante (Chilling Touch) permite a Kaldr utilizar su \"conocimiento eterno\" para imbuir sus ataques con un encantamiento gélido. La antigua leyenda de esta habilidad, antes de que fuera modificada, decía que también hechizaba a sus aliados.\n" +
                                "\n" +
                                "Al canalizar las tormentas de hielo de épocas pasadas a través de sus extremidades heladas, Kaldr libera su poder a través de una Explosión de Hielo (Ice Blast) que se estrella contra el mundo y convierte en estatuas de hielo a cualquiera que quede atrapado en su trayectoria. La historia implica que estas tormentas de hielo son extraídas de periodos de tiempo en el pasado antes de ser enviadas al presente por Kaldr, lo que sugiere alguna forma de poder temporal.";
                        break;
                    case "frase":
                        hist = "\"Un día el hielo cubrirá estas tierras y será como si esta guerra nunca hubiera ocurrido\"";
                        break;
                }
                break;

            case "Magina":

                switch(tipo) {

                    case "texto1":
                        hist = "Los monjes de Turstarkuri observaban los accidentados valles por debajo de su monasterio en la montaña a medida que oleadas y oleadas de invasores se extendían por los reinos inferiores. Ascéticos y pragmáticos, se mantuvieron al margen de las luchas mundanas en su nido monástico, envueltos en la meditación que no conocía a los dioses o los elementos de la magia. Entonces vino la Legión del Dios Muerto, cruzados con el siniestro encargo de sustituir todos los cultos locales con el venenoso nihilismo de su Señor Sin Vida. De un paisaje que no conocía nada más que sangre y batallas durante miles de años, arrancaron las almas y los huesos de las legiones caídas y los lanzaron contra Turstarkuri. El monasterio solo resistió el asalto un par de semanas, y los pocos monjes que se preocuparon en salir de su meditación creyeron que los invasores eran visiones demoníacas enviadas para distraerlos de su meditación. Murieron sobre los cojines de seda en los que estaban sentados. Solo un joven sobrevivió: un peregrino que había llegado como acólito buscando la sabiduría, pero que aún no había sido admitido en el monasterio. Con horror, vio cómo los monjes a los que había servido té y ortigas primero eran asesinados y luego obligados a unirse a las filas del sacerdocio del Dios Muerto. Con nada más que unos pocos de los preciados pergaminos dogmáticos de Turstarkuri, se alejó hacia la relativa seguridad de otras tierras, jurando no solo destruir a los hechiceros del Dios Muerto, sino también poner fin a la magia por completo.";
                        break;
                    case "texto2":
                        hist = "Anti-Mage odia la magia.\n" +
                                "\n" +
                                "A pesar de ser un acólito en el momento de su huida, Anti-Mage ha aprendido algunas técnicas de los Turstarkuri, posiblemente de sus pergaminos dogmáticos.\n" +
                                "\n" +
                                "Después de escapar de Turstarkuri, Anti-Mage siguió meditando en los caminos de los Monjes de Turstarkuri.\n" +
                                "\n" +
                                "Anti-Mage se siente culpable por ser el único superviviente y sigue viendo a sus antiguos amigos a través del ojo de su mente.\n" +
                                "\n" +
                                "Anti-Mage tiene conocimiento de los Tael'Am.\n" +
                                "\n" +
                                "Anti-Mage tiene una relación con los Nómadas de las Tierras Altas, convirtiéndose en uno de sus iniciados.\n" +
                                "\n" +
                                "Después de terminar su auto-entrenamiento, Anti-Mage se unió a la finalmente infructuosa defensa de Bakhwarren.\n" +
                                "\n" +
                                "Anti-Mage ha derrotado a Hroth, el Mago del Yunque.\n" +
                                "\n" +
                                "Anti-Mage ha derrotado a Throsho, el hechicero que cambia de forma.\n" +
                                "\n" +
                                "Anti-Mage ha vencido a Sahsk y fue recompensado por su hazaña por el soberano de Yoskreth. Gracias a estas victorias, su fama creció.\n" +
                                "\n" +
                                "Anti-Mage trabaja con Nortrom para Tyler State.\n" +
                                "\n" +
                                "Originalmente, Terrorblade se suponía que era el hermano de Anti-Mage. Esto es un reflejo de sus personajes utilizados en DotA. Es probable que la relación haya sido eliminada del lore.";
                        break;
                    case "texto3":
                        hist = "Las Cadenas de Abscesión (Chains of Abscession), una antigua reliquia corrompida por el Dios Muerto, cumple ahora con su maestro en su deseo de dar caza a Anti-Mage. Desde entonces ha caído en manos de Pudge que ahora parece compartir el deseo de las Cadenas de consumir a Anti-Mage.";
                        break;
                    case "frase":
                        hist = "\"Los que viven con la varita morirán con mi espada\"";
                        break;
                }
                break;

            case "Zet":

                switch(tipo) {

                    case "texto1":
                        hist = "Antes del comienzo de todo, existía una presencia: una mente primordial, infinita, asombrosa y puesta en un propósito inescrutable. A medida que el universo comenzó a existir, esta mente se fragmentó y se dispersó. Dos de sus fragmentos más grandes, que llegarían a llamarse Radiant y Dire, se encontraron atrapados en una feroz oposición y comenzaron a torcer toda la creación para servir a su conflicto.\n" +
                                "\n" +
                                "Mientras la guerra y el cataclismo amenazaban el cosmos naciente, la voluntad de un tercer fragmento se dio a conocer. Nombrándose a sí mismo Zet, este intelecto buscó resolver la desarmonía y devolver todo a la unidad perfecta. Consternado por la naturaleza conflictiva de sus parientes, Zet reunió la suma de su poder. En un destello repentino, abrumó a sus hermanos y fusionó los aspectos en guerra en una esfera estelar antes de lanzarlos a la oscuridad para orbitar un mundo anodino. Se restauró la armonía, aunque solo quedaba la mínima fracción de la fuerza de Zet. Fijando su mirada en la prisión, Zet eligió usar su poder debilitado para servir como guardián vigilante hasta el final de los tiempos. Durante incontables eones, esta vigilia se mantuvo.\n" +
                                "\n" +
                                "La vida floreció en el mundo de abajo, ajena a los peligros aprisionados dentro de la luna que brillaba suavemente, o de las luchas de Zet para contenerlos. Mientras el eterno choque de los cautivos resonaba en el interior, la superficie de la prisión se estremeció y con el tiempo comenzó a resquebrajarse. En última instancia, el poder agotado de Zet resultó insuficiente para contener la brecha y, por fin, la luna se hizo añicos. Los antiguos habitantes de la prisión se habían escapado para sembrar de nuevo su conflicto.\n" +
                                "\n" +
                                "Lanzado a los confines más lejanos por la explosión de la prisión, Zet fue transformado por las energías disonantes de sus antiguos cautivos. Su presencia ya no era una sola forma y pensamiento, sino que se había dividido entre muchas, algunas menores, otras mayores, cada una conectada por un fugaz arco de conciencia. Luchando por suprimir su propia desunión, Zet aceleró hacia el floreciente conflicto de sus hermanos, doblando sus voluntades fracturadas hacia una conclusión singular: los aspectos de la mente primordial deben reunirse, o todos deben ser destruidos para que el conflicto no se extienda más...";
                        break;
                    case "texto2":
                        hist = "Zet es el tercer fragmento mayor de la Mente Primordial, una conciencia desencarnada infinita. Aunque Zet se reconoce a sí misma como una conciencia individual, sigue siendo la Conciencia Primordial en esencia porque se refiere a Radinthul y Diruulth como sus otros seres.\n" +
                                "\n" +
                                "En su forma actual Zet ha sido deformado por las energías disonantes liberadas por la destrucción de la Luna Loca. Fue tan poderoso que no sólo envió al Ser volando a los confines del espacio, sino que incluso dividió su mente incorpórea en muchos fragmentos mentales de distinto poder, algunos menores y otros mayores. Con su poder debilitado, Zet luchó por restaurar su forma completa, mientras que su forma principal fue capaz de fusionar a los dos Ancestros. El resultado fue que Zet pudo controlar sus fragmentos destrozados, pero aún no es lo suficientemente poderoso como para recomponerse. Todavía puede fusionar sus elementos fracturados (excluyendo su forma principal) para crear un clon a través de la Tempestad Doble (Tempest Double), pero no es ni de lejos lo que era antes.\n" +
                                "\n" +
                                "De ahí que Zet se haya transformado en una conciencia colectiva: una mente formada por muchos individuos que tienen los mismos pensamientos al unísono. Zet es muchos, pero es sólo uno.";
                        break;
                    case "texto3":
                        hist = "Antes de que se creara el universo había una presencia singular: una conciencia ancestral, la Mente Primordial, una inteligencia infinita que podía tener pensamientos insondables que ninguna mente del pasado, del presente y del futuro puede esperar alcanzar. En el momento en que se creó el universo esta mente se rompió en muchos fragmentos. Aunque todas estas partes compartían el mismo progenitor, estos fragmentos mentales pronto adquirieron individualidad. Dos de sus mayores fragmentos -Radinthul y Diruulth- lucharon entre sí y retorcieron toda la creación con sus poderes de embelesamiento para servir a su conflicto.\n" +
                                "\n" +
                                "En esta cascada de momentos, un tercer fragmento superior, el Ancestro no reconocido se dio a conocer. Este intelecto se llamó a sí mismo Zet y se esforzó por detener la espantosa desarmonía que acababa de presenciar en los primeros momentos de su concepción. Concentrando todo su poder, Zet abrumó a sus dos hermanos y los fusionó en una sola forma, atrapándolos a ambos en una esfera cristalina inerte. Zet lanzó esta esfera a la oscuridad del espacio para que quedara a la deriva durante toda la eternidad, sin embargo la fuerza gravitatoria de un floreciente planeta capturó este cuerpo y lo convirtió en su satélite. El coste de este aprisionamiento agotó la mayor parte de su fuerza, no obstante Zet estaba decidido a utilizar el poder que le quedaba para condenarse a sí mismo a una vigilia eterna.\n" +
                                "\n" +
                                "El tiempo pasó y el mundo, anodino en otro tiempo, se llenó de formas de vida primitivas que cobraron importancia y luego cayeron en el olvido. Pero en cada generación de este ciclo de vida, ninguno podía escapar del resplandor de este espeluznante cuerpo celeste (al que pronto llamaron \"La Luna Loca\" en sus historias) que aparecía a todas horas del día. Mientras tanto, los Ancestros beligerantes decidieron escapar de su prisión utilizando las repercusiones de su enfrentamiento, las fuerzas de las mareas y la tensión orbital que actuaba entre el planeta y su prisión. Zet utilizó sus debilitados poderes para contener la brecha, pero en una fatídica noche la Luna Loca se hizo añicos y la explosión resultante expulsó materia lunar a gran velocidad hacia el planeta y destruyó su superficie en un evento de extinción.\n" +
                                "\n" +
                                "Los Ancestros fueron liberados pero volvieron en una nueva forma que robaron del propio material que constituía su prisión. En cuanto a Zet, fue arrojado a los confines del espacio y deformado por las energías disonantes de sus hermanos. Ya no tiene forma ni pensamiento único, Zet encarnó el concepto que más desprecia: la disonancia. Ellos estaban disgregados en muchas piezas, una conciencia fracturada muy parecida a la de su progenitor. Utilizando el poder que le quedaba, Zet luchó por reunir sus elementos separados en un único objetivo y viajó por el cosmos para volver a unirse a la lucha contra los Ancestros que habían reanudado su guerra.";
                        break;
                    case "texto4":
                        hist = "Zet se encontraba entre los muchos héroes que estaban reunidos en el bar Sundered Moon. A diferencia de los demás héroes que socializaban entre sí, Zet estaba sentado solo en un rincón del bar, como si estuviera esperando a alguien. Al escuchar una conversación entre cierto Dios amoroso y su desafortunada presa, el Ser provocó al primero para llamar su atención llamándolo \"Medio Dios\".\n" +
                                "\n" +
                                "El irritado \"Medio Dios\" dejó a su potencial amante y se enfrentó solo a esta extraña figura encapuchada. Zet se burla de la deidad con sus orígenes superiores y Zeus replica con bromas sobre su falta de pronombres y su mala enunciación. Añadiendo a sus palabras, tomó las burlas del Ser como una invitación a una pelea. El Ser le da la razón a medias, diciendo que el Ser sólo ha venido a luchar. Molesto con este flujo y reflujo de conversaciones sin sentido Zeus le recordó al desconocido el motivo por el que estaban todos reunidos aquí, diciéndole al Ser que cualquiera con el que se pelee en este bar derribará un Ancestro al día siguiente. Sin dejarse intimidar por su atrevimiento, Zet corrigió al semidiós diciendo que el Ser no destruirá a un Ancestro, sino a los dos.\n" +
                                "\n" +
                                "Zet reveló una proyección de la sabiduría popular sobre los dos antiguos intelectos del \"mundo anterior a tu mundo\", Radinthul y Diruulth. Contaba la historia de su batalla, encarcelamiento y huida. Zet le revela que los Ancestros han estado construyendo un ejército de criaturas menores para servir a su conflicto y que si cualquiera de los dos Ancestros ganara su poder acabaría con \"sus dos mundos\". Una tarea tan grande no podría hacerse en solitario y al igual que sus hermanos Ancestros, busca amasar un ejército alineado contra ambos Ancestros. Zet le entregó un pergamino y le dijo que cumpliera con cualquier misterio que hubiera en su interior.\n" +
                                "\n" +
                                "Inseguro de cualquier tontería que Zet acabara de decir, Zeus preguntó al Ser si tenía algún interés en esta guerra. Zet le prometió que el Ser le \"devolvería la integridad\" si tenían éxito en la destrucción de los dos Ancestros. Aún teniendo dudas con la oferta del Ser, Zeus le pidió que verificara esta afirmación dándole una \"muestra de esta plenitud\". El Ser aceptó y le devolvió un pequeño fragmento de su poder legítimo, incluyendo un yelmo dorado repleto de poder divino.\n" +
                                "\n" +
                                "Satisfecho, Zeus se deleitó con su nuevo poder, ignorando por completo las tonterías que le habían llevado a ese momento. Invita al Ser a escuchar la historia de su divorcio mientras le ofrece un poco de ambrosía. El Ser declina cortésmente porque tiene trabajo que hacer antes de revelar otros seis pergaminos como el que le dio a Zeus.";
                        break;
                    case "texto5":
                        hist = "La destrucción de la Luna Loca introdujo los fragmentos de Oro Radiante (Radiant Ore) y Piedra Diabólica (Direstone) en el floreciente planeta donde se desarrolla la mayor parte de la historia de Dota 2. Estos fragmentos contenían la presencia de los dos fragmentos más grandes de la Conciencia Primordial, ambos conocidos como Radiant y Dire o Radinthul y Diruulth por Zet. Pero una tercera piedra -conocida como Nemestice- no fue corrompida por los Ancestros. En su lugar, contenía el poder que Zet sacrificó hace eones para sellar a sus hermanos beligerantes en una sola forma, atrapándolo finalmente dentro de una esfera cristalina inerte que se convertiría en el recipiente del poder de ambos Ancestros.\n" +
                                "\n" +
                                "En el momento en que la Luna Loca estalló desde su interior, los fragmentos que contenían la esencia Radiant y Dire fueron arrojados por la explosión y capturados por la atracción gravitatoria de su compañero celestial antes de caer a la tierra, siendo algunos de estos fragmentos arrojados al espacio o destruidos por el calor de la entrada atmosférica. Sin embargo, las piedras Nemestice permanecieron a flote dentro de las ruinas de la Luna Loca dejadas atrás por sus antiguos fugitivos.\n" +
                                "\n" +
                                "Eones más tarde, la brújula magnética de Arc Warden reveló el lugar de impacto de una profetizada tormenta Nemestice que precedería a una lluvia de meteoritos de las demás piedras Nemestice. Finalmente cayeron a la tierra en la era actual para reincorporarse a la lucha contra los dos Ancestros, listas para ser reclamadas por el carcelero de los Ancestros... o por cualquiera que busque el control de ambos.";
                        break;
                    case "texto6":
                        hist = "Zet siempre habla en tercera persona.";
                        break;
                    case "texto7":
                        hist = "Zet está construyendo un ejército de Héroes para luchar contra Radinthul y Diruulth. Hasta ahora, ha reclutado en sus filas a Zeus.\n" +
                                "\n" +
                                "Zet tiene mala predisposición hacia Radinthul y Diruulth desde que se manifestó.";
                        break;
                    case "frase":
                        hist = "\"No es para ayudar a los Ancestros por lo que me uno a esta guerra sino para destruirlos a ambos. Esta desunión debe terminar\"";
                        break;
                }
                break;

            case "Mogul Khan":

                switch(tipo) {

                    case "texto1":
                        hist = "Como soldado en el Ejército de la Niebla Roja, Mogul Khan puso su mirada en el cargo de General. Batalla tras batalla, demostró su valía con sangrientas hazañas. Su ascenso al poder se vio ayudado por el hecho de que nunca dudó en decapitar a un superior. Durante los siete años que duró la Campaña de las Mil Lagunas destacó como autor de gloriosas matanzas y su fama crecía mientras el número de compañeros de armas descendía progresivamente. En la noche de su victoria final, Axe se nombró a sí mismo General de la Niebla Roja y asumió el título definitivo de «Axe». Pero ya no quedaban tropas que liderar. Por supuesto, muchos habían fallecido durante la batalla, pero un buen número también habían caído bajo el acero de Axe. No hace falta decir que ahora, muchos soldados rechazan su liderazgo, pero esto no importa ni lo más mínimo a Axe, que sabe que un ejército de un solo hombre es, de lejos, el mejor.\n" +
                                "\n" +
                                "\n" +
                                "Niebla Roja (Red Mist)\n" +
                                "Todos los guerreros de la Niebla Roja son sus propios herreros y Mogul no es una excepción. Durante su época de simple soldado intentó forjar un arma con un hacha, lo que considera su único fracaso.\n" +
                                "\n" +
                                "Mogul solía ostentar el título de Segador (Reaper), un soldado de alto rango que mataba a cualquier desertor del ejército de la Niebla Roja. A los que se les concede el cargo de Segador se les otorgan tatuajes que expresan la responsabilidad que deben llevar y el respeto que otorga a quienes lo llevan.\n" +
                                "\n" +
                                "Tras la caída de la Niebla Roja, es posible que Mogul Khan se uniera al ejército Bloodmist o lo destruyera.";
                        break;
                    case "texto2":
                        hist = "Todos los guerreros de la Niebla Roja son sus propios herreros y Mogul no es una excepción. Durante su época de simple soldado intentó forjar un arma con un hacha, lo que considera su único fracaso.\n" +
                                "\n" +
                                "Mogul solía ostentar el título de Segador (Reaper), un soldado de alto rango que mataba a cualquier desertor del ejército de la Niebla Roja. A los que se les concede el cargo de Segador se les otorgan tatuajes que expresan la responsabilidad que deben llevar y el respeto que otorga a quienes lo llevan.\n" +
                                "\n" +
                                "Tras la caída de la Niebla Roja, es posible que Mogul Khan se uniera al ejército Bloodmist o lo destruyera.";

                        break;
                    case "texto3":
                        hist = "La historia tiene lugar en los Barrios de Hazhadal, donde Mogul y Goodkind han conseguido llegar a la puerta norte de la Fortaleza de Valhessi. Mogul saluda al guardián de la puerta y le presenta a su bardo Goodkind. Alegremente le pregunta por la ubicación de la Fortaleza de Valhessi y la corona de siete joyas que custodian cinco \"imparables\" guerreros Zongom, pero el carácter taciturno del guardián de la puerta obliga a Axe a detener su farsa.\n" +
                                "\n" +
                                "Ligeramente molesto, Mogul le pide su nombre para que Goodkind pueda hacer sus \"cosas de bardo\", pero el guardián se niega a decirlo. Mogul le convence de nuevo diciendo que su bardo necesita registrar su nombre en aras de la \"exactitud de los registros históricos\", lo que lleva al guardián a revelar su nombre. Grigrikh se presenta de forma intimidatoria y se burla de Mogul llamándole \"pequeño mono rosa\". Probablemente ofendido por sus comentarios, Mogul abandona la escena sin Goodkind, dejándolo supuestamente para que se lo coma Grigrikh.\n" +
                                "\n" +
                                "Sin embargo, Goodkind revela que Mogul no le ha dejado y llega poco después para ejecutar su característica Culling Blade sobre Grigrikh, matándolo al instante y destruyendo la puerta que hay detrás de él. Con estos movimientos, Goodkind consigue escribir las primeras líneas de su aventura. Se adentran en el castillo y son recibidos por un ejército de soldados Valhessi. Abriéndose paso a través de la horda, Goodkind escribe la escena con algunos adornos propios (por ejemplo, escribiendo que Mogul era un combatiente disciplinado aunque claramente estaba disfrutando de la lucha) hasta que se abren paso hacia la cámara final del castillo.\n" +
                                "\n" +
                                "Los cinco \"imparables\" guerreros de Zongom han estado esperando a los intrusos y los saludan con un inquietante y sincronizado discurso. Axe detiene su discurso para dedicar un momento a Goodkind, que podría haber pensado que Mogul dudaba por miedo. Mogul le aclara que simplemente le extrañó su inesperado discurso y le dice que no escriba que tenía miedo de los guerreros de Zongom. Se prepara para la batalla y le dice a Goodkind que deje de escribir y lo vea luchar. Mogul decapita al primer guerrero, realiza su segunda Culling Blade definitiva sobre el segundo guerrero, destripa al tercero y al cuarto, y finalmente mata al último guerrero en un ataque de ira.\n" +
                                "\n" +
                                "Mogul y Goodkind se dirigen a la sala del trono donde encuentran al Rey Hechicero de Valhessi de rodillas, suplicándoles que lo perdonen ofreciéndoles la corona y las demás riquezas de su sala del trono. Decepcionado porque su aventura tiene un final anticlimático, Mogul acepta la corona, pero de repente es transferido al cuerpo del rey, que revela que ha intercambiado cuerpos con él y que ahora posee a Mogul. El Rey Hechicero persigue a Goodkind mientras Mogul intenta librarse del hechizo. Goodkind le dice que destruya la fuente del hechizo ya que podría ser un hechizo canalizado.\n" +
                                "\n" +
                                "Rebuscando en la sala del trono, Axe rompe todas las baratijas que encuentra para deshacer el hechizo pero es inútil. Se da cuenta de que la corona podría ser la fuente y la sostiene sobre su cabeza exclamando \"¡Hechicero! He aquí tu talismán!\" y la hace añicos. El Rey Hechicero se burla de su estupidez y dice que no guarda todo su poder en simples joyas. Con un pensamiento rápido Mogul se da cuenta de que su cuerpo es la fuente del hechizo y sale corriendo por la ventana para caer a su supuesta muerte. El hechizo se anula y Mogul vuelve a su cuerpo para sorpresa de Goodkind, que anota lo sucedido poco después.\n" +
                                "\n" +
                                "Con el boceto de su próxima novela terminado, Axe se pregunta dónde deberían ir ahora mientras Goodkind envía su boceto con un cuervo portador. Después de sugerir algunos lugares que ya han explorado, Goodkind le dice que sus historias se están volviendo un poco repetitivas y que las ventas de sus libros han bajado en varias ciudades. Sugiere unirse a la batalla de los Ancestros, a lo que Mogul duda al principio hasta que menciona que incluso los dioses se unirán a la lucha, lo que hace que Mogul lo reconsidere.";
                        break;
                    case "texto4":
                        hist = "En una ocasión Axe luchó contra un gryftok. Herida, la bestia corrió hacia un río y Axe la persiguió en contra de las protestas de Goodkind. En la lucha se le cayó el hacha al río. Utilizando sus propias manos Axe asfixió al gryftok hasta la muerte y luego utilizó su cuerpo como una balsa durmiéndose en ella mientras se deslizaba por el río. Se despertó cuando la balsa estaba a punto de caer por una cascada, justo a tiempo para golpearse la cabeza con una roca. Cuando se despertó estaba desnudo y solo en la selva, posiblemente en Fellstrath.\n" +
                                "\n" +
                                "Mientras estaba en la selva, se hizo amigo de una araña y aprendió algunos remedios herbales.";
                        break;
                    case "texto5":
                        hist = "Bristleback admira a Mogul Khan por su resistencia al igual que a otros Oglodi.\n" +
                                "\n" +
                                "Mogul es muy conocido por sus hazañas como ejército de un solo hombre tras la caída del primer ejército de la Niebla Roja. Además de asaltar grandes castillos, masacrar ejércitos, robar tesoros y destruir reinos enteros, una de sus hazañas más notables es la destrucción de las fuerzas de la Fortaleza de Valhessi, incluido el Rey Hechicero y los cinco Guerreros Zongom.";
                        break;
                    case "texto6":
                        hist = "Axe suele ir acompañado de su escriba Goodkind. Siempre que salen de aventura escribe todo lo que ocurre en ella, pero también puede recurrir a embellecer sus historias. Después publica estas historias y las vende a diferentes ciudades. Gracias a estas historias, la reputación de Axe ha crecido enormemente pero también hay críticos y detractores que consideran estas historias rancias y de mala calidad. Axe también ha comenzado a entrenarse en las artes del combate, empezando por el manejo de la espada.\n" +
                                "\n" +
                                "Axe se ha alejado de sus compañeros Oglodi pero aún conserva su odio interno hacia los demonios que expresa haciendo una visita poco amistosa a Anessix. También le disgusta matar a otros Oglodi. En cuanto a sus compañeros Oglodi, Disruptor vigila a Axe en White Spire por razones desconocidas. Warlock anima a Axe a ser inteligente como él y Disruptor, y si juega bien sus cartas podría incluso enseñarle a leer.\n" +
                                "\n" +
                                "Como todos los demás Oglodi, Mogul Khan odia a los Keen pero hace una excepción con Sniper al que considera un digno oponente.\n" +
                                "\n" +
                                "Mogul Khan es perseguido por Sorla, una oglodiana que asumió el liderazgo del ejército de la Niebla Roja después de que él lo diezmara. Ella planea desollarlo cuando lo atrape. Debido a la naturaleza sanguinaria y violenta de Sorla, Juggernaut desea discutir con Mogul sobre la mejor manera de enfrentarse a ella.";
                        break;
                    case "frase":
                        hist = "\"¡Axe es todo el refuerzo que necesita este ejército!\"";
                        break;
                }
                break;

            case "Atropos":

                switch(tipo) {

                    case "texto1":
                        hist = "Cuando los dioses tienen pesadillas, Bane Elemental es quien se las provoca. También llamado Atropos, Bane nació de los terrores nocturnos de la diosa Nyctasha. Siendo una energía de horror demasiado potente como para ser contenida por el sueño, emergió del letargo de ella, se alimentó de su inmortalidad y robó la forma vaporosa de su mancillada sangre. Él es la esencia del miedo. Los mortales que oyen su voz escuchan sus más oscuros secretos susurrados al oído. Él llama al miedo oculto en el corazón de cada héroe. La vigilia no es protección, ya que la negra sangre que gotea continuamente de Bane, es una brea que atrapa a sus enemigos en un delirio. En presencia de Bane, todos los héroes recuerdan temer la oscuridad.";
                        break;
                    case "texto2":
                        hist = "Átropos es una de las Tres Sombras (Three Shades). Su espíritu inspira temor y delirio.\n" +
                                "\n" +
                                "Tusk llama a Bane \"Señor Grim\".\n" +
                                "\n" +
                                "Grimstroke da a entender que el cuerpo de Bane está hecho de materiales preciosos, posiblemente restos del icor de Nyctasha.";
                        break;
                    case "frase":
                        hist = "\"Soñé un campo de guerra... y me desperté encontrándome en él\"";
                        break;
                }
                break;

            case "Batrider":

                switch(tipo) {

                    case "texto1":
                        hist = "No se puede decir que haya armonía entre las criaturas de la selva de Yama Raskav. Por mordiscos, garras, pinzas o pezuñas, hasta el más tenue signo de debilidad implica una rápida muerte. Dicen que Rider era solo un chiquillo cortando paja en el campo de su familia cuando fue atrapado por un enorme mordiciélago que buscaba algo de comida para llevar. Pero el chico, que tenía mejores planes que ser devorado, se abrió paso de las garras de la bestia hasta su espalda y la asesinó con sus herramientas. Cubierto de sangre y ebrio de emoción aún por su vuelo, el chico se dio cuenta de que había encontrado su vocación.\n" +
                                "\n" +
                                "El muchacho creció y cada verano solía volver al campo de su familia, a menudo encaminándose a los arbustos, buscando revivir la emoción de enfrentarse a la muerte en forma de fauces o de una caída mortal. Y según pasaban los años, su determinación crecía y crecía. Con cada expedición, se adentraba aún más en la selva, hasta que encontró cómo llegar a las cuevas en pleno corazón de la hostilidad. Cuentan que Rider, la víspera de una tórrida noche de verano, no llevaba más que una cuerda, una botella de coraje líquido y la ardiente determinación de sentir los cielos una vez más, cuando se adentró en ellas...";
                        break;
                    case "frase":
                        hist = "\"No es el murciélago por el que tienes que preocuparte. Ella come fruta\"";
                        break;
                }
                break;

            case "karroch":

                switch(tipo) {

                    case "texto1":
                        hist = "Karroch era un chico normal y corriente. Su madre murió al dar a luz; su padre, un herrero que trabajaba para el Último Rey de Slom, murió aplastado cuando Karroch tenía cinco años. Tras eso, se vio obligado a trabajar en la casa de fieras del rey, donde creció rodeado de las bestias de la corte real: leones, monos, ciervos y cosas menos conocidas, cosas en las que apenas creía. Cuando el muchacho tenía siete años, un explorador trajo a un animal nunca antes visto. Arrastrada ante el rey entre cadenas, la bestia habló, pero su boca no se movió. Sus palabras: una súplica por la libertad. El rey se limitó a reír y ordenó a la bestia que hablase para su divertimiento. Cuando ésta se negó, la golpeó con el Cetro de la Locura y ordenó que fuese llevada de nuevo con las demás fieras.\n" +
                                "\n" +
                                "Durante los meses siguientes, Karroch trajo comida y medicinas a escondidas a la criatura herida, pero solo logró ralentizar su empeoramiento. Sorprendentemente, la bestia habló al muchacho, y con el tiempo su vínculo se fortaleció hasta que el niño descubrió que podía mantener con ella una conversación. De hecho, ahora podía hablar con todas las criaturas de la casa de fieras del rey. La noche en que la bestia murió, la rabia se apoderó del chico. Incitó a los demás animales de la corte a rebelarse y abrió sus jaulas para que causasen estragos en los terrenos del palacio. El Rey Loco fue atacado en medio de la confusión. Durante el caos, un ciervo real se inclinó ante el muchacho que lo había liberado, y, con el Señor de las Bestias (Beastmaster) montado sobre él, saltaron los altos muros de la fortaleza y lograron escapar. Ahora como hombre, Karroch, el Señor de las Bestias, no ha perdido su habilidad de conversar con las criaturas salvajes. Se ha convertido en un guerrero en armonía con la naturaleza salvaje.";
                        break;
                    case "texto2":
                        hist = "Tras su huida de Slom, el sabio ciervo blanco siguió acompañando y aconsejando a Karroch, que había reunido a un grupo de animales. Cuando el ciervo murió, Karroch convirtió su cornamenta en un juego de pañuelos como homenaje.";
                        break;
                    case "texto3":
                        hist = "Una vez atado al Último Rey de Slom, Karroch jura no volver a servir a la nobleza. Ahora liberado, fabrica sus armas con los materiales del mundo natural: plumas, cueros, huesos y pieles.\n" +
                                "\n" +
                                "Al parecer, Karroch se comunica mejor con los animales si se afeita la cabeza.";
                        break;
                    case "frase":
                        hist = "\"Corro con el conejo y cazo con los sabuesos\"";
                        break;
                }
                break;

            case "Strygwyr":

                switch(tipo) {

                    case "texto1":
                        hist = "Strygwyr el Buscador de Sangre (Bloodseeker) es un cazador proclamado a través de un ritual. Un Sabueso de los Gemelos Despellejados enviado en busca de sangre desde los picos envueltos en niebla de Xhacatocatl. Los Despellejados necesitan océanos de sangre para mantenerse saciados y aplacados, y podrían acabar en poco tiempo con la población de los imperios de las montañas si los sacerdotes de las altas mesetas no los apaciguan. Por lo tanto, Strygwyr parte a la caza de presas. La fuerza vital de la sangre que él derrama fluye inmediatamente a los Gemelos a través de las marcas sagradas de sus armas y armadura. A lo largo de los años, ha llegado a encarnar la energía de un feroz sabueso; en la batalla es tan salvaje como un chacal. Bajo la Máscara de Strygwyr, en la carrera por saciar la sed de sangre, se dice que alguna vez se pueden ver los rasgos de los Despellejados tomando directamente posesión de su Sabueso.";
                        break;
                    case "texto2":
                        hist = "Vinculado a la voluntad de los Gemelos Descarnados por el honor y el Juramento de Sangre, Strygwyr es un cazador ritualmente consagrado que desciende de las montañas Xhacatocatl para cosechar sangre para sus dioses. Aunque su tarea parece ser siniestra para cualquier observador involuntario realiza todo su trabajo en nombre de su pueblo y de los dioses gemelos que adoran. Los Gemelos Despellejados necesitan océanos de sangre para mantenerse saciados y apaciguados, y si no satisfacen sus necesidades drenarán a todo el pueblo de Xhacatocatl. Por ello, se pone el manto de los cazadores de ritos de sangre para recolectar la mayor cantidad de sangre posible, con un trabajo mucho más fácil gracias a las marcas sagradas de su equipo que canaliza inmediatamente las energías vitales recolectadas hacia los Gemelos.\n" +
                                "\n" +
                                "Strygwyr es el último descendiente de un antiguo linaje de cazadores de ritos de sangre que también han servido a los Gemelos Desollados en tiempos remotos a los que ningún ser vivo de los tiempos modernos puede recordar. En su juventud, sirvió a sus predecesores cazadores de sangre como mensajero antes de tomar su manto.\n" +
                                "\n" +
                                "En algún momento, se le entregaron un par de espadas demoníacas con el rostro de Eztzhok. Empuña estas cuchillas a la vista de sus dioses gemelos para compartir la sangre que recoge con el demonio Eztzhok, lo cual no aprueban.";
                        break;
                    case "texto3":
                        hist = "En uno de sus viajes, Strygwyr se topó con una extraña tierra de mala muerte que celebraba ejecuciones en lugar de sacrificios. Los asesinatos que se ofrecían a nadie le intrigaban ya que era un concepto tan extraño para alguien acostumbrado a realizar y recibir sacrificios. Antes de poder observar tan fascinantes costumbres necesitaba asegurarse de que su rostro y su identidad quedaran ocultos para cualquier transeúnte sospechoso. De ahí que se vista con los ropajes locales de la tierra para pasar desapercibido; entre ellos, una capucha, una capa, un brazaletes y una falda, mientras los sujeta con una tosca cuerda de cáñamo de un lazo que le resultó muy útil.  También desechó sus habituales espadas de obsidiana antes de salir al tiempo que consiguió encargar un par de espadas de metal al herrero local. Aunque desechó temporalmente su equipo que lleva las marcas sagradas sigue confiando en las líneas sagradas de poder para canalizar la sangre que recoge.\n" +
                                "\n" +
                                "Strygwyr pasó toda una temporada estudiando esta cultura atrasada. Observó que los verdugos de la horca llevaban a cabo sus actos con cuchillas de metal (guillotinas) y cuerda de cáñamo, decapitando y asfixiando a las víctimas desafortunadas mientras una turba contemplaba sus muertes con morbosa fascinación. Pronto se dio cuenta de que la propia turba era una deidad disfrazada y que las ejecuciones eran en realidad sacrificios que se le ofrecían. Satisfecho con su investigación partió hacia su tierra natal para compartir lo aprendido con sus maestros de la casta sacerdotal de Xhacatocatl.";
                        break;
                    case "texto4":
                        hist = "Strygwyr es mencionado cuando Dark Willow se encuentra con él como aliado. Dice que lo vio en Roseleaf pero que se mantuvo alejada de él para que no la matara. La descripción en la carta de artifact muestra que Strygwyr ha estado cosechando sangre de Oglodi, probablemente de las batallas entre Stonehall y la Niebla Roja en Roseleaf.\n" +
                                "\n" +
                                "También es enviado a matar a Prellex y Kanna, los dos líderes de los Radiant y los Dire, respectivamente.";
                        break;
                    case "texto5":
                        hist = "La encarnación canina de Strygwyr le ha afectado profundamente en muchos niveles además de su cuerpo, incluyendo su discurso (a veces) y su temperamento cuando está frenético por el derramamiento de sangre.\n" +
                                "\n" +
                                "Aunque su apariencia externa diga lo contrario a aquellos que no son conscientes, Strygwyr no es una bestia de mente simple. Fuera de las expediciones de recolección, vaga lejos de su hogar como antropólogo, estudiando a fondo las culturas de cualquier tierra que le intrigue.\n" +
                                "\n" +
                                "Strygwyr es una persona fiel y religiosa. Realiza todas sus matanzas no por sadismo o crueldad sino con un propósito ritual, prueba de que pone en práctica su sangrienta fe. Aunque pueda parecer cruel solo lo hace para alimentar a sus dioses y recibir a cambio su misericordia y bendiciones, permitiendo que su pueblo y su patria prosperen.\n" +
                                "\n" +
                                "Debido a su fe, es una persona muy espiritual que no le gustan los sacrificios egoístas ni los estilos de vida materialistas.\n" +
                                "\n" +
                                "Se da a entender que su fe en los dioses le obliga a honrar y respetar los sacrificios elegidos.\n" +
                                "\n" +
                                "Cuando Snapfire se encuentra con él, sus respuestas implican que Strygwyr tiene un lado bastante amistoso en su personalidad. Parece que ofrece galletas por razones desconocidas, pero las implicaciones dirían que lo hace por amabilidad. Puede que no sea canon ya que podría ser una referencia a su línea de voz cuando mata a alguien a través de la Ruptura (Rupture).";
                        break;
                    case "texto6":
                        hist = "Strygwyr respeta a aquellos que se han hecho conocidos por su reputación de traficar con la muerte y derramar sangre, porque sus acciones son beneficios indirectos para los Gemelos Desollados. Esto incluye a personajes como Pudge, Luna, Necrophos y Sorla Khan.\n" +
                                "\n" +
                                "A Strygwyr le disgusta Omniknight. También actúa por voluntad de sus dioses gemelos que buscan la Omnisciencia como sacrificio. También le disgusta Chen y ve su fe en Obelis como algo triste y vacío.\n" +
                                "\n" +
                                "Actuando por voluntad de los Gemelos Desollados, Strygwyr es hostil hacia los demonios que temen a estos dioses glotones y los envía a cazarlos. Anessix es uno de estos demonios cazados por su Sabueso como se ve en Dota Underlords. Eztzhok también intentó poseer a Strygwyr, algo que sus dioses gemelos no vieron con buenos ojos.";
                        break;
                    case "texto7":
                        hist = "Bajo su capucha Strygwyr tiene un rostro sin ojos. Compensa esta desventaja con creces gracias a la bendición de los Gemelos Desollados que guían su visión con la suya propia en lugar de sus inexistentes ojos.\n" +
                                "\n" +
                                "La forma original de Strygwyr es desconocida pero a lo largo de los años su aspecto ha cambiado drásticamente. En su forma actual ha llegado a encarnar un ser parecido a un sabueso. En el proceso de saciar su sed con sangre, los rasgos de los Gemelos Desollados pueden manifestarse en su rostro y tomar posesión directa de su Sabueso. Eztzhok también pudo manifestar su rostro en el de Strygwyr, pero su influencia fue disipada por los Gemelos Desollados casi demasiado tarde con gran sacrificio por su parte.";
                        break;
                    case "frase":
                        hist = "\"Deberías sentirte honrado de sangrar para que los Desollados puedan vivir\"";
                        break;
                }
                break;

            case "Gondar":

                switch(tipo) {

                    case "texto1":
                        hist = "Cuando los perseguidos narran historias sobre Gondar el Cazarrecompensas (Bounty Hunter) ninguno está seguro de cuál de ellas es verdadera. En voz baja dicen que fue abandonado siendo una cría, aprendiendo sus habilidades de rastreo como una cuestión de simple supervivencia. Otros han oído decir que era un huérfano de guerra, acogido por el gran Soruq el Cazador para aprender las habilidades de su maestro con la hoja mientras exploraban los oscuros bosques en busca de grandes trofeos. Sin embargo, otros creen que era un pilluelo criado entre carteristas y ladrones, entrenado en las artes del sigilo y la distracción. Alrededor de una fogata y cada vez más temerosas, sus presas cuentan rumores sobre los trabajos de Gondar: dicen que fue él quien encontró al tirano rey Goff años después de que este pasase a la clandestinidad, trayendo su cabeza y su cetro como prueba; que fue él quien se infiltró en los campamentos rebeldes de Highseat, trayendo finalmente al legendario ladrón Capa Blanca para ser juzgado por sus crímenes, y que fue él quien terminó con la carrera de Soruq el Cazador, condenado como un criminal por haber matado al preciado engendro del príncipe. Las historias sobre las sorprendentes habilidades de Gondar se extienden cada vez más, con cada atrevida hazaña más increíble que la anterior y cada objetivo más difícil de alcanzar. Por el precio adecuado, los perseguidos saben que cualquiera puede ser hallado. Por el precio adecuado, incluso el más poderoso puede encontrar el miedo entre las sombras.";
                        break;
                    case "texto2":
                        hist = "Aunque Gondar aprendió mucho de Soruq, el maestro cazador también tomó un segundo discípulo cuyo nombre se desconoce. Entre los tres se forjó una confianza sagrada. Sin embargo fue el segundo discípulo quien finalmente traicionó a Soruq, robando sus secretos y llevándolo a un ejército de infieles. Enfadado por ello, Gondar dejó de lado sus obligaciones habituales y salió a la caza. Alistándose en el ejército infiel, Gondar localizó al segundo discípulo y lo mató. Luego, utilizando la propia espada del traidor, Gondar asesinó al general del ejército infiel y puso fin a la organización.";
                        break;
                    case "texto3":
                        hist = "Aunque su relación con Soruq se basa principalmente en rumores no hay duda de que aprendió algo del cazador, incluidas las palabras para encantar sus armas.\n" +
                                "\n" +
                                "Gondar es de una raza sin nombre y habla una lengua única, que utiliza en raras ocasiones.\n" +
                                "\n" +
                                "Entre otras cosas, Gondar utiliza el olfato para localizar a sus objetivos.\n" +
                                "\n" +
                                "Según Gondar, nunca ha perdido un objetivo.\n" +
                                "\n" +
                                "Gondar es tan conocido que acepta los trabajos basándose primero en el prestigio y el desafío, y luego en la compensación.\n" +
                                "\n" +
                                "Gondar puede dejarse crecer la barba.\n" +
                                "\n" +
                                "En ocasiones, Gondar pone trampas a sus objetivos.\n" +
                                "\n" +
                                "Gondar se complace en su trabajo y es conocido por su crueldad.\n" +
                                "\n" +
                                "Gondar tiene estrechos lazos con Qaldin y posee un buen conjunto de armas de Asesino Qaldin.\n" +
                                "\n" +
                                "Gondar ha estado en la zona oriental del Basurero Centelleante.\n" +
                                "\n" +
                                "Gondar puede haber matado una vez a un Djinn.\n" +
                                "\n" +
                                "Gondar caza Gigantes.\n" +
                                "\n" +
                                "Gondar cazó y mató a la Garganta Cortada Carmesí. Fue uno de los contratos más duros que aceptó en su vida.\n" +
                                "\n" +
                                "Gondar suele saquear los cadáveres de sus objetivos como parte de su pago.\n" +
                                "\n" +
                                "Es posible que Gondar haya sido alguna vez un bandido.\n" +
                                "\n" +
                                "Gondar lleva a veces una máscara tratada con aceites y ceras para evitar los venenos del enemigo.\n" +
                                "\n" +
                                "Gondar es miembro del gremio de los pangolines.\n" +
                                "\n" +
                                "Los miembros jóvenes de la raza de Gondar se llaman kits.\n" +
                                "\n" +
                                "Es posible que Gondar haya matado a un Ursine en su primera cacería como kit. Sus restos se convirtieron en una armadura para él.\n" +
                                "\n" +
                                "Gondar juega con frecuencia en los hipódromos de White Spire, y se sabe que hace trampas.\n" +
                                "\n" +
                                "Gondar gana una gran cantidad de recompensa por cada caza, más que la mayoría de los demás cazarrecompensas. Esto le permite permitirse un equipo extravagante.\n" +
                                "\n" +
                                "Gondar siente respeto por otros héroes que poseen invisibilidad.\n" +
                                "\n" +
                                "Al parecer, Gondar sobrevivió a un evento peligroso, posiblemente la batalla de Roseleaf.";
                        break;
                    case "texto4":
                        hist = "Uno de los primeros mentores de Gondar fue Tybara, un maestro de las ejecuciones de un solo golpe.\n" +
                                "\n" +
                                "Gondar tiene una relación previa con Riki.\n" +
                                "\n" +
                                "Gondar ha estado en Revtel y puede estar trabajando para el Padre de Mireska para traer a Mireska de vuelta a la ciudad.\n" +
                                "\n" +
                                "Meepo conoce a Gondar, y le dice que se encargó de una \"cosa\" para él.\n" +
                                "\n" +
                                "Gondar trabaja para el Heraldo de Latón (Brass Herald), que pudo haberlo enviado a cazar a Donte Panlin por un rencor.";
                        break;
                    case "frase":
                        hist = "\"Ningún trabajo es demasiado grande, ninguna tarifa es demasiado grande\"";
                        break;
                }
                break;

            case "Mangix":

                switch(tipo) {

                    case "texto1":
                        hist = "En las profundidades de las Montañas Aulladoras, en un valle bajo la Cuidad en Ruinas, la antigua Orden de los Oyo ha practicado durante siglos sus rituales de meditación sagrada, comunicándose con el reino espiritual en grandes festivales de bebida. Nacido de una madre de carne y de un padre celestial, el joven conocido como Mangix fue el primero en crecer con el talento de ambos linajes. Entrenó con los mejores estetas de la Orden, obteniendo finalmente, a través de su embriaguez concienzuda, el derecho al desafío por el título de Maestro Cervecero (Brewmaster), el título más venerado entre la contemplativa secta de destiladores de malta.\n" +
                                "\n" +
                                "Tanto una competición de beber como un combate mortal, Mangix pasó nueve días bebiendo y luchando contra el antiguo maestro. Durante nueve noches se tropezaron y tambalearon, tragaron y golpearon, hasta que finalmente el antiguo guerrero se desplomó en un sopor etílico y un nuevo Brewmaster fue proclamado. Ahora el nuevo y joven Brewmaster invoca la fuerza de sus antepasados Oyo para potenciar su bastón. Al usar su magia, es a sus ancestros espirituales a los que recurre. Como todos los Brewmasters anteriores a él, fue enviado por su gente con una única misión. Vaga por la tierra, esforzándose para alcanzar la iluminación a través de la bebida, buscando la respuesta a la antigua escisión espiritual, esperando alcanzar el pensamiento único que le permita unir de nuevo los planos físico y espiritual.";
                        break;
                    case "texto2":
                        hist = "Brewmaster es el hijo de su padre celestial y su madre mortal. Al igual que otros celestiales, tiene afinidad con los elementos naturales del viento, el fuego y la tierra. Sin embargo, a diferencia de otros Celestiales, Mangix es el único que está en sintonía con más de un elemento. Por ello, es capaz de desdoblarse en tres guerreros elementales distintos, aunque puede que no sea plenamente consciente de esta habilidad ya que siempre está ebrio cuando se produce este desdoblamiento. Mangix prefiere los licores alcohólicos y desprecia el ron. Comparte los mismos ancestros que Storm Spirit, Ember Spirit, Void Spirit y Earth Spirit, y considera a Storm Spirit como un primo. La Ciudad Arruinada (Ruined City) es de especial importancia para Mangix, a la que espera volver algún día y ser enterrado allí.";
                        break;
                    case "frase":
                        hist = "\"¿Deberíamos cancelar esto y tener una ronda amistosa?\"";
                        break;
                }
                break;

            case "Rigwarl":

                switch(tipo) {

                    case "texto1":
                        hist = "Nunca dispuesto a darle la espalda a una pelea, a Rigwarl se le conocía por enfrentarse a los camorristas más grandes y crueles que podía encontrar. Apodado Bristleback por las muchedumbres de borrachos, se metía en peleas en la trastienda de todos los bares de carretera entre Slom y Elze, hasta que finalmente sus hazañas llamaron la atención de un camarero en busca de alguien que hiciera cumplir las normas. A cambio de algo que beber, Bristleback fue contratado para pasar cuentas, mantener la paz y romper una o dos piernas de tanto en tanto (o cinco en el caso de un arácnido desafortunado).\n" +
                                "\n" +
                                "Tras dejarse llevar en una noche de alegría durante la cual daño físico fue repartido por igual entre clientes problemáticos y su hígado, Bristleback encontró por fin un rival digno. «Sus colmillos me ofenden, señor», se le oyó farfullar a un tipo particularmente grande de los páramos del norte al que le había llegado la hora de pagar. Lo que aconteció después fue una pelea de las que hacen época. Una docena de luchadores se apuntaron. No quedó ni un taburete sin romper y al final, sucedió lo imposible: la cuenta se quedó sin pagar. A lo largo de las siguientes semanas, las heridas de Bristleback sanaron y sus espinas volvieron a crecer; pero su honor es un asunto más espinoso. Pagó la cuenta de su propio bolsillo, jurando encontrar a este norteño y hacer justicia. Y entonces hizo algo que nunca había hecho: se entrenó y al hacerlo hizo un descubrimiento asombroso sobre sí mismo. Una sonrisa se dibujó en sus dientes en el momento en que agitó sus espinas. Darle la espalda a una pelea podría resultar siendo idóneo.";
                        break;
                    case "texto2":
                        hist = "Rigwarl frecuenta tabernas entre Slom y Elze, lo que sugiere que podría ser de la zona.\n" +
                                "\n" +
                                "Es posible que Rigwarl haya luchado contra un minero de esmeraldas y que luego le haya robado su equipo.\n" +
                                "\n" +
                                "El némesis de Rigwarl desde el norte es sin duda Ymir, el Tusk. A pesar de su rivalidad Rigwarl no se opone a formar equipo con Ymir.\n" +
                                "\n" +
                                "Rigwarl tiene otro apodo: el matón erizado.\n" +
                                "\n" +
                                "Rigwarl tiene acento cockney.\n" +
                                "\n" +
                                "Rigwarl conoce a Pinzik, un excéntrico ingeniero que le fabricó el Empalador de Pistones (Piston Impaler).\n" +
                                "\n" +
                                "A Rigwarl no le gustan los caballeros.\n" +
                                "\n" +
                                "Rigwarl odia a los gatos.\n" +
                                "\n" +
                                "Rigwarl odia a los Keens ya que los considera pequeños y débiles.\n" +
                                "\n" +
                                "A Rigwarl le gustan los Oglodi por su dureza.";
                        break;
                    case "frase":
                        hist = "\"Fue un camarero el que me metió en este lío. Sí, creo que les haré una visita cuando esto termine\"";
                        break;
                }
                break;

            case "Black Arachnia":

                switch(tipo) {

                    case "texto1":
                        hist = "Durante siglos, Arachnia Negra, la Madre Criadora (Broodmother) merodeó por los oscuros túneles de lava bajo la ardiente caldera del monte Piroteo, criando a millones de arañitas antes de enviarlas a buscar presas en el mundo exterior. Posteriormente, Ptoloptales, el Visir de la Codicia, erigió su zigurat de calamita en las faldas del extinto volcán, a sabiendas de que cualquier saqueador que buscara su magnética fortuna tendría que enfrentarse a pasadizos repletos de arañas.\n" +
                                "\n" +
                                "Tras milenios de maternal paz, Arachnia Negra se vio asediada por un constante goteo de rateros, intrépidos caballeros y jóvenes nobles —todos ellos deliciosos, desde luego, pero tendentes a crear un entorno poco propicio para su inocente prole—. Cansada de las intrusiones, decidió hacer una visita a Ptoloptales; y cuando este se mostró poco dispuesto a negociar un compromiso, lo envolvió con su tela y lo reservó para utilizarlo como plato central de una fiesta de cumpleaños especial.\n" +
                                "\n" +
                                "Desafortunadamente, la ausencia del señor del Zigurat Magnético no hizo sino alentar a una nueva generación de intrusos. El aplastamiento de uno de sus retoños por un torpe aventurero fue la gota que colmó el vaso. Broodmother se dirigió a la superficie y declaró su intención de librar al mundo de todos y cada uno de los posibles invasores, hasta el último héroe si fuera necesario, para poder garantizar que su criadero volviera a ser un entorno seguro y saludable para su preciosa progenie arácnida.";
                        break;
                    case "texto2":
                        hist = "Broodmother ha estado en los Páramos Espinosos (Thorny Whastes), donde caza una presa en particular que sus crías necesitan para alimentarse. Para ello, adopta un caparazón camuflado de púas que le resulta bastante moderno.\n" +
                                "\n" +
                                "Los colmillos de broodmother contienen un veneno paralizante.\n" +
                                "\n" +
                                "El caparazón de broodmother está hecho de quitina.\n" +
                                "\n" +
                                "Broodmother a veces lleva a sus crías en su espalda.";
                        break;
                    case "texto3":
                        hist = "Broodmother y sus crías fueron en su día veneradas por un culto cercano al monte Pyrotheos, que creía que su insaciable hambre era divina. El culto construyó una armadura metálica para ella a partir de las llamas de la caldera del Monte Pyrotheo. Los adoradores ofrecían esa armadura a Broodmother antes de arrojarse a sus telas para ser devorados. El culto de las arañas ha desaparecido desde entonces, dejando sólo trozos de armadura esparcidos por las interminables telas de Broodmother.";
                        break;
                    case "texto4":
                        hist = "Una vez un herrero sin nombre entró en la guarida de Black Arachnia. Temiendo por su vida, le rogó a broodmother que lo perdonara y que, a cambio, le fabricara una armadura. Black Arachnia aceptó y el herrero se puso manos a la obra, midiendo y forjando un nuevo conjunto de armadura de araña, utilizando el metal recogido de las armaduras desechadas de los caballeros que habían sido presa de broodmother. Completó ocho protectores de piernas con pinchos, cada uno de ellos fabricado a partir del peto de un caballero caído. Luego, con manos temblorosas, el herrero colocó un tocado de metal en la cabeza de Black Aracnía, diciendo: \"Una corona digna de una reina\". Satisfecha, Black Aracnía cumplió su promesa y liberó al herrero, sólo para ver cómo era devorado vivo por sus crías.";
                        break;
                    case "texto5":
                        hist = "Black Arachnia conoció una vez a Sun Wukong, y aparentemente tuvieron una relación amistosa. \n" +
                                "Con el tiempo \"rompieron\", y siguen siendo hostiles el uno con el otro hasta el día de hoy.";
                        break;
                    case "frase":
                        hist = "\"Te he prometido para mis hijos\"";
                        break;
                }
                break;

            case "Bradwarden":

                switch(tipo) {

                    case "texto1":
                        hist = "Se dice que el camino de un centauro está pavimentado con los cuerpos de los caídos. Para aquel al que llaman Warrunner, en efecto ha sido un largo recorrido. Para los foráneos, los clanes de cuadrúpedos de Druud a menudo se confunden con criaturas simples y brutales. Su lenguaje no tiene forma escrita; su cultura carece de tradiciones pictográficas, música estructurada o una religión formalizada. Para los centauros, el combate es la perfecta articulación del pensamiento, la máxima expresión de uno mismo. Si matar es un arte entre los centauros, entonces Bradwarden, el Guerrero Galopante (Warrunner), es su mayor artista. Impuso su dominio en los terrenos de Omexe, una antigua arena donde los clanes de centauros se han reunido durante milenios para llevar a cabo sus ritos gladiatorios. A medida que su fama se extendía, los espectadores venían de todas partes para ver al gran centauro en acción. Siendo siempre el primero en entrar a la arena y el último en abandonarla, compone una obra maestra con cada salpicadura de su hoja ensangrentada. Es la poesía de la sangre en el acero, formando intrincados patrones en las pálidas arenas del campo de batalla.\n" +
                                "\n" +
                                "Warrunner derrotó a guerrero tras guerrero, hasta que la arena rugía con el canto de su nombre y se encontró solo, el campeón invicto de su raza. El gran cinturón de Omexe le fue entregado, abrochado alrededor de su gran torso, pero en su victoria, este artista de la muerte solo encontró un vacío. ¿Qué es un guerrero sin un desafío? El gran centauro se alejó de Omexe al galope ese día con un nuevo objetivo. Para su gente, Warrunner es el mayor guerrero que jamás haya pisado la arena. Ahora está decidido a demostrar que es el guerrero más grande que jamás haya vivido.";
                        break;
                    case "texto2":
                        hist = "Bradwarden es el campeón de la raza de los centauros que se ha ganado su honor matando a todos los contrincantes en la arena de Omexe. Galardonado con el prestigioso Gran Cinturón de Omexe por su hazaña, Bradwarden se hace respetar y sus compañeros centauros se reúnen para unirse en su lucha. Al igual que otros centauros, Bradwarden cree que el combate es la forma de arte definitiva, comparando los golpes de su espada con el canto. [Ha acumulado al menos un centenar de victorias en la arena como demuestra su Hacha de Sangre, tomada de un guerrero derrotado. Como parte de sus obligaciones, Bradwarden protege el Cuerno Glorioso de Druud, una reliquia sagrada que llama a todos los centauros a la batalla.";
                        break;
                    case "texto3":
                        hist = "Cuando muere Bradwarden desea ser enterrado en los terrenos de Omexe.\n" +
                                "\n" +
                                "Parece sentir admiración por Magnus, alabando su honor.\n" +
                                "\n" +
                                "No le gustan las criaturas con menos patas, prefiriendo la compañía de otros seres de cuatro patas, aunque no sean centauros.\n" +
                                "\n" +
                                "Comparte origen con Disruptor, que también es de Druud.";
                        break;
                    case "texto4":
                        hist = "Bradwarden tiene alguna conexión con los cazadores de Marrowfell.";
                        break;
                    case "frase":
                        hist = "\"No es orgullo lo que tomo con mi propio poder, es pasión\".";
                        break;
                }
                break;

            case "Nessaj":

                switch(tipo) {

                    case "texto1":
                        hist = "Veterano de innumerables batallas en un millar de mundos diferentes, Chaos Knight proviene de un plano muy superior en donde las leyes fundamentales del universo han encontrado expresión consciente. De entre todos los antiguos Fundamentales, él es el más viejo e infatigable, y persigue sin cesar a un ser al que simplemente denomina \"La Luz\". Hace mucho tiempo, La Luz se aventuró a salir de la esfera progenitora, desafiando así la primera alianza. Ahora Chaos Knight pasa de un plano a otro, siempre tratando de dar caza y apagar La Luz dondequiera que esta se encuentre. Mil veces ha extinguido ya la fuente, y después siempre se desliza hacia otro plano para comenzar de nuevo su búsqueda.\n" +
                                "\n" +
                                "Sobre su montura Armageddon cabalga, sumiéndose en batallas desquiciadamente, aumentando su fuerza gracias al desorden del universo. Siendo una manifestación física del propio caos, es capaz de llamar a otras versiones de sí mismo desde otros planos en tiempos de necesidad y juntos estos oscuros jinetes cabalgan a la batalla, imparables como cualquier fuerza de la naturaleza. Solo cuando la última luz del mundo sea extinguida terminará su búsqueda. Allá donde cabalga Chaos Knight, la muerte sigue su paso.";
                        break;
                    case "texto2":
                        hist = "Antes de que el tiempo empezara a fluir, los cuatro Fundamentos estaban unidos en el Plano Fundamental donde todos estaban vinculados a la gran armonía primordial creada por Elder Titan. Cuando su martillo cayó en el mundo causó un efecto devastador en el universo primigenio que abrió el Plano Fundamental. El primer Fundamental en escapar fue Ezalor, el Guardián de la Luz. Los demás Fundamentales siguieron su ejemplo, lo que llevó al Caballero del Caos a reunir a sus hermanos fugados. Puso su mirada en el Fundamental rebelde que escapó de su respectivo reino y sólo es cuestión de tiempo y espacio que venga a por los demás Fundamentales.";
                        break;
                    case "texto3":
                        hist = "El Caballero del Caos es un Fundamental, una fuerza del universo creada cuando Elder Titan provocó la división del mundo durante el Cisma. \n" +
                                "\n" +
                                "Al igual que otros Fundamentales, el Caballero del Caos regresa al Plano Fundamental cuando muere. \n" +
                                "\n" +
                                "Parece desconocer los diferentes tipos de monturas, llamando \"caballo\" a cualquiera que vea (llegando a llamar \"caballo volador\" a un murciélago).\n" +
                                "\n" +
                                "El nombre del caballo del Chaos Knight es Armagedón.\n" +
                                "\n" +
                                "Pudge piensa que Chaos Knight es un engreído.";
                        break;
                    case "texto4":
                        hist = "Se da a entender que \"La Luz\" que Chaos Knight ha intentado cazar y extinguir es su propio hermano, Ezalor. También pretende dar caza a los demás Fundamentales fugados para reunirlos en el Plano Fundamental.\n" +
                                "\n" +
                                "Según Omniknight la Omnisciencia puede ver a todo Chaos Knight, incluidas las versiones de él de otros planos. Omniknight también es perseguido por Chaos Knight al que considera su segundo objetivo.\n" +
                                "\n" +
                                "Chaos Knight es un enemigo de las fuerzas de la Luz entre las que se encuentran los ya desaparecidos Señores de Oro, también conocidos como Hijos de la Luz. Estos seres, incluida su creación Dawnbreaker, buscaron el poder de Io para atarlo. No consiguieron hacerse con su poder y fueron destruidos mientras su gólem quedaba inerte, dejando al Caballero del Caos continuar con su antigua persecución.";
                        break;
                    case "frase":
                        hist = "\"La luz se oscurecerá y reinará el caos\"";
                        break;
                }
                break;

            case "Chen":

                switch(tipo) {

                    case "texto1":
                        hist = "Nacido en los inhóspitos Páramos de Hazhadal, Chen creció entre las tribus proscritas que se ganaban la vida en el calor fulgurante del desierto. Usando una antigua forma de encantamiento animal, la gente de Chen amaestraba al robusto locuthi del desierto, una especie de pequeños dragones subterráneos que fundieron las arenas del desierto en tubos de cristal donde 'dos veces al año' el agua de lluvia se acumula. Siempre a punto de morir de hambre y de sed, peleándose entre ellos y con sus vecinos, el clan de Chen un día cometió el error de emboscar la caravana equivocada.\n" +
                                "\n" +
                                "En la furiosa lucha que siguió, el grupo de Chen fue superado. Los Caballeros del Surco despacharon rápidamente a los locuthi, que atacaron y murieron en oleadas. Con sus dragones muertos, la tribu era lo siguiente. Chen luchó, rebanó y despedazó, y feneció... o lo habría hecho. Vencido, de rodillas, hizo frente a su ejecución con humildad, ofreciendo su cuello a la espada. Conmovido por el coraje de Chen, su ejecutor detuvo su arma. En vez del acero, Chen recibió dos opciones: muerte o conversión. Chen tomó la fe con ferocidad. Se unió al Surco y se ganó su armadura a base de sangrientas 'conversiones'. Ahora, con el fanatismo de un prosélito y sus poderes de encantamiento animal en auge, él busca a los impíos y les revela su recompensa final.";
                        break;
                    case "frase":
                        hist = "\"Puedes aprender la fe al final de una espada\"";
                        break;
                }
                break;

            case "Clinkz":

                switch(tipo) {

                    case "texto1":
                        hist = "En la base de las Colinas Sangrantes, un millar de acres de bosque se extiende formando un lugar llamado Hoven, donde charcas negras recogen la espesa sangre proveniente de las tierras altas y el rey-mago Sutherex gobierna de forma benevolente. Antaño acérrimo protector de las tierras de Hoven, Clinkz se labró una reputación por su pericia con el arco. En el tricentésimo año del rey-mago, el demonio Maraxiform ascendió del sexto infierno para reclamar el bosque. Como respuesta, el rey-mago pronunció un hechizo inquebrantable: aquel que matase al demonio sería recompensado con una Vida Sin Fin.\n" +
                                "\n" +
                                "Sin saber del hechizo, Clinkz se sumó a la batalla, defendiendo sus tierras de la fiereza del demonio. Clinkz condujo a Maraxiform de vuelta a las mismas puertas del sexto infierno, en cuyo umbral ambos se enzarzaron en una pelea mortal. Gravemente herido, el demonio liberó una llamarada infernal al tiempo que Clinkz disparaba su última flecha. La flecha se clavó en el demonio mientras el fuego del infierno se extendía por las tierras, prendiendo las charcas negras y quemando vivo a Clinkz en el mismo instante de la muerte del demonio. El hechizo del mago surtió efecto en el momento exacto de la conflagración del arquero, manteniéndole en un estado impuro, reduciéndole a ira y huesos, atrapado entre la vida y la muerte y obligado a cargar consigo el aliento del infierno en su viaje por la eternidad.";
                        break;
                    case "texto2":
                        hist = "La encarnación misma de la frase \"Ninguna buena acción queda sin castigo\". Clinkz, el Arquero de Huesos, es el protector maldito de las tierras de Hoven, condenado a una eternidad de tormento por una recompensa de vitalidad infinita que se convirtió en el catalizador de su infinito sufrimiento.";
                        break;
                    case "texto3":
                        hist = "Procedente de un vasto reino forestal llamado El Horno (The Hoven), donde se acumulan charcos de alquitrán de las Colinas Sangrantes (Bleeding Hills), Clinkz es un protector jurado de las tierras de Hoven y de su rey-mago Sutherex, protegiendo el reino forestal con sus reconocidas habilidades en el tiro con arco. En el año trescientos del rey-mago inmortal, el demonio Maraxiform se levantó del Sexto Infierno para reclamar el bosque. En respuesta, Sutherex decretó un hechizo irrompible: a quien matara al demonio se le concedería la Vida Eterna.\n" +
                                "\n" +
                                "Sin conocer el hechizo, Clinkz atravesó los charcos de alquitrán de Hoven para enfrentarse a Maraxiform en la batalla. Consiguió hacer retroceder al demonio hasta la fisura que conducía al Sexto Infierno, donde ambos combatientes se enzarzaron en un conflicto mortal. El demonio herido soltó una ráfaga de fuego infernal justo cuando Clinkz lanzó la última flecha que soltaría como ser mortal. Tanto la flecha como el fuego infernal encontraron su objetivo, matando a Maraxiform y encendiendo los charcos negros de la tierra que quemaron vivo a Clinkz al mismo tiempo.\n" +
                                "\n" +
                                "El arquero debería haber sido incinerado si no fuera porque cumplió involuntariamente la condición del hechizo. El hechizo de inmortalidad fue lanzado en el mismo momento en que Clinkz fue inmolado y lo preservó antes de que el fuego infernal pudiera consumir todo su cuerpo. Ahora sobrevive como un ser esquelético de rabia y agonía, obligado a sentir el fuego infernal siempre ardiente lamiendo sus huesos y su alma, sin que ni el fuego infernal ni la vejez puedan acabar con su sufrimiento.\n" +
                                "\n" +
                                "Pero Clinkz no es de los que desaprovechan su maldición. Desafiando el dolor que siente sigue dedicándose a la defensa de las tierras de Hoven, patrullando todos los rincones de su amado bosque con un paso doloroso tras otro y regalando el fuego del alma de Maraxiform a todos los que se atreven a lanzar amenazas y cumplirlas contra Hoven.";
                        break;
                    case "texto4":
                        hist = "Clinkz tiene fama en todo Hoven por su temperamento violento y volátil.\n" +
                                "\n" +
                                "Incluso en la no-muerte, el honor y la lealtad de Clinkz a Hoven persiste. Dedica sus muertes al rey-mago Sutherex e invoca a Hoven y a su rey mientras está en batalla. Sigue protegiendo a Hoven, a su gente y a su gobernante a pesar del dolor que siente sólo por existir.";
                        break;
                    case "texto5":
                        hist = "A pesar de su reputación de ser iracundo, sigue siendo venerado por la gente de Hoven. Sin saberlo, corresponde a su respeto manteniendo las tierras de Hoven a salvo de cualquier daño.\n" +
                                "\n" +
                                "Clinkz lleva un arco hecho con los restos óseos de su abuelo, probablemente como forma de honrarlo. Utilizando el arco como medio,su abuelo suele dar a Clinkz consejos no deseados.\n" +
                                "\n" +
                                "Snapfire confía en Clinkz para que proteja su receta secreta de galletas y le dice que nunca la revele hasta que ella se haya ido.";
                        break;
                    case "frase":
                        hist = "\"Mejor correr que maldecir el camino\"";
                        break;
                }
                break;

            case "Rattlerap":

                switch(tipo) {

                    case "texto1":
                        hist = "Perteneciente a la misma raza que Sniper y Tinker y al igual que muchos otros de la Gente Ingeniosa, Rattletrap ha sabido compensar su corta estatura con una combinación de artefactos e ingenio. Hijo del hijo de un relojero, Rattletrap fue aprendiz de ese oficio durante años antes de que la guerra descendiera de las montañas y despojase a las sencillas aldeas de unas vocaciones tan inocentes. «Tu nuevo negocio es la guerra», dijo su moribundo padre mientras la aldea de sus ancestros yacía entre humeantes escombros.\n" +
                                "\n" +
                                "Un artesano pobre es aquel que culpa a sus herramientas, y Rattletrap nunca fue de los que buscan excusas. Tras enterrar a su padre entre las ruinas de su pueblo, emprendió su cruzada particular para transformarse en la herramienta de combate más poderosa que el mundo hubiese visto. Se prometió a sí mismo que nunca volverían a cogerle desprevenido, así que, valiéndose de su talento, construyó una armadura ensamblando piezas de relojería que, en comparación, haría que las de los caballeros de otras tierras pareciesen de hojalata. Ahora Rattletrap vive gracias a un sinfín de dispositivos; un guerrero pequeño pero mortífero, cuyas habilidades para emboscar y destruir han alcanzado niveles de eficacia casi propios de una máquina. Es un artesano de la muerte, sus mecanizaciones (letales para los desprevenidos) anuncian un nuevo amanecer en esta época de guerra. ¿Qué hora es? ¡Es la hora de Clockwerk!";
                        break;
                    case "texto2":
                        hist = "Según Alchemist su traje funciona con gasolina.";
                        break;
                    case "texto3":
                        hist = "Los antepasados de Rattletrap eran relojeros, incluidos su padre y su abuelo.\n" +
                                "\n" +
                                "Rattletrap parece tener una estrecha relación con Sniper y Tinker.\n" +
                                "\n" +
                                "Rattletrap tiene una rivalidad con Snapfire.";
                        break;
                    case "frase":
                        hist = "\"¡Tengo una mente como una trampa de acero y el físico para acompañarla!\"";
                        break;
                }
                break;

            case "Rylai":

                switch(tipo) {

                    case "texto1":
                        hist = "Nacida en un reino templado, criada con su ardiente hermana mayor Lina, Rylai the Crystal Maiden pronto descubrió que su afinidad elemental innata con el hielo creaba problemas para todos los que la rodeaban. Los manantiales y los ríos de montaña se congelaban en momentos si se detenía a descansar cerca; las cosechas maduras fueron mordidas por la escarcha, y los huertos frutales se convirtieron en laberintos de hielo y se derrumbaron, echados a perder. Cuando sus exasperados padres enviaron a Lina al ecuador, Rylai se vio desterrada al frío reino norteño de Icewrack, donde fue acogida por un mago de hielo que se había tallado una ermita en la cima del glaciar Blueheart. Después de un largo estudio, el mago la declaró lista para la práctica solitaria y la dejó para que tomara su lugar, descendiendo al glaciar para hibernar durante mil años.";
                        break;
                    case "texto2":
                        hist = "Rylai es habladora.\n" +
                                "\n" +
                                "Rylai no se arregla mucho.\n" +
                                "\n" +
                                "Rylai puede estar un poco loca.\n" +
                                "\n" +
                                "Rylai es valiente pero le falta sabiduría.";
                        break;
                    case "texto3":
                        hist = "En su juventud Rylai enfadó una vez a su maestro, el Mago de Hielo, lo que la obligó a exiliarse al Mar Hirviente donde el glaciar Corazón Azul se encuentra con el océano. Pasó meses de meditación buscando la manera de demostrar que era digna de su tutela. Una tarde, se despertó para decir una sola palabra: \"Snowdrop\". Y con esa palabra hizo que su entorno se congelara convirtiendo el vapor en nieve. Cuando regresó al Glaciar del Corazón Azul, fue recibida por el Mago del Hielo, que se enteró de su hazaña mágica y quedó impresionado. Como recompensa le regaló un nuevo traje, como prueba de su dominio del hielo elemental.";
                        break;
                    case "texto4":
                        hist = "Rylai llevó coletas durante su juventud.\n" +
                                "\n" +
                                "Rylai es la hermana menor de Lina, con la que comparte una rivalidad entre hermanos. Según Rylai, ella siempre fue la \"buena\". Las dos hermanas destruyeron la casa de sus padres seis veces, con fuego y hielo.\n" +
                                "\n" +
                                "Rylai pensó una vez en convertirse en artífice de bienes mágicos y elaboró muchos utensilios como práctica.\n" +
                                "\n" +
                                "A veces se conoce a Rylai como la Doncella del Norte.\n" +
                                "\n" +
                                "Rylai es capaz de canalizar los vientos del Glaciar Corazón Azul, donde reside actualmente.\n" +
                                "\n" +
                                "Rylai es capaz de invocar fragmentos de hielo de Icewrack.\n" +
                                "\n" +
                                "La capacidad de Rylai de bajar la temperatura de su entorno hace que la magia florezca en las cercanías.\n" +
                                "\n" +
                                "A Rylai no le gustan las demostraciones de fuerza externas.\n" +
                                "\n" +
                                "Rylai conoció a Tusk en su juventud y solía tener peleas de bolas de nieve con él.\n" +
                                "\n" +
                                "Al igual que su mentor, el Mago de Hielo, Rylai planea regresar algún día al Glaciar Corazón Azul e hibernar durante mil años.\n" +
                                "\n" +
                                "Rylai conoce a Pierpont, un Arconte de Zafiro que parece haber sido su mentor. Se desconoce si Pierpont es o no la misma persona que el Mago de Hielo.\n" +
                                "\n" +
                                "Según Mireska fueron sus padres los que separaron a Lina y Rylai.\n" +
                                "\n" +
                                "Rylai recibió un manto y un bastón de plumas del Mago de Hielo antes de descender al glaciar.\n" +
                                "\n" +
                                "Rylai posee el manto y la corona de Yulsaria, la Bruja Helada.\n" +
                                "\n" +
                                "Rylai ha tenido contacto con la Tribu Frostiron.\n" +
                                "\n" +
                                "Rylai ha estado probablemente en la Taberna Wolfsden y posee un sombrero de allí como recuerdo.\n" +
                                "\n" +
                                "Rylai es conocido como el \"Guardián de Icewrack\".\n" +
                                "\n" +
                                "Según el Padre de la Guardia del Dragón, Rylai posee algunos rasgos de un dragón de agua.\n" +
                                "\n" +
                                "Más tarde, Rylai salva a Kaden, Fymwryn, Bram y Davion de Terrorblade.";
                        break;
                    case "texto5":
                        hist = "Lina es la principal rival de Rylai y las dos hermanas se enfrentaron a menudo en su infancia. En el pasado Lina parece haberle hecho un gran daño a su hermana y ahora vive en el sentimiento de culpa. Después de haber hablado con Lina Donté Panlin puede haber conseguido que reconozca su remordimiento. Actuando como intermediario transmite esta información a Rylai, diciéndole que Lina podría estar dispuesta a enmendar su error.\n" +
                                "\n" +
                                "Sin que ella lo sepa, Kaldr está enamorado de Rylai y quiere invitarla a salir.";
                        break;
                    case "frase":
                        hist = "\"Cuando el Infierno se congele, empezaré a llamarlo Cielo\"";
                        break;
                }
                break;

            case "Ish'kafel":

                switch(tipo) {

                    case "texto1":
                        hist = "Rápido cuando tiene que serlo y también un astuto estratega, Ish'Kafel, el Visionario Oscuro (Dark Seer), no necesita armas afiladas para vencer a sus enemigos, apoyándose en su lugar en la fuerza de su poderosa mente. Su talento recae en la habilidad de manipular el combate para su provecho. Proveniente de un lugar que él llama 'La Tierra más allá del muro', Dark Seer continúa siendo un extraño aquí, un guerrero de un reino más allá del velo de esta realidad.\n" +
                                "\n" +
                                "Habiendo sido en el pasado un gran general entre su gente y un valiente defensor del rey dios Damathryx, el ejército de Dark Seer fue barrido por una fuerza mucho mayor en los últimos días de la Gran Guerra de las Fronteras. Enfrentándose a una muerte segura, realizó un último acto desesperado: atrajo a las fuerzas enemigas al laberinto de entre las murallas y en el último momento, justo antes de que lo capturasen, cruzó y selló las murallas para siempre en una explosiva descarga de energía oscura. Cuando se despejó la polvareda, vio que había salvado a su gente, pero se encontró a sí mismo deslumbrado por la luz de un sol ajeno a su mundo y sin una forma de regresar. Ahora está comprometido a poner de manifiesto su valía como táctico militar, y promete demostrar que es el mejor estratega que este insólito nuevo mundo haya visto jamás.";
                        break;
                    case "frase":
                        hist = "\"Si tu enemigo es similar, prepárate. Si es mas fuerte, evítalo. Si es más débil, aplástalo\"";
                        break;
                }
                break;

            case "Mireska Sunbreeze":

                switch(tipo) {

                    case "texto1":
                        hist = "Los niños adoran contar historias sobre las fantásticas aventuras de las hadas. Pero eso es porque ignoran que en su mayoría son estúpidas y maliciosas. Y en el mundo de las rencorosas hadas, pocos nombres se pronuncian con tanto desprecio como el de Mireska Brisasol.\n" +
                                "\n" +
                                "Hija de un rey mercader de las hadas, Mireska creció en Revtel, un despiadado país donde la manipulación y el asesinato eran la norma. Pero a pesar de su habilidad para manejarse según el protocolo, las leyes no escritas y los rituales sociales que impregnaban cada elemento de su vida, a ella todo le parecía bastante aburrido.\n" +
                                "\n" +
                                "Así que Mireska hizo lo que hacen la mayoría de niños rebeldes: quemó la casa de su padre y se escapó con su espíritu mascota Jex a vivir la vida de una estafadora errante.";
                        break;
                    case "texto2":
                        hist = "Mireska Sunbreeze es una Fae y la hija de uno de los reyes mercaderes de Revtel. Al igual que los demás miembros de su especie, es un personaje retorcido, que trama sin cesar para idear la siguiente estafa. Detesta a su familia y se esfuerza por ser independiente, buscando que su nombre sea conocido en el mundo y recordado para siempre por su familia. Versada en la magia y capaz de colarse en el Reino de los Fae en cualquier momento, Mireska utiliza sus habilidades para hacer travesuras y daños. Desprecia a los ingenuos bienhechores y siente una gran codicia por el oro y los tesoros. A pesar de su naturaleza sádica, no le gusta la violencia y sólo recurre a ella para conseguir sus objetivos. En cambio admira el talento. la astucia y disfruta enfrentando a sus rivales. Mireska siempre va acompañada de Jex, un Wisp igualmente siniestro que tiene como compañero.";
                        break;
                    case "texto3":
                        hist = "Nacida en una casa privilegiada de Revtel, Mireska era una niña rica con muchas ventajas, incluidos los tutores, a los que odiaba. Su padre, uno de los gobernantes de la ciudad, tenía una personalidad dominante, la juzgaba y se regodeaba de sus fracasos, además de sermonearla sobre los peligros del mundo exterior. Aprendió a desenvolverse en los complejos rituales y la etiqueta de la sociedad fae pero se cansó de ellos y decidió dejarlos de lado para forjar su propio destino. Aburrida de Revtel y harta de su tiránico gobierno quemó su finca familiar y robó la primogenitura de la familia.\n" +
                                "\n" +
                                "Tras huir de la ciudad con Jex, Mireska se dedicó a viajar, regresando de vez en cuando a la hondonada boscosa donde guarda sus bienes robados. El precio de su independencia es muy alto y Mireska se encuentra ahora en busca y captura en seis naciones, perseguida por asesinos allá donde va. Guiada por líneas ley nunca se queda demasiado tiempo en un lugar, prefiriendo vagar por el mundo en busca de víctimas a las que estafar.\n" +
                                "\n" +
                                "Buscada por sus crímenes en Revtel, Mireska es perseguida por asesinos de todas las procedencias, ninguno de los cuales ha tenido éxito hasta ahora. Tal vez debido a sus potentes habilidades mágicas es buscada por el Tyler State y perseguida por sus agentes Nortrom y Anti-Mage. Su padre también quiere que vuelva para enfrentarse a sus crímenes y ha contratado al cazarrecompensas Gondar para encontrarla. Se han empleado acechadores Fae especiales para seguir su rastro. Debido a estas circunstancias Mireska se ha vuelto paranoica de ser capturada o asesinada.\n" +
                                "\n" +
                                "Aunque Mireska consideraba insufrible el comportamiento de su padre, algunos argumentan que sus propias acciones no son diferentes.";
                        break;
                    case "texto4":
                        hist = "En sus primeros viajes Mireska conoció a Lorlin Lasan, un miembro del Círculo de Jasper que le enseñó a matar. Con el tiempo le pidieron que se uniera al Círculo de Jasper pero rechazó la oferta porque no quería realizar actos para la organización y también porque le parecía insoportable su enfoque profesional de la ética. No obstante conserva cierto conocimiento de los tratos del Círculo de Jasper, advirtiendo a su amigo Meepo de que está siendo perseguido por la organización.\n" +
                                "\n" +
                                "Ha pasado mucho tiempo en la Niebla de Hierro (Iron Fog), donde fue testigo de las máquinas y de los horrores infligidos a la gente. Su propósito allí sigue siendo desconocido. El centro comercial de Weeping Rose era otro de sus lugares frecuentados hasta que fue expulsada por una razón desconocida.\n" +
                                "\n" +
                                "Los viajes de Mireska la llevan por todo el mundo, a lugares como Quoidge y la remota selva de Yama Raskav. Ha estado en Roseleaf, donde se produjo un enfrentamiento entre la Legión de Bronce y el ejército de la Niebla Roja, estando Mireska en el lugar durante o después de la lucha. Allí encontró la Bandera de la Serpiente de Toro, aunque es un misterio a quién pertenece. También ha estado en las áridas tierras del sureste de Roseleaf, que adora.";
                        break;
                    case "texto5":
                        hist = "De polizón en uno de los barcos de Kunkka, Mireska estuvo presente en la Isla Temblorosa cuando se produjo la batalla entre la Armada Claddish y los Demonios de la Catarata. El motivo de su presencia en el barco no está claro pero es posible que estuviera buscando algún tipo de trofeo. Se desconoce hasta qué punto estuvo involucrada en la batalla pero parece que hizo algo para condenar a la Armada Claddish por lo que ahora es odiada y perseguida por Kunkka. Mireska quedó traumatizada por la batalla y culpa a Tidehunter de los sucesos de aquel día.";
                        break;
                    case "texto6":
                        hist = "En un intento de encontrar reliquias perdidas Mireska viajó a las junglas de Fellstrath donde descubrió las ruinas del Imperio Overgrown. Al hacerlo despertó a los Mo'rokai, un par de bestias mágicas que una vez fueron adoradas por los habitantes de esa civilización perdida. Los Mo'rokai se lanzaron a arrasar la jungla buscando destruir a los Ancestros.";
                        break;
                    case "texto7":
                        hist = "Criada en la sociedad sin escrúpulos de Revtel, Mireska es propensa a robar cosas por placer, avaricia y venganza. Al marcharse robó la preciada reliquia de su familia sabiendo que eso enfadaría mucho a su padre. Codicia el oro y las joyas llegando a preguntar a Rylai si podía ponerla en contacto con un Arconte del Zafiro, posiblemente para robar algunos zafiros para ella. A Darkterror le robó el Reloj de Arena Claszureme, una reliquia arcana que controla el tiempo. Ha saqueado la tumba de Undying llevándose valiosos objetos funerarios y negándose a devolverlos. Mireska también ha contemplado la posibilidad de provocar incendios.\n" +
                                "\n" +
                                "Tras haber sido expulsada de Weeping Rose, Mireska planea volver y robar el centro comercial. También tiene los ojos puestos en la Cuchilla de la Apoteosis (Apotheosis Blade), jurando a Jex que la robará algún día. Las nieblas sagradas de la Fuente del Averno también están en su lista. Según Inai, Mireska está buscando el Amuleto de la Puerta de las Sombras aunque le advierte que usarlo tiene un alto precio.\n" +
                                "\n" +
                                "Además de los bienes materiales Mireska también codicia los secretos arcanos. Halaga a Enigma con la esperanza de conocer sus poderes. Los secretos de Aghanim, el padre de Rubick, también son muy deseados por Mireska que cree que la respuesta está en su bastón cambiante.\n" +
                                "\n" +
                                "En el lado menos criminal de las cosas Mireska es aficionada a la bebida, frecuentando los pubs y contando grandes cuentas. También le gusta el juego y las apuestas en las carreras de mensajeros en White Spire.";
                        break;
                    case "texto8":
                        hist = "Mireska es buena amiga de Meepo, lo invita a los hipódromos y va a las tabernas con él. Cuando se enteró de que el Círculo de Jasper iba a perseguir a Meepo por una deuda no saldada, le advirtió de antemano. Debido a su afición a la bebida Mireska también es amiga de Mangix, se emborracha con él y lo elogia en su trabajo.\n" +
                                "\n" +
                                "Rhasta tiene una relación de trabajo con ella y le tiene cierto respeto profesional por su condición de estafador. En una ocasión cuando Mireska y Rhasta realizaban estafas en la misma ciudad, sus planes superpuestos causaron muchos problemas a ambos. Por ello Mireska planea elaborar un calendario sobre las ciudades a las que deben viajar y a qué hora para que sus estafas no interfieran entre sí.\n" +
                                "\n" +
                                "Parece que Riki se separó de Mireska ya que decidió unirse al Círculo de Jasper mientras que ella no lo hizo. Mireska cree que si no hubieran tomado caminos distintos podrían haber sido amigos.\n" +
                                "\n" +
                                "Donte Panlin parece conocer a Mireska desde su infancia. Incluso hoy en día trata de advertirla y disuadirla de que continúe por el camino del crimen, diciéndole que podría tener una buena vida como figura heroica. Su simpatía por ella se revela cuando le pide a Gondar que perdone a Mireska y que no le robe su futuro llevándola de vuelta con su padre. Por su parte Mireska encuentra las charlas de Donte irritantes y lo desprecia abiertamente.\n" +
                                "\n" +
                                "Mireska es poco amable con Ostarion y Tresdin, a los que considera líderes tiranos afines a los reyes de Revtel. No ve con buenos ojos Stonehall y sus sangrientas batallas, y advierte a Tresdin de que Rix la matará. Mireska también desprecia a un Keen llamado Mazzie aunque se desconoce el motivo exacto. Cuando se trata de demonios Mireska evita por completo sus tentaciones posiblemente porque su padre le advirtió que no tratara con demonios hace mucho tiempo. El Dragón Faérico Puck posee poderes similares a los de los Fae y se entromete constantemente en sus actividades provocando la ira de Mireska. Al igual que Puck es una de las pocas que puede entender a Mercurial.\n" +
                                "\n" +
                                "Los Caballeros de la Vigilia han luchado o intentado someter a Mireska antes por razones desconocidas. Debido a los acontecimientos ocurridos en la Isla Temblorosa Mireska está huyendo de Kunkka y tiene una relación hostil con Tidehunter.";
                        break;
                    case "frase":
                        hist = "\"Vamos a divertirnos, ¿de acuerdo?\"";
                        break;
                }
                break;

            case "Valora":

                switch(tipo) {

                    case "texto1":
                        hist = "";
                        break;
                    case "texto2":
                        hist = "En los eones posteriores a los que el éxodo del Guardián originó la era de la luz, algunos entre el linaje del primer sol comenzaron a alinearse contra el caos resultante que perseguía al creador de su antepasado. Llamándose a sí mismos los Hijos de la Luz, no veían a nadie más digno de tomar el manto abandonado del Guardián, y anhelaban hacer retroceder el ataque de la oscuridad, creando gloriosos ejércitos construidos para purgar el cosmos de todas las criaturas de la noche primordial.\n" +
                                "\n" +
                                "Valora —conocida como Dawnbreaker, la guerrera más preciada entre las antiguas creaciones de los Niños— es la brillante heraldo de la majestad del orden y la luz. Moldeada a partir del corazón de una joven estrella metálica y cargada de nueva vida por un aliento dorado, Valora fue llamada a difundir el brillo de la sabiduría de los Niños a los confines más oscuros del universo, prendiendo fuego a los cielos con cada golpe de su martillo celestial en medio de una batalla interminable para mantener a raya el caos.\n" +
                                "\n" +
                                "Con el tiempo, los Niños también revelaron otro propósito para Dawnbreaker. Habían descubierto un medio para impregnar la totalidad del cosmos con su luz interior, para borrar todos los aspectos de la oscuridad para siempre, y enviaron a Valora para apoderarse de una fuente de gran poder, la pieza final de su plan definitivo. Pero por primera vez, Valora y su martillo fracasaron, y el precio que pagaron ella y sus maestros fue enorme. La chispa de los Hijos de la Luz se extinguió por completo, y Dawnbreaker quedó a la deriva en una extensión negra, perdida durante incontables milenios antes de estrellarse en un mundo desconocido.\n" +
                                "\n" +
                                "Allí descansó, durmiente, hasta que la presencia de una joven estrella errante dio combustible a una antigua forja de energía, una reliquia de los Niños que, como ella, permaneció enterrada durante incontables eras bajo un ventoso yermo rojo. Ahora, con una pequeña medida de sus antiguos poderes restaurados por la forja, Valora se despierta en una tierra asediada por la guerra y las implacables fuerzas del caos. Ella sabe que sus dioses pueden haber desaparecido, pero el peso del martillo de Dawnbreaker permanece, solo igualado por su voluntad de manejarlo con justicia en nombre de la bondad y la luz.";
                        break;
                    case "texto3":
                        hist = "Valora, la Dawnbreaker, es el arma viviente de los Hijos de la Luz, forjada con los elementos más puros de una joven estrella e infundida con la esencia del aliento de sus dioses. Encargada e inseparable de la Brightmaul que una vez iluminó la oscuridad del espacio con una llama celestial, esta brillante autómata se ve obligada a ocuparse de las tareas de sus creadores que deseaban continuar la búsqueda del Jinete Luminoso contra la oscuridad y el caos al tiempo que extendían su brillo interior hasta los confines del cosmos.\n" +
                                "\n" +
                                "Una gran tragedia no tardó en llegar a Valora y a sus amos dejándola prácticamente sin vida e inerte en el frío espacio negro entre las estrellas y los planetas. Su incontrolado recorrido por el espacio la llevó al planeta en el que se estrellaron las Piedras Némesis permaneciendo dormida durante eones hasta que una estrella en los confines del espacio la revivió con su chispa. Ahora se levanta de su oscuro sueño para ser testigo de un mundo desconocido acosado por el mismo caos al que sus amos anhelaban oponerse.\n" +
                                "\n" +
                                "Tras muchos años de inactividad lo que está en juego en la lucha que tiene ante sí no ha cambiado por lo que empuña su Brightmaul una vez más para doblegar el caos al orden y brillar en la oscuridad honrando la memoria de sus amados maestros.";
                        break;
                    case "texto4":
                        hist = "Entre la progenie del primer sol del Guardián, se encontraban los Hijos de la Luz, una constelación entre las muchas estrellas nacidas del crisol de su supernova que fueron testigos de un mundo acosado por el caos que perseguía al creador de su antepasado. Al tomar el manto abandonado del Guardián continuaron su labor de traer la luz y el orden al reino mientras establecían sus propios objetivos para purgar el cosmos de toda criatura de la oscuridad.\n" +
                                "\n" +
                                "Para ayudarles en sus interminables esfuerzos moldearon un guerrero de los elementos en el corazón de una joven estrella y lo animaron con su aliento dorado. Este gólem pronto sería conocido como Valora, la Rompedora de Amaneceres, que se convertiría en la única dueña del Brightmaul, un martillo capaz de iluminar el oscuro vacío del espacio con fuego celestial. Heraldo luminoso de la majestuosidad del orden y la luz, la única vocación de Valora era unirse a los Niños para extender su resplandor a los rincones más oscuros del universo, inicialmente ajena a su propio sentido.";
                        break;
                    case "texto5":
                        hist = "Aunque los objetivos de los Hijos de la Luz de iluminar parecían justos, hubo algunos entre el vasto linaje de estrellas que se negaron a alinearse con ellos y se rebelaron. Fieles a su dedicación al orden los Hijos enviaron a su ejecutor Valora para acabar con la oposición, ya fuera destruyéndola o intimidándola con una demostración de su poder para que se uniera a su causa. Una y otra vez se le encomendaron más misiones, cada una más desalentadora que la anterior.\n" +
                                "\n" +
                                "Una de esas tareas fue la purga de las criaturas de la noche primordial, de las que Balanar fue una vez miembro. En el amanecer del Primer Día todas las criaturas de la noche perecieron excepto la que conocemos como Balanar. También se unió a Ares en una campaña de un siglo de duración contra las fuerzas del Continuum, que acabó con el derrumbe de las fuerzas de Ares y Valora.\n" +
                                "\n" +
                                "Ninguna de estas misiones fue tan atrevida y arriesgada como su misión final de eliminar para siempre todos los aspectos de la oscuridad y el caos. A pesar de saber que su fracaso era innegable si decidían participar en él, enviaron a Valora para que se hiciera con un poder inalcanzable para atar el caos para siempre: el poder de un Fundamental, cuya carga une toda la existencia.\n" +
                                "\n" +
                                "Por primera vez en su eterna vida Valora y su martillo acabaron fracasando. La chispa dentro de sus maestros fue borrada y Valora, al tener un vínculo vital conectado a ellos, compartió el mismo destino por su complicidad en su ataque contra Io. Sin la chispa de los Niños para animar su cuerpo quedó a la deriva en el vacío del espacio mientras se desvanecía en un oscuro sueño durante eones incontables hasta que su rumbo sin rumbo quedó atrapado en la atracción de un mundo desconocido.";
                        break;
                    case "texto6":
                        hist = "En algún lugar del cosmos la estrella que dio forma a Valora se había convertido en una fría estrella de neutrones. Esta estrella se encontraba entre las muchas cosas que dejaron abandonadas los últimos Hijos de la Luz, como la abandonada forja de energía solar de los Hijos que estaba enterrada bajo un soplador de residuos rojos (posiblemente una nebulosa, dada la descripción), en algún lugar profundo del cosmos. Una joven estrella errante que heredó la chispa de sus maestros le dio combustible para encender su chispa una vez más, devolviendo a Dawnbreaker al borde de la conciencia y restaurando una porción infinitesimal de sus antiguos poderes.\n" +
                                "\n" +
                                "Pero Valora no despertó del todo todavía. Incluso después de restablecer el vínculo con su antigua fuente de vida seguía sin salir de su letargo y pasaba el tiempo en la oscuridad del sueño pensando en sus fracasos y lamentando la pérdida de sus maestros. Pero pronto se dio cuenta de que el mundo aún podía utilizar su luz y se despertó en un mundo asediado por el caos que sus creadores intentaron detener. Con la Brightmaul en sus manos para que la acompañe en este mundo desconocido ejerce sus nuevos poderes para terminar lo que sus maestros empezaron.";
                        break;
                    case "texto7":
                        hist = "Procedente de una época en la que los seres poderosos y ancestrales eran habituales, Valora mira con desprecio el mundo que ve hoy en día considerando a sus habitantes como cosas débiles e inferiores. No se relaciona con los mortales ni con los dioses modernos con los que se encuentra porque ella lleva mucho más tiempo que ellos con su perspectiva dilatada de la existencia y su mayor experiencia de combate con criaturas y entidades mucho más poderosas que las actuales.";
                        break;
                    case "texto8":
                        hist = "Valora pertenece a un vasto linaje de estrellas que se remonta al primer sol que existió en el universo creado por su bisabuelo Keeper of the Light. Entre la progenie de este sol se encuentran sus creadores, los Hijos de la Luz, que forjaron su cuerpo a partir de los elementos del núcleo de una estrella joven y le dieron vida con su aliento dorado. Como su más poderosa ejecutora llevó a cabo sus tareas sin cuestionarlas, lo que pronto les costaría la vida a ambos en su misión final. Tras una profunda reflexión sobre las cosas que hizo al servicio de sus amos, se siente arrepentida de lo que le hicieron hacer pero sigue honrando su memoria.\n" +
                                "\n" +
                                "La Diosa Solar es una descendiente ramificada del linaje de los hijos del primer sol del Guardián, insinuando una conexión muy lejana entre Lina y su diosa con la familia de Valora.\n" +
                                "\n" +
                                "Con respecto a Ezalor tiene muchos sentimientos encontrados. Aunque se siente humillada por la presencia del creador de todos sus creadores, expresa su pesar por el hecho de que Ezalor no recuerde cosas como el sombrío destino de los Señores de Oro (que eran sus descendientes) y que él no sepa \"poner todo en orden\", lo que indica que algo anda mal en sus vidas. También está enfadada con él por haber abandonado a sus descendientes.\n" +
                                "\n" +
                                "Eones después de quedar fuera de servicio Valora recibió una nueva vida cuando la luz de Phoenix encendió una antigua Fragua Solar que le dio nueva vida. Por ello está agradecida a la joven estrella que la revivió. Este don de la vida ha estimulado en ella un profundo respeto por Fénix que habría considerado a la joven estrella como su maestro si todavía estuviera atada a tales conceptos.\n" +
                                "\n" +
                                "Phoenix lleva un eco de la chispa de los Niños en su interior lo que significa que fueron sus antepasados solares y que Phoenix y Dawnbreaker están conectados en un nivel más profundo de lazos familiares.\n" +
                                "\n" +
                                "En un punto desconocido del tiempo, mucho antes de que se hiciera latente, solía ser amante de Marte, cuando aún era conocido como Ares. Juntos derrocaron al Continuum en una campaña que duró siglos. Poco después rompieron por razones desconocidas. Marte la llama por el nombre de Valor.\n" +
                                "\n" +
                                "Como ser antiguo, Valora parece estar bastante familiarizada con otros seres antiguos como ella: dioses, criaturas eldritch, seres antiguos, etc. Antes de su desactivación vivió en una época en la que los seres antiguos eran habituales, de ahí su familiaridad con estas entidades.\n" +
                                "\n" +
                                "En cuanto a los dioses y deidades con los que está familiarizada, Valora parece saber quién es el Dios Muerto ya que lo conoció antes de que lo mataran. Recuerda a Void Spirit en una época anterior a que adoptara una forma que lo hacía parecer viejo pero nunca lo conoció personalmente. Es una de las pocas que parece tener un conocimiento parcial de lo que es realmente la Omnisciencia. También conoce a Enigma.\n" +
                                "\n" +
                                "Valora parece ignorar el hecho de que Outworld Destroyer es el último de su especie, lo que indica que conoció a su raza antes de que disminuyera en número. Por otro lado, parece conocer a la gente de Claszureme y a los Weavers, dos seres extradimensionales más allá del tiempo.\n" +
                                "\n" +
                                "Sus maestros tienen conexiones con el maestro de Morphling y estuvieron a punto de acordar ayudar a su furioso maestro a encontrar al elemental desaparecido hasta que surgieron asuntos más urgentes que les obligaron a abandonar el asunto.\n" +
                                "\n" +
                                "Valora fue creada para velar por los objetivos de los Hijos de la Luz. Eso incluye purgar el universo de toda criatura de la oscuridad, lo que incluye a gente como Night Stalker. Pero su verdadero enemigo y el de sus amos era el Chaos Knight al que pretendían someter como parte de su plan maestro. Enviaron a Valora para que se hiciera con el poder de Io y así poder utilizarlo para someter al caos, pero Io se desquitó apagando la chispa tanto de ella como de los Niños.\n" +
                                "\n" +
                                "En los primeros momentos de su despertar en el planeta en el que se estrellaron las Piedras Némesis no quería otra cosa que vengarse de Io por haber destruido a sus amos. Tras reflexionar sobre los verdaderos motivos de sus amos buscó la absolución y ya no tiene sentimientos negativos hacia Io por su muerte.";
                        break;
                    case "frase":
                        hist = "\"¡La oscuridad teme el amanecer!\"";
                        break;
                }
                break;

            case "Dazzle":

                switch(tipo) {

                    case "texto1":
                        hist = "Cada uno de los jóvenes acólitos de la orden Dezún debe completar una serie de ritos antes de convertirse en un monje de las sombras. El rito final, el de las sombras, es un escalofriante viaje espiritual a través del Reino de Nothl, un dominio impredecible del que no todos los visitantes regresan. De aquellos que vuelven, algunos lo hacen trastornados y otros con extrañas aptitudes, pero todos los que van a ese lugar son transformados por sus experiencias.\n" +
                                "\n" +
                                "Conducido por la necesidad de la iluminación, Dazzle era el más joven de la tribu que había solicitado el sagrado ritual. Nunca antes lo había hecho nadie a tan temprana edad. Al principio la orden se lo negó, argumentando que era demasiado joven. Pero Dazzle no era fácil de disuadir. Percibiendo algo especial en el testarudo acólito, los ancianos cedieron. Dazzle bebió la sagrada poción y estuvo sentado al lado del fuego toda la noche mientras que el resto de su tribu danzaba.\n" +
                                "\n" +
                                "En la dimensión etérea del Reino de Nothl, las propiedades de la luz y de la oscuridad están invertidas de tal manera que su brillante luz sanadora, hermosa para nuestros ojos, es objetivamente siniestra, de alguna forma maligna y nuestros más oscuros actos son realzados con un brillo cegador. La intuición de los ancianos resultó profética: Dazzle volvió con su gente siendo un Monje de las Sombras diferente a todos los anteriores y con el poder de curar y destruir. Ahora usa ese poder para aniquilar a sus enemigos y sanar a sus aliados.";
                        break;
                    case "texto2":
                        hist = "Dazzle ha estado en las selvas de Fellstrath donde descubrió una especie de mariposa que se alimenta de la energía del Reino de Nothl.";
                        break;
                    case "texto3":
                        hist = "Al proceder de orígenes similares, Huskar considera a Dazzle como un primo. A pesar de ello está resentido con él por haberle traído de vuelta del Reino de Nothl.";
                        break;
                    case "frase":
                        hist = "\"Donde cae mi sombra, cae mi enemigo\"";
                        break;
                }
                break;

            case "Krobelus":

                switch(tipo) {

                    case "texto1":
                        hist = "Krobelus era una Profetisa de la Muerte (Death Prophet), lo que significa que ella decía la buenaventura a los ricos que deseaban ver más allá del velo. Pero tras años de investigar en nombre de otros, empezó a buscar pistas sobre su propio destino. Cuando la muerte se negó a revelar sus secretos, ella trató de comprarlos con su propia vida. Sin embargo, el precio más alto, resultó ser insuficiente.\n" +
                                "\n" +
                                "La muerte la rechazaba una y otra vez, siempre ocultando el más profundo de sus misterios, y en su alma creció la mayor de las envidias. Otros podían morir por toda la eternidad, ¿pero por qué no ella? ¿Por qué era arrojada de nuevo a las orillas de la vida con una regularidad tan agobiante? ¿Por qué no era digna de la única cosa que los demás seres vivos dan por supuesto? A pesar de todo, no se desanimó. Cada vez que regresaba de la tumba traía un poco más de muerte con ella. Los espectros la seguían como fragmentos de su alma destrozada; su sangre se diluyó y se volvió ectoplásmica; las vivaces criaturas del atardecer la tomaron por una de su especie.\n" +
                                "\n" +
                                "Cada vez que fallecía, dejaba ir un poco más de su vida y empezaba a parecer que su fin estaba cerca. Con su dedicación a la muerte redoblada y ningún otro cliente que no fuese ella misma, se lanzaba cada vez con más fervor al abismo con la intención de cumplir la profecía que la eludía: que algún día Death Prophet ya no regresaría más de entre los muertos.";
                        break;
                    case "texto2":
                        hist = "Afirma haber visto el campo de batalla de los Ancestros varias veces en sus sueños.\n" +
                                "\n" +
                                "La sangre de Krobelus se ha vuelto delgada y ectoplásmica, pero también puede servir como la tinta oscura que utiliza para escribir sus futuras profecías.\n" +
                                "\n" +
                                "Los espíritus que convoca con su Exorcismo son, por defecto, sus vidas pasadas por cada muerte que ha experimentado. Pero a veces, otros espíritus o entidades pueden ser convocados por ella como murciélagos etéreos, polillas o incluso espíritus salvajes que puede haber encontrado durante su estancia en el más allá.\n" +
                                "\n" +
                                "Es posible que haya perdido la vista por haber espiado demasiado sus profecías.\n" +
                                "\n" +
                                "Parece que todavía tiene una chispa de vida muy tenue en su interior que sigue siendo lo suficientemente brillante como para atraer a las sombras y otras criaturas en los reinos de la muerte que visita.\n" +
                                "\n" +
                                "Sus intentos de cruzar el velo de la muerte han sido tan frecuentes que las almas de los recién fallecidos, tanto de los remanentes como de los enteros, se han aferrado a ella para intentar volver con ella. Estos intentos han dado lugar a que se conviertan en un vestido bastante grotesco. Se desconoce si fue o no contra su voluntad.\n" +
                                "\n" +
                                "Krobelus puede ser amiga, imitadora o ella misma fue la \"Bruja de las Tierras Exteriores\", una bruja de la que se decía que no era necesariamente malévola pero sus profecías predichas no debían ser simplemente ignoradas.\n" +
                                "\n" +
                                "Es posible que una supuesta mujer, a la que sólo se refiere como \"la novia de la muerte\", le enseñara sus habilidades y conocimientos. No se conocen registros sobre ella, sólo rumores y unas pocas reliquias que dejó a la entonces joven Krobelus antes de su partida.\n" +
                                "\n" +
                                "Krobelus conserva un conjunto de ropa formal que reserva para las \"ocasiones más mortíferas\". También parece tener un tocado regio que simboliza su unión con la muerte. Sólo se lo quita con profundo pesar.\n" +
                                "\n" +
                                "Ella parece haber conocido a Rhasta, el Chamán de las Sombras, de antemano, conociendo su nombre real así como insinuando que sus prácticas fueron continuadas desde hace mucho tiempo.\n" +
                                "\n" +
                                "También parece tener una atracción por aquellos afiliados a la muerte o que han experimentado la muerte misma.";
                        break;
                    case "frase":
                        hist = "\"Lo que he visto va mucho más allá de la muerte\"";
                        break;
                }
                break;

            case "Disruptor":

                switch(tipo) {

                    case "texto1":
                        hist = "En lo más alto de las estepas asoladas por el viento de Druud, un talentoso creatormentas llamado Disruptor fue el primero en descubrir los secretos de las borrascas de verano. Bajo el asalto constante de las tormentas estacionales y la invasión de los reinos civilizados del Sur, las tierras altas de Oglodi han luchado durante siglos para subsistir en la cima de las mesetas interminables. Ellos son los restos de lo que otrora fue una gran civilización: El creatormentas de semblante extraño e inescrutable recoge los desechos de un conocimiento perdido que ya ni entiende en su totalidad. Para aquellos que habitan la meseta, el clima se ha convertido en una especie de religión, venerado tanto por dar como por quitar la vida. Pero las tormentas eléctricas que traen las lluvias que mantienen la vida tienen un precio, el de los cadáveres calcinados que dejan a su paso.\n" +
                                "\n" +
                                "A pesar de ser pequeño para su especie, Disruptor era valiente y curioso. Aún sin sangre y sin stryder, exploró las ruinas de las ciudades buscando entre bibliotecas derruidas y oxidadas fábricas. Cogió lo que necesitaba y regresó a su tribu. Modificando una bobina de diseño ancestral, consiguió hacerse con el control de la diferencia de carga eléctrica y así poder lanzar los rayos a su voluntad. Parte magia, parte artesanía, sus resplandecientes bobinas conservan el poder de la vida y de la muerte, un poder blandido con precisión contra las castas terratenientes del Sur y contra cualquier intruso que cruce las antiguas tierras de Oglodi.";
                        break;
                    case "texto2":
                        hist = "Bristleback admira a Disruptor por su fortaleza, al igual que a otros Oglodi.\n" +
                                "\n" +
                                "A diferencia de otros Oglodi, Disruptor es más refinado, razonable y menos propenso al asesinato indiscriminado\n" +
                                ".\n" +
                                "A Disruptor le ofende que le metan en el mismo saco que los violentos Niebla Roja y su líder, Sorla Khan.";
                        break;
                    case "frase":
                        hist = "\"Con tormentas eléctricas, derribaré a mis enemigos\"";
                        break;
                }
                break;

            case "Lucifer":

                switch(tipo) {

                    case "texto1":
                        hist = "Arde pero no se consume, devora pero no se sacia, mata pero está más allá de cualquier dictamen, Lucifer trae la condenación a todos los que le hacen frente. Arrebatando almas con la punta de una espada de fuego, él es el Caído. Incapaz de doblegarse y antaño un destacado general del reino de más allá de la luz, fue expulsado por el pecado de la rebeldía.\n" +
                                "\n" +
                                "Seis veces su nombre fue tañido desde la gran campana de Vashundol. Seis y sesenta veces sus alas fueron estigmatizadas, hasta que solo quedaron muñones humeantes. Sin alas se escurrió de las ataduras que lo mantenían en la luz y cayó gritando hacia la tierra. Del paraíso a un cráter en medio del desierto. Ahora ataca sin piedad, sin motivo, el único ser vivo capaz de moverse libremente por los siete dominios oscuros. Azotado por necesidades ineluctables y atormentado por talentos inimaginables, Doom arrastra su propio infierno dondequiera que va. Desafiante hasta el final. Es solo cuestión de tiempo que el mundo le pertenezca.";
                        break;
                    case "texto2":
                        hist = "Como otros demonios, Lucifer habla ozkavosh.\n" +
                                "\n" +
                                "En Ozkavosh, el nombre de Lucifer es Lucifash.\n" +
                                "\n" +
                                "Según Nevermore, Lucifer vivió una vez o lo encerraron en un pozo.\n" +
                                "\n" +
                                "Lucifer es a menudo llamado \"el que arde y no se consume\".\n" +
                                "\n" +
                                "Lucifer disfruta del dolor que inflige a los enemigos menores que consume.\n" +
                                "\n" +
                                "Según Lucifer, hay siete infiernos.\n" +
                                "\n" +
                                "Según Elder Titan, nunca hubo uno como Lucifer en todos Los Siete Planos.\n" +
                                "\n" +
                                "Según Pudge, Lucifer es más amable de lo que la mayoría de la gente cree.";
                        break;
                    case "frase":
                        hist = "\"Hehm ehme meh heh heh, habla de mí y apareceré. ¡Enfréntame y enfrénta el infierno!\"";
                        break;
                }
                break;

            case "Davion":

                switch(tipo) {

                    case "texto1":
                        hist = "Después de años tras la pista de un legendario Eldwurm, el Caballero Davion se encontró frente a un enemigo decepcionante: el temible Slyrak se había vuelto viejo y frágil, sus alas estaban hechas jirones, sus pocas escamas restantes afectadas por la podredumbre, sus colmillos desgastados hasta las encías y su aliento de fuego no era más amenazador que una caja de cerillas mojada.\n" +
                                "\n" +
                                "Al ver que no obtendría honor por matar al dragón, el Caballero Davion se preparó para el viaje de regreso y dejar a su viejo enemigo morir en paz. Pero una voz penetró en sus pensamientos, y Slyrak le susurró a Davion que sería un honor para él morir en combate. Davion aceptó, y se vio recompensado más allá de las expectativas por su acto de misericordia: mientras hundía su hoja en el pecho de Slyrak, el dragón atravesó la garganta de Davion con una garra. A medida que su sangre se mezclaba, Slyrak transfirió su poder a través del flujo sanguíneo, ofreciéndole al caballero toda su fuerza y siglos de sabiduría. La muerte del dragón selló su vínculo, y el Caballero Dragón (Dragon Knight) había nacido. El ancestral poder permanece dormido dentro del Caballero Dragón Davion, despertándose cuando él lo llama. O quizás es el Dragón el que llama al Caballero...";
                        break;
                    case "texto2":
                        hist = "Antes de matar a Slyrak Davion también mató a Uldorak, otro dragón que amenazaba al reino de Candoness. Al hacerlo se ganó la gratitud de su rey Tansis XIII.\n" +
                                "\n" +
                                "Es posible que Davion también haya matado al Wyvern Carmesí aunque nunca se dice explícitamente.\n" +
                                "\n" +
                                "Davion es dueño de Dragonmaw, una de las Espadas Nombradas.\n" +
                                "\n" +
                                "Gran parte de la armadura de Davion está construida con partes de dragones muertos.\n" +
                                "\n" +
                                "Según Sylla, Davion es miembro del Clan del Dragón, aunque no lo sepa.\n" +
                                "\n" +
                                "Davion no es el único humano que ha mezclado su sangre con la de un dragón aunque es uno de los pocos cuya mezcla dio lugar a la capacidad de manifestar cepas ancestrales de dragón.\n" +
                                "\n" +
                                "El Archronicus da a entender que Davion pertenece a una oscura y antigua orden conocida como los Caballeros Escamados de Uthorian ya que lleva un escudo similar al que Thesos recuperó de los restos del estómago de un dragón.";
                        break;
                    case "texto3":
                        hist = "Davion es uno de los principales protagonistas de la serie de animación. La mayor parte de sus antecedentes y su historia han sido modificados para adaptarlos a la narrativa como su fatídico encuentro con Slyrak y la orden de caballeros a la que pertenece pero su identidad como Caballero Dragón permanece en su mayor parte inalterada. Su primera muerte y renacimiento se produjo cuando Slyrak, que estaba al borde de la muerte tras su batalla con Terrorblade. Le pide a Davion que lo mate, pero antes de que Davion ataque, Slyrak corta la garganta de Davion y luego fusiona su sangre convirtiéndose en uno dando a Davion la capacidad de hablar con los dragones mayores. Después fue asaltado por bandidos, marcando su primera batalla y transformándose en un dragón. Su baño de sangre en Hauptstadt fue presenciado por Marci y Mirana. Más tarde, reclamó su guante de caballero dragón. Junto con Marci, Sagan y Mirana caminan desde el bosque hasta Dragon Hold para finalmente llegar a la torre de Invoker.\n" +
                                "\n" +
                                "Cuando se transforma en dragón su ropa siempre se desgarra hasta que el Invoker hizo un remedio por ahora: Una armadura que no se puede destruir cuando se transforma.";
                        break;
                    case "frase":
                        hist = "\n" +
                                "\"El Dragón Slyrak duerme dentro de esta armadura y el caballero dentro del Dragón espera. Ten cuidado de no despertarlos a ambos\"";
                        break;
                }
                break;

            case "Traxex":

                switch(tipo) {

                    case "texto1":
                        hist = "El nombre de pila de Drow Ranger es Traxex, muy adecuado para los cortos y repulsivos Drow con pinta de troll. Pero Traxex en sí misma no es una Drow. Sus padres eran viajeros en una caravana asaltada por bandidos, cuya ruidosa masacre de inocentes despertó la ira de los pacíficos Drow.\n" +
                                "\n" +
                                "Tras finalizar la batalla, los Drow descubrieron a una pequeña niña escondida en los vagones destrozados y acordaron que no podía ser abandonada. Incluso como niña, Traxex se mostró naturalmente adepta a las artes que apreciaban: sigilo, silencio, sutileza... En espíritu, si no en físico, podría haber sido una Drow intercambiada en el pasado y devuelta a su hogar. Pero a medida que crecía, empezó a destacar por encima de su familia y llegó a pensar que era fea. Después de todo, sus rasgos eran suaves y simétricos, totalmente desprovista de verrugas y bigotes gruesos.\n" +
                                "\n" +
                                "Alejada de su familia adoptiva, se retiró a vivir sola en el bosque. Los viajeros que se pierden en el bosque a veces hablan de una exploradora increíblemente bella que los observa desde lo más profundo de los árboles, y que luego se desvanece como un sueño antes de que puedan acercarse a ella. Ágil y sigilosa, fría y seductora, se mueve en silencio como la niebla. Ese susurro que oyes son sus flechas de hielo en busca del corazón de un enemigo.";
                        break;
                    case "texto2":
                        hist = "En busca de materiales para una nueva arma Traxex descendió bajo tierra para reunirse con sus hermanas drow. Conocedora de la etiqueta y las ceremonias drow, sabía la forma correcta de pedir una rama del Árbol de la Raíz de Sangre, que era sagrado para las drow. Se le concedió una rama blanca que utilizó para fabricar un nuevo arco.";
                        break;
                    case "texto3":
                        hist = "Traxex vive una existencia solitaria y a veces se le conoce como el Viajero Solitario.\n" +
                                "\n" +
                                "Traxex recorre un claro secreto en el bosque, con un pasaje secreto debajo iluminado por cristales brillantes. Allí encontró un arco formado de cristal.\n" +
                                "\n" +
                                "Traxex forma parte de la Guardia Boreal.\n" +
                                "\n" +
                                "Traxex admira a la Guardia Silvana y una vez contempló la posibilidad de unirse a ella por sus elegantes guantes.\n" +
                                "\n" +
                                "Traxex va a la caza de trofeos de gatos de las sombras.\n" +
                                "\n" +
                                "Traxex derrotó una vez a un demonio de las nieves que pretendía desafiarla.\n" +
                                "\n" +
                                "Traxex adora a cierto espíritu divino búho, quizás aprendido de los drow. Una vez soñó con el espíritu y se despertó con un arco a su lado en un lecho de hojas.\n" +
                                "\n" +
                                "Se ha oído a Traxex decir \"¿Y por qué no debería?\", a absolutamente nadie.\n" +
                                "\n" +
                                "Es posible que Traxex se haya aventurado hacia el norte, tal vez hacia Icewrack o La Barrera, donde se encontró con un gran espíritu de lobo blanco. Sólo un arquero fue capaz de abatir a la bestia, posiblemente la propia Drow Ranger.\n" +
                                "\n" +
                                "Traxex es miembro de los Kha-Ren.";
                        break;
                    case "texto4":
                        hist = "yralei es la principal rival de Traxex y a menudo dice cosas malas sobre ella. Según Lyralei, Traxex es una \"cáscara emocionalmente vacía de tristeza perpetua\", Traxex responde llamando a Lyralei \"completamente inútil\"[14].\n" +
                                "Traxex puede tener una relación especial con Pudge y Slark.";
                        break;
                    case "frase":
                        hist = "\"Camino solo, pero las sombras son compañía suficiente\"";
                        break;
                }
                break;

            case "Kaolin":

                switch(tipo) {

                    case "texto1":
                        hist = "En lo más profundo de las Tierras Altas, entre sus peñascos y precipicios, existe un filón de jade sagrado al que renegaron los mineros de las tierras altas. De este raro material se esculpió el semblante del gran general Kaolin, que fue enterrado a la cabeza de un ejército funerario de piedra con el poder de diez mil; soldados y ascéticos, bufones y acróbatas, esculpidos por artesanos y sepultados durante milenios bajo el oscuro cobijo de la Tierra.\n" +
                                "\n" +
                                "Lo que los artesanos no sabían era que en el interior del extraño filón de jade fluía el espíritu de la misma Tierra; una fuerza elemental que era uno con el planeta. Cuando la fuerza dentro del jade tallado se vio separada de la energía de la vida del mundo, reunió fuerzas durante el curso de mil años, excavó hasta ser libre y alcanzar la luz. Ahora, el gran espíritu terrestre Kaolin merodea por los caminos de las Tierras Altas, luchando por el espíritu de la Tierra; y en momentos de necesidad llama a los remanentes de su ejército sepultado, que aún se encuentra encerrado bajo el amoroso cobijo del barro.";
                        break;
                    case "texto2":
                        hist = "Kaolin comparte ancestros con Ember Spirit, Storm Spirit, Void Spirit y Brewmaster.\n" +
                                "\n" +
                                "Kaolin cree en un \"gran ciclo\" de la vida, simbolizado por una rueda, en referencia a la reencarnación.";
                        break;
                    case "texto3":
                        hist = "Kaolin llama a Nature's Prophet \"su profeta\" y afirma conocer la verdadera naturaleza de Tiny.\n" +
                                "\n" +
                                "Kaolin adora o encarna a una diosa desconocida.\n" +
                                "\n" +
                                "Grimstroke afirma que Kaolin es una marioneta manejada por un amo desconocido.\n" +
                                "\n" +
                                "Debido a estos factores, Kaolin podría ser la reencarnación de la diosa Verodicia.\n";
                        break;
                    case "texto4":
                        hist = "Grimstroke desprecia a Kaolin, posiblemente debido a alguna calamidad que una vez infligió a Ashkavor.";
                        break;
                    case "frase":
                        hist = "\"A través del conflicto la naturaleza de uno se revela\"";
                        break;
                }
                break;

            case "Raigor Stonehoof":

                switch(tipo) {

                    case "texto1":
                        hist = "Como un gólem o una gárgola, Earthshaker fue uno con la tierra, pero ahora camina libremente sobre ella. A diferencia de las otras entidades, se creó a sí mismo a través de un acto de voluntad, y no sirve a ningún otro maestro. En su sueño inquieto, encerrado en una profunda fisura en la piedra, se dio cuenta de la vida que transcurría libremente por encima de él y se volvió curioso.\n" +
                                "\n" +
                                "Durante una época de temblores, los picos de Nishai fueron sacudidos, provocando derrumbamientos que cambiaron el curso de los ríos y convirtieron los valles poco profundos en abismos sin fondo. Cuando la tierra finalmente dejó de temblar, Earthshaker salió del polvo que se asentaba, apartando enormes rocas como si se tratasen de una ligera manta.\n" +
                                "\n" +
                                "Se convirtió en una bestia mortal, y se llamó a sí mismo Raigor Pezuñapétrea. Ahora sangra, respira y por lo tanto puede morir, pero su espíritu sigue siendo ese de la tierra. Su poder reside en el tótem mágico que nunca deja de lado y, el día que regrese al polvo, la tierra lo tratará como a un hijo pródigo.";
                        break;
                    case "texto2":
                        hist = "Earthshaker fue una vez un ser inmortal sin nombre, capaz de adoptar diversas formas. Procede de Nishai, donde permaneció dormido hasta que fue despertado por un terremoto. Incluso en su sueño Earthshaker era capaz de sentir las formas de vida que le rodeaban. Asumiendo la forma de una bestia mortal es capaz de remodelar su cuerpo a voluntad, dotándose de cuernos para defenderse de un mundo hostil.\n" +
                                "\n" +
                                "Se ha hecho amigo de las Gárgolas, una especie que habita en Nishai. Hay pruebas de que tiene algunas relaciones con los Behemoths cuyos restos utiliza como armadura.\n" +
                                "\n" +
                                "Earthshaker está encargado de proteger La Montaña Roja, posiblemente un lugar en Nishai, Es hostil a los Dire, equipando tótems especiales imbuidos de luz para contrarrestar su corrupción.\n" +
                                "\n" +
                                "Earthshaker tiene una fuerte conexión con la luna.";
                        break;
                    case "texto3":
                        hist = "Earthshaker recuerda una \"tierra hermana\", otro planeta que fue destruido por seres desconocidos. En sus últimos momentos, Earthshaker la recuerda sintiendo un gran dolor. Un fragmento de ese planeta se ha fusionado ahora con Earthshaker y su poder está volviendo a despertar en su interior. Tras derrotar a un \"viajero interestelar\" que pretendía destruir los restos de su Tierra hermana ahora está al acecho de futuros ataques. Al mismo tiempo trata de entender cómo fue destruida su tierra hermana y algún día vengar su muerte. Mientras tanto utiliza el fragmento de su tierra hermana como tótem.\n" +
                                "\n" +
                                "La entidad que destruyó su tierra hermana también busca destruir otros mundos y Earthshaker puede sentir su llegada. Se ha encontrado con ella antes, en una vida diferente, y fue asesinado por ella. Según él, la entidad no es la única de su tipo.\n" +
                                "\n" +
                                "Para ayudarle a prepararse para el próximo enfrentamiento, Earthshaker ha tenido varias consultas y desencuentros con su amigo Io, pidiéndole su ayuda para llegar a otro mundo. Con la intención de cruzar al espacio y encontrarse con la entidad, le pregunta a Io sobre la reubicación y a Zet sobre el viaje a través del cosmos.\n" +
                                "\n" +
                                "Percibiendo las preocupaciones de Earthshaker, Inai es el único que le ofrece respuestas.";
                        break;
                    case "texto4":
                        hist = "A Earthshaker le gusta decir \"Let's Roll\", hasta un punto molesto.\n" +
                                "\n" +
                                "Earthshaker tiene una malsana obsesión por las Dagas Parpadeantes (Blink Dagger).";
                        break;
                    case "frase":
                        hist = "\"Puede haber muchas tierras, pero solo hay un Earthshaker\"";
                        break;
                }
                break;

            case "Elder Titan":

                switch(tipo) {

                    case "texto1":
                        hist = "Tal vez te preguntes: «¿Cómo obtuvo este mundo su forma?» ¿Por qué de entre todos los mundos de la creación tiene este sus extrañas propiedades así como su diversa y amplia colección de criaturas, culturas e historia? «La respuesta», susurra uno, «radica en los Titanes».\n" +
                                "\n" +
                                "Estos progenitores originales estaban ahí prácticamente al principio o incluso fueron testigos de la creación y luego nacieron con ella todavía resonando en sus oídos. Marcados por las primeras energías del universo, no querían otra cosa más que continuar siendo creadores. Así que decidieron dedicarse a la tarea de darle forma a la materia a su antojo; golpeando con martillos, calentando, doblando y aplastando. Cuando la materia se mostró menos desafiante de lo que desearían, usaron sus herramientas en ellos mismos, reformando sus mentes y reforjando sus espíritus hasta convertirse en criaturas de gran durabilidad. La propia realidad se convirtió en su gran obra maestra. Y aun así, de tanto en tanto, se equivocaban. Cuando se tiene mucha ambición, los fallos son inevitables.\n" +
                                "\n" +
                                "Aquel al que conocemos como Elder Titan fue un gran innovador, un estudioso de la forja de la creación. Al mejorar sus habilidades, hizo pedazos algo que nunca podría ser reparado, solo desechado. Cayó en su propio mundo destrozado, con su alma despedazada. Allí vagó, entre los irregulares fragmentos y los planos escindidos, junto a otros fragmentos perdidos que se habían filtrado a través de las grietas del principio del universo. Y por eso el mundo que conocemos se parece a una isla de náufragos, supervivientes de un naufragio olvidado hace mucho tiempo. Olvidado por todos, excepto por el que se culpa a sí mismo. Pasa su tiempo siempre buscando una forma de repararlo, pensando que podrá reunir las partes de su alma rota, que tanto él como el mundo pueden ser arreglados. Lo conocemos como Elder Titan.";
                        break;
                    case "texto2":
                        hist = "Elder Titan habla a menudo de la Unidad y la Gran Simetría, un estado del ser anterior al Cisma, cuando los fundamentales fueron creados a través de la división.\n" +
                                "\n" +
                                "Elder Titan existe en los siete planos a la vez.\n" +
                                "\n" +
                                "Elder Titan llama a su Espíritu Astral su \"alma de sombra\". \n" +
                                "\n" +
                                "Elder Titan conoció a Treant Protector y a Earthshaker en su pasado.\n" +
                                "\n" +
                                "Elder Titan siente un gran respeto por Lone Druid.\n" +
                                "\n" +
                                "Elder Titan es conocido a veces como el Único (The One).\n" +
                                "\n" +
                                "Elder Titan colecciona reliquias para guardarlas, incluyendo una pieza de la Wyrmforge.\n" +
                                "\n" +
                                "Elder Titan sólo tiene una oportunidad de reparar el mundo.";
                        break;
                    case "frase":
                        hist = "\"Es justo que yo sea arrojado a este mundo porque yo ayudé a destrozarlo\"";
                        break;
                }
                break;

            case "Xin":

                switch(tipo) {

                    case "texto1":
                        hist = "Perdida en las Montañas Aulladoras, la Fortaleza de Destellos yacía abandonada, sus salas de entrenamiento vacías, su patio cubierto de hojas y de polvo. Sobre una tarima en su templo sellado descansa un caldero de jade lleno de ceniza antigua, restos de una pira para el guerrero-poeta Xin. Durante tres generaciones, Xin enseñó a sus acólitos los Vínculos de la Llama Guardián, una serie de mantras que entrenan cuerpo y mente para las duras realidades más allá de los muros de la fortaleza.\n" +
                                "\n" +
                                "No obstante, al enseñar el camino del guerrero consiguió los rivales del guerrero; en su ocaso fue superado y asesinado. Sus seguidores se dispersaron con el viento. A pesar de que los años se convirtieron en siglos y los seguidores en descendientes, sus enseñanzas perduraron mediante sutiles susurros y manuscritos. Debido al legado del maestro, el Celestial Ardiente, aspecto del fuego, se invocó a sí mismo a la Fortaleza de Bengalas y volvió a prender la pira de ceniza. A partir de esas brasas, surgió una imagen de Xin, envuelto en llamas, su semblante pensativo preparado para entrenar, enseñar y difundir el fuego del conocimiento a todos aquellos que busquen orientación.";
                        break;
                    case "texto2":
                        hist = "Xin cree en el equilibrio y la armonía.\n" +
                                "\n" +
                                "Xin suele emplear cadenas al rojo vivo en sus enseñanzas.\n" +
                                "\n" +
                                "Ember Spirit comparte ancestros con Storm Spirit, Earth Spirit, Void Spirit y Brewmaster.\n" +
                                "\n" +
                                "En la fortaleza se guardaban un par de estoques reliquia que cobraban vida con el fuego cuando eran recogidos por el Xin reencarnado.\n" +
                                "\n" +
                                "En una ocasión Xin envió a sus Restos de Fuego a una tormenta de arena para que buscaran a los que todavía practicaban las enseñanzas de la Llama Guardiana.\n" +
                                "\n" +
                                "Los logros de Xin durante sus últimos años suelen considerarse los más impresionantes.";
                        break;
                    case "texto3":
                        hist = "En su vida anterior Xin solía entrenar con Yurnero lo que produjo resultados interesantes.\n" +
                                "\n" +
                                "Grimstroke desprecia a Xin, posiblemente debido a alguna calamidad que una vez infligió a Ashkavor.";
                        break;
                    case "frase":
                        hist = "\"Equilibrio en todas las cosas\"";
                        break;
                }
                break;

            case "Aiushtha":

                switch(tipo) {

                    case "texto1":
                        hist = "Aiushtha tiene aspecto de ser una inocente y despreocupada criatura de los bosques, y aunque hasta cierto punto esto es verdad, difícilmente es la historia de su vida. Ella entiende como nadie el sufrimiento del mundo natural. Ha viajado lejos, ha recorrido bosques brillantes y frondosos, en cualquier clima o estación, haciendo amigos, compartiendo noticias, llevando risas y alegría por doquier. Pero en los mundos hostigados por las guerras, los bosques no son más que materias primas para construir barcos y catapultas; incluso en los lugares pacíficos, los bosques son arrasados para construir casas y arder en las chimeneas.\n" +
                                "\n" +
                                "Aiushtha escucha los ruegos de las criaturas pequeñas, aquellas que necesitan un manto verde bajo sus pies y un techo de hojas sobre sus cabezas. Ella escucha a aquellos a los quien nadie oye. Lleva sus historias de los bosques al mundo, creyendo que su buen ánimo es una especie de Encantamiento, convencida de que puede hacer realidad la promesa de un boscoso futuro.";
                        break;
                    case "texto2":
                        hist = "Ulfsaar mantiene una buena relación con Aiushtha.\n" +
                                "\n" +
                                "Sylla insinúa que Aiushtha ha olvidado su \"verdadera forma\".\n" +
                                "\n" +
                                "Terrorblade afirma que es el mejor amigo de Aiushtha por razones desconocidas.\n" +
                                "\n" +
                                "Aunque por lo general es alegre y de buen carácter Aiushtha odia a los cazadores furtivos y ha ideado medios especiales para tratar con ellos.\n" +
                                "\n" +
                                "Davion está bastante encariñado con Aiushtha ya que suele llamarla \"rayo de sol\".";
                        break;
                    case "texto3":
                        hist = "Aiushtha trabajó en una ocasión con Donte Panlin.";
                        break;
                    case "frase":
                        hist = "\"¿Sabes lo que amo? ¡Todo!\"";
                        break;
                }
                break;

            case "Enigma":

                switch(tipo) {

                    case "texto1":
                        hist = "Nada se sabe del pasado de Enigma. Solo hay historias y leyendas, la mayoría apócrifas, transmitidas a través de los siglos. Realmente Enigma es un misterio que tiene como única biografía real una breve descripción: una fuerza universal, un devorador de mundos. Es un ser del abismo, a veces corpóreo y otras veces etéreo. Una bestia entre planos.\n" +
                                "\n" +
                                "Hay historias que dicen que una vez fue un gran alquimista que intentó descubrir los secretos del universo y fue maldecido por su arrogancia. Otra leyenda dice que es un ser ancestral con una extraña gravedad, el abismo personificado, una retorcida voz de la oscuridad primigenia, anterior a la primera luz del universo. Y hay leyendas más antiguas que dicen que fue la primera estrella colapsada, un agujero negro desarrollado y que puede sentir. Con unas motivaciones insondables y un poder inexorable, es una energía destructiva lanzada contra la propia existencia.";
                        break;
                    case "texto2":
                        hist = "Enigma es un Fundamental, una fuerza del universo creada cuando Elder Titan provocó la división del mundo durante el Cisma. Tiene control sobre la gravedad.\n" +
                                "\n" +
                                "Al igual que otros Fundamentales Enigma regresa al Plano Fundamental cuando muere.\n" +
                                "\n" +
                                "Mireska codicia los poderes de Enigma, halagándolo e intentando que revele sus secretos.\n" +
                                "\n" +
                                "Pudge cree que Enigma es un arrogante.";
                        break;
                    case "texto3":
                        hist = "Antes de que el tiempo empezara a fluir, los cuatro Fundamentales estuvieron una vez unidos en el Plano Fundamental donde todos estaban ligados a la gran armonía primordial creada por Elder Titan. Cuando su martillo cayó en el mundo causó un efecto devastador en el universo primitivo que partió el Plano Fundamental. Keeper of the Light se separó de los otros Fundamentales, incluyendo a Enigma, quien siguió su ejemplo y escapó del plano primordial poco después. Aunque es una fuerza destructiva desatada sobre la existencia no es tan diferente de los otros Fundamentales, que son todos perseguidos por el Chaos Knight, que busca reunir a los Fundamentales de vuelta a su respectivo plano.";
                        break;
                    case "texto4":
                        hist = "En algún momento, un ambicioso alquimista llamado Cedric consiguió adquirir el diario de Jovat Kazran, un alquimista que se convirtió en Fundamental Oscuro. Con gran precaució, lanzó diecisiete hechizos diferentes que invocarían a Enigma dejándolo sin poder e incapaz de dañar a Cedric. Recitando un conjuro de invocación de Elze, trajo a Enigma al plano material. Como no quería perder el tiempo, Enigma fue inmediatamente a matar pero fue bloqueado por un campo de fuerza mágico. Al darse cuenta de que no tenía poder Enigma decidió ofrecerle poder político y mujeres pero le dejó claro que no concedía deseos.\n" +
                                "\n" +
                                "Aunque rechazó todas las ofertas de Enigma, Cedric le exigió los secretos de la última página, que era esencial para el hechizo que ascendería al lanzador a la divinidad. También le presentó su último invento: Un par de brazaletes dorados que permitían al portador manipular el tejido del espacio-tiempo. Su poder era tal que mataría a Cedric si lo llevara en su forma actual pero no como Fundamental. Para controlar este poder con seguridad necesitaba completar el hechizo que lo convertiría en un Fundamental. Y sólo Enigma tiene las respuestas al misterio que convertiría a Cedric en un Dios como él.\n" +
                                "\n" +
                                "Convencido, Enigma le dijo que saliera al campo para que le revelara el paso final hacia la divinidad. Cedric se negó y le reiteró que todavía está bajo su talón pero Enigma revela que nunca le afectaron los hechizos de Cedric y atraviesa casualmente el campo de fuerza. Mientras se acerca lentamente al aterrorizado alquimista se burla de él por su estupidez y cumple sus deseos de forma irónica susurrándole los secretos que tanto deseaba, lo que lo vuelve loco. Mientras sufre un estado de delirio Enigma le revela la verdad sobre los diarios.\n" +
                                "\n" +
                                "Eones después de su huida a los Siete Planos, Enigma dio a conocer su existencia a los habitantes del plano material fabricando docenas de diarios falsos realizados por un alquimista llamado \"Jovat Kazran\" y los escondió en lugares secretos para que los alquimistas los descubrieran. El diario contenía un registro de los estudios de Kazran sobre las cuatro fuerzas fundamentales del universo y sus intentos exitosos de ascender a Fundamental Oscuro así como los elementos necesarios para convertirse en uno. Sin embargo Enigma ha omitido intencionadamente la última página que se supone que contiene el paso final de un hechizo que convierte al lanzador en un Fundamental Oscuro. La última página no existe en realidad, pero esto sólo alimentará la curiosidad de aquellos que buscan los poderes de Enigma y les obligará a acudir a él en busca de los misterios de la última página.\n" +
                                "\n" +
                                "Roba el Artefacto del Abismo del Mundo a Cedric y se lo pone casualmente. Sin embargo, no es un ladrón, así que cumple su parte de la transacción convirtiendo a Cedric en un eidolón. Una vez realizada la ascensión oscura de Cedric, prepara a su nuevo recluta para la próxima batalla y pone a prueba su invento.";
                        break;
                    case "frase":
                        hist = "\"El caos caza la chispa de los soles infinitos, cuya luz morirá en mi mano aplastante\"";
                        break;
                }
                break;

            case "Darkterror":

                switch(tipo) {

                    case "texto1":
                        hist = "Darkterror, el Vacío sin Rostro (Faceless Void), es un visitante de Claszureme, un reino fuera del tiempo. El porqué este ser de otra dimensión cree que la lucha por las Piedras Némesis es razón suficiente para adentrarse en nuestro plano físico sigue siendo un misterio; al parecer, una alteración en el equilibrio del poder en su mundo tiene repercusiones en las dimensiones adyacentes. El tiempo no significa nada para Darkterror, excepto una forma de confundir a sus enemigos y ayudar a sus aliados. Su amplia perspectiva del cosmos le ha proporcionado una actitud distante, despreocupada, aunque durante la batalla es perfectamente capaz de convertir la lucha en algo personal.";
                        break;
                    case "texto2":
                        hist = "Darkterror es un acólito que adora al dios Clasz.\n" +
                                "\n" +
                                "Es posible que Darkterror tuviera ojos pero se los quitó como parte de su dedicación a Clasz.\n" +
                                "\n" +
                                "Cuando Darkterror muere vuelve a Claszureme.\n" +
                                "\n" +
                                "Darkterror cree que la era actual es la época final.\n" +
                                "\n" +
                                "Darkterror parece adorar a varios dioses.\n" +
                                "\n" +
                                "Darkterror se enfrentará a \"consecuencias desagradables\" de una autoridad desconocida si no consigue la victoria en esta dimensión.\n" +
                                "\n" +
                                "Darkterror es capaz de pausar y abrir agujeros en el tiempo.\n" +
                                "\n" +
                                "Darkterror es capaz de prever el futuro.\n" +
                                "\n" +
                                "Darkterror cree que el tiempo es un \"río con muchos remolinos\", y que ha visto sus finales.\n" +
                                "\n" +
                                "Darkterror posee joyas que le permiten atravesar el flujo del tiempo y observar mil estaciones en un solo día.\n" +
                                "\n" +
                                "Darkterror está celoso de la cabeza puntiaguda de Dark Seer y ha tratado de emularla atando y \"enfocando\" su propia cabeza en un tamaño más pequeño.\n" +
                                "\n" +
                                "Darkterror utiliza a menudo cronita en sus armaduras y armas.\n" +
                                "\n" +
                                "A lo largo del tiempo Darkterror ha adoptado muchas formas diferentes.\n" +
                                "\n" +
                                "Es posible que Darkterror haya formado parte del Culto de Dhreg, donde dominó su dogma.\n" +
                                "\n" +
                                "Darkterror está conectado de alguna manera con Nezzureme, una entidad desconocida.\n" +
                                "\n" +
                                "Según Puck, Darkterror no es querido en Claszureme y sus habitantes se sienten aliviados de librarse de él.\n" +
                                "\n" +
                                "Darkterror poseía el Reloj de Arena de Claszureme, un artefacto que manipula el tiempo. Fue robado por Mireska, aunque aún no se ha dado cuenta de ello.";
                        break;
                    case "frase":
                        hist = "\"Desde un lugar más allá del tiempo, y del tiempo más allá de la cuenta\"";
                        break;
                }
                break;

            case "Astral":

                switch(tipo) {

                    case "texto1":
                        hist = "La gente de Ashkavor se agolpaba alrededor de la plaza del templo, ansiosa por presenciar la ascensión de su nuevo guardián, para situarse cerca de aquel hombre que vinculaba sus almas con la suya. Pero a medida que sus pinceladas finales caían contra la piedra rúnica y se forjaba el vínculo de un nuevo Ascendido, todos, incluso aquellos que se habían quedado en sus hogares, pudieron sentir que algo había salido terriblemente mal.\n" +
                                "\n" +
                                "Él entendió la causa al instante. Las gotas de sangre divina que había usado para amplificar la potencia de sus tinteros, en su lugar, los habían contaminado, y el poder del hechizo vinculante que había lanzado ahora amenazaba con consumirlo. La tinta corrompida serpenteó hacia arriba desde la piedra rúnica, a lo largo del mango de su pincel, y pronto tomó control de sus manos. A partir de ahí se extendió rápidamente. Una vez que alcanzó su cara y su boca, no podría haber gritado, incluso si hubiera querido.\n" +
                                "\n" +
                                "Toda su vida había estado estimando cómo alcanzar poderes cada vez mayores de lo que los límites enseñados por sus maestros le permitirían, yendo tan lejos como para romper la prohibición sagrada de alterar las tintas. De hecho, al tener la fuente del vínculo Ascendido a su alcance, sintió el poder entrando en su alma como nunca lo había imaginado. Había alcanzado su mayor triunfo, si tan solo pudiera sobrevivir a él.\n" +
                                "\n" +
                                "Sacó fortaleza del poder del vínculo, para rechazar el flujo de tinta corrompida. El aire se llenó con un gran gemido: el grito colectivo de su pueblo. Algunos de los que estaban de pie se tambalearon. Los más débiles se desmayaron. Muchos intentaron escapar. Mientras, él aún les sacaba fuerzas de lo más profundo de su reserva de sangre. Pero eso no fue suficiente para detener la marea de tinta.\n" +
                                "\n" +
                                "Solo cuando el aliento atrapado en sus pulmones comenzó a fallarle y la oscuridad del tintero lo envolvió por completo, vio cómo salir de la situación. El vínculo que había hecho con el pueblo de Ashkavor, su gente, estaba destinado a ser utilizado solo al servicio de la protección de su pueblo, pero fluía en las dos direcciones.\n" +
                                "\n" +
                                "Con una oleada final de fuerza, esta vez dirigida por algo más que una simple repulsión ciega, empujó el torrente de tinta hacia el vínculo en sí.\n" +
                                "\n" +
                                "Lentamente, sintió que la marea retrocedía... y escuchó los horribles lamentos de su gente, mientras la corrupción a su vez se apoderaba de ellos. Cuando por fin la tinta cedió, sus ojos se abrieron a un mundo distinto. El pueblo de Ashkavor, como él los conocía, había desaparecido. Hasta la última alma se había transformado en una sombra terrorífica de su antiguo ser, compuesta, no de sangre y hueso, sino únicamente de una tinta viscosa y contaminada.";
                        break;
                    case "texto2":
                        hist = "Grimstroke es un ashkavoriano, el último de los ascendidos. Tortuoso y altanero por naturaleza, se ve ensombrecido por los oscuros restos de su antigua familia, retorcidos y transformados por su propia sed de poder. Entrenado desde su nacimiento para ser el protector de su pueblo las ambiciones personales de Grimstroke le llevaron a corromper su propia Ascensión, creando un ser envuelto en tinta malévola. Con grandiosos diseños en mente se dispone a rediseñar el mundo a su antojo con su gran pincel. Grimstroke es astuto y calculador en sus planes y sólo él impide que la marea de tinta consuma más de lo que ya lo ha hecho.";
                        break;
                    case "texto3":
                        hist = "De niño Grimstroke estaba destinado a convertirse en guardián de su pueblo, tarea para la que fue preparado por sus sabios maestros. Al igual que otros antes que él, un día sería Ascendido, uniendo su alma a la de todos los demás ashkavorianos, formando así un vínculo protector. Sus mentores le enseñaron los límites de este vínculo y le prohibieron aumentar el ritual sin darse cuenta de las oscuras ambiciones de su alumno hasta que fue demasiado tarde. Criado en el enrarecido entorno de las altas artes y la sofisticación, Grimstroke adoptó una actitud elitista, mostrando mucho desprecio por los de clase inferior.";
                        break;
                    case "texto4":
                        hist = "El día de su Ascensión Grimstroke entró en el templo del centro de Ashkavor y sumergió su pincel en los tinteros sagrados que había contaminado de antemano con gotas de un extraño ichor. Cuando acercó su pincel a la piedra rúnica del templo la tinta corrupta se apoderó de él. Al principio se resistió a la tinta utilizando los nuevos vínculos que había forjado con sus compañeros ashkavorianos pero incluso su fuerza combinada fue insuficiente. Cuando la tinta se apoderó de su cuerpo, decidió canalizar su oscuridad hacia los lazos, corrompiendo al instante a los demás ashkavorianos, convirtiéndolos en seres de sombra.\n" +
                                "\n" +
                                "Tras aniquilar a su propio pueblo Grimstroke huyó del templo.";
                        break;
                    case "texto5":
                        hist = "Tras el ritual de Ascensión Grimstroke intentó regresar a Ashkavor pero se encontró con que los retornados sombríos que solían ser sus parientes lo alejaban. Finalmente, consiguió dominar sus nuevos poderes y regresó a los terrenos del templo que habían permanecido sin vida y sin cambios desde que lo dejó. A su regreso se apoderó de un antiguo pincel imbuido con la magia de los linajes de sus antepasados. Los retornados aullaron a su llegada pero él tomó el control sobre ellos utilizando su vínculo colectivo para corromper a más víctimas.\n" +
                                "\n" +
                                "Sin embargo, los restos de los ashkavorianos mantienen un nivel de autonomía. Buscan la muerte para sí mismos o en su defecto, arrastrar a Grimstroke al más allá con ellos.\n" +
                                "\n" +
                                "Pero no todos los ashkavorianos fueron corrompidos por la mano de Grimstroke, los ascendidos permanecen y esperan restaurar a su pueblo una vez más. Sin embargo sus poderes fueron muy deformados por la marea de tinta y apenas sobreviven. Grimstroke intenta corromper también a los Ascendidos, sometiéndolos a su control con el poder de los Ancestros completando así su vínculo con todos los ashkavorianos. En busca de más víctimas los mismos rituales de vinculación que antes estaban destinados a proteger a su pueblo se han desviado hacia usos más nefastos.\n" +
                                "\n" +
                                "El razonamiento de Grimstroke para sus acciones no se conoce del todo pero sostiene que su pueblo se buscó su propio destino.";
                        break;
                    case "texto6":
                        hist = "Antes de su ascensión, Grimstroke se enamoró de Yaovhi, una mujer ashkavoriana a la que apreciaba profundamente. Ella también fue consumida por la marea de tinta y se transformó en un oscuro fantasma que ahora sirve a su lado, acechando y desgarrando a sus enemigos. Aunque Grimstroke no siente dolor por la destrucción de su pueblo sigue recordando a Yaovhi, pero intenta no insistir en el pasado inmutable.";
                        break;
                    case "texto7":
                        hist = "Entrenado en los caminos del pincel desde una edad temprana, Grimstroke ha crecido admirando las artes, comentando obras literarias y visuales. Está abierto a la colaboración con otros creadores y se toma el tiempo de examinar sus colecciones. Además también tiene interés en las esculturas y las antigüedades. Desprecia la danza negándose a considerarla una forma de arte.\n" +
                                "\n" +
                                "El amor de Grimstroke por los secretos es personal y es posiblemente una de las razones por las que corrompió su ritual de ascensión en primer lugar. Nunca es tímido a la hora de preguntar a otros personajes sospechosos sobre los secretos que pueden estar atesorando o que pueden haber oído en los vientos de los rumores.";
                        break;
                    case "texto8":
                        hist = "Fiel a su personaje ennegrecido Grimstroke encuentra mucho que admirar en figuras igualmente siniestras como Rotund'jere (Necrophos), Shadow Demon o Balanar, a quien considera una \"hermosa criatura\". Sorprendentemente le importa poco el Dios Muerto y desprecia su incesante canción fúnebre.\n" +
                                "\n" +
                                "Al encontrarse con Sylla afirma haber conocido a otro druida antes, aunque se desconoce a quién se refiere.\n" +
                                "\n" +
                                "Grimstroke siente un odio especial por los tres hermanos espíritus: Xin, Kaolin y Raijin hasta el punto de que su mera existencia le parece ofensiva. La razón de este odio no está clara pero parece que los espíritus estuvieron involucrados en alguna calamidad del pasado de Ashkavor, lo que posiblemente llevó a Grimstroke a buscar mayores poderes en primer lugar. Acusa a Kaolin de ser una marioneta de algún amo desconocido, a Xin de robar su llama del Celestial Ardiente y a Raijin de llevar a Thunderkeg como un \"traje de piel\".";
                        break;
                    case "frase":
                        hist = "\"Pintaré este mundo como mejor me parezca\"";
                        break;
                }
                break;

            case "Aurel":

                switch(tipo) {

                    case "texto1":
                        hist = "Tras toda una vida sirviendo en guerras, levantamientos, disturbios y revoluciones, sus superiores consideraron que Aurel ya había visto suficiente. Pero además de algunas baratijas y su considerable pensión, el antiguo ingeniero se fue con algo mucho más interesante: el largamente olvidado e incompleto esquema de un Girocóptero, el primer aparato volador tripulado no mágico del mundo. Tras retirarse a la oscuridad tropical del Archipiélago Ceniza, con poco más que tiempo y dinero, se puso a trabajar en la construcción de dicho artilugio.\n" +
                                "\n" +
                                "A medida que pasaban los años y los restos de los prototipos fallidos se iban acumulando, empezó a preguntarse si el vuelo mecánico era siquiera posible. Diez años y un día después de su jubilación, una soleada tarde en la que soplaba la brisa del sur, Aurel se sentó sobre su última tentativa lleno de indignación y anticipando el fracaso. Con un gruñido de esfuerzo tiró de la cuerda de arranque y luego se cubrió la cabeza, en espera de la inevitable explosión. Sin embargo, para su mayor sorpresa empezó a elevarse y, tras unos cuantos nerviosos ajustes, a estabilizarse. En menos de una hora ya andaba Aurel peleándose con la brisa, a la misma altura que las gaviotas, sobrecogido por el prodigio que supone volar.\n" +
                                "\n" +
                                "Con la llegada del crepúsculo puso rumbo de regreso a su taller, pero apenas hubo dado la vuelta a su nave una bala de cañón le arrancó la aleta de cola. Desenredándose de los restos, nadó hacia el trozo de tierra más cercano que tenía a la vista, y maldijo al observar cómo el barco responsable del cañonazo recogía lo que quedaba del aparato. Días después, cuando Aurel volvió a su taller, se puso a trabajar en un nuevo girocóptero, esta vez capaz de transportar una carga mucho más pesada y peligrosa.";
                        break;
                    case "texto2":
                        hist = "Aurel es un Keen.\n" +
                                "\n" +
                                "Aurel tenía un antiguo jefe que no le gustaba.\n" +
                                "\n" +
                                "Aurel tiene alguna relación con la Universidad de Ultimyr que fabricó para él el motor de los Rayos Atómicos.\n" +
                                "\n" +
                                "Davion es consciente de lo que su padre haría con la máquina voladora de Aurel.";
                        break;
                    case "texto3":
                        hist = "Sun Wukong odia a Aurel porque lo encuentra molesto a él y a su máquina voladora.";
                        break;
                    case "frase":
                        hist = "\"Tanto por estar jubilado...\"";
                        break;
                }
                break;

            case "Hoodwink":

                switch(tipo) {

                    case "texto1":
                        hist = "Hoodwink pasó sus primeros años en la idílica extensión verde que una vez hubo alcanzado las fronteras de Krimwohl. Pero mientras ese reino crecía, y las necesidades tanto de sus ciudadanos como de sus ejércitos se volvían voraces, los barones de la madera rivales devoraban la belleza de los bosques fronterizos, atiborrándose para satisfacer las demandas de la tierra cambiante.\n" +
                                "\n" +
                                "Para aquellos que vivían en las antiguas tierras boscosas, la elección se reducía a seguir la cola de refugiados hacia las zonas pacificadas, caer ante la pólvora negra y el acero de Krimwohl mientras defendían sus hogares o huir hacia el norte para tentar al destino en las cañadas y arboledas embrujadas del neblinoso Bosque Tomo'kan.\n" +
                                "\n" +
                                "Así que fue en ese brumoso bosque donde Hoodwink alcanzó la mayoría de edad, esquivando a los horribles depredadores de Tomo'kan, congraciándose con algunos de los bandidajes locales mientras se enfrentaba a otros y buscando absolutamente todas las formas de estar presente cuando surgía a menudo alguna travesura interesante, siendo <i>supuestamente y a menudo</i> la causante de ello.\n" +
                                "\n" +
                                "Pero cuando el más leve olor a fuego de Krimwohl llegó a su hogar adoptivo, los pensamientos de Hoodwink se dirigieron hacia cualquier familia y amigos que pudieran haber sobrevivido a la invasión, ahora obligados a ganarse la vida en las tierras arrasadas cuyas heridas dejaron cicatrices en su propia alma, y no pudo evitar acercarse a la civilización para vislumbrar a los demonios que habían destruido su antigua vida.\n" +
                                "\n" +
                                "Allí, vio que los monstruos de su infancia no eran monstruos en absoluto. Eran solo... personas. Soldados, obreros, comerciantes... y refugiados. Y los soldados, incluso con su pólvora negra y acero, no eran nada comparado con los peligros de Tomo'kan. Peligros reales con tentáculos y dientes. Peligros sobre los que ella bailaba como una hoja de arce cayendo en otoño.\n" +
                                "\n" +
                                "Sabiendo que siempre puede moverse con seguridad por el enmarañado Tomo'kan, donde la mayoría de criaturas de sangre caliente temen sabiamente dar un paso, Hoodwink ahora lucha contra aquellos que tratan de apaciguar las tierras salvajes aún más, tomando alegremente lo que le gusta de sus pertenencias, destruyendo lo que no tiene ningún uso y guiando a los supervivientes como ella de vuelta a la vida en lo verde una vez más.";
                        break;
                    case "texto2":
                        hist = "El tío de Hoodwink es Night Stalker\n" +
                                "\n" +
                                "Enchantress posiblemente sea su familia.\n" +
                                "\n" +
                                "Conoce a Puck y Earth Spirit.\n" +
                                "\n" +
                                "Hoodwink es aliado de Centaur Warruner y posiblemente de Verodicia.\n" +
                                "\n" +
                                "Sus enemigos son los Keen, Krimwohl, Chen, Leshrac, Primal Beast y Sagan (Montura de Mirana).";
                        break;
                    case "frase":
                        hist = "\"¿Quién dijo que podías pasear por mis bosques?\"";
                        break;
                }
                break;

            case "Huskar":

                switch(tipo) {

                    case "texto1":
                        hist = "Emergiendo de la agonía del reino sagrado de Nothl, Huskar abrió sus ojos para ver al pródigo monje de las sombras Dazzle ejecutando un profundo encantamiento sobre él. En contra de los antiguos ritos de la Orden Dezún, el eterno espíritu de Huskar había sido salvado de la eternidad, pero como todos los que encuentran a Nothl, se vio irrevocablemente transformado. Ya no estaba a merced de un cuerpo mortal, su propia sangre se convirtió en una increíble fuente de poder; cada gota derramada regresaba con su feroz y ardiente energía multiplicada por diez. Sin embargo su nuevo don enfureció a Huskar, porque en su rescate de Nothl, Dazzle le había negado un lugar entre los dioses. Le había denegado su propio santo sacrificio.\n" +
                                "\n" +
                                "Era un tiempo en el que los ancianos de la orden buscaban expandir su influencia y estaban de acuerdo en que Huskar sería una formidable herramienta en su cruzada. Pero que el convertirse en una simple arma para la orden le arrebatara su derecho de nacimiento le contrarió aún más. Cuando las primeras brasas de la guerra aparecieron en el horizonte, abandonó su ancestral hogar para encontrar nuevos aliados, a la vez que buscaba una causa digna de desatar el poder que su sacrificio total podría traer.";
                        break;
                    case "texto2":
                        hist = "Huskar es un guerrero sagrado, transformado tras su terrible experiencia en el Reino de Nothl. Huskar valora la vitalidad por encima de todo y comparte el respeto por los héroes que hacen lo mismo como Bloodseeker y Witch Doctor. Compara la vida con un cáliz sagrado que se derrama cuando un ser muere.";
                        break;
                    case "texto3":
                        hist = "Cuando Huskar regresó del reino de Nothl volvió con secretos que ninguno de sus superiores tribales reconoció. Ahora utiliza estos secretos para promover sus propios intereses.\n" +
                                "\n" +
                                "Según Huskar la dependencia del maná se considera impía, mostrando preferencia por la fuerza vital bruta en su lugar, lo que está en consonancia con la costumbre de su cultura de sacrificar personas al Reino de Nothl.\n" +
                                "\n" +
                                "Al igual que Dazzle Huskar pertenece a la Orden Dezun, donde sirve como guerrero.\n" +
                                "\n" +
                                "Jah'rakal desprecia a Huskar porque le recuerda a él mismo.";
                        break;
                    case "texto4":
                        hist = "El pueblo de Huskar parece estar basado en los pueblos indígenas del Nuevo Mundo. Profundamente espirituales huyen de la tecnología en favor de utensilios hechos con huesos de sacrificio y piedra afilada, como la obsidiana.";
                        break;
                    case "texto5":
                        hist = "Al provenir de orígenes similares, Huskar considera a Dazzle como un primo. A pesar de ello está resentido con él por haberlo traído de vuelta del Reino de Nothl.";
                        break;
                    case "frase":
                        hist = "“Aquel a quien se le da más en la vida no debe aferrarse a ella sino arriesgarlo todo en cada momento”";
                        break;
                }
                break;

            case "Carl":

                switch(tipo) {

                    case "texto1":
                        hist = "En su antigua y algunos dirían más poderosa forma, la magia era principalmente el arte de la memoria. No requería tecnología ni varitas mágicas u otros accesorios, solo la mente del mago. Toda la parafernalia de los rituales se reducía a códigos mnemotécnicos con el objeto de permitir al experto recordar en gran detalle la fórmula mental específica que da acceso al poder de un hechizo.\n" +
                                "\n" +
                                "Los más grandiosos magos de aquellos días eran los que habían sido otorgados con el don de una memoria superior, pero tan complejas eran las invocaciones que todos los magos estaban obligados a especializarse. En el transcurso de una vida los más entregados podían aspirar a memorizar tres encantamientos, cuatro como mucho. Los hechiceros ordinarios se contentaban con dos, y no era raro que el mago de una aldea supiera solo uno, incluso requiriendo para ello consultar grimorios como ayuda contra el olvido en las raras ocasiones en las que tuviera que usarlo.\n" +
                                "\n" +
                                "Pero entre aquellos primeros taumaturgos había una excepción, un genio de extraordinaria inteligencia y prodigiosa memoria que pasó a ser conocido como Invoker. En su juventud, el precoz mago dominó, no cuatro, ni cinco, ni siquiera siete encantamientos: Era capaz de canalizar no menos de diez hechizos y lanzarlos al instante. Aprendió muchos más pero no les encontró uso, los practicó una vez y los purgó de su memoria para siempre dejando lugar a invocaciones más prácticas. Uno de ellos fue el Conjuro Sempiterno. Un hechizo de longevidad de tal poder que aquellos que lo lanzaron en los primeros días del mundo están entre nosotros todavía (a no ser que hayan sido reducidos a átomos).\n" +
                                "\n" +
                                "La mayoría de estos cuasi-inmortales viven sosegadamente temiendo admitir su secreto, pero Invoker no es de mantener sus dones ocultos. Ahora es anciano, ha aprendido más que ningún otro y su mente todavía tiene espacio para contener una magnífica opinión de su propia valía... además de las invocaciones con las que se entretiene durante el largo y lento crepúsculo de los días de decadencia del mundo.";
                        break;
                    case "texto2":
                        hist = "Carl, el Invocador, es uno de los pocos magos que aún practican la antigua hechicería de Invocación, lo que le permite aprovechar no uno, sino los tres elementos de Quas, Wex y Exort así como cualquier magia que se digne a aprender por pura voluntad, inteligencia y memoria.";
                        break;
                    case "texto3":
                        hist = "Entre los primeros practicantes de la magia en su forma más potente y antigua, había un niño prodigio llamado Carl. Su intelecto y su memoria eran tales que podía dominar más de cuatro hechizos, la mayor cantidad de hechizos que un mago devoto podía esperar dominar con la mayor parte de su capacidad cerebral. Fue inscrito en la ya establecida Academia Ultimyr donde perfeccionó sus ya impresionantes habilidades mágicas. El joven Carl sobresalía en todas las tareas curriculares que se le encomendaban y se regodeaba en los elogios que se le hacían por ser tan competente pero soñaba con un futuro en el que no respondiera ante nadie más que ante sí mismo, en el que pudiera utilizar libremente sus crecientes poderes.\n" +
                                "\n" +
                                "El director de esta academia pensó en mantenerlo encerrado, probablemente para evitar que diera rienda suelta al potencial destructivo que sus poderes podían aportar. Sin embargo esto no se cumplió ya que el joven Carl logró destruir la academia y dejarla en ruinas. Además en el día de su graduación elegido por él mismo, cuando se liberó de la escuela, logró adquirir el traje de batalla formal de Dark Artistry, un uniforme extremadamente codiciado que sólo podía ser entregado a sus estudiantes en tiempos de gran calamidad y dolor.";
                        break;
                    case "texto4":
                        hist = "Entre los primeros practicantes de la magia en su forma más potente y antigua, había un niño prodigio llamado Carl. Su intelecto y su memoria eran tales que podía dominar más de cuatro hechizos, la mayor cantidad de hechizos que un mago devoto podía esperar dominar con la mayor parte de su capacidad cerebral. Lo inscribieron en una academia de renombre de un antiguo mago para las artes místicas que perfeccionó sus ya impresionantes habilidades en la magia. El joven Carl sobresalía en todas las tareas curriculares que se le encomendaban y se regodeaba en los elogios por ser tan competente pero soñaba con un futuro en el que no respondiera ante nadie más que ante sí mismo, en el que pudiera utilizar libremente sus crecientes poderes.\n" +
                                "El director de esta academia pensó en mantenerlo encerrado, probablemente para evitar que diera rienda suelta al potencial destructivo que sus poderes podían provocar. Sin embargo esto no se concretó ya que el joven Carl logró destruir la academia y dejarla en ruinas. Sin un director que lo oprimiera finalmente fue libre de hacer sus sueños realidad. Robó un hechizo de viaje en el tiempo de los archivos secretos del difunto director para poder viajar prematuramente al futuro que soñaba. Al lanzar el hechizo se desplazó con éxito desde el pasado de la línea temporal actual al presente, cambiando de lugar con su yo mayor. Aunque el hechizo tuvo éxito no leyó la descripción completa del hechizo antes de lanzarlo. Si fracasara en la misión de su yo mayor, el resultado sería la desaparición segura de cada línea temporal.";
                        break;
                    case "texto5":
                        hist = "Los largos años de su vida casi inmortal han tenido un efecto inimaginable en su personalidad. Los perjuicios sufridos en esos años podrían ser la razón por la que es drásticamente diferente a su yo más joven.\n" +
                                "\n" +
                                "En los primeros días tras su huida de la academia Carl buscó poner a prueba sus crecientes habilidades por cualquier medio posible. Encontró una gran oportunidad de aventura y pruebas en el campo de batalla y respondió a la llamada a la guerra, convirtiéndose en un mago de batalla.\n" +
                                "\n" +
                                "Hubo una época en la que el miedo y la superstición rodeaban a la hechicería y a sus practicantes. Se contaban historias sobre Invoker, un mago poderoso y opresivo que destruía a los que no tenían los dones de la magia. Tal era su ferocidad que tuvo un poderoso efecto en la reputación de las artes mágicas durante esa época.\n" +
                                "\n" +
                                "Es posible que Carl se haya unido alguna vez a la facción de la Cábala Ardiente (Burning Cabal), un grupo de invocadores especializados en la manipulación del fuego y que favorecen el Exort sobre todas las demás disciplinas mágicas.";
                        break;
                    case "texto6":
                        hist = "En Dota: Dragon's Blood, el Invoker es uno de los principales protagonistas de la serie. Un sabio elfo sin nombre, el Invocador vive como un recluso estoico pero sabio en su torre, que está llena de magia hasta el tope, lo que hace que sea invisible para todos excepto para los que tienen una vista dotada o artículos mágicos que conceden una visión sobrenatural.\n" +
                                "\n" +
                                "Los cuentos entre los \"niños de la luna\" hablan de un sabio que se dice que tiene el poder de traer de vuelta a la verdadera diosa Mene que habita en los lotos mágicos de los estanques del Templo de Selemene. Una joven pero decidida joven elfa llamada Fymryn está decidida a conocer a este hombre y cumplir la profecía poniendo en marcha los acontecimientos de la serie hacia un destino de proporciones cósmicas en el que el cielo y el infierno chocan más allá de sus límites, un destino que nunca pretendió alcanzar.";
                        break;
                    case "texto7":
                        hist = "Joven Carl\n" +
                                "Carl es un niño curioso que aún tiene mucho que aprender. La mayoría de sus interacciones con los héroes aliados y enemigos le llevan a cuestionar su aspecto, sus poderes, sus capacidades, sus intenciones, etc..\n" +
                                "\n" +
                                "Carl es bastante enérgico y juguetón. Esto se puede ver en sus animaciones y en sus líneas de voz, así como en sus líneas con otros héroes. Esto también se manifiesta en su ardiente gusto por la aventura.\n" +
                                "\n" +
                                "Durante sus años en la academia Carl solía ser una persona tímida. Más tarde sentó cabeza (como dijo su último director) y se volvió mucho más sociable.\n" +
                                "\n" +
                                "Carl tiene una inocencia infantil. Le da un poco de asco cuando mata a alguien y se siente incómodo con la gente que lleva ropa reveladora.\n" +
                                "\n" +
                                "\n" +
                                "Carl Adulto\n" +
                                "Carl es extremadamente narcisista. Tiene un gran concepto de sí mismo, pero apenas tiene en cuenta a nadie, a veces ni siquiera reconoce su existencia o simplemente se olvida de ellos luego de un tiempo, lo que queda patente en su intencionada falta de respuestas de aliado/rival, como confirman los propios desarrolladores.  \n" +
                                "Aunque no tenga ninguna consideración por nadie, tiende a desviar la atención de los demás hacia sí mismo, otro rasgo común entre los narcisistas. Su gusto personal por la ropa también lo refleja muy bien.\n" +
                                "\n" +
                                "El poderoso intelecto de Carl le hace merecedor de su extremo solipsismo. Reconoce que su mente es la única que seguramente existe y el resto de lo que percibe no son más que meras extensiones de sus pensamientos.\n" +
                                "\n" +
                                "Tal es su solipsismo que también le ha hecho creer que es el progenitor y la encarnación de toda la creación.\n" +
                                "\n" +
                                "Para que Carl domine semejante poder tendría que ser extremadamente disciplinado. Los espíritus del dragón dentro de la máscara deJuggernaut alaban su disciplina.";
                        break;
                    case "texto8":
                        hist = "El joven Carl afirma conocer al tatarabuelo de Warlock. Dado que Demnok y Carl han estado en la Academia Ultimyr es posible que se refiera al antepasado de Demnok que pudo conocer en su antigua academia.\n" +
                                "\n" +
                                "Entre los muchos nombres de Carl a lo largo de los eones, Rubick lo conoció en una época en la que se le llamaba el \"Arsenal Magus\".\n" +
                                "\n" +
                                "Puck tiene algún conocimiento de Carl, afirmando recordarlo de un pasado lejano. Esto dice mucho sobre la edad de Invoker.\n" +
                                "\n" +
                                "Undying y Queen of Pain son algunos de los pocos que lo conocen lo suficiente como para llamarlo por su verdadero nombre de poder, Carl. Mirana también es una de las pocas que lo conoce por el nombre de Carl pero esto podría ser sólo un juego de palabras con su nombre más que algo relacionado con el lore.\n" +
                                "\n" +
                                "Según las habladurías de Dark Willow, Axe y Anti-Mage quieren golpear a Carl. El primero puede verse en un arte de carta para el juego spinoff Artifact.\n";
                        break;
                    case "frase":
                        hist = "\"Soy un faro de conocimiento que resplandece a través de un mar negro de ignorancia\"";
                        break;
                }
                break;

            case "Io":

                switch(tipo) {

                    case "texto1":
                        hist = "Io está en todas partes y en todas las cosas. Acusado por sus enemigos de ser el Gran Destructor y venerado por los eruditos como el parpadeo de un ojo divino, este extraño ente de fuerza vital ocupa todos los planos a la vez. La más mínima fracción de su ser puede cruzar a la existencia física en cualquier momento.\n" +
                                "\n" +
                                "Al igual que los dos grandes jinetes gemelos Luz y Oscuridad, su historia, como un antiguo viajero más, se ha perdido en el tiempo. Io el Ente es uno de los Fundamentales del universo; una fuerza anterior al tiempo, un merodeador de los reinos más allá de la comprensión de los mortales. Io no es nada menos que la suma de todas las fuerzas de atracción y repulsión del plano material, una manifestación viviente de la carga que mantiene unidas a las partículas entre sí. Solo a través de la manipulación controlada de estas fuerzas Io puede sentirse en el plano presencial. Io —una fuerza benevolente y cooperativa— une su extraño magnetismo a los demás para potenciar el poder de sus aliados. Sus motivos son inescrutables; su fuerza, inimaginable. Io se mueve a través del plano físico, como una expresión perfecta de los misterios del universo.";
                        break;
                    case "texto2":
                        hist = "Io es un Fundamental, una fuerza del universo creada cuando Elder Titán dividió el mundo durante el Cisma. \n" +
                                "\n" +
                                "Como otros Fundamentales Io vuelve al Plano Fundamental cuando muere.\n" +
                                "\n" +
                                "Según Puck, Io es \"audaz\" y está aliado con una fuerza desconocida. Puck no está de acuerdo pero afirma que Io presenta un \"argumento convincente\" para la alianza. También felicita a Io por su ingenio agudo y humorístico, que cree que se desperdicia con los mortales.";
                        break;
                    case "texto3":
                        hist = "Io es amigo de Earthshaker, que es más joven que el. Hablan entre sí, siendo Earthshaker uno de los pocos que puede entender a Io. Después de que Earthshaker se fusionara con un fragmento de su hermana Tierra, su preocupación por las entidades malévolas que la destruyeron le llevó a buscar a Io y a discutir formas de viajar por el espacio para poder luchar contra las entidades.";
                        break;
                    case "frase":
                        hist = "*bip bup*";
                        break;
                }
                break;

            case "Jakiro":

                switch(tipo) {

                    case "texto1":
                        hist = "Incluso entre las bestias mágicas, un dragón de dos cabezas es algo extraño. Mitad hielo y astucia, mitad fuego y rabia, la criatura conocida como Jakiro planea sobre campos de batalla carbonizados y congelados, causando estragos entre aquellos que se alzan en armas contra él. De los huevos de los dragones Pyroxianos siempre nacen dos crías. Conocidos por su ferocidad incluso en los primeros instantes de su vida, los dragones recién nacidos de estas especies intentarán matar a sus hermanos aún en el nido. Solo el más fuerte sobrevive. De esta forma, la fuerza del linaje Pyroxiano queda garantizada. Por algún error de la Naturaleza, el extraño Jakiro nació de un solo huevo, combinando en un solo individuo el amplio rango de habilidades que se encuentra en las distintas especies de Pyroxianos. Atrapados en el armazón de su monstruoso cuerpo, los poderes del hielo y el fuego se combinan. Ningún enemigo está a salvo.";
                        break;
                    case "texto2":
                        hist = "Jakiro, el dragón de dos cabezas, es un dragón pirexae policéfalo con los poderes del hielo y el fuego como derecho de nacimiento. Su propio nacimiento fue una anomalía entre los Pirexae ya que nació de un solo huevo con dos cabezas compartiendo un solo cuerpo. Desafiando el mismo proceso que asegura la fuerza de la especie Pyrexae, Jakiro es rechazado como una paria entre su raza e incluso perseguido por su propia familia con cazadragones que le hacen la vida mucho más difícil.\n" +
                                "\n" +
                                "Pero su raza no consideraba que el propio Jakiro fuera un verdadero testimonio de la fuerza de los pirexae. Aunque un solo pirexae tiene una poderosa afinidad con un solo elemento, Jakiro puede ejercer toda la gama de todas las habilidades que se encuentran en las diversas especies de pirexae con gran sinergia. Con semejante poder contenido en uno entre un millón ningún enemigo está a salvo ya que los elementos se combinan en Jakiro para convertir a sus enemigos en un amasijo irreconocible de cristales de hielo y carne ennegrecida.\n" +
                                "\n" +
                                "Nacido de la carne de una madre Eldwurm y de un padre desconocido, el monstruo dragón Jakiro nace de un único huevo con dos cabezas, una que arde con la rabia del ardiente linaje pirexae y otra que se congela con la astucia del linaje gélido pirexae. Rechazado y a veces perseguido por su raza por ser una anomalía entre los sabios pero temibles pirexas, Jakiro se basa en su dualidad de poderes y rasgos para destruir a todo tipo de seres y criaturas que se atrevan a proyectar alguna hostilidad hacia él.";
                        break;
                    case "texto3":
                        hist = "Entre los Mer Folk, hay historias de un \"demonio de dos cabezas\" que mató a una expedición (salvo dos supervivientes) formada por los mejores guerreros Slithereen en las aguas que rodean los acantilados de Grosche. Sus advertencias hablan del demonio que protegía los acantilados de Grosche. Cuando el grupo de asaltantes invadió el territorio del dragón por la noche la cabeza de fuego de Jakiro atacó al grupo pero consiguieron ponerse a salvo en su propio elemento del mar. Sin embargo su cabeza de escarcha congeló a los invasores sobre las olas que deberían haberles protegido. Los dos supervivientes restantes sólo pudieron ver cómo la cabeza de fuego de Jakiro incineraba a los ignorantes invasores.\n" +
                                "\n" +
                                "En una ocasión, Jakiro descendió a las cavernas subterráneas de Riverwarren para proteger a sus habitantes en un momento de gran necesidad. Desde ese día su aparición y sus hazañas se conmemoran siempre en el Día de las Piras, donde se cuentan y celebran respectivamente las historias de su protector. A medida que los niños crecen sus sueños sobre el regreso del dragón se desvanecen con el tiempo, pero un día Jakiro volverá a ayudar a los habitantes de las cavernas.";
                        break;
                    case "texto4":
                        hist = "La dualidad de Jakiro le otorga los rasgos de ambas herencias pirexas. Su cabeza de hielo hereda su sabiduría y astucia, mientras que su cabeza de fuego hereda su rabia y ferocidad.\n" +
                                "\n" +
                                "Un rasgo natural de la mayoría de los dragones, Jakiro es una criatura muy territorial.\n" +
                                "Debido a esto, Jakiro es uno de los dragones más nobles y protectores, algo poco común en las obras de fantasía. Protege los acantilados de Grosche de los invasores y, en una ocasión, acudió en ayuda de los habitantes de Riverwarren, que aún celebran sus hazañas en su ausencia.\n" +
                                "\n" +
                                "Como criatura policéfala las cabezas de Jakiro se tratan como hermanos, sin que ninguno de ellos sea el mayor o el superior. A menudo se encuentran poco dispuestos a compartir y se culpan mutuamente como hermanos. En el lado positivo, a menudo se halagan mutuamente los logros y se cuidan mutuamente, considerándose como iguales.";
                        break;
                    case "texto5":
                        hist = "Según Jakiro, Winter Wyvern es su primo. Sin embargo, Auroth parece tener una animosidad hacia él y expresa su arrepentimiento por no haberlo matado antes de que nacieran. El guionista de Valve, Steve Jaros, confirmó que Auroth es efectivamente su madre.";
                        break;
                    case "frase":
                        hist = "\"Dos lados de la misma moneda\"";
                        break;
                }
                break;

            case "Yurnero":

                switch(tipo) {

                    case "texto1":
                        hist = "Nadie ha visto nunca el rostro que se oculta bajo la máscara de Yurnero el Juggernaut. Incluso que tenga uno es solo especulación. Por desafiar a un señor corrupto, Yurnero fue exiliado de la ancestral Isla de las Máscaras, un castigo que le salvó la vida. Poco después, la isla desapareció bajo las olas en una noche de magia vengativa. Solo le quedó continuar con la larga tradición Juggernaut de la isla, una de rituales y manejo de la espada. Como último practicante del arte, la confianza y el valor de Yurnero son el resultado de una práctica sin fin y su original dominio de la hoja demuestra que nunca ha dejado de desafiarse a sí mismo. Sin embargo, sus motivos son tan inescrutables como su expresión. A pesar de ser un héroe que lo ha perdido todo dos veces, él lucha como si la victoria fuera una conclusión previsible.";
                        break;
                    case "texto2":
                        hist = "Yurnero, el Juggernaut, llamado así por la tradición marcial que juró preservar y proteger, es el último de los enmascarados que se ahogaron bajo las olas que inundaron la antigua Isla de las Máscaras. Aunque su máscara inanimada no tiene expresiones legibles cada movimiento de su brazo con forma de espada es una expresión de un arte perdido que anhela ser recordado y cada ritual que lanza en solitario no es más que una sombra de las antaño vivas y ricas tradiciones de la Isla.";
                        break;
                    case "texto3":
                        hist = "Yurnero tuvo que ganarse su habilidad para convertirse en el maestro espadachín que es hoy. Se entrenó bajo la tutela de su difunto maestro de la espada (del que no sabemos el nombre) hasta convertirse en un maestro de la espada como él. Su maestro le recompensó con una hakama tradicional y la espada Akakiryu, que recibió su nombre de un dragón legendario.\n" +
                                "\n" +
                                "Hace mucho tiempo, Yurnero se encargó de recuperar el Defensor, una gran espada robada de las Islas de Marfil. Mató a sus ladrones y ahora empuña el Defensor con honor.\n" +
                                "\n" +
                                "Yurnero es un exitoso cazador con muchas muertes en su haber, incluyendo demonios y abominaciones, con algunos de ellos poseyendo un intelecto de cazador alienígena. Se sabe que ha matado a una bestia valiente con grandes colmillos en una feroz batalla y que ha matado a un lobo de montaña con golpes de mano abierta. Puede que haya matado a un solo miembro de la especie corodont, ahora extinta, tallando una máscara de su corazón de marfil.";
                        break;
                    case "texto4":
                        hist = "Aunque el relato original nos dice que Yurnero fue exiliado y desterrado al mar por su desafío contra un alto señor, existe otro relato sobre el destierro de Yurnero. Tras su destierro, se le colocó una máscara que simbolizaba su condición de Ronin sin amo que le guiara, y que difería en su aspecto de la máscara por defecto que todos conocemos.\n" +
                                "\n" +
                                "Se da a entender que el exilio de Yurnero se produjo por otra razón además de su rebeldía contra un señor corrupto. El contexto detrás de su insubordinación era que podría haber sido cómplice en la defensa de los deshonrados parias sin máscara de la Isla de las Máscaras. Estos desgraciados recibían su castigo por violar un credo u otro. Su retribución fue ser despojados de su honor junto a sus máscaras y ser arrojados lejos de los alcances de la sociedad para que nunca más puedan influir en los asuntos de la Isla. Defender a esta gente, incluso ante el desafío de la alta alcurnia, provocará el exilio fuera de la propia Isla, el mismo destino que se le infligió a Yurnero.";
                        break;
                    case "texto5":
                        hist = "En un suceso no especificado, posiblemente un duelo, Sven partió en dos la máscara de Yurnero con la Hoja del Adjudicador, rompiendo su parte superior y despertando las almas ancestrales que yacían dormidas en su interior. Entre los espíritus se encontraba un antiguo dragón que ahora acompaña a Yurnero y le aporta sus poderes. Así, el Juggernaut se convirtió en un ser fusionado de muchas almas. El poder del dragón combinado con la gran fuerza de sus antepasados le hizo más poderoso que nunca. Yurnero y su dragón están agradecidos por las acciones de Sven y sienten que tienen una deuda de gratitud con él.\n" +
                                "\n" +
                                "Después de la desintegración Yurnero y su dragón planean restaurar lo que han perdido. Una vez destruido el Ancestro juraron traer de vuelta a su gente y comenzar el renacimiento de la Isla de las Máscaras.";
                        break;
                    case "texto6":
                        hist = "Se dice que Yurnero no se entristece por lo que ha perdido ya que es implacable y purga esa pena con la búsqueda del honor. Sin embargo a veces medita sobre algo que ha perdido que puede ser su querida Isla o su relación perdida con Lanaya.\n" +
                                "\n" +
                                "Cuando entra en combate Yurnero descarga toda su furia sobre sus enemigos. A pesar de ello se sitúa entre el blanco y el negro para convertirse en gris siendo emocionalmente distante y no revelando sus otras emociones y pensamientos a nadie, no reservando nada a los demás más que su espada y su mano.\n" +
                                "\n" +
                                "Incluso después de la destrucción de su Isla Yurnero sigue adhiriéndose a la cultura de la Isla que gira en torno al honor y el respeto. Respeta a los oponentes dignos que mueren por su mano (a veces conservando sus restos como su recuerdo del honor que tienen) y les hace saber que sus muertes son honorables. No respeta a los cobardes ni a nadie que realice actos de cobardía.\n" +
                                "\n" +
                                "Yurnero es un guerrero valiente y corajudo resultado de su fe en la práctica y el perfeccionamiento interminables de su oficio. Una cosa es enfrentarse a los peligros y a la adversidad sin miedo, pero él sabe que hay un límite claro entre ser valiente y ser insensato. Fue lo suficientemente valiente como para desafiar al último señor de las Islas, al que creía corrupto y defendió a los deshonrosos parias de su isla natal a pesar de saber que defender a estas personas frente a desafiar a las autoridades le otorgará un destino mucho peor que el que tienen estos parias. No teme a la muerte pero ciertamente prefiere alejarse de ella. A veces confía en el alcohol para obtener un impulso de valor.\n" +
                                "\n" +
                                "Yurnero es un espadachín seguro de sí mismo, fruto de su fe en la interminable práctica y el perfeccionamiento de sus artes. Tal vez pueda decirse que su convicción en su habilidad es lo que diferencia su valentía de la insensatez. Esto se refleja en su uso de armas que son mortales para el que las empuña y su objetivo.\n" +
                                "\n" +
                                "Yurnero suele celebrar las batallas con un estandarte que lleva a la espalda. Cree que una batalla no es buena si no hay nada que la celebre.\n" +
                                "\n" +
                                "Un guerrero severo y serio, Yurnero practica y valora la disciplina.";
                        break;
                    case "texto7":
                        hist = "Yurnero es el último ejemplar de un antiguo linaje de venerados guerreros que son los progenitores de la Isla de las Máscaras. La mayoría de estas almas perdidas eran enmascarados como él pero también tenía un espíritu de dragón entre sus antepasados.\n" +
                                "\n" +
                                "Hace mucho tiempo Yurnero solía entrenar con frecuencia con Ember Spirit. Sus sesiones de entrenamiento juntos siempre daban resultados interesantes. Siente un gran respeto por Xin, aunque estén enfrentados.\n" +
                                "\n" +
                                "Phantom Lancer es un viejo amigo de Yurnero. Como compañeros de Héroes Radiants alineados contra las facciones Dire, ambos conocen a Kanna y Yurnero puede preguntar a Azwraith sobre los rumores relativos al regreso de Kanna.\n" +
                                "\n" +
                                "Yurnero tuvo una vez una relación romántica con Templar Assassin pero ambos rompieron después de que él hiciera algo que la molestara. Aunque parece que ya lo ha superado seguirá llorando por ella, incluso después de haber perdido el control sobre su cuerpo cuando los numerosos espíritus de su máscara se apoderaron de él y lo poseyeron, quienes también comparten su dolor a pesar de no conocerla en absoluto. Lanaya aún se siente despechada y no ha superado la ruptura. Está bastante enfadada con Yurnero hasta el punto de amenazar con la violencia e intentar darle celos.\n" +
                                "\n" +
                                "La muerte de Yurnero a manos de Mars significa la finalización de la colección de su tío. Se desconoce cual de sus tíos, Hades o Poseidón, está coleccionando seres similares a Yurnero, por no mencionar que se desconoce el contexto de esta situación.\n" +
                                "\n" +
                                "Yurnero está preocupado por la violenta campaña de Sorla Khan. Desea discutir una solución al problema con Axe.";
                        break;
                    case "frase":
                        hist = "\"Por el Rostro de la Venganza, que se ahogó en la Isla de las Máscaras, llevaré a cabo los ritos de los Sin Rostro\"";
                        break;
                }
                break;

            case "Ezalor":

                switch(tipo) {

                    case "texto1":
                        hist = "Chispa de infinitos soles, cabalgando sobre un pálido corcel va este Guardián de la Luz (Keeper of the Light). Ezalor hace ya largo tiempo que escapó del plano Fundamental, separándose de las otras fuerzas ancestrales a las que estaba ligado en el seno de la gran armonía Primigenia. Él es una fuerza que cobró consciencia en los albores del universo, y que ahora cabalga en todos los planos a la vez, siempre un paso por delante del caos que le persigue, portando con él su don en el extremo de un bastón radiante. Su majestuosa verdad yace oculta bajo la apariencia externa de un anciano decrépito que apenas consigue mantenerse sobre la montura. Sin embargo, cuando se enfrenta al desafío del caos o de las fuerzas de la oscuridad, su luz primigenia brota en un estallido, y todo su poder se manifiesta, transformándolo, una vez más, en una fuerza muy a tener en cuenta.";
                        break;
                    case "texto2":
                        hist = "Sobre un caballo pálido cabalga esta chispa de antiguos soles. Ezalor, el Guardián de la Luz, cabalga desde la destrozada armonía Primordial para llevar el don de la vida y la luz a todos los rincones del vasto universo mientras se mantiene a un paso de las antiguas fuerzas del caos y la oscuridad.\n" +
                                "\n" +
                                "Una fuerza del universo que se ha hecho sensible en los albores del tiempo, encarna y se identifica con la fuerza nuclear débil, una fuerza fundamental que es única entre las demás por sus capacidades transmutativas a nivel subatómico (en comparación con las otras fuerzas que son atractivas y repulsivas), así como por la capacidad de manipular la magia y su propia esencia.\n" +
                                "\n" +
                                "Antes de que el tiempo comenzara a fluir, las leyes fundamentales del universo estaban unidas por la gran armonía primordial en el lejano y ascendente Plano Fundamental, creada por Aquel que conocemos como Elder Titan. En los albores del universo, estas fuerzas inanimadas obtuvieron el don de la sensibilidad y la expresión a través de medios inexplicables. Con la capacidad de sentir y pensar la chispa de los antiguos soles llegó a ser conocida como Ezalor, el Guardián de la Luz y nacieron los cuatro Fundamentos. Poco después, la armonía primordial se rompió (ya sea por Ezalor con su capacidad de alterar la armonía o por Elder Titan que causó el Cisma) y los Fundamentales sintientes se soltaron en los muchos planos del mundo fragmentado que dejó su creador.\n" +
                                "\n" +
                                "Ezalor menciona con frecuencia que está en una búsqueda, pero el objetivo de esta búsqueda y el motivo por el que participa en ella se desconoce actualmente. También afirma ser originario de un lugar conocido como la Fortaleza de la Luz al que también regresa cuando muere antes de volver a cabalgar.";
                        break;
                    case "texto3":
                        hist = "Ezalor creó y asumió el manto de quien llevó la luz a todos los rincones del universo y mantuvo a raya la oscuridad y el caos con sus poderes sobre la luz y el orden, pero abandonó este papel poco después (probablemente debido a que el Caballero del Caos le perseguía tenazmente) dejándolo para que lo retomara cualquiera que quisiera continuar su obra.\n" +
                                "\n" +
                                "Pero fue bajo este manto que Ezalor estuvo en su mejor momento y lo estuvo cuando aún era la chispa de antiguos soles. Empuñando un báculo radiante canalizó sus poderes para crear el primer sol del universo, un faro de luz consciente y sensible que puede reproducirse mediante supernovas lo que da lugar a un ciclo interminable de nacimiento y renacimiento. El primer sol fue el primogénito de todos los soles y estrellas del universo, incluidos los de Phoenix y Dawnbreaker.\n" +
                                "\n" +
                                "Aunque pudo dar vida a estrellas conscientes también puede crear formas de vida. En los primeros días que siguieron a su éxodo del Plano Fundamental Ezalor canalizó su poder para crear un caballo alado que heredó su don permitiéndole ayudar en su trabajo de dar vida a los soles.\n" +
                                "\n" +
                                "Su trabajo pronto llegó a su fin cuando el Caballero del Caos puso sus ojos en él y persiguió a su hermano fugitivo del que se decía que había desafiado el primer pacto cuando escapó del Plano Fundamental. Ezalor se vio obligado a abandonar su trabajo en respuesta al acuciante peligro que se cernía sobre él y dejó el manto sin nadie a quien dárselo, hasta que lo retomaron sus nietos eones después.";
                        break;
                    case "texto4":
                        hist = "Eones más tarde Ezalor asumió un astuto disfraz en forma de anciano envejecido, una verdadera encarnación externa de la fuerza fundamental que es su identidad. Se le ha observado aparecer bajo diferentes disfraces: Adivino, mago e incluso sabio, pero ninguno está tan bien documentado como su disfraz de Guardián de la Luz del Norte.\n" +
                                "\n" +
                                "Las leyendas de las remotas y frígidas aldeas de las Montañas de los Lamentos hablan de un anciano encapuchado que viaja por los fríos páramos del Norte apareciendo sólo a los que se han perdido y cuando el mal o la oscuridad hacen acto de presencia en esas tierras. Cabalga sobre un ciervo gris, llevando la luz de la famosa Estrella del Norte que ha ayudado a innumerables viajeros a encontrar su camino al tiempo que destierra el mal y la oscuridad cuando los encuentra.";
                        break;
                    case "texto5":
                        hist = "Ezalor es propenso al olvido pero este comportamiento le afecta más profundamente de lo que observamos por su apariencia física. No es olvidadizo porque adopte la forma de un anciano sino porque en realidad es una expresión externa de la fuerza que encarna: la fuerza nuclear débil, que es más conocida por mediar en el proceso de desintegración radiactiva.\n" +
                                "\n" +
                                "La decadencia puede estar asociada al olvido en los ancianos porque su capacidad de crear y recuperar recuerdos suele deteriorarse (o decaer) con la edad.\n" +
                                "\n" +
                                "Por lo tanto Ezalor no eligió adoptar la forma de un anciano sino que su apariencia es el resultado de la creación de una forma que representa mejor lo que realmente encarna.\n" +
                                "\n" +
                                "Dejando a un lado las explicaciones sus olvidos a menudo le meten en problemas con sus parientes e incluso con él mismo.\n" +
                                "\n" +
                                "Ezalor es un ser benévolo y noble. Incluso después de abandonar su manto sigue haciendo todo lo posible para combatir el mal siempre que lo encuentra al tiempo que sigue ayudando a los que necesitan su don de la luz independientemente de la forma que adopte. Su voz y su forma de hablar tienen un aire de heroísmo y nobleza.\n" +
                                "\n" +
                                "Entre otros héroes, tiene fama de ser un viejo gracioso para ellos.\n" +
                                "\n" +
                                "Algunas de las líneas de voz de Ezalor cuando se encuentra con héroes femeninos aliados muestran que es bastante coqueto con las mujeres independientemente de su raza o especie. Se desconoce si esto es sólo una broma sobre su condición de viejo pervertido o un aspecto real de su personalidad ya que ninguna de las mujeres a las que dirige estas líneas lo reconoce y ni siquiera muestra este comportamiento en Dota Underlords.";
                        break;
                    case "texto6":
                        hist = "Ezalor es uno de los pocos héroes que tiene hijos propios. Todos los astros y soles del universo son sus hijos, incluidos Phoenix, Dawnbreaker y sus creadores, los Hijos de la Luz, que son todos descendientes del primer sol del Guardián. Dawnbreaker se siente humilde ante la presencia de su bisabuelo pero también le entristece que no hiciera nada para salvar a los Hijos de la Luz ni supiera el destino que eligieron. Incluso se enfurece con él por abandonar a sus descendientes.\n" +
                                "\n" +
                                "La Diosa Solar, una figura divina a la que adora Lina es una dilución de un linaje mayor de progenie estelar (como en las propias estrellas y soles) que incluye a la Rompedora de Amaneceres y a sus creadores, los Hijos de la Luz, Esto implicaría que la Diosa Solar es también un descendiente muy lejano de Ezalor y su primer sol.\n" +
                                "\n" +
                                "Dado que Marte es el amante de Dawnbreaker, Ezalor sería su bisabuelo. Marte parece estar muy preocupado por cómo trató a los Hijos de la Luz y por qué los abandonó.\n" +
                                "\n" +
                                "Ezalor es el hermano menor y la antítesis de Chaos Knight que ha estado persiguiéndolo desde el éxodo de los Fundamentales de su reino progenitor. El Caballero del Caos afirma que busca destruir todo el orden y la creación así como apagar la Luz de todos los planos de existencia pero oculta un motivo ulterior en el que realmente busca reunir a sus hermanos de vuelta al plano Fundamental.\n" +
                                "\n" +
                                "Todos los Fundamentales son los hijos de Elder Titan, eso incluye a las dos fuerzas omnipresentes Io y Enigma.\n" +
                                "\n" +
                                "Además del Caballero del Caos, Ezalor ha tenido algunos enfrentamientos con los hijos del Cisma. Enigma es hostil hacia Ezalor ya que encarna la misma fuerza que hace que una estrella colapse sobre sí misma y muera convirtiéndola en un agujero negro. En Dota Underlords Enigma también planea sustituirlo por Tiny por razones desconocidas.";
                        break;
                    case "frase":
                        hist = "\"Dicen que fui yo quien llevó la primera luz al universo. Puede que tengan razón, no recuerdo bien\"";
                        break;
                }
                break;

            case "Kunkka":

                switch(tipo) {

                    case "texto1":
                        hist = "Como almirante de la poderosa Armada Claddiense, Kunkka estaba a cargo de proteger las islas de su tierra natal cuando los demonios de la Catarata emprendieron una incursión en las tierras de los hombres. Tras años de pequeñas incursiones y atrevidos ataques cada vez más devastadores, la flota demoníaca llevó a todos sus buques carnívoros a la Isla Trémula. Desesperados, los Magos Suicidas de Cladd llevaron a cabo su rito definitivo, invocando a un ejército de espíritus ancestrales para proteger a su armada. Esto fue apenas suficiente para cambiar el rumbo de los acontecimientos en contra de los demonios.\n" +
                                "\n" +
                                "Mientras Kunkka los veía tomar sus embarcaciones una a una, él tuvo la satisfacción de deshacer la flota enemiga al completo con su magia ancestral. Pero en el apogeo del combate, algo en el choque entre demonios, hombres y espíritus atávicos debió despertar a una cuarta fuerza que estaba dormitando en las profundidades. Las olas se alzaron en chorros elevados en torno a los pocos navíos restantes y Maelrawn el Tentacular apareció en medio de la batalla. Sus tentáculos bambolearon a las naves, juntando a los barcos humanos y demoníacos y batiendo el agua y el viento en un furioso caos.\n" +
                                "\n" +
                                "Lo que ocurrió en el crisol de la tormenta, nadie lo puede aseverar realmente. La Catarata desapareció en el vacío, despojada de sus antiguos moradores. Kunkka es ahora el almirante de un solo barco, un fantasmagórico bote que incesantemente repite los últimos segundos de su destrucción. Si él murió en aquel choque no es posible saberlo. Ni siquiera Tidehunter, el invocador de Maelrawn, lo sabe con seguridad.";
                        break;
                    case "texto2":
                        hist = "Kunkka es el antiguo almirante de la Armada de Claddish. Procede de un linaje de marineros que antaño cazaban ballenas con arpones. Es un comandante veterano, estuvo presente en la batalla de Puerto Mignin, así como en la primera y segunda batalla de la Isla Temblorosa. Empuña la legendaria Tidebringer, una espada habitada por un alma perdida de Claddish.\n" +
                                "\n" +
                                "Después de la segunda batalla de la Isla Temblorosa, Kunkka apareció en una costa Keenish, donde reanudó su carrera como comandante de flota con los Keen como tripulación. Se rumorea que obligó a los artesanos Keen a fabricar una nueva espada a partir de los restos de los Demonios de la Catarata que también habían aparecido en la misma orilla. Los Keen aparentemente lo tienen en alta estima dándole las llaves de las puertas de su capital. Al menos se conoce el nombre de un barco bajo su nuevo mando, el Majestuoso Leviatán, un gran navío que transporta innumerables cofres de tesoros.\n" +
                                "\n" +
                                "Otro rumor no confirmado es que Kunkka partió los mares con su Sable Neptuniano, encontró a Maelrawn y cortó uno de los tentáculos del dios.\n" +
                                "\n" +
                                "Aunque Kunkka no parece ser un pirata tiene la costumbre de saquear objetos preciosos cuando se le presenta la oportunidad. Su personaje de Almirante es un mero disfraz ya que su verdadera identidad es el temido Barba Marrón, el Valiente, uno de los piratas más temidos del mar.";
                        break;
                    case "texto3":
                        hist = "Se especula sobre si Kunkka sigue vivo o se ha convertido en un fantasma tras la batalla de la Isla Temblorosa. Dado que a veces se cree que Kunkka es un fantasma es posible que el ritual de los Magos Suicidas hiciera que él y su barco sobrevivieran en sus formas etéreas tras su destrucción en los mares.\n" +
                                "\n" +
                                "Kunkka ha tenido escorbuto muchas veces.\n" +
                                "\n" +
                                "Kunkka supuestamente conoce \"terribles secretos\" en el fondo del mar que sólo él puede desvelar mediante una llave.\n" +
                                "\n" +
                                "A veces, su tripulación llama a Kunkka \"Mangas Verdes\".\n" +
                                "\n" +
                                "En una ocasión, Kunkka recibió un fino fajín como regalo de una princesa que vivía en la Isla de las Canciones. La naturaleza de esta relación no está clara.\n" +
                                "\n" +
                                "Su notoria rivalidad con Tidehunter tiene su origen en la participación de este último en la Isla Temblorosa, donde Maelrawn fue convocado para destruir las dos flotas enfrentadas. A pesar de la animosidad formal Kunkka también guarda cierto respeto por su némesis lamentando a veces su muerte.\n" +
                                "Kunkka está enfurecido por Mireska a quien culpa de la pérdida de su flota en la Isla Temblorosa. Mireska iba de polizón en su barco en busca de \"trofeos\" y tuvo algún tipo de participación en la batalla. Debido a sus acciones ahora es perseguida por Kunkka.";
                        break;
                    case "texto4":
                        hist = "De joven Kunkka sirvió como guardiamarina. Era ambicioso y buscaba ascender en el escalafón. Durante sus primeros días escuchó historias de grandes tiburones, más largos que una fragata, que cazaban barcos y devoraban marineros. A medida que crecía y ascendía de rango se ganaba los botones dorados que indicaban su nuevo estatus. De adulto cazó y mató a los tiburones gigantes de los que había oído hablar de joven, confirmando que tales leyendas eran ciertas.";
                        break;
                    case "frase":
                        hist = "\"¡Avanza ahora, tu almirante está a bordo!\"";
                        break;
                }
                break;

            case "Tresdin":

                switch(tipo) {

                    case "texto1":
                        hist = "Llegaron sin previo aviso. Tras las murallas de la ciudad de Stonehall se produjo un estruendo y un sonido terrible, y de la ignota negrura apareció un ejército de bestias en número imposible de cuantificar. Esgrimían llamas y vil hechicería. Asesinaban y raptaban a madres e hijos para sus oscuros propósitos. De la otrora poderosa fuerza militar de Stonehall, solo la Legión de Bronce, liderada por la indomable comandante Tresdin, se encontraba lo suficientemente cerca como para responder a la llamada de la batalla. Cabalgaron hacia el interior de su ciudad, combatiendo a través de callejones ensangrentados y mercados en llamas, abriéndose paso a través de la monstruosa multitud hacia la fuente de la repentina invasión: una grieta etérea en la plaza de la villa, y en el precipicio, bramando, su temido campeón.\n" +
                                "\n" +
                                "Envuelto en un resplandor corrosivo, el líder de la horda abismal blandió su enorme hoja, partiendo en dos a un legionario mientras la carne de este comenzaba a corromperse. Tresdin alzó su sangrienta espada y fijó la mirada en la bestia. Esta se giró, dirigiéndole una sonrisa a través de un laberinto de dientes. Sin hacer caso a la batalla que se libraba a su alrededor, cargaron la una contra el otro.\n" +
                                "\n" +
                                "Desviando un golpe tras otro, la pareja danzaba en duelo mortal mientras la Legión de Bronce iba sucumbiendo en torno a ellos. Tresdin saltó hacia delante mientras su rival balanceaba su espada para llevarla a su encuentro. Se volvieron las tornas. El ataque impactó bruscamente contra Tresdin, dándole un brutal golpe en el costado, pero aun perdiendo el equilibrio, fue capaz de reunir fuerzas para realizar otro ataque. La hoja raspó contra la hoja más allá de la empuñadura, llegando hasta la retorcida garra que había debajo y cortándola en dos en una terrible explosión de chispas y sangre. El infame público miró con asombro mientras ella lanzaba su ataque, conduciendo su hoja a través de la carne de su rival hasta el desbocado corazón que latía debajo. Con un grito que partió las nubes del cielo, la bestia estalló en un torrente de sangre y dolor. El portal estigio flaqueó, el poder que sostenía el abismo empezó a desvanecerse tan bruscamente como había aparecido. Los invasores que aún quedaban cayeron rápidamente bajo el acero de Stonehall.\n" +
                                "\n" +
                                "A pesar de la victoria, los supervivientes veían poco que celebrar: la ciudad estaba en ruinas, escasos eran los que habían salido con vida. Los incendios continuaban extendiéndose. Desplegando sus estandartes de guerra, Tresdin reunió a cuantos aliados pudo. Ardía en furia mientras prometía brutal venganza contra las fuerzas del abismo y maldecía a quien osara ponerse en su camino.";
                        break;
                    case "texto2":
                        hist = "Tresdin luchó contra la Horda Abisal, liderada por Vrogros, en Stonehall.\n" +
                                "\n" +
                                "Tras recibir las Cuchillas demoníacas de Voth Domosh de Qwyth, Tresdin aprendió a hablar Ozkavosh, conversando con los demonios y afirmando que \"los demonios gobernarán\".\n" +
                                "\n" +
                                "Tresdin no se fía de los magos, los demonios, los dragones, las serpientes, los árboles, los peces, los ingenieros, los insectos, los osos, los muertos y de casi cualquier otro héroe.\n" +
                                "\n" +
                                "A Tresdin le repugna la Cuchilla Abisal (Abyssal Blade) que asocia con los invasores de Stonehall.\n" +
                                "\n" +
                                "Es posible que Tresdin haya sido alguna vez miembro de la guardia real de Stonehall.\n" +
                                "\n" +
                                "Tresdin siente admiración por los bigotes.\n" +
                                "\n" +
                                "Tresdin tiene una historia con Rix, quien planea matarla.\n" +
                                "\n" +
                                "Mireska considera que el liderazgo de Tresdin es duro y tiránico, tiene una mala opinión de Stonehall y de la Legión de Bronce culpándoles de un derramamiento de sangre innecesario.\n" +
                                "\n" +
                                "Tresdin se ha aventurado en el mundo subterráneo en busca de venganza y ha encontrado un casco con gemas dentro de un flujo de magma. Ahora lo lleva, aunque no sabe qué efectos negativos puede tener.";
                        break;
                    case "texto3":
                        hist = "Dirigida por Tresdin, la Legión de Bronce intentó contener al ejército de la Niebla Roja en Roseleaf. Los detalles son escasos, salvo los indicios de que Tresdin tomó malas decisiones y pudo haber iniciado la lucha, lo que resultó en un desastre para la Legión de Bronce. Tras la batalla Mireska encontró en el lugar la Bandera de la Serpiente de Toro que es el emblema de la legión.";
                        break;
                    case "texto4":
                        hist = "Tresdin estuvo una vez enamorado de un hombre llamado Belasanno.";
                        break;
                    case "frase":
                        hist = "\"¡Si quieren guerra, entonces se la daremos!\"";
                        break;
                }
                break;

            case "Leshrac":

                switch(tipo) {

                    case "texto1":
                        hist = "Leshrac, el Alma Atormentada, es una entidad arrancada de las entrañas de la naturaleza, un ser limítrofe que existe, a partes iguales, en dos planos diferentes de la existencia. Su penetrante inteligencia es tal que no puede ni por un momento ignorar el agonizante horror existente en el corazón de la creación. Habiendo sido un gran filósofo que buscaba el significado de la existencia, él sondeó las profundidades de la naturaleza con los prodigiosos Cristales Cronópticos y quedó para siempre perturbado por los atroces secretos que le fueron revelados. Ahora las más oscuras profundidades de su revelación son iluminadas solo por los esporádicos destellos de su arrogancia. Como otras figuras elementales, Leshrac es completamente uno con la naturaleza, pero en su caso es una naturaleza espeluznante y vil. Solo él conoce la perversa realidad de la existencia y desprecia a aquellos que creen que el cosmos reserva una recompensa especial para los que practican la benevolencia.";
                        break;
                    case "texto2":
                        hist = "Leshrac, el Alma Atormentada, es el guardián elemental de la verdad maligna de toda la creación más allá de nuestra comprensión. Con los elementos de la naturaleza y las energías Cronópticas del núcleo de la naturaleza a su disposición, el prístino mundo natural pronto reflejará su horripilante contraparte mientras él lo conduce al caos, la decadencia y el sufrimiento.";
                        break;
                    case "texto3":
                        hist = "Leshrac habla a menudo de un estado de caos total que pretende alcanzar inclinando el equilibrio de nuestro mundo. Para derribar el equilibrio de este mundo debe traer la desolación más indiscriminada a este mundo y a sus habitantes. Lo consigue asolando la propia naturaleza convirtiéndola en un mundo devastado (al igual que su núcleo devastado) y utilizando cualquier recurso que tenga con el fin de lograr el desequilibrio. Aquellos que son lo suficientemente desafortunados como para ser sensibles y animados son destruidos junto con el mundo en el que habitan, además de ser tratados con un viaje al corazón de toda la existencia para ver la desagradable verdad de la naturaleza, junto con otras retorcidas intenciones que Leshrac tiene reservadas. También afirma que debe restaurar este estado de desequilibrio dando a entender que ya ha existido antes y que él simplemente lo está trayendo de vuelta.\n" +
                                "\n" +
                                "Hay varias razones que le motivan a hacer todas estas cosas horribles. En primer lugar, esta Alma Atormentada se siente obligada a compartir su tormento con los demás. No sólo infligiendo sufrimiento a los que se cruzan en su camino, sino desbloqueando el tormento innato que todo el mundo lleva dentro al iluminarles con la horrible verdad de la naturaleza, de la misma manera que se dio cuenta de que toda su existencia es un tormento. Sin embargo, lo que realmente le impulsa a hacer estas cosas tan sucias es su sed de conocimiento oscuro. Aún sin estar satisfecho de haber aprendido el horrible misterio en el corazón de la naturaleza que lo alteró hasta convertirlo en el ser que es hoy, Leshrac desea un \"final para todo\" que cree que puede permitirle aprender estos peores misterios ocultos por las Impurezas en el corazón de la existencia.\n" +
                                "\n" +
                                "Tal vez sea esto lo que le motiva a participar en la guerra de los Ancestros. Si fracasa será condenado a lo que posiblemente sea un estado de tormento interminable.";
                        break;
                    case "texto4":
                        hist = "Sabiendo que la verdad de toda la naturaleza es el tormento, el sufrimiento y la decadencia, las acciones inherentes de Leshrac reflejan esta oscura filosofía. Para causar el mayor tormento y sufrimiento posible comparte sus tormentos con los demás a través de sus energías Cronópticas para que todos puedan aprender el verdadero tormento que una vez ignoraron. En cuanto a provocar la mayor decadencia posible lo hace mediante la devastación y la destrucción de la naturaleza. Su crueldad y sadismo se derivan de esta creencia, especialmente por el tormento y el sufrimiento.\n" +
                                "\n" +
                                "Leshrac es un nihilista. Su tipo de nihilismo no está especificado pero rechaza la creencia de que la Naturaleza reserva una recompensa para los benévolos y no tiene ningún uso para los que creen eso. Puede haber alcanzado este nihilismo por el hecho de que hacer el bien no significa nada cuando ha visto lo que la malvada verdad de la realidad les tiene reservado. Desea un \"final para todo\", lo que cree que le permitirá aprender los peores misterios ocultos por las Impurezas.\n" +
                                "\n" +
                                "También se dice que su marca de sabiduría es sombría, lo que puede ser una prueba más de su nihilismo, lo que también lo convierte en un filósofo pesimista.";
                        break;
                    case "texto5":
                        hist = "Leshrac parece estar orgulloso de su cuerpo de cuatro patas, vilipendiando a los seres que sólo tienen dos. Además de eso, vilipendia a los seres con anormalidades físicas. Por alguna razón ve la forma de Enchantress como una desgracia para los de cuatro patas.\n" +
                                "\n" +
                                "Está tan desviado de su antigua forma normal que se siente extraño en el mundo natural. Lo relaciona con Puck que también es ajeno a la naturaleza.\n" +
                                "\n" +
                                "Este autoconocimiento de ser el único ente que ve la verdad de la realidad le ha convertido en arrogante, si es que no lo era así antes de su transformación. Incluso humilla a los demás al matarlos pero se da cuenta de su humildad al mori. Su tendencia a humillar a los demás podría ser parte de su sadismo.\n" +
                                "\n" +
                                "Leshrac es generalmente una criatura infeliz. Su mente retorcida se encuentra a menudo en un estado de cavilación, produciendo a veces agonizantes reflexiones que se manifiestan dolorosamente en su forma física. (Comparado con la mayoría de los Héroes que declaran alegremente y con confianza \"Está en la bolsa\", él lo dice sin entusiasmo, como si fuera forzado a decirlo). También odia la diversión.\n" +
                                "\n" +
                                "Según un aspecto pícaro de Espectro, Leshrac tiene una ira que considera insignificante. Quizás esta ira proviene de su propio estado de tormento o está enojado porque a menudo ataca a los demás con ira, como vilipendiándolos e impugnándolos, sin mencionar que la mayoría de sus líneas de voz tienen una voz elevada.";
                        break;
                    case "texto6":
                        hist = "Leshrac es el autoproclamado guardián de las Impurezas. En algunas ocasiones les da diezmos de oro por razones desconocidas. También se desconoce qué uso tienen las Impurezas para el oro. Invoca a las Impurezas con sus acciones posiblemente para mostrar su devoción por ellas. Por último, busca un \"final para todo\" que cree que le permitirá conocer los peores misterios que esconden.\n" +
                                "\n" +
                                "Leshrac no jura lealtad ni sumisión a nadie, por lo que no sirve a ningún poder o entidad superior que no sea la propia naturaleza.\n" +
                                "\n" +
                                "Grimstroke considera un desperdicio matar a Leshrac porque tenía planes de reclutarlo para su bando. Lo que planea hacer junto al elemental nihilista es actualmente desconocido.\n" +
                                "\n" +
                                "Esta malvada criatura nihilista es odiada y vilipendiada por mucha gente. Según su propia palabra, es un asesino en masa y puede haber cometido un genocidio.\n" +
                                "\n" +
                                "En una ocasión Leshrac le hizo algo a una mujer conocida de Pangolier, lo que le enfureció enormemente. Aunque Donté le dejó vivir en ese momento juró matar a Leshrac en venganza, si volvía a verlo. Es interesante destacar que el nihilismo de Leshrac que abarca el tormento y el sufrimiento choca con el hedonismo de Donté.\n" +
                                "\n" +
                                "A Hoodwink no le gusta Leshrac. Parece estar familiarizada con su clase y se sorprende al verlo además de los otros que ha conocido y tiene una muy mala relación con un personaje femenino sin nombre que se enfadará con ella por matar a Leshrac.";
                        break;
                    case "texto7":
                        hist = "Se desconoce la forma anterior de Leshrac, cuando aún era un filósofo, pero en su forma actual aún pueden verse restos de su aspecto anterior. Su rostro es un buen indicador de lo que solía ser: sus rasgos faciales más notables son su nariz ancha y plana y sus ojos amarillos y vacíos, rasgos que pueden verse en el pueblo oglodi. También cabe destacar que los Oglodi fueron una vez una raza intelectual formada por artistas y filósofos esotéricos, de los que posiblemente Leshrac formaba parte dado su origen.\n" +
                                "\n" +
                                "Transformado en un elemental maligno por el horroroso misterio del corazón de la naturaleza, Leshrac es uno con esta naturaleza escabrosa y vil. Su forma se asemeja a la del cuerpo de un centauro pero sus rasgos son retorcidos y antinaturales. Las excrecencias pétreas forman su extraña cornamenta y los hombros de su torso equino. A diferencia de las patas delanteras de un caballo y de otros ungulados, sus patas delanteras pueden doblarse hacia y fuera de su cuerpo. Tiene pezuñas de tres dedos y hay marcas rúnicas por toda su forma, de las que no sabemos nada sobre su significado. Es un ser dimensional que existe a medias en el plano material y a medias en su corazón. Su cuerpo emite un débil resplandor en todo momento. Al igual que los caballos y otros ungulados similares en los que se basa su forma, a veces puede manotear el suelo en su animación ociosa.\n" +
                                "\n" +
                                "Su forma física alberga los mismos cristales cronópticos que le permiten ver el corazón de toda la realidad. Estos cristales sobresalen de su espalda, sus hombros y la parte posterior de su cráneo por defecto. Son de color rosa o púrpura, y pueden ser la fuente de su poder Cronóptico. Los cristales de la parte posterior de su cabeza pueden multiplicarse y crecer aún más, sustituyendo su propia cornamenta. Estas lamentables agujas se nutren de las ondas de energía Cronóptica que pasan por su mente deformada.\n" +
                                "\n" +
                                "Esta forma antinatural puede ser deformada aún más por su voluntad. Por ejemplo los pensamientos agonizantes de Leshrac pueden manifestarse más allá de la mente y en su cuerpo, haciendo que estallen desde lo más profundo. La angustia de Leshrac, sus pensamientos negros y sus malas acciones lo han convertido en el anfitrión de un crecimiento maligno de enredaderas, una especie de sabiduría retorcida que se alimenta y prospera de esos tres aspectos de Leshrac.\n" +
                                "\n" +
                                "Un sorbo de las aguas contaminadas de su naturaleza ha corrompido irremediablemente su cuerpo con una variedad de mutaciones vegetativas antinaturales. La corrupción ha provocado un crecimiento de ramas en sus brazos que utiliza para canalizar un gran poder a través de ellas. Hay un crecimiento antinatural de hongos duros como piedras en sus hombros y espalda y su cola se ha transformado en un arma que \"pulsa desolación\", probablemente refiriéndose a su Pulse Nova. El efecto ha llegado también a sus cuernos curvos que corrompen permanentemente las almas de cualquiera que los toque.";
                        break;
                    case "frase":
                        hist = "\"El desequilibrio lo exige\"";
                        break;
                }
                break;

            case "Ethreain":

                switch(tipo) {

                    case "texto1":
                        hist = "En vida, el mago del hielo Ethreain (sin ser todavía un Lich) esclavizó reinos enteros bajo la amenaza de su destructivo poder helador. Con el tiempo, sus súbditos, ayudados por unos pocos magos desesperados, se volvieron lo suficientemente audaces como para tenderle una emboscada. Armados con suficiente cuerda maldita como para atarle eternamente, anudaron al mago del hielo a firmes pesos y lo arrojaron a una laguna conocida principalmente por no tener fondo. No era así.\n" +
                                "\n" +
                                "Durante más o menos un año, solo cayó, hasta que su cuerpo se estrelló contra un saliente. Allí descansó, muerto pero sin descomponerse, hasta la llegada del geomante Anhil, que comprobaba la veracidad de la leyenda de la supuesta Laguna Negra sin fondo. La plomada de Anhil se enredó con las cuerdas que ataban al mago ahogado, arrastrando un inesperado premio. Con la esperanza de que, al devolverle la vida, pudiese preguntar al Lich por las propiedades de la laguna, Anhil eliminó las ligaduras y realizó un simple rito de resurrección. Incluso los descendientes de los enemigos de Ethreain habían perecido hacía tiempo, por lo que no había nadie para avisarle de semejante imprudencia. Sin embargo, rápidamente descubrió el error que había cometido, cuando Lich se deshizo de sus ataduras y le consumió.";
                        break;
                    case "texto2":
                        hist = "Lich ha participado en la guerra que se libra en Roseleaf. Técnicamente no es un participante directo, pero lo ve como una oportunidad para enriquecerse ya que la guerra tiene muchas oportunidades para él mientras se desarrolla: Lion viaja a Weeping Rose buscando asilo en la ciudad para protegerse de Tyler Estate y de la Corte de Ristul. La Doncella de Cristal está de vacaciones y es posible que resida en algún lugar de Weeping Rose debido a sus obligaciones como colaboradora externa del Cónclave de Zafiro. Y la rebelión Vhoul, liderada por el rebelde Rix, está perdiendo actualmente contra las fuerzas de Stonehall y están dispuestos a hacer cualquier cosa para ganar la lucha. Con todos estos acontecimientos Lich sopesa sus opciones: ¿a quién debe matar primero?";
                        break;
                    case "texto3":
                        hist = "Con el tiempo, la magia de escarcha del Lich se convirtió en un catalizador del poder que había en su interior y que comenzó a manifestarse desde su cuerpo en forma de densos cristales de hielo. Estos crecimientos comenzaron a salir de sus brazos y espalda buscando envolver al mismo mago de hielo. Para contrarrestarlo envolvió su cuerpo con un trozo de tela encantada que neutraliza el crecimiento de este poder impidiendo que lo consuma.\n" +
                                "\n" +
                                "Lich lleva un frasco en su cintura que late con los restos del calor que tenía su corazón antes de morir, donde puede vigilarlo.\n" +
                                "\n" +
                                "La gravedad no ejerce ninguna atracción sobre el Lich lo que le permite elevarse sin esfuerzo por encima del suelo incluso cuando está sujeto por un cinturón pesado. Lleva este cinturón como burla a los que pretenden derribar a Lich.\n" +
                                "\n" +
                                "Además de la magia de hielo, Lich tiene la capacidad de preservar objetos para evitar que se pudran y corroan. Utiliza este poder para preservar las cuerdas encantadas, llevándolas como recordatorio de que nadie debe esperar volver a atarlo.\n" +
                                "\n" +
                                "Ethreain tuvo una vez en su vida un tomo mágico. Cuando sus súbditos rebeldes lo ataron, le encadenaron el tomo a la espalda y le colocaron un tocado para cegarlo y que nunca pudiera leer sus oscuras páginas.\n" +
                                "\n" +
                                "En vida, Ethreain buscó la Corona de Sangre. Los rumores sobre el artefacto lo llevaron a buscar el objeto de reino en reino pero no logró adquirirlo al ser arrojado a su muerte en la Piscina Negra. Sin embargo no sabía que la corona no puede ser portada por ninguna criatura viva y si hubiera completado esta búsqueda en su forma mortal y no en su forma no-muerta, habría sido su mayor fracaso.";
                        break;
                    case "frase":
                        hist = "\"Y así los muertos enterrarán a los muertos\"";
                        break;
                }
                break;

            case "N'aix":

                switch(tipo) {

                    case "texto1":
                        hist = "En las mazmorras de Devarque, un vengativo hechicero yacía entre grilletes, planeando su fuga. Compartía su celda con una criatura balbuceante conocida como N'aix, un ladrón maldito por el Consejo Vil con el don de la longevidad, de forma que su cadena perpetua por robos y engaños fuera lo más dolorosa posible. A lo largo de los años, sus cadenas se habían corroído, así como su cordura; N'aix no guardaba ningún recuerdo de su vida anterior, ni ningún sueño de escapar.\n" +
                                "\n" +
                                "Viendo en él el recipiente perfecto para sus planes, el mago ejecutó un hechizo de Infestación e introdujo su esencia vital en el cuerpo de N'aix, con la intención de que éste se sacrificara de la forma más violenta posible mientras el mago volvía a su cuerpo y se fugaba disimuladamente. Sin embargo, el mago vio su mente absorbida por un vórtice de locura tan poderoso que disipó sus planes y destruyó su voluntad. Devuelto a la consciencia por la repentina inyección de vida, N'aix se despertó de la pesadilla de la locura y obedeció a la voz que resonaba en su cabeza, que tenía una única idea: escapar.\n" +
                                "\n" +
                                "En ese momento, nació Lifestealer. La criatura se introdujo en la mente de los guardias de la mazmorra y los soldados, haciéndoles abrir las cerraduras y atacar a sus compañeros, despejando así el camino hacia su libertad mientras se alimentaba de sus vidas. Lifestealer porta aún los grilletes rotos, como una advertencia de que nadie lo puede retener, aunque en el fondo siga siendo un prisionero. Dos mentes cohabitan en un solo cuerpo: una criatura de maléfica astucia y un maestro cuya voz finge obedecer.";
                        break;
                    case "texto2":
                        hist = "Renacido en las sucias mazmorras de Devarque, N'aix el Lifestealer se lanza al mundo para continuar con los robos por los que fue castigado en su vida anterior. N'aix no tiene una sola mente sino que es una mezcla antinatural de dos mentes que habitan un solo cuerpo. Combinando la nueva fuerza de N'aix y la magia de la fuerza vital de un mago sin nombre es sólo cuestión de tiempo que N'aix libere la esencia de sus víctimas para alimentarse a sí mismo y a su maestro.\n" +
                                "\n" +
                                "En las mazmorras de Devarque había un mago vengativo encarcelado entre sus muros y barrotes. Este mago sin nombre compartía celda con un Oglodi balbuceante llamado N'aix, un ladrón maldecido por el Consejo Vil (Vile Council) con la longevidad, para que su larga vida en cautiverio fuera lo más castigada posible. Tal fue la longevidad que se le impuso que podría vivir durante muchas generaciones de los nobles de Devarque,por lo que sucumbir de viejo nunca será un escape del tormento que recibirá durante el resto de su condena.\n" +
                                "\n" +
                                "La mente del ladrón estaba rota por las innumerables crueldades que los nobles de Devarque y sus descendientes le habían infligido siendo cada método diferente al anterior. Pero aunque su mente rota no podía entender por qué se le castigaba ni siquiera podía comprender el significado del castigo, los métodos de tortura seguían siendo diferentes a los anteriores mantenidos por la malvada creatividad de los nobles de Devarque y su progenie.\n" +
                                "\n" +
                                "Encontrando una gran oportunidad para su plan de fuga, el mago puso en marcha sus planes. Elaboró un hechizo de Infestación: un hechizo que arroja la fuerza vital del mago en el cuerpo de la víctima, permitiéndole controlar a N'aix contra su propia voluntad. Después de obligarlo a atacar a los guardias y provocar una conmoción, volvería a su cuerpo y se escabulliría sin ser notado. Al lanzar su fuerza vital sobre la criatura, encontró su mente atrapada en un vórtice de intensa locura que barrió sus planes y destrozó su voluntad, dejando su conciencia atrapada dentro de la criatura o lo que quedaba de su antigua identidad.\n" +
                                "\n" +
                                "Aunque el hechizo fracasó e incluso le salió el tiro por la culata no se desperdició en absoluto. El hechizo fallido infundió a N'aix con la fuerza vital del mago y le devolvió la conciencia de su estado de locura y desvarío. En los primeros momentos de su despertar logró comprender una voz en su cabeza que sólo podía tener un pensamiento: Escapar.\n" +
                                "\n" +
                                "Así nació Lifestealer, una mezcla de dos mentes perversas que habitan en un solo recipiente. Haciendo caso a la idea de escapar, Lifestealer arrojó su mente a los guardias y soldados de la mazmorra, obligándoles a romper las cerraduras y a reducir a sus compañeros, dejando un rastro de caos y cuerpos para que él se diera un festín. Al final de esta masacre, Lifestealer escapó de las mazmorras de Devarque, libre para continuar con su robo una vez más: no de oro y posesiones sino de la dulce fuerza vital que fluye dentro de cada criatura viviente.\n" +
                                "\n" +
                                "Lleva sus grilletes rotos a la vista como recordatorio de que nadie debe esperar contenerlo, una ironía enfermiza que se ve desmentida por su forma física: una prisión de carne torturada que contiene una conciencia incorpórea que sólo conoce como Maestro, al que sólo pretende obedecer.";
                        break;
                    case "texto3":
                        hist = "N'aix buscó una vez un hechicero que pudiera elaborar un conjunto de mejoras viles para fortalecer su retorcido cuerpo. Pero sus hazañas y su reputación han llegado a oídos de mucha gente a lo largo y ancho y la tarea de encontrar un hechicero que incluso ofreciera sus servicios a alguien tan malvado y demente como N'aix resultaría difícil de completar. Finalmente encontró a un aprendiz de un mago caído en desgracia que tenía interés en las artes más oscuras del fortalecimiento. N'aix le encargó la elaboración de un conjunto de mejoras para su cuerpo, que incluía un juego de cuchillas con garras y una espaldera esquelética que, al abrirse revelara una mancha de carne palpitante.\n" +
                                "\n" +
                                "El aprendiz del hechicero se puso manos a la obra y consiguió forjar las mejoras solicitadas y los acopló al cuerpo de N'aix, reforzando aún más su forma y transformando su silueta en algo irreconocible de su ser anterior. La última pieza era un hocico de aspecto monstruoso al que se le había añadido secretamente un agente de control que le permitiría controlar a Lifestealer tras realizar un ritual. Al colocar el bozal en las fauces del Lifestealer y realizar el ritual se dio cuenta demasiado tarde de que el agente controlador no se había unido al bozal durante el ritual en absoluto.";
                        break;
                    case "texto4":
                        hist = "A pesar de que su identidad y recuerdos pasados han sido destruidos, N'aix aún conserva varios aspectos de cuando todavía era un ladrón corriente. Le desagradan los conceptos de encarcelamiento, adquisición y control y se confunde cuando se le da algo gratuitamente.\n" +
                                "\n" +
                                "El único pensamiento que el mago le dio a N'aix después de quedar atrapado en su mente indica su aversión al control. \"Escapar\" puede no significar que el mago le diga a N'aix que escape sino que el propio mago quiere realmente escapar de la mente de N'aix. Esta petición cae en saco roto (o en las mentes en este contexto) ya que sólo pretende obedecerle.\n" +
                                "\n" +
                                "A pesar de que le desagrada el control y ser controlado parece ser un hipócrita en ese sentido por su falta de vacilación a la hora de utilizar el control mental (por ejemplo, Infest) es un indicador de ello.\n" +
                                "\n" +
                                "Los nuevos poderes de N'aix sobre la fuerza vital de otros le ha dado una personalidad maliciosa y sádica como efecto secundario.\n" +
                                "\n" +
                                "N'aix, que ya es una criatura demente, no encuentra nada desagradable en las cosas horribles que hace para satisfacer sus necesidades y deseos perversos.";
                        break;
                    case "texto5":
                        hist = "N'aix se refiere con frecuencia a su Maestro, que es el mismo mago que compartió su celda e intentó controlarlo.";
                        break;
                    case "frase":
                        hist = "\"¡Oh Maestro, contempla todas estas vidas para tomar!\"";
                        break;
                }
                break;

            case "Lina":

                switch(tipo) {

                    case "texto1":
                        hist = "La rivalidad fraterna entre Lina la Asesina y su hermana pequeña Rylai, la Doncella de Cristal (Crystal Maiden), hizo correr ríos de tinta en la templada región donde pasaron su infancia en una lucha continua. Lina siempre tuvo ventaja. Sin embargo, aunque Crystal era cándida e ingenua, el feroz ardor de Lina se veía atenuado por el ingenio y la manipulación. Los exasperados padres de estos incompatibles retoños llegaron a utilizar media docena de moradas, perdiendo unas por fuego y otras por hielo, antes de comprender que la vida sería mucho más sencilla si las niñas vivieran separadas. Como hermana mayor, Lina fue enviada lejos hacia el Sur para vivir con una paciente tía suya en el abrasador Desierto de Misrule, un clima en el que la feroz Asesina se encontraba como pez en el agua. Su llegada causó una gran conmoción entre los aletargados lugareños. Más de un pretendiente acabó con sus dedos abrasados o tuvo que huir con las cejas chamuscadas y el rabo entre las piernas. Lina es orgullosa y segura de sí misma, nada puede apagar su fuego.";
                        break;
                    case "texto2":
                        hist = "Lina es la hermana mayor de Rylai. Las dos tienen una rivalidad entre hermanas.\n" +
                                "\n" +
                                "En su juventud, el cabello de Lina solía arder. Esto sigue ocurriendo cuando se enfada.\n" +
                                "\n" +
                                "Lina se entrenó en las artes de la llama cuando era niña con acólitos de la Diosa Solar en el este del Basurero Centelleante. Los acólitos creían que su cabello estaba \"tocado por la luz\", y le ofrecían baratijas para reflejar el sol en su cabello.\n" +
                                "\n" +
                                "Aunque Lina no lo sepa, es posible que sea una \"niña besada por el wyrm\", de las que sólo nacen una vez cada época.\n" +
                                "\n" +
                                "Lina posee una joya y un vestido que en su día usó un noble que gobernó el Desierto de la Anarquía.\n" +
                                "\n" +
                                "Lina es muy popular entre los hombres del desierto, cuyos hijos aristócratas la buscan a menudo para casarse. El Señor de la Anarquía mandó hacer un vestido real para ella, para que estuviera presentable ante su hijo.\n" +
                                "\n" +
                                "Lina luchó una vez en una guerra, donde redujo el campo de batalla a un cráter humeante.\n" +
                                "\n" +
                                "Según Rylai, Lina cree que la combustión humana es divertida.";
                        break;
                    case "texto3":
                        hist = "Rylai es la principal rival de Lina y los dos hermanos se enfrentaron a menudo en su infancia. Lina suele ser la instigadora y parece haber hecho un gran mal a su hermana y ahora vive en remordimieto. Después de haber hablado con Lina, Donte Panlin puede haber conseguido que ella conceda el arrepentimiento. \n" +
                                "\n" +
                                "Actuando como intermediario, transmite esta información a Rylai diciéndole que Lina puede estar dispuesta a enmendar su error.\n" +
                                "\n" +
                                "Según Mireska, fueron sus padres los que separaron a Lina y a Rylai.";
                        break;
                    case "frase":
                        hist = "\"El fuego es un buen sirviente pero una dura amante\"";
                        break;
                }
                break;

            case "Lion":

                switch(tipo) {

                    case "texto1":
                        hist = "Una vez que fue Gran Maestro de la tradición de hechicería Demon Witch, Lion ganó fama entre sus hermanos por luchar del lado de la luz y la justicia. Pero la adulación corrompe. Con poderes superados solo por su ambición, el mago fue seducido por un demonio y se volvió malvado, intercambiando su alma por prestigio. Después de cometer horribles crímenes que estropearon su alma, fue abandonado. El demonio lo traicionó, logrando mejores tratos con sus enemigos. Tal fue la ira de Lion que siguió al demonio de regreso al infierno y lo mató, desgarrándolo miembro por miembro, tomando su mano demoníaca como propia. Sin embargo, tal demonoplastia tiene un costo. Lion fue transfigurado por el proceso, su cuerpo se transformó en algo irreconocible. Se levantó del infierno, la rabia encarnada, matando incluso a aquellos que una vez lo llamaron maestro, y arrasando las tierras donde una vez había sido tan adorado.";
                        break;
                    case "texto2":
                        hist = "En un momento desconocido, Lion buscó la mano de Buki'vak, el Corrupto, que habitaba en las profundidades bajo las Ciudades Hundidas y a través del Vacío Infernal. Lo derrotó tras una larga batalla y recogió su mano para una nueva demonoplastia. Al igual que los efectos de la mano de su difunto compañero demonio, Lion se vio afectado por la Corrupción Maligna, lo que hizo que crecieran fragmentos de obsidiana de su cuerpo y lo hizo aún más irreconocible de su forma original.\n" +
                                "\n" +
                                "Lion solía ser un embajador de alto rango del Infierno. Un pueblo demoníaco agradecido le concedió su uniforme y lleva el cetro Strifemaul para enfatizar los puntos importantes de su razonamiento, probablemente a través de la violencia o el énfasis real.\n" +
                                "\n" +
                                "Lion lleva un anillo de rubí que puede calcinar el alma de su portador. Afortunadamente su alma ya está condenada y corrompida por lo que no tiene ningún efecto sobre él. También tiene un tercer ojo físico que le permite mirar más allá de la realidad para ver los viles poderes que hay más allá de ella.\n" +
                                "\n" +
                                "El Amuleto del Rey Aleta es uno de los muchos objetos que posee Lion. Utilizado en su día por los arcanistas del Rey Aleta para desterrar a los objetivos al reino submarino, ha perdido su capacidad principal y gran parte de su potencia, pero aún tiene suficiente poder para convertir a los objetivos en un pez.\n" +
                                "\n" +
                                "Después de masacrar a la Orden del Escalón de Cristal, Lion se preparó para matar al enfurecido Vidmar, el jefe de su ya desaparecida orden. Con su último aliento, maldijo la mano demoníaca de Lion una vez que fue golpeada por su hechizo (que también reforzó su maldición), infundiéndole la Podredumbre de Cristal. Sólo al fusionar el tocado de la Prelada con su mano, Lion pudo frenar temporalmente los efectos. Pronto deberá encontrar una solución permanente para librarse de la maldición, pero por ahora... parece que Lion tiene una nueva magia que probar.\n" +
                                "\n" +
                                "Cada vida que León toma con su mano demoníaca alimenta la transfiguración demoníaca de su cuerpo y su magia, infundiéndoles los aspectos de su difunto compañero demoníaco.\n" +
                                "\n" +
                                "Lion pidió al Quorum que le concedieran asilo en Weeping Rose y lo recibió.\n" +
                                "\n" +
                                "Nyx Assassin insinúa que Lion debe ganarse la gracia de Nyx, sugiriendo que Lion tiene algún conocimiento de la diosa reina.\n" +
                                "\n" +
                                "Antes de que Lion se convirtiera en acólito del Gran Maestro del Brujo Demonio (Grandmaster of the Demon Witch), solía cuidar ovejas para su familia.";
                        break;
                    case "texto3":
                        hist = "León ya se ha encontrado con Donte Panlin y le cae muy mal. Donte le advierte que si vuelven a encontrarse, habrá consecuencias.";
                        break;
                    case "texto4":
                        hist = "Mientras la Legión de Bronce y la Niebla Roja libraban sus guerras, Lion tenía su propio conflicto al que enfrentarse. Perseguido por la Corte de Ristul por su mano demoníaca trasplantada y por el Tyler State por su uso profano de la magia, Lion buscó asilo en Weeping Rose.\n" +
                                "Primero debe buscar al Emisario del Quórum, que escuchará su petición de asilo. A cambio podrá compartir sus secretos con el Quórum.\n" +
                                "\n" +
                                "Varias respuestas de voz indican que está dispuesto a trabajar para Tyler State a cambio de su libertad. También cree que Silencer debería reconocer su utilidad debido a sus habilidades antimágicas similares, como el Drenaje de Maná.\n" +
                                "\n" +
                                "Lich también busca matarlo antes de que llegue a Weeping Rose por razones desconocidas.";
                        break;
                    case "frase":
                        hist = " \"Todo el infierno se ha desatado, y yo sostengo los pedazos\"";
                        break;
                }
                break;

            case "Sylla":

                switch(tipo) {

                    case "texto1":
                        hist = "Mucho antes de las primeras palabras de las primeras historias ya se alzaba el druídico Clan del Oso. Sabios y justos eran, y se concentraron en el modo de llegar a comprender el orden natural. Las astutas fuerzas de la naturaleza vieron esto, y así buscaron de entre ellos al más docto. El viejo y sabio Sylla, juez supremo y profeta del clan, dio un paso al frente por los suyos y a él fue entregada la Semilla con estas palabras: «Cuando el mundo entero se haya apagado, cuando la civilización haya dejado estas tierras, cuando el mundo esté muerto y arruinado por los interminables desiertos al final de los tiempos, planta la Semilla».\n" +
                                "\n" +
                                "Al tomar en su mano lo que se le confiaba, Sylla sintió que los años retrocedían y regresaba su vitalidad. Vastos conocimientos irrumpieron en su mente. Se vio capaz de proyectar su voluntad sobre la realidad y, con cierta concentración, de alterar incluso su propio aspecto físico. Pero sutiles murmullos y crueles oídos llevaron la noticia de la Semilla y su poder a otros pueblos, y una terrible guerra cayó sobre el Clan del Oso. Mientras su casa ancestral ardía, Sylla cogió su carga y huyó a las tierras salvajes.\n" +
                                "\n" +
                                "Los años pasaron y el tiempo y los mitos se olvidaron del Clan del Oso, de Sylla y la Semilla, se olvidaron de las maravillosas civilizaciones que ascendieron y cayeron tras el paso del Clan del Oso. Durante milenios, Sylla esperó... esperó por noticias de sus dioses, esperó que llegara la paz a los reinos en constante guerra, esperó en el exilio y en secreto el final de todas las cosas y la conclusión de su sagrada encomienda, siempre preparándose a sí mismo para enfrentarse y destruir cualquier cosa que osara poner en peligro su propósito.";
                        break;
                    case "texto2":
                        hist = "Sylla participa en las discusiones de Onyx Grove.\n" +
                                "\n" +
                                "Sylla ha vencido a Xahryx, una misteriosa entidad que encarnaba el mal.\n" +
                                "\n" +
                                "Sylla ha tenido contacto con el Clan de la Serpiente, quienes le han regalado una armadura.\n" +
                                "\n" +
                                "El Oso Espiritual de Sylla es simbiótico con él, en corazón y espíritu. Es una proyección del espíritu de Sylla y su apariencia puede alterarse según el estado de ánimo de Sylla.\n" +
                                "\n" +
                                "Sylla domina las artes del Clan del Oso, lo que le permite sintonizarse con la naturaleza.\n" +
                                "\n" +
                                "Sylla enseñó una vez a Ulfsaar, pero también perdió un dedo por razones desconocidas.\n" +
                                "\n" +
                                "Sylla tiene poca consideración por los lobos, a los que caza. Debido a esto, a menudo es hostil con Lycan.\n" +
                                "\n" +
                                "Sylla tiene alguna conexión con los Atniw. Se desconoce qué es exactamente el Atniw.\n" +
                                "\n" +
                                "Al conocer a Sylla, Grimstroke afirma que ha conocido a otro druida antes aunque no está claro a quién se refiere.";
                        break;
                    case "frase":
                        hist = "\"Me pregunto qué me espera al final de todo...\"";
                        break;
                }
                break;

            case "Luna":

                switch(tipo) {

                    case "texto1":
                        hist = "¿Cómo pudo verse reducida a esto? Ella, que una vez fue el Azote de las Llanuras, despiadada líder de hombres y bestias, capaz de sembrar el terror dondequiera que se aventuraba. Ahora estaba lejos de su tierra natal, medio enloquecida por el hambre y meses de vagar, con su ejército largamente muerto o vuelto a peor. Detenida al borde un vetusto bosque, un par de brillantes ojos la espiaban desde una gruesa rama. Un ser bello y letal que buscaba algo que llevarse a la boca durante el marchito atardecer. Sin hacer ruido, dio media vuelta y se largó. La rabia se apoderó de ella. Empuñando una vieja daga comida por el óxido, fue tras la bestia decidida a recuperar aunque fuese un ápice de su gloria pasada, pero su presa no se dejaría atrapar. Tres veces arrinconó a la bestia entre rocas y árboles, y tres veces se abalanzó solo para presenciar cómo su desvaneciente sombra se adentraba aún más en el bosque. Sin embargo, la luna llena brillaba intensamente, y el rastro de la criatura era fácil de seguir.\n" +
                                "\n" +
                                "Al llegar a un claro sobre la cima de una elevada colina, la enorme bestia de forma felina se sentó en el espacio abierto, atenta y expectante. Cuando la mujer blandió su daga, la criatura se alzó sobre sus patas traseras, rugió y embistió. La muerte, al parecer, finalmente había venido a por ella en este extraño lugar. Permaneció en pie, tranquila y preparada para lo que estaba por llegar. Una ráfaga de movimientos y la bestia arrancó la daga de su mano antes de desaparecer en el bosque. Silencio. Figuras encapuchadas se acercaron. En un tono reverente le revelaron que Selemene, Diosa de la Luna, la había elegido, la había guiado y la había puesto a prueba. Inconscientemente, había soportado los ritos sagrados de los Luna Oscura, guerreros de los Bosques de Nightsilver.\n" +
                                "\n" +
                                "Se le ofreció una elección: unirse a los Luna Oscura y comprometerse al servicio de Selemene, o irse y nunca regresar. Ella no vaciló. Abrazando su absolución, renunció a su pasado sangriento y adoptó una nueva identidad como Luna de la Luna Oscura, la temida Jinete de la Luna, la guardiana despiadada y siempre leal de los Bosques de Nightsilver.";
                        break;
                    case "texto2":
                        hist = "La montura de Luna es Nova.\n" +
                                "\n" +
                                "Luna pertenece y posee una reliquia de la Orden de la Luna Oscura, un grupo de guerreros al servicio de Selemene. Fue elaborado a partir de un fragmento lunar que cayó de los cielos.\n" +
                                "\n" +
                                "Al igual que otros miembros de su orden Luna está probablemente familiarizada con el Templo de Mene, y sirve en su defensa contra la Horda de la Luna Oscura.\n" +
                                "\n" +
                                "Luna tiene fama de tener un corazón frío.\n" +
                                "\n" +
                                "A juzgar por su lore y el diálogo, Luna y Mirana están afiliadas, con Mirana llevando una realeza más alta que ella algo que Luna parece resentir.\n" +
                                "\n" +
                                "Según Marte, Luna es como una oveja al servicio de Selemene.\n" +
                                "\n" +
                                "Slyrak es consciente de la aversión de Davion hacia Luna.\n" +
                                "\n" +
                                "En Dota: Dragon's Blood se queda sin poder después de que Selemene le quite sus poderes tras la renuncia de Luna.";
                        break;
                    case "texto3":
                        hist = "Luna conoce a Beatrix Snapfire de los días en los que era el Azote de las llanuras ya que, al parecer, las dos competían juntas en sus hazañas.\n" +
                                "\n" +
                                "Pudge insultó una vez a la montura de Luna, pero parece que se ha disculpado.";
                        break;
                    case "frase":
                        hist = "\"Yo fui una vez el azote de las llanuras, un terror en el viento. ¿Qué esperanza creen que tienen nuestros enemigos?\"";
                        break;
                }
                break;

            case "Banehallow":

                switch(tipo) {

                    case "texto1":
                        hist = "Banehallow era un noble nacido en la casa de Ambry, la más poderosa casta de terratenientes del viejo reino de Slom. Antes de la Caída, cuando los caprichos del Rey se volvieron cada vez más extraños y su corte comenzó a llenarse de hechiceros y charlatanes, la familia Ambry fue la primera en alzarse en contra de la avaricia del trono. Cansados de rendir lealtad y pleitesía, en su lugar, enviaron seis mil espadas a la capital, las cuales fueron usadas en la Masacre de los Apóstatas. Entonces, una verdad salió a la luz: Si hieres a un rey en el cuello, asegúrate de arrancarle la cabeza por completo.\n" +
                                "\n" +
                                "Enfurecido por la traición, el rey exterminó a todos los descendientes en la línea de sangre de los Ambry, salvo al regente de la casa y a su hijo menor, Banehallow. Ante toda la corte real y con el deshonrado caballero encadenado al suelo de mármol ornamentado, el Rey ordenó a sus magos transformar al chico en un lobo para que éste le arrancase la garganta a su propio padre. «Hacedlo» —dijo el Rey— «para que Lord Ambry sienta la mordedura de la traición». Una poderosa magia fue invocada y el chico se transformó; pero a pesar de que su cuerpo cambió, su espíritu permaneció intacto, y en vez de morder el cuello expuesto de su padre, atacó a sus captores, reduciéndolos a pedazos. Una docena de Caballeros del Rey perecieron bajo los colmillos del lobo antes de que consiguieran conducirlo fuera, a la oscuridad de la noche. Lord Ambry, aún encadenado, continuó riéndose a pesar de que el Rey lo empaló con una espada. Ahora, como único heredero de la extinta familia Ambry, Banehallow merodea por los caminos como Lycan, mitad guerrero, mitad lobo, en búsqueda de justicia por todo lo que perdió.";
                        break;
                    case "texto2":
                        hist = "A Banehallow le gusta la compañía de otros afligidos por la licantropía, a los que conoce en sus viajes. Sin embargo su compañía no siempre es bien recibida por otros como él.\n" +
                                "\n" +
                                "Banehallow ha viajado a las ruinas de la finca de su familia donde recogió suficientes desechos para hacerse un casco con forma de lobo.";
                        break;
                    case "texto3":
                        hist = "Sun Wukong ha prometido ayudar a Banehallow a recuperar la Casa de Ambry.";
                        break;
                    case "frase":
                        hist = "\"Un lobo con piel de hombre\"";
                        break;
                }
                break;

            case "Magnus":

                switch(tipo) {

                    case "texto1":
                        hist = "Los maestros herreros del monte Joerlak solo se ponen de acuerdo en una cosa: ni la más preciada de las aleaciones es tan valiosa como un cuerno de magnoceronte. De todos esos cuernos, el más grande y afilado pertenece a la bestia conocida como Magnus. Durante media generación Magnus dedicó su tiempo a cornear a aquellos cazadores que intentaban reclamar los tesoros de los de su especie. Cada noche regresaba a su cueva con las pezuñas y cuernos teñidos de rojo hasta que un día la matriarca urgió a él y su prole a buscar refugio al norte, más allá de la sombra de la montaña. Magnus, no obstante, se tomó aquella predicción a broma, sabiéndose infalible a la hora de defender a su pueblo. Los magnocerontes no se moverían de allí, sentenció, pues un magnoceronte no cree en el azar... y tampoco cambia jamás de opinión.\n" +
                                "\n" +
                                "Pero cuando el monte Joerlak entró súbitamente en erupción y vio como medio clan moría bajo el fuego y las llamas, Magnus tuvo que cambiar de opinión. Los supervivientes apremiaron hacia el norte hasta que se toparon con un cerco en el camino, vigilado por cientos de cazadores armados con arcos y acero. Magnus no esperaba menos. Guio a sus más bravos hermanos en una carga contra los enemigos y luchó con fiereza tal que solo el volcán que tenía tras de sí podría igualar. Mientras tanto, los magnocerontes más ancianos, las madres y las crías se desvanecieron entre las sombras. Existe división de opiniones entre los maestros herreros acerca de lo que aconteció después.\n" +
                                "\n" +
                                "Muchos dicen que Magnus logró reunirse con los suyos. Otros cuentan que recibió heridas mortales y acabó pereciendo junto al cuerpo de la matriarca. Ninguna de estas teorías es acertada. Magnus prometió volver a reunirse con su familia, sí... pero no sin antes haber encontrado y asesinado con la furia de su cuerno a aquellos responsables de la erupción del monte Joerlak, pues un magnoceronte no cree en el azar.";
                        break;
                    case "texto2":
                        hist = "Entre los magnoceroi del monte Joerlak no hay ninguno tan feroz y firme como Magnus. Sólo él posee el cuerno más grande de todos ellos y le da un gran uso corneando a cualquiera que se atreva a cazar a sus parientes por sus preciosos cuernos, manteniendo su noble vigilia durante media generación. Una gran calamidad puso a sus hermanos en peligro lo que le hizo estar aún más decidido a preservarlos.\n" +
                                "\n" +
                                "Tras alejarse de los suyos para vengar a los caídos ha jurado dar caza a los cómplices que pusieron en peligro a sus hermanos. Utiliza los poderes de su pueblo en forma de pica, cuerno, pezuñas, magia así como el poder de la propia montaña que los destruyó para corresponder a la justicia y al justo castigo.\n" +
                                "\n" +
                                "Al igual que los cuernos de su raza, los maestros herreros del Monte Joerlak sólo están de acuerdo en un punto: que el cuerno de un magnoceros es más precioso que cualquier aleación. Si el cuerno de un magnoceros típico es de plata, el cuerno de Magnus es de oro. Durante media generación este excelente guerrero protegió ferozmente a su familia de los coleccionistas y cazadores furtivos que codiciaban los cuernos de los suyos hasta que su matriarca le instó a él y a todos sus hermanos a buscar refugio en el norte, más allá del alcance de la sombra de la montaña. Pero Magnus desestimó su consejo, ya que nunca había dejado de defender a su pueblo. Decidió que los magnoceros se quedarían ya que un magnocero no cree en el azar... ni cambia nunca de opinión.\n" +
                                "\n" +
                                "Magnus pronto encontraría sus creencias desafiadas cuando el Monte Joerlak entró en erupción sin previo aviso. La mitad de su familia pereció en el fuego y la ceniza, lo que le llevó a él y a los demás supervivientes a dirigirse al norte tal y como había decidido su matriarca. Llegaron a un bloqueo vigilado por un centenar de cazadores armados con arcos y acero para sus expectativas. Fue Magnus quien se puso a la vanguardia de la carga liderando a sus hermanos más fieros contra sus enemigos mientras luchaba con una ferocidad que sólo podía ser igualada por el volcán en erupción que tenía detrás. Mientras tanto, los ancianos, las madres y las crías de los magnoceroi se desvanecieron en la deriva. Los maestros de ceremonias estaban divididos acerca de lo que ocurrió a continuación.\n" +
                                "\n" +
                                "Algunos especulan que Magnus se reunió con su familia mientras que otros afirman que sucumbió a sus heridas y murió junto al cuerpo de su Matriarca. Sin embargo ninguna de estas teorías es correcta. Magnus juró reunirse con su familia pero sólo después de encontrar a los cómplices de la erupción del monte Joerlak y ensartarlos con su cuerno. Después de todo, un magnoceros no cree en el azar ni siquiera contra una supuesta calamidad natural.";
                        break;
                    case "texto3":
                        hist = "Ha pasado mucho tiempo desde la calamidad que sufrió su pueblo. Aunque Magnus estaba decidido a enfrentarse a los que cazaban a su familia ha encontrado una nueva causa en la lucha dentro del Bosque de Roseleaf. Magnus ha simpatizado y se ha puesto del lado de los Vhoul a los que cree que sus colonizadores, la nación de Stonehall, están convirtiendo en una mercancía. También ha tomado a la joven Ilexa bajo su protección pues cree que está destinada a algo grande, y él debe encargarse de que se haga realidad.";
                        break;
                    case "texto4":
                        hist = "Magnus es un miembro orgulloso de su raza. Sus parientes en peligro de extinción (junto a aquellos de entre ellos que han muerto) y sus votos de vengarlos y restaurarlos nunca salen de su mente.\n" +
                                "\n" +
                                "Magnus es una criatura muy obstinada. No cambia de opinión y es firme en sus juramento, creencias y no cree en la casualidad, pero sus creencias pueden ser desafiadas por acontecimientos funestos. Aun así es capaz de recuperarse y renovar sus creencias rápidamente, ya que ni la muerte ni una erupción volcánica que acabó con la mitad de su familia fueron capaces de cambiar permanentemente su forma de pensar.\n" +
                                "\n" +
                                "Magnus está orgulloso de su propio cuerno. Es consciente de lo precioso que es en comparación con otras cosas y aprecia las reacciones de asombro y celos hacia su cuerno, pero se cruza una línea si alguien intenta tocarlo.\n" +
                                "\n" +
                                "Magnus es una criatura noble. Protege a los indefensos y detesta a los que se aprovechan de su debilidad inherente. Por otro lado nunca se sacia de matar a los tontos y débiles que se le cruzan y cree en la regla de la naturaleza que no tiene cabida para los débiles, y la aplica.\n" +
                                "\n" +
                                "Puede parecer contradictorio e incluso hipócrita, pero Magnus sólo defiende a los mansos y mata a la clase de debiluchos que intentan cubrir su debilidad con un falso poder, como los que son oportunistas o subyugan a los seres inferiores y los que se sobrevaloran.\n" +
                                "\n" +
                                "Magnus tiene el don de decir las cosas correctas en el momento adecuado.";
                        break;
                    case "texto5":
                        hist = "En la guerra a tres bandas que se libra en Roseleaf, Magnus ha elegido el bando de los Vhoul y sus protectores como el Treant Protector.\n" +
                                "\n" +
                                "También se ha convertido en el protector de Ilexa y la ha llevado a los Merodeadores para que la protejan.\n" +
                                "\n" +
                                "Le gusta trabajar con Sven, probablemente por la sinergia entre sus habilidades antiejército. Sven también comparte los mismos sentimientos.\n" +
                                "\n" +
                                "Magnus es respetado por el Centaur Warrunne por su fuerza. Sin embargo, esto parece un poco contradictorio, porque Bradwarden es un cazador furtivo, un tipo de persona que Magnus detesta.\n" +
                                "\n" +
                                "Magnus odia a los cazadores furtivos y a otras personas similares a ellos.\n" +
                                "\n" +
                                "Debido a su alianza con los Vhoul y sus protectores es hostil hacia la Legión de Bronce de Stonehall y la Horda de la Niebla Roja.";
                        break;
                    case "frase":
                        hist = "\"No, no culpo a nadie que codicia mi cuerno. Pero desear más que verlo es garantía de muerte\"";
                        break;
                }
                break;

            case "Marci":

                switch(tipo) {

                    case "texto1":
                        hist = "Admirada por muchos, los orígenes de Marci son conocidos por unos pocos sin nombre. Viaja principalmente en compañía de la princesa Mirana, pero las raíces de su amistad están entrelazadas en secretos que ninguna de las dos revelaría innecesariamente. Para los aliados, ella sirve como una compañera feroz y honesta. Para los enemigos, actúa como una intrépida disuasión para no dañar a cualquiera que considere como amigo. Aunque los adversarios imprudentes pueden considerar que su tamaño no tiene nada de especial, Marci posee un poder interior que imbuye sus golpes con una fuerza increíble. Diezmará a quienes osen ponerla a prueba, pero quienes se ganen su favor tendrán una confidente imperturbable de por vida.";
                        break;
                    case "texto2":
                        hist = "Marci es la sirvienta y el músculo de Mirana. Es muda y muy hábil en la batalla. Más tarde fue asesinada por Kashurra, sacrificando su vida para salvar a Mirana.";
                        break;
                    case "frase":
                        hist = "*Silbido*";
                        break;
                }
                break;

            case "Mars":

                switch(tipo) {

                    case "texto1":
                        hist = "Mars, primer hijo del cielo, pasó una larga existencia librando una guerra interminable y vio innumerables cruzadas bajo el estandarte de su antiguo nombre. Guerras de conquista y de venganza. Justas e injustas... pero siempre crueles. Tanto como su padre, Mars se entregó a sus impulsos más básicos, con inclinaciones mucho más monstruosas que las de Zeus, e infligió sufrimientos nunca vistos.\n" +
                                "\n" +
                                "Pero a medida que las épocas se desvanecían a su paso, los hábitos egoístas de su padre, los hábitos de muchos de sus parientes piadosos, de aquellos que <i>lo juzgaron</i> como despreciable, comenzaron a crear un vacío. La guerra por sí misma ya no era suficiente para satisfacer sus deseos. Por primera vez en su eternidad, el dios de la guerra comenzó a cuestionar con qué fin esgrimía su gloriosa lanza.\n" +
                                "\n" +
                                "Como las Moiras indicaban, su solución llegó fácilmente: debía librar la guerra con un propósito más crucial e inspirar más que mero salvajismo y tristeza como perspectiva de su culminación. Por último, debía reclamar el manto de liderazgo que le da su derecho de nacimiento, porque había llegado el momento de quemar el panteón antiguo y construir un nuevo imperio, justo encima de las cenizas de sus ancestros. Solo entonces podría encontrar satisfacción y hacer que la gloria de Mars fuera evidente para todos.";
                        break;
                    case "texto2":
                        hist = "Marte ha renegado de su herencia en su afán por crear un nuevo imperio. Tiene un antiguo nombre que le dio su padre y que ha desechado.\n" +
                                "\n" +
                                "Marte recibe y exige que se le hagan sacrificios.\n" +
                                "\n" +
                                "En una ocasión Marte mató a uno de sus tutores al que compara con Rubick.";
                        break;
                    case "texto3":
                        hist = "Marte ha luchado en innumerables guerras incluyendo las Conquistas Estigias, la Invasión de Wightfall y las campañas contra El Continuum. Luchó contra una misteriosa figura llamada Sheragndar y fue responsable de la creación de Quoidge como resultado de sus guerras.";
                        break;
                    case "texto4":
                        hist = "La Legión de la Ceniza, un grupo de guerreros supremos que encontraban la emoción en el combate, fue asesinada por Marte tras desafiar al dios a un combate.\n" +
                                " \n" +
                                "Sus cuerpos no muertos se levantan ahora voluntariamente a las órdenes de Marte, formando una Arena de Sangre en la que los combatientes pueden luchar sin interferencias.";
                        break;
                    case "texto5":
                        hist = "Marte menciona a varios otros dioses del panteón griego. Su padre es Zeus, su madre es Hera, sus tíos son Poseidón y Hades. También hace referencia a Vulcano, el dios del fuego y la herrería que forjó su lanza.\n" +
                                "\n" +
                                "Está distanciado de Zeus, su padre, cuyo panteón desea derribar. Debido a su enemistad con su padre, Marte también odia el rayo que le recuerda a los rayos de Zeus.\n" +
                                "\n" +
                                "Aparte de los dioses griegos, Marte tiene relaciones hostiles con los dioses de Dota 2, buscando cazar y matar a Selemene y a los Gemelos Desollados. Es neutral hacia la Omnisciencia.\n" +
                                "\n" +
                                "Marte es cercano a Io, describiéndola como su más antigua amiga que le ayudó en tiempos oscuros. También tiene un extraño deseo por las crías y los huevos de Black Arachnia.";
                        break;
                    case "frase":
                        hist = "\"¡Los de atrás, uníos! Los de delante, arrodillaos\"";
                        break;
                }
                break;

            case "Medusa":

                switch(tipo) {

                    case "texto1":
                        hist = "Belleza es poder. Ese pensamiento consolaba a Medusa (la más joven y encantadora de las tres bellas hermanas Gorgonas, nacidas de una diosa del mar) porque únicamente ella era mortal. Le reconfortaba, hasta el día en que unos asaltantes enmascarados invadieron el reino Gorgón y se llevaron a las dos hermanas inmortales, implacablemente ante su belleza y sus lágrimas. Uno de los invasores apresó también a Medusa, pero la apartó con una mirada de asco: 'Esta apesta a mortal. No tenemos uso alguno para aquello que muere'. Humillada y enfurecida, Medusa huyó al templo de su madre y se arrodilló ante la diosa, llorando, '¡Me denegaste la vida inmortal, por ello te pido que me des poder! ¡Poder para que pueda dedicar esta vida que tengo a rescatar mis hermanas y vengar esta injusticia!' Tras pensarlo detenidamente, la diosa le concedió a su hija su petición, permitiéndole a Medusa intercambiar su belleza legendaria por un rostro y una forma de una fuerza temible. En ningún momento se ha arrepentido Medusa de su decisión. Entiende que el poder es la única belleza que merece la pena poseer, ya que únicamente el poder puede cambiar el mundo.";
                        break;
                    case "texto2":
                        hist = "Medusa tiene un jardín de rocas que contiene estatuas petrificadas de héroes.\n" +
                                "\n" +
                                "Medusa posee un bolso de piel de serpiente.\n" +
                                "Antes de su transformación, Medusa llevaba un delicado velo sobre el rostro.\n" +
                                "\n" +
                                "Medusa posee un arco hecho con la madera y el veneno cristalizado de una víbora de la selva de Yama Raskav.\n" +
                                "\n" +
                                "Medusa conoce a Zeus y a sus hermanos.\n" +
                                "\n" +
                                "Donte Panlin ha prometido ayudar a Medusa a encontrar a sus hermanas";
                        break;
                    case "frase":
                        hist = "\"La única belleza real es el poder\"";
                        break;
                }
                break;

            case "Meepo":

                switch(tipo) {

                    case "texto1":
                        hist = "«Si me preguntas, la vida depende de a quién conoces y qué puedes encontrar. Cuando vives en las Ruinas de la Grieta Sombría, incluso encontrar comida puede ser complicado. Así que tienes que saber ahorrar, tienes que gorronear, tienes que conocer tus puntos fuertes. Algunas de las bestias ahí arriba pueden matarte, así que necesitas algún método para atrapar a los débiles y evadir a los fuertes. Lo bueno es que las ruinas tienen historia y la historia vale mucho para algunos. Solía haber un palacio allí, donde tenían lugar todos estos rituales oscuros. Mal rollo. Si sobrevivías a la ceremonia, rompían un cristal y hacían tu alma pedazos. ¡Eso sí, eran muy artísticos! Esculturas y todo eso. Deja que te cuente: a veces encuentras unas cuantas de esas tallas viejas. Lleva un saco lleno de ellas a la ciudad y véndelas, te dará suficiente para comer unas semanas. Si la suerte realmente está de tu parte, puede que encuentres un cristal de la Grieta Sombría. Llévalo a tasar y ponte a preguntar. Siempre hay alguien que conoce a algún loco en busca de este tipo de cosas. Si no es tu día, véndeselo a un Magus la próxima vez que uno pase por la ciudad. Les encantan estas cosas. Eso sí, hagas lo que hagas, ten cuidado al manipular esos cristales. No querrás que uno te explote encima. Duele un montón».";
                        break;
                    case "texto2":
                        hist = "Meepo pertenece a una raza de seres sin nombre y proviene de una familia numerosa.\n" +
                                "\n" +
                                "Se sabe que Meepo cava tumbas.\n" +
                                "\n" +
                                "Meepo conoce a Gondar y dice que se encargó de una \"cosa\" por él.\n" +
                                "\n" +
                                "Meepo come pescado.\n" +
                                "\n" +
                                "Meepo tiene un diente de oro.\n" +
                                "\n" +
                                "A Meepo le gustan las pelirrojas lo que declara a Lina, Lyralei (Windranger) y Aiushtha (Enchantress).\n" +
                                "\n" +
                                "Meepo utiliza con frecuencia armas improvisadas como su fiel pala, un manojo de cristales, una antorcha, un palo de linterna, una llave de gran tamaño, un martillo y una sartén atada a un palo.\n" +
                                "\n" +
                                "Meepo codicia las gemas mágicas de Rubick y le pide que se las regale. También se ofrece a venderle a Rubick más gemas.\n" +
                                "\n" +
                                "Meepo es conocido por desenterrar Oro Radiante.\n" +
                                "\n" +
                                "Meepo pasó años cavando en Singer's Gulch, donde desenterró un cristal resonante gigante.\n" +
                                "\n" +
                                "Meepo sabe tocar un laúd cuadrado, al que llama \"violín de punteo\". A veces toca en un conjunto con sus clones.\n" +
                                "\n" +
                                "Además de vender baratijas, Meepo también se gana la vida contando historias sobre las Ruinas de Riftshadow y guiando a los viajeros a través de sus desiertos. Aquellos que deseen conocer los secretos más profundos de las ruinas deben dar una generosa propina a Meepo y mantener la boca cerrada sobre cualquier cosa que vean.\n" +
                                "\n" +
                                "A Meepo le gusta el juego, incluso suele apostar en las carreras de White Spire.\n" +
                                "\n" +
                                "Meepo es de clase trabajadora.";
                        break;
                    case "texto3":
                        hist = "En una ocasión Meepo exploró las Ruinas de Hueso donde obtuvo la llave del arco de entrada, muy dañado por los explosivos. En el interior encontró bandidos a los que expulsó y se llevó una de sus bandanas como recuerdo. También encontró el cráneo de una gran criatura parecida a un pájaro que ahora utiliza para proteger su hombro derecho.";
                        break;
                    case "texto4":
                        hist = "Un clon de Meepo se separó y ahora está perdido en Underhollow. Está abarrotado de equipo minero y puede haber estado buscando el raro queso Roshefort. También se ha dejado crecer la barba.";
                        break;
                    case "texto5":
                        hist = "Meepo está familiarizado con el Círculo de Jasper y, al parecer, tiene una gran deuda pendiente con ellos. Por ello es perseguido por Lorlin Lasan, que promete un destino siniestro para Meepo una vez que lo encuentre. También es buen amigo de Mireska, una antigua candidata al Círculo de Jasper que va a beber y a jugar con él y le advierte de los planes del Círculo de Jasper.";
                        break;
                    case "frase":
                        hist = "\"Todos estos elegantes caballeros y monstruos aterradores. ¡Pff! ¿Qué tienen ellos que yo no tengo? Nada, eso es\"";
                        break;
                }
                break;

            case "Mirana":

                switch(tipo) {

                    case "texto1":
                        hist = "La princesa Mirana, nacida en una familia real y la siguiente en la línea de sucesión al Trono Solar, renunció voluntariamente a cualquier derecho a tierras mundanas y títulos cuando se dedicó por completo al servicio de Selemene, Diosa de la Luna. Conocida desde entonces como la Princesa de la Luna, Mirana merodea por los sagrados Bosques de Nightsilver en busca de cualquiera que se atreva a robar el sagrado loto luminoso de las charcas plateadas en los dominios de la diosa. Montada sobre su amigo felino, no conoce el miedo, y está preparada, orgullosa y en sintonía con las fases de la luna y los ciclos de las constelaciones mayores. Su arco, con afilados fragmentos de mineral lunar en sus extremos, obtiene su poder de la luna, lo que le permite recargar sus flechas de luz.";
                        break;
                    case "texto2":
                        hist = "En una ocasión Mirana fue asediada y se vio obligada a defender a su montura moribunda. Agotada y al borde del colapso su lucha fue vista por la antigua montura de Selemene, la celestial Axia de Metira, que descendió de los cielos para llevarse a Mirana. Se desconoce si la montura moribunda de Mirana se refiere o no a Sagan.";
                        break;
                    case "texto3":
                        hist = "Mirana se presenta por primera vez junto a Marci. El dúo buscaba los Lotos de Selemene. Y ella se encontró con el Caballero Dragón durante sus celebraciones en la taberna. Davion se interesó por ella y más tarde los acompañó desde Haupstadt hasta la Bodega del Dragón. \n" +
                                "Más tarde ascendió al Trono Solar como Emperatriz del Sol.";
                        break;
                    case "texto4":
                        hist = "Sagan es la montura de Mirana.\n" +
                                "\n" +
                                "Mirana encontró una vez un grifo en el Bosque de la Plata Nocturna.\n" +
                                "\n" +
                                "Mirana a veces rinde culto en el Templo de Mene donde tiene visiones.\n" +
                                "\n" +
                                "A diferencia de Luna Mirana no parece ser miembro de la orden de la Luna Oscura.\n" +
                                "\n" +
                                "Mirana tiene una guardaespaldas llamado Marci.\n" +
                                "\n" +
                                "Mirana es la Diosa-Emperatriz del Sol después de que Lina y Marci murieran por ella.\n" +
                                "\n" +
                                "Mirana obtiene el título de \"Princesa de la Luna\" después de que Selemene la acogiera cuando era una niña.";
                        break;
                    case "frase":
                        hist = "\"¿Cuánto tiempo debemos cabalgar antes de que nos llamen de nuevo a Nightsilver Woods?\"";
                        break;
                }
                break;

            case "Sun Wukong":

                switch(tipo) {

                    case "texto1":
                        hist = "Durante quinientos años tuvo que soportar la presión de la montaña. Solo su cabeza estaba libre del aplastante peso de la cárcel de piedra que los dioses antiguos habían invocado para detener su pueril rebelión. El musgo crecía sobre las líneas de su cara, la hierba le brotaba por las orejas y su visión estaba enmarcada por las flores silvestres que prosperaban en torno a sus mejillas. La mayoría lo creía muerto hace tiempo, atormentado por los dioses por librar una guerra contra los cielos hasta que no quedó nada más que su leyenda. Pero, según se cuenta, Monkey King no puede morir.\n" +
                                "\n" +
                                "Así que esperó. Aguantó hasta que los dioses vinieron a ofrecerle una oportunidad de redención. Y cuando llegaron a decirle el precio, Sun Wukong aceptó su encargo: acompañaría a un joven acólito en una peregrinación secreta, lo protegería de los demonios y los peligros del camino y lo guiaría a casa en posesión de una codiciada reliquia. Si hacía eso y obedecía humildemente los mandatos del humano sirviendo a su sagrada misión, Sun Wukong demostraría que estaba reformado.\n" +
                                "\n" +
                                "Para variar, Sun Wukong cumplió con honor su juramento a los dioses y expió así los pecados de insurrecciones pasadas. El acólito —que había aprendido mucho de las adversidades— retornó a su templo con la reliquia en sus manos, y Wukong —viéndose por primera vez en paz con los dioses— estuvo conforme con renunciar a su antigua sed de aventura y gloria durante algún tiempo. Pero Monkey King nació para hacer travesuras... y ofender a los dioses es algo que nunca pasa de moda.";
                        break;
                    case "texto2":
                        hist = "Sun Wukong puede transformarse en setenta y dos formas diferentes.\n" +
                                "\n" +
                                "Sun Wukong puede arrancarse pelos del cuerpo y transformarlos en clones de sí mismo.\n" +
                                "\n" +
                                "Sun Wukong puede ver demonios ocultos.";
                        break;
                    case "texto3":
                        hist = "Su bastón, el Ruyi Jingu Bang, pesa diecisiete mil libras (7700 Kg) y se extiende mágicamente según la voluntad de Wukong. Antes de Wukong el bastón tiene una larga historia.";
                        break;
                    case "texto4":
                        hist = "Sun Wukong ha estado en el Laberinto Estrecho aunque no se \" adhirió al camino\". Mientras estaba allí borró su nombre y el de varios otros del Libro de los Muertos.";
                        break;
                    case "texto5":
                        hist = "El modelo de arma por defecto de Sun Wukong es la Bara del Rey Mono.\n" +
                                "\n" +
                                "Sun Wukong también es conocido como el Gran Sabio.\n" +
                                "\n" +
                                "Sun Wukong desprecia a los animales, excepto a los monos.\n" +
                                "\n" +
                                "Sun Wukong se ha burlado a los dioses.\n" +
                                "\n" +
                                "Sun Wukong ha pasado un verano en el Bosque de la Noche Plateada.\n" +
                                "\n" +
                                "Sun Wukong monta una nube.\n" +
                                "\n" +
                                "Sun Wukong desea montar un dragón.\n" +
                                "\n" +
                                "Sun Wukong visitó una vez el Palacio de Hurra'agdu donde comió algún tipo de insecto como manjar.\n" +
                                "\n" +
                                "Sun Wukong es extremadamente hablador hasta el punto de resultar molesto.";
                        break;
                    case "texto6":
                        hist = "Sun Wukong conoció una vez a Black Arachnia y aparentemente tuvo una relación amistosa. Con el tiempo \"rompieron\", y siguen siendo hostiles el uno con el otro hasta el día de hoy.\n" +
                                "\n" +
                                "Debido a su historia, Sun Wukong muestra un fuerte odio hacia los espíritus y los dioses, especialmente Ember Spirit, Storm Spirit y Earth Spirit. También desprecia a los carceleros, incluyendo a Razor.\n" +
                                "\n" +
                                "Sun Wukong golpeó una vez a Beastmaster.\n" +
                                "\n" +
                                "Sun Wukong odia a Aurel, lo encuentra molesto a él y a su máquina voladora.\n" +
                                "\n" +
                                "Sun Wukong ha prometido ayudar a Banehallow a recuperar la Casa de Ambry.\n" +
                                "\n" +
                                "Sun Wukong es amigo de muchos asesinos.\n" +
                                "\n" +
                                "Sun Wukong es coqueto y se interesa por Lina, Rylai y Luna.\n" +
                                "\n" +
                                "Sun Wukong es amigo de Breklin.\n" +
                                "\n" +
                                "Sun Wukong hizo una vez algo negativo a Skitskurr (Weaver).\n" +
                                "\n" +
                                "Sun Wukong luchó una vez contra Leviatán mientras buscaba su Báculo, también liberó a Slark de su prisión por accidente.";
                        break;
                    case "frase":
                        hist = "\"Hay muchas historias sobre el Rey Mono. Algunas incluso son ciertas\"";
                        break;
                }
                break;

            case "Morphling":

                switch(tipo) {

                    case "texto1":
                        hist = "Durante negros eones, el cometa daba vueltas en círculos. Esclava de un sol distante y sumisa a la inexorable fuerza de la gravedad, la enorme bola de hielo se abría paso por la oscuridad entre mundos, volviéndose extraña debido a su sombrío viaje. En vísperas de la ancestral guerra de los Vloy, el cometa atravesó el cielo y dejó una estela de luz a lo largo de la noche. Una señal que ambos ejércitos interpretaron como un presagio. La fría esfera se derritió en un destello de calor abrasador mientras que por debajo dos fuerzas reanudaban la batalla en el margen de un estrecho río. Así es cómo Morphling, liberado de su helado estasis, nació en conflicto: una fuerza elemental en sintonía con las caprichosas y espontáneas mareas de los océanos. Se adentró en la lucha, tomando instintivamente la forma del primer general que se atrevió a atravesar el agua y matándolo a continuación. A medida que los variopintos guerreros se iban enfrentando, él iba cambiando de una forma a otra a lo largo de la batalla, absorbiendo instantáneamente los aspectos de estas extrañas criaturas: ahora un soldado de infantería, ahora un arquero, ahora un jinete... hasta que, en el momento en que el último soldado cayó, Morphling ya había desempeñado todos los papeles. El final de la batalla fue su comienzo.";
                        break;
                    case "texto2":
                        hist = "Morphling rinde culto a la Polimorfia.\n" +
                                "\n" +
                                "Morphling existe tanto en el Plano Astral como en el Plano Terrenal al mismo tiempo.\n" +
                                "\n" +
                                "Mientras estaba en el espacio Morphling fue atraído a la tierra por la promesa de una corona hecha de Oro Radiante.\n" +
                                "\n" +
                                "Morphling mantiene un contacto regular con Birot, que le rinde tributo a cambio de noticias sobre el mundo de la superficie.";
                        break;
                    case "frase":
                        hist = "\"Solo extrañas el agua cuando el pozo se seca\"";
                        break;
                }
                break;

            case "Slithice":

                switch(tipo) {

                    case "texto1":
                        hist = "Entre los miembros de la Guardia Slithereen de alto juramento hay un voto solemne que se repite a menudo antes de la batalla: ningún Slithereen puede fallar. En verdad, estas palabras son a partes iguales juramento y pacto ejecutable, porque aquellos que no cumplen con su deber son desterrados de la orden. Fracasar es ser otra cosa que Slithereen.\n" +
                                "\n" +
                                "Una vez que fue la más estimada de su raza, Slithice estuvo al mando de un batallón de sus compañeros durante muchos años, utilizando su formidable voz como su mejor arma. Poderosa, sinuosa, serpentina, lideró a su mortífera Guardia en defensa de los Profundos y la gran riqueza de las ciudades hundidas. Pero en la batalla final de Crey, sus fuerzas fueron rechazadas por un ejército merodeador de levianths que intentaba encontrar un tributo para su dios Maelrawn. Después de la larga y sangrienta matanza, mientras se retiraban los cuerpos de los pasillos hundidos, se encontró que faltaba un único cáliz enjoyado en el tesoro. De sus cien guardias, solo sobrevivió un puñado, pero su valentía y sacrificio fueron de poca importancia. Lo que importaba era que se llevaran ese tesoro. Honor destruido. Y así, Naga Siren fue expulsada. Desterrado a buscar el cáliz robado. Aunque podría añadir cien veces su peso al tesoro de oro, está condenada a vivir apartada hasta el día en que devuelva lo que le fue arrebatado. Porque ninguna cantidad de oro es igual en honor al honor que ella perdió.";
                        break;
                    case "texto2":
                        hist = "Slithice y Rhasta son viejos amigos.\n" +
                                "\n" +
                                "Después de la batalla de Crey, Slithice fue despojada de su rango y su puesto, desterrada y obligada a cubrirse la cabeza si alguna vez entra en contacto con su propia gente. Sin embargo recibió un conjunto de armadura de obsidiana de los agradecidos ciudadanos de Crey y obtuvo un conjunto de espadas saqueadas del cadáver de un Leviatán muerto.\n" +
                                "\n" +
                                "Al igual que Slardar, Slithice sirvió para proteger a los Profundos y sus tesoros, es probable que conozca la Bóveda Profunda y sus guardianes.";
                        break;
                    case "texto3":
                        hist = "En su primer ciclo como miembro de la Guardia Slithereen, Slithice fue desplegada para ayudar al Cónclave de la Salmuera en la Batalla de la Puerta de Piedra. Por sus acciones ejemplares y su valor en combate fue iniciada en la Orden del Ciprín aunque al principio se resistió a este honor. Su pertenencia a esta prestigiosa y antigua orden allanó el camino para su ascenso a la preeminencia.";
                        break;
                    case "frase":
                        hist = "\"Canto la canción de batalla de las sirenas\"";
                        break;
                }
                break;

            case "Furion":

                switch(tipo) {

                    case "texto1":
                        hist = "Cuando Verodicia, Diosa de los bosques, había terminado de poblar los verdes parajes, habiendo plantado el rizado espíritu en la semilla, habiendo tentado a las sutiles aguas de muy dentro de la roca, habiendo jurado al Sol su completa atención al crecer de las cosas, ella se dio cuenta de que su propio tiempo había llegado a su fin y como una de las hojas cuyo destino ella había impreso en la semilla, ella caería sin ver el fruto de su sueño. Le apenó dejar al mundo despojado, ya que los brotes aún no habían salido de la tierra y serían tiernos y vulnerables a cualquier tipo de daño. Ella halló en su bolsa de semillas una última simiente que no había encontrado durante la siembra. Entonces dijo una sola palabra a la semilla y la tragó mientras caía. Su inmenso cuerpo descomponiéndose durante el largo invierno, se convertiría en el humus que alimentaría a los plantones en primavera. Y en la mañana del equinoccio vernal, antes de que el resto del bosque hubiera empezado a despertar, esa última semilla maduró y rompió en un instante. De ella nació Nature's Prophet, en todo su esplendor, fuerte y sabio, poseyendo el poder de Verodicia de prever dónde sería más necesitado en defensa de los verdes parajes y cualquiera podría ser lo bastante afortunado de llamarlo aliado.";
                        break;
                    case "texto2":
                        hist = "De los vastos restos de Verodicia el Profeta de la Naturaleza brota en plenitud, haciendo rodar la gran rueda de la vida una vez más. Con la previsión de velar por las creaciones de su diosa y el poder de protegerla en tiempos de necesidad el hijo predilecto de Verodicia preserva su vida y todas sus creaciones para no dilapidar nunca el sacrificio predestinado, aunque desinteresado, que su diosa padeció con gran dolor.";
                        break;
                    case "texto3":
                        hist = "El Profeta de la Naturaleza fue convocado al lado de la antigua guardiana del bosque Virga Truebark cuando ésta desafió al Príncipe de Hierro. Juntos, los guardianes de la naturaleza lucharon codo con codo contra su adversario común. El resultado de esta lucha es actualmente desconocido.\n" +
                                "\n" +
                                "El héroe de las tierras fluviales Castor Twin-Tusks desafió al profeta elegido por Verodicia a un duelo arcano. Castor perdió tanto el duelo como su vida.";
                        break;
                    case "texto4":
                        hist = "La disposición del Profeta es como la de la Naturaleza. A partes iguales, la naturaleza es bondadosa e implacable.\n" +
                                "\n" +
                                "A veces, el Profeta puede ser pacífico y gentil, pero aquellos que no ven el otro lado de la Naturaleza aprenderán que no es ajeno a la violencia. Encarnando la mitad violenta de la Naturaleza es feroz, salvaje y castigador si es necesario.\n" +
                                "\n" +
                                "El Profeta es sabio. Se dice que posee una sabiduría vetusta y la sabiduría del juicio.\n" +
                                "\n" +
                                "Incluso como avatar de la diosa del bosque, el Profeta ejerce ocasionalmente la modestia con su apariencia.";
                        break;
                    case "texto5":
                        hist = "Al igual que la diosa que lo engendró, el dominio del Profeta es el bosque salvaje. Es el protector incondicional de todo lo que es natural, su vigilancia sobre el bosque se ve reforzada por la previsión que le dio Verodicia. El Profeta no sólo es centinela de la flora sino también de todas las bestias y pájaros. Manteniendo su influencia en la vida de la diosa, el Profeta se siente orgulloso de ser el primero en brotar antes que el resto de la flora sagrada.\n" +
                                "\n" +
                                "También tiene hermanos, entre los que se encuentra un grupo de treants con forma de ciervo y cuatro patas, afines a Enchantress. Estos ágiles treants, al igual que el Profeta, son uno de los primeros nacidos del Yermo y han estado con él desde tiempos inmemoriales.\n" +
                                "\n" +
                                "Además de ser un guardián de la naturaleza, también gobierna su bosque como un líder sabio. Gobierna la tierra con una corona de cuernos reales afilados con la sabiduría del juicio.\n" +
                                "\n" +
                                "A juzgar por el nombre, el Profeta puede ser un guardián de las tribus que habitan en el bosque profundo. A diferencia de sus primos de leche estos hombres son primarios, impulsados por el instinto y la voluntad de sobrevivir. Invocan al panteón de la naturaleza, que está desprovisto de dioses gentiles. La tradición mencionada y el diseño de inspiración celta de los brazaletes del Profeta pueden sugerir que estos hombres salvajes son antiguos druidas del bosque.\n" +
                                "\n" +
                                "El Profeta es uno de los muchos Héroes que Earth Spirit reúne para defender las tierras de su planeta. Estos guardianes son los siguientes: Enchantress, Lone Druid y Ulfsaar. Esto parece sugerir que hay una facción oculta que se dedica a la defensa de toda la naturaleza. Kaolin, cuyo espíritu es uno con el planeta incluso después de haber sido separado de él, afirma que él y los espíritus del Profeta son iguales.\n" +
                                "\n" +
                                "Profundizando en esta relación, Kaolín afirma que el Profeta debe venerarlo y que el profeta de Verodicia es también su mayor profeta.\n" +
                                "Al igual que el Profeta, Kaolín está consagrado a una diosa de la que se dice que cuida toda la vida. También es interesante que algunas de las runas que deja el rastro del libro de la rueda de Kaolín son las mismas que las runas del hechizo Brote del Profeta.\n" +
                                "Sin embargo, estas runas son en realidad activos reutilizados que también se encuentran en el Maledict y Death Ward de Witch Doctor, la Mano de Dios de Chen, los Glifos de la Confusión, utilizados por Vanessa, etc. Es posible que estos hechizos que utilizan las mismas runas impliquen un sistema mágico universal, o simplemente activos reutilizados.\n" +
                                "Cuando Verodicia expiró su enorme cuerpo se descompuso durante el largo invierno y se convirtió en humus. Es posible que, con los restos de la diosa del bosque, que ahora se ha fusionado con la tierra, Kaolin luche ahora en honor de toda la Tierra, lo que incluye a la propia Verodicia.\n" +
                                "\n" +
                                "Junto a Treant Protector, el Profeta es el orgullo de Verodicia. A pesar de su relación el Profeta no dice nada amistoso a Rooftrellen hasta el punto de salirse completamente del personaje. En la otra rama, Rooftrellen lo llama \"arbolito\" cada vez que se encuentra con él, probablemente porque Rooftrellen lo trata como su hermano menor aunque el Profeta es mayor que él ya que fue la primera semilla del bosque de Verodicia en crecer.\n" +
                                "\n" +
                                "Es interesante observar que ambos llevan tablillas rúnicas con una estética similar (tablillas oscuras sujetas con cuerda e inscritas con runas azules) si no runas similares.\n" +
                                "\n" +
                                "Como compañero guardián de la Naturaleza, el Lone Druid está en buena relación con el Profeta. Esto es evidente en el hecho de que Sylla se sentirá confundido y traicionado si el Profeta lo ataca o lo mata. Sylla le dice al Profeta que, independientemente de su poder o estación, incluso él debe respetar su misión de plantar la Semilla, insinuando además la importancia de su misión incluso para las fuerzas de la naturaleza.\n" +
                                "\n" +
                                "La generosidad de la Naturaleza se sustenta y fortalece gracias a las bendiciones de la Tierra, donde tiene sus raíces. Así, Earthshaker y el Profeta se llevan bien, el primero respeta al Profeta incluso en su muerte. Estos dos comparten una comprensión común de un tema desconocido que no todos los seres consiguen.\n" +
                                "\n" +
                                "El Profeta de la Naturaleza intentó una vez reclutar a Hoodwink en su afiliación de guardianes de la naturaleza pero el bribón solitario rechazó su oferta, negándose también a recibir órdenes de él.\n" +
                                "\n" +
                                "Aparentemente, Windranger se arrepiente de haber matado al Profeta ya que sabe que es el hijo de Verodicia, lo que da a entender que estaban en buenos términos entre ellos.\n" +
                                "\n" +
                                "Al igual que el Profeta, Drow Ranger valora el bosque y hace su hogar en él, incluso lo reclama como su dominio personal. Por ello puede pedir la ayuda del Profeta para reclamar el bosque. A veces cree que ella es la elegida del bosque más que el Profeta. Sin embargo, desde que se puso la Máscara de la Locur no le gusta que el Profeta la siga.\n" +
                                "\n" +
                                "En algún momento, el Profeta luchó lealmente junto a Virga Truebark contra el Príncipe de Hierro.\n" +
                                "\n" +
                                "Enno puede llamar al Profeta de la Naturaleza como uno de los muchos Héroes aliados que pueden ayudarle a reclamar la Espira Blanca sin líder.\n" +
                                "\n" +
                                "El Profeta está mal dispuesto hacia los Keen y su S.O.L.K. porque su ciencia es una plaga y una afrenta a la Naturaleza. Expresa sus hostilidades específicamente hacia Timbersaw y Tinker. Estos dos Keenfolk comparten también los mismos sentimientos.\n" +
                                "\n" +
                                "Rechaza la presencia de Venomancer y sus Plague Wards en su bosque, ya que son una plaga antinatural para la naturaleza.";
                        break;
                    case "frase":
                        hist = "\"Desperté dentro de la semilla para ver mi destino... y muchos fueron sus ramas\"";
                        break;
                }
                break;

            case "Rotund'jere":

                switch(tipo) {

                    case "texto1":
                        hist = "En tiempos de una gran plaga, un monje de intenciones oscuras llamado Rotund'jere se vio ascendido al rango de cardenal por la repentina muerte de todos sus superiores. Mientras otros miembros de la orden salían a socorrer a los enfermos, el recién ordenado cardenal se recluía en la Catedral de Rumusque, tramando desesperadamente la manera de hacerse con las propiedades de los moribundos nobles, prometiéndoles recompensas espirituales si le cedían sus dominios terrenales. A medida que la plaga empezó a desvanecerse, su comportamiento llamó la atención de la orden superior, la cual le declaró culpable de herejía y lo condenó a servir en la guardia de la plaga, embrujado con hechizos que le asegurarían una enfermedad lenta y prolongada. Pero no contaron con su inmunidad natural. Rotund'jere pilló la viruela, pero en lugar de morir, la enfermedad alimentó su poder, transformándole en un verdadero mago de la plaga, un Papa de la Pestilencia. Haciéndose llamar a sí mismo Necrophos, viaja por el mundo, propagando la plaga dondequiera que vaya y aumentando su terrible poder con cada pueblo que erradica su pestilente presencia.";
                        break;
                    case "texto2":
                        hist = "Rotund'jere fue un papa que sirvió en la catedral de Rumusque, habiendo sido promovido a cardenal con bastante rapidez, para su sorpresa, por la muerte de sus superiores causada por la propagación de la peste en la zona.\n" +
                                "\n" +
                                "En lugar de ir con sus compañeros papas y otros miembros de la iglesia, Rotund'jere maquinó para adquirir riquezas engañando a nobles y otros civiles sin saberlo para que le dieran sus riquezas y objetos de valor a cambio de recompensas espirituales. Incluso después de su transformación en Necrophos parece que sigue difundiendo falsas promesas y predica en las zonas que visita a veces recibiendo valiosos objetos físicos o a veces las propias personas plagadas, ofreciéndole sus vidas para que las coseche, posiblemente para facilitar la transición a través de la muerte o la salvación.\n" +
                                "\n" +
                                "Dado su estado de plaga pero no de muerte, Necrophos puede estar realmente al borde de estar vivo y muerto siendo capaz de cruzar hacia y desde cualquier estado usando las almas de sus víctimas.\n" +
                                "\n" +
                                "Rotund'jere tiene una guadaña hecha para él por un herrero nigromántico creada a base de martillear almas torturadas para darles forma y obediencia.\n" +
                                "\n" +
                                "Rotund'jere puede tener preferencia por usar herramientas hechas de Piedra Diabólica ya que se dice que son ligeras y fáciles de contrarrestar, ideales para crear guadañas.\n" +
                                "\n" +
                                "A pesar de su aspecto marchito y su personalidad más bien oscura, Rotund'jere afirma ser siempre bastante alegre.\n" +
                                "\n" +
                                "Parece tener un afecto bastante fuerte hacia Pudge, siempre halagando su trabajo, incluso cuando es un enemigo, mostrando placer cuando los dos están en el mismo equipo y siendo incapaz de odiarlo a pesar de todo.\n" +
                                "\n" +
                                "Por otro lado parece tener un fuerte desprecio hacia Omniknight, afirmando que es \"demasiado limpio\".\n" +
                                "\n" +
                                "Parece llamarse a sí mismo a través de múltiples títulos, incluyendo \"Necrófago\", \"Mago de la Plaga\", \"Papa de la Pestilencia\" y el \"Pudor Oscuro\".\n" +
                                "\n" +
                                "Rotund'jere es buscado como criminal por Lady Onshu.";
                        break;
                    case "texto3":
                        hist = "Donte Panlin está disgustado por las acciones de Rotund'jere, y ha jurado derrotarlo.";
                        break;
                    case "frase":
                        hist = "\"He aquí el Papa de la Pestilencia\"";
                        break;
                }
                break;

            case "Balanar":

                switch(tipo) {

                    case "texto1":
                        hist = "Sobre Balanar, el Acechador Nocturno (Night Stalker), no hay historia, solo leyendas. En todas las razas y culturas existen relatos ancestrales de una época imposible antes de la luz del sol y del día, cuando solo la noche reinaba y el mundo estaba dominado por las criaturas de la oscuridad, criaturas como el Acechador Nocturno.\n" +
                                "\n" +
                                "Se dice que en los albores del Primer Día, todas las criaturas de la noche perecieron. Todas, claro está, salvo una. Como la encarnación del mal que es, Balanar disfruta con su malevolencia. Él creó el rol del Terror Nocturno, el Hombre del Saco. Siempre que haya jovencitos, él será el espectro invocado para asustarles; papel que disfruta interpretando de forma teatral. Como su propio nombre indica, acecha a los incautos, los indefensos, aquellos que se alejan de los senderos iluminados o a los que desoyen las advertencias de su comunidad. Night Stalker es la prueba viviente de que todas las peores pesadillas de los niños... son reales.";
                        break;
                    case "texto2":
                        hist = "Balanar, el Acechador Nocturno, es una antigua criatura nocturna que sobrevivió a la diezma de su familia en el Primer Día. Tan antiguo como la oscuridad primordial que precedió a la luz del día, su verdadera historia se ha perdido en el tiempo. Sólo existen relatos apócrifos entretejidos en la tradición de todas las razas y culturas que cuentan la historia de un cazador que acecha en las horas de oscuridad, invocado por las viejas historias de los ancianos para asustar a los jóvenes para que se comporten bien.\n" +
                                "\n" +
                                "Aquellos que se atreven a desafiar estas advertencias o a enfrentarse a sus miedos sólo reciben su muerte, un testimonio del hecho de que Balanar no es una personificación abstracta fabricada por los ancianos para advertir a sus jóvenes, sino un ser real de carne y hueso y que el propio Balanar creó ese papel sólo por el hecho de hacerlo.\n" +
                                "\n" +
                                "Cuando el mundo apenas estaba iluminado por el jinete de la Luz, existía un periodo en el que la mañana nunca llegaba y los días eran conocidos como noches. En este estado perpetuo de umbra, las criaturas de las tinieblas reinaban sin oposición sobre el mundo. Poco después los pioneros entre las presas de estas bestias llegaron a adorar a sus amos, forjando armaduras y regalia para honrar su magnificencia. Balanar fue uno de los pocos de estos maestros a los que sus presas regalaron regalia, lo que significaba que era una figura muy poderosa entre las criaturas de la oscuridad.\n" +
                                "\n" +
                                "Pero pronto estas grandes criaturas no reinaron sin rival ni tuvieron ninguna impunidad. Se encontraron en conflicto con los ejércitos de los Hijos de la Luz, que tomaron el manto del Guardián para llevar la luz a todos los rincones del universo, mientras tenían su propio objetivo de purgar el cosmos de todas las criaturas de la noche primordial. Uno de sus heraldos, Valora la Dawnbreaker también entró en conflicto con estas criaturas.\n" +
                                "\n" +
                                "En el amanecer del Primer Día, todas las criaturas nocturnas perecieron. Balanar sobrevivió a este ataque gracias a la gran cantidad de oscuridad que residía en su corazón y que le permitió mantenerse durante la luz del día (pero en un estado debilitado), lo que le convirtió en el único superviviente del evento. Ahora desempeña el papel del Terror Nocturno, el cazador, castigando con la muerte a quienes ignoran los cuentos y las advertencias de sus comunidades, acechando a los incautos y desprevenidos, e infundiendo miedo a generaciones de familias y sociedades con su mera existencia.";
                        break;
                    case "texto3":
                        hist = "En algún momento, definitivamente después de la erradicación de su familia, Balanar fue capturado y atado por la Orden de Ra'hul con cadenas malditas que, según se decía, harían que su poder ancestral se desvaneciera.\n" +
                                "\n" +
                                "Aunque la Orden tuvo éxito en un principio, su prisionero escapó cuando cayó la noche, devolviendo al Acechador Nocturno todo su poder y permitiéndole liberarse, posiblemente masacrando a la Orden en el proceso.";
                        break;
                    case "texto4":
                        hist = "Balanar no participa en ninguno de los eventos de Artifact, pero el arte de las cartas lo representa atacando a Enchantress en un bosque oscuro.";
                        break;
                    case "texto5":
                        hist = "Balanar es una criatura malévola. Parece disfrutar del papel de Terror Nocturno o cazador que le otorgaron muchas poblaciones temerosas, aunque el Acechador Nocturno simplemente mata a otros para su sustento.\n" +
                                "\n" +
                                "Como corresponde a alguien con un poder inmenso, Balanar es un ser señorial. Antes de que el Primer Día extinguiera a sus congéneres las criaturas a las que prestaba atención llegaron a adorarle y crearon galas que simbolizaban su magnificencia. También le desagradan los que pretenden tener más autoridad o favor sobre la noche o la luna.";
                        break;
                    case "texto6":
                        hist = "Void Spirit es el superior de Balanar. Lo que ambos tienen en común son sus poderes sobre el vacío y la sombra.\n" +
                                "\n" +
                                "Como criatura de la noche, Balanar debe ser hostil hacia los Hijos de la Luz y sus creaciones, incluido Dawnbreaker. Esta progenie estelar envió muchos ejércitos para purgar el cosmos de todas las criaturas de la noche primordial lo que probablemente dio lugar al evento catastrófico conocido como el Primer Día que mató a todas las criaturas nocturnas.";
                        break;
                    case "frase":
                        hist = "\"Yo alimento la oscuridad y la oscuridad me alimenta\"";
                        break;
                }
                break;

            case "Nyx Assassin":

                switch(tipo) {

                    case "texto1":
                        hist = "En lo profundo del Archivo de Ultimyr, guardado entre tratados académicos sobre cladística dragón y libros de hechizos intraducibles, existe un antiguo tomo de curiosidades entomológicas. Elaborado por eruditos, el libro describe los talentos telepáticos del escarabajo devoto, una extraña clase de insecto social con habilidades únicas en todos los siete planos.\n" +
                                "\n" +
                                "A diferencia de la mayoría de larvas de su colonia, Nyx Assassin no surgió de la metamorfosis con los típicos pensamientos laboriosos y apéndices embotados de la casta trabajadora de su especie. La suya fue una transformación especial, guiada por la gracia de Nyx. Él era el elegido, seleccionado entre muchos y ungido con un extracto de la propia reina diosa. No todos sobreviven a la oscura bendición de la cámara de la reina, pero él emergió con una mente penetrante y garras como dagas. Sus afiladas mandíbulas rastrillaban el aire mientras que sus pensamientos se proyectaban directamente en las mentes de quienes lo rodeaban. De todos los escarabajos devotos, solo él fue elegido para la más alta vocación. Tras su metamorfosis renació, por la gracia de Nyx, con habilidades que lo moldearon para nada más que una cosa: matar en nombre de su diosa.";
                        break;
                    case "texto2":
                        hist = "Nyx Assassin y los escarabajos zealot en general fueron descritos en un libro de entomología de los Archivos de Ultimyr.\n" +
                                "\n" +
                                "Nyx Assassin vive en la Colmena Oculta.\n" +
                                "\n" +
                                "Nyx Assassin puede proyectar sus pensamientos en los que le rodean, así como escuchar los pensamientos de los demás. Utiliza esta habilidad para cazar enemigos cercanos y para comunicarse.\n" +
                                "\n" +
                                "Los pensamientos de Nyx Assassin entran en las mentes de los demás de forma sutil.\n" +
                                "\n" +
                                "Entre los escarabajos zealt, los Asesinos de Nyx se consideran una casta aparte y pueden estar representados por más de un miembro a la vez.\n" +
                                "\n" +
                                "Nyx Assassin no acepta sobornos.\n" +
                                "\n" +
                                "Nyx Assassin cree que los seres sin armadura o exoesqueleto no son dignos de vivir.\n" +
                                "\n" +
                                "Nyx Assassin tiene un caparazón especial, resistente a la magia, que fue el resultado de siete temporadas de muda, crecido con la ayuda de sustancias alquímicas.\n" +
                                "\n" +
                                "Nyx Assassin a veces imbuye sus garras con veneno contra enemigos misteriosos, cuya única debilidad es ese veneno.\n" +
                                "\n" +
                                "Nyx Assassin ha recibido el Orbe Sagrado de Nyx, que amplía sus habilidades para rastrear objetivos.\n" +
                                "\n" +
                                "Nyx Assassin pertenece a la secta de Kaktos.\n" +
                                "\n" +
                                "Al parecer Nyx Assassin desprende un olor agradable, al menos para Donte.";
                        break;
                    case "texto3":
                        hist = "El actual Nyx Assassin detesta a Abaddon desde el nacimiento de su casta única. Asimismo, parece que Abaddon ha derrotado a anteriores emisarios enviados por Nyx.\n" +
                                "\n" +
                                "Broodmother se ha comido a varios escarabajos zealot, compañeros de Nyx Assassin.\n" +
                                "\n" +
                                "Según Lanaya, los Ocultos también están interesados en reclutar a Nyx Assassin. Los Ocultos también están interesados en sus talentos y consideran un desperdicio matarlo.";
                        break;
                    case "frase":
                        hist = "\"La bendición de Nyx me da todo el propósito que necesito\"";
                        break;
                }
                break;

            case "Aggron Stonebreak":

                switch(tipo) {

                    case "texto1":
                        hist = "El ogro común es la criatura a partir de la cual se creó la expresión «Más tonto que las piedras». En su estado natural, un ogro es sumamente incapaz de hacer o decidir nada. Sin más vestimenta que la suciedad en sus cuerpos, a veces se encuentra envuelto en pieles de animales tras devorar sus despojos. Al ser una criatura poco sociable, se le suele encontrar confraternizando cariñosamente con rocas o tocones que haya confundido por los de su especie (lo que puede explicar la baja tasa de reproducción del ogro). Sin embargo, más o menos una vez por generación, la raza de los ogros es bendecida con el nacimiento de un Mago Ogro (Ogre Magi) bicéfalo, al que inmediatamente se le otorga el nombre tradicional de Aggron Quiebrapiedras, el nombre del primer y tal vez único ogro inteligente en la historia de su estirpe.\n" +
                                "\n" +
                                "Con dos cabezas, Ogre Magi es capaz de operar a un nivel al que otras criaturas llegan con solo una. Y a pesar de que Ogre Magi no pueda ganar discusiones (ni consigo mismo), tiene un don divino conocido como la suerte del necio, una tendencia a tener inauditas rachas de suerte que le han permitido a la raza de los ogros prosperar a pesar de los enemigos, las severas condiciones meteorológicas y la incapacidad para alimentarse a sí misma. Es como si la Diosa de la Suerte, sintiendo lástima por esta especie tristemente inepta, estuviera velando por Ogre Magi. ¿Y quién podría culparla? Pobrecitos.";
                        break;
                    case "texto2":
                        hist = "Por razones desconocidas, la Diosa de la Suerte encomendó a Aggron la vigilancia de una bandada de Alondras de Fuego. Uno de estos pájaros, Flockheart, consiguió separarse de la bandada y acabó siendo la montura de Aggron.";
                        break;
                    case "frase":
                        hist = "\"¡Una vez no es suficiente!\" \"Tantascomo podamos contar\"";
                        break;
                }
                break;

            case "Purist Thunderwrath":

                switch(tipo) {

                    case "texto1":
                        hist = "Purist Furiatrueno era un duro luchador con mucho camino recorrido y un caballero profundamente comprometido, habiendo jurado obediencia a la orden en la que había crecido como escudero de caballeros veteranos de gran reputación. Había pasado la vida entera al servicio de la Omnisciencia, La Que Todo lo Ve. La de ellos era una sagrada lucha y tan arraigada estaba en él su labor, que nunca la cuestionó mientras tuvo fuerza para combatir y el impetuoso valor de la juventud. Pero los largos años de la cruzada iban pasando, cuando sus mayores pasaban a mejor vida y eran enterrados en penosas tumbas a los lados de caminos embarrados, cuando sus hermanos caían en combate contra ignorantes criaturas que se negaban a someterse a la Omnisciencia, cuando sus propios escuderos eran aniquilados por emboscadas, plagas y agua no potable, empezó a cuestionarse el significado de sus votos y el de toda la cruzada.\n" +
                                "\n" +
                                "Tras una profunda meditación, partió con su ejército y comenzó un largo camino de vuelta hacia los acantilados llenos de cuevas de Emauracus, y allí desafió a los sacerdotes de la Omnisciencia. Ningún caballero los había cuestionado antes y ellos intentaron arrojarlo al foso de los sacrificios, pero Purist no se inmutó, ya que cuando les plantó cara empezó a brillar con una luz sagrada y ellos se dieron cuenta de que la Omnisciencia había decidido mostrarse a él. El Anciano Hierofante le condujo durante semanas en un viaje hacia las profundidades, hasta llegar a la más profunda y sagrada cámara donde esperaba no un concepto abstracto de sabiduría y descubrimiento, no una reliquia esculpida que requiriese de una inyección de imaginación para creer, sino el Supremo en persona. No se había limitado a habitar esas rocas durante millones de eones; no, Él las había creado.\n" +
                                "\n" +
                                "La Omnisciencia había formado la inmensa capa de mineral que rodeaba el planeta para defenderse de los numerosos terrores del espacio. De esta forma, La Que Todo lo Ve proclamó haber creado el mundo. Dadas las otras verdades reveladas a Purist en ese día, el caballero no tenía razón alguna para refutar la historia. Quizás la Omnisciencia era una mentirosa que se escondía en su profunda prisión de piedra y no la creadora del mundo, pero Omniknight nunca más cuestionó su fe. Su campaña tenía finalmente sentido y no cabe duda de que los gloriosos poderes que atesora y dan a sus acompañantes fuerza en el combate, son reales y van más allá de toda sospecha.";
                        break;
                    case "texto2":
                        hist = "Purist Thunderwrath, the Omniknight, es un celoso cruzado que lucha por su dios, la Omnisciencia. Fuera del combate, Purist también puede ser un Hierofante, un miembro del clero de la Omnisciencia. También es un teólogo que tiene conocimientos sobre muchos dioses fuera del que adora.\n" +
                                "\n" +
                                "Purist es la segunda presa más perseguida del Caballero del Caos, después del Guardián de la Luz.\n" +
                                "\n" +
                                "Al igual que otros clérigos de la Omnisciencia, Purist es severo y propenso al proselitismo, discutiendo sin cesar con los incrédulos.\n" +
                                "\n" +
                                "Purista posee un casco encantado forjado y usado por los primeros caballeros que fueron bendecidos por la Omnisciencia.\n" +
                                "\n" +
                                "Omniknight posee el Martillo de la Catarata, un martillo de guerra sagrado ungido por el que todo lo ve para reforzar a su portador y a sus aliados.";
                        break;
                    case "texto3":
                        hist = "Presintiendo que un poderoso y oculto mal se agita en la guerra entre Stonehall y la Niebla Roja, Purist buscó a Luna de Dark Moon para formar una alianza. Con la fuerza combinada de sus poderes y sus deidades espera detener a la Corte de Ristul antes de que su poder comience a influir en alguien.";
                        break;
                    case "frase":
                        hist = "\"He mirado a la Omnisciencia, y ella me ha mirado a mí\"";
                        break;
                }
                break;

            case "Nerif":

                switch(tipo) {

                    case "texto1":
                        hist = "Los ascendentes a la Gran Sede de Cymurri habían importado durante eras sus Oráculos exclusivamente del Incubario de Marfil, en lo más alto de las huecas cumbres de la Cordillera de Zealot, con un primer pago realizado en el momento justo de la concepción del embrión y entregando el faltante en el alumbramiento de un profeta maduro y bien entrenado para el Portón del Rey Ídolo.\n" +
                                "\n" +
                                "Criados por las mismas Sibilas Pálidas que procrearon y les dieron a luz, todos los Oráculos sancionados fueron anclados en su forma física al mundo que la mayoría de nosotros compartimos; mientras tanto, sus almas deambulaban muy lejos, apenas atadas por el más liviano de los ombligos astrales. De tales vagabundeos cósmicos volverían los profetas, hablando con palabras de fuego y lenguas de carne. Sus místicas declaraciones se analizaban entre los consejeros Cymurri, quienes encontraron en ellas visiones del futuro, asesoramiento diplomático, toda la munición sobrenatural que necesitaba la dinastía de Reyes Ídolos para asegurar la victoria en cualquier campaña, tanto en la corte como en el campo de batalla. Así fue durante generaciones, con las páginas del Tomo de los Ídolos llenas de los nombres de reyes triunfantes y de los nuevos dominios que habían adquirido. Así fue, esto es, hasta que un Oráculo en particular llamado Nerif llegó para servir al último de todos los reyes con yelmo de piedra.\n" +
                                "\n" +
                                "Desde el primer momento, las profecías de Nerif fueron inusuales. No parecían presagiar meramente el futuro, sino moldearlo. El extraño adivino graznó consejos que nadie había solicitado y, de pronto, los Cymurri se encontraron inmersos en conflictos con enemigos recién descubiertos. Los consejeros, sintiendo una amenaza a su poder, no tardaron en acusar de estos desagradables acontecimientos al último Oráculo. Exigieron su destitución, pidiendo a las Sibilas llevar de vuelta a su profeta defectuoso y reemplazarlo con un sustituto meritorio. Pero Nerif describió un ominoso sueño sobre el cataclismo del Incubario y horas más tarde llegaron noticias de la destrucción de la antigua escuela en una catastrófica avalancha. Temiendo sufrir el mismo destino que las Sibilas Pálidas, los consejeros se retiraron a sus cámaras de consejo, repentinamente ansiosos por evitar la atención del Oráculo.\n" +
                                "\n" +
                                "El Rey Ídolo, sin embargo, era una criatura de gran practicidad. Dudó del compromiso de sus excesivamente prudentes consejeros. Un Oráculo de tal rareza, razonó, debería usarse como arma para extender su dominio. Por tanto degradó a sus tímidos consejeros y colocó a Nerif a su lado. Con solo un pobre entendimiento del talento de Nerif, declaró con valentía los resultados que deseaba y persuadió a Nerif para pronunciar sus deseos en forma de profecías.\n" +
                                "\n" +
                                "Al principio, todo fue bien. El Último de los Reyes Ídolos se jactó de que al adoptar a la mascota del Destino, había hecho del Destino su juguete. Debió tomárselo como una advertencia cuando, en la víspera de la invasión al reino del Sátrapa Insatisfecho, intentó forzar una predicción de una victoria asegurada por parte de su Oráculo, solo para escuchar cómo Nerif murmuró en silencio: «la situación podría tomar un camino u otro». No podía sonsacar una declaración más firme de los labios de Nerif. Aun así, el Rey tenía confianza en su ejército. El Sátrapa estaba rodeado de tierra, pobremente armado y completamente aislado de posibles aliados. Entendió el «la situación podría tomar un camino u otro» como una indicación de que, con el poder táctico de su parte, había poco riesgo en su plan.\n" +
                                "\n" +
                                "Por supuesto, ahora sabemos que debería haberse tomado las palabras del profeta más literalmente. Incluso con el estudio cuidadoso de los Anales Anotados de If, lo que pasó en el campo de batalla frente al palacio del Sátrapa Insatisfecho es casi imposible de visualizar. Parece ser que en mitad de la carnicería, la batalla se empezó a bifurcar. En cada momento crucial, la realidad se abrió y se rompió en pedazos. ////// Los soldados que se tambalearon y cayeron en la batalla también se mantuvieron firmes, avanzando para luchar. Sus mentes también se dividieron; los guerreros se encontraron vivos y muertos, existentes e inexistentes. La victoria y la derrota se dividieron, de modo que ambos ejércitos experimentaron simultáneamente cada resultado por separado. El universo se convirtió en una sala de espejos, con todos los espejos rompiéndose sin cesar.\n" +
                                "\n" +
                                "El efecto inmediato en ambas partes fue la locura. Incapaz de comprender el estado de triunfo y derrota, la mente del Rey Graven se dispersó en motas de locura. Al ingenuo sátrapa no le fue mejor. Las realidades emparejadas opuestas continuaron dividiéndose y dividiéndose nuevamente, resonando en infinitas historias, todas ellas pobladas por una población desconcertada que pronto perdió la capacidad de alimentarse, vestirse, defenderse o reproducirse de la manera tradicional.\n" +
                                "\n" +
                                "Sin embargo, mucho antes de que se presentaran las repercusiones, los cautelosos Consejeros de Cymurri agarraron a Nerif, lo ataron y amordazaron, y lo lanzaron fuera de su universo a gran velocidad en una barca dimensional, con la esperanza de depositarlo donde no pudiera hacerles daño. para siempre. Era, por supuesto, demasiado tarde para ellos. Y bien puede ser para nosotros.";
                        break;
                    case "texto2":
                        hist = "Del caos y la causalidad Nerif, el Oráculo, emerge de otro universo para participar en la batalla de los Ancestros. Nada será inamovible pues incluso el destino deja de ser seguro cuando él doblega la suerte y la causalidad con fines insospechados que pueden beneficiar o perjudicar a cualquier bando.\n" +
                                "\n" +
                                "Este extraño ser alienígena procede de otro universo cuyos habitantes lo han exiliado por razones que es mejor no conocer para no ser infligidos por el mismo miedo que consumió a sus predecesores. Para aquellos que estén dispuestos a escuchar su historia prepárense para escuchar la historia del gran profeta cuyas profecías pueden ser ciertas pero sus intenciones no lo son.";
                        break;
                    case "texto3":
                        hist = "Durante mucho tiempo, los herederos de la Gran Sede de Cymurri se apoyaron en los Oráculos, importados exclusivamente de la antigua escuela del Incubario de Marfil, situada en lo alto de las cumbres huecas de la Cordillera del Zelote. A pesar de esta poderosa y mística ventaja de tener la previsión a su lado tal poder tiene un precio monetario. El pago inicial se realizaba en el momento en que se desarrollaba el embrión de un Oráculo y el saldo restante se pagaba cuando se entregaba un Oráculo maduro y bien entrenado a la Puerta del Rey Esculpido.\n" +
                                "\n" +
                                "En el Incubarium de Marfil, los Oráculos se crían y nacen de las Sibilas Pálidas, que los crían y entrenan hasta que alcanzan su plenitud. Utilizando sus formas físicas como anclaje en el plano material, sus almas vagaban lejos mientras seguían atadas por el más débil lazo astral. Al regresar de sus vagabundeos cósmicos informaban con expresiones místicas que eran analizadas por los Consejeros Cymurri, quienes encontraban en ellas visiones del futuro y consejos diplomáticos. Estas profecías eran un poderoso recurso que el linaje de los Reyes Graven utilizaba para asegurar la victoria en cada campaña en la corte o en el campo de batalla, llenando las páginas del tomo Graven con los nombres de los reyes exitosos y los dominios que habían capturado. Esta tendencia persistiría hasta que cierto Oráculo llamado Nerif escribió la última página para significar el fin de los reyes con casco de piedra.\n" +
                                "\n" +
                                "Al principio las profecías de Nerif eran inusuales. La mayoría de los oráculos hablan de lo que ven en el futuro pero Nerif hablaba del futuro como si lo estuviera moldeando con sus palabras. Pronunció consejos que nadie pidió y de repente los Cymurri se encontraron en conflicto con nuevos enemigos. Sintiendo una amenaza a su poder los Cymurri culparon a Nerif y exigieron su destitución. Apelaron a las Sibilas para que sustituyeran a su defectuoso profeta por un sustituto digno. Pero Nerif presagió un sueño ominoso de la destrucción del Incubarium y la noticia de su destrucción en una avalancha llegó unas horas después. Temiendo correr la misma suerte que las Sibilas Pálidas y su escuela, los Consejeros Cymurri se retiraron a sus cámaras de consejo, lejos del aviso del presagio.\n" +
                                "\n" +
                                "Pero el Rey Graven en funciones era una persona práctica y oportunista. Mientras que sus consejeros veían malas noticias y la posibilidad de realizarlas, el Rey Graven sólo veía oportunidades en este extraño augur. Un Oráculo de tal rareza, razonó, debería ser utilizado como arma para ampliar sus dominios. De ahí que degradara a sus consejeros y colocara a Nerif a su lado. Con un conocimiento superficial de su poder persuadió a Nerif para que expresara sus deseos en forma de profecía.\n" +
                                "\n" +
                                "Al principio todo iba bien. Se jactó de que, al adoptar la mascota del Destino, había convertido al propio Destino en un juguete. Debió tomarlo como una advertencia cuando en vísperas de su invasión en el reino del Sátrapa Insaciable, Nerif murmuró en voz baja \"Podría ir en cualquier dirección\" cuando el Rey de los Grifos le obligó a hacer una predicción de victoria segura. El Rey no podía forzar nada más allá de eso pero sin embargo confiaba en su ejército. La Satrapía no tenía salida al mar, estaba mal armada y se había alejado de todos los posibles aliados. Pensó que su profecía significaba que con el poder táctico de su lado había poco riesgo en su plan.\n" +
                                "\n" +
                                "Tal vez el Rey Graven debería haber tomado las palabras del profeta más literalmente pero sabiendo lo que había sucedido después eso no cambiaría nada. Incluso estudiando detenidamente los Anales Anotados lo que ocurrió en el campo de batalla ante el palacio del sátrapa era imposible de visualizar. En medio de la escaramuza, Nerif había dividido literalmente la realidad, dividiendo cada momento de la batalla en dos desenlaces mientras se desarrollaban. Los soldados que se tambaleaban y caían en la batalla también se encontraban impávidos y capaces de luchar y seguían adelante con la batalla. Incluso sus mentes se dividieron en dos, ya que todos experimentaron el estado de estar vivos y muertos, existentes e inexistentes, triunfantes y derrotados.\n" +
                                "\n" +
                                "El Rey Graven, el Sátrapa Insaciable y sus dos fuerzas no podían comprender una situación paradójica y todos cayeron en la locura mientras el universo se convertía en una sala de espejos que reflejaba el resultado alternativo de cada momento, rompiéndose sin cesar en más fragmentos de reflejo. Las realidades opuestas pero emparejadas siguieron dividiéndose y volviéndose a dividir, haciéndose eco en continuos infinitos, todos ellos poblados por una población que pronto perdió la capacidad de alimentarse, vestirse, defenderse o reproducirse de la manera tradicional.\n" +
                                "\n" +
                                "Pero antes de que las repercusiones pudieran producirse, los cautelosos Consejeros Cymurri habían apresado a Nerif, lo ataron y sellaron su boca, antes de colocarlo en una barca dimensional que fue lanzada fuera de su universo a gran velocidad, con la esperanza de poder desterrarlo a un lugar donde no pudiera dañar a nadie para siempre. Por supuesto fue demasiado tarde para ellos. Y ahora que su barca lo ha traído de algún modo a nuestro universo es muy posible que sea para nosotros.";
                        break;
                    case "texto4":
                        hist = "Una asesina solitaria se acerca a un edificio situado entre las paredes de un valle. La oscura figura salta de cornisa en cornisa mientras se abre paso en el establecimiento. De acuerdo con su lista siempre cambiante, salta sobre un guardia desprevenido pero no perdona a los demás mientras atraviesa una enorme puerta.\n" +
                                "\n" +
                                "El intruso se revela como Phantom Assassin, que ha venido a matar a Nerif para las Hermanas del Velo. Nerif pronuncia su nombre prohibido mientras se burla de su falta de perspectiva, para sorpresa de su posible asesino. Luego le cuenta las muchas posibilidades que ha visto de este encuentro y concluye con la única cosa que todas tienen en común: ella nunca ha sabido por qué fue enviada aquí para empezar.\n" +
                                "\n" +
                                "Mortred hace callar al adivino mientras le pone una daga en el cuello y le asegura que tiene un nombre que borrar de su lista, que es todo lo que necesita saber. Impasible, Nerif le dice que le falta algo evidente en su negativa a matarlo. Algo la retiene y la carcome: aunque sus asesinatos han moldeado el mundo que la rodea nunca ha conocido las consecuencias más allá de ellos y cómo han moldeado también el mundo. Obligado, Mortred le pregunta sobre las verdades que podría decirle y el adivino responde con una sonrisa en el rostro.\n" +
                                "\n" +
                                "\"Todo... si lo deseas. Pero antes, un favor\".\n" +
                                "\n" +
                                "Nerif se vuelve de espaldas y revela una proyección de las múltiples líneas temporales de la realidad. Explica que, en lugar de ver los patrones de las estrellas como meras formas de animales o figuras, ve las constelaciones estelares del cielo como un patrón de líneas de tiempo. Para él estas líneas de tiempo son profecías que presagian su muerte en caso de que se produzca. Aunque ha muerto en muchas líneas temporales ha prestado atención a aquellas en las que sus asesinos han demostrado ser las némesis más letales para él a lo largo del tiempo.\n" +
                                "\n" +
                                "Antes de que pueda terminar su explicación, Mortred hace saber que quiere a estas personas muertas. Habiendo llegado a un acuerdo, Nerif materializa la Paradoja Múltiple en sus manos y se la confía para que la ayude en su contrato. A continuación, ella inspecciona con curiosidad la hoja.";
                        break;
                    case "texto5":
                        hist = "Nerif no participa en ninguno de los acontecimientos de Artifact pero es mencionado por Ish'Kafel. Al enterarse de las habilidades de precognición del Oráculo, lo busca como un poderoso aliado o un enemigo contra el que vale la pena probar sus habilidades";
                        break;
                    case "texto6":
                        hist = "Nerif no interviene en ninguno de los acontecimientos de Dragon's Blood. Hace una breve aparición física al principio del primer episodio y continúa narrando la introducción cuando está fuera de la pantalla. En ella presenta al espectador los orígenes del universo Dota, el Caos del Infinito, la introducción de las Piedras Némesis y el plan de Terrorblade para rehacer la creación.\n" +
                                "\n" +
                                "Transcripción\n" +
                                "\"Al principio, sólo existía la Mente Primordial. De esta mente surgió toda la creación. Las estrellas, los planetas, la vida y la muerte. Pero con el tiempo, la Mente se dividió contra sí misma. Dos fragmentos, Radiant y Dire, el pensamiento y la acción, se disputaron la creación con una ferocidad irreconciliable. Le siguió el Cao Infinito.\n" +
                                "\n" +
                                "Reyes, reinas. Dioses. Monstruos. Todos buscaban la sabiduría en la destrozada Mente Primordial y el poder de su inefable locura. Pero en su prisión de Foulfell, el demonio Terrorblade contempló el caos y encontró la Verdad. Terrorblade encontró la idea. Fusionar el pensamiento y la acción. Rehacer la creación a su propia imagen infernal\".";
                        break;
                    case "texto7":
                        hist = "En la línea de tiempo de Artifact, Dark Seer ha oído hablar de este extraño hablador pero aún no lo ha conocido. Ish'Kafel ha oído decir que tiene la capacidad de ver todas las posibilidades, un don que cualquier practicante del azar codiciaría. Si esto es cierto debe buscarlo como un poderoso aliado, o al menos como un digno enemigo contra el que vale la pena poner a prueba sus habilidades de predicción.\n" +
                                "\n" +
                                "Aunque ha visto su muerte en manos de Phantom Assassin a través de un océano de posibilidades, ha conseguido convencer a Mortred de que se ponga de su lado con respuestas que puede necesitar saber. Haciendo un trato con su antigua asesina, Nerif la ha obligado a cumplir un contrato, dándole un par de cuchillas de corte de realidad para que la ayude a cumplirlo. Quién sabe con qué podría recompensarla Nerif a cambio de matar a sus némesis...";
                        break;
                    case "frase":
                        hist = "\"Tengo un final en mente para ti\"";
                        break;
                }
                break;

            case "Harbinger":

                switch(tipo) {

                    case "texto1":
                        hist = "Como miembro de una raza magistral y señorial, Harbinger merodea la frontera del Vacío, siendo el único centinela superviviente de un puesto avanzado en el mundo al borde del abismo. Desde este cristalino e irregular Mundo Exterior, siempre en guardia, ha observado los cielos durante una eternidad, atento a cualquier perturbación en la infinita noche más allá de las estrellas. Grabado profundamente en el brillante entramado de su intelecto yace un patrón resonante semejante a una profecía, una melodía oscura implicando que llegará el momento en que un mal despertará ahí fuera, más allá de los límites de la creación, y dirigirá su atención hacia nuestro mundo. Con todo su ser centrado en su vigilia, el Destructor del Mundo Exterior (Outworld Destroyer) prestó poca atención a los eventos más cercanos al sol. Pero finalmente la llamada de los Ancestrales y una sensación de una amenaza creciente tanto desde dentro como desde fuera, le obligó a viajar hacia el sol para visitar los planos de la guerra. El papel de Harbinger entre nuestras propias profecías es inequívoco: debe ser considerado un presagio de cosas peores que todavía están por venir. Pero su llegada en sí ya significa algo malo.";
                        break;
                    case "texto2":
                        hist = "Harbinger, el Destructor de Mundos (o Devorador de Mundos Exteriores), un inquietante visitante de nuestro reino procedente de la oscuridad exterior, llega a nuestro mundo para traer noticias oscuras y presagios inamovibles que sólo él podría evitar. Procede del Mundo en el Borde, una fortaleza cristalina que flota en el frío espacio sin nombre entre las estrellas y los planetas. Aunque es muy poderoso e intimidante por sí mismo, no es más que un presagio de cosas peores que esperan a toda la creación.\n" +
                                "\n" +
                                "Harbinger es el único miembro superviviente de una raza magistral sin nombre, cuyo único miembro restante se ha sentenciado a sí mismo a una vigilia eterna en un mirador conocido como el Outworld. En esta fortaleza cristalina, Harbinger anticipa el mal que se predijo en la música profética de su mente, cuyos ritmos implican que eventualmente este mal de los bordes de la realidad despertará y dirigirá su atención a nuestro mundo con una intención inefable pero ciertamente oscura. Harbinger prestó poca atención a los acontecimientos en todo el sistema solar que contiene el planeta que alberga a los Ancestros en guerra, pero una sensación en el borde de su conciencia le dice que la propia guerra de los Ancestros podría servir como catalizador de una fuerza más oscura que bien podría ser el mismo mal que ha estado anticipando durante eternidades.\n" +
                                "\n" +
                                "Aunque una vez trivializó esta guerra, un cambio de opinión le ha enviado hacia el planeta mundano para acabar con el conflicto entre ambos Ancestros con la esperanza de que al menos este mal pueda ser evitado por el momento. Pero su llegada no debe ser anunciada como una presencia mesiánica sino más bien como un presagio explícito con advertencias y malas noticias que esperan a quienes necesitan oírlas, es decir, a toda la existencia.";
                        break;
                    case "texto3":
                        hist = "En las profundidades del frío espacio entre las estrellas y los planetas, Harbinger ha anticipado el ascenso al poder de Kanna y la incorporación de Earthshaker como su campeón. Sin embargo lo que no percibe es su aceptación de la guía de una figura de autoridad ya que ha renegado de su madre. Y así va, con sus alas pétreas en alto, hacia el cuerpo celestial que alberga a los Ancestros en guerra. Se alinea con las hordas de los Dire y se presenta como el mayordomo de Kanna, llenando el vacío que dejó su madre. Poco sabe ella que Harbinger ya ha puesto la piedra angular de su eterna servidumbre hacia él. Y nada puede prepararlos para lo que él planea hacer con ella a continuación...";
                        break;
                    case "texto4":
                        hist = "Como encarnación de un presagio y como alguien que ha previsto lo que traerá Harbinger habla con frecuencia del destino, las profecías y el sombrío futuro que ha previsto.\n" +
                                "\n" +
                                "Dicho esto, también afirma ser indirectamente responsable de sus actos. Al igual que un gato negro, un presagio común y catalizador de la mala suerte, es indirectamente responsable de la mala fortuna que recibirá una persona que se cruce en su camino.\n" +
                                "\n" +
                                "La previsión de Harbinger, su inteligencia ajena y su visión expansiva de la existencia (así como de las cosas malas que le ocurrirán) le han dado una visión muy desconectada de la realidad, al menos desde su perspectiva. Conceptos como la moneda, el sufrimiento de los demás y las guerras terrenales libradas por los Ancestros son insignificantes para él, a menos que Harbinger perciba que hay algo muy preocupante en ellos.\n" +
                                "\n" +
                                "Cuando destruye con éxito a un Ancestro, lo celebrará y dirá que su existencia tiene sentido dando a entender que antes no lo tenía. Es probable que su lúgubre visión de la existencia le haga decir esto ya que sabe que su existencia no tiene ningún sentido porque, finalmente, todo va a llegar a su fin.\n" +
                                "\n" +
                                "Harbinger no tiene reparos en manipular a los demás para sus propios fines. Se une voluntariamente a los Dire como sirviente pero en secreto planea controlar a su líder por razones desconocidas.";
                        break;
                    case "texto5":
                        hist = "Harbinger es uno de los pocos héroes de Dota 2 que tiene un alineamiento inequívoco con un Ancestro y sus ejércitos. En el juego de cartas Artifact, se ha aliado con las fuerzas de Dire incluyendo a personajes como Kanna y Earthshaker que fue reclutado por el primero.\n" +
                                "\n" +
                                "Es natural que un héroe de los Dire tenga mala disposición hacia los Radiant. Harbinger protege a Kanna de su propia madre, Prellex que es una sacerdotisa Radiant. También intenta matarla mientras afirma que su hija tiene razón en algo que ha dicho.";
                        break;
                    case "frase":
                        hist = "\"Su cordura les destrozaré; sus sueños de conquista los destruiré\"";
                        break;
                }
                break;

            case "Donté Panlin":

                switch(tipo) {

                    case "texto1":
                        hist = "\n" +
                                "Los hombres y mujeres que componen Nivan Gallants viven una vida de esgrima, candelabros y romance de mal gusto. Y mientras todos se adhieren a su credo de que \"Una vida de aventura es la única vida que vale la pena vivir\", las hazañas de Donté Panlin aún logran levantar las cejas incluso del más hedonista de los espadachines.\n" +
                                "\n" +
                                "No hay monstruo que no mate. No hay criatura a la que no corteje. No hay tirano al que no se enfrente. Y ningún noble inmune a su lengua de plata.";
                        break;
                    case "texto2":
                        hist = "Donté Panlin es un pícaro amante de la diversión que disfruta con el peligro y la aventura. Miembro de los Galanes de Nivan recorre el mundo en busca de desafíos justos, luchando contra tiranos, matando monstruos mientras reprende a los nobles con su agudo ingenio. Atado al sentido del honor, Donte evita la crueldad, las peleas injustas y meterse con los jóvenes y los discapacitados. Con humor y encanto Donte proyecta una extravagancia con estilo y admira a otros que hacen lo mismo. Ha luchado y ganado muchas batallas, y se ha ganado un grupo de seguidores. Al igual que los de su orden, Donte es aficionado al vino y a los romances fáciles y posee un fuerte sentido de la lealtad y la camaradería con sus hermanos. La vanidad no es poca cosa en la personalidad de Donte que se examina regularmente en el espejo.";
                        break;
                    case "texto3":
                        hist = "Donte Panlin nació en el seno de una familia noble. Como los demás de su raza, está cubierto de escamas, que eran blandas cuando era joven y se endurecieron con el tiempo. Sus escamas son deseadas como un material valioso posiblemente para hacer armaduras.";
                        break;
                    case "texto4":
                        hist = "En su juventud, Donte se unió a los Galanes de Nivan, una orden de espadachines hedonistas dedicados a la aventura y a la lucha contra la injusticia. Tuvo como mentor a Etienne Swiftguard. Mientras los galantes luchaban contra los piromantes del rey Sylak, Étienne fue herido de muerte y, con sus últimas energías, le entregó a Donte su mosquete. Convertido en un miembro de pleno derecho de los galantes, Donte vive por el honor y la antiautoridad, rehuyendo las órdenes de los reyes y prefiriendo la compañía de los plebeyos.\n" +
                                "\n" +
                                "Como se espera de su orden, Donte se comporta con honor caballeresco, renunciando a la crueldad innecesaria siempre que es posible y se opone a la opresión y a la esclavitud. Considera a sus compañeros galantes como hermanos y siente una obligación hacia ellos Al mismo tiempo comparte un sentido de competencia amistosa con sus hermanos intentando superar las hazañas de los demás.";
                        break;
                    case "texto5":
                        hist = "En sus aventuras Donte ha luchado contra tiranos y ha matado a muchos demonios. Una vez intentó matar al mago Vorn pero Azwraith (Phantom Lancer) lo mató antes de que tuviera la oportunidad. Aunque no tiene ningún interés real en el conflicto entre los Ancestros se unió a la batalla por su deseo de gloria y aventura.\n" +
                                "\n" +
                                "Los viajes de Donte le llevan a todas las partes del mundo. Ha llegado hasta Revtel y Qaldin, ha visto las artes de los Cazadores de Marrowfell y una vez rodó en un pozo de basiliscos. Acepta nuevas misiones, prometiendo ayudar a Medusa a encontrar a sus hermanas secuestradas.\n" +
                                "\n" +
                                "Debido a su descaro Donte ha sido considerado un criminal por muchas autoridades aunque nunca ha sido capturado. Sin embargo, considera que las leyes injustas estaban destinadas a romperse, y que sus acciones estaban justificadas. Gondar, que trabaja para una misteriosa figura llamada el Heraldo de Bronce, ha sido enviado para darle caza.";
                        break;
                    case "texto6":
                        hist = "Cuando no está luchando, Donte parece tener aprecio por la buena cocina. Con su agudo sentido del olfato puede distinguir las especias de tierras lejanas. También tiene gusto por los buenos vinos, en particular el Vino Blanco de Icewrack. En su tiempo libre también frecuenta las pistas de carreras de White Spire.\n" +
                                "\n" +
                                "Donte es un mujeriego y ya ha tenido relaciones con mujeres peligrosas. Coquetea abiertamente con todas las heroínas que conoce y llega a pedirle a Razzil que le haga una poción de amor.";
                        break;
                    case "texto7":
                        hist = "Donte conoce a Mireska desde sus primeros días en Revtel y sigue preocupado por ella. Al verla abandonar su hogar por una vida de robos y crímenes intenta convencerla de que tome un camino diferente y le advierte de que se está convirtiendo en alguien como su padre, al que odia. Cuando se entera de que Gondar ha sido enviado a capturar a Mireska le dice que no la dañe y ponga en peligro su futuro. A pesar de ello Mireska odia que la aleccionen y le desprecia por ello.\n" +
                                "\n" +
                                "En el pasado, Donte ha encontrado aliados entre otras figuras justas, como Aiushtha y Ursa. Tiene un lado amable y a menudo actúa como intermediario entre dos partes enfrentadas. Por ejemplo aconseja a Yurnero que se disculpe con Lanaya, su amante despechada y persuade a Lina para que reconcilie sus diferencias con Rylai, su hermana menor.\n" +
                                "\n" +
                                "Ha luchado en numerosos duelos, como contra Sorla Khan de la Niebla Roja y Sun Wukong, al que atravesó con su estoque lanzándoselo mientras estaba transformado en árbol. Rigwarl es uno de los rivales más despreciados de Donte y en una ocasión le cortó las púas en el fragor de la batalla, provocando la huida de Rigwarl.\n" +
                                "\n" +
                                "Pero no todas sus rivalidades se reducen a simples peleas. Donte siente una fuerte aversión por lo malvado y demoníaco y jura acabar con enemigos como Rotund'jere por su papel en el sufrimiento masivo. Aun así, Donte parece misericordioso y dispuesto a dar segundas oportunidades. Ya se ha topado con Lion antes y le ha advertido que si vuelven a encontrarse habrá consecuencias.\n" +
                                "\n" +
                                "Leshrac tiene una historia muy personal con Donte y aunque los detalles no están claros es uno de sus enemigos más odiados. Hace mucho tiempo Leshrac hizo algo a una mujer en la vida de Donte y éste no le ha perdonado desde entonces. En ese momento Donte dejó vivir a Leshrac pero hizo un juramento de matarlo en venganza la próxima vez que lo viera.\n" +
                                "\n" +
                                "Donte parece haber insultado inadvertidamente a Disruptor cuando lo agrupó con los Oglodi de la Niebla Roja, más violentos, y está arrepentido de ello.";
                        break;
                    case "frase":
                        hist = "\"El honorable donté Panlin, a su servicio\"";
                        break;
                }
                break;

            case "Mortred":

                switch(tipo) {

                    case "texto1":
                        hist = "Mediante un proceso de divinidad, algunas niñas son escogidas para formar parte de las Hermanas del Velo, una orden que considera el asesinato una parte sagrada del orden natural. Las Hermanas del Velo identifican a sus objetivos mediante la meditación y las aseveraciones de los oráculos. No aceptan ningún contrato y nunca parecen perseguir objetivos por razones políticas o mercenarias. Sus asesinatos no guardan relación con ninguna agenda reconocible y pueden parecer totalmente aleatorios: Una figura poderosa no tiene más posibilidades de ser eliminada que un campesino o un pocero. Sean cuales sean sus motivos, solo ellas los conocen. Tratan a sus víctimas como sacrificios, y morir en sus manos se considera un honor. Crecen sin ninguna identidad excepto la de su orden, cualquier Phantom Assassin puede tomar el lugar de otra; su número es desconocido. Tal vez son muchas, tal vez muy pocas. No se sabe qué se oculta bajo su fantasmagórico velo. Excepto que esta, de vez en cuando, si no hay nadie cerca que la pueda oír, destapa su velo para dejar salir, en un susurro prohibido, su propio nombre: Mortred.";
                        break;
                    case "texto2":
                        hist = "Entre las Hermanas del Velo, Mortred no es más que una de las varias Asesinas Fantasma.\n" +
                                "\n" +
                                "Mortred aprendió sus técnicas y artes marciales en el campo de pruebas de las Hermanas del Velo.\n" +
                                "\n" +
                                "Al igual que otros Asesinos Fantasma, Mortred recibe órdenes del Oráculo del Velo.\n" +
                                "\n" +
                                "Mireska cree que Mortred está siendo utilizada por las Hermanas del Velo.\n" +
                                "\n" +
                                "Mortred tiene una lista de tareas y objetivos que lleva consigo.\n" +
                                "\n" +
                                "Mortred posee las cuchillas gemelas de Craler, que adquirió de Oracle.\n" +
                                "\n" +
                                "Mortred es conocido a veces como el Espectro Oscuro.\n" +
                                "\n" +
                                "Mortred ha estado en la misteriosa tierra de Lordran.\n" +
                                "\n" +
                                "Mortred posee y lleva el Sello Crepuscular.\n" +
                                "\n" +
                                "Según Sun Wukong, Mortred disfruta matando porque sí.\n" +
                                "\n" +
                                "Mortred lleva una lista de sus objetivos aparentemente con hasta cinco nombres.\n" +
                                "\n" +
                                "Mortred puede haber sido nombrado por el Oráculo del Velo para ser asesinado por otro miembro de su orden.\n" +
                                "\n" +
                                "Mortred tiene alguna afiliación con la Guardia de la Raíz de Sangre, una misteriosa facción presumiblemente dedicada a proteger los Árboles de la Raíz de Sangre y sus terrenos sagrados.\n" +
                                "\n" +
                                "Según Gondar, el cazador de recompensas, los crímenes de Mortred y las formas de las Hermanas del Velo de que la muerte a manos de un Asesino Fantasma sea considerada un honor le han valido una recompensa por su cabeza.\n" +
                                "\n" +
                                "Según Grimstroke, la técnica de Mortred depende demasiado de la suerte y muy poco de la habilidad real.\n" +
                                "\n" +
                                "Según Ostarion, el Rey Espectro, Mortred, las Hermanas del Velo y otros Asesinos Fantasma siguen demasiadas reglas para su gusto y que la única regla que necesitan es la del Rey Espectro.\n" +
                                "\n" +
                                "Krobelus, la Profeta de la Muerte, siempre ve a Mortred muerta en sus profecías.";
                        break;
                    case "frase":
                        hist = "\"Estoy aquí para desdibujar la línea entre la vida y la muerte\"";
                        break;
                }
                break;

            case "Azwraith":

                switch(tipo) {

                    case "texto1":
                        hist = "El remoto pueblo de Pole no tenía conocimiento de las guerras que se libraban en el corazón del reino. Para ellos, la tranquilidad de la pesca submarina y una comida familiar era todo lo que requería una vida plena. Sin embargo, la guerra llegó para ellos, no obstante. El humilde lancero Azwraith se unió a los reclutas sanos que pasaban en fila por sus casas y prometió traer la paz a su reino y, al hacerlo, a su pueblo. Colocado con sus parientes en la vanguardia del asalto final contra el Dread Magus Vorn, el costo para sus compañeros fue absoluto. Mientras la fuerza de carga luchaba hacia la fortaleza, sólo Azwraith entre los de su especie permaneció en pie, y solo él pudo infiltrarse en la fortaleza.\n" +
                                "\n" +
                                "Concentrado y enfurecido por la matanza de sus hermanos, Azwraith superó cada una de las trampas mortales del mago y los guardianes conjurados. Pronto, el simple pescador llegó al santuario de la torre de Vorn. La pareja se batió en duelo durante la noche, pica contra bastón, mientras el caos rugía abajo, y con un grito ensordecedor, Azwraith atravesó a su enemigo. Pero el mago no expiró simplemente; explotó en incontables fragmentos de luz, penetrando a su asesino con poder. Cuando el polvo se asentó y el humo del combate comenzó a disiparse, Azwraith se encontró de pie entre una multitud de sus parientes. Cada uno parecía estar vestido como estaba, cada uno parecía armado como estaba, y podía sentir que cada uno pensaba como lo hacía. Consciente de que sus aliados se acercaban, ordenó a estos fantasmas que se escondieran y uno a uno comenzaron a desvanecerse en la nada. Cuando los soldados llegaron al lugar sagrado, encontraron al guerrero que había vencido al mago. Cuando se acercaron a su campeón, el lancero desapareció. El piquero que se había parado frente a ellos no era más que otro fantasma.";
                        break;
                    case "texto2":
                        hist = "Azwraith es aficionado a dar largos sermones de moral, especialmente a Mireska.\n" +
                                "\n" +
                                "Tras derrotar a Vorn, Azwraith se resiste en volver a Pole, su pueblo natal, aunque sabe que sería bien recibido. Esto se debe a que sabe que la aldea no tendría cabida para sus ilusiones fantasmales.\n" +
                                "\n" +
                                "Azwraith posee una lanza con la punta de un cristal cargado con los enemigos de Vorn, lo que le ayuda a concentrar sus ilusiones en un único propósito.";
                        break;
                    case "texto3":
                        hist = "Azwraith es viejo amigo de Yurnero. Ambos parecen conocer a una misteriosa figura llamada Kanna, por la que Yurnero pregunta.";
                        break;
                    case "frase":
                        hist = "\"Te superamos en número. ¡Los superamos en número a todos!\"";
                        break;
                }
                break;

            case "Phoenix":

                switch(tipo) {

                    case "texto1":
                        hist = "En soledad a través de unas inalteradas tinieblas resplandeció el primer sol del Guardián, un atípico punto de luz consciente destinado a extender calidez por el despoblado vacío. A través de más eones de los que se pueden contar, este astro cegador permaneció fusionando su inconmensurable energía antes de estallar en el cataclismático resplandor de una supernova. De este infierno se engendraron nuevos soles, estrellas de idéntica descendencia que su padre, que erraron por un océano mortecino y se establecieron en forma de constelaciones. Cuando llegase el momento, ellos también se propagarían entre las llamas de las supernovas. Así continuaría repitiéndose este deslumbrante ciclo de nacimiento y renacimiento hasta que todos los cielos tallados con el mayúsculo esfuerzo del Titán se resignaran a titilar y brillar.\n" +
                                "\n" +
                                "Este crisol eterno hizo que la estrella a la que los mortales acabarían nombrando Phoenix colapsara hacia su existencia y, al igual que sus ancestros, fue empujado hacia el interminable cosmos para encontrar un lugar entre sus hermanos estelares. No obstante, la curiosidad hacia aquello que los oscuros ancianos dejaban descansar en las sombras consumió al polluelo, quien decidió dedicar largos ciclos a investigar y estudiar. Aprendió que, entre mundos tanto completos como fragmentados, se revolvería pronto un nexo de una particularidad notable, encerrado en un conflicto imperecedero de consecuencias cósmicas, un plano que se vería necesitado de más influencia de la que pudieran ofrecer los lejanos rayos de un sol moribundo.Y así fue como este joven hijo de los soles adoptó una forma terrenal y viajó con impaciencia para alumbrar con su calor a todos aquellos que más lo necesitaran y, quizás, apoderarse de su propio destino solar.";
                        break;
                    case "texto2":
                        hist = "Bristleback se refiere a Phoenix como un \"elemental\".\n" +
                                "\n" +
                                "A pesar de tener una apariencia y un comportamiento animal, Phoenix es sorprendentemente astuto cuando se trata de comerciar.";
                        break;
                    case "texto3":
                        hist = "Fénix fue el responsable de devolver a la vida a Dawnbreaker después de que la chispa que había en su interior fuera destruida por Io. Cuando Fénix surcó el cosmos, su chispa pasó junto a la fragua solar que contenía su esencia vital, reavivando la chispa de Dawnbreaker.\n" +
                                "\n" +
                                "Phoenix tuvo una vez en su poder las reliquias Forja Solar y el Giro Solar. Perdidas en algún momento, más tarde recuperó la primera reliquia pero la segunda fue desenterrada y encontrada por Mortimer, el sapo dragón de Snapfire. Snapfire se la vendió a Phoenix, de quien se dijo que era \"sorprendentemente astuto\".";
                        break;
                    case "frase":
                        hist = "*Graznido*";
                        break;
                }
                break;

            case "Primal Beast":

                switch(tipo) {

                    case "texto1":
                        hist = "Aunque el deterioro del Bosque Neblinoso y su evolución de una extensión idílica a una maraña salvaje llena de muerte fue un proceso lento impulsado por magos, la mayoría de los eruditos están de acuerdo en que el verdadero principio del fin estuvo marcado por la llegada interdimensional de Primal Beast.\n" +
                                "\n" +
                                "Una criatura nacida en una existencia desprovista de todo sentimiento excepto el hambre y el dolor, eones de carnicería convirtieron a Primal Beast en el máximo depredador de un planeta lleno de terrores violentos. Desterrado desesperadamente por aspirantes a maestros con esperanzas fallidas de controlarlo, Beast fue arrojado a un nuevo mundo, lleno en cambio de blandas criaturas atrapadas en una oposición insignificante, donde pudo ascender de un mero depredador hambriento a una máquina de matar invasiva sin nada que pudiera interponerse en su camino.\n" +
                                "\n" +
                                "Durante miles de años, el Bosque Neblinoso sirvió como terreno masivo para el juego destructivo de Primal Beast, e incluso las temidas duranas se convirtieron en sabrosos bocadillos. De hecho, no podía haber rivales por el territorio de Primal Beast, solo molestias menores. Hasta que una de esas pequeñas molestias empleó un vil engaño para atraparlo en el Gleipnir.\n" +
                                "\n" +
                                "Allí podría haber permanecido, sometido por la eternidad, si no fuera por los poderes impredecibles del Dispositivo del Continuum. Ahora, libre tanto de Gleipnir como de la Bóveda, lejos del Bosque Neblinoso y mucho más cerca de las tierras habitadas, Primal Beast dirige su hocico hacia nuevas matanzas y las delicias de la destrucción salvaje, y los míseros fuegos de la civilización poco podrán hacer para mantener a raya a este monstruo eterno.";
                        break;
                    case "texto2":
                        hist = "Arrancado de su dimensión natal por aquellos que no lograron controlarlo, la Bestia Primigenia llega a nuestro mundo en los asolados Bosques de Niebla como un depredador invasor, trayendo consigo toda la rabia que acumuló durante eones de intentos de subyugación.";
                        break;
                    case "texto3":
                        hist = "La Bestia Primigenia solía ser una criatura tonta que sólo siente hambre y dolor. Tras su destierro y la huida de su prisión, ahora siente placer por la carnicería y la destrucción, así como una rabia desenfrenada.\n" +
                                "\n" +
                                "Aunque los animales suelen dejar en paz a la civilización y a la humanidad cuando no son provocados este no es el caso de la Bestia Primigenia. Aparentemente esta bestia se ha vuelto loca y ahora come todo lo que ve y destruye todo lo que no es comida.\n" +
                                "\n" +
                                "Esta bestia puede tener una mente única cuando caza a su presa ignorando cualquier cosa que se interponga entre él y su única víctima.\n" +
                                "\n" +
                                "Una criatura indómita que ha escapado y resistido todos los intentos de controlarla, la Bestia Primigenia odia ser controlada y no dudará en infligir un castigo por ello.";
                        break;
                    case "frase":
                        hist = "\"Raawr\"";
                        break;
                }
                break;

            case "Puck":

                switch(tipo) {

                    case "texto1":
                        hist = "Aunque Puck puede parecer un personaje travieso e infantil a primera vista, no es más que una máscara que oculta a su verdadero yo: la forma juvenil de un Dragón Feérico, una criatura que vive eones. Puck vive incontables milenios en su forma juvenil. Por tanto, aunque técnicamente es cierto que Puck es joven, continuará siéndolo cuando las ciudades de la época actual se hayan convertido en polvo. Sus motivos son inescrutables, y lo que a primera vista puede parecer un juego, en realidad esconde un propósito mucho más oscuro. Su inagotable sed de travesuras es el auténtico indicador de la verdadera naturaleza de Puck.";
                        break;
                    case "texto2":
                        hist = "Al igual que otros dragones hada, Puck nació en una fronda del Undertree y proviene de una dimensión diferente.\n" +
                                "\n" +
                                "Después de nacer, Puck se comió a todos sus hermanos para alimentarse. Hoy tiene hambre de más.\n" +
                                "\n" +
                                "Las alas de Puck existen, y mudan, en un reino ligeramente desincronizado con el resto de su cuerpo.\n" +
                                "\n" +
                                "Según Alchemist, la sangre de dragónes hada es rara y valiosa para la alquimia.\n" +
                                "\n" +
                                "A Puck parece gustarle el color verde.\n" +
                                "\n" +
                                "Puck ha estado en el reino de Claszureme.\n" +
                                "\n" +
                                "Puck está familiarizado con los Pergaminos de Haize, que establece que su juventud viene con la responsabilidad.\n" +
                                "\n" +
                                "Puck conoce y tiene un conocimiento esotérico de Io y sus tratos, calificando al Fundamental de \"audaz\", y discrepando de la \"alianza\" de Io. Sin embargo Puck afirma que Io presenta un \"argumento convincente\" para la alianza.\n" +
                                "\n" +
                                "Puck conoce a Shendelzare y una vez admiró sus alas.\n" +
                                "\n" +
                                "Puck puede poseer poderes similares a los de Mireska, que es un Fae.\n" +
                                "\n" +
                                "Interfiere con frecuencia en sus actividades criminales, irritándola enormemente. Al igual que Mireska es uno de los pocos que puede entender el discurso de Mercurial lo que indica un vínculo con el Reino de los Fae.";
                        break;
                    case "frase":
                        hist = "\"Me encuentro extrañamente atraído por estas raras actividades\"";
                        break;
                }
                break;

            case "Pudge":

                switch(tipo) {

                    case "texto1":
                        hist = "En los Campos de Matanza Sin Fin, muy al sur de Quoidge, una figura corpulenta trabaja sin descanso durante toda la noche: desmembrando, destripando, amontonando las extremidades y las entrañas de los caídos para que, al amanecer, el campo de batalla esté despejado. En esta tierra maldita, nada puede pudrirse ni descomponerse, ningún cuerpo puede volver de la tierra de donde una vez surgió, sin importar lo profunda que sea la tumba. Rodeado de aves de rapiña que necesitan que corte los cuerpos en pedazos más pequeños, Pudge el Carnicero hace honor a su nombre usando cuchillos que se vuelven más y más afilados con el paso del tiempo. Swish, swish, chop. La carne se separa del hueso, los tendones y ligamentos parte como papel mojado. Y aunque siempre ha sido diestro en el arte de la carnicería, con los años también ha ido desarrollando un gusto por los «productos derivados». Un mordisquito de músculo por aquí, un sorbito de sangre por allá... y al poco tiempo estaba hincando sus mandíbulas en el más duro de los torsos, como un perro desgarrando unos harapos. Aquellos temerosos de la Parca, deberíais estar más asustados por el Carnicero.";
                        break;
                    case "texto2":
                        hist = "Aunque le preguntan a menudo Pudge se niega a responder a cualquier pregunta sobre su familia y se enfada bastante con los extraños curiosos. En su juventud, sirvió al rey Brandalon como su carnicero real. Este fue el comienzo de la carrera de Pudge, que consideró los mejores años de su vida. El reinado del Rey fue particularmente sangriento y Pudge es uno de los pocos que aún están vivos para recordar la carnicería. En algún momento también pasó algún tiempo en una granja.\n" +
                                "\n" +
                                "Pudge es inmune a la mayoría de las formas de deterioro natural. Este rasgo fue buscado por un encantador de Weeping Rose que logró adquirirlo (en forma de esencia de Pudge) por medios desconocidos. Esta esencia se utilizó posteriormente para dar vida al muñeco inanimado de Pudge.\n" +
                                "\n" +
                                "En busca de carne, Pudge viajó a los Campos de la masacre sin fin, donde se cernía sobre los muertos descuartizando y devorando su carne. Por razones desconocidas, abandonó los Campos antes de que los clérigos de Rumusque peregrinaran hasta allí para purgar la tierra.";
                        break;
                    case "texto3":
                        hist = "Pudge es un comedor voraz de carne. Prefiere la carne roja y cruda pero consume casi cualquier tipo de carne, incluso la de sus enemigos caídos. Es tan glotón que una vez se comió un dragón negro. Sigue los pasos de la guerra y mantiene su vientre lleno de carne fresca de los recién asesinados.\n" +
                                "\n" +
                                "De vez en cuando Pudge también come un poco de pescado crudo aunque no lo considera carne \"de verdad\". También le gusta el tuétano pero no le gusta mucho el pollo.\n" +
                                "\n" +
                                "Tiene un gran sentido del olfato, especialmente para la carne. A diferencia de la mayoría de los seres vivos Pudge nunca necesita dormir.";
                        break;
                    case "texto4":
                        hist = "Hace mucho tiempo, las Cadenas de la Abscesión fueron forjadas por el clérigo Rumusque Crella para atar a los súbditos del Dios Muerto. Con el paso del tiempo las Cadenas se corrompieron por el Dirge y cayeron en el poder del Dios Muerto. Se volvieron contra el pueblo de Crella, destruyendo su tierra natal. Desde entonces las Cadenas han adquirido una mente propia, no les gustan los dioses y tienen un hambre especial por el Anti-Mage, probablemente debido a su oposición al Dios Muerto. \n" +
                                "Las Cadenas están familiarizadas con Vrogros, ya que han consumido a sus secuaces anteriormente.\n" +
                                "\n" +
                                "Pudge se encontró con las Cadenas de la Abscesión después de ser desterrado por una razón desconocida. Se encontró en un lugar lleno de muertos y olió algo interesante dentro de una gran grieta en la tierra. Entrando en la grieta Pudge se encontró con las Cadenas de la Abscesión, atraídas allí por las mismas cosas que había olido. Las Cadenas se movieron por sí mismas, volando por el aire y atacaron a Pudge. Finalmente fue capaz de someter a las Cadenas y ponerlas bajo su control. El Dios Muerto considera esto un acto de robo y exige que las Cadenas sean devueltas, llegando a enviar a Pudge carne. Sin embargo, Pudge disfruta de la compañía de las Cadenas y no tiene intención de devolverlas.";
                        break;
                    case "texto5":
                        hist = "En las profundidades de una finca del reino de Krimwohl, una joven nacida en la realeza vivía sola: no tenía figuras paternas, ni tutores, ni sirvientes cerca para atender sus necesidades. Con el tiempo desarrolló una personalidad malvada y escuchó las historias de Pudge, un monstruo inmune a todo tipo de descomposición. Utilizando la gran riqueza y los contactos que tenía a su disposición, llamó a un hechicero de Weeping Rose para que recuperara la esencia de Pudge. El viaje del encantador duró meses y en ese tiempo se fabricó el muñeco de Pudge como recipiente para la esencia.\n" +
                                "\n" +
                                "El hechicero llegó finalmente a Krimwohl con la esencia de Pudge a mano y el muñeco estaba listo para ser imbuido con ella. De la esencia se derivaron marcas arcanas que dieron vida al Carnicero de Juguete. Poco sabían que la inmortalidad e imperecabilidad de Pudge no era el único rasgo que heredaba el muñeco sino que también compartía su voraz apetito así como sus recuerdos, lo que le hacía creer que era un no-muerto que vivía en Quoidge (igual que el propio Pudge).";
                        break;
                    case "texto6":
                        hist = "Pudge tuvo una vez un cerdo de zanja como mascota. Encontró al animal en un montón de carne sacrificada y tuvo que coserle algunas de sus heridas. Era su mejor amigo pero al final se lo comió.";
                        break;
                    case "texto7":
                        hist = "Rubick es el principal rival de Pudge ya que ambos se enfrentaron en un concurso hace tiempo. Sin embargo Pudge considera a Rubick un tipo \"correcto\", aunque lo encuentra un poco extraño.\n" +
                                "\n" +
                                "Pudges conoce a Lady Onshu.\n" +
                                "\n" +
                                "Pudge puede tener una relación especial con Traxex y Slark.\n" +
                                "\n" +
                                "Pudge disfruta trabajando con Atropos.\n" +
                                "\n" +
                                "Pudge dijo una vez algo sobre Riki, posiblemente mientras era invisible, y ahora está avergonzado por ello.\n" +
                                "\n" +
                                "Pudge se comió una vez a uno de los seguidores de Vrogros.\n" +
                                "\n" +
                                "Pudge tiene una relación antagónica con el Dios Muerto a causa del robo de las Cadenas de Abscesión.\n" +
                                "\n" +
                                "Los Gemelos Desollados admiran la espeluznante carnicería de Pudge.";
                        break;
                    case "frase":
                        hist = "\"¡Cuando termine con estas alimañas, estarán listas para un pastel!\"";
                        break;
                }
                break;

            case "Pugna":

                switch(tipo) {

                    case "texto1":
                        hist = "En el reino natal de Pugna, cerca de los respiraderos de los Confines Abisales, se alzaba una lamasería dedicada a las Artes del Olvido, que obtenía su poder de las energías abisales. El Maestro Supremo del templo había pasado al Olvido varios años atrás, dejando su academia sin liderazgo. Desde el momento de la muerte de su maestro, los regentes del templo comenzaron a realizar ritos de divinización para identificar a la reencarnación de su maestro, y finalmente todas las señales convergieron en las inmediaciones. Diversos poblados se alzaban bajos las sombras del templo, sus calles y plazas estaban repletos de risas de chiquillos alborotadores.\n" +
                                "\n" +
                                "Pugna, con apenas trece meses de edad, era uno de los candidatos entre los niños locales, y se presentó en el templo el día señalado junto a otros dos prometedores candidatos. Los lamas ofrecieron un amasijo de reliquias desgastadas a los pequeños, posesiones atesoradas por su antiguo maestro supremo. Uno de los niños se hizo con una varita pórfida que perteneció al lama largo tiempo atrás... y la introdujo por uno de sus orificios nasales. Una niña traviesa se hizo con un amuleto que también había pertenecido al lama e inmediatamente se lo tragó. Pugna miró a los otros dos con expresión divertida, lanzó una alegre carcajada y los abrasó con una lluvia de llamas esmeralda, reduciéndolos a cenizas al instante. A continuación se hizo con la varita y el amuleto y exclamó '¡Mío!' Los regentes levantaron al radiante Pugna sobre sus hombros, lo vistieron con el ornamento de su maestro supremo y se lo llevaron hacia el trono antes de que su humor tuviera ocasión de cambiar. En cinco años, el propio templo ya era otra montaña de cenizas, lo que complació sobremanera a Pugna.";
                        break;
                    case "texto2":
                        hist = "Procedente de los Confines del Infierno, Pugna es el último descendiente de un linaje de seres reencarnados que son los mejores practicantes de las Artes del Olvido. Elegido a una tierna edad por los regentes del difunto Gran Maestro del Olvido para determinar la próxima reencarnación de su maestro, no perdió tiempo ni esfuerzo en mostrar su habilidad innata para manejar el poder del Olvido y del Reino del Infierno, lo que le permitió acceder al trono de su predecesor.\n" +
                                "\n" +
                                "Habiendo crecido más poderoso que su anterior encarnación a medida que aprendía más magia oscura en su academia y envejecía, ahora esgrime las llamas esmeralda de los Reinos de las Tinieblas y el poder del Olvido con un efecto indiscriminado: incinerando a quien quiera, convirtiendo sus creaciones en cenizas y robando lo que quiera de quien se digne a observar.";
                        break;
                    case "texto3":
                        hist = "Cuando era un ser anciano, Pugna capturó a un malévolo netherdrake llamado Viper de las cavernas luminosas de los Confines del Infierno, donde los dragones tóxicos prosperaron durante millones de años. El sádico mago esperaba domar a esta bestia lanzando encadenamientos y hechizos oscuros para que se sometiera a él. Lo que no sabía era que el netherdrake se sometía intencionadamente a su magia y a sus ataduras: el netherdrake esperaba aprender las prácticas de su maestro. Durante la esclavitud de Viper, Pugna también practicaba el arte del aumento mágico que Viper observaba con gran interés.\n" +
                                "\n" +
                                "Viper pronto aprendería que algunos de los sortilegios de su maestro eran mortales para él por lo que buscó un escape inmediato. Exudando un ácido que derritió los barrotes de su jaula se liberó y escupió veneno en los ojos de Pugna antes de escapar de su prisión. En cuanto a Pugna, parece que ha sobrevivido a ser envenenado por la criatura más tóxica que existe lo que puede ser la razón por la que se convirtió en un esqueleto. Además de sus otros objetivos nefastos ahora busca recuperar a su mascota perdida, Viper.";
                        break;
                    case "texto4":
                        hist = "Pugna no tenía ningún interés en la batalla entre la Niebla Roja y Stonehall ni tenía ninguna influencia significativa en ella. En su lugar, se enfrenta al Estado de Tyler y al Quórum como un ejército de un solo mago contra las fuerzas que pretenden controlar la magia, antes de poner finalmente su mirada en Rosa Llorona cuando ambos han sido reducidos a cenizas.";
                        break;
                    case "frase":
                        hist = "\"¿Quién necesita una espada cuando tienes a Oblivion?\"";
                        break;
                }
                break;

            case "Akasha":

                switch(tipo) {

                    case "texto1":
                        hist = "El Rey Eclesiasta de Elze abrigaba un deseo por el dolor... el dolor prohibido. En una figura menos prominente a nivel político, este tipo de deseos se podrían considerar inapropiados. Sin embargo, para un monarca de su importancia, la satisfacción de tales deseos habría amenazado la virtud del mismísimo Trono Divino. Así pues se retiró a su mazmorra llena de demonólogos, prometiendo la libertad a quien lograse invocar y ligar totalmente a su servicio a un súcubo de tormento personal. La criatura que llegó, llamada Akasha, realizó para él unos tormentos tan exquisitos que él la designó su Reina Secreta. A partir de ese momento dedicó cada minuto libre del que disponía a someterse a sus deliciosos tormentos, llegando incluso a abdicar de todas sus responsabilidades para disfrutar de los placeres más dolorosos que solo ella le podía proporcionar. Queen of Pain lo podía llevar al borde de la muerte, sin embargo la runa a la que estaba ligada lo obligaba a mantenerlo con vida. Finalmente, el estado de abandono del Rey provocó una revuelta. Fue arrastrado desde su habitación y arrojado desde lo alto de la Torre de las Invocaciones. En el momento de su muerte, Queen of Pain accedió al mundo, libre de su esclavitud... libre para infligir sus tormentos a quien se le antojara.\n";
                        break;
                    case "frase":
                        hist = "\"Dicen que todo el dolor está en la mente pero se equivocan: todo está en mis manos\"";
                        break;
                }
                break;

            case "Razor":

                switch(tipo) {

                    case "texto1":
                        hist = "De entre todos los poderes emblemáticos que pueblan el Mundo Espectral, Razor, el Espectro del Rayo, es uno de los más temidos. Con su látigo eléctrico, patrulla el Laberinto Angosto, una red de serpenteantes pasajes donde las almas de los muertos son clasificadas según su inteligencia innata, su astucia y su persistencia. De vez en cuando, mientras deambula por la parte superior del laberinto, Razor posa su vista sobre las perplejas almas que se encuentran abajo y las azota con un relámpago abrasador para castigarlas y, al mismo tiempo, apremiarlas para que decidan sus propios destinos mientras se dirigen apresuradamente hacia luminosas salidas u oscuros abismos sin fondo. Razor es la encarnación de una fuerza dominante, abstracta y casi impasible cuando se trata de aplicar su poder. Aun así, tiene cierto aire señorial que sugiere que obtiene una sardónica satisfacción de su trabajo.";
                        break;
                    case "texto2":
                        hist = "azor tiene acceso y añade nombres en el Libro de los Muertos.\n" +
                                "\n" +
                                "El rival más antiguo de Razor es Storm Spirit, que probablemente data de una época anterior a la fusión de Raijin con Thunderkeg.Esta rivalidad podría deberse a que Razor roba las energías de muchas tormentas, elemento que representa Storm Spirit.\n" +
                                "\n" +
                                "Razor parece ser capaz de cambiar su apariencia y varios testigos lo describen de forma diferente.\n" +
                                "\n" +
                                "Mars describe a Razor como un burócrata aburrido.";
                        break;
                    case "frase":
                        hist = "\"Traigo mi látigo relámpago no para castigar a las almas sino solo para apresurarlas hacia la salida inevitable\"";
                        break;
                }
                break;

            case "Riki":

                switch(tipo) {

                    case "texto1":
                        hist = "Riki fue el segundo de tres hijos en la gran dinastía de Tahlin. Con un hermano mayor heredero al trono y uno más pequeño mimado y consentido, Riki, al ser el mediano, parecía elegido para el arte de la invisibilidad. Fue un arte que cultivó y que llegó a salvar su vida la noche en que su gente fue traicionada y su familia masacrada. De toda la descendencia real, él fue el único que escapó... pequeño, ágil, sin pretensiones, utilizando el humo como camuflaje. Logró desenvolverse en el duro mundo exterior utilizando la ventaja de la sorpresa, cortando en silencio el cuello de los guerreros enemigos, uno tras otro. Ahora, liberado de sus responsabilidades reales, Riki utiliza sus talentos para su nueva vocación: Asesino Sigiloso. Silencia a sus enemigos y mejora sus habilidades con la esperanza de vengarse algún día de aquellos que asesinaron a su familia y le robaron lo que le pertenecía por derecho de nacimiento.";
                        break;
                    case "texto2":
                        hist = "Antes de escapar de los terrenos reales, Riki cogió una de las dagas utilizadas para matar a su padre. Ahora la utiliza contra sus enemigos.\n" +
                                "\n" +
                                "Riki se disfrazó de miembro de la guardia real de Tahlin para poder escapar.\n" +
                                "\n" +
                                "Riki tiene en su poder la corona dañada de su madre (la reina).\n" +
                                "\n" +
                                "Riki acepta contratos, pero no da reembolsos.\n" +
                                "\n" +
                                "Riki posee las dagas ancestrales de su casa.\n" +
                                "\n" +
                                "Riki puede ser miembro de la Orden de los Rompe-espadas.\n" +
                                "\n" +
                                "La tierra natal de Riki, sin nombre, es conocida por sus fragantes especias.";
                        break;
                    case "texto3":
                        hist = "Junto con Mireska Riki se asoció en su día con el Círculo de Jasper. Es probable que se haya unido a la asociación mientras que Mireska decidió seguir su camino por separado. Debido a esto Mireska siente que se han distanciado. Riki conoce a Lorlin Lasan, otro miembro del Círculo de Jasper.";
                        break;
                    case "frase":
                        hist = "\"No hay nadie tan apuñalado como el que no quiere ver\"";
                        break;
                }
                break;

            case "Rubick":

                switch(tipo) {

                    case "texto1":
                        hist = "Cualquier mago puede lanzar un hechizo o dos, y algunos puede que incluso estudien lo suficiente como para convertirse en brujos, pero solo a los más talentosos se les permite ser reconocidos como Magus. Sin embargo, como en cualquier círculo de hechiceros, el sentido de comunidad nunca garantiza que la competencia sea cortés.\n" +
                                "\n" +
                                "Aun siendo ya un duelista de renombre y un erudito del grandioso mundo de la hechicería, a Rubick nunca se le había pasado por la cabeza que quizá tuviera madera para ser un Magus hasta encontrarse en mitad de su séptimo intento de asesinato. Mientras lanzaba sin demasiada dificultad al duodécimo de una sarta de supuestos asesinos desde un alto balcón, cayó en la cuenta de cuán poco imaginativos se habían vuelto los atentados contra su vida. Donde antes el sonido de un chasquido de dedos o una mano envuelta en llamas le hubieran hecho dar saltos de alegría, ahora todo se había vuelto muy predecible. Ansiaba tener una competencia mayor. Por eso, enfundándose su máscara de combate, hizo lo que cualquier brujo que quisiera ascender de rango haría: anunció sus intenciones de matar a un Magus.\n" +
                                "\n" +
                                "Pero Rubick no tardó en descubrir que el amenazar a un Magus supone amenazarlos a todos, y todos ellos le correspondieron con contundencia. Cada encantamiento enemigo era un torrente imparable de energía y cada ataque un golpe letal bien calculado. Pero en seguida ocurrió algo que los enemigos de Rubick no esperaban: sus artes parecían volverse contra ellos. En medio de esa trifulca mágica, Rubick reía entre dientes, leyendo y replicando sutilmente los poderes de uno para lanzarlos contra otro, sembrando el caos entre los que se habían aliado en su contra. Empezaron a oírse acusaciones de traición y al poco los hechiceros se volvieron los unos contra los otros sin sospechar quién estaba detrás de su perdición.\n" +
                                "\n" +
                                "Cuando la batalla concluyó finalmente, todos se encontraban abrasados y congelados, empapados, cortados y perforados. Más de uno yacía muerto por las artes de un aliado. Rubick permanecía aparte, dolorido pero deleitado con el espectáculo. Nadie tuvo las fuerzas para discutir cuando presentó su petición de asunción al Consejo Oculto, y todos los Once Insustanciales convinieron en concederle el título de Gran Magus.";
                        break;
                    case "texto2":
                        hist = "Mireska desea los secretos de Aghanim que cree que están sellados dentro del báculo de Rubick.\n" +
                                "\n" +
                                "Según Meepo Rubick posee muchas gemas mágicas que Meepo codicia. También le ofrece a Rubick venderle más gemas.";
                        break;
                    case "texto3":
                        hist = "En algún momento, Rubick capturó un misterioso rompecabezas llamado Puzzle of Perplex en un bastón especial. Ha pasado sus momentos de ocio intentando descifrar este misterioso rompecabezas, pero no ha podido resolverlo por sí mismo. De vez en cuando lanza este rompecabezas a un enemigo con la esperanza de obtener información de sus inútiles intentos de resolverlo mientras se quedan embobados con sus hipnotizantes mecanismos.\n" +
                                "\n" +
                                "Cuando Rubick descubrió el quid de este rompecabezas encontró un truco \"sorprendentemente sencillo\" que le permitiría manipular el espacio cuatridimensional para afectar a la realidad que le rodeaba. Pero incluso después de hacerlo, se dio cuenta de que el conocimiento que había en el corazón de este rompecabezas también le permitiría alterar los propios fundamentos de la magia. Ya no depende de los hechizos de otros ahora juega con los límites del arte arcano, remodelando y revelando el inexplorado mundo de la magia a su gusto.";
                        break;
                    case "texto4":
                        hist = "Rubick es el hijo de Aghanim, el dueño del legendario Cetro de Aghanim. Lucha por estar a la altura de la fama de su padre viviendo a la sombra de sus logros en el mundo de la magia y hasta ahora no lo ha conseguido.\n" +
                                "\n" +
                                "Pudge es el principal rival de Rubick ya que ambos se enfrentaron en un concurso hace mucho tiempo. Sin embargo, Pudge considera a Rubick un tipo \"correcto\", aunque lo encuentra un poco extraño.";
                        break;
                    case "frase":
                        hist = "\"Ninguna hechicería está más allá de mi alcance\"";
                        break;
                }
                break;

            case "Cryxalis":

                switch(tipo) {

                    case "texto1":
                        hist = "Las arenas de los Páramos Centelleantes están vivas y sienten. Todo el desierto conversa consigo mismo, ideando pensamientos que solo una tierra tan extensa podría concebir. Pero cuando tiene que comunicarse con aquellos más estrechos de miras, libera un fragmento de sí mismo y rellena un caparazón de armadura mágica creada por el ingenioso Djinn de Qaldin. Esta identidad esencial se hace llamar Crixalis, «Hijo de las Arenas», pero otros le conocen como Sand King. Sand King tiene la forma de un gran arácnido, creado a imagen y semejanza de la feroz naturaleza que caracteriza a los pequeños pero ubicuos habitantes de los Páramos Centelleantes. Guardián, guerrero, embajador... Sand King es todo eso y uno con el interminable desierto que le dio la vida.";
                        break;
                    case "frase":
                        hist = "\"Te mostraré el miedo en un puñado de arena...\"";
                        break;
                }
                break;

            case "shadow Demon":

                switch(tipo) {

                    case "texto1":
                        hist = "Entre los demonios soberanos con acceso explícito a este mundo, Doom raramente se molesta con los asuntos de los no-infernales o los consortes espectrales menores, mientras que Shadow Fiend pasa de forma casi exclusiva para realizar expediciones recolectoras. Sin embargo, el Demonio de las Sombras (Shadow Demon) siempre ha tenido un profundo y constante interés en el plano material, como si sintiera que el control de este arenoso nexo dimensional pudiera ser la clave para el dominio total de todas las realidades.\n" +
                                "\n" +
                                "Invocado originalmente por magos menores, Shadow Demon concedió cada deseo y demostró su poder de una forma cada vez más impresionante, hasta que obtuvo la atención de los más grandes demonólogos y, a través de ellos, la de varios líderes, tiranos, autarcas y hierofantes que dependían de la brujería para respaldar su mundano poder. Tan grande fue su engaño que todos sus invocadores se creían a sí mismos los amos y a Shadow Demon el sirviente; mientras tanto, él corrompió sus identidades y tomó posesión de sus mentes. Al final, casi todos los miembros del culto eran marionetas huecas, extensiones de su inicua voluntad.\n" +
                                "\n" +
                                "El que hubiera sido el siguiente paso de Shadow Demon permanece abierto a la especulación, porque en aquel momento, Nevermore, el Diablo de las Sombras (Shadow Fiend) degustó un alma particularmente repulsiva y descubrió que no contenía otra cosa que un corazón nauseabundo de la esencia de Shadow Demon. Alertados de que un levantamiento estaba en camino, y de que el antiguo equilibrio del Pacto Oscuro estaba a punto de desestabilizarse, Doom y Shadow Fiend unieron fuerzas brevemente para destruir al próspero culto. Combinando hechizos de increíble fuerza, deshicieron siglos del paciente trabajo de Shadow Demon, reduciendo su culto a cenizas y a todos sus miembros a salpicaduras de sangre. No quedó nada excepto un residuo de sombra demoníaca. Inmortal e irreductible, esta mota de mal fue suficiente para alimentar el siguiente plan de Shadow Demon y, poco a poco, varios siglos más tarde, empezó a reorganizarse.\n" +
                                "\n" +
                                "Todo lo que ese resto de sombra tocaba, lo mancillaba, y con ello su influencia creció gradualmente. Una amalgama de elementos dañados se unió, entretejió y combinó para dar a Shadow Demon una forma incluso más fuerte que la anterior. Todavía sigue sin estar completo, y su plan para el dominio infinito carece de sus anteriores debilidades. Parecería que un ser como él, de pura malicia y malevolencia, una amenaza a toda la creación, estaría para siempre fuera de lugar en nuestro mundo... y sin embargo a Shadow Demon no le faltan seguidores.";
                        break;
                    case "texto2":
                        hist = "Al igual que otros demonios, Shadow Demon habla ozkavosh.\n" +
                                "\n" +
                                "Nevermore estuvo una vez al servicio de Shadow Demon, posiblemente por una deuda desconocida.\n" +
                                "\n" +
                                "Shadow Demon emplea regalos y sobornos para conseguir que la gente se una a su culto.";
                        break;
                    case "frase":
                        hist = "\"El que juega con demonios se convertirá en el juguete de ellos\"";
                        break;
                }
                break;

            case "Nevermore":

                switch(tipo) {

                    case "texto1":
                        hist = "Se dice que Nevermore, el Demonio de las Sombras (Shadow Fiend), tiene alma de poeta; de hecho, tiene miles de ellas. Durante los años se ha hecho con las almas de poetas, monjes, emperadores, mendigos, esclavos, filósofos, criminales y, naturalmente, héroes. Ningún tipo de alma se le escapa. Lo que hace con ellas sigue siendo un misterio. Nunca nadie ha visitado el Abismo de donde Nevermore emerge como una anguila de entre rocas astrales. ¿Las devora una tras otra? ¿Las usa para decorar los pasillos de un templo misterioso o las conserva en salmuera nigromántica? ¿Es meramente una marioneta controlada por un titiritero demoníaco a través de la grieta dimensional? Tal es su maldad, tan intensa es su aura de oscuridad que ninguna mente racional puede atravesarla. Claro que si de verdad quieres saber a dónde lleva las almas robadas, hay una forma segura de averiguarlo: añadir tu alma a su colección. O esperar a que él venga a por ti.";
                        break;
                    case "texto2":
                        hist = "Nevermore sirve a un amo sin nombre.\n" +
                                "\n" +
                                "Al igual que otros demonios Nevermore habla ozkavosh.\n" +
                                "\n" +
                                "Nevermore fue quizás una vez gobernado por Lucifer, quien lo mantuvo en un pozo.\n" +
                                "\n" +
                                "Nevermore estuvo una vez al servicio de Shadow Demon, posiblemente debido a una deuda desconocida.\n" +
                                "\n" +
                                "Nevermore consumió una vez las almas de los demonios, que eran tan oscuras y llenas de rabia que lo transformaron por completo.";
                        break;
                    case "texto3":
                        hist = "En la historia de Artifact, Nevermore era el único miembro presente que hablaba en nombre de la Corte de Ristul. Un comandante Vhoul desesperado llamado Rix se acercó a él y le pidió un poder que le permitiera obtener una gran ventaja en su lucha ya que estaban perdiendo la guerra contra la Legión de Bronce. Se llegó a un acuerdo entre ellos y el alma de Rix fue reclamada por Nevermore, convirtiéndolo en una versión demoníaca de sí mismo seguido de sus compañeros Vhoul muertos en Roseleaf reanimados en el mundo material.\n" +
                                "\n" +
                                "Nevermore también tiene un rebaño de discípulos que se asemejan a su forma demoníaca. Al igual que su maestro estos seguidores llevan a cabo su trabajo de hacer tratos con los mortales, normalmente encontrando dicho trabajo en lugares con conflicto y desesperación.";
                        break;
                    case "frase":
                        hist = "\"Entonces, ¿tienes curiosidad de dónde vengo? Hay una manera fácil de averiguarlo por ti mismo\"";
                        break;
                }
                break;

            case "Rhasta":

                switch(tipo) {

                    case "texto1":
                        hist = "Nacido en las Colinas Sangrantes, Rhasta no era más que un chico hambriento cuando fue recogido por un viajero estafador. Por dos piezas de cobre, el viejo estafador te adivinaba el futuro. Por tres, castraba a tu cerdo, por cinco, circuncidaba a tus hijos. Y por una buena comida, se ponía su atuendo de chamán, leía sus viejos libros y desataba una maldición sobre tus enemigos. Su nuevo y extraño jovencito, parte trol de las colinas y parte... otra cosa, trabajó como asistente y le dio un toque exótico al espectáculo del estafador.\n" +
                                "\n" +
                                "Siempre un paso por delante de los estafados y una ciudad por delante de sus perseguidores, estos dos recorrieron mundo hasta que un día el estafador se dio cuenta de que su joven aprendiz podía llegar a hacer lo que él solo simulaba hacer. Su pupilo tenía un don, un don que sus clientes apreciaban. Así pues, el joven Rhasta fue presentado ante el público y fue bautizado como Chamán de las Sombras (Shadow Shaman). Ambos continuaron deambulando de pueblo en pueblo, conjurando por dinero a medida que la reputación de Shadow Shaman iba creciendo. En un momento dado, su oscuro pasado irrumpió con fuerza y un grupo de ex-clientes estafados les tendió una emboscada. El estafador fue asesinado y, por primera vez, Rhasta utilizó sus poderes oscuros, masacrando a los atacantes. Enterró a su adorado maestro y desde entonces utiliza sus poderes para destruir a cualquiera que intente hacerle daño.";
                        break;
                    case "texto2":
                        hist = "Rhasta se considera un intermediario entre los vivos y los muertos así como un \"mensajero de los desaparecidos\". Estas descripciones apuntan a una especie de comunicación con el mundo de los muertos.\n" +
                                "\n" +
                                "Está en comunión con los espíritus de los antepasados, así como con las \"sombras\", que le dirigen a través del mundo y le conceden fuerza.\n" +
                                "\n" +
                                "Rhasta suele cantar en una lengua desconocida.\n" +
                                "\n" +
                                "Rhasta sigue adivinando la suerte como hacía cuando viajaba con su antiguo maestro.\n" +
                                "\n" +
                                "Rhasta hace varias referencias a los tambores incluso escuchando su propio ritmo de tambor personal.\n" +
                                "\n" +
                                "Rhasta tiene conexiones con varias figuras o cultos esotéricos, incluyendo el Tang-Ki y el Eki Bukaw.\n" +
                                "\n" +
                                "Rhasta también conoce un antiguo hechizo para curar el insomnio: convertir a los afligidos en ovejas.\n" +
                                "\n" +
                                "Cuando Rhasta viajaba con su Maestro, deleitaba y conmocionaba a las multitudes con sacudidas de relámpagos, encantaba a peligrosas serpientes y las divertía convirtiéndose él mismo en una gallina al final de cada actuación. Después de que el viejo estafador fuera asesinado convirtió sus trucos mágicos en formas mortales de autodefensa. \n" +
                                "\n" +
                                "También desarrolló un método para sujetar a los enemigos con lazos mágicos.\n" +
                                "\n" +
                                "Rhasta y Slithice son viejos amigos.\n" +
                                "\n" +
                                "Jah'rakal desprecia a Rhasta porque considera que los trolls de las colinas son inferiores a los verdaderos trolls.\n" +
                                "\n" +
                                "Rhasta tiene una relación de negocios con Mireska debido a sus antecedentes como estafadores.";
                        break;
                    case "texto3":
                        hist = "Como los demás chamanes de su época. Rhasta viajaba de ciudad en ciudad vendiendo sus servicios a todo tipo de personas. Pero hacia el final de la Era Sórdida la reputación de los chamanes itinerantes había caído en desgracia. A los magos como Rhasta se les culpaba de las enfermedades y las malas cosechas lo que llevó a su persecución y ejecución. Temiendo por su vida Rhasta ocultó sus poderes chamánicos disfrazándose de vagabundo mientras realizaba los mismos servicios que el viejo estafador. Si alguien le preguntaba por sus habilidades afirmaba que simplemente las había aprendido en el camino como vagabundo. Los consejos de su maestro le acompañaban y llevaba un sombrero de ala ancha así como estandartes a la espalda que mostraban claramente los servicios que ofrecía, en caso de cualquier confusión que pudiera dar lugar a hostilidades con los aldeanos desconfiados. Mientras estaba en el camino preparaba una potente bebida que guardaba en una botella a su lado, tóxica para todos excepto para él.";
                        break;
                    case "texto4":
                        hist = "Los enemigos de Rhasta se acumularon a medida que mataba a sus perseguidores atrayendo a enemigos aún más poderosos que lo buscaban. Para evitar a los suyos se ocultó bajo tierra pero tampoco allí encontró santuario. En su lugar le salió al encuentro Gliss, un señor sacerdote serpiente que deseaba sus poderes e intentó atacarle con una jarra maldita. Rhasta no tuvo más remedio que matar a Gliss y más tarde adquirió el incensario del sacerdote para sí mismo.";
                        break;
                    case "frase":
                        hist = "\"Soy el intermediario entre la vida y la muerte\"";
                        break;
                }
                break;

            case "Nortrom":

                switch(tipo) {

                    case "texto1":
                        hist = "Como parte de la séptima y última generación de un linaje cuidadosamente planeado, Nortrom fue criado por la ancestral orden de los Aeol Drias para convertirse en el mayor usuario de la magia que el mundo había visto jamás. Él fue el profetizado, la culminación de doscientos años de cuidadosos emparejamientos, un mago guerrero que traería la gloria a la orden y la destrucción a sus acérrimos enemigos, los Caballeros del Surco.\n" +
                                "\n" +
                                "Criado junto a otros jóvenes magos en un acantonamiento oculto entre las colinas de los páramos de Hazhadal, los preceptores de la orden esperaron a que las habilidades de Nortrom se manifestasen. Mientras que otros estudiantes perfeccionaban sus talentos con el fuego, el hielo o los hechizos de encantamiento, Nortrom se sentaba en silencio sin mostrar ninguno, incapaz de lanzar hasta el más simple de los conjuros. A medida que se acercaba el día de la prueba final, él aún no había encontrado su magia. Disgustados, sus preceptores le increparon, mientras que los demás niños se rieron de él. «No eres ningún mago», dijo el líder de la orden. Sin embargo, Nortrom no se marchó con el rabo entre las piernas. Llegó al día de la prueba y se enfrentó a los demás magos que se habían burlado de él. Y gracias a esto, sus preceptores aprendieron una valiosa lección: una carencia de magia puede ser la mayor magia de todas. Nortrom silenció a los demás jóvenes magos, uno por uno, y los derrotó en un único combate hasta que solo él quedó campeón de los Aeol Drias, cumpliendo así la profecía.";
                        break;
                    case "texto2":
                        hist = "Según su propia biografía, Nortrom podría ser una persona endogámica o producida por la endogamia.\n" +
                                "\n" +
                                "Tras derrotar a los jóvenes magos el día de su prueba final Nortrom aplicó sus nuevas habilidades en la \"supresión\" de los forajidos impíos de los Barrios de Hazhadal, donde hizo un corto trabajo con sus embelesadores de animales.\n" +
                                "\n" +
                                "En los primeros días de su infancia los cuidadores de Nortrom hablaban con fervor de la profecía que pronto cumpliría y de los benditos favores que todos recibirían el día de la ascensión de Nortrom por criar al profetizado mago de la guerra. Los mismos cuidadores pronto sentirían rencor y abandono por él cuando su falta de magia comenzara a manifestarse sin saber que sus verdaderas habilidades aún no se habían manifestado.\n" +
                                "\n" +
                                "Nortrom maneja varios equipos que ejercen el poder del silencio incluyendo un escudo que desvía la magia sin sonido, otro escudo que emana un aura de calma y quietud que silencia a los enemigos cercanos y un glaive forjado en el corazón de una estrella muerta en un rincón insonoro del universo.\n" +
                                "\n" +
                                "También maneja un glaive y un escudo relacionados con Oscilla. Fue el primero en afirmar que no se trata de meros objetos de poder sino de apéndices astrales de una gran criatura que pueden utilizarse para encontrar sus otras piezas.";
                        break;
                    case "frase":
                        hist = "\"Los enemigos se deben ver y no escuchar\"";
                        break;
                }
                break;

            case "Dragonus":

                switch(tipo) {

                    case "texto1":
                        hist = "Un mago de prestigio en la corte del Nido Espectral, Dragonus vive una existencia conflictiva. Aunque esté comprometido de nacimiento a proteger a quienquiera que se siente en el Nido de Espinas, odia a la reina Furia Celeste actual con toda su alma. En su juventud, siendo un aristócrata, fue amigo y compañero de la mayor de las princesas Furia Celeste, Shendelzare, la primera en la sucesión al Nido. La había amado calurosa e inquebrantablemente, pero en cuanto sus estudios tomaron prioridad, su mente se centró en el estudio de lo arcano y la maestría de la brujería Furia Celeste.\n" +
                                "\n" +
                                "Obsesionado con lo etéreo, pasó por alto las señales mundanas de traición que apuntaban a una conspiración contra Shendelzare y perdió su oportunidad de desbaratarla. Cuando la corte fue golpeada por un rápido y violento golpe de estado, dejó sus estudios solo para darse cuenta de que había perdido a su vieja y querida amiga. El Nido de Espinas pertenecía ahora a la despiadada hermana menor de Shendelzare y Dragonus no podía hacer nada al respecto. La magia de los Furia Celeste solo sirve para proteger a los Furia Celeste, así que ir en contra del Nido sería inútil. Se aferra a su posición, pensando que es su mejor baza si espera algún día devolver a su amor verdadero al lugar que le corresponde. Mientras tanto, solo la diosa Scree'auk conoce su secreto, cuya magia transformó a Shendelzare de una criatura incapacitada a una encarnación de pura energía vengativa.\n" +
                                "\n" +
                                "Aunque sueña con devolver a su amada reina al Nido Espectral, lo hace aún más con restaurar a Shendelzare a una forma física completamente sanada. La duplicidad de su papel en la corte le tortura, ya que es una criatura noble y de buen corazón, pero la peor tortura de todas es imaginarse el odio que Vengeful Spirit le guarda en su corazón.";
                        break;
                    case "texto2":
                        hist = "Mars insinúa que Dragonus puede haber hecho un trato con la diosa Scree'auk a cambio de poder.\n" +
                                "\n" +
                                "Es probable que Dragonus haya hecho el Talon de Scree'auk para Shendelzare.\n" +
                                "\n" +
                                "Terrorblade desprecia a Dragonus porque se parece a un ángel, al mismo tiempo, también cree que Skywrath Mage sería un buen demonio.\n" +
                                "\n" +
                                "Mireska insinúa que Dragonus está siendo utilizado como una marioneta aunque se desconoce por quién.\n" +
                                "\n" +
                                "Dragonus no es del agrado de la actual reina Skywrath.";
                        break;
                    case "frase":
                        hist = "\"Incluso en este campo caído, dedico mis poderes al sublime Skywrath\"";
                        break;
                }
                break;

            case "Slardar":

                switch(tipo) {

                    case "texto1":
                        hist = "Slardar es un Slithereen, uno de los Profundos, guardián de una extensa red de ciudades sumergidas y las riquezas ancestrales allí enterradas. En la oscura sima de los grandes abismos del océano, el Guardián Slithereen patrulla por las secretas salas de tesoros, siempre vigilante ante los ladrones subacuáticos enviados a las profundidades por codiciosos hechiceros de las tierras secas. Es completamente leal, y su naturaleza taciturna esconde un profundo conocimiento de los lugares más secretos del mar. A pesar del dolor que le causa la claridad, emerge al bajío para realizar reconocimientos, asegurarse de que nadie conspira contra las profundidades y, a veces, perseguir implacablemente a los pocos que logran robar alguna pieza del Tesoro Hundido. Al haber pasado toda su vida a gran presión bajo el tremendo peso del mar, Slardar, el Guardián Slithereen, es una criatura de gran poder.";
                        break;
                    case "texto2":
                        hist = "Slardar mató una vez a un Dragón Marino.\n" +
                                "\n" +
                                "Slardar forma parte de la Guardia Slithereen, donde forma parte de la élite de los Centuriones. No sólo eso, es miembro de una división especial llamada El Diluvio, donde tiene el alto rango de Primera Lanza.\n" +
                                "\n" +
                                "Según Alchemist el cuerpo de Slardar contiene mercurio como muchos peces.";
                        break;
                    case "frase":
                        hist = "\"Yo protejo lo que duerme en las profundidades\"";
                        break;
                }
                break;

            case "Slark":

                switch(tipo) {

                    case "texto1":
                        hist = "Prácticamente desconocido por los habitantes del mundo seco, el Arrecife Oscuro es una prisión submarina donde envían a las peores criaturas marinas que hayan cometido crímenes contra los suyos. Es un nido enzarzado lleno de Slithereen asesinos, Profundos traicioneros y merantes sociópatas. En este lúgubre laberinto, patrullado por anguilas y protegido por enormes anémonas, solo los salvajes sobreviven. Encerrado en el Arrecife Oscuro por crímenes desconocidos, Slark pasó media vida sin familia ni amabilidad, sin fiarse de nadie, sobreviviendo mediante una combinación de sigilo y crueldad, guardándose sus pensamientos y sus planes para él. Cuando los Doce Infames del Arrecife Oscuro planearon su desastrosa fuga, mantuvieron sus planes en perfecto secreto, asesinando a cualquiera que empezara a atar cabos; pero de algún modo, Slark descubrió su plan y se procuró un lugar en él. Diez de los doce murieron en el intento de fuga y otros dos fueron capturados y devueltos al Arrecife Oscuro, posteriormente ejecutados para el entretenimiento de los otros presos. Pero Slark, el desconocido decimotercero, aprovechó la conmoción para escabullirse y no ser visto nunca más. Actualmente un residente furtivo de los manglares carnívoros de las regiones al sur de la Costa Sombría, Slark sigue siendo el único fugitivo con éxito del Arrecife Oscuro.";
                        break;
                    case "texto2":
                        hist = "Slark es un Slithereen.\n" +
                                "\n" +
                                "Slark parece despreciar la lucha por las Piedras Némesis llegando a decir que preferiría haberse quedado en Arrecife Oscuro.\n" +
                                "\n" +
                                "Slark está en deuda con un Pacto Oscuro que hizo con los Oscuros.\n" +
                                "\n" +
                                "Slark conoció una vez a otro Slithereen que está cumpliendo una dura condena en el Arrecife Oscuro.\n" +
                                "\n" +
                                "Slark puede haber comido una vez a otro recluso en Arrecife Oscuro.\n" +
                                "\n" +
                                "Slark sufre de putrefacción de las aletas.\n" +
                                "\n" +
                                "Slark puede haberse disfrazado de tiburón cuando escapó de Arrecife Oscuro.\n" +
                                "\n" +
                                "Slark tiene pesadillas sobre estar en un acuario.\n" +
                                "\n" +
                                "Slark visita las grutas ocultas de Crey ya sea como jugador o como luchador en las arenas de deportes de sangre que hay allí.\n" +
                                "\n" +
                                "Slark ha utilizado el caparazón de un Umizar como armadura.\n" +
                                "\n" +
                                "Slark utiliza un pez daga como arma.\n" +
                                "\n" +
                                "En prisión a Slark no le gustaba que le preguntaran dónde guardaba sus armas.\n" +
                                "\n" +
                                "Slark mantenía alijos ocultos antes de entrar en la prisión de Arrecife Oscuro. Durante ese tiempo la mayoría de sus alijos fueron saqueados, a excepción de unos pocos.\n" +
                                "\n" +
                                "Durante su estancia en prisión Slark marcó nuevas tendencias de moda al peinar sus aletas en forma de mohawk.\n" +
                                "\n" +
                                "Cuando Slark se fugó robó varios objetos al director de la prisión, entre ellos una armadura y una preciada daga.\n" +
                                "\n" +
                                "Slark conoce a Slithice. Es un fan de su forma de cantar y probablemente recibió una daga de ella como regalo.\n" +
                                "\n" +
                                "Slark puede tener una relación especial con Traxex y Pudge.";
                        break;
                    case "frase":
                        hist = "Si hubiera sabido que terminaría aquí, me habría quedado en la prisión de Dark Reef\"";
                        break;
                }
                break;

            case "Beatrix Snapfire":

                switch(tipo) {

                    case "texto1":
                        hist = "Beatrix Snapfire y su sapo dragón, Mortimer, están bien vistos por la gente andrajosa que subsiste a lo largo de las rutas del desierto y de los oasis desperdigados por Nanarak, el paso abandonado por la lluvia hacia las Tierras Lejanas.\n" +
                                "\n" +
                                "Tan conocida por sus habilidades para fabricar armas como por la generosidad de su sabiduría, su hilaridad y por las galletas rompedoras más malvadas que el mundo nunca probó, Bea sobrevivió a una edad madura adulta en el joven comercio de los ingeniosos siendo rápida con su ingenio y aún más rápida con sus armas.\n" +
                                "\n" +
                                "No hay duda de que las Tierras Lejanas están llenas de los huesos de bandidos y malandrines que creyeron que podían aprovecharse de su baja estatura y su propensión benevolente.";
                        break;
                    case "texto2":
                        hist = "Beatrix Snapfire es una entusiasta que vive en las regiones desérticas cercanas a las Tierras Exteriores (Outlands). Conocida como Beadie por sus amigos, cabalga por las tierras áridas sobre Mortimer, su fiel sapo dragón. Beatrix, que en su día fue miembro de una banda, pasó su juventud cometiendo actos desagradables pero desde entonces se ha marchado para vivir por su cuenta. Con una habilidad natural para la herrería se arma con un arsenal de armas, teniendo siempre a su lado a Ol' Rackatee, su fiel escopeta. Aparte de la herrería, Beatrix se deleita horneando galletas aunque nunca comparte su receta secreta.";
                        break;
                    case "texto3":
                        hist = "Beatrix proviene de una familia keen y tiene varias hermanas, una de las cuales es la madre de Rizzrack, lo que la convierte en tía de Rizzrack. A diferencia de sus hermanas, no tiene hijos propios.\n" +
                                "\n" +
                                "Cuando era niña su padre le enseñó a pescar con dinamita. Parece que vivió cerca de otros keen como Kardel y Rattletrap.";
                        break;
                    case "texto4":
                        hist = "En su juventud Beatrix causó grandes problemas entre los guardianes con los que vivía lo que le valió el rencor de otros como Kardel y Rattletrap. Se escapó en una pequeña aventura planeando volver al cabo de unos meses. Pero su escapada se convirtió en varios años y se vio obligada a huir al Pantano del Terror por un malentendido para escapar de sus perseguidores. Después de salir del pantano decidió no volver a casa, ya que había ido demasiado lejos.\n" +
                                "\n" +
                                "Al llegar a las tierras exteriores se encontró desesperada y sola por lo que  recurrió a la fabricación de armas para venderlas a la gente de la zona. Su experiencia en la fabricación de armas hizo que sus productos fueran muy valiosos. Esta actividad pronto la llevó a unirse a una banda. La banda duró muchos años, durante los cuales Beatrix continuó suministrando armas a personajes desagradables incluido el reino de Krimwohl (cuya población fue responsable de la destrucción del hogar de Hoodwink), donde vendió su pólvora a sus habitantes. Ya no habla mucho de aquellos días y prefiere mantenerlo así.";
                        break;
                    case "texto5":
                        hist = "Durante su estancia con la pandilla Beatrix encontró un bebé sapo dragón no más grande que su mano. Como broma, lo llamó Mortimer. Su pandilla bromeó diciendo que ella era su madre y el grupo consideró seriamente la posibilidad de comerse a Mortimer cuando éste creciera[15].\n" +
                                "\n" +
                                "Beatrix se encariñó con Mortimer, y cuando dejó la banda él se fue con ella. Espera que le sobreviva y que encuentre un nuevo compañero en el futuro.";
                        break;
                    case "texto6":
                        hist = "Al regresar a su ciudad natal Beatrix descubre que su hermana, que se había establecido originalmente en el Valle del Augurio, ha fallecido mientras ella no estaba. Observa que el hijo de su hermana, Rizzrack, todavía está por aquí pero algo traumatizado. Los más viejos aún recuerdan las cosas que hizo de joven y todavía le tienen miedo. Al ver esto Beatrix no está segura de cuánto tiempo se quedará en su antigua ciudad natal.\n";
                        break;
                    case "texto7":
                        hist = "Beatrix tiene una relación antagónica con Kardel y Rattletrap debido a hechos no especificados que cometió en su juventud. Sin embargo posee un reloj hecho por el abuelo de Rattletrap. Es amiga de al menos un keen, Boush, habiendo colaborado en algo hace muchos años.\n" +
                                "\n" +
                                "En sus días de juventud Beatrix corrió con Luna, cuando aún era conocida como el Azote de las Llanuras antes de entrar al servicio de Selemene.\n" +
                                "\n" +
                                "Beatrix ha conocido a trolls antes pero no se llevaba bien con ellos. Una vez conoció a alguien que decía servir a un \"maestro oculto\", posiblemente relacionado con Lanaya.";
                        break;
                    case "frase":
                        hist = "\"Beadie y Mortimer. Somos una especie de paquete\"";
                        break;
                }
                break;

            case "Kardel Sharpeye":

                switch(tipo) {

                    case "texto1":
                        hist = "Kardel Ojoavizor nació en lo profundo de las montañas de Knollen donde, desde tiempos inmemoriales, la Gente Ingeniosa ha sobrevivido gracias a la caza de los extraños acechacantilados que viven en los despeñaderos situados sobre su pueblo, disparándolos desde lejos y recogiendo sus cuerpos en el lugar en donde caen. Ojoavizor se encontraba entre los mejores de esta misteriosa Gente Ingeniosa, para la que las armas de proyectiles no son más que otra extremidad y disparar es tan natural como el respirar.\n" +
                                "\n" +
                                "El día de su llamamiento, cuando iba a conseguir plena aceptación en su poblado, Ojoavizor se sometió a la antigua prueba: alcanzar una bestia de los acantilados con un solo disparo desde el fondo del valle. Fallar significaría el rechazo. Con todo su pueblo pendiente de él, Ojoavizor realizó su disparo. Un acechacantilados cayó; la multitud enloqueció. Pero cuando el cuerpo fue recogido, el pueblo quedó en silencio, ya que los ancianos descubrieron que la bala había atravesado el brillante ojo central del acechacantilados y había quedado atrapada entre sus mandíbulas. Este signo de mal agüero fue el comienzo de una oscura profecía, prediciendo tanto grandeza como exilio para el hombre que realizó el disparo. Así es cómo Ojoavizor el Francotirador (Sniper), debido a su propia habilidad, fue condenado a alejarse de su gente y a no volver hasta no haber cumplido el resto de la profecía alcanzando un rango legendario en el campo de batalla.";
                        break;
                    case "texto2":
                        hist = "Kardel es un Keen de tierras altas, sabe diseñar y construir sus propias armas de fuego.\n" +
                                "\n" +
                                "Kardel puede dejarse crecer un bigote completo en tres días.\n" +
                                "\n" +
                                "Kardel desprecia a los usuarios de arcos pues cree que las armas de fuego son el futuro.\n" +
                                "\n" +
                                "Kardel ha tenido contacto con la tribu de los Vientos Escarchados.\n" +
                                "\n" +
                                "Kardel disfruta cazando criaturas mundanas como la liebre, pero también presas sobrenaturales.\n" +
                                "\n" +
                                "Brag Sharpeye es el abuelo de Kardel. Su abuela no tiene nombre. Kardel ha heredado reliquias de ambos.\n" +
                                "\n" +
                                "Al igual que otros Keen, Kardel heredó una pistola de su padre, el Ladrón de Muertes (Killstealer).\n" +
                                "\n" +
                                "Hasta que Kardel no haga el mismo disparo perfecto que hizo cuando mató al Steepstalker no podrá volver a Knollen.\n" +
                                "\n" +
                                "Rigwarl odia a Kardel por la misma razón que odia a todos los Keen; los considera pequeños y débiles.\n" +
                                "\n" +
                                "A Kardel le gustan especialmente los carnavales de verano de Knollen, sobre todo su galería de tiro.\n" +
                                "\n" +
                                "Kardel tiene una rivalidad con Snapfire.";
                        break;
                    case "frase":
                        hist = "\"Ahora eso es lo que yo llamo poder de freno\"";
                        break;
                }
                break;

            case "Mercurial":

                switch(tipo) {

                    case "texto1":
                        hist = "Al igual que las altas concentraciones de energía buscan disminuir su nivel, la Espectro (Spectre) conocida como Mercurial es un ser de intensa y violenta energía que se ve irresistiblemente atraído por las escenas de lucha que transcurren en el mundo físico. Aunque su estado espectral trasciende las limitaciones sensoriales, cada vez que asume una apariencia física se ve afectada por una pérdida involuntaria de consciencia. En el fragor de la batalla, su identidad se destruye y se reconfigura mientras va tomando consciencia de sí misma. Se aferra al hecho de que ella es Mercurial la Espectro y de que todos sus Tormentos son solo sombras de la verdadera Espectro. La claridad llega en la lidia por la supervivencia; su mente se reafirma a sí misma hasta el momento de la victoria o la derrota cuando, finalmente, trasciende la materia y recupera una vez más su forma eterna.";
                        break;
                    case "texto2":
                        hist = "Mercurial procede del reino de las sombras. Su Daga Espectral libera su sombra a su paso, un estado en el que los espectros prosperan mientras los mortales se acobardan ante su oscuridad.\n" +
                                "\n" +
                                "Durante mucho tiempo ha actuado como su camino, utilizando su Daga Espectral para cubrir el plano físico con su sombra pero ahora emplea una mayor concentración de sus poderes para mantener a raya el reino de las sombras de lo que antes hacía para soltarlo.\n" +
                                "\n" +
                                "La verdadera forma espectral de Mercurial trasciende las limitaciones sensoriales. Técnicamente esto significa que su forma real fuera de su manifestación física es imperceptible para los sentidos mundanos.\n" +
                                "\n" +
                                "Mercurial experimenta un ciclo interminable de manifestación y ascensión. Irresistiblemente atraída por los conflictos en el plano físico, se ve obligada a tomar una manifestación física para participar. En el momento álgido de la batalla, su identidad se rompe y se reconfigura, formando los duplicados que vemos en su habilidad Haunt. La verdadera Mercurial reafirma su control sobre todos ellos mientras lucha. En el resultado final de la batalla en la que se encuentre ya sea la victoria o la derrota, \"trascenderá la materia\" y será \"restaurada a su forma eterna\" hasta la próxima vez que se vea arrastrada a cualquier conflicto en el plano físico.\n" +
                                "\n" +
                                "El proceso de trascender la materia y ser restaurada a su forma eterna probablemente se refiere a su regreso a su estado espectral normal después de dejar su manifestación física. Este proceso podría ser la ascensión de la que habla.\n" +
                                "\n" +
                                "Las energías violentas de su plano natal fluyen fuera de su manifestación física.\n" +
                                "\n" +
                                "Mercurial habla de un \"origen\", al que busca acercarse convirtiéndose en uno de los Ascendentes.\n" +
                                "\n" +
                                "Mercurial habla de las \"Trascendencias\", un concepto misterioso.\n" +
                                "\n" +
                                "Mercurial puede ser uno de los muchos espectros.\n" +
                                "\n" +
                                "Mercurial parece hablar el mismo idioma que los Ascendentes.\n" +
                                "\n" +
                                "El lenguaje de Mercurial puede ser realmente incomprensible para la mayoría de los seres. Al obtener voz, expresa su desconcierto al poder entenderse a sí misma mediante pensamientos y discursos comprensibles.\n" +
                                "\n" +
                                "Mercurial se disuelve y dispersa cuando muere.\n" +
                                "\n" +
                                "Mercurial lleva a veces un tocado brillante para advertir a los depredadores interdimensionales entre los Siete Planos. Dicho tocado actúa como un faro para otros que son \"menos visibles\".\n" +
                                "\n" +
                                "Mercurial es uno de los pocos seres que posee la habilidad de condensar y comprimir la energía bruta de un alma en una hoja.\n" +
                                "\n" +
                                "Mercurial entiende la luz y la eternidad de una manera diferente a la mayoría de los seres.\n" +
                                "\n" +
                                "Mercurial atraviesa un reino desconocido con luz eterna utilizando sentidos que no tienen equivalente mundano. En este reino toma penachos de seres misteriosos para adornar su vestido.";
                        break;
                    case "texto3":
                        hist = "En algún momento y por medios desconocidos una sombra solitaria de la identidad destrozada de Mercurial fue atraída y atrapada en una armadura maldita. Enfurecida, esta sombra solitaria describió la armadura como una \"jaula\" ya que la separaba del Spectre original, pero pronto se dio cuenta de que en realidad era una \"puerta\" a la libertad: una puerta que la llevaría a convertirse en una entidad separada del Spectre original. Para abrir esta \"puerta\" y atravesarla necesitaba cosechar almas para la armadura, de modo que ésta pudiera concederle un sentido más fuerte de sí misma. Con la promesa de libertad a su alcance ya no desea volver a unirse a la Spectre original y ahora se dedica a cosechar las almas de los desafortunados que se cruzan en su camino, todo en nombre de la obtención de la verdadera individualidad.";
                        break;
                    case "texto4":
                        hist = "Puck y Mireska pueden entender el discurso de Mercurial. Ambos tienen vínculos con el Reino de los Fae y el Reino de las Sombras respectivamente lo que indica un posible vínculo con Mercurial también.\n" +
                                "\n" +
                                "En algún momento Inai ha advertido a Mercurial que siga sus instrucciones al pie de la letra. Mercurial parece tener una animosidad con Inai.\n" +
                                "\n" +
                                "Mercurial encuentra a sus parientes en personas como Azwraith y Meepo que tienen la capacidad de duplicar su presencia. A pesar de ello los considera indignos e inferiores respectivamente.";
                        break;
                    case "frase":
                        hist = "\"Entre los trascendentales, serías considerado innoble\"";
                        break;
                }
                break;

            case "Barathrum":

                switch(tipo) {

                    case "texto1":
                        hist = "Barathrum el Rompe Espíritus (Spirit Breaker) es un poderoso e imponente ser, una brutal inteligencia elemental que decidió cambiar de plano y adentrarse en el mundo material para tomar parte en eventos que repercutieran en su hogar, el reino elemental. Para ese fin adoptó una forma que le sería útil tanto en nuestro mundo como fuera de él. Su apariencia física toma prestados algunos de los puntos fuertes de este mundo, mezclando rasgos bovinos y simiescos —cuernos, pezuñas y manos— como emblemas externos de sus cualidades internas de fuerza, velocidad y astucia. Spiritbreaker lleva un aro en el hocico como recordatorio de que sirve al maestro oculto y de que este mundo en el que obra es solo una sombra del verdadero.";
                        break;
                    case "texto2":
                        hist = "Barathrum sirve a un maestro, a quien nombra como Imperator. Es el único dedicado por completo a su maestro.\n" +
                                "\n" +
                                "Barathrum viaja entre los Siete Planos por lo que también se le conoce como la Bestia de Todos los Mundos.\n" +
                                "\n" +
                                "Barathrum posee un mayal forjado alrededor de un núcleo de energía elemental compacta lo que permite que el arma atraviese los planos de existencia.";
                        break;
                    case "frase":
                        hist = "\"Soy la bestia de muchas partes; separo a los enemigos de sus vidas\"";
                        break;
                }
                break;

            case "Raijin Thunderkeg":

                switch(tipo) {

                    case "texto1":
                        hist = "Storm Spirit es, literalmente, una fuerza de la naturaleza. La fuerza salvaje del viento y del clima, embotellados bajo forma humana. Y una forma bulliciosa, jovial e indómita, ¡todo hay que decirlo! Tan alegre como nuestro tío favorito, es capaz de insuflar una chispeante energía a cada escena. Pero no siempre fue así. De hecho, hubo una gran tragedia en su creación. Hace generaciones, en las llanuras más allá de las Montañas Aulladoras, una buena persona deambulaba famélica, pasando hambre y sed. Un simple elementalista llamado Panzatrueno utilizó un hechizo prohibido para invocar al espíritu de la tormenta, quería que lloviera. Enfurecida ante la presunción de este mortal, la Tormenta Celestial conocida como Raijin se desató sobre la tierra, azotándola sin piedad con vientos e inundaciones. Panzatrueno no era rival para el ser Celestial, no hasta que conjuró un hechizo suicida que unificó sus destinos en uno: capturó al Celestial en su propio cuerpo. Atrapados juntos, el humor irrefrenable de Panzatrueno se fusionó con la desbordante energía de Raijin, creando al joven Raijin Panzatrueno, un Celestial que camina por el mundo en forma física.";
                        break;
                    case "texto2":
                        hist = "Espíritu de Tormenta es el producto de un hechizo prohibido que fusionó el espíritu de Raijin, el Celestial de las tormentas, en la forma física de Thunderkeg, un elementalista de más allá de las Montañas de los Lamentos.\n" +
                                "\n" +
                                "Al parecer, Storm Spirit ha leído el grimorio de Demnok Lannik.\n" +
                                "\n" +
                                "Storm Spirit fue el primero de sus hermanos en aventurarse fuera de las Montañas de los Lamentos. \n" +
                                "\n" +
                                "Cuando las noticias de sus hazañas llegaron a sus hermanos que aún estaban dentro de las cumbres, sintieron curiosidad y se unieron a su \"primo\".";
                        break;
                    case "texto3":
                        hist = "Raijin y Thunderkeg comparten una personalidad bulliciosa. Esto ha llevado a sus hermanos y a otras personas a llamar a Raijin molesto e inmaduro.\n" +
                                "\n" +
                                "Raijin es rebelde y no le gusta que le controlen ni que le den órdenes. Esta podría ser la razón por la que se enfadó con Thunderkeg (se dijo que las súplicas del pobre elementalista eran una \"presunción\" para él) y por la que su hermano Void Spirit planeó controlarlo.\n" +
                                "\n" +
                                "Ambos comparten un buen sentido del humor y un estado de ánimo constantemente jovial. Raijin conserva esta personalidad incluso durante una batalla.\n" +
                                "\n" +
                                "Raijin parece ser un egoísta y es bastante arrogante. Se desconoce si Thunderkeg comparte este rasgo pero también le gusta admirar su propia apariencia.";
                        break;
                    case "texto4":
                        hist = "Entre los cuatro espíritus, Raijin es el más joven de ellos. Raijin consideró que las Montañas de los Lamentos eran demasiado estrechas para su gusto, así que se aventuró a manipular los vientos del resto del mundo. Antes de que pusiera un pie fuera de las cumbres se vio envuelto en un hechizo de invocación mal hecho que su hermano mayor plantó en secreto para que Thunderkeg lo encontrara y que fue lanzado torpemente por un elementalista aficionado llamado Thunderkeg que esperaba acabar con una sequía. Lo que sucedió después en esta historia puede leerse en su biografía.";
                        break;
                    case "texto5":
                        hist = "El Espíritu de la Tormenta (o al menos su mitad mortal Thunderkeg) comparte ancestros con Ember Spirit, Earth Spirit, Void Spirit y Brewmaster.\n" +
                                " Mangix podría estar refiriéndose a Thunderkeg más que al Espíritu de la Tormenta porque el primero también proviene de las Montañas de los Lamentos. Cuando Mangix muere le pide que entierre su cuerpo bajo la Ciudad Arruinada.\n" +
                                "\n" +
                                "El Espíritu de la Tormenta tiene una antigua rivalidad con Razor, que probablemente se remonta a una época anterior a la fusión de Raijin con Thunderkeg. El lore de Razor implica que la rivalidad comenzó cuando robó la energía de las tormentas sensibles (probablemente refiriéndose a Raijin) lo que hizo que estas tormentas se enfadaran mucho.\n" +
                                "\n" +
                                "Grimstroke desprecia a Raijin posiblemente debido a alguna calamidad que una vez infligió a Ashkavor.\n" +
                                "\n" +
                                "En la historia de Artifact, Storm Spirit tiene una intensa rivalidad con Zeus.";
                        break;
                    case "texto6":
                        hist = "En medio de la masa terrestre desgarrada por las escaramuzas de Ancestros, Humanos, Oglodi, Vhoul y otros seres mortales, una nueva batalla de proporciones divinas se alza para sacudir el ya frágil mundo de los mortales. Al no querer compartir la autoridad sobre todo lo que es la tormenta y el clima, y al negarse a inclinarse ante una patética excusa de dios mortal, Storm Spirit debe luchar contra Zeus para demostrar que sólo hay un verdadero señor del rayo... y para recordarle que, a pesar de todos los poderes divinos que le quedan, todavía tiene que caminar con los pies.\n" +
                                "\n" +
                                "Cada vez que él y Zeus tienen que reunirse siempre acaban lidiando con las posturas del otro antes de tener una conversación seria. También tuvo una competición de poder contra Zeus, en la que éste ganó el primer punto al destruir un edificio. En respuesta a esta hazaña, Storm Spirit destruyó todo un ejército para zanjar el asunto. Frustrado el dios mortal tuvo una rabieta y redujo una ciudad entera a un cráter.";
                        break;
                    case "frase":
                        hist = "\"Todos se quejan del clima... bueno, ¡estoy haciendo algo al respecto!\"";
                        break;
                }
                break;

            case "Sven":

                switch(tipo) {

                    case "texto1":
                        hist = "Sven es el hijo bastardo de un Caballero de la Vigilia, nacido de un Merante Pálido y criado en las Ruinas de la Costa Sombría. Con su padre ejecutado por violar el Códice de la Vigilia y su madre rechazada por su raza salvaje, Sven cree que el honor no se encuentra en ningún orden social, sino en uno mismo. Tras cuidar a su madre durante una prolongada agonía, se ofreció como aprendiz de los Caballeros de la Vigilia, sin revelar nunca su identidad. Durante trece años estudió en la escuela de su padre, dominando el rígido código que declaró su existencia una abominación. Luego, el día en que debería haber prestado juramento, tomó la Hoja del Exiliado, destruyó el Yelmo Sagrado y quemó el Códice en la Divina Llama de la Vigilia. Se alejó de la Fortaleza de la Vigilia, siempre en solitario, siguiendo hasta la última estricta runa de su código privado. Aún sigue siendo un caballero, sí... pero un Caballero Renegado. No responde más que ante sí mismo.";
                        break;
                    case "texto2":
                        hist = "Sven es un caballero renegado, medio Meranth de nacimiento. Después de que su padre fuera ejecutado por violar el Códice de la Vigilia la madre de Sven falleció, dejándolo huérfano. Sven es un guerrero solitario que maneja la legendaria Espada de los Desterrados con un efecto devastador. Viaja solo buscando el honor y la gloria, al tiempo que adquiere una considerable cantidad de oro como espadachín independiente.\n" +
                                "\n" +
                                "En una ocasión Sven empaló con su armadura a un ogro que lo atacaba en el Camino Feral.\n" +
                                "\n" +
                                "El yelmo de Sven, de forma extraña, puede estar fabricado para adaptarse a su fisiología merántica.\n" +
                                "\n" +
                                "Sven encontró una vez un arma en los restos hundidos de una galera de los Caballeros de la Vigilia.\n" +
                                "\n" +
                                "Según Rylai, Sven es \"azul\" bajo su armadura.";
                        break;
                    case "texto3":
                        hist = "Empuñando la Espada del Adjudicador, Sven rompió la máscara de Juggernaut liberando a los espíritus de los ancestros de Yurnero así como a un espíritu de dragón compañero. Tanto los espíritus como Yurnero consideran esto un acto de bondad, están agradecidos por las acciones de Sven y tienen una deuda de gratitud con Sven.\n" +
                                "\n" +
                                "Sven tiene en alta estima a los solitarios como el Druida Solitario pero no se alía necesariamente con ellos para mantenerse fiel a su código.\n" +
                                "\n" +
                                "Crystal Maiden parece tener afecto por Sven dirigiéndose a él y felicitándolo personalmente.";
                        break;
                    case "texto4":
                        hist = "En esta extraña línea temporal la historia de Sven ha llegado a un punto en el que todavía está alineado con los Caballeros de la Vigilia pero su repentina destrucción desde dentro es un futuro que no se puede evitar, al menos para la voluntad del Caballero Renegado. Para asegurar que esta posibilidad se haga realidad Sven debe entrenar entre sus enemigos, elevarse por encima de sus filas y, en última instancia: destruirlos desde dentro.\n" +
                                "\n" +
                                "Aunque aún no ha promulgado su código de renegado manifiesta un poco del código en sus acciones al alinearse contra cualquier tipo de ejército como lo haría cualquier verdadero renegado de la sociedad. Ha declarado la guerra a los Radiantes y a los Dires, a Venomancer y a su creciente jardín de Guardias de la Peste (a los que Lesale llama sus \"hijos\"), a la Legión de Bronce, a la reformada Horda de la Niebla Roja e incluso a la rebelión de los Vhouls.";
                        break;
                    case "frase":
                        hist = "\"Que mis enemigos compartan el destino del Yelmo Destrozado\"";
                        break;
                }
                break;

            case "Squee, Spleen y Spoon":

                switch(tipo) {

                    case "texto1":
                        hist = "En la amplia historia de la Ensenada del Dragador, no hay ningún otro negocio más maldito que Demoliciones Techies. Pensándolo bien, la Ensenada del Dragador ya no existe. Ni Toterin. Ni tan siquiera Villa Tramposa. De hecho, si alguien investigara la historia de Demoliciones Techies notarían que poco después de la aparición de los Techies, las ciudades suelen desaparecer.\n" +
                                "\n" +
                                "Como todas las inevitables catástrofes que rodean a Techies, la erradicación de la Ensenada del Dragador comenzó con un invento. Con la tarea de diseñar una manera más segura de detonar explosivos en las minas bajo la ciudad, los prodigiosos Squee, Spleen y Spoon desarrollaron la creación más extraña hasta la fecha: un botón que, al ser pulsado, activaba un dispositivo lejano que encendía un detonador.\n" +
                                "\n" +
                                "Muy entusiasmados por probar su invento, el trío rellenó barril tras barril de explosivos de sal ígnea, llenando cada rincón de su diminuto taller con las nuevas bombas remotas que habían desarrollado. De este montón, cogieron una única carga y la enterraron en un campo muy lejano. Mientras se ocultaban en una zanja, Spleen presionó el botón detonador. Sin embargo, no ocurrió nada. Confuso, se levantó, volvió a presionar el botón una y otra vez hasta que, finalmente, una explosión provocó un agujero en el campo. Eufóricos, Squee y Spleen volvieron a casa justo cuando una onda masiva de sonido y fuerza los arrolló.\n" +
                                "\n" +
                                "Desconcertados y con pitidos en los oídos a causa de la inesperada explosión, lograron reunirse en la nube de polvo para ver unas ruinas humeantes en el lugar donde una vez estuvo su taller. Trozos de madera y piedra continuaban cayendo a medida que el inmenso cráter que tenían delante se iba haciendo más profundo y amplio. Toda la Ensenada del Dragador temblaba, y luego poco a poco empezó a caer en las minas subterráneas mientras todos sus residentes huían presa del pánico.\n" +
                                "\n" +
                                "Sentados en el borde de su casa, cada vez más hundida, Techies sonreían y hacían burlas, tan emocionados por las posibilidades que se olvidaron de la ira de sus antiguos vecinos. Solo se preguntaban una cosa: ¿cómo podrían provocar una explosión aún más grande?";
                        break;
                    case "texto2":
                        hist = "En una ocasión el equipo Techies trató de sustituir su carro por un elefante utilizando diversos medios de seducción. Se dice que solo un elefante sobrevivió lo suficiente como para reemplazar su carro.";
                        break;
                    case "frase":
                        hist = "\"Medidas hechas\". \"Bombas construidas\". \"El polvo está seco\". \"Está bien, ¡hagamos estallar algo!\"";
                        break;
                }
                break;

            case "Lanaya":

                switch(tipo) {

                    case "texto1":
                        hist = "Lanaya, la Asesina Templaria (Templar Assassin), llegó a su vocación a través de una senda de curiosa investigación. Dotada de una inclinación científica, se pasó los primeros años de su vida dedicándose al minucioso estudio de las leyes de la naturaleza, consultando grimorios de magia y alquimia, recreando experimentos a partir de fragmentos carbonizados de los Archivos Púrpura y memorizando observaciones de los archivistas Keen. Tranquila y reservada por naturaleza, la dificultad de adquirir estos objetos refuerza aún más sus habilidades de sigilo. Si hubiese sido menos retraída, incluso se podría haber hecho famosa como erudita del robo entre los gremios. En su lugar, sus investigaciones la condujeron a rincones mucho más oscuros.\n" +
                                "\n" +
                                "Mientras dedicaba sus furtivos talentos a descubrir los misterios del universo, abrió una puerta secreta que existe en la naturaleza misma: la entrada al mayor Templo Oculto. La inteligencia que se ocultaba tras el portal demostró que la estaba esperando, y cualesquiera que fuesen los misterios revelados en el momento de su descubrimiento, no fueron nada comparados con las respuestas que indujeron a Lanaya a continuar a su servicio. Juró proteger los misterios, pero más concretamente a las órdenes del Templo Oculto que satisface su infinita ansia de comprensión. En los ojos de cada enemigo que erradica, un poco más del misterio es revelado.";
                        break;
                    case "texto2":
                        hist = "Lanaya tiene algunos conocimientos de alquimia.\n" +
                                "\n" +
                                "Lanaya ha estado en las ruinas de la Meseta Violeta tras el incidente provocado por Boush y su equipo científico. Descubrió los Archivos Violeta y examinó los textos que contenían incluido un plano para un arma de mejora psiónica.\n" +
                                "\n" +
                                "Los poderes de Lanaya provienen directamente del Templo Oculto. Si rompe sus votos, sus poderes se desvanecerán. Confía en los Ocultos porque los secretos que le han revelado la han conquistado.\n" +
                                "\n" +
                                "Lanaya mató una vez a una reina, llevándose su horquilla como recuerdo.\n" +
                                "\n" +
                                "Lanaya puede haber sido miembro de los Lamentos del Oeste, una facción de asesinos.\n" +
                                "\n" +
                                "Lanaya ha explorado Halgalreh y ha vuelto con ropa usada por los lugareños.\n" +
                                "\n" +
                                "Lanaya es miembro de la Orden de la Luna Roja.\n" +
                                "\n" +
                                "Lanaya ha tenido contacto con los Siete Invisibles, que le dieron una armadura hecha de hueso. A través de esta armadura, puede comunicarse con los muertos.\n" +
                                "\n" +
                                "En una ocasión Lanaya se adentró en un arboreto de Las Tres Sombras, donde encontró un conjunto de prendas encantadas.\n" +
                                "\n" +
                                "Lanaya siente que la guerra entre los Ancestros está por debajo de ella.";
                        break;
                    case "texto3":
                        hist = "Como miembro del Templo Oculto Lanaya está estrechamente asociada con Inai, el Espíritu del Vacío, al que considera su maestro.\n" +
                                "\n" +
                                "Yurnero tuvo una relación romántica con Lanaya pero al parecer ambos rompieron después de que él hiciera algo que la molestara. Aunque Yurnero parece haberlo superado, sigue sintiendo tristeza. Lanaya se siente despechada y no ha superado la ruptura. Está bastante enfadada con Yurnero hasta el punto de amenazar con la violencia e intentar darle celos.\n" +
                                "\n" +
                                "Lanaya ha conocido a otros Ascendidos además de Grimstroke.";
                        break;
                    case "texto4":
                        hist = "La relación de Lanaya con la Familia Sunbreeze proviene de su intento de recuperar cierto artefacto del padre de Mireska, que no lo entregó fácilmente. Aunque es una asesina Lanaya no mató al mayor de los Sunbreeze en este encuentro.";
                        break;
                    case "frase":
                        hist = "\"Donde me envían los Ocultos voy sin cuestionar. Ni siquiera cuestiono por qué no cuestiono\"";
                        break;
                }
                break;

            case "Terrorblade":

                switch(tipo) {

                    case "texto1":
                        hist = "Terrorblade es el merodeador demoníaco, un espíritu maligno al que incluso otros demonios temen. Este iconoclasta cósmico robó a los Señores de los Demonios, ignoró el código de rituales que deberían haber limitado su conducta y quebrantó todas y cada una de las leyes de las siete Regiones Infernales. Por sus crímenes tuvo que aprender una lección: hasta el Infierno tiene un infierno. Hubo un breve y brutal juicio, con muchos muertos en todos los bandos, y finalmente fue encarcelado en Foulfell, una dimensión oculta donde los demonios encerraban a los suyos.\n" +
                                "\n" +
                                "Pero Foulfell no es una prisión normal. En este oscuro espejo de la realidad se sentencia a los demonios a contemplar eternamente el retorcido reflejo de sus propias almas. Pero en lugar de sufrir, Terrorblade dominó el reflejo de la peor versión de sí mismo: un demonio furioso y ladrón de inimaginable poder. Con su bestia interior bajo su control, destruyó las paredes de la prisión fractal y emergió libre para desatar su terror en toda la creación.";
                        break;
                    case "texto2":
                        hist = "Al igual que otros demonios, Terrorblade habla ozkavosh.\n" +
                                "\n" +
                                "Terrorblade originalmente empuñaba un par de guadañas pero se las quitaron después de su destierro. Ahora las ha recuperado.\n" +
                                "\n" +
                                "Terrorblade es conocido por extorsionar a otros.\n" +
                                "\n" +
                                "A Terrorblade le gustan los dragones y aprecia luchar junto a ellos.\n" +
                                "\n" +
                                "La forma de metamorfosis de Terrorblade es en realidad un reflejo de sí mismo en su peor momento que aprendió a separar y a interactuar con él mientras miraba las paredes fractales de la prisión de Foulfell.\n" +
                                "\n" +
                                "A Terrorblade le molesta Dragonus porque cree que se parece a un ángel. Al mismo tiempo también cree que Skywrath Mage sería un buen demonio.\n" +
                                "\n" +
                                "Terrorblade afirma que es el mejor amigo de Aiushtha por razones desconocidas.\n" +
                                "\n" +
                                "Terrorblade conoce al demonio de Demnok Lannik.\n" +
                                "\n" +
                                "Según Pudge la carne de Terrorblade es sorprendentemente dulce.\n" +
                                "\n" +
                                "Terrorblade es quien ofrece un trato a Fruhling para matar a Uldorak.";
                        break;
                    case "frase":
                        hist = "\"Los santurrones se ahogarán en su santurronería\"";
                        break;
                }
                break;

            case "Leviathan":

                switch(tipo) {

                    case "texto1":
                        hist = "El Cazador de la Marea (Tidehunter) conocido como Leviatán fue una vez campeón de las Islas Hundidas, pero sus motivaciones son tan misteriosas como las de su gente. Es bien conocida la importancia que tienen las rutas de navegación de los tierraseca y cómo los imperios pueden crecer o perecer según quién controle los océanos. Sin embargo, muy pocos conocen las rutas submarinas y cómo las tribus en guerra de la Diáspora Merante fueron cavando moradas durante sus interminables escaramuzas subacuáticas. En los frágiles tratados entre los mer y los hombres podemos vislumbrar el alcance de los imperios sumergidos, aunque sus políticas parecen complejas y opacas. Parece ser que Leviatán, cansado de tantas rencillas y jurando lealtad solo a su dios abisal Maelrawn el Tentacular, decidió partir en soledad. Ahora acecha en el bajío en busca de hombres o merantes que se hayan desviado de su camino y siente un odio especial por el almirante Kunkka, su némesis desde hace mucho tiempo por razones perdidas en las más profundas fosas del mar.";
                        break;
                    case "texto2":
                        hist = "Tidehunter estuvo presente en la segunda batalla de la Isla Temblorosa donde invocó a su dios Maelrawn para que destruyera a Kunkka y a la Armada Claddish. Ambos han mantenido una rivalidad desde entonces.\n" +
                                "\n" +
                                "Mireska estaba de polizón en el barco de Kunkka durante la batalla y culpa a Tidehunter de que Kunkka, de alguna manera, la considere parcialmente responsable del destino de su flota.\n" +
                                "\n" +
                                "El ancla de Tidehunter fue robada de una de las naves insignia de Kunkka.\n" +
                                "\n" +
                                "Tidehunter es capaz de realizar muchas mutaciones, incluyendo aletas y dientes mutados.\n" +
                                "\n" +
                                "Tidehunter se comió una vez una de las botas de Kunkka.\n" +
                                "\n" +
                                "Sus dientes son a veces tomados como trofeos.";
                        break;
                    case "frase":
                        hist = "\"No puedes esconderte de la marea\"";
                        break;
                }
                break;

            case "Rizzrack":

                switch(tipo) {

                    case "texto1":
                        hist = "Rizzrack aún podía oír los gritos en su cabeza. Trabajaba frenéticamente haciendo girar la llave inglesa, enroscando tuercas, construyendo, cincelando, forjando. El sueño le evitaba; él solamente construía. Habían pasado meses desde que se encerró en el taller de su tío, y su salvación ya casi estaba terminada. Se frotó la espalda mientras cerraba los ojos. Entonces pudo ver un manto de flores flotando sobre las plácidas olas de Bahía Augurio antes de explotar en una nube de polen que silenciaba las vidas en cuanto alcanzaba los pulmones. Se despertó sobresaltado, con ahogo. Durante horas, el rítmico sonido de la piedra de amolar llenó el taller mientras afilaba un set de enormes hojas. Su mente se llenaba de imágenes de enredaderas estrangulando a sus vecinos, envolviendo sus casas. La inundación de Bahía Augurio no había sido nada en comparación con la violencia de los horrores que las aguas habían dejado tras de sí para que enraizaran más allá de los muros de la ciudad.\n" +
                                "\n" +
                                "Pero el sierratraje le daría fuerza y seguridad —pensaba él—, permitiendo esa chispa de esperanza antes de que el poderío de su miedo chocara contra su debilitada mente. Ramas, corteza, sangre. Cuando la ciudad cayó, Rizzrack huyó de los árboles andantes, los combatió, los mató. Los árboles habían destrozado las puertas e irrumpido en la ciudad. Los árboles habían aplastado, hecho añicos y pisoteado lo último que Bahía Augurio había podido reunir como defensa, acosando a los pocos refugiados que aún no habían huido. Con torpe silencio, Rizzrack desenrolló la gruesa cadena del brazo del traje, trémulas sus manos mientras inspeccionaba cada conexión y deslizaba un vacilante dedo por la garra unida a su extremo. El sierratraje estaba listo.\n" +
                                "\n" +
                                "Con temblorosa mano despertó de su letargo a la máquina de cortar. El terror le impulsaba, terror a lo que le esperaba y a lo que tendría que enfrentarse para poder albergar la esperanza de calmar su pensamiento. Con el sierratraje estremeciéndose mientras cobraba vida, se dio cuenta de que debía enfrentarse a este miedo, y supo también que eso no le iba a gustar ni lo más mínimo.";
                        break;
                    case "texto2":
                        hist = "Rizzrack es miembro de una familia que incluye a Beatrix Snapfire, que es su tía. Su madre, la hermana mayor de Beatrix, lo acogió y se establecieron juntos en el Valle de Augurio. Ella falleció en circunstancias desconocidas, posiblemente durante el ataque a la Bahía de Augurio por parte de los Treant Protectors dejando a su hijo traumatizado.";
                        break;
                    case "texto3":
                        hist = "Traumatizado por la destrucción de Augury Bay, Rizzrack es un poco inestable mentalmente actuando constantemente como un paranoico y hablando de voces en su cabeza. Por la misma razón, no es aficionado a Treant Protector o Nature's Prophet. A pesar de su devoción por la destrucción de árboles no le interesa el fuego.";
                        break;
                    case "texto4":
                        hist = "Su traje-sierra viene con un mecanismo de eyección para el piloto pero parece que siempre se dispara demasiado tarde.";
                        break;
                    case "texto5":
                        hist = "Rizzrack es el sobrino de Beatrix Snapfire.\n" +
                                "\n" +
                                "La madre de Rizzrack ya no vive.";
                        break;
                    case "frase":
                        hist = "\"No soy un leñador. Esto. Esto es personal\"";
                        break;
                }
                break;

            case "Boush":

                switch(tipo) {

                    case "texto1":
                        hist = "La diminuta raza de Boush el Hojalatero (Tinker) es conocida por su inteligencia, su astucia y su problemática relación con la magia. De hecho, se sienten orgullosos de sobrevivir gracias a su ingenio y utilizan únicamente los poderes de la naturaleza que pueden desatar mediante métodos racionales. Pero esta renuncia ha sido una gran fuente de problemas, Boush puede dar fe de ello. Como investigador clave de las leyes naturales, Boush el Hojalatero dirige una enorme investigación intelectual sobre el comportamiento de la naturaleza, fundando un laboratorio subterráneo en los rumoreados páramos brumosos de la Meseta Violeta. Aunque desprecian a los magos por los peligros que desatan en el mundo, Boush y sus Hojalateros asociados abrieron con arrogancia un portal hacia algún reino que escapaba de su comprensión y permitieron el paso a algunos de sus horrores. Una niebla negra emergió del cavernoso interior de la Meseta Violeta, envolviéndola en una oscuridad permanente de la que emanaban constantes sonidos horripilantes. Boush escapó gracias a su inteligencia y a los artilugios que portaba, fue el único Hojalatero que sobrevivió al Incidente de la Meseta Violeta.";
                        break;
                    case "texto2":
                        hist = "Boush fundó el laboratorio bajo la Meseta Violeta donde desarrolló varias tecnologías, como drones robóticos, láseres para cortar rocas y cohetes buscadores. Después de que un experimento saliera mal en el laboratorio  Boush fue el único superviviente que salió con vida. Cree que es poco probable que haya más supervivientes.\n" +
                                "\n" +
                                "Yurnero cree que Boush causó el incidente de la Meseta Violeta y que es responsable criminalmente de todas las muertes involucradas.";
                        break;
                    case "texto3":
                        hist = "Tinker es un Keen.\n" +
                                "\n" +
                                "Tinker tiene un doctorado.\n" +
                                "\n" +
                                "Tinker construyó una vez un ejército de pequeños drones robóticos llamados Rollermaws.\n" +
                                "\n" +
                                "Tras su huida de la Meseta Violeta Tinker utilizó la misma tecnología transdimensional que abrió el portal en el laboratorio para crear un par de botas teletransportadoras.\n" +
                                "\n" +
                                "Tinker no cree en la alquimia. Considera que sus practicantes son unos locos.\n" +
                                "\n" +
                                "Tinker conoce la Guerra de los Siete Minutos y puede haber participado en ella.\n" +
                                "\n" +
                                "Rigwarl odia a Tinker por la misma razón que odia a todos los Keen.";
                        break;
                    case "texto4":
                        hist = "oush es amigo de Beatrix Snapfire, una compañera entusiasta, ya que ambos colaboraron en algo hace muchos años.";
                        break;
                    case "frase":
                        hist = "\"¡La victoria es 10% inspiración, 90% decapitación!\"";
                        break;
                }
                break;

            case "Tiny":

                switch(tipo) {

                    case "texto1":
                        hist = "Tras cobrar vida como un trozo de roca, los orígenes de Tiny son un misterio sobre el que especula continuamente. Ahora es un Gigante de Piedra, ¿pero qué era antes? ¿un fragmento del talón de un Gólem? ¿un pedazo sobrante del taller de un escultor de gárgolas? ¿una parte del Rostro Oracular de Garthos? Se mueve por una gran curiosidad, y viaja por todo el mundo sin descanso en busca de sus orígenes, su ascendencia y su gente. A medida que camina, aumenta de peso y de tamaño, y las fuerzas que el tiempo ejerce sobre las rocas haciéndolas más y más pequeñas causan en Tiny el efecto contrario, provocando que crezca sin cesar.";
                        break;
                    case "texto2":
                        hist = "Tiny es un gigante de piedra de origen desconocido. \n" +
                                "\n" +
                                "Parece haber crecido a partir de un tamaño pequeño, e incluso menciona que Enchantress lo hizo saltar una vez sobre las aguas de un río. Tiny aparentemente tiene el poder de animar la roca provocando avalanchas a voluntad.\n" +
                                "\n" +
                                "Earth Spirit afirma conocer la \"verdadera naturaleza\" de Tiny.";
                        break;
                    case "frase":
                        hist = "\"Mis enemigos se abalanzan sobre mí como las olas sobre la piedra\"";
                        break;
                }
                break;

            case "Rooftrellen":

                switch(tipo) {

                    case "texto1":
                        hist = "Lejos hacia el oeste, en las montañas más allá del Valle del Augurio, yacen los restos de un antiguo poder, una fuente de energía sobrenatural alojada en lo más profundo del bosque. Se dice que las cosas que crecen allí lo hacen de forma extraña. Para las fuerzas de la naturaleza este es un lugar sagrado, creado para permanecer oculto y desconocido. Muchos son los peligros y trampas de esta tierra. Hay plantas devoradoras, fauna híbrida y flores venenosas, pero ninguno de ellos es tan temible como los poderosos Protectores Ent.\n" +
                                "\n" +
                                "Estas gigantescas y atemporales criaturas, encargadas de mantener la paz en esta peligrosa tierra, se aseguran de que nadie de dentro salga sin motivo alguno y que nadie del exterior descubra sus secretos. Durante incontables años se hicieron cargo de sus tierras sagradas, ininterrumpidamente, apenas conscientes de los cambios del mundo más allá. Pero inevitablemente, el mundo exterior descubrió esta tierra indómita, y año tras año los forasteros se volvieron cada vez más osados. Al poco vinieron con herramientas para cortar y llamas para quemar, lo que hacía a los Ent preguntarse a menudo: ¿Quiénes son estas frágiles y trabajadoras criaturas? ¿Qué se ha hecho del mundo verde y salvaje? Transcurrió una era de preguntas y dudas, un millar de veranos de minucioso análisis de antiguas tradiciones, a medida que más y más forasteros morían, nutriendo su tierra.\n" +
                                "\n" +
                                "Para cuando todos los que habían florecido acabaron de expresar su opinión, la curiosidad había superado la cautela. Estaba decidido: un único Protector sería enviado al mundo exterior con el cometido de vagar hasta que los glaciares se alzaran de nuevo, de observar los cambios en la tierra y sus criaturas, y de descubrir qué peligros desconocidos podrían amenazar sus tierras sagradas.";
                        break;
                    case "texto2":
                        hist = "Rooftrellen es el único miembro de los Treant Protectors conocido por su nombre. Como los demás de su raza es longevo y el tiempo parece pasar rápidamente para él. Al ser el único Protector que ha salido de su tierra natal Rooftrellen se siente confundido por el oro y los objetos, cosas que nunca antes había vist. Al igual que otros Protectores, Rooftrellen teme a los héroes que manejan hachas y fuego.\n" +
                                "\n" +
                                "En su frente Rooftrellen lleva una piedra rúnica especial. Se desconoce su significado. Tampoco se sabe si los Treant Protectors están relacionados con los treants de Nature's Prophet . Rooftrellen puede invocar al Espíritu de la Naturaleza para liberar su poder causando un crecimiento excesivo de vides y raíces. Se desconoce si esta habilidad es exclusiva de él o si está disponible para todos los Protectores. Si Rooftrellen cayera en batalla una plántula brotará de su cuerpo, crecerá hasta convertirse en un segundo Protector y continuará su misión.\n" +
                                "\n" +
                                "Es probable que la ciudad de Augury Bay fuera explorada por Rooftrellen ya que pronto fue atacada por un ejército de \"árboles andantes\". Dada la cercanía geográfica y el relato de Rizzrack sobre el ataque estos árboles se parecen mucho a los Treant Protectors. Por esta razón Rooftrellen tiene una rivalidad natural con Timbersaw.\n" +
                                "\n" +
                                "Rooftrellen ha estado en Roseleaf donde realizó una gran hazaña. Sin embargo desde entonces se ha marchado y Mireska considera su salida como un error.\n" +
                                "\n" +
                                "Rooftrellen es inusualmente resistente ya que proporciona un santuario para los brotes de stuntwood, una planta parásita que, de otro modo, mata a la mayoría de los árboles.";
                        break;
                    case "frase":
                        hist = "\"La vida convertida en muerte se convierte en nueva vida. Como debe ser\"";
                        break;
                }
                break;

            case "Jah'rakal":

                switch(tipo) {

                    case "texto1":
                        hist = "Es fácil ofender a un troll. Una raza irritable y peleona, los trolls prosperan gracias a las discusiones y los conflictos, no dejando pasar ninguna oportunidad para alzar su voz en disputa. Los machos maduran en cámaras subterráneas bajo el domicilio de sus matriarcas, alimentándose y entreteniéndose sin contribuir a nada. A menudo se quedan durante años pasada la madurez, mientras la matriarca les proporciona sustento. Cuando finalmente se saca a los trolls de su cámara subterránea, se agrupan con otros de su especie, formando bandas errantes de insatisfechos que se quejan ruidosamente ante cualquier provocación.\n" +
                                "\n" +
                                "Tanto que les gusta discutir a los trolls, imagínate lo raro que es que un troll sea expulsado de entre los suyos por ser difícil llevarse bien con él. Ese fue el destino de Jah'rakal, un troll alarmista de las profundidades de Hoven. Tan engañado estaba, tan amargado y abrasivo, que incluso los otros trolls encontraban su compañía intolerable. Tras un arrebato especialmente cáustico en el que demandó la mayoría del botín de su última redada, sus compañeros ya habían tenido suficiente. Se volvieron contra él, le apalearon con porras y le alejaron del campamento. Enfurecido por su destierro, regresó al día siguiente, armado con acero, y les mató a todos, uno a uno. Entonces hizo un juramento de sangre: a partir de ese momento se convertiría en una fuerza de combate. Ahora vaga por el mundo como el Jefe de Guerra Troll (Troll Warlord), amargado y enojado, el alto mando imperial de un ejército de un solo hombre.";
                        break;
                    case "texto2":
                        hist = "Al igual que otros trolls Jah'rakal es altivo, arrogante y aprecia la buena moda si se la puede permitir.\n" +
                                "\n" +
                                "Jah'rakal desprecia a Dazzle y a Huskar porque este último le recuerda a sí mismo.\n" +
                                "\n" +
                                "Jah'rakal siente un odio especial por Keen.\n" +
                                "\n" +
                                "Jah'rakal desprecia a Rhasta, un troll de las colinas, al que considera inferior a los verdaderos trolls.\n" +
                                "\n" +
                                "Jah'rakal cree que no hay inocentes.\n" +
                                "\n" +
                                "Jah'rakal odia al Comerciante por razones desconocidas.\n" +
                                "\n" +
                                "En una ocasión, Jah'rakal luchó y mató a un par de cazadores de trolls Oglodi y se quedó con sus hachas de batalla.";
                        break;
                    case "frase":
                        hist = "\"Yo hacer sufrir a inocentes tanto como a culpables. No haber inocentes\"";
                        break;
                }
                break;

            case "Ymir":

                switch(tipo) {

                    case "texto1":
                        hist = "Había sido una pelea memorable. Allí estaba Ymir, el Colmillo (Tusk), el Terror de la Barrera, la Bola de Nieve de Cobalto, el único luchador que había sido capaz de superar al Guerrero Espinoso en un combate justo y ahora el último hombre en pie en la Taberna de la Guarida de los Lobos. Lo que había empezado como una simple apuesta de bar por la supremacía había acabado con cuatro clientes habituales, un herrero y seis de los mejores soldados de la Brigada de la Escarcha retorciéndose sobre los trozos y astillas de casi todas las botellas, jarras y sillas del edificio. Tusk celebró y alardeó de su victoria mientras vaciaba su bebida.\n" +
                                "\n" +
                                "Tan pronto como los derrotados recuperaron la consciencia se empezaron a oír gritos de doble o nada. Tusk esperaba ansioso, pero a nadie se le pudo ocurrir apuesta mayor de la que acababa de ganar. Horrorizado por los daños causados a su taberna y desesperado por evitar otra riña, el camarero tuvo una idea. A pesar de ser tan hábil, Ymir nunca había participado en una batalla de verdad, nunca se había puesto a prueba contra la muerte indiscriminada y el caos de la guerra. Así que le propuso una apuesta al luchador: buscar la mayor batalla que pudiese encontrar, sobrevivir a ella y ganar para el bando que él eligiese. ¿Lo apostado? La siguiente ronda de bebidas.";
                        break;
                    case "texto2":
                        hist = "Tusk rara vez viaja al sur, prefiere las gélidas tierras del norte.\n" +
                                "\n" +
                                "Tusk conoce a Rylai de su pasado y solía tener peleas de bolas de nieve con ella.\n" +
                                "\n" +
                                "El rival de Tusk es sin duda Bristleback.\n" +
                                "\n" +
                                "Tusk es amigo de la tribu Frostiron que le ha fabricado una armadura que visita cada invierno.\n" +
                                "\n" +
                                "Según Tusk es costumbre invitar a una copa a todos los que siguen en pie después de una pelea en un bar.\n" +
                                "\n" +
                                "Cuando Tusk era joven practicaba con un saco de boxeo con forma de pez. Cuando se hizo mayor un herrero del pueblo le fabricó un guante de hierro con la forma de su antiguo saco de boxeo. Por esta razón, Tusk también es conocido por el apodo de \"Iroh Fisht\".";
                        break;
                    case "frase":
                        hist = "\"Después de una pelea de bar, es costumbre, como cortesía, invitar a todos los que todavía están de pie a una ronda de bebidas\"";
                        break;
                }
                break;

            case "Vrogros":

                switch(tipo) {

                    case "texto1":
                        hist = "No existe mito ni canción que anuncie su venida.\n" +
                                "\n" +
                                "Bajo la superficie del mundo yacen maravillas y horrores desconocidos. En lo más profundo, muy por debajo de los campos de fluido magma y las hirvientes raíces de los volcanes dormidos, se alza la ciudad de obsidiana de Aziyog, con su incomparable mampostería que se extiende a lo largo de una interminable caverna. Tras muros argamasados con los huesos de innumerables esclavos se encuentran los dominios de la horda abisal y su brutal underlord Vrogros.\n" +
                                "\n" +
                                "Vrogros, armado por los monstruosos herreros de su especie y muy versado en las artes de la Grieta Oscura, es capaz de conjurar llamas y maldad devastadora a través del resquicio entre los mundos. Él siempre busca expandir sus posesiones, destruyendo o esclavizando todo lo que encuentra. Sin embargo, las tierras que ofrece el reino subterráneo son pocas, y por eso ha vuelto su mirada hacia arriba. Las primeras oleadas de invasores abisales ya han marchado a través de la grieta siguiendo sus órdenes; unas pocas legiones condenadas cuyo único propósito es medir el poder de las naciones de la superficie. Ahora, mientras todas sus huestes se preparan para la conquista eterna, el propio Vrogros se adentra en un mundo iluminado por el sol para anunciar la llegada de su reinado. Quienes se enfrenten al Underlord se inclinarán y le rendirán tributo, o serán aplastados en el acto.";
                        break;
                    case "texto2":
                        hist = "Una grieta etérea aparece dentro de las murallas de una nación ignorante dando paso a Vrogros, el Señor del Abismo, y a las legiones de la Horda Abisal. Con una presencia imponente tan amplia como su circunferencia el Señor del Abismo pone finalmente el pie desde el Aziyog subterráneo en el mundo de la superficie con la vil intención de destruirlo o conquistarlo todo tras haber agotado las tierras que ofrece el mundo subterráneo.\n" +
                                "\n" +
                                "Su monstruosa figura y su poder pueden llamar la atención de todos pero nadie puede prever su repentina e imprevisible llegada ya que allana un camino sin obstáculos para que él y sus ejércitos pongan el pie en el mundo iluminado por el sol que pronto será reclamado para un oscuro propósito.\n" +
                                "\n" +
                                "Vrogros procede de la ciudad subterránea de Aziyog, situada bajo las cámaras de magma de los volcanes inactivos que dan a esta ciudad su estructura de obsidiana. Esta poderosa bestia ya ha conquistado todas las tierras que el mundo subterráneo puede ofrecer sin embargo este señor nunca se conformó con la mera conquista regional. Con su dominio de las artes de la Grieta Oscura Vrogros doblega incluso el espacio a su voluntad para transportarse a sí mismo y a sus ejércitos sin los retrasos de la distancia y el tiempo llevándolos al mundo de la superficie donde sus naciones y sus habitantes están listos para ser tomados.\n" +
                                "\n" +
                                "Las primeras fuerzas de la Horda Abisal ya han atravesado su grieta: meros grupos de exploración y forraje destinados a probar el poder de las naciones de arriba. Con el conocimiento impartido por sus encuentros el propio Vrogros atraviesa finalmente la grieta etérea para liderar la carga de la Horda Abisal mientras da a conocer su presencia al mundo de la superficie con la intención de conquistar las tierras antes y más allá del horizonte al tiempo que aprovecha al máximo a los supervivientes de su impío holocausto convirtiéndolos en sus esclavos o quemándolos en el hogar de Aziyog.";
                        break;
                    case "texto3":
                        hist = "En esta extraña línea de tiempo Vrogros todavía tiene que entrar y conquistar el mundo de la superficie. Actualmente está planeando su asalto a Stonehall pero también parece que ha formado una alianza impía con los señores de los demonios de la Corte de Ristul.";
                        break;
                    case "texto4":
                        hist = "Vrogros es malvado y esclaviza a la gente.";
                        break;
                    case "texto5":
                        hist = "Tras acordar con los demás señores la división del poder en tres partes, Vrogros gobierna la Corte de Ristul junto a Shadow Fiend y B'Kor. No se puede decir que les guste trabajar juntos pero son aliados a pesar de todo y deben mantener su lealtad para mantener el poder sobre la corte.\n" +
                                "\n" +
                                "Vrogros tiene su propio culto de diablillos que se parecen a él con sus cuerpos escamados que se asemejan a criaturas de cuatro patas y sus pequeñas caras sobre cabezas que tienen un par de cuernos, lo que implica que pertenece a una especie de monstruos. Se les puede ver en el cómic de Ascensión de la Eminencia de Ristul y en el juego de cartas Artifact en una carta llamada Ozkavosh Horror. Sin embargo se desconoce si son realmente demonios ya que la carta no tiene ningún lore que diga nada al respecto más allá de su título.\n" +
                                "\n" +
                                "Con intenciones hostiles sobre la nación de Stonehall es natural que la vengativa Legion Commander tenga mala disposición hacia él.\n" +
                                "\n" +
                                "El estatus de Vrogros como uno de los usurpadores de los puestos de poder de la Corte de Ristul lo convierte en un objetivo para la Reina del Dolor que busca reclamar su asiento en la corte demoníaca.\n" +
                                "\n" +
                                "Los adoradores de Marte le han enviado muchas oraciones pidiendo la muerte de Vrogros. Tras escuchar todas estas plegarias, Marte se muestra hostil hacia él.\n" +
                                "\n" +
                                "Siltbreaker planea matar a Vrogros a tiempo.";
                        break;
                    case "frase":
                        hist = "\"Nada puede detenernos. Nada puede frenar nuestra marcha. Y cuando hayamos llegado, todo arderá\"";
                        break;
                }
                break;

            case "Undying":

                switch(tipo) {

                    case "texto1":
                        hist = "¿Cuánto tiempo ha transcurrido desde que perdió su nombre? Su ruinosa mente ya no lo recuerda.\n" +
                                "\n" +
                                "Vagamente es capaz de rememorar armaduras, estandartes y compañeros con rostros sombríos cabalgando a su lado. También recuerda una batalla: dolor y miedo cuando unas manos pálidas lo arrancaron de su montura. Recuerda el terror de cuando fue arrojado al abismo del Dios Muerto junto con sus hermanos, para escuchar el Canto Fúnebre y ser consumido por la nada. En las oscuras profundidades, perdieron la noción del tiempo. Sus pensamientos les abandonaron. La cordura les abandonó. No así el hambre. Se atacaron unos a otros, con sus uñas destrozadas y sus dientes hechos añicos. Entonces llegó: distante al principio, una frágil nota apenas perceptible, seguida de otra y otra, imposibles de ignorar e incesantes. El coro creció hasta transformarse en un muro viviente de sonidos que retumbaban en su mente hasta que ningún otro pensamiento pudo sobrevivir. Mientras el Canto Fúnebre le consumía, abrió sus brazos al Dios Muerto y aceptó su obliteración. Aunque su destrucción no era lo que habían planeado para él. El Dios Muerto pedía guerra. En el vientre de la gran nada, un nuevo propósito le fue asignado: difundir el Canto Fúnebre por toda la tierra y hacer que los muertos se levantaran contra los vivos. Estaba predestinado a convertirse en Undying, heraldo del Dios Muerto, para alzarse y caer y volver a alzarse cuando su cuerpo le fallara. Para caminar penosamente a través de la muerte eterna, para que el Canto Fúnebre nunca cese.";
                        break;
                    case "texto2":
                        hist = "\"Dirge\" es tanto una canción interminable como el nombre de Undying.\n" +
                                "\n" +
                                "Al igual que otros seguidores del Dios Muerto, Dirge probablemente lleva la armadura de su antigua nación, antes de ser convertido en no-muerto.\n" +
                                "\n" +
                                "Mireska ha robado valiosos objetos funerarios que una vez fueron enterrados con Undying y se niega a devolverlos.";
                        break;
                    case "frase":
                        hist = "\"Donde van los vivos, los muertos pronto los siguen\"";
                        break;
                }
                break;

            case "Ulfsaar":

                switch(tipo) {

                    case "texto1":
                        hist = "Ulfsaar el Guerrero es el miembro más fiero de la tribu ursina, protector de su tierra y de su gente. Durante los largos inviernos, mientras las madres duermen y amamantan a sus cachorros, los machos patrullan las tierras de encima. Son incansables vigilantes y defensores de sus antiguas costumbres. Oyendo tenues pero crecientes rumores de un expansivo mal, Ulfsaar se dirigió más allá de las fronteras de su boscosa y silvestre patria con el propósito de encontrar y destruir la amenaza desde la raíz antes de que ésta pudiera poner en peligro a su pueblo. Ulfsaar es una criatura orgullosa con un espíritu brillante y fuerte, totalmente digno de confianza, un firme aliado y defensor.";
                        break;
                    case "texto2":
                        hist = "Ulfsaar tiene una buena relación con Enchantress.\n" +
                                "\n" +
                                "Ulfsaar desprecia la Alquimia.\n" +
                                "\n" +
                                "Ulfsaar aborrece a los seres que retuercen o combinan las formas naturales.\n" +
                                "\n" +
                                "Ulfsaar aprendió una vez de Sylla pero también le arrancó un dedo a su mentor.\n" +
                                "\n" +
                                "Ulfsaar parece albergar una venganza contra Roshan, según su respuesta al recibir la Ofrenda de Vladmir.\n" +
                                "\n" +
                                "Durante el invierno Ulfsaar y sus hermanos ursinos patrullan las montañas heladas del norte de su tierra natal sacrificando a las bestias salvajes que puedan amenazar a sus cachorros dormidos.\n" +
                                "\n" +
                                "Al igual que sus hermanos, Ulfsaar honra a los Sangstrath que les precedieron y celebra sus leyendas.";
                        break;
                    case "texto3":
                        hist = "Ulfsaar mató una vez a un razorwyrm. Ahora utiliza sus huesos como armadura.\n" +
                                "\n" +
                                "Ulfsaar caza ravagers y lleva sus espinas en la espalda.\n" +
                                "\n" +
                                "Ulfsaar puede haber matado a uno o más cholgar y guarda sus dientes en un collar alrededor de su cuello.";
                        break;
                    case "texto4":
                        hist = "Una vez Ulfsaar quedó gravemente herido tras una batalla en una tierra helada. Un chamán lo encontró y ató su fuerza vital a los carámbanos cercanos hasta que se recuperó. Ahora posee una armadura con esos carámbanos encantados incrustados.";
                        break;
                    case "texto5":
                        hist = "Ursa trabajó una vez con Donte Panlin.";
                        break;
                    case "frase":
                        hist = "\"Es mi espíritu el que me mantiene a salvo, y no una mera armadura\"";
                        break;
                }
                break;

            case "Shendelzare":

                switch(tipo) {

                    case "texto1":
                        hist = "Incluso el Furia Celeste más satisfecho es una criatura de mal genio, con una inclinación natural a buscar venganza por la menor ofensa, pero Vengeful Spirit es la esencia de la venganza. La que una vez fuese una orgullosa y feroz heredera de los Furia Celeste, Shendelzare era la primera en la línea de sucesión al Nido Espectral, hasta que una traición de su hermana le robó su derecho de nacimiento. Atrapada en una red de asesinos, Shendelzare solo pudo liberarse a costa de sus alas, cojeando hacia lo lejos en la mayor humillación posible: a pie. Con sus alas rotas, supo que los Furia Celeste nunca la aceptarían como monarca; y en la percha más alta del Nido, inaccesible excepto para los alados, su hermana era intocable. Reacia a vivir como una lisiada no voladora y deseando la venganza mucho más que el poder terrenal, la princesa caída hizo un pacto con la diosa Scree'auk: renunció a su cuerpo roto a cambio de una imperecedera forma de energía espiritual, impulsada por la venganza, capaz de causar grandes daños en el plano material. Puede que se pase toda la eternidad sin poder volar, pero obtendrá su venganza.";
                        break;
                    case "texto2":
                        hist = "Dragonus es el amante secreto de Shendelzare.\n" +
                                "\n" +
                                "Shendelzare adora a Scree'auk, pero también a Avilliva.\n" +
                                "\n" +
                                "El Talon de Scree'auk fue probablemente hecho para Shendelzare por Dragonus.\n" +
                                "\n" +
                                "Shendelzare conoce a Puck y una vez admiró sus alas.";
                        break;
                    case "frase":
                        hist = "\"El camino de la venganza es largo, pero lo que me espera al final hace que valga la pena\"";
                        break;
                }
                break;

            case "Lesale Deathbringer":

                switch(tipo) {

                    case "texto1":
                        hist = "En las Selvas de Ácido de la Isla Jidi, el veneno corre por las venas y borbotea en las entrañas de cada criatura que horada, trepa o se desliza por las hojas cubiertas de savia cáustica. Incluso ante esta colección de animales tóxicos, Venomancer es conocido por ser el más venenoso. Hace siglos, un herbolario llamado Lesale cruzó en barca la Bahía de Fradj buscando potentes esencias que pudiesen ser extraídas de las cortezas y las raíces. En su lugar, se encontró con una terrorífica transformación. Dos leguas en el interior de la selva de Jidi, Lesale encontró un reptil camuflado como un epifito que le picó al haberlo arrancado por error. Desesperado, usó su conocimiento parcial de las hierbas de la selva y mezcló el veneno del reptil ya aplastado con el néctar de una orquídea acorazada para sintetizar un antídoto. En los momentos previos a que una oscura parálisis le invalidase por completo, se inyectó a sí mismo el antídoto usando una de las espinas de la orquídea. Cayó inmediatamente en coma.\n" +
                                "\n" +
                                "Diecisiete años después, algo se despertó en el lugar donde el herbolario había caído, quitándose de encima la vegetación acumulada con el paso de los años: Venomancer. Ya no era Lesale el Herbolario, si no Lesale, el Heraldo de la Muerte. Su mente estaba casi borrada por completo y su carne, consumida, había sido sustituida por un nuevo tipo de materia: una fusión entre el veneno del reptil y el tegumento de la orquídea. Las Selvas de Ácido de Jidi conocieron a un nuevo maestro, uno del que hasta los depredadores más voraces se escondían para salvar sus vidas. La espeluznante isla pronto se convirtió en una cárcel para la criatura y, siguiendo un instinto humano proveniente de las profundidades del corazón de Venomancer, Lesale salió en busca de nuevos venenos... y nuevas víctimas.";
                        break;
                    case "texto2":
                        hist = "Antes de entrar en la Selva Ácida, Lesale ya tenía cierto conocimiento de sus plantas y animales.\n" +
                                "\n" +
                                "El capullo de una Polilla Fradjan estaba dentro de la orquídea de la armadura que Lesale utilizó para confeccionar su antídoto. Por ello, la fisiología de la polilla se ha fusionado con su nueva forma.";
                        break;
                    case "texto3":
                        hist = "Una vez tras una batalla, Lesale se arrastró hasta una grieta en el suelo para recuperarse de sus heridas. No sabía que en ese lugar se reunían los adoradores de Aktok, un antiguo dios serpiente. Cuando los seguidores llegaron al lugar para ofrecer sus sacrificios, confundieron a Lesale con un avatar de Aktok y lo adoraron en consecuencia. Lesale aceptó sus ofrendas descansando hasta que recuperó las fuerzas y luego se levantó para seguir a los cultistas de vuelta a su pueblo donde se los comió a todos.";
                        break;
                    case "frase":
                        hist = "\"Ningún nigromante levantará lo que el venomancer haga caer\"";
                        break;
                }
                break;

            case "Viper":

                switch(tipo) {

                    case "texto1":
                        hist = "El malvado familiar de un mago sádico que le capturó con la esperanza de amaestrarlo. Así es Viper, una criatura que, curiosamente, agradeció el ser rescatada de los dominios subterráneos e inalterables de los Confines Abisales, donde su raza vivió durante millones de años después de que un deslizamiento tectónico aislase a los Dracos Abisales en cuevas luminosas. Viper pasó parte del tiempo fingiendo estar sometido a los encantamientos del mago, esperando aprender lo que pudiese de la magia oscura que el mago practicaba. Pero pronto se dio cuenta que pocos hechizos son tan mortales como las toxinas de su especie, así que, exudando un ácido que rápidamente corroyó los barrotes de su jaula, el Draco Abisal se liberó de su confinamiento, escupió veneno en los ojos del anciano hechicero y escapó para dar a conocer al mundo que tenía un nuevo maestro.";
                        break;
                    case "texto2":
                        hist = "Viper, el Netherdrake, es un único espécimen de la especie prehistórica netherdrake que habita en los subterráneos de Nether Reaches, ampliamente temido por sus potentísimos venenos y exudados ácidos.\n" +
                                "\n" +
                                "Tras una traumática experiencia de cautiverio por parte de cierto sádico y dominante practicante de la hechicería oscura, Viper jura corresponder al sufrimiento que recibió esclavizando a todos los magos de su futura colección como retribución por su sufrimiento bajo las ataduras de la hechicería y de aquellos que la manejan, al tiempo que ejerce los mismos poderes que contribuyeron a su sufrimiento.\n" +
                                "\n" +
                                "Víctima desafortunada de los intentos de un sádico hechicero por capturar a un netherdrake como mascota en las cavernas luminosas selladas de los Confines del Infierno, Viper pronto se daría cuenta de que su libertad era el comienzo de su esclavitud. De naturaleza malévola, Viper esperaba aprender de la magia oscura de su captor, sometiéndose a propósito a sus hechizos para aprenderlos a un nivel práctico y dolorosamente físico.\n" +
                                "\n" +
                                "Aunque pudo soportar la mayoría de sus hechizos pronto se dio cuenta de que algunos de ellos eran demasiado potentes para él. No queriendo arriesgar más su vida, corroyó los barrotes de su jaula y escupió veneno a los ojos de su captor antes de soltarse finalmente al mundo.";
                        break;
                    case "texto3":
                        hist = "Años después de su fuga, la alegría que sentía Viper por su huida pronto se convirtió en hartazgo. Sentía que su existencia estaba vacía por el hecho de que su captor seguía en este mundo. Voló para vengarse de Pugna una vez más para aliviar su trauma pero rápidamente se dio cuenta de que Pugna era sólo una parte de un problema mayor que se le había escapado. La existencia hueca de Viper \n" +
                                "se llenó de una realización maligna: ¿por qué esclavizar a su antiguo maestro cuando podía esclavizar a todos los que eran como él? Muchos magos como él invocan a sus familiares y les conceden la bendición de la vida sólo para dejarlos vivir en la servidumbre. Y muchos más se sumergen en la magia con el propósito de controlar a otros. Viper no podía soportar la idea de eso.\n" +
                                "\n" +
                                "Así fue como Viper se iluminó. Salió con un nuevo propósito de esclavizar a todos los que practican las viles artes de la hechicería y mantenerlos como mascotas en su zoológico de magos. No ha olvidado a Pugna, pues no es más que una mascota que pronto encarcelará entre los demás que son iguales a él.";
                        break;
                    case "texto4":
                        hist = "Viper  ya era una criatura malévola antes de ser invocada por Pugna. Durante su tiempo como mascota de Pugna, éste le enseñó a ser sádico pero los malos tratos de Pugna también le han influido indirectamente para esclavizar y dominar a otros, un rasgo que también ha heredado.\n" +
                                "\n" +
                                "Viper es un hipócrita. Le disgusta ser esclavizado y los que esclavizan a otros pero está dispuesto a esclavizar a otros y a explotar a los que tienen el poder de controlar a otros.\n" +
                                "\n" +
                                "Viper es una criatura sorprendentemente inteligente e inquisitiva. La magia es un proceso mnemotécnico y agotador pero Viper ha aprendido mucho sobre la magia y el lanzamiento de hechizos sólo con observar a su antiguo amo mientras estaba cautivo.";
                        break;
                    case "texto5":
                        hist = "En Underlords, Viper parece respetar a aquellos que desprecian la magia, como Anti-Mage. También parece estar preocupado por lo que Ethreain hizo a Winter Wyvern.\n" +
                                "\n" +
                                "Pugna esclavizó al netherdrake y lo mantuvo como su mascota. Ahora busca vengarse de él por el trauma que sufrió bajo su servidumbre.\n" +
                                "\n" +
                                "Viper está en una cruzada contra la magia y es hostil a cualquiera que la practique. En Artifact intenta esclavizar a los hechiceros Lich y Crystal Maiden. Los poderes de cautivación de Chen han despertado su interés y desea convertirlo en el guardián de su zoológico. También quiere mantener a Enchantress como mascota.\n" +
                                "\n" +
                                "En Artifact, parece no gustarle Kanna ni Prellex. Le disgusta la primera por sus poderes de control mental y considera que su madre no es diferente a ella.\n" +
                                "\n" +
                                "En Underlords, Viper anima a las hermanas elementales Rylai y Lina a matarse mutuamente.\n" +
                                "\n" +
                                "Probablemente como una coincidencia Viper busca reclamar la ciudad mágica de Weeping Rose al igual que su antiguo maestro Pugna.";
                        break;
                    case "frase":
                        hist = "\"Has fallado en la prueba del ácido\"";
                        break;
                }
                break;

            case "Visage":

                switch(tipo) {

                    case "texto1":
                        hist = "En lo alto de la entrada del Laberinto Angosto, contemplando eternamente los caminos hacia el más allá, reposan las amenazadoras formas de gárgolas burlonas. Bestias y pájaros, hombres y monstruos, todas las criaturas que mueren y eligen caminar por esas sendas algún día tienen que pasar por debajo de sus ojos. Para un espíritu sin ataduras, la decisión de viajar a través del velo de la muerte es irrevocable. Cuando llega la oportunidad, y por arte o por astucia algún alma inquieta huye de sus cielos o infiernos, es la temida gárgola Visage, la forma que encierra al espíritu eterno Necro'lic, la que se encarga de recuperarla. Despiadada y eficiente, sin ser estorbada por los principios de la muerte y la fatiga, Visage acecha a su presa sin piedad ni fin, con la voluntad de destruir a todo aquel que pueda dar cobijo a la esencia fugitiva. Los que burlen las leyes de la otra vida jamás tendrán descanso, pues si bien es cierto que los muertos pueden resucitar, es solo cuestión de tiempo antes de que Visage los encuentre y los devuelva a su debido lugar.";
                        break;
                    case "texto2":
                        hist = "Visage es el nombre de la forma de gárgola que utiliza Necro'lic. Mientras que el propio Necro'lic es el espíritu que vive dentro de la gárgola.\n" +
                                "\n" +
                                "Necro'lic conoce a Razor ya que ambos están ligados al Underscape. Cuando ve a Razor fuera de Underscape le regaña por no vigilarlo.\n" +
                                "\n" +
                                "Necro'lic siente una especial aversión por los inmortales y los no muertos. También desaprueba que las almas sean capturadas por Shadow Fiend.\n" +
                                "\n" +
                                "Al parecer, Necro'lic ha enviado varias veces a Lion hacia los infiernos.";
                        break;
                    case "frase":
                        hist = "\"Una cosa es animar un cadáver de debajo de la tierra. Otra cosa es arrancar un alma de más allá del velo\"";
                        break;
                }
                break;

            case "Inai":

                switch(tipo) {

                    case "texto1":
                        hist = "Ni aun los otros espíritus afirman entender la mente y las maquinaciones del más antiguo de ellos, Inai, el Espíritu del Vacío (Void Spirit). Él, conocedor de secretos que destrozarían una mente mortal, observa el funcionamiento del universo desde una atalaya incognoscible, dejando que unos sirvientes cuidadosamente preparados cumplan su voluntad, y solo emerge al plano material desde su Templo Oculto cuando considera que únicamente él puede dirigir el curso de la realidad por el camino adecuado.\n" +
                                "\n" +
                                "Inai, con una amplia perspectiva de la existencia, centra fijamente su atención en un punto del tiempo más allá del cual no puede ver, cuando los tejidos de las múltiples realidades están destinados a chocar. Ahora abandona el éter para resolver personalmente la batalla de los Ancestros y preparar a sus aliados para lo que él considera un conflicto mayor que está por venir.";
                        break;
                    case "texto2":
                        hist = "Inai es el primero de los celestiales, representa el vacío. Se le conoce como el Oculto y reside en el Templo Oculto, sólo emerge para participar en la batalla de los Ancestros en el plano mortal. Aun así es capaz de crear desgarros en el Plano Astral lo que le permite atravesar y dañar todo lo que se encuentra a su paso. Instruye a otros, como Lanaya, para que cumplan sus órdenes, todo ello permaneciendo oculto para todos, excepto para unos pocos.\n" +
                                "\n" +
                                "Ahora que ha entrado en el reino de los mortales Inai busca unirse con todos los demás celestiales en un evento que llama la Gran Confluencia.";
                        break;
                    case "texto3":
                        hist = "Tras tomar forma mortal hace mucho tiempo Inai construyó un templo para albergar su cuerpo y sus artefactos. El templo es difícil de encontrar para todos excepto para aquellos que él permite que se encuentren con él.\n" +
                                "\n" +
                                "El padre de Mireska gastó gran parte de su oro tratando de encontrar el templo sin éxito.";
                        break;
                    case "texto4":
                        hist = "Lanaya es una de las pocas mortales a las que se les permitió ver el Templo Oculto y entrar en él. Ahora cumple las órdenes de Inai a cambio de secretos. Mercurial también sirve a Inai pero no siempre sigue sus instrucciones.\n" +
                                "\n" +
                                "Inai siente un gran respeto por los monjes korumitas que eran eruditos que estudiaban tanto las artes marciales como las mágicas. Respeta su legado en el sentido de que casi nadie recuerda quiénes eran de forma similar a la inclinación del Espíritu Vacío por el secreto. Su templo está construido en base a un diseño korumita.\n" +
                                "\n" +
                                "Los monjes de Turstarkuri siguen las enseñanzas de Inai aunque éste dice que malinterpretaron su significado y fueron consumidos por su locura cuando fueron destruidos por las legiones del Dios Muerto.\n" +
                                "\n" +
                                "Sintiendo los problemas de Earthshaker que comenzaron cuando recibió un trozo de su hermana la tierra Inai le ofrece respuestas.\n" +
                                "\n" +
                                "El elementalista Thunderkeg se topó con un hechizo para invocar al Raijin celestial sin saber que el hechizo había sido plantado para que lo descubriera Inai.\n" +
                                "\n" +
                                "Inai buscó una vez al Maestro de Barathrum por razones desconocidas.\n" +
                                "\n" +
                                "Inai está familiarizado con Echo Sabre ya que lo ha sostenido en una ocasión. No le gusta estar en el plano mortal pero encuentra a los mortales divertidos.";
                        break;
                    case "frase":
                        hist = "\"Amigo o enemigo, en la estela de la confluencia seguirás donde yo te guíe\"";
                        break;
                }
                break;

            case "Demnok Lannik":

                switch(tipo) {

                    case "texto1":
                        hist = "Como conservador jefe y director de adquisiciones para los Archivos Arcanos de la Academia Ultimyr, Demnok Lannik era incansable en su búsqueda de tomos perdidos, poco comunes y prohibidos. Ningún templo maldito era tan inquietante ni ninguna caverna era tan peligrosa como para que la más mínima preocupación por su propia supervivencia pudiera disuadirle de entrar si los rumores indicaban que algún pergamino de sabiduría ancestral podía encontrarse aún en sus profundidades. Sin embargo, sus investigaciones solían despertar bastante a menudo la ira de entes guardianes, por lo que vio necesario dominar el arte de la magia. Se dedicó a aprender hechicería con el mismo ímpetu meticuloso que lo había caracterizado en su búsqueda de incunables, convirtiéndose en el mejor Hechicero (Warlock) de la Academia en menos tiempo del que la mayoría de practicantes necesitaban para completar un curso básico. Mientras estaba en ello, talló un bastón de madera sombría e imbuyó en él a un espíritu cautivo de los Infiernos Exteriores. Además, anticipándose al día en el que haya recopilado hasta el último tomo de magia perdido, ha comenzado a escribir su propio Grimorio Oscuro. Sin duda, será muy instructivo.";
                        break;
                    case "texto2":
                        hist = "Un ritmo acompasado de golpes y el tintineo de un farol encadenado anuncian la presencia de Demnok Lannik, el Brujo de la Academia Ultimyr. La obsesión de este extraño bibliotecario le ha convertido en un recipiente de conocimiento prohibido y de ese conocimiento surgen los oscuros misterios del mundo arcano que ayudarán a sus agradecidos aliados o eliminarán a sus desaprendidos enemigos.\n" +
                                "\n" +
                                "Demnok Lannik es el conservador jefe y responsable de adquisiciones de los vastos archivos arcanos de la Academia Ultimyr. Su trabajo consiste en adquirir nuevos textos para ampliar el vasto almacén de conocimientos de los archivos y supervisar el contenido de los mismos para su custodia. A diferencia de la mayoría de la gente Demnok siente una pasión enfermiza por su profesión. La mayoría de las personas poco entusiastas se conformarían con no desperdiciar su vida por su trabajo, algunas pueden dedicar su ser a su profesión hasta un punto que no las mate pero la terquedad de Demnok ha arriesgado su vida una y otra vez en la búsqueda de conocimientos perdidos en las profundidades del peligro alimentado por el más mínimo rumor de su existencia.\n" +
                                "\n" +
                                "Con el tiempo sus investigaciones en busca de textos perdidos han desencadenado a menudo la ira de entidades protectoras, lo que le ha obligado a dominar la hechicería para contrarrestar cualquier atentado contra su vida mientras sigue investigando. Con la misma pasión por su trabajo se matriculó en la misma academia en la que trabajaba y se convirtió en el Brujo más poderoso de la academia jamás conocido en menos tiempo del que la mayoría de los practicantes necesitan para completar un curso de licenciatura. Para equiparse como brujo, talló un báculo de madera de terror, invocó a un espíritu demoníaco de los infiernos exteriores y lo unió a su báculo, todo ello hecho a posteriori. Ahora que está bien equipado para sus esfuerzos, Demnok ha comenzado a escribir su Grimorio Negro: el cuerpo definitivo y compuesto de todo el conocimiento arcano que este mundo ha logrado comprender y registrar.";
                        break;
                    case "texto3":
                        hist = "Cuando no está buscando tomos perdidos, el archivero Demnok es el guardián de los archivos. El eslogan de Demnok, \"Todo lo que tomas prestado debes devolver\" anima a los prestatarios a devolver sus libros para que no les visite una presencia oscura sellada dentro de su malvado bolso.\n" +
                                "\n" +
                                "Su dedicación a la búsqueda del conocimiento ha ampliado enormemente los archivos de información arcana de la Academia lo que le ha valido el respeto tentativo del profesorado de la Academia.\n" +
                                "\n" +
                                "Fuera de su trabajo Demnok aspira a ganarse un puesto entre el consejo de treinta y un magos que gobiernan la Rosa Llorona. También desea devolver a los Oglodi a la prominencia, posiblemente aspirando a restaurar los Oglodi intelectuales y esotéricos antes de que fueran destruidos por los Tarnsmen.";
                        break;
                    case "texto4":
                        hist = "Demnok es una persona muy curiosa. Se necesita muy poco esfuerzo para despertar su curiosidad y mucho para saciar su sed de conocimiento ya que ni siquiera las amenazas de peligro potencial pueden detenerlo. Aunque al principio aprendió demonología como una mera ocurrencia, su curiosidad ha acabado por convertirla en una de sus ciencias principales y le ha llevado a profundizar en el aprendizaje y el trato con el peligroso mundo de los demonios.\n" +
                                "\n" +
                                "Como profesional académico, el sabio Demnok valora el conocimiento y es instructivo con él. Sólo él asume voluntariamente la carga de cuidar el mayor depósito de conocimiento arcano propiedad de los mortales y se jacta de ser el que más contribuye a los archivos arcanos. Escribió el Grimorio Negro con el único propósito de hacer un libro instructivo sobre todo el conocimiento arcano. \n" +
                                "\n" +
                                "Fuera de su trabajo, está dispuesto a enseñar a otros incluso habilidades simples como la lectura.\n" +
                                "\n" +
                                "La búsqueda del conocimiento por parte de Demnok le ha llevado a la maldad, tal y como afirma Windranger.\n" +
                                "\n" +
                                "Además de la preocupación de sus compañeros de facultad por sus peculiares estudios, quizás esta maldad se refleje también en sus respuestas de voz, donde habla con frecuencia de ardor, caos, oscuridad, demonios, etc.";
                        break;
                    case "texto5":
                        hist = "Demnok es muy respetado entre el profesorado de la Academia Ultimyr por sus esfuerzos, a pesar de la preocupación de éstos por su extraño interés en la demonología y la magia oscura.\n" +
                                "\n" +
                                "El yo más joven de Invoker afirma conocer al gran, gran... antepasado de Demnok, que también trabajaba en la Academia Ultimyr, lo que insinúa que Demnok pertenece a un largo linaje de profesionales académicos dedicados a Ultimyr.\n" +
                                "\n" +
                                "Aunque se ha distanciado de los Oglodi aprueba luchar junto a algunos de ellos incluido Demnok. También se arrepiente de haberlos matado mientras no sean de la Niebla Roja. Por otro lado a Demnok le disgusta el analfabetismo de Axe, cosa que pretende resolver si Axe lo hace bien.\n" +
                                "\n" +
                                "Disruptor respeta a Demnok como un sabio Oglodi pero cree que está mal orientado.\n" +
                                "\n" +
                                "Bristleback generaliza y respeta a los Oglodi por su dureza sin exceptuar al bibliófilo Demnok.\n" +
                                "\n" +
                                "Demnok ha preguntado a Ogre Magi sobre su sabiduría y magia. Por otro lado, a Aggron le gusta Demnok, dirigiéndose a veces a él como Sr. Warlock. También le gusta jugar con su invocación demoníaca.\n" +
                                "\n" +
                                "Demnok ha sido objeto de burlas por parte de los verdaderos demonios que se da a entender que son más grandes que los demonios inferiores que él controla. Por sus burlas, desea darles su merecido con un objeto de poder mayor que puede enseñar a mendigar incluso a los demonios.\n" +
                                "\n" +
                                "Su búsqueda de conocimientos en el campo de la demonología no ha pasado desapercibida. La demonio terrestre Anessix quiere castigar a Demnok por revelar demasiados secretos.\n" +
                                "\n" +
                                "Como se revela en Underlords Rubick es el rival de Demnok, aunque el primero no sea consciente de ello. Demnok afirma que él debería ser el verdadero heredero de Aghanim y no Rubick.";
                        break;
                    case "frase":
                        hist = "\"¡El caos viene a mis órdenes!\"";
                        break;
                }
                break;

            case "Skitskurr":

                switch(tipo) {

                    case "texto1":
                        hist = "El tejido de la creación requiere de una constante atención, por si acaso se desgarra; porque cuando esto ocurre, mundos enteros se deshacen. Es la responsabilidad de los Tejedores (Weavers) mantener el tejido en buen estado y reparar los desgarros de la malla de la realidad. También lo defienden de los seres que lo roen y depositan sus huevos en las regiones más raídas, ya que esas crías pueden devorar rápidamente un universo entero si los Tejedores no prestan suficiente atención. Skitskurr era un maestro Tejedor, encargado de mantener una pequeña parte de la creación en perfecto estado y sin deshilacharse. Pero este trabajo no era suficiente para satisfacerlo. Le fastidiaba que todo el trabajo original de la creación se hubiera hecho en el pasado; el Telar había hecho su trabajo y había seguido adelante. Él prefería crear, no realizar un simple mantenimiento... tejer los mundos que concebía en su mente. Comenzó realizando pequeños cambios en sus dominios, pero el ansia de la creación era realmente adictiva y sus costuras eran cada vez más osadas, pues no seguían el patrón que el Telar había creado originalmente.\n" +
                                "\n" +
                                "Los guardianes llegaron, con sus tijeras, y el mundo del Tejedor fue descosido, separado del tapiz cósmico, y fue tejido de nuevo pero sin él. Skitskurr se vio solo, separado de los suyos, un estado que habría resultado una tortura para cualquier otro Tejedor. Sin embargo Skitskurr se alegró, ahora era libre. Libre para crear por sí mismo, para empezar de cero. Los materiales que necesitaba para tejer una nueva realidad estaban por todas partes a su alrededor. Lo único que tenía que hacer era descoser este viejo mundo de una vez por todas.";
                        break;
                    case "texto2":
                        hist = "Skitskurr es uno de los muchos weavers.\n" +
                                "\n" +
                                "La nueva tela de la realidad de Skitskurr está tejida con los hilos del conflicto.\n" +
                                "\n" +
                                "Skitskurr encontró una nueva arma, el Skittering Desolation, cuando se deslizó en el tiempo.\n" +
                                "\n" +
                                "El exoesqueleto de Skitskurr está hecho de quitina.\n" +
                                "\n" +
                                "Las antenas de Skitskurr están en sintonía con cualquier cambio en el tejido de la realidad.\n" +
                                "\n" +
                                "El caparazón de Skitskurr le avisa del calor de las nuevas realidades creables.";
                        break;
                    case "frase":
                        hist = "\"El destino teje los hilos de nuestras vidas. El destino también empuña la espada que los corta\"";
                        break;
                }
                break;

            case "Lyralei":

                switch(tipo) {

                    case "texto1":
                        hist = "Los bosques occidentales guardan bien sus secretos. Uno de ellos es Lyralei, maestro arquero del bosque y ahijado favorito del viento. Conocida ahora como Windranger, la familia de Lyralei murió en una tormenta la noche de su nacimiento: su casa fue derribada por el vendaval y el contenido se dispersó por los vientos. Solo el recién nacido sobrevivió entre el campo de escombros de muerte y destrucción. En la tranquilidad que siguió a la tormenta, el propio viento se dio cuenta del llanto del afortunado bebé en la hierba. El viento se compadeció de la niña y la levantó hacia el cielo y la depositó en el umbral de una aldea vecina. En los años que siguieron, el viento volvió ocasionalmente a la vida de la niña, observándola desde la distancia mientras perfeccionaba sus habilidades. Ahora, después de muchos años de entrenamiento, Windranger dispara sus flechas certeras a sus objetivos. Ella se mueve con una velocidad cegadora, como acelerado por un viento siempre a su espalda. Con una ráfaga de flechas, masacra a sus enemigos, habiéndose convertido ella misma, casi, en una fuerza de la naturaleza.";
                        break;
                    case "texto2":
                        hist = "Aunque Lyralei nunca conoció a su familia ni a su pueblo Grimstroke sugiere que era mejor no conocerlos.";
                        break;
                    case "texto3":
                        hist = "Lyralei es la principal rival de Traxex y a menudo dice cosas malas sobre ella. Según Lyralei Traxex es una \"cáscara emocionalmente vacía de tristeza perpetua\", Traxex responde llamando a Lyralei \"completamente inútil\".";
                        break;
                    case "texto4":
                        hist = "Antecedentes\n" +
                                "Aunque Lyralei nunca conoció a su familia ni a su pueblo Grimstroke sugiere que era mejor no conocerlos.\n" +
                                "\n" +
                                "\n" +
                                "Relaciones\n" +
                                "Lyralei es la principal rival de Traxex y a menudo dice cosas malas sobre ella. Según Lyralei Traxex es una \"cáscara emocionalmente vacía de tristeza perpetua\", Traxex responde llamando a Lyralei \"completamente inútil\".";
                        break;
                    case "frase":
                        hist = "\"Si al principio no tienes éxito, acércate, dispara de nuevo\"";
                        break;
                }
                break;

            case "Auroth":

                switch(tipo) {

                    case "texto1":
                        hist = "Al igual que muchos grandes poetas, Auroth solo desea tiempo para escribir, pero la vida de la Wyvern Invernal está repleta de interrupciones. Las epopeyas de los Eldwurms tienen una extensa e interesante historia, pero algunos temen que los eruditos dragones que quedan no sean tan prolíficos como antaño, con apenas unas líneas añadidas al Eddas de los Eldwurm desde la última edad de grandeza. Auroth se lamenta: «Olvidamos que hay más vida que el triunfo y el dominio sobre los enemigos. Debemos, también, vivir nuestras vidas en búsqueda de la expresión creativa». Se embarca en expediciones de investigación, recopilando libros para su inspiración. Pero toda esta investigación puede llegar a ser terriblemente distractoria e invierte menos tiempo escribiendo del que debería. Pese a que ella sabe que debería estar holgazaneando en su guarida, expandiendo el Eddas, a menudo se ve involucrada en épicas batallas frente a poderosos enemigos. Saquea castillos, asalta antiguas bibliotecas... y si tiene la suerte de vanagloriarse en el proceso, se dice a sí misma que es simplemente un efecto secundario de su investigación. El hecho es que, mientras que su habilidad y poder en batalla son legendarios, sus trabajos como erudita apenas han logrado un ápice de reconocimiento literario. Pero ella no se contenta con protagonizar historias heroicas. También desea crearlas.";
                        break;
                    case "texto2":
                        hist = "Según Mercurial, Auroth es el eldwurm más antiguo.\n" +
                                "\n" +
                                "Junto con Rylai, Auroth lleva a Davion, Bram, Kaden y Fymwryn a un lugar seguro.\n" +
                                "\n" +
                                "Más tarde, sacrifica su vida para proteger a Bram, Marci y Mirana después de ser asesinada por el virrey Kashurra.\n" +
                                "\n" +
                                "Beatrix Snapfire y Bram disfrutan de la poesía de Auroth.";
                        break;
                    case "frase":
                        hist = "\"Algunos respiran fuego. Yo respiro hielo\"";
                        break;
                }
                break;

            case "Zharvakko":

                switch(tipo) {

                    case "texto1":
                        hist = "Una estrambótica figura se acerca torpemente. Irregular en sus extremidades y en su aspecto, destartalada en sus andares, zigzaguea tenazmente por el campo de batalla en busca de ese fundamental punto débil donde sus talentos puedan beneficiar y perjudicar tanto como sea posible. No está claro si está estropeada o mal hecha, aún así, nadie puede dudar del poder que posee en su físico contrahecho. Un largo bastón aporrea la tierra cuando Zharvakko el Curandero (Witch Doctor) avanza, desplegando un terrible arsenal de fetiches, conjuros y maleficios. Es un amasijo de conocimientos mágicos aprendidos y perfeccionados durante siglos en las montañas de la isla de Arktura, ahora empleados con precisión contra sus enemigos. Zharvakko puede ser tu mejor amigo o tu peor rival, sanando aliados y destrozando a todo el que se le oponga.";
                        break;
                    case "frase":
                        hist = "\"La mala praxis hace la perfección\"";
                        break;
                }
                break;

            case "Ostarion":

                switch(tipo) {

                    case "texto1":
                        hist = "Durante incontables años, el Rey Ostarion construyó un reino a partir de los restos de sus enemigos. Fue la obra de un obseso, realizada para perdurar durante la eternidad de una monarquía que parecía destinada a no terminar nunca. Él creía que mientras continuara alzando las torres de su palacio, no podría morir. Pero con el tiempo se dio cuenta de que se había estado engañando... que los huesos podían perecer. Profundamente receloso de la carne, buscó un modo más permanente de prolongar su reinado, y al final se decidió por la búsqueda de la energía espectral, una forma de espíritu puro que desprenden ciertas almas oscuras al morir. Creía que si se imbuía de Esencia Espectral podría crear un cuerpo tan luminoso y eterno como su ego. En el solsticio milenario conocido como la Noche Espectral, se sometió a un ritual de transformación, obligando a sus súbditos a cosechar suficientes almas para alimentar su ambición por la inmortalidad. Nadie sabe cuántos de sus campeones murieron, porque el único superviviente que importaba era el Rey Espectral (Wraith King) que se levantó con el sol a la mañana siguiente. Ahora rara vez pasa un momento en su trono resplandeciente; sino que se pasea dando zancadas con la espada desenvainada, exigiendo una lealtad que se extiende más allá de la muerte.";
                        break;
                    case "texto2":
                        hist = "En sus conquistas Ostarion llegó al reino del duque de Levinthal. Durante días, sus ejércitos no muertos asediaron la ciudad. Por fin el duque salió a caballo para enfrentarse a Ostarion en combate personal en un último acto de valiente desafío. Ostarion lo mató, y tomó su enorme espada rota como muestra.";
                        break;
                    case "texto3":
                        hist = "Ostarion era conocido anteriormente como el Rey Esqueleto (Skeleton King), renacido como Rey Espectro Wraith King después de la ceremonia de Wraith-Night. Debido a esta historia, Ostarion sigue siendo conocido a veces como el Señor de los huesos.\n" +
                                "\n" +
                                "Ostarion considera que todos los campeones que murieron por él durante la Noche de los Espectros son su legítimo tributo.\n" +
                                "\n" +
                                "Después de la Noche de los Espectros Ostarion apenas se acuerda de su primer reino, cuando aún estaba creado de hueso.\n" +
                                "\n" +
                                "A Ostarion le gusta tomar las coronas y adornos de sus enemigos asesinados, usándolos para sí mismo.\n" +
                                "\n" +
                                "Los sirvientes de Ostarion le hicieron una espada con los huesos y las armaduras de los reyes caídos.\n" +
                                "\n" +
                                "Ostarion mató al Dreadknight junto con su cómplice Magnoceros.\n" +
                                "\n" +
                                "Ostarion parece tener afinidad con Queen of Pain.\n" +
                                "\n" +
                                "Cuando Ostarion atravesaba la barrera entre los planos, probablemente en proceso de resurrección, fue atacado por una fuerza etérea de fuego arremolinado que iba a devolverle al abismo sin fin. Con su puño cubierto de cota de malla, contraatacó al fuego con fuerza bruta hasta que fue liberado y se encontró de nuevo en el Plano Terreno. Esta serie de sucesos está posiblemente referenciada en su respuesta de muerte contra Shadow Fiend.\n" +
                                "\n" +
                                "En una ocasión un reino que pretendía conquistar ofreció a Ostarion una espada como muestra de rendición pacífica. Sin embargo este gesto no le convenció para perdonar al reino.\n" +
                                "\n" +
                                "Ostarion probablemente mató al dragón no muerto Ambinderath. Posee una espada fabricada con su mandíbula.\n" +
                                "\n" +
                                "Cuando los súbditos de Ostarion mueren se unen mágicamente al Rey Espectro y le sirven como guerreros esqueléticos que brillan con lo que parece ser la misma esencia de la que él está hecho.\n" +
                                "\n" +
                                "Aunque Ostarion es imposible de matar puede ser detenido temporalmente. En una ocasión fue derrotado por The Chainbreaker y The Bloodletter usando Silver Edge.";
                        break;
                    case "frase":
                        hist = "\"Más pura que la carne, más fuerte que el hueso, imperecedera es la esencia del espectro\"";
                        break;
                }
                break;

            case "Zeus":

                switch(tipo) {

                    case "texto1":
                        hist = "Señor de los Cielos, padre de dioses, Zeus trata a todos los Héroes como si fueran sus ruidosos hijos rebeldes. Tras ser sorprendido innumerables veces en mitad de encuentros con incontables mujeres mortales, su divina esposa le dio finalmente un ultimátum: «Si amas tanto a los mortales, ve y conviértete en uno de ellos. Si consigues demostrar que eres fiel, entonces vuelve a mí como mi inmortal marido. De lo contrario, ve y muere entre tus criaturas». Zeus encontró su lógica (y su magia) irrefutable y aceptó su plan. Él ha mantenido su mejor comportamiento desde entonces, apreciando algo más la inmortalidad que a los mortales. Pero para demostrarse a sí mismo que es digno de su eterna esposa, él tendrá que seguir buscando la victoria en el campo de batalla.";
                        break;
                    case "texto2":
                        hist = "Cuando las nubes de la tormenta se reúnan para oscurecer los días más soleados y los cielos más claros, la única luz iluminadora en los cielos será el rayo de Zeus, el todopoderoso Señor del Cielo y padre de los dioses. Divorciado, desterrado y desposeído por su divina esposa de su propio panteón para vivir la vida de un mortal tras ser sorprendido acostándose con demasiadas mujeres mortales, ahora lucha en la guerra de los Ancestros para demostrar que es digno de su esposa Hera y de su largamente perdida divinidad e inmortalidad.\n" +
                                "\n" +
                                "Descendiendo de los Cielos y de su claustro montañoso, la llegada de Zeus al mayor campo de batalla de todos los Siete Planos y del tiempo y el espacio anuncia una previsión de rayos celestiales con posibilidad de arquear la electricidad y de golpear globalmente, sacudiendo el ya frágil mundo de los mortales e incluso los cielos de arriba con tales poderes celestiales contenidos en un solo recipiente mortal.\n" +
                                "\n" +
                                "Zeus es el rey y padre de los dioses que además trata a todos los Héroes como si fueran sus hijos revoltosos. A pesar de este título se ha aficionado a las mujeres mortales y ha sido sorprendido engañando a su esposa divina por una incontable cantidad de aventuras con mujeres mortales. Hera, cansada de sus impulsos de doble juego, finalmente le dio un ultimátum: \"Si tanto amas a las mortales ve y conviértete en uno. Si puedes demostrar tu fidelidad vuelve a mí como mi marido inmortal. Si no vete y muere entre tus criaturas\". Zeus encontró su lógica y su magia irrefutable, y accedió a su plan.\n" +
                                "\n" +
                                "La mayor parte de su poder divino le fue arrebatado y finalmente fue convertido en mortal para caminar entre ellos en el mundo mundano. Desde que fue degradado se ha comportado de la mejor manera posible por primera vez en su vida, controlando sus impulsos y teniendo más cariño a su antigua inmortalidad que a los mortales. Pero para demostrar que es digno de su esposa Hera y volver a ascender a los cielos debe seguir buscando la victoria en el campo de batalla.";
                        break;
                    case "texto3":
                        hist = "Apenas preocupado por los asuntos de los mortales (incluida la batalla a tres bandas entre la Legión de Bronce, los Vhoul y la Niebla Roja), Zeus encontró su propia batalla que librar cuando se enteró del dominio del Espíritu de la Tormenta sobre las tormentas. Al no querer compartir el título y la autoridad sobre su elemento, viaja a Roseleaf (a pie) para enfrentarse a él y demostrar al mundo que Zeus es el único dios del rayo.\n" +
                                "\n" +
                                "Cada vez que él y Espíritu de Tormenta tienen que encontrarse siempre acaban lidiando con las posturas del otro antes de tener una conversación seria. Zeus también tuvo una competición de poder contra Espíritu de Tormenta en la que Zeus ganó el primer punto al destruir un edificio. En respuesta a la hazaña de Zeus, Storm Spirit destruyó todo un ejército para zanjar el asunto. Frustrado, el dios mortal tuvo una rabieta y redujo una ciudad entera a un cráter.";
                        break;
                    case "texto4":
                        hist = "Incluso en su forma mortal Zeus conserva su personalidad divina y sus gestos.\n" +
                                "\n" +
                                "Al igual que su homólogo en la vida real Zeus es un hombre muy lujurioso con preferencia por las mujeres mortales. Su atracción por las mortales es su impulso más bajo que lucha por controlar de acuerdo con su juramento a Hera.\n" +
                                "\n" +
                                "En cuanto a su impulso, lo controla muy mal, lo que le hace tomar malas decisiones y tener rabietas.";
                        break;
                    case "texto5":
                        hist = "La familia divina de Zeus sigue siendo mayoritariamente la misma en el lore de Dota 2. Su padre es un titán sin nombre al que derrocó junto a los demás titanes durante su ascenso al poder como rey de los dioses. Antes de que su padre muriera es posible que le advirtiera que matara a su propio hijo, pues él también repetiría el ciclo del parricidio y lo derrocaría a él y a su familia con el tiempo. Mucho después de la muerte de su padre Zeus lo ha estado buscando.\n" +
                                "\n" +
                                "Le ha sido muy infiel a su esposa Hera después de engañarla con sus numerosos escarceos con mujeres mortales. Debido a esto puede regodearse en su marido cuando éste se encuentra en un suceso desafortunado. Con el tiempo ha ido recuperando poco a poco la confianza y la relación con su esposa.\n" +
                                "\n" +
                                "Mars y Zeus tienen una relación muy complicada.\n" +
                                "\n" +
                                "Habiendo renegado de su familia divina (y del nombre que le dio su padre) el objetivo de Marte es destruir a su padre y a su parentela divina que lo juzgó como despreciable en unos ciclos mortales de parricidio para poder castigarlos finalmente por haberle vilipendiado, por su egoísmo y por su escasa autoridad como dioses.\n" +
                                "\n" +
                                "Marte no quiere reconciliarse con su padre y odia lo que representa.\n" +
                                "\n" +
                                "Marte se avergüenza de saber que no llegó a sobrevivir a su padre y se enfada si es asesinado por éste.\n" +
                                "\n" +
                                "Por otro lado Zeus tiene una variedad de sentimientos hacia él, desde la hostilidad recíproca hasta el afecto paternal. Zeus puede sentirse un poco orgulloso de Marte, advertirle del inevitable ciclo del parricidio o perdonarlo por seguir simplemente el ciclo del parricidio si muere por su mano. A veces, Zeus se entristece y llora a su hijo si lo mata.\n" +
                                "\n" +
                                "Zeus nos dice que Marte heredó sus rasgos de su madre por lo que puede culpar a su esposa de todo el asunto.\n" +
                                "\n" +
                                "Poseidón y Hades son sus únicos hermanos.\n" +
                                "\n" +
                                "El dios de la forja Vulcano podría ser su hijo, si se utiliza el árbol genealógico real del panteón griego.\n" +
                                "\n" +
                                "La Omnisciencia conoce a Zeus y tiene algo que decirle, Zeus le dice al agente de la Omnisciencia que le envíe sus saludos.\n" +
                                "\n" +
                                "Al conocer a Luna, siente curiosidad por su fe hacia Selemene y desea conocerla personalmente.\n" +
                                "\n" +
                                "Zeus conoce a Narciso.\n" +
                                "\n" +
                                "Bristleback es uno de los compañeros de bebida favoritos de Zeus.\n" +
                                "\n" +
                                "A Zeus parece gustarle la sabiduría de Snapfire y le gusta el sabor de sus galletas horneadas. Cuando se enfrenta a ella intenta no pelear con Beatrix y se pone triste si la mata.\n" +
                                "\n" +
                                "Arc Warden ha reclutado a Zeus en su ejército contra los dos Ancestros. Incluso intentó charlar con el Ser con su historia de divorcio y algo de ambrosía pero Zet rechazó amablemente sus avances porque estaba ocupado por la noche.\n" +
                                "\n" +
                                "Mientras estaba en Sundered Moon Zeus coqueteó con Medusa. Incluso cuando ella no está cerca, a veces desea que ella vea sus hazañas y logros.\n" +
                                "\n" +
                                "Zeus intentó coquetear con Hoodwink convirtiéndose en una variedad de animales pero a ella no le importó y lo rechazó de todos modos.\n" +
                                "\n" +
                                "Su principal rival es Storm Spirit porque Zeus no quería compartir el título y la autoridad de una deidad del trueno. Por otro lado el rebelde Raijin se negó a inclinarse ante cualquier tipo de divinidad ni quiso reconocerlo como \"Dios del Trueno\" ya que encarnaba todos los elementos de la propia tempestad y Raijin no comparte lo que cree que es suyo por derecho.\n" +
                                "\n" +
                                "Es interesante observar que, durante los tiempos en que lucharon, ambos tienen algún aspecto de mortalidad. Raijin es un Celestial atrapado en el cuerpo de un mortal mientras que Zeus es una deidad convertida en mortal.\n" +
                                "\n" +
                                "Monkey King libró una vez una guerra contra los dioses del Cielo en sus dominios. Incluso después de su redención sigue sin gustarle los dioses y se unió a la guerra de los Ancestros para poder dominar a los dioses mayores que lo tienen en jaque.";
                        break;
                    case "frase":
                        hist = "\"La inmortalidad esta sobrevalorada. Esto es mucho más interesante\"";
                        break;
                }
                break;
        }

        return hist;
    }


    private void ActionBar() {
        ActionBar actionBar = getSupportActionBar();
        assert  actionBar != null;
        actionBar.setTitle(titpag);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


    private void parrafos1(int dato_img) {

        imgFondo.setImageResource(dato_img);

        texto1.setText(Historia(titpag, "texto1"));
        frase_heroe.setText(Historia(titpag, "frase"));


        texto2.setVisibility(View.GONE);
        texto3.setVisibility(View.GONE);
        texto4.setVisibility(View.GONE);
        texto5.setVisibility(View.GONE);
        texto6.setVisibility(View.GONE);

        layout1.setVisibility(View.GONE);
        layout2.setVisibility(View.GONE);
        layout3.setVisibility(View.GONE);
        layout4.setVisibility(View.GONE);
        layout5.setVisibility(View.GONE);

        layout6.setVisibility(View.GONE);
        layout7.setVisibility(View.GONE);
        texto7.setVisibility(View.GONE);
        texto8.setVisibility(View.GONE);

    }

    private void parrafos2(int dato_img, String tit1) {

        imgFondo.setImageResource(dato_img);
        frase_heroe.setText(Historia(titpag, "frase"));

        texto1.setText(Historia(titpag, "texto1"));
        texto2.setText(Historia(titpag, "texto2"));

        titulo1.setText(tit1);


        texto3.setVisibility(View.GONE);
        texto4.setVisibility(View.GONE);
        texto5.setVisibility(View.GONE);
        texto6.setVisibility(View.GONE);

        layout2.setVisibility(View.GONE);
        layout3.setVisibility(View.GONE);
        layout4.setVisibility(View.GONE);
        layout5.setVisibility(View.GONE);

        layout6.setVisibility(View.GONE);
        layout7.setVisibility(View.GONE);
        texto7.setVisibility(View.GONE);
        texto8.setVisibility(View.GONE);

    }

    private void parrafos3(int dato_img, String tit1, String tit2) {

        imgFondo.setImageResource(dato_img);
        frase_heroe.setText(Historia(titpag, "frase"));

        texto1.setText(Historia(titpag, "texto1"));
        texto2.setText(Historia(titpag, "texto2"));
        texto3.setText(Historia(titpag, "texto3"));

        titulo1.setText(tit1);
        titulo2.setText(tit2);

        texto4.setVisibility(View.GONE);
        texto5.setVisibility(View.GONE);
        texto6.setVisibility(View.GONE);

        layout3.setVisibility(View.GONE);
        layout4.setVisibility(View.GONE);
        layout5.setVisibility(View.GONE);

        layout6.setVisibility(View.GONE);
        layout7.setVisibility(View.GONE);
        texto7.setVisibility(View.GONE);
        texto8.setVisibility(View.GONE);

    }

    private void parrafos4(int dato_img, String tit1, String tit2, String tit3) {

        imgFondo.setImageResource(dato_img);
        frase_heroe.setText(Historia(titpag, "frase"));

        texto1.setText(Historia(titpag, "texto1"));
        texto2.setText(Historia(titpag, "texto2"));
        texto3.setText(Historia(titpag, "texto3"));
        texto4.setText(Historia(titpag, "texto4"));

        titulo1.setText(tit1);
        titulo2.setText(tit2);
        titulo3.setText(tit3);

        texto5.setVisibility(View.GONE);
        texto6.setVisibility(View.GONE);

        layout4.setVisibility(View.GONE);
        layout5.setVisibility(View.GONE);

        layout6.setVisibility(View.GONE);
        layout7.setVisibility(View.GONE);
        texto7.setVisibility(View.GONE);
        texto8.setVisibility(View.GONE);

    }

    private void parrafos5(int dato_img, String tit1, String tit2, String tit3, String tit4) {

        imgFondo.setImageResource(dato_img);
        frase_heroe.setText(Historia(titpag, "frase"));

        texto1.setText(Historia(titpag, "texto1"));
        texto2.setText(Historia(titpag, "texto2"));
        texto3.setText(Historia(titpag, "texto3"));
        texto4.setText(Historia(titpag, "texto4"));
        texto5.setText(Historia(titpag, "texto5"));

        titulo1.setText(tit1);
        titulo2.setText(tit2);
        titulo3.setText(tit3);
        titulo4.setText(tit4);

        texto6.setVisibility(View.GONE);
        texto7.setVisibility(View.GONE);
        texto8.setVisibility(View.GONE);

        layout5.setVisibility(View.GONE);
        layout6.setVisibility(View.GONE);
        layout7.setVisibility(View.GONE);

    }

    private void parrafos6(int dato_img, String tit1, String tit2, String tit3, String tit4) {

        imgFondo.setImageResource(dato_img);
        frase_heroe.setText(Historia(titpag, "frase"));

        texto1.setText(Historia(titpag, "texto1"));
        texto2.setText(Historia(titpag, "texto2"));
        texto3.setText(Historia(titpag, "texto3"));
        texto4.setText(Historia(titpag, "texto4"));
        texto5.setText(Historia(titpag, "texto5"));
        texto6.setText(Historia(titpag, "texto6"));

        titulo1.setText(tit1);
        titulo2.setText(tit2);
        titulo3.setText(tit3);
        titulo4.setText(tit4);
        titulo5.setText("Relaciones");

        texto7.setVisibility(View.GONE);
        texto8.setVisibility(View.GONE);

        layout6.setVisibility(View.GONE);
        layout7.setVisibility(View.GONE);

    }

    private void parrafos7(int dato_img, String tit1, String tit2, String tit3, String tit4, String tit5, String tit6) {

        imgFondo.setImageResource(dato_img);
        frase_heroe.setText(Historia(titpag, "frase"));

        texto1.setText(Historia(titpag, "texto1"));
        texto2.setText(Historia(titpag, "texto2"));
        texto3.setText(Historia(titpag, "texto3"));
        texto4.setText(Historia(titpag, "texto4"));
        texto5.setText(Historia(titpag, "texto5"));
        texto6.setText(Historia(titpag, "texto6"));
        texto7.setText(Historia(titpag, "texto7"));

        titulo1.setText(tit1);
        titulo2.setText(tit2);
        titulo3.setText(tit3);
        titulo4.setText(tit4);
        titulo5.setText(tit5);
        titulo6.setText(tit6);

        texto8.setVisibility(View.GONE);

        layout7.setVisibility(View.GONE);

    }

    private void parrafos8(int dato_img, String tit2, String tit3, String tit4, String tit5, String tit6) {

        imgFondo.setImageResource(dato_img);
        frase_heroe.setText(Historia(titpag, "frase"));

        texto1.setText(Historia(titpag, "texto1"));
        texto2.setText(Historia(titpag, "texto2"));
        texto3.setText(Historia(titpag, "texto3"));
        texto4.setText(Historia(titpag, "texto4"));
        texto5.setText(Historia(titpag, "texto5"));
        texto6.setText(Historia(titpag, "texto6"));
        texto7.setText(Historia(titpag, "texto7"));
        texto8.setText(Historia(titpag, "texto8"));

        titulo1.setText("Descripción");
        titulo2.setText(tit2);
        titulo3.setText(tit3);
        titulo4.setText(tit4);
        titulo5.setText(tit5);
        titulo6.setText(tit6);
        titulo7.setText("Relaciones");

    }


    private void rel(String rel) {

        switch (rel) {
            case "heroe":
                layout_detmundo_rel_mundo.setVisibility(View.GONE);
                layout_detmundo_rel_razas.setVisibility(View.GONE);
                break;
            case "mundo":
                layout_detmundo_rel_heroes.setVisibility(View.GONE);
                layout_detmundo_rel_razas.setVisibility(View.GONE);
                break;
            case "raza":
                layout_detmundo_rel_heroes.setVisibility(View.GONE);
                layout_detmundo_rel_mundo.setVisibility(View.GONE);
                break;
            case "heroe_mundo":
                layout_detmundo_rel_razas.setVisibility(View.GONE);
                break;
            case "heroe_raza":
                layout_detmundo_rel_mundo.setVisibility(View.GONE);
                break;
            case "mundo_raza":
                layout_detmundo_rel_heroes.setVisibility(View.GONE);
                break;
            case "vacio":
                layout_detmundo_rel_heroes.setVisibility(View.GONE);
                layout_detmundo_rel_mundo.setVisibility(View.GONE);
                layout_detmundo_rel_razas.setVisibility(View.GONE);
                layout_rel_mundo.setVisibility(View.GONE);
                break;
            case "heroe_mundo_raza":
                break;
        }

    }


    @Override
    public void itemClick(lista_relacionados item) {

        try {
            Intent intent = new Intent(this, detalle_razas.class);
            intent.putExtra("itemDetail", item);
            this.startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void itemClick_Heroes(lista_relacionados item) {
        try {
            Intent intent = new Intent(this, detalle_heroe.class);
            intent.putExtra("itemDetail", item);
            this.startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void itemClick_Mundo(lista_relacionados item) {
        try {
            Intent intent = new Intent(this, detalle_mundo.class);
            intent.putExtra("itemDetail", item);
            this.startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    //inter-prueba: ca-app-pub-3940256099942544/1033173712
    //inter-produc: ca-app-pub-8291876581767416/3022376241
    private void inter_det_heroe() {
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });

        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this,"ca-app-pub-3940256099942544/1033173712", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        //Log.i(TAG, "onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        //Log.i(TAG, loadAdError.getMessage());
                        mInterstitialAd = null;
                    }
                });

    }
    
}