@SuppressWarnings("unchecked")
public class ArrayQueue<T> implements Queue<T>{

   private int front, back, size;
   private T[] arr;
   private T temp;

   //constructor
   public ArrayQueue(){
      size=0;
      front=0;
      back=0;
      T[] temparr = (T[]) new Object[10];
      arr = temparr;
   }

   public T remove(){
      if (size==0){
         throw new UnsupportedOperationException();
      }
      front++;
      size--;
      this.checkcapacity();
      return arr[front-1];
   }

   public T peek(){
      if (size == 0) {
         throw new UnsupportedOperationException();
      }
      return arr[front];
   }

   public void add(T thing){
      this.checkcapacity();
      arr[back] = thing;
      size++;
      if (back+1 < arr.length){
         back++;
      }  else {
         back=0;
      }
   }

   public void checkcapacity(){
      if((front == back) && (size!=0)){
         this.increasecapacity();
      }
   }

   public void increasecapacity(){
		int temp2 = 3*(arr.length+1);
		T[] temparr = (T[]) new Object[temp2];
		System.arraycopy(arr, front, temparr, 0, size);
      System.arraycopy(arr, 0, temparr, front, size-front);
		arr = temparr;
	}

   public boolean isEmpty(){
      return (size==0);
   }
}
