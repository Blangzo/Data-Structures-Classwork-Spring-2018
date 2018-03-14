public class InsertionSorter implements IntSorter {

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
      for(int i=1; i < arr.length; i++){
         for(int k=i; k>0 && arr[k] < arr[k-1]; k--){
            swap(k);
         }
      }
      long end = System.nanoTime();
      sortTime = end - begin;
   }

   private void swap(int k){
      int temp = arr[k-1];
      arr[k-1] = arr[k];
      arr[k] = temp;
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
