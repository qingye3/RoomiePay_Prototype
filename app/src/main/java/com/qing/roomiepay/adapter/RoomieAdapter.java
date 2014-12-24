package com.qing.roomiepay.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.qing.roomiepay.R;
import com.qing.roomiepay.bean.RoomieBean;

import java.util.ArrayList;

/**
 * Created by Qing on 12/23/2014.
 */
public class RoomieAdapter extends ArrayAdapter<RoomieBean>{
    public RoomieAdapter(Context context, int resource, ArrayList<RoomieBean> roomies) {
        super(context,0, roomies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View vi = convertView;
        if (convertView == null) {
            vi = LayoutInflater.from(getContext()).inflate(R.layout.roomie_row, parent, false);
        }
        TextView text = (TextView) vi.findViewById(R.id.roomie_name);
        Button button = (Button) vi.findViewById(R.id.delete);
        RoomieBean roomie = getItem(position);
        if (roomie != null && text!= null) {
            text.setText(roomie.getName());
        }

        //TODO add button stuff
        return vi;
    }
}
