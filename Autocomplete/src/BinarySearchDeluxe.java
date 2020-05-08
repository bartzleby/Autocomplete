import java.util.Comparator;

public class BinarySearchDeluxe {
	
	// for testing
	public static void main(String[] args) {
		Integer[] ints = {10, 10, 20, 30, 45, 45, 45, 45, 50, 50, 55, 60, 60, 60, 60, 65, 65, 68, 69, 70, 77, 77, 77, 77, 77, 80, 80, 80, 80, 81, 81, 81, 85, 85, 90, 99, 99, 899};
		
		int firstIndex = firstIndexOf(ints, 45, Comparator.naturalOrder());
		System.out.println(firstIndex);
		
		int lastIndex = lastIndexOf(ints, 45, Comparator.naturalOrder());
		System.out.println(lastIndex);
	}

    /**
     * Return the index of the first key in a[] that equals the search key, or -1 if no such key.
     * @param <Key>
     * @param a
     * @param key
     * @param comparator
     * @return
     */
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
    	
    	if (a == null || key == null || comparator == null) throw new NullPointerException();
    	
    	int i = doBinarySearch(a, key, comparator);
    	if (i == -1) return i;
    	return decrementToFirst(a, i, comparator);
    	
    }

    /**
     * Return the index of the last key in a[] that equals the search key, or -1 if no such key.
     * @param <Key>
     * @param a
     * @param key
     * @param comparator
     * @return
     */
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
    	
    	if (a == null || key == null || comparator == null) throw new NullPointerException();
    	
    	int i = doBinarySearch(a, key, comparator);
    	if (i == -1) return i;
    	return incrementToLast(a, i, comparator);
    	
    }

	/*
     * Returns an index of search Key in Key Array, or -1 if no such key.
     * @param <Key>
     * @param a the array of Keys, must be sorted in ascending order according to comparator.
     * @param key the search key
     * @param comparator
     * @return index of key in array {@code a} if present; {@code -1} otherwise
     */
    private static <Key> int doBinarySearch(Key[] a, Key key, Comparator<Key> comparator) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (comparator.compare(key, a[mid]) < 0) hi = mid - 1;
            else if (comparator.compare(key, a[mid]) > 0) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
    
    private static <Key> int decrementToFirst(Key[] a, int i, Comparator<Key> comparator) {
    	while (comparator.compare(a[i], a[i - 1]) == 0) i--;
		return i;
    }
    
    private static <Key> int incrementToLast(Key[] a, int i, Comparator<Key> comparator) {
    	while (comparator.compare(a[i], a[i + 1]) == 0) i++;
		return i;
	}
}