/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FarmCon.com.beans;

import java.io.Serializable;



/**
 *
 * @author Pratip
 */
public class Bid implements Serializable
{
    private int bidID;
    private int customerID;
    private int auctionID;
    private double totalAmount;
    private int requiredQuantity;
    private String customerName;
    
    /**
     * @return the bidID
     */
    public int getBidID() {
        return bidID;
    }

    /**
     * @param bidID the bidID to set
     */
    public void setBidID(int bidID) {
        this.bidID = bidID;
    }

    /**
     * @return the customerID
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * @param customerID the customerID to set
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    /**
     * @return the auctionID
     */
    public int getAuctionID() {
        return auctionID;
    }

    /**
     * @param auctionID the auctionID to set
     */
    public void setAuctionID(int auctionID) {
        this.auctionID = auctionID;
    }

    /**
     * @return the totalAmount
     */
    public double getTotalAmount() {
        return totalAmount;
    }

    /**
     * @param totalAmount the totalAmount to set
     */
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * @return the requiredQuantity
     */
    public int getRequiredQuantity() {
        return requiredQuantity;
    }

    /**
     * @param requiredQuantity the requiredQuantity to set
     */
    public void setRequiredQuantity(int requiredQuantity) {
        this.requiredQuantity = requiredQuantity;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
}
