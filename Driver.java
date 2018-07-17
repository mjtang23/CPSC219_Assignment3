/*
  Author:  James Tam and Marcus Tang 10086730
  Version: March 27th, 2015

  Starting execution point. It also calls from class GameController to start the game.

*/


public class Driver
{
    public static void main(String [] args)
    {
        GameController start  = new GameController();
        start.runMenu();
    }
}
