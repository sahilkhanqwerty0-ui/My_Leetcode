class Solution {
    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        List<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);

        boolean[] visited = new boolean[n + 1];
        visited[1] = true;

        int depth = -1;

        while (!q.isEmpty()) {
            int size = q.size();
            depth++;

            while (size-- > 0) {
                int u = q.poll();

                for (int v : graph[u]) {
                    if (!visited[v]) {
                        visited[v] = true;
                        q.offer(v);
                    }
                }
            }
        }

        if (depth == 0) return 0;

        long ans = 1, mod = 1_000_000_007;

        for (int i = 0; i < depth - 1; i++)
            ans = (ans * 2) % mod;

        return (int) ans;
    }
}