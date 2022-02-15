package tictactoe;

import java.util.Scanner;

public class Main {
    public static int count = 0;
    public static int empty = 9;
    public static void main(String[] args) {
        char[][] marix = new char[3][3];
        startGame(marix);
        prefix();
        while (true) {
            int tag = continueGame(marix);
            if (tag == 1) {
                judgeResult(marix);
                break;
            }
        }
        // write your code here
    }

    private static void judgeResult(char[][] marix) {
        for(char[] a : marix){
            if(a[0]==a[1] &&a[1]==a[2] ){
                if (a[0] =='X'){
                    System.out.println("X wins");
                    return;
                }else if (a[0]=='O'){
                    System.out.println("O wins");
                    return;
                }
            }
        }
        for(int i =0;i<3;i++){
            if(marix[i][0]==marix[i][1] &&marix[i][1]==marix[i][2]){
                if (marix[i][0]=='X'){
                    System.out.println("X wins");
                    return;
                }else if (marix[i][0]=='O'){
                    System.out.println("O wins");
                    return;
                }
            }
        }
        if(marix[0][0]==marix[1][1]&&marix[1][1]==marix[2][2]){
            if (marix[0][0]=='X'){
                System.out.println("X wins");
                return;
            }else if (marix[0][0]=='O'){
                System.out.println("O wins");
                return;
            }
        }else if (marix[0][2]==marix[1][1]&&marix[1][1]==marix[2][0]){
            if (marix[1][1]=='X'){
                System.out.println("X wins");
                return;
            }else if (marix[0][2]=='O'){
                System.out.println("O wins");
                return;
            }
        }
        System.out.println(empty == 0 ? "Draw" : "Game not finished");
    }

    private static void prefix() {
        System.out.print("Enter the coordinates: ");
    }

    public static void startGame(char[][] marix) {
        System.out.print("Enter the cells: ");
        Scanner scanner = new Scanner(System.in);
        String gets = scanner.nextLine();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char getin = gets.charAt(i * 3 + j);
                marix[i][j] = getin;
                if (getin == 'X') {
                    count++;
                    empty--;
                } else if (getin == 'O') {
                    count--;
                    empty--;
                }
            }
        }
        printPlat(marix);
    }

    public static int continueGame(char[][] marix) {
        Scanner scanner = new Scanner(System.in);
        try {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (a > 3 || a < 1 || b > 3 || b < 1) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else if (marix[a - 1][b - 1] == '_') {
                if (count == 1) {
                    marix[a - 1][b - 1] = 'O';
                    count--;
                    empty--;
                } else {
                    marix[a - 1][b - 1] = 'X';
                    count++;
                    empty--;
                }
                printPlat(marix);
                return 1;
            } else {
                System.out.println("This cell is occupied! Choose another one!");
                return -1;
            }
        } catch (Exception e) {
            System.out.println("You should enter numbers!");
            return -1;
        }
        return -1;
    }

    private static void printPlat(char[][] marix) {
        System.out.println("---------");

        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(marix[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }


}
