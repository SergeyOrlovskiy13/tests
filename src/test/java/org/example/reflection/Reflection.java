package org.example.reflection;

import org.checkerframework.checker.units.qual.A;
import org.example.booking.Booking_HomeTest1;
import org.example.google.Google_HomeTest;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reflection {

    public static void main(String[] args) {

       List <String> methods= new ArrayList<>();
        Google_HomeTest google_homeTest = new Google_HomeTest();
        Class cl = google_homeTest.getClass();
        Booking_HomeTest1 booking_homeTest1 = new Booking_HomeTest1();
        Class cl1 = booking_homeTest1.getClass();

        for (Method m : cl.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
               methods.add(m.getName());
            }
        }

        for (Method m : cl1.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                methods.add(m.getName());
            }
        }

        try (FileWriter writer = new FileWriter("text.txt");) {
            for (String el : methods)
            writer.write(el +","+"\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}