
public class BattleShooter extends EnemyShip implements Observer {
	/**
	 * As design pattern observer, should really implement DisplayElement too; not sure the method will be used in this context.
	 * 
	 */
	private Square masterPosition;

	public BattleShooter(Grid grid) {
		super(grid);
		setPoints(20);
	}

	@Override
	public void characteristicMove() {
		/**
		 * These move away from MasterShip current position.
		 * (BattleCruisers move towards)
		 * Therefore 'end' position is this.position, and start is where MasterShip.
		 */
		Movement move = Movement.vector(this.masterPosition, this.getPosition());
		this.move(move);
	}

	@Override
	public void update(Square masterPosition) {
		this.masterPosition = masterPosition;
	}

}
