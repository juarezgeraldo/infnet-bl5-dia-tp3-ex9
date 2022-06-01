package com.br.juarezjunior.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool;
    private TextInputEditText editPrecoGasolina;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoBasolina);
        resultado = findViewById(R.id.textResultado);
    }

    public void calcular(View view) {

        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        boolean camposValidados = validarCampos(precoAlcool, precoGasolina);
        if (camposValidados){
            double percentual = Double.parseDouble(precoAlcool) / Double.parseDouble(precoGasolina);
            if (percentual < 0.7) {
                resultado.setText("Melhor utilizar álcool - " + percentual);
            } else {
                resultado.setText("Melhor utilizar gasolina - " + percentual);
            }
        }else{
            resultado.setText("Preencha todos os campos");
        }


/*        if (precoAlcool.getText().toString() != "") {
            if (precoGasolina.getText().toString() != "") {
                double percentual = Double.parseDouble(precoAlcool.getText().toString()) / Double.parseDouble(precoGasolina.getText().toString());
                if (percentual < 0.7) {
                    resultado.setText("Melhor utilizar álcool - " + percentual);
                } else {
                    resultado.setText("Melhor utilizar gasolina - " + percentual);
                }
            }else{
                resultado.setText("Verifique informação do preço da gasolina, pois há inconsistência");
            }
        }else{
            resultado.setText("Verifique informação do preço do álcool, pois há inconsistência");
        }
 */
    }


    public boolean validarCampos(String pAlcool, String pGasolina) {
        boolean camposValidados = true;
        if (pAlcool == null || pAlcool.equals("")) {
            camposValidados = false;
        } else {
            if (pGasolina == null || pGasolina.equals("")) {
                camposValidados = false;
            }
        }
        return camposValidados;
    }

}

