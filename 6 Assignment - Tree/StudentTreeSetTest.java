/*
javac Student.java StudentTreeSet.java StudentTreeSetTest.java
java StudentTreeSetTest
*/

public class StudentTreeSetTest {
   public static void main(String[] args) {
      test1();
      test2();
   }

   public static void test1() {
      StudentTreeSet tree = new StudentTreeSet();
      Student a = new Student("a", "a", 50);
      Student b = new Student("b", "b", 30);
      Student c = new Student("c", "c", 20);
      Student d = new Student("d", "d", 40);
      Student e = new Student("e", "e", 70);
      Student f = new Student("f", "f", 60);
      Student g = new Student("g", "g", 80);
      Student h = new Student("h", "h", 55);
      Student i = new Student("i", "i", 54);
      Student j = new Student("j", "j", 53);

      tree.add(a);
      tree.add(b);
      tree.add(c);
      tree.add(d);
      tree.add(e);
      //tree.add(f);
      tree.add(g);

      System.out.println("1: " + tree.size()); //6
      System.out.println("2: " + tree.remove(f)); //false
      System.out.println("3: " + tree.contains(f)); //false
      System.out.println("22: " + tree.size()); //6
      tree.add(f); //nothing
      System.out.println("23: " + tree.size()); //7
      System.out.println("4: " + tree.contains(f)); //true
      System.out.println("5: " + tree.remove(f)); //true
      System.out.println("6: " + tree.contains(f)); //false
      System.out.println("7: " + tree.contains(a)); //true
      System.out.println("8: " + tree.contains(b)); //true
      System.out.println("9: " + tree.contains(c)); //true
      System.out.println("10: " + tree.contains(d)); //true
      System.out.println("11: " + tree.contains(e)); //true
      System.out.println("12: " + tree.contains(g)); //true
      System.out.println("24: " + tree.size()); //6
      System.out.println("13: " + tree.remove(f)); //false
      System.out.println("1: " + tree.size()); //6
      System.out.println("14: " + tree.remove(f)); //false
      System.out.println("25: " + tree.size()); //6
      tree.add(f);
      System.out.println("26: " + tree.size()); //7
      tree.add(f);
      tree.add(f);
      tree.add(f);
      tree.add(f);
      tree.add(f);
      tree.add(f);
      tree.add(f);
      System.out.println("21:" + tree.size()); //7
      System.out.println("15: " + tree.remove(f)); //true
      System.out.println("27: " + tree.size()); //6
      System.out.println("16: " + tree.remove(f)); //false
      tree.add(f);
      System.out.println("17: " + tree.remove(f)); //true
      System.out.println("18: " + tree.remove(f)); //false
      System.out.println("19: " + tree.contains(f)); //false
      System.out.println("20: " + tree.remove(f)); //false

      tree.add(f);
      tree.add(h);
      System.out.println("28: " + tree.remove(h));
      tree.add(h);
      System.out.println("29: " + tree.remove(f));

      tree.add(h);
      tree.add(f);
      tree.add(i);
      System.out.println("30: " + tree.remove(f)); //true
      tree.add(f);
      System.out.println("31: " + tree.remove(i)); //true
      tree.add(i);
      System.out.println("33: " + tree.contains(f)); //true
      System.out.println("34: " + tree.contains(i)); //true
      System.out.println("35: " + tree.contains(h)); //true
      tree.add(j);
      System.out.println("32: " + tree.remove(j));
      System.out.println("35: " + tree.remove(h)); //true
   }

   public static void test2() {
      System.out.println("start test2");
      StudentTreeSet tree = new StudentTreeSet();
      Student a = new Student("a", "a", 2);
      Student b = new Student("b", "b", 3);
      Student c = new Student("c", "c", 4);
      Student d = new Student("d", "d", 5);
      Student e = new Student("e", "e", 6);
      Student f = new Student("f", "f", 7);
      Student g = new Student("g", "g", 8);
      Student h = new Student("h", "h", 9);
      Student i = new Student("i", "i", 10);
      Student j = new Student("j", "j", 11);
      Student k = new Student("k", "k", 12);
      Student l = new Student("l", "l", 13);
      Student m = new Student("m", "m", 14);
      Student n = new Student("n", "n", 15);
      Student o = new Student("o", "o", 16);
      Student p = new Student("p", "p", 17);
      Student q = new Student("q", "q", 18);
      Student r = new Student("r", "r", 19);
      System.out.println("Created student objs test2");
      tree.add(a);
      tree.add(b);
      tree.add(c);
      tree.add(d);
      tree.add(e);
      tree.add(f);
      tree.add(g);
      tree.add(h);
      tree.add(i);
      tree.add(j);
      tree.add(k);
      tree.add(l);
      tree.add(m);
      tree.add(n);
      tree.add(o);
      tree.add(p);
      tree.add(q);
      tree.add(r);
      System.out.println("added student objs test2");
      System.out.println("t1 " + tree.remove(e));
      System.out.println("passre");
      System.out.println(tree.remove(f));
      System.out.println("passr1");
      System.out.println(tree.contains(f));
      System.out.println("passc1");
      System.out.println(tree.contains(e));
      System.out.println("passc2");
      System.out.println(tree.remove(e));
      System.out.println("passr2");
      System.out.println(tree.contains(e));
      System.out.println("passc3");
   }
}
