// https://leetcode.com/problems/reconstruct-itinerary/

import java.util.*;

public class Cp0332 {
    public static void main(String args[]) {

    }

    // Main idea: Eulerian path algorithm
    // Time: O(nlogn), nlogn: priority queue. Eulertian path algorithm o(n).
    // Space: O(n)
    public static List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> flights = new HashMap<>();
        LinkedList<String> path = new LinkedList<>();
        for (List<String> ticket : tickets) {
            flights.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            flights.get(ticket.get(0)).add(ticket.get(1));
        }
        findEulerianPath(flights, path, "JFK");
        return path;
    }

    private static void findEulerianPath(
            Map<String, PriorityQueue<String>> flights, LinkedList<String> path, String departure) {
        PriorityQueue<String> arrivals = flights.get(departure);
        while (arrivals != null && !arrivals.isEmpty()) {
            findEulerianPath(flights, path, arrivals.poll());
        }
        path.addFirst(departure);
    }
}
