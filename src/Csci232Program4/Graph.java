package Csci232Program4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Graph {
    Node[] graph;
    Graph(Node[] graph){
        this.graph = graph;
    }
    void BFS(){
        Queue<Node> queue = new LinkedList<>();
        Node current = graph[0];
        List<Node> visited= new ArrayList<>();
        queue.add(current);
        visited.add(current);
        //Node[] visited = new Node[graph.length];
        while (!queue.isEmpty()){
            current.setVisited(true);
            if (queue.element().neighbors != null){
                for (int i = 0; i<queue.element().neighbors.length;i++){
                    if (queue.element().neighbors[i].visited == false){
                        queue.add(current.neighbors[i]);
                        queue.element().neighbors[i].setVisited(true);
                        visited.add(current.neighbors[i]);
                    }
                }
            }
            queue.remove();
            if(!queue.isEmpty()) {
                current = queue.element();
            }
        }
        Node[] BFS = visited.toArray(new Node[visited.size()]);
        //int[] printable = new int[BFS.length];
        String print = new String();
        for (int i = 0;i<graph.length;i++){
//            System.out.println(BFS[i].getKey());
            if (print.isEmpty()){
                print = Integer.toString(BFS[i].getKey());
            }else{
                print = print +","+ Integer.toString(BFS[i].getKey());
            }
            //printable[i] = BFS[i].getKey();
        }
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("BFS.txt"));
            writer.write(print);
            writer.close();
        }catch (IOException e){
            System.out.println("IOexception");
        }

    }
    List<Node> visited= new ArrayList<>();
    void DFS(){
//        Stack<Node> stack = new Stack<>();

        Node current = graph[0];
//        stack.add(current);
        depth(current);
        Node[] DFS = visited.toArray(new Node[visited.size()]);
        String print = new String();
        for (int i = 0;i<graph.length;i++){
            if(print.isEmpty()){
                print = Integer.toString(DFS[i].getKey());
            }else{
                print = print+","+Integer.toString(DFS[i].getKey());
            }
        }
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("DFS.txt"));
            writer.write(print);
            writer.close();
        }catch(IOException e){
            System.out.println("IOException");
        }
    }
    void depth(Node current){
        current.setVisited(true);
        visited.add(current);
        if (current.neighbors!=null){
            for(int i = 0;i<current.neighbors.length;i++){
                if(current.neighbors[i].visited==false){
                    depth(current.neighbors[i]);
                }
            }
        }

    }
}
