package io.dimitrivaughn;
import java.io.*;
import java.util.*;

/**
 * Created by dimitrivaughn on 5/19/16.
 */
public interface Connection {

// Declaring abstract methods for the interface

    String getIP();
    String getProtocol();
    String getPort();
    String connect();
    String close();


}
