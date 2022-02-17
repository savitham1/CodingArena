package dailyChallenge;

import java.util.Map;
import java.util.TreeMap;

/**
 * There is a car with capacity empty seats.
 * The vehicle only drives east (i.e., it cannot turn around and drive west).
 *
 * You are given the integer capacity and an array trips
 * where trip[i] = [numPassengersi, fromi, toi] indicates that the ith trip has
 * numPassengersi passengers and the locations to pick them up and drop them off are
 * fromi and toi respectively. The locations are given as the number of kilometers due east
 * from the car's initial location.
 *
 * Return true if it is possible to pick up and drop off all passengers for all the given trips,
 * or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: trips = [[2,1,5],[3,3,7]], capacity = 4
 * Output: false
 * Example 2:
 *
 * Input: trips = [[2,1,5],[3,3,7]], capacity = 5
 * Output: true
 */
public class carPooling {

  // Sort the trips by their start location.
  // Create timestamps while calculating the total passengers on board at the time.
  // If at any point the total passengers > actual capacity => return false.
  public Boolean carPoolingSolution(int[][] trips, int capacity) {

    // Key = timestamp or location and value = the number of passengers on board.
    Map<Integer, Integer> timestamp = new TreeMap<>(); // To maintain a sorted timestamp.

    // Add each trip details to the treeMap as timestamp.
    // Gather the total number of passengers at every start and dropoff location timestamps.
    for (int[] trip : trips) {
      int onBoardingPassengers = trip[0]; // Number of people in the current trip.
      int startLocation = trip[1]; // Timestamp where passengers start their trip.
      int endLocation = trip[2]; // Timestamp where the passengers end their trip.

      // Existing passengers + new passengers on-boarding in this trip.
      int addPassenger = timestamp.getOrDefault(startLocation, 0) + onBoardingPassengers;

      // Update the count of passenger at the on-boarding timestamp.
      timestamp.put(startLocation, addPassenger);

      // Reduce the count of passenger at their drop off location.
      int removePassenger = timestamp.getOrDefault(endLocation, 0) - onBoardingPassengers;

      // Update the count of passengers at the dropOff timestamp.
      timestamp.put(endLocation, removePassenger);
    }

    int usedCapacity = 0;
    // Check if at any given point, the total passenger count is greater than the capacity.
    for (int passengerCount : timestamp.values()) {
      usedCapacity += passengerCount; // tracks the total number passengers on board.
      if (usedCapacity > capacity) {
        return false;
      }
    }
    return true;
  }
}