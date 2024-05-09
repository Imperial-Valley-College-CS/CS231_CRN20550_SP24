import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.NumberAxis;

import java.util.Arrays;

public class SortingTimeComplexity extends Application
{
   NumberAxis xAxis = new NumberAxis(0, 20000, 1000);
   NumberAxis yAxis = new NumberAxis(0, 300, 50);
   XYChart.Series selectionSeries = new XYChart.Series();
   ScatterChart<Number, Number> sc = new ScatterChart<>(xAxis,yAxis);
   @Override
   public void start(Stage stage)
   {
      //testSort();
      Number[][] values = timeComplexity();
      scatterChart(values);
      Scene scene = new Scene(sc, 500, 400);
      stage.setScene( scene );
      stage.show();
   }
   
   public void scatterChart(Number[][] values)
   {
      
      selectionSeries.setName("Selection Sort");
      for( Number[] row : values )
      {
         selectionSeries.getData().add( new XYChart.Data(row[0], row[1]) );
      }
      sc.getData().add( selectionSeries );
   }
   
   public Number[][] timeComplexity()
   {
      int size = 1000;         //100 elements per array
      Number[][] values = new Number[5][2];
      int k = 0; 
      while( size < 16001 )
      {
         //array of arrays
         int sorts = 50;         //50 sortes
         int[][] arrays = new int[sorts][size];
         
         for( int i = 0; i < sorts; i++ )
            arrays[i] = generateArray(size);
            
         int counter = 0;
         long startTime = System.currentTimeMillis();
         while( counter < sorts )
         {
            Sort.selectionSort( arrays[counter] );
            counter++;
         }
         long endTime = System.currentTimeMillis();
         double timeToSort = (double)(endTime-startTime)/sorts;
         values[k][0] = size;
         values[k][1] = timeToSort;
         System.out.printf( "%d, %.12f\n", size, timeToSort);
         size *= 2;
         k++;
      }
      return values;
   }
   
   public static int[] generateArray( int size )
   {
      int[] arr = new int[size];
      for( int i = 0; i < size; i++ )
         arr[i] = (int)(10*size*Math.random());
         
      return arr;
   }
   
   public static void testSort()
   {
      int[] x = {11, 9, 6, 1, 3, 20};
      int[] arr = Sort.selectionSort( x );
      System.out.println( Arrays.toString(arr) );
   }
}