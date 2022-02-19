package javacode;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApp {
    private static final int NUMBER_OF_WHEELS = 4;

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(CarConfig.class);

        Wheel wheel = context.getBean("wheel", Wheel.class);

        Car car = context.getBean("car", Car.class);
        car.addWheels(wheel, NUMBER_OF_WHEELS);
        System.out.println(car.getDescription(car.getWheels()));

        context.close();
    }
}
