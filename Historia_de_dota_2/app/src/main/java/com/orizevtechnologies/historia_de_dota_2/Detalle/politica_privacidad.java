package com.orizevtechnologies.historia_de_dota_2.Detalle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.orizevtechnologies.historia_de_dota_2.R;

public class politica_privacidad extends AppCompatActivity {

    private TextView texto_politica;
    private String texto = "";
    private String nombre_app = "Lore de Dota 2";
    private String correo_electronico = "michaelorizev@gmail.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_politica_privacidad);

        ActionBar();
        init_view();
        agregar_texto();

    }

    private void init_view() {

        texto_politica = findViewById(R.id.texto_politica);
    }


    private void ActionBar() {
        ActionBar actionBar = getSupportActionBar();
        assert  actionBar != null;
        actionBar.setTitle("Política de Privacidad");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void agregar_texto() {

        texto = "Al instalar nuestro aplicativo móvil \""+nombre_app+"\" usted indica que conoce y entiende lo siguiente:\n" +
                "\n" +
                "1. A través de esta aplicación no se recaban datos de carácter personal de los usuarios.\n" +
                "\n" +
                "2. No se registran direcciones IP.\n" +
                "\n" +
                "3. No se accede a las cuentas de correo de los usuarios.\n" +
                "\n" +
                "4. La aplicación no guarda datos ni hace seguimientos sobre tiempos y horarios de utilización.\n" +
                "\n" +
                "5. La aplicación no guarda información relativa a tu dispositivo como, por ejemplo, fallos, actividad del sistema, ajustes del hardware, tipo de navegador, idioma del navegador.\n" +
                "\n" +
                "6. La aplicación no accede a tus contactos ni agendas.\n" +
                "\n" +
                "7. La aplicación no recopila información sobre tu ubicación real.\n" +
                "\n" +
                "8. Remarketing con Google AdMob\n" +
                "Proveedores como Google, utilizan cookies de primer nivel y cookies de terceros u otros identificadores de terceros para compilar datos sobre las interacciones de los usuarios con Las impresiones de anuncios y otras funciones de servicio de anuncios.\n" +
                "\n" +
                "9. Clasificación por edades: PEGI 3 - Apto para todos los públicos.\n" +
                "\n" +
                "10. Cargos y cuotas:\n" +
                "Cualquier uso de esta aplicación es totalmente gratuito.\n" +
                "\n" +
                "11. Cambios en nuestra Política de Privacidad:\n" +
                "Nuestra Política de Privacidad puede cambiar regularmente.\n" +
                "Publicaremos cualquier cambio de política de privacidad en esta sección, por lo que debe revisarla periódicamente.\n" +
                "\n" +
                "12. Contacto:\n" +
                "Si tiene alguna pregunta sobre esta Política o para informar de cualquier violación de la Política, envíe un correo electrónico a: "+correo_electronico;

        texto_politica.setText(texto);

    }




}