package Ningbo.BinarySearch;

/**
 * Created by zhang on 6/18/16.
 */

class ArrayReader {
    public int get(int index) {
        return 0;
    }
}

public class SearchInASortedBigArray {
    public int searchBigSortedArray(ArrayReader reader, int target) {
        int index = 1;
        while (reader.get(index) < target) {
            index *= 2;
        }

        int start = 0;
        int end = index;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (reader.get(mid) < target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }

        if (reader.get(start) == target) {
            return start;
        }
        else if (reader.get(end) == target) {
            return end;
        }
        else {
            return -1;
        }
    }
}
