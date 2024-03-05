import java.io.*;
import java.util.*;
import javafx.scene.paint.Color;

public abstract class Invader
{
   protected int health, speedX, speedY;
   protected Color color;
   protected Position position;
   protected boolean[][] body;
   protected boolean isAlive = true;
   protected String matrixDirectory = Constants.MATRIX_DIRECTORY;
   
   public Invader( int x, int y )
   {
      this.position = new Position(x, y, Constants.ALIEN_WIDTH, Constants.ALIEN_HEIGHT);
      this.body = new boolean[Constants.ALIEN_ROWS][Constants.ALIEN_COLS];
      this.speedY = Constants.ALIEN_SPEED;
   }//end constructor
   
   public boolean[][] getBody(){ return this.body; }
   public Color getColor(){ return this.color; }
   public Position getPosition(){ return this.position; }
   public boolean alive(){ return this.isAlive; }
   
   public void setBody()
   {
      File f = new File( matrixDirectory );
      try
      {
         Scanner scan = new Scanner(f);
         int row = 0;
         while( scan.hasNextLine() )
         {
            int col = 0;
            String[] nextLine = scan.nextLine().split(",");
            for( String s : nextLine )
            {
               body[row][col] = s.equals("1");
               col++;
            }
            row++;
         }         
      }catch( FileNotFoundException e )
      {
         System.out.println( matrixDirectory + " not found." );
      }
   }//end setBody
   
   public boolean hit()
   {
      this.health--;
      if( this.health <= 0 )
         this.isAlive = false;
         
      return this.isAlive;
   }
   
   public abstract void move();
}