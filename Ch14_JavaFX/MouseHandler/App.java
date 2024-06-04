import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.event.*;
import javafx.scene.input.*;
import javafx.scene.control.Button;


public class App extends Application
{
   Group g = new Group();        //is a Parent
   Scene scene = new Scene(g); 
   MouseHandler handleMouse = new MouseHandler();
   
   @Override
   public void start(Stage s)
   {  
      scene.setOnMouseClicked( handleMouse );     //established a link between bttn and ButtonHandler class
      s.setScene(scene);
      s.show();
   }
   
   class MouseHandler implements EventHandler<MouseEvent>
   {
      @Override
      public void handle(MouseEvent e)        //handle is abstract, we must override
      {
         System.out.println( e.getX() + ", " + e.getY() );
      }
   }//end MouseHandler
   
}//end App