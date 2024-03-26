import java.util.Arrays;

public class GenericMethods
{
   public static void main(String[] args)
   {
      Integer[] numbers = {4, 8, 1, 36, 20, 7};
      Integer[] newNumbers = sort(numbers);
      
      System.out.println( Arrays.toString(newNumbers) );
   }

   public static <E extends Comparable<E>> E[] sort(E[] list)
   {
      for(int i = 1; i < list.length; i++ )
      {
         E temp = list[i];    //makes a copy of element to insert
         int j = i-1;
         while( j >= 0 && list[j].compareTo(temp) > 0 )
         {
            //shift
            list[j+1] = list[j];
            j--;
         }
         list[j+1] = temp;
      }
      
      return list;
   }
}