package com.qing.roomiepay.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Qing on 12/23/2014.
 * Bean to store data. Only getters are allowed
 */
public class RoomieBean{
    private String name;
    private List<IOUBean> IOUs = null;
    private List<ExpenditureBean> expenditures = null;

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
            IOUs = new ArrayList<>();
        }
        return IOUs;
    }

    public void addIOU(IOUBean IOU){
        if (IOUs == null){
            IOUs = new ArrayList<>();
        }
        this.IOUs.add(IOU);

    }

    public List<ExpenditureBean> getExpenditures(){
        if (expenditures == null){
            expenditures = new ArrayList<>();
        }
        return expenditures;
    }

    public void addExpenditure(ExpenditureBean expenditure){
        if (expenditures == null){
            expenditures = new ArrayList<>();
        }
        this.expenditures.add(expenditure);
    }
}
