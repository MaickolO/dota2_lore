package com.orizevtechnologies.historia_de_dota_2.fragmentPrincipal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.orizevtechnologies.historia_de_dota_2.R;
import com.orizevtechnologies.historia_de_dota_2.Spinner_Archronicus.Capitulos;

import java.util.ArrayList;

public class archronicus extends Fragment {

    private TextView parrafo1;
    private TextView parrafo2;
    private TextView parrafo3;
    private TextView capitulo;
    private TextView imgtxt1;
    private TextView imgtxt2;
    private TextView imgtxt3;
    private ImageView hist_img1;
    private ImageView hist_img2;
    private ImageView hist_img3;
    private LinearLayout layout1;
    private LinearLayout layout2;
    private LinearLayout layout3;
    Spinner spinner;
    private AdView mAdView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_archronicus, container, false);




        initViews(view);
        anuncio_banenr(view);

        return view;
    }

    private void initViews(View view) {

        layout1 = view.findViewById(R.id.layout1);
        layout2 = view.findViewById(R.id.layout2);
        layout3 = view.findViewById(R.id.layout3);
        spinner = view.findViewById(R.id.archronicus_spinner);
        parrafo1 = view.findViewById(R.id.parrafo1);
        parrafo2 = view.findViewById(R.id.parrafo2);
        parrafo3 = view.findViewById(R.id.parrafo3);
        capitulo = view.findViewById(R.id.nombre_capitulo);
        hist_img1 = view.findViewById(R.id.historia_img1);
        hist_img2 = view.findViewById(R.id.historia_img2);
        hist_img3 = view.findViewById(R.id.historia_img3);
        imgtxt1 = view.findViewById(R.id.imgtxt1);
        imgtxt2 = view.findViewById(R.id.imgtxt2);
        imgtxt3 = view.findViewById(R.id.imgtxt3);
        ArrayList<Capitulos> capitulos = new ArrayList<>();
        capitulos.add(new Capitulos("La luna loca y los Ancestros"));
        capitulos.add(new Capitulos("Crónica de Thesos"));
        capitulos.add(new Capitulos("El mar de las Invocaciones"));
        capitulos.add(new Capitulos("La Recompensa por la Muerte"));
        capitulos.add(new Capitulos("Ciclo de Solsticios"));
        capitulos.add(new Capitulos("La noche de los Espectros"));

        ArrayAdapter<Capitulos> adapter = new ArrayAdapter<>(getContext(),
                R.layout.spinner_item, capitulos);



        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i) {

                    case 0:

                        layout1.setVisibility(View.VISIBLE);
                        layout2.setVisibility(View.VISIBLE);
                        layout3.setVisibility(View.VISIBLE);

                        parrafo1.setVisibility(View.VISIBLE);
                        parrafo2.setVisibility(View.VISIBLE);
                        parrafo3.setVisibility(View.VISIBLE);

                        parrafo1.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                        parrafo2.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                        parrafo3.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);

                        capitulo.setText(R.string.capitulo1);

                        parrafo1.setText(inf(1));
                        parrafo2.setText(inf(7));
                        parrafo3.setText(inf(8));

                        hist_img1.setImageResource(R.drawable.c1i1);
                        imgtxt1.setText(R.string.cap1img1);
                        hist_img2.setImageResource(R.drawable.c1i2);
                        imgtxt2.setText(R.string.cap1img2);
                        hist_img3.setImageResource(R.drawable.c1i3);
                        imgtxt3.setText(R.string.cap1img3);
                    break;

                    case 1:
                        layout1.setVisibility(View.VISIBLE);
                        layout2.setVisibility(View.VISIBLE);
                        layout3.setVisibility(View.GONE);

                        parrafo1.setVisibility(View.VISIBLE);
                        parrafo2.setVisibility(View.VISIBLE);
                        parrafo3.setVisibility(View.GONE);

                        parrafo1.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                        parrafo2.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                        parrafo3.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);

                        capitulo.setText(R.string.capitulo2);

                        parrafo1.setText(inf(2));
                        parrafo2.setText(inf(9));

                        hist_img1.setImageResource(R.drawable.c2i1);
                        imgtxt1.setText(R.string.cap2img1);
                        hist_img2.setImageResource(R.drawable.c2i2);
                        imgtxt2.setText(R.string.cap2img2);
                        break;

                    case 2:
                        layout1.setVisibility(View.VISIBLE);
                        layout2.setVisibility(View.VISIBLE);
                        layout3.setVisibility(View.VISIBLE);

                        parrafo1.setVisibility(View.VISIBLE);
                        parrafo2.setVisibility(View.VISIBLE);
                        parrafo3.setVisibility(View.VISIBLE);

                        capitulo.setText(R.string.capitulo3);

                        parrafo1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                        parrafo2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                        parrafo3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

                        parrafo1.setText(inf(3));
                        parrafo2.setText(inf(10));
                        parrafo3.setText(inf(11));

                        hist_img1.setImageResource(R.drawable.c3i1);
                        imgtxt1.setText(R.string.cap3img1);
                        hist_img2.setImageResource(R.drawable.c3i2);
                        imgtxt2.setText(R.string.cap3img2);
                        hist_img3.setImageResource(R.drawable.c3i3);
                        imgtxt3.setText(R.string.cap3img3);
                        break;

                    case 3:
                        layout1.setVisibility(View.GONE);
                        layout2.setVisibility(View.GONE);
                        layout3.setVisibility(View.GONE);
                        parrafo1.setVisibility(View.VISIBLE);
                        parrafo2.setVisibility(View.GONE);
                        parrafo3.setVisibility(View.GONE);

                        parrafo1.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                        parrafo2.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                        parrafo3.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);

                        capitulo.setText(R.string.capitulo4);
                        parrafo1.setText(inf(4));
                        break;

                    case 4:
                        layout1.setVisibility(View.GONE);
                        layout2.setVisibility(View.GONE);
                        layout3.setVisibility(View.GONE);
                        parrafo1.setVisibility(View.VISIBLE);
                        parrafo2.setVisibility(View.GONE);
                        parrafo3.setVisibility(View.GONE);
                        capitulo.setText(R.string.capitulo5);
                        parrafo1.setText(inf(5));

                        parrafo1.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                        parrafo2.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                        parrafo3.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                        break;

                    case 5:
                        layout1.setVisibility(View.GONE);
                        layout2.setVisibility(View.GONE);
                        layout3.setVisibility(View.GONE);
                        parrafo1.setVisibility(View.VISIBLE);
                        parrafo2.setVisibility(View.GONE);
                        parrafo3.setVisibility(View.GONE);
                        capitulo.setText(R.string.capitulo6);
                        parrafo1.setText(Html.fromHtml(inf(6)));

                        parrafo1.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                        parrafo2.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                        parrafo3.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                        break;

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private String inf(int capitulo) {

        String historia = "";

        switch (capitulo) {

            case 1:
                historia = "CUANDO UN MUNDO era todavía una mancha fría capturó una inquietante compañera: una esfera cristalina brillante que llegó a ser conocida en la historia como la Luna Loca (Mad Moon). Este pequeño orbe estaba lleno de un violento resplandor, un recordatorio visual del conflicto en los cielos, lo suficientemente brillante como para competir con el sol en días soleados.\n" +
                        "\n" +
                        "Pero la Luna Loca no era una roca inerte.  Era más bien una prisión, en la que dos ancestrales inteligencias beligerantes habían sido capturadas y arrojadas al exilio hace eones, una vez que los vastos Primordiales que cimentaron la creación se cansaron de su interminable guerra.  El castigo para estos Ancestrales era estar encerrados juntos en una forma, cayendo para siempre en el infinito... y así fue hasta que nuestro desafortunado mundo capturó a ese errante.";
                break;

            case 2:
                historia = "Hace unos días llegó a la Alta Campana (High Bell) el rumor de dos extrañas bestias abatidas en los límites de la tierra de los granos.  Ya sea por enfermedad o por la espada, las historias variaban pero siempre se hablaba de dos dragones, de color azul oscuro y muy muertos.\n" +
                        "\n" +
                        "Partí inmediatamente y encontré sus cuerpos escamosos carbonizados en la propiedad de un granjero a tres días de viaje por la carretera limítrofe. Uno grande, otro pequeño, los dragones yacían en el lugar donde murieron, rodeados por las huellas de una bestia mucho mayor cuyas marcas en el suelo eran lo suficientemente grandes como para que un Keen adulto se acostara en ellas; y así lo hice, imaginando la escala imposible del animal en cuyo rastro me encontraba.  Un gran dragón verdadero, como las historias de antaño, y como algunos dicen que aún viven en los páramos del sur.\n" +
                        "\n" +
                        "Las huellas cruzaban el terreno durante una cierta distancia y terminaban donde la bestia levantaba el vuelo en el borde del campo. Así pues, estas jóvenes bestias no habían encontrado su fin por una enfermedad o por la espada, sino por el ataque de uno de sus propios congéneres.\n" +
                        "\n" +
                        "Con la buena fe del nombre de mi padre y la promesa de un traslado inmediato, pude comprar el cadáver putrefacto del menor de los dos dragones muertos. Como el espécimen no había alcanzado la madurez completa pude arrastrarlo detrás de mi fiel Zonkey durante varias horas hasta las tierras de mi padre.  Comenzaron varios días de desarticulación y ebullición, seguidos de noches enteras de inertización en cera, hasta que, por fin, el esqueleto completo fue expuesto ante mí en el gran salón, disponible para su estudio.\n" +
                        "\n" +
                        "Aquí dibujo mis observaciones con una tinta cuidadosa, anotando la forma y el tamaño de cada hueso.";
                break;

            case 3:
                historia = "Más allá del alcance de Southward's End,\n" +
                        "donde el calor del verano no se atreve a vagar\n" +
                        "las canciones hablan de antiguos tesoros perdidos\n" +
                        "que valen más que los títulos, las tierras y el hogar.\n" +
                        "\n" +
                        "Por la noche, los cielos se tiñen con el resplandor del lazo\n" +
                        "el laberinto océanico tan frío com la helada escarpada\n" +
                        "los vientos salvajes traicionan al mejor de los hombres\n" +
                        "donde los capitanes más audaces temen cruzar.\n" +
                        "\n" +
                        "Se dice que hay una costa oculta\n" +
                        "desconocida para el mapa o el hombre\n" +
                        "donde una vez murió un demonio marino\n" +
                        "arrastrado a lo largo de sus extensas arenas.\n" +
                        "\n" +
                        "Dentro de este cadáver, las leyendas afirman\n" +
                        "una gema yace oculta a la vista\n" +
                        "y quien se atreva a sostener esta piedra única\n" +
                        "verá todas las formas ocultas del miedo.\n" +
                        "\n" +
                        "De donde partió la solitaria fragata\n" +
                        "ningún alma vive aún para atreverse a recordar\n" +
                        "el valeroso trayecto iniciado en el frío\n" +
                        "sin temor a la tormenta o a la tempestad.\n" +
                        "\n" +
                        "Hacia el hielo y el viento del sur se dirigieron\n" +
                        "la intrépida tripulación trazaba su trayecto\n" +
                        "en días de horizontes de hielo y icebergs\n" +
                        "vislumbraron tierra todos en la cubierta.\n" +
                        "\n" +
                        "En una costa ártica observaron\n" +
                        "los restos de un monstruo inmenso congelado\n" +
                        "vieron viejas marcas de guerras oceánicas\n" +
                        "Y el hielo cerró los dientes para eclipsar su mástil.\n" +
                        "\n" +
                        "En la oscurecida playa se establece una multitud\n" +
                        "para excavar esta serpentina mortal\n" +
                        "sus picos y herramientas levantaron en alto\n" +
                        "para continuar en su espeluznante trabajo.\n";
                break;

            case 4:
                historia = "El antiguo Texto de la Recompensa por la Muerte, como se le conoce desde entonces, fue descubierto por primera vez entre las ruinas del gran Cartulario de Stonehall. La importancia del documento pasó desapercibida durante años, ya que permaneció sin traducir y olvidado, sellado tras las puertas del Archivo Histórico de Sennos.  No fue hasta que los eruditos estudiaron el documento en detalle que llegaron a entender lo que representaba. Este trozo de pergamino en descomposición era nada menos que una posible fuente de la tradición marcial del Último Golpe (Last Strike), ahora común entre todos los reinos de las tierras disputadas. \n" +
                        "\n" +
                        "Traducido de la página:\n" +
                        "Proclamación Real\n" +
                        "Por orden del Lord Regente Urthic Laste de Stonehall\n" +
                        "\n" +
                        "De ahora en adelante, todos los miembros de los Ejércitos de Stonehall deberán adherirse a las declaraciones que se indican a continuación:\n" +
                        "\n" +
                        "1. Los miembros del ejército de Stonehall recibirán una recompensa por cada golpe mortal asestado a un enemigo en la batalla. Esta recompensa sólo se concederá al miembro que aseste el golpe mortal.\n" +
                        "\n" +
                        "2. Tras el transcurso de la batalla, cada cuadrilla será responsable del recuento y la división del pago entre ellos para cubrir los gastos, incluyendo la compra de equipo y su mantenimiento.\n" +
                        "\n" +
                        "3. En caso de disputa, los miembros podrán desafiarse a duelo. El vencedor recibirá la parte total que posea el vencido.\n" +
                        "\n" +
                        "4. Si un duelo concluye con la muerte de un compañero, la recompensa será para...\n";
                break;

            case 5:
                historia = "En la noche más larga del año los muertos no siempre duermen.  Durante siglos, los eruditos estetas de Keyturn estudiaron los cielos desde la cima de su montaña donde, generación tras generación, siguieron el movimiento de los cuerpos celestes, copiando sus disposiciones en el gran Libro de los Cielos.  Fueron ellos los que descubrieron que la rueda del mundo era un objeto de muchas partes móviles, un reloj de ritmos extraños y métrica irregular. Fueron ellos quienes contaron el número de amaneceres en cada estación. Fueron ellos los que calcularon el día de la noche más larga. \n" +
                        "\n" +
                        "Y fueron ellos quienes descubrieron por primera vez el gran ciclo dentro del ciclo: un cambio periódico por el que, en un solsticio entre muchos, la barrera entre los planos se desvanece, la aurora resplandece de color verde en el cielo y los muertos vivientes se levantan de sus tumbas. Y fueron ellos los que fueron destruidos.\n" +
                        "\n" +
                        "Ahora sólo tenemos fragmentos de sus largos estudios.  El gran Libro de los Cielos se ha perdido en la historia, aunque a veces se encuentran restos copiados de ciertos pasajes en las ruinas de templos antiguos o en obras eruditas de bibliotecas en ruinas. Estos fragmentos son la última visión de una civilización perdida.\n";
                break;

            case 6:
                historia = "El joven príncipe Ostarion fue empujado al trono por la muerte de su familia real.  La rápida y podrida enfermedad que acabó con sus vidas estuvo a punto de llevarse también al príncipe, pero el mago de la corte tomó medidas desesperadas: Someter al joven a un ritual que le arranque toda la carne vulnerable, transformándolo en un ser de hueso animado. El joven rey emergió de la purga, convencido de que, habiendo desafiado a la muerte una vez, nunca se sometería a ella. <br>" +
                        "<p>" +
                        "Con una profunda desconfianza hacia todo lo de carne, Ostarion comenzó a transformar el legado de sus padres en formas imperecederas. Cada piedra de su reino fue sustituida por su equivalente en hueso.   El ejército del Rey Esqueleto se hizo con el dominio de las tierras vecinas y a medida que ampliaba su alcance, extraía los huesos de sus enemigos.  Finalmente, llegó a gobernar una tierra fría, blanca y frágil para posteriormente anhelar algo más. <br>" +
                        "<p>" +
                        "Como nunca confió en la carne no quiso revestir sus huesos con ella, finalmente se decantó por la búsqueda de energía espectral, una forma de pureza espiritual que desprenden ciertas almas oscuras al morir y que adoptan los fantasmas y otros retornados cuando necesitan una forma con la que caminar por la tierra. Si se formaba a partir de la esencia espectral pensaba que podría crearse un cuerpo tan luminoso y eterno como su ego. <br>" +
                        "<p>" +
                        "Consultando al antiguo mago que había salvado la vida del joven príncipe, el Rey Esqueleto se enteró de una rara oportunidad: una noche predicha por ciertos viejos sabios que habían lidiado con los revoltosos y, en la mayoría de los sentidos, imprevisibles ciclos de la naturaleza: el solsticio conocido como la Noche de los Espectros (Wraith-Night), en la que los muertos se alzarían en tan gran número que sus almas podrían ser cosechadas y capturadas en cantidad suficiente como para completar otro ritual.  Si lograba cosechar la energía de los espectros de la horda de muertos vivientes, podría alzarse una vez más transfigurado: Rey Eterno, pero esta vez de los espectros. <br>" +
                        "<p><p><p>" +
                        "<b> De los diarios de Azorszos el Óseo.</b><br>" +
                        "<b> Mago Physik a Ostarion, súbdito mayor de ese ingrato miserable al que debe aclamar como Rey, y quien con gusto encabezará la multitud que se maldice a sí misma por el papel que desempeñó al colocar a nuestro llamado Rey Esqueleto en el trono de huesos.</b> <br>" +
                        "<p>" +
                        "<i>En este noveno siglo de encarcelamiento ya no puedo ocultarle la verdad. De alguna manera el rey se ha enterado de que este año caerá otra de las encíclicas Noches de los Espectros que presagian los textos antiguos. Anoche vino a verme y no le costó mucho trabajo amenazarme para sacar la última parte del conocimiento que hubiera querido darle de buena gana.  Y sin embargo, con la amenaza de una mayor longevidad, lo arrancó y le terminé señalando los libros que exponen todos los elementos para una cosecha exitosa. </i> <br>" +
                        "<p>" +
                        "<i>Sólo otro, si hemos de creer las sagas de los Eldwurms, ha extraido esa esencia enferma que ilumina los ojos de los fantasmas y las almas deambulantes; la ha recogido y condensado en tal cantidad que de ella podría formar un nuevo físico. Su nombre y su presencia se han perdido para la historia; tal vez este mundo no pudo retenerlo por mucho tiempo. Pero ahora mi Rey, mi señor Ostarion, está decidido a ser el segundo.</i><br>" +
                        "<p>" +
                        "<i>Temo por el mundo si completa el ritual de la Noche del Espectro. Aquellos que le temían en su forma esquelética, ¿qué pensarán de él una vez que ostente el poder de los Espectros? ¿Qué destino les espera a los súbditos que no quieran luchar por su causa o que no se alineen con su decreto? Porque pocos pueden resistir ahora su desafío. Muchos caballeros errantes, lacras de nuestra época, consideran una noble vocación tomar las armas ante cualquier rey que se presente.</i><br>" +
                        "<p>" +
                        "<i>Pero este rey puede hacerles lamentar su código de honor. A medida que los ejércitos de la noche se acercan podrían ser sabios en no defender a su rey -mi Rey- sino pensar en sus verdaderos motivos y considerar que el costo de la lealtad podría ser mayor que el de la rebelión.</i><br>" +
                        "<p>" +
                        "<i>Gané un pequeño auge asegurando que todo va bien. El rey me ha prometido que si su ascensión tiene éxito la recompensa de mi ayuda será mi propia muerte.  Tal vez añada mi escasa esencia de espectro a la suya, un pensamiento maldito pero bienvenido si significa acabar con este sufrimiento.  El día que lo sometí al rito de osificación que le salvó la vida, no tenía ni idea de que al estar tan cerca, yo tambien sería afligido por el efecto en una medida...suficiente como para despojarme de la carne pero no de los nervios. Mis nervios desnudos se envolvieron como una hiedra marchita alrededor de estos huesos leprosos. Adheriéndose a cada ráfaga de frío, a cada tejido que roza, nada más que dolor puro durante siglos. Me ha prometido la muerte antes y nada ha salido de ello. Pero tal vez ahora, si ya no tengo nada que ofrecerle, me dejará morir. Llámame optimista. No uno eterno, ciertamente, pero he tenido casi un milenio para practicar. Vivo en la esperanza.</i><br>" +
                        "<p>" +
                        "<i>Y ahora... escucho su risa arrogante, mientras sube los escalones de la torre. Es el momento de los preparativos finales... deseadme suerte.</i>";
                break;

            case 7:
                historia = "Durante años, las primitivas sociedades se alzaron y cayeron bajo su extraño resplandor; criaturas de diversa inteligencia y sofisticación la contemplaron con asombro y curiosidad, en la medida en que su sensibilidad se lo permitía. Mientras tanto, el estrés orbital y las fuerzas de las mareas permitieron a los habitantes de la Luna Loca empezar a explotar lo que al principio eran las más mínimas debilidades y se pusieron a trabajar para abrir su prisión.  Las grietas se extendieron lentamente, a partir de las fracturas más pequeñas, hasta que al final hubo millones de fisuras, vastas y resplandecientes con energías extrañas.\n" +
                        "\n" +
                        "En una noche apocalíptica la luna acabó destrozada, desgarrada desde dentro.  La mayor parte de la materia lunar fue lanzada al espacio o se consumió al chocar con la atmósfera. Unos pocos fragmentos cayeron a la tierra, ya sea como masa fundida o como cristales irregulares. Los fragmentos quedaron depositados en el lugar donde habían caído, y poco a poco la tierra que los rodeaba se fue recuperando. Cuando los supervivientes del cataclismo prehistórico se recuperaron, florecieron y desarrollaron, la Luna Loca se convirtió menos en un recuerdo que en un sueño, con la noche de su destrucción entretejida en sus mitos.\n";
                break;

            case 8:
                historia = "Los fragmentos caídos de la materia primigenia se habían fracturado en sus compuestos originales:  Radiant (Radiante) y Dire (Peligroso).  En su forma pura, cada tipo de piedra desprendía una energía peculiar.  Los que se asentaron en los alrededores de los lugares se vieron alimentados por este poder sobrenatural hasta que no sólo aprovecharon la energía, sino que se hicieron dependientes de ella. Construyeron santuarios alrededor de los Ancestros y los veneraron, irónicamente, como entidades divinas que habían caído a la tierra.\n" +
                        "\n" +
                        "Los Ancestros, tanto Radiant como Dire, proporcionaban muchos beneficios: energía cinética, maná, protección e incluso resurrección. Pero su aura cambiaba todo en su influencia: Alrededor de Radiant, los efectos eran brillantes y coloridos, evocando suavidad y encanto.  Alrededor de Dire, un siniestro resplandor radiactivo, una filtración visual que indica veneno y decadencia.   Ninguna de las dos fuerzas era neutral; ambas eran complementos perfectos y contradicciones totales que nunca podrían estar en paz.\n" +
                        "\n" +
                        "A medida que la influencia cultural de cada piedra se extendía, acababa entrando en conflicto con las sociedades rival. La interferencia entre los Ancestros era causa de guerra, ya que la presencia de uno de ellos provocaba la correspondiente caída de la energía del otro.  Cada piedra sólo podía recuperar toda su energía con la destrucción de su piedra enemiga. Y así, las cautivadas criaturas se unieron para proteger su tierra destruyendo al Ancestro vecino, y desde muy lejos los Héroes escucharon la llamada a la batalla y vinieron a unirse, sin darse cuenta de que en cierto sentido ambos bandos eran el mismo.\n";
                break;

            case 9:
                historia = "La estructura del ala me sorprendió. Al igual que la curiosa arquitectura del hombro. Los huesos en sí, aunque muy fuertes, eran mucho más ligeros de lo que había esperado.   Más parecidos a los huesos de un pájaro que a los de una criatura con escamas y dientes.\n" +
                        "\n" +
                        "Lo más inesperado de todo fueron los restos de un viejo escudo encontrados en las entrañas de la bestia.  Los dragones son conocidos por llevar acero en sus gargantas para ayudar a triturar y moler su comida.  Si un dragón (convencionalmente) respira fuego, ¿cómo puede mantener el acero en su estómago o cualquier otro material similiar?  Pero éste llevaba una forma muy inusual de hierro en la garganta, y en él la marca de una antigua orden que hoy en día sólo se ve raramente por estos lares, una cresta de dragón, y el sello de los Caballeros Escamados de Uthorian.  ¡Ay del caballero que llevara...\n";
                break;

            case 10:
                historia = "\n" +
                        "Durante días y días mutilaron y cortaron\n" +
                        "mientras se ensuciaba la playa con sangre ancestral\n" +
                        "a través de costillas y tejidos profundizaron\n" +
                        "y forjaron su camino hasta el núcleo del monstruo\n" +
                        "\n" +
                        "De las profundidades húmedas surgió una luz tenue y brillante\n" +
                        "uxtraña luz espectral de tono esmeralda\n" +
                        "Una gran gema del mismo tamaño que el puño de su localizador\n" +
                        "la tripulación se alegró; las antiguas canciones se hicieron realidad.\n" +
                        "\n" +
                        "Regresaron a cubierta con el tesoro en sus manos\n" +
                        "como uno, toda la tripulación se quedó sin aliento\n" +
                        "porque estaban rodeados de espectros de antaño\n" +
                        "barcos fantasmas hundidos junto a aquellos que ya han muerto.\n" +
                        "\n" +
                        "Porque ocultos al ojo común\n" +
                        "estan los que vagan cuando la sangre vital falla\n" +
                        "la gema brillante concede la verdad a la vista, ellos supieron\n" +
                        "y luego se dispusieron a izar las velas con miedo.\n" +
                        "\n" +
                        "Sin embargo, las espantosas sombras no pretenden hacer daño,\n" +
                        "sino advertir a los hombres cuyo aire aún se dibuja\n" +
                        "que sacar la piedra de la vida de las extensas aguas\n" +
                        "leventaría la ira del profundo Maelrawn.\n" +
                        "\n" +
                        "Un día y doce sobre las olas del océano\n" +
                        "avanzó cargada, en retirada la tripulación ansiosa\n" +
                        "cuando llegaron largas sombras a su paso\n" +
                        "el sirviente de Lord Maelrawn, vino a comer.\n" +
                        "\n" +
                        "Por la urgencia y la afortunada brisa aceleraron\n" +
                        "cuatro amaneceres su castigo se mantuvo a raya\n" +
                        "hasta que una brizna tierra se alejó\n" +
                        "entonces los vientos de la fortuna los traicionaron.\n" +
                        "\n" +
                        "Mientras la criatura se acercaba al barco para atacar\n" +
                        "los botes de remos se llenaron de hombres y botines\n" +
                        "luego se soltaron las pesadas cadenas y la carga\n" +
                        "para estrellar el ancla del barco contra la bestia del mar.\n";
                break;

            case 11:
                historia = "Luego, la cubierta se inclinó a babor mientras la bestia marina escalaba\n" +
                        "con furia salvaje tentáculos subieron a bordo\n" +
                        "en pánico frenético tres botes huyeron\n" +
                        "con el barco enrollado, el kraken rugió\n" +
                        "\n" +
                        "A través de grueso árboles sus tentáculos se retorcían y apretaban\n" +
                        "el casco de madera se abre entre el oleaje congelado\n" +
                        "mientras la mitad del barco se hundía, el maestro de la muerte rugió\n" +
                        "la gema aún se movía, acercándose al borde de la orilla\n" +
                        "\n" +
                        "En apresurada persecución el kraken nadó\n" +
                        "para alcanzar el primer barco de tres\n" +
                        "cuando los hombres ahogados se congelaron y los restos se hundieron\n" +
                        "el cazador aprendió que su tesoro permanecia libre\n" +
                        "\n" +
                        "Mientras la segunda tripulación remaba horrorizada\n" +
                        "los tentaculos resbaladizos se aferraron alrededor\n" +
                        "pero una vez más la gema no estaba allí\n" +
                        "y la tripulación del tercer barco encalló\n" +
                        "\n" +
                        "Tan aterrorizado por la furia de Maelrawn\n" +
                        "la calamidad se puso en marcha de nuevo\n" +
                        "luego se abrió paso sobre el oleaje\n" +
                        "mientras el kraken se agitaba, su enemigo se retiró\n" +
                        "\n" +
                        "De la última convocatoria de la tripulación predestinada\n" +
                        "ningún relato gris se digna a contar\n" +
                        "Algunos creen firmemente que han llegado a casa\n" +
                        "Aunque otros ceuntan de la influencia del verdugo\n" +
                        "\n" +
                        "La caza por la gema del Dios de las mareas profundas\n" +
                        "continúa en bana búsqueda sin recompensa\n" +
                        "sus sirvientes llegan ciegamente a la orilla\n" +
                        "Para matar, arrasar y ser sometidos por la espada\n" +
                        "\n" +
                        "Porque para ninguna criatura esclava de las profundidades\n" +
                        "Ni para el espíritu encadenado en la guarida del ahogado\n" +
                        "Ni para Maelrawn el Tentacular\n" +
                        "Habrá descanso hasta que en los mares, la gema llegue a dormir.";
                break;

        }

        return historia;
    }

    private void anuncio_banenr(View view) {

        MobileAds.initialize(getActivity(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = view.findViewById(R.id.adView_archronicus);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }


}