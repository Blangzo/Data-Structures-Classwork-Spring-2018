public class Student {
   //private variables
   private String firstName;
   private String lastName;
   private int idNumber;
   //constructor
   public Student(String firstName, String lastName, int idNumber) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.idNumber = idNumber;
   }
   //getters
   public String getFullName() {return firstName + " " + lastName;}
   public int getIdNumber() {return idNumber;}
   //setters
   public void setFirstName(String firstName) {this.firstName = firstName;}
   public void setLastName(String lastName) {this.lastName = lastName;}
   //creates and returns hashcode
   public int hashCode() {
      String s = this.getStringOfThree();
      return s.hashCode();
   }
   //get string of the 3 variables
   public String getStringOfThree() {
      String sid = Integer.toString(idNumber);
      //length of name and price are the only lengths that can vary
      int ln = firstName.length() + lastName.length() + sid.length();
      StringBuilder sb = new StringBuilder(ln);
      sb.append(firstName);
      sb.append(lastName);
      sb.append(idNumber);
      return sb.toString();
   }
}
