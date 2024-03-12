public class RecursiveMethods
{
   public static void main(String[] args)
   {
      System.out.println( sumSeries(2) );
      int count = countSpaces("Hi, how's the weather outside?");
      System.out.println( count );
   }
   
   public static double sumSeries(double num)
   {
      double a = num/(2*num+1);
      if( num == 1 )
         return a;    //base case (num must converge to base case)
      else
         return a + sumSeries(num-1);
   }
   
   public static int countSpaces( String str )
   {
      if( str.length() == 0 )    //str is shrinking
         return 0;               //base case
      else
      {
         if( str.charAt(0) == 32 )
            return 1 + countSpaces( str.substring(1) );
            
         return countSpaces( str.substring(1) );
      }
   }
}