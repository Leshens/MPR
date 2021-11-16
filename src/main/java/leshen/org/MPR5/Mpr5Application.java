package leshen.org.MPR5;

import leshen.org.MPR5.car.*;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Mpr5Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Mpr5Application.class, args);

//		Car car = context.getBean(Car.class);

//		System.out.println(car);
	}

}
