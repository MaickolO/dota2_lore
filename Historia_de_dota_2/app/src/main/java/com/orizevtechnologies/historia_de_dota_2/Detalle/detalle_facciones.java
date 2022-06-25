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

public class detalle_facciones extends AppCompatActivity implements RecyclerAdapter_rel_raza.RecyclerItemClick,
        RecyclerAdapter_rel_heroes.RecyclerItemClick_heroes, RecyclerAdapter_rel_mundo.RecyclerItemClick_mundo {

    private ImageView img_facciones;
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
    private LinearLayout layout_rel_facciones;
    private LinearLayout layout_detfacciones_rel_razas;
    private LinearLayout layout_detfacciones_rel_mundo;
    private LinearLayout layout_detfacciones_rel_heroes;
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_facciones);

        try {
            initViews();
            initValues();
            ActionBar();
            rel_facciones();
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

        mAdView = findViewById(R.id.adView_det_facciones);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    private void initViews() {
        img_facciones = findViewById(R.id.fondo_facciones_detalle);
        tit_es = findViewById(R.id.titulo_espanol_det_facciones);
        tit_en = findViewById(R.id.titulo_ingles_det_facciones);

        texto1 = findViewById(R.id.det_facciones_texto1);
        texto2 = findViewById(R.id.det_facciones_texto2);
        texto3 = findViewById(R.id.det_facciones_texto3);
        texto4 = findViewById(R.id.det_facciones_texto4);
        texto5 = findViewById(R.id.det_facciones_texto5);
        texto6 = findViewById(R.id.det_facciones_texto6);

        titulo1 = findViewById(R.id.det_facciones_titulo1);
        titulo2 = findViewById(R.id.det_facciones_titulo2);
        titulo3 = findViewById(R.id.det_facciones_titulo3);
        titulo4 = findViewById(R.id.det_facciones_titulo4);
        titulo5 = findViewById(R.id.det_facciones_titulo5);

        layout1 = findViewById(R.id.det_facciones_layout1);
        layout2 = findViewById(R.id.det_facciones_layout2);
        layout3 = findViewById(R.id.det_facciones_layout3);
        layout4 = findViewById(R.id.det_facciones_layout4);
        layout5 = findViewById(R.id.det_facciones_layout5);

        layout_rel_facciones = findViewById(R.id.layout_rel_facciones);
        layout_detfacciones_rel_razas = findViewById(R.id.layout_detfacciones_rel_razas);
        layout_detfacciones_rel_mundo = findViewById(R.id.layout_detfacciones_rel_mundo);
        layout_detfacciones_rel_heroes = findViewById(R.id.layout_detfacciones_rel_heroes);
    }
    
    
    private void rel_facciones() {

        //Relaciones Razas
        RecyclerView rvLista_facciones_rel_razas = findViewById(R.id.recycler_view_facciones_rel_razas);
        LinearLayoutManager manager_razas = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rvLista_facciones_rel_razas.setLayoutManager(manager_razas);
        List<lista_relacionados> items = getItems_razas();
        RecyclerAdapter_rel_raza adapter_razas = new RecyclerAdapter_rel_raza(items, this);
        rvLista_facciones_rel_razas.setAdapter(adapter_razas);

        
        //Relaciones Heroes
        RecyclerView rvLista_facciones_rel_heroes = findViewById(R.id.recycler_view_facciones_rel_heroe);
        LinearLayoutManager manager_heroes = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rvLista_facciones_rel_heroes.setLayoutManager(manager_heroes);
        List<lista_relacionados> items_heroes = getItems_heroes();
        RecyclerAdapter_rel_heroes adapter_heroes = new RecyclerAdapter_rel_heroes(items_heroes, this);
        rvLista_facciones_rel_heroes.setAdapter(adapter_heroes);

        
        //Relaciones Mundo
        RecyclerView rvLista_facciones_rel_mundo = findViewById(R.id.recycler_view_facciones_rel_mundo);
        LinearLayoutManager manager_mundo = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rvLista_facciones_rel_mundo.setLayoutManager(manager_mundo);
        List<lista_relacionados> items_mundo = getItems_mundo();
        RecyclerAdapter_rel_mundo adapter_mundo = new RecyclerAdapter_rel_mundo(items_mundo, this);
        rvLista_facciones_rel_mundo.setAdapter(adapter_mundo);

    }


    private List<lista_relacionados> getItems_razas() {
        return new ArrayList<>();
    }


    private List<lista_relacionados> getItems_heroes() {
        List<lista_relacionados> itemLists= new ArrayList<>();

        switch (titpag) {

            case "Horda Abisal":
                itemLists.add(new lista_relacionados("Vrogros","Underlord",R.drawable.perfil_underlord));
                itemLists.add(new lista_relacionados("Tresdin","Legion Commander",R.drawable.perfil_legion_commander));
                break;

            case "Ascendidos":
                itemLists.add(new lista_relacionados("Astral","Grimstroke",R.drawable.perfil_grimstroke));
                break;

            case "Legion de Ceniza":
                itemLists.add(new lista_relacionados("Mars","First Son of Heaven",R.drawable.perfil_mars));
                break;

            case "Profundos":

            case "Guardia Slithereen":
                itemLists.add(new lista_relacionados("Slardar","Slithereen Guard",R.drawable.perfil_slardar));
                itemLists.add(new lista_relacionados("Slithice","Naga Siren",R.drawable.perfil_naga));
                break;

            case "Continuum":
                itemLists.add(new lista_relacionados("Mars","First Son of Heaven",R.drawable.perfil_mars));
                itemLists.add(new lista_relacionados("Valora","Dawnbreaker",R.drawable.perfil_dawnbreaker));
                break;

            case "Círculo de Jasper":
                itemLists.add(new lista_relacionados("Riki","Stealth Assassin",R.drawable.perfil_riki));
                itemLists.add(new lista_relacionados("Mireska Sunbreeze","Dark Willow",R.drawable.perfil_willow));
                itemLists.add(new lista_relacionados("Meepo","Geomancer",R.drawable.perfil_meepo));
                break;
            case "Casa de Ambry":
                itemLists.add(new lista_relacionados("Banehallow","Lycan",R.drawable.perfil_lycan));
                break;

            case "Niebla Sangrienta y Niebla Roja":
                itemLists.add(new lista_relacionados("Mogul Khan","Axe", R.drawable.perfil_axe));
                break;

            case "Legión de Bronce":
                itemLists.add(new lista_relacionados("Tresdin","Legion Commander",R.drawable.perfil_legion_commander));
                itemLists.add(new lista_relacionados("Vrogros","Underlord",R.drawable.perfil_underlord));
                break;

            case "Armada de Claddish":
                itemLists.add(new lista_relacionados("Kunkka","Admiral",R.drawable.perfil_kunkka));
                itemLists.add(new lista_relacionados("Leviathan","Tidehunter",R.drawable.perfil_tide));
                break;

            case "Corte de Ristul":
                itemLists.add(new lista_relacionados("Nevermore","Shadow Fiend",R.drawable.perfil_sf));
                itemLists.add(new lista_relacionados("Vrogros","Underlord",R.drawable.perfil_underlord));
                itemLists.add(new lista_relacionados("shadow Demon","Demonio Sombrío",R.drawable.perfil_shadow));
                itemLists.add(new lista_relacionados("Akasha","Queen of Pain",R.drawable.perfil_qop));
                itemLists.add(new lista_relacionados("Razor","Lightning Revenant",R.drawable.perfil_razor));
                break;

            case "Eldwurms":
                itemLists.add(new lista_relacionados("Auroth","Winter Wyvern",R.drawable.perfil_ww));
                itemLists.add(new lista_relacionados("Davion","Dragon Knight",R.drawable.perfil_dragon));
                break;

            case "Casa Averno":
                itemLists.add(new lista_relacionados("Abbadon", "Lord of Avernus", R.drawable.perfil_abbadon));
                break;

            case "Monjes de Turstarkuri":
                itemLists.add(new lista_relacionados("Magina","Anti-Mage", R.drawable.perfil_antimage));
                itemLists.add(new lista_relacionados("Inai","Void Spirit",R.drawable.perfil_void));
                break;

            case "Galantes de Nivan":
                itemLists.add(new lista_relacionados("Pudge","Butcher",R.drawable.perfil_pudge));
                itemLists.add(new lista_relacionados("Donté Panlin","Pangolier",R.drawable.perfil_pangolier));
                break;

            case "Radiante y Diabólico":
                break;

            case "Hermanas del velo":
                itemLists.add(new lista_relacionados("Mortred","Phantom Assassin",R.drawable.perfil_pa));
                itemLists.add(new lista_relacionados("Donté Panlin","Pangolier",R.drawable.perfil_pangolier));
                break;

            case "Caballeros de la Vigilia":
                itemLists.add(new lista_relacionados("Sven","Rogue Knight",R.drawable.perfil_sven));
                itemLists.add(new lista_relacionados("Mireska Sunbreeze","Dark Willow",R.drawable.perfil_willow));
                break;

        }

        return itemLists;
    }


    private List<lista_relacionados> getItems_mundo() {

        List<lista_relacionados> lista_mundo_es= new ArrayList<>();

        switch (titpag) {
            case "Horda Abisal":
            case "Legión de Bronce":
                lista_mundo_es.add(new lista_relacionados("Palacio de Piedra", "StoneHall", R.drawable.stonehall));
                break;

            case "Armada de Claddish":
                lista_mundo_es.add(new lista_relacionados("Isla Temblorosa", "Trembling Isle", R.drawable.isla_temblorosa));
                break;
        }

        return lista_mundo_es;
    }


    private void initValues(){

        String tit_igual;

        lista_relacionados itemDetail = (lista_relacionados) getIntent().getExtras().getSerializable("itemDetail");
        img_facciones.setImageResource(itemDetail.getImg_principal());
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

            case "Horda Abisal":
                parrafos3("Cultura", "Invasión");
                rel("heroe_mundo");
                break;

            case "Ascendidos":
                parrafos2("Ritual");
                rel("heroe");
                break;

            case "Legion de Ceniza":

            case "Profundos":

            case "Continuum":

            case "Círculo de Jasper":

            case "Casa de Ambry":
                parrafos1();
                rel("heroe");
                break;

            case "Niebla Sangrienta y Niebla Roja":
                parrafos3("Red Mist", "Bloodmist");
                rel("heroe");
                break;

            case "Legión de Bronce":
                parrafos6("Rangos", "Equipamiento", "Campañas", "Destrucción", "Élite Stonehall");
                rel("heroe_mundo");
                break;

            case "Armada de Claddish":
                parrafos2("Destrucción");
                rel("heroe_mundo");
                break;

            case "Corte de Ristul":
                parrafos4("Miembros", "Laberinto Estrecho", "Los Siete Infiernos");
                rel("heroe");
                break;

            case "Eldwurms":
                parrafos6("Refugio de los Eldwurm", "Descripción", "Cultura", "Eldwurms Notables", "Enemigos");
                rel("heroe");
                break;

            case "Casa Averno":
                parrafos2("Las Tres Espadas");
                rel("heroe");
                break;

            case "Monjes de Turstarkuri":
                parrafos3("Prácticas", "Caída");
                rel("heroe");
                break;

            case "Galantes de Nivan":
                parrafos3("Acciones", "Relaciones");
                rel("heroe");
                break;

            case "Radiante y Diabólico":
                parrafos3("Radiant", "Dire");
                rel("vacio");
                break;

            case "Hermanas del velo":
                parrafos6("Oráculo del Velo", "Asesinas Fantasmas", "Velo Fantasma", "Artes Marciales", "Misiones");
                rel("heroe");
                break;

            case "Guardia Slithereen":
                parrafos4("Rangos y Unidades", "Batalla de Crey", "Batalla de Stonefish Gate");
                rel("heroe");
                break;

            case "Caballeros de la Vigilia":
                parrafos5();
                rel("heroe");
                break;

        }
    }


    private String Historia(String nombre, String tipo) {

        String hist = "";

        switch (nombre) {

            case "Horda Abisal":

                switch (tipo) {

                    case "texto1":
                        hist = "La Horda Abisal es una facción de demonios que habita en la ciudad subterránea de Aziyog. Están liderados por Vrogros, el Señor Subterráneo.\n" +
                                "Pudge puede haberse comido una vez a un miembro de la Horda Abisal.";
                        break;
                    case "texto2":
                        hist = "La Horda Abisal toma esclavos y utiliza sus huesos para construir los muros de su ciudad. Entre sus filas se encuentran monstruosos maestros de la forja, que fabrican una enorme espada para su señor supremo. Aquellos que se enfrenten a la Horda Abisal se enfrentarán inevitablemente a su destrucción o esclavización. Los esclavos muertos son arrojados al horno, posiblemente para alimentar las forjas.";
                        break;
                    case "texto3":
                        hist = "No satisfecho con las limitadas tierras de su dominio subterráneo, Vrogros se propuso conquistar las tierras de arriba. Abriendo una Grieta Oscura envía las legiones de la Horda Abisal a través del portal para poner a prueba a las naciones de arriba sabiendo bien que pueden ser derrotadas. Mientras tanto, la fuerza completa de la superficie se prepara para la invasión principal de abajo, mientras Vrogros sale a la superficie en persona, preparándose para abrir la grieta que llevará a su ejército conquistador al mundo de la superficie. La horda es evidentemente reservada o aislacionista ya que el mundo de la superficie nunca había oído o profetizado su llegada.\n" +
                                "\n" +
                                "Vrogros hizo su aparición en Stonehall donde sus fuerzas demoníacas se enfrentaron a Tresdin y la Legión de Bronce.";
                        break;
                        
                }
                break;

            case "Ascendidos":

                switch (tipo) {

                    case "texto1":
                        hist = "Los Ascendidos son los guardianes elegidos de Ashkavor. A través de un ritual sagrado establecen un vínculo entre ellos y todos los ashkavorianos, extrayendo inmensos poderes de sus almas colectivas para proteger Ashkavor.";
                        break;
                    case "texto2":
                        hist = "Los jóvenes son entrenados desde una edad temprana para asumir el manto de los ascendidos, lo que se consigue mediante la realización de un ritual sagrado. Sus maestros ponen un límite estricto a la hora de aumentar los efectos del ritual por precaución de poner en peligro a la población ashkavoriana. El día de la Ascensión el iniciado es llevado al centro de la ciudad donde hay una gran piedra rúnica en el templo central. Aquí, el iniciado realiza un hechizo vinculante pintando la piedra rúnica con un gran pincel, sumergido en tinteros mágicos. De este modo, el recién ascendido forma un vínculo con todos los demás ashkavorianos uniendo las almas de su pueblo a la suya en un gran lazo compartido por otros ascendidos.";
                        break;

                }
                break;

            case "Legion de Ceniza":

                if ("texto1".equals(tipo)) {
                    hist = "La Legión de la Ceniza era un grupo de hábiles guerreros que disfrutaban del combate. Luchaban con lanzas y escudos. La Legión de la Ceniza desafió al dios Marte y perdió pero ahora sirven voluntariamente como soldados no muertos para Marte, quien los convoca para formar una arena circular. Se desconoce si la Legión de la Ceniza está relacionada con la Legión de Bronce.";
                }
                break;

            case "Niebla Sangrienta y Niebla Roja":

                switch (tipo) {

                    case "texto1":
                        hist = "La Niebla Roja es un ejército Oglodi, notable por invadir los Mil Tarns. A sus soldados se les enseñaba a apuntar al cuello y a los cobardes se les obligaba a cortarse el pelo por vergüenza. Entre los Niebla Roja había un Segador, una figura respetada responsable de ejecutar a los que huían de la batalla. Además del combate los Niebla Roja también eran hábiles herreros y cada soldado era responsable de forjar su propia espada y escudo.\n" +
                                "\n" +
                                "Axe formaba parte de la Niebla Roja y fue escalando posiciones eliminando a sus rivales hasta que el único soldado que quedó fue él mismo. Entonces aprovechó esta oportunidad para declararse general de la Niebla Roja. Después de que la Niebla Roja cayera en desgracia fue sustituida por el ejército de Niebla Sangrienta.";
                        break;
                    case "texto2":
                        hist = "Después de Axe, el liderazgo de la Niebla Roja recayó en Sorla Khan, una oglodiana violenta y poco razonable. Sus acciones han molestado a gente como Yurnero, que cree que hay que ocuparse de ella.\n" +
                                "\n" +
                                "La Niebla Roja lanzó una ofensiva contra la Legión de Bronce de Tresdin en Roseleaf con resultados desconocidos. Mireska da a entender que la Niebla Roja salió victoriosa aunque esto es incierto.";
                        break;
                    case "texto3":
                        hist = "Bloodmist es un ejército que se levantó para ocupar el lugar del caído ejército de la Niebla Roja. Enseña a sus guerreros a apuntar al vientre.";
                        break;

                }
                break;

            case "Legión de Bronce":

                switch (tipo) {

                    case "texto1":
                        hist = "La Legión de Bronce es una de las divisiones militares de Stonehall, sus principales funciones son la defensa nacional y la conquista. Tiene una reputación temible y su comandante es Tresdin. Los colores de la Legión de Bronce son el rojo y el dorado.";
                        break;
                    case "texto2":
                        hist = "La Legión de Bronce es un heterogéneo conjunto de soldados de diferentes orígenes unidos bajo el objetivo común de luchar por Stonehall. Además de la obvia presencia de humanos dentro de la Legión también están los Vhoul, los Ogros, los Sátiros, los Odobenus e incluso los creeps Radiants entre sus vastas filas.\n" +
                                "\n" +
                                "Se dice que su rasgo distintivo es la disciplina y sus soldados siempre están entrenando cuando están fuera de combate.";
                        break;
                    case "texto3":
                        hist = "En las armerías de la infantería de la Legión de Bronce, los legionarios ligeros tienen acceso a varias espadas de una mano, picas, lanzas, arcos, flechas, escudos boetianos/aspis, redes de cuchillas, mazas que llevan el símbolo de la serpiente de toro como cabeza, hachas de guerra, etc. Las tropas más pesadas, como los ogros, reciben enormes garrotes, martillos de guerra y los mismos escudos. Su equipo puede ser forjado por los herreros de Stonehall o por los mercenarios Smeevils que forjan armas y armaduras para cualquier bando que solicite su servicio.\n" +
                                "\n" +
                                "Durante el asedio a Roseleaf la Legión de Bronce defendió las murallas de las escalas de los asaltantes de Oglodi y de otros Oglodi que podían escalar las murallas derramando aceite quemado sobre los que intentaban escalar. Junto a otras almenas mal construidas en Roseleaf la Legión de Bronce utilizó lodestones pero fueron saboteados por Lorlin Lasan del Círculo de Jasper (en nombre de la Niebla Roja) que consiguió volver sus defensas contra ellos. El resultado fue que el magnetismo de la lodestone atrajo a los soldados blindados cercanos hacia ella, destruyendo las defensas mal construidas y reteniendo a las pobres tropas atrapadas en ella. También tienen acceso a lo que parece ser un primitivo tanque o máquina de asedio.";
                        break;
                    case "texto4":
                        hist = "Transgresión en Tares\n" +
                                "El reino vecino de Tares pasó siglos manteniendo su devoción por sus colonizadores de Stonehall. Han pasado muchos siglos de servidumbre y los nobles taresianos finalmente han considerado necesario devolverles el golpe, negociando en secreto para amasar un ejército de soldados pobres y mercenarios baratos que han sido motivados con las susurradas promesas de un botín de oro y una vida libre de las legiones del tirano de Stonehall.\n" +
                                "La noticia de su rebelión ha llegado de algún modo a la inteligencia de Stonehall lo que ha llevado al emperador Galanius a enviar a la Legión de Bronce. La Comandante de la Legión Tresdin y sus subordinados Marcus y Rix fueron enviados para destruir la escasa oposición y llevar a los conspiradores ante la justicia.\n" +
                                "\n" +
                                "Huída a Filedo\n" +
                                "Tresdin, Marcus, Rix y el resto de la selecta Legión de Bronce persiguen a los restantes nobles taresianos que han huido a Filedo utilizando la batalla librada en sus tierras como distracción.\n" +
                                "\n" +
                                "Roseleaf\n" +
                                "Dirigida por Tresdin la Legión de Bronce intentó contener al ejército de la Niebla Roja en Roseleaf. Los detalles son escasos, salvo los indicios de que Tresdin tomó malas decisiones y pudo haber iniciado la lucha, lo que resultó en un desastre para la Legión de Bronce. Después de la batalla Mireska encontró en el lugar la Bandera de la Serpiente de Toro, que puede ser el emblema de la legión.";
                        break;
                    case "texto5":
                        hist = "Cuando Stonehall fue atacada por el Señor Subterráneo y su Horda Abisal, la Legión de Bronce fue la única división lo suficientemente cercana como para acudir en ayuda de la ciudad. Aunque Tresdin pudo hacer retroceder a los invasores demoníacos, la Legión de Bronce fue destruida en gran medida en la batalla.";
                        break;
                    case "texto6":
                        hist = "La Élite Stonehall es una subdivisión de la Legión de Bronce. Fue creada por Belasanno después de que Rix traicionara a la Legión de Bronce.";
                        break;

                }
                break;

            case "Armada de Claddish":

                switch (tipo) {

                    case "texto1":
                        hist = "La Armada de Claddish es una poderosa flota que opera desde la nación insular de Cladd. Está dirigida por su almirante, Kunkka, a quien se le encargó la defensa de su patria. Los colores de la Armada de Cladd son el azul y el dorado. Los marineros de Cladd están armados con sables y pistolas de pedernal. Los barcos están tripulados por cañones dirigidos por un capitán especial que lleva un casco emplumado. Los veteranos distinguidos reciben un sello de honor hecho en forma de halcón.";
                        break;
                    case "texto2":
                        hist = "Durante la batalla en la Isla Temblorosa la Armada de Claddish se enfrentó a los Demonios de la Catarata con la ayuda de espíritus ancestrales invocados por los Magos Suicidas. Sin embargo ambas flotas fueron destruidas por Maelrawn dejando tras de sí sólo un barco fantasma que seguía siendo comandado por Kunkka. Tidehunter tropezó más tarde con la flota hundida y reclamó el mástil del buque insignia como arma.";
                        break;

                }
                break;

            case "Corte de Ristul":

                switch (tipo) {

                    case "texto1":
                        hist = "La Corte de Ristul es un séquito de seres infernales que son representantes de sus respectivos infiernos y del más allá. Están dirigidos por destacados habitantes de los Siete Infiernos y del más allá que le precede, como el Laberinto Estrecho.\n" +
                                "\n" +
                                "La Corte de Ristul es el nexo de unión entre el mundo de los demonios, el camino que conduce a él y los mundos exteriores. Están dispuestos a escuchar a quienes buscan una audiencia con ellos, especialmente a los desesperados por el poder y otras necesidades. La Corte de Ristul se esfuerza por atender a los desesperados y sin esperanza. A partir de ahí, estas personas se despojan de su moral y acuden a la Corte de Ristul para que les preste su impía fuerza y recursos.\n" +
                                "\n" +
                                "La Corte de Ristul obtiene su fuerza e influencia en el plano material de estas personas. Aquellos que buscan una audiencia con la Corte de Ristul no se someten a transacciones simples y mundanas. Un representante de la corte reclamará su alma y colocará una marca sobre ellos para significar su vínculo y lealtad a la corte, generalmente obteniendo poderes impíos en el proceso.\n" +
                                "\n" +
                                "Aunque la Corte de Ristul puede parecer una demostración de que incluso los demonios tienen etiqueta y política, no siempre es así. Aunque los demonios carecen de moral no carecen de jerarquía. En la Corte de Ristul el equilibrio de poder se desplaza constantemente hacia aquellos que aumentan su influencia. Como criaturas egocéntricas y egoístas los demonios de la corte siempre están compitiendo por el poder y la influencia sobre la Corte de Ristul, incluso dispuestos a poner a sus propios parientes bajo sus talones.\n" +
                                "\n" +
                                "A partir de Artifact, la Corte de Ristul está dirigida actualmente por tres señores demonio: Shadow Fiend, Underlord y B'Kor.";
                        break;
                    case "texto2":
                        hist = "La Corte de Ristul está representada por muchas entidades. Algunos de sus miembros tienen cultos y seguidores y otros simplemente representan a la corte por su cuenta.";
                        break;
                    case "texto3":
                        hist = "Razor, El Relámpago Renacido, es un miembro de la Corte de Ristul pero representa el más allá conocido como el Laberinto Estrecho.";
                        break;
                    case "texto4":
                        hist = "Shadow Fiend\n" +
                                "Nevermore se encuentra actualmente entre los tres señores demonio que gobiernan la Corte de Ristul. Tiene un rebaño de discípulos que se asemejan a su forma para llevar a cabo sus órdenes, como hacer tratos con los mortales.\n" +
                                "\n" +
                                "Underlord\n" +
                                "Vrogros es uno de los tres señores demoníacos que gobiernan la Corte de Ristul. También tiene un rebaño de discípulos y adoradores que apoyan su gobierno. Durante su tiempo como señor de los demonios ya estaba planeando su invasión a Stonehall.\n" +
                                "\n" +
                                "B'Kor\n" +
                                "Hermano de la súcubo Akasha, B'Kor es uno de los tres señores de demonios que gobiernan la Corte de Ristul. Al igual que sus compañeros, tiene un grupo de discípulos que le ayudan. Se dice que es el \"maestro de ceremonias\" entre ellos.\n" +
                                "\n" +
                                "Shadow Demon\n" +
                                "Según Dota Underlords, Shadow Demon es un miembro de la Corte de Ristul.\n" +
                                "\n" +
                                "Knogh\n" +
                                "Knogh fue una vez el heredero de una poderosa familia de demonios destinado a gobernar la Corte de Ristul. Fue forzado a la servidumbre en el plano mortal por Vanessa y con su ausencia, no pudo cumplir su destino. Aunque su poder disminuyó en el reino de los mortales, no perdió su derecho de nacimiento, que más tarde fue entregado a Akasha, quien lo convenció de transferir su poder a ella.\n" +
                                "\n" +
                                "Anessix\n" +
                                "Anessix es un demonio terrestre sin mucha influencia en la corte. Está estresada con su deuda de oro y almas con la Corte de Ristul y no posee mucho poder en comparación con los demonios mayores de la corte. Sin embargo, tiene una gran influencia sobre White Spire como la Señora de los Secretos, revelando secretos y misterios a aquellos que buscan el poder. Debido a esto, ha amasado un culto de adoradores que la ayudan a controlar Little Revtel, un gran distrito situado en White Spire.";
                        break;

                }
                break;

            case "Profundos":

                if ("texto1".equals(tipo)) {
                    hist = "Los Profundos son una facción encargada de custodiar la Bóveda Profunda, que contiene los vastos tesoros de las ciudades hundidas, antaño en lo alto de las montañas. Slardar es su miembro más destacado, enviado a explorar y dar caza a quienes quieran robar del tesoro. Se desconoce si la facción es exclusiva de los Slithereen o está abierta a otras razas.\n" +
                            "\n" +
                            "Una unidad de guardias de élite protege a los Profundos, una vez liderada por Slithice, que defendía una bóveda situada en Crey. Desde entonces ha sido desterrada por los Profundos después de que se revelara que se había tomado un cáliz de la bóveda y sólo puede volver si recupera con éxito el cáliz desaparecido.\n" +
                            "\n" +
                            "Los miembros que traicionan a los Profundos son enviados a la prisión del Arrecife Oscuro.";
                }
                break;

            case "Eldwurms":

                switch (tipo) {

                    case "texto1":
                        hist = "Los Eldwurms (también conocidos como eldwyrms, elderwurms, grandes dragones) son dragones viejos, sabios y poderosos en el lore de Dota 2.";
                        break;
                    case "texto2":
                        hist = "Auroth menciona a menudo un lugar donde los Eldwurms se reúnen para descansar. Este refugio es un mirador ya que Auroth pudo ver el campo de batalla de los Ancestros desde este puesto.";
                        break;
                    case "texto3":
                        hist = "Los Eldwurms se definen por su edad y conocimientos más que por sus características físicas comunes ya que parece que cualquier especie de dragón puede ser un Eldwurm si cumple los requisitos de ser viejo y sabio. Por lo tanto son una clase intelectual de dragones más que una especie o cepa de dragón.";
                        break;
                    case "texto4":
                        hist = "Eldwurm Eddas\n" +
                                "Escritas no sólo por un Eldwurm sino por cualquiera de ellos, las Eddas de los Eldwurm (también conocidas como Edda de los Eldwurm, sagas de los Eldwurm, etc.) son un enorme poema, como una edda o una saga, que relata la colorida historia de los Eldwurm, así como otras maravillas y terrores del mundo que sus autores pudieran registrar.\n" +
                                "\n" +
                                "Mito de los Antiguos\n" +
                                "El Mito del Antiguo es, bueno, un mito antiguo. No se dice mucho sobre su contenido. Por alguna razón tiene que ver con Auroth. Lo único que se sabe actualmente sobre el Mito Antiguo es que si uno pide a dos dragones su opinión sobre él puede recibir cinco respuestas.\n" +
                                "\n" +
                                "Resistencia a la Muerte\n" +
                                "En su búsqueda del conocimiento los antiguos eldwurms han aprendido técnicas para evitar la propia muerte.";
                        break;
                    case "texto5":
                        hist = "Slyrak\n" +
                                "Slyrak es un enorme y poderoso Eldwurm que posee muchos siglos de sabiduría. Es más conocido por haber transferido su fuerza y sabiduría a Dragon Knight, este último se ha fusionado con el valor de Sir Davion junto con la sabiduría de los otros Eldwurms, ambos son ahora la fuente de su nobleza.\n" +
                                "\n" +
                                "Winter Wyvern\n" +
                                "Auroth, Winter Wyvern, es otra Eldwurm, pero en realidad es la última Eldwurm que queda, sin contar a Slyrak, que existe parcialmente en este mundo. Como tal es la última guardiana de la Edda de los Eldwurm y quizás la Eldwurm más antigua que existe.";
                        break;
                    case "texto6":
                        hist = "Parece que Lich está mal dispuesto con los dos Eldwurms restantes. Busca combatir y tal vez matar a Slyrak y ha hecho algo malo a Auroth que ha conmocionado a Viper, lo que implica algún tipo de apuñalamiento por la espalda. Su mala acción contra Auroth puede haber tenido lugar después de que se interesara por ella en Artifact.";
                        break;

                }
                break;

            case "Casa Averno":

                switch (tipo) {

                    case "texto1":
                        hist = "La Casa Averno es una familia noble. Son protectores de su tierra y sus tradiciones, la más importante de las cuales es la Fuente mística del Averno. Al nacer, los vástagos de la casa son bañados en las nieblas negras de la Fuente lo que les otorga una conexión innata con las energías místicas de la tierra. Su educación hace hincapié en el entrenamiento militar para que puedan liderar el ejército de la familia para defender sus tierras ancestrales. Una clase sacerdotal supervisa los asuntos relacionados con la Fuente. La Casa del Averno lanza maldiciones sobre sus enemigos ralentizando sus movimientos y acelerando a sus perseguidores.";
                        break;
                    case "texto2":
                        hist = "La Casa Averno posee tres espadas legendarias. Sólo se conocen dos.\n" +
                                "\n" +
                                "1. Rompenieblas\n" +
                                "\n" +
                                "2. Darkstar, la forjaniebla, puede ser otra aunque no se indica específicamente.";
                        break;

                }
                break;

            case "Casa de Ambry":

                if ("texto1".equals(tipo)) {
                    hist = "La Casa de Ambry era una casa noble y el mayor miembro de la casta terrateniente del reino de Slom. Estaba encabezada por Lord Ambry. Tenían cierto derecho a la realeza ya que tenían entre ellos generales de sangre noble lo que sugería fuerzas militares bajo su mando.\n" +
                            "\n" +
                            "Cuando el Último Rey de Slom se corrompió visiblemente la Casa de Ambry envió seis mil guerreros para tomar la capital pero fracasó, dando lugar a la Masacre de los Apóstatas. Enfurecido por la traición el Rey ordenó que trajeran a Lord Ambry ante él e hizo que sus hechiceros maldijeran a Banehallow, el hijo de Lord Ambry, con licantropía con la intención de que matara a su propio padre. Banehallow, en cambio, escapó en su forma de lobo mientras que Lord Ambry fue finalmente ejecutado por el propio Rey. El vasto linaje de Ambry fue eliminado por decreto real, dejando a Banehallow, el licántropo como su último miembro superviviente.\n" +
                            "\n" +
                            "Tras la caída de la Casa, la finca de la familia Ambry fue saqueada.";
                }
                break;

            case "Círculo de Jasper":

                if ("texto1".equals(tipo)) {
                    hist = "El Círculo de Jaspe es una organización especializada en actividades ilícitas. Llevan a cabo sus tortuosas acciones con ética profesional lo que les da un aire respetable.\n" +
                            "\n" +
                            "Lorlin Lasan y Riki son probables miembros de la organización ya que ambos son asesinos. Mireska trabajó y aprendió una vez bajo las órdenes de Lasan en el Círculo de Jasper pero decidió no unirse porque no quería ser una \"chica de los recados\".\n" +
                            "\n" +
                            "Meepo ya ha tratado con el Círculo de Jasper y, al parecer, tiene una deuda pendiente con ellos. Por ello Lasan y el Círculo de Jasper quieren asesinarle.";
                }
                break;

            case "Monjes de Turstarkuri":

                switch (tipo) {

                    case "texto1":
                        hist = "Los Monjes de Turstarkuri eran una facción ascética que practicaba la meditación profunda, siguiendo las enseñanzas de Inai en lo alto de su monasterio de montaña en Turstarkuri. Debido a su relación con Inai, los monjes pueden estar relacionados con el Templo Oculto.";
                        break;
                    case "texto2":
                        hist = "Evitaban los dioses y la magia, creían en la paz y el pragmatismo. Meditando sobre cojines de seda, los monjes bebían té y ortigas mientras vigilaban los pergaminos dogmáticos de Turstarkuri. Poco se sabe de sus secretos salvo que sus técnicas implicaban volver la magia contra sus usuarios y que los practicantes parecen tener una visión sobrenatural a través de un \"ojo de la mente\".\n" +
                                "\n" +
                                "Cuando Inai salió del Templo Oculto reveló que los monjes habían malinterpretado sus enseñanzas y que estaban consumidos por su propia locura.";
                        break;
                    case "texto3":
                        hist = "Cuando las legiones del Dios Muerto invadieron los reinos bajo las montañas, los monjes permanecieron en meditación, creyendo que los invasores eran meras visiones demoníacas enviadas para distraerlos. Al cabo de apenas quince días, fueron asesinados en el acto y sus cuerpos se alzaron para unirse a las filas de los invasores. Sólo Anti-Mage, entonces un joven acólito de los Turstarkuri, consiguió escapar con varios de los preciados pergaminos de los monjes.";
                        break;

                }
                break;

            case "Galantes de Nivan":

                switch (tipo) {

                    case "texto1":
                        hist = "Los Galanes de Nivan son una organización de hombres y mujeres que dedican su vida a la esgrima, el romance y la aventura. Comprometidos con un código de honor y justicia los galantes buscan batallas contra los tiranos evitando una conducta deshonrosa. Sus miembros parecen estar formados por una raza similar a la de los pangolines. Unirse a la organización no es poca cosa y los aspirantes deben pasar por un extenso entrenamiento en artes marciales. En sus campos de entrenamiento hay escuelas e iglesias así como maniquíes de madera y rampas rodantes.\n" +
                                "\n" +
                                "Hedonistas y amantes de la diversión los galantes se entregan al vino, al amor y tienen un fuerte sentido de la camaradería y competición entre sus miembros. Su honor les lleva a rechazar la esclavitud, la servidumbre y a apiadarse de los débiles, los jóvenes y los discapacitados. Prefieren el combate directo al clandestino. Después de una victoria, celebran y brindan por sus gloriosas acciones.\n" +
                                "\n" +
                                "El lema de los galanes nivanos es \"Una vida de aventuras es la única que merece la pena\". Sus armas favoritas son los estoques y los mosquetes.";
                        break;
                    case "texto2":
                        hist = "Los galantes se encuentran en conflicto con los opresores, librando una guerra contra el rey Sylak. Durante esa guerra los galantes lucharon contra los piromantes del rey y ninguno sobrevivió salvo el joven Donte Panlin. Su mentor, Etienne Swiftguard, cayó en el combate pero no antes de entregarle a Donte su mosquete, que éste sigue utilizando hoy en día. La mayor parte de las veces realizan sus hazañas en campo abierto y disfrutan de la fama que acompaña a las noticias de sus hazañas. Sin embargo los galanes a veces actúan en secreto poniéndose máscaras para proteger a sus pupilos y a ellos mismos.\n" +
                                "\n" +
                                "Aparte de los tiranos los galanes también luchan y matan demonios además de buscar el peligro allá donde vayan.";
                        break;
                    case "texto3":
                        hist = "los Nivan Gallant son amigos de la Orden del Oyo, quizás por su amor compartido por el vino.\n" +
                                "\n" +
                                "Pudge se comió una vez a un miembro de los galantes quien juró que sus hermanos se vengarían por él. Esto aún no ha sucedido.";
                        break;

                }
                break;

            case "Radiante y Diabólico":

                switch (tipo) {

                    case "texto1":
                        hist = "Radiant es una facción que se caracteriza por un tema brillante y natural mientras que Dire se caracteriza por una temática oscura y sombría. \n" +
                                "\n" +
                                "La mitad inferior izquierda del mapa del juego pertenece a los Radiant mientras que la superior derecha pertenece a los Dire.";
                        break;
                    case "texto2":
                        hist = "Radiant es una de las Piedras Némesis, una fuerza diametralmente opuesta a los Dire.\n" +
                                "\n" +
                                "Radiant es conocido por Zet como Radinthul. Originalmente mantenía a los Dire y a los Radiant bajo control pero perdió el control tras la destrucción de la Luna Loca.\n" +
                                "\n" +
                                "El oro radiante se puede encontrar en las tierras radiantes. Es un mineral brillante y azulado con propiedades mágicas benévolas que a veces se utiliza para fabricar armas y herramientas.\n" +
                                "\n" +
                                "El Oro Radiante se utilizó para crear el Demon Edge.";
                        break;
                    case "texto3":
                        hist = "Dire es una de las Piedras Némesis, una fuerza diametralmente opuesta a Radiant.\n" +
                                "\n" +
                                "Zet lo conoce como Diruulth. Originalmente mantenía a raya a los Dire y a los Radiant pero perdió el control tras la destrucción de la Luna Loca.\n" +
                                "\n" +
                                "El Dire propaga la corrupción.\n" +
                                "\n" +
                                "La luz del sol y la luna contrarrestan las influencias de Dire.\n" +
                                "\n" +
                                "Earthshaker se opone a Dire blandiendo un tótem que absorbe la luz para desterrar su corrupción.\n" +
                                "\n" +
                                "La Piedra Diabólica se utilizó para crear el Demon Edge.";
                        break;

                }
                break;

            case "Hermanas del velo":

                switch (tipo) {

                    case "texto1":
                        hist = "Las Hermanas del Velo, también conocidas como las Hermanas Veladas o las Veladas, son una organización secreta que practica asesinatos rituales. Como su nombre indica la mayoría de sus miembros, si no todos, son mujeres.";
                        break;
                    case "texto2":
                        hist = "Entre la orden se encuentra el venerado Oráculo Velado, quien pronuncia los nombres de los que van a morir. Aunque es raro se sabe que el Oráculo Velado ha nombrado a otros miembros de la Hermandad para asesinarlos. Por ello, la Hermandad toma precauciones especiales para evitar ser asesinada por uno de los suyos.";
                        break;
                    case "texto3":
                        hist = "Las Hermanas Veladas creen que el asesinato es una parte sagrada del orden natural. Para conseguirlo seleccionan niñas con un método de adivinación para entrenarlas y educarlas como Asesinas Fantasma. Las niñas son criadas sin identidad propia, salvo su devoción a las Hermanas Veladas. Sus objetivos se determinan aparentemente al azar, a través de meditaciones y profecías que no hacen distinción entre las clases de hombres. Las víctimas son consideradas como sacrificios y la muerte a manos de una Asesina Fantasma se considera un honor. Las Asesinas Fantasma tienen prohibido pronunciar su propio nombre. Mortred es la única que ha roto esta regla.\n" +
                                "\n" +
                                "Las Asesinas Fantasma se consideran una dentro de la orden. Cuando una Asesina Fantasma cae, otra se levanta para tomar su lugar. El número total de Asesinas Fantasma es desconocido.";
                        break;
                    case "texto4":
                        hist = "Cada asesina lleva un Velo Fantasma sobre su rostro, hecho de seda. También hay indicios de que el Velo Fantasma es un concepto metafísico ya que Mortred afirma que incluso los muertos no pueden \"ver más allá del Velo Fantasma\". También creen que sus propias muertes representan un fracaso para el Velo y que sus asesinatos son requeridos por el \"patrón del Velo\".";
                        break;
                    case "texto5":
                        hist = "Las asesinas de las Hermanas del velo están muy bien entrenadas en el uso de espadas y guadañas de doble filo. Las aprendices adquieren y demuestran sus habilidades en el campo de pruebas.\n" +
                                "\n" +
                                "La primera habilidad que se aprende es el arte de lanzar dagas que se utiliza para incapacitar o distraer a un objetivo antes de entrar en combate. A las asesinas se les enseña a meditar, lo que mejora sus habilidades para anticiparse a los ataques que les llegan. Mediante la voluntad divina las Asesinas Fantasma pueden asestar golpes decisivos, a menudo acabando con la vida de un objetivo de un solo golpe. Las armas de las Asesinas Fantasma van desde cuchillas largas y ágiles hasta otras más pesadas y curvas. Sobre todo, las Hermanas Veladas se enorgullecen de tener armas que pueden atravesar cualquier cosa.";
                        break;
                    case "texto6":
                        hist = "Las Hermanas tienen negocios en la ciudad mercantil de Revtel aunque su naturaleza exacta no está clara. Estos tratos han despertado rumores, escuchados por Donte Panlin, que advierte a Mortred de que los reyes de la ciudad se enfadarán cuando se enteren de sus acciones.";
                        break;

                }
                break;

            case "Guardia Slithereen":

                switch (tipo) {

                    case "texto1":
                        hist = "La Guardia Slithereen es una unidad de Slithereen y Nagas, encargadas de defender a los Profundos y su tesoro lleno de riquezas hundidas. Sus miembros son Slardar y Naga Siren. Los comandantes de la guardia llevan cascos adornados con brillantes penachos amarillos. Los miembros distinguidos de la guardia pueden ser admitidos en la prestigiosa Orden del Ciprín.";
                        break;
                    case "texto2":
                        hist = "Entre la guardia hay miembros de élite, los altos juramentados. Observan un estricto juramento, repetido antes de la batalla: Ningún Slithereen puede fallar. El honor es muy valorado. Si uno de los altos juramentados falla en sus deberes es desterrado hasta que pueda cumplir con sus obligaciones. Slithice es uno de los altos juramentados.\n" +
                                "\n" +
                                "Los miembros más hábiles son designados como centuriones. Otra unidad de élite de la guardia se llama El Diluvio, y está liderada por la Primera Lanza, cargo que actualmente ocupa Slardar.";
                        break;
                    case "texto3":
                        hist = "Una gran batalla tuvo lugar en Crey entre la Guardia Slithereen y un ejército de Levianths merodeadores, en busca de tributo para su dios, Maelrawn. Slithice lideró una fuerza de cien guardias para defender los tesoros hundidos, la mayoría de los cuales fueron masacrados en la lucha. Aunque lograron repeler a los Levianths se encontró que faltaba un cáliz del tesoro hundido. Por este descuido Slithice fue despojada de su rango, exiliada y obligada a cubrirse la cabeza hasta encontrar y devolver el único cáliz.";
                        break;
                    case "texto4":
                        hist = "La Guardia Slithereen, junto con Slithice, estuvo presente en la Batalla de la Puerta de Pez de Piedra, llamada allí para ayudar al Cónclave de la Salmuera. Su oponente es desconocido.";
                        break;

                }
                break;

            case "Continuum":

                if ("texto1".equals(tipo)) {
                    hist = "El Continuum es una facción misteriosa. Mars luchó contra el Continuum en campañas que duraron siglos. Sheragndar podría haber sido un miembro del Continuum. Dawnbreaker contra el Continuum durante un periodo de tiempo desconocido.";
                }
                break;

            case "Caballeros de la Vigilia":

                switch (tipo) {

                    case "texto1":
                        hist = "Los Caballeros de la Vigilia son una orden de caballeros que siguen un estricto código de conducta prescrito en el Códice de la Vigilia. Tienen su base en la Fortaleza de la Vigilia. La orden posee la Cuchilla de los Desterrados, el Yelmo Sagrado y se encarga de una cierta Llama Sagrada. Los Caballeros de la Vigilia también son expertos armeros. Su símbolo puede verse reflejado en una de sus armas, el Sello de la Vigilia.\n" +
                                "\n" +
                                "Bajo el estandarte de los Caballeros de la Vigilia navegan galeras, algunas de ellas con armas.";
                        break;
                    case "texto2":
                        hist = "Existen varias sectas dentro de los Caballeros de la Vigilia:\n" +
                                "\n" +
                                "Los Guardianes de la Llama\n" +
                                "Una pequeña secta de expertos espadachines estacionados en la Columnata Interior para proteger la Llama Sagrada.\n" +
                                "\n" +
                                "Mono Militis\n" +
                                "Una secta encargada de perseguir a los miembros que se han desviado de las enseñanzas del Códice de la Vigilia.\n" +
                                "\n" +
                                "Guardia Cincelada\n" +
                                "Una secta perdida cuya causa es desconocida. Puede o no estar relacionada con los Caballeros de la Vigilia.";
                        break;
                    case "texto3":
                        hist = "El padre de Sven era miembro de la orden hasta que fue ejecutado por violar el Códice de la Vigilia. Más tarde Sven se unió a los Caballeros de la Vigilia sin revelar su identidad. Los Caballeros de la Vigilia consideraban la existencia de Sven una \"abominación\", quizás por su origen mestizo, aunque esto es incierto. La orden celebra una ceremonia de Juramentación para sus iniciados, en la que Sven estaba a punto de participar tras trece años de estudio con la orden. Sin embargo, ese día, Sven rompió el Yelmo Sagrado de la orden, tomó para sí la Espada Proscrita y quemó el Códice de la Vigilia en la Llama Sagrada. El guantelete de hierro de Sven, que utiliza para lanzar el Martillo de la Tormenta también fue arrebatado a la orden. Los Caballeros de la Vigilia fueron aparentemente aplastados por Sven, aunque no del todo. Hasta el día de hoy la orden sigue intentando reclamar la Hoja de los Proscritos a Sven.";
                        break;
                    case "texto4":
                        hist = "Un grupo de Caballeros de la Vigilia, ahora conocido como La Vigilia Perdida, desapareció en una patrulla y normalmente se supone que se perdió en el mar. Algunos creen, sin embargo, que llegaron a las tierras de Ashkavor, donde fueron vistos por los ashkavorianos en las montañas cercanas a Fellstrath.";
                        break;
                    case "texto5":
                        hist = "Los Caballeros de la Vigilia han luchado o intentado someter a Mireska antes por razones desconocidas.";
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

    @SuppressLint("SetTextI18n")
    private void parrafos5() {

        texto1.setText(Historia(titpag, "texto1"));
        texto2.setText(Historia(titpag, "texto2"));
        texto3.setText(Historia(titpag, "texto3"));
        texto4.setText(Historia(titpag, "texto4"));
        texto5.setText(Historia(titpag, "texto5"));

        titulo1.setText("Sectas");
        titulo2.setText("Sven");
        titulo3.setText("La Vigilia Perdida");
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
                layout_detfacciones_rel_mundo.setVisibility(View.GONE);
                layout_detfacciones_rel_razas.setVisibility(View.GONE);
                break;
            case "mundo":
                layout_detfacciones_rel_heroes.setVisibility(View.GONE);
                layout_detfacciones_rel_razas.setVisibility(View.GONE);
                break;
            case "raza":
                layout_detfacciones_rel_heroes.setVisibility(View.GONE);
                layout_detfacciones_rel_mundo.setVisibility(View.GONE);
                break;
            case "heroe_mundo":
                layout_detfacciones_rel_razas.setVisibility(View.GONE);
                break;
            case "heroe_raza":
                layout_detfacciones_rel_mundo.setVisibility(View.GONE);
                break;
            case "mundo_raza":
                layout_detfacciones_rel_heroes.setVisibility(View.GONE);
                break;
            case "vacio":
                layout_detfacciones_rel_heroes.setVisibility(View.GONE);
                layout_detfacciones_rel_mundo.setVisibility(View.GONE);
                layout_detfacciones_rel_razas.setVisibility(View.GONE);
                layout_rel_facciones.setVisibility(View.GONE);
                break;
            case "heroe_mundo_raza":
                break;
        }

    }


    @Override
    public void itemClick(lista_relacionados item) {

        try {
            Intent intent = new Intent(this, detalle_facciones.class);
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