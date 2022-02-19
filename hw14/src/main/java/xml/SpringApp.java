package xml;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Wheel wheel = context.getBean("wheel", Wheel.class);

        Car car = context.getBean("car", Car.class);
        System.out.println(car.getDescription(wheel));

        context.close();
    }
}
