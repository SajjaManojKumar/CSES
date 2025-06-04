package com.manojkumarsajja.learn.GraphAlgorithms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KnightsTour {
    private static final int[][] dir = {{2, 1}, {1, 2}, {2, -1}, {-1, 2}, {-2, 1}, {1, -2}, {-2, -1}, {-1, -2}};

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        int x = in.nextInt() - 1;
        int y = in.nextInt() - 1;
        int[][] board = new int[8][8];
        board[y][x] = 1;
        int step = 2;

        knightMove(y, x, board, step);
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }

        in.close();
    }

    private static boolean knightMove(int y, int x, int[][] board, int step) {
        if (step == 65)
            return true;

        List<int[]> moves = getSortedMoves(y, x, board);
        for (int[] move : moves) {
            int dirIdx = move[1];
            int ny = y + dir[dirIdx][0];
            int nx = x + dir[dirIdx][1];
            board[ny][nx] = step;

            if (knightMove(ny, nx, board, step + 1))
                return true;

            board[ny][nx] = 0;
        }

        return false;
    }

    private static List<int[]> getSortedMoves(int y, int x, int[][] board) {
        List<int[]> moves = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            int ny = y + dir[i][0];
            int nx = x + dir[i][1];

            if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8 && board[ny][nx] == 0) {
                moves.add(new int[]{getSuccessRate(ny, nx, board), i});
            }
        }
        moves.sort((a, b) -> (a[0] - b[0]));

        return moves;
    }

    private static int getSuccessRate(int x, int y, int[][] board) {
        int sRate = 0;
        for (int[] d : dir) {
            int nx = x + d[0];
            int ny = y + d[1];

            if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8 && board[nx][ny] == 0) {
                sRate++;
            }
        }

        return sRate;
    }
}
