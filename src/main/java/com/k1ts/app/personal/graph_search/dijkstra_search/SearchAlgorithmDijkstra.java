package com.k1ts.app.personal.graph_search.dijkstra_search;

import java.util.*;

public class SearchAlgorithmDijkstra {

    public static void main(String[] args) {
        new SearchAlgorithmDijkstra().estimatePath();
    }

    private void estimatePath() {
        int[] prev = new int[5];
        int[] dijkstra = dijkstra(buildGraphDirected(), 0, 5, prev);
        System.out.println(reconstructPath(prev, 4));
    }

    private Map<Integer, List<Edge>> buildGraphDirected() {
        Map<Integer, List<Edge>> g = new HashMap<>();
        for (int i = 0; i < 5; i++) g.put(i, new ArrayList<>());

        // vertices mapping: 0=A, 1=B, 2=C, 3=D, 4=E
        g.get(0).add(new Edge(1, 4));  // A -> B (4)
        g.get(0).add(new Edge(2, 2));  // A -> C (2)
        g.get(1).add(new Edge(2, 1));  // B -> C (1)
        g.get(1).add(new Edge(3, 5));  // B -> D (5)
        g.get(2).add(new Edge(3, 8));  // C -> D (8)
        g.get(2).add(new Edge(4, 10)); // C -> E (10)
        g.get(3).add(new Edge(4, 2));  // D -> E (2)
        g.get(4).add(new Edge(3, 2));  // E -> D (2)
        return g;
    }

    private int[] dijkstra(Map<Integer, List<Edge>> graph, int source, int n, int[] prev) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);
        dist[source] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(source, 0));

        boolean[] visited = new boolean[n];

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;

            if (visited[u]) {
                continue;
            }

            visited[u] = true;

            for (Edge edge : graph.get(u)) {
                int v = edge.to;
                int weight = edge.weight;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    prev[v] = u;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }

        return dist;
    }

    private List<Integer> reconstructPath(int[] prev, int target) {
        LinkedList<Integer> path = new LinkedList<>();

        for (int at = target; at != -1; at = prev[at]) {
            path.addFirst(at);
        }

        return path;
    }

    private class Edge {

        private int to;

        private int weight;

        private Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    private class Node implements Comparable<Node> {

        private int vertex;

        private int dist;

        private Node(int vertex, int dist) {
            this.vertex = vertex;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node node) {
            return Integer.compare(this.dist, node.dist);
        }
    }
}
