package com.qing.roomiepay.dao;


import com.qing.roomiepay.bean.RoomieBean;

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
        datastore.addRoomie(e);
    }
}
