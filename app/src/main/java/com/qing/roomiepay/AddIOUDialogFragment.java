package com.qing.roomiepay;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.qing.roomiepay.bean.ExpenditureBean;
import com.qing.roomiepay.bean.IOUBean;
import com.qing.roomiepay.dao.RoomieDAO;

/**
 * Created by Qing on 12/30/2014.
 */
public class AddIOUDialogFragment extends DialogFragment{
    private IOUBean iou = null;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        RoomieDAO dao = new RoomieDAO();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View v = inflater.inflate(R.layout.dialog_add_iou, null);
        final Spinner spinner = (Spinner) v.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, dao.getAllNames());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        builder.setView(v)
                .setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        TextView amount = (TextView) v.findViewById(R.id.amount_text);
                        iou = new IOUBean(spinner.getSelectedItem().toString(), textView2Double(amount));
                        mListener.onIOUDialogPositiveClick(AddIOUDialogFragment.this);
                    }


                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        iou = null;
                        mListener.onIOUDialogNegativeClick(AddIOUDialogFragment.this);
                    }
                });
        return builder.create();
    }

    public IOUBean getIOU() {
        return iou;
    }

    private double textView2Double(TextView amount) {
        return Double.parseDouble(amount.getText().toString());
    }

    public interface AddIOUDialogListener{
        public void onIOUDialogPositiveClick(AddIOUDialogFragment dialog);
        public void onIOUDialogNegativeClick(AddIOUDialogFragment dialog);
    }

    AddIOUDialogListener mListener;
    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        try{
            mListener = (AddIOUDialogListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement AddExpenditureDialogListener");
        }
    }
}
