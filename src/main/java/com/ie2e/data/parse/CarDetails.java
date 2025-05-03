package com.ie2e.data.parse;

import com.google.common.base.Objects;

public class CarDetails {
    private String carRegNo;
    private String carModel;
    private String carMake;
    private String yearOfManufacture;
    public CarDetails() {

    }
    public CarDetails(String carRegNo, String carMake, String carModel, String yearOfManufacture) {
        this.carRegNo = carRegNo;
        this.carModel = carModel;
        this.carMake = carMake;
        this.yearOfManufacture = yearOfManufacture;
    }
    public String getCarRegNo() {
        return carRegNo;
    }

    public void setCarRegNo(String carRegNo) {
        this.carRegNo = carRegNo;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(String yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CarDetails that = (CarDetails) o;
        return Objects.equal(carRegNo, that.carRegNo) && Objects.equal(carModel, that.carModel) && Objects.equal(carMake, that.carMake) && Objects.equal(yearOfManufacture, that.yearOfManufacture);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(carRegNo, carModel, carMake, yearOfManufacture);
    }

    @Override
    public String toString() {
        return "CarDetails{" +
                "carRegNo='" + carRegNo + '\'' +
                ", carModel='" + carModel + '\'' +
                ", carMake='" + carMake + '\'' +
                ", yearOfManufacture='" + yearOfManufacture + '\'' +
                '}';
    }
}
