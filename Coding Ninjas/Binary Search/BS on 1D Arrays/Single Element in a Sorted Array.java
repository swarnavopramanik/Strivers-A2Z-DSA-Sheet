https://www.codingninjas.com/studio/problems/unique-element-in-sorted-array_1112654?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.ArrayList;
public class Solution
{
    public static int singleNonDuplicate(ArrayList<Integer> arr) {
        int n = arr.size(); // Size of the array.

        // Edge cases:
        if (n == 1)
            return arr.get(0);
        if (!arr.get(0).equals(arr.get(1)))
            return arr.get(0);
        if (!arr.get(n - 1).equals(arr.get(n - 2)))
            return arr.get(n - 1);

        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = (low + high) / 2;

            // If arr[mid] is the single element:
            if (!arr.get(mid).equals(arr.get(mid + 1)) && !arr.get(mid).equals(arr.get(mid - 1))) {
                return arr.get(mid);
            }

            // We are in the left:
            if ((mid % 2 == 1 && arr.get(mid).equals(arr.get(mid - 1)))
                    || (mid % 2 == 0 && arr.get(mid).equals(arr.get(mid + 1)))) {
                // Eliminate the left half:
                low = mid + 1;
            }
            // We are in the right:
            else {
                // Eliminate the right half:
                high = mid - 1;
            }
        }

        // Dummy return statement:
        return -1;
    }
}
