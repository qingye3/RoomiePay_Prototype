package com.qing.roomiepay.dao;

import com.qing.roomiepay.bean.RoomieBean;

import java.util.ArrayList;

/**
 * Created by Qing on 12/23/2014.
 * Datastore is a Singleton
 */
public class Datastore {
    private static Datastore instance = null;
    public ArrayList<RoomieBean> roomies;

    private Datastore(){
        roomies = new ArrayList<>();
    }

    public static Datastore getInstance(){
        if (instance == null) {
            instance = new Datastore();
        }
        return instance;
    }
}
