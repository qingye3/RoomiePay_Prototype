package com.qing.roomiepay.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.qing.roomiepay.EditRoomieActivity;
import com.qing.roomiepay.R;
import com.qing.roomiepay.bean.AmountBean;
import com.qing.roomiepay.bean.RoomieBean;

import java.util.ArrayList;

/**
 * Created by Qing on 12/30/2014.
 */
public class RoomieBookAdapter extends ArrayAdapter<AmountBean>{
    Context context;
    RoomieBean roomie;

    public RoomieBookAdapter(Context context, RoomieBean roomie){
        super(context, 0, new ArrayList<AmountBean>());
        this.context = context;
        this.roomie = roomie;
    }

    public interface RoomieBookAdapterListener{
        public void onRemovingAmount(AmountBean amount);
    }

    RoomieBookAdapterListener mListener;
    public void setListener(RoomieBookAdapterListener listener){
        mListener = listener;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        View vi = convertView;
        if (convertView == null) {
            vi = LayoutInflater.from(getContext()).inflate(R.layout.row_with_delete, parent, false);
        }
        final TextView text = (TextView) vi.findViewById(R.id.textView);
        final Button button = (Button) vi.findViewById(R.id.delete);
        final AmountBean amount = getItem(position);
        if (amount != null && text != null){
            text.setText(amount.toText());
            text.setTag(position);
        }
        button.setTag(position);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onRemovingAmount(amount);
                clear();
                addAll(roomie.getExpenditures());
                addAll(roomie.getIOUs());
            }
        });
        return vi;
    }
}
