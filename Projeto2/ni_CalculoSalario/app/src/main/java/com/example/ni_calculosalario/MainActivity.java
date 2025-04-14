package com.example.ni_calculosalario;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btnSalario, btnLimpar;
    private EditText textValor;
    private RadioButton rbPercentual1, rbPercentual2, rbPercentual3;
    private RadioGroup radioGroup;
    private TextView textResultado;
    private double percentual = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Log.i("Ciclo de Vida", "Tela 2 - OnCreate");

        // inicializando as variaveis
        btnSalario = findViewById(R.id.btnSalario);
        btnLimpar = findViewById(R.id.btnLimpar);
        textValor = findViewById(R.id.TextValor);

        rbPercentual1 = findViewById(R.id.rbPercentual1);
        rbPercentual2 = findViewById(R.id.rbPercentual2);
        rbPercentual3 = findViewById(R.id.rbPercentual3);
        radioGroup = findViewById(R.id.RadioGroup);

        textResultado = findViewById(R.id.TextResultado);

        configurarRadioGroup();

        // declarando a ação d botão
        btnSalario.setOnClickListener(view -> {
            String salarioTexto = textValor.getText().toString();

            // garantindo que não terá erros
            if (salarioTexto.isEmpty()) {
                Toast.makeText(this, "Digite o salário", Toast.LENGTH_SHORT).show();
                return;
            }

            double salario = Double.parseDouble(salarioTexto);
            double novoSalario = calcularNovoSalario(salario, percentual);

            textResultado.setText(String.format("Novo salário: R$ %.2f", novoSalario)); // formatando o texto
        });

        // definindo o que o bo botão limpa vai fazer
        btnLimpar.setOnClickListener(view -> {
            textValor.setText("");
            textResultado.setText("");
            radioGroup.clearCheck();
            percentual = 0.0;
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    //metodo para configuração do radio group
    private void configurarRadioGroup() {
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rbPercentual1) {
                percentual = 0.40;
            } else if (checkedId == R.id.rbPercentual2) {
                percentual = 0.45;
            } else if (checkedId == R.id.rbPercentual3) {
                percentual = 0.50;
            }
        });
    }

    //modulo para calcular o novo salario com a porcentagem
    private double calcularNovoSalario(double salario, double percentual) {
        return salario + (salario * percentual);
    }

    //ciclo de vida
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
