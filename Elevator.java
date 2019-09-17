/******************************
 * name: Aladin Sidahmed
 * CSCIE-55 HW 1
 * date: 15 SEP 2019
 ******************************/
 package cscie55.hw1.elevator;
 
public class Elevator {

    final static int FLOORS = 7;
    private int passengers; // integer value holds the number of passengers in the elevator
    private int currentFloor;
    private boolean directionOfTravel;	// true is up, false is down
    private int [] floorPassengers;

    public Elevator(){
		/*
		Default constructor to the Elevator class. Initiates values of the class members
		*/
		
        // The class should have a no-argument constructor that sets up the elevator's state.
        this.passengers = 0; // initiate the empty elevator
        this.currentFloor = 1;	// ground floor is 1
        this.directionOfTravel = true;	// true is up, false is down
        this.floorPassengers = new int[FLOORS+1]; // will keep my FLOORS numbered 1-7
        for(int i = 0; i < FLOORS+1 ; i++){
            this.floorPassengers[i] = 0;
        }
    }

    public void move(){
		/*
		Increments or decrements the floor number depending on the elevator's 
		direction of travel. If the elevator reaches the final floor for that direction,
		it reverses the direction of travel to prevent array overflow. Finally, sets the 
		floor value to zero to indicate that the passengers have stepped off the elevator
		at their designated floor.
		*/
        // Increments/decrements the current floor, i.e. the
        // Elevator moves one floor at a time.
        if(directionOfTravel == true){ // moving up
            this.currentFloor++;
        }else{
            this.currentFloor--;
        }

        //Modifies the direction of travel, if the
        //ground floor or top floor has been reached.
        if(this.currentFloor == FLOORS){
            //top floor
            this.directionOfTravel = false; // move down
        }else if(this.currentFloor == 1){
            // 1 is my ground floor
            this.directionOfTravel = true; // moving up
        }

        //Clears the array entry tracking the number of passengers
        //destined for the floor that the elevator has just arrived at.
        passengers -= floorPassengers[currentFloor];
        floorPassengers[currentFloor] = 0;

        //For each floor, if it stops or not, the move() method prints
        //out the status of the Elevator [see toString() method below]
        System.out.println(this.toString());
    }

    public void boardPassenger(int destinationFloor){
        /*This method adds to the Elevator one passenger destined for the indicated floor.*/
        passengers++; //adds a new passenger to the
        floorPassengers[destinationFloor]++;
    }


    public String toString(){
		/*
		returns a string value indicating the current floor and the number of passengers
		still in the elevator
		*/
        String result = "Floor "+ this.currentFloor +": "+ passengers+" passengers\n";
        return result;
    }

}
