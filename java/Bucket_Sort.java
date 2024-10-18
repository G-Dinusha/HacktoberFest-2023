import java.util.ArrayList;
import java.util.Collections;

public class Bucket_Sort {

    public static void bucketSort(float[] arr) {
        // Create empty buckets
        int n = arr.length;
        ArrayList<Float>[] buckets = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Distribute input array values into buckets
        for (float num : arr) {
            int bucketIndex = (int) (num * n); // Assuming numbers are in range [0, 1)
            if (bucketIndex >= n) {
                bucketIndex = n - 1; // Handle edge case
            }
            buckets[bucketIndex].add(num);
        }

        // Sort each bucket and collect them
        int index = 0;
        for (ArrayList<Float> bucket : buckets) {
            Collections.sort(bucket); // Sort individual buckets
            for (float num : bucket) {
                arr[index++] = num; // Collect sorted values
            }
        }
    }

    public static void main(String[] args) {
        float[] arr = {0.42f, 0.32f, 0.23f, 0.52f, 0.51f, 0.12f};
        bucketSort(arr);

        // Print sorted array
        for (float num : arr) {
            System.out.print(num + " ");
        }
    }
}
