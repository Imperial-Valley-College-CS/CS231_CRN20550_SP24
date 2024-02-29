import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class App extends Application
{
   Group root = new Group();
   Scene scene = new Scene(root);
   @Override
   public void start(Stage stage)
   {
      stage.setScene(scene);
      stage.show();
   }
}