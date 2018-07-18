/* Marcus Tang 10086730 March 27th, 2015
This is a child class of the Track class. It has the exact same properties, but it contains an SUV vehicle, and blizzard conditions. It tracks the movement of the SUV, but it doesn't contain the properties of the SUV. Therefore, it must call the SUV to see how much the SUV should move on the track. ActicTrack only tracks the movement, not the consumption of fuel the SUV consumes.
*/
import java.util.Random;
// Properties of the class 
public class ArcticTrack extends Track
{
   SUV user = new SUV();
   private int current = 0;
   private int previous;
   private int distance = 0;
   private Car [] arctic;
   private boolean storm = false;
   
   // displays just the title of track
   public void title()
   {
      System.out.println("Arctic Track");      
   }
   // displays the graphical output of game
   public void show()
   {
     title();
     display();
   }
  // starts character at starting position
   public void startPos()
   {
     setLocation(user,0);
     show();
   }
   // Sets the character at the next location
   public void nextPos()
   {
     setLocation(user,current);
     title();
     display();
   }
   // changes what current should be for next round, depending on choice
   public void setCurrent(int distance)
   {
      current = current + distance;
   }

  // Where recreation of the track is made. 
   public void arcticTrack()
   {
     arctic = new Car[SIZE];
     arctic = getTrack();
     previous = current;
     arctic[previous] = null;
     Blizzard();
     StormCheck(); 
     
   }
   // For the Arctic class to change the AWD mode
   public void AWDchoice(boolean temp)
    {
       user.AWDswitch(temp);
    }
  // Generates a Blizzard
  public void Blizzard()
  {
     int snow;
     Random generator = new Random();
     snow = generator.nextInt(10)+1;
     if(snow == 1)
     {
        System.out.println("Oh dear, you ran into a blizzard...");
        storm = true;
     }
     else
     {
       storm = false;
     }
	 
  }
  // Checks to see what the move should be based on AWD mode and Blizzard condition
  public void StormCheck()
  {
     if(user.getAWD() == true && storm == true)
        setCurrent(user.AWDmove1()); 
       
     else if(user.getAWD() == false && storm == true)
         setCurrent(user.AWDmove2());

     else if(user.getAWD() == true && storm == false)  
          setCurrent(user.AWDmove3());
     
     else 
       setCurrent(user.AWDmove3());
  }

  // returns the current number
 public int getCurrent()
 {
   return current;
 }
 // sets the value of the fuel for cheat menu
 public void setSUVFuel(int choice)
  {
    user.setFuel(choice);
  }
  // Checks to see if the fuel is empty in SUV
 public boolean CheckEmpty()
  {
    if(user.isEmpty() == true)
      return true;
  
    else
     return false;
  }
  
}
