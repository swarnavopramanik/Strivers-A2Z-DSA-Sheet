1423. Maximum Points You Can Obtain from Cards

   class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length, totalSum = 0, minSubarray = 0;

	for (int i=0, currSum=0; i<n; i++) {
		totalSum += cardPoints[i];
		currSum += cardPoints[i];
		if (i < n-k) minSubarray += cardPoints[i];
		else {
			currSum -= cardPoints[i-(n-k)];
			minSubarray = Math.min(minSubarray, currSum);
		}
	}

	return totalSum - minSubarray;
    }
} 


--------------------------------------------------------------------------------------------------------------------------------------------

  
 class Solution {
    public int maxScore(int[] C, int K) {
        int total = 0;
        for (int i = 0; i < K; i++) total += C[i];
        int best = total;
        for (int i = K - 1, j = C.length - 1; i >= 0; i--, j--) {
            total += C[j] - C[i];
            best = Math.max(best, total);
        }
        return best;
    }
} 

