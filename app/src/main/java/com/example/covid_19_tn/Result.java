package com.example.covid_19_tn;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Result extends AppCompatActivity {
    TextView tv, tv2, tv3;
    Button btnRestart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        tv = (TextView)findViewById(R.id.tvres);
        btnRestart = (Button) findViewById(R.id.btnRestart);

       // StringBuffer sb = new StringBuffer();
        if ((Questionnaire.marks <= 3)&&(Questionnaire.codeRouge.isEmpty())) {
            tv.setBackgroundColor(Color.rgb(144,238,144));
            tv.setText("Vous êtes en bonne sante" + "\n" +"Surveillez l'apparition d'autres symptômes et refaites le test dans 4 jours" + "\n" +"Restez chez vous "+ "\n" + "Respectez les règles de confinement");
        }
        else if ((Questionnaire.marks>=4)&&(Questionnaire.marks <= 6) &&(Questionnaire.codeRouge.isEmpty())){
            tv.setBackgroundColor(Color.rgb(255,165,0));
                tv.setText("Moyennement suspecté"+"\n"+"Un medecin vous contactera le plus tôt possible"+"\n"+"Restez chez vous "+"\n"+"Evitez tout contact avec les personnes de votre entourage"+"\n"+"Respectez les règles de confinement");
            }
        else if ((Questionnaire.marks>=7)||(!Questionnaire.codeRouge.isEmpty())){
            tv.setBackgroundColor(Color.rgb(255,0,0));
            tv.setText("Fortement suspecté"+"\n"+"Appelez 190"+"\n"+"Un medecin vous contactera le plus tôt possible"+"\n"+"Restez chez vous "+"\n"+"Evitez tout contact avec les personnes de votre entourage"+"\n"+"Respectez les règles de confinement");
        }


        //sb.append( Questionnaire.etat[0] + "\n");
       // StringBuffer sb2 = new StringBuffer();
       // sb2.append("");
        //StringBuffer sb3 = new StringBuffer();
       // sb3.append("");

        Questionnaire.marks=0;

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),Questionnaire.class);
                startActivity(in);
            }
        });
    }

}
