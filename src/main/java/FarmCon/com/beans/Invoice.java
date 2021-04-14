/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FarmCon.com.beans;

/**
 *
 * @author Pratip
 */
public class Invoice 
{
    private int invoiceID;
    private int auctionID;
    private int productID;
    private String productName;
    private String productDescription;
    private int customerID;
    private String customerName;
    private double totalAmount;
    private String customerAddress;
    private String customerEmail;
    private long customerPhone;
    private int farmerID;
    private String farmerName;
    private String farmerAddress;
    private String farmerEmail;
    private long farmerPhone;
    private int requiredQuantity;

    /**
     * @return the invoiceID
     */
    public int getInvoiceID() {
        return invoiceID;
    }

    /**
     * @param invoiceID the invoiceID to set
     */
    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
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
     * @return the productID
     */
    public int getProductID() {
        return productID;
    }

    /**
     * @param productID the productID to set
     */
    public void setProductID(int productID) {
        this.productID = productID;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the productDescription
     */
    public String getProductDescription() {
        return productDescription;
    }

    /**
     * @param productDescription the productDescription to set
     */
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
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
     * @return the customerAddress
     */
    public String getCustomerAddress() {
        return customerAddress;
    }

    /**
     * @param customerAddress the customerAddress to set
     */
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    /**
     * @return the customerEmail
     */
    public String getCustomerEmail() {
        return customerEmail;
    }

    /**
     * @param customerEmail the customerEmail to set
     */
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    /**
     * @return the customerPhone
     */
    public long getCustomerPhone() {
        return customerPhone;
    }

    /**
     * @param customerPhone the customerPhone to set
     */
    public void setCustomerPhone(long customerPhone) {
        this.customerPhone = customerPhone;
    }

    /**
     * @return the farmerID
     */
    public int getFarmerID() {
        return farmerID;
    }

    /**
     * @param farmerID the farmerID to set
     */
    public void setFarmerID(int farmerID) {
        this.farmerID = farmerID;
    }

    /**
     * @return the farmerName
     */
    public String getFarmerName() {
        return farmerName;
    }

    /**
     * @param farmerName the farmerName to set
     */
    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    /**
     * @return the farmerAddress
     */
    public String getFarmerAddress() {
        return farmerAddress;
    }

    /**
     * @param farmerAddress the farmerAddress to set
     */
    public void setFarmerAddress(String farmerAddress) {
        this.farmerAddress = farmerAddress;
    }

    /**
     * @return the farmerEmail
     */
    public String getFarmerEmail() {
        return farmerEmail;
    }

    /**
     * @param farmerEmail the farmerEmail to set
     */
    public void setFarmerEmail(String farmerEmail) {
        this.farmerEmail = farmerEmail;
    }

    /**
     * @return the farmerPhone
     */
    public long getFarmerPhone() {
        return farmerPhone;
    }

    /**
     * @param farmerPhone the farmerPhone to set
     */
    public void setFarmerPhone(long farmerPhone) {
        this.farmerPhone = farmerPhone;
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
}   
            