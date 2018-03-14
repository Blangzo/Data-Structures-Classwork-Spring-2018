/*
javac -classpath hamcrest-core-1.3.jar;.;junit-4.12.jar MergeSorter.java InsertionSorter.java SelectionSorter.java IntSorter.java ArrayTest.java

java -cp junit-4.12.jar;.;hamcrest-core-1.3.jar org.junit.runner.JUnitCore ArrayTest
*/
import static org.junit.Assert.*;
import org.junit.Test;

public class ArrayTest {

  public static int[] createArray(int size) {
    int[] result = new int[size];
    for (int i = 0; i < result.length; i++) {
      result[i] = (int)(Math.random() * 1000);
    }
    return result;
  }

  public static boolean isSorted(int[] array) {
    for (int i = 1; i < array.length; i++) {
      if (array[i - 1] > array[i]) {
        return false;
      }
    }
    return true;
  }

  @Test
  public void testSort() {
    int[] array = createArray(100);
    //int[] array = {0,1,-2,3,-4,5,6,7,-1};
    System.out.println("InsertionSorter");
    InsertionSorter sorter = new InsertionSorter();
    sorter.init(array);
    System.out.println("beforesort");
    sorter.sort();
    System.out.println("\nMoves: " + sorter.getMoves());
    assertTrue(isSorted(array));
    System.out.println("Time: " + sorter.getSortTime());
    System.out.println("testpassed");
    //******************************************
    int[] array2 = createArray(100);
    //int[] array2 = {0,1,-2,3,4,5,6,7,-1};
    System.out.println("\nSelectionSorter");
    SelectionSorter sorter2 = new SelectionSorter();
    sorter2.init(array2);
    System.out.println("beforesort");
    sorter2.sort();
    System.out.println("\nMoves: " + sorter2.getMoves());
    assertTrue(isSorted(array2));
    System.out.println("Time: " + sorter2.getSortTime());
    System.out.println("testpassed");
    //******************************************
    int[] array3 = createArray(100);
    //int[] array3 = {0,1,-2,3,4,5,6,7,-1};
    System.out.println("\nMergeSorter");
    MergeSorter sorter3 = new MergeSorter();
    sorter3.init(array3);
    System.out.println("beforesort");
    sorter3.sort();
    System.out.println("\nMoves: " + sorter3.getMoves());
    assertTrue(isSorted(array3));
    System.out.println("Time: " + sorter3.getSortTime());
    System.out.println("testpassed");
  }
}
