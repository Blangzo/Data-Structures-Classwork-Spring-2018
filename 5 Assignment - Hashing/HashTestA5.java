/*
javac ProductRecord.java Student.java StudentHashSet.java HashTestA5.java

java HashTestA5
piece of trash made by wesley ho
*/
import java.util.*;
public class HashTestA5 {

   public static void main(String[] args) {
      System.out.println("Test class for Assignment 5 cs445 prof James spring '18 begin'");
      testPR();
      testS();
      testSs();
      System.out.println("Test class for Assignment 5 cs445 prof James spring '18 end'");
   }

   static void testPR() {
      System.out.println("ProductRecord Test Begin");
      //tests that hashcode is same every time (repeatable)
      int ahashcode, price, cc, sc, mc, pc;
      ProductRecord a, b;
      String randS;
      for(int i=0; i<10000; i++){
         price = (int)(Math.random() * 1000000000);
         cc = (int)(Math.random() * 22 + 10000);
         sc = (int)(Math.random() * 3 + 10);
         pc = (int)(Math.random() * 21 + 500);
         mc = (int)(Math.random() * 5);
         randS = randomString(100);
         for(int k=0; k<100; k++){
            a = new ProductRecord(randS, price, cc, sc, pc, mc);
            b = new ProductRecord(randS, price, cc, sc, pc, mc);
            if(a.hashCode() != b.hashCode())
               System.out.println("Hashcode not repeatable");
         }
      }
      //tests that hashcode is unique (few collisions)
      //at 1000000 (1 mil) objects, has ~100-130 collisions
      //these collisions likely due to the same ProductRecord being created
      //at 100000 (100k) objects, has ~0-4 collisions
      Set<Integer> set = new HashSet<Integer>();
      int collisions = 0, numT = 10000;
      for(int i=0; i<numT; i++){
         price = (int)(Math.random() * 1000000000);
         cc = (int)(Math.random() * 22 + 10000);
         sc = (int)(Math.random() * 3 + 10);
         pc = (int)(Math.random() * 21 + 500);
         mc = (int)(Math.random() * 5);
         randS = randomString(100);
         a = new ProductRecord(randS, price, cc, sc, pc, mc);
         if(set.contains(a.hashCode())) collisions++;
         else set.add(a.hashCode());
      }
      System.out.println("Number of collisions over " + numT + " ProductRecords:" + collisions);
      System.out.println("ProductRecord Test End");
   }

   static void testS() {
      System.out.println("Student Test Begin");
      //tests that hashcode is same every time (repeatable)
      int ahashcode, in;
      Student a, b;
      String fn, ln;
      for(int i=0; i<10000; i++){
         in = (int)(Math.random() * 1000000000);
         fn = randomString(100);
         ln = randomString(100);
         for(int k=0; k<100; k++){
            a = new Student(fn, ln, in);
            b = new Student(fn, ln, in);
            if(a.hashCode() != b.hashCode())
               System.out.println("Hashcode not repeatable");
         }
      }
      //tests that hashcode is unique (few collisions)
      //at 1000000 (1 mil) objects, has ~100-130 collisions
      //these collisions likely due to the same ProductRecord being created
      //at 100000 (100k) objects, has ~0-4 collisions
      Set<Integer> set = new HashSet<Integer>();
      int collisions = 0, numT = 10000;
      for(int i=0; i<numT; i++){
         in = (int)(Math.random() * 1000000000);
         fn = randomString(100);
         ln = randomString(100);
         a = new Student(fn, ln, in);
         if(set.contains(a.hashCode())) collisions++;
         else set.add(a.hashCode());
      }
      System.out.println("Number of collisions over " + numT + " ProductRecords:" + collisions);
      System.out.println("Student Test End");
   }

   static void testSs() {
      System.out.println("Student Set Test Begin");
      StudentHashSet s1, s2, s3;
      Student a1, b1, c1 = null, c2 = null;
      int temp;
      s1 = new StudentHashSet();
      s2 = new StudentHashSet(24);
      a1 = new Student("Wesley", "Ho", 728);
      b1 = new Student("Ryan", "Pavone", 723);
      s1.add(a1);
      s1.add(b1);
      s2.add(a1);
      s2.add(b1);
      if(!s1.contains(a1)) {System.out.println("Error1");}
      if(!s1.contains(b1)) {System.out.println("Error2");}
      if(!s2.contains(a1)) {System.out.println("Error3");}
      if(!s2.contains(b1)) {System.out.println("Error4");}
      for(int i=0; i<10000; i++) {
         temp = (int)(Math.random() * 1001);
         c1 = new Student(randomString(10), randomString(10), temp);
         temp = (int)(Math.random() * 1001);
         c2 = new Student(randomString(10), randomString(10), temp);
         s1.add(c1);
         s1.add(c2);
         s2.add(c1);
         s2.add(c2);
      }
      if(!s1.contains(a1)) {System.out.println("Error5");}
      if(!s1.contains(b1)) {System.out.println("Error6");}
      if(!s2.contains(a1)) {System.out.println("Error7");}
      if(!s2.contains(b1)) {System.out.println("Error8");}
      s1.remove(a1);
      s1.remove(b1);
      s2.remove(a1);
      s2.remove(b1);
      if(s1.contains(a1)) {System.out.println("Error9");}
      if(s1.contains(b1)) {System.out.println("Error10");}
      if(s2.contains(a1)) {System.out.println("Error12");}
      if(s2.contains(b1)) {System.out.println("Error13");}

      if(!s1.contains(c1)) {System.out.println("Error14");}
      if(!s1.contains(c2)) {System.out.println("Error15");}
      if(!s2.contains(c1)) {System.out.println("Error16");}
      if(!s2.contains(c2)) {System.out.println("Error17");}
      s1.remove(c1);
      s1.remove(c2);
      s2.remove(c1);
      s2.remove(c2);
      if(s1.contains(c1)) {System.out.println("Error18");}
      if(s1.contains(c2)) {System.out.println("Error19");}
      if(s2.contains(c1)) {System.out.println("Error20");}
      if(s2.contains(c2)) {System.out.println("Error21");}
      //assert(s1.contains(a1), true);
      //assert(s1.contains(b1), true);
      System.out.println("Student Set Test Passed");
   }

   static String randomString(int len) {
      StringBuilder sb = new StringBuilder(len);
      int temp;
      String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
      for(int i=0; i<len; i++){
         temp = (int)(Math.random() * 52);
         sb.append(alphabet.charAt(temp));
      }
      return sb.toString();
   }
}
