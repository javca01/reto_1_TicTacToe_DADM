package co.edu.unal.tictactoev1;

import java.util.Random;

public class TicTacToeGame {

    private char[] mBoard = new char[BOARD_SIZE];
    public static final int BOARD_SIZE = 9;

    public static final char HUMAN_PLAYER = 'X';
    public static final char COMPUTER_PLAYER = 'O';
    public static final char OPEN_SPOT = ' ';

    private Random mRand;

    public TicTacToeGame() {
        mRand = new Random();
    }

    public void clearBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            mBoard[i] = OPEN_SPOT;
        }
    }

    public void setMove(char player, int location) {
        if (mBoard[location] == OPEN_SPOT) {
            mBoard[location] = player;
        }
    }

    public int getComputerMove() {
        int move;

        for (int i = 0; i < BOARD_SIZE; i++) {
            if (mBoard[i] == OPEN_SPOT) {
                mBoard[i] = COMPUTER_PLAYER;
                if (checkForWinner() == 3) {
                    mBoard[i] = OPEN_SPOT;
                    return i;
                }
                mBoard[i] = OPEN_SPOT;
            }
        }

        for (int i = 0; i < BOARD_SIZE; i++) {
            if (mBoard[i] == OPEN_SPOT) {
                mBoard[i] = HUMAN_PLAYER;
                if (checkForWinner() == 2) {
                    mBoard[i] = OPEN_SPOT;
                    return i;
                }
                mBoard[i] = OPEN_SPOT;
            }
        }

        do {
            move = mRand.nextInt(BOARD_SIZE);
        } while (mBoard[move] != OPEN_SPOT);

        return move;
    }

    public int checkForWinner() {
        for (int i = 0; i <= 6; i += 3) {
            if (mBoard[i] == mBoard[i + 1] && mBoard[i + 1] == mBoard[i + 2]) {
                if (mBoard[i] == HUMAN_PLAYER) return 2;
                if (mBoard[i] == COMPUTER_PLAYER) return 3;
            }
        }

        for (int i = 0; i <= 2; i++) {
            if (mBoard[i] == mBoard[i + 3] && mBoard[i + 3] == mBoard[i + 6]) {
                if (mBoard[i] == HUMAN_PLAYER) return 2;
                if (mBoard[i] == COMPUTER_PLAYER) return 3;
            }
        }

        if ((mBoard[0] == mBoard[4] && mBoard[4] == mBoard[8]) ||
                (mBoard[2] == mBoard[4] && mBoard[4] == mBoard[6])) {
            if (mBoard[4] == HUMAN_PLAYER) return 2;
            if (mBoard[4] == COMPUTER_PLAYER) return 3;
        }

        for (int i = 0; i < BOARD_SIZE; i++) {
            if (mBoard[i] == OPEN_SPOT) return 0;
        }

        return 1;
    }
}
