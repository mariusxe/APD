
public class Main {
    int NR = 5;
    int INF = -1;

    void main() 
	{
        int[][] finalGraph = new int[NR][NR];
        int myrank = MPI.COMM_WORLD.Rank();
        int nrProc = MPI.COMM_WORLD.Size();

        int graph[][] = {
                {0, 5, INF, 3, INF},
                {INF, 0, 6, INF, 4},
                {INF, INF, 0, 9, INF},
                {INF, INF, INF, 0, INF},
                {INF, INF, INF, 2, 0}
        };

        MPI.Init(args);
        if (myrank == 0) {
            MPI.COMM_WORLD.Bcast(graph, 0, NR * NR, MPI.INT, 0);

            for (int k = 0; k < NR; k++) {
                for (int j = 0; j < NR; j++) {
                    if (graph[0][k] + graph[k][j] < graph[0][j]) {
                        graph[0][j] = graph[0][k] + graph[k][j];
                    }
                }
            }
        }
        if (myrank != 0) {

            MPI.COMM_WORLD.Recv(graph, 0, NR, MPI.OBJECT, 0, 0);

            for (int k = 0; k < NR; k++) {
                for (int j = 0; j < NR; j++) {
                    if (graph[myrank][k] + graph[k][j] < graph[myrank][j]) {
                        graph[myrank][j] = graph[myrank][k] + graph[k][j];
                    }
                }
            }


            MPI.Finalize();
        }
    }
}
