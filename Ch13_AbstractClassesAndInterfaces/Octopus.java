import javafx.animation.AnimationTimer;

public class Octopus extends Invader
{
   private Timer timer = new Timer();   
   private String[] octopusFiles = {"/OctopusMatrix.txt", "/HurtOctopusMatrix.txt", "/DamagedOctopusMatrix.txt"};
   private int counter, xUlim, xLlim;
   private int speedXCoeff = 1;
   
   public Octopus( int x, int y )
   {
      super(x,y);
      super.health = octopusFiles.length;
      super.color = Constants.OCTOPUS_COLOR;
      super.speedX = Constants.OCTOPUS_SPEED;
      super.matrixDirectory += this.octopusFiles[0];
      super.setBody();
   }
   
   @Override
   public boolean hit()
   {
      timer.start();    //starts timer (handle method invoked on every frame)
      super.hit();
      if( super.isAlive )
      {
         super.matrixDirectory = Constants.MATRIX_DIRECTORY +
            this.octopusFiles[octopusFiles.length-super.health];
         super.setBody();
      }
      return super.isAlive;
   }
   
   @Override
   public void move()
   {
      int newX = super.position.getX();
      int newY = super.position.getY();
      
      newY += super.speedY;
      super.position.setY( newY );
      
      newX += this.speedXCoeff*super.speedX;
      
      if( (newX+Constants.ALIEN_WIDTH) >= this.xUlim 
          || newX <= xLlim )    //checks for boundary
         this.speedXCoeff *= -1;
         
      this.position.setX(newX);
   }
   
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
            timer = 0;
         }
         double dt = (now-last)*Math.pow(10,-9);
         timer += dt;
         last = now;         
      }//end handle (called on every frame)
      
   }//end Timer
}//end Octopus