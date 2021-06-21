package kenya;

import java.util.LinkedList;

public class CarLinkedList extends LinkedList<Car> implements CarInterface {

	private static final long serialVersionUID = 1L;

	@Override
	public Car first() {
		return this.first();
	}

	@Override
	public Car latest() {
		return this.latest();
	}

	@Override
	public Car higher() {
		return this.higher();
	}

	@Override
	public Car less() {
		return this.less();
	}
	
}
