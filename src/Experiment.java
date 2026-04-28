public class Experiment {

    Sorter s = new Sorter();
    Searcher f = new Searcher();

    public long timeSort(int[] a, String type) {
        long start = System.nanoTime();

        if (type.equals("b")) {
            s.basicSort(a);
        } else {
            s.advancedSort(a);
        }

        long end = System.nanoTime();
        return end - start;
    }

    public long timeSearch(int[] a, int x) {
        long start = System.nanoTime();
        f.search(a, x);
        long end = System.nanoTime();

        return end - start;
    }

    public void run() {

        int[] sizes = {10, 100, 1000};

        for (int size : sizes) {

            int[] a = s.gen(size);

            System.out.println("size = " + size);

            long t1 = timeSort(a.clone(), "b");
            long t2 = timeSort(a.clone(), "q");
            long t3 = timeSearch(a, a[size / 2]);

            System.out.println("bubble: " + t1);
            System.out.println("quick: " + t2);
            System.out.println("search: " + t3);

            System.out.println("-----");
        }
    }
}