package engine.board;

import engine.pieces.Piece;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableMap;


/**
 * @author bmayson
 *
 */
public abstract class Tile {

	protected final int tileCoordinate;
	// All the tiles in the board
	private static final Map<Integer,EmptyTile> EMPTY_TILES = createAllPossibleEmptyTiles();
	
	//Generating all the tiles
	private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles() {
		final Map<Integer,EmptyTile> emptyTileMap = new HashMap<>();
		
		for(int i = 0 ; i<64;i++) {
			emptyTileMap.put(i,new EmptyTile(i));
		}
		
		return ImmutableMap.copyOf(emptyTileMap);
	}
	
	// Function to create a tile
	public static Tile createTile(final int tileCoordinate,final Piece piece) {
		return piece != null ? new OccupiedTile(tileCoordinate,piece):EMPTY_TILES.get(tileCoordinate);
	}
	
	private Tile(int tileCoordinate) {
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
		private final Piece pieceOnTile;
		
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
