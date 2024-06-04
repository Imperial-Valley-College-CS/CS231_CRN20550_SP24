public class Block
{
   //data fields
   private int x, y;
   
   //constructor
   public Block(int x, int y)
   {
      this.x = x;
      this.y = y;
   }
   
   //method
   public int getX(){ return this.x; }
   public int getY(){ return this.y; }
   
   public void setX( int x )
   {
      this.x = x;
   }
   
   public void setY( int y )
   {
      this.y = y;
   }
}