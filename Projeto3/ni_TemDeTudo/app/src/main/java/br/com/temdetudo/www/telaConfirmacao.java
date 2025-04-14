package br.com.temdetudo.www;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class telaConfirmacao extends AppCompatActivity {

    private TextView textConfirmacao;
    private Button btnVoltar;
    private ImageView imgConfirmacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_confirmacao);

        Log.i("Ciclo de Vida", "Tela 3 - OnCreate");

        textConfirmacao = findViewById(R.id.textConfirmacao);
        btnVoltar = findViewById(R.id.btnVoltar);
        imgConfirmacao = findViewById(R.id.imgconfirmacao);

        // pegando o nome do cliente com bundle
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String nomeCliente = bundle.getString("NOME_CLIENTE");
            textConfirmacao.setText("Seja Bem-Vindo(a), " + nomeCliente + "!");
        }

        // voltando para a primeira activity
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent voltarIntent = new Intent(telaConfirmacao.this, MainActivity.class);
                startActivity(voltarIntent);
            }
        });

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
        Log.i("Ciclo de Vida", "Tela 3 - onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i("Ciclo de Vida", "Tela 3 - onPause");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("Ciclo de Vida", "Tela 3 - onDestroy");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("Ciclo de Vida", "Tela 3 - onStop");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("Ciclo de Vida", "Tela 3 - onRestart");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i("Ciclo de Vida", "Tela 3 - onStart");
    }
}
