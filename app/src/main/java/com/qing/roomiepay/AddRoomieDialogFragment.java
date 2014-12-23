package com.qing.roomiepay;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.qing.roomiepay.dao.RoomieDAO;

/**
 * Created by Qing on 12/22/2014.
 */
public class AddRoomieDialogFragment extends DialogFragment {
    private RoomieDAO roomieDAO;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        roomieDAO = new RoomieDAO();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.dialog_add_roomie, null))
                .setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        TextView textView = (TextView) getView().findViewById(R.id.roomie_name);
                        roomieDAO.addRoomie(textView.toString());
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
        return builder.create();
    }

    public interface AddRoomieDialogListener{
        public void onDialogPositiveClick(DialogFragment dialog);
        public void onDialogNegativeClick(DialogFragment dialog);
    }

    AddRoomieDialogListener mListener;
    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        try{
            mListener = (AddRoomieDialogListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement NoticeDialogListener");
        }
    }
}
