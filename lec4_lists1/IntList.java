package lec4_lists1;


public class IntList {
	public int first;
	public IntList rest;

	public IntList(int f, IntList r) {
		first = f;
		rest = r;
	}

	/** Return the size of the list using... recursion! */
	public int size() {
		if (rest == null) {
			return 1;
		}
		return 1 + this.rest.size();
	}

	/** Return the size of the list using no recursion! */
	public int iterativeSize() {
		IntList p = this;
		int totalSize = 0;
		while (p != null) {
			totalSize += 1;
			p = p.rest;
		}
		return totalSize;
	}

	/** Returns the ith item of this IntList. */
	public int get(int i) {
		if (i == 0) {
			return first;
		}
		return rest.get(i - 1);
	}

	/** Adds and integer x to the start of the list */
	public void addFirst(int x) {
		IntList n = new IntList(this.first, this.rest);
		this.first = x;
		this.rest = n;
	}

	public static void main(String[] args) {
		IntList L = new IntList(15, null);
		L.addFirst(10);
		L.addFirst(5);

		System.out.println(L.get(0));
		System.out.println(L.get(1));
		System.out.println(L.get(2));
	}
} 