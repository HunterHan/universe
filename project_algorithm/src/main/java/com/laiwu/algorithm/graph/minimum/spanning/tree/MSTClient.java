package com.laiwu.algorithm.graph.minimum.spanning.tree;

import static com.laiwu.algorithm.graph.minimum.spanning.tree.MatrixUDG.INF;

/**
 * 普里姆算法
 * <p>
 * 克鲁斯卡尔算法
 */
public class MSTClient {
  public static void main(String[] args) {
    char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
    int matrix[][] = {
                 /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
          /*A*/ {0, 12, INF, INF, INF, 16, 14},
          /*B*/ {12, 0, 10, INF, INF, 7, INF},
          /*C*/ {INF, 10, 0, 3, 5, 6, INF},
          /*D*/ {INF, INF, 3, 0, 4, INF, INF},
          /*E*/ {INF, INF, 5, 4, 0, 2, 8},
          /*F*/ {16, 7, 6, INF, 2, 0, 9},
          /*G*/ {14, INF, INF, INF, 8, 9, 0}};
    MatrixUDG pG;

    // 自定义"图"(输入矩阵队列)
    //pG = new MatrixUDG();
    // 采用已有的"图"
    pG = new MatrixUDG(vexs, matrix);

    //pG.print();
    //pG.DFS();
    //pG.BFS();
    pG.prim(0);
    pG.kruskal();
  }
}
