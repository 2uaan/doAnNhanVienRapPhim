package model;

public class gheNS {
	
	private char row;
	private int col;
	private int name;
	
	public gheNS(char row, int col) {
		super();
		this.row = row;
		this.col = col;
		this.name = row + col;
	}

	public char getRow() {
		return row;
	}

	public void setRow(char row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getName() {
		return name;
	}
	
}
