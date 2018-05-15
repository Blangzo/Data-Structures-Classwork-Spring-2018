/*
javac MaxHeap.java ArrayTestNojunit.java

java ArrayTestNojunit
*/
public class ArrayTestNojunit{

   public static final int nanos = 1000000000;

   public static void main(String[] args){
      double davg=0, average=0, total;
      total=0;
      int qwert=100;
      for(int i=0; i<=qwert; i++){
         total += (double)SelectionSortTest()/ nanos;
      }
      average = total/qwert;
      System.out.println(average);
      average *= nanos;
      System.out.println("Average time for Insertion Sorter: " + average);
      davg = average / nanos;
      System.out.println("Average seconds for Insertion Sorter: " + davg);

      total = 0;
      for(int i=0; i<qwert; i++){
         total += (double)InsertionSortTest()/ nanos;
      }
      average = total/qwert;
      average *= nanos;
      System.out.println("Average time for Selection Sorter: " + average);
      davg = average/ nanos;
      System.out.println("Average seconds for Selection Sorter: " + davg);

      total = 0;
      for(int i=0; i<qwert; i++){
         total += (double)MergeSortTest()/ nanos;
      }
      average = total/qwert;
      average *= nanos;
      System.out.println("Average time for Merge Sorter: " + average);
      davg = average / nanos;
      System.out.println("Average seconds for Merge Sorter: " + davg);
   }

   static int arraylength = 10000;
   public static long InsertionSortTest(){
      int[] array = createArray(arraylength);
      //int[] array = {0,1,-2,3,-4,5,6,7,-1};
      //System.out.println("InsertionSorter");
      InsertionSorter sorter = new InsertionSorter();
      sorter.init(array);
      //System.out.println("beforesort");
      sorter.sort();
      //System.out.println("\nMoves: " + sorter.getMoves());
      //assertTrue(isSorted(array));
      //System.out.println("Time: " + sorter.getSortTime());
      //System.out.println("testpassed");
      return sorter.getSortTime();
  }

  public static long SelectionSortTest(){
     int[] array = createArray(arraylength);
     //int[] array = {0,1,-2,3,-4,5,6,7,-1};
     //System.out.println("InsertionSorter");
     SelectionSorter sorter = new SelectionSorter();
     sorter.init(array);
     //System.out.println("beforesort");
     sorter.sort();
     //System.out.println("\nMoves: " + sorter.getMoves());
     //assertTrue(isSorted(array));
     //System.out.println("Time: " + sorter.getSortTime());
     //System.out.println("testpassed");
     return sorter.getSortTime();
  }

  public static long MergeSortTest(){
     int[] array = createArray(arraylength);
     //int[] array = {0,1,-2,3,-4,5,6,7,-1};
     //System.out.println("InsertionSorter");
     MergeSorter sorter = new MergeSorter();
     sorter.init(array);
     //System.out.println("beforesort");
     sorter.sort();
     //System.out.println("\nMoves: " + sorter.getMoves());
     //assertTrue(isSorted(array));
     //System.out.println("Time: " + sorter.getSortTime());
     //System.out.println("testpassed");
     return sorter.getSortTime();
  }

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
}
