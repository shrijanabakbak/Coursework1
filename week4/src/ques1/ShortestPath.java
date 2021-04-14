package ques1;

public class ShortestPath {
	public int minDistance(int dist[], Boolean b[]) {
		int min=Integer.MAX_VALUE, index = -1;
		for(int x=0; x<4; x++) {
			if(b[x]==false && dist[x]<=min) {
				min=dist[x];
				index=x;
			}
		}
		return index;
	}
	public void printGraph(int dist[], int x) {
		
		System.out.println("Distancne from source to destination is");
		for(int i=0; i<4; i++) {
			System.out.println(i + "-----" + dist[i]);
		}
	}
	public void dijkstra(int graph[][], int src) {
		//To find the shortest path, using the Dijkstra algorithm.
		int dist[]=new int[4];
		Boolean b[]=new Boolean[4];
		
		for(int i=0;i<4; i++) {
			dist[i]=Integer.MAX_VALUE;
			 b[i]=false;
		}
		dist[0]=0;
		// starting of forloop
		for(int count=0; count<4; count++) {
			int u=minDistance(dist, b);
			b[u]=true;
			for(int x=0; x<4;x++) {
				if(!b[x]&&graph[u][x]!=0 && dist[u]!=Integer.MAX_VALUE && dist[u]+graph[u][x]<dist[x]) {
					dist[x]=dist[u]+graph[u][x];
				}
			}
			printGraph(dist,4);
		}
		//for loop ends
	}
	public static void main(String[] args) {
		//assigning a point's number 
		int graph[][]=new int[][] {
			{1,3,8,9},
			{8,7,2,6},
			{13,3,6,4},
			{13,1,5,3}
		  };
			ShortestPath p = new ShortestPath();
			p.dijkstra(graph, 0);
	}
	


}
