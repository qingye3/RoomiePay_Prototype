package com.qing.roomiepay.dao;


import com.qing.roomiepay.bean.RoomieBean;

import java.util.ArrayList;
/**
 * Created by Qing on 12/23/2014.
 */
public class RoomieDAO {
    private Datastore datastore = null;

    public RoomieDAO() {
        datastore = Datastore.getInstance();
    }

    public void addRoomie(String name){
        RoomieBean e = new RoomieBean(name);
        datastore.roomies.add(e);
    }

    public ArrayList<RoomieBean> getAllRoomies(){
        return datastore.roomies;
    }

    public void removeRoomie(int index){
        datastore.roomies.remove(index);
    }
}
