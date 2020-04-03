package com.example.covid_19_tn;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Questionnaire extends AppCompatActivity {

    TextView Q;
    Button submitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2;
    String questions[] = {
            "Est ce que vous avez eu un contact avec une personne étrangère ou quelqu'un contaminé ?",
            "Avez-vous  de la fièvre ces 48 dernières heures (>=38 prise par thermomètre) ? ",
            "Avez-vous des frissons et/ou des sueurs ?",
            "Ces dernières 24 heures, avez-vous de la nausée, vomissement  et/ou de la diarrhée (Avec au moins 3 selles molles.) ?",
            "Ces derniers jours,  y-a-t- il une apparition de  toux ou une augmentation de votre toux habituelle ?",
            "Ces derniers jours, avez-vous noté une forte diminution ou perte de votre goût ou de votre odorat ?",
            "Ces derniers jours, avez-vous eu un mal de gorge ou sécheresse de la gorge ?",
            "Ces derniers jours, avez-vous une asthénie (fatigue inhabituelle) ?",
            "Ces derniers jours avez-vous des douleurs musculaires et/ou des courbatures inhabituelles?",
            "Avez-vous des maux de tete (céphalé)",
            "Dans les dernières 24 heures, avez-vous noté un manque de souffle INHABITUEL lorsque vous parlez ou lors d' un petit effort ou une difficulté respiratoire ou étouffement ? ",
            "Avez-vous des douleurs toracique?",
            "Avez-vous de l’hypertension artérielle mal équilibrée ? Ou avez-vous une maladie cardiaque ou vasculaire ? Ou prenez vous un traitement à visée cardiologique ?",
            "Êtes-vous diabétique sous insuline?",
            "Avez-vous eu un cancer ?",
            "Avez-vous une maladie respiratoire (asthme ou autre) ? Ou êtes-vous suivi par un pneumologue ?",
            "Avez-vous une insuffisance rénale chronique dialysée ?",
            "Avez-vous une maladie chronique du foie ?",
            "Êtes-vous enceinte ?",
            "Avez-vous une maladie connue qui diminue  vos défenses immunitaires ? ou Prenez-vous un traitement immunosuppresseur (C'est un traitement qui diminue vos défenses contre les infections )? ",
            "Avez-vous prenez des anti-inflamatoire ?",
            "AAvez-vous des difficultés à manger et à boire?"
    };
    String questionsAr[] = {
            "جيت من الخارج ولا قابلت شخص من الخارج؟",
            "عندك سخانة من 38 درجة فما  فوق؟",
            "هل تعاني من قشعريرة و / أو تعرّق؟",
            "  خلال الـ 24 ساعة لتعداو ،  عاندكش ردّان و / أو إسهال ؟",
            "في الأيامات لتعداو لخرى ،  عندكشي بداية كحة أو زيادة في الكحة المعتادة؟",
            "في الأيامات لتعداو لخرى ،  لاحظت انخفاض حاد أو فقدان في  الذوق أوحاسة الشم؟",
            "في الأيامات لتعداو لخرى ،  عندكشي التهاب  ولا جفاف في حلقك؟",
            "في الأيامات لتعداو لخرى ،   حسيتشي بالتعب (بالفشلة)؟",
            "خلال الـ 24 ساعة لتعداو ، لاحظتش عندك ضيق تنفس غير عادي عند التحدث أو أثناء جهد بسيط أو صعوبة في التنفس أو اختناق؟",
            "",
            "عندكشي  غلظ الدم؟ أوعندكشي مرض القلب ؟ أو أنك تاخذ علاج القلب؟",
            "عندكشي مرض السكري و تستعمل في الأنسولين؟",
            "هل أنت مصاب بالسرطان؟",
            "عندكشي مرض  في التنفس (فدة أو غيره)؟ ولا إتبع مع طبيب أمراض الرئة؟",
            "عندكشي أمراض الكلى المزمنة أوتعمل في تصفية (دياليز)؟",
            "عندكشي تليف كبدي  (مرض كبدي مزمن)؟",
            "هل انت حامل ؟",
            "عندكشي مرض  يقلل من المناعة متاعك ؟",
            "تاخو في العلاج  إطّيح في المناعة؟" +"\n"+
                    "كيما الأمثلة هاذي: الكورتيكوستيرويدات والميثوتريكسات والسيكلوسبورين والتاكروليموس والأزاثيوبرين وسيكلوفوسفاميد.",
            "تشرب في  أدوية مضادة للالتهابات؟"

    };
    int score[] = {300, 20, 20, 1, 20, 1, 1, 1, 1,1,300, 200, 1, 1, 1, 20, 2, 2, 1, 20, 10, 10};
    String opt[] = {
            "Oui","Non"
    };
    int flag=0;
    public static int marks=0;
    public static List<String> etat = new ArrayList<>();
    public static List<String> codeRouge = new ArrayList<>();
    public static List<String> codeOrange = new ArrayList<>();
    DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionnaire);

        final TextView sc = (TextView)findViewById(R.id.textView4);
        marks=0;
        submitbutton=(Button)findViewById(R.id.button3);
        Q=(TextView) findViewById(R.id.questions);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.rb1);
        rb2=(RadioButton)findViewById(R.id.rb2);
        Q.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        //final int i =0;

        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Veuillez sélectionner un choix", Toast.LENGTH_SHORT).show();
                    return;
                }
                if ((flag==15)&&(Identification.genre.equals("Homme"))){flag++;}
                RadioButton userans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = userans.getText().toString();
                if(ansText.equals(opt[0])) {
                    if (score[flag] % 100 == 0){codeRouge.add(questions[flag]);}
                    else if ((score[flag] % 100 != 0)&&((score[flag] % 10 == 0))){codeOrange.add(questions[flag]);marks+=score[flag] / 10;}
                    else{marks+=score[flag];}
                    etat.add(questions[flag]);
                    Toast.makeText(getApplicationContext(),questions[flag] , Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (sc != null)
                    sc.setText(""+marks);

                if(flag<questions.length)
                {
                    Q.setText(questions[flag]);
                    rb1.setText(opt[0]);
                    rb2.setText(opt[1]);
                }
                else {
                    submitbutton.setText("Résultat");
                }
                if(submitbutton.getText().equals("Résultat")){
                    reff = FirebaseDatabase.getInstance().getReference().child("Citoyen");
                    Identification.citoyen.setEtat(etat);
                    Identification.citoyen.setQorange(codeOrange);
                    Identification.citoyen.setQRouge(codeRouge);
                    reff.push().setValue(Identification.citoyen);
                    Intent in = new Intent(getApplicationContext(),Result.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

    }

}

