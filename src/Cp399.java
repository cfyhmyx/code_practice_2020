// https://leetcode.com/problems/evaluate-division/

import java.util.*;

public class Cp399 {
    public static void main(String args[]) {
        List<List<String>> equations = new ArrayList<>();
        List<String> equation_1 = new ArrayList<>();
        equation_1.add("x1");
        equation_1.add("x2");
        List<String> equation_2 = new ArrayList<>();
        equation_2.add("x2");
        equation_2.add("x3");
        List<String> equation_3 = new ArrayList<>();
        equation_3.add("x3");
        equation_3.add("x4");
        List<String> equation_4 = new ArrayList<>();
        equation_4.add("x4");
        equation_4.add("x5");
        equations.add(equation_1);
        equations.add(equation_2);
        equations.add(equation_3);
        equations.add(equation_4);

        double[] values = new double[4];
        values[0] = 3.0;
        values[1] = 4.0;
        values[2] = 5.0;
        values[3] = 6.0;

        List<List<String>> queries = new ArrayList<>();
        List<String> query_1 = new ArrayList<>();
        query_1.add("x1");
        query_1.add("x5");
        List<String> query_2 = new ArrayList<>();
        query_2.add("x5");
        query_2.add("x2");
        List<String> query_3 = new ArrayList<>();
        query_3.add("x2");
        query_3.add("x4");
        List<String> query_4 = new ArrayList<>();
        query_4.add("x2");
        query_4.add("x2");
        List<String> query_5 = new ArrayList<>();
        query_5.add("x2");
        query_5.add("x9");
        List<String> query_6 = new ArrayList<>();
        query_6.add("x9");
        query_6.add("x9");
        queries.add(query_1);
        queries.add(query_2);
        queries.add(query_3);
        queries.add(query_4);
        queries.add(query_5);
        queries.add(query_6);

        double[] result = calcEquation(equations, values, queries);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    // Main idea: dfs.
    // Time: O(k*(V+E)), k: the number of query
    // Space: O(V+E)
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            map.putIfAbsent(equation.get(0), new HashMap<>());
            map.putIfAbsent(equation.get(1), new HashMap<>());

            // Add string itself to the map
            map.get(equation.get(0)).putIfAbsent(equation.get(0), 1.0);
            map.get(equation.get(1)).putIfAbsent(equation.get(1), 1.0);

            map.get(equation.get(0)).putIfAbsent(equation.get(1), values[i]);
            map.get(equation.get(1)).putIfAbsent(equation.get(0), 1.0 / values[i]);
        }
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            Set<String> visited = new HashSet<>();
            Double curResult = dfs(queries.get(i).get(0), queries.get(i).get(1), map, visited);
            if (curResult != null) {
                result[i] = curResult;
            } else {
                result[i] = -1.0;
            }
        }
        return result;
    }

    private static Double dfs(String start, String end, Map<String, Map<String, Double>> map, Set<String> visited) {
        if (!(map.containsKey(start) && map.containsKey(end))) return null;
        visited.add(start);
        if (map.get(start).containsKey(end)) {
            return map.get(start).get(end);
        }
        for (Map.Entry<String, Double> entry : map.get(start).entrySet()) {
            if (visited.contains(entry.getKey())) {
                continue;
            }
            Double result = dfs(entry.getKey(), end, map, visited);
            if (result != null) {
                return entry.getValue() * result;
            }
        }
        visited.remove(start);
        return null;
    }
}
