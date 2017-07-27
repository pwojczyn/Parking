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

    public Parking() {
        this.carsList = new ArrayList<>();

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

    public boolean removeCar(String carName) {
        //System.out.println("carName"+carName);
        for (Cars cars : carsList) {

            if (cars.getCarName().equals(carName)){
                System.out.println("Usunieto samochód "+cars.getCarName());

                carsList.remove(cars);

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
}
