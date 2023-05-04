
import java.util.Comparator;
import java.util.function.Predicate;

public class ArrayUtils {

	// find(a, lo, hi, p) returns the index of the first element in
	// the unordered sub-array a[lo,hi) for which the predicate 'p'
	// returns true. Returns -1 if the predicate is false for all
	// elements of a[lo,hi).
	// Preconditions:
	//		a != null or lo == hi
	//		a[lo,hi) != null
	//		0 <= lo <= hi <= a.length
	// Postconditions (let 'r' be the return value):
	//		(r == -1) and (!p(a[lo,hi)))
	//			or
	//		(r != -1) and lo <= r < hi and (p(a[r])) and !p(a[lo,r)))
	public static <T> int find(T[] a, int lo, int hi, Predicate<T> p) {
		for (int i = lo; i < hi; i++)
			// !p(a[lo,i))
			if (p.test(a[i]))
				// !p(a[lo,i)) and p(a[i])
				return i;
		// !p(a[lo,hi))
		return -1;
	}

	// find(a, p) returns the index of the first element of
	// the unordered array 'a' for which the predicate returns
	// true. Returns -1 if the predicate is false for all
	// elements of 'a'.
	// Preconditions:
	//		a != null
	//		a[0,a.length) != null
	// Postconditions (let 'r' be the return value):
	//		(r == -1) and !p(a[0,a.length))
	//			or
	//		(r != -1) and 0 <= r < a.length and (p(a[r])) and !p(a[0,r)))
	public static <T> int find(T[] a, Predicate<T> p) {
		return find(a, 0, a.length, p);
	}

	// find(a, lo, hi, value) returns the index of the first element in
	// the unordered sub-array a[lo,hi) that matches 'value'. Returns -1
	// if 'value' is not found in a[lo,hi).
	// Preconditions:
	//		a != null or lo == hi
	//		a[lo,hi) != null
	//		0 <= lo <= hi <= a.length
	// Postconditions (let 'r' be the return value):
	//		(r == -1) and a[lo,hi) != value)
	//			or
	//		(r != -1) and 0 <= r < a.length and (a[r] == value) and a[lo,r) != value)
	public static <T> int find(T[] a, int lo, int hi, T value) {
		return find(a, lo, hi, new IsEqual<T>(value));
	}

	// find(a, p) returns the index of the first
	// occurrence of 'value' in the unordered array 'a'.
	// Returns -1 if 'value' is not found.
	// Preconditions:
	//		a != null
	//		a[0,a.length) != null
	// Postconditions (let 'r' be the return value):
	//		(r == -1) and (a[0,a.length) != value)
	//			or
	//		(r != -1) and 0 <= r < a.length and (a[r] == value) and (a[0,r) != value)
	public static <T> int find(T[] a, T value) {
		return find(a, 0, a.length, value);
	}

	public static <T> void move(T[] aFrom, int loFrom, int hiFrom, T[] aTo, int loTo) {
		
		while (loFrom < hiFrom) {
			aTo[loTo++] = aFrom[loFrom];
			aFrom[loFrom++] = null;
		}
	}

	public static <T> void move(T[] aFrom, T[] aTo, int lo, int hi) {
		
		// Check preconditions

		move(aFrom, lo, hi, aTo, lo);
	}

	// lowerBound returns the index of the first (lowest-index)
	// element of sub-array a[lo,hi) that is greater than or equal
	// to the given value.
	// Preconditions:
	// 		a != null
	// 		0 <= lo <= a.length
	// 		0 <= hi <= a.length
	// 		hi - lo > 0
	// Postconditions (let r be the return value):
	// 		for i in [lo,r) a[i] < value
	// 		for i in [r,hi) a[i] >= value
	public static <T> int lowerBound(T[] a, int lo, int hi, T value, Comparator<T> c) {
		// In all invariants, lo' and hi' are the original values
		// of lo and hi.
		// Note that due to the invariant that mid is in [lo,hi),
		// we will never get lo > hi.
		while (lo < hi) {
			// for all j in [lo',lo) a[mid] < value
			// for all j in [hi,hi') a[mid] >= value
			int mid = lo + (hi - lo) / 2;
			// mid in [lo,hi)
			if (c.compare(a[mid], value) < 0)
				lo = mid + 1;
			// for all j in [lo',lo) a[mid] < value
			// NOTE: mid + 1 is important to guarantee termination!
			else
				hi = mid;
			// for all j in [hi,hi') a[mid] >= value
		}
		// for all j in [lo',hi) a[mid] < value
		// for all j in [hi,hi') a[mid] >= value
		return hi;
	}

	// lowerBound returns the index of the first (lowest-index)
	// element of array 'a' that is greater than or equal to the
	// given value.
	// Preconditions:
	// a != null
	// a.length > 0
	// Postconditions (let r be the return value):
	// for i in [0,r) a[i] < value
	// for i in [r,a.length) a[i] >= value
	public static <T> int lowerBound(T[] a, T value, Comparator<T> c) {
		return lowerBound(a, 0, a.length, value, c);
	}

	// lowerBound returns the index of the first (lowest-index)
	// element of sub-array a[lo,hi) that is greater than or equal
	// to the given value.
	// Preconditions:
	// 		a != null
	// 		0 <= lo <= a.length
	// 		0 <= hi <= a.length
	// 		hi - lo > 0
	// Postconditions (let r be the return value):
	// 		for i in [lo,r) a[i] < value
	// 		for i in [r,hi) a[i] >= value
	public static <T extends Comparable<T>> int lowerBound(T[] a, int lo, int hi, T value) {
		return lowerBound(a, lo, hi, value, new WrapComparable<T>());
	}

	// lowerBound returns the index of the first (lowest-index)
	// element of array 'a' that is greater than or equal to the
	// given value.
	// Preconditions:
	// a != null
	// a.length > 0
	// Postconditions (let r be the return value):
	// for i in [0,r) a[i] < value
	// for i in [r,a.length) a[i] >= value
	public static <T extends Comparable<T>> int lowerBound(T[] a, T value) {
		return lowerBound(a, 0, a.length, value);
	}

	// upperBound returns the index of the first (lowest-index)
	// element of sub-array a[lo,hi) that is strictly greater than
	// the given value.
	// Preconditions:
	// a != null
	// 0 <= lo <= a.length
	// 0 <= hi <= a.length
	// hi - lo > 0
	// Postconditions (let r be the return value):
	// for i in [lo,r) a[i] <= value
	// for i in [r,hi) a[i] > value
	public static <T> int upperBound(T[] a, int lo, int hi, T value, Comparator<T> c) {
		// In all invariants, lo' and hi' are the original values
		// of lo and hi.
		// Note that due to the invariant that mid is in [lo,hi),
		// we will never get lo > hi.
		while (lo < hi) {
			// In all invariants, lo' and hi' are the original values
			// of lo and hi.
			// for all j in [lo',lo) a[mid] <= value
			// for all j in [hi,hi') a[mid] > value
			int mid = lo + (hi - lo) / 2;
			// mid in [lo,hi)
			if (c.compare(a[mid], value) <= 0)
				lo = mid + 1;
			// for all j in [lo',lo) a[mid] <= value
			else
				hi = mid;
			// for all j in [hi,hi') a[mid] > value
		}
		// for all j in [lo',hi) a[mid] <= value
		// for all j in [hi,hi') a[mid] > value
		return hi;
	}

	// upperBound returns the index of the first (lowest-index)
	// element of array 'a' that is strictly greater than the
	// given value.
	// Preconditions:
	// a != null
	// a.length > 0
	// Postconditions (let r be the return value):
	// for i in [0,r) a[i] <= value
	// for i in [r,a.length) a[i] > value
	public static <T> int upperBound(T[] a, T value, Comparator<T> c) {
		return upperBound(a, 0, a.length, value, c);
	}

	// upperBound returns the index of the first (lowest-index)
	// element of sub-array a[lo,hi) that is strictly greater than
	// the given value.
	// Preconditions:
	// a != null
	// 0 <= lo <= a.length
	// 0 <= hi <= a.length
	// hi - lo > 0
	// Postconditions (let r be the return value):
	// for i in [lo,r) a[i] <= value
	// for i in [r,hi) a[i] > value
	public static <T extends Comparable<T>> int upperBound(T[] a, int lo, int hi, T value) {
		return upperBound(a, lo, hi, value, new WrapComparable<T>());
	}

	// upperBound returns the index of the first (lowest-index)
	// element of array 'a' that is strictly greater than the
	// given value.
	// Preconditions:
	// a != null
	// a.length > 0
	// Postconditions (let r be the return value):
	// for i in [0,r) a[i] <= value
	// for i in [r,a.length) a[i] > value
	public static <T extends Comparable<T>> int upperBound(T[] a, T value) {
		return upperBound(a, 0, a.length, value);
	}

}
