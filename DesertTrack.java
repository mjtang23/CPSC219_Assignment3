/* Marcus Tang 10086730 March 27th, 2015
This is another child class of the class Track. It takes in a Sports car object, a child of the Car class, and places it in the array based on certain conditions. 
*/
import java.util.Random;

// properties of the DesertTrack. Also contains the properties of the Track class.
public class DesertTrack extends Track
{
   CarFactory factory = new CarFactory();
   Car CPU = factory.getCar("Sport");
   private int current = 0;
   private int previous; 
   private boolean heatWave= false;
   private Car [] desert;
   
  // displays the track title
   public void startPos()
   {
     
     setLocation(CPU,0);
     title("Desert Track");
     display();
   }
   
   protected void setHeatwave(){
	   heatWave = true;
   }
  // sets the current position so the character can move
   public void setCurrent(int distance)
   {
      current += distance;
   }
   // sets the character to the next position and displays the progress
   public void nextPos()
   {
     setLocation(CPU,current);
     title("Desert Track");
     display();
   }
  // returns the array desert
   public Car []  getDesert ()
    {
	return desert;
    }
  // the copy of the aTrack from Track class and make it's own desert array
   public void desertTrack()
   {
     
     desert = getTrack();
     previous = current;
     desert[previous] = null;
	 if(heatWave == false){
		HeatWave();
		 
	 }
     
     HeatWaveCheck();
	 heatWave = false;
   }
   // Generates a heatwave
   public void HeatWave()
  {
     int heat;
     Random generator = new Random();
     heat = generator.nextInt(10)+1;
     if(heat == 3)
     {
       
        heatWave = true;
     }
	 
  }
  // Checks to see if heatwave is on, and set the consumption rate if it applies
  public void HeatWaveCheck()
    { 
      if(heatWave == true){
		System.out.println("Heat wave!!!!!!");
        setCurrent(CPU.move(1));
	  }else{
        setCurrent(CPU.move(2));
	  }
    }
  // returns the current integer
  public int getCurrent()
 {
   return current;
 }
// sets the fuel for the sports car in cheat menu option
 public void setSportFuel(int temp)
  {
    CPU.setFuel(temp);
  }
 // Checks to see if fuel is empty in Sports
 public boolean CheckEmpty()
  {
    if(CPU.isEmpty() == true)
      return true;
  
    else
     return false;
  }
}
