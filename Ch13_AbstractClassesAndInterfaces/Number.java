public abstract class Number
{
   protected String value;
   protected int base;
   
   public Number( String value )
   {
      this.value = value;
   }
   
   public void setValue( String value )
   {
      this.value = value;
   }
   public String getValue()
   {
      return this.value;
   }
   
   //abstract methods (implementation is delegated to subclasses)
   public abstract long toDec();
   public abstract String toBin();
   public abstract String toHex();
}