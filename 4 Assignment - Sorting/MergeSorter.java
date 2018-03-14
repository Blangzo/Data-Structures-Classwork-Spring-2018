public class MergeSorter implements IntSorter {

   public long sortTime;
   public int moves;
   public int[] arr;
   public int[] arr2;

   //Initializes class, reset # of moves, and performs necessary setup
   public void init(int[] a){
      arr = a;
      moves = 0;
      sortTime = 0;
   }

   //sorts values from initial array
   public void sort(){
      long begin = System.nanoTime();
      arr2 = mergesort(arr); //sorts initial array and returns sorted array
      for(int i=0; i<arr.length; i++){ //puts sorted array back in initial array
         arr[i] = arr2[i];
         moves++;
      }
      long end = System.nanoTime();
      sortTime = end - begin;
   }

   //the recursive part
   public int[] mergesort(int[] a2){
      if (a2.length <=1){ //base case to end recursion
         return a2;
      }

      int[] left = new int[a2.length/2]; //first half of array
      int[] right = new int[(a2.length+1)/2]; //second half of array.
      //a2.length+1 is necessary because otherwise with odd numbers,
      //integer division would truncate the number meaning the
      //right array would not be long enough to cover the entire inital array
      for(int i=0; i<left.length; i++){
         left[i] = a2[i];
         moves++;
      }
      for(int k=0; k<right.length; k++){
         right[k] =  a2[k+a2.length/2];
         moves++;
      }

      left = mergesort(left);
      right = mergesort(right);

      return merge(left, right);
   }

   public int[] merge(int[] left, int[] right){
      int[] result = new int[left.length + right.length];
      int leftv = 0;
      int rightv =  0;
      int resultv = 0;
      //left and right are assumed to be sorted
      //sorted into one array
      while(leftv < left.length && rightv < right.length){
         if(left[leftv] <= right[rightv]){
            result[resultv] = left[leftv];
            leftv++;
            resultv++;
            moves++;
         } else{
            result[resultv] = right[rightv];
            rightv++;
            resultv++;
            moves++;
         }
      }
      //remaining integers are put into the array
      while(leftv < left.length){
         result[resultv] = left[leftv];
         leftv++;
         resultv++;
         moves++;
      }
      while(rightv < right.length){
         result[resultv] = right[rightv];
         rightv++;
         resultv++;
         moves++;
      }
      return result;
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
