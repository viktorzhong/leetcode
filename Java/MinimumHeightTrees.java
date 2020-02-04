class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) return Collections.singletonList(0);
        List<List<Integer>> g = new ArrayList<>();
        int[] degrees = new int[n];

        for(int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++) {
            int[] e = edges[i];
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }

        LinkedList<Integer> leaves = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            degrees[i] = g.get(i).size();
            if(degrees[i] == 1) leaves.add(i);
        }

        while(leaves.size() < n) {
            int size = leaves.size();
            n -= size;
            for(int i = 0; i < size; i++) {
                int leaf = leaves.poll();
                for(int v : g.get(leaf)) {
                    degrees[v]--;
                    if(degrees[v] == 1) leaves.add(v);
                }
            }
        }

        return leaves;
    }
}