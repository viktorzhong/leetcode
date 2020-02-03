class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        int[] indegrees = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] pair : prerequisites) {
            graph.get(pair[1]).add(pair[0]);
            indegrees[pair[0]]++;
        }

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < indegrees.length; i++) {
            if(indegrees[i] == 0) queue.offer(i);
        }

        int cnt = 0;
        while(!queue.isEmpty()) {
            int course = queue.poll();
            cnt++;
            int size = graph.get(course).size();
            for(int i = 0; i < size; i++) {
                int pointer = graph.get(course).get(i);
                indegrees[pointer]--;
                if(indegrees[pointer] == 0) queue.offer(pointer);
            }
        }

        return cnt == n;
    }
}