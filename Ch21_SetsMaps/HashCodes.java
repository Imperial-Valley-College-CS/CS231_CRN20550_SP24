public class HashCodes
{
   public static void main(String[] args)
   {
      Movie m1 = new Movie("Star Wars", "PG", 121);
      Movie m2 = new Movie("Star Wars", "PG", 121);
      
      System.out.println( m1.hashCode() );
      System.out.println( m2.hashCode() );
      System.out.println( m1.equals(m2) );
      
      // String str = "spider";
//       long hashcode = hash( str );
//       System.out.println( hashcode );
//       System.out.println( str.hashCode() );
   }
   
   public static long hash( String s )
   {
      long code = 0;
      int n = s.length();
      for( int i = 0; i < n; i++ )
      {
         code += s.charAt(i)*Math.pow(31, n-i-1); 
      }
      return code;
   }
}