public class Videogame implements Comparable<Videogame>
{
   private String title;
   private int year;
   
   public Videogame( String title, int year )
   {
      this.title = title;
      this.year = year;
   }
   
   public int getYear(){ return this.year; }
   public String getTitle(){ return this.title; }
   
   @Override
   public int compareTo(Videogame v)      //inherited from Comparable interface
   {
      return this.title.compareTo(v.getTitle());       //v1.compareTo(v2)   
   }
   
   @Override
   public String toString()            //inherited from Object class
   {
      return "Title: " + this.title + "\nRelease Year: " + this.year;
   }
}