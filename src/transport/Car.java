package transport;

import java.time.LocalDate;
import java.util.Objects;

import static transport.ValidateParameters.*;

public class Car {

    private final String brand;
    private final String model;
    public double engineVolume;
    public String color;
    public final String year;
    public final String country;
    public String transmission;
    public final String bodyStyle;
    public String registrationNumber;
    public final int numberOfSeats;
    public static String typeOfTire;

    public Car(String brand, String model, double engineVolume, String color, String year, String country, String transmission, String bodyStyle, String registrationNumber, int numberOfSeats, String typeOfTire) {
        this.brand = validateCarParameters(brand);
        this.model = validateCarParameters(model);
        this.engineVolume = validateEngineVolume(engineVolume);
        this.color = validateCarColor(color);
        this.year = validateYear(year);
        this.country = validateCarParameters(country);
        this.transmission = validateTransmission(transmission);
        this.bodyStyle = validateBodyStyle(bodyStyle);
        this.registrationNumber = validateRegistrationNumber(registrationNumber);
        this.numberOfSeats = validateNumberOfSeats(numberOfSeats);
        this.typeOfTire = validateTypeOfTire(typeOfTire);
    }

    public static double validateEngineVolume(double value) {
        return value <= 0 ? 1.5 : value;
    }

    public static String validateCarColor(String value) {
        return validateString(value, "белый");
    }

    public static String validateYear(String value) {
        return validateString(value, "2000");
    }

    public static String validateTransmission(String value) {
        return validateString(value, "механическая");
    }

    public static String validateBodyStyle(String value) {
        return validateString(value, "седан");
    }

    public static String validateRegistrationNumber(String value) {
        return validateString(value, "666");
    }

    public static int validateNumberOfSeats(int value) {
        return value <= 0 ? 4 : value;
    }

    public static String validateTypeOfTire(String value) {
        return validateString(value, isThisASummerTire());
    }

    public static String isThisASummerTire() {
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

    public String getYear() {
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
        return brand + " " + model + ", " + year + " год выпуска, " + "страна сборки - " + country + ", цвет кузова - " + color + ", объем двигателя - " + engineVolume + " л." + ", коробка передач - " + transmission + ", тип кузова - " + bodyStyle + ", регистрационный номер: " + registrationNumber + ", количество мест: " + numberOfSeats + ", тип резины: " + typeOfTire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.engineVolume, engineVolume) == 0 && year == car.year && numberOfSeats == car.numberOfSeats && brand.equals(car.brand) && model.equals(car.model) && color.equals(car.color) && country.equals(car.country) && transmission.equals(car.transmission) && bodyStyle.equals(car.bodyStyle) && registrationNumber.equals(car.registrationNumber) && typeOfTire.equals(car.typeOfTire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, engineVolume, color, year, country, transmission, bodyStyle, registrationNumber, numberOfSeats, typeOfTire);
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
