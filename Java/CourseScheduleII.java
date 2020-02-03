class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegrees = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++) {
            int[] pair = prerequisites[i];
            graph.get(pair[1]).add(pair[0]);
            indegrees[pair[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegrees[i] == 0) queue.offer(i);
        }

        int cnt = 0;
        while(!queue.isEmpty()) {
            int course = queue.poll();
            res[cnt++] = course;
            int size = graph.get(course).size();
            for(int i = 0; i < size; i++) {
                int pointer = graph.get(course).get(i);
                indegrees[pointer]--;
                if(indegrees[pointer] == 0) queue.offer(pointer);
            }
        }

        if(cnt == numCourses) return res;

        return new int[0];
    }
}