GoldMine Pathfinding and Maximum Gold Collection:

This Java project implements an algorithm to find the optimal path in a gold mine and calculate the maximum amount of gold that can be collected. The mine is represented as a 2D grid where each cell contains a certain amount of gold. The algorithm calculates a miner's possible paths (moving right, right-up, or right-down) to collect the maximum gold.

Key Features:
1. Gold Mining Algorithm:
    - The `goldmining` method calculates the maximum gold collectible by evaluating possible moves (right, right-up, and right-down) from each cell in the grid. 
    - It updates a 2D array (`totalgold) where each cell holds the maximum amount of gold collectible up to that point.

2. Pathfinding:
    - The `path` method traces back to the path that led to the maximum gold. It starts from the cell with the highest gold value and traces the optimal route backward to the leftmost column.

3. Helper Methods:
    - `findMax`: Finds the cell with the maximum gold in the 2D grid.
    - `location`: Retrieves the coordinates of a specific gold value in the grid.

Example Workflow:
- A random 3x3 grid of gold values is generated.
- The maximum gold is calculated using the `goldmining` function.
- The cell with the maximum gold is identified, and the path leading to that cell is displayed in reverse order (from the start of the path to the cell with the maximum gold).

Code Breakdown:
- `goldmining`: Core method to compute the maximum gold collectible from any starting position.
- `path`: Recursive function to trace the optimal path based on the previous moves (right, right-up, right-down).
- `findMax` and `location`: Used to identify the cell with the highest gold value and retrieve its coordinates.

Use Case:
This program can be used in scenarios involving grid-based pathfinding problems, particularly where the objective is to maximize a certain resource (e.g., gold in this case).
