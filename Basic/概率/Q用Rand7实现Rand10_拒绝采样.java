class Solution extends SolBase {
    public int rand10() {
        int col, row, idx;
        do {
            col = rand7();
            row = rand7();
            idx = col + (row - 1) * 7;
        } while(idx > 40);
        // [1, 40]
        return (idx % 10) + 1;
    }
}