package br.com.lanchefacil.www;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class FormularioDePedidos extends AppCompatActivity {

    private EditText InpuText;
    private Button btnLanche1,btnLanche2, btnLanche3, btnLanche4, btnconfirmar;
    private LinearLayout layerLanche1,layerLanche2, layerLanche3, layerLanche4;
    private TextView textLanche1, textLanche2, textLanche3, textLanche4;
    private String nome = "";
    private String LancheNome = "";
    private float precoDoLanche, precoDoLanche1, precoDoLanche2, precoDoLanche3, precoDoLanche4;
    private LinearLayout [] layouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_formulario_de_pedidos);

        Log.i("Ciclo de Vida", "Tela 2 - OnCreate");

        InpuText = findViewById(R.id.InpuText);
        btnconfirmar = findViewById(R.id.btnconfirmar);

        textLanche1 = findViewById(R.id.textLanche1);
        textLanche2 = findViewById(R.id.textLanche2);
        textLanche3 = findViewById(R.id.textLanche3);
        textLanche4 = findViewById(R.id.textLanche4);

        btnLanche1 = findViewById(R.id.btnLanche1);
        btnLanche2 = findViewById(R.id.btnLanche2);
        btnLanche3 = findViewById(R.id.btnLanche3);
        btnLanche4 = findViewById(R.id.btnLanche4);

        layerLanche1 = findViewById(R.id.layerLanche1);
        layerLanche2 = findViewById(R.id.layerLanche2);
        layerLanche3 = findViewById(R.id.layerLanche3);
        layerLanche4 = findViewById(R.id.layerLanche4);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //chamando os metodos
        PrecoLanches();
        Layers();

        // redireciona para a proxima pagina e envia os dados do cliente e sua escolha
        btnconfirmar.setOnClickListener(view -> {
            nome = InpuText.getText().toString();

            if(!nome.isEmpty()) {
                Intent intent = new Intent(this, ResumoDoPedido.class);
                intent.putExtra("nome", nome);
                intent.putExtra("precoDoLanche", precoDoLanche);
                intent.putExtra("nomeDoLanche", LancheNome);
                startActivity(intent);
                finish();
            } else{
                InpuText.setError("Por favor, digite seu nome"); //garantindo que a pessoa digitará o nome
            }
        });
    }

    //metodo para definir o preço dos laches
    public void PrecoLanches(){
        precoDoLanche1 = 32.00f;
        precoDoLanche2 = 18.00f;
        precoDoLanche3 = 22.90f;
        precoDoLanche4 = 12.00f;
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("pt", "BR"));
        DecimalFormat decimalFormat = new DecimalFormat("0.00", symbols);
        textLanche1.setText("R$"+ decimalFormat.format(precoDoLanche1));
        textLanche2.setText("R$"+ decimalFormat.format(precoDoLanche2));
        textLanche3.setText("R$"+ decimalFormat.format(precoDoLanche3));
        textLanche4.setText("R$"+ decimalFormat.format(precoDoLanche4));
    }

    //modulo que muda a cor dos layers quando clica nos botoes
    public void Layers(){
        layouts = new LinearLayout[4];
        layouts[0] = layerLanche1;
        layouts[1] = layerLanche2;
        layouts[2] = layerLanche3;
        layouts[3] = layerLanche4;

        btnLanche1.setOnClickListener(view -> {
            CorLayer(0);
            LancheNome = "X-Burguer";
            precoDoLanche = precoDoLanche1;
        });
        btnLanche2.setOnClickListener(view -> {
            CorLayer(1);
            LancheNome = "Hot Dog";
            precoDoLanche = precoDoLanche2;
        });
        btnLanche3.setOnClickListener(view -> {
            CorLayer(2);
            LancheNome = "Sanduiche";
            precoDoLanche = precoDoLanche3;
        });
        btnLanche4.setOnClickListener(view -> {
            CorLayer(3);
            LancheNome = "Batata Frita";
            precoDoLanche = precoDoLanche4;
        });
    }

    // definindo cores
    public void CorLayer(int index){
        for(int i = 0; i<4; i++){
            if(index == i){
                layouts[i].setBackgroundColor(Color.rgb(56, 142, 60 ));
            }
            else{
                layouts[i].setBackgroundColor(Color.argb(0,0,0,0));
            }
        }
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