package com.oklm.oklm;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private int Resultat;
    private int score=0;
    private boolean jeuxEnCours=false;
    private ArrayList<ImageView> Colorresult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView Chrono = (TextView)findViewById(R.id.textView);
        final TextView Score = (TextView)findViewById(R.id.textView2);

        //gestion des couleurs imageview
        final ImageView RougeResult = (ImageView)findViewById(R.id.ResultRouge);
        final ImageView BleuResult = (ImageView)findViewById(R.id.ResultBleu);
        final ImageView VertResult = (ImageView)findViewById(R.id.ResultVert);
        final ImageView GrisResult = (ImageView)findViewById(R.id.ResultGris);

        Colorresult= new ArrayList<ImageView>();
        Colorresult.add(RougeResult); //0
        Colorresult.add(BleuResult); //1
        Colorresult.add(VertResult); //2
        Colorresult.add(GrisResult); //3






        /*** Gestion du bouton GO***/
        final Button Go = (Button) findViewById(R.id.goBoutton);
       //initialisation Timer
       final CountDownTimer  Test=  new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
              Chrono.setText(""+millisUntilFinished / 1000);

            }

            public void onFinish() {
              Chrono.setText("Over!");
                Go.setVisibility(View.VISIBLE);

                //gone tous les results
                RougeResult.setVisibility(View.GONE);
                BleuResult.setVisibility(View.GONE);
                VertResult.setVisibility(View.GONE);
                GrisResult.setVisibility(View.GONE);

                jeuxEnCours=false;
            }
        };


        Go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //4 couleurs on randomize sur 4
                NewColor(); //fonction qui lance le jeux
                score=0;
                jeuxEnCours=true;
                Test.start();
                Go.setVisibility(View.GONE);


            }
        });



        //gestion du click sur un boutton de couleur
        Button BouttonRouge = (Button)findViewById(R.id.button2);
        Button BouttonBleu = (Button)findViewById(R.id.button);
        Button BouttonVert = (Button)findViewById(R.id.button3);
        Button BouttonGris = (Button)findViewById(R.id.button4);

        BouttonRouge.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                if(jeuxEnCours ) {
                    if (Resultat == (int) Color.Rouge.getNumColor()) {
                        score = score + 1;
                        Score.setText(score + " ");
                    }
                    NewColor();
                }
            }});
        BouttonBleu.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                if(jeuxEnCours ) {
                    if (Resultat == (int) Color.Bleu.getNumColor()) {
                        score = score + 1;
                        Score.setText(score + " ");
                    }
                    NewColor();
                }
            }});
        BouttonVert.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                if(jeuxEnCours ) {
                    if (Resultat == (int) Color.Vert.getNumColor()) {
                        score = score + 1;
                        Score.setText(score + " ");
                    }
                    NewColor();
                }
            }});
        BouttonGris.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {

               if(jeuxEnCours ) {
                   if (Resultat == (int) Color.Gris.getNumColor()) {
                       score = score + 1;
                       Score.setText(score + " ");
                   }
                   NewColor();
               }
            }});

    }



    //genère la prochaine couleur et affiche le resultat correspondant
    public void NewColor(){

        //la couleur que l'on va afficher ensuite
         Resultat= randomisation(4);
        //on met tout à gone
        for(ImageView item : Colorresult )
        {
            item.setVisibility(View.GONE);
        }

        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new DecelerateInterpolator()); //add this
        fadeIn.setDuration(450);

        AnimationSet animation = new AnimationSet(false); //change to false
        animation.addAnimation(fadeIn);

        Colorresult.get(Resultat).setAnimation(animation);
        //on affiche la couleur générer
        Colorresult.get(Resultat).setVisibility(View.VISIBLE);



    }

    // To animate view slide out from bottom to top
    public void slideToTop(View view){
        TranslateAnimation animate = new TranslateAnimation(0,0,0,-view.getHeight());
        animate.setDuration(500);
        animate.setFillAfter(true);
        view.startAnimation(animate);
        view.setVisibility(View.GONE);
    }


    //genère un nombre aléatoire entre 0 et i-1
    public int randomisation(int i){
        int Min=0;
        int Max=i-1;

        Random rand = new Random();
        return rand.nextInt(Max - Min + 1) + Min;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
