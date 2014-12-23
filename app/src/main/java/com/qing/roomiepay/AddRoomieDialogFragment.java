package com.qing.roomiepay;


import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;

/**
 * Created by Qing on 12/22/2014.
 */
public class AddRoomieDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.dialog_add_roomie, null))
                .setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
        return builder.create();
    }
}
