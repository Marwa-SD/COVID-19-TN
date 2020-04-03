package com.example.covid_19_tn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.common.collect.Range;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Identification extends AppCompatActivity {
    private EditText nomu, prenomu, telu, cinu,postal,ageu,poidsu,tailleu;
    private RadioGroup radiog;
    private RadioButton genreu;
    private AwesomeValidation awesomeValidation;
   DatabaseReference reff;
   public static Citoyen citoyen;
   public static String genre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.identification);
        nomu =(EditText) findViewById(R.id.nom);
        prenomu = (EditText)findViewById(R.id.prenom);
        telu = (EditText)findViewById(R.id.tel);
        cinu = (EditText)findViewById(R.id.cin);
        postal =(EditText)findViewById(R.id.codePostal);
        ageu = (EditText)findViewById(R.id.age);
        poidsu = (EditText)findViewById(R.id.poids);
        tailleu = (EditText)findViewById(R.id.taille);
        radiog = (RadioGroup) findViewById(R.id.rg);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this, R.id.nom, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.tel, "^[0-9]{8}$", R.string.mobileerror);
        awesomeValidation.addValidation(this, R.id.codePostal, "^[0-9]{4}$", R.string.codeerror);
        awesomeValidation.addValidation(this, R.id.cin, "^[0-9]{8}$", R.string.cinerror);
        awesomeValidation.addValidation(this, R.id.age, Range.closed(1,90 ), R.string.ageerror);
        Button button = (Button) findViewById(R.id.b);

        citoyen = new Citoyen();
        reff = FirebaseDatabase.getInstance().getReference().child("Citoyen");


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View View) {


                if (awesomeValidation.validate()) {
                    if(radiog.getCheckedRadioButtonId()!=-1){
                        genreu = (RadioButton) findViewById(radiog.getCheckedRadioButtonId());
                        genre = genreu.getText().toString().trim();
                        citoyen.setNom(nomu.getText().toString().trim());
                        citoyen.setGenre(genre);
                        citoyen.setPrenom(prenomu.getText().toString().trim());
                        citoyen.setAge(Integer.parseInt(ageu.getText().toString().trim()));
                        citoyen.setCin(Long.parseLong(cinu.getText().toString().trim()));
                        citoyen.setTel(Long.parseLong(telu.getText().toString().trim()));
                        citoyen.setCodeP(Integer.parseInt(postal.getText().toString().trim()));
                        citoyen.setPoids(Integer.parseInt(poidsu.getText().toString().trim()));
                        citoyen.setTaille(Integer.parseInt(tailleu.getText().toString().trim()));
                        //reff.push().setValue(citoyen);
                        Intent in = new Intent(getApplicationContext(),Questionnaire.class);
                        startActivity(in);
                }
            }}
        });
    }
}




