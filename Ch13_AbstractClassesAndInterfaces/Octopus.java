import javafx.application.Application;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;

public class Octopus extends Application
{
   private Timer timer = new Timer();
   @Override
   public void start( Stage stage )
   {
      timer.start();       //activates the AnimationTimer       
   }//end main
   
   class Timer extends AnimationTimer
   {
      long last = 0;
      double speed = 10;   //speed of execution
      double timer = 0;
      
      @Override
      public void handle(long now)
      {
         if( timer > speed )
         {    
            super.health = 3;
            super.matDir = "/Octopus.txt";
            setBody();        
            System.out.println( now*Math.pow(10,-9) );
            timer = 0;
         }
         double dt = (now-last)*Math.pow(10,-9);
         timer += dt;
         last = now;         
      }//end handle (called on every frame)
      
   }//end Timer
}//end Octopus