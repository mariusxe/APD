
public class Main
{
    int MASTER=0;
    int n=10;

    void main()
    {
        int nrProc, myrank;
        Random rand = new Random();
        int v[]= new int[2];
        nrProc=COMM_WORLD.Size() ;
        myrank= COMM_WORLD.Rank();
        if(myrank > 0){
            v[0] = myrank;
            v[1] = rand.nextInt() % 100;
            MPI.COMM_WORLD.Send(v,0,2, MPI.INT,0,0);
        }
        if(myrank == 0) {
            int rank = 0;
            int max = rand.nextInt() % 100;
            for (int i = 1; i < nrProc; i++) {
                MPI.COMM_WORLD.Recv(v, 0, 2, MPI.INT, i, 0);
                if(v[1] > max){
                    max= v[1];
                    rank = i;
                } else {
                    if((v[1] == max) && (i > rank)) {
                        rank = i;
                    }
                }
            }
            System.out.println("PROCESS MASTER is "+ rank +" with the generated number " + max);
        }


        MPI.Finalize();
    }
}
