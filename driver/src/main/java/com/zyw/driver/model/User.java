package com.zyw.driver.model;

import com.baidu.mapapi.model.LatLng;

import org.apache.mina.core.session.IoSession;

/**
 * Created by zyw on 2015/11/10.
 */
public class User {
    protected String mName;
    protected String mPhoneNumber;
    protected double[] mLocation = new double[2];
    protected IoSession mSession;
    protected int mDistance;
    public User(String name,String phoneNumber){
        mName = name;
        mPhoneNumber = phoneNumber;
    }

    public int getDistance() {
        return mDistance;
    }

    public void setDistance(int distance) {
        mDistance = distance;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        mPhoneNumber = phoneNumber;
    }

    public double[] getLocation() {
        return mLocation;
    }

    public void setLocation(double[] location) {
        mLocation = location;
    }

    public IoSession getSession() {
        return mSession;
    }

    public void setSession(IoSession session) {
        mSession = session;
    }

    public LatLng getLatLng() {
        return new LatLng(getLocation()[0],getLocation()[1]);
    }
}
