    static List<Integer> getArr() {
        Random rand = new Random();
        List<Integer> list;
        while(true) {
            int sum = 20;
            list = new ArrayList<>();
            for(int i = 0; i < 3; i++) {
                int cur = rand.nextInt(11);
                list.add(cur);
                sum -= cur;
            }
            if(sum >= 0 && sum <= 10) {
                list.add(sum);
                break;
            }
        }
        return list;
    }
    public static void main(String[] args) {
        List<List<Integer>> tmp = new ArrayList<>();
        for(int i = 0; i < 100000; i++) {
            tmp.add(getArr());
        }
        Map<Integer, Integer>[] map = new Map[4];
        for(int i = 0; i < 4; i++) {
            map[i] = new HashMap<>();
        }
        for(List<Integer> list : tmp) {
            for(int i = 0; i < 4; i++) {
                map[i].put(list.get(i), map[i].getOrDefault(list.get(i), 0) + 1);
            }
        }
        for(Map<Integer, Integer> m : map) {
            System.out.println(m);
        }
        System.out.println(getArr());
    }