package com.qing.roomiepay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ListView;

import com.qing.roomiepay.adapter.RoomieAdapter;
import com.qing.roomiepay.bean.RoomieBean;
import com.qing.roomiepay.dao.RoomieDAO;
import com.qing.roomiepay.fragment.AddRoomieDialogFragment;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity
                            implements AddRoomieDialogFragment.AddRoomieDialogListener{

    private ListView list = null;
    private RoomieDAO roomieDAO = null;
    private RoomieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        roomieDAO = new RoomieDAO();
        list = (ListView) findViewById(R.id.roomieListView);
        adapter = new RoomieAdapter(this, new ArrayList<RoomieBean>());
        list.setAdapter(adapter);
        updateListView();
    }

    private void updateListView() {
        adapter.clear();
        adapter.addAll(roomieDAO.getAllRoomies());
    }

    @Override
    protected void onResume(){
        super.onResume();
        updateListView();
    }

    public void startAccountingCB(View view){
        Intent intent = new Intent(this, AccountingActivity.class);
        this.startActivity(intent);
    }

    public void addRoomieCB(View view){
        AddRoomieDialogFragment newFragment = new AddRoomieDialogFragment();
        newFragment.show(getSupportFragmentManager(), "add_roomie");
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        updateListView();
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {

    }
}
