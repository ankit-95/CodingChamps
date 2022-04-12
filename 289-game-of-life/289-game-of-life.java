class Solution {
    public void gameOfLife(int[][] board) {
		int m = board.length;
		int n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				checkAndUpdate(board, i, j);
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = board[i][j] >= 1 ? 1 : 0;
			}
		}
	}

	private void checkAndUpdate(int[][] board, int i, int j) {
		int m = board.length;
		int n = board[0].length;
		int count = 0;
		int[][] indexes = { { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 }, { -1, -1 }, { -1, 0 }, { -1, 1 } };
		for (int[] index : indexes) {
			if (i + index[0] < 0 || i + index[0] >= m || j + index[1] < 0 || j + index[1] >= n) {
				continue;
			}
			if (Math.abs(board[i + index[0]][j + index[1]]) == 1) {
				count++;
			}
		}
		if (board[i][j] == 0 && count == 3) {
			board[i][j] = 2;
		} else if (board[i][j] == 1 && (count < 2 || count > 3)) {
			board[i][j] = -1;
		}
	}
}