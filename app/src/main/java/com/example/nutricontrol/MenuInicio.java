package com.example.nutricontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MenuInicio extends AppCompatActivity {

    private EditText txtUser;
    private EditText txtPass;
    private Button btnIngresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_inicio);
        btnIngresar = (Button) findViewById(R.id.buttonContinuar);
        txtUser = (EditText) findViewById(R.id.txtUser);
        txtPass = (EditText) findViewById(R.id.txtPass);

    }

    public void continuar(View view){
        String user = txtUser.getText().toString();
        String pass = txtPass.getText().toString();

        if(user.isEmpty() || pass.isEmpty()){
            Toast.makeText(getApplicationContext(), "Faltan datos.", Toast.LENGTH_SHORT).show();
        }else{
            String[] archivo = fileList();

            if(exist(archivo, "users.txt")){
                conectar();
            }else{
                Toast.makeText(getApplicationContext(), "No hay usuarios registrados.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void registrarUser(View view){
        startActivity(new Intent(MenuInicio.this, RegistrarUsuario.class));
    }

    private void conectar(){
        try {
            InputStreamReader file = new InputStreamReader(openFileInput("users.txt"));
            BufferedReader br = new BufferedReader(file);
            String line = br.readLine();
            String[] datos = line.split(",");
            boolean exist = false;
            while (line!=null){
                if(datos[0].equals(txtUser)){
                    if(datos[1].equals(txtPass)){
                        txtUser.setText("");
                        txtPass.setText("");
                        startActivity(new Intent(MenuInicio.this, DatosUsuario.class));
                    }else{
                        Toast.makeText(getApplicationContext(), "Contraseña incorrecta.", Toast.LENGTH_SHORT).show();
                        exist = true;
                        break;
                    }
                }
                line = br.readLine();
            }
            if (exist == false){
                Toast.makeText(getApplicationContext(), "No existe la cuenta. Verifique nuevamente.", Toast.LENGTH_SHORT).show();
            }
            br.close();
            file.close();
        }catch (IOException e){}
    }

    private boolean exist(String[] file, String url){
        for (int i = 0; i < file.length; i++)
            if(url.equals(file[i]))
                return true;
        return false;
    }


}