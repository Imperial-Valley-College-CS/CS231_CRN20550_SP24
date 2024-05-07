public class Sort
{
   public static int[] selectionSort( int[] arr )
   {
      for( int j = 0; j < arr.length-1; j++ )
      {
         int k = j;              //index of smallest
         for( int i = j+1; i < arr.length; i++ )
         {
            if( arr[i] < arr[k] )
            {
               k = i;         //store index of smallest element
            }
         }
         //swap elements
         int temp = arr[j];
         arr[j] = arr[k];
         arr[k] = temp;
      }
      return arr;
   }
   
   public static int[] bubbleSort( int[] arr ){
		boolean sorted = false; //sorted boolean flag
		int pass = 0;           //keep track of each pass
		while( !sorted ){	//while sorted is false
			sorted = true; //assume array is sorted (if swap happens set to false)
			for( int i = 1; i < arr.length - pass; i++ ){				
				if( arr[i-1] > arr[i] ){   //if previous > next
					//swap neighboring elements
					int temp = arr[i-1];
					arr[i-1] = arr[i];
					arr[i] = temp;
					sorted = false;   //array not sorted yet
				} 
			}
			pass++;
		}
		return arr;
	}
}