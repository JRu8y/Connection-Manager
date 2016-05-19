package io.dimitrivaughn;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by dimitrivaughn on 5/19/16.
 */
public class ConnectionManagerSpec {

    int expectedValue;
    int actualValue;
    boolean expectedState;
    boolean actualState;

    ConnectionManager manager;


    @Before

    public void Sandbox() {
        manager = new ConnectionManager();
    }


    @Test
    public void newConnectionTest() {
        manager.newConnection("0", "1");
        expectedValue = 1;
        actualValue = manager.getOpenConnections();
        assertEquals("The array size should increase by 1: Expected value = 1 ", expectedValue, actualValue);
    }

    @Test
    public void newCustomTest() {
        manager.newCustomConnection("0", "2");
        expectedValue = 1;
        actualValue = manager.getOpenConnections();
        assertEquals("The array size should increase by 1: Expected value = 1 ", expectedValue, actualValue);
    }


    @Test
    public void isTooManyConnectionsTest() {
        manager.newConnection("0", "1");
        manager.newConnection("00", "1");
        manager.newConnection("000", "1");
        manager.newConnection("0000", "1");
        expectedState = true;
        actualState = manager.isTooManyConnections();
        assertEquals("The array size should increase by 1: Expected value = 1 ", expectedState, actualState);
    }



    }
