/* Marcus Tang 10086730 March 27th, 2015
This class controls all the classes that are called to make the game run. It allows the user to make choices during the game. The choices to make a move in the game, or even to access the cheat menu. it also displays the description of the game, and ends the game when the criteria meets. This program doesn't have the properties of the track or cars, but calls for them when they need to be in the game.The Cheat options dont work for setting up a blizzard or for a heatwave.
*/
import java.util.Scanner;
// The properties of this class and the attributes 
public class GameController
{
   

      private int choice;
      private int choice2;
      private boolean pass = false;
      private boolean done = false;
      private int sportsFuel;
      private int SUVfuel;
      private int SportsPos;
      private int SUVpos;
      Scanner in = new Scanner(System.in);
      DesertTrack hot = new DesertTrack();
      ArcticTrack cold = new ArcticTrack();
      Debug cheat = new Debug();
   
      
   // Displays the options for the SUV
   public void SUVmenu()
   {
      System.out.println("SUV driving options:");
      System.out.println("\t (1) all wheel drive mode");
      System.out.println("\t (2) drive normally");
      System.out.println("\t (3) quit game");
      System.out.println("\t (4) cheat menu");
      System.out.print("Enter choice:");
      choice = in.nextInt();
      
   }  
   // Displays the options for the Sports car
   public void CARmenu()
   {
      System.out.println("Car driving options:");
      System.out.println("\t (1) drive normally");
      System.out.println("\t (2) quit game");
      System.out.println("\t (3) cheat menu");
      System.out.print("Enter choice:");
      choice = in.nextInt();
   }  
   // Displays the options for the cheats
   public int CheatMenu()
   {
      System.out.println("\t (0) debugging messages on/off");
      System.out.println("\t (1) change fuel of sports car");
      System.out.println("\t (2) change fuel of SUV car");
      System.out.println("\t (3) change location of sports car");
      System.out.println("\t (4) change location of SUV");
      System.out.println("\t (5) make a blizzard!");
      System.out.println("\t (6) make a heatwave!");
      System.out.print("Enter choice:");
      int choice = in.nextInt();
      return choice;
   }
   // Displays the description of the game
   public void Instruct()
    {
      System.out.println("Here's the game.You're the SUV in the Arctic track with the character V. You will be racing against the Sports car that will be one space faster than you. On the bright side, the Sports car can run out of fuel before you, especially if it gets in a heatwave. On the other hand, there is a random chance that you'll run into a blizzard. If you're not in AWD, then you'll not move at all and basically loose a turn. There is a cheat menu if you need to tweak a few settings, but otherwise LET THE RACE BEGIN!!");
    }
   // Checks to see if value put for the cheat menu is valid
   public void CheatCheck(int choice)
    {
      switch (choice){
         case 0:  if(Debug.on == false)
                   {
                     System.out.println("Debug on!!");
                     Debug.on = true;
                   }
   
                  else if(Debug.on == true)
                   {
                     System.out.println("Debug off");
                     Debug.on = false;
                   }  
                  
                  break;
         case 1:  System.out.print("Change Sports car fuel to:");
                  sportsFuel = in.nextInt();
                  hot.setSportFuel(sportsFuel);
                  System.out.println("Sports fuel set to:" + sportsFuel);
                  
                  break;
         case 2:  System.out.print("Change SUV fuel to:");
                  SUVfuel = in.nextInt();
                  cold.setSUVFuel(SUVfuel);
                  System.out.println("SUV fuel set to:" + SUVfuel);
                  
                  break;
         case 3:  System.out.print("Change the location of Sports car to (from 0-24):");
                  SportsPos = in.nextInt();
                  while(SportsPos < 0 || SportsPos >24)
                     {
                        System.out.print("Invalid choice, please try again:");
                        SportsPos = in.nextInt();
                     }
                  hot.setCurrent(SportsPos);
                  System.out.println("Sports car now in position:" + SportsPos);
                  
                  break;
         case 4:  System.out.print("Change the location of SUV car to (from 0-24):");
                  SUVpos = in.nextInt();
                  while(SUVpos < 0 || SUVpos >24)
                     {
                        System.out.print("Invalid choice, please try again:");
                        SUVpos = in.nextInt();
                     }
                  cold.setCurrent(SUVpos);
                  System.out.println("Sports car now in position:" + SUVpos);
                
                  break;
         case 5:  System.out.println("Blizzard settings turned on");
                  cold.setStorm();
				
				  //SUVmenu();
                  break;
         case 6:  System.out.println("Run Settings for HeatWave");
                  hot.setHeatwave();
				  //CARmenu();
                  break; 

         default: System.out.print("You choice is invalid... Try again:");
                   choice2 = in.nextInt();
       }
   
   }
   // checks to see if answer for SUV menu is valid
   public void CheckSUV()
   {
     switch (choice){
         case 1:  System.out.println("AWD activated!");
                  cold.AWDchoice(true);
                  cold.arcticTrack();
                  break;
         case 2:  cold.AWDchoice(false);
                  cold.arcticTrack();
                  break;
				  
         case 3:  System.out.println("You've quit the game. Thanks for playing!");
                  System.out.println("It's a tie!!");
				  System.exit(0);
                  
         case 4:  System.out.println("The Cheat Menu:");
                  CheatCheck(CheatMenu());
				  SUVmenu();
				  CheckSUV();
                  break;

         default: System.out.print("You choice is invalid... Try again:");
                  choice = in.nextInt();
         }
    }
    // checks to see if user input for Sports car is valid
    public void CheckCAR()
   {
     switch (choice){
         case 1:  hot.desertTrack();
                  break;
         case 2:  System.out.println("You've just quit. Thanks for playing!");
                  System.out.println("It's a tie");
                  System.exit(0);
                  
         case 3:  System.out.println("The Cheat Menu:");                 
				  CheatCheck(CheatMenu());
				  CARmenu();
				  CheckCAR();
                  break;
         default: System.out.print("You choice is invalid... Try again:");
                  choice = in.nextInt();
         }
    }

   // Runs the menu for the game until it meets the requirements

   public void runMenu()
   {
      Instruct();
      hot.startPos();
      cold.startPos();
    
     //loops until fuel is gone, or one of the vehicles reaches the end
      while(done == false)
      {
               
         if(cold.getCurrent()> 23)
            {
              System.out.println("SUV Wins!!");
              
              break;
            }

          if(hot.getCurrent()> 23)
            {
              System.out.println("Sport's Car Wins!!");
              break;
            }

           SUVmenu();
           CheckSUV();
           CARmenu();
           CheckCAR();

           if(cold.CheckEmpty() == true)
           {
              System.out.println("SUV all out of fuel!!");
              System.out.println("Sport's Car Wins!!"); 
			  done = true;
              break; 
           }
 
         if(hot.CheckEmpty() == true)
           {
              System.out.println("Sports car all out of fuel!!");
              System.out.println("SUV Wins!!!");
			  done = true;
              break;
           }
           cold.nextPos();
           hot.nextPos(); 
           
     }   
        
          
       
   }
   

    
  

}
