package com.qing.roomiepay;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.qing.roomiepay.bean.ExpenditureBean;
import com.qing.roomiepay.bean.IOUBean;
import com.qing.roomiepay.bean.RoomieBean;
import com.qing.roomiepay.dao.RoomieDAO;

import java.util.ArrayList;

public class AccountingActivity extends Activity {

    RoomieDAO roomieDAO = null;
    ListView list = null;
    ArrayAdapter<String> adapter = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounting);
        roomieDAO = new RoomieDAO();

        list = (ListView) findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new ArrayList<String>());
        list.setAdapter(adapter);

        updateListView();
    }

    private void updateListView() {
        adapter.clear();
        adapter.addAll(transactionStrings());
    }

    private ArrayList<String> transactionStrings() {
        ArrayList<String> ret = new ArrayList<>();
        double [][] transMatrix = getTransMatrix();
        for (int i = 0; i < getCount() - 1; i++){
            if (transMatrix[i][i+1] > 0){
                ret.add(getNameByIndex(i) + " should pay " + getNameByIndex(i+1) + " $" + String.valueOf(transMatrix[i][i+1]));
            }
            else{
                ret.add(getNameByIndex(i+1) + " should pay " + getNameByIndex(i) + " $" + String.valueOf(-transMatrix[i][i+1]));
            }
        }
        return ret;
    }

    private int getCount() {
        return roomieDAO.getAllRoomies().size();
    }

    private String getNameByIndex(int i) {
        return getRoomieByIndex(i).getName();
    }

    private RoomieBean getRoomieByIndex(int i) {
        return roomieDAO.getAllRoomies().get(i);
    }

    private double[][] getTransMatrix() {
        double [][] transMatrix = new double[getCount()][getCount()];
        for (int i = 0; i < getCount(); i++){
            for (int j = i+1; j < getCount(); j++){
                transMatrix[i][j] += getIOUSums(getRoomieByIndex(i), getRoomieByIndex(j));
                transMatrix[i][j] += (getExpenditure(getRoomieByIndex(j)) - getExpenditure(getRoomieByIndex(i)))/getCount();
            }
        }
        for (int i = 0; i < getCount(); i++){
            for (int j = i+2; j < getCount(); j++){
                double adjustAmount = transMatrix[i][j];
                transMatrix[i][j] = 0;
                for (int k = i; k < j; k++)
                    transMatrix[k][k+1] += adjustAmount;
            }
        }
        return transMatrix;
    }

    private double getIOUSums(RoomieBean borrower, RoomieBean lender) {
        double ret = 0;
        for (IOUBean iou : lender.getIOUs()){
            if (iou.getBorrower() == borrower.getName()){
                ret+= iou.getAmount();
            }
        }
        return ret;
    }

    private double getExpenditure(RoomieBean roomie) {
        double result = 0;
        for (ExpenditureBean expenditure:roomie.getExpenditures()){
            result += expenditure.getAmount();
        }
        return result;
    }

}
