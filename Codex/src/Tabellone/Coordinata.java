package Tabellone;

public class Coordinata {

	private final int x;
	private final int y;

	protected Coordinata(int x, int y) {
		this.x = x;
		this.y = y;
	}

	protected Coordinata() {
		this.x = 0;
		this.y = 0;
	}

	protected int getX() {
		return x;
	}

	protected int getY() {
		return y;
	}
}
