public class TimeComplexitySearch
{
   public static void main(String[] args)
   {
      int [] arr = {3, 8, 17, 20, 34, 50};
      int key = 31;
      
      int size = 10000;
      while( size < 100000000 )
      {
         double time = timeForLinearSearch(size);
         System.out.printf( "%d, %.8f\n", size, time );
         size *= 2;
      }   
   }
   
   public static double timeForLinearSearch( int size )
   {
      int searches = 1000;
      int search = 0;
      int[] arr = generateArray(size);
      long startTime = System.currentTimeMillis();
      
      while( search < searches )
      {
         int key = 0;     //-500 to positive 499
         binarySearch(key,arr);
         search++;
      }
      
      long endTime = System.currentTimeMillis();
      return (double)(endTime-startTime)/searches;
   }
   
   public static void timeForBinarySearch()
   {
   }
   
   public static int[] generateArray( int size )
   {
      int startValue = 50;
      int[] arr = new int[size];
      for( int i = 0; i < size; i++ )
         arr[i] = startValue+2*i;
         
      return arr;
   }
   
   public static int linearSearch(int key, int[] arr)
   {
      for( int i = 0; i < arr.length; i++ )
      {
         if( key == arr[i] )
         {
            return i;
         }
      }
            
      return -1;
   }
   
   public static int binarySearch(int key, int[] arr)
   {
      int low = 0;
      int high = arr.length-1;
      return binarySearch(key, arr, low, high);
   }
   
   public static int binarySearch(int key, int[] arr, int low, int high)
   {
      if( low > high )     //key was not found in array (base case)
         return -1;
         
      int mid = (low+high)/2;
      
      if( key > arr[mid] )
         return binarySearch(key, arr, mid+1, high);
      else if( key < arr[mid] )
         return binarySearch(key, arr, low, mid-1);
      else
         return mid;
   }
}