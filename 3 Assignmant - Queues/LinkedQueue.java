@SuppressWarnings("unchecked")
public class LinkedQueue<T> implements Queue<T>{

   private Node head;
   private int size;
   private Node tail;

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

      public LinkedQueue(){
      head = null;
      size = 0;
      tail = null;
   }

   public T remove(){
      if (size == 0) {
         throw new UnsupportedOperationException();
      }
      //@SuppressWarnings("unchecked")
      T temp = (T)head.getdata();
      head = head.getNextNode();
      size--;
      //System.out.println("remove data:" + temp);
      return temp;
   }

   public T peek(){
      if (size == 0) {
         throw new UnsupportedOperationException();
      }
      //@SuppressWarnings("unchecked")
      T temp = (T)head.getdata();
      //System.out.println("peek data:" + temp);
      return temp;
   }

   public void add(T thing){
      //@SuppressWarnings("unchecked")
      Node newNode = new Node(thing, null);
      if(size==0){
         tail = newNode;
         head = newNode;
      } else {
         tail.setNextNode(newNode);
         tail = newNode;
      }
      size++;
   }

   //checks if size == 0. If so, there is nothing in the stack, so the
   //list must be empty and it returns true, otherwise, returns false.
   public boolean isEmpty(){
      return (size==0);
   }
}
