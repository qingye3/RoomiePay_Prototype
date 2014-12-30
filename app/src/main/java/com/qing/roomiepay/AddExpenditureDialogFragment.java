package com.qing.roomiepay;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.qing.roomiepay.bean.ExpenditureBean;

/**
 * Created by Qing on 12/30/2014.
 */
public class AddExpenditureDialogFragment extends DialogFragment {
    private ExpenditureBean expenditure = null;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View v = inflater.inflate(R.layout.dialog_add_expenditure, null);
        builder.setView(v)
                .setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        TextView purpose = (TextView) v.findViewById(R.id.purpose_text);
                        TextView amount = (TextView) v.findViewById(R.id.amount_text);
                        expenditure = new ExpenditureBean(textView2String(purpose), textView2Double(amount));
                        mListener.onExpenditureDialogPositiveClick(AddExpenditureDialogFragment.this);
                    }


                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        expenditure = null;
                        mListener.onExpenditureDialogNegativeClick(AddExpenditureDialogFragment.this);
                    }
                });
        return builder.create();
    }

    public ExpenditureBean getExpenditure() {
        return expenditure;
    }

    private double textView2Double(TextView amount) {
        return Double.parseDouble(amount.getText().toString());
    }

    private String textView2String(TextView purpose) {
        return purpose.getText().toString();
    }

    public interface AddExpenditureDialogListener{
        public void onExpenditureDialogPositiveClick(AddExpenditureDialogFragment dialog);
        public void onExpenditureDialogNegativeClick(AddExpenditureDialogFragment dialog);
    }

    AddExpenditureDialogListener mListener;
    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        try{
            mListener = (AddExpenditureDialogListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement AddExpenditureDialogListener");
        }
    }
}
