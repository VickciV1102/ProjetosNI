package com.example.ni_pizzaria;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btnIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Log.i("Ciclo de Vida", "Tela 1 - OnCreate");
        btnIniciar = findViewById(R.id.btnIniciar);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //direcionando para a proxima ativity ao clicar no botão
        btnIniciar.setOnClickListener(view -> {
            Intent intent = new Intent(this, SelecaoDePizza.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i("Ciclo de Vida", "Tela 1 - onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i("Ciclo de Vida", "Tela 1 - onPause");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("Ciclo de Vida", "Tela 1 - onDestroy");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("Ciclo de Vida", "Tela 1 - onStop");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("Ciclo de Vida", "Tela 1 - onRestart");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i("Ciclo de Vida", "Tela 1 - onStart");
    }
}