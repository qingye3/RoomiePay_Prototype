package com.qing.roomiepay.dao;

import com.qing.roomiepay.bean.RoomieBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Qing on 12/23/2014.
 * Datastore is a Singleton
 */
public class Datastore {
    private static Datastore instance = null;
    private ArrayList<RoomieBean> roomies;

    private Datastore(){
        roomies = new ArrayList<RoomieBean>();
    }

    public static Datastore getInstance(){
        if (instance == null) {
            instance = new Datastore();
        }
        return instance;
    }

    public ArrayList<RoomieBean> getRoomies() {
        return roomies;
    }

    public void setRoomies(ArrayList<RoomieBean> roomies) {
        this.roomies = roomies;
    }

    public void addRoomie(RoomieBean roomie) {
        roomies.add(roomie);
    }

    public int getCount(){
        return roomies.size();
    }
}
