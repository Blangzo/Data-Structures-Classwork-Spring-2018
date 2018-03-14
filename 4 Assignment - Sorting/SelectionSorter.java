public class SelectionSorter implements IntSorter {

   public long sortTime;
   public int moves;
   public int[] arr;

   //Initializes class, reset # of moves, and performs necessary setup
   public void init(int[] a){
      arr = a;
      moves = 0;
      sortTime = 0;
   }

   //sorts values from initial array
   public void sort(){
      long begin = System.nanoTime();
      int max;
      int temp = 0;
      for(int i = arr.length-1; i > 0; i--){
         max = 0;
         for(int k = 1; k <= i; k++){
            if(arr[k] > arr[max]){
               max = k;
            }
         }
         swap(max, i);
      }
      long end = System.nanoTime();
      sortTime = end - begin;
   }

   private void swap(int max, int i){
      int temp = arr[max];
      arr[max] = arr[i];
      arr[i] = temp;
      moves++;
   }

   //Returns the number of moves made while sorting
   public int getMoves(){
      return moves;
   }

   //returns the number of nanoseconds it took to perform the sort
   public long getSortTime(){
      return sortTime;
   }
}
