package com.qing.roomiepay;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.qing.roomiepay.adapter.RoomieBookAdapter;
import com.qing.roomiepay.bean.AmountBean;
import com.qing.roomiepay.bean.ExpenditureBean;
import com.qing.roomiepay.bean.RoomieBean;
import com.qing.roomiepay.dao.RoomieDAO;

/**
 * Created by Qing on 12/23/2014.
 */
public class EditRoomieActivity extends FragmentActivity
                                  implements AddExpenditureDialogFragment.AddExpenditureDialogListener,
                                               RoomieBookAdapter.RoomieBookAdapterListener{
    RoomieBean roomie;
    RoomieBookAdapter adapter;
    ListView list = null;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Bundle b = getIntent().getExtras();
        RoomieDAO roomieDAO = new RoomieDAO();
        roomie = roomieDAO.getRoomieByIndex(b.getInt("roomieIndex"));
        setContentView(R.layout.activity_edit_roomie);

        TextView text = (TextView) findViewById(R.id.textView);
        text.setText(roomie.getName());

        list = (ListView) findViewById(R.id.listView);
        adapter = new RoomieBookAdapter(this, roomie);
        adapter.setListener(this);
        list.setAdapter(adapter);
        updateListView();
    }

    private void updateListView() {
        adapter.clear();
        adapter.addAll(roomie.getExpenditures());
        adapter.addAll(roomie.getIOUs());
    }

    public void addExpenditureCB(View view){
        AddExpenditureDialogFragment newFragment = new AddExpenditureDialogFragment();
        newFragment.show(getSupportFragmentManager(), "add_expenditure");
    }

    public void addIOUCB(View view){

    }

    @Override
    public void onExpenditureDialogPositiveClick(AddExpenditureDialogFragment dialog) {
        ExpenditureBean expenditure = dialog.getExpenditure();
        if (expenditure != null) {
            roomie.addExpenditure(dialog.getExpenditure());
        }
        updateListView();
    }

    @Override
    public void onExpenditureDialogNegativeClick(AddExpenditureDialogFragment dialog) {
    }

    @Override
    public void onRemovingAmount(AmountBean amount) {
        roomie.getExpenditures().remove(amount);
    }
}
