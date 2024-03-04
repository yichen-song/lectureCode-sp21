public class Lists1Exercises {
    /** Returns an IntList identical to L, but with
      * each element incremented by x. L is not allowed
      * to change. */
    public static IntList incrList(IntList L, int x) {
        /* Your code here. */
        if (L.rest == null) {
            return new IntList(L.first + x, L.rest);
        }
        return new IntList(L.first + x, incrList(L.rest, x));
    }

    /** Returns an IntList identical to L, but with
      * each element incremented by x. Not allowed to use
      * the 'new' keyword. */
    public static IntList dincrList(IntList L, int x) {
        if (L.rest != null) {
            L.rest = incrList(L.rest, x);
        }
        L.first += x;
        return L;
    }

    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L.rest = new IntList(7, null);
        L.rest.rest = new IntList(9, null);

        System.out.println(L.size());
        System.out.println(L.iterativeSize());

        // Test your answers by uncommenting. Or copy and paste the
        // code for incrList and dincrList into IntList.java and
        // run it in the visualizer.
        System.out.println(L.get(1));
        IntList incrList = incrList(L, 3);
        IntList toPrintList = L;
        for (int i = 0; i < L.size(); i += 1) {
            System.out.println(toPrintList.first + " " + incrList.first);
            toPrintList = toPrintList.rest;
            incrList = incrList.rest;
        }
        IntList dincrList = dincrList(L, 3);
        toPrintList = L;
        for (int i = 0; i < L.size(); i += 1) {
            System.out.println(toPrintList.first + " " + dincrList.first);
            toPrintList = toPrintList.rest;
            dincrList = dincrList.rest;
        }
    }
}