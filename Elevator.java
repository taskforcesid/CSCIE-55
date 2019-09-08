package cscie55.hw1.elevator; 
/******************************
* name: Aladin Sidahmed	
* CSCIE-55 HW 1
* date: 08 SEP 2019
******************************/
public class Elevator {
	
	final static int floors = 7;
	
	private int passengers;
	private int currentFloor;
	private boolean directionOfTravel;	// true is up, false is down 
	private int [] floorPassengers;
	
	public int getCurrentFloor(){
		return this.currentFloor;
	}
	
	public boolean getDirectionOfTravel(){
		return this.directionOfTravel;
	}
	
	public int getFloorPassengers(int floorNumber){
		return this.floorPassengers[floorNumber];
	}
	
	public void setCurrentFloor(int currentFloor){
		this.currentFloor = currentFloor;
	}
	
	public void setDirectionOfTravel(boolean directionOfTravel){
		this.directionOfTravel = directionOfTravel;
	}
	
	public void setFloorPassengers(int floorNumber, int passengers){
		this.floorPassengers[floorNumber] = passengers;
	}
	
	public Elevator(){
		// The class should have a no-argument constructor that sets up the elevator's state.
		this.currentFloor = 1;	// ground floor is 1
		this.directionOfTravel = true;	// true is up, false is down 
		this.floorPassengers = new int[floors+1]; // will keep my floors numbered 1-7
		for(int i = 0; i < floors+1 ; i++){
			this.floorPassengers[i] = 0;
		}
	}
	
	public void move(){
		// Increments/decrements the current floor, i.e. the 
		// Elevator moves one floor at a time.
		if(getDirectionOfTravel()){ // movingup
			setCurrentFloor(getCurrentFloor()+1);
		}else{
			setCurrentFloor(getCurrentFloor()-1);
		}
			
		//Modifies the direction of travel, if the 
		//ground floor or top floor has been reached.
		if(getCurrentFloor() == floors){
			//top floor
			setDirectionOfTravel(false); // move down
		}else if(getCurrentFloor() == 1){
			// 1 is my ground floor
			setDirectionOfTravel(true); // moving up
		}
		
		//Clears the array entry tracking the number of passengers 
		//destined for the floor that the elevator has just arrived at.
		setFloorPassengers(getCurrentFloor(),0);
		
		//For each floor, if it stops or not, the move() method prints 
		//out the status of the Elevator [see toString() method below]
	}
	
	public String toString(){
		int numberOfPassengers = 0;
		for(int i = 0 ; i <= floors; i++){
			numberOfPassengers += getFloorPassengers(i);
		}			
		
		String result = "Floor "+ this.getCurrentFloor() +": + numberOfPassengers +" passengers"
		return result;
	}

}
