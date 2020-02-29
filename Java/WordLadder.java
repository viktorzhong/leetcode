class Solution {
    private HashMap<String, List<String>> map = new HashMap<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        buildMap(beginWord, wordList);
        HashSet<String> done = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        done.add(beginWord);

        int levels = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                String cur = q.poll();
                if(cur.equals(endWord)) return levels;
                for(String w : map.get(cur)) {
                    if(!done.contains(w)) {
                        q.offer(w);
                        done.add(w);
                    }
                }
            }
            levels++;
        }

        return 0;
    }

    private void buildMap(String beginWord, List<String> wordList) {
        for(String word : wordList) {
            List<String> list = new ArrayList<>();
            for(String o : wordList) {
                if(diff(word, o) == 1) list.add(o);
            }
            map.put(word, list);
        }
        if(!map.containsKey(beginWord)) {
            List<String> list = new ArrayList<>();
            for(String o : wordList) {
                if(diff(beginWord, o) == 1) list.add(o);
            }
            map.put(beginWord, list);
        }
    }

    private int diff(String s, String t) {
        if(s.length() != t.length()) return -1;
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != t.charAt(i)) ++count;
        }
        return count;
    }
}