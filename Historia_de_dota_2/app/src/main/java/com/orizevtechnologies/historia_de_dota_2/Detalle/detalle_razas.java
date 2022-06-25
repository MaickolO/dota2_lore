package com.orizevtechnologies.historia_de_dota_2.Detalle;

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

public class detalle_razas extends AppCompatActivity implements RecyclerAdapter_rel_raza.RecyclerItemClick,
        RecyclerAdapter_rel_heroes.RecyclerItemClick_heroes, RecyclerAdapter_rel_mundo.RecyclerItemClick_mundo {

    private ImageView img_razas;
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
        setContentView(R.layout.activity_detalle_razas);

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

        mAdView = findViewById(R.id.adView_det_razas);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    private void initViews() {
        img_razas = findViewById(R.id.fondo_razas_detalle);
        tit_es = findViewById(R.id.titulo_espanol_detalle_razas);
        tit_en = findViewById(R.id.titulo_ingles_detalle_razas);

        texto1 = findViewById(R.id.det_razas_texto1);
        texto2 = findViewById(R.id.det_razas_texto2);
        texto3 = findViewById(R.id.det_razas_texto3);
        texto4 = findViewById(R.id.det_razas_texto4);
        texto5 = findViewById(R.id.det_razas_texto5);
        texto6 = findViewById(R.id.det_razas_texto6);

        titulo1 = findViewById(R.id.det_razas_titulo1);
        titulo2 = findViewById(R.id.det_razas_titulo2);
        titulo3 = findViewById(R.id.det_razas_titulo3);
        titulo4 = findViewById(R.id.det_razas_titulo4);
        titulo5 = findViewById(R.id.det_razas_titulo5);

        layout1 = findViewById(R.id.det_razas_layout1);
        layout2 = findViewById(R.id.det_razas_layout2);
        layout3 = findViewById(R.id.det_razas_layout3);
        layout4 = findViewById(R.id.det_razas_layout4);
        layout5 = findViewById(R.id.det_razas_layout5);

        layout_rel_razas = findViewById(R.id.layout_rel_razas);
        layout_detrazas_rel_razas = findViewById(R.id.layout_detrazas_rel_razas);
        layout_detrazas_rel_mundo = findViewById(R.id.layout_detrazas_rel_mundo);
        layout_detrazas_rel_heroes = findViewById(R.id.layout_detrazas_rel_heroes);

    }


    private void rel_razas() {

        //Relaciones Razas
        RecyclerView rvLista_razas_rel_razas = findViewById(R.id.recycler_view_razas_rel_razas);
        LinearLayoutManager manager_razas = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rvLista_razas_rel_razas.setLayoutManager(manager_razas);
        List<lista_relacionados> items = getItems_razas();
        RecyclerAdapter_rel_raza adapter_razas = new RecyclerAdapter_rel_raza(items, this);
        rvLista_razas_rel_razas.setAdapter(adapter_razas);

        //Relaciones Heroes
        RecyclerView rvLista_razas_rel_heroes = findViewById(R.id.recycler_view_razas_rel_heroe);
        LinearLayoutManager manager_heroes = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rvLista_razas_rel_heroes.setLayoutManager(manager_heroes);
        List<lista_relacionados> items_heroes = getItems_heroes();
        RecyclerAdapter_rel_heroes adapter_heroes = new RecyclerAdapter_rel_heroes(items_heroes, this);
        rvLista_razas_rel_heroes.setAdapter(adapter_heroes);

        //Relaciones Mundo
        RecyclerView rvLista_razas_rel_mundo = findViewById(R.id.recycler_view_razas_rel_mundo);
        LinearLayoutManager manager_mundo = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rvLista_razas_rel_mundo.setLayoutManager(manager_mundo);
        List<lista_relacionados> items_mundo = getItems_mundo();
        RecyclerAdapter_rel_mundo adapter_mundo = new RecyclerAdapter_rel_mundo(items_mundo, this);
        rvLista_razas_rel_mundo.setAdapter(adapter_mundo);

    }

    
    private List<lista_relacionados> getItems_razas() {

        List<lista_relacionados> lista_razas_es= new ArrayList<>();
        

        switch (titpag) {
            
            case "Centauros":
                break;

            case "Criaturas de las Oscuridad":
                break;

            case "Cocodrilianos":
                break;

            case "Demonios":
                break;

            case "Dragones (Sangre de Dragón)":
                break;

            case "Dragones":
                break;

            case "Drows":
                break;

            case "Eimermoles":
                break;

            case "Elementales":
                lista_razas_es.add(new lista_relacionados("Gigantes de Piedra", "Stone Giants", R.drawable.gigantes_piedra));
                lista_razas_es.add(new lista_relacionados("Estrellas", "Stars", R.drawable.estrellas));
                break;

            case "Elfos":
                break;

            case "Hadas":
                break;

            case "Dragones Faéricos":
                lista_razas_es.add(new lista_relacionados("Hadas", "Faerys", R.drawable.fae));
                break;

            case "Greevils":
                break;

            case "Arpías":
                break;

            case "Osos Infernales":
                break;

            case "Humanos":
                break;

            case "Keens":
                lista_razas_es.add(new lista_relacionados("Oglodis", "", R.drawable.oglodi));
                lista_razas_es.add(new lista_relacionados("Trolls", "", R.drawable.trolls));
                break;

            case "Kobolds":
                break;

            case "Leviatanes":
                break;

            case "Magnoceros":
                break;

            case "Enmascarados":
                break;

            case "Meranths":
                lista_razas_es.add(new lista_relacionados("Nagas", "", R.drawable.naga));
                lista_razas_es.add(new lista_relacionados("Slithereen", "", R.drawable.slardar));
                lista_razas_es.add(new lista_relacionados("Leviatanes", "Levianths", R.drawable.leviatanes));
                lista_razas_es.add(new lista_relacionados("Estrellas", "Stars", R.drawable.estrellas));
                break;

            case "Mushlings":
                break;
                
            case "Nagas":
                lista_razas_es.add(new lista_relacionados("Meranths", "", R.drawable.meranths));
                lista_razas_es.add(new lista_relacionados("Slithereen", "", R.drawable.slardar));
                lista_razas_es.add(new lista_relacionados("Leviatanes", "Levianths", R.drawable.leviatanes));
                break;
                
            case "Netherdrakes":
                break;
                
            case "Oglodis":
                lista_razas_es.add(new lista_relacionados("Keens", "", R.drawable.keen));
                lista_razas_es.add(new lista_relacionados("Trolls", "", R.drawable.trolls));
                break;
                
            case "Ogros":
                lista_razas_es.add(new lista_relacionados("Trolls", "", R.drawable.trolls));
                break;
                
            case "Merodeadores":
                lista_razas_es.add(new lista_relacionados("Centauros", "Centaurs", R.drawable.centauro));
                break;
                
            case "Dragones Pyrexae":
                lista_razas_es.add(new lista_relacionados("Dragones", "Dragons", R.drawable.dragones));
                break;
                
            case "Sátiros":
                break;
                
            case "Skywraths":
                break;
                
            case "Slithereen":
                lista_razas_es.add(new lista_relacionados("Leviatanes", "Levianths", R.drawable.leviatanes));
                break;
                
            case "Smeevils":
                break;
                
            case "Estrellas":
                break;
                
            case "Gigantes de Piedra":
                break;
                
            case "Titanes":
                break;
                
            case "Protectores Treant":
                break;
                
            case "Trolls":
                lista_razas_es.add(new lista_relacionados("Keens", "", R.drawable.keen));
                lista_razas_es.add(new lista_relacionados("Oglodis", "", R.drawable.oglodi));
                break;
                
            case "Ursine":
                break;
                
            case "Tejedores":
                break;
                
            case "Escarabajos Zealots":
                break;
        }


        return lista_razas_es;
    }


    private List<lista_relacionados> getItems_heroes() {
        List<lista_relacionados> itemLists= new ArrayList<>();

        switch (titpag) {

            case "Centauros":
                itemLists.add(new lista_relacionados("Bradwarden","Centaur Warruner",R.drawable.perfil_centaur));
                break;

            case "Criaturas de las Oscuridad":
                itemLists.add(new lista_relacionados("Balanar","Night Stalker",R.drawable.perfil_balanar));
                itemLists.add(new lista_relacionados("Valora","Dawnbreaker",R.drawable.perfil_dawnbreaker));
                itemLists.add(new lista_relacionados("Inai","Void Spirit",R.drawable.perfil_void));
                break;

            case "Cocodrilianos":
                break;

            case "Demonios":
                itemLists.add(new lista_relacionados("shadow Demon","Demonio Sombrío",R.drawable.perfil_shadow));
                itemLists.add(new lista_relacionados("Nevermore","Shadow Fiend",R.drawable.perfil_sf));
                itemLists.add(new lista_relacionados("Terrorblade","Demon Marauder",R.drawable.perfil_tb));
                itemLists.add(new lista_relacionados("Lucifer","Doom",R.drawable.perfil_doom));
                itemLists.add(new lista_relacionados("Tresdin","Legion Commander",R.drawable.perfil_legion_commander));
                itemLists.add(new lista_relacionados("Akasha","Queen of Pain",R.drawable.perfil_qop));
                itemLists.add(new lista_relacionados("Lion","Demon Witch",R.drawable.perfil_lion));
                itemLists.add(new lista_relacionados("Strygwyr","Bloodseeker", R.drawable.perfil_bloodseeker));
                break;

            case "Dragones (Sangre de Dragón)":
                itemLists.add(new lista_relacionados("Davion","Dragon Knight",R.drawable.perfil_dragon));
                break;

            case "Dragones":
                itemLists.add(new lista_relacionados("Davion","Dragon Knight",R.drawable.perfil_dragon));
                itemLists.add(new lista_relacionados("Jakiro","Twin Head Dragon",R.drawable.perfil_jakiro));
                itemLists.add(new lista_relacionados("Lina","Slayer",R.drawable.perfil_lina));
                itemLists.add(new lista_relacionados("Puck","Faerie Dragon",R.drawable.perfil_puck));
                itemLists.add(new lista_relacionados("Auroth","Winter Wyvern",R.drawable.perfil_ww));
                break;

            case "Drows":
                itemLists.add(new lista_relacionados("Traxex","Drow Ranger",R.drawable.perfil_drow));
                break;

            case "Eimermoles":
                break;

            case "Elementales":
                itemLists.add(new lista_relacionados("Kaldr","Ancient Aparition",R.drawable.perfil_ancient));
                itemLists.add(new lista_relacionados("Atropos","Bane Elemental", R.drawable.perfil_bane));
                itemLists.add(new lista_relacionados("Raigor Stonehoof","Earthshaker",R.drawable.perfil_shaker));
                itemLists.add(new lista_relacionados("Enigma","Consumer of worlds",R.drawable.perfil_enigma));
                itemLists.add(new lista_relacionados("Carl","Invoker",R.drawable.perfil_invoker));
                itemLists.add(new lista_relacionados("Leshrac","Tormented Soul",R.drawable.perfil_leshrac));
                itemLists.add(new lista_relacionados("Morphling","The Morphling",R.drawable.perfil_morphling));
                itemLists.add(new lista_relacionados("Phoenix","Fenix",R.drawable.perfil_fenix));
                itemLists.add(new lista_relacionados("Razor","Lightning Revenant",R.drawable.perfil_razor));
                itemLists.add(new lista_relacionados("Barathrum","Spirit Breaker",R.drawable.perfil_bara));
                itemLists.add(new lista_relacionados("Tiny","Stone Giant",R.drawable.perfil_tiny));
                itemLists.add(new lista_relacionados("Visage","Bound Form of Necro'lic",R.drawable.perfil_visage));
                itemLists.add(new lista_relacionados("Lyralei","Windranger",R.drawable.perfil_windranger));
                break;

            case "Elfos":
                break;

            case "Hadas":
                itemLists.add(new lista_relacionados("Mireska Sunbreeze","Dark Willow",R.drawable.perfil_willow));
                break;

            case "Dragones Faéricos":
                itemLists.add(new lista_relacionados("Puck","Faerie Dragon",R.drawable.perfil_puck));
                break;

            case "Greevils":
                itemLists.add(new lista_relacionados("Razzil Darkbrew","Alchemist", R.drawable.perfil_alchemist));
                break;

            case "Arpías":
                itemLists.add(new lista_relacionados("Lyralei","Windranger",R.drawable.perfil_windranger));
                break;

            case "Osos Infernales":
                break;

            case "Humanos":
                itemLists.add(new lista_relacionados("Magina","Anti-Mage", R.drawable.perfil_antimage));
                itemLists.add(new lista_relacionados("karroch","Beastmaster", R.drawable.perfil_beastmaster));
                itemLists.add(new lista_relacionados("Rylai","Crystal Maiden",R.drawable.perfil_crystal));
                itemLists.add(new lista_relacionados("Chen","Holy Knight",R.drawable.perfil_chen));
                itemLists.add(new lista_relacionados("Davion","Dragon Knight",R.drawable.perfil_dragon));
                itemLists.add(new lista_relacionados("Traxex","Drow Ranger",R.drawable.perfil_drow));
                itemLists.add(new lista_relacionados("Kunkka","Admiral",R.drawable.perfil_kunkka));
                itemLists.add(new lista_relacionados("Tresdin","Legion Commander",R.drawable.perfil_legion_commander));
                itemLists.add(new lista_relacionados("Lina","Slayer",R.drawable.perfil_lina));
                itemLists.add(new lista_relacionados("Luna","Moon Rider",R.drawable.perfil_luna));
                itemLists.add(new lista_relacionados("Yurnero","Juggernatur",R.drawable.perfil_jugg));
                itemLists.add(new lista_relacionados("Mirana","Princess of the Moon",R.drawable.perfil_mirana));
                itemLists.add(new lista_relacionados("Purist Thunderwrath","Omniknight",R.drawable.perfil_omniknight));
                itemLists.add(new lista_relacionados("Mortred","Phantom Assassin",R.drawable.perfil_pa));
                itemLists.add(new lista_relacionados("Pudge","Butcher",R.drawable.perfil_pudge));
                itemLists.add(new lista_relacionados("Nortrom","Silencer",R.drawable.perfil_silencer));
                itemLists.add(new lista_relacionados("Lyralei","Windranger",R.drawable.perfil_windranger));
                break;

            case "Keens":
                itemLists.add(new lista_relacionados("Rattlerap","Clockwerk",R.drawable.perfil_clockwerk));
                itemLists.add(new lista_relacionados("Boush","Tinker",R.drawable.perfil_tinker));
                itemLists.add(new lista_relacionados("Kardel Sharpeye","Sniper",R.drawable.perfil_sniper));
                itemLists.add(new lista_relacionados("Aurel","Gyrocopter",R.drawable.perfil_gyrocopter));
                itemLists.add(new lista_relacionados("Squee, Spleen y Spoon","Techies",R.drawable.perfil_techies));
                itemLists.add(new lista_relacionados("Rizzrack","Timbersaw",R.drawable.perfil_timber));
                itemLists.add(new lista_relacionados("Razzil Darkbrew","Alchemist", R.drawable.perfil_alchemist));
                itemLists.add(new lista_relacionados("Beatrix Snapfire","Snapfire",R.drawable.perfil_snapfire));
                itemLists.add(new lista_relacionados("Kunkka","Admiral",R.drawable.perfil_kunkka));
                break;

            case "Kobolds":
                break;

            case "Leviatanes":
                itemLists.add(new lista_relacionados("Leviathan","Tidehunter",R.drawable.perfil_tide));
                break;

            case "Magnoceros":
                itemLists.add(new lista_relacionados("Magnus","Magnoceros",R.drawable.perfil_magnus));
                break;

            case "Enmascarados":
                itemLists.add(new lista_relacionados("Yurnero","Juggernatur",R.drawable.perfil_jugg));
                break;

            case "Meranths":
                itemLists.add(new lista_relacionados("Slithice","Naga Siren",R.drawable.perfil_naga));
                itemLists.add(new lista_relacionados("Leviathan","Tidehunter",R.drawable.perfil_tide));
                itemLists.add(new lista_relacionados("Slardar","Slithereen Guard",R.drawable.perfil_slardar));
                itemLists.add(new lista_relacionados("Slark","Nightcrawler",R.drawable.perfil_slark));
                itemLists.add(new lista_relacionados("Sven","Rogue Knight",R.drawable.perfil_sven));
                break;

            case "Mushlings":
                break;

            case "Nagas":
                itemLists.add(new lista_relacionados("Slithice","Naga Siren",R.drawable.perfil_naga));
                break;

            case "Netherdrakes":
                itemLists.add(new lista_relacionados("Viper","Netherdrake",R.drawable.perfil_viper));
                itemLists.add(new lista_relacionados("Pugna","Oblivion",R.drawable.perfil_pugna));
                break;

            case "Oglodis":
                itemLists.add(new lista_relacionados("Mogul Khan","Axe", R.drawable.perfil_axe));
                itemLists.add(new lista_relacionados("Disruptor","Stormcrafter",R.drawable.perfil_disruptor));
                itemLists.add(new lista_relacionados("N'aix","Lifestealer",R.drawable.perfil_life));
                itemLists.add(new lista_relacionados("Demnok Lannik","Warlock",R.drawable.perfil_warlock));
                break;

            case "Ogros":
                itemLists.add(new lista_relacionados("Razzil Darkbrew","Alchemist", R.drawable.perfil_alchemist));
                itemLists.add(new lista_relacionados("Aggron Stonebreak","Ogre Magi",R.drawable.perfil_ogre));
                break;

            case "Merodeadores":
                itemLists.add(new lista_relacionados("Magnus","Magnoceros",R.drawable.perfil_magnus));
                itemLists.add(new lista_relacionados("Aiushtha","Enchantress",R.drawable.perfil_enchantress));
                itemLists.add(new lista_relacionados("Rooftrellen","Treant Protector",R.drawable.perfil_arbol));
                itemLists.add(new lista_relacionados("Luna","Moon Rider",R.drawable.perfil_luna));
                itemLists.add(new lista_relacionados("Banehallow","Lycan",R.drawable.perfil_lycan));
                break;

            case "Dragones Pyrexae":
                itemLists.add(new lista_relacionados("Jakiro","Twin Head Dragon",R.drawable.perfil_jakiro));
                break;

            case "Sátiros":
                break;

            case "Skywraths":
                itemLists.add(new lista_relacionados("Dragonus","Skywrarth Mage",R.drawable.perfil_sky));
                itemLists.add(new lista_relacionados("Shendelzare","Vengeful Spirit",R.drawable.perfil_venge));
                break;

            case "Slithereen":
                itemLists.add(new lista_relacionados("Slithice","Naga Siren",R.drawable.perfil_naga));
                itemLists.add(new lista_relacionados("Slardar","Slithereen Guard",R.drawable.perfil_slardar));
                itemLists.add(new lista_relacionados("Slark","Nightcrawler",R.drawable.perfil_slark));
                break;

            case "Smeevils":
                itemLists.add(new lista_relacionados("Clinkz","Bone Fletcher",R.drawable.perfil_clinkz));
                break;

            case "Estrellas":
                itemLists.add(new lista_relacionados("Ezalor","Keeper of the Light",R.drawable.perfil_keeper));
                itemLists.add(new lista_relacionados("Enigma","Consumer of worlds",R.drawable.perfil_enigma));
                itemLists.add(new lista_relacionados("Phoenix","Fenix",R.drawable.perfil_fenix));
                itemLists.add(new lista_relacionados("Valora","Dawnbreaker",R.drawable.perfil_dawnbreaker));
                break;

            case "Gigantes de Piedra":
                itemLists.add(new lista_relacionados("Tiny","Stone Giant",R.drawable.perfil_tiny));
                itemLists.add(new lista_relacionados("Raigor Stonehoof","Earthshaker",R.drawable.perfil_shaker));
                break;

            case "Titanes":
                itemLists.add(new lista_relacionados("Elder Titan","Worldsmith",R.drawable.perfil_titan));
                break;

            case "Protectores Treant":
                itemLists.add(new lista_relacionados("Rooftrellen","Treant Protector",R.drawable.perfil_arbol));
                itemLists.add(new lista_relacionados("Rizzrack","Timbersaw",R.drawable.perfil_timber));
                break;

            case "Trolls":
                itemLists.add(new lista_relacionados("Jah'rakal","Troll Warlord",R.drawable.perfil_troll));
                itemLists.add(new lista_relacionados("Rhasta","Shadow Shaman",R.drawable.perfil_ss));
                itemLists.add(new lista_relacionados("Dazzle","Shadow Priest",R.drawable.perfil_dazzle));
                itemLists.add(new lista_relacionados("Zharvakko","Witch Doctor",R.drawable.perfil_wd));
                itemLists.add(new lista_relacionados("Batrider","Batrider", R.drawable.perfil_batrider));
                itemLists.add(new lista_relacionados("Huskar","Sacred Warrior",R.drawable.perfil_huskar));
                break;

            case "Ursine":
                itemLists.add(new lista_relacionados("Ulfsaar","Ursa Warrior",R.drawable.perfil_ursa));
                itemLists.add(new lista_relacionados("Gondar","Bounty Hunter", R.drawable.perfil_bounty));
                break;

            case "Tejedores":
                itemLists.add(new lista_relacionados("Skitskurr","Weaver",R.drawable.perfil_weaver));
                break;

            case "Escarabajos Zealots":
                itemLists.add(new lista_relacionados("Nyx Assassin","Asesino de Nyx",R.drawable.perfil_nyx));
                itemLists.add(new lista_relacionados("Black Arachnia","Broodmother", R.drawable.perfil_broodmother));
                break;
        }

        return itemLists;
    }


    private List<lista_relacionados> getItems_mundo() {

        List<lista_relacionados> lista_mundo_es= new ArrayList<>();


        switch (titpag) {

            case "Centauros":
                lista_mundo_es.add(new lista_relacionados("Druud", "Druud", R.drawable.druud));
                break;

            case "Criaturas de las Oscuridad":
                lista_mundo_es.add(new lista_relacionados("Siete Planos", "Seven Planes", R.drawable.seven_planes));
                break;

            case "Cocodrilianos":
                break;

            case "Demonios":
                lista_mundo_es.add(new lista_relacionados("Aziyog", "Aziyog", R.drawable.aziyog));
                lista_mundo_es.add(new lista_relacionados("Foulfell", "Foulfell", R.drawable.foulfell));
                lista_mundo_es.add(new lista_relacionados("Siete Infiernos", "Seven Hells", R.drawable.seven_hells));
                break;

            case "Dragones (Sangre de Dragón)":
                break;

            case "Dragones":
                lista_mundo_es.add(new lista_relacionados("Archivos de Ultimyr", "Ultimyr Archives", R.drawable.archivos_ultimyr));
                lista_mundo_es.add(new lista_relacionados("Desierto de la Anarquía", "Desert of Misrule", R.drawable.desierto_misrule));
                break;

            case "Drows":
                break;

            case "Eimermoles":
                break;

            case "Elementales":
                lista_mundo_es.add(new lista_relacionados("Corazón de la Naturaleza", "Hearth of Nature", R.drawable.corazon_naturaleza));
                lista_mundo_es.add(new lista_relacionados("Siete Planos", "Seven Planes", R.drawable.seven_planes));
                break;

            case "Elfos":
                break;

            case "Hadas":
                lista_mundo_es.add(new lista_relacionados("Revtel", "Revtel", R.drawable.revtel));
                break;

            case "Dragones Faéricos":
                lista_mundo_es.add(new lista_relacionados("Claszureme", "Claszureme", R.drawable.claszureme));
                lista_mundo_es.add(new lista_relacionados("Templo Escondido", "Hidden Temple", R.drawable.templo_oculto));
                break;

            case "Greevils":
                break;

            case "Arpías":
                break;

            case "Osos Infernales":
                lista_mundo_es.add(new lista_relacionados("Revtel", "Revtel", R.drawable.revtel));
                break;

            case "Humanos":
                break;

            case "Keens":
                lista_mundo_es.add(new lista_relacionados("Knollen", "Knollen", R.drawable.knollen));
                lista_mundo_es.add(new lista_relacionados("Meseta Violeta", "Violet Plateau", R.drawable.violet_plateau));
                break;

            case "Kobolds":
                break;

            case "Leviatanes":
                break;

            case "Magnoceros":
                break;

            case "Enmascarados":
                lista_mundo_es.add(new lista_relacionados("Isla de las Máscaras", "Isle of Masks", R.drawable.isla_mascaras));
                break;

            case "Meranths":
                lista_mundo_es.add(new lista_relacionados("Arrecife Oscuro", "Dark Reef", R.drawable.arrecife_oscuro));
                break;

            case "Mushlings":
                break;

            case "Nagas":
                lista_mundo_es.add(new lista_relacionados("Arrecife Oscuro", "Dark Reef", R.drawable.arrecife_oscuro));
                break;

            case "Netherdrakes":
                lista_mundo_es.add(new lista_relacionados("Confines Infernales", "Nether Reaches", R.drawable.confines_infernales));
                break;

            case "Oglodis":
                lista_mundo_es.add(new lista_relacionados("Druud", "Druud", R.drawable.druud));
                lista_mundo_es.add(new lista_relacionados("Palacio de Piedra", "StoneHall", R.drawable.stonehall));
                break;

            case "Ogros":
                lista_mundo_es.add(new lista_relacionados("Fisura de Hielo", "Icewrack", R.drawable.icewrack));
                lista_mundo_es.add(new lista_relacionados("Palacio de Piedra", "StoneHall", R.drawable.stonehall));
                break;

            case "Merodeadores":
                break;

            case "Dragones Pyrexae":
                lista_mundo_es.add(new lista_relacionados("Revtel", "Revtel", R.drawable.revtel));
                break;

            case "Sátiros":
                break;

            case "Skywraths":
                break;

            case "Slithereen":
                lista_mundo_es.add(new lista_relacionados("Arrecife Oscuro", "Dark Reef", R.drawable.arrecife_oscuro));
                break;

            case "Smeevils":
                lista_mundo_es.add(new lista_relacionados("El Horno", "The Hoven", R.drawable.hoven));
                break;

            case "Estrellas":
                lista_mundo_es.add(new lista_relacionados("Rosa Llorona", "Weeping Rose", R.drawable.weeping_rose));
                lista_mundo_es.add(new lista_relacionados("Bosque de la Noche Plateada", "Nightsilver Woods", R.drawable.bosque_noche_plateada));
                break;

            case "Gigantes de Piedra":
                break;

            case "Titanes":
                break;

            case "Protectores Treant":
                break;

            case "Trolls":
                lista_mundo_es.add(new lista_relacionados("Knollen", "Knollen", R.drawable.knollen));
                lista_mundo_es.add(new lista_relacionados("El Horno", "The Hoven", R.drawable.hoven));
                break;

            case "Ursine":
                break;

            case "Tejedores":
                break;

            case "Escarabajos Zealots":
                lista_mundo_es.add(new lista_relacionados("Archivos de Ultimyr", "Ultimyr Archives", R.drawable.archivos_ultimyr));
                break;
        }


        return lista_mundo_es;
    }


    private void initValues(){

        String tit_igual;

        lista_relacionados itemDetail = (lista_relacionados) getIntent().getExtras().getSerializable("itemDetail");
        img_razas.setImageResource(itemDetail.getImg_principal());
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

            case "Centauros":
                parrafos5("Hábitat", "Fisiología", "Clanes", "Cultura");
                rel("heroe_mundo");
                break;

            case "Criaturas de las Oscuridad":
                parrafos2("Relaciones");
                rel("heroe_mundo");
                break;

            case "Cocodrilianos":

            case "Eimermoles":

            case "Elfos":

            case "Kobolds":

            case "Mushlings":

            case "Sátiros":
                parrafos1();
                rel("vacio");
                break;

            case "Demonios":
                parrafos5("Personalidad", "Señores Demonio", "Otros Demonios", "Poseídos por Demonios");
                rel("heroe_mundo");
                break;

            case "Dragones (Sangre de Dragón)":
                parrafos3("Clasificación", "Vínculo");
                rel("heroe");
                break;

            case "Dragones":
                parrafos5("Tipos", "Partes del Cuerpo", "Lista", "Relaciones");
                rel("heroe_mundo");
                break;

            case "Drows":
                parrafos3("Cultura", "Minería");
                rel("heroe");
                break;

            case "Elementales":
                parrafos4("Características", "Elementales Notables", "Posibles Elementales");
                rel("heroe_mundo_raza");
                break;

            case "Hadas":

            case "Smeevils":
                parrafos1();
                rel("heroe_mundo");
                break;

            case "Dragones Faéricos":
                parrafos4("Fisiología", "Cultura", "Relaciones");
                rel("heroe_mundo_raza");
                break;

            case "Greevils":

            case "Arpías":

            case "Humanos":

            case "Leviatanes":

            case "Gigantes de Piedra":

            case "Titanes":

            case "Protectores Treant":

            case "Tejedores":
                parrafos1();
                rel("heroe");
                break;

            case "Osos Infernales":
                parrafos6("Hábitat", "Fisiología", "Inteligencia", "Cultura", "Relaciones");
                rel("mundo");
                break;

            case "Keens":
                parrafos6("Fisiología", "Territorio", "Cultura", "Fuerza Militar", "Relaciones con Otras Razas");
                rel("heroe_mundo_raza");
                break;

            case "Magnoceros":
                parrafos2("Cultura");
                rel("heroe");
                break;

            case "Enmascarados":
                parrafos6("Hábitat", "Aparaciencia", "Máscaras", "Religión", "Manejo de la Espada");
                rel("heroe_mundo");
                break;

            case "Meranths":
                parrafos2("Cultura");
                rel("heroe_mundo_raza");
                break;

            case "Nagas":
                parrafos4("Ciudades", "Cultura", "Relaciones");
                rel("heroe_mundo_raza");
                break;

            case "Netherdrakes":
                parrafos3("hábitat", "Fisiología");
                rel("heroe_mundo");
                break;

            case "Oglodis":
                parrafos4("Historia", "Cultura", "Relaciones");
                rel("heroe_mundo_raza");
                break;

            case "Ogros":
                parrafos5("Fisiología", "Inteligencia", "Cultura", "Relaciones");
                rel("heroe_mundo_raza");
                break;

            case "Merodeadores":
                parrafos4("Hábitat", "Cultura", "Relaciones");
                rel("heroe_raza");
                break;

            case "Dragones Pyrexae":
                parrafos1();
                rel("heroe_mundo_raza");
                break;

            case "Skywraths":
                parrafos2("Política");
                rel("heroe");
                break;

            case "Slithereen":
                parrafos4("Fisiología", "La Guardia", "Cultura");
                rel("heroe_mundo_raza");
                break;

            case "Estrellas":
                parrafos6("Nacimiento", "Muerte", "Entidades Notables", "Relaciones", "Astronomía");
                rel("heroe_mundo");
                break;

            case "Trolls":
                parrafos6("Inteligencia", "Cultura", "Trolls Oscuros (Dark Trolls)", "Trolls Instigadores (Monger Trolls)", "Relaciones");
                rel("heroe_mundo_raza");
                break;

            case "Ursine":
                parrafos6("Hibernación", "La Edad Salvaje", "La Guerra Tribal", "Religión", "Relaciones");
                rel("heroe");
                break;

            case "Escarabajos Zealots":
                parrafos6("Descripción", "Castas", "La Colmena Oculta", "Alquimia", "Relaciones");
                rel("heroe_mundo");
                break;

        }
    }
    

    private String Historia(String nombre, String tipo) {

        String hist = "";

        switch (nombre) {

            case "Centauros":

                switch (tipo) {

                    case "texto1":
                        hist = "Los centauros son una raza de seres de cuatro patas. Seres como " +
                                "Leshrac o Magnus son similares a los centauros en apariencia, " +
                                "pero no se consideran centauros.";
                        break;
                    case "texto2":
                        hist = "Los centauros parecen ser una especie ampliamente distribuida. " +
                                "Algunos viven en las tierras de Druud mientras que otros viven " +
                                "en la masa terrestre donde se encuentran Roseleaf y Stonehall. " +
                                "Otros centauros parecen vivir cerca o dentro de los territorios " +
                                "forestales de los Ancestros.";
                        break;
                    case "texto3":
                        hist = "Los centauros no difieren mucho de los centauros de las obras de " +
                                "fantasía y mitología, pero tienen algunos rasgos distintivos. Por " +
                                "ello, un centauro puede no parecerse a otro." +
                                "\n" + "\n" +
                                "La parte inferior de su torso, que es la de un caballo, tiene una " +
                                "complexión variable que difiere de cada individuo. Algunos tienen " +
                                "cuerpos delgados mientras que otros tienen cuerpos fornidos. Algunos " +
                                "centauros tienen cuerpos totalmente coloreados con piel de color beige " +
                                "claro o azul. Algunos centauros pueden tener la piel de color beige " +
                                "claro para la parte superior del torso y de color marrón oscuro para " +
                                "la parte inferior. Los centauros más fuertes tienen pieles lo " +
                                "suficientemente gruesas como para desviar los ataques. A los centauros " +
                                "les puede crecer plumaje, el pelo largo que se puede ver en la parte " +
                                "inferior de las patas de algunas razas de caballos." +
                                "\n" + "\n" +
                                "La parte superior de sus torsos presenta algunos rasgos humanoides. " +
                                "También les puede crecer pelo (o vello facial en el caso de los machos) " +
                                "de diferentes colores, normalmente blanco o negro. A algunos centauros " +
                                "les crecen un par de cuernos que pueden tener un aspecto rizado o recto " +
                                "y que posiblemente se alargan cuando envejecen. Tienen orejas cortas " +
                                "y puntiagudas y pequeños colmillos que sobresalen de la mandíbula inferior. " +
                                "Aunque algunos centauros tienen rostro humanoides con los rasgos mencionados " +
                                "es posible ver que algunos centauros tienen narices cortas y negras (como " +
                                "las que se ven en los perros) en su cara.";
                        break;
                    case "texto4":
                        hist = "Los centauros de Druud están organizados en clanes de los cuales sólo " +
                                "uno es conocido por su nombre, los Cazadores de Marrowfell. Cada año, el clan " +
                                "de Marrowfell galopa hacia Roseleaf para anticiparse a la migración de los " +
                                "Thunderhides, escogiendo a los miembros más fuertes de la manada como trofeos. " +
                                "La caza es un rito sagrado para estos miembros del clan, y cualquier intento " +
                                "de impedirla no será recibido amablemente por los cazadores." +
                                "\n" + "\n" +
                                "Los clanes se formaron en la fundación del clan (Clanfounding), presidida " +
                                "por los ancianos Pezuña-Gris (Greyhoofs)." +
                                "\n" + "\n" +
                                "Los centauros de los clanes pueden encontrar extraños a los centauros de fuera, " +
                                "lo que sugiere una ruptura en la cultura.";
                        break;
                    case "texto5":
                        hist = "A pesar de no tener lenguaje escrito, música o religión formal, los centauros han desarrollado una sofisticada cultura en torno al combate que consideran un arte y la forma más elevada de expresión. Como grupo orgulloso de ser artistas de la muerte deben elegir sabiamente sus herramientas del arte. Las armas preferidas de los centauros son las hachas, las mazas, las alabardas y los mayales. Algunos centauros son también hábiles arqueros. De hecho, muchos centauros creen que el camino a la gloria está pavimentado con enemigos muertos. Trenzando sus colas antes de la batalla los centauros buscan que sus nombres sean recordados a través de la conquista." +
                                "\n" + "\n" +
                                "Los centauros participan en ritos de gladiadores reuniéndose en especialmente en la arena de Omexe, antiguo campo de entrenamiento donde los guerreros de los clanes han competido durante milenios. El campeón de esta competición recibe el Gran Cinturón de Omexe, que se lleva alrededor del torso. Su destinatario más reciente es Bradwarden, el Centauro Corredor de Guerra (Centaur Warrunner), quien derrotó a todos los contrincantes hasta que sólo él quedó en pie en la arena. Además los vencedores en la arena tienen derecho a tomar las armas de cualquiera que venzan." +
                                "\n" + "\n" +
                                "El cuerno glorioso de Druud es una reliquia encantada que, al sonar, llama a todos los centauros de Druud a la batalla. Está cuidadosamente custodiado por Warruner y las defensas del clan." +
                                "\n" + "\n" +
                                "Un pueblo feroz y libre, los centauros prohíben a sus miembros llevar una silla de montar, ya que es un signo de servidumbre a otro, aunque se permiten, y se admiran, los elegantes caparisones.";
                        break;

                }
                break;

            case "Criaturas de las Oscuridad":

                switch (tipo) {

                    case "texto1":
                        hist = "Las criaturas de la oscuridad (también conocidas como criaturas de la sombra, criaturas de la noche, criaturas de la noche primordial) son una antigua raza de seres de la oscuridad en la historia de Dota 2." +
                                "\n" + "\n" +
                                "Night Stalker es una criatura nocturna.";
                        break;
                    case "texto2":
                        hist = "Void Spirit dice que Balanar debe respetarlo como su superior." +
                                "\n" + "\n" +
                                "A Dawnbreaker no le gustan las criaturas nocturnas y es posible que haya matado a algunas de ellas antes.";
                        break;

                }
                break;

            case "Cocodrilianos":

                if ("texto1".equals(tipo)) {
                    hist = "Los crocodilianos son seres reptilianos que habitan las selvas de Fellstrath. Se asemejan a cocodrilos erguidos de piel grisácea. Desde la caída del Imperio de Overgrown, los crocodilianos vagan ahora por sus ruinas en manadas. Parecen ser más inteligentes que los animales, ya que utilizan armas y magia.";
                }
                break;

            case "Demonios":

                switch (tipo) {

                    case "texto1":
                        hist = "Los demonios son una raza de seres vagamente definida en la historia de Dota 2. Habitan los Siete Infiernos y en una serie de reinos subterráneos, como el Abismo o Foulfell. La mayoría de los demonios hablan la lengua de Ozkavosh. Están gobernados por los Señores Demonios. Los criminales demoníacos son encarcelados en la dimensión oculta de Foulfell.";
                        break;
                    case "texto2":
                        hist = "Los demonios son muy engreídos, egoístas y egocéntricos. Carecen de conciencia y están más que dispuestos a traicionar a otros o a su propia especie para satisfacer sus necesidades." +
                                "\n" + "\n" +
                                "Según los comentarios de Void Spirit y Dawnbreaker, los demonios son criaturas de gran poder e inteligencia limitada.";
                        break;
                    case "texto3":
                        hist = "Doom\n" +
                                "Lucifer (o Lucifash en Ozkavosh) reina sobre los Siete Infiernos como uno de los tres Demonios soberanos con la capacidad de atravesar el plano material sin obstáculos. A pesar de esta habilidad, apenas se ocupa de los asuntos de los llamados \"No Infernales\" y \"Consortes Espectrales Menores\". Parece tener algún tipo de control sobre Nevermore (Shadow Fiend) y Shadow Demon, lo que indica que es el Señor Demonio supremo entre los tres." +
                                "\n" + "\n" +
                                "Shadow Fiend\n" +
                                "Entre los tres Señores Demonios conocidos, Shadow Fiend explota su habilidad de desplazamiento entre planos para viajar al plano material y cosechar almas para que caigan en el Abismo. Está bajo el control de Doom y Shadow Demon, lo que indica que es el más bajo de los tres Señores Demonios. Además de ser un Señor Demonio, también es uno de los tres señores actuales de la Corte de Ristul." +
                                "\n" + "\n" +
                                "Shadow Demon\n" +
                                "La encarnación misma de los peligros de la evocación demoníaca, el Demonio de las Sombras es único entre los Señores Demonio en el sentido de que no viaja al plano material por voluntad propia. En su lugar, se deja invocar al plano material por cualquiera que se atreva a invocar su presencia antes de destruir la mente del invocador y sustituirla por su propia esencia que le permite controlar al cultista descerebrado. En términos de jerarquía parece estar en el medio debido a que está bajo el mando de Doom y tiene a Shadow Fiend bajo su autoridad.";
                        break;
                    case "texto4":
                        hist = "Queen of Pain\n" +
                                "También conocida como Akasha, esta súcubo del sufrimiento fue invocada por primera vez en el plano material por los demonólogos encarcelados de la corte de Elze en respuesta a las promesas de libertad del masoquista Rey Eclesiástico de Elze. Esta súcubo personal fue atada con runas para infligir un dolor exquisito al rey durante sus momentos de ocio hasta que fue asesinado por sus súbditos por descuidar sus obligaciones, siendo libre de impartir sus tormentos a cualquiera que se dignara a observar. Es miembro de la Corte de Ristul, pero planea recuperar su posición de manos de su hermano B'Kor." +
                                "\n" + "\n" +
                                "Terrorblade\n" +
                                "Terrorblade es el Demonio Merodeador (Demon Marauder). Es temido incluso por su familia por realizar todo tipo de actos criminales en los Siete Infiernos. Encarcelado en el plano prisión de Foulfell y condenado a una terrible existencia de retorcida autocontemplación, Terrorblade contempló los muros fractales de Foulfell y vio su peor yo devolviéndole la mirada. En lugar de ello, consiguió controlar su demonio interior y rompió los muros de la prisión, quedando libre para aterrorizar a toda la creación." +
                                "\n" + "\n" +
                                "Maraxiform\n" +
                                "Este demonio es originario del Sexto Infierno y subió a las tierras de Hoven con la intención de conquistarlas. Luchó contra un mortal Clinkz hasta que fue expulsado a las puertas del propio Sexto Infierno. Maraxiform fue asesinado por Clinkz, pero no sin antes incinerar el cuerpo de su asesino y dejarlo incapaz de morir por la combinación de su fuego infernal perpetuo y un hechizo de inmortalidad que le fue lanzado a Clinkz al morir. Su cabeza es ahora utilizada como arco por Clinkz." +
                                "\n" + "\n" +
                                "Eztzhok\n" +
                                "Eztzhok es un demonio que recibe una parte de la sangre que Bloodseeker recolecta para sus dioses. Al principio, el sirviente de los Gemelos Desollados se limitaba a blandir un par de espadas demoníacas que se parecían a Eztzhok, pero luego sus rasgos empezaron a perfilarse en el rostro del propio Buscador de Sangre (Bloodseeker). Los Gemelos Desollados recuperaron a su leal sirviente del demonio, pero no sin sacrificio." +
                                "\n" + "\n" +
                                "Abzidian\n" +
                                "Abzidian, el herrero de los demonios, es famoso por haber creado el Filo del Demonio, una poderosa espada cuya hoja es un fragmento de Oro Radiant y su empuñadura está hecha de Direstone." +
                                "\n" + "\n" +
                                "Golem de Warlock\n" +
                                "El espíritu de este demonio fue convocado desde los Infiernos Exteriores y dentro del bastón de Dreadwood de Warlock, usándolo como catalizador para convocar su presencia en el plano material. Terrorblade parece estar familiarizado con el demonio de Warlock.";
                        break;
                    case "texto5":
                        hist = "Lion\n" +
                                "Su forma desfigurada es el resultado de una demonoplastia, el injerto de partes del cuerpo de un demonio en el suyo. Al fusionar la mano de su difunto compañero demoníaco en su brazo izquierdo, su cuerpo se transformó en algo irreconocible y, la transformación que no ha cesado desde ese momento, ha ido fusionando lentamente los aspectos de su difunto compañero demoníaco en su forma física e incluso en su magia." +
                                "\n" + "\n" +
                                "Bloodseeker\n" +
                                "Una vez fue poseído por el demonio Eztzhok hasta que los Gemelos Desollados consiguieron recuperarlo." +
                                "\n" + "\n" +
                                "Legion Commander\n" +
                                "Aunque no posee ningún rasgo demoníaco, su voz parece estar deformada y puede hablar Ozkavosh";
                        break;

                }
                break;

            case "Dragones (Sangre de Dragón)":

                switch (tipo) {

                    case "texto1":
                        hist = "Los dragones son las manifestaciones físicas de los Eldwurms.";
                        break;
                    case "texto2":
                        hist = "Todos los dragones de la historia de Sangre de Dragón se clasifican según las cuatro fuerzas fundamentales y los cuatro elementos clásicos que pueden manipular." +
                                "\n" + "\n" +
                                "Para los elementos de la naturaleza, hay dragones de fuego, dragones de agua, dragones de aire y dragones de tierra." +
                                "\n" + "\n" +
                                "En cuanto a las fuerzas fundamentales, hay dragones del vacío, dragones iónicos, dragones luminosos (o de oro) y dragones del caos." +
                                "\n" + "\n" +
                                "También se clasifican por su edad, empezando por los dragones más jóvenes, más pequeños y más débiles, que se conocen como crías, wyrmlings (que son el equivalente a los dragones adolescentes), adultos y eldwurms, los dragones más viejos, más grandes, más dormilones y más poderosos." +
                                "\n" + "\n" +
                                "Independientemente de la etapa en la que se encuentren, son extremadamente letales, ya que Bram señala que incluso las crías pueden arrancarle la cara a un hombre adulto.";
                        break;
                    case "texto3":
                        hist = "Cuando un Dragón muere, un dragón debe matar al humano para vincular su sangre otorgando a un humano poderes desde respirar fuego hasta convertirse en un Híbrido Dragón/Humano a costa de un poco de cordura. Pero un Dragón también puede vincular su comunicación con otros dragones." +
                                "\n" + "\n" +
                                "Una visión superficial de estos dragones puede hacer pensar que son entidades distintas por sí mismas, pero no es el caso. Todos los dragones dentro de una misma especie elemental/fundamental son en realidad los avatares físicos de sus respectivos Eldwurms (nótese la \"E\" mayúscula que los diferencia de los eldwurms que sólo son dragones viejos), meras extensiones de la vasta encarnación del Eldwurm. Por ello, carecen de alma propia (de ahí su falta de conciencia y autoconciencia) hasta que un Eldwurm se encarna/reencarna en estos cuerpos sin alma.";
                        break;

                }
                break;

            case "Dragones":

                switch (tipo) {

                    case "texto1":
                        hist = "Los dragones son una o más razas relacionadas en la historia de Dota 2. Se pueden encontrar numerosas referencias a dragones, dracos, wyrms, eldwurms, wyverns y drakinds. Se desconoce cuál es la distinción entre estas descripciones. En los Archivos de Ultimyr se pueden encontrar libros que describen la clasificación de los dragones.";
                        break;
                    case "texto2":
                        hist = "Las razas más antiguas de dragones no tenían ojos y llevaban armaduras de hierro. Estos antiguos dragones aterrorizaron reinos en tiempos ya olvidados." +
                                "\n" + "\n" + "\n" +
                                "Dragones Marinos.\n" +
                                "Habitan en las profundidades del océano. Cuando se lucha contra un dragón el escudo es de suma importancia ya que los dragones siempre atacan primero. Los dragones son conocidos por acumular oro y tesoros." +
                                "\n" + "\n" +
                                "Dragones Lunares.\n" +
                                "Habitan en el lado oscuro de la luna." +
                                "\n" + "\n" +
                                "Razorwyrms.\n" +
                                "También pueden ser un tipo de dragón." +
                                "\n" + "\n" +
                                "Pyrexae Dragons. \n" +
                                "Están en sintonía con el fuego o el hielo." +
                                "\n" + "\n" +
                                "Netherdrakes.\n" +
                                "Pueden o no estar relacionados con los dragones." +
                                "\n" + "\n" +
                                "Dragones no muertos (Undead Dragons).\n" +
                                "Sus cuerpos están hechos de hueso y carne podrida." +
                                "\n" + "\n" +
                                "Wyrms del Desierto. \n" +
                                "Nativos del Desierto de Misrul.";
                        break;
                    case "texto3":
                        hist = "Muchos equipamientos se fabrican con partes del cuerpo de los dragones." +
                                "\n" + "\n" +
                                "A través de diversos medios, los humanos pueden recibir sangre de dragón, mezclándola con la suya propia. El ejemplo más conocido es Davion, el Caballero Dragón, aunque no es el único. Para algunos receptores de sangre de dragón, los efectos mágicos se magnifican y distorsionan, extrayendo poderes de todas las razas ancestrales de dragón. La sangre de dragón también puede utilizarse para preparar una potente bebida flamígera." +
                                "\n" + "\n" +
                                "La armadura de un caballero dragón a veces está hecha de dragones muertos y también mejora al usuario mágicamente, como Kaden." +
                                "\n" + "\n" +
                                "Las glándulas flamígeras (flameglands) de un dragón exhalan fuegos lo suficientemente fuertes como para forjar nuevas aleaciones y posiblemente acero de dragón. El fuego de dragón también se utiliza en el endurecimiento de vasijas para beber." +
                                "\n" + "\n" +
                                "La saliva de dragón se utiliza en la alquimia, pero necesita ser contenida con \"aleaciones especiales\", posiblemente debido a su naturaleza corrosiva." +
                                "\n" + "\n" +
                                "Los dientes de dragón se utilizan en la fabricación de sierras, capaces de cortar armaduras." +
                                "\n" + "\n" +
                                "Las garras de dragón se utilizan para fabricar ganchos." +
                                "\n" + "\n" +
                                "Las escamas de dragón también se pueden utilizar para escalar la montaña cerca de Dragon Hold." +
                                "\n" + "\n" +
                                "La columna vertebral de un dragón rojo se utiliza para fabricar espadas.";
                        break;
                    case "texto4":
                        hist = "Slyrak" +
                                "\n" + "\n" +
                                "Uldorak" +
                                "\n" + "\n" +
                                "Crimsom Wyvern" +
                                "\n" + "\n" +
                                "Vyxia" +
                                "\n" + "\n" +
                                "Auroth (Winter Wyvern)" +
                                "\n" + "\n" +
                                "Akakiryu" +
                                "\n" + "\n" +
                                "Omr" +
                                "\n" + "\n" +
                                "Ambinderath";
                        break;
                    case "texto5":
                        hist = "Los sapos dragón están lejanamente relacionados con los dragones";
                        break;

                }
                break;

            case "Drows":

                switch (tipo) {

                    case "texto1":
                        hist = "Los drow son una raza diminuta que habita en los bosques. De baja estatura y físicamente repulsivos, los drow están cubiertos de verrugas y toscos bigotes. Valoran el silencio, el sigilo y la sutileza; se sabe que ayudan a los extraños que lo necesitan. Drow Ranger fue adoptada por las Drow después de que sus padres fueran asesinados por bandidos. Algunas drow pueden adoptar otras formas, conocidas por otros como mutantes. Los Drow del Norte, una variedad de su raza, viven cerca de las regiones árticas.";
                        break;
                    case "texto2":
                        hist = "Los Drow tienen cierto conocimiento de la magia y disponen de medios para silenciar los conjuros. Drow Ranger adora a cierto espíritu búho, quizás aprendido de los Drow." +
                                "\n" + "\n" +
                                "Los drow cuidan de los Árboles de Raíz de Sangre en las cavernas sagradas, lugares sagrados de terribles batallas que determinaron el destino de todos los Drow. Estos árboles están fuertemente vigilados y los intrusos que los perturban son asesinados. Sólo mediante una cuidadosa etiqueta y un ritual se pueden tomar partes del árbol para su uso.";
                        break;
                    case "texto3":
                        hist = "Los Drow tienen una cultura minera, extrayendo ciertos minerales, particularmente como el hierro de Pincher. Los Drow del Norte también extraen minerales de la sima, utilizándolos para crear armaduras.";
                        break;

                }
                break;

            case "Eimermoles":

                if ("texto1".equals(tipo)) {
                    hist = "Los eimermoles son una raza de seres parecidos a los topos que viven en entornos subterráneos. Son de color púrpura azulado con una franja de pelo blanco en el centro, y poseen una nariz en forma de estrella con muchos zarcillos carnosos." +
                            "\n" + "\n" +
                            "Son una raza tecnológicamente avanzada que emplea taladros mecánicos y maquinaria para excavar bajo la tierra. Se pueden encontrar equipos de Eimermoles en los túneles de Underhollow donde trabajan con luces y picos, posiblemente en una búsqueda para encontrar el raro queso Roshefort. Algunos Eimermoles se ganan la vida distribuyendo objetos bajo tierra." +
                            "\n" + "\n" +
                            "En el Abismo Esmeralda, los Eimermoles pueden ser los responsables de los gigantescos taladros que sobresalen del suelo y que son adorados por los Mushlings locales.";
                }
                break;

            case "Elementales":

                switch (tipo) {

                    case "texto1":
                        hist = "Los elementales son seres que están en total armonía o unidad con la naturaleza. Esta afinidad les permite controlar e invocar los numerosos elementos de la naturaleza a su antojo, dependiendo del elemento que representen.";
                        break;
                    case "texto2":
                        hist = "Como se ha dicho anteriormente, los elementales son completamente uno con la naturaleza. Esto significa que suelen encarnar el aspecto de la naturaleza que representan: encarnando la totalidad del elemento en sí, tomando prestados aspectos de la naturaleza en su forma o simplemente dando forma a su propio cuerpo a partir de un elemento específico. Esta encarnación les permite manipular sus respectivos elementos a su voluntad y todos sus poderes se centran en su propia afinidad elemental." +
                                "\n" +
                                "Algunos elementales pueden tener una existencia dimensional o la capacidad de cambiar de plano, lo que significa que existen en más de un plano de existencia o que pueden viajar libremente entre planos respectivamente. Suelen existir en el plano material para encarnar sus elementos mundanos y hacerse físicamente observables en las formas que vemos pero también existen en otro plano oculto que es etéreo o directamente de otro mundo. Entre los planos de existencia más destacados se encuentran el Plano Astral y el reino elemental.";
                        break;
                    case "texto3":
                        hist = "Ancient Aparition\n" +
                                "La Aparición Ancestral, cuyo verdadero nombre es Kaldr, es un elemental de hielo. Como elemental, puede manipular los aspectos fríos de la naturaleza, como las temperaturas heladas, los vientos cáusticos y las tormentas de hielo.\n" +
                                "Kaldr encarna el elemento hielo, pero el hielo y el frío actuales no son más que un eco de lo que realmente encarna. Se da a entender que en realidad encarna las gélidas temperaturas del universo, que pronto se enfriarán para dar paso a un acontecimiento llamado el Gran Equilibrio, en el que toda la materia se detendrá en sus frías garras.\n" +
                                "Además del plano material donde podemos observar su forma helada y su poder desvanecido, Kaldr existe fuera del tiempo en el frío vacío infinito que precede a la creación y que pronto sobrevendrá. \n" +
                                "El maestro de Kaldr es Enigma" +
                                "\n" + "\n" +
                                "Leshrac\n" +
                                "El Alma Atormentada fue una vez un filósofo mundano que se desvivió por encontrar el sentido de la existencia. Se transformó en un elemental tras encontrar la horrible verdad en el corazón de la naturaleza con los Cristales Cronópticos.\n" +
                                "Leshrac es único entre los elementales. La naturaleza con la que está alineado es escabrosa y vil, sus elementos son impuros y malignos. A diferencia de otros elementales que pueden controlar un solo elemento de la naturaleza, Leshrac puede manipular todos los elementos contaminados que se encuentran en su naturaleza. Además, puede manipular el espacio-tiempo a su alrededor.\n" +
                                "Es un ser dimensional que existe a medias en un plano de existencia y a medias en otro. Es posible que exista en el umbral entre el plano material y el plano de existencia donde encontró el corazón maligno de la naturaleza.\n" +
                                "No parece servir a ningún maestro pero a menudo invoca a las Impurezas como si fueran alguien/algo importante para él." +
                                "\n" + "\n" +
                                "Morphling\n" +
                                "Morphling es un elemental de agua que llegó al planeta en un cometa. Puede invocar el elemento acuático para arrastrar a sus enemigos y aplastarlos con la gran resistencia o rapidez del siempre cambiante elemento agua.\n" +
                                "Aunque no procede de este mundo, Morphling se ha hecho uno con las mareas de los océanos del planeta.\n" +
                                "Este elemental existe en el Plano Terrenal y en el Plano Astral a la vez lo que le permite causar daño en ambos niveles de existencia.\n" +
                                "Se dice que tiene un maestro desconocido y sin nombre, que estaba furioso con su desaparición y lo ha estado buscando por sí mismo y por medio de los Hijos de la Luz." +
                                "\n" + "\n" +
                                "Spirit Breaker\n" +
                                "Spirit Breaker, también conocido como Barathrum, es un ser elemental procedente del reino elemental. Ha tomado prestados los rasgos de las criaturas bovinas y simiescas del plano material para su avatar físico, una expresión externa de su fuerza, agilidad y astucia. Fuera de su forma física, Barathrum es una inteligencia elemental, lo que significa que su verdadera forma es en realidad una mente incorpórea, al igual que los Ancestros, que también se clasifican como intelectuales.\n" +
                                "Aunque no es evidente al principio, Barathrum está en armonía con los elementos a su manera. El símbolo que aparece cuando utiliza su Carga de Oscuridad (Charge of Darkness) es el signo de Tauro, que representa el elemento tierra en la astrología. El elemento está bien representado por su símbolo de Atributo de Fuerza y sus adornos de hierro, magnetos y cristales; todos los cuales pertenecen a la tierra. Al igual que su compañero elemental Leshrac también puede manipular el tejido de la realidad a su alrededor.\n" +
                                "Barathrum es un caminante astral. Proviene del reino elemental y se ha trasladado al plano material del que se dice que es una sombra anterior.\n" +
                                "Sirve a un maestro oculto." +
                                "\n" + "\n" +
                                "Espiritu Forjado (Forged Spirit)\n" +
                                "El Espíritu Forjado es un elemental que se conjura invocando los poderes de Quas y Exort." +
                                "\n" + "\n" +
                                "Los Espíritus Forjados encarnan las propiedades de los elementos que los crean. De Quas encarnan sus propiedades de terquedad, tenacidad y fortaleza que conforman su durabilidad y permanencia, la duración de su existencia. De Exort encarnan sus propiedades de fuerza, dureza y brutalidad que constituyen su capacidad de daño.\n" +
                                "Cualquiera que pueda invocarlos es considerado su maestro. Entre los maestros más destacados se encuentran Invoker y Culween." +
                                "\n" + "\n" +
                                "Goles y Gárgolas\n" +
                                "Los gólems y las gárgolas son, implícitamente, elementales, según la biografía de Earthshaker." +
                                "\n" + "\n" +
                                "Gigantes de Piedra\n" +
                                "Los Gigantes de Piedra pueden ser un tipo de elemental." +
                                "\n" + "\n" +
                                "Elementales de Viento\n" +
                                "Los elementales del viento existen en la biografía de Windranger.";
                        break;
                    case "texto4":
                        hist = "Bane Elemental\n" +
                                "Bane, también conocido como Atropos, se denomina Bane Elemental. Abaddon también lo llama elemental, pero se desconoce si Bane representa algo en la naturaleza.\n" +
                                "Sin embargo nada, aparte de su título y la declaración de Abaddon, lo considera un elemental. Como mínimo, su encarnación proviene de la pesadilla de Nyctasha, la diosa del miedo. Dado que su forma proviene de la sangre divina de Nyctasha, también se dice que es la esencia del propio miedo." +
                                "\n" + "\n" +
                                "Earthshaker\n" +
                                "Earthshaker es la tierra misma dada forma mortal, parece calificar como un elemental siendo uno con la tierra y teniendo la habilidad de darle forma, pero las siguientes razones hacen su estatus ambiguo o anómalo como mínimo.\n" +
                                "Su biografía lo compara con especies elementales como los gólems y las gárgolas por ser uno con la tierra al igual que ellos. Luego procede a separarlo de estos elementales diciendo que no sirve a ningún amo a diferencia de la mayoría de los elementales.\n" +
                                "Además ha sido separado de su elemento debido a que ha tomado una forma de carne y hueso. Cuando finalmente muera, volverá a la tierra." +
                                "\n" + "\n" +
                                "Enigma\n" +
                                "Obviamente Enigma no es un elemental, pero cuando su \"modelo\" o \"forma\" se disuelva, volverá a la \" fuerza elemental \" para reencarnarse. Sin embargo, su subordinado Kaldr le llama elemental, lo que aumenta el misterio de la verdadera identidad de Enigma. \n" +
                                "También se refiere al oro como \"oro elemental\", línea reservada a los elementales como Leshrac. Puede referirse a la especulación de que Enigma es un alquimista universal que fue maldecido por su arrogancia. En la alquimia, el oro y los cuatro elementos de la naturaleza son temas importantes.\n" +
                                "Además de su naturaleza elemental, se ha alineado con los elementales en Dota Underlords." +
                                "\n" + "\n" +
                                "Phoenix\n" +
                                "Bristleback ha calificado a Fénix como elemental.\n" +
                                "El Fénix que conocemos no es más que una sombra de su forma real. Fénix es en realidad una estrella joven que ha adoptado una forma terrestre parecida a la de un pájaro de fuego.\n" +
                                "Más allá de la declaración de Bristleback, nada (todavía) sugiere que sea un elemental, además de encarnar la llama en forma de estrella." +
                                "\n" + "\n" +
                                "Razor\n" +
                                "Razor, el Relámpago Renacido, podría ser un elemental por las siguientes razones.\n" +
                                "En Dota Underlords, está clasificado como un Héroe Primordial, una alianza que incluye fuerzas de la naturaleza como los Fundamentales y los Elementales. Podría ser clasificado como este último con su alineación al rayo.\n" +
                                "Proviene del Laberinto Estrecho o de Underscape, que se da a entender que existe en un plano espiritual de la existencia. \n" +
                                "A pesar de estar atado al más allá, se ha desplazado fuera de esos lugares, algo que su maestro desaprueba.\n" +
                                "Su maestro es Visage." +
                                "\n" + "\n" +
                                "Tiny\n" +
                                "El estatus de Tiny como elemental es tan ambiguo como sus orígenes. La información que sigue se basa en las especulaciones del propio Tiny.\n" +
                                "Tiny especula que procede de una astilla del talón de un gólem o de una astilla del taller de un escultor de gárgolas. Ambas entidades se consideran elementales según la biografía de Earthshaker.\n" +
                                "También puede haber cobrado vida como un guijarro en el río, que es una parte natural del entorno. Earth Spirit afirma que fue hecho del suelo, que también es una parte natural del entorno.\n" +
                                "En Dota Underlords, está clasificado como un Héroe Primordial, una alianza que incluye fuerzas de la naturaleza como Fundamentales y elementales. Podría ser clasificado como este último con su alineación con la tierra." +
                                "\n" + "\n" +
                                "Visage\n" +
                                "El lore de Visage no lo clasifica explícitamente como elemental, pero es algo evidente en sus rasgos.\n" +
                                "La biografía de Earthshaker clasifica a las gárgolas como un tipo de elemental por ser uno con la tierra. Al ser una gárgola de piedra, también se le puede clasificar como tal.\n" +
                                "Esta gárgola procede del Laberinto Estrecho, que se supone que existe en un plano espiritual de la existencia. Sólo se desplaza fuera de este plano para capturar espíritus fugitivos que han logrado escapar de sus respectivas vidas posteriores.\n" +
                                "Su creador y maestro es Necro'lic.";
                        break;

                }
                break;

            case "Elfos":

                if ("texto1".equals(tipo)) {
                    hist = "Los elfos son una raza de personas en el lore de Dota 2. " +
                            "\n" + "\n" +
                            "En Dota Sangre de Dragón (Dota Dragon's Blood) son una raza ancestral que adora a Mene.";
                }
                break;

            case "Hadas":

                if ("texto1".equals(tipo)) {
                    hist = "Los Fae o Hadas son una raza de seres malévolos que viven en el Reino de los Fae. Se parecen a los insectos con alas y antenas. Los Fae son conocidos por ser intrigantes, poco fiables y pueden desaparecer en las sombras haciéndose invisibles." +
                            "\n" + "\n" +
                            "Algunos Fae viven en Revtel, una nación de intrigas retorcidas y tratos sin escrúpulos, donde son gobernados por reyes mercaderes como el padre de Mireska. La cultura Fae es traicionera y manipuladora, con complejos rituales y etiquetas que uno debe cumplir para permanecer en la sociedad respetable. A pesar de estas reglas, algunos Fae creen que es indecoroso morir de manera decorosa." +
                            "\n" + "\n" +
                            "Los Fae son conscientes del stuntwood, una enredadera parásita que mata a los árboles al absorber los nutrientes. La consideran una plaga y eliminan las enredaderas y los brotes en cuanto los ven.";
                }
                break;

            case "Dragones Faéricos":

                switch (tipo) {

                    case "texto1":
                        hist = "Los Dragones Faéricos son una raza que proviene de una dimensión diferente. Son neóticos y extremadamente longevos. El más conocido es el travieso Puck.";
                        break;
                    case "texto2":
                        hist = "Los dragones hada son pequeñas criaturas voladoras con seis extremidades prensiles y una cola que se bifurca en dos puntas rizadas. Se sabe que algunos individuos poseen colas brillantes creando un espectáculo de luz en vuelo que rara vez se ve. Tienen dos grandes ojos y varias antenas en la cabeza. Las alas son parecidas a las de los insectos y existen en un reino ligeramente desincronizado con el resto de su cuerpo lo que les permite mudar y cambiar de forma independientemente de su organismo. Ellos también contienen un polvo mágico que puede ser liberado a voluntad." +
                                "\n" + "\n" +
                                "Las larvas de los Dragones Hada llegan a la edad adulta en una crisálida antes de eclosionar en las frondas del Undertree. Esta incubación puede durar un millón de años, y un solo Dragón Hada puede sufrir varias metamorfosis. Al salir de sus pupas, las larvas se transforman en ninfas, que conservan rasgos juveniles. Los dragones de hadas rejuvenecen mediante la muda que puede cambiar su aspecto." +
                                "\n" + "\n" +
                                "La sangre de dragón hada es aparentemente rara, y se utiliza en la alquimia.";
                        break;
                    case "texto3":
                        hist = "Juguetones y traviesos por naturaleza, los Dragones Hada son conocidos por hacer trucos y contar bromas. Algunos son capaces de viajar a diferentes reinos y dimensiones, como Claszureme." +
                                "\n" + "\n" +
                                "Los Dragones Hada jóvenes se alimentan de las hojas, las raíces y los tallos del Undertree. Aparte de la materia vegetal, los Dragones Hada también pueden ser caníbales, consumiendo a sus propios hermanos para alimentarse." +
                                "\n" + "\n" +
                                "Los Pergaminos de Haize citados por Puck pueden ser de importancia cultural para los Dragones Hadas y afirman que la juventud conlleva responsabilidades." +
                                "\n" + "\n" +
                                "Los Dragones Hada pueden ser hostiles con los extranjeros. Aquellos que intentan observar su brillante vuelo en las noches sin luna suelen perder la vida en el proceso";
                        break;
                    case "texto4":
                        hist = "Los Dragones Feéricos pueden estar relacionados con los Fae y el Reino de los Fae y posteriormente comparten poderes similares. La Fae Mireska se queja de que Puck interfiere regularmente en sus asuntos y tanto ella como Puck son capaces de entender el lenguaje de Mercurial, la Espectro." +
                                "\n" + "\n" +
                                "Se sabe que los Dragones Faéricos visitan el Templo Oculto.";
                        break;

                }
                break;

            case "Greevils":

                switch (tipo) {

                    case "texto1":
                        hist = "Los Greevils son una raza en Dota 2. Algunos son conocidos por su codicia de oro.\n" +
                                "\n" + "\n" +
                                "Durante Diretide 2012, los jugadores recibían Huevos Greevil que podían imbuirse de Esencias y eclosionar en un mensajero Greevil personalizado. En Frostivus 2012, estos greevils recibían habilidades y se podía jugar con ellos en el modo de juego The Greeviling.";
                        break;

                }
                break;

            case "Arpías":

                switch (tipo) {

                    case "texto1":
                        hist = "Las arpías son una raza de humanoides femeninas aladas. Algunas arpías son capaces de hacer magia. Sus plumas son lo suficientemente resistentes como para servir de armadura.";
                        break;

                }
                break;

            case "Osos Infernales":

                switch (tipo) {

                    case "texto1":
                        hist = "Los osos infernales son una especie de criaturas ursinas bípedas del mundo de Dota 2.";
                        break;
                    case "texto2":
                        hist = "Aunque no es explícito, los osos infernales pueden vivir en Roseleaf, donde son cazados por los Cazadores de Marrowfell cada año. También se les ve en el Valle Aullante como una de las pocas criaturas que no se asustan por el conflicto entre Lucius Longclaw y su clan canino contra Bogdugg y los Ogros de Bonemeal.";
                        break;
                    case "texto3":
                        hist = "A pesar de su título de \"oso\", los osos infernales carecen de la mayoría de los rasgos físicos típicos de los osos. A diferencia de sus primos peludos, el único pelaje que tienen es el de las manos, que llega hasta los codos pero no cubre los antebrazos, y el de los pies. No tienen zarpas pero tienen tres grandes garras en los pies y manos prensiles. Estas manos son lo suficientemente fuertes como para romper espadas de metal con sus puños y crear ondas de choque con una palmada que puede arrojar a los enemigos más pequeños. Como todas las crías de animales, los cachorros de oso infernal son considerados como algo lindo." +
                                "\n" + "\n" +
                                "Lo que realmente los distingue de otras razas de osos es su cabeza. Al carecer de nariz tienen una gran boca lleno de grandes colmillos. Como su boca no tiene labios, sus encías y colmillos están expuestos. También tienen orejas largas y puntiagudas." +
                                "\n" + "\n" +
                                "Los osos infernales son de dos colores, amarillo y rojo. Por ello, se les llama en broma Patata y Tomate, respectivamente. Pero los osos infernales de Howling Weald tienen la piel azul o naranja claro.";
                        break;
                    case "texto4":
                        hist = "Los osos infernales son incapaces de hablar de forma inteligible porque se comunican con rugidos y gruñidos guturales. Sin embargo, un clan de osos infernales ha conseguido aprender a leer y escribir. También pueden sentir emociones complicadas como la ira por presenciar la muerte de un compañero, el disgusto por estar en cautividad o el sentimiento de alivio por haber sido curados de sus heridas." +
                                "\n" + "\n" +
                                "Los osos infernales alfa pueden afirmar su dominio sobre los osos infernales menores intimidándolos para que hagan algo lo que indica que los osos infernales son animales sociales.";
                        break;
                    case "texto5":
                        hist = "Su comportamiento animalista oculta su violenta historia. Hace mucho tiempo, hubo un gran levantamiento de osos infernales pero la insurrección fue sofocada con la invención de un arma simple pero poderosa.";
                        break;
                    case "texto6":
                        hist = "Lord Kwerthias de Revtel poseía una gran colección de animales exóticos como los osos infernales. Phantom Assassin fue enviada por su hermandad para asesinar a Kwerthias y lo hizo con éxito desatando a sus mascotas en el palacio. Los guardias estaban ocupados con las bestias furiosas y Mortred aprovechó la ocasión para degollarlo." +
                                "\n" + "\n" +
                                "En algún lugar de White Spire, Grek tiene una colección de animales salvajes para sus peligrosos espectáculos. Los osos infernales no son más que una de las muchas especies disponibles en su colección que despachó contra Anessix para impedir que se convirtiera en el próximo Underlord tras la muerte de Momma Eeb." +
                                "\n" + "\n" +
                                "Los osos infernales son cazados por los cazadores furtivos de la tribu Marrowfell. Para sus cazadores furtivos más hábiles incluso un centauro recién iniciado puede matar a un oso infernal, pero es mucho más impresionante matar a uno sin quedar herido.";
                        break;

                }
                break;

            case "Humanos":

                switch (tipo) {

                    case "texto1":
                        hist = "Los humanos son la raza predominante en Dota 2.";
                        break;

                }
                break;

            case "Keens":

                switch (tipo) {

                    case "texto1":
                        hist = "Los Keen o Keen Folk son una raza de pequeños humanoides que habitan una amplia zona del mundo conocido. Son inteligentes y tecnológicamente avanzados y compensan su debilidad física con la ciencia. La mayoría de los Keen rehúyen la práctica de la magia, prefiriendo desbloquear los poderes de la naturaleza mediante la experimentación racional.";
                        break;
                    case "texto2":
                        hist = "Los Keen son de pequeña estatura casi como los gnomos. Algunos, los Smallkeen son incluso más diminutos que sus primos. El vello facial es común entre los Keen y algunos son capaces de desarrollar un bigote completo en pocos días.";
                        break;
                    case "texto3":
                        hist = "La tierra natal de los Keen está, al menos parcialmente, bordeada por el mar ya que Kunkka llegó a las costas Keenish después de la segunda batalla de la Isla Temblorosa. Algunos Keen, incluyendo el pueblo de Kardel, viven en los valles montañosos de Knollen. También se conoce una rama de Keen de las tierras altas, aunque su ubicación precisa no está clara. Es probable que la Bahía del Augurio también estuviera poblada por Keen, especialmente Smallkeen." +
                                "\n" + "\n" +
                                "La tribu de los Vientos Escarchados puede estar compuesta por Keen. Su ubicación es desconocida pero probablemente sea el norte." +
                                "\n" + "\n" +
                                "Antes de su destrucción había un laboratorio Keen en la Meseta Violeta junto con los Archivos Violetas.";
                        break;
                    case "texto4":
                        hist = "La cultura Keen gira en torno a la ciencia y las armas de fuego. Cuando un padre Keen muere su arma se transmite a su hijo. Los Keen de Knollen cazan con sus rifles, tanto por deporte como por ritual. Entre los Keen de las tierras altas se espera que cada persona diseñe y construya su propio rifle." +
                                "\n" + "\n" +
                                "La ropa de los Keen es funcional, con cada pieza diseñada para contener munición. Los fusileros suelen llevar camuflaje para distorsionar el contorno del portador." +
                                "\n" + "\n" +
                                "Entre los Keen es conocido el hábito de fumar puros." +
                                "\n" + "\n" +
                                "Algunos Keen organizan carnavales de verano en los que se puede jugar y ganar premios.";
                        break;
                    case "texto5":
                        hist = "La nación Keen posee un ejército avanzado que ha luchado en guerras, disturbios y revoluciones. Un miembro conocido es Aurel, el Girocóptero." +
                                "\n" + "\n" +
                                "La flota de los Keen parece estar liderada por Kunkka, después de que éste llegara a las costas de los Keen. Los Keen tienen a Kunkka en alta estima, le dan las llaves de las puertas de la capital Keen y le forjan nuevas espadas. Los marineros Keen también tripulan la nueva flota de Kunkka.";
                        break;
                    case "texto6":
                        hist = "Los Oglodi suelen ser hostiles a los Keen ya que los consideran pequeños y físicamente débiles. Los Keen de Knollen son conocidos por disparar a los trolls y trolls como Jah'rakal desprecian abiertamente a los Keen.";
                        break;

                }
                break;

            case "Kobolds":

                switch (tipo) {

                    case "texto1":
                        hist = "Los kobolds son una raza humanoide de piel verde y cara de pájaro. No nacen con nombres, sino que los toman de la primera persona que matan";
                        break;

                }
                break;

            case "Leviatanes":

                switch (tipo) {

                    case "texto1":
                        hist = "Los leviatanes son una raza submarina de seres gigantes. Presumiblemente el único miembro conocido de la raza es Tidehunter Leviathan." +
                                "\n" + "\n" +
                                "Los leviatanes adoran a Maelrawn, dios de las profundidades. Para rendirle tributo, los Levianths asaltan los templos hundidos y la Bóveda Profunda (Deep Vault) en busca de tesoros lo que les hace entrar en conflicto con sus defensores, la Guardia Slithereen. En Crey, un ejército de leviatanes se enfrentó a las fuerzas de Slithice y fue rechazado. Sin embargo, después se encontró que faltaba un único cáliz que podría haber sido tomado por los leviatanes ." +
                                "\n" + "\n" +
                                "Los leviatanes llevan largas espadas de obsidiana, algunas de las cuales fueron abandonadas y recogidas por Slithice tras la batalla de Crey. ";
                        break;

                }
                break;

            case "Magnoceros":

                switch (tipo) {

                    case "texto1":
                        hist = "Los Magnoceroi (singular: Magnoceros) son una raza de cuadrúpedos peludos con un prominente cuerno único. Vivieron en los alrededores del monte Joerlak hasta su erupción, tras la cual se dirigieron al norte en busca de refugio. Según los maestros herreros del Monte Joerlak, los cuernos de los Magnoceroi son más valiosos que cualquier aleación. Esto llevó a los Magnoceroi a frecuentes y sangrientos encuentros con los cazadores.";
                        break;
                    case "texto2":
                        hist = "Los Magnoceros son notoriamente obstinados y no creen en el azar. Su cultura es matriarcal. Un día, los Magnoceros pretenden matar a los responsables de la erupción del monte Joerlak y reclamar su tierra natal. En la batalla los Magnoceros acribillan a sus enemigos con sus cuernos, los pisotean con sus pezuñas y los atraviesan con picas." +
                                "\n" + "\n" +
                                "Un Magnoceros sin nombre ayudó al Caballero del Terror (Dreadknight) en su intento de conquistar el reino de Ostarion, pero fracasó. Tras su muerte, su cráneo fue convertido en un pauldrón.";
                        break;

                }
                break;

            case "Enmascarados":

                switch (tipo) {

                    case "texto1":
                        hist = "Los Enmascarados son los nativos de la Isla de las Máscaras en el lore de Dota 2.";
                        break;
                    case "texto2":
                        hist = "Como ya se ha dicho, los enmascarados eran nativos exclusivamente de la Isla de las Máscaras. Es posible que también vivieran en las Islas de Marfil, que podrían estar situadas dentro de la isla.";
                        break;
                    case "texto3":
                        hist = "A juzgar por su único representante vivo, los enmascarados se distinguen por las máscaras talladas que llevan siempre sobre el rostro, que pueden llegar a cubrir toda la cabeza. El resto de su cuerpo tiene una apariencia bastante humanoide sin desviaciones como dedos de más." +
                                "\n" + "\n" +
                                "Lo que se esconde bajo las máscaras de estas extrañas personas es un misterio. Pero se sabe que sus máscaras son símbolos y expresiones de muchas cosas, desde aspectos de la personalidad del portador, símbolo de su estatus social, motivos ceremoniales, etc." +
                                "\n" + "\n" +
                                "El único rasgo conocido de su rostro son sus ojos inexpresivos pero el resto de su rostro bajo la máscara sigue siendo un misterio.";
                        break;
                    case "texto4":
                        hist = "Las máscaras son un aspecto central de la cultura de los Enmascarados, por lo que merecen una sección aparte. Sus máscaras se elaboran con madera de abedul o marfil antes de ser talladas y pintadas con un diseño único." +
                                "\n" + "\n" +
                                "Desde la gente común hasta los señores nobles, se da a entender que tener una máscara es un signo de que el honor de uno sigue intacto ya que se les despoja de ella si cometen un crimen deshonroso, como violar un credo establecido." +
                                "\n" + "\n" +
                                "Sus máscaras son símbolos y expresiones de muchas cosas. Incluso puede decirse que sus máscaras, en lugar de sus hipotéticos rostros, son una expresión de sí mismos. Una máscara puede capturar los aspectos de una entidad como la furia del portador durante la batalla, la astucia, el horror de las bestias alienígenas y los aspectos venerados de los animales. Las máscaras pueden expresar una variedad de mensajes como la intimidación." +
                                "Las máscaras también pueden significar el estatus social de uno: Una máscara ceremonial se otorga a aquellos que se han graduado como verdaderos maestros de la espada y las máscaras de la vergüenza se dan a los Ronin exiliados de la Isla." +
                                "\n" + "\n" +
                                "Incluso los animales están sujetos a esta tradición. Todas las bestias de carga, como los yaks, que sirven a otros en la batalla deben llevar una máscara del deber tres veces bendecida para obtener la condición de un noble animal mensajero.";
                        break;
                    case "texto5":
                        hist = "Mucho antes de su destrucción los adoradores solían viajar al Templo de las Máscaras para realizar diversos rituales y actividades de su fe. Ahora se ha perdido en las profundidades pero su único adorador restante aún mantiene su memoria en los ritos que sigue practicando incluso durante las batallas. El Rostro de la Venganza puede haberse conservado en este templo como uno de los muchos ídolos-máscaras que profesan sus visitantes." +
                                "\n" + "\n" +
                                "Los enmascarados son politeístas y rinden culto a un panteón del que sólo se conocen dos por su nombre. Estas deidades con nombre incluyen al Hacedor de Máscaras (Maker of Masks) y al Dios Jabalí (Boar God)." +
                                "\n" + "\n" +
                                "En la Isla, se dice que la muerte tiene muchos ojos vigilantes.";
                        break;
                    case "texto6":
                        hist = "El manejo de la espada es una de las culturas más destacadas de la Isla. Se da a entender que hay varias artes marciales en la Isla pero sólo una es conocida por su nombre, sus técnicas y su único practicante vivo. La larga tradición de los Juggernaut, una herencia que apuesta por el trabajo con la espada, se centra en la esgrima y los rituales. Cada técnica realizada es una expresión de sí mismo o una obra de arte." +
                                "\n" + "\n" +
                                "Hubo una vez una escuela olvidada de esgrima que existió mucho antes de la época de Yurnero, justo antes de la cúspide de la Isla de las Máscaras. La Orden Perdida, un grupo esotérico de ancianos hábiles con la espada metafísica, estableció una nueva escuela de Maestría. Los practicantes de esta escuela aprendieron la habilidad de perforar el tejido de la realidad con sus espadas y la transmitieron a sus discípulos al tiempo que registraban dichas técnicas en pergaminos. Pronto aprenderían que manipular el mundo natural tendría repercusiones más allá del campo de batalla. Para no invitar a que se produzcan consecuencias nefastas, de las que sabemos muy poco, los ancianos quemaron todos los pergaminos y mataron a todos sus discípulos antes de volver finalmente sus propias espadas contra ellos mismos.";
                        break;

                }
                break;

            case "Meranths":

                switch (tipo) {

                    case "texto1":
                        hist = "Los Meranths, también conocidos como Mer, son habitantes de los mares, probablemente compuestos por Slithereens, Nagas, Leviatanes y otros. Los Meranths están repartidos en una diáspora, cuyas tribus están constantemente en guerra por el territorio. La política de los Meranths es compleja y opaca para el mundo de la superficie, aunque mantienen tratados con las naciones del hombre." +
                                "\n" + "\n" +
                                "Sven es medio Meranth, ya que su madre era una \"Meranth Pálida\" (Pallid Meranth). Se desconoce qué distinción implica esto pero se supone que da una pista de una \"raza salvaje\" merantica aún no revelada según los Caballeros de la Vigilia. Dado el lugar de crianza de Sven, la raza de su madre puede ser común a las Ruinas de Shadeshore.";
                        break;
                    case "texto2":
                        hist = "La mitología de los Meranths buscan en la luna y en las estrellas sabiduría y guía." +
                                "\n" + "\n" +
                                "Los criminales de los Meranths son encerrados en la prisión del Arrecife Oscuro (Dark Reef).";
                        break;

                }
                break;

            case "Mushlings":

                switch (tipo) {

                    case "texto1":
                        hist = "Los Mushlings son una raza de seres parecidos a los hongos que viven en entornos subterráneos como el Abismo Esmeralda o Underhollow. Son un pueblo primitivo que va armado con lanzas de caza. Los Mushlings cazan y se alimentan de ajolotes y escarabajos que asan en el fuego. Se han observado algunos adorando taladros gigantes, posiblemente los de los Eimermole.";
                        break;

                }
                break;

            case "Nagas":

                switch (tipo) {

                    case "texto1":
                        hist = "Los Naga son una raza de seres acuáticos, con la parte superior del cuerpo humanoide y la inferior de serpiente. Al igual que otras razas submarinas se consideran Meranths. Los Naga también pueden considerarse parte de los Slithereen aunque parecen formar un subgrupo dentro de esa clasificación. A diferencia de los Slithereen como Slardar la mayoría de los Naga tienen una cabeza y unos rasgos faciales más humanos.";
                        break;
                    case "texto2":
                        hist = "Los naga viven en numerosas ciudades hundidas bajo las olas donde almacenan una gran riqueza de artefactos dorados en lugares como la Bóveda Profunda (Deep Vault). Tienen un elegante sentido de la estética y sus ciudades están revestidas de ornamentados pilares y estatuas blancas e iluminadas con mágicas lámparas brillantes.";
                        break;
                    case "texto3":
                        hist = "En las ciudades Naga se pueden ver monumentos a un ser parecido a una serpiente. Se desconoce qué representa este ser." +
                                "\n" + "\n" +
                                "Los naga no son ajenos a la guerra y empuñan tridentes, armas de asta y espadas gemelas en la batalla. Algunos forman la Guardia Slithereen donde respetan un estricto código de honor.";
                        break;
                    case "texto4":
                        hist = "Los Naga son aliados de los Profundos (Deep Ones) a los que defienden contra los ejércitos saqueadores de Leviatanes. En la batalla de Crey, Slithice y sus soldados fueron capaces de contener a un ejército invasor a costa de la pérdida de un solo artefacto. Una de sus ciudades limita con la peligrosa prisión del Arrecife Oscuro y es posible que los Naga tengan una relación conflictiva con sus habitantes, al igual que con Maelrawn, cuyo icono parece estar esparcido por la prisión.";
                        break;

                }
                break;

            case "Netherdrakes":

                switch (tipo) {

                    case "texto1":
                        hist = "Los Netherdrakes son una especie de criaturas dracónicas voladoras que son más conocidas por sus venenos y ácidos innatos." +
                                "\n" + "\n" +
                                "El Netherdrake más conocido es Viper, que fue capturado por el anciano Pugna con la esperanza de tenerlo como mascota. Viper acabó escapando y casi matando a Pugna con su veneno.";
                        break;
                    case "texto2":
                        hist = "La especie Netherdrake sólo puede encontrarse bajo tierra, en las cavernas luminosas de los Bajos Fondos que han quedado selladas del mundo de la superficie debido al desplazamiento de las placas tectónicas.";
                        break;
                    case "texto3":
                        hist = "Con su único miembro conocido como referencia, la piel de un Netherdrake tiene una textura correosa. Pueden excretar venenos hemotóxicos así como ácidos corrosivos de su cuerpo que pueden fundir el metal.";
                        break;

                }
                break;

            case "Oglodis":

                switch (tipo) {

                    case "texto1":
                        hist = "Los Oglodi son una raza de humanoides que habitan el mundo de Dota 2. Sus narices anchas y planas diferencian su raza de otros seres humanoides. Son conocidos por su fortaleza física y respetados por su fuerza. Los oglodi pueden ser de piel roja o clara y algunos son mucho más grandes que otros.";
                        break;
                    case "texto2":
                        hist = "Los Oglodi fueron una vez un pueblo pacífico y centrado en lo espiritual que practicaba el arte y la filosofía más que los conceptos de la guerra. Todo esto cambió cuando los Tarnsmen, un grupo de demonios que adoraban a un dios demoníaco de la guerra, destruyeron su gran ciudad. Los Tarnsmen asolaron la capital de los Oglodi pero pusieron fin a la guerra por capricho, porque estaban aburridos de luchar contra ellos. Los Oglodi estaban decididos a reconstruir su civilización desde las cenizas y juntos dejaron de lado sus costumbres artesanales para convertirse ellos mismos en guerreros. Crearon el ejército de la Niebla Roja y buscaron a los Tarnsmen en los Mil Tarns, masacrando a los adoradores de demonios y a su ciclópeo dios de la guerra. La gran cantidad de sangre derramada tiñó de rojo los lagos y la sangre del demonio se mezcló con la de los propios oglodis.";
                        break;
                    case "texto3":
                        hist = "Antes de la terrible tragedia que asoló a los Oglodi, fueron antaño artesanos del arte y la filosofía. En la actualidad la mayoría de los Oglodi son aficionados a la guerra y han formado ejércitos como el de la Niebla Roja (Red Mist) y el de la Sangre (Bloodmist). Están liderados por un Khan y son famosos por su brutal violencia y su tendencia a reaccionar violentamente incluso ante una simple sugerencia. Sin embargo, algunos Oglodi, como Demnok Lannik y Disruptor eligen el camino de la magia y la erudición en su lugar. Por esta razón, Grimstroke insinúa que los Oglodi podrían tener un repositorio oculto en algún lugar, posiblemente lleno de secretos.";
                        break;
                    case "texto4":
                        hist = "Los Oglodi desprecian a los Keen por su pequeña estatura y debilidad física. " +
                                "\n" + "\n" +
                                "El ejército de la Niebla Roja se enfrentó a la Legión de Bronce de Tresdin en Roseleaf lo que indica algún tipo de rivalidad con Stonehall." +
                                "\n" + "\n" +
                                "Se sabe que los Oglodi cazan Trolls, incluyendo a Jah'rakal.";
                        break;

                }
                break;

            case "Ogros":

                switch (tipo) {

                    case "texto1":
                        hist = "Los ogros son una especie ampliamente distribuida. Viven a lo largo de la Carretera Feral (Feral Road) donde a veces atacan a los viajeros que llegan. Una rama de ogros de la escarcha vive en el frío reino septentrional de Icewrack. El clan de ogros de Bonemeal vive en la Cresta de Bonemeal. Algunos de ellos también pueden vivir en los campamentos forestales entre los territorios de los Ancestros." +
                                "\n" + "\n" +
                                "Los más civilizados viven en Stonehall como tropas pesadas de la Legión de Bronce.";
                        break;
                    case "texto2":
                        hist = "Lo que les falta de inteligencia y agilidad lo compensan con su fuerza innata y su suerte de bobo. Los ogros son fácilmente reconocibles por su elevada complexión endomórfica y los dos prominentes colmillos que sobresalen de sus mandíbulas superior e inferior similares a los que se ven en los trolls. Con la ayuda de una tintura alquímica elaborada a partir de mohos y musgos un ogro fue capaz de escapar de una prisión gracias a su fuerza." +
                                "\n" + "\n" +
                                "El color de su piel varía entre el amarillo, el gris, el azul y el marrón anaranjado. Sus extremidades tienen una cantidad variable de dígitos.";
                        break;
                    case "texto3":
                        hist = "Los ogros no son criaturas muy inteligentes. Un ogro corriente puede confundir un tronco de árbol o una roca con sus hermanos lo que posiblemente explique la baja tasa de reproducción de la raza ogra. A menudo se visten con suciedad y no parecen comprender el concepto de vestimenta adecuada por lo que se cubren accidentalmente con pieles de animales que pueden arrojar sobre ellos mientras comen lanekill. Algunos ogros son tan ineptos que se dice que son incapaces de alimentarse correctamente. Hay algunos ogros más inteligentes que carecen de la ineptitud mencionada pero siguen siendo torpes en esencia." +
                                "\n" + "\n" +
                                "Sin embargo hay algunas excepciones. La más notable es Ogro Magi, que tiene la suficiente memoria e inteligencia para lanzar al menos dos hechizos, lo que le sitúa al nivel de un mago ordinario. Su magia y necedad ha llamado la atención de sabios como Warlock y Ember Spirit." +
                                "\n" + "\n" +
                                "También está el Ogro Frostmage, que puede lanzar un poderoso hechizo protector que rodea a un aliado con una capa invisible de aire helado.";
                        break;
                    case "texto4":
                        hist = "Aunque su escasa inteligencia diría lo contrario los ogros tienen una cultura. Se dice que los ogros de antaño eran grandes constructores y hábiles artesanos para los estándares ogros.";
                        break;
                    case "texto5":
                        hist = "Los ogros son carnívoros. Pueden comer Keen, Vhoul, caballos, murciélagos guana, creeps y cualquier otra cosa que se mueva. A veces cocinan su comida en guiso. Además de animales vivos pueden ser carroñeros y comer lanekill o comida mohosa. Los ogros no son vegetarianos." +
                                "\n" + "\n" +
                                "La raza de los ogros no adora a ningún dios ni es lo suficientemente inteligente como para comprender la noción de divinidad. Por ello, la Diosa de la Suerte se ha apiadado de toda la raza y los ha bendecido con la Suerte Tonta para ayudarles a superar los tiempos difíciles con buena fortuna. Sin embargo, su relación con la raza de los ogros es unilateral ya que ninguno de ellos parece rendirle culto o reconocerla, salvo el único ogro al que bendijo con dos cabezas." +
                                "\n" + "\n" +
                                "Los ogros y los trolls no se llevan bien." +
                                "\n" + "\n" +
                                "Se sabe que los centauros de Marrowfell cazan ogro";
                        break;

                }
                break;

            case "Merodeadores":

                switch (tipo) {

                    case "texto1":
                        hist = "Los Merodeadores se asemejan a la raza de los Centauros con sus torsos superiores humanoides y los inferiores cuadrúpedos. Lo que distingue a los Prowlers de ellos es su cabeza, que es la de un Sátiro, y sus extremidades con garras en lugar de pezuñas." +
                                "Son una especie bastante inteligente.";
                        break;
                    case "texto2":
                        hist = "Aunque no está exactamente implícito, los Prowlers viven en Roseleaf donde son vecinos de los treants y los Vhoul.";
                        break;
                    case "texto3":
                        hist = "Entre los Prowlers, el bosque es una morada importante para ellos. Son sus protectores y a su vez creen que el bosque les protege a ellos. Los Prowlers creen en una cantidad desconocida de dioses, que bendicen el bosque y a sus habitantes. Son un pueblo religioso, los Prowlers ven el poder en la creencia." +
                                "\n" + "\n" +
                                "Hay acólitos y chamanes entre las filas de la raza Prowler, lo que sugiere que tienen acceso a la magia.";
                        break;
                    case "texto4":
                        hist = "Magnus confió a los Prowlers la protección de una niña llamada Ilexa. Adoptaron a la niña sin palabras porque ambos sabían en qué se iba a convertir cuando creciera, por lo que debían mantener su crecimiento a salvo y sin obstáculos para que desarrollara su potencial." +
                                "\n" + "\n" +
                                "Están al lado de los protectores de Roseleaf, incluidos Treant Protector y Enchantress." +
                                "\n" + "\n" +
                                "Los Prowlers están con Rix y la rebelión de los Vhouls." +
                                "\n" + "\n" +
                                "Parecen estar en términos amistosos con Lycan y Luna por razones desconocidas." +
                                "\n" + "\n" +
                                "Como protectores de su tierra natal, el bosque de Roseleaf, los Merodeadores rechazan a los Cazadores de Marrowfell que se aprovechan de sus habitantes." +
                                "\n" + "\n" +
                                "La Vanguardia Prowler protege a Roseleaf de la presencia de la Horda de la Niebla Roja y de las facciones de los Ancestros.";
                        break;

                }
                break;

            case "Dragones Pyrexae":

                switch (tipo) {

                    case "texto1":
                        hist = "Los Dragones Pirexae son una raza de dragones. Su miembro más conocido es Jakiro. Según Inai, los Pyrexae son una raza sabia." +
                                "\n" + "\n" +
                                "Se sabe que los Pirexae se comen a los caballeros, con acero y todo, y guardan sus armaduras de metal en sus estómagos." +
                                "\n" + "\n" +
                                "Los ricos mercaderes de Revtel consideran la carne de Dragón Pyrexae como un gran manjar.";
                        break;

                }
                break;

            case "Sátiros":

                switch (tipo) {

                    case "texto1":
                        hist = "Los sátiros son una raza de seres parecidos a las cabras. Tienen cuernos, piel rosada y blanca y pelaje negro en el cuello y los brazos";
                        break;

                }
                break;

            case "Skywraths":

                switch (tipo) {

                    case "texto1":
                        hist = "Los Skywrath son una raza de seres parecidos a las aves. Se gobiernan desde la Aguilera Fatal (Ghastly Eyrie). Los Skywrath son expertos en magia y son capaces de realizar poderosos hechizos. Sin embargo son conocidos por ser malhumorados, se ofenden fácilmente y son vengativos. Los Skywrath adoran a Avilliva y quizás a Scree'auk.";
                        break;
                    case "texto2":
                        hist = "El Nido de Espinas (Nest of Thorns) es la sede del poder político de los Skywrath. Aquí se producen traiciones e intrigas mientras los vástagos de Skywrath intentan derrocar a sus rivales. Shendelzare, la primera en la línea de sucesión al trono, fue blanco de su hermana que envió asesinos para matarla. En la lucha Shendelzare perdió sus alas, lo que le impidió ascender al trono. Desde entonces, Shendelzare ha buscado los poderes de Scree'auk para recuperar lo que era suyo por derecho." +
                                "\n" + "\n" +
                                "A la actual reina de los Skywrath no le gusta Dragonus.";
                        break;

                }
                break;

            case "Slithereen":

                switch (tipo) {

                    case "texto1":
                        hist = "Los Slithereen son una raza submarina. Algunos miembros de la raza Slithereen forman parte de los Profundos (Deep Ones). Son similares a los Naga.";
                        break;
                    case "texto2":
                        hist = "Los Slithereen tienen la parte superior del cuerpo humanoide, con una parte inferior parecida a la de un pez y aletas en la cabeza a ambos lados. Algunos Slithereen poseen luces bioluminiscentes que cuelgan de sus cabezas. Acostumbrados a las profundidades marinas los Slithereen son sensibles a la luz. Sin embargo, pueden salir a la superficie y desplazarse por tierra. Los Slithereen también son capaces de recuperar rápidamente las extremidades perdidas.";
                        break;
                    case "texto3":
                        hist = "Los miembros de la raza Slithereen forman la Guardia Slithereen, una unidad de guerreros encargada de defender las Profundidades así como las ciudades hundidas y sus tesoros. Han luchado en la Batalla de la Puerta de Piedra (Stonefish Gate) así como en Crey.";
                        break;
                    case "texto4":
                        hist = "En ocasiones, los Slithereen cazan dragones de mar como deporte, y utilizan las partes de su cuerpo como armadura y armas." +
                                "\n" + "\n" +
                                "Los Slithereen se refieren a los seres de la superficie como \"terrertres\" (landlings)." +
                                "\n" + "\n" +
                                "La nobleza Slithereen lleva grandes crestas enjoyadas en la cabeza. La armadura que llevan los plebeyos suele ser de color claro y de color oscuro para los Slithereen en el exilio." +
                                "\n" + "\n" +
                                "Los criminales Slithereen son encerrados en la prisión del Arrecife Oscuro.";
                        break;

                }
                break;

            case "Smeevils":

                switch (tipo) {

                    case "texto1":
                        hist = "Los Smeevils son una raza de pequeños humanoides. Algunos pueden vivir en el Horno o en sus alrededores.";
                        break;

                }
                break;

            case "Estrellas":

                switch (tipo) {

                    case "texto1":
                        hist = "Las estrellas son una raza de seres cósmicos." +
                                "\n" + "\n" +
                                "Las estrellas son literalmente lo que uno esperaría que fueran, excepto que las estrellas en el lore de Dota 2 son formas de vida sensibles. Las estrellas son esferas luminosas en el espacio creadas por una fuerza débil, que se mantienen unidas por la gravedad, que también hace que se colapsen sobre sí mismas con el tiempo hasta que estallan en una supernova." +
                                "\n" + "\n" +
                                "El núcleo de una estrella, que es su corazón, es extremadamente caliente y rico en metales y minerales que pueden utilizarse en la forja, tanto si se trata de una estrella joven como de una estrella muerta. Su núcleo colapsado, puede emitir a menudo ráfagas de luz consciente de corta duración." +
                                "\n" + "\n" +
                                "Las estrellas poseen una esencia conocida como su chispa. Esta chispa es la que les permite crear y dar vida. Se supone que las estrellas más viejas pueden transmitir su chispa a sus descendientes.";
                        break;
                    case "texto2":
                        hist = "Las primeras estrellas nacieron del don del jinete de la Luz. En los primeros tiempos del universo, Ezalor utilizó su báculo para encender el calor del primer sol del universo y de otras innumerables estrellas similares. Esta estrella primordial no era sólo una enorme esfera de fuego sino una entidad consciente en sí misma." +
                                "A lo largo de un tiempo incalculable, la gravedad hizo que esta estrella se derrumbara sobre su núcleo, fusionando su incalculable energía, hasta que estalló en una supernova. Aunque esto marcó el final de la vida del primer sol fue un crisol para el nacimiento de muchas otras estrellas como ella. Los hijos del primer sol también estallarían en supernova pronto y este fenómeno de la supernova se repetirá hasta que el frío vacío del espacio brille con la luz y el calor de un sinfín de estrellas. Las propias estrellas se mueven por los oscuros cielos hechos por Elder Titan en busca de iluminación." +
                                "\n" + "\n" +
                                "Ezalor no era el único que podía crear estas estrellas. Al igual que dio vida y luz a las estrellas creó un caballo alado que compartía su capacidad de encender el calor de los soles.";
                        break;
                    case "texto3":
                        hist = "La gravedad interviene tanto en la creación como en la muerte de una estrella. Cuando una estrella muere, puede convertirse en una estrella oscura, fría y pasiva o simplemente desvanecerse en la nada.";
                        break;
                    case "texto4":
                        hist = "Fénix es una joven estrella errante, descendiente lejana del linaje del primer sol. Es único entre sus parientes solares que se contentan con encontrar su lugar en el cosmos y se asientan en las constelaciones. En cambio su curiosidad le llevó a descubrir la batalla de los Ancestros, lo que le impulsó a asumir la forma terrestre de un pájaro ardiente y a elevarse por el cosmos infinito para ayudar a los que necesitan su luz y buscar su destino solar." +
                                "\n" + "\n" +
                                "Dawnbreaker se forjó a partir del corazón de una joven estrella. Por ello, es la encarnación de su corazón." +
                                "\n" + "\n" +
                                "Los Hijos de la Luz son una gran facción de estrellas, fueron las primeras y más poderosas ramas del ahora extenso linaje del primer sol de Ezalor. Intentaron alinear a otras estrellas a su causa pero incluso las estrellas tienen políticas disonantes entre ellas. Por ello, enviaron a su heraldo Dawnbreaker para que destrozara a los rebeldes o los pusiera en su sitio." +
                                "El sol que brilla sobre el planeta en el que se estrellaron las Piedras Némesis es el responsable de la luz que se dice que tiene la luna de Selemene (no la Luna Loca). Es una estrella muy joven en relación con la edad de Dawnbreaker." +
                                "\n" + "\n" +
                                "La Estrella del Demonio puede verse entre las puntas de una luna creciente." +
                                "\n" + "\n" +
                                "Hay una estrella llamada Dragón, que tiene residuos plásmicos que pueden utilizarse para forjar armaduras.";
                        break;
                    case "texto5":
                        hist = "Keeper of the Light y Enigma son los dos Fundamentales responsables de la existencia de una estrella. Ezalor crea estrellas utilizando sus poderes de fuerza débil mientras que Enigma las crea fusionando los restos de una supernova. Este último también es responsable de su muerte mediante un supernova." +
                                "\n" + "\n" +
                                "La conexión de Mirana con las estrellas y los cuerpos celestes es muy íntima. Su devoción por la astrología le proporciona un conocimiento íntimo sobre las estrellas y los poderes que le otorga la diosa de la luna Selemene le acercan aún más a las propias estrellas." +
                                "\n" + "\n" +
                                "Oracle puede ver el futuro (o incluso los futuros) leyendo las constelaciones del cielo." +
                                "\n" + "\n" +
                                "El poder de Selemene depende en gran medida de las estrellas. Su control sobre el cielo nocturno le permite manipular sus características, como las constelaciones de estrellas que se ven mejor por la noche y los rayos de luz que producen." +
                                "\n" + "\n" +
                                "La Diosa Solar es una dilución de una línea mayor de progenie estelar" +
                                "\n" + "\n" +
                                "Las mitologías de las criaturas marinas suelen buscar la sabiduría y la orientación en la luna y las estrellas." +
                                "\n" + "\n" +
                                "El Bosque de la Noche Plateada fue santificado por un fragmento de origen estelar que cayó en el bosque. El Santuario de Selemene se construyó en torno a este lugar sagrado y el propio fragmento se convirtió en un arma sagrada de la Orden de la Luna Oscura, que ahora empuña Luna. Los que se adentran en el bosque son azotados por los rayos de luz estelar de Selemene." +
                                "\n" + "\n" +
                                "Weeping Rose está envuelta en una noche perpetua por lo que las estrellas del cielo nocturno son siempre visibles y están disponibles para que el Quórum aproveche su poder.";
                        break;
                    case "texto6":
                        hist = "Las estrellas son un tema importante que se estudia mediante campos de conocimiento relacionados con ellas y otros cuerpos celestes. Durante siglos, los sabios estetas de Keyturn estudiaron el movimiento de los cuerpos celestes desde su torreón de la montaña registrando sus disposiciones en el Libro de los Cielos. A través de estas observaciones descubrieron que la rueda del mundo era una cosa de muchas partes móviles, un reloj de ritmos extraños y métrica irregular. Estudiando la rueda de los cuerpos celestes contaron el número de amaneceres en cada estación y calcularon el día de la noche más larga. Puede decirse que fueron los primeros cronometradores de la historia, si es que no hubo nadie antes de ellos.";
                        break;

                }
                break;

            case "Gigantes de Piedra":

                switch (tipo) {

                    case "texto1":
                        hist = "Los Gigantes de Piedra son una raza de gigantes. En la antigüedad su civilización construyó grandes ciudades de piedra. Sus ciudades se han desintegrado, destruidas por un gran terremoto. Sólo queda un único pilar que ahora es utilizado como arma por Earthshaker.";
                        break;

                }
                break;

            case "Titanes":

                switch (tipo) {

                    case "texto1":
                        hist = "El titán más conocido era Elder Titan. Al perfeccionar sus habilidades destrozó algo que nunca pudo ser reparado, y cayó en su propio mundo roto. Ahora pasa la eternidad intentando reparar este error.";
                        break;

                }
                break;

            case "Protectores Treant":

                switch (tipo) {

                    case "texto1":
                        hist = "Los Treant Protectors son una raza antigua que se asemeja a grandes árboles móviles. Suelen estar ocultos entre el follaje y rara vez se les ve. Encargados de proteger su tierra y sus secretos, los Protectores son extremadamente longevos y notoriamente fieros en sus tareas. Debido a su longevidad, el tiempo parece pasar rápidamente para ellos, y la paciencia es una de sus virtudes naturales." +
                                "\n" + "\n" +
                                "Al igual que los árboles normales, los Treant Protectors poseen las mismas características vegetales. Consumen agua a través de sus raíces, que hacen las funciones de pies. La savia vital fluye a través de sus cuerpos que crecen y necesitan la luz del sol para alimentarse. Sin embargo, a diferencia de las plantas normales, parecen necesitar dormir.\n" +
                                "Debido a su aislamiento autoimpuesto, los Treant Protectors saben poco de las cosas del mundo exterior, como demuestra la confusión de Rooftrellen cuando se encuentra con oro y objetos." +
                                "\n" + "\n" +
                                "Jurados a defender a los indefensos, los Treant Protectors son capaces de extraer la vida de los intrusos y transferir su vitalidad a sus aliados. Sus raíces y zarcillos llegan a lo largo y ancho de donde emergen para escudar y rejuvenecer a los aliados. Como era de esperar, los Protectors temen las hachas, el fuego y a los héroes que los empuñan." +
                                "\n" + "\n" +
                                "El Protector más conocido es Rooftrellen, enviado por su especie para explorar el mundo e informar de cualquier amenaza que pueda poner en peligro su patria. Se desconoce su significado. Tampoco se sabe si los Treant Protectors están relacionados con los treants de Nature's Prophet. Rooftrellen puede invocar al Espíritu de la Naturaleza para liberar su poder causando un crecimiento excesivo de vides y raíces. Se desconoce si esta habilidad es exclusiva de él o está disponible para todos los Protectors." +
                                "\n" + "\n" +
                                "En general, se asume que los Treant Protectors atacaron Augury Bay destruyendo la ciudad y matando a sus habitantes. Una inundación precedió al ataque, durante el cual los ataques echaron \"raíces\" más allá de las murallas de la ciudad. Durante este ataque, fue revelado por Rizzrack que los Protectors estrangulaban a los residentes hasta la muerte con lianas y sus flores flotaban en las aguas liberando nubes tóxicas de polen. Es probable que Rooftrellen fuera el que identificara a Augury Bay como una amenaza y por eso llamó a los Protectors para que asaltaran la ciudad.";
                        break;

                }
                break;

            case "Trolls":

                switch (tipo) {

                    case "texto1":
                        hist = "Los trolls son criaturas humanoides que tienen formas corporales variadas, desde complexiones atléticas hasta físicos torcidos. Sus mandíbulas inferiores tienen dos colmillos que pueden o no sobresalir de las comisuras de sus bocas al igual que algunas especies de ogros. El tamaño de estos colmillos puede variar entre cada trol." +
                                "\n" + "\n" +
                                "Como especie, la cantidad de dedos que tienen puede variar entre cada troll. Los trolls pueden tener un mínimo de tres dedos, pero algunos pueden tener cuatro o incluso cinco. Esto también se aplica a los dedos de los pies, pero la cantidad de dedos que un troll puede tener no siempre es igual a la otra. Los trolls también tienen orejas puntiagudas y narices puntiagudas que apuntan hacia abajo." +
                                "\n" + "\n" +
                                "Dependiendo de la especie, los trolls pueden tener diferentes colores de piel. La piel de color verde se ve comúnmente en los trolls de las colinas y en los trolls oscuros, pero algunos trolls tienen la piel de color chartreuse. Jah'rakal tiene la piel de color rojo, algo que no se ha visto entre otros trolls.";
                        break;
                    case "texto2":
                        hist = "La inteligencia de los trolls puede variar entre las subespecies pero en general son seres bastante inteligentes. Son lo suficientemente inteligentes como para formar sociedades y enunciar correctamente sus respectivas lenguas. Algunos de los trolls más sabios tienen la inteligencia para utilizar la magia incluso a una edad temprana.";
                        break;
                    case "texto3":
                        hist = "La cultura de los trolls puede variar entre subespecies y poblaciones. Algunos trolls están más acostumbrados a la vida mundana de vivir en sociedades con sus propios parientes o con otras personas,pero algunos trolls son más esotéricos y arcanos. Los trolls pueden adaptarse rápidamente a diferentes culturas cuando se exponen a ellas el tiempo suficiente." +
                                "\n" + "\n" +
                                "A los trolls que se adentran en lo arcano, se les conoce comúnmente por utilizar la haruspiciencia, una forma de adivinación que implica la inspección de las entrañas y restos de seres vivos para ver el futuro.";
                        break;
                    case "texto4":
                        hist = "Los Trolls Oscuros son un grupo esotérico de trolls con la capacidad de resucitar a los muertos. Aunque se desconoce la ubicación exacta de su tierra natal, se puede suponer que viven en algún lugar de la masa terrestre donde se encuentra Stonehall. \n" +
                                "Se sabe que son habitantes del bosque pero un incendio forestal les ha llevado a abandonar su hogar. En respuesta el jefe de los Trolls Oscuros, J'Muy, condujo a los pocos trolls que quedaban en un éxodo hacia Weeping Rose donde busca una audiencia con el Quórum para que les conceda asilo. Los Trolls Oscuros pueden ser un grupo formado por una especie de trolls ya existente que sólo se diferencian por sus poderes nigrománticos o un tipo de troll completamente diferente.";
                        break;
                    case "texto5":
                        hist = "Los trolls instigadores son nativos de las tierras de Hoven, donde nacen y se crían en las guaridas subterráneas de sus padres. Se ofenden con facilidad y son poco amistosos con los demás llegando incluso a discutir con los de su propia especie con voces elevadas. Mucho después de haber superado la edad de la madurez se negarán obstinadamente a salir de sus cuarteles mientras se alimentan de las provisiones de sus padres hasta que se ven obligados a salir al mundo. A partir de ahí, forman manadas de trolls instigadores que participan en todo tipo de conductas indebidas.\n" +
                                "Jah'rakal, el Troll Warlord, es un troll instigador que fue considerado intolerable por su antigua banda. Fue golpeado y desterrado de su campamento pero volvió para matar a sus \"compañeros\" antes de convertirse en el troll que es hoy.";
                        break;
                    case "texto6":
                        hist = "Algunos Trolls viven en los valles montañosos de Knollen donde son hostiles con los Keen. Brag Sharpeye, el abuelo de Sniper, era conocido por disparar los dedos de los pies de los trolls desde grandes distancias." +
                                "\n" + "\n" +
                                "Beatrix Snapfire se ha encontrado con trolls antes con los que ha intentado ser amable pero siempre ha acabado mal." +
                                "\n" + "\n" +
                                "Los trolls son a veces cazados por los Oglodi pero no siempre con éxito.";
                        break;

                }
                break;

            case "Ursine":

                switch (tipo) {

                    case "texto1":
                        hist = "Los ursaianos son una raza de grandes seres con aspecto de oso. Viven en bosques salvajes bajo montañas heladas y son muy protectores de su territorio. Los ursa son un pueblo fuerte y recto, y las madres de los osos pueden ser muy feroces cuando protegen a sus crías. \n" +
                                "\n" +
                                "Ulfsaar es el único ursa conocido por su nombre. Presintiendo un peligro inminente más allá de las tierras ursas se ha propuesto destruir la amenaza en su origen.\n" +
                                "\n" +
                                "La mayoría de los ursa no encuentran práctica la armadura.";
                        break;
                    case "texto2":
                        hist = "Durante el invierno los machos ursas patrullan su tierra mientras que las hembras duermen y amamantan a sus cachorros en los bosques oscuros. Las bestias de las montañas del norte de su hogar son especialmente peligrosas y son asesinados regularmente.";
                        break;
                    case "texto3":
                        hist = "En su historia temprana, los ursa no tenían la capacidad de hablar. Esta época se conoce como la Edad Salvaje y está marcada por los conflictos violentos. Se formaron alianzas y cada grupo estaba definido por sus propios patrones y sellos.\n" +
                                "Hoy, los ursa honran y recuerdan su pasado a través de rituales y ceremonias.";
                        break;
                    case "texto4":
                        hist = "Hace mucho tiempo estallaron las guerras entre los clanes ursa. Fue la primera vez que los ursa empezaron a llevar armaduras de metal adornadas con los motivos de su clan. La mayoría de las reliquias de las guerras se han perdido aunque los ursa siguen llevando piezas para participar en ceremonias.";
                        break;
                    case "texto5":
                        hist = "Los ursa creen en los espíritus de la naturaleza así como en los espíritus individuales que habitan en el interior de cada ser. Según Ulfsaar, es su propio espíritu personal el que le mantiene a salvo. Los ursa también parecen creer en un \"primer oso\" ancestral.\n" +
                                "\n" +
                                "Los guerreros ursa llevan plumas y collares hechos con dientes de Cholgar que son bendecidos para dar suerte y protección.";
                        break;
                    case "texto6":
                        hist = "Es posible que Gondar haya matado a un ursa durante su primera cacería como prueba lo que podría indicar una relación hostil entre el pueblo de Gondar y el ursa.";
                        break;

                }
                break;

            case "Tejedores":

                switch (tipo) {

                    case "texto1":
                        hist = "Los Weavers son seres parecidos a los insectos que se encargan de mantener y reparar el tejido de la realidad, manteniéndolo firme y evitando que se desvanezca. También se encargan de defender de criaturas no especificadas que roen y ponen sus huevos en el tejido, evitando que sus crías devoren todo el universo. A cada Weaver se le asigna una porción del universo que debe cuidar. Los Weavers se refieren al medio de creación como el Telar. Se cree que la tela que tejen está relacionada con el destino.\n" +
                                "\n" +
                                "Los Weavers tienen antenas y órganos sensoriales que les permiten detectar cambios en el tejido de la realidad. Cuanto más largas sean sus antenas, más capaces serán de tejer la realidad.\n" +
                                "\n" +
                                "El Weaver más conocido es Skitskurr. Aburrido de limitarse a mantener el universo Skitskurr quería crear nuevas realidades. Sus ambiciones pronto llamaron la atención de los guardianes del universo que cortaron su parte del telar y lo expulsaron. Separado de los demás Weavers, Skitskuur busca ahora tejer una nueva realidad propia.";
                        break;

                }
                break;

            case "Escarabajos Zealots":

                switch (tipo) {

                    case "texto1":
                        hist = "Los escarabajos zealot son una raza de insectos telepáticos y eusociales. Gran parte de lo que se sabe sobre ellos procede de un único tomo antiguo en los Archivos de Ultimyr. Su nombre es una referencia a su ferviente culto a Nyx, su reina, a la que consideran una diosa.";
                        break;
                    case "texto2":
                        hist = "Los escarabajos Zealot nacen de los huevos como larvas y sufren una metamorfosis para convertirse en adultos. Los escarabajos Zealot completamente crecidos están cubiertos por un exoesqueleto quitinoso, con un tórax elevado que conduce a una cabeza erguida. Aunque sus caparazones son relativamente delgados, cada escarabajo posee púas retráctiles para disuadir a los atacantes. Los escarabajos Zealot tienen ocho apéndices, seis de los cuales son patas para caminar y los dos apéndices frontales actúan como manipuladores. Dos mandíbulas alargadas sobresalen por debajo de dos ojos, a veces con dientes. Algunos escarabajos zelote tienen un aguijón que sobresale de su abdomen, capaz de matar a la presa.\n" +
                                "\n" +
                                "Todos los escarabajos Zealot son telepáticos y viven en colonias comunales. Todos los escarabajos tienen un conocimiento íntimo de sus túneles subterráneos y los comparten entre ellos. La colmena experimenta \"ciclos\" regulares, aunque se desconoce lo que esto implica.";
                        break;
                    case "texto3":
                        hist = "Al igual que otros insectos sociales las larvas sufren diferentes metamorfosis según la casta a la que pertenezcan y cada casta es físicamente diferente para adaptarse a sus tareas. Algunas castas son conocidas por cavar pequeñas madrigueras donde acechan a posibles presas. Sin contar la reina hay un total de cuatro castas. Los escarabajos Zealot de casta superior son conocidos por hacer uso de armaduras y extensiones metálicas en las garras.\n" +
                                "\n" + "\n" +
                                "La Diosa Reina\n" +
                                "Los Escarabajos Zealot están gobernados por Nyx, su diosa reina. Nyx vive en una cámara especial posiblemente en la Colmena Oculta.\n" +
                                "Segrega una sustancia especial que utiliza para ungir a un único gusano elegido, lo que desencadena una metamorfosis única. No todos los gusanos elegidos sobreviven a este proceso. El que lo hace se convierte en el Asesino de Nyx, cuyo propósito es cumplir con la más alta vocación de Nyx: matar en nombre de su reina. Los motivos detrás de las órdenes de asesinato de Nyx son desconocidos.\n" +
                                "\n" +
                                "La Casta Reproductora\n" +
                                "Poco se sabe de la casta reproductora o de cómo se relacionan sus miembros con la reina.\n" +
                                "\n" +
                                "La Casta de Soldados\n" +
                                "No se sabe nada de la casta de los soldados.\n" +
                                "\n" +
                                "La Casta Trabajadora\n" +
                                "La casta de obreros es la unidad base de la colonia. Los obreros están inundadas de \"pensamientos plagados\" de deberes, probablemente controlados por la reina.\n" +
                                "\n" +
                                "La Casta Asesina\n" +
                                "El Asesino de Nyx se considera una casta aparte. Es la cuarta y más alta casta, después de la reina y consta de un solo miembro. Siempre hay al menos un Nyx Assassin vivo. El Nyx Assassin fue descrito por el tomo de los Archivos de Ultimyr que señalaba sus extraordinarios poderes telepáticos.\n" +
                                "\n" +
                                "A diferencia de los otros escarabajos, el Asesino de Nyx tiene una mente excepcionalmente aguda y es capaz de devorar las mentes de los seres menores. Con esta telepatía latente, el Asesino de Nyx puede proyectar sus pensamientos en los que le rodean así como escuchar los pensamientos de los demás.\n" +
                                " Es más grande, con garras delanteras más afiladas y mandíbulas dentadas. Después de ser bendecido por su reina el Asesino de Nyx adquirió nuevas y extrañas energías. Al igual que otros escarabajos Zealot el Asesino de Nyx puede excavar en la tierra, a menudo a mayor profundidad que sus hermanos.\n" +
                                "\n" +
                                "Los nuevos Nyx Assassins reciben un conjunto especial de armadura de garras cuando completan su primera misión. Por cada tres asesinatos que realicen se les concede un cuerno ceremonial. Debe continuar completando asesinatos para mantener este cuerno.";
                        break;
                    case "texto4":
                        hist = "Una colonia especial llamada la Colmena Oculta está reservada para Nyx, su asesino y otras que no son nombrados. Cuando se elige a un nuevo asesino de Nyx, se le envía a la Colmena Oculta para que lo confirme. Aquí se celebran ceremonias, se otorgan armaduras y la reina comparte sus planes con sus subordinados.";
                        break;
                    case "texto5":
                        hist = "Nyx y los escarabajos Zealot pueden tener conocimientos de alquimia. Se utilizaron compuestos alquímicos especiales para ayudar al actual Asesino de Nyx a que le creciera un caparazón resistente a la magia tras siete temporadas de muda.\n" +
                                "\n" +
                                "Una vez cada mil ciclos de la colmena Nyx concede a su asesino elegido el Orbe Sagrado, este orbe le confiere grandes poderes. La muda necesaria para incorporar el orbe al exoesqueleto es excepcionalmente dolorosa.";
                        break;
                    case "texto6":
                        hist = "Black Arachnia ha capturado y comido varios escarabajos zealot.\n" +
                                "\n" +
                                "Abaddon tiene una rivalidad poco clara con Nyx y ha derrotado a varios Asesinos de Nyx en el pasado.";
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