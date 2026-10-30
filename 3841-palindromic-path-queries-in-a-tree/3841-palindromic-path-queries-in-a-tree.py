class Solution:
    def palindromePath(self, n, edges, s, queries):
        g = [[] for _ in range(n)]

        for u, v in edges:
            g[u].append(v)
            g[v].append(u)

        LOG = n.bit_length()
        parent = [[0] * n for _ in range(LOG)]
        depth = [0] * n
        tin = [0] * n
        size = [1] * n

        # Iterative DFS
        order = []
        stack = [(0, -1)]

        while stack:
            u, p = stack.pop()
            parent[0][u] = max(p, 0)
            tin[u] = len(order)
            order.append(u)

            for v in g[u]:
                if v != p:
                    depth[v] = depth[u] + 1
                    stack.append((v, u))

        # Subtree sizes
        for u in reversed(order):
            for v in g[u]:
                if parent[0][v] == u and v != u:
                    size[u] += size[v]

        # Binary lifting
        for j in range(1, LOG):
            for i in range(n):
                parent[j][i] = parent[j-1][parent[j-1][i]]

        # Fenwick Tree (XOR)
        bit = [0] * (n + 1)

        def update(i, val):
            i += 1
            while i <= n:
                bit[i] ^= val
                i += i & -i

        def get(i):
            ans = 0
            i += 1
            while i > 0:
                ans ^= bit[i]
                i -= i & -i
            return ans

        def change(u, val):
            l = tin[u]
            r = l + size[u]

            update(l, val)
            if r < n:
                update(r, val)

        chars = [1 << (ord(c) - 97) for c in s]

        for u in range(n):
            change(u, chars[u])

        def lca(u, v):
            if depth[u] < depth[v]:
                u, v = v, u

            d = depth[u] - depth[v]

            for j in range(LOG):
                if d & (1 << j):
                    u = parent[j][u]

            if u == v:
                return u

            for j in range(LOG - 1, -1, -1):
                if parent[j][u] != parent[j][v]:
                    u = parent[j][u]
                    v = parent[j][v]

            return parent[0][u]

        ans = []

        for q in queries:
            t, a, b = q.split()
            u = int(a)

            if t == "update":
                new = 1 << (ord(b) - 97)
                change(u, chars[u] ^ new)
                chars[u] = new

            else:
                v = int(b)
                w = lca(u, v)

                mask = get(tin[u]) ^ get(tin[v]) ^ chars[w]

                ans.append((mask & (mask - 1)) == 0)

        return ans