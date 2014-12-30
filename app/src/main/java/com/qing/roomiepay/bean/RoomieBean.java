package com.qing.roomiepay.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Qing on 12/23/2014.
 */
public class RoomieBean{
    private String name;
    List<IOUBean> IOUs = null;
    List<ExpenditureBean> expenditures = null;

    public RoomieBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IOUBean> getIOUs() {
        if (IOUs == null){
            IOUs = new ArrayList<IOUBean>();
        }
        return IOUs;
    }

    public void addIOU(IOUBean IOU){
        if (IOUs == null){
            IOUs = new ArrayList<IOUBean>();
        }
        this.IOUs.add(IOU);

    }

    public void removeIOUbyIndex(int index){
        IOUs.remove(index);
    }

    public List<ExpenditureBean> getExpenditures(){
        if (expenditures == null){
            expenditures = new ArrayList<>();
        }
        return expenditures;
    }

    public void addExpenditure(ExpenditureBean expenditure){
        if (expenditures == null){
            expenditures = new ArrayList<ExpenditureBean>();
        }
        this.expenditures.add(expenditure);
    }

    public void removeExpenditureByID(int index){
        expenditures.remove(index);
    }

}
