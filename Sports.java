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
   // returns the value it needs to move when a heatwave occurs
   public int SportsMove1()
    {
       setFuel (getFuel() - heatConsume);
       System.out.println("Current fuel: " + getFuel());
       System.out.println("Fuel use: " + heatConsume);
       System.out.println("Distance traveled: " + 3);
       return 3;
    }
   // returns the value it needs to move when the no heatwave occurs
   public int SportsMove2()
    {
      setFuel (getFuel() - 2);
      System.out.println("Current fuel: " + getFuel());
      System.out.println("Fuel use: " + 2);
      System.out.println("Distance traveled: " + 3);
      return 3;

    }
  

}
