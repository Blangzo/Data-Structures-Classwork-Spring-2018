
public class LinkedStack<T> implements Stack<T>{

   private Node head;
   private int size;

   private class Node<T>{

      public T data;
      public Node nextNode;

      public Node(T thing2){
         data = thing2;
         nextNode = null;
      }

      public Node(T thing2, Node nNode){
         data = thing2;
         nextNode = nNode;
      }

      public void setNextNode(Node sNode){
         nextNode = sNode;
      }

      public Node getNextNode(){
         return nextNode;
      }

      public T getdata(){
         return data;
      }
   }

   public LinkedStack(){
      head = null;
      size = 0;
   }

   public T pop(){
      if (size == 0) {
         throw new UnsupportedOperationException();
      }
      @SuppressWarnings("unchecked")
      T temp = (T)head.getdata();
      head = head.getNextNode();
      size--;
      return (T)temp;
   }

   public T peek(){
      if (size == 0) {
         throw new UnsupportedOperationException();
      }
      @SuppressWarnings("unchecked")
      T temp = (T)head.getdata();
      return temp;
   }

   public void push(T thing){
      @SuppressWarnings("unchecked")
      Node newNode = new Node(thing, head);
      head = newNode;
      size++;
   }

   //checks if size == 0. If so, there is nothing in the stack, so the
   //list must be empty and it returns true, otherwise, returns false.
   public boolean isEmpty(){
      return (size==0);
   }
}
