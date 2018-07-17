/*Marcus Tang 10086730 March 27th, 2015
This is a child class of Car. It has different fuel settings and consumption, but not capable of tracking it's own movement on the track. It returns the value it should move in certain situations. It also has th ablility to toggle AWD mode.
*/
// properties of the SUV
public class SUV extends Car
{
   
   private int count = 0;
   private boolean AWD = false;
   private final int AWDconsume = 3;
   private int AWDmove = 0;
   private int fuel;
   public SUV()
   {
      setAppearance('V'); 
      setFuel (50);
         
   }
  // Switches AWD on and off when it takes in the value.
  public void AWDswitch(boolean choice)
  {
    if(choice == false)
      AWD = false;

    else if(choice == true)
      AWD = true;
  }


  // returns the state of the AWD
  public boolean getAWD()
  {
    return AWD;
  }
 // How much the SUV should move when the vehicle is in a blizzard and AWD is on
 public int AWDmove1()
   {
     setFuel (getFuel() - AWDconsume);
     System.out.println("Current fuel: " + getFuel());
     System.out.println("Fuel use: " + AWDconsume);
     System.out.println("Distance traveled: " + 1);
     return 1;
   }
  // How much the SUV should move when AWD is off, and blizzard is on
  public int AWDmove2()
   {
     setFuel (getFuel() - AWDconsume);
     System.out.println("Current fuel: " + getFuel());
     System.out.println("Fuel use: " + AWDconsume);
     System.out.println("Distance traveled: " + 0);
     return 0;
   }
   // How much the vehicle should move when the AWD is on and the blizzard is off
   public int AWDmove3()
   {
     setFuel (getFuel() - AWDconsume);
     System.out.println("Current fuel: " + getFuel());
     System.out.println("Fuel use: " + AWDconsume);
     System.out.println("Distance traveled: " + 2);
     return 2;
   }
  
}
