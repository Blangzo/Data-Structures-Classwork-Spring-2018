
public class ArrayStack<T> implements Stack<T>{

   private int size;
   private T[] arr;
   private T temp;

   //constructor
   public ArrayStack(){
      size=0;
      @SuppressWarnings("unchecked")
      T[] temparr = (T[]) new Object[10];
      arr = temparr;
   }

   public T pop(){
      if (size==0){
         throw new UnsupportedOperationException();
      }
      size--;
      return arr[size];
   }

   public T peek(){
      if (size == 0) {
         throw new UnsupportedOperationException();
      }
      return arr[size-1];
   }

   public void push(T thing){
      if(size+1 >= arr.length){
         this.increasecapacity();
      }
      arr[size] = thing;
      size++;
   }

   public void increasecapacity(){
		int temp2 = 2*arr.length;
      @SuppressWarnings("unchecked")
		T[] temparr = (T[]) new Object[temp2];
		System.arraycopy(arr, 0, temparr, 0, size);
		arr = temparr;
	}

   public boolean isEmpty(){
      if (size == 0) return true;
      else return false;
   }
}
