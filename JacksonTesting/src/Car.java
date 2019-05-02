

public class Car {

	private String color;
	private String type;
	
    public Car() {
        super();
    }

	public Car(String color, String type) {
		this.color = color;
		this.type = type;
	}

	public final String getColor() {
		return color;
	}

	public final void setColor(String color) {
		this.color = color;
	}

	public final String getType() {
		return type;
	}

	public final void setType(String type) {
		this.type = type;
	}
	
	public String toString() {
		return "---\nCar color: " + getColor() +
				"\nCar type: " + getType() + "\n---";
	}

}
