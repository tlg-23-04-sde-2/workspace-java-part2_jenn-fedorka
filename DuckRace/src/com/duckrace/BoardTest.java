package com.duckrace;

class BoardTest {

    public static void main(String[] args) {
        //create a board object, which initialize its field
        Board board = new Board();

        board.updateBoard(3, Reward.PRIZES);
        board.updateBoard(3, Reward.DEBIT_CARD);
        board.updateBoard(10, Reward.DEBIT_CARD);
        board.updateBoard(13, Reward.DEBIT_CARD);
        board.updateBoard(1, Reward.PRIZES);
        board.updateBoard(5, Reward.DEBIT_CARD);
        board.updateBoard(3, Reward.DEBIT_CARD);
        board.show();
    }
}