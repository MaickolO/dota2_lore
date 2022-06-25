package com.orizevtechnologies.historia_de_dota_2.Detalle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.orizevtechnologies.historia_de_dota_2.R;
import com.orizevtechnologies.historia_de_dota_2.listas.RecyclerAdapter_rel_dioses;
import com.orizevtechnologies.historia_de_dota_2.listas.RecyclerAdapter_rel_heroes;
import com.orizevtechnologies.historia_de_dota_2.listas.RecyclerAdapter_rel_mundo;
import com.orizevtechnologies.historia_de_dota_2.listas.RecyclerAdapter_rel_raza;
import com.orizevtechnologies.historia_de_dota_2.listas.lista_relacionados;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class detalle_dioses extends AppCompatActivity implements RecyclerAdapter_rel_raza.RecyclerItemClick,
        RecyclerAdapter_rel_heroes.RecyclerItemClick_heroes, RecyclerAdapter_rel_mundo.RecyclerItemClick_mundo,
        RecyclerAdapter_rel_dioses.RecyclerItemClickDioses {

    private ImageView img_dioses;
    private TextView tit_es;
    private TextView tit_en;
    private String titpag;

    private TextView texto1;
    private TextView texto2;
    private TextView texto3;
    private TextView texto4;
    private TextView texto5;

    private TextView titulo1;
    private TextView titulo2;
    private TextView titulo3;
    private TextView titulo4;

    private LinearLayout layout1;
    private LinearLayout layout2;
    private LinearLayout layout3;
    private LinearLayout layout4;
    private LinearLayout layout_rel_dioses;
    private LinearLayout layout_detdioses_rel_razas;
    private LinearLayout layout_detdioses_rel_mundo;
    private LinearLayout layout_detdioses_rel_heroes;
    private LinearLayout layout_detdioses_rel_dioses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_dioses);

        try {
            initViews();
            initValues();
            ActionBar();
            rel_dioses();
            anuncio_banenr();
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        
    }

    private void anuncio_banenr() {
        MobileAds.initialize(this, initializationStatus -> {});
        AdView mAdView = findViewById(R.id.adView_det_dioses);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    private void initViews() {
        img_dioses = findViewById(R.id.fondo_dioses_detalle);
        tit_es = findViewById(R.id.titulo_espanol_det_dioses);
        tit_en = findViewById(R.id.titulo_ingles_det_dioses);

        texto1 = findViewById(R.id.det_dioses_texto1);
        texto2 = findViewById(R.id.det_dioses_texto2);
        texto3 = findViewById(R.id.det_dioses_texto3);
        texto4 = findViewById(R.id.det_dioses_texto4);
        texto5 = findViewById(R.id.det_dioses_texto5);

        titulo1 = findViewById(R.id.det_dioses_titulo1);
        titulo2 = findViewById(R.id.det_dioses_titulo2);
        titulo3 = findViewById(R.id.det_dioses_titulo3);
        titulo4 = findViewById(R.id.det_dioses_titulo4);

        layout1 = findViewById(R.id.det_dioses_layout1);
        layout2 = findViewById(R.id.det_dioses_layout2);
        layout3 = findViewById(R.id.det_dioses_layout3);
        layout4 = findViewById(R.id.det_dioses_layout4);

        layout_rel_dioses = findViewById(R.id.layout_rel_dioses);
        layout_detdioses_rel_razas = findViewById(R.id.layout_detdioses_rel_razas);
        layout_detdioses_rel_mundo = findViewById(R.id.layout_detdioses_rel_mundo);
        layout_detdioses_rel_heroes = findViewById(R.id.layout_detdioses_rel_heroes);
        layout_detdioses_rel_dioses = findViewById(R.id.layout_detdioses_rel_dioses);
    }

    private void rel_dioses() {
        //Relaciones Heroes
        RecyclerView rvLista_dioses_rel_heroes = findViewById(R.id.recycler_view_dioses_rel_heroe);
        LinearLayoutManager manager_heroes = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rvLista_dioses_rel_heroes.setLayoutManager(manager_heroes);
        List<lista_relacionados> items_heroes = getItems_heroes();
        RecyclerAdapter_rel_heroes adapter_heroes = new RecyclerAdapter_rel_heroes(items_heroes, this);
        rvLista_dioses_rel_heroes.setAdapter(adapter_heroes);
        //Relaciones Mundo
        RecyclerView rvLista_dioses_rel_mundo = findViewById(R.id.recycler_view_dioses_rel_mundo);
        LinearLayoutManager manager_mundo = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rvLista_dioses_rel_mundo.setLayoutManager(manager_mundo);
        List<lista_relacionados> items_mundo = getItems_mundo();
        RecyclerAdapter_rel_mundo adapter_mundo = new RecyclerAdapter_rel_mundo(items_mundo, this);
        rvLista_dioses_rel_mundo.setAdapter(adapter_mundo);
        //Relaciones Razas
        RecyclerView rvLista_dioses_rel_razas = findViewById(R.id.recycler_view_dioses_rel_razas);
        LinearLayoutManager manager_razas = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rvLista_dioses_rel_razas.setLayoutManager(manager_razas);
        List<lista_relacionados> items = getItems_razas();
        RecyclerAdapter_rel_raza adapter_razas = new RecyclerAdapter_rel_raza(items, this);
        rvLista_dioses_rel_razas.setAdapter(adapter_razas);
        //Relaciones Dioses
        RecyclerView rvLista_dioses_rel_dioses = findViewById(R.id.recycler_view_dioses_rel_dioses);
        LinearLayoutManager manager_dioses = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rvLista_dioses_rel_dioses.setLayoutManager(manager_dioses);
        List<lista_relacionados> items_dioses = getItems_dioses();
        RecyclerAdapter_rel_dioses adapter_dioses = new RecyclerAdapter_rel_dioses(items_dioses, this);
        rvLista_dioses_rel_dioses.setAdapter(adapter_dioses);
    }


    private List<lista_relacionados> getItems_heroes() {
        List<lista_relacionados> itemLists= new ArrayList<>();

        switch (titpag) {
            case "Aethrak":
                itemLists.add(new lista_relacionados("Davion","Dragon Knight",R.drawable.perfil_dragon));
                itemLists.add(new lista_relacionados("Carl","Invoker",R.drawable.perfil_invoker));
                itemLists.add(new lista_relacionados("Terrorblade","Demon Marauder",R.drawable.perfil_tb));
                break;
            case "Aktok":
                itemLists.add(new lista_relacionados("Lesale Deathbringer","Venomancer",R.drawable.perfil_veno));
                break;
            case "Ascendentes":
                itemLists.add(new lista_relacionados("Mercurial","Spectre",R.drawable.perfil_spectre));
                break;
            case "Avilliva":
                itemLists.add(new lista_relacionados("Shendelzare","Vengeful Spirit",R.drawable.perfil_venge));
                itemLists.add(new lista_relacionados("Dragonus","Skywrarth Mage",R.drawable.perfil_sky));
                break;
            case "Belladonna":
                itemLists.add(new lista_relacionados("Lanaya","Templar Assassin",R.drawable.perfil_templar));
                itemLists.add(new lista_relacionados("Atropos","Bane Elemental", R.drawable.perfil_bane));
                break;
            case "Padre de Brewmaster":
                itemLists.add(new lista_relacionados("Mangix","Brewmaster", R.drawable.perfil_brewmaster));
                break;
            case "Celestial Ardiente":
                itemLists.add(new lista_relacionados("Xin","Ember Spirit",R.drawable.perfil_ember));
                break;
            case "Byssark":
                itemLists.add(new lista_relacionados("Davion","Dragon Knight",R.drawable.perfil_dragon));
                itemLists.add(new lista_relacionados("Carl","Invoker",R.drawable.perfil_invoker));
                itemLists.add(new lista_relacionados("Terrorblade","Demon Marauder",R.drawable.perfil_tb));
                break;
            case "Celestiales":
                itemLists.add(new lista_relacionados("Raijin Thunderkeg","Storm Spirit",R.drawable.perfil_storm));
                itemLists.add(new lista_relacionados("Kaolin","Earth Spirit",R.drawable.perfil_earth));
                itemLists.add(new lista_relacionados("Xin","Ember Spirit",R.drawable.perfil_ember));
                itemLists.add(new lista_relacionados("Inai","Void Spirit",R.drawable.perfil_void));
                itemLists.add(new lista_relacionados("Mangix","Brewmaster", R.drawable.perfil_brewmaster));
                break;
            case "Clasz":
                itemLists.add(new lista_relacionados("Darkterror","Faceless Void",R.drawable.perfil_faceless));
                break;
            case "Los Oscuros":
                itemLists.add(new lista_relacionados("Slark","Nightcrawler",R.drawable.perfil_slark));
                break;
            case "Los Sin Rostro":
                itemLists.add(new lista_relacionados("Yurnero","Juggernatur",R.drawable.perfil_jugg));
                break;
            case "Gemelos Despellejados":
                itemLists.add(new lista_relacionados("Strygwyr","Bloodseeker", R.drawable.perfil_bloodseeker));
                itemLists.add(new lista_relacionados("Pudge","Butcher",R.drawable.perfil_pudge));
                itemLists.add(new lista_relacionados("Mars","First Son of Heaven",R.drawable.perfil_mars));
                break;
            case "Fundamentales":
                itemLists.add(new lista_relacionados("Io","Wisp",R.drawable.perfil_io));
                itemLists.add(new lista_relacionados("Nessaj","Chaos Knight",R.drawable.perfil_chaos));
                itemLists.add(new lista_relacionados("Ezalor","Keeper of the Light",R.drawable.perfil_keeper));
                itemLists.add(new lista_relacionados("Enigma","Consumer of worlds",R.drawable.perfil_enigma));
                itemLists.add(new lista_relacionados("Elder Titan","Worldsmith",R.drawable.perfil_titan));
                break;
            case "Fymryn":
                itemLists.add(new lista_relacionados("Carl","Invoker",R.drawable.perfil_invoker));
                itemLists.add(new lista_relacionados("Mirana","Princess of the Moon",R.drawable.perfil_mirana));
                itemLists.add(new lista_relacionados("Marci","Marci",R.drawable.perfil_marci));
                itemLists.add(new lista_relacionados("Davion","Dragon Knight",R.drawable.perfil_dragon));
                itemLists.add(new lista_relacionados("Luna","Moon Rider",R.drawable.perfil_luna));
                itemLists.add(new lista_relacionados("Terrorblade","Demon Marauder",R.drawable.perfil_tb));
                break;
            case "Diosa de la Suerte":
                itemLists.add(new lista_relacionados("Aggron Stonebreak","Ogre Magi",R.drawable.perfil_ogre));
                break;
            case "Los Ocultos":
                itemLists.add(new lista_relacionados("Lanaya","Templar Assassin",R.drawable.perfil_templar));
                itemLists.add(new lista_relacionados("Nyx Assassin","Asesino de Nyx",R.drawable.perfil_nyx));
                break;
            case "Indrak":
                itemLists.add(new lista_relacionados("Davion","Dragon Knight",R.drawable.perfil_dragon));
                itemLists.add(new lista_relacionados("Carl","Invoker",R.drawable.perfil_invoker));
                itemLists.add(new lista_relacionados("Terrorblade","Demon Marauder",R.drawable.perfil_tb));
                break;
            case "Ix'yxa el Destructor":
                itemLists.add(new lista_relacionados("Pugna","Oblivion",R.drawable.perfil_pugna));
                break;
            case "Lirrak":
                itemLists.add(new lista_relacionados("Davion","Dragon Knight",R.drawable.perfil_dragon));
                itemLists.add(new lista_relacionados("Carl","Invoker",R.drawable.perfil_invoker));
                itemLists.add(new lista_relacionados("Terrorblade","Demon Marauder",R.drawable.perfil_tb));
                break;
            case "Maelrawn el Tentacular":
                itemLists.add(new lista_relacionados("Kunkka","Admiral",R.drawable.perfil_kunkka));
                itemLists.add(new lista_relacionados("Slithice","Naga Siren",R.drawable.perfil_naga));
                itemLists.add(new lista_relacionados("Leviathan","Tidehunter",R.drawable.perfil_tide));
                break;
            case "Forjador de Máscaras":
                itemLists.add(new lista_relacionados("Yurnero","Juggernatur",R.drawable.perfil_jugg));
                break;
            case "Mene":
                itemLists.add(new lista_relacionados("Carl","Invoker",R.drawable.perfil_invoker));
                itemLists.add(new lista_relacionados("Luna","Moon Rider",R.drawable.perfil_luna));
                itemLists.add(new lista_relacionados("Mirana","Princess of the Moon",R.drawable.perfil_mirana));
                itemLists.add(new lista_relacionados("Terrorblade","Demon Marauder",R.drawable.perfil_tb));
                itemLists.add(new lista_relacionados("Marci","Marci",R.drawable.perfil_marci));
                break;
            case "Nyctasha":
                itemLists.add(new lista_relacionados("Atropos","Bane Elemental", R.drawable.perfil_bane));
                break;
            case "Nyx":
                itemLists.add(new lista_relacionados("Nyx Assassin","Asesino de Nyx",R.drawable.perfil_nyx));
                itemLists.add(new lista_relacionados("Abbadon", "Lord of Avernus", R.drawable.perfil_abbadon));
                break;
            case "Obelis":
                itemLists.add(new lista_relacionados("Chen","Holy Knight",R.drawable.perfil_chen));
                break;
            case "Omniciencia":
                itemLists.add(new lista_relacionados("Purist Thunderwrath","Omniknight",R.drawable.perfil_omniknight));
                itemLists.add(new lista_relacionados("Zeus","Lord of Heaven",R.drawable.perfil_zeus));
                itemLists.add(new lista_relacionados("Strygwyr","Bloodseeker", R.drawable.perfil_bloodseeker));
                break;
            case "Orrak":
                itemLists.add(new lista_relacionados("Davion","Dragon Knight",R.drawable.perfil_dragon));
                itemLists.add(new lista_relacionados("Carl","Invoker",R.drawable.perfil_invoker));
                itemLists.add(new lista_relacionados("Terrorblade","Demon Marauder",R.drawable.perfil_tb));
                break;
            case "Polymorphia":
                itemLists.add(new lista_relacionados("Morphling","The Morphling",R.drawable.perfil_morphling));
                break;
            case "Poseidon":
                itemLists.add(new lista_relacionados("Zeus","Lord of Heaven",R.drawable.perfil_zeus));
                itemLists.add(new lista_relacionados("Mars","First Son of Heaven",R.drawable.perfil_mars));
                break;
            case "Conciencia Primordial":
                itemLists.add(new lista_relacionados("Zet","Arc Warden", R.drawable.perfil_arc));
                break;
            case "Raijin":
                itemLists.add(new lista_relacionados("Raijin Thunderkeg","Storm Spirit",R.drawable.perfil_storm));
                break;
            case "Scree'auk":
                itemLists.add(new lista_relacionados("Dragonus","Skywrarth Mage",R.drawable.perfil_sky));
                itemLists.add(new lista_relacionados("Shendelzare","Vengeful Spirit",R.drawable.perfil_venge));
                break;
            case "Selemene (Dragon's Blood)":
                itemLists.add(new lista_relacionados("Carl","Invoker",R.drawable.perfil_invoker));
                itemLists.add(new lista_relacionados("Mirana","Princess of the Moon",R.drawable.perfil_mirana));
                itemLists.add(new lista_relacionados("Marci","Marci",R.drawable.perfil_marci));
                itemLists.add(new lista_relacionados("Davion","Dragon Knight",R.drawable.perfil_dragon));
                itemLists.add(new lista_relacionados("Luna","Moon Rider",R.drawable.perfil_luna));
                itemLists.add(new lista_relacionados("Terrorblade","Demon Marauder",R.drawable.perfil_tb));
                break;
            case "Selemene":
                itemLists.add(new lista_relacionados("Mirana","Princess of the Moon",R.drawable.perfil_mirana));
                itemLists.add(new lista_relacionados("Marci","Marci",R.drawable.perfil_marci));
                itemLists.add(new lista_relacionados("Luna","Moon Rider",R.drawable.perfil_luna));
                itemLists.add(new lista_relacionados("Bradwarden","Centaur Warruner",R.drawable.perfil_centaur));
                itemLists.add(new lista_relacionados("Mars","First Son of Heaven",R.drawable.perfil_mars));
                break;
            case "Sherzi":
                itemLists.add(new lista_relacionados("Mirana","Princess of the Moon",R.drawable.perfil_mirana));
                break;
            case "Skadi":
                break;
            case "Slyrak":
                itemLists.add(new lista_relacionados("Davion","Dragon Knight",R.drawable.perfil_dragon));
                itemLists.add(new lista_relacionados("Carl","Invoker",R.drawable.perfil_invoker));
                itemLists.add(new lista_relacionados("Terrorblade","Demon Marauder",R.drawable.perfil_tb));
                break;
            case "Diosa Solar":
                itemLists.add(new lista_relacionados("Lina","Slayer",R.drawable.perfil_lina));
                itemLists.add(new lista_relacionados("Gondar","Bounty Hunter", R.drawable.perfil_bounty));
                itemLists.add(new lista_relacionados("Valora","Dawnbreaker",R.drawable.perfil_dawnbreaker));
                break;
            case "Espíritu de la Naturaleza":
                itemLists.add(new lista_relacionados("Rooftrellen","Treant Protector",R.drawable.perfil_arbol));
                break;
            case "El Dios Muerto":
                itemLists.add(new lista_relacionados("Undying","Almighty Dirge",R.drawable.perfil_zombie));
                itemLists.add(new lista_relacionados("Magina","Anti-Mage", R.drawable.perfil_antimage));
                itemLists.add(new lista_relacionados("Huskar","Sacred Warrior",R.drawable.perfil_huskar));
                itemLists.add(new lista_relacionados("Pudge","Butcher",R.drawable.perfil_pudge));
                break;
            case "El Increado":
                itemLists.add(new lista_relacionados("Elder Titan","Worldsmith",R.drawable.perfil_titan));
                break;
            case "La Parca":
                itemLists.add(new lista_relacionados("Rotund'jere","Necrophos",R.drawable.perfil_necrophos));
                break;
            case "El Moldeador":
                itemLists.add(new lista_relacionados("Elder Titan","Worldsmith",R.drawable.perfil_titan));
                break;
            case "Las Tres Sombras":
                itemLists.add(new lista_relacionados("Atropos","Bane Elemental", R.drawable.perfil_bane));
                itemLists.add(new lista_relacionados("Lanaya","Templar Assassin",R.drawable.perfil_templar));
                break;
            case "Los Siete Invisibles":
                itemLists.add(new lista_relacionados("Lanaya","Templar Assassin",R.drawable.perfil_templar));
                break;
            case "El Doliente":
                itemLists.add(new lista_relacionados("Mangix","Brewmaster", R.drawable.perfil_brewmaster));
                break;
            case "Trascendentales":
                itemLists.add(new lista_relacionados("Mercurial","Spectre",R.drawable.perfil_spectre));
                break;
            case "Tyrian":
                itemLists.add(new lista_relacionados("Lanaya","Templar Assassin",R.drawable.perfil_templar));
                itemLists.add(new lista_relacionados("Atropos","Bane Elemental", R.drawable.perfil_bane));
                break;
            case "Uldorak":
                itemLists.add(new lista_relacionados("Davion","Dragon Knight",R.drawable.perfil_dragon));
                itemLists.add(new lista_relacionados("Carl","Invoker",R.drawable.perfil_invoker));
                itemLists.add(new lista_relacionados("Terrorblade","Demon Marauder",R.drawable.perfil_tb));
                break;
            case "Vahdrak":
                itemLists.add(new lista_relacionados("Davion","Dragon Knight",R.drawable.perfil_dragon));
                itemLists.add(new lista_relacionados("Carl","Invoker",R.drawable.perfil_invoker));
                itemLists.add(new lista_relacionados("Terrorblade","Demon Marauder",R.drawable.perfil_tb));
                break;
            case "Verodicia":
                itemLists.add(new lista_relacionados("Furion","Nature's Prophet",R.drawable.perfil_nature));
                break;
            case "Vulcano":
                itemLists.add(new lista_relacionados("Mars","First Son of Heaven",R.drawable.perfil_mars));
                break;
            case "WorldWyrm":
                itemLists.add(new lista_relacionados("Mirana","Princess of the Moon",R.drawable.perfil_mirana));
                itemLists.add(new lista_relacionados("Marci","Marci",R.drawable.perfil_marci));
                itemLists.add(new lista_relacionados("Davion","Dragon Knight",R.drawable.perfil_dragon));
                itemLists.add(new lista_relacionados("Carl","Invoker",R.drawable.perfil_invoker));
                break;
            case "Zal":
                itemLists.add(new lista_relacionados("Mirana","Princess of the Moon",R.drawable.perfil_mirana));
                break;
        }

        return itemLists;
    }

    private List<lista_relacionados> getItems_mundo() {

        List<lista_relacionados> lista_mundo_es= new ArrayList<>();

        switch (titpag) {
            case "Celestial Ardiente":
                lista_mundo_es.add(new lista_relacionados("Fortaleza de las Llamas", "Fortress of Flares", R.drawable.fortaleza_llamas));
                break;
            case "Clasz":
                lista_mundo_es.add(new lista_relacionados("Claszureme", "Claszureme", R.drawable.claszureme));
                break;
            case "Los Oscuros":
                lista_mundo_es.add(new lista_relacionados("Ruinas de Grietas Sombrías", "Riftshadow Ruins", R.drawable.riftshadow_ruins));
                break;
            case "Los Sin Rostro":
                lista_mundo_es.add(new lista_relacionados("Isla de las Máscaras", "Isle of Masks", R.drawable.isla_mascaras));
                break;
            case "Fundamentales":
                lista_mundo_es.add(new lista_relacionados("Siete Planos", "Seven Planes", R.drawable.seven_planes));
                break;
            case "Fymryn":
                lista_mundo_es.add(new lista_relacionados("Bosque de la Noche Plateada", "Nightsilver Woods", R.drawable.bosque_noche_plateada));
                break;
            case "Los Ocultos":
                lista_mundo_es.add(new lista_relacionados("Templo Escondido", "Hidden Temple", R.drawable.templo_oculto));
                break;
            case "Ix'yxa el Destructor":
                lista_mundo_es.add(new lista_relacionados("Confines Infernales", "Nether Reaches", R.drawable.confines_infernales));
                break;
            case "Maelrawn el Tentacular":
                lista_mundo_es.add(new lista_relacionados("Isla Temblorosa", "Trembling Isle", R.drawable.isla_temblorosa));
                break;
            case "Forjador de Máscaras":
                lista_mundo_es.add(new lista_relacionados("Isla de las Máscaras", "Isle of Masks", R.drawable.isla_mascaras));
                break;
            case "Mene":
                lista_mundo_es.add(new lista_relacionados("Bosque de la Noche Plateada", "Nightsilver Woods", R.drawable.bosque_noche_plateada));
                break;
            case "Omniciencia":
                lista_mundo_es.add(new lista_relacionados("Emauracus", "Emauracus", R.drawable.emauracus));
                break;
            case "Conciencia Primordial":
                lista_mundo_es.add(new lista_relacionados("La Luna Loca", "The Mad Moon", R.drawable.mad_moon2));
                break;
            case "Selemene (Dragon's Blood)":
                lista_mundo_es.add(new lista_relacionados("Bosque de la Noche Plateada", "Nightsilver Woods", R.drawable.bosque_noche_plateada));
                lista_mundo_es.add(new lista_relacionados("Imperio Helio", "Helio Imperium", R.drawable.imperio_helio));
                break;
            case "Selemene":
                lista_mundo_es.add(new lista_relacionados("Bosque de la Noche Plateada", "Nightsilver Woods", R.drawable.bosque_noche_plateada));
                break;
            case "Sherzi":
                lista_mundo_es.add(new lista_relacionados("Imperio Helio", "Helio Imperium", R.drawable.imperio_helio));
                break;
            case "Skadi":
                lista_mundo_es.add(new lista_relacionados("Arrecife Oscuro", "Dark Reef", R.drawable.arrecife_oscuro));
                break;
            case "Diosa Solar":
                lista_mundo_es.add(new lista_relacionados("Basurero Centelleante", "Scintillant Waste", R.drawable.basurero_centelleante));
                lista_mundo_es.add(new lista_relacionados("Desierto de la Anarquía", "Desert of Misrule", R.drawable.desierto_misrule));
                break;
            case "El Dios Muerto":
                lista_mundo_es.add(new lista_relacionados("Catedral de Rumusque", "Cathedral of Rumusque", R.drawable.catedral));
                lista_mundo_es.add(new lista_relacionados("Campos de la Matanza sin Fin", "Fields of Endless Carnage", R.drawable.campos_carniceria_sin_fin));
                break;
            case "El Doliente":
                lista_mundo_es.add(new lista_relacionados("Siete Planos", "Seven Planes", R.drawable.seven_planes));
                break;
            case "WorldWyrm":
                lista_mundo_es.add(new lista_relacionados("Imperio Helio", "Helio Imperium", R.drawable.imperio_helio));
                break;
            case "Zal":
                lista_mundo_es.add(new lista_relacionados("Imperio Helio", "Helio Imperium", R.drawable.imperio_helio));
                break;
        }

        return lista_mundo_es;
    }

    private List<lista_relacionados> getItems_razas() {

        List<lista_relacionados> lista__razas__es= new ArrayList<>();

        switch (titpag) {
            case "Aethrak":
                lista__razas__es.add(new lista_relacionados("Dragones (Sangre de Dragón)", "Dragons (Dragon's Blood)", R.drawable.dragones_db));
                break;
            case "Avilliva":
                lista__razas__es.add(new lista_relacionados("Skywraths", "", R.drawable.skywraths));
                break;
            case "Byssark":
                lista__razas__es.add(new lista_relacionados("Dragones (Sangre de Dragón)", "Dragons (Dragon's Blood)", R.drawable.dragones_db));
                break;
            case "Fymryn":
                lista__razas__es.add(new lista_relacionados("Elfos", "Elfs", R.drawable.elfos));
                break;
            case "Indrak":
                lista__razas__es.add(new lista_relacionados("Dragones (Sangre de Dragón)", "Dragons (Dragon's Blood)", R.drawable.dragones_db));
                break;
            case "Lirrak":
                lista__razas__es.add(new lista_relacionados("Dragones (Sangre de Dragón)", "Dragons (Dragon's Blood)", R.drawable.dragones_db));
                break;
            case "Maelrawn el Tentacular":
                lista__razas__es.add(new lista_relacionados("Slithereen", "", R.drawable.slardar));
                lista__razas__es.add(new lista_relacionados("Leviatanes", "Levianths", R.drawable.leviatanes));
                break;
            case "Forjador de Máscaras":
                lista__razas__es.add(new lista_relacionados("Enmascarados", "Masked Ones", R.drawable.mascara));
                break;
            case "Mene":
                lista__razas__es.add(new lista_relacionados("Elfos", "Elfs", R.drawable.elfos));
                break;
            case "Orrak":
                lista__razas__es.add(new lista_relacionados("Dragones (Sangre de Dragón)", "Dragons (Dragon's Blood)", R.drawable.dragones_db));
                break;
            case "Selemene (Dragon's Blood)":
                lista__razas__es.add(new lista_relacionados("Elfos", "Elfs", R.drawable.elfos));
                break;
            case "Selemene":
                lista__razas__es.add(new lista_relacionados("Estrellas", "Stars", R.drawable.estrellas));
                break;
            case "Sherzi":
                lista__razas__es.add(new lista_relacionados("Humanos", "Humans", R.drawable.humanos));
                break;
            case "Slyrak":
                lista__razas__es.add(new lista_relacionados("Dragones (Sangre de Dragón)", "Dragons (Dragon's Blood)", R.drawable.dragones_db));
                break;
            case "Diosa Solar":
                lista__razas__es.add(new lista_relacionados("Estrellas", "Stars", R.drawable.estrellas));
                break;
            case "Espíritu de la Naturaleza":
                lista__razas__es.add(new lista_relacionados("Protectores Treant", "Treant Protectors", R.drawable.treants));
                break;
            case "El Moldeador":
                lista__razas__es.add(new lista_relacionados("Titanes", "Titans", R.drawable.titans));
                break;
            case "Uldorak":
                lista__razas__es.add(new lista_relacionados("Dragones (Sangre de Dragón)", "Dragons (Dragon's Blood)", R.drawable.dragones_db));
                break;
            case "Vahdrak":
                lista__razas__es.add(new lista_relacionados("Dragones (Sangre de Dragón)", "Dragons (Dragon's Blood)", R.drawable.dragones_db));
                break;
            case "WorldWyrm":
                lista__razas__es.add(new lista_relacionados("Dragones (Sangre de Dragón)", "Dragons (Dragon's Blood)", R.drawable.dragones_db));
                break;
            case "Zal":
                lista__razas__es.add(new lista_relacionados("Humanos", "Humans", R.drawable.humanos));
                break;
        }

        return lista__razas__es;
    }

    private List<lista_relacionados> getItems_dioses() {

        List<lista_relacionados> lista_dioses= new ArrayList<>();

        switch (titpag) {
            case "Aethrak":
                lista_dioses.add(new lista_relacionados("WorldWyrm", "", R.drawable.worldwyrm));
                lista_dioses.add(new lista_relacionados("Byssark", "", R.drawable.byssrak));
                lista_dioses.add(new lista_relacionados("Indrak", "", R.drawable.indrak));
                lista_dioses.add(new lista_relacionados("Lirrak", "", R.drawable.lirrak));
                lista_dioses.add(new lista_relacionados("Orrak", "Aurak", R.drawable.orrak));
                lista_dioses.add(new lista_relacionados("Slyrak", "", R.drawable.slyrak));
                lista_dioses.add(new lista_relacionados("Uldorak", "", R.drawable.uldorak));
                lista_dioses.add(new lista_relacionados("Vahdrak", "", R.drawable.vahdrak));
                break;
            case "Ascendentes":
                lista_dioses.add(new lista_relacionados("Trascendentales", "Transcendencies", R.drawable.trascendentes));
                break;
            case "Avilliva":
                lista_dioses.add(new lista_relacionados("Scree'auk", "", R.drawable.screauk));
                break;
            case "Belladonna":
                lista_dioses.add(new lista_relacionados("Las Tres Sombras", "The Three Shades", R.drawable.tres_sombras));
                break;
            case "Padre de Brewmaster":
                lista_dioses.add(new lista_relacionados("Celestiales", "Celestials", R.drawable.celestiales));
                break;
            case "Byssark":
                lista_dioses.add(new lista_relacionados("WorldWyrm", "", R.drawable.worldwyrm));
                lista_dioses.add(new lista_relacionados("Aethrak", "", R.drawable.aethrak));
                lista_dioses.add(new lista_relacionados("Indrak", "", R.drawable.indrak));
                lista_dioses.add(new lista_relacionados("Lirrak", "", R.drawable.lirrak));
                lista_dioses.add(new lista_relacionados("Orrak", "Aurak", R.drawable.orrak));
                lista_dioses.add(new lista_relacionados("Slyrak", "", R.drawable.slyrak));
                lista_dioses.add(new lista_relacionados("Uldorak", "", R.drawable.uldorak));
                lista_dioses.add(new lista_relacionados("Vahdrak", "", R.drawable.vahdrak));
                break;
            case "Celestiales":
                lista_dioses.add(new lista_relacionados("Padre de Brewmaster", "Brewmaster's Father", R.drawable.brewmaster_father));
                lista_dioses.add(new lista_relacionados("Celestial Ardiente", "Burning Celestial", R.drawable.celestial_ardiente));
                lista_dioses.add(new lista_relacionados("Raijin", "", R.drawable.raijin));
                break;
            case "Gemelos Despellejados":
                lista_dioses.add(new lista_relacionados("Omniciencia", "Omniscience", R.drawable.omniciencia));
                break;
            case "Fymryn":
                lista_dioses.add(new lista_relacionados("Mene", "", R.drawable.mene));
                lista_dioses.add(new lista_relacionados("Selemene (Dragon's Blood)", "", R.drawable.selemene2));
                break;
            case "Indrak":
                lista_dioses.add(new lista_relacionados("WorldWyrm", "", R.drawable.worldwyrm));
                lista_dioses.add(new lista_relacionados("Aethrak", "", R.drawable.aethrak));
                lista_dioses.add(new lista_relacionados("Byssark", "", R.drawable.byssrak));
                lista_dioses.add(new lista_relacionados("Lirrak", "", R.drawable.lirrak));
                lista_dioses.add(new lista_relacionados("Orrak", "Aurak", R.drawable.orrak));
                lista_dioses.add(new lista_relacionados("Slyrak", "", R.drawable.slyrak));
                lista_dioses.add(new lista_relacionados("Uldorak", "", R.drawable.uldorak));
                lista_dioses.add(new lista_relacionados("Vahdrak", "", R.drawable.vahdrak));
                break;
            case "Lirrak":
                lista_dioses.add(new lista_relacionados("WorldWyrm", "", R.drawable.worldwyrm));
                lista_dioses.add(new lista_relacionados("Aethrak", "", R.drawable.aethrak));
                lista_dioses.add(new lista_relacionados("Byssark", "", R.drawable.byssrak));
                lista_dioses.add(new lista_relacionados("Indrak", "", R.drawable.indrak));
                lista_dioses.add(new lista_relacionados("Orrak", "Aurak", R.drawable.orrak));
                lista_dioses.add(new lista_relacionados("Slyrak", "", R.drawable.slyrak));
                lista_dioses.add(new lista_relacionados("Uldorak", "", R.drawable.uldorak));
                lista_dioses.add(new lista_relacionados("Vahdrak", "", R.drawable.vahdrak));
                break;
            case "Mene":
                lista_dioses.add(new lista_relacionados("Fymryn", "", R.drawable.fymryn));
                lista_dioses.add(new lista_relacionados("Selemene (Dragon's Blood)", "", R.drawable.selemene2));
                lista_dioses.add(new lista_relacionados("Selemene", "", R.drawable.selemene));
                lista_dioses.add(new lista_relacionados("WorldWyrm", "", R.drawable.worldwyrm));
                break;
            case "Omniciencia":
                lista_dioses.add(new lista_relacionados("Gemelos Despellejados", "Flayed Twins", R.drawable.gemelos_desollados));
                break;
            case "Orrak":
                lista_dioses.add(new lista_relacionados("WorldWyrm", "", R.drawable.worldwyrm));
                lista_dioses.add(new lista_relacionados("Aethrak", "", R.drawable.aethrak));
                lista_dioses.add(new lista_relacionados("Byssark", "", R.drawable.byssrak));
                lista_dioses.add(new lista_relacionados("Indrak", "", R.drawable.indrak));
                lista_dioses.add(new lista_relacionados("Lirrak", "", R.drawable.lirrak));
                lista_dioses.add(new lista_relacionados("Slyrak", "", R.drawable.slyrak));
                lista_dioses.add(new lista_relacionados("Uldorak", "", R.drawable.uldorak));
                lista_dioses.add(new lista_relacionados("Vahdrak", "", R.drawable.vahdrak));
                break;
            case "Conciencia Primordial":
                lista_dioses.add(new lista_relacionados("El Doliente", "The Wailing One", R.drawable.wailing_one));
                break;
            case "Selemene (Dragon's Blood)":
                lista_dioses.add(new lista_relacionados("Fymryn", "", R.drawable.fymryn));
                lista_dioses.add(new lista_relacionados("Mene", "", R.drawable.mene));
                lista_dioses.add(new lista_relacionados("WorldWyrm", "", R.drawable.worldwyrm));
                break;
            case "Sherzi":
                lista_dioses.add(new lista_relacionados("WorldWyrm", "", R.drawable.worldwyrm));
                lista_dioses.add(new lista_relacionados("Zal", "", R.drawable.zal));
                break;
            case "Slyrak":
                lista_dioses.add(new lista_relacionados("WorldWyrm", "", R.drawable.worldwyrm));
                lista_dioses.add(new lista_relacionados("Aethrak", "", R.drawable.aethrak));
                lista_dioses.add(new lista_relacionados("Byssark", "", R.drawable.byssrak));
                lista_dioses.add(new lista_relacionados("Indrak", "", R.drawable.indrak));
                lista_dioses.add(new lista_relacionados("Lirrak", "", R.drawable.lirrak));
                lista_dioses.add(new lista_relacionados("Orrak", "Aurak", R.drawable.orrak));
                lista_dioses.add(new lista_relacionados("Uldorak", "", R.drawable.uldorak));
                lista_dioses.add(new lista_relacionados("Vahdrak", "", R.drawable.vahdrak));
                break;
            case "Las Tres Sombras":
                lista_dioses.add(new lista_relacionados("Belladonna", "", R.drawable.belladonna));
                lista_dioses.add(new lista_relacionados("Tyrian", "", R.drawable.tyrian));
                break;
            case "El Doliente":
                lista_dioses.add(new lista_relacionados("Conciencia Primordial", "Primordial Consciousness", R.drawable.conciencia_primordial));
                break;
            case "Trascendentales":
                lista_dioses.add(new lista_relacionados("Ascendentes", "Ascendants", R.drawable.ascendentes));
                break;
            case "Tyrian":
                lista_dioses.add(new lista_relacionados("Belladonna", "", R.drawable.belladonna));
                lista_dioses.add(new lista_relacionados("Las Tres Sombras", "The Three Shades", R.drawable.tres_sombras));
                break;
            case "Uldorak":
                lista_dioses.add(new lista_relacionados("WorldWyrm", "", R.drawable.worldwyrm));
                lista_dioses.add(new lista_relacionados("Aethrak", "", R.drawable.aethrak));
                lista_dioses.add(new lista_relacionados("Byssark", "", R.drawable.byssrak));
                lista_dioses.add(new lista_relacionados("Indrak", "", R.drawable.indrak));
                lista_dioses.add(new lista_relacionados("Lirrak", "", R.drawable.lirrak));
                lista_dioses.add(new lista_relacionados("Orrak", "Aurak", R.drawable.orrak));
                lista_dioses.add(new lista_relacionados("Slyrak", "", R.drawable.slyrak));
                lista_dioses.add(new lista_relacionados("Vahdrak", "", R.drawable.vahdrak));
                break;
            case "Vahdrak":
                lista_dioses.add(new lista_relacionados("WorldWyrm", "", R.drawable.worldwyrm));
                lista_dioses.add(new lista_relacionados("Aethrak", "", R.drawable.aethrak));
                lista_dioses.add(new lista_relacionados("Byssark", "", R.drawable.byssrak));
                lista_dioses.add(new lista_relacionados("Indrak", "", R.drawable.indrak));
                lista_dioses.add(new lista_relacionados("Lirrak", "", R.drawable.lirrak));
                lista_dioses.add(new lista_relacionados("Orrak", "Aurak", R.drawable.orrak));
                lista_dioses.add(new lista_relacionados("Slyrak", "", R.drawable.slyrak));
                lista_dioses.add(new lista_relacionados("Uldorak", "", R.drawable.uldorak));
                break;
            case "WorldWyrm":
                lista_dioses.add(new lista_relacionados("Mene", "", R.drawable.mene));
                lista_dioses.add(new lista_relacionados("Selemene (Dragon's Blood)", "", R.drawable.selemene2));
                lista_dioses.add(new lista_relacionados("Sherzi", "", R.drawable.sherzi));
                lista_dioses.add(new lista_relacionados("Zal", "", R.drawable.zal));
                lista_dioses.add(new lista_relacionados("Aethrak", "", R.drawable.aethrak));
                lista_dioses.add(new lista_relacionados("Byssark", "", R.drawable.byssrak));
                lista_dioses.add(new lista_relacionados("Indrak", "", R.drawable.indrak));
                lista_dioses.add(new lista_relacionados("Lirrak", "", R.drawable.lirrak));
                lista_dioses.add(new lista_relacionados("Orrak", "Aurak", R.drawable.orrak));
                lista_dioses.add(new lista_relacionados("Slyrak", "", R.drawable.slyrak));
                lista_dioses.add(new lista_relacionados("Uldorak", "", R.drawable.uldorak));
                lista_dioses.add(new lista_relacionados("Vahdrak", "", R.drawable.vahdrak));
                break;
            case "Zal":
                lista_dioses.add(new lista_relacionados("Sherzi", "", R.drawable.sherzi));
                lista_dioses.add(new lista_relacionados("WorldWyrm", "", R.drawable.worldwyrm));
                break;
        }

        return lista_dioses;
    }


    private void initValues(){
        lista_relacionados itemDetail = (lista_relacionados) getIntent().getExtras().getSerializable("itemDetail");
        img_dioses.setImageResource(itemDetail.getImg_principal());
        tit_es.setText(itemDetail.getNombre_principal());
        tit_en.setText(itemDetail.getNombre_secundario());
        titpag = (String) tit_es.getText();
        if (itemDetail.getNombre_secundario().equals("")) {
            tit_en.setVisibility(View.GONE);
        }
        texto();
    }


    private void texto() {
        switch (titpag) {
            case "Aethrak":
                parrafos5("Fisiología", "Comportamiento", "Ciclo de Vida", "Curiosidades");
                rel("heroe_raza_dioses");
                break;
            case "Aktok":
            case "Diosa de la Suerte":
            case "Nyctasha":
            case "Obelis":
            case "Polymorphia":
            case "El Increado":
            case "Los Siete Invisibles":
            case "Vulcano":
                parrafos1();
                rel("heroe");
                break;
            case "Ascendentes":
            case "Padre de Brewmaster":
            case "Trascendentales":
            case "Tyrian":
                parrafos1();
                rel("heroe_dioses");
                break;
            case "Fymryn":
            case "Selemene (Dragon's Blood)":
            case "Sherzi":
            case "WorldWyrm":
            case "Zal":
                parrafos1();
                rel("heroe_mundo_raza_dioses");
                break;
            case "Belladonna":
                parrafos2("Curiosidades");
                rel("heroe_dioses");
                break;
            case "Celestial Ardiente":
            case "Los Oscuros":
            case "Los Sin Rostro":
            case "Los Ocultos":
            case "Ix'yxa el Destructor":
                parrafos1();
                rel("heroe_mundo");
                break;
            case "Byssark":
            case "Vahdrak":
                parrafos3("Fisiología", "Ciclo de Vida");
                rel("heroe_raza_dioses");
                break;
            case "Celestiales":
                parrafos3("Creación", "Lista de Celestiales");
                rel("heroe_dioses");
                break;
            case "Clasz":
                parrafos2("Culto");
                rel("heroe_mundo");
                break;
            case "Ermarcor el Explorador":
            case "Shiva":
                parrafos1();
                rel("vacio");
                break;
            case "Gemelos Despellejados":
                parrafos4("Súbditos", "Relaciones", "Curiosidades");
                rel("heroe_dioses");
                break;
            case "Fundamentales":
                parrafos4("Descripción", "Lista de Fundamentales", "Curiosidades");
                rel("heroe_mundo");
                break;
            case "Indrak":
                parrafos4("Fisiología", "Ciclo de Vida", "Curiosidades");
                rel("heroe_raza_dioses");
                break;
            case "Lirrak":
            case "Slyrak":
            case "Uldorak":
            case "Avilliva":
                parrafos1();
                rel("heroe_raza_dioses");
                break;
            case "Maelrawn el Tentacular":
                parrafos3("La Isla Temblorosa", "Relaciones");
                rel("heroe_mundo_raza");
                break;
            case "Forjador de Máscaras":
                parrafos1();
                rel("heroe_mundo_raza");
                break;
            case "Mene":
                parrafos3("Profecía", "Curiosidades");
                rel("heroe_mundo_raza_dioses");
                break;
            case "Nyx":
                parrafos4("El Elegido", "Rivalidades", "Curiosidades");
                rel("heroe");
                break;
            case "Omniciencia":
                parrafos4("Religión", "Clero", "Relaciones");
                rel("heroe_mundo_dioses");
                break;
            case "Orrak":
                parrafos3("Ciclo de Vida", "Curiosidades");
                rel("heroe_mundo_dioses");
                break;
            case "Poseidon":
            case "Raijin":
            case "Scree'auk":
                parrafos2("Curiosidades");
                rel("heroe");
                break;
            case "Conciencia Primordial":
                parrafos3("Historia", "Especulaciones");
                rel("heroe_mundo_dioses");
                break;
            case "Selemene":
                parrafos5("Poderes", "Orden de la Luna Oscura", "Amigos", "Curiosidades");
                rel("heroe_mundo_raza");
                break;
            case "Skadi":
                parrafos1();
                rel("mundo");
                break;
            case "Diosa Solar":
                parrafos3("Religión", "Especulación");
                rel("heroe_mundo_raza");
                break;
            case "Espíritu de la Naturaleza":
            case "El Moldeador":
                parrafos1();
                rel("heroe_raza");
                break;
            case "El Dios Muerto":
                parrafos5("El Himno (Dirge)", "Turstarkuri", "Vástago", "Relaciones");
                rel("heroe_mundo");
                break;
            case "La Parca":
                parrafos3("Descripción", "Relaciones");
                rel("heroe");
                break;
            case "El Tendero":
                parrafos2("Dota: Dragon´s Blood");
                rel("vacio");
                break;
            case "Las Tres Sombras":
                parrafos3("Lista", "Curiosidades");
                rel("heroe_dioses");
                break;
            case "El Doliente":
                parrafos3("Historia", "Especulación");
                rel("heroe_mundo_dioses");
                break;
            case "Verodicia":
                parrafos2("La Gema del Zafiro");
                rel("heroe");
                break;
        }
    }


    private String Historia(String nombre, String tipo) {
        String hist = "";
        switch (nombre) {
            case "Aethrak":
                switch (tipo) {
                    case "texto1":
                        hist = "Aethrak es el Eldwurm del Aire en la serie animada Dota: Dragon's Blood.";
                        break;
                    case "texto2":
                        hist = "Aethrak y los dragones del aire pueden manipular el elemento de viento, que es un tercio del poder que compone una tormenta. Mientras vuelan pueden impulsarse por el aire con ráfagas de viento para aumentar su ya impresionante velocidad. También generan ráfagas de viento que suelen señalar su presencia cuando vuelan por zonas cerradas como cuevas.\n" +
                                "\n" +
                                "Un rasgo distintivo de Aethrak y sus compañeros dragones de aire son las partes de su cuerpo que parecen águilas. Tienen cinco garras afiladas en los extremos de las patas, alas anchas que se pliegan al sumergirse (lo que ayuda a disminuir la resistencia del aire) y púas aerodinámicas alrededor del cuerpo que les ayudan a volar por el cielo a gran velocidad. Los wyrmlings parecen tener púas en el hocico que se asemejan a picos pero empiezan a desaparecer cuando se convierten en eldwurms mayores.";
                        break;
                    case "texto3":
                        hist = "Todos los dragones de aire son carnívoros. Cuando cazan, vuelan a una altura suficiente para alcanzar las nubes y, al mismo tiempo, pueden ver a sus presas desde largas distancias. Cazan a sus presas mediante el movimiento lo que significa que es más probable que persigan a las presas que muestren algún signo de movimiento que a las que permanecen inmóviles.\n" +
                                "\n" +
                                "Una vez que divisan una presa potencial comienzan a descender lanzándose de cabeza y plegando las alas. En el momento en que la presa está al alcance de sus garras despliegan sus alas y extienden sus garras con el fin de llevarse a la desafortunada víctima para consumirla. Incluso si no consiguen asegurar su presa de esta manera son cazadores bastante persistentes. Seguirán persiguiéndolas mientras vuelan a baja altura (incluso dentro de densos bosques) para asegurarse de que pueden capturarlas de nuevo.";
                        break;
                    case "texto4":
                        hist = "Como todos los Eldwurms, Aethrak es inmortal en el sentido de que puede reencarnarse siempre que haya un cuerpo anfitrión adecuado para que su alma se instale. Al morir encuentra al siguiente dragón más viejo de su tipo (que son los dragones de aire en su caso) antes de llenar su cuerpo sin alma con su propia alma. Los recipientes que posee no son inmortales en sí mismos, por lo que todos mueren de forma natural como cualquier criatura viva, pero se dice que tienen una larga vida y que se hacen más fuertes tanto en fuerza física como en sus respectivos poderes elementales a medida que maduran y envejecen en lugar de marchitarse en dragones más débiles.";
                        break;
                    case "texto5":
                        hist = "El nombre de Aethrak proviene de la palabra \"aether\" (éter). Éter significa \"aire\" o \"atmósfera\" en latín. Como tal, el éter es la atmósfera o el aire que está por encima del suelo así como otros significados similares que se refieren a la atmósfera superior menos tangible o al aire divino que los dioses griegos respiran en su dominio celestial.";
                        break;
                }
                break;
            case "Aktok":
                switch (tipo) {
                    case "texto1":
                        hist = "Aktok es un antiguo dios serpiente del que se dice que un día se tragará el mundo. Tiene un culto de chamanes y adoradores que se reúnen una vez cada temporada para ofrecer sacrificios en un lugar especial designado. Lesale, el Venomancer, descansó una vez en este lugar, donde fue confundido con un heraldo de Aktok y se le entregaron ofrendas, tras lo cual siguió a los cultistas hasta su casa y se los comió.";
                        break;
                }
                break;
            case "Ascendentes":
                switch (tipo) {
                    case "texto1":
                        hist = "Los Ascendentes son un grupo de seres misteriosos a los que se refiere únicamente Mercurial, que desea convertirse en uno de ellos. Los Ascendentes hablan una lengua única. Los Trascendentales pueden tener algo que ver con los Ascendentes aunque la relación no está clara.";
                        break;
                }
                break;
            case "Avilliva":
                switch (tipo) {
                    case "texto1":
                        hist = "Avilliva es un dios de los Skywrath. Está simbolizado por alas ensangrentadas.";
                        break;
                }
                break;
            case "Belladonna":
                switch (tipo) {
                    case "texto1":
                        hist = "Belladonna es una de las Tres Sombras. Concede a los mortales el poder de ver lo invisible dilatando sus ojos.\n";
                        break;
                    case "texto2":
                        hist = "La belladona se basa en la atropa belladona, la planta de la belladona mortal, que antiguamente era utilizada como cosmético por las mujeres para dilatar sus pupilas.\n" +
                                "\n" +
                                "Belladonna también significa \"mujer bella\" en italiano.";
                        break;
                }
                break;
            case "Padre de Brewmaster":
                switch (tipo) {
                    case "texto1":
                        hist = "El padre de Brewmaster es un Celestial sin nombre que engendró a Mangix con una madre mortal transmitiendo sus poderes elementales a su hijo.";
                        break;
                }
                break;
            case "Celestial Ardiente":
                switch (tipo) {
                    case "texto1":
                        hist = "El Celestial Ardiente es uno de los celestiales. Impresionado por las enseñanzas de Xin entró en la Fortaleza de las Llamas y fusionó su cuerpo con las cenizas de Xin, creando la nueva entidad conocida como Ember Spirit. Se dice que le motivó una sensación premonitoria de conflicto inminente en el que pretende participar.";
                        break;
                }
                break;
            case "Byssark":
                switch (tipo) {
                    case "texto1":
                        hist = "Byssrak es el Eldwurm del Vacío en la serie animada Dota: Dragon's Blood, cuya alma sostiene el universo como uno de los ocho pilares de la creación. Entre los cuatro Eldwurms que representan las cuatro fuerzas fundamentales, él es el equivalente dracónico de Enigma, el Fundamental de la Gravedad. Es extremadamente breve con su discurso, sólo habla una palabra a la vez y no utiliza frases u oraciones al hablar.";
                        break;
                    case "texto2":
                        hist = "Byssrak y sus compañeros dragones del vacío tienen varios parecidos con Enigma que se integran en su diseño como sus esquemas de color similares y la energía violeta que fluye por las grietas entre sus escamas. Una característica única que poseen es su garrote de cola que tiene forma de jarrón que contiene la misma energía que fluye a través de las grietas entre sus escama pero su propósito es desconocido. A primera vista los dragones del vacío parecen carecer de alas incluso más que los dragones de tierra, que sólo llevan alas vestigiales, pero sus verdaderas alas se manifiestan a partir de las placas de sus hombros en forma de una misteriosa energía violeta.\n" +
                                "\n" +
                                "A juzgar por el equipo que se fabricó con sus restos, Byssrak y los dragones del vacío tienen la capacidad de manipular la gravedad y el espacio. Es de su especie con la que se forjó la Espada de Kaden, lo que significa que pueden manipular su propia gravedad para aumentar exponencialmente su propia masa, lo que les permite golpear más fuerte con sus enormes colas y otras extremidades. Los pergaminos del portal utilizados por los Caballeros Dragón (como Bram) también están hechos de restos de dragones del vacío. Esto podría implicar que los dragones del vacío también pueden manipular el espacio para teletransportarse a una distancia considerable.";
                        break;
                    case "texto3":
                        hist = "Como todos los Eldwurms, Byssrak es inmortal en el sentido de que puede reencarnarse siempre que haya un cuerpo anfitrión adecuado para que su alma se instale. Al morir encuentra al siguiente dragón más antiguo de su tipo (que son los dragones del vacío en su caso) antes de llenar su cuerpo sin alma con la suya propia. Los recipientes que posee no son inmortales en sí mismos, por lo que todos mueren de forma natural como cualquier criatura viva pero se dice que tienen una larga vida y se hacen más fuertes tanto en fuerza física como en sus respectivos poderes elementales a medida que maduran y envejecen en lugar de marchitarse hasta convertirse en dragones más débiles.";
                        break;
                }
                break;
            case "Celestiales":
                switch (tipo) {
                    case "texto1":
                        hist = "Los celestiales son un grupo de seres poderosos. En ocasiones interactúan, entran en conflicto e incluso procrean con los mortales. Los celestiales están en sintonía con diferentes elementos como el fuego, la tierra, el vacío y el rayo.";
                        break;
                    case "texto2":
                        hist = "Según Inai el primer celestial, un gran ser, creó cuatro niños con un golpe de su martillo probablemente refiriéndose a los Fundamentales.";
                        break;
                    case "texto3":
                        hist = "Raijin, el Espíritu de la Tormenta \n" +
                                "\n" +
                                "Kaolin, el Espíritu de la Tierra\n" +
                                "\n" +
                                "Xin, el espíritu del Fuego\n" +
                                "\n" +
                                "Inai, el Espíritu del Vacío\n" +
                                "\n" +
                                "Padre de Brewmaster\n" +
                                "\n" +
                                "Celestial Ardiente";
                        break;
                }
                break;
            case "Clasz":
                switch (tipo) {
                    case "texto1":
                        hist = "Clasz es una entidad que vive en el reino de Claszureme, que lleva su nombre. Se le describe como una figura \"infinita\".";
                        break;
                    case "texto2":
                        hist = "Para entrar en Claszureme es necesario estudiar y comprender las enseñanzas de Clasz.\n" +
                                "\n" +
                                "Los acólitos de Clasz deben observar ritos sin ojos de carne, que se quitan si quieren seguir adorando. Los seguidores hacen sonar unos guanteletes metálicos en oración y Clasz responde a los sonidos de estos impactos con regalos y bendiciones de suerte y protección.\n" +
                                "\n" +
                                "El Reloj de Arena de Claszureme está relacionado con Clasz.";
                        break;
                }
                break;
            case "Los Oscuros":
                switch (tipo) {
                    case "texto1":
                        hist = "Los Oscuros son un grupo de seres sin nombre. Sólo se les conoce por Slark, quien forjó un Pacto Oscuro con ellos. Cuando Slark reclama la victoria en un campo de batalla espera que los Oscuros honren su pacto. Se desconoce en qué consiste exactamente este pacto.";
                        break;
                }
                break;
            case "Ermarcor el Explorador":
                switch (tipo) {
                    case "texto1":
                        hist = "Ermacor el Explorador es una misteriosa figura parecida a una deidad en la historia de Dota 2. Ermacor fue una deidad prominente de antaño pero sus adoradores y las oraciones pronunciadas en su nombre disminuyeron en número y el templo dedicado a él quedó abandonado. Se dice que otorga bendiciones que ayudan a los que la reciben a \"encontrar un camino\", presumiblemente bendiciones que resuelven los problemas de los viajeros y explroadores. La tradición sugiere que Ermacor puede ser un dios del movimiento físico y de los exploradores o algo similar.";
                        break;
                }
                break;
            case "Los Sin Rostro":
                switch (tipo) {
                    case "texto1":
                        hist = "Los Sin Rostro son entidades desconocidas adoradas por Juggernaut, quien realiza ritos para ellos.";
                        break;
                }
                break;
            case "Gemelos Despellejados":
                switch (tipo) {
                    case "texto1":
                        hist = "Los Gemelos Despellejados, también conocidos como los Despellejados o simplemente Los Despellejadores, son un par de dioses que exigen enormes cantidades de sangre de sacrificio para vivir sin la cual descenderían y drenarían la sangre de todos los pueblos de las montañas Xhacatocatl. Los Gemelos Despellejados no pueden ser destruidos ni desterrados a otro reino.\n" +
                                "\n" +
                                "La sangre de los propios Gemelos se utiliza para teñir telas y templar armas aunque no se sabe cómo se obtiene su sangre.";
                        break;
                    case "texto2":
                        hist = "Para evitar la despoblación de sus tierras los sumos sacerdotes de las mesetas deben satisfacer la lujuria de los Gemelos Despellejados enviando a gente, como Strygwyr, que se dedica a una caza interminable de más víctimas para utilizarlas en sacrificios ceremoniales, transfiriendo su sangre a los Gemelos Despellejados a través de marcas sagradas en su vestimenta. Se dice que, en su frenética carrera de sangre, los Gemelos Despellejados a veces toman el control de Strygwyr proyectando su propia apariencia en su sabueso. Strygwyr lleva una capucha que le cubre los ojos ya que los Gemelos Despellejados guían sus movimientos a través de su vista.\n" +
                                "\n" +
                                "Los cazadores de huesos realizan una función similar en las tierras secas del oeste de Xhacatocatl donde cazan una variedad de bestias.\n" +
                                "\n" +
                                "Los Despellejados también emplean una gigantesca ave de rapiña llamada Iczoxtotec que surca los cielos en busca de batalla y, por tanto, de víctimas frescas para el sacrificio. Los cuervos son comunes sobre los altares de sacrificio y su inhumana lujuria por la carne los ha convertido en un símbolo sagrado de los Gemelos Despellejados.";
                        break;
                    case "texto3":
                        hist = "Según Strygwyr, los Gemelos Despellejados exigen el sacrificio de la Omnisciencia, un dios rival.\n" +
                                "\n" +
                                "El demonio Eztzhok es odiado por los Gemelos Despellejados por haber corrompido a Strygwyr, su siervo, y haber robado parte de la sangre cosechada por él. Los Gemelos Despellejados se dieron cuenta en el último momento de que la corrupción de Eztzhok casi se había apoderado de Strygwyr y pudieron recuperar a su siervo a costa de un gran sacrificio.\n" +
                                "\n" +
                                "Los Gemelos Despellejados ven con buenos ojos a Pudge, cuyo sangriento trabajo aprueban.\n" +
                                "\n" +
                                "Mars, el Dios de la Guerra, busca luchar y quizás matar a los Gemelos Despellejados.";
                        break;
                    case "texto4":
                        hist = "Los Gemelos Despellejados son similares a Xipe Totec, el Dios azteca de la vida, la muerte y la guerra.";
                        break;
                }
                break;
            case "Fundamentales":
                switch (tipo) {
                    case "texto1":
                        hist = "Los fundamentos son poderosas entidades primordiales cada una de las cuales representa las interacciones fundamentales que componen el universo.";
                        break;
                    case "texto2":
                        hist = "Un Fundamental se define por varias cosas. En primer lugar encarnan las leyes fundamentales del universo que posteriormente adquirieron sensibilidad por medios desconocidos. Existen en todos los planos de existencia del universo a la vez y, por tanto, son fuerzas omnipresentes. Los Fundamentales pueden utilizar esta omnipresencia para invocar versiones de sí mismos de otros planos, pero cada Fundamental tiene diferentes formas y aplicaciones de este poder.\n" +
                                "\n" +
                                "Existen más allá de los límites del plano físico y poseen habilidades que desafían las leyes de la naturaleza. Elder Titan creó a los Fundamentales mucho antes del Cisma, cuando dividió las fuerzas del universo. \n" +
                                "\n" +
                                "Cuando un Fundamental muere, vuelve al Plano Fundamental.";
                        break;
                    case "texto3":
                        hist = "Hay cuatro Fundamentos lo que significa que algunas menciones a los Fundamentales deben ser referencias superpuestas a la misma entidad.\n" +
                                "\n" +
                                "Io: El Fundamental del electromagnetismo o fuerza electromagnética. Io es una fuerza omnipresente que encarna las fuerzas de atracción y repulsión dentro del campo material y la carga que une toda la existencia aludiendo a las fuerzas complementarias de la electricidad y el magnetismo. Cuando se manifiesta en el plano físico a través de la manipulación de las líneas eléctricas, Io aparece en el mundo como una brizna, una manifestación de la más mínima fracción de su verdadero ser.\n" +
                                "\n" +
                                "Chaos Knight: Conocido como el jinete gemelo de la Oscuridad, el Caballero del Caos es el Fundamental del Caos pero las reacciones dirigidas a él implican en gran medida que es el Fundamental de la fuerza nuclear fuerte. Entre los cuatro Fundamentales es el más antiguo y el más fuerte de todos ellos ya que extrae su fuerza del desorden del universo. A pesar de su naturaleza malvada y caótica parece tener un motivo ulterior que consiste en volver a unir los cuatro Fundamentales en su plano progenitor.\n" +
                                "\n" +
                                "Keeper of the Light: Conocido como el jinete gemelo de la Luz, el creador de los soles antiguos. Ezalor es el Fundamental del orden, pero las reacciones dirigidas a él implican en gran medida que es el Fundamental de la fuerza nuclear débil. Fue el primero en salir del plano Fundamental separándose de los demás Fundamentales que estaban unidos por la gran Armonía Primordial. Su huida desafió el primer pacto y ahora es considerado un Fundamental renegado por el Caballero del Caos, quien lo persigue por todos los planos del mundo. De todos los Fundamentales Ezalor es el único que tiene explícitamente la capacidad de controlar la magia y su propia esencia manipulando la llamada \"armonía\" y la \"armonía primordial\".\n" +
                                "\n" +
                                "Enigma: El Fundamental de la fuerza gravitacional o interacción gravitatoria, del que se dice que es un antiguo viajero cuya verdadera historia se pierde en el tiempo. En realidad, Enigma es un Fundamental, una fuerza destructiva de la naturaleza creciente y hambrienta que consume todo lo que se atreve a existir. Su misterio sólo es igualado por las profundidades de su poder, teniendo la capacidad de canalizar singularidades sobre el mundo en forma de agujeros negros superdensos. Se ha interesado por los ambiciosos alquimistas del plano material, atrayéndolos a su eterna servidumbre con la promesa de un poder fundamental contenido en docenas de diarios falsos \"escritos\" por un legendario alquimista llamado Jovat Kazran.";
                        break;
                    case "texto4":
                        hist = "Los Fundamentales se conocían originalmente como los Cinco Fundadores, siendo probablemente Elder Titan el quinto miembro.\n" +
                                "\n" +
                                "La mayor parte de la historia de los Fundamentales se basa en las interacciones fundamentales de la física de la vida real y otros conceptos relacionados.\n" +
                                "\n" +
                                "En física, las teorías de la gran unificación y las teorías de la superunificación postulan que las cuatro fuerzas fundamentales se unificaron una vez en una sola fuerza. Esta teoría se convirtió en un concepto de la historia al que se alude en el lore de los Fundamentales, especialmente en las respuestas de los aliados no utilizados de Enigma.\n" +
                                "\n" +
                                "En cuanto a la unificación de las cuatro fuerzas, fue la gravedad la que se separó primero de las otras fuerzas. Sin embargo en la versión de Dota 2 es la fuerza nuclear débil (representada por keeper of the Light) la que se separa primero de las demás fuerzas.";
                        break;
                }
                break;
            case "Fymryn":
                switch (tipo) {
                    case "texto1":
                        hist = "Fymryn es una elfa bendecida por un poder olvidado. Quiere cumplir una profecía para traer de vuelta a Mene, la antigua diosa de la luna, robando los lotos mágicos de las piscinas del templo de Selemene antes de entregárselos a Invoker, a quien cree que la traerá de vuelta.\n" +
                                "\n" +
                                "Posee un poder mágico único que gira en torno a la agilidad y el engaño, muy adecuado para un ser escurridizo como ella y la raza a la que pertenece. Fymryn tiene la capacidad de disfrazarse en una persona diferente, aunque este cambio sólo se aplica a su aspecto físico y sigue conservando su verdadera voz. También puede duplicarse a sí misma para invocar hasta quince clones idénticos, pero no copian nada de lo que ella está manejando en ese momento. Por último, tiene la capacidad de teletransportarse a distancias cortas para escapar rápidamente o para abrumar a un oponente con ataques rápidos.";
                        break;
                }
                break;
            case "Diosa de la Suerte":
                switch (tipo) {
                    case "texto1":
                        hist = "La Diosa de la Suerte es una deidad sin nombre que vela por Aggron Stonebreak. Lleva un objeto bendecido que representa a la diosa y le ha encomendado la tarea de vigilar una bandada de alondras de fuego.";
                        break;
                }
                break;
            case "Los Ocultos":
                switch (tipo) {
                    case "texto1":
                        hist = "Los Ocultos son seres que viven en el Templo Oculto. Tienen un gran conocimiento y poseen poderes desconocidos.\n" +
                                "\n" +
                                "Lanaya conoció a los Ocultos tras descubrir su templo. Para satisfacer su deseo de conocimiento sirve a los Ocultos como asesina a cambio de sus secretos y respuestas. Sus objetivos suelen ser aquellos que han descubierto secretos prohibidos, lo que ofende a sus maestros.";
                        break;
                }
                break;
            case "Indrak":
                switch (tipo) {
                    case "texto1":
                        hist = "Indrak es el Eldwurm iónico, cuya alma sostiene el universo como uno de los ocho pilares de la creación. Entre los cuatro Eldwurms que representan las cuatro fuerzas fundamentales, es el equivalente dracónico de Io, el Fundamental del Electromagnetismo. Al igual que Io, Indrak y las especies que utiliza como recipientes ejercen el poder de la electricidad. Se dice que sólo habla con la verdad objetiva, un rasgo que comparten todos los dragones iónicos.";
                        break;
                    case "texto2":
                        hist = "Al igual que la mordedura de cualquier otro dragón elemental, Indrak y los dragones iónicos poseen una mordedura que porta su respectivo poder elemental, la electricidad. Este poder estático continúa después de su muerte ya que incluso sus restos siguen teniendo propiedades eléctricas, que Kaden utiliza con gran efecto como arma de electroshock.\n" +
                                "\n" +
                                "Kaden afirma que los dragones iónicos no pueden mentir. Actualmente se desconoce qué significa esto.";
                        break;
                    case "texto3":
                        hist = "Como todos los Eldwurms, Indrak es inmortal en el sentido de que puede reencarnarse siempre que haya un cuerpo anfitrión adecuado para que su alma se instale. Al morir encuentra al siguiente dragón más antiguo de su tipo (que son los dragones iónicos en su caso) antes de llenar su cuerpo sin alma con su propia alma. Los recipientes que posee no son inmortales en sí mismos por lo que todos mueren de forma natural como cualquier criatura viva, pero se dice que tienen una larga vida y se hacen más fuertes tanto en fuerza física como en sus respectivos poderes elementales a medida que maduran y envejecen en lugar de marchitarse en dragones más débiles.";
                        break;
                    case "texto4":
                        hist = "El nombre de Indrak y su temática en torno a los rayos proviene de Indra, la antigua deidad india del rayo, el trueno y la lluvia.";
                        break;
                }
                break;
            case "Ix'yxa el Destructor":
                switch (tipo) {
                    case "texto1":
                        hist = "Ix'yxa el Destructor es un ser divino procedente de los Confines Infernales.\n" +
                                "\n" +
                                "Sus excesivos festines le han hecho engordar demasiado para acceder a los pasajes conocidos entre el mundo de las tinieblas y la superficie por lo que intercambia favores con otros que le ayuden a encontrar nuevos caminos por los que pueda viajar. Sin embargo desconfía de aquellos a los que ha otorgado una parte de su poder o con los que ha intercambiado favores, por lo que les envía un espectro de sí mismo para que vigilen a sus apoderados. Uno de estos recipientes es Pugna, quien lleva un tocado que contiene el ojo de Ix'yxa.";
                        break;
                }
                break;
            case "Lirrak":
                switch (tipo) {
                    case "texto1":
                        hist = "Lirrak es la Eldwurm del Agua. También conocida como la \"Madre de los Océanos\" y/o \"Madre de las Tormentas\", aprovecha los poderes del agua (en todas sus formas). Vive bajo las aguas estancadas de un lago en la cima de una montaña con cráteres donde un campo de hierba y flores rodea la tierra del lago.\n" +
                                "\n" +
                                "Invoker fue capaz de localizar el hogar de la Eldwurm e invocó su orbe Wex para separar las aguas y revelar su ubicación bajo ellas antes de sellar al dragón en su interior. Lirrak fue capaz de atravesar el orbe e intentó congelarlo en represalia antes de que él esquivara rápidamente su ataque y la sellara de nuevo con éxito con su orbe Exort.";
                        break;
                }
                break;
            case "Maelrawn el Tentacular":
                switch (tipo) {
                    case "texto1":
                        hist = "Maelrawn, o Maelrawn el Tentacular, es un dios abisal que vive en las profundidades del océano. Se le describe con tentáculos y probablemente se asemeja a un cefalópodo gigante. Según Tidehunter y Naga Siren, Maelrawn reside en un gigantesco remolino. Slithice también habla de \"el que rompió la cáscara del mundo\", quizá refiriéndose a Maelrawn.";
                        break;
                    case "texto2":
                        hist = "Durante la batalla en la Isla Temblorosa, Maelrawn fue convocado por Tidehunter. Con sus tentáculos Maelrawn agitó el agua y viento, destruyendo las dos flotas enfrentadas de la Armada de Claddish y los Demonios de la Catarata.";
                        break;
                    case "texto3":
                        hist = "Maelrawn es adorado por muchos Leviatanes que con frecuencia saquean las ciudades hundidas en busca de tesoros que traer como tributo. Uno de estos intentos ocurrió en Crey, donde una fuerza de cien guardias Slithereen, comandados por Slithice, se enfrentó y derrotó a un ejército Leviatanes.\n" +
                                "\n" +
                                "Por otro lado los Slithereen parecen despreciar a Maelrawn, especialmente Slithice quien jura acabar con su existencia.";
                        break;
                }
                break;
            case "Forjador de Máscaras":
                switch (tipo) {
                    case "texto1":
                        hist = "El Fabricante de Máscaras es un dios de la Isla de las Máscaras. Es adorado por Juggernaut, quien peregrina al Templo de las Máscaras para realizar rituales.";
                        break;
                }
                break;
            case "Mene":
                switch (tipo) {
                    case "texto1":
                        hist = "Mene es la antigua diosa de la luna. Es adorada por los elfos. Se dice que vive en los Lotos de Mene. Aún no está claro por qué desapareció y qué relación tiene con Selemene.";
                        break;
                    case "texto2":
                        hist = "Una profecía predice el regreso de Mene cuando los Lotos de Mene son depositados en la Tierra por Invoker.";
                        break;
                    case "texto3":
                        hist = "Mene es el antiguo nombre de Selemene de Dota 2 antes de ser reemplazado por razones desconocidas, por lo que cualquier mención de Mene en el lore de Dota 2 se refiere a la misma diosa lunar Selemene. \n" +
                                "\n" +
                                "En Dota: Dragon's Blood sin embargo, son dos diosas distintas e individuales.";
                        break;
                }
                break;
            case "Nyctasha":
                switch (tipo) {
                    case "texto1":
                        hist = "Nyctasha era una diosa cuyas pesadillas dieron nacimiento a Atropos.";
                        break;
                }
                break;
            case "Nyx":
                switch (tipo) {
                    case "texto1":
                        hist = "Nyx es la reina de los escarabajos zealot, adorada por su raza como una diosa. Al igual que otros escarabajos zealot, es telepática, incluso más que sus parientes menores. Reside en una cámara especial, posiblemente dentro de la Colmena Oculta. Nyx puede tener conocimientos de alquimia, utilizando productos químicos especiales para ayudar al actual Nyx Assassin a desarrollar un caparazón resistente a la magia.";
                        break;
                    case "texto2":
                        hist = "Como reina, Nyx segrega una sustancia especial que hace que los gusanos jóvenes se metamorfoseen en morfologías únicas. Con esta sustancia selecciona un solo gusano y desencadena una transformación que hace que el gusano se convierta en un Nyx Assassin. No todos los gusanos sobreviven a este proceso. Una vez que el asesino madura es enviado al mundo para matar en nombre de su diosa. Se desconocen las motivaciones personales de Nyx detrás de estos asesinatos y cómo elige a sus objetivos. Las bendiciones de la reina suelen imbuir a sus asesinos con nuevas y extrañas energías.\n" +
                                "\n" +
                                "Nyx también posee el Orbe Sagrado que entrega a uno de sus asesinos cada mil ciclos de la colmena. El orbe otorga a su portador grandes poderes nuevos.";
                        break;
                    case "texto3":
                        hist = "Nyx parece odiar a Abaddon, y ha enviado emisarios en el pasado para atacarlo. La razón de esta rivalidad es desconocida. Nyx Assassin también detesta a Abaddon.";
                        break;
                    case "texto4":
                        hist = "Nyx es la diosa griega de la noche.";
                        break;
                }
                break;
            case "Obelis":
                switch (tipo) {
                    case "texto1":
                        hist = "Obelis es una deidad adorada por los Caballeros del Pliegue.";
                        break;
                }
                break;
            case "Omniciencia":
                switch (tipo) {
                    case "texto1":
                        hist = "La Omnisciencia, también conocida como el que todo lo ve, es una entidad venerada por los habitantes del mundo de Dota 2 aunque pocos la han visto de cerca. La Omnisciencia, que lleva miles de millones de eones en las profundidades del planeta, afirma haber creado el propio mundo formando un enorme caparazón de piedra alrededor de su cuerpo para protegerse de los peligros del espacio. Se puede acceder a la Omnisciencia a través de los acantilados de Emauracus aunque el viaje a las profundidades del planeta dura muchas semanas. Al ser omnisciente, la Omnisciencia aparentemente puede ver seres de otros planos como los fantasmas del Caballero del Caos.";
                        break;
                    case "texto2":
                        hist = "Un único libro contiene las escrituras atribuidas a la Omnisciencia[3]. Los piadosos peregrinos a los altos acantilados de Emauracus esperan recibir visiones sagradas de la Omnisciencia[4].\n" +
                                "\n" +
                                "La religión obliga a sus seguidores a emprender cruzadas, convirtiendo a pueblos y criaturas por la fuerza de las armas. Entre sus devotos caballeros se encuentra Purist Thunderwrath, el Omniknight. Tras un periodo de fe vacilante Purist fue seleccionado por la Omnisciencia para un encuentro personal donde conoció la verdadera naturaleza de su Dios. Aunque las afirmaciones de la Omnisciencia no son verificables, el encuentro de Purist con el que todo lo ve y los poderes que le otorgó confirmaron su fe sin lugar a dudas.\n" +
                                "\n" +
                                "Se practica el sacrificio humano arrojando a las víctimas a un pozo. Los enemigos muertos también se consideran sacrificios dignos para la Omnisciencia. Las profecías son emitidas por la propia Omnisciencia o por su sacerdocio. Los hechizos oscuros, como el Necronomicon son despreciados. Los seguidores esperan \"disolverse\" en la Omnisciencia a su debido tiempo. Se desconoce qué significa esto exactamente.\n" +
                                "\n" +
                                "Los seguidores devotos reciben habilidades mágicas que protegen y purifican. La propia Omnisciencia protege a sus guerreros en la superficie del planeta y encanta sus armas con propiedades sagradas.\n" +
                                "\n" +
                                "Hace mucho tiempo la Omnisciencia bendijo a los primeros mortales y éstos se convirtieron en caballeros que forjaron armaduras encantadas que superan cualquier cosa hecha por los herreros de Emauracus en la actualidad.";
                        break;
                    case "texto3":
                        hist = "Una orden clerical de Hierofantes supervisa a los adoradores de la Omnisciencia, con un Hierofante Anciano que lidera el rebaño. Los nombres de los Hierofantes se inscriben a veces en las armas. Los Hierofantes están obligados a seguir un estricto conjunto de reglas:\n" +
                                "\n" +
                                "Un Hierofante de la Omnisciencia debe sentir siempre el poder que le protege.\n" +
                                "\n" +
                                "Un Hierofante de la Omnisciencia debe sentir siempre el peso de la responsabilidad sobre sus hombros.\n" +
                                "\n" +
                                "Un Hierofante de la Omnisciencia debe siempre prestar atención a las palabras de su orden.\n" +
                                "\n" +
                                "Un Hierofante de la Omnisciencia debe siempre protegerse de cualquier amenaza.\n" +
                                "\n" +
                                "Un Hierofante de la Omnisciencia debe acercarse siempre con la cabeza inclinada.\n" +
                                "\n" +
                                "Los monjes también forman parte del clero, conocido por coser capas para sus cruzados.";
                        break;
                    case "texto4":
                        hist = "Según Strygwyr, los Gemelos Despellejados exigen el sacrificio de la Omnisciencia como Dios rival.\n" +
                                "\n" +
                                "Zeus conoce la Omnisciencia.";
                        break;
                }
                break;
            case "Orrak":
                switch (tipo) {
                    case "texto1":
                        hist = "Orrak (o Aurrak) es la Eldwurm luminosa, cuya alma sostiene el universo como uno de los ocho pilares de la creación. Entre los cuatro Eldwurms que representan las cuatro fuerzas fundamentales, ella es el equivalente al Guardián de la Luz con su encarnación de la luz, pero en el fondo es la fuerza nuclear fuerte.";
                        break;
                    case "texto2":
                        hist = "Como todos los Eldwurms, Orrak es inmortal en el sentido de que puede reencarnarse siempre que haya un cuerpo anfitrión adecuado para que su alma se instale. Al morir encuentra al siguiente dragón más antiguo de su tipo (que son los dragones luminosos en su caso) antes de llenar su cuerpo sin alma con su propia alma. Los recipientes que posee no son inmortales en sí mismos por lo que todos mueren de forma natural como cualquier criatura viva pero se dice que tienen una larga vida y que se hacen más fuertes tanto en fuerza física como en sus respectivos poderes elementales a medida que maduran y envejecen en lugar de marchitarse hasta convertirse en dragones más débiles.";
                        break;
                    case "texto3":
                        hist = "Ambos nombres, Orrak y Aurrak, hacen referencia a su naturaleza dorada. \"Or\" es otra palabra que designa el color del oro, utilizada a menudo en el contexto de la heráldica. Su último nombre puede provenir de \"Au\", que es el símbolo químico del oro en la tabla periódica.";
                        break;
                }
                break;
            case "Polymorphia":
                switch (tipo) {
                    case "texto1":
                        hist = "Polymorphia parece ser un Dios, adorado por Morphling. Puede tratarse de un ser acuático, capaz de realizar \"patrones eternos\".";
                        break;
                }
                break;
            case "Poseidon":
                switch (tipo) {
                    case "texto1":
                        hist = "Poseidón es una deidad en la historia de Dota 2. Pertenece al mismo panteón que Zeus y Mars. Si se utilizara el árbol genealógico de los dioses griegos en la vida real sería el hermano del primero y el tío del segundo. Como Dios de los mares se da a entender que tiene autoridad sobre los asuntos náuticos.";
                        break;
                    case "texto2":
                        hist = "Poseidón se basa en el Dios del mismo nombre de la mitología griega.";
                        break;
                }
                break;
            case "Conciencia Primordial":
                switch (tipo) {
                    case "texto1":
                        hist = "La Conciencia Primordial (también conocida como Mente Primordial, Origen Primordial o simplemente el Primordial) es la primera mente que existe en el lore de Dota 2, mucho antes de la creación y la existencia misma.";
                        break;
                    case "texto2":
                        hist = "Se dice que es el progenitor de toda la creación, al menos según uno de sus fragmentos mayores. Cuando el universo fue creado se dividió en muchos fragmentos. Tres de sus fragmentos mayores eran conocidos como Radinthul, Diruulth y Zet. Cuando la Mente Primordial se dividió en Diruulth, Radinthul y Zet, existieron y lucharon en un mundo anterior al actual. No se sabe cómo se llama este mundo. Debido a que todos comparten el mismo progenitor Zet a veces se refiere a sus hermanos como sus otros yo, como si fueran un mismo ser.\n" +
                                "\n" +
                                "Los dos fragmentos mayores de la Mente Primordial (ahora conocidos como los Ancestros) existen en las Piedras Némesis que una vez formaron la Luna Loca antes de que fuera destruida por los Ancestros en guerra. Por otro lado, el poder que Zet utilizó para apresar a ambos quedó atrapado en una piedra conocida como Nemestice que también habita en la misma materia lunar que una vez formó la Luna Loca.\n" +
                                "\n" +
                                "Un aspecto del Primordial llamado Zet conoce el misterio de los orígenes de las Runas de Poder. Su testimonio de este conocimiento es su capacidad para crear estas runas de la nada.";
                        break;
                    case "texto3":
                        hist = "La historia del Doliente (Wailing One) es muy similar a la de la entidad conocida como Zet. Aunque ambas historias tienen sus diferencias las dos mencionan una mente primordial que era anterior a toda la existencia y que posteriormente fue destrozada para ser testigo de toda la creación. Ambas historias mencionan incluso un gran cisma.";
                        break;
                }
                break;
            case "Raijin":
                switch (tipo) {
                    case "texto1":
                        hist = "Raijin era un Celestial. Fue convocado sin consentimiento por el elementalista Thunderkeg lo que le enfureció enormemente. Por ello asoló la tierra de Thunderkeg con vientos e inundaciones. El elementalista trató de resistirse a esto con su escasa magia y tuvo poco efecto hasta que lanzó un hechizo suicida que lo fusionó con el Celestial, trayendo a Raijin a su cuerpo y aprisionándolo allí. Ahora fusionados en un solo ser los dos renacieron como Raijin Thunderkeg, el Espíritu de la Tormenta.";
                        break;
                    case "texto2":
                        hist = "Raijin es el Dios japones del trueno.";
                        break;
                }
                break;
            case "Scree'auk":
                switch (tipo) {
                    case "texto1":
                        hist = "Scree'auk es una diosa que concedió a Shendelzare la energía espiritual que deseaba para llevar a cabo su venganza. Puede que sea sagrada para la raza Skywrath y probablemente se parezca a un gran pájaro.\n" +
                                "\n" +
                                "Dragonus puede haber hecho un pacto con Scree'auk intercambiando su lealtad en favor de su poder. También puede haber hecho el Talon de Scree'auk para su amante no correspondida, Shendelzare.";
                        break;
                    case "texto2":
                        hist = "El auk (alcidae) es un tipo de ave que no vuela";
                        break;
                }
                break;
            case "Selemene (Dragon's Blood)":
                switch (tipo) {
                    case "texto1":
                        hist = "Selemene fue una vez una mortal que robó el poder de Mene, la antigua diosa de la luna y desde entonces ha usurpado su Templo de Mene. Se desconoce su relación con Mene. Como todavía existe un culto elfo que adora a Mene durante los acontecimientos del anime, Selemene, enfadada por el robo de Fymryn, decide erradicar la antigua fe con la ayuda de sus tropas.\n" +
                                "\n" +
                                "En su vida mortal Invoker y ella tuvieron una hija llamada Filomena a la que se negó a salvar tras su ascensión.";
                        break;
                }
                break;
            case "Selemene":
                switch (tipo) {
                    case "texto1":
                        hist = "Selemene es la diosa de la luna. Es adorada por Mirana y Luna. El antiguo Bosque de la Noche Plateada está dedicado a ella y contiene su reserva privada de lotos brillantes que crecen en estanques plateados. Selemene está asociada con la Polilla Lunar aunque la naturaleza precisa de esta relación no está clara.\n" +
                                "\n" +
                                "En otras culturas posiblemente sea representada por avatares como Mei Nei, un conejo que repone a los guerreros heridos y cansados.\n" +
                                "\n" +
                                "El Templo de Mene está dedicado a Selemene. Mirana, quien ha abandonado su reino para servir a Selemene, reza a veces en el templo, donde recibe visiones proféticas. En la noche de cada luna nueva los seguidores de Selemene se ponen ropas sagradas, cantan ritos y queman ofrendas a la diosa.\n" +
                                "\n" +
                                "También existe un Santuario de Selemene erigido en el lugar en el que cayó un disco lunar del cielo hace mucho tiempo cuando los Bosques de la Noche Plateada aún eran jóvenes.";
                        break;
                    case "texto2":
                        hist = "Al tener control sobre la luna y sus energías, Selemene imbuye las armas de sus seguidores con energía lunar, golpea a sus enemigos con rayos lunares y envuelve la tierra en sombras. En tiempos de gran necesidad la diosa desciende al mundo y oscurece el sol con un eclipse lunar para ayudar a sus campeones en la batalla. También es capaz de bendecir a sus seguidores con poderes similares incluyendo compañeros animales como Andalmere, el León de la Luna.";
                        break;
                    case "texto3":
                        hist = "Una secta de guerreros, la Orden de la Luna Oscura, adora y se dedica al servicio de Selemene. Residiendo en los Bosques de la Noche Plateada, encuentran e inician a nuevos miembros en la orden como Selemene exige. Una de esas iniciadas fue Luna, la Jinete de la Luna. Tras encontrarse en el límite del bosque, Luna fue sometida a una prueba, durante la cual una enorme bestia felina se enfrentó a ella y la condujo a una colina iluminada por la luna.\n" +
                                "\n" +
                                "A los que se niegan unirse a la Luna Oscura se les prohíbe volver al Bosque de la Noche Plateada.";
                        break;
                    case "texto4":
                        hist = "Selemene parece ser la responsable de frenar la Luna Oscura, un cataclismo de terribles consecuencias para el mundo. Por ello sus poderes se ven a veces perturbados y debilitados por la Horda de la Luna Oscura, una facción que pretende destruir a la diosa y hacer que la Luna Oscura se produzca. Se dice que sus poderes son una corrupción en el dominio de Selemene, tomando la forma de \"sombras\" y es bien conocido por ella y sus seguidores.\n" +
                                "\n" +
                                "Mars considera a Selemene una diosa rival y desea matarla.";
                        break;
                    case "texto5":
                        hist = "Selemene está probablemente basada en Selene, la diosa griega de la luna.\n" +
                                "\n" +
                                "Mene es el antiguo nombre de Selemene de Dota 2 antes de ser reemplazado por razones desconocidas. Por ello no hay que confundir a Mene con un ser distinto de la Selemene del lore de Dota 2 sino que Mene es el antiguo nombre de Selemene a diferencia de su versión en Dota: Dragon's Blood.";
                        break;
                }
                break;
            case "Sherzi":
                switch (tipo) {
                    case "texto1":
                        hist = "La emperatriz Sherzi fue un personaje exclusivo de la serie Dota: Dragon's Blood. Es la madre de Mirana.";
                        break;
                }
                break;
            case "Shiva":
                switch (tipo) {
                    case "texto1":
                        hist = "Shiva es una diosa asociada al hielo y al frío. Una vez fue dueña de la Guardia de Shiva (Shiva's Guard).";
                        break;
                }
                break;
            case "Skadi":
                switch (tipo) {
                    case "texto1":
                        hist = "Skadi es una diosa. Poco se sabe de ella, salvo que sus \"ojos\" se utilizan para fabricar artefactos y armas. En la prisión de Arrecife Oscuro se encontró una Espada Skadi. Otra arma Skadi fue fabricada por un herrero y un mago, con materiales encontrados en el Arrecife Oscuro.";
                        break;
                }
                break;
            case "Slyrak":
                switch (tipo) {
                    case "texto1":
                        hist = "Slyrak es el Eldwurm de Fuego en la serie animada de Dota: Dragon's Blood.\n" +
                                "\n" +
                                "Con el tiempo, después de ese encuentro, Davion tuvo pesadillas y cuando se transforma en Slyrak sus ropas arden hasta que Invoker le da a Davion una armadura que no se puede romper si se transforma. Más tarde Davion y Slyrak llegaron a un entendimiento. Incluso formó una tregua con Kaden para detener al Virrey. Más tarde liberó a Davion de sus ataduras para luchar contra Terrorblade en Foulfell.";
                        break;
                }
                break;
            case "Diosa Solar":
                switch (tipo) {
                    case "texto1":
                        hist = "La Diosa Solar es una deidad sin nombre adorada por los habitantes del basurero centelleante oriental.";
                        break;
                    case "texto2":
                        hist = "Los acólitos de la Diosa Solar creen que el sol proporciona al mundo un amor cálido. Lina viajó una vez para estudiar las artes de la llama con los acólitos que creían que su pelo estaba bendecido por la luz. El acólito le dio baratijas para que se las pusiera en el pelo y reflejaran la luz del sol. Se rumorea que en un momento de bendición divina la propia Diosa Solar descendió para bendecir a Lina con su poder y le concedió como regalo túnicas fluidas y medallones de oro.\n" +
                                "\n" +
                                "Sus adoradores también forjan objetos de oro a menudo dedicados a su diosa.";
                        break;
                    case "texto3":
                        hist = "La Fragua Solar (Solar Forge) puede tener alguna relación con la Diosa Solar.";
                        break;
                }
                break;
            case "Espíritu de la Naturaleza":
                switch (tipo) {
                    case "texto1":
                        hist = "El Espíritu ancestral de la Naturaleza existe dentro de todas las plantas del mundo natural. Rooftrellen es capaz de invocarlo para que libere su poder a través de las plantas circundantes y provoque un crecimiento excesivo de vides y ramas.\n" +
                                "\n" +
                                "Es posible que este espíritu provenga de las semillas de Verodicia, de las que se dice que contienen un espíritu naciente en su interior.";
                        break;
                }
                break;
            case "El Dios Muerto":
                switch (tipo) {
                    case "texto1":
                        hist = "El Dios Muerto es una deidad que causa la destrucción de los vivos. Comanda legiones de seguidores que suscriben la \"nihilosofía venenosa\" del Dios Muerto. Los ejércitos marchan en nombre del Dios Muerto invadiendo y conquistando tierras. El Dios Muerto maneja una varita mágica.";
                        break;
                    case "texto2":
                        hist = "El Dios de los Muertos envía el Himno, un sonido funesto que incita a los muertos, consume a los vivos y los convierte a su servicio. Uno de estos conversos fue Undying, su principal heraldo, encargado de reunir a los muertos de todo el mundo contra los vivos. Los muertos vivientes convertidos son tan numerosos que los ejércitos del Dios Muerto pueden reconocerse por las armaduras de sus antiguas naciones.";
                        break;
                    case "texto3":
                        hist = "Los ejércitos del Dios Muerto se dirigieron a Turstarkuri resucitando a los muertos de anteriores invasores y asolando los reinos de las tierras bajas. Allí se dirigieron al monasterio de la montaña donde los monjes de Turstarkuri residían en meditación. Los monjes creyeron que los invasores eran meras ilusiones y fueron asesinados en el acto. Sólo un joven acólito, el futuro Anti-Mage, consiguió escapar. Los monjes asesinados se alzaron como muertos vivientes y se unieron al sacerdocio del Dios Muerto.";
                        break;
                    case "texto4":
                        hist = "Hace mucho tiempo un vástago del Dios Muerto lideró un ejército de muertos pero fue traicionado por sus secuaces que intentaron volver a su sueño. Un campeón no muerto de su ejército llevaba el Dominador abrasador (Searing Dominator).";
                        break;
                    case "texto5":
                        hist = "Al Dios Muerto se le opone la Catedral de Rumusque, cuyos clérigos buscan purgar la tierra de su corrupción. Hace cientos de años, la sacerdotisa de Rumusque, Crella, intentó atar a los lugartenientes del Dios Muerto con las Cadenas de la Absolución. Pero sus cadenas fueron corrompidas por el Dirge y cayeron bajo el mando del Dios Muerto destruyendo la patria de Crella. Las Cadenas fueron descubiertas más tarde y adquiridas por Pudge, lo que el Dios Muerto considera un robo. Exige la devolución de las Cadenas pero Pudge se niega a hacerlo.\n" +
                                "\n" +
                                "Los Campos de la Matanza sin Fin, una vez corrompidos por el Dios Muerto, fueron recientemente limpiados por los clérigos de Rumusque tras una peregrinación al lugar.";
                        break;
                }
                break;
            case "El Increado":
                switch (tipo) {
                    case "texto1":
                        hist = "El Increado es una entidad divina desconocida a la que hace referencia Elder Titan. Es capaz de destrozar, descrear o renovar seres. También podría ser simplemente una metáfora de todo lo que aún no ha sido creado.";
                        break;
                }
                break;
            case "La Parca":
                switch (tipo) {
                    case "texto1":
                        hist = "La Parca es una entidad mortífera en el lore de Dota 2.";
                        break;
                    case "texto2":
                        hist = "Esta misteriosa figura encapuchada tiene su origen en el más allá del velo de la muerte. Al igual que los otros poderes emblemáticos del Inframundo, la Parca conduce a los muertos a su propio dominio eterno con un movimiento de su guadaña. Las representaciones de esta entidad en diversas obras de arte son consistentes con su característica capa encapuchada y su enorme guadaña pero el Libro de los Muertos muestra a la Parca con alas angelicales.\n" +
                                "\n" +
                                "Al igual que cierto monje corrupto, la Parca confía en la peste y la plaga como herramientas para cosechar almas.";
                        break;
                    case "texto3":
                        hist = "La fuerte conexión de Necrophos con la muerte y la decadencia le otorga habilidades de la propia Parca. Puede invocar la Guadaña de la Parca para sacrificar a los vivos con un solo golpe. Por otro lado la Parca oscura sigue el camino de Necrophos con anticipación, dejando su trabajo en la estela del mago de la plaga que siempre está listo para convocar a esta entidad oscura.";
                        break;
                }
                break;
            case "El Moldeador":
                switch (tipo) {
                    case "texto1":
                        hist = "El Moldeador es el creador del universo, al menos según Elder Titan.";
                        break;
                }
                break;
            case "El Tendero":
                switch (tipo) {
                    case "texto1":
                        hist = "El tendero es un personaje importante en la serie animada de Dota: Dragon's Blood.";
                        break;
                    case "texto2":
                        hist = "El comerciante o tendero regresa en la serie de animación DOTA: Dragon's Blood. Su breve encuentro con los héroes de la historia no deja ver su gran influencia en sus historias.\n" +
                                "\n" +
                                "Después de que Gwanwyn les informara de su ubicación, Mirana y Marci buscaron al tendero para que les ayudara a recuperar los lotos robados. Llegan a su tienda y Mirana le pregunta por la ubicación de los lotos robados. Él responde asegurando que no tiene nada que hacer con los bienes robados. Además de su respuesta también dice que conoce a una persona que podría ayudarles: un sabio solitario que vive en su torre situada en un valle al sur de los Picos Rotos. A continuación les ofrece la Gema del Tendero y dice que la necesitarán para \"verlo\".\n" +
                                "\n" +
                                "Mirana le ofrece un brazalete a cambio pero él lo rechaza diciendo que prefiere que le paguen en especie. Antes de que termine la escena levanta la gema para revelar el pasado de Mirana en sus facetas mientras confirma su trato.\n" +
                                "\n" +
                                "No se le vuelve a ver después de esto pero los episodios posteriores revelan que sus acciones de regalar la gema fueron indirectamente responsables de la manifestación temporal de Terrorblade en el plano material y uno de los factores clave para la caída de Nightsilver a manos de Terrorblade y los elfos Coedwen.";
                        break;
                }
                break;
            case "Las Tres Sombras":
                switch (tipo) {
                    case "texto1":
                        hist = "Las Tres Sombras son un grupo de seres etéreos, simbolizados por la planta de belladona. Poseen los atributos de la locura, el terror y la muerte. Los arboretos están dedicados a su nombre donde crecen las solanáceas gigantes.";
                        break;
                    case "texto2":
                        hist = "Atropos, también conocido como el Bane Elemental, inflige pavor y delirio a sus víctimas. Se le asocia con el terror.\n" +
                                "\n" +
                                "Belladonna inflige a sus víctimas pupilas dilatadas, permitiéndoles ver lo invisible. Se asocia con la locura o la muerte.\n" +
                                "\n" +
                                "Tyrian da a los héroes la fuerza necesaria para librarse de cualquier carga. Se le asocia con la locura o la muerte.";
                        break;
                    case "texto3":
                        hist = "Las Tres Sombras reciben su nombre y se basan en la atropa belladonna, la planta mortal de las solanáceas.";
                        break;
                }
                break;
            case "Los Siete Invisibles":
                switch (tipo) {
                    case "texto1":
                        hist = "Los Siete Invisibles son seres misteriosos conocidos únicamente por su contacto con Lanaya. Le otorgaron una armadura, hecha de hueso, que le permitía comunicarse con los muertos. Debido a sus interacciones con Lanaya los Siete Invisibles pueden ser simplemente un nombre diferente para los Ocultos.";
                        break;
                }
                break;
            case "El Doliente":
                switch (tipo) {
                    case "texto1":
                        hist = "El doliente es una deidad creadora en el lore de Dota 2. Es posible que las Montañas de los Lamentos (Wailing Mountains) reciban su nombre.";
                        break;
                    case "texto2":
                        hist = "Según un mito de la creación en el que cree la Orden de los Oyo, el Doliente es una conciencia divina que fue responsable de la creación del mundo. El mito explica que el Doliente fue una vez una entidad completa hasta que concibió un único pensamiento paradójico. El Doliente no pudo concebir este pensamiento y convertirse en un solo ser por lo que se desgarró y sus numerosos fragmentos formaron el universo multiplanar actual.\n" +
                                "\n" +
                                "Hoy en día, los distintos rangos de la antigua Orden del Oyo -desde sus Aestesistas hasta sus Maestros Cerveceros- se esfuerzan por encontrar la respuesta al único pensamiento paradójico que el Doliente no pudo responder. El único pensamiento que reunirá los planos material y espiritual de vuelta a lo que era en el principio.";
                        break;
                    case "texto3":
                        hist = "La tradición sobre el Doliente es muy similar a la que rodea a la entidad conocida como Arc Warden y su origen, la Conciencia Primordial. Aunque ambas historias tienen sus diferencias, las dos mencionan una mente primordial que era anterior a toda la existencia y que posteriormente fue destrozada para ser testigo de toda la creación.\n" +
                                "\n" +
                                "Esta especulación se apoya aún más cuando los libros de la rueda de las Montañas de los Lamentos, que suelen cantar la gran grieta en toda la existencia, entonan una nueva canción de conflicto que se da a entender que presagia la batalla de los Ancestros, que también surgieron de una conciencia antigua.";
                        break;
                }
                break;
            case "Trascendentales":
                switch (tipo) {
                    case "texto1":
                        hist = "Los Trascendentales son un elemento misterioso, al que sólo se refiere Mercurial, quien afirma que algunos comportamientos entre los Trascendentales se considerarían innobles. Esto implica que los Trascendentales son un grupo de seres sobrenaturales, posiblemente los mismos que los Ascendentes.";
                        break;
                }
                break;
            case "Tyrian":
                switch (tipo) {
                    case "texto1":
                        hist = "Tyrian es uno de las Tres Sombras. Poco se sabe de él, salvo que se manifiesta como un espíritu etéreo y parece ayudar a los mortales a \"quitarse de encima las cargas\".";
                        break;
                }
                break;
            case "Uldorak":
                switch (tipo) {
                    case "texto1":
                        hist = "Uldorak es el Eldwurm de la Tierra en la serie animada Dota: Dragon's Blood.\n" +
                                "\n" +
                                "En DOTA Dragon's blood. El nido de Uldorak fue descubierto por Davion y lograron dejarlo dormir. Al día siguiente es asesinado no por Davion, sino por Fruhling. que está poseído por Terrorblade. Terrorblade entonces roba su alma y más tarde utiliza su cuerpo para derrotar y matar a Slyrak.\n" +
                                "\n" +
                                "Según el escritor Ashley Miller, Uldorak destruyó el reino de Candoness fuera de pantalla. También dice que sólo era un Dragón del Tiempo de nombre y que no tenía nada que ver con el tiempo en sí porque tenía un publicista que difundía su poder, además de llevar un gran reloj alrededor del cuello para complementar su nuevo título y mostrar a los demás lo antiguo que era.";
                        break;
                }
                break;
            case "Vahdrak":
                switch (tipo) {
                    case "texto1":
                        hist = "Vahdrak es el Eldwurm del Caos, cuya alma sostiene el universo como uno de los ocho pilares de la creación. Entre los cuatro Eldwurms que representan las cuatro fuerzas fundamentales, es el equivalente dracónico del Caballero del Caos, que comparte el mismo esquema de colores y conjunto de poderes, pero en el fondo es la fuerza nuclear débil.";
                        break;
                    case "texto2":
                        hist = "Una característica exclusiva de Vahdrak y sus compañeros dragones del caos son sus alas, que tienen tres ojos rojos. Normalmente están cubiertos y plegados bajo sus alas, pero estos ojos pueden abrirse cuando el dragón intenta intimidar a los atacantes o cuando utiliza algunos de sus poderes.\n" +
                                "\n" +
                                "Vahdrak y los dragones del caos poseen habilidades únicas que los diferencian de otras especies. La mayoría de los dragones hacen uso de los elementos o fuerzas de la naturaleza, pero estos dragones tienen poderes que los considerarían como criaturas eldritch. Su capacidad para salirse de la realidad, redirigir los ataques a su alrededor y teletransportarse a distancias cortas (mediante el desplazamiento entre planos) hace que sea difícil asestarles un golpe, por no hablar de tocar a estos dragones. Kaden buscó a estos dragones por sus habilidades, imbuyendo su armadura con los poderes de un dragón del caos.\n" +
                                "\n" +
                                "Además de la capacidad de desplazamiento de planos, Vahdrak parece tener la capacidad de oscurecer su entorno antes de liberar una onda expansiva de energía roja. Este ataque es lo suficientemente poderoso como para desmaterializar a otros eldwurms, posiblemente relacionado con su poder sobre la descomposición del átomo a través de la interacción débil.";
                        break;
                    case "texto3":
                        hist = "Como todos los Eldwurms, Vahdrak es inmortal en el sentido de que puede reencarnarse siempre que haya un cuerpo anfitrión adecuado para que su alma se instale. Al morir encuentra al siguiente dragón más antiguo de su tipo (que son los dragones del caos en su caso) antes de llenar su cuerpo sin alma con su propia alma. Los recipientes que posee no son inmortales en sí mismos por lo que todos mueren de forma natural como cualquier criatura viva pero se dice que tienen una larga vida y se hacen más fuertes tanto en fuerza física como en sus respectivos poderes elementales a medida que maduran y envejecen en lugar de marchitarse hasta convertirse en dragones más débiles.";
                        break;
                }
                break;
            case "Verodicia":
                switch (tipo) {
                    case "texto1":
                        hist = "Verodicia es una dios en el mundo de Dota 2.\n" +
                                "\n" +
                                "Verodicia fue la encargada de sembrar las semillas de todo el verdor del mundo a la vez que engatusaba a las aguas y al sol para que las mantuvieran. Sin embargo estuvo a punto de morir antes de que pudiera brotar alguna. No contenta con dejarla desprotegida se tragó una última semilla que se le había escapado al sembrarla y murió poco después. Después de que su cuerpo se descompusiera la semilla dio a luz a Nature´s Prophet, transfiriéndole toda su sabiduría y poder.\n" +
                                "\n" +
                                "Verodicia también dejó un anillo encantado con su bendición.";
                        break;
                    case "texto2":
                        hist = "Hace mucho tiempo, Verodicia dejó una gema de zafiro en los páramos de una tierra devastada por la guerra para que ayude a la tierra a volver a la vida. Nature's Prophet ha encontrado esta gema y ahora la lleva entre dos alas de mariposa.";
                        break;
                }
                break;
            case "Vulcano":
                switch (tipo) {
                    case "texto1":
                        hist = "Vulcano es una deidad en el lore de Dota 2. Es el dios de la forja del panteón formado por Zeus y Mars, habiendo forjado la legendaria lanza de este último que aún brilla con el calor de sus fuegos.";
                        break;
                }
                break;
            case "WorldWyrm":
                switch (tipo) {
                    case "texto1":
                        hist = "El Worldwyrm es la suma de toda la existencia en Dota: Dragon's Blood.";
                        break;
                }
                break;
            case "Zal":
                switch (tipo) {
                    case "texto1":
                        hist = "El Dios Emperador Zal era un personaje exclusivo de la serie Dota: Dragon's Blood. Es el padre de Mirana.";
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

    private void parrafos1() {

        texto1.setText(Historia(titpag, "texto1"));


        texto2.setVisibility(View.GONE);
        texto3.setVisibility(View.GONE);
        texto4.setVisibility(View.GONE);
        texto5.setVisibility(View.GONE);
        

        layout1.setVisibility(View.GONE);
        layout2.setVisibility(View.GONE);
        layout3.setVisibility(View.GONE);
        layout4.setVisibility(View.GONE);
        

    }

    private void parrafos2(String tit1) {

        texto1.setText(Historia(titpag, "texto1"));
        texto2.setText(Historia(titpag, "texto2"));

        titulo1.setText(tit1);


        texto3.setVisibility(View.GONE);
        texto4.setVisibility(View.GONE);
        texto5.setVisibility(View.GONE);
        

        layout2.setVisibility(View.GONE);
        layout3.setVisibility(View.GONE);
        layout4.setVisibility(View.GONE);
        

    }

    private void parrafos3(String tit1, String tit2) {

        texto1.setText(Historia(titpag, "texto1"));
        texto2.setText(Historia(titpag, "texto2"));
        texto3.setText(Historia(titpag, "texto3"));

        titulo1.setText(tit1);
        titulo2.setText(tit2);

        texto4.setVisibility(View.GONE);
        texto5.setVisibility(View.GONE);
        

        layout3.setVisibility(View.GONE);
        layout4.setVisibility(View.GONE);
        

    }

    private void parrafos4(String tit1, String tit2, String tit3) {

        texto1.setText(Historia(titpag, "texto1"));
        texto2.setText(Historia(titpag, "texto2"));
        texto3.setText(Historia(titpag, "texto3"));
        texto4.setText(Historia(titpag, "texto4"));

        titulo1.setText(tit1);
        titulo2.setText(tit2);
        titulo3.setText(tit3);

        texto5.setVisibility(View.GONE);
        

        layout4.setVisibility(View.GONE);
        

    }

    private void parrafos5(String tit1, String tit2, String tit3, String tit4) {

        texto1.setText(Historia(titpag, "texto1"));
        texto2.setText(Historia(titpag, "texto2"));
        texto3.setText(Historia(titpag, "texto3"));
        texto4.setText(Historia(titpag, "texto4"));
        texto5.setText(Historia(titpag, "texto5"));

        titulo1.setText(tit1);
        titulo2.setText(tit2);
        titulo3.setText(tit3);
        titulo4.setText(tit4);

        

        

    }

    private void rel(String rel) {
        switch (rel) {
            case "heroe":
                layout_detdioses_rel_mundo.setVisibility(View.GONE);
                layout_detdioses_rel_razas.setVisibility(View.GONE);
                layout_detdioses_rel_dioses.setVisibility(View.GONE);
                break;
            case "mundo":
                layout_detdioses_rel_heroes.setVisibility(View.GONE);
                layout_detdioses_rel_razas.setVisibility(View.GONE);
                layout_detdioses_rel_dioses.setVisibility(View.GONE);
                break;
            case "raza":
                layout_detdioses_rel_heroes.setVisibility(View.GONE);
                layout_detdioses_rel_mundo.setVisibility(View.GONE);
                layout_detdioses_rel_dioses.setVisibility(View.GONE);
                break;
            case "heroe_mundo":
                layout_detdioses_rel_razas.setVisibility(View.GONE);
                layout_detdioses_rel_dioses.setVisibility(View.GONE);
                break;
            case "heroe_raza":
                layout_detdioses_rel_mundo.setVisibility(View.GONE);
                layout_detdioses_rel_dioses.setVisibility(View.GONE);
                break;
            case "mundo_raza":
                layout_detdioses_rel_heroes.setVisibility(View.GONE);
                layout_detdioses_rel_dioses.setVisibility(View.GONE);
                break;
            case "vacio":
                layout_detdioses_rel_heroes.setVisibility(View.GONE);
                layout_detdioses_rel_mundo.setVisibility(View.GONE);
                layout_detdioses_rel_razas.setVisibility(View.GONE);
                layout_detdioses_rel_dioses.setVisibility(View.GONE);
                layout_rel_dioses.setVisibility(View.GONE);
                break;
            case "heroe_mundo_raza":
                layout_detdioses_rel_dioses.setVisibility(View.GONE);
                break;
            case "heroe_raza_dioses":
                layout_detdioses_rel_mundo.setVisibility(View.GONE);
                break;
            case "heroe_mundo_raza_dioses":
                break;
            case "heroe_dioses":
                layout_detdioses_rel_mundo.setVisibility(View.GONE);
                layout_detdioses_rel_razas.setVisibility(View.GONE);
                break;
            case "heroe_mundo_dioses":
                layout_detdioses_rel_razas.setVisibility(View.GONE);
                break;


        }

    }
    
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
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
    public void itemClick_Dioses(lista_relacionados item) {
        try {
            Intent intent = new Intent(this, detalle_dioses.class);
            intent.putExtra("itemDetail", item);
            this.startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}