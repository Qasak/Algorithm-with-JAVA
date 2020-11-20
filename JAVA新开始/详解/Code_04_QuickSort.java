package basic_class_01;

import java.util.Arrays;

public class Code_04_QuickSort {

	public static void quickSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		quickSort(arr, 0, arr.length - 1);
	}

	public static void quickSort(int[] arr, int l, int r) {
		// 待排序的区域至少有两个数
		if (l < r) {
			// 有序的时候，时间变成O(N^2)
			// 每次划分，大于小于各占一般->O(NlogN)
			
			// 待排序区间是左闭右闭的，
			// l + (int) (Math.random() * (r - l + 1) 属于[l, r]
			swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
			// 返回等于区域的两端的下标
			// 也可以返回more（more==cur），more的右边都是大于pivot的值
			int[] p = partition(arr, l, r);
			// 左右半边排除==pivot的数
			quickSort(arr, l, p[0] - 1);
			quickSort(arr, p[1] + 1, r);
		}
	}

	public static int[] partition(int[] arr, int l, int r) {
		// 整个区间是小于部分推着等于部分往右走

		int less = l - 1;
		int more = r;
		int cur = l;
		// 终止：当前位置== more区间边界
		while (cur < more) {
			// 当前元素小于pivot的话， less区间扩展，当前元素与之交换后，往前走
			if (arr[cur] < arr[r]) {
				swap(arr, ++less, cur++);
			// 当前元素大于pivot, more区间扩展，
			} else if (arr[cur] > arr[r]) {
				// 交换过来后，是待定，下次循环判断是大，小，等。
				
				swap(arr, --more, cur);
			// 相等：不交换，cur直接往右走
			} else {
				cur++;
			}
		}
		// pivot归位
		swap(arr, cur, r);
		// [less + 1, more] 区间全是==pivot的数
		return new int[] { less + 1, more };
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	// for test
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	// for test
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	// for test
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// for test
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			quickSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				printArray(arr1);
				printArray(arr2);
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		quickSort(arr);
		printArray(arr);

	}

}
