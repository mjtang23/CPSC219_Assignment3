/*Marcus Tang 10086730 Sept 18th, 2018
This is a child class of Car. It has the ability to move 3 units by default, but only returns that value to the track. It has the property to track the fuel, but needs the Desert Class to call which method when a certain situation occurs.
*/
// Properties of the car
public class SportsCar extends Car
{
   private int fuel;
   private final int heatConsume = 4;
   //Constructor
   public SportsCar()
    {
	setAppearance('P');
        setFuel (30); 
       
    }
	
	int move(int choice){
		
		if(choice == 1){
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
	
	protected boolean getAWD(){
		return false;
	}
   // returns the value it needs to move when a heatwave occurs
   public void moveOutput(int consume)
    {
       
       System.out.println("Current fuel: " + getFuel());
       System.out.println("Fuel use: " + consume);
       System.out.println("Distance traveled: " + 3);
     
    }
   
   protected void setAWD(boolean aWD) {
		super.AWD = false;
	}

}
