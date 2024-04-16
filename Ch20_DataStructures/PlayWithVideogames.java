import java.io.*;
import java.util.*;

public class PlayWithVideogames
{
   public static void main(String[] args)
   {
      ArrayList<Videogame> list = readData("VideogameData/DataSheetVideogames.csv");
      list.sort( new TitleComparator() );
      // Collections.sort(list);
      
      if( list != null )
         for( Videogame v : list )
            System.out.println(v + "\n");
      
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
         return v1.getTitle().compareTo( v2.getTitle() );
      }
   }
   
   static class SalesComparator implements Comparator<Videogame>
   {
      @Override
      public int compare(Videogame v1, Videogame v2)
      {
         return v1.getSales()-v2.getSales();
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