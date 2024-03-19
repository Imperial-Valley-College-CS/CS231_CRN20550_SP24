public class TestGenericMethods
{
   public static void main(String[] args)
   {
      String str1 = "mufasa";
      String str2 = "simba";
      System.out.println( max(str1, str2) );
      
      Car car1 = new Car("honda", "odessey", 1992);
      Car car2 = new Car("chevy", "corvette", 2009);
      System.out.println( max(car1, car2) );
   }
   
   public static <E extends Comparable<E>> E max( E obj1, E obj2 )
   {
      if( obj1.compareTo(obj2) > 0 )
         return obj1;
      else
         return obj2;
   }
}