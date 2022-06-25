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
import com.orizevtechnologies.historia_de_dota_2.Detalle.detalle_heroe;
import com.orizevtechnologies.historia_de_dota_2.listas.RecyclerAdapter;
import com.orizevtechnologies.historia_de_dota_2.listas.lista_relacionados;
import com.orizevtechnologies.historia_de_dota_2.R;

import java.util.ArrayList;
import java.util.List;

public class heroes extends Fragment implements RecyclerAdapter.RecyclerItemClick, SearchView.OnQueryTextListener {

    private AdView mAdView;
    private RecyclerView rvLista_heroes;
    private SearchView svSearch_heroes;
    private RecyclerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_heroes, container, false);

        initViews(view);
        initValues();
        initListener();
        anuncio_banenr(view);

        return view;
    }

    private void initViews(View view) {
        rvLista_heroes = view.findViewById(R.id.recycler_view);
        svSearch_heroes = view.findViewById(R.id.svSearch);
        svSearch_heroes.setIconifiedByDefault(false);
    }

    private void initValues() {

        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        rvLista_heroes.setLayoutManager(manager);

        List<lista_relacionados> items = getItems();
        adapter = new RecyclerAdapter(items, this);
        rvLista_heroes.setAdapter(adapter);

    }

    private void initListener() {
        svSearch_heroes.setOnQueryTextListener(this);
    }

    private List<lista_relacionados> getItems() {
        List<lista_relacionados> itemLists = new ArrayList<>();

        itemLists.add(new lista_relacionados("Abbadon", "Lord of Avernus", R.drawable.perfil_abbadon));
        itemLists.add(new lista_relacionados("Razzil Darkbrew","Alchemist", R.drawable.perfil_alchemist));
        itemLists.add(new lista_relacionados("Kaldr","Ancient Aparition",R.drawable.perfil_ancient));
        itemLists.add(new lista_relacionados("Magina","Anti-Mage", R.drawable.perfil_antimage));
        itemLists.add(new lista_relacionados("Zet","Arc Warden", R.drawable.perfil_arc));
        itemLists.add(new lista_relacionados("Mogul Khan","Axe", R.drawable.perfil_axe));
        itemLists.add(new lista_relacionados("Atropos","Bane Elemental", R.drawable.perfil_bane));
        itemLists.add(new lista_relacionados("Batrider","Batrider", R.drawable.perfil_batrider));
        itemLists.add(new lista_relacionados("karroch","Beastmaster", R.drawable.perfil_beastmaster));
        itemLists.add(new lista_relacionados("Strygwyr","Bloodseeker", R.drawable.perfil_bloodseeker));
        itemLists.add(new lista_relacionados("Gondar","Bounty Hunter", R.drawable.perfil_bounty));
        itemLists.add(new lista_relacionados("Mangix","Brewmaster", R.drawable.perfil_brewmaster));
        itemLists.add(new lista_relacionados("Rigwarl","Bristleback", R.drawable.perfil_bristleback));
        itemLists.add(new lista_relacionados("Black Arachnia","Broodmother", R.drawable.perfil_broodmother));
        itemLists.add(new lista_relacionados("Bradwarden","Centaur Warruner",R.drawable.perfil_centaur));
        itemLists.add(new lista_relacionados("Nessaj","Chaos Knight",R.drawable.perfil_chaos));
        itemLists.add(new lista_relacionados("Chen","Holy Knight",R.drawable.perfil_chen));
        itemLists.add(new lista_relacionados("Clinkz","Bone Fletcher",R.drawable.perfil_clinkz));
        itemLists.add(new lista_relacionados("Rattlerap","Clockwerk",R.drawable.perfil_clockwerk));
        itemLists.add(new lista_relacionados("Rylai","Crystal Maiden",R.drawable.perfil_crystal));
        itemLists.add(new lista_relacionados("Ish'kafel","Dark Seer",R.drawable.perfil_dark));
        itemLists.add(new lista_relacionados("Mireska Sunbreeze","Dark Willow",R.drawable.perfil_willow));
        itemLists.add(new lista_relacionados("Valora","Dawnbreaker",R.drawable.perfil_dawnbreaker));
        itemLists.add(new lista_relacionados("Dazzle","Shadow Priest",R.drawable.perfil_dazzle));
        itemLists.add(new lista_relacionados("Krobelus","Death Prophet",R.drawable.perfil_death));
        itemLists.add(new lista_relacionados("Disruptor","Stormcrafter",R.drawable.perfil_disruptor));
        itemLists.add(new lista_relacionados("Lucifer","Doom",R.drawable.perfil_doom));
        itemLists.add(new lista_relacionados("Davion","Dragon Knight",R.drawable.perfil_dragon));
        itemLists.add(new lista_relacionados("Traxex","Drow Ranger",R.drawable.perfil_drow));
        itemLists.add(new lista_relacionados("Kaolin","Earth Spirit",R.drawable.perfil_earth));
        itemLists.add(new lista_relacionados("Raigor Stonehoof","Earthshaker",R.drawable.perfil_shaker));
        itemLists.add(new lista_relacionados("Elder Titan","Worldsmith",R.drawable.perfil_titan));
        itemLists.add(new lista_relacionados("Xin","Ember Spirit",R.drawable.perfil_ember));
        itemLists.add(new lista_relacionados("Aiushtha","Enchantress",R.drawable.perfil_enchantress));
        itemLists.add(new lista_relacionados("Enigma","Consumer of worlds",R.drawable.perfil_enigma));
        itemLists.add(new lista_relacionados("Darkterror","Faceless Void",R.drawable.perfil_faceless));
        itemLists.add(new lista_relacionados("Astral","Grimstroke",R.drawable.perfil_grimstroke));
        itemLists.add(new lista_relacionados("Aurel","Gyrocopter",R.drawable.perfil_gyrocopter));
        itemLists.add(new lista_relacionados("Hoodwink","Hoodwink",R.drawable.perfil_hoodwink));
        itemLists.add(new lista_relacionados("Huskar","Sacred Warrior",R.drawable.perfil_huskar));
        itemLists.add(new lista_relacionados("Carl","Invoker",R.drawable.perfil_invoker));
        itemLists.add(new lista_relacionados("Io","Wisp",R.drawable.perfil_io));
        itemLists.add(new lista_relacionados("Jakiro","Twin Head Dragon",R.drawable.perfil_jakiro));
        itemLists.add(new lista_relacionados("Yurnero","Juggernatur",R.drawable.perfil_jugg));
        itemLists.add(new lista_relacionados("Ezalor","Keeper of the Light",R.drawable.perfil_keeper));
        itemLists.add(new lista_relacionados("Kunkka","Admiral",R.drawable.perfil_kunkka));
        itemLists.add(new lista_relacionados("Tresdin","Legion Commander",R.drawable.perfil_legion_commander));
        itemLists.add(new lista_relacionados("Leshrac","Tormented Soul",R.drawable.perfil_leshrac));
        itemLists.add(new lista_relacionados("Ethreain","Lich",R.drawable.perfil_lich));
        itemLists.add(new lista_relacionados("N'aix","Lifestealer",R.drawable.perfil_life));
        itemLists.add(new lista_relacionados("Lina","Slayer",R.drawable.perfil_lina));
        itemLists.add(new lista_relacionados("Lion","Demon Witch",R.drawable.perfil_lion));
        itemLists.add(new lista_relacionados("Sylla","Lone Druid",R.drawable.perfil_lone));
        itemLists.add(new lista_relacionados("Luna","Moon Rider",R.drawable.perfil_luna));
        itemLists.add(new lista_relacionados("Banehallow","Lycan",R.drawable.perfil_lycan));
        itemLists.add(new lista_relacionados("Magnus","Magnoceros",R.drawable.perfil_magnus));
        itemLists.add(new lista_relacionados("Marci","Marci",R.drawable.perfil_marci));
        itemLists.add(new lista_relacionados("Mars","First Son of Heaven",R.drawable.perfil_mars));
        itemLists.add(new lista_relacionados("Medusa","Gorgon",R.drawable.perfil_medusa));
        itemLists.add(new lista_relacionados("Meepo","Geomancer",R.drawable.perfil_meepo));
        itemLists.add(new lista_relacionados("Mirana","Princess of the Moon",R.drawable.perfil_mirana));
        itemLists.add(new lista_relacionados("Sun Wukong","Monkey King",R.drawable.perfil_monkey));
        itemLists.add(new lista_relacionados("Morphling","The Morphling",R.drawable.perfil_morphling));
        itemLists.add(new lista_relacionados("Slithice","Naga Siren",R.drawable.perfil_naga));
        itemLists.add(new lista_relacionados("Furion","Nature's Prophet",R.drawable.perfil_nature));
        itemLists.add(new lista_relacionados("Rotund'jere","Necrophos",R.drawable.perfil_necrophos));
        itemLists.add(new lista_relacionados("Balanar","Night Stalker",R.drawable.perfil_balanar));
        itemLists.add(new lista_relacionados("Nyx Assassin","Asesino de Nyx",R.drawable.perfil_nyx));
        itemLists.add(new lista_relacionados("Aggron Stonebreak","Ogre Magi",R.drawable.perfil_ogre));
        itemLists.add(new lista_relacionados("Purist Thunderwrath","Omniknight",R.drawable.perfil_omniknight));
        itemLists.add(new lista_relacionados("Nerif","Oracle",R.drawable.perfil_oracle));
        itemLists.add(new lista_relacionados("Harbinger","Outworld Destroyer",R.drawable.perfil_od));
        itemLists.add(new lista_relacionados("Donté Panlin","Pangolier",R.drawable.perfil_pangolier));
        itemLists.add(new lista_relacionados("Mortred","Phantom Assassin",R.drawable.perfil_pa));
        itemLists.add(new lista_relacionados("Azwraith","Phantom Lancer",R.drawable.perfil_pl));
        itemLists.add(new lista_relacionados("Phoenix","Fenix",R.drawable.perfil_fenix));
        itemLists.add(new lista_relacionados("Primal Beast","Bestia Primordial",R.drawable.perfil_primal));
        itemLists.add(new lista_relacionados("Puck","Faerie Dragon",R.drawable.perfil_puck));
        itemLists.add(new lista_relacionados("Pudge","Butcher",R.drawable.perfil_pudge));
        itemLists.add(new lista_relacionados("Pugna","Oblivion",R.drawable.perfil_pugna));
        itemLists.add(new lista_relacionados("Akasha","Queen of Pain",R.drawable.perfil_qop));
        itemLists.add(new lista_relacionados("Razor","Lightning Revenant",R.drawable.perfil_razor));
        itemLists.add(new lista_relacionados("Riki","Stealth Assassin",R.drawable.perfil_riki));
        itemLists.add(new lista_relacionados("Rubick","Grand Magus",R.drawable.perfil_rubick));
        itemLists.add(new lista_relacionados("Cryxalis","Sand King",R.drawable.perfil_sk));
        itemLists.add(new lista_relacionados("shadow Demon","Demonio Sombrío",R.drawable.perfil_shadow));
        itemLists.add(new lista_relacionados("Nevermore","Shadow Fiend",R.drawable.perfil_sf));
        itemLists.add(new lista_relacionados("Rhasta","Shadow Shaman",R.drawable.perfil_ss));
        itemLists.add(new lista_relacionados("Nortrom","Silencer",R.drawable.perfil_silencer));
        itemLists.add(new lista_relacionados("Dragonus","Skywrarth Mage",R.drawable.perfil_sky));
        itemLists.add(new lista_relacionados("Slardar","Slithereen Guard",R.drawable.perfil_slardar));
        itemLists.add(new lista_relacionados("Slark","Nightcrawler",R.drawable.perfil_slark));
        itemLists.add(new lista_relacionados("Beatrix Snapfire","Snapfire",R.drawable.perfil_snapfire));
        itemLists.add(new lista_relacionados("Kardel Sharpeye","Sniper",R.drawable.perfil_sniper));
        itemLists.add(new lista_relacionados("Mercurial","Spectre",R.drawable.perfil_spectre));
        itemLists.add(new lista_relacionados("Barathrum","Spirit Breaker",R.drawable.perfil_bara));
        itemLists.add(new lista_relacionados("Raijin Thunderkeg","Storm Spirit",R.drawable.perfil_storm));
        itemLists.add(new lista_relacionados("Sven","Rogue Knight",R.drawable.perfil_sven));
        itemLists.add(new lista_relacionados("Squee, Spleen y Spoon","Techies",R.drawable.perfil_techies));
        itemLists.add(new lista_relacionados("Lanaya","Templar Assassin",R.drawable.perfil_templar));
        itemLists.add(new lista_relacionados("Terrorblade","Demon Marauder",R.drawable.perfil_tb));
        itemLists.add(new lista_relacionados("Leviathan","Tidehunter",R.drawable.perfil_tide));
        itemLists.add(new lista_relacionados("Rizzrack","Timbersaw",R.drawable.perfil_timber));
        itemLists.add(new lista_relacionados("Boush","Tinker",R.drawable.perfil_tinker));
        itemLists.add(new lista_relacionados("Tiny","Stone Giant",R.drawable.perfil_tiny));
        itemLists.add(new lista_relacionados("Rooftrellen","Treant Protector",R.drawable.perfil_arbol));
        itemLists.add(new lista_relacionados("Jah'rakal","Troll Warlord",R.drawable.perfil_troll));
        itemLists.add(new lista_relacionados("Ymir","Tusk",R.drawable.perfil_tusk));
        itemLists.add(new lista_relacionados("Vrogros","Underlord",R.drawable.perfil_underlord));
        itemLists.add(new lista_relacionados("Undying","Almighty Dirge",R.drawable.perfil_zombie));
        itemLists.add(new lista_relacionados("Ulfsaar","Ursa Warrior",R.drawable.perfil_ursa));
        itemLists.add(new lista_relacionados("Shendelzare","Vengeful Spirit",R.drawable.perfil_venge));
        itemLists.add(new lista_relacionados("Lesale Deathbringer","Venomancer",R.drawable.perfil_veno));
        itemLists.add(new lista_relacionados("Viper","Netherdrake",R.drawable.perfil_viper));
        itemLists.add(new lista_relacionados("Visage","Bound Form of Necro'lic",R.drawable.perfil_visage));
        itemLists.add(new lista_relacionados("Inai","Void Spirit",R.drawable.perfil_void));
        itemLists.add(new lista_relacionados("Demnok Lannik","Warlock",R.drawable.perfil_warlock));
        itemLists.add(new lista_relacionados("Skitskurr","Weaver",R.drawable.perfil_weaver));
        itemLists.add(new lista_relacionados("Lyralei","Windranger",R.drawable.perfil_windranger));
        itemLists.add(new lista_relacionados("Auroth","Winter Wyvern",R.drawable.perfil_ww));
        itemLists.add(new lista_relacionados("Zharvakko","Witch Doctor",R.drawable.perfil_wd));
        itemLists.add(new lista_relacionados("Ostarion","Wraith King",R.drawable.perfil_wk));
        itemLists.add(new lista_relacionados("Zeus","Lord of Heaven",R.drawable.perfil_zeus));

        return itemLists;
    }


    @Override
    public void itemClick(lista_relacionados item) {

        try {
            Intent intent = new Intent(getContext(), detalle_heroe.class);
            intent.putExtra("itemDetail", item);
            getContext().startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }

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

    
    private void anuncio_banenr(View view) {

        MobileAds.initialize(getActivity(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = view.findViewById(R.id.adView_heroes);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }



}

