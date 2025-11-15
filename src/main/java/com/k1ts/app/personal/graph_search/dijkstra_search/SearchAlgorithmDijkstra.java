package com.k1ts.app.personal.graph_search.dijkstra_search;

import java.util.*;

public class SearchAlgorithmDijkstra {

    public static void main(String[] args) {
        new SearchAlgorithmDijkstra().estimatePath();
    }

    private void estimatePath() {
    }

    int[] dijkstra(Map<Integer, List<Edge>> graph, int source, int n, int[] prev) {
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

    List<Integer> reconstructPath(int[] prev, int target) {
        LinkedList<Integer> path = new LinkedList<>();

        for (int at = target; at != -1; at = prev[at]) {
            path.addFirst(at);
        }

        return path;
    }

    static class Edge {

        private int to;

        private int weight;

        Edge(int to, int weight) {
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
