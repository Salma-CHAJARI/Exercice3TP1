package com.example.exercice3tp1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private CheckBox qt1r1,qt1r2,qt1r3,qt1r4;
    private RadioButton qt5oui,qt5non;
    private Button btnQuit,btnExa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        qt1r1=findViewById(R.id.qt1r1);
        qt1r2=findViewById(R.id.qt1r2);
        qt1r3=findViewById(R.id.qt1r3);
        qt1r4=findViewById(R.id.qt1r4);
        qt5oui=findViewById(R.id.qt5oui);
        qt5non=findViewById(R.id.qt5non);
        btnQuit=findViewById(R.id.btnQuit);
        btnExa=findViewById(R.id.btnExa);
        Intent in = new Intent(MainActivity.this,ResultActivity.class);
        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });
        btnExa.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int note=2;
                if(!qt1r1.isChecked() && !qt1r2.isChecked() && !qt1r3.isChecked() && !qt1r4.isChecked() ){
                    Toast.makeText(MainActivity.this,"S'il vous plait séléctionner votre réponse!",Toast.LENGTH_LONG).show();
                }
                else if(qt1r1.isChecked() && qt1r2.isChecked() && qt1r3.isChecked() && qt1r4.isChecked() ){
                    note--;
                    in.putExtra("4choix","Vous avez cochez toutes les cases pour la 1ére question votre réponse est incorrecte");
                    if(qt5oui.isChecked()){
                        in.putExtra("oui","Vous avez bien répondu au question 2 bravo!");
                    }else{
                        note--;
                        in.putExtra("non","Votre réponse du deuxiéme question est incorrecte");
                    }
                    in.putExtra("note",note);
                    startActivity(in);
                }
                else{
                    if(qt1r1.isChecked()){
                        note--;
                        in.putExtra("qt1r1","La réponse du 1 ére question est incorrecte.");
                    }
                    if(qt1r2.isChecked()){
                        in.putExtra("qt1r2","La réponse du 1 ére question est correcte.");

                    }
                    if(qt1r3.isChecked()){
                        note--;
                        in.putExtra("qt1r3","La réponse du 1 ére question est incorrecte.");
                    }
                    if(qt1r4.isChecked()){
                        note--;
                        in.putExtra("qt1r4","La réponse du 1 ére question est incorrecte.");
                    }
                    if(qt5oui.isChecked()){
                        in.putExtra("oui","Vous avez bien répondu au question 2 bravo!");
                    }else{
                        note--;
                        in.putExtra("non","Votre réponse du deuxiéme question est incorrecte");
                    }
                    in.putExtra("note",note);
                    startActivity(in);
                }

            }
        });



    }
}