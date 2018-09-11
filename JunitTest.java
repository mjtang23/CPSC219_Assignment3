import org.junit.Test;

import junit.framework.Assert;

public class JunitTest {

	@Test
	public void SUVinstant() {
		CarFactory factory = new CarFactory();
		Car test = factory.getCar("SUV");
		Assert.assertTrue(test instanceof SUV);
		
	}
	
	@Test
	public void Sportinstant() {
		CarFactory factory = new CarFactory();
		Car test = factory.getCar("Sport");
		Assert.assertTrue(test instanceof SportsCar);
		
	}
	
	@Test
	public void AWDtoggle() {
		CarFactory factory = new CarFactory();
		Car test = new SUV();
		test.AWDswitch(true);
		Assert.assertEquals(test.getAWD(), true);
		
	}
	

}
