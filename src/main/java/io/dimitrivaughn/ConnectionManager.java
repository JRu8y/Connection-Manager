package io.dimitrivaughn;
import java.util.*;
import java.io.*;



/**
 * Created by dimitrivaughn on 5/19/16.
 */
public class ConnectionManager {


// Declaration of fields

    private int maxNumberConnections;
    private int openConnections;
    private Connection connection;
    private String addressIP;
    private String commProtocol;
    private String portID;
    private boolean connectionStatus;



// Initialization of fields within the constructor

    public ConnectionManager(){
        maxNumberConnections = 3;
        openConnections = 0;
    }


// series of getters and setters


    public int getOpenConnections() {
        return openConnections;
    }

    public void setOpenConnections(int number) {
        openConnections = number;
    }


// instantiates a ManagedConnection and adds it to an ArrayList

    public ManagedConnection newConnection(String IP, String protocol){
        openConnections++;
        return new ManagedConnection(IP, protocol, "80");
    }

// instantiates a custom ManagedConnection

    public ManagedConnection newCustomConnection(String IP, String port){
        openConnections++;
        return new ManagedConnection(IP, "HTTP", port);
    }


// checks whether current number of connections exceeds the maximum numbers

    public boolean isTooManyConnections(){
        if(openConnections>maxNumberConnections){
            return true;
        }
            return false;
    }


// Declaration of private inner class Managed Connection

    private class ManagedConnection implements Connection{


// Initializing object fields with constructor for the ManagedConnection nested class

        public ManagedConnection(String ip, String protocol, String port){
            addressIP = ip;
            commProtocol = protocol;
            portID = port;
            connectionStatus = true;
        }




// Declaring a series of getters and setters for private fields declared in the outer class

        public String getIP(){
            if(!getConnectionStatus()){
                return "Connection closed";
            }
            return addressIP;
        }
        public String getProtocol(){
            if(!getConnectionStatus()){
                return "Connection closed";
            }
            return commProtocol;
        }
        public String getPort(){
            if(!getConnectionStatus()){
                return "Connection closed";
            }
            return portID;
        }



        public int getMaxNumberConnections() {
            return maxNumberConnections;
        }

        public void setAddressIP(String ip) {
           addressIP = ip;
        }

        public void setCommProtocol(String protocol) {
            commProtocol = protocol;
        }

        public void setPortID(String port) {
            portID = port;
        }

        public boolean getConnectionStatus() {
            return connectionStatus;
        }

        public void setConnectionStatus(boolean bool) {
            connectionStatus = bool;
        }

        public Connection getConnection() {
            return connection;
        }

        public void setConnection(Connection connect) {
            connection = connect;
        }



// Initiates connection by setting connection status to open

        public String connect(){
            if(openConnections < maxNumberConnections){
                setConnectionStatus(true);
                return "Connection open";
            }
            return "No connections available";
        }

// Closes connection by setting connection status to closed

        public String close(){
            setConnectionStatus(false);
            return "Connection closed";

        }

    }

}
