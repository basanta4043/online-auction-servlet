package com.onlineauction.onlineauctionservlet.model.beans;

import java.util.HashMap;
import java.util.Map;

public class Bid {

    public enum status {
        OPEN(0), LOST(1), WON(2);

        private final int statusCode;
        private static Map<Object, Object> map = new HashMap<>();

        status(int statusCode) {
            this.statusCode = statusCode;
        }

        static {
            for (status userstatus : status.values()) {
                map.put(userstatus.statusCode, userstatus);
            }
        }

        public static status valueOf(int userstatus) {
            return (status) map.get(userstatus);
        }

        public int getValue() {
            return statusCode;
        }

    }

    private int bidID;
    private int bidderID;
    private int bidProductID;
    private double bidValue;
    private status bidStatus;

    public Bid(int bidID, int bidderID, int bidProductID, double bidValue, status bidStatus) {
        super();
        this.bidID = bidID;
        this.bidderID = bidderID;
        this.bidProductID = bidProductID;
        this.bidValue = bidValue;
        this.bidStatus = bidStatus;
    }

    public Bid() {
    }


    public int getBidID() {
        return bidID;
    }


    public void setBidID(int bidID) {
        this.bidID = bidID;
    }


    public int getBidderID() {
        return bidderID;
    }


    public void setBidderID(int bidderID) {
        this.bidderID = bidderID;
    }


    public int getBidProductID() {
        return bidProductID;
    }


    public void setBidProductID(int bidProductID) {
        this.bidProductID = bidProductID;
    }


    public double getBidValue() {
        return bidValue;
    }


    public void setBidValue(double bidValue) {
        this.bidValue = bidValue;
    }

    public int getBidStatus() {
        return bidStatus.statusCode;
    }

    public void setBidStatus(int bidstatus) {
        this.bidStatus = status.valueOf(bidstatus);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + bidID;
        result = prime * result + bidProductID;
        result = prime * result + ((bidStatus == null) ? 0 : bidStatus.hashCode());
        long temp;
        temp = Double.doubleToLongBits(bidValue);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + bidderID;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Bid other = (Bid) obj;
        if (bidID != other.bidID)
            return false;
        if (bidProductID != other.bidProductID)
            return false;
        if (bidStatus != other.bidStatus)
            return false;
        if (Double.doubleToLongBits(bidValue) != Double.doubleToLongBits(other.bidValue))
            return false;
        if (bidderID != other.bidderID)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Bid [bidID=" + bidID + ", bidderID=" + bidderID + ", bidProductID=" + bidProductID + ", bidValue="
                + bidValue + ", bidStatus=" + bidStatus + "]";
    }


}