package com.example.ni_pizzaria;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResumoPedido extends AppCompatActivity {

    private TextView T4TextResumo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resumo_pedido);

        Log.i("Ciclo de Vida", "Tela 4 - OnCreate");

        T4TextResumo = findViewById(R.id.T4TextResumo);

        //pegando dados
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            double valorPizza = bundle.getDouble("valorPizza");
            String metodoPagamento = bundle.getString("metodoPagamento");
            String sabores = bundle.getString("Sabores");

            String resumo = "Sabores: " + sabores + "\n" +
                    "Valor da Pizza: R$" + valorPizza + "\n" +
                    "Método de Pagamento: " + metodoPagamento;

            T4TextResumo.setText(resumo);
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    //ciclo de vida
    @Override
    protected void onResume(){
        super.onResume();
        Log.i("Ciclo de Vida", "Tela 4 - onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i("Ciclo de Vida", "Tela 4 - onPause");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("Ciclo de Vida", "Tela 4 - onDestroy");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("Ciclo de Vida", "Tela 4 - onStop");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("Ciclo de Vida", "Tela 4 - onRestart");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i("Ciclo de Vida", "Tela 4 - onStart");
    }
}
