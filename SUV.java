/*Marcus Tang 10086730 Sept 11th, 2018
This is a child class of Car. It has different fuel settings and consumption, but not capable of tracking it's own movement on the track. It returns the value it should move in certain situations. It also has th ablility to toggle AWD mode.
*/
// properties of the SUV
public class SUV extends Car
{
   
   private int count = 0;
   private final int SUVconsume = 3;
   private int AWDmove = 0;
   private int fuel;
   
   public SUV()
   {
      setAppearance('V'); 
      setFuel (50);
         
   }
   
 //AWD setter. 
 	protected void setAWD(boolean aWD){
 		super.AWD = aWD;
 	}
 	
  // Switches AWD on and off when it takes in the value.
  public void AWDswitch(boolean choice)
  {
    if(choice == false)
      setAWD(false);

    else if(choice == true)
      setAWD(true);
  }


  // returns the state of the AWD
  public boolean getAWD()
  {
    return super.AWD;
  }
  

  int move(int choice)
   {
	   int move = 0;
	   if(choice == 1){
		    // How much the SUV should move and consume when the vehicle is in a blizzard and AWD is on
			move = 1;
	   }else if(choice == 2){
		     // How much the SUV should move and consume when AWD is off, and blizzard is on
			move = 0;
	   }else{
		    // How much the vehicle should move and consume when the AWD is on/off and the blizzard is off
			move = STANDARD_DISTANCE;
	   }
     setFuel (getFuel() - SUVconsume);
     System.out.println("Current fuel: " + getFuel());
     System.out.println("Fuel use: " + SUVconsume);
     System.out.println("Distance traveled: " + move);
     return move;
   }
  
  
}
