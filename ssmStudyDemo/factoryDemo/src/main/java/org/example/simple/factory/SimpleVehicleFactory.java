package org.example.simple.factory;

import org.example.simple.pojo.Bike;
import org.example.simple.pojo.Car;
import org.example.simple.pojo.Truck;
import org.example.simple.pojo.Vehicle;

public class SimpleVehicleFactory {

    private enum VehicleType{
        CAR,BIKE,TRUCK;
    }

    public Vehicle createVehicle(String vehicleType){
        if (VehicleType.CAR.equals(vehicleType)){
            return new Car();
        }else if (VehicleType.BIKE.equals(vehicleType)){
            return new Bike();
        }else return new Truck();
    }

}
