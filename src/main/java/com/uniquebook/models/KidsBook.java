/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.models;

/**
 *
 * @author edris
 */
public class KidsBook extends Book{

    public enum kidsCategory {
            AGE0_2,  AGE3_5, AGE6_8, AGES9_12,TEENS    };

    public KidsBook() {
    }



    @Override
    public String toString() {
        return "KidsBook{" + "book=" +  super.toString();
    }
    
}
