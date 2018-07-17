/* Marcus Tang 10086730 March 27th, 2015
This is another child class of the class Track. Again it only tracks the movement of the sports car, but doesn't keep track of the fuel consumed. This track has to call from the class Sports in order to get the correct moves on the track.
*/
import java.util.Random;
// properties of the DesertTrack
public class DesertTrack extends Track
{
   Sports CPU = new Sports();
   private int current = 0;
   private int previous; 
   private boolean heatWave;
   private Car [] desert;
   
   
  // Displays the track title
   public void title()
   {
      System.out.println("Desert Track");
   }
  // displays the track title
   public void startPos()
   {
     
     setLocation(CPU,0);
     title();
     display();
   }
  // sets the current position so the character can move
   public void setCurrent(int distance)
   {
      current = current + distance;
   }
   // sets the character to the next position and displays the progress
   public void nextPos()
   {
     setLocation(CPU,current);
     title();
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
     HeatWave();
     HeatWaveCheck();
   
   }
   // Generates a heatwave
   public void HeatWave()
  {
     int heat;
     Random generator = new Random();
     heat = generator.nextInt(10)+1;
     if(heat == 3)
     {
        System.out.println("Heat wave!!");
        heatWave = true;
     }
     else
     {
       heatWave = false;
     }
	 
  }
  // Checks to see if heatwave is on, and set the consumption rate if it applies
  public void HeatWaveCheck()
    { 
      if(heatWave == true)
        setCurrent(CPU.SportsMove1());

      else 
        setCurrent(CPU.SportsMove2());
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
