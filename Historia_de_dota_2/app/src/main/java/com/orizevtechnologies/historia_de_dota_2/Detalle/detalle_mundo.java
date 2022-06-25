package com.orizevtechnologies.historia_de_dota_2.Detalle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.orizevtechnologies.historia_de_dota_2.listas.RecyclerAdapter_rel_heroes;
import com.orizevtechnologies.historia_de_dota_2.listas.RecyclerAdapter_rel_mundo;
import com.orizevtechnologies.historia_de_dota_2.listas.RecyclerAdapter_rel_raza;
import com.orizevtechnologies.historia_de_dota_2.listas.lista_relacionados;
import com.orizevtechnologies.historia_de_dota_2.R;

import java.util.ArrayList;
import java.util.List;

public class detalle_mundo extends AppCompatActivity implements RecyclerAdapter_rel_raza.RecyclerItemClick,
        RecyclerAdapter_rel_heroes.RecyclerItemClick_heroes, RecyclerAdapter_rel_mundo.RecyclerItemClick_mundo{

    private ImageView img_mundo;
    private TextView tit_es;
    private TextView tit_en;
    private String titpag;

    private TextView texto1;
    private TextView texto2;
    private TextView texto3;
    private TextView texto4;
    private TextView texto5;
    private TextView texto6;

    private TextView titulo1;
    private TextView titulo2;
    private TextView titulo3;
    private TextView titulo4;
    private TextView titulo5;

    private LinearLayout layout1;
    private LinearLayout layout2;
    private LinearLayout layout3;
    private LinearLayout layout4;
    private LinearLayout layout5;

    private LinearLayout layout_rel_razas;
    private LinearLayout layout_detrazas_rel_razas;
    private LinearLayout layout_detrazas_rel_mundo;
    private LinearLayout layout_detrazas_rel_heroes;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_mundo);

        try {
            initViews();
            initValues();
            ActionBar();
            rel_razas();
            anuncio_banenr();
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

        mAdView = findViewById(R.id.adView_det_mundo);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    private void initViews() {
        img_mundo = findViewById(R.id.fondo_mundo_detalle);
        tit_es = findViewById(R.id.titulo_espanol_detalle);
        tit_en = findViewById(R.id.titulo_ingles_detalle);

        texto1 = findViewById(R.id.det_mundo_texto1);
        texto2 = findViewById(R.id.det_mundo_texto2);
        texto3 = findViewById(R.id.det_mundo_texto3);
        texto4 = findViewById(R.id.det_mundo_texto4);
        texto5 = findViewById(R.id.det_mundo_texto5);
        texto6 = findViewById(R.id.det_mundo_texto6);

        titulo1 = findViewById(R.id.det_mundo_titulo1);
        titulo2 = findViewById(R.id.det_mundo_titulo2);
        titulo3 = findViewById(R.id.det_mundo_titulo3);
        titulo4 = findViewById(R.id.det_mundo_titulo4);
        titulo5 = findViewById(R.id.det_mundo_titulo5);

        layout1 = findViewById(R.id.det_mundo_layout1);
        layout2 = findViewById(R.id.det_mundo_layout2);
        layout3 = findViewById(R.id.det_mundo_layout3);
        layout4 = findViewById(R.id.det_mundo_layout4);
        layout5 = findViewById(R.id.det_mundo_layout5);

        layout_rel_razas = findViewById(R.id.layout_rel_mundo);
        layout_detrazas_rel_razas = findViewById(R.id.layout_detmundo_rel_razas);
        layout_detrazas_rel_mundo = findViewById(R.id.layout_detmundo_rel_mundo);
        layout_detrazas_rel_heroes = findViewById(R.id.layout_detmundo_rel_heroes);

    }

    private void rel_razas() {

        //Relaciones Razas
        RecyclerView rvLista_razas_rel_razas = findViewById(R.id.recycler_view_mundo_rel_razas);
        LinearLayoutManager manager_razas = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rvLista_razas_rel_razas.setLayoutManager(manager_razas);
        List<lista_relacionados> items = getItems_razas();
        RecyclerAdapter_rel_raza adapter_razas = new RecyclerAdapter_rel_raza(items, this);
        rvLista_razas_rel_razas.setAdapter(adapter_razas);

        //Relaciones Heroes
        RecyclerView rvLista_razas_rel_heroes = findViewById(R.id.recycler_view_mundo_rel_heroe);
        LinearLayoutManager manager_heroes = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rvLista_razas_rel_heroes.setLayoutManager(manager_heroes);
        List<lista_relacionados> items_heroes = getItems_heroes();
        RecyclerAdapter_rel_heroes adapter_heroes = new RecyclerAdapter_rel_heroes(items_heroes, this);
        rvLista_razas_rel_heroes.setAdapter(adapter_heroes);

        //Relaciones Mundo
        RecyclerView rvLista_razas_rel_mundo = findViewById(R.id.recycler_view_mundo_rel_mundo);
        LinearLayoutManager manager_mundo = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rvLista_razas_rel_mundo.setLayoutManager(manager_mundo);
        List<lista_relacionados> items_mundo = getItems_mundo();
        RecyclerAdapter_rel_mundo adapter_mundo = new RecyclerAdapter_rel_mundo(items_mundo, this);
        rvLista_razas_rel_mundo.setAdapter(adapter_mundo);

    }

    private List<lista_relacionados> getItems_razas() {

        List<lista_relacionados> lista__razas__es= new ArrayList<>();


        switch (titpag) {

            case "Ashkavor":

            case "Aziyog":

            case "Catedral de Rumusque":

            case "Claszureme":

            case "Desierto de la Anarquía":

            case "Emauracus":

            case "Imperio de Huesos":

            case "Campos de la Matanza sin Fin":

            case "Fuente del Averno":

            case "Fortaleza de las Llamas":

            case "Corazón de la Naturaleza":

            case "Fisura de Hielo":

            case "La Luna Loca":

            case "Monte Pyrotheos":

            case "Bosque de la Noche Plateada":

            case "Reino de Nothl":

            case "Ruinas de Grietas Sombrías":

            case "Basurero Centelleante":

            case "Palacio de Piedra":

            case "Mundo Exterior":

            case "Isla Temblorosa":

            case "Siete Planos":

            case "Estado Tyler":

            case "Underscape":

            case "Rosa Llorona":
                break;

            case "Arrecife Oscuro":
                lista__razas__es.add(new lista_relacionados("Nagas", "", R.drawable.naga));
                lista__razas__es.add(new lista_relacionados("Slithereen", "", R.drawable.slardar));
                lista__razas__es.add(new lista_relacionados("Meranths", "", R.drawable.meranths));
                break;

            case "Druud":
                lista__razas__es.add(new lista_relacionados("Centauros", "Centaurs", R.drawable.centauro));
                lista__razas__es.add(new lista_relacionados("Oglodis", "", R.drawable.oglodi));
                break;

            case "Foulfell":

            case "Siete Infiernos":
                lista__razas__es.add(new lista_relacionados("Demonios", "Demons", R.drawable.demonios));
                break;

            case "Imperio Helio":
                lista__razas__es.add(new lista_relacionados("Humanos", "Humans", R.drawable.humanos));
                lista__razas__es.add(new lista_relacionados("Keens", "", R.drawable.keen));
                lista__razas__es.add(new lista_relacionados("Oglodis", "", R.drawable.oglodi));
                lista__razas__es.add(new lista_relacionados("Ogros", "Ogres", R.drawable.ogro));
                lista__razas__es.add(new lista_relacionados("Sátiros", "Satyrs", R.drawable.satiros));
                lista__razas__es.add(new lista_relacionados("Trolls", "", R.drawable.trolls));
                break;

            case "Templo Escondido":
                lista__razas__es.add(new lista_relacionados("Dragones Faéricos", "Faerie Dragons", R.drawable.dragones_faericos));
                break;

            case "Isla de las Máscaras":
                lista__razas__es.add(new lista_relacionados("Enmascarados", "Masked Ones", R.drawable.mascara));
                lista__razas__es.add(new lista_relacionados("Dragones", "Dragons", R.drawable.dragones));
                lista__razas__es.add(new lista_relacionados("Demonios", "Demons", R.drawable.demonios));
                break;

            case "Knollen":
                lista__razas__es.add(new lista_relacionados("Keens", "", R.drawable.keen));
                lista__razas__es.add(new lista_relacionados("Trolls", "", R.drawable.trolls));
                break;

            case "Confines Infernales":
                lista__razas__es.add(new lista_relacionados("Netherdrakes", "", R.drawable.netherdrakes));
                break;

            case "Revtel":
                lista__razas__es.add(new lista_relacionados("Hadas", "Faerys", R.drawable.fae));
                lista__razas__es.add(new lista_relacionados("Dragones Pyrexae", "Pyrexae Dragons", R.drawable.pyroxae_dragons));
                break;

            case "El Horno":
                lista__razas__es.add(new lista_relacionados("Trolls", "", R.drawable.trolls));
                break;

            case "Archivos de Ultimyr":
                lista__razas__es.add(new lista_relacionados("Dragones", "Dragons", R.drawable.dragones));
                lista__razas__es.add(new lista_relacionados("Escarabajos Zealots", "Zealots Scarabs", R.drawable.nyx));
                break;

            case "Meseta Violeta":
                lista__razas__es.add(new lista_relacionados("Keens", "", R.drawable.keen));
                break;

        }

        return lista__razas__es;
    }


    private List<lista_relacionados> getItems_heroes() {
        List<lista_relacionados> itemLists= new ArrayList<>();

        switch (titpag) {

            case "Ashkavor":
                itemLists.add(new lista_relacionados("Astral","Grimstroke",R.drawable.perfil_grimstroke));
                break;

            case "Aziyog":
                itemLists.add(new lista_relacionados("Vrogros","Underlord",R.drawable.perfil_underlord));
                break;

            case "Catedral de Rumusque":
                itemLists.add(new lista_relacionados("Rotund'jere","Necrophos",R.drawable.perfil_necrophos));
                itemLists.add(new lista_relacionados("Pudge","Butcher",R.drawable.perfil_pudge));
                break;

            case "Claszureme":
                itemLists.add(new lista_relacionados("Inai","Void Spirit",R.drawable.perfil_void));
                itemLists.add(new lista_relacionados("Puck","Faerie Dragon",R.drawable.perfil_puck));
                break;

            case "Arrecife Oscuro":
                itemLists.add(new lista_relacionados("Slark","Nightcrawler",R.drawable.perfil_slark));
                break;

            case "Desierto de la Anarquía":
                itemLists.add(new lista_relacionados("Lina","Slayer",R.drawable.perfil_lina));
                itemLists.add(new lista_relacionados("Mireska Sunbreeze","Dark Willow",R.drawable.perfil_willow));
                break;

            case "Druud":
                itemLists.add(new lista_relacionados("Bradwarden","Centaur Warruner",R.drawable.perfil_centaur));
                itemLists.add(new lista_relacionados("Disruptor","Stormcrafter",R.drawable.perfil_disruptor));
                break;

            case "Emauracus":
                itemLists.add(new lista_relacionados("Purist Thunderwrath","Omniknight",R.drawable.perfil_omniknight));
                break;

            case "Imperio de Huesos":
                itemLists.add(new lista_relacionados("Ostarion","Wraith King",R.drawable.perfil_wk));
                break;

            case "Campos de la Matanza sin Fin":
                itemLists.add(new lista_relacionados("Pudge","Butcher",R.drawable.perfil_pudge));
                break;

            case "Fuente del Averno":
                itemLists.add(new lista_relacionados("Abbadon", "Lord of Avernus", R.drawable.perfil_abbadon));
                break;

            case "Fortaleza de las Llamas":
                itemLists.add(new lista_relacionados("Xin","Ember Spirit",R.drawable.perfil_ember));
                break;

            case "Foulfell":
                itemLists.add(new lista_relacionados("Terrorblade","Demon Marauder",R.drawable.perfil_tb));
                break;

            case "Corazón de la Naturaleza":
                itemLists.add(new lista_relacionados("Leshrac","Tormented Soul",R.drawable.perfil_leshrac));
                itemLists.add(new lista_relacionados("Enigma","Consumer of worlds",R.drawable.perfil_enigma));
                break;

            case "Imperio Helio":
                itemLists.add(new lista_relacionados("Marci","Marci",R.drawable.perfil_marci));
                itemLists.add(new lista_relacionados("Davion","Dragon Knight",R.drawable.perfil_dragon));
                itemLists.add(new lista_relacionados("Lina","Slayer",R.drawable.perfil_lina));
                itemLists.add(new lista_relacionados("Mirana","Princess of the Moon",R.drawable.perfil_mirana));
                break;

            case "Templo Escondido":
                itemLists.add(new lista_relacionados("Lanaya","Templar Assassin",R.drawable.perfil_templar));
                itemLists.add(new lista_relacionados("Inai","Void Spirit",R.drawable.perfil_void));
                itemLists.add(new lista_relacionados("Mercurial","Spectre",R.drawable.perfil_spectre));
                break;

            case "Fisura de Hielo":
                itemLists.add(new lista_relacionados("Rylai","Crystal Maiden",R.drawable.perfil_crystal));
                itemLists.add(new lista_relacionados("Ymir","Tusk",R.drawable.perfil_tusk));
                break;

            case "Isla de las Máscaras":
                itemLists.add(new lista_relacionados("Yurnero","Juggernatur",R.drawable.perfil_jugg));
                itemLists.add(new lista_relacionados("Beatrix Snapfire","Snapfire",R.drawable.perfil_snapfire));
                break;

            case "Knollen":
                itemLists.add(new lista_relacionados("Kardel Sharpeye","Sniper",R.drawable.perfil_sniper));
                break;

            case "La Luna Loca":
                itemLists.add(new lista_relacionados("Zet","Arc Warden", R.drawable.perfil_arc));
                break;

            case "Monte Pyrotheos":
                itemLists.add(new lista_relacionados("Black Arachnia","Broodmother", R.drawable.perfil_broodmother));
                break;

            case "Confines Infernales":
                itemLists.add(new lista_relacionados("Viper","Netherdrake",R.drawable.perfil_viper));
                itemLists.add(new lista_relacionados("Pugna","Oblivion",R.drawable.perfil_pugna));
                break;

            case "Bosque de la Noche Plateada":
                itemLists.add(new lista_relacionados("Luna","Moon Rider",R.drawable.perfil_luna));
                itemLists.add(new lista_relacionados("Marci","Marci",R.drawable.perfil_marci));
                itemLists.add(new lista_relacionados("Mirana","Princess of the Moon",R.drawable.perfil_mirana));
                break;

            case "Reino de Nothl":
                itemLists.add(new lista_relacionados("Dazzle","Shadow Priest",R.drawable.perfil_dazzle));
                itemLists.add(new lista_relacionados("Huskar","Sacred Warrior",R.drawable.perfil_huskar));
                itemLists.add(new lista_relacionados("Nessaj","Chaos Knight",R.drawable.perfil_chaos));
                itemLists.add(new lista_relacionados("Ezalor","Keeper of the Light",R.drawable.perfil_keeper));
                itemLists.add(new lista_relacionados("Mars","First Son of Heaven",R.drawable.perfil_mars));
                itemLists.add(new lista_relacionados("Visage","Bound Form of Necro'lic",R.drawable.perfil_visage));
                itemLists.add(new lista_relacionados("Inai","Void Spirit",R.drawable.perfil_void));
                break;

            case "Revtel":
                itemLists.add(new lista_relacionados("Mireska Sunbreeze","Dark Willow",R.drawable.perfil_willow));
                itemLists.add(new lista_relacionados("Gondar","Bounty Hunter", R.drawable.perfil_bounty));
                itemLists.add(new lista_relacionados("Mortred","Phantom Assassin",R.drawable.perfil_pa));
                break;

            case "Ruinas de Grietas Sombrías":
                itemLists.add(new lista_relacionados("Meepo","Geomancer",R.drawable.perfil_meepo));
                break;

            case "Basurero Centelleante":
                itemLists.add(new lista_relacionados("Cryxalis","Sand King",R.drawable.perfil_sk));
                break;

            case "Siete Infiernos":
                itemLists.add(new lista_relacionados("Nevermore","Shadow Fiend",R.drawable.perfil_sf));
                itemLists.add(new lista_relacionados("shadow Demon","Demonio Sombrío",R.drawable.perfil_shadow));
                itemLists.add(new lista_relacionados("Lucifer","Doom",R.drawable.perfil_doom));
                itemLists.add(new lista_relacionados("Terrorblade","Demon Marauder",R.drawable.perfil_tb));
                itemLists.add(new lista_relacionados("Tresdin","Legion Commander",R.drawable.perfil_legion_commander));
                itemLists.add(new lista_relacionados("Clinkz","Bone Fletcher",R.drawable.perfil_clinkz));
                break;

            case "Palacio de Piedra":
                itemLists.add(new lista_relacionados("Tresdin","Legion Commander",R.drawable.perfil_legion_commander));
                itemLists.add(new lista_relacionados("Vrogros","Underlord",R.drawable.perfil_underlord));
                break;

            case "El Horno":
                itemLists.add(new lista_relacionados("Clinkz","Bone Fletcher",R.drawable.perfil_clinkz));
                itemLists.add(new lista_relacionados("Jah'rakal","Troll Warlord",R.drawable.perfil_troll));
                break;

            case "Mundo Exterior":
                itemLists.add(new lista_relacionados("Harbinger","Outworld Destroyer",R.drawable.perfil_od));
                break;

            case "Siete Planos":
                itemLists.add(new lista_relacionados("Elder Titan","Worldsmith",R.drawable.perfil_titan));
                itemLists.add(new lista_relacionados("Mercurial","Spectre",R.drawable.perfil_spectre));
                itemLists.add(new lista_relacionados("Barathrum","Spirit Breaker",R.drawable.perfil_bara));
                break;

            case "Isla Temblorosa":
                itemLists.add(new lista_relacionados("Kunkka","Admiral",R.drawable.perfil_kunkka));
                itemLists.add(new lista_relacionados("Leviathan","Tidehunter",R.drawable.perfil_tide));
                itemLists.add(new lista_relacionados("Mireska Sunbreeze","Dark Willow",R.drawable.perfil_willow));
                break;

            case "Estado Tyler":
                itemLists.add(new lista_relacionados("Magina","Anti-Mage", R.drawable.perfil_antimage));
                itemLists.add(new lista_relacionados("Nortrom","Silencer",R.drawable.perfil_silencer));
                itemLists.add(new lista_relacionados("Mireska Sunbreeze","Dark Willow",R.drawable.perfil_willow));
                break;

            case "Archivos de Ultimyr":
                itemLists.add(new lista_relacionados("Demnok Lannik","Warlock",R.drawable.perfil_warlock));
                itemLists.add(new lista_relacionados("Nyx Assassin","Asesino de Nyx",R.drawable.perfil_nyx));
                itemLists.add(new lista_relacionados("Kaldr","Ancient Aparition",R.drawable.perfil_ancient));
                itemLists.add(new lista_relacionados("Lyralei","Windranger",R.drawable.perfil_windranger));
                itemLists.add(new lista_relacionados("Rubick","Grand Magus",R.drawable.perfil_rubick));
                break;

            case "Underscape":
                itemLists.add(new lista_relacionados("Razor","Lightning Revenant",R.drawable.perfil_razor));
                itemLists.add(new lista_relacionados("Visage","Bound Form of Necro'lic",R.drawable.perfil_visage));
                itemLists.add(new lista_relacionados("Sun Wukong","Monkey King",R.drawable.perfil_monkey));
                break;

            case "Meseta Violeta":
                itemLists.add(new lista_relacionados("Boush","Tinker",R.drawable.perfil_tinker));
                itemLists.add(new lista_relacionados("Lanaya","Templar Assassin",R.drawable.perfil_templar));
                break;

            case "Rosa Llorona":
                itemLists.add(new lista_relacionados("Mireska Sunbreeze","Dark Willow",R.drawable.perfil_willow));
                itemLists.add(new lista_relacionados("Lion","Demon Witch",R.drawable.perfil_lion));
                itemLists.add(new lista_relacionados("Akasha","Queen of Pain",R.drawable.perfil_qop));
                itemLists.add(new lista_relacionados("Magina","Anti-Mage", R.drawable.perfil_antimage));
                itemLists.add(new lista_relacionados("Nortrom","Silencer",R.drawable.perfil_silencer));
                break;

        }

        return itemLists;
    }


    private List<lista_relacionados> getItems_mundo() {

        List<lista_relacionados> lista_mundo_es= new ArrayList<>();


        switch (titpag) {

            case "Ashkavor":

            case "Aziyog":

            case "Claszureme":

            case "Arrecife Oscuro":

            case "Druud":

            case "Emauracus":

            case "Imperio de Huesos":

            case "Fuente del Averno":

            case "Fortaleza de las Llamas":

            case "Imperio Helio":

            case "Templo Escondido":

            case "Fisura de Hielo":

            case "Isla de las Máscaras":

            case "Knollen":

            case "La Luna Loca":

            case "Monte Pyrotheos":

            case "Confines Infernales":

            case "Bosque de la Noche Plateada":

            case "Ruinas de Grietas Sombrías":

            case "Palacio de Piedra":

            case "Mundo Exterior":

            case "Siete Planos":

            case "Isla Temblorosa":

            case "Archivos de Ultimyr":

            case "Underscape":

            case "Meseta Violeta":
                break;

            case "Catedral de Rumusque":
                lista_mundo_es.add(new lista_relacionados("Campos de la Matanza sin Fin", "Fields of Endless Carnage", R.drawable.campos_carniceria_sin_fin));
                break;

            case "Desierto de la Anarquía":
                lista_mundo_es.add(new lista_relacionados("Basurero Centelleante", "Scintillant Waste", R.drawable.basurero_centelleante));
                break;

            case "Campos de la Matanza sin Fin":
                lista_mundo_es.add(new lista_relacionados("Catedral de Rumusque", "Cathedral of Rumusque", R.drawable.catedral));
                break;

            case "Foulfell":
                lista_mundo_es.add(new lista_relacionados("Siete Infiernos", "Seven Hells", R.drawable.seven_hells));
                lista_mundo_es.add(new lista_relacionados("Siete Planos", "Seven Planes", R.drawable.seven_planes));
                break;

            case "Corazón de la Naturaleza":

            case "Reino de Nothl":
                lista_mundo_es.add(new lista_relacionados("Siete Planos", "Seven Planes", R.drawable.seven_planes));
                break;

            case "Revtel":
                lista_mundo_es.add(new lista_relacionados("Palacio de Piedra", "StoneHall", R.drawable.stonehall));
                break;

            case "Basurero Centelleante":
                lista_mundo_es.add(new lista_relacionados("Desierto de la Anarquía", "Desert of Misrule", R.drawable.desierto_misrule));
                break;

            case "Siete Infiernos":
                lista_mundo_es.add(new lista_relacionados("Aziyog", "Aziyog", R.drawable.aziyog));
                lista_mundo_es.add(new lista_relacionados("Foulfell", "Foulfell", R.drawable.foulfell));
                break;

            case "El Horno":
                lista_mundo_es.add(new lista_relacionados("Siete Infiernos", "Seven Hells", R.drawable.seven_hells));
                break;

            case "Estado Tyler":
                lista_mundo_es.add(new lista_relacionados("Rosa Llorona", "Weeping Rose", R.drawable.weeping_rose));
                break;

            case "Rosa Llorona":
                lista_mundo_es.add(new lista_relacionados("Estado Tyler", "Tyler Estate", R.drawable.tyler_state));
                break;

        }

        return lista_mundo_es;
    }


    private void initValues(){

        String tit_igual;

        lista_relacionados itemDetail = (lista_relacionados) getIntent().getExtras().getSerializable("itemDetail");
        img_mundo.setImageResource(itemDetail.getImg_principal());
        tit_es.setText(itemDetail.getNombre_principal());
        tit_en.setText(itemDetail.getNombre_secundario());
        titpag = (String) tit_es.getText();
        tit_igual = (String) tit_en.getText();

        if (titpag.equals(tit_igual)) {
            tit_en.setVisibility(View.GONE);
        }

        texto();

    }


    private void texto() {

        switch (titpag) {

            case "Ashkavor":
                parrafos3("cultura", "La Marea de Tinta");
                rel("heroe");
                break;

            case "Aziyog":

            case "Emauracus":

            case "Imperio de Huesos":

            case "Fuente del Averno":
                parrafos1();
                rel("heroe");
                break;

            case "Catedral de Rumusque":
                parrafos3("Clero", "Relaciones");
                rel("heroe_mundo");
                break;

            case "Claszureme":
                parrafos2("Habitantes");
                rel("heroe");
                break;

            case "Arrecife Oscuro":
                parrafos5();
                rel("heroe_raza");
                break;

            case "Desierto de la Anarquía":
                parrafos3("Habitantes", "Visitantes");
                rel("heroe_mundo");
                break;

            case "Druud":
                parrafos1();
                rel("heroe_raza");
                break;

            case "Campos de la Matanza sin Fin":
                parrafos2("La Purga");
                rel("heroe_mundo");
                break;

            case "Fortaleza de las Llamas":
                parrafos2("Cenizas");
                rel("heroe");
                break;

            case "Foulfell":
                parrafos3("Fragmentos", "Terrorblade");
                rel("heroe_mundo_raza");
                break;

            case "Corazón de la Naturaleza":
                parrafos3("Impurezas", "Habitantes");
                rel("heroe_mundo");
                break;

            case "Imperio Helio":
                parrafos2("Especulación");
                rel("heroe_raza");
                break;

            case "Templo Escondido":
                parrafos6("Localización", "Inai (Void Spirit)", "Reunión con Lanaya", "Asesinos", "Rumores");
                rel("heroe_raza");
                break;

            case "Fisura de Hielo":
                parrafos4("Habitantes", "Cultura", "Especies");
                rel("heroe");
                break;

            case "Isla de las Máscaras":
                parrafos4("Localización", "Habitantes", "Especies");
                rel("heroe_raza");
                break;

            case "Knollen":
                parrafos2("Cultura");
                rel("heroe_raza");
                break;

            case "La Luna Loca":
                parrafos3("Creación", "Destrucción");
                rel("heroe");
                break;

            case "Monte Pyrotheos":
                parrafos3("El culto de la Araña", "El Zigurat Magnético");
                rel("heroe");
                break;

            case "Confines Infernales":
                parrafos3("Magia", "Entidades Notables");
                rel("heroe_raza");
                break;

            case "Bosque de la Noche Plateada":
                parrafos4("Historia", "Especies", "Visitantes");
                rel("heroe");
                break;

            case "Reino de Nothl":
                parrafos6("Magia", "Aplicaciones", "Usos", "Entidades", "Especies");
                rel("heroe_mundo");
                break;

            case "Revtel":
                parrafos3("Cultura", "Relaciones");
                rel("heroe_mundo_raza");
                break;

            case "Ruinas de Grietas Sombrías":
                parrafos3("Carroñeros", "Especies");
                rel("heroe");
                break;

            case "Basurero Centelleante":
                parrafos2("El Basurero Oriental");
                rel("heroe_mundo");
                break;

            case "Siete Infiernos":
                parrafos2("Lista");
                rel("heroe_mundo_raza");
                break;

            case "Palacio de Piedra":
                parrafos2("Invasión");
                rel("heroe");
                break;

            case "El Horno":
                parrafos3("Habitantes", "Maraxiform");
                rel("heroe_mundo_raza");
                break;

            case "Mundo Exterior":
                parrafos2("Cristales");
                rel("heroe");
                break;

            case "Siete Planos":
                parrafos2("Lista");
                rel("heroe");
                break;

            case "Isla Temblorosa":
                parrafos3("Primera Batalla", "Segunda Batalla");
                rel("heroe");
                break;

            case "Estado Tyler":

            case "Rosa Llorona":
                parrafos1();
                rel("heroe_mundo");
                break;

            case "Archivos de Ultimyr":
                parrafos3("Entidades Notables", "Visitantes");
                rel("heroe_raza");
                break;

            case "Underscape":
                parrafos4("El Laberinto Estrecho", "Guardianes", "Visitantes");
                rel("heroe");
                break;

            case "Meseta Violeta":
                parrafos4("El Laboratorio", "Incidente", "Visitantes");
                rel("heroe_raza");
                break;
        }

    }


    private String Historia(String nombre, String tipo) {
        String hist = "";

        switch (nombre) {

            case "Ashkavor":

                switch (tipo) {

                    case "texto1":
                        hist = "Ashkavor es una tierra cercana a las montañas que conducen a Fellstrath. " +
                                "Es el hogar de Grimstroke y de su antigua amante, Yaovhi." +
                                "\n" + "\n" +
                                "Los ashkavorianos son conocidos por sus Ascendidos, individuos especialmente " +
                                "seleccionados que se someten a un entrenamiento y un ritual para convertirse en " +
                                "guardianes de su pueblo."+
                                "\n" + "\n" +
                                "Ashkavor tiene al menos una ciudad, con un templo. Los " +
                                "rituales de ascensión se realizan ahí, cerca de la piedra rúnica central del templo, " +
                                "que se pinta con un pincel para iniciar el hechizo vinculante del Ascendido.";
                        break;
                    case "texto2":
                        hist = "Las líneas de sangre ancestral son extremadamente importantes en Ashkavor " +
                                "e imbuyen a los ashkavorianos de magia. Existen al menos cinco casas principales. " +
                                "Los ancianos llevan un registro de los acontecimientos de la región.";
                        break;

                    case "texto3":
                        hist = "Grimstroke fue el último ashkavoriano en ascender. En su afán de poder, contaminó " +
                                "los tinteros rituales con un extraño ichor. Cuando sumergió su pincel, la tinta " +
                                "se arremolinó hacia su cuerpo, envolviéndolo por completo en la oscuridad. En un " +
                                "acto de desesperación, introdujo la tinta corrompida en los lazos que había establecido " +
                                "con sus compañeros ashkavorianos, transformando instantáneamente a todos sus parientes " +
                                "en sombras malditas. Esta calamidad acabó con Ashkavor como civilización. Grimstroke " +
                                "huyó de la ciudad, sólo para regresar más tarde, encontrándola inmóvil y sin vida. Un" +
                                " pincel mágico, hecho con la magia de las líneas de sangre ancestrales de Ashkavor, se " +
                                "mantuvo en la ciudad hasta que fue tomado por Grimstroke a su regreso." +
                                "\n" + "\n" +
                                "Sólo quedan los Ascendidos anteriores a Grimstroke, escondidos y debilitados por la " +
                                "marea de tinta, aguardando la oportunidad de restaurar a su pueblo algún día.";
                        break;
                }
                break;

            case "Aziyog":

                if ("texto1".equals(tipo)) {
                    hist = "Aziyog es una ciudad subterránea situada bajo la capa de magma y por " +
                            "debajo de volcanes. La ciudad está formada por obsidiana y consiste " +
                            "en una enorme caverna subterránea adornada con finas piedras. Las " +
                            "paredes de la caverna están llenas de pequeñas grietas cubiertas de " +
                            "huesos de esclavos." +
                            "\n" + "\n" +
                            "Dentro de la ciudad habita la Horda Abisal al igual que Vrogros, su " +
                            "Underlord. En busca de conquistas y nuevas tierras Vrogos llama a su " +
                            "horda para que marche desde Aziyog a la superficie y luche contra las " +
                            "naciones de arriba. Vrogros se refiere con frecuencia al Abismo, probablemente " +
                            "otro nombre para Aziyog.";
                }
                break;

            case "Catedral de Rumusque":
                switch (tipo) {
                    case "texto1":
                        hist = "La catedral de Rumusque es supuestamente un lugar de culto. Se desconoce " +
                                "si el nombre \"Rumusque\" se refiere a una deidad/entidad a la que la catedral " +
                                "rinde culto o presta servicios, o si es el nombre de la zona en la que está " +
                                "construida la catedral." +
                                "\n" + "\n" +
                                "El grupo religioso que habita la catedral suelen llamarse Los Fieles de Rumusque.";
                        break;
                    case "texto2":
                        hist = "La catedral acoge a sus propios clérigos que parecen creer en la lucha contra la muerte, " +
                                "la decadencia y la corrupción. Aquí, los papas han trabajado para servir bajo una deidad o " +
                                "propósito desconocido pero es evidente que difunden una especie de escritura sagrada y prometen " +
                                "la salvación y recompensas espirituales si uno acepta sus enseñanzas. La gran sacerdotisa Crella " +
                                "era uno de estos clérigos, y fue ella quien forjó las Cadenas de Abscesión para atar a los siervos " +
                                "del Dios Muerto." +
                                "\n" + "\n" +
                                "Lady Anshu es la Gran Sacerdotisa del clero." +
                                "\n" + "\n" +
                                "Las enseñanzas de Rumusque son desconocidas y actualmente no se conoce ningún " +
                                "canon o texto.";
                        break;
                    case "texto3":
                        hist = "Los clérigos de Rumusque se oponen a la corrupción del Dios Muerto. " +
                                "Para combatir su influencia, se aventuraron en una peregrinación a los " +
                                "Campos de la Carnicería Interminable (Fields of Endless Carnage), donde " +
                                "yacían innumerables cadáveres. Purificaron la tierra con métodos desconocidos, " +
                                "aunque Donte Panlin describe sus tácticas como \"tiempos oscuros\". Pudge " +
                                "abandonó los campos antes de que llegara el clérigo, y por tanto no fue purgado." +
                                "\n" + "\n" +
                                "En una ocasión la catedral, junto con el resto de la población cercana, " +
                                "fue azotada por una poderosa plaga que mató a la mayoría de los sacerdotes y " +
                                "papas que trabajaban allí salvo unos pocos afortunados, uno de los cuales fue " +
                                "Rotund'jere que luego se convertiría en Necrophos tras ser arrojado a un \"pabellón " +
                                "de la plaga\" (Plage Ward), una habitación posiblemente ubicada en el interior de la " +
                                "catedral, de la que se dice que está \"ensorcijada con hechizos\" que infligirán a los " +
                                "que permanezcan en su interior una enfermedad lenta y persistente.";
                        break;

                }
                break;

            case "Claszureme":
                switch (tipo) {
                    case "texto1":
                        hist = "Claszureme es un reino fuera del tiempo, llamado así por el Dios Clasz. " +
                                "A menudo se caracteriza por sus \"salones infinitos\"." +
                                "\n" + "\n" +
                                " Para entrar en Claszureme, hay que tener una gran comprensión de las " +
                                "enseñanzas de Clasz. Se desconoce qué relación tiene Claszureme con los " +
                                "Siete Planos, si es que tiene alguna. El espacio entre Claszureme y otros " +
                                "reinos es increíblemente frío. Para comprender plenamente los misterios de " +
                                "Claszureme, uno debe dedicarse a su \"defensa dimensional\", se desconoce lo " +
                                "que esto implica exactamente." +
                                "\n" + "\n" +
                                "La cronita (chronite), un mineral que existe fuera del tiempo, puede " +
                                "encontrarse en los bordes de Claszureme. En los bordes También se pueden " +
                                "encontrar joyas que manipulan el tiempo, aunque son raras." +
                                "\n" + "\n" +
                                "El Reloj de Arena de Claszureme probablemente también procede de este reino.";
                        break;
                    case "texto2":
                        hist = "Clasz gobierna sobre Claszureme. El culto de Dhreg tiene probablemente su " +
                                "sede en algún lugar de Claszureme y predica desde las numerosas capillas " +
                                "situadas en el reino." +
                                "\n" + "\n" +
                                "Darkterror proviene de Claszureme y es capaz de atravesar el reino " +
                                "abriendo un agujero en el tiempo. También es capaz de abrir una grieta " +
                                "en Claszureme, atrapando y deteniendo el tiempo para todas las cosas dentro " +
                                "de una burbuja dimensional. Los seres que viajan al reino normal desde " +
                                "Claszureme suelen llegar en líneas temporales inciertas, y requieren de guía " +
                                "para no perderse en el tiempo. Puck ha estado en Claszureme, donde se enteró " +
                                "de que Darkterror no es querido en el reino y muchos de sus habitantes se " +
                                "alegran de verlo partir al reino mortal." +
                                "\n" + "\n" +
                                "Según Darkterror, fuerzas desconocidas de Claszureme le infligirán desgracias " +
                                "si no consigue la victoria en la dimensión mortal. Cuando es derrotado, " +
                                "regresa a Claszureme. Darkterror también parece hacer referencia a varios " +
                                "dioses, pero no se dan más detalles.";
                        break;

                }
                break;

            case "Arrecife Oscuro":
                switch (tipo) {
                    case "texto1":
                        hist = "El Arrecife Oscuro es una prisión submarina que alberga a los peores habitantes " +
                                "del mar." +
                                "\n" + "\n" +
                                "Gigantescas babosas infestan la prisión, comiendo carroña y los cadáveres de los " +
                                "prisioneros. +" +
                                "\n" + "\n" +
                                "Según Slark, el Arrecife Oscuro se \"levantará\" algún día, aunque se desconoce " +
                                "qué significa esto exactamente.";
                        break;
                    case "texto2":
                        hist = "La prisión se encuentra cerca de un asentamiento naga. Está construida dentro de " +
                                "una profunda zanja oceánica, cubierta por una rejilla metálica. Su interior se " +
                                "describe como un oscuro laberinto. Las anguilas patrullan el terreno y las salidas " +
                                "están vigiladas por anémonas gigantes que pican. Hay minas explosivas encadenadas " +
                                "flotando cerca del exterior donde varios barcos han naufragado y se han sumergido " +
                                "alrededor de la entrada superior. La fauna cetácea puede oírse en las cercanías, " +
                                "sobre todo por la noche.";
                        break;
                    case "texto3":
                        hist = "En la prisión se encuentran Slithereen asesinos, Profundos (Deep Ones) traicioneros " +
                                "y Meranths sociópatas. A veces se introducen gemas de contrabando en el Arrecife " +
                                "Oscuro." +
                                "\n" + "\n" +
                                "Sólo los prisioneros más duros sobreviven. Slark estuvo una vez preso en el Arrecife " +
                                "Oscuro, por crímenes no revelados. Dark Reef Dozen intentó una vez escapar, pero " +
                                "fracasó. Sin embargo, Slark pudo aprovechar su intento de fuga como distracción " +
                                "para escapar él mismo. Hasta el día de hoy, Slark es el único prisionero que ha " +
                                "escapado de Arrecife Oscuro. Un ladrón mató una vez a once guardias antes de ser " +
                                "finalmente asesinado.";
                        break;
                    case "texto4":
                        hist = "La Diosa Skadi puede tener algo que ver con la prisión de Arrecife Oscuro. Se " +
                                "encontró una hoja de Skadi enterrada en los terrenos de la prisión. Otra arma " +
                                "de Skadi fue fabricada por un herrero y un mago, con materiales encontrados en " +
                                "el Arrecife Oscuro.";
                        break;
                    case "texto5":
                        hist = "Los Oscuros pueden estar relacionados de algún modo con el Arrecife Oscuro. En " +
                                "los alrededores de la prisión pueden verse estatuas de un ser cefalópodo lo " +
                                "que indica quizás una relación con el dios Maelrawn.";
                        break;

                }
                break;

            case "Desierto de la Anarquía":
                switch (tipo) {
                    case "texto1":
                        hist = "El Desierto de Misrule se encuentra en el interior o al oeste del Basurero " +
                                "Centelleante (Scintillant Waste). Es una tierra caliente y estéril, y es el " +
                                "hogar de los Wyrms del desierto.";
                        break;
                    case "texto2":
                        hist = "Se pueden encontrar asentamientos en partes del desierto, la mayoría de los " +
                                "cuales llevan un estilo de vida tranquila y humilde. " +
                                "\n" + "\n" +
                                "Cansados de su problemática hija, los padres de Lina la enviaron a " +
                                "vivir con una tía en el desierto. Muchos pretendientes han llamado a Lina, " +
                                "pero todos han sido rechazados hasta ahora." +
                                "\n" + "\n" +
                                "En el pasado, el desierto estaba gobernado por nobles, que se adornaban " +
                                "con preciosos rubíes. Llevaban joyas de oro y túnicas con colas puntiagudas. " +
                                "En la actualidad, el Señor de la Anarquía reina en el desierto.";
                        break;
                    case "texto3":
                        hist = "Mireska Sunbreeze ha pasado un tiempo en el Desierto del Desgobierno y " +
                                "ha llegado a gustarle.";
                        break;

                }
                break;

            case "Druud":
                if ("texto1".equals(tipo)) {
                    hist = "Druud es una región caracterizada por ser un altiplano o meseta y es el " +
                            "hogar de los clanes de centauros. La arena de Omexe se encuentra en Druud." +
                            "\n" + "\n" +
                            "Las tierras altas de Druud también son el hogar de un grupo de Oglodi " +
                            "que son todo lo que queda de una antigua tribu. Los Oglodi de las tierras " +
                            "altas son a menudo asediados por los reinos al sur de Druud." +
                            "\n" + "\n" +
                            "En las tierras altas de Druud se pueden encontrar Stryders, que son utilizados " +
                            "como montura por los Oglodi.";
                }
                break;

            case "Emauracus":
                if ("texto1".equals(tipo)) {
                    hist = "Emauracus es un lugar conocido por sus acantilados cavernosos. Los " +
                            "sacerdotes de la Omnisciencia habitan en estas cuevas, que se adentran " +
                            "en las profundidades de la tierra, donde reside la Omnisciencia. Un " +
                            "viaje a la Omnisciencia puede durar muchas semanas. También se pueden " +
                            "encontrar fosas de sacrificio a la Omnisciencia, aunque se desconoce si " +
                            "estas fosas son naturales, o hechas por el hombre. Los altos acantilados " +
                            "de Emauracus están simbolizados por un par de alas, que a veces se " +
                            "encuentran en armaduras y equipos." +
                            "\n" + "\n" +
                            "En las bóvedas de Emauracus se guardan poderosas reliquias, como el " +
                            "martillo de la Cascada de los Adoradores. El forjador de Emauracus " +
                            "afirma ser el mejor herrero vivo, pero incluso él se asombra de las " +
                            "armaduras forjadas por los primeros caballeros que recibieron la " +
                            "bendición de la Omnisciencia.";
                }
                break;

            case "Imperio de Huesos":
                if ("texto1".equals(tipo)) {
                    hist = "El Imperio de Hueso era el dominio de Ostarion. Su palacio y sus " +
                            "torres estaban construidos de huesos al igual que el pavimento de " +
                            "sus calles. Incluso el entorno natural llegó a ser sustituido por " +
                            "hueso como el Bosque de Marfil. Se gobernó desde el Trono de Huesos." +
                            "\n" + "\n" +
                            "Tras los sucesos de la Noche de los Espectros, en la que Ostarion " +
                            "renació como el Rey Espectro, la Esencia Espectral que había recogido " +
                            "también transformó su imperio. Ahora los huesos están cubiertos de " +
                            "una Pulpa Espectral verde.";
                }
                break;

            case "Campos de la Matanza sin Fin":
                switch (tipo) {
                    case "texto1":
                        hist = "Los Campos de la Matanza sin Fin son una zona de combate en el " +
                                "extremo sur de Quoidge. Está cubierto de muertos que no pueden " +
                                "descomponerse por razones desconocidas. Pudge solía vagar por los " +
                                "campos cortando la carne y devorándola.";
                        break;
                    case "texto2":
                        hist =  "Los clérigos de la Catedral de Rumusque peregrinaron a los campos, " +
                                "posiblemente para purificarlos de cadáveres. La forma en que lo hicieron " +
                                "es descrita por Donte Panlin como \"oscura\". Pudge abandonó la zona antes " +
                                "de que llegaran los clérigos y no fue purificado en el proceso.";
                        break;

                }
                break;

            case "Fuente del Averno":
                if ("texto1".equals(tipo)) {
                    hist = "La Fuente del Averno es una fuente de vapores místicos que otorga poderes " +
                            "a sus guardianes, la Casa del Averno. Fluye desde una grieta en la piedra " +
                            "y es respirada por los miembros de la Casa. Los vapores se asemejan a una " +
                            "niebla negra que absorbe la luz y confiere extraños poderes sobre la vida y " +
                            "la muerte. Los que están en sintonía con sus energías también pueden ver " +
                            "fortunas y destinos en la niebla, revelando secretos de liderazgo, guerra y " +
                            "dominio. Por esta razón, los poderes de la Fuente son odiados incluso por los" +
                            " demonios inmortales del infierno." +
                            "\n" + "\n" +
                            "La propia niebla negra puede ser sensible, aunque sus motivos no están claros." +
                            " Elige a los mortales para que la defiendan, permitiéndoles forjar armas en " +
                            "la niebla. La niebla también es capaz de conjurar criaturas para sus defensores, " +
                            "como Netherax." +
                            "\n" + "\n" +
                            "Lord Abaddon bebió más profundamente que ninguno de la Fuente y desde entonces " +
                            "se ha convertido en un ser sobrenatural, una criatura de la niebla negra. Abaddon " +
                            "afirma que es la niebla la que le controla a él, y no al revés.";
                }
                break;

            case "Fortaleza de las Llamas":
                switch (tipo) {
                    case "texto1":
                        hist = "La Fortaleza de las Llamas es una estructura situada en las Montañas de los " +
                                "Lamentos, probablemente cerca de la Ciudad Ruinosa. En su día fue un campo de " +
                                "entrenamiento para nuevos guerreros, dirigido por el renombrado Xin, que enseñaba " +
                                "a sus alumnos los Lazos de la Llama Guardiana. Se puede encontrar un templo sellado " +
                                "dentro de los terrenos de la fortaleza.\n" +
                                "En la actualidad, la fortaleza está abandonada y sus edificios están cubiertos" +
                                " de vegetación." +
                                "\n" + "\n" +
                                "En la fortaleza se guardaban un par de estoques reliquia, que cobraban vida " +
                                "en forma de fuego cuando los recogía el reencarnado Xin.";
                        break;
                    case "texto2":
                        hist = "En el templo, las cenizas de Xin descansan en un caldero de topacio. Inspirado " +
                                "por el legado de Xin, el Celestial Ardiente volvió a encender las cenizas con " +
                                "su cuerpo y esta fusión dio lugar al ser conocido hoy como Ember Spirit.";
                        break;

                }
                break;

            case "Foulfell":
                switch (tipo) {
                    case "texto1":
                        hist = "Foulfell es un plano carcelario, una dimensión oculta donde los demonios " +
                                "encarcelan a sus forajidos. Puede ser uno de los Siete Planos. El interior " +
                                "de Foulfell se describe como un espejo oscuro de la realidad, revestido de " +
                                "paredes fractales que reflejan las imágenes de los encarcelados. A veces " +
                                "se le llama el infierno de los infiernos, indicando que está dentro o conectado " +
                                "a los Siete Infiernos.";
                        break;
                    case "texto2":
                        hist = "Los cristales negros llamados Fragmentos de Foulfell se originan en el " +
                                "plano carcelario y cada fragmento contiene demonios encarcelados. Palpitan " +
                                "con el odio sin voz de sus prisioneros, e interactúan con los demonios de " +
                                "formas desconocidas.";
                        break;
                    case "texto3":
                        hist = "Condenado por robar a los Señores Demonio, Terrorblade fue encarcelado " +
                                "en Foulfell, donde aprendió a manipular sus reflejos. Finalmente, rompió " +
                                "las paredes en fragmentos y se escapó de Foulfell.";
                        break;

                }
                break;

            case "Corazón de la Naturaleza":
                switch (tipo) {
                    case "texto1":
                        hist = "Encontrado solo en las profundidades de toda la naturaleza y accesible " +
                                "únicamente con los Cristales Cronópticos embrujados, este plano de existencia " +
                                "sólo es conocido por la mente solitaria de una entidad maligna. En este " +
                                "plano oculto, la naturaleza se ha convertido en un lugar escabroso y vil. " +
                                "Lo escabroso en este contexto puede tener dos significados: Es escabroso " +
                                "porque se dice que es horroroso y espantoso para los que lo ven o puede ser " +
                                "escabroso porque tiene colores demasiado vivos y brillantes lo que posiblemente " +
                                "podría reflejarse en el esquema de colores brillantes y disonantes de Leshrac. " +
                                "Aquí, la naturaleza se ha convertido en un mundo asolado, lleno de tormento," +
                                " sufrimiento y decadencia." +
                                "\n" + "\n" +
                                "En este plano hay energía Cronóptica que fluye de este plano a otro cuando " +
                                "es invocada por Leshrac para evaporar todo lo que toca. Basado en el único " +
                                "elemental que encarna los aspectos de este plano, en este lugar crecen " +
                                "hongos antinaturales, sostenidos por sus aguas contaminadas. También crecen " +
                                "aquí vides malvadas, que se nutren de la angustia, los pensamientos negros y " +
                                "las acciones sucias en lugar de la luz, el aire y el agua." +
                                "\n" + "\n" +
                                "Según Leshrac, las formas de todos los seres surgen de este lugar, lo que " +
                                "puede explicar por qué se le llama el corazón de la naturaleza. Si la forma " +
                                "de cada ser se origina en esta naturaleza maldita entonces todos los que " +
                                "surgen de este lugar (especialmente los que existen en el mundo natural) " +
                                "están técnicamente sometidos a una existencia de tormento de la que simplemente " +
                                "no son conscientes ya que su origen es una naturaleza hecha de elementos " +
                                "atormentados.";
                        break;
                    case "texto2":
                        hist = "Las Impurezas son los poderes y elementos impuros del corazón de la naturaleza. " +
                                "A pesar de ser impuros, pueden ser destilados hasta su esencia por alguna razón. " +
                                "Estas Impurezas incluyen:" +
                                "\n" + "\n" +
                                "Vientos malignos, de los que no sabemos nada." +
                                "\n" + "\n" +
                                "Aguas contaminadas que pueden fortalecer y sostener sólo la vida antinatural. " +
                                "Cualquiera que beba de estas aguas se corrompe con brotes de hongos y ramas " +
                                "que también pueden propagar la corrupción aún más a las almas de los que las " +
                                "tocan. La corrupción es permanente e irreparable." +
                                "\n" + "\n" +
                                "Energías siniestras que alimentan los deseos de Leshrac a juzgar por el " +
                                "tono de la voz. Puede ser o no la energía Cronóptica que se menciona con " +
                                "frecuencia en la historia de Leshrac." +
                                "\n" + "\n" +
                                "Tierra fragmentada, de la que tampoco sabemos nada." +
                                "\n" + "\n" +
                                "Electricidad rosa-púrpura, convocada a partir de las enormes tormentas " +
                                "eléctricas de Leshrac." +
                                "\n" + "\n" +
                                "Todos estos elementos componen la naturaleza vil y maldita que existe en " +
                                "sus propias profundidades. Las Impurezas están en un constante estado de " +
                                "tormento y son descritas como \"sin inteligencia\" por razones desconocidas. " +
                                "Aunque las Impurezas y el lugar del que provienen son un conocimiento " +
                                "prohibido en sí mismo, cubren una base aún peor de misterios bajo ellas, " +
                                "que Leshrac busca aprender a través de \"un final para todo\" que podría " +
                                "ser su muerte o la destrucción del mundo." +
                                "\n" + "\n" +
                                "Al igual que los elementos del mundo natural: La luz, el aire y el agua; " +
                                "las Impurezas son los elementos que sostienen la vida en este lugar, " +
                                "incluso proporcionan la reencarnación a aquellos que tienen una conexión " +
                                "especial con ellos, como su único agente elemental.";
                        break;
                    case "texto3":
                        hist = "Nadie vive en este asqueroso lugar excepto Leshrac, que describe este " +
                                "mundo como un claustro y un lugar de soledad. Leshrac es el guardián " +
                                "de las Impurezas que componen este lugar y es su único agente. Como " +
                                "elemental que es uno con esta vil naturaleza, está compuesto por las " +
                                "Impurezas que constituyen este lugar. Aquellos que son asesinados, " +
                                "impurificados y descompuestos a sus elementos fundamentales por su mano " +
                                "y voluntad son enviados de vuelta a este lugar para fusionarse con las " +
                                "Impurezas. No es un nativo de este plano, pero Leshrac es el primer y " +
                                "único ser que ha encontrado este plan, gracias a los Cristales Cronópticos " +
                                "embrujados que ahora le torturan con el conocimiento de este lugar." +
                                "\n" + "\n" +
                                "Leshrac puede dar diezmos de oro a las Impurezas por razones desconocidas. " +
                                "Tampoco se sabe qué uso le dan las Impurezas al oro" +
                                "\n" + "\n" +
                                "También invoca a las Impurezas de este plano en sus acciones. Tal es su " +
                                "devoción por las Impurezas que incluso las menciona en una expresión al morir." +
                                "\n" + "\n" +
                                "Enigma parece conocer este lugar. Lo conoce como el \"núcleo del universo\" " +
                                "o el \" principio de la naturaleza\", donde tesoros brotan de dicho lugar " +
                                "para que él los reciba. Esto parece implicar que el corazón de la naturaleza " +
                                "es en realidad el origen de toda la naturaleza.";
                        break;

                }
                break;

            case "Imperio Helio":
                switch (tipo) {
                    case "texto1":
                        hist = "El Imperio Helio es un lugar frecuentemente mencionado por Davion. " +
                                "Stonehall planea conquistar el imperio Helio. Algo sucedió en este " +
                                "lugar que involucró a Lina y Davion. Hay un \"Calzador\" (Shoehorn) " +
                                "en el lugar donde vive una persona que se parece a Alchemist (ya sea " +
                                "refiriéndose a Razzil o al ogro, este último hizo una aparición en Dota: " +
                                "Dragon's Blood)." +
                                "\n" + "\n" +
                                "En Dragon's Blood, Drysi menciona brevemente el Imperio Helio cuando " +
                                "se enfrenta a Luna y sus tropas de la Luna Oscura. Recuerda que Luna " +
                                "los vendió al Imperio Helio, lo que posiblemente da cierto contexto " +
                                "a la traición de Luna hacia Drysi.";
                        break;
                    case "texto2":
                        hist = "Helio es una palabra que se refiere al sol. La palabra imperium significa " +
                                "\"poder absoluto\" o \"poder real\". Esto puede sugerir que el Imperio de " +
                                "Helio tiene algo que ver con el Trono Solar, el trono de poder que Mirana " +
                                "iba a ocupar antes de abdicar en la Orden de la Luna Oscura.";
                        break;

                }
                break;

            case "Templo Escondido":
                switch (tipo) {
                    case "texto1":
                        hist = "El Templo Oculto es un lugar secreto descubierto por Lanaya en su " +
                                "interminable búsqueda del conocimiento. Los Ocultos, incluyendo a Inai, " +
                                "viven dentro del templo que también almacena una serie de códices encriptados." +
                                "\n" + "\n" +
                                "Se sabe que los Dragones Feéricos (Faerie Dragons) visitan el Templo Oculto.";
                        break;
                    case "texto2":
                        hist = "El templo se encontró a través de una puerta secreta que \"existe en la " +
                                "propia naturaleza\". Según Lanaya una persona normal no puede ver la entrada " +
                                "del templo. Además, insinúa que los escalones del templo están donde \"la " +
                                "mente se encuentra con la materia\"." +
                                "\n" + "\n" +
                                "El padre de Mireska gastó gran parte de su oro tratando de encontrar el " +
                                "templo, sin éxito.";
                        break;
                    case "texto3":
                        hist = "Inai, el Espíritu del Vacío (Void Spirit), reside en el Templo Oculto. Es " +
                                "su maestro y se le considera el más oculto de los Ocultos (Hidden Ones). " +
                                "Es posible que el templo sea un bastión que construyó basándose en diseños korumitas.";
                        break;
                    case "texto4":
                        hist = "Al conocer a los Ocultos, Lanaya se enteró de que poseían secretos que ella " +
                                "deseaba. A cambio de ese conocimiento juró servir a sus exigencias actuando " +
                                "sin rechistar como su asesina. Con esto se le concedieron poderes especiales " +
                                "para ayudarla en sus deberes. Si rompe sus votos sus poderes desaparecerán.";
                        break;
                    case "texto5":
                        hist = "El Templo Oculto está interesado en reclutar asesinos, incluido el Asesino " +
                                "de Nyx (Nyx Assassin). Los señalados para la ejecución suelen ser culpables " +
                                "de descubrir secretos, especialmente los que están prohibidos por los Ocultos." +
                                "\n" + "\n" +
                                "Mercurial también sirve al Templo Oculto pero no siempre sigue las instrucciones.";
                        break;
                    case "texto6":
                        hist = "Según los rumores que circulan entre los adeptos al templo, los Ocultos " +
                                "saldrán pronto a revelar más secretos.";
                        break;

                }
                break;

            case "Fisura de Hielo":
                switch (tipo) {
                    case "texto1":
                        hist = "Fisura de Hielo (Icewrack) es una tierra helada en el norte, a veces " +
                                "conocida como el Basurero Helado. Está justo al sur de La Barrera " +
                                "(The Barrier) y limita con el Mar del Norte o el Mar Hirviente. El " +
                                "glaciar Corazón Azul fluye a través de Icewrack. El Corazón de Njord " +
                                "puede estar en o cerca de Fisura de Hielo.";
                        break;
                    case "texto2":
                        hist = "La tribu Frostiron vive en el extremo norte de Icewrack, cerca del Mar del Norte." +
                                "\n" + "\n" +
                                "Rylai, una niña inusual nacida con la capacidad de congelar todo a su paso, " +
                                "fue enviada por sus exasperados padres a vivir a Icewrack, donde se convirtió " +
                                "en alumna del Mago de Hielo. Es capaz de invocar enormes fragmentos de hielo " +
                                "desde Icewrack, haciéndolos llover sobre sus oponentes." +
                                "\n" + "\n" +
                                "Tusk es nativa de la zona y regresa al lejano norte cada invierno para visitar " +
                                "a la tribu Frostiron." +
                                "\n" + "\n" +
                                "Un gran espíritu de lobo blanco vivió una vez en o cerca de Icewrack, cuya " +
                                "presencia presagiaba la muerte. Muchos cazadores intentaron matarlo, hasta " +
                                "que se dice que fue asesinado por un talentoso arquero, posiblemente Traxex.";
                        break;
                    case "texto3":
                        hist = "Los pueblos de Icewrack pueden utilizar monedas de cobre como divisa. Los " +
                                "zafiros se encuentran en los glaciares de Icewrack y son valorados por los " +
                                "artesanos de la Tribu Frostiron." +
                                "\n" + "\n" +
                                "Icewrack es conocido por un fino tipo de vino blanco, muy apreciado por Donte " +
                                "Panlin y los Galanes de Nivan (Nivan Gallants)." +
                                "\n" + "\n" +
                                "Hay indicios de que las tierras de Icewrack y sus alrededores están envueltas " +
                                "en un conflicto.";
                        break;
                    case "texto4":
                        hist = "En Icewrack se puede encontrar una especie particular de lobo, el lobo de Icewrack. \n" +
                                "\n" + "\n" +
                                "En la región también viven zorros cervales.";
                        break;

                }
                break;

            case "Isla de las Máscaras":
                switch (tipo) {
                    case "texto1":
                        hist = "Aunque se puede decir mucho sobre sus nativos y habitantes poco se sabe " +
                                "de la Isla de las Máscaras, aparte de su destrucción predestinada en " +
                                "una noche de magia vengativa. Durante esa noche, el fuego surgió del mar " +
                                "haciendo que las aguas circundantes de la isla hirvieran y sumergieran la " +
                                "isla bajo las olas." +
                                "\n" + "\n" +
                                "Snapfire era lo suficientemente mayor como para haber visitado esta isla " +
                                "antes de que fuera inundada. Le pareció un lugar precioso, pero también " +
                                "pensó que la gente de allí era tonta.";
                        break;
                    case "texto2":
                        hist = "Es posible que las Islas de Marfil estuvieran situadas en algún lugar cerca " +
                                "o dentro de esta isla." +
                                "\n" + "\n" +
                                "Dentro de la Isla de las Máscaras se encuentra uno de sus lugares de " +
                                "culto, el Templo de las Máscaras, al que los Enmascarados acudían en " +
                                "peregrinación. Quedó sumergido junto a la isla en la que se encontraba " +
                                "haciéndolo completamente inaccesible. A pesar de ello, el único visitante " +
                                "que queda sigue practicando los rituales de su fe sin el templo." +
                                "\n" + "\n" +
                                "Todo lo que había en la isla se ahogó bajo las olas, incluido el Rostro de " +
                                "la Venganza.";
                        break;
                    case "texto3":
                        hist = "Como todos los enmascarados, Juggernaut fue concebido y criado en la Isla de " +
                                "las Máscaras. Ahora que la isla ha sido destruida, él es el único que queda " +
                                "para preservar su memoria y su rica cultura con su presencia en el mundo de " +
                                "los vivos." +
                                "\n" + "\n" +
                                "Su condición de último de su especie no duró para siempre. Sin saberlo, su " +
                                "propia máscara es en realidad el recipiente de las almas dormidas de sus " +
                                "antepasados guerreros, un antiguo linaje de venerados guerreros. En vida, " +
                                "fueron tachados de traidores a la isla, se les negó una muerte noble y se " +
                                "les despojó de su honor, al igual que a su descendiente Yurnero. Estas almas " +
                                "dormidas pronto despertarían cuando su contenedor fue partido por la mitad " +
                                "por Sven con la Espada del Adjudicador devolviendo a la vida una pequeña " +
                                "parte de la presencia de los Enmascarados. Ahora, unidos al ser de Yurnero, " +
                                "buscan reclamar su honor perdido y restaurar la Isla de las Máscaras y a su " +
                                "gente, lo cual se logrará una vez que el Ancestro adversario sea destruido." +
                                "\n" + "\n" +
                                "Esta isla es la patria de la aislada y ya extinta raza de los Enmascarados, " +
                                "el núcleo cultural y tradicional de esta isla." +
                                "\n" + "\n" +
                                "Crex vo Gali, una entidad misteriosa, se come a los grotescos que le sirven " +
                                "de alimento." +
                                "\n" + "\n" +
                                "El legendario dragón Akakiryu puede haber vivido alguna vez en esta isla. " +
                                "Una espada recibió su nombre y el arma fue otorgada a un joven Yurnero " +
                                "mucho antes de su exilio.";
                        break;
                    case "texto4":
                        hist = "En esta isla se puede encontrar una gran variedad de fauna. Entre las " +
                                "criaturas más comunes se encuentran los yaks de montaña, los lobos " +
                                "de montaña, los perros con cuernos, el carnero de las altas llanuras, " +
                                "los jabalíes, etc. Además de estos animales poco interesantes, hay " +
                                "varias bestias peligrosas que podrían haber vivido alguna vez en las " +
                                "islas. Hay demonios y grandes abominaciones que cazan con un intelecto " +
                                "ajeno y una gran bestia valiente con grandes colmillos. Los corodontes, " +
                                "bestias extinguidas hace mucho tiempo con el corazón hecho de marfil, " +
                                "pueden haber vivido en algún lugar de las Islas de Marfil." +
                                "\n" + "\n" +
                                "En esta isla existen espíritus de dragón. El espíritu de dragón más " +
                                "notable es el que acompaña a Yurnero, que resulta ser también uno de " +
                                "sus muchos antepasados.";
                        break;

                }
                break;

            case "Knollen":
                switch (tipo) {
                    case "texto1":
                        hist = "Knollen es una tierra de valles montañosos. Está habitada por Keens, " +
                                "y es la patria de Kardel Sharpeye, el Francotirador. Los Trepadores " +
                                "(Steepstalkers) viven entre sus picos, al igual que los Trolls, que a " +
                                "veces son disparados por los Keen.";
                        break;
                    case "texto2":
                        hist = "Los Keen de Knollen son muy hábiles con las armas de fuego. Cuando un " +
                                "padre Keen muere, su arma pasa a su hijo. Para convertirse en miembro " +
                                "de pleno derecho del pueblo, un joven Keen debe superar una antigua " +
                                "prueba: matar a un steepstalker de un solo disparo desde el fondo del" +
                                " valle. Fallar es una desgracia. Cuando Kardel mató a su steepstalker, " +
                                "la bala atravesó el ojo central de la criatura y cayó en sus mandíbulas, " +
                                "lo que significó tanto su grandeza como un oscuro presagio. Debía alcanzar " +
                                "un gran renombre en el campo de batalla, o no volver jamás." +
                                "\n" + "\n" +
                                "En Knollen también es habitual fumar puros." +
                                "\n" + "\n" +
                                "Knollen es conocida por sus carnavales de verano, en los que se puede " +
                                "jugar a juegos como el tiro al blanco y ganar entradas.";
                        break;

                }
                break;

            case "La Luna Loca":
                switch (tipo) {
                    case "texto1":
                        hist = "La Luna Loca era una gran esfera cósmica que orbitaba el mundo, " +
                                "la prisión de las fuerzas Radiant y Dire, hasta que se autodestruyó " +
                                "en un cataclismo.";
                        break;
                    case "texto2":
                        hist = "Una vez, los ancestrales intelectos Radinthul y Diruulth se enfrentaron " +
                                "sin cesar, ambos nacidos de una gran mente primordial que se hizo añicos " +
                                "al crearse el universo. Las dos fuerzas, completamente opuestas en todos " +
                                "los sentidos, no podían encontrar un compromiso entre ellas. Zet, otro " +
                                "fragmento de la mente primordial, se cansó de su lucha y fusionó a " +
                                "sus hermanos en una sola esfera. Los lanzó al espacio para que quedaran a " +
                                "la deriva durante toda la eternidad. Con el tiempo, esta esfera fue " +
                                "capturada en la órbita de un mundo aún en fase de enfriamiento, la Tierra, " +
                                "brillando sobre ella mientras las razas nacían. Debido a su poder, la Luna " +
                                "Loca brillaba con fuerza sobre la Tierra, compitiendo incluso con el brillo del sol." +
                                "\n" + "\n" +
                                "Pero las fuerzas de su interior seguían luchando y la Luna Loca empezó a " +
                                "mostrar imperfecciones. Fue entonces cuando Valora, la Dawnbreaker, " +
                                "se estrelló contra la luna mientras estaba en su estado latente, se " +
                                "disculpó con Zet por sus transgresiones y juró destruir a ambos Ancestros. " +
                                "El poder de Zet disminuyó, las pequeñas debilidades se expandieron y, " +
                                "finalmente, la esfera se rompió, haciendo llover material sobre el Mundo. " +
                                "Los restos de la Luna Loca se asentaron como Oro Radiante (Radiant Ore) y " +
                                "Piedra Diabólica (Direstone), materiales puros de las dos inteligencias. " +
                                "El Mundo cayó en un caos temporal, aunque algunos aprovecharon la situación. " +
                                "Abzidian, el Herrero de los Demonios, aprovechó este momento para forjar el " +
                                "Filo de los Demonios (Demon Edge) a partir de las materias primas que cayeron.";
                        break;
                    case "texto3":
                        hist = "Tras la destrucción de la Luna Loca, el Oro Radiante y la Piedra Diabólica " +
                                "comenzaron a emitir energía pura que corrompió a las razas. Se volvieron " +
                                "dependientes de ella y construyeron civilizaciones en torno al material, " +
                                "mientras la roca les proporcionaba energía, Mana y vida. El Oro Radiante " +
                                "emitía colores brillantes y encantaba la zona que lo rodeaba, mientras que " +
                                "la Piedra Diabólica hacía que la tierra pareciera venenosa y descompuesta. " +
                                "Ninguno de los dos eran neutral en sus acciones. Las energías que emitían " +
                                "eran incompatibles e interferían entre sí. Con el tiempo, los seguidores " +
                                "de cada una de las fuerzas se dieron cuenta de ello y trataron de destruir " +
                                "la piedra opuesta. Esta lucha es la que dio inicio a una batalla interminable.";
                        break;

                }
                break;

            case "Monte Pyrotheos":
                switch (tipo) {
                    case "texto1":
                        hist = "El Monte Pyrotheos es un volcán muerto. Debajo de su caldera humeante " +
                                "hay un complejo sistema de tubos de lava oscura, donde vive Black " +
                                "Arachnia con sus numerosas crías de araña.";
                        break;
                    case "texto2":
                        hist = "Broodmother y sus crías de araña fueron en su día veneradas por un " +
                                "culto cercano al monte Pyrotheos, que creía que su insaciable hambre " +
                                "era divina. El culto construyó una armadura metálica para ella a partir " +
                                "de las llamas de la caldera del Monte Pyrotheo. Los adoradores ofrecían " +
                                "esa armadura a Broodmother antes de arrojarse a sus telas para ser " +
                                "devorados. El culto de las arañas ha desaparecido desde entonces, dejando " +
                                "sólo trozos de armadura esparcidos por las interminables telas de Broodmother.";
                        break;
                    case "texto3":
                        hist = "Sabiendo que la presencia de Black Arachnia disuadía a los intrusos, Ptholopthales " +
                                "llegó al Monte Pyrotheos, y construyó su Zigurat Magnético en las laderas del " +
                                "volcán. Esto atrajo a un sinfín de ladrones, todos los cuales fueron consumidos " +
                                "por Black Arachnia. Sin embargo, los intrusos suponían un peligro para sus " +
                                "crías. Black Arachnia visitó a Ptholopthales, que se negó a alcanzar un " +
                                "acuerdo para reducir el número de intrusos. Enfadada, Black Arachnia " +
                                "envolvió al visir en un capullo de seda y se lo comió. Por desgracia, " +
                                "esto no detuvo el continuo flujo de ladrones, por lo que Broodmother se ha " +
                                "propuesto dar caza a cualquier intruso potencial antes de que ponga un pie " +
                                "cerca de sus túneles.";
                        break;

                }
                break;

            case "Confines Infernales":
                switch (tipo) {
                    case "texto1":
                        hist = "Las descripciones de los Confines Infernales parecen variar, desde un mundo " +
                                "subterráneo situado cerca de las placas tectónicas del planeta hasta un plano " +
                                "de existencia espiritual. En cualquier caso, se trata de un reino con mucha " +
                                "historia a sus espaldas que ha existido durante millones de años. Se dice que se " +
                                "llama Confines Infernales porque llega hasta ti..." +
                                "\n" + "\n" +
                                "En cuanto a la primera descripción, se puede acceder a los Confines Infernales " +
                                "mediante fisuras en la tierra que permiten el paso al reino. Sin embargo, esto " +
                                "ya no es una opción, ya que el deslizamiento tectónico ha sellado al reino y a " +
                                "sus habitantes del mundo de la superficie. Hay respiraderos en los Confines del " +
                                "Infierno, pero se desconoce para qué sirven. Existen cavernas luminosas en este " +
                                "reino, que es el hogar de los Netherdrakes." +
                                "\n" + "\n" +
                                "En cuanto a las últimas descripciones, es posible que los Confines Infernales " +
                                "no sean un lugar físico, sino más bien un plano espiritual de la existencia. " +
                                "Cuando los objetivos son desterrados a los Confines Infernales, asumen una forma " +
                                "etérea. También hay una sala que extrae el poder de los Confines Infernales y " +
                                "existe entre el plano corpóreo y un reino espiritual, haciendo que se convierta " +
                                "en mitad corpóreo y mitad etéreo. Los objetos de los Confines Infernales sólo " +
                                "pueden aparecer en el plano material atándolos a dicho plano de existencia. Estos " +
                                "datos parecen contradecir el estatus del lugar como un reino físico." +
                                "\n" + "\n" +
                                "Sin embargo, los rumores sobre una posible entrada a este lugar pueden disipar " +
                                "la ambigüedad. Se dice que entre los reinos existe un pasaje a los Confines " +
                                "Infernales sellado, lo que posiblemente insinúa que los Confines Infernales " +
                                "son un lugar tanto corpóreo como etéreo debido a que tienen una existencia " +
                                "fronteriza entre los reinos." +
                                "\n" + "\n" +
                                "La coraza de asalto se forjó en este reino." +
                                "\n" +
                                "A juzgar por su apelativo " +
                                "Nether y su origen de otro mundo, La Capucha Infernal (Nether Shawl) puede " +
                                "tener su origen en este lugar.";
                        break;
                    case "texto2":
                        hist = "En los Confines Infernales, sus habitantes practican las Artes del " +
                                "Olvido. Hay una academia dedicada a las Artes del Olvido donde se " +
                                "enseña a los niños a dominar sus técnicas oscuras para convertirse en el " +
                                "próximo gran maestro del Olvido." +
                                "\n" + "\n" +
                                "Pugna afirma que toda la magia tiene su origen en los Confines Infernales.";
                        break;
                    case "texto3":
                        hist = "Viper no es más que uno de los muchos netherdrakes que proceden de las cavernas " +
                                "luminosas de los Confines Infernales. Fue soltado de ese lugar por cierto mago " +
                                "que esperaba capturarlo y domesticarlo, pero logró liberarse en el mundo de la " +
                                "superficie." +
                                "\n" + "\n" +
                                "Nacido en la aldea cercana a los respiraderos de los Confines del Infierno, " +
                                "Pugna es otro nativo de este lugar. Pasó toda su infancia en este reino y fue " +
                                "preparado desde muy joven en la academia vecina para convertirse en el próximo " +
                                "gran maestro del Olvido." +
                                "\n" + "\n" +
                                "Entre las formas de vida malignas de los Confines Infernales, destaca Ix'yxa " +
                                "el Destructor, el más temible de todos ellos." +
                                "\n" + "\n" +
                                "Los Confines del Infierno están repletos de vida maligna, incluyendo a " +
                                "los Netherdrakes que han vivido en las cavernas del reino durante millones de años.";
                        break;

                }
                break;

            case "Bosque de la Noche Plateada":
                switch (tipo) {
                    case "texto1":
                        hist = "El Bosque de la Noche Plateada es el bosque sagrado de Selemene, " +
                                "la diosa de la luna. La Orden de la Luna Oscura reside en el bosque, " +
                                "dedicándose a Selemene y cumpliendo sus órdenes. Los intrusos son " +
                                "rechazados por los guerreros de la Luna Oscura o golpeados por los rayos " +
                                "de energía lunar de la propia Selemene.";
                        break;
                    case "texto2":
                        hist = "Cuando los Bosques de la Noche Plateada apenas estaban formados, un solo " +
                                "fragmento de luna cayó y el Santuario de Selemene fue erigido en ese " +
                                "mismo lugar. El Templo de Mene también fue construido más tarde en el bosque." +
                                "\n" + "\n" +
                                "Cuando Vrogros, el Underlord emergió de la ciudad subterránea de Aziyog, " +
                                "anunció a Luna y Mirana sus intenciones de invadir y quemar los bosques " +
                                "de la Noche Plateada. Esto aún no se ha cumplido." +
                                "\n" + "\n" +
                                "La Horda de la Luna Oscura, en su deseo de provocar el cataclismo de la " +
                                "Luna Oscura, entró en el Bosque de la Noche Plateada y atacó el Templo de " +
                                "Mene mientras la Orden de la Luna Oscura estaba incapacitada. Fueron " +
                                "repelidos por los heroes exteriores que intervinieron para defender el " +
                                "santuario de la diosa." +
                                "\n" + "\n" +
                                "Aunque los habitantes de los Bosques de la Noche Plateada son tranquilos " +
                                "hoy en día, han tenido una complicada historia de política y violencia.";
                        break;
                    case "texto3":
                        hist = "Los lotos luminosos crecen en el bosque dentro de estanques plateados. " +
                                "Estos lotos se consideran sagrados para Selemene y están ferozmente " +
                                "protegidos de los ladrones por Mirana." +
                                "\n" + "\n" +
                                "Un gran número de bestias habitan el bosque, incluyendo Owlions, " +
                                "litigons y Nova, la montura de Luna. Un grifo también se encontró " +
                                "una vez en el Bosque de la Noche Plateada. Más tarde se convirtió en " +
                                "la montura de Mirana." +
                                "\n" + "\n" +
                                "Es probable que el bosque sea también el hogar de la sagrada Polilla " +
                                "Lunar, así como de su descendiente, la polilla felina.";
                        break;
                    case "texto4":
                        hist = "Sun Wukong a veces pasa los veranos en el Bosque de la Noche Plateada." +
                                "\n" + "\n" +
                                "Fymryn roba a veces los Lotos de la laguna para que Mene regrese.";
                        break;

                }
                break;

            case "Reino de Nothl":
                switch (tipo) {
                    case "texto1":
                        hist = "En el Reino de Nothl, las propiedades de todas las cosas del mundo " +
                                "terrenal se invierten. Pero la inversión más notable de este reino " +
                                "reside en su versión de la luz y la oscuridad. Su oscuridad emite un " +
                                "resplandor cegador que ilumina los tramos más negros de la luz que " +
                                "impregna el reino. Cualquier cosa que invada el Reino de Nothl se " +
                                "manifestará como una fuente de fortaleza en el plano material. Debido " +
                                "a sus elementos paradójicos y peligros inherentes un viaje espiritual a " +
                                "este reino puede ser muy angustioso y peligroso. Existe la posibilidad de " +
                                "que los espíritus de sus visitantes nunca retornen a su mundo de origen y " +
                                "algunos de sus visitantes pueden volver locos o con poderes procedentes del " +
                                "propio reino." +
                                "\n" + "\n" +
                                "El Reino de Nothl es una vida después de la muerte para aquellos que están " +
                                "profundamente conectados a él o sacrificados a él y un lugar de renacimiento " +
                                "(para aquellos que están profundamente conectados a él) en las tierras de los vivos." +
                                "\n" + "\n" +
                                "Se dice que Nullifier fue robado de una dimensión inversa, posiblemente " +
                                "refiriéndose al Reino de Nothl.";
                        break;
                    case "texto2":
                        hist = "Según Aghanim, los poderes de Dazzle son una mezcla de chakra y magia del caos, " +
                                "posiblemente refiriéndose a la magia del chakra de la Luz y a las energías caóticas " +
                                "de la Oscuridad. Dado que los poderes de Dazzle provienen del Reino de Nothl, " +
                                "es posible que Keeper of the Light y Chaos Knight tengan alguna conexión con este lugar." +
                                "\n" + "\n" +
                                "Dazzle afirma que su magia (que proviene del Reino de Nothl) invoca el poder de " +
                                "todos los reinos. Lo que esto significa exactamente es desconocido.";
                        break;
                    case "texto3":
                        hist = "Todos los acólitos de la Orden deben someterse al Rito de las Sombras, su último " +
                                "rito de iniciación, que implica un viaje espiritual al Nothl, para ser promovidos " +
                                "a las filas de los Sacerdotes de la Sombra. Si completan la iniciación oscura " +
                                "sin problemas se convertirán en Sacerdotes de la Sombra, vectores del poder " +
                                "de Nothl en el plano terrenal." +
                                "\n" + "\n" +
                                "Los acólitos experimentados de la Orden pueden llevar a cabo el rito de la " +
                                "Tumba Superficial, que impide la muerte de su destinatario por muy cerca " +
                                "que esté de la muerte. El ritual funciona preservando la más débil chispa " +
                                "de vida que queda en el corazón de un moribundo para reiniciarlo. Parece " +
                                "que la oscuridad de Nothl está detrás del poder del hechizo." +
                                "\n" + "\n" +
                                "La Ola de Sombra es el ritual más común entre las filas de los Sacerdotes " +
                                "de la Sombra gracias a su efectividad que proviene de su simplicidad. La " +
                                "versión de Dazzle de este ritual arroja una luz curativa que en realidad " +
                                "es un siniestro mal oculto." +
                                "\n" + "\n" +
                                "Bad Juju es el efecto secundario de cualquier ritual de Nothl. Cualquier " +
                                "invocación del poder de Nothl hace que el reino se filtre en nuestro mundo, " +
                                "infligiendo peligros desconocidos a los que ya están afligidos por sus rituales de Nothl.";
                        break;
                    case "texto4":
                        hist = "Las prendas que se tejen en completa oscuridad pueden canalizar la esencia " +
                                "del Reino de Nothl en su tejido. Debido a esta magia, se cree que los encantos " +
                                "de las prendas se hacen más fuertes a medida que envejecen. Estas prendas " +
                                "sagradas son veneradas por sus sagrados creadores y catalizadores de un mayor " +
                                "poder Nothl." +
                                "\n" + "\n" +
                                "El acceso al Reino de Nothl sólo es conocido por la Orden de Dezun, " +
                                "que guarda los secretos del acceso a la sombra etérea. Implica muchos " +
                                "métodos, uno de los cuales consiste en beber una poción sagrada hecha " +
                                "con ingredientes secretos. Otra forma de entrar incluye una dosis de la Gran Pipa.";
                        break;
                    case "texto5":
                        hist = "Dazzle es el héroe más joven en acceder al Reino de Nothl. El tiempo que pasó en el " +
                                "Reino de Nothl le ha otorgado una fuerte conexión con ese mundo, bendiciéndole con el " +
                                "poder de manejar sus elementos invertidos. Aprovechando su profunda conexión con este " +
                                "reino, suele visitar Nothl para sus experimentos, como convertir sus carencias en una " +
                                "fuente de fuerza." +
                                "\n" + "\n" +
                                "Huskar estuvo a punto de alcanzar su apoteosis cuando fue sacrificado voluntariamente " +
                                "al Reino de Nothl, pero fue dolorosamente rescatado por un profundo conjuro lanzado " +
                                "sobre él por Dazzle. Volvió con la casi inmortalidad y la capacidad de sacar fuerzas " +
                                "de sus heridas. Según Inai, el Nothl es un \"patio de recreo\" para Huskar." +
                                "\n" + "\n" +
                                "Mars conoce y entiende el reino de Nothl. Lo compara con una letrina, probablemente " +
                                "por la forma en que la gente (posiblemente no deseada) es arrojada a ella como sacrificio." +
                                "\n" + "\n" +
                                "Como guía de todo tipo de vida después de la muerte, el alcance de Visage " +
                                "se extiende al Reino de Nothl." +
                                "\n" + "\n" +
                                "La omnisciencia de Void Spirit abarca incluso el Reino de Nothl." +
                                "\n" + "\n" +
                                "Siltbreaker ha visto el Reino de Nothl y no está impresionado por lo que vio." +
                                "\n" + "\n" +
                                "La Orden de Dezun es la única facción mortal que conoce a fondo el Reino de Nothl y sus secretos.";
                        break;
                    case "texto6":
                        hist = "El shryll violeta es una especie de ave con una existencia que limita " +
                                "entre este mundo y Nothl. Sólo las puntas de sus alas cruzan la frontera " +
                                "hacia Nothl desde este mundo, haciendo que las puntas de sus plumas sean " +
                                "oscuras mientras el resto de su cuerpo blanco permanece en el Plano Terrenal." +
                                "\n" + "\n" +
                                "Una criatura dracónica de una sola ala fue capturada por Huskar, que la " +
                                "ha utilizado para sus propios fines. Es posible que esta criatura provenga " +
                                "de este reino o tenga algún tipo de conexión con él." +
                                "\n" + "\n" +
                                "En las selvas de Fellstrath, hay una especie de mariposa que puede extraer " +
                                "energías del Reino de Nothl utilizando su probóscide. Son ineficientes con " +
                                "su alimentación y cada pinchazo que hacen para alcanzar Nothl permite que " +
                                "su influencia se filtre al Plano Terrenal. Dazzle fue la primera persona " +
                                "en descubrir estas criaturas";

                }
                break;

            case "Revtel":
                switch (tipo) {
                    case "texto1":
                        hist = "Revtel es una nación, probablemente una ciudad-estado, poblada por Fae. Se " +
                                "encuentra cerca de Stonehall y White Spire.";
                        break;
                    case "texto2":
                        hist = "Sede de mercaderes y comerciantes, Revtel es conocida por su fabulosa " +
                                "riqueza y sus lujos. Al mismo tiempo sus tratos despiadados y su ambiente " +
                                "de carnicería son conocidos en todo el mundo. Se observan la etiqueta y " +
                                "los laboriosos rituales sociales, pero los asesinatos son habituales. " +
                                "Los habitantes de Revtel se entregan a los manjares, incluida la carne " +
                                "de los dragones de Pyrexae." +
                                "\n" + "\n" +
                                "Revtel está gobernada por tres reyes mercaderes: Kwerthias, el Heraldo " +
                                "de Cobre (the Brass Herald), y el padre de Mireska, de la familia Sunbreeze. " +
                                "Su hija, Mireska, se cansó de la vida en la ciudad, por lo que quemó la " +
                                "finca familiar y huyó de Revtel con Jex, su compañero wisp. Según Mireska, " +
                                "los gobernantes de Revtel eran de naturaleza tiránica.";
                        break;
                    case "texto3":
                        hist = "Las Hermanas del Velo han llevado a cabo acciones turbias en Revtel, " +
                                "probablemente asesinatos. Al principio, estos incidentes eran secretos, " +
                                "pero ahora se han difundido de boca en boca. Donte Panlin, al enterarse de " +
                                "los incidentes, advierte a Mortred que los gobernantes de Revtel estarían " +
                                "muy disgustados con las acciones de su orden." +
                                "\n" + "\n" +
                                "Gondar tiene tratos con los reyes mercaderes de Revtel, uno de los cuales " +
                                "puede ser traer a Mireska de vuelta a su padre.";
                        break;

                }
                break;

            case "Ruinas de Grietas Sombrías":
                switch (tipo) {
                    case "texto1":
                        hist = "Las Ruinas de Riftshadow son el emplazamiento de una antigua civilización. " +
                                "Se valora por sus esculturas y artefactos históricos. En este lugar hubo " +
                                "un gran palacio en el que se practicaban rituales oscuros con víctimas vivas. " +
                                "A los que sobrevivían a los rituales se les colocaba el alma en un cristal " +
                                "y se les hacía pedazos. Estos cristales se pueden encontrar ahora en las " +
                                "ruinas, y se conocen como cristales Riftshadow. Al menos un pueblo está " +
                                "cerca de las Ruinas de Riftshadow.";
                        break;
                    case "texto2":
                        hist = "Los artefactos de la antigua civilización de Riftshadow son de gran valor " +
                                "para los historiadores y coleccionistas. Los carroñeros, como Meepo, recogen " +
                                "tallas y esculturas de las ruinas y las venden en la ciudad a cambio de comida. " +
                                "En raras ocasiones, se puede encontrar un cristal de Riftshadow que es de " +
                                "especial interés para los magos. Meepo ha manipulado y destrozado accidentalmente " +
                                "uno de estos cristales, que dividió su alma de una en muchas." +
                                "\n" + "\n" +
                                "Además de vender baratijas, Meepo también se gana la vida contando historias " +
                                "sobre las Ruinas de la Grieta Sombría y guiando a los viajeros a través de " +
                                "sus desiertos. Aquellos que deseen conocer los secretos más recónditos de " +
                                "las ruinas deben dar una generosa propina a Meepo y mantener la boca " +
                                "cerrada sobre cualquier cosa que vean.";
                        break;
                    case "texto3":
                        hist = "En las Ruinas de Riftshadow habitan varios animales, entre ellos bestias " +
                                "peligrosas. Meepo cuenta que atrapa a los animales con redes y que a veces " +
                                "los mata para alimentarse. También se sabe que golpea su sartén para asustar " +
                                "a los animales con el ruido.";
                        break;

                }
                break;

            case "Basurero Centelleante":
                switch (tipo) {
                    case "texto1":
                        hist = "El Basurero Centelleante es una tierra desértica. Es probable que se " +
                                "encuentre al este del Desierto de la Anarquía. Las arenas del desierto " +
                                "son sensibles, tienen pensamientos e interactúan con el mundo exterior " +
                                "a través de su embajador, Crixalis. Es el hogar de varias especies de" +
                                " arácnidos. Las arenas movedizas pueden encontrarse en el desierto, y " +
                                "se han llevado a muchos exploradores. El reino de Qaldin está cerca." +
                                "\n" + "\n" +
                                "En el borde del Basurero Centelleante hay un enorme cráter, en el " +
                                "que se encontró la Fragua Solar. La antigua ciudad de El'Harath está " +
                                "probablemente en algún lugar del Basurero Centelleante.";
                        break;
                    case "texto2":
                        hist = "La zona oriental del Basurero Centellante se caracteriza por el calor " +
                                "extremo. Está habitada por artesanos, que forjan armas y artefactos de " +
                                "oro. Adoran a una diosa solar. Para combatir el calor, los lugareños " +
                                "llevan ropa de colores claros. Lina ha estado en Basurero Oriental y " +
                                "probablemente también Gondar.";
                        break;

                }
                break;

            case "Siete Infiernos":
                switch (tipo) {
                    case "texto1":
                        hist = "Los Siete Infiernos, también conocidos como las Regiones Infernales, " +
                                "son los reinos del inframundo, habitados principalmente por demonios. " +
                                "Los Siete Infiernos son conocidos por su calor extremo, y están separados " +
                                "por una membrana. Su ubicación exacta y sus nombres son inciertos y pueden" +
                                " solaparse con Vashundol, Foulfell y el Abismo. Los Siete Infiernos están " +
                                "gobernados por los Señores Demonios mediante una serie de leyes desconocidas." +
                                "\n" + "\n" +
                                "Doom posee una espada que puede cortar las membranas entre los infiernos.";
                        break;
                    case "texto2":
                        hist = "Los niveles se dividen por orden y a veces se denominan Infiernos " +
                                "exteriores, superiores e inferiores.\n" +
                                "Los niveles se dividen por orden y a veces se denominan Infiernos exteriores, " +
                                "superiores e inferiores." +
                                "\n" + "\n" + "\n" +
                                "Primer Infierno." +
                                "\n" + "\n" +
                                "Segundo Infierno.\n" +
                                "Foulfell. Una prisión eterna para los demonios que rompen la ley de los Siete Infiernos. " +
                                "Terrorblade escapó de Foulfell y obtuvo su poder al fusionarse con su yo de pesadilla " +
                                "en la prisión eterna." +
                                "\n" + "\n" +
                                "Tercer infierno." +
                                "\n" + "\n" +
                                "Cuarto Infierno." +
                                "\n" + "\n" +
                                "Quinto Infierno. \n" +
                                "Aquí se forjó una pieza de armadura de cola para Lucifer." +
                                "\n" + "\n" +
                                "Sexto infierno. \n" +
                                "Hogar de Maraxiform. Clinkz luchó contra Maraxiform en las puertas del sexto infierno." +
                                "\n" + "\n" +
                                "Séptimo infierno. \n" +
                                "El infierno más bajo. Lucifer reside aquí.";
                        break;

                }
                break;

            case "Palacio de Piedra":
                switch (tipo) {
                    case "texto1":
                        hist = "Stonehall es una gran ciudad que alberga varias organizaciones militares, " +
                                "entre ellas la Legión de Bronce. Un regimiento de élite de la guardia " +
                                "real también patrulla la ciudad. El emperador de Stonehall es el " +
                                "emperador Galanius. La metrópolis vertical White Spire, la nación " +
                                "Fae Revtel, y la ciudad más pequeña de Quath están cerca. Según algunos, " +
                                "Stonehall y su ejército se han visto envueltos en un innecesario derramamiento de sangre.";
                        break;
                    case "texto2":
                        hist = "Stonehall fue atacada por la Horda Abisal, liderada por Vrogos, el Underlord. " +
                                "Aunque Tresdin y la Legión de Bronce fueron capaces de repeler el ataque, " +
                                "la ciudad fue destruida en gran parte en el proceso.";
                        break;

                }
                break;

            case "El Horno":
                switch (tipo) {
                    case "texto1":
                        hist = "El Horno es un gran bosque situado en la base de las Colinas Sangrientas " +
                                "(Bleeding Hills). El bosque tiene aproximadamente mil leguas (4828 Km) " +
                                "de ancho, y está repleto de charcos de alquitrán negro, que bajan " +
                                "de las Colinas Sangrientas. En el bosque se encuentran árboles antiguos, " +
                                "cuya madera se utiliza a veces para fabricar escudos y armaduras.";
                        break;
                    case "texto2":
                        hist = "El Hoven está gobernado por el benévolo rey-mago Sutherex. Entre " +
                                "sus súbditos se encuentra Clinkz, un protector jurado de la tierra. " +
                                "Los trolls viven en cavernas subterráneas bajo The Hoven. Jah'rakal " +
                                "es de The Hoven, pero ahora vaga por el mundo.";
                        break;
                    case "texto3":
                        hist = "El demonio Maraxiform puso sus ojos en The Hoven, saliendo del sexto " +
                                "infierno para reclamar el dominio del bosque. Se encontró con Clinkz, " +
                                "que le hizo regresar a las puertas del infierno tras una larga batalla. " +
                                "Justo antes de su muerte, Maraxiform lanzó una descarga de fuego infernal, " +
                                "encendiendo los charcos de alquitrán del bosque y quemando vivo a Clinkz " +
                                "en el proceso. Sin embargo, al matar al demonio, Clinkz se había ganado sin " +
                                "querer el premio de Sutherex: la vida eterna. Y así, Maraxiform fue derrotado, " +
                                "y Clinkz continuó viviendo como un esqueleto, envuelto para siempre en el " +
                                "fuego del infierno.";
                        break;

                }
                break;

            case "Mundo Exterior":
                switch (tipo) {
                    case "texto1":
                        hist = "El Mundo Exterior es un lugar misterioso situado en algún lugar del " +
                                "borde del Vacío, que también se describe como \"El Mundo en el Borde del Abismo\". " +
                                "Este es el mundo natal de la raza a la que pertenece Harbinger y donde " +
                                "mantiene su vigilia, anticipando la llegada de las fuerzas del mal que " +
                                "fue predicha en la oscura música profética de su mente." +
                                "\n" + "\n" +
                                "Algunas descripciones relativas al Outworld implican fuertemente " +
                                "que es un cuerpo celestial, un planeta sólido o un plano de existencial. " +
                                "Según su único habitante, también puede ser descrito como el \"mundo inclinado\", " +
                                "lo que implica que este lugar está inclinado en el borde del abismo, " +
                                "orientado hacia el propio Vacío, por lo que siempre estará mirando " +
                                "(y observando) hacia él.";
                        break;
                    case "texto2":
                        hist = "La estructura cristalina es única en este reino, con una especie de " +
                                "árboles cristalinos augurales que son nativos del Outworld. El " +
                                "Outworld es rico en cristales que pueden producir poder arcano, " +
                                "lo que hace que esté inundado de grandes cantidades de energía arcana " +
                                "que tiende a difundirse a través de las \"grietas\" del Outworld " +
                                "Destroyer, lo que probablemente implica que el proceso restaura su " +
                                "maná. También existe un tipo de cristal de Outworld con la capacidad " +
                                "de autoensamblarse, lo que lo convierte en una excelente prisión " +
                                "improvisada. Si un cristal de Outworld se rompe, libera energías " +
                                "cataclísmicas que pueden sentirse interdimensionalmente.";
                        break;

                }
                break;

            case "Siete Planos":
                switch (tipo) {
                    case "texto1":
                        hist = "El universo de Dota 2 está dividido en siete planos de existencia, cada " +
                                "uno con sus propias características. Los seres físicos que atraviesan " +
                                "entre los planos están sujetos a una poderosa fricción que daña sus cuerpos." +
                                " Los espíritus que se pierden entre los planos acaban convirtiéndose en minerales." +
                                "\n" + "\n" +
                                "Desplazarse entre planos puede ser peligroso, ya que existen depredadores " +
                                "interdimensionales que acechan los rincones oscuros de la creación." +
                                "\n" + "\n" +
                                "Hay una red o costura que existe entre los mundos.";
                        break;
                    case "texto2":
                        hist = "Actualmente sólo se conocen cuatro planos por su nombre." +
                                "\n" + "\n" + "\n" +
                                "Plano Terrenal\n" +
                                "El plano en el que se desarrollan la mayoría de los eventos de Dota 2. " +
                                "Según Elder Titan, es el plano en el que se librará la batalla final. " +
                                "Este plano se considera una \"sombra\" del plano sin nombre del que " +
                                "procede Spirit Breaker. También se conoce como el Plano Físico o Mortal." +
                                "\n" + "\n" +
                                "Plano Astral\n" +
                                "El Espíritu Astral de Elder Titan proviene del Plano Astral." +
                                "\n" + "\n" +
                                "Plano Primordial\n" +
                                "Posiblemente el plano al que van las almas después de morir." +
                                "\n" + "\n" +
                                "Plano Fundamental\n" +
                                "El plano al que van los Fundamentales después de morir. \"Un plano " +
                                "lejano donde las leyes fundamentales del universo han encontrado una " +
                                "expresión sensible\"." +
                                "\n" + "\n" +
                                "Plano Elemental\n" +
                                "Posiblemente un plano de donde proviene Spirit Breaker." +
                                "\n" + "\n" +
                                "Foulfell\n" +
                                "Una dimensión oculta que a veces se describe como el \"plano de la prisión\". " +
                                "Es donde los demonios encarcelan a sus renegados." +
                                "\n" + "\n" +
                                "Plano Espectral \n" +
                                "Un plano sin nombre de donde se origina Mercurial. Se describe como un " +
                                "plano de emanaciones caóticas y poder violento.";
                        break;

                }
                break;

            case "Isla Temblorosa":
                switch (tipo) {
                    case "texto1":
                        hist = "La Isla Temblorosa es una isla rodeada de aguas traicioneras que " +
                                "forma parte de la nación de Claddish o de una isla cercana. En " +
                                "las aguas cercanas a la Isla Temblorosa tuvieron lugar dos batallas históricas.";
                        break;
                    case "texto2":
                        hist = "Se libró una batalla entre Kunkka y un oponente sin nombre. Kunkka " +
                                "salió triunfante y se llevó el sombrero del capitán derrotado como trofeo de guerra.";
                        break;
                    case "texto3":
                        hist = "En las cercanías se libró una gran batalla entre la Armada de Cladd de " +
                                "Kunkka y los Demonios de la Catarata. La Flota de Demonios lanzó una " +
                                "ofensiva total sobre la Isla Temblorosa, obligando a los Magos Suicidas de " +
                                "Cladd a realizar un gran ritual, invocando a los espíritus ancestrales " +
                                "para igualar las probabilidades. Sin embargo, en el clímax de la batalla, " +
                                "Tidehunter invocó al dios abisal Maelrawn, que destruyó ambas flotas en una " +
                                "tormenta de agua, viento y tentáculos. Se desconoce qué ocurrió exactamente " +
                                "durante esta tormenta. Tras ello la Catarata, abandonada por sus demonios, " +
                                "partió rugiendo hacia el vacío, mientras que la Armada de Claddish quedó " +
                                "reducida a un solo barco fantasma, todavía bajo el mando de Kunkka." +
                                "\n" + "\n" +
                                "Mireska estaba de polizón en el barco de Kunkka durante la lucha, en " +
                                "busca de trofeos. Al parecer, alteró la batalla de forma negativa para " +
                                "la armada claddish, aunque ella culpa a Tidehunter en su lugar. Por ello," +
                                " Kunkka sale a buscarla.";
                        break;

                }
                break;

            case "Estado Tyler":
                if ("texto1".equals(tipo)) {
                    hist = "El Estado Tyler es una misteriosa institución que trabaja para hacer cumplir " +
                            "las leyes mágicas y castigar a los infractores de las normas. Trabajan " +
                            "con el Quórum en el gobierno de Weeping Rose. Anti-Mage y Nortrom son " +
                            "empleados notables, trabajando para ellos en la captura de usuarios mágicos " +
                            "renegados como Mireska, al igual que el Censor del Estado Tyler, Votajo." +
                            "\n" + "\n" +
                            "En la finca se experimenta con los reclusos y, como resultado, " +
                            "se desarrollan objetos como el Witchbane.";
                }
                break;

            case "Archivos de Ultimyr":
                switch (tipo) {
                    case "texto1":
                        hist = "Los Archivos de Ultimyr son una extensa biblioteca perteneciente a la " +
                                "Academia de Ultimyr o Universidad de Ultimyr." +
                                "\n" + "\n" +
                                "Los archivos contienen muchos tomos de hechizos imposibles de traducir, " +
                                "así como bestiarios y tratados biológicos sobre clasificaciones de dragones. " +
                                "Un libro antiguo describe las curiosidades entomológicas del mundo, incluyendo " +
                                "la especie de escarabajos zelotes telepáticos, y el individuo único entre " +
                                "ellos conocido como Nyx Assassin. Los escarabajos zelotes son un tema de " +
                                "gran interés para los de Ultimyr y se ha encontrado una fuente de información " +
                                "potencial sobre esta especie más allá de las tierras de Ashkavor." +
                                "\n" + "\n" +
                                "Los archiveros han recuperado textos perdidos que contienen las representaciones " +
                                "más antiguas de Kaldr (Ancient Aparition), acompañadas de un texto ilegible " +
                                "escrito en una lengua extinta. Un hechicero sin nombre utilizó un conjuro de " +
                                "desciframiento para desvelar los misterios del texto, pero se volvió completamente " +
                                "loco como resultado. Se prohibió cualquier otro intento de descifrar el " +
                                "texto, manteniendo su conocimiento oculto para el mundo una vez más." +
                                "\n" + "\n" +
                                "Según el Tomo del Conocimiento, los Archivos de Ultimyr son los mayores " +
                                "archivos arcanos conocidos por los mortales. Esto sugiere que hay archivos " +
                                "aún mayores fuera de la posesión de los mortales.";
                        break;
                    case "texto2":
                        hist = "Warlock es el Guardián en Jefe de los archivos y Jefe de Adquisiciones. " +
                                "Es el custodio del contenido del archivo arcano y siempre está adquiriendo " +
                                "nuevos elementos de información (por ejemplo, libros, textos, tomos, " +
                                "incunables, etc.) para ampliar los archivos." +
                                "\n" + "\n" +
                                "Existe una junta de supervisores llamada apropiadamente Junta de Supervisores " +
                                "de Ultimyr. Al igual que Demnok, se encargan de adquirir nueva información " +
                                "para los archivos.";
                        break;
                    case "texto3":
                        hist = "Windranger visitó una vez los archivos para investigar sobre temas desconocidos." +
                                "\n" + "\n" +
                                "Rubick planea visitar pronto la Academia Ultimyr, probablemente para acceder a sus archivos.";
                        break;

                }
                break;

            case "Underscape":
                switch (tipo) {
                    case "texto1":
                        hist = "El Underscape es un reino al que van las almas después de morir. Está " +
                                "precedido por el Laberinto Estrecho, un sistema de corredores que clasifica " +
                                "las almas según su habilidad." +
                                "\n" + "\n" +
                                "Razor, el Relámpago Renacido, vive en el Underscape, y se considera un " +
                                "humilde servidor de algún poder desconocido. El Libro de los Muertos se " +
                                "guarda presumiblemente en algún lugar del Underscape. A medida que Razor " +
                                "pasa más tiempo en el mundo de la superficie, los poderes del Underscape " +
                                "comienzan a filtrarse inexplicablemente en su látigo, añadiendo un tinte " +
                                "oscuro a su habitual rayo.";
                        break;
                    case "texto2":
                        hist = "El Laberinto Estrecho es un complejo sistema de pasillos retorcidos por " +
                                "los que las almas recién fallecidas deben transitar antes de llegar al " +
                                "Inframundo. Al hacerlo, el Laberinto Estrecho clasifica las almas en " +
                                "función de su inteligencia, astucia y persistencia. Algunas almas salen " +
                                "a puntos de luz, mientras que otras salen a pozos oscuros. Las paredes " +
                                "del Laberinto Estrecho están revestidas de cuchillas afiladas. Algunos " +
                                "individuos bendecidos han vuelto a la vida desde el Laberinto Estrecho, " +
                                "aunque se desconoce cómo exactamente." +
                                "\n" + "\n" +
                                "El Libro de los Muertos es custodiado por Razor, que graba los nombres " +
                                "de los muertos en las páginas del libro, posiblemente utilizando sus " +
                                "poderes en lugar de métodos mundanos como la tinta.";
                        break;
                    case "texto3":
                        hist = "El Laberinto Estrecho está vigilado por numerosos guardianes. " +
                                "El más conocido es Razor, el Relámpago Renacido. Se cierne sobre los " +
                                "pasadizos y utiliza su látigo eléctrico para conducir a las almas hacia las salidas. " +
                                "Es portador de una máscara que tiene un mapa de los corredores escrito en su " +
                                "interior para que él pueda verlo. Aquellos que intentan resistirse a Razor y " +
                                "a los otros guardianes sin nombre del Laberinto Estrecho son arrojados " +
                                "al \"Intermedio\" (Herebetween), una especie de limbo en el que vagarán " +
                                "para siempre sin tener una vida después de la muerte. Los familiares de " +
                                "Visage también son conocidos como uno de los guardianes que vigilan el laberinto.";
                        break;
                    case "texto4":
                        hist = "Sun Wukong ha entrado y escapado del Laberinto Estrecho, donde borró su " +
                                "propio nombre y el de varios otros del Libro de los Muertos.";
                        break;

                }
                break;

            case "Meseta Violeta":
                switch (tipo) {
                    case "texto1":
                        hist = "La Meseta Violeta era una formación natural que albergaba laboratorios " +
                                "subterráneos para experimentos científicos de los Keen. Los Archivos " +
                                "Violeta se encontraban en la Meseta Violeta o en sus alrededores, y " +
                                "guardaban los registros de sus experimentos.";
                        break;
                    case "texto2":
                        hist = "El laboratorio subterráneo de la Meseta Violeta fue fundado por Boush. " +
                                "En la Meseta Violeta se investigaron armas. Un plano de armas mostraba " +
                                "un dispositivo focal que concentraba las energías psíquicas del portador " +
                                "en una ráfaga de energía penetrante. Algunos creen que es mejor que " +
                                "estos planos permanezcan perdidos.";
                        break;
                    case "texto3":
                        hist = "El equipo de investigación, incluido Boush, abrió accidentalmente un " +
                                "portal a un mundo diferente, provocando la entrada de criaturas alienígenas " +
                                "de pesadilla en este mundo. Una misteriosa niebla negra surgió del interior " +
                                "de la meseta, que ahora rodea y envuelve la formación en una oscuridad perpetua. " +
                                "De la meseta emanan extraños sonidos de otro mundo y desde entonces pocos la " +
                                "visitan. El laboratorio fue destruido en este suceso, siendo Boush el " +
                                "único superviviente que salió con vida. Él cree que es poco probable " +
                                "que haya otros supervivientes aunque le gustaría conocer a alguno algún día." +
                                "\n" + "\n" +
                                "Yurnero cree que Boush causó el incidente de la Meseta Violeta y es el " +
                                "responsable criminal de todas las muertes involucradas.";
                        break;
                    case "texto4":
                        hist = "Lanaya visitó sus ruinas más tarde, memorizando lo que quedaba de " +
                                "sus registros en los archivos. A pesar de la destrucción del " +
                                "laboratorio, los drones robóticos que se utilizaron en su día " +
                                "para la experimentación siguen siendo funcionales y pueden ser teledirigidos por Boush.";
                        break;
                    case "texto5":
                        hist = "";
                        break;

                }
                break;

            case "Rosa Llorona":
                if ("texto1".equals(tipo)) {
                    hist = "Weeping Rose es una ciudad mágica, envuelta por la noche perpetua. El " +
                            "Quórum gobierna sobre Weeping Rose y es conocido por conceder regalos y " +
                            "favores a cambio de un precio. En Weeping Rose se venden bienes valiosos, " +
                            "incluyendo libros raros y posiblemente incluso gorgonas." +
                            "\n" + "\n" +
                            "Mireska ha estado en Weeping Rose, pero fue expulsada por razones " +
                            "desconocidas. Ahora se esfuerza por volver y robar en Weeping Rose." +
                            "\n" + "\n" +
                            "Lion está buscando refugio en Weeping Rose y desea apelar al Quórum para " +
                            "que le conceda asilo. Se desconoce por qué lo desea. Donte Panlin le " +
                            "advierte que el Quórum no regala las cosas por nada." +
                            "\n" + "\n" +
                            "Akasha, la Reina del Dolor, visitó al príncipe demonio exiliado Knogh y " +
                            "a su maestra, la ocultista Vanessa, en Weeping Rose. Para asegurarse de " +
                            "que sus intereses pudieran estar representados en la Corte de Ristul, " +
                            "Knogh aceptó transferir su derecho de nacimiento a Akasha: formando la " +
                            "Eminencia de Ristul." +
                            "\n" + "\n" +
                            "Magina, Anti-Mage, y Nortrom, Silencer, han trabajado ambos para " +
                            "Tyler Estate, que hace cumplir las leyes mágicas en Weeping Rose. " +
                            "Cuando Turath lideró una fuga en la finca Tyler, Magina envió a su " +
                            "discípulo Wei a la ciudad de Weeping Rose para que acorralara y matara " +
                            "a los prisioneros fugados mientras él perseguía a Turath hasta White Spire";
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

    private void parrafos1() {

        texto1.setText(Historia(titpag, "texto1"));


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

    }

    private void parrafos2(String tit1) {

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

    }

    private void parrafos3(String tit1, String tit2) {

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
        texto6.setVisibility(View.GONE);

        layout4.setVisibility(View.GONE);
        layout5.setVisibility(View.GONE);

    }

    @SuppressLint("SetTextI18n")
    private void parrafos5() {

        texto1.setText(Historia(titpag, "texto1"));
        texto2.setText(Historia(titpag, "texto2"));
        texto3.setText(Historia(titpag, "texto3"));
        texto4.setText(Historia(titpag, "texto4"));
        texto5.setText(Historia(titpag, "texto5"));

        titulo1.setText("Descripción");
        titulo2.setText("Prisionero");
        titulo3.setText("Diosa Skadi");
        titulo4.setText("Relaciones");

        texto6.setVisibility(View.GONE);

        layout5.setVisibility(View.GONE);

    }

    private void parrafos6(String tit1, String tit2, String tit3, String tit4, String tit5) {

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
        titulo5.setText(tit5);

    }

    private void rel(String rel) {

        switch (rel) {
            case "heroe":
                layout_detrazas_rel_mundo.setVisibility(View.GONE);
                layout_detrazas_rel_razas.setVisibility(View.GONE);
                break;
            case "mundo":
                layout_detrazas_rel_heroes.setVisibility(View.GONE);
                layout_detrazas_rel_razas.setVisibility(View.GONE);
                break;
            case "raza":
                layout_detrazas_rel_heroes.setVisibility(View.GONE);
                layout_detrazas_rel_mundo.setVisibility(View.GONE);
                break;
            case "heroe_mundo":
                layout_detrazas_rel_razas.setVisibility(View.GONE);
                break;
            case "heroe_raza":
                layout_detrazas_rel_mundo.setVisibility(View.GONE);
                break;
            case "mundo_raza":
                layout_detrazas_rel_heroes.setVisibility(View.GONE);
                break;
            case "vacio":
                layout_detrazas_rel_heroes.setVisibility(View.GONE);
                layout_detrazas_rel_mundo.setVisibility(View.GONE);
                layout_detrazas_rel_razas.setVisibility(View.GONE);
                layout_rel_razas.setVisibility(View.GONE);
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

}