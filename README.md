# Pathfinding Visualization Project

## Project Overview
This project aims to implement and visualize pathfinding algorithms in a grid-based environment. The graphical interface allows users to interact with the map by setting start, finish, walls, and obstacles. The project includes multiple pathfinding algorithms, such as Dijkstra, A*, BFS, and DFS, allowing users to choose the best algorithm for finding a path through the grid.

The project has two versions:
- **Graphical Version (Java Swing)**: A GUI-based tool to visualize pathfinding in real-time.
- **Console Version (Text-Based)**: A simpler version that runs in the terminal with text output.

The graphical interface provides features such as grid size adjustments, tool selection, real-time pathfinding visualization, and obstacle management.

## Features

### Graphical Version (Swing)
1. **Grid-based Layout**: The grid can be customized in terms of size, from small to large (10x10 to 50x50).
2. **Algorithms Supported**:
   - **Dijkstra**: Finds the shortest path by visiting the nearest unvisited node.
   - **A\***: An optimized version of Dijkstra that uses heuristics to guide the search.
   - **Breadth-First Search (BFS)**: Explores all neighboring nodes at the present depth level before moving on to nodes at the next depth level.
   - **Depth-First Search (DFS)**: Explores as far as possible along each branch before backtracking.
3. **Toolbox**:
   - **Start & Finish Points**: Set the start and finish points interactively by clicking on the grid.
   - **Walls**: Mark obstacles on the grid to simulate impassable areas.
   - **Erase Tool**: Clear walls or obstacles from the grid.
4. **Interactive Features**:
   - **Real-time Updates**: View the number of checked nodes and the path length.
   - **Adjustable Settings**: Customize grid size, speed (delay), obstacle density, and algorithm choice.
5. **Visual Updates**:
   - **Pathfinding Process**: The algorithm’s progress is visualized in real-time, with each node visited marked differently.
   - **Final Path**: Once a path is found, it is displayed with special markers.
   
### Console Version
- **Text-based Visualization**: The grid is displayed in the terminal, using characters to represent start (`S`), finish (`F`), walls (`#`), and visited nodes (`+`).
- **Algorithm Support**: Same as the graphical version (Dijkstra, A*, BFS, DFS).
- **Path Visualization**: Once a path is found, it is represented as `*` characters.

## How to Run

### Graphical Version (Swing)

1. **Clone the repository**:

   ```bash
   https://github.com/rukonuzzamantopu/Path-Finding-Navigation-System
  
