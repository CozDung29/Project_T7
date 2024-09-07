package com.managepage.dto.reponse;

import java.util.List;

public class BuildingReponseDTO {
    private String name;
    private String address;
    private Integer numberOfBasement; 
    private String managerName;
    private String managerPhoneNumber;
    private Integer floorArea; 
    private Integer freeArea; 
    private String rentArea; 
    private Integer rentPrice; 
    private String serviceFee; 
    private Integer mediumFee; 

    // Getters and Setters

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfBasement() {
        return numberOfBasement;
    }

    public void setNumberOfBasement(Integer numberOfBasement) {
        this.numberOfBasement = numberOfBasement;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPhoneNumber() {
        return managerPhoneNumber;
    }

    public void setManagerPhoneNumber(String managerPhoneNumber) {
        this.managerPhoneNumber = managerPhoneNumber;
    }

    public Integer getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(Integer floorArea) {
        this.floorArea = floorArea;
    }

    public Integer getFreeArea() {
        return freeArea;
    }

    public void setFreeArea(Integer freeArea) {
        this.freeArea = freeArea;
    }

    public String getRentArea() {
        return rentArea;
    }

    public void setRentArea(String rentArea) {
        this.rentArea = rentArea;
    }

    public Integer getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(Integer rentPrice) {
        this.rentPrice = rentPrice;
    }

    public String getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(String serviceFee) {
        this.serviceFee = serviceFee;
    }

    public Integer getMediumFee() {
        return mediumFee;
    }

    public void setMediumFee(Integer mediumFee) {
        this.mediumFee = mediumFee;
    }
}
