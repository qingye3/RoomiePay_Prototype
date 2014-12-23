package com.qing.roomiepay.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Qing on 12/23/2014.
 */
public class RoomieBean {
    private String name;
    List<IOUBean> IOUs = null;

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

    public void setIOUs(List<IOUBean> IOUs) {
        this.IOUs = IOUs;
    }

    public void addIOU(IOUBean IOU){
        if (IOUs == null){
            IOUs = new ArrayList<IOUBean>();
        }
        this.IOUs.add(IOU);
    }

}
