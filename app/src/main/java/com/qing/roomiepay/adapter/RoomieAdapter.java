package com.qing.roomiepay.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.qing.roomiepay.R;
import com.qing.roomiepay.bean.RoomieBean;
import com.qing.roomiepay.dao.RoomieDAO;

import java.util.ArrayList;

/**
 * Created by Qing on 12/23/2014.
 */
public class RoomieAdapter extends ArrayAdapter<RoomieBean>{
    RoomieDAO roomieDAO;

    public RoomieAdapter(Context context, ArrayList<RoomieBean> roomies) {
        super(context,0, roomies);
        roomieDAO = new RoomieDAO();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        View vi = convertView;
        if (convertView == null) {
            vi = LayoutInflater.from(getContext()).inflate(R.layout.roomie_row, parent, false);
        }
        final TextView text = (TextView) vi.findViewById(R.id.roomie_name);
        final Button button = (Button) vi.findViewById(R.id.delete);
        RoomieBean roomie = getItem(position);
        if (roomie != null && text!= null) {
            text.setText(roomie.getName());
        }
        button.setTag(position);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = (int) v.getTag();
                Log.i("roomieDAO", String.valueOf(roomieDAO != null));
                roomieDAO.removeRoomie(position);
                clear();
                addAll(roomieDAO.getAllRoomies());
            }
        });
        return vi;
    }
}
