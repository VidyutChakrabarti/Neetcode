from collections import deque

class Solution:
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        n = len(graph)
        reversed_adj = [[] for _ in range(n)]
        count = [0] * n
        
        for u in range(n):
            for v in graph[u]:
                reversed_adj[v].append(u)
            count[u] = len(graph[u])
        
        queue = deque()
        for u in range(n):
            if count[u] == 0:
                queue.append(u)
        
        safe_nodes = []
        while queue:
            u = queue.popleft()
            safe_nodes.append(u)
            for v in reversed_adj[u]:
                count[v] -= 1
                if count[v] == 0:
                    queue.append(v)
        
        return sorted(safe_nodes)