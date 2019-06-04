package Csci232Program4;

public class Node {
    int[] host;
    int key;
    Node(int[] hosts){
        host = hosts;
        key = host[0];
    }
    boolean visited = false;
    Node[] neighbors;
    void setNeighbors(Node[] others){
        if (host.length <=1){
            neighbors = null;
        }
        else{
            neighbors = new Node[host.length-1];
            for (int i = 0;i<neighbors.length;i++){
                for (int j = 0;j<others.length;j++){
                    int mykey = others[j].getKey();
                    if (host[i+1]==others[j].getKey()){
                        neighbors[i] = others[j];
                    }
                }
            }
        }
    }
    void setKey(int key){
        this.key = key;
    }
    int getKey(){
        return key;
    }
    void setVisited(boolean visited){
        this.visited = visited;
    }
}
