/*
在一条[环路]上有 N 个加油站
其中第 i 个加油站有汽油 gas[i] 升。
你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。
你从其中的一个加油站出发，开始时油箱为空。

如果题目有解，该答案即为唯一答案。
输入数组均为非空数组，且长度相同。
输入数组中的元素均为非负数。
**/
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
		// 从0开始，若第i个加油站无法到达，则从下一个站开始(若从前面任意一个站开始，更加无法到达)
        int rest = 0, run = 0, start = 0;
        for(int i = 0; i < gas.length; i++) {
            rest += gas[i] - cost[i];
            run  += gas[i] - cost[i];
            if(run < 0) {
                start = i + 1;
                run = 0;
            }
        }
        return rest >= 0? start : -1;
    }
}