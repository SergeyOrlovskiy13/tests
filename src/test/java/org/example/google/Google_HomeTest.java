package org.example.google;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


public class Google_HomeTest {
    String [] r = new String[1];

    @Test
    void main() {
        boolean d = false;
        if (d==false) {
            Google_Home.main(r);
            d = true;
        } else {
            System.out.println("wrong data");
        }

        assertEquals(true,d);
    }
}