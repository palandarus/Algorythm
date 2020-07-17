package hw6;

public class Main {
    private static int board[][] = new int[8][8];
    private static void printBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static boolean checkQueen(int x, int y) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] != 0)
                    if (!(i == x && j == y)) {
                        if (i - x == 0 || j - y == 0) return false;
                        if (Math.abs(i - x) == Math.abs(j - y)) return false;
                    }
            }
        }
        return true;
    }
    private static boolean checkBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] != 0)
                    if (!checkQueen(i, j))
                        return false;
            }
        }
        return true;
    }
    private static boolean queens(int n) {
        if (!checkBoard()) return false;
        if (n == 9) return true;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = n;
                    if (queens(n + 1))
                        return true;
                    board[i][j] = 0;
                }
            }
        }
        return false;
    }

    private static int operations = 0;
    private static void put(int from, int to) {
        System.out.printf("%d -> %d | ", from, to);
        if (++operations % 10 == 0) System.out.print('\n');
    }
    private static void tower(int height, int from, int to) {
        int temp = from ^ to; // 1^2=3; 1^3=2; 2^3=1
        if (height == 1) {
            put(from, to);
        } else {
            tower(height - 1, from, temp);
            put (from, to);
            tower(height - 1, temp, to);
        }
    }

    public static void main(String[] args) {
        /*queens(1);
        printBoard();
        tower(8, 1, 3);
        System.out.println("\noperations: " + operations);*/

        final int TREES_COUNT=60;

        int balanced=0;
        for (int i = 0; i < TREES_COUNT; i++) {
            Tree t=new Tree(10000);
            balanced+=t.isBalanced(t.root)? 1: 0;
        }
        System.out.println(balanced);
        System.out.println("Balanced trees percentage "+balanced*100f/TREES_COUNT+ "%");
    }

}
