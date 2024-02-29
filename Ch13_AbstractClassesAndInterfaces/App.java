import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.event.*;
import javafx.scene.input.*;
import javafx.scene.paint.Color;

public class App extends Application
{
   Group root = new Group();
   Scene scene = new Scene(root);
   Canvas canvas = new Canvas(600, 400);
   GraphicsContext gc = canvas.getGraphicsContext2D();
   MouseHandler handleMouseClick = new MouseHandler();
   
   @Override
   public void start(Stage stage){
      
      scene.setOnMouseClicked(handleMouseClick);
      root.getChildren().add( canvas );
      stage.setScene(scene);
      stage.show();
   }//end start
   
   class MouseHandler implements EventHandler<MouseEvent>
   {
      @Override
      public void handle(MouseEvent e)
      {
         System.out.println( "X: " + e.getX() +
                             "Y: " + e.getY());
                             
         gc.setFill(Color.RED);
         gc.fillRect( e.getX(), e.getY(), 10, 10);
      }   
   }
}//end App