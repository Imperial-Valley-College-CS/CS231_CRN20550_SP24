import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.event.*;
import javafx.scene.input.*;

public class App extends Application
{
   Group root = new Group();
   Scene scene = new Scene(root);
   Canvas canvas = new Canvas(600, 400);
   GraphicsContext gc = canvas.getGraphicsContext2D();
   
   @Override
   public void start(Stage stage){
      
      //scene.setOnMouseClicked();
      root.getChildren().add( canvas );
      stage.setScene(scene);
      stage.show();
   }//end start
   
   class MouseHandler implements EventHandler<MouseEvent>
   {
   }
}//end App