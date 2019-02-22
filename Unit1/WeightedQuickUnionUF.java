/**
 * 并查集
 * 路劲压缩 + 带权合并
 * 参考：《算法》
 * 
 * @author Asia
 * @version 1.0
 */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class WeightedQuickUnionUF{
    private int[] parent;       // 用数组记录父亲
    private int[] size;         // 一棵树的数量
    private int count;          // 树的数量

    //初始化
    public WeightedQuickUnionUF(int n){
        count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; ++i){
            parent[i] = i;
            size[i] = 1;
        }
    }

    /**
     * 返回连通数
     * @return count
     */
    public int count(){
        return count;
    }

    /**
     * 寻找根
     * @return root
     */
    public int find(int x){        
        while (x != parent[x]){
            parent[x] = parent[parent[x]];      //  路径压缩
            x = parent[x];
        }            
        return x;
    }

    /**
     * 判断两元素是否连通
     * @return true or false
     */
    public boolean connected(int x, int y){
        return find(x) == find(y);
    }


    /**
     * 连通两个元素
     * @param x,y 元素
     */
    public void union(int x, int y){
        int rootx = find(x);
        int rooty = find(y);
        if (rootx == rooty) return;

        if (size[rootx] < size[rooty]){
            parent[x] = y;
            size[rooty] += size[rootx];
        }
        else {
            parent[y] = x;
            size[rootx] += size[rooty];
        }

        --count;
    }

    public static void main(String[] args){
        int n = StdIn.readInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(n);
        while (!StdIn.isEmpty()){
            int x = StdIn.readInt();
            int y = StdIn.readInt();
            if (uf.connected(x, y)) continue;
            uf.union(x, y);
            StdOut.println(x + " " + y);
        }
        StdOut.println(uf.count() + "components");
    }
}