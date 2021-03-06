package grid;

import java.util.Iterator;

/**
 * Iterates through a grid in raster scan fashion, i.e. (0,0) -> (n,0) -> (0,1), etc.
 * Returns every possible GridPoint in turn.
 */
public class GridPointIterator extends GridIterator implements
		Iterator<GridPoint> {

	public GridPointIterator(Square[][] array) {
		super(array);
		this.reset();
	}

	public boolean hasNext() {
		if (this.done) return false;
		else return true;
	}

	public GridPoint next() {
		GridPoint result = new GridPoint(x, y);
		this.step();
		return result;
	}

}
