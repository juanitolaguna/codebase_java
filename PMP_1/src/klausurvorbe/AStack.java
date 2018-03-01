package klausurvorbe;

import java.util.Arrays;

public class AStack<T>{
	private Object[] values;
	private int size;
	

	public AStack(){
		values = new Object[10];
		size = 0;
	}
	
	public AStack<T> push(T value){
		if(size >= values.length) resizeArray(size + 10);
		values[size] = value;
		size++;
		return this;
	}

	private void resizeArray(int size) {
		values = Arrays.copyOf(values, size);
	}
	
	@SuppressWarnings("unchecked")
	public T pop(){
		if(size == 0) return null;
		return (T) values[size - 1];
	}
	
	public boolean isEmpty(){
		return size == 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + size;
		result = prime * result + Arrays.hashCode(values);
		return result;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AStack other = (AStack) obj;
		if (size != other.size)
			return false;
		if (!Arrays.equals(values, other.values))
			return false;
		return true;
	}
}