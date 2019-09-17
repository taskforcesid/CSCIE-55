/******************************
 * name: Aladin Sidahmed
 * CSCIE-55 HW 1
 * date: 15 SEP 2019
 ******************************/
 
package cscie55.hw1.elevator;
import cscie55.hw1.elevator.Elevator;

public class ElevatorTest {
    public static void main(String []args) {
		
		/*
		main method: creates an instance of the Elevator object,
		then boards three passengers, two passengers to the 3rd
		floor, and one passenger to the 5th. 
		Then runs a loop calling the move method to have the elevator
		go to the top of the building then back to the bottom floor.
		*/
		
        //Create an instance of an Elevator object.
        Elevator myElevator = new Elevator();
        //Board two passengers for the 3nd floor, and one for the 5th floor.
        myElevator.boardPassenger(3);
        myElevator.boardPassenger(3);
        myElevator.boardPassenger(5);

        System.out.println(myElevator.toString());

        for (int i = 0; i < 12; i++) {
            myElevator.move();
        }
    }
}
