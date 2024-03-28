public class TestArrayList
{
   public static void main(String[] args)
   {
      ArrayList<String> list = new ArrayList<>();
      
      list.add("hulk");
      list.add("loki");
      list.add("bane");
      list.add("batman");
      list.add("joker");
      System.out.println( list.toString() );
      
      for( int i = 0; i < list.size(); i++ )
      {
         System.out.println( list.get(i) );
      }
      
      for( String s : list )
      {
         System.out.println( s );
      }
   }
}