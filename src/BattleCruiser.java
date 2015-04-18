
public class BattleCruiser extends EnemyShip implements Observer {
	/**
	 * As design pattern observer, should really implement DisplayElement too; not sure the method will be used in this context.
	 * 
	 */
	private Square masterPosition;
	
	public BattleCruiser(Grid grid) {
		super(grid);
		setPoints(10);
	}

	@Override // Maybe change return type to Square, then no need for masterPosition
	public void update(Square masterPosition) {
		this.masterPosition = masterPosition;
	}
	
	@Override
	public void characteristicMove() {
		Movement move = Movement.vector(this.getPosition(), this.masterPosition);
		this.move(move);
	}
	
	

}
