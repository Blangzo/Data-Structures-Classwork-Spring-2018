public class StudentHashSet {
   //private variables
   private final double lf = .5;
   private Student[] arr;
   private int size;
   //constructor
   public StudentHashSet(){
      arr = new Student[11];
      size = 0;
   }
   //second constructor
   public StudentHashSet(int length){
      arr = new Student[length];
      size = 0;
   }
   //adds a student obj to the array using hashcodes and a linear resolution
   //strategy for collisions
   public void add(Student s) {
      int temp = s.hashCode() % arr.length;
      temp = Math.abs(temp);
      // Student testvar;
      // try{
      //    testvar = arr[temp];
      //    System.out.println(testvar);
      //    if(arr[temp] != null) {
      //       System.out.println("work54398");
      //    }
      // } catch (ArrayIndexOutOfBoundsException e) {
      //    System.out.println(e);
      //    System.out.println("add - temp: " + temp + " length: " +
      //       arr.length + " size: " + size);
      // }
      try{
         while(arr[temp] != null) {
            if(arr[temp] == s) {break;}//checks that s isn't already in set
            //if s is in set, breaks while ends add after checklf
            temp++;
            if(arr.length <= temp) {
               temp = 0;
            }//loops
         }
      } catch (ArrayIndexOutOfBoundsException e) {
         System.out.println(e);
         System.out.println("add - temp: " + temp + " length: " +
             arr.length + " size: " + size);
         System.out.println(arr.length < temp);
         }
      if(arr[temp] != s) { //only incrases size if s not in set
         arr[temp] = s;
         size++;
      }
      checklf();
   }
   //removes a student obj from the array
   public boolean remove(Student s) {
      int temp = s.hashCode() % arr.length;
      temp = Math.abs(temp);
      System.out.println("Remove - temp: " + temp + " size: " + size);
      while(arr[temp] != null){
         if(arr[temp] == s){
            arr[temp] = null;
            shiftup(temp+1); //must also check objects from temp to next null to
            //see if they must be moved
            return true;
         }
         temp++;
         if(arr.length < temp) {temp=0;}
      }
      return false;
   }
   //checks if it cotains a certain student obj
   public boolean contains(Student s) {
      int temp = s.hashCode() % arr.length;
      temp = Math.abs(temp);
      System.out.println("Contains - temp: " + temp + " size: " + size);
      while(arr[temp] != null) { //checks from temp to next null
         if(arr[temp] == s) {
            return true;
         }
         temp++;
      }
      return false;
   }
   //returs size of set
   public int size() {return size;}
   //checks load factor and changes size of array if necessary
   public void checklf() {
      double temp = (double)size / arr.length;
      if(temp > lf){
         increasecapacity();
      }
   }
   //increases capacity of array
   public void increasecapacity() {
      System.out.println("IC - length: " + arr.length + " size: " + size);
      int temp2 = (2*arr.length)+1;
      int temp;
      Student[] temps = new Student[temp2];
      for(Student s : arr){
         if(s != null) {
            temp = s.hashCode() % temp2;
            temp = Math.abs(temp);
            while(temps[temp] != null){
               temp++;
               if(temps.length <= temp){
                  temp = 0;
               }
            }
            temps[temp] = s;
         }
      }
      arr = temps;
   }
   //must also check objects after a removed object to see if they must be
   //placed somewhere necessary
   public void shiftup(int initial) {
      while(arr[initial] != null) {
         this.add(arr[initial]);
         if(initial != (arr[initial].hashCode() % arr.length)){
            arr[initial] = null  ;
         }
         initial++;
      }
   }
}
