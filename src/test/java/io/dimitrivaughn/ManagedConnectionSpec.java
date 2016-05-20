package io.dimitrivaughn;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by dimitrivaughn on 5/19/16.
 */
public class ManagedConnectionSpec {

    Connection connection;
    String expectedString;
    String actualString;

    ConnectionManager manager;


    @Before

    public void Sandbox() {
        manager = new ConnectionManager();
        connection = manager.newConnection("12.56.100.12", "FTP");

    }


    @Test
    public void getIPFailTest() {
        connection.close();
        expectedString = "Connection closed";
        actualString = connection.getIP();
        assertEquals("Should return an error message: Expected value = Connection closed", expectedString, actualString);
    }

    @Test
    public void getProtocolFailTest() {
        connection.close();
        expectedString = "Connection closed";
        actualString = connection.getProtocol();
        assertEquals("Should return an error message: Expected value = Connection closed", expectedString, actualString);
    }

    @Test
    public void getPortFailTest() {
        connection.close();
        expectedString = "Connection closed";
        actualString = connection.getPort();
        assertEquals("Should return an error message: Expected value = Connection closed", expectedString, actualString);
    }

    @Test
    public void connectTest() {
        connection.close();
        expectedString = "Connection open";
        actualString = connection.connect();
        assertEquals("Should open a connection: Expected value = Connection open", expectedString, actualString);
    }

    @Test
    public void connectFailTest() {
        manager.newConnection("12.56.100.10", "FTP");
        manager.newConnection("12.56.100.11", "HTTP");
        manager.newConnection("12.56.100.12", "FTP");
        manager.newConnection("12.56.100.14", "FTP");
        expectedString = "No connections available";
        actualString = connection.connect();
        assertEquals("Should return an error message: Expected value = No connections available", expectedString, actualString);
    }


}
