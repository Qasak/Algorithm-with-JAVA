/*
给你两个数组，arr1 和 arr2，

arr2 中的元素各不相同
arr2 中的每个元素都出现在 arr1 中
对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。

 

示例：

输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
输出：[2,2,2,1,4,3,3,9,6,7,19]
 

提示：

arr1.length, arr2.length <= 1000
0 <= arr1[i], arr2[i] <= 1000
arr2 中的元素 arr2[i] 各不相同
arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 
**/

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
		// map 记录arr2中元素出现的位置，用来给arr1中的元素给权重
		// 可以用数组优化：值全部小于1000 => 可以用一个大小1001的数组order来存，order[arr2[i]] => arr2中的值对应其下标
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
            set.add(arr2[i]);
        }

        Integer[] A1 = Arrays.stream(arr1).boxed().toArray(Integer[]::new);
        Arrays.sort(A1, (o1, o2) -> {
			// map只有arr2中出现过的元素，而arr1中可能有多出来的元素
			// 如果两元素都是arr2中有的，那么这俩按从小到大顺序排序
			
            if(map.containsKey(o1) && map.containsKey(o2)) {
                return map.get(o1) - map.get(o2);
			// 如果两个元素都是arr2中没有的，那么这俩按从小到大顺序排序
            } else if(!map.containsKey(o1) && !map.containsKey(o2)){
                return o1 - o2;
			// 如果其中一个元素在arr2中，那么它应该放在前面
            } else {
                if(set.contains(o1)) {
                    return -1;
                }else {
                    return 1;
                }
            }
        });

        return Arrays.stream(A1).mapToInt((num) -> num).toArray();

    }
}

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] order = new int[1001];
        for(int i = 0; i < arr2.length; i++) {
			// i + 1 => 排序的时候和不存在的元素区分
            order[arr2[i]] = i + 1;
        }

        return Arrays
                .stream(arr1)
                .boxed()
				// 如果不在数组中(order[n] == 0), 那么按从小到大顺序排序
                .sorted(Comparator.comparingInt(n -> (order[n] == 0 ? 1001 + n : order[n])))
                .mapToInt(e -> e)
                .toArray();

    }
}