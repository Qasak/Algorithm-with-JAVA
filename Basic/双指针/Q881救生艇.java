class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int i = 0, j = n - 1;
        int cnt = 0;
        while(i <= j) {
            if(i == j) {
                cnt++;
                break;
            }
            if(people[i] + people[j] <= limit) {
                i++; j--;
                cnt++;
            } else {
                j--;
                cnt++;
            }
        }
        return cnt;
    }
}