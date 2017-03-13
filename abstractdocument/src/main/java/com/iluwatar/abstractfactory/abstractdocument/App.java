package com.iluwatar.abstractfactory.abstractdocument;

import com.iluwatar.abstractfactory.abstractdocument.domain.Car;
import com.iluwatar.abstractfactory.abstractdocument.domain.HasModel;
import com.iluwatar.abstractfactory.abstractdocument.domain.HasParts;
import com.iluwatar.abstractfactory.abstractdocument.domain.HasPrice;
import com.iluwatar.abstractfactory.abstractdocument.domain.HasType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 */
public class App {

    public App() {
        System.out.println("Constructing parts and car");

        Map<String, Object> carPorperties = new HashMap<>();
        carPorperties.put(HasModel.PROPERTY, "300sl");
        carPorperties.put(HasPrice.PROPERTY, 1000L);

        Map<String, Object> wheelProperties = new HashMap<>();
        wheelProperties.put(HasType.PROPERTY, "wheel");
        wheelProperties.put(HasModel.PROPERTY, "15c");
        wheelProperties.put(HasPrice.PROPERTY, 100L);

        Map<String, Object> doorProperties = new HashMap<>();
        doorProperties.put(HasType.PROPERTY, "door");
        doorProperties.put(HasModel.PROPERTY, "Lambo");
        doorProperties.put(HasPrice.PROPERTY, 300L);

        carPorperties.put(HasParts.PROPERTY, Arrays.asList(wheelProperties, doorProperties));

        Car car = new Car(carPorperties);

        System.out.println("here is our car");
        System.out.println("-> model: " + car.getModel().get());
        System.out.println("-> price: " + car.getPrice().get());
        System.out.println("-> parts: ");
        car.getParts().forEach(p -> System.out
                .println("\t" + p.getType().get() + "/" + p.getModel().get() + "/" + p.getPrice().get()));
    }

    public static void main(String[] args) {
        new App();
    }
}
