package com.example.exercice3tp1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {
    TextView resultq1, resultq2, note;
    Button btnr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        resultq1=findViewById(R.id.resultq1);
        resultq2=findViewById(R.id.resultq2);
        note=findViewById(R.id.note);
        Intent ins=getIntent();
        Intent inr=new Intent(ResultActivity.this,MainActivity.class);
        btnr=findViewById(R.id.btnr);
        if(ins.hasExtra("4choix")){
            resultq1.setText(ins.getStringExtra("4choix"));
            resultq1.setTextColor(getResources().getColor(R.color.red));
        }
        else if(ins.hasExtra("qt1r1")){
            resultq1.setText(ins.getStringExtra("qt1r1"));
            resultq1.setTextColor(getResources().getColor(R.color.red));
        }
        else if(ins.hasExtra("qt1r2")){
            resultq1.setText(ins.getStringExtra("qt1r2"));
            resultq1.setTextColor(getResources().getColor(R.color.green));
        }
        else if(ins.hasExtra("qt1r3")){
            resultq1.setText(ins.getStringExtra("qt1r3"));
            resultq1.setTextColor(getResources().getColor(R.color.red));
        }else{
            resultq1.setText(ins.getStringExtra("qt1r4"));
            resultq1.setTextColor(getResources().getColor(R.color.red));
        }
        if (ins.hasExtra("oui")){
            resultq2.setText(ins.getStringExtra("oui"));
            resultq2.setTextColor(getResources().getColor(R.color.green));
        }
        else{
            resultq2.setText(ins.getStringExtra("non"));
            resultq2.setTextColor(getResources().getColor(R.color.red));
        }
        int n=ins.getIntExtra("note",2);
        note.setText(String.valueOf(n) + " sur 2");
        btnr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(inr);
            }
        });
    }

}