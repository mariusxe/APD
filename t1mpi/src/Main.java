
public class Main
{
    int MASTER=0;
    int n=10;

    void main()
    {
        int nrProc, id, sum = 0, i, buc, sumTotal = 0;
        Random rand = new Random();
        int v[]= new int[n];
        nrProc = COMM_WORLD.Size() ;
        id = COMM_WORLD.Rank();
        for (i = 0; i < n; i++) {
            v[i] = rand.nextInt() % 100 + 1;
        }
        buc = n / nrProc;
        for (i = 0; i < buc; i++) {
            sum = sum + v[id*buc + i];
        }
        if (id != MASTER){
            MPI.COMM_WORLD.Send(MPI.COMM_WORLD, sum, 1, MPI.INT, MASTER, 0);
        }
        else {
            MPI.COMM_WORLD.Recv(MPI.COMM_WORLD,sum, 1, MPI.INT, id, 0);
            sumTotal = sumTotal + sum;

        }

        System.out.println("Suma finala e " + sumTotal );


        MPI.Finalize();
    }
}
