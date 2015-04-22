import java.util.Random;


public class BattleStar extends EnemyShip {
	private final Random random = new Random();
	
	public BattleStar(Grid grid) {
		super(grid);
		setPoints(5);
		setName("Battle Star");
	}
	
	@Override
	public void characteristicMove() {
		Movement randomMove = Movement.values()[random.nextInt(Movement.values().length)];
		this.move(randomMove);
	}

}
