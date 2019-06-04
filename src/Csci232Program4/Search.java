package Csci232Program4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Search {
    public static void main(String[] args){
        Scanner sc;
        try{
            sc = new Scanner(new File("input.txt"));
            int lines = 0;
            List<String> temps = new ArrayList<>();
            while (sc.hasNextLine()){
                lines++;
                temps.add(sc.nextLine());
            }
            String[] strings = temps.toArray(new String[temps.size()]);
            Node[] nodes = new Node[temps.size()];
            for (int i = 0;i< strings.length;i++){
                String[] splitstring = strings[i].split(",");
//                System.out.println(splitstring.length);
                int[] split = new int[splitstring.length];
                if (splitstring.length>1){
                    for (int j = 0; j<splitstring.length;j++){
//                        System.out.println("   "+j+"  "+splitstring.length);
                        split[j] = Integer.parseInt(splitstring[j]);
                    }
                }else{
                    split[0] = Integer.parseInt(splitstring[0]);
                }
                nodes[i] = new Node(split);
            }
            for (int i = 0; i<nodes.length;i++){
                nodes[i].setNeighbors(nodes);
            }
            int choice = 0;
            Graph graph = new Graph(nodes);
            while (choice != -1){
                System.out.println("What would you like to do?");
                System.out.println("Press 1 to print BFS to a file called BFS.txt");
                System.out.println("Press 2 to print DFS to a file called DFS.txt");
                System.out.println("Press -1 to quit");
                Scanner reader = new Scanner (System.in);
                choice = reader.nextInt();
                switch (choice){
                    case 1:
                        graph.BFS();
                        System.out.println("BFS printed");
                        for (int i = 0; i<nodes.length;i++){
                            nodes[i].setVisited(false);
                        }
                        break;
                    case 2:
                        graph.DFS();
                        System.out.println("DFS printed");
                        for (int i = 0; i<nodes.length;i++){
                            nodes[i].setVisited(false);
                        }
                        break;
                    case -1:
                        System.out.println("exit");
                        break;
                    default:
                        System.out.println("Invalid choice");
                        choice = 0;
                        break;
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("file error");
        }
    }
}
