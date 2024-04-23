import java.util.*;

public class NumberOccurrences
{
   public static void main(String[] args)
   {
      HashMap<Integer,Integer> map = new HashMap<>();
      Scanner scan = new Scanner(System.in);
      int key;
      
      do
      {
         System.out.print("Enter a number: ");
         key = scan.nextInt();               //map's key
         
         if( map.containsKey(key) )
         {
            int value = map.get(key);
            map.replace(key, value+1);
         }else
         {
            map.put(key, 1);
         }
      }while( key != 0 );
      
      System.out.println( map );
      
      int maxValue = 0;
      ArrayList<Integer> keys = new ArrayList<>();
      
      for( int x : map.keySet() )
      {
         if( map.get(x) > maxValue )
         {
            keys.clear();              //found bigger value, clear list
            maxValue = map.get(x);     //update maxValue
            keys.add(x);               //add key to list
         }else if ( map.get(x) == maxValue )
         {
            keys.add(x);               //add key to list
         }
      }
      
      System.out.println( "Number entered most is " + keys );
   }
}