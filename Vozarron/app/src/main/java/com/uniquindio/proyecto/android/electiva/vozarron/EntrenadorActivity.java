package com.uniquindio.proyecto.android.electiva.vozarron;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EntrenadorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrenador);
    }

    /**
     * Metodo encargado de pasar a la ventana participantes
     *
     * @param view
     */
    public void pasarAParticipantes(View view) {
        Intent intent = new Intent(this, ParticipantesActivity.class);
        startActivity(intent);
    }
}
