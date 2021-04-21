// 1.全部放入pq
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int j: arr) {
            pq.add(j);
        }
        int[] ans = new int[k];
        for(int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }
        return ans;
    }
}

/* 2.我们用一个大根堆实时维护数组的前 k 小值
首先将前 k个数插入大根堆中，随后从第 k+1个数开始遍历，
如果当前遍历到的数比大根堆的堆顶的数要[小]，就把堆顶的数弹出，再插入当前遍历到的数。
最后将大根堆里的数存入数组返回即可。
java: 默认小根堆

**/
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] vec = new int[k];
        if (k == 0) { // 排除 0 的情况
            return vec;
        }
        // 小根堆转为大根堆
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < k; ++i) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; ++i) {
            if(arr[i] < queue.peek()) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; ++i) {
            vec[i] = queue.poll();
        }
        return vec;
    }
}
/*
3. 快速选择
快排的划分函数每次执行完后都能将数组分成两个部分，
小于等于分界值 pivot 的元素的都会被放到数组的左边，大于的都会被放到数组的右边，然后返回分界值的下标
与快速排序不同的是，快速排序会根据分界值的下标递归处理划分的两侧，而这里我们只处理划分的一边。

我们定义函数 randomized_selected(arr, l, r, k) 表示划分数组 arr 的 [l,r] 部分
假设返回的下标pos(分界值pivot最终在数组中的位置)，即pivot是pos - l + 1小的数(pivot = l, 那么它是第1小的数)
有三种情况
1.pos - l + 1 == k, 即pos就是第k小的数，直接返回
2.pos - l + 1 < k, pos比k小，那么，第k小的数在pivot右边，要递归右边，即：
randomized_selected(arr, pos + 1, r, k)
**/
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 最后一个参数表示我们要找的是下标为k-1的数
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSearch(int[] nums, int l, int r, int k) {
        // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
        swap(nums, l + (int) (Math.random() * (r - l + 1)), r);
        int j = partition(nums, l, r);
        if (j == k) {
            return Arrays.copyOf(nums, j + 1);
        }
        // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
        return j > k? quickSearch(nums, l, j - 1, k): quickSearch(nums, j + 1, r, k);
    }

    // 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。
    private int partition(int[] nums, int l, int r) {
        // int v = nums[l];
        // int i = l, j = r + 1;
        // while (true) {
        //     while (++i <= r && nums[i] < v);
        //     while (--j >= l && nums[j] > v);
        //     if (i >= j) {
        //         break;
        //     }
        //     int t = nums[j];
        //     nums[j] = nums[i];
        //     nums[i] = t;
        // }
        // nums[l] = nums[j];
        // nums[j] = v;
        // return j;
        int less = l - 1;
        int more = r;
        int cur = l;
        while(cur < more) {
            if(nums[cur] < nums[r]) {
                swap(nums, ++less, cur++);
            } else if(nums[cur] > nums[r]) {
                swap(nums, --more, cur);
            } else {
                cur++;
            }
        }
        swap(nums, more, r);
        return more;
    }
    private void swap (int[] arr, int l, int r) {
        int t = arr[l];
        arr[l] = arr[r];
        arr[r] = t;
    }
}
