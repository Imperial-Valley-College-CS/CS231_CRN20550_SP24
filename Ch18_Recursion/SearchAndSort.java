public class SearchAndSort
{
   public static void main(String[] args)
   {
      int[] arr = {1,8,9,13,14,15};
      int index = binarySearchHelper(arr,15);
      System.out.println( index );
   }
   
   public static int binarySearchHelper(int[] arr, int key)
   {
      int low = 0;
      int high = arr.length-1;
      return binarySearch(arr, key, low, high);
   }
   
   public static int binarySearch(int[] arr, int key, int low, int high)
   {
      int mid = (low + high)/2;     //integer division
      
      if( low > high )
         return -1;        //key is not in arr
      else if( key > arr[mid] )
         return binarySearch(arr,key,mid+1,high);
      else if( key < arr[mid] )
         return binarySearch(arr,key,low,mid-1);
      else
         return mid;       //key is found at mid      
   }
}