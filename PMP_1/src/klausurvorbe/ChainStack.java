package klausurvorbe;


public class 	ChainStack<T>{
	private StackElement<T> top;
	private int length;
	
	private ChainStack(){
		top = null;
		length = 0;
	}
	
	private void push(T value){
		top = new StackElement<T>(top, value);
		length++;
	}
	
	private T pop(){
		if(top == null) return null;
		T value = top.value;
		top = top.prev;
		length--;
		return value;
		
	}
	
	private boolean isEmpty(){
		return length == 0;
	}
	
	
	
	@Override
	public String toString() {
		return top.value.toString();
	}



	private static class StackElement<T>{
		StackElement<T> prev;
		T value;
		private StackElement(StackElement<T> p, T v){
			prev = p;
			value = v;
		}	
	}
	
	public static void main(String[] args) {
		ChainStack<String> stack = new ChainStack<>();
		stack.push("Hallo");
		stack.push("Hallo1");
		stack.push("Hallo2");
		stack.push("Hallo3");
		stack.push("Hallo4");

		for(StackElement<String> _top = stack.top; _top != null; _top = _top.prev){
			System.out.println(_top.value);
		}
		
		System.out.println("pop!");
		System.out.println(stack.isEmpty());
		System.out.println(stack.pop());
		System.out.println(stack.top.value);
	}


}
