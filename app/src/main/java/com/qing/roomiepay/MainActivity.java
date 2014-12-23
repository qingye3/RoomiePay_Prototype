package com.qing.roomiepay;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startAccountingCB(View view){
    }

    public void addRoomieCB(View view){
        AddRoomieDialogFragment newFragment = new AddRoomieDialogFragment();
        newFragment.show(getSupportFragmentManager(), "add_roomie");
    }
}
