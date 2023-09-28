package com.example.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etNumero;
    private Button btnCalcular;
    private TextView tvResultado;

    private CalcularViewModel calcularViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configview();
    }

    private void configview() {
        etNumero = findViewById(R.id.etNumero);
        btnCalcular = findViewById(R.id.btnCalcular);
        tvResultado = findViewById(R.id.tvResultado);
        calcularViewModel = new ViewModelProvider(this).get(CalcularViewModel.class);

        btnCalcular.setOnClickListener(v -> {
            int numero = Integer.parseInt(etNumero.getText().toString());
            calcularViewModel.calcular(numero);
        });

        calcularViewModel.getResultado().observe(this, integer -> tvResultado.setText(String.valueOf(integer)));


    }
}