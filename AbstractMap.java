import java.util.Iterator;


public abstract class AbstractMap<K, V> implements Map<K,V>
{
	public boolean isEmpty() {return size() == 0;}
	//-----------------Nested MapEntry Class-----------------------
	protected static class MapEntry<K,V> implements Entry<K,V>
	{
		private K k;	// key
		private V v;	// value
		public MapEntry(K key, V value)
		{
			k = key;
			v = value;			
		}
		// public methods of the Entry interface
		public K getKey() {return k;}
		public V getValue() {return v;}
		// Utilities exposed as part of the Entry interface
		protected void setKey(K key) {k = key;}
		protected V setValue(V value)
		{
			V old = v;
			v = value;
			return old;
		}
	}
	//------------------End of nested MapEntry class---------------------------
	
	// Support for public keySet method...
	private class KeyIterator implements Iterator<K>
	{ 
		private Iterator<Entry<K,V>> entries = entrySet().iterator();	// reuse entrySet
		public boolean hasNext() {return entries.hasNext();}
		public K next() {return entries.next().getKey();}
		public void remove() {throw new UnsupportedOperationException();}
	}
	private class KeyIterable implements Iterable<K>
	{
		public Iterator<K> iterator() {return new KeyIterator();}
	}
	public Iterable<K> keySet() {return new KeyIterable();}
	
	// Support for public values method...
	
	private class ValueIterator implements Iterator<V>
	{
		private Iterator<Entry<K,V>> entries = entrySet().iterator();	// reuse entrySet
		public boolean hasNext() {return entries.hasNext();}
		public V next() {return entries.next().getValue();}
		public void remove() {throw new UnsupportedOperationException();}
	}
	private class ValueIterable implements Iterable<V>
	{
		public Iterator<V> iterator() {return new ValueIterator();}
	}
	public Iterable<V> values() {return new ValueIterable();}
}
