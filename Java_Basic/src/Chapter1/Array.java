package Chapter1;

public class Array {
    public static void main(String[] args) {
        int[] numbers = {3, 4, 7, 10, 15, 20};

        System.out.print("짝수: ");
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                System.out.print(numbers[i] + " ");
            }
        }

        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        System.out.println("누적합: " + sum);

        boolean[][] board = {
                {true, false},
                {false, true}
        };

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j]) {
                    System.out.println("검은돌(●) 위치: (" + i + "," + j + ")");
                }
            }
        }
    }
}
