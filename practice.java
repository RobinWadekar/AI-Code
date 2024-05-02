import java.util.*;
public class practice {

    // static class Edge {
    //     int source;
    //     int destination;
    //     Edge(int s, int d) {
    //         source = s;
    //         destination = d;
    //     }
    // }
    // static Scanner sc = new Scanner(System.in);
    // public static void bfs_dfs(ArrayList<Edge>[] g) {
    //     Queue<Integer> q = new LinkedList<>();
    //     q.add(0);
    //     boolean []visited = new boolean[g.length];
    //     System.out.println("\nBFS Traversal : ");
    //     practice_bfs(g, q, visited);
    //     Stack<Integer> s = new Stack<>();
    //     s.push(0);
    //     visited = new boolean[g.length];
    //     System.out.println("\nDFS Traversal : ");
    //     practice_dfs(g, s, visited);
    // }
    // public static void practice_bfs(ArrayList<Edge>[] g, Queue<Integer> q, boolean[] visited) {
    //     if(q.isEmpty()) {
    //         return;
    //     }
    //     int currIdx = q.poll();
    //     for (int i = 0; i < g[currIdx].size(); i++) {
    //         if(!visited[currIdx]) {
    //             Edge curr = g[currIdx].get(i);
    //             System.out.println(curr.source);
    //             visited[currIdx] = true;
    //             for (Edge neighbor : g[currIdx]) {
    //                 if(!visited[neighbor.destination]) {
    //                     q.add(neighbor.destination);
    //                 }
    //             }
    //         }
    //     }
    //     if(!q.isEmpty()) {
    //         practice_bfs(g, q, visited);
    //     }
    // }
    // public static void practice_dfs(ArrayList<Edge>[] g, Stack<Integer> s, boolean[] visited) {
    //     if(s.isEmpty()) {
    //         return;
    //     }
    //     int currIdx = s.pop();
    //     if(!visited[currIdx]) {
    //         Edge curr = g[currIdx].get(0);
    //         System.out.println(curr.source);
    //         s.push(curr.destination);
    //         visited[currIdx] = true;
    //         for (Edge neighbor : g[currIdx]) {
    //             if (!visited[neighbor.destination]) {
    //                 s.push(neighbor.destination);
    //                 practice_dfs(g, s, visited);
    //             }
    //         }
    //     }
    // }
    // public static void main(String[] args) {
    //     System.out.print("Enter n : ");
    //     int n = sc.nextInt();
    //     ArrayList<Edge>[] graph = new ArrayList[n];
    //     for (int i = 0; i < graph.length; i++) {
    //         graph[i] = new ArrayList<>();
    //     }
    //     for (int i = 0; i < graph.length; i++) {
    //         System.out.print("Enter how many neighbour "+i+" has : ");
    //         int m = sc.nextInt();
    //         for (int j = 0; j < m; j++) {
    //             graph[i].add(new Edge(i, sc.nextInt()));
    //         }
    //     }
    //     bfs_dfs(graph);
    // }

    // static Scanner sc = new Scanner(System.in);
    // static class Job {
    //     int id;
    //     int profit;
    //     int deadline;
    //     Job(int id, int p, int d) {
    //         this.id = id;
    //         profit = p;
    //         deadline = d;
    //     }
    // }
    // public static void selection() {
    //     System.out.println();
    //     System.out.print("Enter the value of n : ");
    //     int n = sc.nextInt();
    //     int []arr = new int[n];
    //     for (int i = 0; i < arr.length; i++) {
    //         arr[i] = sc.nextInt();
    //     }
    //     System.out.println();
    //     for (int elem : arr) {
    //         System.out.println(elem);
    //     }
    //     System.out.println();
    //     for (int i = 0; i < arr.length-1; i++) {
    //         int min = i;
    //         for (int j = i+1; j < arr.length; j++) {
    //             if(arr[j] < arr[min]) {
    //                 min = j;
    //             }
    //         }
    //         int temp = arr[i];
    //         arr[i] = arr[min];
    //         arr[min] = temp;
    //     }
    //     System.out.println();
    //     for (int elem : arr) {
    //         System.out.println(elem);
    //     }
    // }
    // public static void scheduling() {
    //     System.out.println();
    //     System.out.print("Enter the value of n : ");
    //     int n = sc.nextInt();
    //     ArrayList<Job> jobs = new ArrayList<>();
    //     System.out.println("Enter each Job's Slot & profit : ");
    //     for (int i = 0; i < n; i++) {
    //         jobs.add(new Job(i, sc.nextInt(), sc.nextInt()));
    //     }
    //     System.out.println("\nJobs : ");
    //     for (Job currJob : jobs) {
    //         System.out.println("J"+currJob.id+"  "+currJob.slot+"  "+currJob.profit);
    //     }
    //     Collections.sort(jobs, (a, b) -> b.profit-a.profit);
    //     System.out.print("\nJobs Scheduling Order : ");
    //     for (int i = 0; i < jobs.size(); i++) {
    //         int maxId = -1;
    //         int maxProfit = Integer.MIN_VALUE;
    //         for (int j = 0; j < jobs.size(); j++) {
    //             Job curr = jobs.get(j);
    //             if(curr.slot == i && curr.profit > maxProfit) {
    //                 maxProfit = curr.profit;
    //                 maxId = curr.id;
    //             }
    //         }
    //         if(maxId != -1) {
    //             System.out.print("J"+maxId+"  ");
    //         }
    //     }
    // }
    // public static void main(String[] args) {
    //     selection();
    //     scheduling();
    // }

    static Scanner sc = new Scanner(System.in);
    static char [][]Board;
    public static void initializingStuff() {
        System.out.print("Enter n : ");
        int n = sc.nextInt();
        Board = new char[n][n];
        for (int i = 0; i < Board.length; i++) {
            for (int j = 0; j < Board.length; j++) {
                Board[i][j] = 'x';
            }
        }
    }
    public static boolean isSafe(int row, int col) {
        for (int i = 0; i < Board.length; i++) {
            if(Board[i][col] == 'Q') {
                return false;
            }
        }
        int i = row, j = col;
        while (i > -1 && j > -1) {
            if(Board[i][j] == 'Q') {
                return false;
            }
            i--; j--;
        }
        i = row; j = col;
        while (i > -1 && j < Board.length) {
            if(Board[i][j] == 'Q') {
                return false;
            }
            i--; j++;
        }
        i = row; j = col;
        while (i < Board.length && j > -1) {
            if(Board[i][j] == 'Q') {
                return false;
            }
            i++; j--;
        }
        i = row; j = col;
        while (i < Board.length && j < Board.length) {
            if(Board[i][j] == 'Q') {
                return false;
            }
            i++; j++;
        }
        return true;
    }
    public static boolean nQueen(int row) {
        if(row == Board.length) {
            return true;
        }
        for (int col = 0; col < Board.length; col++) {
            if(isSafe(row, col)) {
                Board[row][col] = 'Q';
                if(nQueen(row+1)) {
                    return true;
                }
                Board[row][col] = 'x';
            }
        }
        return false;
    }
    public static void printBoard() {
        System.out.println("\n----------Board----------");
        for (int i = 0; i < Board.length; i++) {
            for (int j = 0; j < Board.length; j++) {
                System.out.print(Board[i][j]+"  ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        System.out.println();
        initializingStuff();
        printBoard();
        if(nQueen(0)) {
            printBoard();
        } else {
            System.out.println("No solution");
        }
    }
}