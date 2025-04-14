package com.example.ni_pizzaria;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SelecaoTamanhoEPagamento extends AppCompatActivity {

    private RadioButton rbTamanho1, rbTamanho2, rbTamanho3, rbPagamento1, rbPagamento2, rbPagamento3, rbPagamento4;
    private Button btnPagar;
    private RadioGroup rgTamanho, rgPagamento;
    private String metodoPagamento = "";
    private double valorPizza = 0.0;
    private int quantidade = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_selecao_tamanho_epagamento);

        Log.i("Ciclo de Vida", "Tela 3 - OnCreate");

        quantidade = getIntent().getIntExtra("Quantidade", 1);

        rbTamanho1 = findViewById(R.id.rbTamanho1);
        rbTamanho2 = findViewById(R.id.rbTamanho2);
        rbTamanho3 = findViewById(R.id.rbTamanho3);

        rbPagamento1 = findViewById(R.id.rbPagamento1);
        rbPagamento2 = findViewById(R.id.rbPagamento2);
        rbPagamento3 = findViewById(R.id.rbPagamento3);
        rbPagamento4 = findViewById(R.id.rbPagamento4);

        rgTamanho = findViewById(R.id.rgTamanho);
        rgPagamento = findViewById(R.id.rgPagamento);

        btnPagar = findViewById(R.id.btnPagar);

        //chamando metodos
        TamanhoPizza();
        MetodoPagamento();

        btnPagar.setOnClickListener(view -> {
            if (valorPizza == 0.0) {
                Toast.makeText(this, "Selecione o tamanho da pizza.", Toast.LENGTH_SHORT).show(); //garante que o usuario selecione alguma opção
                return;
            }
            if (metodoPagamento.isEmpty()) {
                Toast.makeText(this, "Selecione o método de pagamento.", Toast.LENGTH_SHORT).show();//garante que o usuario selecione alguma opção
                return;
            }

            String saboresSelecionados = getIntent().getStringExtra("Sabores");

            Intent intent = new Intent(this, ResumoPedido.class);
            Bundle bundle = new Bundle();
            double valorTotal = valorPizza * quantidade;
            bundle.putDouble("valorPizza", valorTotal);
            bundle.putString("metodoPagamento", metodoPagamento);
            bundle.putString("Sabores", saboresSelecionados);
            intent.putExtras(bundle);
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    //definindo preço para cada tamanho
    public void TamanhoPizza() {
        rgTamanho.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rbTamanho1) {
                valorPizza = 27.90;
            } else if (checkedId == R.id.rbTamanho2) {
                valorPizza = 37.90;
            } else if (checkedId == R.id.rbTamanho3) {
                valorPizza = 47.90;
            }
        });
    }

    //definindo metodos de pagamento
    public void MetodoPagamento() {
        rgPagamento.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rbPagamento1) {
                metodoPagamento = "Dinheiro";
            } else if (checkedId == R.id.rbPagamento2) {
                metodoPagamento = "Cartão de Débito";
            } else if (checkedId == R.id.rbPagamento3) {
                metodoPagamento = "Cartão de Crédito";
            } else if (checkedId == R.id.rbPagamento4) {
                metodoPagamento = "Pix";
            }
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
