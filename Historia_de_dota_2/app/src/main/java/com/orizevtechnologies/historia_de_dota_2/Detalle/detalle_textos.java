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

public class detalle_textos extends AppCompatActivity implements RecyclerAdapter_rel_raza.RecyclerItemClick,
        RecyclerAdapter_rel_heroes.RecyclerItemClick_heroes, RecyclerAdapter_rel_mundo.RecyclerItemClick_mundo{

    private ImageView img_textos;
    private TextView tit_es;
    private TextView tit_en;
    private String titpag;

    private TextView texto1;
    private TextView texto2;
    private TextView texto3;
    private TextView texto4;

    private TextView titulo1;
    private TextView titulo2;
    private TextView titulo3;

    private LinearLayout layout1;
    private LinearLayout layout2;
    private LinearLayout layout3;
    private LinearLayout layout_rel_textos;
    private LinearLayout layout_dettextos_rel_razas;
    private LinearLayout layout_dettextos_rel_mundo;
    private LinearLayout layout_dettextos_rel_heroes;
    private AdView mAdView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_textos);

        try {
            initViews();
            initValues();
            ActionBar();
            rel_textos();
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

        mAdView = findViewById(R.id.adView_det_textos);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    private void initViews() {
        img_textos = findViewById(R.id.fondo_textos_detalle);
        tit_es = findViewById(R.id.titulo_espanol_det_textos);
        tit_en = findViewById(R.id.titulo_ingles_det_textos);

        texto1 = findViewById(R.id.det_textos_texto1);
        texto2 = findViewById(R.id.det_textos_texto2);
        texto3 = findViewById(R.id.det_textos_texto3);
        texto4 = findViewById(R.id.det_textos_texto4);

        titulo1 = findViewById(R.id.det_textos_titulo1);
        titulo2 = findViewById(R.id.det_textos_titulo2);
        titulo3 = findViewById(R.id.det_textos_titulo3);

        layout1 = findViewById(R.id.det_textos_layout1);
        layout2 = findViewById(R.id.det_textos_layout2);
        layout3 = findViewById(R.id.det_textos_layout3);

        layout_rel_textos = findViewById(R.id.layout_rel_textos);
        layout_dettextos_rel_razas = findViewById(R.id.layout_dettextos_rel_razas);
        layout_dettextos_rel_mundo = findViewById(R.id.layout_dettextos_rel_mundo);
        layout_dettextos_rel_heroes = findViewById(R.id.layout_dettextos_rel_heroes);

    }


    private void rel_textos() {

        //Relaciones Razas
        RecyclerView rvLista_textos_rel_razas = findViewById(R.id.recycler_view_textos_rel_razas);
        LinearLayoutManager manager_razas = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rvLista_textos_rel_razas.setLayoutManager(manager_razas);
        List<lista_relacionados> items = getItems_razas();
        RecyclerAdapter_rel_raza adapter_razas = new RecyclerAdapter_rel_raza(items, this);
        rvLista_textos_rel_razas.setAdapter(adapter_razas);


        //Relaciones Heroes
        RecyclerView rvLista_textos_rel_heroes = findViewById(R.id.recycler_view_textos_rel_heroe);
        LinearLayoutManager manager_heroes = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rvLista_textos_rel_heroes.setLayoutManager(manager_heroes);
        List<lista_relacionados> items_heroes = getItems_heroes();
        RecyclerAdapter_rel_heroes adapter_heroes = new RecyclerAdapter_rel_heroes(items_heroes, this);
        rvLista_textos_rel_heroes.setAdapter(adapter_heroes);


        //Relaciones Mundo
        RecyclerView rvLista_textos_rel_mundo = findViewById(R.id.recycler_view_textos_rel_mundo);
        LinearLayoutManager manager_mundo = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rvLista_textos_rel_mundo.setLayoutManager(manager_mundo);
        List<lista_relacionados> items_mundo = getItems_mundo();
        RecyclerAdapter_rel_mundo adapter_mundo = new RecyclerAdapter_rel_mundo(items_mundo, this);
        rvLista_textos_rel_mundo.setAdapter(adapter_mundo);

    }


    private List<lista_relacionados> getItems_razas() {

        List<lista_relacionados> lista_razas_es= new ArrayList<>();

        if ("Libro de los Cielos".equals(titpag)) {
            lista_razas_es.add(new lista_relacionados("Estrellas", "Stars", R.drawable.estrellas));
        }

        return lista_razas_es;
    }


    private List<lista_relacionados> getItems_heroes() {
        List<lista_relacionados> itemLists= new ArrayList<>();

        switch (titpag) {
            case "Grimorio Negro":
                itemLists.add(new lista_relacionados("Demnok Lannik", "Warlock", R.drawable.perfil_warlock));
                itemLists.add(new lista_relacionados("Mars", "First Son of Heaven", R.drawable.perfil_mars));
                break;

            case "Eddas de los Eldwurm":

            case "Crepúsculo en la Fortaleza de Khorvin Wenn":
                itemLists.add(new lista_relacionados("Auroth","Winter Wyvern",R.drawable.perfil_ww));
                break;

            case "Tomo Graven":
                itemLists.add(new lista_relacionados("Nerif","Oracle",R.drawable.perfil_oracle));
                break;

            case "Pergaminos de Haize":
                itemLists.add(new lista_relacionados("Puck","Faerie Dragon",R.drawable.perfil_puck));
                break;

            case "Tael'Am":
                itemLists.add(new lista_relacionados("Magina","Anti-Mage", R.drawable.perfil_antimage));
                break;

            case "Códice de la Vigilia":
                itemLists.add(new lista_relacionados("Sven","Rogue Knight",R.drawable.perfil_sven));
                break;

            case "Niebla Roja, Pasion Roja":
                itemLists.add(new lista_relacionados("Mogul Khan","Axe", R.drawable.perfil_axe));
                break;


        }

        return itemLists;
    }


    private List<lista_relacionados> getItems_mundo() {

        List<lista_relacionados> lista_mundo_es= new ArrayList<>();

        if ("La Recompensa por la Muerte".equals(titpag)) {
            lista_mundo_es.add(new lista_relacionados("Palacio de Piedra", "StoneHall", R.drawable.stonehall));
        }

        return lista_mundo_es;
    }


    private void initValues(){

        String tit_igual;

        lista_relacionados itemDetail = (lista_relacionados) getIntent().getExtras().getSerializable("itemDetail");
        img_textos.setImageResource(itemDetail.getImg_principal());
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

            case "Grimorio Negro":
                parrafos3();
                rel("heroe");
                break;

            case "Libro de los Cielos":
                parrafos2("Contenido");
                rel("raza");
                break;

            case "Eddas de los Eldwurm":
                parrafos4();
                rel("heroe");
                break;

            case "Tomo Graven":

            case "Pergaminos de Haize":

            case "Niebla Roja, Pasion Roja":

            case "Crepúsculo en la Fortaleza de Khorvin Wenn":

            case "Códice de la Vigilia":
                parrafos1();
                rel("heroe");
                break;

            case "Tael'Am":
                parrafos2("Pasajes");
                rel("heroe");
                break;

            case "La Recompensa por la Muerte":
                parrafos2("Contenido");
                rel("mundo");
                break;

        }
    }


    private String Historia(String nombre, String tipo) {

        String hist = "";

        switch (nombre) {

            case "Grimorio Negro":

                switch (tipo) {

                    case "texto1":
                        hist = "El Grimorio Negro es un libro escrito por Demnok Lannik. También se conoce como el Libro de las Sombras.";
                        break;
                    case "texto2":
                        hist = "Otros Héroes a menudo comentan sobre el Grimorio Negro que Warlock lleva consigo. No todas estas respuestas hacia él pintan una imagen clara de cómo es el libro pero una respuesta de Mars implica que el libro es grande y pesado.";
                        break;
                    case "texto3":
                        hist = "La obsesión de Warlock por coleccionar libros de conocimiento arcano le ha motivado a escribir el Grimorio Negro. Por lo tanto este libro fue escrito con el propósito de registrar cada pedazo de conocimiento arcano que Demnok ha logrado acumular. Debido a que los misterios arcanos son infinitos el libro siempre está siendo ampliado por su único autor haciendo que crezca en tamaño.\n" +
                                "\n" +
                                "Este libro es también un registro de la vida de su autor y de los nombres de sus víctimas que él considera dignos de ser catalogados.";
                        break;

                }
                break;

            case "Libro de los Cielos":

                switch (tipo) {

                    case "texto1":
                        hist = "Hace siglos, los estetas de Keyturn escribieron el gran Libro de los Cielos. Estos estetas eran astrónomos: estudiaron el giro de los cuerpos celestes en los cielos y registraron su disposición en el Libro de los Cielos. A partir de estas observaciones consiguieron crear lo que parece ser el primer ejemplo de cronología en la historia de Dota 2, contando el número de días de cada estación y calculando el día de la noche más larga.\n" +
                                "\n" +
                                "A lo largo de su largo estudio de lo etéreo desde su atalaya mundana pronto conocieron un gran ciclo dentro del ciclo que estudiaban. Entre los muchos solsticios había uno llamado Noche de los Espectros, el cual se anunciaba con el resplandor de las auroras verdes en el cielo y la disminución de la barrera entre los planos, lo que provocaba una afluencia de Esencia de los Espectros que se filtraba en el mundo natural, cargando la vida salvaje con esta esencia y resucitando a los muertos de su sueño. Los estetas de Keyturned fueron destruidos y sólo quedaron los fragmentos del Libro de los Cielos para preservar su existencia de los devastadores estragos del olvido.";
                        break;
                    case "texto2":
                        hist = "Este antiguo libro contenía los movimientos y disposiciones de los cuerpos celestes en el cielo. Ahora que el libro (así como sus autores) ha sido destruido y se ha perdido para la historia sólo quedan meros restos de sus pasajes. Gracias a los esfuerzos de quienes han copiado sus fragmentos el recuerdo de este libro ha sobrevivido hasta nuestros días pero el resto de sus valiosos conocimientos se ha perdido para siempre.";
                        break;

                }
                break;

            case "Eddas de los Eldwurm":

                switch (tipo) {

                    case "texto1":
                        hist = "Las Eddas de Eldwurm (o Edda de Eldwurm) son un antiguo texto escrito por dragones en el lore de Dota 2.";
                        break;
                    case "texto2":
                        hist = "La Edda de los Eldwurm, que ha sido elaborada por los eruditos, ha acumulado eones de rica historia de los dragones en forma de epopeyas, poemas, sagas, etc. Esta Edda es un registro de los grandes acontecimientos de su historia que relata cosas como batallas y triunfos. Debido a esto las Eddas de los Eldwurm tienen un gran valor histórico.\n" +
                                "\n" +
                                "Las sagas de los Eldwurms hablan de un ser perdido en el olvido, mucho antes de la época de Ostarion, que una vez consiguió reunir y condensar suficiente Esencia Espectral para que este oscuro ritual de la Noche Espectral convirtiera su cuerpo en el de un espectro.";
                        break;
                    case "texto3":
                        hist = "Las Eddas de los Eldwurms son de libre acceso, pero sólo para los Eldwurms. Esto significa que cualquiera puede contribuir a su contenido, pero ese \"cualquiera\" sólo incluye a los propios Eldwurms.\n" +
                                "\n" +
                                "Los antaño prolíficos eruditos de los Eldwurms contribuían con sus conocimientos y habilidades a las páginas de sus Eddas. Hoy en día, los pocos eruditos dragones que quedan no han sido productivos últimamente y sólo han añadido unas pocas líneas a sus Eddas desde su última época de grandeza.\n" +
                                "\n" +
                                "Winter Wyvern es uno de estos poetas dragones que contribuyen a las Eddas. Afligido por el bloqueo del escritor Auroth busca añadir más contenido a los poemas dragones en vista de la falta de líneas nuevas y frescas que se añaden a las Eddas. Más concretamente desea crear una nueva historia. La última de su especie, es la única guardiana de su Edda, incluso en la muerte sigue escribiendo en la Edda, sin manos prensiles para agarrar correctamente cualquier tipo de instrumento de escritura, su escriba Thrael lo escribe por ella.";
                        break;
                    case "texto4":
                        hist = "Azorszos conoce la información sobre los espectros en las sagas de los Eldwurms, lo que sugiere que él mismo la ha leído o al menos ha oído hablar de ello.";
                        break;

                }
                break;

            case "Tomo Graven":

                if ("texto1".equals(tipo)) {
                    hist = "Graventome es un registro de los herederos exitosos del linaje del Rey Graven y sus hazañas. Durante generaciones las páginas de este texto se han llenado con los nombres de los reyes triunfantes y los nuevos dominios que adquirieron con la ayuda del recurso sobrenatural de las profecías de los Oráculos (descifradas por sus maestros, los Cymurri) hasta que Nerif escribió metafóricamente la última página cuando acabó con el linaje del Rey Graven con sus imprevisibles consecuencias.";
                }
                break;

            case "Pergaminos de Haize":

                if ("texto1".equals(tipo)) {
                    hist = "Los Pergaminos de Haize son documentos misteriosos, posiblemente asociado a la raza de los dragones hadas. Puck conoce bien su contenido y revela brevemente una sencilla doctrina de los textos: La juventud conlleva una gran responsabilidad.";
                }
                break;

            case "Tael'Am":

                switch (tipo) {

                    case "texto1":
                        hist = "El Tael'Am es un texto de procedencia desconocida. Contiene pasajes que parecen predicar la resistencia hacia el Dios Muerto. Anti-Mage conoce el Tael'Am.";
                        break;
                    case "texto2":
                        hist = "\"¡Que tu odio te preste la fuerza para destrozar el símbolo de la muerte de tus hermanos pues en sus restos yace el poder absoluto!\"\n" +
                                "\n" +
                                "\"Asciende a la Divinidad sobre los sueños destrozados de los indignos caídos cuyas ansias de poder y ciega ignorancia les llevaron a su prematuro fallecimiento\".\n" +
                                "\n" +
                                "\"Protege tus entrañas de las garras de los no vivos pues las tierras pestilentes producen cosechas pútridas...\"\n" +
                                "\n" +
                                "\"Que tu mirada no se vea obstaculizada por los de mente ausente y hambre eterna pues tú pondrás fin a su sufrimiento...\"\n" +
                                "\n" +
                                "\"¡Predica mi Palabra sobre tus adversarios para que no sufras sus perversas blasfemias!\"\n" +
                                "\n" +
                                "\"Que la Venganza sea tu Resplandor para que disperse las sombras que envuelven a los Malvados...\"";
                        break;

                }
                break;

            case "La Recompensa por la Muerte":

                switch (tipo) {

                    case "texto1":
                        hist = "El texto de la Recompensa por la Muerte es un antiguo documento que decretó el primer caso de último golpe o Last Strike, una tradición marcial que ahora es común entre todos los reinos disputados con capacidad para pagar a sus fuerzas armadas con cada golpe mortal que asestan. Los duelos otra tradición marcial ahora común pero exclusiva de los ejércitos de Stonehall.\n" +
                                "\n" +
                                "Fue decretado por primera vez por el Lord Regente Urthic Laste de Stonehall en una fecha desconocida, mucho antes de la época del Emperador Galanius en funciones, dada su antigüedad. Dado que fue un regente de Stonehall quien lo promulgó se da a entender que Urthic actuaba en lugar del verdadero soberano, que podría haber quedado incapacitado para gobernar Stonehall. Dicho esto se desconoce quién era la verdadera autoridad antes de él.";
                        break;
                    case "texto2":
                        hist = "Encontrado por primera vez en las ruinas del Cartulario de Stonehall, este texto estaba escrito en un pergamino con un lenguaje perdido que tuvo que ser traducido antes de ser registrado, lo que hace pensar en su antigüedad. El documento se encontró incompleto dejando a salvo la mayor parte de sus misterios.\n" +
                                "\n" +
                                "El documento explica los procedimientos de la Recompensa por Muerte, exclusiva de los ejércitos de Stonehall, una tradición en la que se paga a los soldados una recompensa por cada golpe mortal que asesten con éxito a un enemigo. Por supuesto, el pago se realiza después de la batalla (no durante la misma), donde cada \"compañía\" es responsable de contar y dividir el dinero entre ellos para utilizarlo en el mantenimiento y la compra de equipo diverso.\n" +
                                "\n" +
                                "También explica lo que parece ser el primer caso registrado de duelos, otra tradición común que es exclusiva de los ejércitos de Stonehall incluso hoy en día, pero que se practicaba con cualquiera que desafiara. El documento da a entender que los duelos no eran sólo una forma de desafiar a un enemigo en combate singular sino una manera de resolver disputas. En este caso los duelos se utilizan para resolver disputas entre dos soldados de Stonehall que pueden tener un problema entre sus últimos golpes. El ganador entre los dos reclamará la parte total de su oponente. Si un duelo termina con la muerte de uno de los participantes se hará una recompensa, pero se desconoce a qué se debe esta recompensa ya que el documento se corta en esa parte.";
                        break;

                }
                break;

            case "Crepúsculo en la Fortaleza de Khorvin Wenn":

                if ("texto1".equals(tipo)) {
                    hist = "Crepúsculo en la Fortaleza de Khorvin Wenn es un poema. Es uno de los poemas favoritos de Auroth, que comparte con las mentes de aquellos a los que ha encerrado en sus hechizos de curación, llenando sus pensamientos con sus imágenes poéticas.";
                }
                break;

            case "Códice de la Vigilia":

                if ("texto1".equals(tipo)) {
                    hist = "El Códice de la Vigilia es un conjunto de códigos que siguen los miembros de los Caballeros de la Vigilia. Poco se sabe de este código excepto que es rígido y que se considera la existencia de Sven una abominación, quizás por su origen mestizo. El padre de Sven fue ejecutado por violar el código, probablemente por engendrar un hijo con un meranth. Más tarde, Sven quemó el Códice de la Vigilia en la Llama Sagrada de la orden como castigo por la muerte de su padre. El código personal de Sven puede estar basado en partes del Códice de la Vigilia ya que recita líneas del texto cuando utiliza Warcry.";
                }
                break;

            case "Niebla Roja, Pasion Roja":

                if ("texto1".equals(tipo)) {
                    hist = "\"Niebla roja, pasión roja\" es un libro de suspense erótico escrito por el bardo Goodkind sobre una aventura desconocida en la vida de Axe. No mucha gente lo lee debido a su etiqueta de thriller erótico. A pesar de ello el pródigo cazador de magos Wei, gran fan de todos los libros de Goodkind, piensa que esta novela está infravalorada.";
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

        layout1.setVisibility(View.GONE);
        layout2.setVisibility(View.GONE);
        layout3.setVisibility(View.GONE);
    }

    private void parrafos2(String tit1) {

        texto1.setText(Historia(titpag, "texto1"));
        texto2.setText(Historia(titpag, "texto2"));
        titulo1.setText(tit1);
        texto3.setVisibility(View.GONE);
        texto4.setVisibility(View.GONE);
        layout2.setVisibility(View.GONE);
        layout3.setVisibility(View.GONE);

    }

    @SuppressLint("SetTextI18n")
    private void parrafos3() {
        texto1.setText(Historia(titpag, "texto1"));
        texto2.setText(Historia(titpag, "texto2"));
        texto3.setText(Historia(titpag, "texto3"));
        titulo1.setText("Descripción");
        titulo2.setText("Contenido");
        texto4.setVisibility(View.GONE);
        layout3.setVisibility(View.GONE);
    }

    @SuppressLint("SetTextI18n")
    private void parrafos4() {
        texto1.setText(Historia(titpag, "texto1"));
        texto2.setText(Historia(titpag, "texto2"));
        texto3.setText(Historia(titpag, "texto3"));
        texto4.setText(Historia(titpag, "texto4"));
        titulo1.setText("Contenido");
        titulo2.setText("Autores");
        titulo3.setText("Lectores");
    }


    private void rel(String rel) {

        switch (rel) {
            case "heroe":
                layout_dettextos_rel_mundo.setVisibility(View.GONE);
                layout_dettextos_rel_razas.setVisibility(View.GONE);
                break;
            case "mundo":
                layout_dettextos_rel_heroes.setVisibility(View.GONE);
                layout_dettextos_rel_razas.setVisibility(View.GONE);
                break;
            case "raza":
                layout_dettextos_rel_heroes.setVisibility(View.GONE);
                layout_dettextos_rel_mundo.setVisibility(View.GONE);
                break;
            case "heroe_mundo":
                layout_dettextos_rel_razas.setVisibility(View.GONE);
                break;
            case "heroe_raza":
                layout_dettextos_rel_mundo.setVisibility(View.GONE);
                break;
            case "mundo_raza":
                layout_dettextos_rel_heroes.setVisibility(View.GONE);
                break;
            case "vacio":
                layout_dettextos_rel_heroes.setVisibility(View.GONE);
                layout_dettextos_rel_mundo.setVisibility(View.GONE);
                layout_dettextos_rel_razas.setVisibility(View.GONE);
                layout_rel_textos.setVisibility(View.GONE);
                break;
            case "heroe_mundo_raza":
                break;
        }

    }


    @Override
    public void itemClick(lista_relacionados item) {
        try {
            Intent intent = new Intent(this, detalle_textos.class);
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