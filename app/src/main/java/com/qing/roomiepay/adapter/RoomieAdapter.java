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
import com.qing.roomiepay.bean.RoomieBean;
import com.qing.roomiepay.dao.RoomieDAO;

import java.util.ArrayList;

/**
 * Created by Qing on 12/23/2014.
 */
public class RoomieAdapter extends ArrayAdapter<RoomieBean>{
    RoomieDAO roomieDAO;
    Context context;

    public RoomieAdapter(Context context, ArrayList<RoomieBean> roomies) {
        super(context,0, roomies);
        this.context = context;
        roomieDAO = new RoomieDAO();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        View vi = convertView;
        if (convertView == null) {
            vi = LayoutInflater.from(getContext()).inflate(R.layout.row_with_delete, parent, false);
        }
        final TextView text = (TextView) vi.findViewById(R.id.textView);
        final Button button = (Button) vi.findViewById(R.id.delete);
        RoomieBean roomie = getItem(position);
        if (roomie != null && text!= null) {
            text.setText(roomie.getName());
            text.setTag(position);
            text.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Intent intent = new Intent(context, EditRoomieActivity.class);
                    Bundle b = new Bundle();
                    b.putInt("roomieIndex", (int) v.getTag());
                    intent.putExtras(b);
                    context.startActivity(intent);
                }
            });
        }
        button.setTag(position);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = (int) v.getTag();
                roomieDAO.removeRoomie(position);
                clear();
                addAll(roomieDAO.getAllRoomies());
            }
        });
        return vi;
    }
}
