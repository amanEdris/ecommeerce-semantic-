/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.internal.objects.NativeMath.random;

/**
 *Utility class to generate names for created objects
 */
public class HelperUtil{
    
    private char getRandomCharacter() {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        return alphabet[random(alphabet.length)];

    }

    public String generateNames() {
        StringBuilder sb = new StringBuilder();
        int size = random(25) + random(25);
        for (int i = 0; i < (size == 0 ? 1 : size); i++) {
            sb.append(getRandomCharacter());
        }

        return sb.toString();
    }

    private int random(int length) {
        return new Random().nextInt(length);
    }

}
