public class Hex extends Number
{
   public Hex( String value )
   {
      super(value);  //call to super constructor
      super.base = 16;
   }
   
   @Override
   public long toDec()
   {
      long decimal = 0;
      int exp = 0;
      for( int i = super.value.length()-1; i >= 0; i-- )
      {
         char digit = super.value.toLowerCase().charAt(i);
         int coeff = digit;
         
         if( digit >= 48 && digit <= 57 )
         {
            coeff -= 48;
         }else if( digit >= 97 && digit <= 122 )
         {
            coeff -= 87;
         }
         
         decimal += coeff*Math.pow(super.base, exp);
         exp++;
      }//end of loop
      return decimal;
   }
   @Override
   public String toBin()
   {
      return null;
   }
   @Override
   public String toHex()
   {
      return super.value;
   }
}