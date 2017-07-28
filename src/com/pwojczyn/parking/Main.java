package com.pwojczyn.parking;


public class Main {


    public static void main(String[] args) {
        Menu menu = new Menu();
        Parking parking = new Parking();

        parking.startData();
        menu.pressMenu(parking);
    }
}
