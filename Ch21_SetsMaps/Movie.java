public class Movie
{
   //data field
   private String title, rating;
   private int length;           //length in minutes
   
   public Movie(String t, String r, int l)
   {
      this.title = t;
      this.rating = r;
      this.length = l;
   }
   
   @Override
   public boolean equals( Object m )
   {
      return this.hashCode() == m.hashCode();
   }
   
   @Override
   public int hashCode()
   {
      int code = this.title.hashCode()+this.rating.hashCode()
         + Integer.hashCode(length);
         
      return code;
   }
}