class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int n = words.length;
        int i = 0;
        while(i < n) {
            int cur = maxWidth, len = 0;
            // StringBuilder sb = new StringBuilder();
            List<String> list = new ArrayList<>();

            while(cur - words[i].length() >= 1) {
                list.append(words[i]);
                cur -= words[i].length();
                len += words[i].length();
                i++;
            }
            int spaceCnt = maxWidth - len;
            StringBuilder sb = new StringBuilder();
            int per = spaceCnt / (list.size() - 1);
            for(int j = 0; j < list.size(); j++) {
                if(j == 0) {
                    
                } else if(j == list.size() - 1){

                } else {

                }
            }

        }
    }
}