package transformers;

import java.util.Map;

import io.cucumber.java.DataTableType;
import models.Car;

public class CarTransformer {

	@DataTableType
	public Car defineCar(Map<String, String> entry) {
		 return new Car(entry.get("model"), entry.get("name"), entry.get("energy"), entry.get("transmission"), entry.get("year"), entry.get("price"), entry.get("description"));
	}
}
