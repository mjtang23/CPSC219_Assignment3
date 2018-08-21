/*Marcus Tang 10086730 March 27th, 2015
This is a child class of Car. It has the ability to move 3 units by default, but only returns that value to the track. It has the property to track the fuel, but needs the Desert Class to call which method when a certain situation occurs.
*/
// Properties of the car
public class Sports extends Car
{
   private int fuel;
   private final int heatConsume = 4;
   public Sports()
    {
	setAppearance('P');
        setFuel (30); 
       
    }
	
	int move(int choice){
		
		if(choice ==1){
			//move when heatwave occurs
			setFuel (getFuel() - heatConsume);
			moveOutput(heatConsume);
		}else{
			//movement with no heatwave
			setFuel (getFuel() - CONSUMPTION_RATE);
			moveOutput(CONSUMPTION_RATE);
		}
		
		return 3;
		
	}
   // returns the value it needs to move when a heatwave occurs
   public void moveOutput(int consume)
    {
       
       System.out.println("Current fuel: " + getFuel());
       System.out.println("Fuel use: " + consume);
       System.out.println("Distance traveled: " + 3);
     
    }
   
  

}
