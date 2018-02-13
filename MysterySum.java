/*
    Author: Michael Moschetti
*/
class MysterSum {
    public static float mysterySum(long n) {
        float ans = 0;
        for(long i = 1; i < n; i++) {
            ans += 1/(i*i);
        }
        return ans;
    }

    public static float mysterySumReverse(long n) {
        float ans = 0;
        for(long i = n; i > 0; i--) {
            ans += 1/(i*i);
        }
        return ans;
    }

    public static void main(String args[]) {
        for(int i = 1; i < 100001; i *= 10) {
            System.out.println("Forwards with n = " + i + " returns: " + Math.sqrt(6*mysterySum(i)));
            System.out.println("Reverse with n = " + i + " returns: " + Math.sqrt(6*mysterySumReverse(i)));
            // N = 10 provides full accuracy and reverse is better and computes for N = 1
        }
    }
}
