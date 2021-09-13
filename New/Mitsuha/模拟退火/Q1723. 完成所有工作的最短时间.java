// DFS 超时
class Solution {
    int ans = 0x3f3f3f3f;
    int n;
    int[] jobss;
    int K;
    public int minimumTimeRequired(int[] jobs, int k) {
        int[] time = new int[k];
        jobss = jobs;
        n = jobs.length;
        K = k;
        dfs(0, time, 0);
        return ans;
    }
    // cur : 当前最大工作时间
    public void dfs(int idx, int[] time, int cur) {
        if(cur >= ans) {
            return;
        }
        if(idx == n) {
            ans = Math.min(ans, cur);
            return;
        }
        // 当前工作可以分配给哪个工人
        for(int i = 0; i < K; i++) {
            time[i] += jobss[idx];
            dfs(idx + 1, time, Math.max(cur, time[i]));
            time[i] -= jobss[idx];
        }
    }
}

// 我们可以重新审视一下这道题。

// 题目其实是让我们将 n个数分为 k 份，并且尽可能让 k 份平均。这样的「最大工作时间」才是最小的。

class Solution {
    int ans = 0x3f3f3f3f;
    int n;
    int[] jobss;
    int K;
    public int minimumTimeRequired(int[] jobs, int k) {
        int[] time = new int[k];
        jobss = jobs;
        n = jobs.length;
        K = k;
        dfs(0, 0, time, 0);
        return ans;
    }
    // cur : 当前最大工作时间
    public void dfs(int idx, int used, int[] time, int cur) {
        if(cur >= ans) {
            return;
        }
        if(idx == n) {
            ans = cur;
            return;
        }
        // 优先分配给「空闲工人」
        if (used < K) {
            time[used] = jobss[idx];
            dfs(idx + 1, used + 1, time, Math.max(time[used], cur));
            time[used] = 0;
        }
        // 当前工作可以分配给哪个工人
        for(int i = 0; i < used; i++) {
            time[i] += jobss[idx];
            dfs(idx + 1, used, time, Math.max(cur, time[i]));
            time[i] -= jobss[idx];
        }
    }
}

// 因为将 nn 个数划分为 kk 份，等效于用 nn 个数构造出一个「特定排列」，然后对「特定排列」进行固定模式的任务分配逻辑，就能实现「答案」与「最优排列」的对应关系。

// 基于此，我们可以使用「模拟退火」进行求解。
/*
随机选择两个下标，计算「交换下标元素前对应序列的得分」&「交换下标元素后对应序列的得分」
如果温度下降（交换后的序列更优），进入下一次迭代
如果温度上升（交换前的序列更优），以「一定的概率」恢复现场（再交换回来）

class Solution {
public:
    vector<int> jobs;
    int k;
    // 超参数，全看运气QAQ，我这组超参数可以过所有.一路从52调到60.....
    double T = 1e6; //初始温度
    double t = 1e-6;  // 结束温度
    double a = 0.9999; //温度下降系数
    int epoch = 10000;//最大迭代次数
    //
    int ret = INT_MAX;


    int calc_time() {
    // 计算目标函数
    // 计算固定job序列下的“最小最大时间”，这一步是启发式优化算法的关键步骤。
    // 一般能写出这个。模拟退火，遗传算法，粒子群等直接套公式.....
    // 参考三叶大佬
        vector<int> worker_load(k, 0);
        for (int i = 0; i < jobs.size(); i++) {
            int idx = 0, cur = worker_load[idx];
            for (int j = 0; j < k; j++) {
                if (worker_load[j] < cur) {
                    cur = worker_load[j];
                    idx = j;
                }
            }
            worker_load[idx] += jobs[i];
        }
        int cur = 0;
        for (int i = 0; i < k; i++) cur = max(cur, worker_load[i]);
        ret = min(ret, cur);
        return cur;
    }

    void swap(vector<int>& arr, int idx1, int idx2) {
        int t = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = t;
    }


    void sa() {
    // 一次退火的流程,在同一温度下搜索epoch次
        while(epoch-- > 0) {
            // 1.随机扰乱原序列，生成新的job序列
            // 随机交换job序列中两个位置的数，生成的新的job序列当做此次退火尝试的解序列.
            int idx1 = rand() % jobs.size();
            int idx2 = rand() % jobs.size();
            swap(jobs, idx1, idx2);

            // 2.计算目标函数的值
            // 计算当前job序列下的“最小最大时间”
            int result = calc_time();

            // 3.是否接受新的解序列
            // result小于之前的最好结果，还考虑什么？直接选择这个序列作为解序列呀！直接返回
            if(result <= ret) {
                return;
            }
            // result更差（给个机会吧），以一定的概率接受这个更差的job序列和“最小最大时间”(这个概率和温度有关)
            else {
                int diff = result - ret;
                // 当前温度和diff下的接受概率（T越大，这个概率越大，结果越容易被接受）
                double p = log(diff / T); 
                double rand_p = rand() % 100 / 100; // 产生一个0-1的随机数
                // 虽然这个解更差，但是概率给了它一次机会。我们还是接受这个job序列
                if(p > rand_p) {
                    return;
                }
                // 不接受这个job序列，还是以前的序列好呀，我们要恢复以前的序列
                else {
                    swap(jobs, idx1, idx2);
                }
            }
        }
    }


    int minimumTimeRequired(vector<int>& jobs_, int k_) {
        srand(100); // 随机数种子
        jobs = jobs_; 
        k = k_;     // 变为全局变量
        while(T > t) {
            sa();
            T *= a;// 降低温度
        }
        // for(int item : jobs) {
        //     cout<<item;
        // }
    return ret;
    }
};
*/

