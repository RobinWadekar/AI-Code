import java.util.*;
public class three {
    static Scanner sc = new Scanner(System.in);
    static class Job {
        int slot;
        int profit;
        int id;
        Job(int id, int d, int p) {
            this.id = id;
            this.profit = p;
            this.slot = d;
        }
    }
    public static void selection() {
        System.out.println();
        System.out.print("Enter the value of n : ");
        int n = sc.nextInt();
        int []arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println();
        for (int elem : arr) {
            System.out.println(elem);
        }
        System.out.println();
        for (int i = 0; i < arr.length-1; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        System.out.println();
        for (int elem : arr) {
            System.out.println(elem);
        }
    }
    public static void scheduling() {
        System.out.println();
        System.out.print("Enter the value of n : ");
        int n = sc.nextInt();
        ArrayList<Job> jobs = new ArrayList<>();
        System.out.println("Enter each Job's Slot & profit : ");
        for (int i = 0; i < n; i++) {
            jobs.add(new Job(i, sc.nextInt(), sc.nextInt()));
        }
        System.out.println("\nJobs : ");
        for (Job currJob : jobs) {
            System.out.println("J"+currJob.id+"  "+currJob.slot+"  "+currJob.profit);
        }
        Collections.sort(jobs, (a, b) -> b.profit-a.profit);
        System.out.print("\nJobs Scheduling Order : ");
        for (int i = 0; i < jobs.size(); i++) {
            int maxId = -1;
            int maxProfit = Integer.MIN_VALUE;
            for (int j = 0; j < jobs.size(); j++) {
                Job curr = jobs.get(j);
                if(curr.slot == i && curr.profit > maxProfit) {
                    maxProfit = curr.profit;
                    maxId = curr.id;
                }
            }
            if(maxId != -1) {
                System.out.print("J"+maxId+"  ");
            }
        }
    }
    public static void main(String[] args) {
        selection();
        scheduling();
    }
}