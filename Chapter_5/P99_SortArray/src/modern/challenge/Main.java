package modern.challenge;

import java.time.Clock;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int ARRAY_SIZE = 10_000;
    private static final String[] MELON_TYPES
            = {"Watermelon", "Cantaloupe", "Horned", "Crenshaw", "Honeydew",
                "Gac", "Bitter", "Winter", "Sprite", "Korean", "Canary", "Charentais",
                "Bailan", "Hami", "Santa Claus", "Sky Rocket", "Golden Langkawi", "Apollo",
                "Honey Globe", "Autumn Sweet", "Jade Dew", "Golden Prize", "Ten Me", "New Century"};

    public static void main(String[] args) {

        Clock clock = Clock.systemUTC();
        Random rnd = new Random();
        Comparator<Melon> byType = Comparator.comparing(Melon::getType);

        // initialize an array integers        
        int[] integers = new int[ARRAY_SIZE];
        for (int i = 0; i < ARRAY_SIZE; i++) {
            integers[i] = rnd.nextInt(ARRAY_SIZE);
        }

        // initialize an array of Melons
        Melon[] melons = new Melon[ARRAY_SIZE];
        for (int i = 0; i < ARRAY_SIZE; i++) {
            melons[i] = new Melon(MELON_TYPES[rnd.nextInt(5)], 2000 + rnd.nextInt(2000000));
        }

        System.out.println("Sort via Arrays.sort()");
        System.out.println("----------------------");

        System.out.println("\nArrays.sort(): sorting 'integers', array size: " + integers.length);
        int[] cloneIntegers = integers.clone();
        long startTimeV1 = clock.millis();
        Arrays.sort(cloneIntegers);
        displayExecutionTime(clock.millis() - startTimeV1);
        displayIntSortedArray(cloneIntegers);

        System.out.println("\nArrays.sort(): sorting 'melons', array size: " + melons.length);
        Melon[] cloneMelons = melons.clone();
        long startTimeV2 = clock.millis();
        Arrays.sort(cloneMelons, new Comparator<Melon>() {
            @Override
            public int compare(Melon melon1, Melon melon2) {
                return Integer.compare(melon1.getWeight(), melon2.getWeight());
            }
        });
        displayExecutionTime(clock.millis() - startTimeV2);
        displayMelonsSortedArray(cloneMelons);

        System.out.println("\nArrays.parallelSort(): sorting 'melons', array size: " + melons.length);
        Melon[] cloneMelonsParallel = melons.clone();
        long startTimeV3 = clock.millis();
        Arrays.parallelSort(cloneMelonsParallel, new Comparator<Melon>() {
            @Override
            public int compare(Melon melon1, Melon melon2) {
                return Integer.compare(melon1.getWeight(), melon2.getWeight());
            }
        });
        displayExecutionTime(clock.millis() - startTimeV3);
        displayMelonsSortedArray(cloneMelonsParallel);

        System.out.println("\n\nSort via Bubble sort:");
        System.out.println("----------------------");

        System.out.println("\nSorting numbers ...");
        int[] cloneIntegersBs = integers.clone();
        long startTimeV4 = clock.millis();
        ArraySorts.bubbleSort(cloneIntegersBs);
        displayExecutionTime(clock.millis() - startTimeV4);
        displayIntSortedArray(cloneIntegersBs);

        System.out.println("\nSorting melons by type ...");
        Melon[] cloneMelonBs = melons.clone();
        long startTimeV5 = clock.millis();
        ArraySorts.bubbleSortWithComparator(cloneMelonBs, byType);
        displayExecutionTime(clock.millis() - startTimeV5);
        displayMelonsSortedArray(cloneMelonBs);

        System.out.println("\n\nSort via Bubble sort optimized:");
        System.out.println("----------------------");

        System.out.println("\nSorting numbers ...");
        int[] cloneIntegersBso = integers.clone();
        long startTimeV6 = clock.millis();
        ArraySorts.bubleSortOptimized(cloneIntegersBso);
        displayExecutionTime(clock.millis() - startTimeV6);
        displayIntSortedArray(cloneIntegersBso);

        System.out.println("\nSorting melons by type ...");
        Melon[] cloneMelonBso = melons.clone();
        long startTimeV7 = clock.millis();
        ArraySorts.bubleSortOptimizedWithComparator(cloneMelonBso, byType);
        displayExecutionTime(clock.millis() - startTimeV7);
        displayMelonsSortedArray(cloneMelonBso);

        System.out.println("\n\nSort via Insertion sort:");
        System.out.println("----------------------");

        System.out.println("\nSorting numbers ...");
        int[] cloneIntegersIs = integers.clone();
        long startTimeV8 = clock.millis();
        ArraySorts.insertionSort(cloneIntegersIs);
        displayExecutionTime(clock.millis() - startTimeV8);
        displayIntSortedArray(cloneIntegersIs);

        System.out.println("\nSorting melons by type ...");
        Melon[] cloneMelonIs = melons.clone();
        long startTimeV9 = clock.millis();
        ArraySorts.insertionSortWithComparator(cloneMelonIs, byType);
        displayExecutionTime(clock.millis() - startTimeV9);
        displayMelonsSortedArray(cloneMelonIs);

        System.out.println("\n\nSort via Counting sort:");
        System.out.println("----------------------");

        System.out.println("\nSorting numbers ...");
        int[] cloneIntegersCs = integers.clone();
        long startTimeV10 = clock.millis();
        ArraySorts.countingSort(cloneIntegersCs);
        displayExecutionTime(clock.millis() - startTimeV10);
        displayIntSortedArray(cloneIntegersCs);

        System.out.println("\n\nSort via Heap sort:");
        System.out.println("----------------------");

        System.out.println("\nSorting numbers ...");
        int[] cloneIntegersHs = integers.clone();
        long startTimeV11 = clock.millis();
        ArraySorts.heapSort(cloneIntegersHs);
        displayExecutionTime(clock.millis() - startTimeV11);
        displayIntSortedArray(cloneIntegersHs);

        System.out.println("\nSorting melons by type ...");
        Melon[] cloneMelonHs = melons.clone();
        long startTimeV12 = clock.millis();
        ArraySorts.heapSortWithComparator(cloneMelonHs, byType);
        displayExecutionTime(clock.millis() - startTimeV12);
        displayMelonsSortedArray(cloneMelonHs);

        System.out.println("\n\nSort via Bucket sort:");
        System.out.println("----------------------");

        System.out.println("\nSorting numbers ...");
        int[] cloneIntegersBks = integers.clone();
        long startTimeV13 = clock.millis();
        ArraySorts.bucketSort(cloneIntegersBks);
        displayExecutionTime(clock.millis() - startTimeV13);
        displayIntSortedArray(cloneIntegersBks);

        System.out.println("\n\nSort via Cocktail sort:");
        System.out.println("----------------------");

        System.out.println("\nSorting numbers ...");
        int[] cloneIntegersCks = integers.clone();
        long startTimeV14 = clock.millis();
        ArraySorts.cocktailSort(cloneIntegersCks);
        displayExecutionTime(clock.millis() - startTimeV14);
        displayIntSortedArray(cloneIntegersCks);

        System.out.println("\n\nSort via Cycle sort:");
        System.out.println("----------------------");

        System.out.println("\nSorting numbers ...");
        int[] cloneIntegersCys = integers.clone();
        long startTimeV15 = clock.millis();
        ArraySorts.cycleSort(cloneIntegersCys);
        displayExecutionTime(clock.millis() - startTimeV15);
        displayIntSortedArray(cloneIntegersCys);

        System.out.println("\n\nSort via Exchange sort:");
        System.out.println("----------------------");

        System.out.println("\nSorting numbers ...");
        int[] cloneIntegersEs = integers.clone();
        long startTimeV16 = clock.millis();
        ArraySorts.exchangeSort(cloneIntegersEs);
        displayExecutionTime(clock.millis() - startTimeV16);
        displayIntSortedArray(cloneIntegersEs);

        System.out.println("\n\nSort via Merge sort:");
        System.out.println("----------------------");

        System.out.println("\nSorting numbers ...");
        int[] cloneIntegersMs = integers.clone();
        long startTimeV17 = clock.millis();
        ArraySorts.mergeSort(cloneIntegersMs);
        displayExecutionTime(clock.millis() - startTimeV17);
        displayIntSortedArray(cloneIntegersMs);

        System.out.println("\n\nSort via Pancake sort:");
        System.out.println("----------------------");

        System.out.println("\nSorting numbers ...");
        int[] cloneIntegersPs = integers.clone();
        long startTimeV18 = clock.millis();
        ArraySorts.pancakeSort(cloneIntegersPs);
        displayExecutionTime(clock.millis() - startTimeV18);
        displayIntSortedArray(cloneIntegersPs);

        System.out.println("\n\nSort via Quicksort:");
        System.out.println("----------------------");

        System.out.println("\nSorting numbers ...");
        int[] cloneIntegersQs = integers.clone();
        long startTimeV19 = clock.millis();
        ArraySorts.quickSort(cloneIntegersQs, 0, cloneIntegersQs.length - 1);
        displayExecutionTime(clock.millis() - startTimeV19);
        displayIntSortedArray(cloneIntegersQs);

        System.out.println("\nSorting melons by type ...");
        Melon[] cloneMelonQs = melons.clone();
        long startTimeV20 = clock.millis();
        ArraySorts.quickSortWithComparator(cloneMelonQs, 0, cloneMelonQs.length - 1, byType);
        displayExecutionTime(clock.millis() - startTimeV20);
        displayMelonsSortedArray(cloneMelonQs);
        
        System.out.println("\n\nSort via Shell sort:");
        System.out.println("----------------------");

        System.out.println("\nSorting numbers ...");
        int[] cloneIntegersSs = integers.clone();
        long startTimeV21 = clock.millis();
        ArraySorts.shellSort(cloneIntegersSs);
        displayExecutionTime(clock.millis() - startTimeV21);
        displayIntSortedArray(cloneIntegersSs);
        
        System.out.println("\n\nSort via Selection sort:");
        System.out.println("----------------------");

        System.out.println("\nSorting numbers ...");
        int[] cloneIntegersSss = integers.clone();
        long startTimeV22 = clock.millis();
        ArraySorts.selectionSort(cloneIntegersSss);
        displayExecutionTime(clock.millis() - startTimeV22);
        displayIntSortedArray(cloneIntegersSss);
        
        System.out.println("\n\nSort via Radix sort:");
        System.out.println("----------------------");

        System.out.println("\nSorting numbers ...");
        int[] cloneIntegersRs = integers.clone();
        long startTimeV23 = clock.millis();
        ArraySorts.radixSort(cloneIntegersRs, 10);
        displayExecutionTime(clock.millis() - startTimeV23);
        displayIntSortedArray(cloneIntegersRs);
        
        System.out.println("\nShuffle via Fisher–Yates algorithm:");
        System.out.println("-------------------------------------");

        System.out.println("\nShuffle numbers ...");
        int[] cloneIntegersSfs = cloneIntegersRs.clone();
        long startTimeV24 = clock.millis();
        ArraySorts.shuffleInt(cloneIntegersSfs);
        displayExecutionTime(clock.millis() - startTimeV24);
        System.out.println("Original (we use a sorted array):");
        displayIntSortedArray(cloneIntegersRs);
        System.out.println("Shuffle:");
        displayIntSortedArray(cloneIntegersSfs);
        
        System.out.println("\nShuffle melons ...");
        Melon[] cloneMelonSfs = cloneMelonQs.clone();
        long startTimeV25 = clock.millis();
        ArraySorts.shuffleObj(cloneMelonSfs);
        displayExecutionTime(clock.millis() - startTimeV25);
        System.out.println("Original (we use a sorted array):");
        displayMelonsSortedArray(cloneMelonQs);
        System.out.println("Shuffle:");
        displayMelonsSortedArray(cloneMelonSfs);
    }

    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ms" + " ("
                + TimeUnit.SECONDS.convert(time, TimeUnit.MILLISECONDS) + " s)");
    }

    // dummy display method
    private static void displayIntSortedArray(int[] arr) {

        for (int i = 0; i < 30; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.print(" ...\n");
    }

    // dummy display method
    private static void displayMelonsSortedArray(Melon[] arr) {

        for (int i = 0; i < 30; i++) {
            System.out.print(arr[i] + " ");
            if (i % 5 == 0) {
                System.out.println();
            }
        }

        System.out.print(" ...\n");
    }
}
