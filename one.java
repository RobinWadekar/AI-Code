import java.util.*;
public class one {
    static Scanner sc = new Scanner(System.in);
    static class Edge {
        int src;
        int des;
        Edge(int s, int d) {
            this.src = s;
            this.des = d;
        }
    }
    public static void printingGraph(ArrayList<Edge>[] g) {
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[i].size(); j++) {
                Edge curr = g[i].get(j);
                System.out.println(curr.src+"------------------"+curr.des);
            }
        }
    }
    public static void breath(ArrayList<Edge>[] g, Queue<Integer> q, boolean []visited) {
        if(q.isEmpty()) {
            return;
        }
        int currIndexing = q.poll();
        for (int i = 0; i < g[currIndexing].size(); i++) {
            Edge curr = g[currIndexing].get(i);
            if(!visited[currIndexing]) {
                System.out.println(curr.src);
                visited[currIndexing] = true;
                for (Edge neighbor : g[currIndexing]) {
                    if(!visited[neighbor.des]) {
                        q.add(neighbor.des);
                    }
                }
            }
        }
        if(!q.isEmpty()){
            breath(g, q, visited);
        }
    }
    public static void depth(ArrayList<Edge>[] g, Stack<Integer> s, boolean []visited) {
        if(s.isEmpty()) {
            return;
        }
        int currIndexing = s.pop();
        if(!visited[currIndexing]) {
            Edge curr = g[currIndexing].get(0);
            System.out.println(curr.src);
            visited[currIndexing] = true;
            for (Edge neighbor : g[currIndexing]) {
                if(!visited[neighbor.des]) {
                    s.push(neighbor.des);
                    depth(g, s, visited);
                }
            }
        }
    }
    public static void main(String[] args) {
        System.out.print("Enter the value of n : ");
        int n = sc.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < graph.length; i++) {
            System.out.print("Enter no. of neighbours "+i+" has : ");
            int m = sc.nextInt();
            for (int j = 0; j < m; j++) {
                int d = sc.nextInt();
                graph[i].add(new Edge(i,d));
            }
        }
        /*  
            0--------1
            |        |
    6-------4--------2
            |
            3--------5
        */
        printingGraph(graph);
        System.out.println();
        System.out.println("BFS Traversal : ");
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        breath(graph, q, visited);
        System.out.println();
        System.out.println("BFS Traversal : ");
        visited = new boolean[n];
        Stack<Integer> s = new Stack<>();
        s.push(0);
        depth(graph, s, visited);
    }
}