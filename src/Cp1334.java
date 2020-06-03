// https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Cp1334 {

    public static void main(String args[]) {
        int[][] edges = {{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}};
        int result = findTheCity(4, edges, 4);
        System.out.println(result);
    }

    // Main idea: graph, Floyd
    // Time: V^3, V: vertex number
    // Space: V^2
    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] distance = new int[n][n];
        for (int i = 0; i < n; i++) {
            // Use the 10000000 as the maximum distance.
            Arrays.fill(distance[i], 10000000);
            distance[i][i] = 0;
        }

        for (int[] edge : edges) {
            distance[edge[0]][edge[1]] = edge[2];
            distance[edge[1]][edge[0]] = edge[2];
        }

        floyd(n, distance);

        int minCity = -1;
        int minCount = n;

        for (int i = 0; i < n; i++) {
            int curCount = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (distance[i][j] <= distanceThreshold) {
                    curCount++;
                }
            }
            if (curCount <= minCount) {
                minCount = curCount;
                minCity = i;
            }
        }

        return minCity;
    }

    private static void floyd(int n, int[][] distance) {
        for (int k=0; k<n; k++) {
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }
    }

    // Main idea: graph, Bellman-Ford
    // Time: V^3, V: vertex number
    // Space: V^2
    /*public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] distance = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
            distance[i][i] = 0;
        }

        for (int i = 0; i < n; i++) {
            // Time: V^2
            bellmanFord(n, edges, distance[i], i);
        }

        int minCity = -1;
        int minCount = n;

        for (int i = 0; i < n; i++) {
            int curCount = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (distance[i][j] <= distanceThreshold) {
                    curCount++;
                }
            }
            if (curCount <= minCount) {
                minCount = curCount;
                minCity = i;
            }
        }

        return minCity;
    }

    private static void bellmanFord(int n, int[][] edges, int[] dist, int source) {
        // Loop n-1 times.
        for (int i = 0; i < n - 1; i++) {
            for (int[] edge :  edges) {
                int from = edge[0];
                int to = edge[1];
                int length = edge[2];
                if (dist[to] - dist[from] > length) {
                    dist[to] = dist[from] + length;
                }
                if (dist[from] - dist[to] > length) {
                    dist[from] = dist[to] + length;
                }
            }
        }
    }*/

    // Main idea: graph, Dijkstra
    // Time: V*E*log(V), V: vertex number, E: edge number
    // Space: V^2
    /*public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Create adjacency matrix with weight
        // Three dimensional array. For the dimension with certain length, we use [].
        List<int[]>[] adj = new ArrayList[n];
        int[][] distance = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
            distance[i][i] = 0;
        }
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        // Build the matrix.
        for (int[] edge : edges) {
            // From edge[0] to edge[1].
            adj[edge[0]].add(new int[]{edge[1], edge[2]});
            // From edge[1] to edge[0].
            adj[edge[1]].add(new int[]{edge[0], edge[2]});
        }

        for (int i = 0; i < n; i++) {
            // Time: E*log(V)
            dijkstra(n, adj, distance[i], i);
        }

        int minCity = -1;
        int minCount = n;

        for (int i = 0; i < n; i++) {
            int curCount = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (distance[i][j] <= distanceThreshold) {
                    curCount++;
                }
            }
            if (curCount <= minCount) {
                minCount = curCount;
                minCity = i;
            }
        }

        return minCity;
    }

    private static void dijkstra(int n, List<int[]>[] adj, int[] dist, int source) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        pq.add(new int[]{source, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int to = cur[0];
            int curDistance = cur[1];
            if (curDistance > dist[to]) {
                continue;
            }
            for (int[] next : adj[to]) {
                if (dist[next[0]] > curDistance + next[1]) {
                    dist[next[0]] = curDistance + next[1];
                    pq.offer(new int[]{next[0], dist[next[0]]});
                }
            }
        }
    }*/
}
