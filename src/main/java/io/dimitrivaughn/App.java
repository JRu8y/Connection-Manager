package io.dimitrivaughn;
import java.io.*;
import java.util.*;

/**
 * Created by dimitrivaughn on 5/19/16.
 */
public class App {

    public static void main(String[] args) {

        ConnectionManager manager = new ConnectionManager();

        Connection connection1 = manager.newConnection("12.56.100.12", "FTP");
        Connection connection2 = manager.newConnection("14.100.75.60", "HTTP");
        Connection connection3 = manager.newCustomConnection("11.11.125.48", "TCP");

        connection1.close();
        connection2.connect();
        connection3.close();

        connection1.getIP();

    }


}
