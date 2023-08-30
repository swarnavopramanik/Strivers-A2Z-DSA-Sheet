703. Kth Largest Element in a Stream


  // Approach 1 ; Method use PriorityQueue

 class KthLargest {
    private int k;
    private Queue<Integer> heap = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) add(num);
    }
    
    public int add(int val) {
        if ( heap.size() < k || val > heap.peek() ) heap.add(val);
        if (heap.size() > k) heap.remove();

        return heap.peek();
    }
} 




// Approach 2 ; Method use BinarySearch 

 class KthLargest {
    List<Integer> store = new ArrayList<>();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums)
            store.add(num);
        Collections.sort(store);
    }
    
    public int add(int val) {
        int pos = binarySearch(val); 
        store.add(pos, val);
        return store.get(store.size() - k);
    }
    
    public int binarySearch(int val) {
        int low = 0, high = store.size() - 1, res = high + 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (store.get(mid) == val)
                return mid;
            else if (store.get(mid) > val) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }
} 


