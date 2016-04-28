package com.oklm.oklm;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;


public class CreditActivity extends AppCompatActivity {

    private RelativeLayout LayoutBackground;
    private int flag = 1;
    Message myMessage;
    private boolean authorisation=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);

        LayoutBackground = (RelativeLayout) findViewById(R.id.Background);

        //exemple de thread et handler classique en Java - android, permettant de modifier l'ihm à la volée seulement dans le handler car dans le thread on peut pas
       final Handler mHandler = new Handler();

        new Thread(new Runnable() {
            @Override
            public void run () {

                while(true) {
                    if(authorisation){


                    try {
                        Thread.sleep(100);
                    } catch (Throwable t) {
                    } //sleep 100 ms
                    // Envoyer le message au Handler (la méthode handler.obtainMessage est plus efficace
                    // que créer un message à partir de rien, optimisation du pool de message du Handler)
                    //Instanciation du message (la bonne méthode):
                    myMessage = mHandler.obtainMessage();
                    //Envoyer le message
                    mHandler.sendMessage(myMessage);

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {

                        if (flag == 1) {
                            LayoutBackground.setBackgroundColor(0xFFFFFF00); //Jaune
                            flag = 0;
                        } else {
                            LayoutBackground.setBackgroundColor(0xFFFF0000); //rouge
                            flag = 1;
                        }
                    }
                });
                    }
             }
            }

        }).start();

        //new ChangeBackground().execute("");


    }

    /************************************************************************************/
/** Gestion du cycle de vie *******************************************************************/
    /**************************************************************************************/
    //Méthode appelée quand l'activité s'arrête
    public void onStop() {
        super.onStop();
        //Mise-à-jour du booléen pour détruire la Thread de background
        authorisation = false;
    }
    @Override
    protected void onPause() {
        super.onPause();
        // Mise-à-jour du booléen pour mettre en pause la Thread de background
        authorisation = false;
    }
    @Override
    protected void onResume() {
        super.onResume();
        // Mise-à-jour du booléen pour relancer la Thread de background
        authorisation = true;
    }


    //asynctask
//    private class ChangeBackground extends AsyncTask<String, Void, String> {
//        @Override
//        protected String doInBackground(String... params) {
//
//
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                // TODO Auto-generated catch block
//                Thread.interrupted();
//                e.printStackTrace();
//            }
//
//
//            return null;
//
//        }
//
//        @Override
//        protected void onPostExecute(String result) {
//
//                    if (flag == 1) {
//                        LayoutBackground.setBackgroundColor(0xFFFFFF00); //Jaune
//                        flag = 0;
//                    } else {
//                        LayoutBackground.setBackgroundColor(0xFFFF0000); //rouge
//                    flag = 1;
//                }
//            }
//
//
//        @Override
//        protected void onPreExecute() {
//        }
//
//        @Override
//        protected void onProgressUpdate(Void... values) {
//        }
//    }

}
