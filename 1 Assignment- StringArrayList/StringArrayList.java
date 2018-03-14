public class StringArrayList implements StringList{

	private int size;
	private String[] arr, temparr;

	//constructor
	public StringArrayList(){
		size = 0;
		arr = new String[10];
	}

	//add string to list & return index where String was inserted
	public int add(String s){
		if (arr.length <= size){
			this.increasecapacity();
		}
		arr[size] = s;
		size++;
		return size-1;
	}

	public void increasecapacity(){
		int temp = (int) (1.5*arr.length);
		temparr = new String[temp];
		System.arraycopy(arr, 0, temparr, 0, size);
		arr = temparr;
	}

	//Retrieve String at pos. i
	public String get(int i){
			return arr[i];
	}

	//Return true if list contain String s
	public boolean contains(String s){
		for (int i=0; i<size; i++){
			if (arr[i].equals(s)){
				return true;
			}
		}
		return false;
	}

	//Return the index of String s or -1 if not in list
	public int indexOf(String s){
		for (int i=0; i<size; i++){
			if (arr[i].equals(s)){
				return i;
			}
		}
		return -1;
	}

	//Return current size of list
	public int size(){
		return size;
	}

	//Insert string s at index, shift other values
	//return index where String was inserted
	public int add(int index, String s) {
		if (arr.length <= size+1){
			this.increasecapacity();
			System.out.println(size);
		}
		this.shiftarray(index);
		arr[index] = s;
		size++;
		return index;
	}

	public void shiftarray(int index){
		for (int i=size; i > index;i--) {
			arr[i] = arr[i-1];
		}
	}

	//Remove all strings
	public void clear(){
		size = 0;
	}

	//Return true if list is empty, else = false
	public boolean isEmpty(){
		if (size == 0) return true;
		else return false;
	}

	//Remove String at index i. Shift other values
	public String remove(int i) {
		String temp = arr[i];
		for (int j=i; j < size-1; j++){
			arr[j] = arr[j+1];
		}
		size--;
		arr[size] = null;
		return temp;
	}

	//Set the value of the String in pos index
	public void set(int index, String s){
		arr[index] = s;
	}

	//Return an array representation of the list
	public String[] toArray(){
		String[] toarr = new String[size];
		for (int i=0; i<size; i++) {
			toarr[i] = arr[i];
		}
		return toarr;
	}
}
