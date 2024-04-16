import java.io.*;
import java.util.*;

public class PlayWithVideogames
{
   public static void main(String[] args)
   {
      ArrayList<Videogame> listOfgames = readData("VideogameData/DataSheetVideogames.csv");      
      
      PriorityQueue<Videogame> queueOfgames = new PriorityQueue<>( new TitleComparator() );
      
      for( int i = 0; i < 10; i++ )
         queueOfgames.offer( listOfgames.get(i) );
         
      
      int size = queueOfgames.size();
      for( int i = 0; i < size; i++ )
         System.out.println( queueOfgames.poll() );
   }
   
   public static ArrayList<Videogame> readData( String filename )
   {
      try
      {   
         FileReader file = new FileReader(filename);
         BufferedReader scan = new BufferedReader(file); 
         ArrayList<Videogame> videogames = new ArrayList<>();       
         scan.readLine();  //scan first line in csv (column headings)
         int count = 0;
         
         do
         {
            String[] fields = scan.readLine().split(",");
            int sales = Integer.parseInt(fields[1]);
            Videogame v = new Videogame(fields[0], sales, fields[4]);
            videogames.add( v );
            count++;
                      
         }while( count < 50 );
         
         scan.close();
         return videogames;
         
      }catch( FileNotFoundException e )
      {
         System.out.println( filename + " not found. " );
         return null;
      }catch( IOException e )
      {
         System.out.println( filename + " not found. " );
         return null;
      }
   }
   
   static class TitleComparator implements Comparator<Videogame>
   {
      @Override
      public int compare(Videogame v1, Videogame v2)
      {
         return v2.getTitle().compareTo( v1.getTitle() );
      }
   }
   
   static class SalesComparator implements Comparator<Videogame>
   {
      @Override
      public int compare(Videogame v1, Videogame v2)
      {
         return v2.getSales()-v1.getSales();
      }
   }
 
   // static class ReleaseComparator implements Comparator<Videogame>
//    {
//       @Override
//       public int compare(Videogame v1, Videogame v2)
//       {
//          return v1.getRelease().compareTo(v2.getRelease());
//       }
//    }
 
}