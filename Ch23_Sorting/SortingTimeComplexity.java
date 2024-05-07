import java.util.Arrays;

public class SortingTimeComplexity
{
   public static void main(String[] args)
   {
      //testSort();
      timeComplexity();
   }
   
   public static void timeComplexity()
   {
      int size = 1000;         //100 elements per array
      
      while( size < 20000 )
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
            Sort.bubbleSort( arrays[counter] );
            counter++;
         }
         long endTime = System.currentTimeMillis();
         double timeToSort = (double)(endTime-startTime)/sorts;
         System.out.printf( "%d, %.12f\n", size, timeToSort);
         size *= 2;
      }
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