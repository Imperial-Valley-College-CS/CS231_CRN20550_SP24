public class Position
{
   private int x, y;
   private int width, height;
   
   public Position( int x, int y, int width, int height )
   {
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
   }
   
   public void setX( int x )
   { 
      this.x = x;
   }
   
   public void setY( int y )
   { 
      this.y = y;
   }
   
   public int getX(){ return this.x; }
   public int getY(){ return this.y; }
   public int getDomain(){ return this.x + this.width; }
   public int getRange(){ return this.y + this.height; }
   
   public boolean collision( Position object )
   {
      if( object.getX() > this.x && object.getX() < getDomain() )
         if(  object.getY() > this.y && object.getY() < getRange() )
            return true;
         
      return false;
   }
}