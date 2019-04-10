package algo.numberOfConnectedComponent;

public class NumberOfConnectedComponent {


    static int M[][] = new int[][]{{1, 0, 0, 0, 0},
            {0, 1, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0},
            {0, 0, 0, 0, 1}
    };
    static boolean[] visited = new boolean[5];

    public static void main(String args[]) {


        System.out.println(getConnectedComponent());


    }

    public static int getConnectedComponent() {

        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                markVisited(i);
                count++;
            }
        }
        return count;
    }

    public static void markVisited(int c) {
        visited[c] = true;
        for (int i = 0; i < M.length; i++) {
            if (M[c][i] == 1 && !visited[i]) {
                markVisited(i);
            }
        }
    }

}
