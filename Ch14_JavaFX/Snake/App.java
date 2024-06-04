import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.*;
import java.util.ArrayList;

public class App extends Application
{
   int windowSize = 500;
   Group g = new Group();
   Canvas canvas = new Canvas(windowSize,windowSize);
   GraphicsContext gc = canvas.getGraphicsContext2D();
   Scene scene = new Scene(g); 
   //Image hulk = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a0/Hulk_%282540708438%29.jpg/480px-Hulk_%282540708438%29.jpg");  
   //Image pumpkin = new Image("pumpkin.jpg");
   Timer timer = new Timer();
   KeyHandler startKey = new KeyHandler();
   KeyHandlerTwo stopKey = new KeyHandlerTwo();
   MouseHandler mouseHandle = new MouseHandler();
   int x = 50;
   int y = 100;
   int size = 10;
   //int dir = 1;
   String direction = "RIGHT";
   ArrayList<Block> snake = new ArrayList<>();
   
   @Override
   public void start(Stage s)
   {  
      initSnake();  
      //timer.start();                //starts timer (invokes handle method on every frame)
      
      g.getChildren().add(canvas);
      scene.setOnKeyPressed(startKey);
      scene.setOnKeyReleased(stopKey);
      scene.setOnDragDetected(mouseHandle);
      s.setScene(scene);
      s.show();
   }
   
   public void initSnake()
   {
      int numBlocks = 5;
      int maxX = (numBlocks-1)*size;
      
      while( maxX >= 0 )
      {
         snake.add( new Block(x+maxX, y) );
         maxX -= size;
      }
   }
   
   public void move()
   {
      gc.setFill(Color.BLACK);         //background Color  
      gc.fillRect(0, 0, windowSize, windowSize);
      
      //gc.drawImage(pumpkin, 0, 0);
      
      gc.setFill(Color.WHITE);         //snake color  
      for( Block b : snake )
         gc.fillRect(b.getX(), b.getY(), size, size);
      
      Block head = snake.get(0);
      int newX = head.getX();
      int newY = head.getY();
      
      if( direction.equals("RIGHT") )
         newX += size;
      if( direction.equals("LEFT") )
         newX -= size;
         
      if( direction.equals("UP") )
         newY -= size;
      if( direction.equals("DOWN") )
         newY += size;
         
      snake.add(0, new Block(newX, newY) );
      snake.remove( snake.size()-1 );           //remove tail
      
      // if( x > windowSize || x < 0 )
//          dir *= -1;
   }
   
   //inner class
   class Timer extends AnimationTimer
   {
      long dt = 16000000;     //approximate time in between frames (0.016 seconds) 62.5 Hz
      long last = dt;
      int frames = 3;         //increase to make slower
      
      @Override
      public void handle(long now)     //handle method is invoked on every frame
      {
         // if( now - last > frames*dt )
//          {
//             move();
//             last = now;
//          }
         move();
      }
   }//end Timer
   
   class KeyHandler implements EventHandler<KeyEvent>
   {
      @Override
      public void handle(KeyEvent e)        //handle is abstract, we must override
      {
         direction =  e.getCode().toString();
         timer.start();
      }
   }//end KeyHandler
   
   class KeyHandlerTwo implements EventHandler<KeyEvent>
   {
      @Override
      public void handle(KeyEvent e)        //handle is abstract, we must override
      {
         timer.stop();
      }
   }//end KeyHandler
   
   class MouseHandler implements EventHandler<MouseEvent>
   {
      @Override
      public void handle(MouseEvent e)        //handle is abstract, we must override
      {
         System.out.println( e.getX() + ", " + e.getY());
      }
   }//end KeyHandler
   
}//end App