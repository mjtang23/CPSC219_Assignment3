//version Sept 11th, 2018
public class CarFactory{
	public Car getCar(String carType){
		if(carType.equalsIgnoreCase("SUV")){
			return new SUV();
		}else if(carType.equalsIgnoreCase("Sport")){
			return new SportsCar();
		}else{
			return null;
		}
	}

}