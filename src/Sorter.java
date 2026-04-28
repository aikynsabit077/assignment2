import java.util.Random;

public class Sorter {

    // bubble
    public void basicSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
        }
    }

    //quick
    public void advancedSort(int[] a) {
        qs(a, 0, a.length - 1);
    }

    private void qs(int[] a, int l, int r) {
        if (l < r) {
            int p = part(a, l, r);
            qs(a, l, p - 1);
            qs(a, p + 1, r);
        }
    }

    private int part(int[] a, int l, int r) {
        int pivot = a[r];
        int i = l - 1;

        for (int j = l; j < r; j++) {
            if (a[j] <= pivot) {
                i++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }

        int t = a[i + 1];
        a[i + 1] = a[r];
        a[r] = t;

        return i + 1;
    }

    public int[] gen(int n) {
        Random rand = new Random();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = rand.nextInt(1000);
        }

        return a;
    }

    public void print(int[] a) {
        for (int x : a) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}