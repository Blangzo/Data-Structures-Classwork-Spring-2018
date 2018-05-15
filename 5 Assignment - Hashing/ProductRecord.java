public class ProductRecord {

   private String name;
   private double price;
   private int colorCode;
   private int styleCode;
   private int materialCode;
   private int patternCode;

   //constructor
   public ProductRecord(String name, double price, int colorCode, int styleCode, int materialCode, int patternCode) {
      this.name = name;
      this.price = price;
      this.colorCode = validateRange(colorCode, 10000, 10021);
      this.styleCode = validateRange(styleCode, 10, 12);
      this.materialCode = validateRange(materialCode, 500, 520);
      this.patternCode = validateRange(patternCode, 0, 4);
   }
   //checks to make sure that the input code is between given lower and upper
   //throws IllegalArgumentException if code is not between bounds
   private int validateRange(int value, int lower, int upper) {
      if (value < lower || value > upper) {
         throw new IllegalArgumentException("Value should be between " + lower + " and " + upper + ".");
      }
      return value;
   }
   //Sets price of object
   public void setPrice(double price) {this.price = price;}
   //getters for individual variables
   public String getName() {return name;}
   public double getPrice() {return price;}
   public int getColorCode() {return colorCode;}
   public int getStyleCode() {return styleCode;}
   public int getMaterialCode() {return materialCode;}
   public int getPatternCode() {return patternCode;}
   //creates and returns hashcode
   public int hashCode() {
      String s = this.getStringOfSix();
      return s.hashCode();
   }

   //get string of the 6 variables
   public String getStringOfSix() {
      String sprice = Double.toString(price);
      //length of name and price are the only lengths that can vary
      int ln = name.length() + sprice.length() + 5 + 2 + 3 + 4;
      StringBuilder sb = new StringBuilder(ln);
      sb.append(name);
      sb.append(sprice);
      sb.append(colorCode);
      sb.append(styleCode);
      sb.append(materialCode);
      sb.append(patternCode);
      return sb.toString();
   }
}
