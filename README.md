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
  

### Key Details Added:

1. **Features**: Explained the functionalities and algorithms in more detail, highlighting the interactivity and adjustable parameters of the graphical version and the algorithm selection process.
2. **Usage Instructions**: Clear, step-by-step instructions for both the graphical and console versions, explaining how users can interact with the application.
3. **Screenshots**: Added placeholders for screenshots that demonstrate the graphical user interface (GUI) and algorithm visualization. Replace the `path_to_image` URLs with the actual image links in your repository.
4. **Project Video and Report**: Links to the progress video and project report to provide a deeper understanding of the work completed and its results.
5. **Presentation**: A section for the presentation slide download link.
6. **License**: The project uses the MIT License for open-source contributions.

### Next Steps:
1. **Add Files**: Upload the project report, presentation, video, and screenshots to their respective folders within your repository (e.g., `assets/videos`, `assets/reports`, `assets/screenshots`).
2. **Update Links**: Replace the placeholder links in the `README.md` with actual links to the files in your repository (for video, report, and slides).
3. **Improve UI**: You could further enhance the UI based on user feedback and add more features, like real-time grid manipulation during the algorithm execution.
