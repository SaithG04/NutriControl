package com.example.nutricontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class DatosUsuario extends AppCompatActivity {

    private EditText eText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_usuario);

        eText = (EditText) findViewById(R.id.dato);
        String[] archivo = fileList();

        if(exist(archivo, "datosUsuario.txt")){
            try {
                InputStreamReader file = new InputStreamReader(openFileInput("datosUsuario.txt"));
                BufferedReader br = new BufferedReader(file);
                String line = br.readLine();
                String texto = "";
                while (line!=null){
                    texto = texto + line + "\n";
                    line = br.readLine();
                }
                br.close();
                file.close();
                eText.setText(texto);
            }catch (IOException e){

            }
        }
    }
    private boolean exist(String[] file, String url){
        for (int i = 0; i < file.length; i++)
            if(url.equals(file[i]))
                return true;
        return false;
    }

    public void save(View view){
        try {
            OutputStreamWriter file = new OutputStreamWriter(openFileOutput("datosUsuario.txt", Activity.MODE_PRIVATE));
            file.write(eText.getText().toString());
            file.flush();
            file.close();
            Toast.makeText(getApplicationContext(), "GUARDADO", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {

        }

    }
}