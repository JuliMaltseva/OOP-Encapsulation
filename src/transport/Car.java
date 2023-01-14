package transport;

import java.time.LocalDate;
import java.util.Objects;

public class Car {

    public final String brand;
    public final String model;
    public double engineVolume;
    public String color;
    public final int year;
    public final String country;
    public String transmission;
    public final String bodyStyle;
    public String registrationNumber;
    public final int numberOfSeats;
    public String typeOfTire;

    public Car(String brand, String model, double engineVolume, String color, int year,
               String country, String transmission, String bodyStyle, String registrationNumber, int numberOfSeats, String typeOfTire) {
        if (isBrand(brand)) {
            this.brand = brand;
        } else {
            this.brand = "default";
        }

        if (isModel(model)) {
            this.model = model;
        } else {
            this.model = "default";
        }

        if (isEngineVolume(engineVolume)) {
            this.engineVolume = engineVolume;
        } else {
            this.engineVolume = 1.5;
        }

        if (isColor(color)) {
            this.color = color;
        } else {
            this.color = "белый";
        }

        if (isYear(year)) {
            this.year = year;
        } else {
            this.year = 2000;
        }

        if (isCountry(country)) {
            this.country = country;
        } else {
            this.country = "default";
        }

        if (isTypeOfTire(typeOfTire)) {
            this.typeOfTire = typeOfTire;
        } else {
            this.typeOfTire = isThisASummerTire();
        }

        if (isTransmission(transmission)) {
            this.transmission = transmission;
        } else {
            this.transmission = "механическая";
        }

        if (isBodyStyle(bodyStyle)) {
            this.bodyStyle = bodyStyle;
        } else {
            this.bodyStyle = "седан";
        }

        if (isRegistrationNumber(registrationNumber)) {
            this.registrationNumber = registrationNumber;
        } else {
            this.registrationNumber = "666";
        }

        if (isNumberOfSeats(numberOfSeats)) {
            this.numberOfSeats = numberOfSeats;
        } else {
            this.numberOfSeats = 4;
        }
    }

    private boolean isBrand(String brand) {
        if (brand == null || brand == "") {
            return false;
        }
        return true;
    }

    private boolean isTypeOfTire(String typeOfTire) {
        if (typeOfTire == null || typeOfTire == "") {
            return false;
        }
        return true;
    }

    private boolean isBodyStyle(String bodyStyle) {
        if (bodyStyle == null || bodyStyle == "") {
            return false;
        }
        return true;
    }

    private boolean isRegistrationNumber(String registrationNumber) {
        if (registrationNumber == null || registrationNumber == "") {
            return false;
        }
        return true;
    }

    private boolean isTransmission(String transmission) {
        if (transmission == null || transmission == "") {
            return false;
        }
        return true;
    }

    private boolean isModel(String model) {
        if (model == null || model == "") {
            return false;
        }
        return true;
    }

    private boolean isCountry(String country) {
        if (country == null || country == "") {
            return false;
        }
        return true;
    }

    private boolean isEngineVolume(double engineVolume) {
        if (engineVolume <= 0) {
            return false;
        }
        return true;
    }

    private boolean isNumberOfSeats(int numberOfSeats) {
        if (numberOfSeats <= 0) {
            return false;
        }
        return true;
    }

    private boolean isColor(String color) {
        if (color == null || color == "") {
            return false;
        }
        return true;
    }

    private boolean isYear(double year) {
        if (year <= 0) {
            return false;
        }
        return true;
    }

    public String isThisASummerTire() {
         String currentMonth = String.valueOf(LocalDate.now().getMonth());
        switch (currentMonth) {
            case "JANUARY":
            case "FEBRUARY":
            case "MARCH":
            case "APRIL":
            case "OCTOBER":
            case "NOVEMBER":
            case "DECEMBER":
                typeOfTire = "зимняя";
                break;
            case "MAY":
            case "JUNE":
            case "JULY":
            case "AUGUST":
            case "SEPTEMBER":
                typeOfTire = "летняя";
            default:
                throw new RuntimeException("некорректно указан месяц");
        }
        return typeOfTire;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public String getCountry() {
        return country;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getBodyStyle() {
        return bodyStyle;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public String getTypeOfTire() {
        return typeOfTire;
    }

    public void setTypeOfTire(String typeOfTire) {
        this.typeOfTire = typeOfTire;
    }


    @Override
    public String toString() {
        return brand + " " + model + ", " + year + " год выпуска, " +
                "страна сборки - " + country +
                ", цвет кузова - " + color +
                ", объем двигателя - " + engineVolume + " л." +
                ", коробка передач - " + transmission +
                ", тип кузова - " + bodyStyle +
                ", регистрационный номер: " + registrationNumber +
                ", количество мест: " + numberOfSeats +
                ", тип резины: " + typeOfTire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.engineVolume, engineVolume) == 0 && year == car.year &&
                numberOfSeats == car.numberOfSeats &&
                brand.equals(car.brand) && model.equals(car.model) && color.equals(car.color) &&
                country.equals(car.country) && transmission.equals(car.transmission) &&
                bodyStyle.equals(car.bodyStyle) && registrationNumber.equals(car.registrationNumber) &&
                typeOfTire.equals(car.typeOfTire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, engineVolume, color, year, country,
                transmission, bodyStyle, registrationNumber, numberOfSeats, typeOfTire);
    }

    private class Key {
        private final boolean isRemoteEngineStart;
        private final boolean isKeylessEntry;

        public Key(boolean isRemoteEngineStart, boolean isKeylessEntry) {
            this.isRemoteEngineStart = isRemoteEngineStart;
            this.isKeylessEntry = isKeylessEntry;
        }

        public boolean isRemoteEngineStart() {
            return isRemoteEngineStart;
        }

        public boolean isKeylessEntry() {
            return isKeylessEntry;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return isRemoteEngineStart == key.isRemoteEngineStart && isKeylessEntry == key.isKeylessEntry;
        }

        @Override
        public int hashCode() {
            return Objects.hash(isRemoteEngineStart, isKeylessEntry);
        }
    }
}
