package com.zyw.calltaxi.model;

/**
 * Created by zyw on 2015/11/10.
 */
public class Passenger extends User {
    /**
     * 乘客是否正在等待接单
     */
    protected boolean mIsWaitingOrder = false;

    protected Destination mDestination;

    public Passenger(String name, String phoneNumber) {
        super(name, phoneNumber);
    }

    public boolean isWaitingOrder() {
        return mIsWaitingOrder;
    }

    public void setIsWaitingOrder(boolean isWaitingOrder) {
        mIsWaitingOrder = isWaitingOrder;
    }

    public Destination getDestination() {
        return mDestination;
    }

    public void setDestination(Destination destination) {
        mDestination = destination;
    }
}
