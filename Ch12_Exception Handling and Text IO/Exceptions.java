import java.util.*;

public class Exceptions
{
   public static void main(String[] args)
   {
      Scanner scan = new Scanner(System.in);      
      while(true)
      {                  
         try
         {
            System.out.println("How old are you?");
            int age = scan.nextInt();
            break;
         }catch( InputMismatchException e )
         {  
            //eat carriage return and newline left over from pressing enter key
            scan.next();     
            System.out.println("Value entered was not an integer.");
         }  
      }    
   }//end main   
}//end class