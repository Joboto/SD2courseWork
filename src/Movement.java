
public enum Movement {
	 NW(-1,-1), N(0,-1), NE(1,-1), W(-1,0), O(0,0), E(1,0), SW(-1,1), S(0,1), SE(1,1);
	
	private int x;
	private int y;
	
	private Movement (int xdir, int ydir){
		x = xdir;
		y = ydir;
	}
	
	public int xChange(){
		return x;
	}
	
	public int yChange(){
		return y;
	}
	
	public static Movement vector(Square start, Square end){
		Movement output = Movement.O;
		int xDiff = end.getX() - start.getX();
		int yDiff = end.getY() - start.getY();
		xDiff = (int) Math.signum(xDiff);
		yDiff = (int) Math.signum(yDiff);
		
		for(Movement move : Movement.values()){
			if(move.x == xDiff && move.y == yDiff){
				output = move;
				break;
			}
		}
		return output;
	}
	

}
