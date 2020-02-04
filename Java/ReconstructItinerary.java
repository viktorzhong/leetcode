class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        if(tickets == null || tickets.size() == 0) return null;
        int n = tickets.size() + 1;
        List<String> res = new ArrayList<>();
        res.add("JFK");

        Map<String, List<String>> map = new HashMap<>();
        for(List<String> ticket : tickets) {
            if(!map.containsKey(ticket.get(0))) {
                map.put(ticket.get(0), new ArrayList<>());
            }
            map.get(ticket.get(0)).add(ticket.get(1));
        }

        for(List<String> list : map.values()) {
            Collections.sort(list);
        }

        if(dfs(res, map, n, "JFK")) {
            return res;
        }

        return null;
    }

    private boolean dfs(List<String> res, Map<String, List<String>> map, int n, String start) {
        if(res.size() == n) return true;
        if(!map.containsKey(start)) return false;

        List<String> destList = map.get(start);
        for(int i = 0; i < destList.size(); i++) {
            String dest = destList.get(i);
            res.add(dest);
            destList.remove(i);
            if(dfs(res, map, n, dest)) return true;
            destList.add(i, dest);
            res.remove(res.size() - 1);
        }

        return false;
    }
}