package com.win;

import java.io.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestHarness {

    public static void main(String[] args){
        Pattern splitPattern = Pattern.compile(" *, *");
        String[] items = splitPattern.split("John Wu,  Annie , John Smith");
        for (String item : items) {
        	System.out.println(item);
        }
    }
}

