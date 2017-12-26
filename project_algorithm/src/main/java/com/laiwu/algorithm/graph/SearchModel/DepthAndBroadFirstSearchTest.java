package com.laiwu.algorithm.graph.SearchModel;

public class DepthAndBroadFirstSearchTest {

  public static void main(String args[]) {
    int vertexCount = 8;
    int edgeCount = 9;

    DepthAndBreadthFirstSearchGraph graph = new DepthAndBreadthFirstSearchGraph(vertexCount);
    String vertex[] = {"1", "2", "3", "4", "5", "6", "7", "8"};//结点的标识

    initGraphVertex(graph, vertex);

    initGraphEdge(graph);

    System.out.println("深度优先搜索序列：");
    graph.DFS();
    System.out.println("\n");
    System.out.println("广度优先搜索序列：");
    graph.BFS();

    System.out.println("\n结点个数是：" + graph.getNumOfVertex());
    System.out.println("边的个数是：" + graph.getNumOfEdges() / 2);

    graph.deleteEdge(0, 1);//删除<V1,V2>边
    System.out.println("删除<V1,V2>边后...");
    System.out.println("结点个数是：" + graph.getNumOfVertex());
    System.out.println("边的个数是：" + graph.getNumOfEdges() / 2);
  }

  private static void initGraphEdge(DepthAndBreadthFirstSearchGraph graph) {
    graph.insertEdge(0, 1, 1);
    graph.insertEdge(0, 2, 1);
    graph.insertEdge(1, 3, 1);
    graph.insertEdge(1, 4, 1);
    graph.insertEdge(3, 7, 1);
    graph.insertEdge(4, 7, 1);
    graph.insertEdge(2, 5, 1);
    graph.insertEdge(2, 6, 1);
    graph.insertEdge(5, 6, 1);

    graph.insertEdge(1, 0, 1);
    graph.insertEdge(2, 0, 1);
    graph.insertEdge(3, 1, 1);
    graph.insertEdge(4, 1, 1);
    graph.insertEdge(7, 3, 1);
    graph.insertEdge(7, 4, 1);
    graph.insertEdge(6, 2, 1);
    graph.insertEdge(5, 2, 1);
    graph.insertEdge(6, 5, 1);
  }

  private static void initGraphVertex(DepthAndBreadthFirstSearchGraph graph, String[] vertex) {
    for (String node : vertex) {
      graph.insertVertex(node);//插入结点
    }
  }
}
