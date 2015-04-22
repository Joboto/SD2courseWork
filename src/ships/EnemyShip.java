package ships;
import grid.Grid;
import interfaces.CharacteristicMove;


public abstract class EnemyShip extends Ship implements CharacteristicMove {
	private int points;

	public EnemyShip(Grid grid) {
		super(grid);
		// TODO Auto-generated constructor stub
	}

	public int getPoints() {
		return this.points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

}
