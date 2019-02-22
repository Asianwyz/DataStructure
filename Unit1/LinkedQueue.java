/**
 * 链表实现队列
 * 参考：《算法》
 * 
 * @author Asia
 * @version 1.9
 */


import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<Item> implements Iterable<Item>{
    private int n;              // 队列元素数目
    private Node first;         // 队首
    private Node last;          // 队尾

    // 结点类
    private class Node{
        private Item item;
        private Node next;
    }

    // 初始化
    public LinkedQueue(){
        first = null;
        last  = null;
        n = 0;
        assert check();
    }

    /**
     * 检查队列是否为空
     * @return 空返回true
     */
    public boolean isEmpty(){
        return first == null;
    }

    /**
     * 返回队列长度
     * @return size;
     */
    public int size(){
        return n;
    }

    /**
     * 返回队首元素
     * @return first.item
     * @throws java.util.NoSuchElementException 如果为空
     */
    public Item peek(){
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return first.item;
    }

    /**
     * 添加元素
     * @param item
     */
    public void push(Item item){
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if (isEmpty())
            first = last;
        else
            oldlast.next = last;
        
        ++n;
        assert check();
    }

    /**
     * 出队
     * @return first.item
     * @throws java.util.NoSuchElementException 队列为空
     */
    public Item pop(){
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first = first.next;
        --n;
        if (isEmpty()) last = null;         // to avoid loitering
        assert check();
        return item;
    }

    private boolean check(){
        if (n < 0){
            return false;
        }
        else if ( n == 0){
            if (first != null) return false;
            if (last  != null) return false;
        }
        else if (n == 1){
            if (first == null || last == null)  return false;
            if (first != null)                  return false;
            if (first.next != null)             return false;
        }
        else {
            if (first == null || last == null) return false;
            if (first == last)      return false;
            if (first.next == null) return false;
            if (last.next  != null) return false;

            // 检查队列长度是否等于n
            int numberOfNodes = 0;
            for (Node x = first; x != null; x = x.next){
                ++numberOfNodes;
            }
            if (numberOfNodes != n) return false;

            //检查队列是否一致
            Node lastNode = first;
            while (lastNode.next != null){
                lastNode = lastNode.next;
            }
            if (last != lastNode) return false;
        }

        return true;
    }
    
    /**
     * 迭代器
     */
    public Iterator<Item> iterator()  {
        return new ListIterator();  
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }

    public static void main(String[] args) {
        LinkedQueue<String> queue = new LinkedQueue<String>();
        while (!StdIn.isEmpty()){
            String item = StdIn.readString();
            if (!item.equals("-"))
                queue.push(item);
            else if (!queue.isEmpty())
                StdOut.print(queue.pop() + " ");
        }
        StdOut.println("(" + queue.size() + " left on queue)");
    }

}
