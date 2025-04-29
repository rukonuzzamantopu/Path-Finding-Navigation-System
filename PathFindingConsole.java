import java.util.*;

public class PathFindingConsole {
    static final char START_CHAR = 'S';
    static final char FINISH_CHAR = 'F';
    static final char WALL_CHAR = '#';
    static final char EMPTY_CHAR = '.';
    static final char VISITED_CHAR = '+';
    static final char PATH_CHAR = '*';

    static int rows;
    static int cols;
    static Node[][] grid;
    static int startX, startY;
    static int finishX, finishY;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter grid size (rows cols): ");
        rows = sc.nextInt();
        cols = sc.nextInt();

        System.out.print("Enter obstacle density (0-1): ");
        double density = sc.nextDouble();

        System.out.println("Choose algorithm: 1) Dijkstra  2) A*  3) BFS  4) DFS");
        int choice = sc.nextInt();

        initializeGrid(density);
        placeEndpoints(sc);

        System.out.println("\nInitial grid:");
        printGrid(grid);
        System.out.println("\nRunning...");

        List<Node> path = null;
        switch(choice) {
            case 1:
                path = Algorithm.dijkstra(grid, startX, startY, finishX, finishY);
                break;
            case 2:
                path = Algorithm.aStar(grid, startX, startY, finishX, finishY);
                break;
            case 3:
                path = Algorithm.bfs(grid, startX, startY, finishX, finishY);
                break;
            case 4:
                path = Algorithm.dfs(grid, startX, startY, finishX, finishY);
                break;
            default:
                System.out.println("Invalid choice. Exiting.");
                System.exit(0);
        }

        if (path == null) {
            System.out.println("No path found.");
        } else {
            markPath(path);
            System.out.println("\nPath found (length=" + (path.size() - 1) + "): ");
            printGrid(grid);
        }

        sc.close();
    }

    static void initializeGrid(double density) {
        grid = new Node[rows][cols];
        Random rand = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rand.nextDouble() < density) {
                    grid[i][j] = new Node(i, j, WALL_CHAR);
                } else {
                    grid[i][j] = new Node(i, j, EMPTY_CHAR);
                }
            }
        }
    }

    static void placeEndpoints(Scanner sc) {
        System.out.print("Enter start coords (row col): ");
        startX = sc.nextInt(); startY = sc.nextInt();
        grid[startX][startY] = new Node(startX, startY, START_CHAR);

        System.out.print("Enter finish coords (row col): ");
        finishX = sc.nextInt(); finishY = sc.nextInt();
        grid[finishX][finishY] = new Node(finishX, finishY, FINISH_CHAR);
    }

    static void printGrid(Node[][] g) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(g[i][j].type);
            }
            System.out.println();
        }
    }

    static void markPath(List<Node> path) {
        for (Node n : path) {
            if (grid[n.x][n.y].type == EMPTY_CHAR || grid[n.x][n.y].type == VISITED_CHAR) {
                grid[n.x][n.y].type = PATH_CHAR;
            }
        }
        grid[startX][startY].type = START_CHAR;
        grid[finishX][finishY].type = FINISH_CHAR;
    }

    static class Node {
        int x, y;
        char type;
        int gCost = Integer.MAX_VALUE;
        int hCost = 0;
        Node parent = null;
        boolean visited = false;

        Node(int x, int y, char type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }

        int fCost() {
            return gCost + hCost;
        }
    }

    static class Algorithm {
        static List<Node> dijkstra(Node[][] grid, int sx, int sy, int fx, int fy) {
            PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.gCost));
            Node start = grid[sx][sy];
            start.gCost = 0;
            pq.add(start);

            while (!pq.isEmpty()) {
                Node current = pq.poll();
                if (current.visited) continue;
                current.visited = true;
                markVisited(current);
                if (current.x == fx && current.y == fy) break;

                for (Node nb : neighbors(grid, current)) {
                    if (nb.type == WALL_CHAR || nb.visited) continue;
                    int newCost = current.gCost + 1;
                    if (newCost < nb.gCost) {
                        nb.gCost = newCost;
                        nb.parent = current;
                        pq.add(nb);
                    }
                }
            }
            return reconstructPath(grid[fx][fy]);
        }

        static List<Node> aStar(Node[][] grid, int sx, int sy, int fx, int fy) {
            PriorityQueue<Node> open = new PriorityQueue<>(Comparator.comparingInt(Node::fCost));
            Node start = grid[sx][sy];
            start.gCost = 0;
            start.hCost = heuristic(sx, sy, fx, fy);
            open.add(start);

            while (!open.isEmpty()) {
                Node current = open.poll();
                if (current.visited) continue;
                current.visited = true;
                markVisited(current);
                if (current.x == fx && current.y == fy) break;

                for (Node nb : neighbors(grid, current)) {
                    if (nb.type == WALL_CHAR || nb.visited) continue;
                    int tentativeG = current.gCost + 1;
                    if (tentativeG < nb.gCost) {
                        nb.gCost = tentativeG;
                        nb.hCost = heuristic(nb.x, nb.y, fx, fy);
                        nb.parent = current;
                        open.add(nb);
                    }
                }
            }
            return reconstructPath(grid[fx][fy]);
        }

        static List<Node> bfs(Node[][] grid, int sx, int sy, int fx, int fy) {
            Queue<Node> queue = new LinkedList<>();
            Node start = grid[sx][sy];
            start.visited = true;
            queue.add(start);

            while (!queue.isEmpty()) {
                Node current = queue.poll();
                markVisited(current);
                if (current.x == fx && current.y == fy) break;

                for (Node nb : neighbors(grid, current)) {
                    if (nb.type == WALL_CHAR || nb.visited) continue;
                    nb.visited = true;
                    nb.parent = current;
                    queue.add(nb);
                }
            }
            return reconstructPath(grid[fx][fy]);
        }

        static List<Node> dfs(Node[][] grid, int sx, int sy, int fx, int fy) {
            Stack<Node> stack = new Stack<>();
            Node start = grid[sx][sy];
            start.visited = true;
            stack.push(start);

            while (!stack.isEmpty()) {
                Node current = stack.pop();
                markVisited(current);
                if (current.x == fx && current.y == fy) break;

                for (Node nb : neighbors(grid, current)) {
                    if (nb.type == WALL_CHAR || nb.visited) continue;
                    nb.visited = true;
                    nb.parent = current;
                    stack.push(nb);
                }
            }
            return reconstructPath(grid[fx][fy]);
        }

        static int heuristic(int x, int y, int fx, int fy) {
            return Math.abs(x - fx) + Math.abs(y - fy);
        }

        static List<Node> neighbors(Node[][] grid, Node n) {
            List<Node> list = new ArrayList<>();
            int[] dx = {1, -1, 0, 0};
            int[] dy = {0, 0, 1, -1};
            for (int i = 0; i < 4; i++) {
                int nx = n.x + dx[i], ny = n.y + dy[i];
                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols)
                    list.add(grid[nx][ny]);
            }
            return list;
        }

        static void markVisited(Node n) {
            if (n.type == EMPTY_CHAR) n.type = VISITED_CHAR;
        }

        static List<Node> reconstructPath(Node end) {
            if (end.parent == null) return null;
            List<Node> path = new ArrayList<>();
            Node curr = end;
            while (curr != null) {
                path.add(curr);
                curr = curr.parent;
            }
            Collections.reverse(path);
            return path;
        }
    }
}
