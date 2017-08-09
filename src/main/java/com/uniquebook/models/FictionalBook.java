/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.models;

import java.util.Date;

/**
 *
 * @author edris
 */
public class FictionalBook extends Book {

    public enum fictionalCategory {
        COMICS, FICTION, GRPAHICS_NOVEL, LIERATURE, POETRY, ROMANCE, SCIENCE_FICTION,
        THRILLERS, WESTERNS
    };

    public FictionalBook() {
    }

    @Override
    public String toString() {
        return "FictionalBook{" + "book="+super.toString();
    }
}
