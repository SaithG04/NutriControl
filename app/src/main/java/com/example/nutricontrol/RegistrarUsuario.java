package com.example.nutricontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.app.AlertDialog.Builder;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Calendar;
import java.util.Locale;
import java.util.zip.Inflater;

public class RegistrarUsuario extends AppCompatActivity {

    String sexo = "";
    String fechaNac = "";
    EditText nombres;
    EditText apellidos;
    EditText altura;
    EditText peso;
    RadioButton rbMasculino;
    RadioButton rbFemenino;
    RadioButton rbOtro;
    Button btnSelec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);
        nombres = findViewById(R.id.etNombres);
        apellidos = findViewById(R.id.etApellidos);
        altura = findViewById(R.id.etAltura);
        peso = findViewById(R.id.etPeso);
        btnSelec = findViewById(R.id.btnSeleccionar);
        rbMasculino = findViewById(R.id.rbMasculino);
        rbFemenino = findViewById(R.id.rbFemenino);
        rbOtro = findViewById(R.id.rbOtro);
    }

    public void save(View view){
        /*
        String nombresS = nombres.getText().toString();
        String apellidosS = apellidos.getText().toString();
        String alturaS = altura.getText().toString();
        String pesoS = peso.getText().toString();

        if(!btnSelec.getText().toString().equalsIgnoreCase("seleccionar")) fechaNac = btnSelec.getText().toString();

        if(nombresS.isEmpty() || apellidosS.isEmpty() || sexo.isEmpty() || fechaNac.isEmpty() || alturaS.isEmpty() || pesoS.isEmpty() || fechaNac.isEmpty()){
            Toast.makeText(this, "Faltan datos", Toast.LENGTH_SHORT).show();
        }else{
            short alturaSh = Short.parseShort(alturaS);
            double pesoD = Double.parseDouble(pesoS);
            if(alturaSh<100 || alturaSh>200) {
                Toast.makeText(this, "Altura inválida", Toast.LENGTH_SHORT);
            }else{
                if(pesoD<40 || pesoD>120) {
                    Toast.makeText(this, "Peso inválido", Toast.LENGTH_SHORT);
                }else{


                    /*
                    try {

                        OutputStreamWriter file = new OutputStreamWriter(openFileOutput("datos.txt", Activity.MODE_PRIVATE));

                        file.write(nombres + "," + apellidos + "," + sexo + "," + fechaNac + "," + altura+ "," + peso);
                        file.flush();
                        file.close();
                        Toast.makeText(getApplicationContext(), "GUARDADO", Toast.LENGTH_SHORT).show();

                    } catch (IOException e) {

                    }/*

                    Usuario usuario = new Usuario(nombresS, apellidosS, sexo, fechaNac, alturaSh, pesoD);
                    int id = 0;
                    Cuenta cuenta = new Cuenta((id + 1), "Usuario", "Contraseña", usuario);
                    Toast.makeText(getApplicationContext(), nombresS + "," + apellidosS + "," + sexo + "," + fechaNac + "," + alturaS + "," + pesoS, Toast.LENGTH_SHORT).show();
                }
            }
        }*/
        crearUser(view);
    }

    public void setSexoMasculino(View view){
        sexo = "Masculino";
    }

    public void setSexoFemenino(View view){
        sexo = "Femenino";
    }

    public void setSexoOtro(View view){
        sexo = "Otro";
    }

    public void openCalendar(View view) {
        Calendar calendar = Calendar.getInstance();
        int a = calendar.get(Calendar.YEAR);
        int m = calendar.get(Calendar.MONTH);
        int d = calendar.get(Calendar.DAY_OF_MONTH);

        if(btnSelec.getText().equals("SELECCIONAR")){
            DatePickerDialog dt = new DatePickerDialog(RegistrarUsuario.this, R.style.CalendarStyle,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int mes, int dia) {
                            String fecha, diaSt, mesSt;
                            if(dia<10) diaSt = "0" + dia +"/"; else diaSt = dia + "/";
                            if((mes + 1)<10) mesSt = "0" + (mes + 1) + "/"; else mesSt = (mes + 1) +"/";
                            fecha = diaSt + mesSt + year;
                            btnSelec.setText(fecha);
                        }
                    },a,m,d);
            dt.show();
        }else{
            String[] date = btnSelec.getText().toString().split("/");
            int dS = Integer.parseInt(date[0]);
            int mS = Integer.parseInt(date[1]) - 1;
            int aS = Integer.parseInt(date[2]);
            DatePickerDialog dt = new DatePickerDialog(RegistrarUsuario.this, R.style.CalendarStyle,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int mes, int dia) {
                            String fecha, diaSt, mesSt;
                            if(dia<10) diaSt = "0" + dia +"/"; else diaSt = dia + "/";
                            if((mes + 1)<10) mesSt = "0" + (mes + 1) + "/"; else mesSt = (mes + 1) +"/";
                            fecha = diaSt + mesSt + year;
                            btnSelec.setText(fecha);
                        }
                    },aS,mS,dS);
            dt.show();
        }
    }

    public void crearUser(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(RegistrarUsuario.this, R.style.AlertDialogStyle);
        builder.setTitle("USUARIO");
        final EditText userET = new EditText(RegistrarUsuario.this);
        userET.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
        userET.setHintTextColor(Color.GRAY);
        userET.setHint("Ingrese usuario.");
        builder.setView(userET);
        builder.setPositiveButton("OK",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String a = userET.getText().toString();
                Toast.makeText(RegistrarUsuario.this, a, Toast.LENGTH_SHORT).show();
                crearPassword(view);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }
    public void crearPassword(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(RegistrarUsuario.this, R.style.AlertDialogStyle);
        builder.setTitle("CONTRASEÑA");
        EditText passET = new EditText(RegistrarUsuario.this);
        passET.setInputType(InputType.TYPE_NUMBER_VARIATION_PASSWORD);
        passET.setHintTextColor(Color.GRAY);
        passET.setHint("Ingrese contraseña.");
        builder.setView(passET);
        builder.setPositiveButton("OK",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String a = passET.getText().toString();
                Toast.makeText(RegistrarUsuario.this, a, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }
}