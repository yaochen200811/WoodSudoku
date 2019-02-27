package SudokuGame;

import java.util.ArrayList;

public class SudokuModel {
	Board board;
	boolean isEditing;
	int editIndex[];
	
	public SudokuModel() {
		board = new Board();
		isEditing = false;
		editIndex = new int[2];
	}
	
	public int genNewGame() {
		ArrayList<Integer> avalNums;
		int randIndex = 0;
		boolean haveAval = true;
		for (int x = 0; x < 9 && haveAval; x ++) {
			for (int y = 0; y < 9  && haveAval; y ++) {
				avalNums = board.getAvalNum(x,y);
				if (avalNums.size() == 0) {
					haveAval = false;
				}else {
					randIndex = (int)(Math.random() * avalNums.size());
					board.setNum(x, y, avalNums.get(randIndex));
				}
			}
		}
		if (!haveAval) {
			board = new Board();
			return 1 + genNewGame();
		}
		return 1;
	}
	
	public void diGenGame() {
		int diCount = (int)(Math.random() * 20 + 35);
		int randX = 0;
		int randY = 0;
		while (diCount > 0) {
			randX = (int)(Math.random() * 9);
			randY = (int)(Math.random() * 9);
			if (board.getNum(randX, randY) > 0) {
				board.setNum(randX, randY, -1);
				diCount --;
			}
		}
	}
	
	public boolean checkFin() {
		return true;
	}

}
