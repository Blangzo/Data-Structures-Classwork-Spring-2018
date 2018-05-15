import java.util.Comparator;

public class StudentTreeSet {

   private int size;
   private TreeNode root;
   private StudentComparator comparator = new StudentComparator();

   //returns size of tree which is stored in tree object
   public int size() {
      return size;
   }

   //adds a student to the tree
   public void add(Student value) {
      if (value == null) {
         throw new UnsupportedOperationException("Can't add null student.");
      }
      if (root == null) {
         root = new TreeNode(value);
         size++;
      } else {
         add(value, root);
      }
   }

   //checks if the tree contains a student value
   public boolean contains(Student value) {
      if (value == null) {
         return false;
      }
      return contains(value, root);
   }

   //helper method to conrains method
   private boolean contains(Student value, TreeNode node) {
      if (node != null) {
         int c = comparator.compare(value, node.value);
         if (c == 0) {
            return true;
         } else if (c < 0) {
            return contains(value, node.left);
         } else {
            return contains(value, node.right);
         }
      }
      return false;
   }

   //helper method to add method
   private void add(Student value, TreeNode node) {
      int c = comparator.compare(value, node.value);
      if (c == 0) {
         node.value = value;
      } else if (c < 0) {
         if (node.hasLeftChild()) {
            add(value, node.left);
         } else {
            node.left = addTreeNode(value);
         }
      } else {
         if (node.hasRightChild()) {
            add(value, node.right);
         } else {
            node.right = addTreeNode(value);
         }
      }
   }

   //creates and adds treenode with a given student value
   private TreeNode addTreeNode(Student value) {
      size++;
      return new TreeNode(value);
   }

   //treenode class holding leftchild node, rightchild node, and a student
   //value
   private class TreeNode {
      private TreeNode left;
      private TreeNode right;
      private Student value;

      public TreeNode(Student value) {
         this.value = value;
      }

      public boolean hasLeftChild() {
         return left != null;
      }

      public boolean hasRightChild() {
         return right != null;
      }

      public void removeLeftChild() {
         left = null;
      }

      public void removeRightChild() {
         right = null;
      }

      public int countChildren() {
         int result = 0;
         if (hasLeftChild()) {
            result++;
         }
         if (hasRightChild()) {
            result++;
         }
         return result;
      }
   }

   //compares alphabetically by last lastName
   //if last names are the same, compares alphabetically by first names
   //if first names are also the same, compares numerically by id number
   //uses helper methods bc I think the code looks cleaner this way rather than
   //nesting a bunch of if statements and I think its equally efficient
   //except the class file might take a few more bytes, but whatever
   private class StudentComparator implements Comparator<Student> {
      //method that will actually be called
      public int compare(Student left, Student right) {
         if(left == null && right == null) {
            return 0;
         } else if(left == null) {
            return -1;
         } else if(right == null) {
            return 1;
         }
         return this.checkLastName(left, right);
      }

      //helper method
      private int checkLastName(Student left, Student right) {
         int a = left.getLastName().compareToIgnoreCase(right.getLastName());
         if(a < 0) {
            return -1;
         } else if(a > 0) {
            return 1;
         } else {
            return this.checkFirstName(left, right);
         }
      }

      //helper method
      private int checkFirstName(Student left, Student right) {
         int a = left.getFirstName().compareToIgnoreCase(right.getFirstName());
         if(a < 0) {
            return -1;
         } else if(a > 0) {
            return 1;
         } else {
            return this.checkID(left, right);
         }
      }

      //helper method
      private int checkID(Student left, Student right) {
         return left.getIdNumber() - right.getIdNumber();
      }
   }

   //removes a student value
   public boolean remove(Student s) {
      if(s == null || !contains(s)) {
         //System.out.println("remove false");
         return false;
      }
      size--;
      remove(s, root);
      return true;
   }

   //recursive helper method
   //shifts down until it finds the node to be removed
   //then removes the node
   private boolean remove(Student s, TreeNode node) {
      if(node == null) {
         return false;
      }
      int c = comparator.compare(s, node.value);
      if (c < 0) {
         System.out.println(node.value);
         remove(s, node.left);
      } else if(c > 0) {
         remove(s, node.right);
      } else {
         //System.out.println("lastelse");
         if(node.countChildren() == 2) {
            TreeNode temp = findMax(node.left);
            //System.out.println(node.value);
            node.value = temp.value;
            //System.out.println(node.value + " - " + temp.value);
            remove(temp.value, node.left);
         } else if(node.left != null) {
            //System.out.println("nodeleft");
            node = node.left;
         } else if(node.right != null) {
            //System.out.println("noderight");
            node = node.right;
         } else {
            //System.out.println("prune leaf");
            //System.out.println(node.value.getId());
            node.value = null;
            node = null;
            //System.out.println(node.value.getId());
         }
      }
      return true;
   }

   //helper method
   public TreeNode findMax(TreeNode node) {
      if(node.hasRightChild()) {
         return findMax(node.right);
      } else {
         return node;
      }
   }
}
