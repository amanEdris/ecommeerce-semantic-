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
public class NonFictionalBook extends Book {

    private String category;

    public NonFictionalBook() {
    }

    public enum NonFictionalCategory {
        HISTORY("History"), HOME__GARDEN("Home Garden"), ACTIVITY__GAME_BOOKS("Activity Game Books"),
        ANTIQUES__COLLECTIBLES("Antiques collectibles"), ARCHITECTURE("Architecture"), ART("Art"),
        BIBLE__CHRISTIANITY("Bible Christanity"), BIOGRAPHY("Biography"), BUSINESS_BOOKS("Business Books"),
        COMPUTERS("Computers"), COOKBOOKS("Cook Books"), FOOD__WINECRAFTS__HOBBIES("Food & Winecrafts Hobbies"),
        CURRENT_AFFAIRS__POLITICS("Current Affairs Poltics"), DIET("Diet"), HEALTH__FITNESS("Health Fitness"),
        EDUCATION("Education"), ENGINEERING("Engineering"), FORIEGN_LANGUAGES("Forign Language"), HOME("Home"),
        LAW("Law"), MEDICINE__NURSING("Medicne Nursing"), PHILOSOPHY("Philosposy"), PHOTOGRAPHY("Photography"),
        PYSCOLOGY("Pyscology"), RELIGION("Comics"), SCIENCE__TECHNOLOGY("Scince Technology"),
        SELF_HELP__REALATIONSHIP("Self Help & Relationship"), SOCIAL_SCIENCE("Social Science"), SPORTS("Sports"),
        STUDY_AID__TEST("Study aid test"), PREPARATION("Preparation"), TRAVEL("Travel"), WEDDINGS("Weddings");

        private String name;

        private NonFictionalCategory(String stringVal) {
            name = stringVal;
        }

        public String toString() {
            return name;
        }

        public static String getEnumByString(String code) {

            for (NonFictionalCategory e : NonFictionalCategory.values()) {
                if (code.equals(e.name)) {
                    return e.name();
                }
            }
            return null;
        }
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "NonFictionalBook{" + "category=" + category + '}' + super.toString();
    }

}
