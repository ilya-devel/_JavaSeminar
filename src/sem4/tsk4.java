package sem4;

import java.util.*;

public class tsk4 {

    public static void main(String[] args) {
        System.out.println("\n71. Simplify Path");
        System.out.println(simplifyPath("/a/./b/../../c/"));
        System.out.println("\n695. Max Area of Island");
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(maxAreaOfIsland(grid));
        int[][] grid2 = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}};
        System.out.println(maxAreaOfIsland(grid2));
        System.out.println();
        System.out.println("\n101. Symmetric Tree");

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(3);

        System.out.println(isSymmetric(root));
        System.out.println();
        System.out.println("\n542. 01 Matrix");
        int[][] mat1 = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}};
        int[][] mat2 = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}};
        int[][] newMap1 = updateMatrix(mat1);
        int[][] newMap2 = updateMatrix(mat2);
        showMap(newMap1);
        showMap(newMap2);
    }

    public static String simplifyPath(String path) {
        String[] dirs = path.split("/");
        LinkedList<String> correctlyDirs = new LinkedList<>();
        for (String dir : dirs) {
            if (!Objects.equals(dir, "") && !Objects.equals(dir, ".") && !Objects.equals(dir, "..")) {
                correctlyDirs.add(dir);
            }
            if (Objects.equals(dir, "..")) correctlyDirs.pollLast();
        }
        return "/" + String.join("/", correctlyDirs);
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int[][] steps = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int maxSize = 0;
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                if (grid[y][x] == 1) {
                    LinkedList<int[]> islands = new LinkedList<>();
                    int curArea = 0;
                    islands.add(new int[]{y, x});
                    while (!islands.isEmpty()) {
                        int[] curIsland = islands.pop();
                        if (grid[curIsland[0]][curIsland[1]] == 1) {
                            curArea++;
                            grid[curIsland[0]][curIsland[1]] = 0;
                            for (int[] step : steps) {
                                int curX = curIsland[1] + step[1];
                                int curY = curIsland[0] + step[0];
                                if (curX >= 0 && curX < grid[0].length && curY >= 0
                                        && curY < grid.length && grid[curY][curX] == 1) {
                                    islands.add(new int[]{curY, curX});
                                }
                            }
                        }
                    }
                    maxSize = Math.max(curArea, maxSize);
                }
            }
        }
        return maxSize;
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right == null) return true;
        if (root.left == null || root.right == null) return false;
        Deque<TreeNode> roots = new ArrayDeque<>();
        roots.addFirst(root.left);
        roots.addLast(root.right);
        while (roots.size() % 2 == 0 && roots.size() > 0) {
            TreeNode left = roots.pollFirst();
            TreeNode right = roots.pollLast();
            if ((left.val != right.val) || (left.left == null && right.right != null) ||
                    (left.right == null && right.left != null) || (left.left != null && right.right == null) ||
                    (left.right != null && right.left == null)) {
                return false;
            }
            if (left.left != null && right.right != null) {
                roots.addFirst(left.left);
                roots.addLast(right.right);
            }
            if (left.right != null && right.left != null) {
                roots.addFirst(left.right);
                roots.addLast(right.left);
            }
        }
        return roots.size() == 0;
    }

    public static int[][] updateMatrix(int[][] mat) {
        int colLen = mat.length;
        int rowLen = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < colLen; i++) {
            for (int j = 0; j < rowLen; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] steps = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] step : steps) {
                int r = cell[0] + step[0];
                int c = cell[1] + step[1];
                if (r < 0 || r >= colLen || c < 0 || c >= rowLen ||
                        mat[r][c] <= mat[cell[0]][cell[1]] + 1) continue;
                queue.add(new int[]{r, c});
                mat[r][c] = mat[cell[0]][cell[1]] + 1;
            }
        }

        return mat;
    }

    public static void showMap(int[][] map) {
        for (int[] row : map) {
            for (int col : row) {
                System.out.printf("%d\t", col);
            }
            System.out.println();
        }
    }
}
