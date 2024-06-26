518. Coin Change II

  class Solution {
    public int change(int amount, int[] coins) {
        int arr[] = new int[amount+1];
        arr[0] = 1;
        for(int c : coins)
            for(int i = c; i <= amount; i++)
                arr[i] += arr[i-c];
        return arr[amount];
    }
}
