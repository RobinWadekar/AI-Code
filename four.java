import java.util.*;
public class four {
    static Scanner sc = new Scanner(System.in);
    public static void takeInput(char []arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = 'x';
            }
        }
    }
    public static void printArr(char []arr[]) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]+"  ");
            }
            System.out.println();
        }
    }
    public static boolean isSafe(char arr[][], int row, int col) {
        for (int i = 0; i < row; i++) {
            if(arr[i][col] == 'Q') {
                return false;
            }
        }
        int i = row, j = col;
        while (i > -1 && j > -1) {
            if(arr[i][j] == 'Q') {
                return false;
            }
            i--; j--;
        }
        i = row; j = col;
        while (i > -1 && j < arr.length) {
            if(arr[i][j] == 'Q') {
                return false;
            }
            i--; j++;
        }
        i = row; j = col;
        while (i < arr.length && j > -1) {
            if(arr[i][j] == 'Q') {
                return false;
            }
            i++; j--;
        }
        i = row; j = col;
        while (i < arr.length && j < arr.length) {
            if(arr[i][j] == 'Q') {
                return false;
            }
            i++; j++;
        }
        return true;
    }
    public static boolean nQueen(char board[][], int row) {
        if(row == board.length) {
            return true;
        }
        for (int col = 0; col < board[row].length; col++) {
            if(isSafe(board, row, col)) {
                board[row][col] = 'Q';
                if(nQueen(board, row+1)) {
                    return true;
                }
                board[row][col] = 'x';
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.print("\nEnter the value of n : ");
        int n = sc.nextInt();
        char Board[][] = new char[n][n];
        takeInput(Board);
        printArr(Board);
        if(nQueen(Board, 0)) {
            printArr(Board);
        } else {
            System.out.println("\nNo Solution for n = "+n+" Queen Problem.");
        }
    }
}