/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FarmCon.com.utilities;

/**
 *
 * @author Pratip
 */
public class DBParamProvider 
{
    private String driver;
    private String db_URL;
    private String db_name;
    private String db_username;
    private String db_password;

    /**
     * @return the driver
     */
    public String getDriver() {
        return driver;
    }

    /**
     * @param driver the driver to set
     */
    public void setDriver(String driver) {
        this.driver = driver;
    }

    /**
     * @return the db_URL
     */
    public String getDb_URL() {
        return db_URL;
    }

    /**
     * @param db_URL the db_URL to set
     */
    public void setDb_URL(String db_URL) {
        this.db_URL = db_URL;
    }

    /**
     * @return the db_name
     */
    public String getDb_name() {
        return db_name;
    }

    /**
     * @param db_name the db_name to set
     */
    public void setDb_name(String db_name) {
        this.db_name = db_name;
    }

    /**
     * @return the db_username
     */
    public String getDb_username() {
        return db_username;
    }

    /**
     * @param db_username the db_username to set
     */
    public void setDb_username(String db_username) {
        this.db_username = db_username;
    }

    /**
     * @return the db_password
     */
    public String getDb_password() {
        return db_password;
    }

    /**
     * @param db_password the db_password to set
     */
    public void setDb_password(String db_password) {
        this.db_password = db_password;
    }
    
}
