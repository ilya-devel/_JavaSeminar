package sem2;

import java.util.ArrayList;
import java.util.Collections;

public class homeworks2 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(maxAreaOfIsland(grid));
        int[][] image = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println();
        showGrid(image);
        floodFill(image, 1, 1, 2);
        System.out.println();
        showGrid(image);
        System.out.println();
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(2));
        System.out.println(isSymmetric(root));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        ArrayList<Integer> sizes = new ArrayList<>();
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if (grid[x][y] == 1) sizes.add(getSizeArea(x, y, grid));
            }
        }
        Collections.sort(sizes);
        if (sizes.size() != 0) return sizes.get(sizes.size() - 1);
        return 0;
    }

    public static int getSizeArea(int x, int y, int[][] grid) {
        int size = 1;
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[x].length || grid[x][y] == 0) return 0;
        grid[x][y] = 0;
        size = size + getSizeArea(x + 1, y, grid);
        size = size + getSizeArea(x - 1, y, grid);
        size = size + getSizeArea(x, y + 1, grid);
        size = size + getSizeArea(x, y - 1, grid);
        return size;
    }

    public static void floodFill(int[][] image, int sr, int sc, int color) {
        int orig = image[sr][sc];
        changeColor(image, sr, sc, color, orig);
    }

    public static void changeColor(int[][] image, int i, int j, int color, int orig) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[i].length || image[i][j] != orig || image[i][j] == color)
            return;
        image[i][j] = color;
        changeColor(image, i + 1, j, color, orig);
        changeColor(image, i - 1, j, color, orig);
        changeColor(image, i, j + 1, color, orig);
        changeColor(image, i, j - 1, color, orig);
    }

    public static void showGrid(int[][] image) {
        for (int[] row : image) {
            for (int item : row) System.out.printf("%d ", item);
            System.out.println();
        }
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right == null) return true;
        if (root.left == null || root.right == null) return false;
        // return root.left.val == root.right.val && isSymmetric(root.left) && isSymmetric(root.right);
        ArrayList<Integer> lst1 = new ArrayList<>();
        ArrayList<Integer> lst2 = new ArrayList<>();
        checkLeafLeft(root.left, lst1);
        checkLeafRight(root.right, lst2);
        return lst1.equals(lst2);
    }

    public static void checkLeafLeft(TreeNode root, ArrayList<Integer> lst) {
        if (root == null) {
            lst.add(null);
            return;
        }
        lst.add(root.val);
        checkLeafLeft(root.left, lst);
        checkLeafLeft(root.right, lst);
    }

    public static void checkLeafRight(TreeNode root, ArrayList<Integer> lst) {
        if (root == null) {
            lst.add(null);
            return;
        }
        lst.add(root.val);
        checkLeafRight(root.right, lst);
        checkLeafRight(root.left, lst);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

//        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
