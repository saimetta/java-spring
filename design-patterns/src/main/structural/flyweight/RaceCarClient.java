package main.structural.flyweight;

public class RaceCarClient {
	
    private RaceCar raceCar;
    /**
     * The extrinsic state of the flyweight is maintained by the client
     */
    private int currentX = 0;
    private int currentY=0;
    
    public RaceCarClient(String name) {
        raceCar = CarFactory.getRaceCar(name);
    }
     
    public void moveCar(int newX, int newY){
    	/*Car movement is handled by the flyweight object*/
        raceCar.moveCar(currentX,
                currentY, newX, newY);
        currentX = newX;
        currentY = newY;
    }

	public RaceCar getRaceCar() {
		return raceCar;
	}

	public int getCurrentX() {
		return currentX;
	}

	public int getCurrentY() {
		return currentY;
	}
}