/*
javac -classpath hamcrest-core-1.3.jar;.;junit-4.12.jar MaxHeap.java ArrayTest.java

java -cp junit-4.12.jar;.;hamcrest-core-1.3.jar org.junit.runner.JUnitCore ArrayTest
*/
import static org.junit.Assert.*;
import org.junit.Test;

public class ArrayTest {

  public static long[] createArray(int size) {
    long[] result = new long[size];
    for (int i = 0; i < result.length; i++) {
      result[i] = (int)(Math.random() * 1000);
    }
    return result;
  }

  public static boolean isSorted(long[] array) {
    for (int i = 1; i < array.length; i++) {
      if (array[i - 1] > array[i]) {
        return false;
      }
    }
    return true;
  }

  @Test
  public void testSort() {
    long[] array = createArray(100);
    //int[] array = {0,1,-2,3,-4,5,6,7,-1};
    System.out.println("MaxHeap");
    System.out.println("beforesort");
    for(long i : array) {
      System.out.print(i + " ");
    }
    MaxHeap.heapsort(array);
    System.out.println("aftersort");
    for(long i : array) {
      System.out.print(i + " ");
    }
    assertTrue(isSorted(array));
    System.out.println("testpassed");
  }
}
