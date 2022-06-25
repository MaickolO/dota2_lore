package com.orizevtechnologies.historia_de_dota_2.fragmentPrincipal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.orizevtechnologies.historia_de_dota_2.Detalle.politica_privacidad;
import com.orizevtechnologies.historia_de_dota_2.R;

public class informacion extends Fragment {

    private LottieAnimationView compartir;
    private LottieAnimationView politica;
    private LottieAnimationView contacto;

    private LinearLayout layout_compartir;
    private LinearLayout layout_politica;
    private LinearLayout layout_contacto;

    private final String nombre_app = "Lore de Dota 2";
    private final String link = "link app";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_informacion, container, false);

        init_view(view);
        lottie();
        click_layouts();

        return view;
    }

    private void init_view(View view) {
        compartir = view.findViewById(R.id.lottie_compartir);
        politica = view.findViewById(R.id.lottie_politica);
        contacto = view.findViewById(R.id.lottie_contacto);
        layout_compartir = view.findViewById(R.id.layout_compartir);
        layout_politica = view.findViewById(R.id.layout_politica);
        layout_contacto = view.findViewById(R.id.layout_contacto);
    }

    @SuppressLint("IntentReset")
    private void click_layouts() {


        layout_compartir.setOnClickListener(view -> {
            compartir.playAnimation();
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Mira este nuevo juego \""+nombre_app+"\" en Google Play! juégalo GRATIS Ahora - "+link);
            sendIntent.setType("text/plain");
            Intent shareIntent = Intent.createChooser(sendIntent, null);
            startActivity(shareIntent);
        });

        layout_contacto.setOnClickListener(view -> {
            contacto.playAnimation();
            enviarEmail();

        });

        layout_politica.setOnClickListener(view -> {
            try {
                politica.playAnimation();
                Intent intent = new Intent(getContext(), politica_privacidad.class);
                startActivity(intent);
            } catch (Exception e) {

            }
        });

    }

    //ClickCerrar
    private void lottie() {

        compartir.setOnClickListener(view -> {
            compartir.playAnimation();
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Mira este nuevo juego \""+nombre_app+"\" en Google Play! juégalo GRATIS Ahora - "+link);
            sendIntent.setType("text/plain");
            Intent shareIntent = Intent.createChooser(sendIntent, null);
            startActivity(shareIntent);
        });

        politica.setOnClickListener(view -> {
            politica.playAnimation();
            Intent intent = new Intent(getContext(), politica_privacidad.class);
            startActivity(intent);
        });

        contacto.setOnClickListener(view -> {
            contacto.playAnimation();
            enviarEmail();
        });

    }

    public void  enviarEmail(){

        String[] TO = {"michaelorizev@gmail.com"};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, nombre_app+" - contacto");

        try {
            startActivity(emailIntent);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getContext(), "No tienes ningún gestor de correo instalado", Toast.LENGTH_SHORT).show();
        }
    }



}