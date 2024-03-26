public class Car implements Comparable<Car>
{
   private String make, model;
   private int year;
   
   public Car( String make, String model, int year )
   {
      this.make = make;
      this.model = model;
      this.year = year;
   }
   
   public void setMake( String make )
   {
      this.make = make;
   }
   public void setModel( String model )
   {
      this.model = model;
   }
   public void setYear( int year )
   {
      this.year = year;
   }
   
   public String getMake(){ return this.make; }
   public String getModel(){ return this.model; }
   public int getYear(){ return this.year; }
   
//    @Override //compare Make
//    public int compareTo( Car car )
//    {
//       return this.make.compareToIgnoreCase(car.getMake());   
//    }
//    
   // @Override //compare Model
//    public int compareTo( Car car )
//    {
//       return this.model.compareToIgnoreCase(car.getModel());   
//    }
   
   @Override //compare Year
   public int compareTo( Car car )
   {
      return this.year - car.getYear();   
   }
   
   @Override
   public String toString()
   {
      return "Make: " + this.make + "\nModel: " + this.model + 
         "\nYear: " + this.year;
   }
}