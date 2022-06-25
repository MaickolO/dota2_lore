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
import com.orizevtechnologies.historia_de_dota_2.R;
import com.orizevtechnologies.historia_de_dota_2.listas.RecyclerAdapter_rel_heroes;
import com.orizevtechnologies.historia_de_dota_2.listas.RecyclerAdapter_rel_mundo;
import com.orizevtechnologies.historia_de_dota_2.listas.RecyclerAdapter_rel_raza;
import com.orizevtechnologies.historia_de_dota_2.listas.lista_relacionados;

import java.util.ArrayList;
import java.util.List;

public class detalle_eventos extends AppCompatActivity implements RecyclerAdapter_rel_raza.RecyclerItemClick,
        RecyclerAdapter_rel_heroes.RecyclerItemClick_heroes, RecyclerAdapter_rel_mundo.RecyclerItemClick_mundo{

    private ImageView img_eventos;
    private TextView tit_es;
    private TextView tit_en;
    private String titpag;

    private TextView texto1;
    private TextView texto2;
    private TextView texto3;

    private TextView titulo1;
    private TextView titulo2;

    private LinearLayout layout1;
    private LinearLayout layout2;
    private LinearLayout layout_rel_eventos;
    private LinearLayout layout_deteventos_rel_razas;
    private LinearLayout layout_deteventos_rel_mundo;
    private LinearLayout layout_deteventos_rel_heroes;
    private AdView mAdView;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_eventos);

        try {
            initViews();
            initValues();
            ActionBar();
            rel_eventos();
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

        mAdView = findViewById(R.id.adView_det_eventos);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }


    private void initViews() {
        img_eventos = findViewById(R.id.fondo_eventos_detalle);
        tit_es = findViewById(R.id.titulo_espanol_det_eventos);
        tit_en = findViewById(R.id.titulo_ingles_det_eventos);

        texto1 = findViewById(R.id.det_eventos_texto1);
        texto2 = findViewById(R.id.det_eventos_texto2);
        texto3 = findViewById(R.id.det_eventos_texto3);

        titulo1 = findViewById(R.id.det_eventos_titulo1);
        titulo2 = findViewById(R.id.det_eventos_titulo2);

        layout1 = findViewById(R.id.det_eventos_layout1);
        layout2 = findViewById(R.id.det_eventos_layout2);

        layout_rel_eventos = findViewById(R.id.layout_rel_eventos);
        layout_deteventos_rel_razas = findViewById(R.id.layout_deteventos_rel_razas);
        layout_deteventos_rel_mundo = findViewById(R.id.layout_deteventos_rel_mundo);
        layout_deteventos_rel_heroes = findViewById(R.id.layout_deteventos_rel_heroes);

    }


    private void rel_eventos() {

        //Relaciones Razas
        RecyclerView rvLista_eventos_rel_razas = findViewById(R.id.recycler_view_eventos_rel_razas);
        LinearLayoutManager manager_razas = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rvLista_eventos_rel_razas.setLayoutManager(manager_razas);
        List<lista_relacionados> items = getItems_razas();
        RecyclerAdapter_rel_raza adapter_razas = new RecyclerAdapter_rel_raza(items, this);
        rvLista_eventos_rel_razas.setAdapter(adapter_razas);


        //Relaciones Heroes
        RecyclerView rvLista_eventos_rel_heroes = findViewById(R.id.recycler_view_eventos_rel_heroe);
        LinearLayoutManager manager_heroes = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rvLista_eventos_rel_heroes.setLayoutManager(manager_heroes);
        List<lista_relacionados> items_heroes = getItems_heroes();
        RecyclerAdapter_rel_heroes adapter_heroes = new RecyclerAdapter_rel_heroes(items_heroes, this);
        rvLista_eventos_rel_heroes.setAdapter(adapter_heroes);


        //Relaciones Mundo
        RecyclerView rvLista_eventos_rel_mundo = findViewById(R.id.recycler_view_eventos_rel_mundo);
        LinearLayoutManager manager_mundo = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rvLista_eventos_rel_mundo.setLayoutManager(manager_mundo);
        List<lista_relacionados> items_mundo = getItems_mundo();
        RecyclerAdapter_rel_mundo adapter_mundo = new RecyclerAdapter_rel_mundo(items_mundo, this);
        rvLista_eventos_rel_mundo.setAdapter(adapter_mundo);

    }


    private List<lista_relacionados> getItems_razas() {

        return new ArrayList<>();
    }


    private List<lista_relacionados> getItems_heroes() {
        List<lista_relacionados> itemLists= new ArrayList<>();

        switch (titpag) {

            case "Batalla de la Puerta del Pez-Piedra":
                itemLists.add(new lista_relacionados("Slithice","Naga Siren",R.drawable.perfil_naga));
                break;

            case "Masacre de los Apóstatas":
                itemLists.add(new lista_relacionados("Banehallow","Lycan",R.drawable.perfil_lycan));

                break;

            case "Qaz'hallaq":
                itemLists.add(new lista_relacionados("Cryxalis","Sand King",R.drawable.perfil_sk));
                break;

            case "Guerra de los Siete Minutos":
                itemLists.add(new lista_relacionados("Boush","Tinker",R.drawable.perfil_tinker));
                break;

            case "Era Sórdida":
                itemLists.add(new lista_relacionados("Rhasta","Shadow Shaman",R.drawable.perfil_ss));
                break;

            case "Batallas del Dios de la Guerra":
                itemLists.add(new lista_relacionados("Mars","First Son of Heaven",R.drawable.perfil_mars));
                break;

            case "Rebelion Vhoul":
                itemLists.add(new lista_relacionados("Tresdin","Legion Commander",R.drawable.perfil_legion_commander));
                break;

        }

        return itemLists;
    }


    private List<lista_relacionados> getItems_mundo() {

        List<lista_relacionados> lista_mundo_es= new ArrayList<>();

        switch (titpag) {

            case "Qaz'hallaq":
                lista_mundo_es.add(new lista_relacionados("Basurero Centelleante", "Scintillant Waste", R.drawable.basurero_centelleante));
                break;

            case "Guerra de los Siete Minutos":
                lista_mundo_es.add(new lista_relacionados("Meseta Violeta", "Violet Plateau", R.drawable.violet_plateau));
                break;

            case "Rebelion Vhoul":
                lista_mundo_es.add(new lista_relacionados("Palacio de Piedra", "StoneHall", R.drawable.stonehall));
                break;

            case "Batallas del Dios de la Guerra":
                lista_mundo_es.add(new lista_relacionados("Siete Infiernos", "Seven Hells", R.drawable.seven_hells));
                break;

        }

        return lista_mundo_es;
    }


    private void initValues(){

        String tit_igual;

        lista_relacionados itemDetail = (lista_relacionados) getIntent().getExtras().getSerializable("itemDetail");
        img_eventos.setImageResource(itemDetail.getImg_principal());
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

            case "Batalla de la Puerta del Pez-Piedra":

            case "Masacre de los Apóstatas":

            case "Era Sórdida":
                parrafos1();
                rel("heroe");
                break;

            case "Qaz'hallaq":

            case "Guerra de los Siete Minutos":

            case "Rebelion Vhoul":
                parrafos1();
                rel("heroe_mundo");
                break;

            case "Batallas del Dios de la Guerra":
                parrafos3();
                rel("heroe_mundo");
                break;

        }
    }


    private String Historia(String nombre, String tipo) {

        String hist = "";

        switch (nombre) {

            case "Batalla de la Puerta del Pez-Piedra":

                if ("texto1".equals(tipo)) {
                    hist = "La Batalla de la Puerta de Piedra fue un conflicto en el que participaron el Cónclave de la Salmuera (\"Conclave of the Brine\") y la Guardia Slithereen (\"Slithereen Guard\") contra un oponente desconocido. La Guardia Slithereen fue desplegada para ayudar al Cónclave contra una \"grave amenaza\".\n" +
                            "\n" +
                            "Slithice estuvo presente en la batalla, donde fue distinguida por su valor, lo que la llevó a ser aceptada como miembro de la Orden de Cyprin.";
                }
                break;

            case "Masacre de los Apóstatas":

                if ("texto1".equals(tipo)) {
                    hist = "La Masacre de los Apóstatas tuvo lugar cuando seis mil soldados de la Casa de Ambry intentaron arrebatar la capital de Slom a su Último Rey. Este levantamiento fracasó y los rebeldes fueron masacrados. Lord Ambry fue ejecutado por este intento, y su hijo Banehallow fue maldecido por los magos del Rey con licantropía eterna.";
                }
                break;

            case "Qaz'hallaq":

                if ("texto1".equals(tipo)) {
                    hist = "El Qaz'hallaq es una ceremonia que practican los habitantes de Qaldin. Durante la ceremonia, siete acólitos son picados hasta la muerte con el Aguijón Ceremonial de Qaldin.";
                }
                break;

            case "Guerra de los Siete Minutos":

                if ("texto1".equals(tipo)) {
                    hist = "La Guerra de los Siete Minutos fue una guerra breve. Tinker sólo la menciona una vez y no se conocen más detalles.";
                }
                break;

            case "Era Sórdida":

                if ("texto1".equals(tipo)) {
                    hist = "La Era Sórdida fue un periodo histórico. Se caracterizó por una larga sequía, que duró trece temporadas. La gente de esta época culpaba del hambre y las enfermedades causadas por la sequía a los magos viajeros, uno de los cuales era Rhasta. Esta actitud continuó en la siguiente era, en la que los magos capturados eran desollados y expuestos en los caminos si eran sorprendidos en sus viajes. Durante todo este periodo Rhasta disimuló sus habilidades chamánicas vistiendo y actuando como un vagabundo.";
                }
                break;

            case "Batallas del Dios de la Guerra":

                switch (tipo) {

                    case "texto1":
                        hist = "El Dios de la Guerra Marte ha librado numerosas campañas a lo largo del univeros.";
                        break;
                    case "texto2":
                        hist = "Las Conquistas Estigia fueron una serie de guerras libradas por Marte. No se dice nada más sobre ellas, pero su nombre implica que tuvieron lugar en el río Estigia o en los Siete Infiernos.";
                        break;
                    case "texto3":
                        hist = "La Invasión Wightfall fue una guerra librada por Marte. No se sabe nada más sobre ella.";
                        break;

                }
                break;

            case "Rebelion Vhoul":

                if ("texto1".equals(tipo)) {
                    hist = "La Rebelión de los Vhoul fue lanzada por los Vhoul Roedores. Fue iniciada por Rix cuando Tresin le encargó recoger las raciones de los granjeros de Roseleaf por la fuerza, en lugar de ello llevó a los granjeros a resistirse contra la autoridad de Stonehall.";
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

        layout1.setVisibility(View.GONE);
        layout2.setVisibility(View.GONE);

    }

    @SuppressLint("SetTextI18n")
    private void parrafos3() {

        texto1.setText(Historia(titpag, "texto1"));
        texto2.setText(Historia(titpag, "texto2"));
        texto3.setText(Historia(titpag, "texto3"));

        titulo1.setText("Conquistas Estigia");
        titulo2.setText("Invasión de Wightfall");

    }


    private void rel(String rel) {

        switch (rel) {
            case "heroe":
                layout_deteventos_rel_mundo.setVisibility(View.GONE);
                layout_deteventos_rel_razas.setVisibility(View.GONE);
                break;
            case "mundo":
                layout_deteventos_rel_heroes.setVisibility(View.GONE);
                layout_deteventos_rel_razas.setVisibility(View.GONE);
                break;
            case "raza":
                layout_deteventos_rel_heroes.setVisibility(View.GONE);
                layout_deteventos_rel_mundo.setVisibility(View.GONE);
                break;
            case "heroe_mundo":
                layout_deteventos_rel_razas.setVisibility(View.GONE);
                break;
            case "heroe_raza":
                layout_deteventos_rel_mundo.setVisibility(View.GONE);
                break;
            case "mundo_raza":
                layout_deteventos_rel_heroes.setVisibility(View.GONE);
                break;
            case "vacio":
                layout_deteventos_rel_heroes.setVisibility(View.GONE);
                layout_deteventos_rel_mundo.setVisibility(View.GONE);
                layout_deteventos_rel_razas.setVisibility(View.GONE);
                layout_rel_eventos.setVisibility(View.GONE);
                break;
            case "heroe_mundo_raza":
                break;
        }

    }


    @Override
    public void itemClick(lista_relacionados item) {

        try {
            Intent intent = new Intent(this, detalle_eventos.class);
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