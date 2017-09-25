package graph;

import java.util.*;

public class CheeseGame {

    private int count = 0;

    private Set<List<Integer>> cheeses = new HashSet<>();
    public int shortestTour(int[][] maze, List<Integer> src) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == 2) {
                    cheeses.add(Arrays.asList(j, i));
                }
            }
        }

        List<Integer> startingCoord = src;
        while(!cheeses.isEmpty()) {
            startingCoord = shortestTourHelper(maze, startingCoord);
        }

        return count;
    }

    private List<List<Integer>> getSuccessors(int[][] maze, List<Integer> coord) {
        List<List<Integer>> successors = new ArrayList<>();
        if (coord.get(1) + 1 < maze.length) {
            successors.add(Arrays.asList(coord.get(0), coord.get(1)+1));
        }
        if (coord.get(1) - 1 >= 0) {
            successors.add(Arrays.asList(coord.get(0), coord.get(1) - 1));
        }
        if (coord.get(0) + 1 < maze[0].length) {
            successors.add(Arrays.asList(coord.get(0) + 1, coord.get(1)));
        }
        if (coord.get(0) - 1 >= 0) {
            successors.add(Arrays.asList(coord.get(0) - 1, coord.get(1)));
        }
        return successors;
    }

    private List<Integer> shortestTourHelper(int[][] maze, List<Integer> startingCoord) {
       int[][][] previousCoordinates = new int[maze.length][maze[0].length][2];
        Queue<List<Integer>> fringe = new LinkedList<>();
        fringe.add(startingCoord);
        Set<List<Integer>> visited = new HashSet<>();
        List<Integer> endingCoordinate = new ArrayList<>();
        while(!fringe.isEmpty()) {
            List<Integer> exploring = fringe.remove();
            Integer y = exploring.get(1);
            Integer x = exploring.get(0);
            visited.add(exploring);
            if (maze[y][x] == 2) {
                maze[y][x] = 0;
                List<Integer> dest = Arrays.asList(x, y);
                endingCoordinate.addAll(dest);
                cheeses.remove(dest);
                int iterY = y;
                int iterX = x;
                while(!startingCoord.equals(Arrays.asList(iterX, iterY))) {
                    iterY = previousCoordinates[iterY][iterX][1];
                    iterX = previousCoordinates[iterY][iterX][0];
                    this.count += 1;
                }
                return endingCoordinate;
            } else {
                for (List<Integer> next : getSuccessors(maze, exploring)) {
                    if (!visited.contains(next) && maze[next.get(1)][next.get(0)] != 1) {
                        fringe.add(next);
                        previousCoordinates[next.get(1)][next.get(0)] = new int[]{exploring.get(0), exploring.get(1)};
                    }
                }
            }
        }
        return endingCoordinate;
    }

    public static void main(String...args) {
        int[][] maze = {
                {0, 0, 2},
                {0, 1, 1},
                {0, 0, 2}
        };

        CheeseGame cheeseGame = new CheeseGame();
        System.out.println(cheeseGame.shortestTour(maze, Arrays.asList(0, 2)));
    }
}
