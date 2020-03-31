package com.example.covid_19_tn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.common.collect.Range;

public class Identification extends AppCompatActivity {
    private EditText nomu, prenomu, telu, cinu,postal,ageu;
    private RadioGroup radiog;
    private AwesomeValidation awesomeValidation;
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
        radiog = (RadioGroup) findViewById(R.id.rg);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this, R.id.nom, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.tel, "^[0-9]{8}$", R.string.mobileerror);
        awesomeValidation.addValidation(this, R.id.codePostal, "^[0-9]{4}$", R.string.codeerror);
        awesomeValidation.addValidation(this, R.id.cin, "^[0-9]{8}$", R.string.cinerror);
        awesomeValidation.addValidation(this, R.id.age, Range.closed(1,90 ), R.string.ageerror);
        Button button = (Button) findViewById(R.id.b);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View View) {


                if (awesomeValidation.validate()) {
                    if(radiog.getCheckedRadioButtonId()==-1){

                        Intent in = new Intent(getApplicationContext(), Questionnaire.class);
                        startActivity(in);
                }
            }}
        });
    }
}




