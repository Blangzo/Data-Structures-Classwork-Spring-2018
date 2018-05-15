public class MaxHeap {

   private static final int DEFAULT_CAPACITY = 20;
   private int nextPosition = 0;
   private long[] values;

   //constructor
   public MaxHeap() {
      values = new long[DEFAULT_CAPACITY];
   }

   //second constructor
   public MaxHeap(int initialCapacity) {
      values = new long[initialCapacity];
   }

   //third constructor
   public MaxHeap(long[] array) {
      this.values = array;
      for (int i = 1; i < values.length; i++) {
         reheapUp(i);
      }
      nextPosition = values.length;
   }

   //Implement this method
   //NOTE: since this method is static, you can instantiate a MaxHeap using the array parameter. Implement the heap sort algorithm. "array" should be sorted in place - i.e., don't create a copy.
   //creates a maxheap obj and for each element, removes
   public static void heapsort(long[] array) {
      MaxHeap heap = new MaxHeap(array);
      for (int i = 0; i < array.length; i++) {
         heap.remove();
      }
   }

   //Implement this:
   //swaps top element to back of array and shuffles down new top element
   public long remove() {
      swap(0, nextPosition-1);
      nextPosition--;
      reheapDown(0);
      return 0;
   }

   //checks if empty
   public boolean isEmpty() {
      return nextPosition == 0;
   }

   public void add(long value) {
      ensureCapacity();
      values[nextPosition] = value;
      reheapUp(nextPosition);
      nextPosition++;
   }

   public long getMax() {
      if (this.isEmpty()) {
         throw new UnsupportedOperationException("Heap is empty.");
      }
      return values[0];
   }

   private void reheapDown(int i) {
      int maxChild = getMaxChildIndex(i);
      if (maxChild > -1) {
         if (values[i] < values[maxChild]) {
            swap(i, maxChild);
            reheapDown(maxChild);
         }
      }
   }

   private void reheapUp(int i) {
      int parent = (i - 1) / 2;
      if (parent >= 0) {
         if (values[parent] < values[i]) {
            swap(i, parent);
            reheapUp(parent);
         }
      }
   }

   private void ensureCapacity() {
      if (nextPosition >= values.length) {
         long[] temp = new long[values.length * 2 + 1];
         System.arraycopy(values, 0, temp, 0, values.length);
         values = temp;
      }
   }

   private void swap(int a, int b) {
      long temp = values[a];
      values[a] = values[b];
      values[b] = temp;
   }

   private int getMaxChildIndex(int i) {
      int left = 2 * i + 1;
      if (left >= nextPosition) {
         return -1;
      } else {
         int right = 2 * i + 2;
         if (right >= nextPosition || values[left] > values[right]) {
            return left;
         } else {
            return right;
         }
      }
   }
}
