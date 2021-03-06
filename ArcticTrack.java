/* Marcus Tang 10086730 March 27th, 2015
This is a child class of the Track class. Takes in a SUV, a child class of the Car class, and positions the SUV in the array based on certain situations.
*/
import java.util.Random;
// Properties of the class 
public class ArcticTrack extends Track
{
   CarFactory factory = new CarFactory();
   SUV user = new SUV();
   private int current = 0;
   private int previous;
   private int distance = 0;
   private Car [] arctic;
   private boolean storm = false;
   

   // displays the graphical output of game
   public void show()
   {
     title("Arctic Track");
     display();
   }
   
   protected void setStorm(){
	   storm = true;
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
     title("Arctic Track");
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
	 if(storm == false){
		 Blizzard();
	 }
     
     StormCheck(); 
     storm = false;
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
     if(snow == 3)
     {
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
     if(user.getAWD() == true && storm == true){
		 System.out.println("Oh dear, you ran into a blizzard...");
        setCurrent(user.move(1)); 
	 }
     else if(user.getAWD() == false && storm == true){
		 System.out.println("Oh dear, you ran into a blizzard...");
         setCurrent(user.move(2));
	 }
     else{
          setCurrent(user.move(3));
     }

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
