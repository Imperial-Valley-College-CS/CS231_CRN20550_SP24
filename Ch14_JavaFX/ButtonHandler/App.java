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
   Button bttn = new Button("OK");
   ButtonHandler bttnHandle = new ButtonHandler();
   
   @Override
   public void start(Stage s)
   {  
      bttn.setOnAction( bttnHandle );     //established a link between bttn and ButtonHandler class
      g.getChildren().add( bttn );
      s.setScene(scene);
      s.show();
   }
   
   class ButtonHandler implements EventHandler<ActionEvent>
   {
      @Override
      public void handle(ActionEvent e)        //handle is abstract, we must override
      {
         Button clickedBttn = (Button)e.getSource();
         System.out.println( clickedBttn.getText() );
      }
   }//end ButtonHandler
   
}//end App