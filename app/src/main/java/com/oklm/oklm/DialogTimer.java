package com.oklm.oklm;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
/**
 * Created by aiello on 27/04/2016.
 */
public class DialogTimer extends DialogFragment  {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the Builder class for convenient dialog construction
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage("Timer")
                    .setPositiveButton("1 min", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // FIRE ZE MISSILES!
                            ((MainActivity)getActivity()).ChangeTimer(60000);
                            ((MainActivity)getActivity()).ChangeCountDownTimer();
                            ((MainActivity)getActivity()).Chrono.setText(60 + "");
                        }
                    })
                    .setNegativeButton("30 sec", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // User cancelled the dialog
                            ((MainActivity)getActivity()).ChangeTimer(30000);
                            ((MainActivity)getActivity()).ChangeCountDownTimer();
                            ((MainActivity)getActivity()).Chrono.setText(30 + "");
                        }
                    });
            // Create the AlertDialog object and return it
            return builder.create();
        }



}
