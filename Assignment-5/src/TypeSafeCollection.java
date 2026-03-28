import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class TypeSafeCollection<K extends Type, V extends Type> implements 
Iterable<Map.Entry<K, V>> {
	// Storage for the key-value pairs
	Map<K, V> collection = new HashMap <>();
	
	// Declare the type of keys and values 
	Type keyType, valueType;
	
	// Constructor that initializes the key and value types 
	public TypeSafeCollection(Type keyType, Type valueType) {
		this.keyType = keyType;
		this.valueType = valueType;
	}//END of TypeSafeCollection constructor
	
	//Method to add a key-value pair
	public void add(K key, V value) throws TypeMismatchException {
		if (!keyType.isCompatibleWith(key) || !valueType.isCompatibleWith(value)) {
			throw new TypeMismatchException("Key or value type does not match collections type constraints");
		}
		collection.put(key, value);
	}
	
	// Method to remove a key-value pair
	public V remove(K key) {
		//remove the value 
		return collection.remove(key);
	}
	
	//Method to return the iterator object for looping 
	@Override
	public Iterator<Map.Entry<K, V>> iterator() {
		return new TypeSafeIterator();
	}//END of iterator method
	
	// Inner class to implement iterator
	private class TypeSafeIterator implements Iterator<Map.Entry<K, V>> {
		// Iterator for map entries
		private Iterator<Map.Entry<K, V>> iterator = collection.entrySet().iterator();
		
		//Chekc if theres more elements
		@Override
		public boolean hasNext() {
			return iterator.hasNext();	
		}//END of hasNext method
		
		//Return the next entry in the map
		@Override
		public Map.Entry<K, V> next() {
			//if there is not next element display an error
			if (!hasNext()) throw new NoSuchElementException();
			return iterator.next();
		}//END of hasNext method
	}//END of TypeSafeIterator class
}//END of TypeSafeCollection class
