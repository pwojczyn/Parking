package com.pwojczyn.parking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int choice;
    public static Scanner scanner;

    public static List<Parking> parkingList;
    public static int parkingNumber;

    public static void printMenu() {
        System.out.println("Parking - program do gromadzenia danych o samochodach na parkingu.");
        System.out.println("");
        System.out.println("Wybierz opcję:");
        System.out.println("1 - Dodaj parking.");
        System.out.println("2 - Dodaj samochód do parkingu.");
        System.out.println("3 - Wyświetl listę z parkingami.");

        System.out.println("7 - Wygeneruj losowe dane w programie.");
        System.out.println("8 - Zapisz dane do pliku.");
        System.out.println("9 - Odczytaj dane z pliku.");
        System.out.println("-----------------------");
        System.out.println("0 - Wyjście");

     }

    public static void addParking(){
        //Parking(String parkingName, String parkingCity, String parkingStreet, int numberOfParkingPlace)
        System.out.println("Podaj nazwę parkingu: ");
        String parkingName=scanner.nextLine();
        System.out.println("Podaj miasto parkingu: ");
        String parkingCity = scanner.nextLine();
        System.out.println("Podaj ulicę parkingu: ");
        String parkingStreet=scanner.nextLine();
        System.out.println("Podaj liczbę miejsc parkingowych: ");
        int numberOfParkingPlace=Integer.parseInt(scanner.nextLine());

        parkingNumber++;
        parkingList.add(new Parking(parkingNumber, parkingName,parkingCity,parkingStreet,numberOfParkingPlace));
    }
    public static void exampleParking(){
        // generowanie przykładowego parkingu
        parkingNumber++;
        parkingList.add(new Parking(parkingNumber,"Parkowy","Bydgoszcz","Portowa 12",150));
        parkingNumber++;
        parkingList.add(new Parking(parkingNumber,"Ogrodowy","Bydgoszcz","Długa 22",250));
        parkingNumber++;
        parkingList.add(new Parking(parkingNumber,"Rzeczny","Bydgoszcz","Modrzewiowa 2",50));
        parkingNumber++;
        parkingList.add(new Parking(parkingNumber,"Brązowy","Bydgoszcz","Ogórkowa 30",20));
    }
    public static void showParkingList(){
        System.out.println("---------------------  Lista parkingów --------------------");
        System.out.println("Parking ID | Nazwa parkingu | Miasto parkingu | Limit miejsc ");

        for (Parking parking : parkingList) {

            //System.out.println(""+parking.getParkingID()+" | "+parking.getParkingName()+" | "+parking.getParkingCity()+" | "+parking.getNumberOfParkingPlace());
            System.out.println(parking.toString());
        }
        System.out.println("-----------------------------------------------------------");
    }
    public static void startData(){
        parkingNumber++;
        parkingList.add(new Parking(parkingNumber,"Pod Dębem","Bydgoszcz","Dębowa 3",2));
    }

    public static void addCar(){
        System.out.println("Parkowanie samochodu na wybranym parkingu.");
        System.out.println("Podaj nazwę samochodu: ");
        String carName = scanner.nextLine();
        System.out.println("Podaj ID parkingu: ");
        int parkingID=Integer.parseInt(scanner.nextLine());
        //Parking updateParking = parkingList.get(parkingID);

        //System.out.println(parkingList.get(parkingID-1).toString());
        if (parkingList.get(parkingID-1).getParkedCar() < parkingList.get(parkingID-1).getNumberOfParkingPlace()){
            parkingList.get(parkingID-1).addCarToParking(carName);
            parkingList.get(parkingID-1).addParkedCar();
        }else
            System.out.println("Brak miejsc parkingowych, proszę spróbować na innym parkingu !!!");


        //parkingList.get(2).setCarsList("kk"));

        //System.out.println(parkingList.get(parkingID-1).toString());

        //System.out.println(updateParking.toString());


        //Cars newCar = new Cars(carName);

        //parkingList.get(1).setCarsList(new Cars("Opel"));

        //System.out.println(parkingList.get(1).getCarsList());

    }
    public static void pressMenu() {

        switch (choice) {
            case 1: {
                addParking();
                printMenu();
                break;
            }
            case 2:{
                addCar();
                printMenu();
                break;
            }
            case 3:{
                showParkingList();
                printMenu();
                break;
            }
            case 7:{
                System.out.println("Generowanie przykładowej listy parkingów.");
                exampleParking();
                printMenu();
                break;
            }
            case 8:{
                System.out.println("Tu będzie metoda zapisująca dane do pliku.");
                break;
            }
            case 9:{
                System.out.println("Tu będzie metoda odczytująca dane z pliku.");
                break;
            }

            case 0: {
                System.out.println("-----------------------");
                System.out.println("Zakończenie programu.");
                System.out.println("-----------------------");
                break;
            }
            default: {
                System.out.println("Nie znam tej komendy!");
            }
        }
    }

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        parkingNumber = 0;

        parkingList = new ArrayList<Parking>();

        printMenu();
        startData();
        do {
            choice = Integer.parseInt(scanner.nextLine());

            pressMenu();
        } while (choice != 0);
    }
}
