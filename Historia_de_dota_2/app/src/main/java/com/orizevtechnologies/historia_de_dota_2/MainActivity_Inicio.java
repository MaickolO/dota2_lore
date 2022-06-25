package com.orizevtechnologies.historia_de_dota_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.orizevtechnologies.historia_de_dota_2.fragmentPrincipal.archronicus;
import com.orizevtechnologies.historia_de_dota_2.fragmentPrincipal.dioses;
import com.orizevtechnologies.historia_de_dota_2.fragmentPrincipal.eventos;
import com.orizevtechnologies.historia_de_dota_2.fragmentPrincipal.facciones;
import com.orizevtechnologies.historia_de_dota_2.fragmentPrincipal.heroes;
import com.orizevtechnologies.historia_de_dota_2.fragmentPrincipal.informacion;
import com.orizevtechnologies.historia_de_dota_2.fragmentPrincipal.razas;
import com.orizevtechnologies.historia_de_dota_2.fragmentPrincipal.regiones;
import com.orizevtechnologies.historia_de_dota_2.fragmentPrincipal.textos;

public class MainActivity_Inicio extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_inicio);

        Toolbar toolbar = findViewById(R.id.toolbar_inicio);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout_inicio);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //Fragmento por defecto
        if (savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_principal,
                    new archronicus()).commit();
            navigationView.setCheckedItem(R.id.menu_archronicus);
        }

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.menu_archronicus:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_principal,
                        new archronicus()).commit();
                break;

            case R.id.menu_heroes:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_principal,
                        new heroes()).commit();
                break;
            case R.id.menu_facciones:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_principal,
                        new facciones()).commit();
                break;


            case R.id.menu_regiones:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_principal,
                        new regiones()).commit();
                break;

            case R.id.menu_razas:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_principal,
                        new razas()).commit();
                break;

            case R.id.menu_dioses:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_principal,
                        new dioses()).commit();
                break;

            case R.id.menu_eventos:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_principal,
                        new eventos()).commit();
                break;

            case R.id.menu_textos:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_principal,
                        new textos()).commit();
                break;

            case R.id.menu_informacion:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_principal,
                        new informacion()).commit();
                break;

        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

}