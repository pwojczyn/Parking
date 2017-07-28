package com.pwojczyn.parking;

import java.util.*;

public class Parking {
    private int parkingID;
    private String parkingName;
    private String parkingCity;
    private String parkingStreet;
    private int numberOfParkingPlace;
    private int costPerPlace;
    private int parkedCar;

    private ArrayList<Cars> carsList;

    public List<Parking> parkingList;
    public int parkingNumber;
    public Scanner scanner;



    public Parking() {
        this.carsList = new ArrayList<>();
        this.parkingList = new ArrayList<Parking>();
        this.scanner = new Scanner(System.in);

    }

    public Parking(int parkingID, String parkingName, String parkingCity, String parkingStreet, int numberOfParkingPlace, int costPerPlace) {
        this.parkingID = parkingID;

        this.parkingName = parkingName;
        this.parkingCity = parkingCity;
        this.parkingStreet = parkingStreet;
        this.numberOfParkingPlace = numberOfParkingPlace;
        this.costPerPlace = costPerPlace;
        this.carsList = new ArrayList<>();
    }

    public Parking(int parkingID, String parkingName, String parkingCity, String parkingStreet, int numberOfParkingPlace) {
        this.parkingID = parkingID;
        this.parkingName = parkingName;
        this.parkingCity = parkingCity;
        this.parkingStreet = parkingStreet;
        this.numberOfParkingPlace = numberOfParkingPlace;
        this.carsList = new ArrayList<>();
    }


    public String getParkingName() {
        return parkingName;
    }

    public void setParkingName(String parkingName) {
        this.parkingName = parkingName;
    }

    public String getParkingCity() {
        return parkingCity;
    }

    public void setParkingCity(String parkingCity) {
        this.parkingCity = parkingCity;
    }

    public String getParkingStreet() {
        return parkingStreet;
    }

    public void setParkingStreet(String parkingStreet) {
        this.parkingStreet = parkingStreet;
    }

    public int getNumberOfParkingPlace() {
        return numberOfParkingPlace;
    }

    public void setNumberOfParkingPlace(int numberOfParkingPlace) {
        this.numberOfParkingPlace = numberOfParkingPlace;
    }


    public int getCostPerPlace() {
        return costPerPlace;
    }

    public void setCostPerPlace(int costPerPlace) {
        this.costPerPlace = costPerPlace;
    }

    public int getParkingID() {
        return parkingID;
    }

    public void setParkingID(int parkingID) {
        this.parkingID = parkingID;
    }

    public int getParkedCar() {
        return parkedCar;
    }

    public void setParkedCar(int parkedCar) {
        this.parkedCar = parkedCar;
    }

    public List<Cars> getCarsList() {
        return carsList;
    }

    public void setCarsList(ArrayList<Cars> carsList) {
        //this.carsList.add(new ArrayList<Cars>(carsList));
    }

    public void addCarToParking(String carName) {
        this.carsList.add(new Cars(carName));
    }

    public void addParkedCar() {
        if (this.parkedCar <= this.numberOfParkingPlace) {
            this.parkedCar++;
        } else
            System.out.println("Parking jest pełen !!!");


    }
    public boolean removeCarFromList( String carName){
        //System.out.println("carName"+carName);
        for (Cars cars : this.carsList) {

            if (cars.getCarName().equals(carName)){
                System.out.println("Usunieto samochód "+cars.getCarName());

                this.carsList.remove(cars);

                return true;
            }else{
                System.out.println("Nie ma "+cars.getCarName()+" takiego samochodu");
            }

        }

        return false;
    }

    public boolean removeCar() {
        System.out.println("Usuwanie samochodu z parkingu:");
        System.out.println("Podaj nazwę samochodu: ");
        String carName = scanner.nextLine();
        System.out.println("Podaj ID parkingu: ");
        int parkingID=Integer.parseInt(scanner.nextLine());
        this.parkingList.get(parkingID-1).removeCarFromList(carName);

        //System.out.println("carName"+carName);
        for (Cars cars : this.carsList) {

            if (cars.getCarName().equals(carName)){
                System.out.println("Usunieto samochód "+cars.getCarName());

                this.carsList.remove(cars);

                return true;
            }else{
                System.out.println("Nie ma "+cars.getCarName()+" takiego samochodu");
            }

        }

        return false;

    }



    @Override
    public String toString() {
        return "Parking{" +
                "parkingID=" + parkingID +
                ", parkingName='" + parkingName + '\'' +
                ", parkingCity='" + parkingCity + '\'' +
                ", parkingStreet='" + parkingStreet + '\'' +
                ", numberOfParkingPlace=" + numberOfParkingPlace +
                ", costPerPlace=" + costPerPlace +
                ", parkedCar=" + parkedCar +
                ", carsList=" + carsList.toString() +
                '}';
    }
    public void addParking(){

        System.out.println("Podaj nazwę parkingu: ");
        String parkingName=scanner.nextLine();
        System.out.println("Podaj miasto parkingu: ");
        String parkingCity = scanner.nextLine();
        System.out.println("Podaj ulicę parkingu: ");
        String parkingStreet=scanner.nextLine();
        System.out.println("Podaj liczbę miejsc parkingowych: ");
        int numberOfParkingPlace=Integer.parseInt(scanner.nextLine());

        this.parkingNumber++;
        this.parkingList.add(new Parking(this.parkingNumber, parkingName,parkingCity,parkingStreet,numberOfParkingPlace));
    }
    public void startData(){
        this.parkingNumber++;
        this.parkingList.add(new Parking(this.parkingNumber,"Pod Dębem","Bydgoszcz","Dębowa 3",2));
            }
    public void exampleParking(){
        // generowanie przykładowego parkingu
        this.parkingNumber++;
        this.parkingList.add(new Parking(this.parkingNumber,"Parkowy","Bydgoszcz","Portowa 12",150));
        this.parkingNumber++;
        this.parkingList.add(new Parking(this.parkingNumber,"Ogrodowy","Bydgoszcz","Długa 22",250));
        this.parkingNumber++;
        this.parkingList.add(new Parking(this.parkingNumber,"Rzeczny","Bydgoszcz","Modrzewiowa 2",50));
        this.parkingNumber++;
        this.parkingList.add(new Parking(this.parkingNumber,"Brązowy","Bydgoszcz","Ogórkowa 30",20));
    }
    public void showParkingList(){
        System.out.println("---------------------  Lista parkingów --------------------");
        System.out.println("Parking ID | Nazwa parkingu | Miasto parkingu | Limit miejsc ");

        for (Parking parking : this.parkingList) {

            //System.out.println(""+parking.getParkingID()+" | "+parking.getParkingName()+" | "+parking.getParkingCity()+" | "+parking.getNumberOfParkingPlace());
            System.out.println(parking.toString());
        }
        System.out.println("-----------------------------------------------------------");
    }
    public void addCar(){
        System.out.println("Parkowanie samochodu na wybranym parkingu.");
        System.out.println("Podaj nazwę samochodu: ");
        String carName = scanner.nextLine();
        System.out.println("Podaj ID parkingu: ");
        int parkingID=Integer.parseInt(scanner.nextLine());

        if (this.parkingList.get(parkingID-1).getParkedCar() < this.parkingList.get(parkingID-1).getNumberOfParkingPlace()){
            this.parkingList.get(parkingID-1).addCarToParking(carName);
            this.parkingList.get(parkingID-1).addParkedCar();
        }else {
            System.out.println("-----------------------");
            System.out.println("Brak miejsc parkingowych, proszę spróbować na innym parkingu !!!");
            System.out.println("-----------------------");
        }

    }
    public void parkingStats(){
        int allParkingPlace = 0;
        int allParkedCars = 0;
        for (Parking parking : this.parkingList) {
            allParkingPlace +=  parking.getNumberOfParkingPlace();
            allParkedCars+= parking.getParkedCar();
        }
        System.out.println("Statytski parkingów:");
        System.out.println("-----------------------");
        System.out.println("Wszystkich miejsc parkingowych: "+allParkingPlace);
        System.out.println("Zaparkowane samochody: "+allParkedCars);
        System.out.println("Wolne miejsca parkingowe: "+(allParkingPlace-allParkedCars) );
        System.out.println("-----------------------");
    }
}
