package com.qing.roomiepay;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ListView;

import com.qing.roomiepay.adapter.RoomieAdapter;
import com.qing.roomiepay.bean.RoomieBean;
import com.qing.roomiepay.dao.RoomieDAO;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity
                            implements AddRoomieDialogFragment.AddRoomieDialogListener{

    ListView list = null;
    RoomieDAO roomieDAO = null;
    RoomieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        roomieDAO = new RoomieDAO();
        list = (ListView) findViewById(R.id.roomieListView);
        adapter = new RoomieAdapter(this, R.layout.roomie_row, new ArrayList<RoomieBean>());
        list.setAdapter(adapter);
    }

    public void startAccountingCB(View view){
    }

    public void addRoomieCB(View view){
        AddRoomieDialogFragment newFragment = new AddRoomieDialogFragment();
        newFragment.show(getSupportFragmentManager(), "add_roomie");
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        adapter.clear();
        adapter.addAll(roomieDAO.getAllRoomies());
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {

    }


}
