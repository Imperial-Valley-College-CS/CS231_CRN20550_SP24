import java.util.Arrays;

public class ArrayList<E>
{
   private E[] arr;
   private int size = 0;
   
   public ArrayList()
   {
      this.arr = (E[])(new Object[2]);
   } 
   
   public ArrayList( int size )
   {
      this.arr = (E[])(new Object[size]);
   }  
   
   public void add( E obj )
   {
      if( this.size == this.arr.length )
         resize();
         
      this.arr[this.size] = obj;
      
      System.out.println( "Debug: " + Arrays.toString(this.arr) );
      
      this.size++;
   }
   
   private void resize()
   {
      E[] copy = this.arr;      
      this.arr = (E[])(new Object[2*this.size]);
      
      for( int i = 0; i < copy.length; i++ )
         this.arr[i] = copy[i];
   }
   
   @Override
   public String toString()
   {
      String listAsString = "[";
      
      for( int i = 0; i < this.size-1; i++ )
      {
         listAsString += this.arr[i] + ", ";
      }
      
      listAsString += this.arr[this.size-1] + "]";
      return listAsString;
   }
}