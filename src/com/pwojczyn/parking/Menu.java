package com.pwojczyn.parking;

import java.util.Scanner;

public class Menu {
    public Scanner scanner;
    public Menu(){
        printMenu();
        this.scanner = new Scanner(System.in);
    }
    public void printMenu() {
        System.out.println("Parking - program do gromadzenia danych o samochodach na parkingu.");
        System.out.println("");
        System.out.println("Wybierz opcję:");
        System.out.println("1) - Dodaj parking.");
        System.out.println("2) - Dodaj samochód do parkingu.");
        System.out.println("3) - Wyświetl listę z parkingami.");
        System.out.println("4) - Usuniecie samochodu z parkingu.");

        System.out.println("7) - Wygeneruj losowe dane w programie.");
        System.out.println("8) - Statystki parkingów.");
        System.out.println("-----------------------");
        System.out.println("0) - Wyjście");

    }
    public void pressMenu(Parking parking) {
        int choice;
        do {
            choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1: {
                parking.addParking();
                printMenu();
                break;
            }
            case 2:{
                parking.addCar();
                printMenu();
                break;
            }
            case 3:{
                parking.showParkingList();
                printMenu();
                break;
            }
            case 4:{
                parking.removeCar();
                printMenu();
                break;
            }
            case 7:{
                System.out.println("Generowanie przykładowej listy parkingów.");
                parking.exampleParking();
                printMenu();
                break;
            }
            case 8:{
                parking.parkingStats();
                printMenu();
                break;
            }

            case 0: {
                System.out.println("-----------------------");
                System.out.println("Zakończenie programu.");
                System.out.println("-----------------------");
                break;
            }
            default: {
                System.out.println("-----------------------");
                System.out.println("Nie znam tej komendy!");
                System.out.println("-----------------------");
            }
        }





        } while (choice != 0);
    }

  }
