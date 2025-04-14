package com.example.ni_sistemadecompras;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // declarando variáveis
    private CheckBox cbCompra1, cbCompra2, cbCompra3, cbCompra4, cbCompra5;
    private TextView TextResultado;
    private Button btnTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Log.i("Ciclo de Vida", "Tela 2 - onCreate");

        // instanciando variaveis
        cbCompra1 = findViewById(R.id.cbCompra1);
        cbCompra2 = findViewById(R.id.cbCompra2);
        cbCompra3 = findViewById(R.id.cbCompra3);
        cbCompra4 = findViewById(R.id.cbCompra4);
        cbCompra5 = findViewById(R.id.cbCompra5);

        TextResultado = findViewById(R.id.TextResultado);

        btnTotal = findViewById(R.id.btnTotal);

        // passando o metodo para aparecer quando clico no botão
        btnTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Resultado();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // criando o metodo para mostrar o resultado
    public void Resultado (){
        double total = 0.0;

        if (cbCompra1.isChecked()) {
            total += 2.69;
        }
        if (cbCompra2.isChecked()) {
            total += 2.70;
        }
        if (cbCompra3.isChecked()) {
            total += 16.70;
        }
        if (cbCompra4.isChecked()) {
            total += 3.38;
        }
        if (cbCompra5.isChecked()) {
            total += 3.00;
        }

        // exibindo o resultado e formatando ele
        TextResultado.setText(String.format("Total: R$ %.2f", total));
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i("Ciclo de Vida", "Tela 2 - onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i("Ciclo de Vida", "Tela 2 - onPause");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("Ciclo de Vida", "Tela 2 - onDestroy");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("Ciclo de Vida", "Tela 2 - onStop");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("Ciclo de Vida", "Tela 2 - onRestart");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i("Ciclo de Vida", "Tela 2 - onStart");
    }
}
