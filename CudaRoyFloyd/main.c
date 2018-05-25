
#include "cuda_runtime.h"
#include "device_launch_parameters.h"
#include <stdio.h>
#include <stdlib.h>
#define N 5
#define INF -1

int graph[][] = {
        {0, 5, INF, 3, INF},
        {INF, 0, 6, INF, 4},
        {INF, INF, 0, 9, INF},
        {INF, INF, INF, 0, INF},
        {INF, INF, INF, 2, 0}
        };
__global__  void RoyFloyd(graf[][], int k){

	int i = threadIdx.x;
	int j = threadIdx.y;

	if (graph[i][k] + graph[k][j] < graph[i][j]) {
		graph[i][j] = graph[i][k] + graph[k][j];
	}

}

int main(int argc, char **argv){
    int numBlocks = 1;
    dim3 threadsPerBlock(N, N);
    int *cuda;
    int size = N ;

    cudaMalloc(&cuda, size);
	cudaMemcpy(cuda, a, size, cudaMemcpyHostToDevice);

	for (int k = 0; k < N; ++k) {
		RoyFloyd <<< num_blocks, threadsPerBlock >>> (cuda);
	}


	cudaMemcpy(a, cuda, size, cudaMemcpyDeviceToHost);
	cudaFree(cuda);

	return 0;
}


