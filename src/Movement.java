
public enum Movement {
	N(0,1), NE(1,1), E(1,0), SE(1,-1), S(0,-1), SW(-1,-1), W(-1,0), NW(-1,1);
	
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

}
