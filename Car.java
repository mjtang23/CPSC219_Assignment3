/*
  Author:  James Tam(CPSC 219 Prof)
  Version: April 1, 2013

  Features:
  * Tracks and manages information for appearance and fuel capacity.


 */

public abstract class Car
{
    public static final int STARTING_FUEL = 40;
    public static final int STANDARD_DISTANCE = 2;
    public static final int CONSUMPTION_RATE = 2;
    private char appearance;
    private int fuel;

    public Car()
    {
	   setAppearance('c');
	   fuel = STARTING_FUEL;
    }

    // As the car moves, this class or child classes can specify for that type of car
    // How much fuel to consume.
    protected void consumeFuel(int amount)
    {
	if (amount < 0)
	    fuel = 0;
	else
	    fuel = fuel - amount;
    }

    public int getFuel()
    {
	return fuel;
    }

    // Allows external queries of the fuel state of a particular car.
    public boolean isEmpty()
    {
	if (fuel <= 0)
	    return true;
	else
	    return false;
    }

    // Car internally knows how much fuel to use and how far to move. However the 
    // actual movement in the virtual track must be done by another class hence
    // this method must communicate to the caller how far it moves.


    // If this method is overriden then all child class methods must also display
    // the same debugging messages shown below.
    abstract int move (int choice);
	
	//Returns the state of the AWD on vehicle
	abstract boolean getAWD();
   
    public void setAppearance (char anAppearance)
    {
	appearance = anAppearance;
    }

    public void setFuel (int newFuel)
    {
	if (fuel < 0)
	    System.out.println("Fuel cannot be set to a negative value");
	else
	    fuel = newFuel;
    }

    public String toString() 
    {
	String s = "";
	s = s + appearance;
	return s;
    }
}
