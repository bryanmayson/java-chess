package engine.board;

import engine.pieces.Piece;

/**
 * @author bmayson
 *
 */
public abstract class Tile {

	int tileCoordinate;
	
	public Tile(int tileCoordinate) {
		this.tileCoordinate = tileCoordinate;
	}

	public abstract boolean isTileOccupied();
	
	public abstract Piece getPiece();
	
	
	/*EmptyTile subclass*/
	public static final class EmptyTile extends Tile{
		public EmptyTile(int coordinate) {
			super(coordinate);
		}
		@Override
		public boolean isTileOccupied() {
			return false;
		}
		@Override
		public Piece getPiece() {
			return null;
		}
		
	}
	
	/*OccupiedTile subclass*/
	public static final class OccupiedTile extends Tile{
		Piece pieceOnTile;
		
		public OccupiedTile(int coordinate, Piece pieceOnTile) {
			super(coordinate);
			this.pieceOnTile = pieceOnTile;
		}
		
		@Override
		public boolean isTileOccupied() {
			return true;
		}
		
		@Override
		public Piece getPiece() {
			return this.pieceOnTile;
		}
		
	}
	
}
