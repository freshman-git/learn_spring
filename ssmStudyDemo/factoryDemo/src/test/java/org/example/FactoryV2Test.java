package org.example;

import org.example.abstratTest.pojo.Vehicle;
import org.example.simple.factory.FactoryV2;
import org.junit.Test;

public class FactoryV2Test {

    @Test
    public void test(){
        FactoryV2 factoryV2 = new FactoryV2();
        Vehicle car = factoryV2.create("car");
        System.out.println(car);
    }
}
