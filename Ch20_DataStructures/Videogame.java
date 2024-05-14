import java.util.*;

public class Videogame implements Comparable<Videogame>
{
   //data fields
   private String title, series, platform, developer, publisher;
   private GregorianCalendar release;
   private int sales;
   
   public Videogame( String title, int sales, String release )
   {
      this.title = title;
      this.sales = sales;
      setDate( release );
   }
   
   public int getSales(){ return this.sales; }
   public String getTitle(){ return this.title; }
   public GregorianCalendar getRelease(){ return this.release; }   
   
   public void setDate( String date )
   {
      String[] data = date.split("-");
      
      int year, month, day;
      day = Integer.parseInt(data[0]);
      
      switch( data[1].toLowerCase() )
      {
         case "jan": month = 0; break;
         case "feb": month = 1; break;
         case "mar": month = 2; break;
         case "apr": month = 3; break;
         case "may": month = 4; break;
         case "jun": month = 5; break;
         case "jul": month = 6; break;
         case "aug": month = 7; break;
         case "sep": month = 8; break;
         case "oct": month = 9; break;
         case "nov": month = 10; break;
         default: month = 11; break;
      }
      
      year = Integer.parseInt(data[2]);
      
      if( year >= 58 )         //first videogame released in 1958
         year += 1900;
      else
         year += 2000;
      
      release = new GregorianCalendar(year, month, day);
   }
   
   private String getFormattedDate()
   {
      return release.get(Calendar.MONTH) + "/" + release.get(Calendar.DAY_OF_MONTH) + 
         "/" + release.get(Calendar.YEAR);
   }
   
   @Override
   public int compareTo(Videogame v)      //inherited from Comparable interface
   {
      return this.sales-v.getSales();
      //return this.title.compareTo(v.getTitle());       //v1.compareTo(v2)   
   }
   
   @Override
   public String toString()            //inherited from Object class
   {
      return "Title: " + this.title + "\nSales: " + this.sales 
         + "\nRelease Date: " + getFormattedDate();
   }
}