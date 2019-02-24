/**
 * LinkedStack
 * 链表实现堆
 * 参考：《算法》
 * 
 * @author Asia
 * @version 1.0
 * 
 */

import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStack<Item> implements Iterable<Item>{
    private int n;          //堆的容量
    private Node first;     //堆首结点

    // 结点类
    private class Node{
        private Item item;
        private Node next;
    }

    /**
     * 初始化一个空的堆
     */

    public LinkedStack(){
        first = null;
        n = 0;
        assert check();
    }
     
     /**
      * 判断堆是否为空
      * @return 空返回true
      */
    public boolean isEmpty(){
        return first == null;
    }

    /**
     * 返回堆容量
     * @return 容量
     */
    public int size(){
        return n;
    }

    /**
     * 添加元素
     * @param item 添加item至堆
     */
    public void push(Item item){
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        
        n++;
        assert check();
    }
    
    /**
     * 删除并返回堆顶元素
     * @return 堆顶元素
     * @throws 堆为空抛出异常
     */

    public Item pop(){
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;    //  保存堆顶元素
        first = first.next;        //  删除堆顶元素
        n--;
        assert check();
        return item;               //  返回堆顶元素
    }

     /**
      * 返回堆顶元素，不删除
      * @return 堆顶
      * @throws 堆空抛出异常
      */
    
    public Item peek(){
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }

    /**
     * 迭代器
     */
    public Iterator<Item> iterator(){
        return new ListIterator();
    }

    //迭代器
    private class ListIterator implements Iterator<Item>{
        private Node current = first;
        public boolean hasNext()    { return current != null;                       }
        public void remove()        { throw new UnsupportedOperationException();    }

        public Item next(){
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    /**
     * 检测是否合法
     */
    private boolean check(){
        
        //判断堆容量是否正确
        if (n < 0){
            return false;
        }
        if (n == 0){
            if (first != null)      return false;
        }
        else if (n == 1){
            if (first == null)      return false;
            if (first.next != null) return false;
        }
        else {
            if (first == null)      return false;
            if (first.next == null) return false;
        }

        // 检测堆真实容量是否与 n 相同
        int numberOfNodes = 0;
        for (Node x = first; x != null && numberOfNodes <= n; x = x.next){
            numberOfNodes++;
        }
        if (numberOfNodes != n) return false;

        return true;
    }

    /**
     * main
     * @throws Exception 
     */

    public static void main(String[] args) throws Exception {
        LinkedStack<Integer> stack = new LinkedStack<Integer>();
        
        int i = -1;
        
        while (i != 0){
            i = System.in.read();
            if (i != -1)            
                stack.push(i);
            else if (!stack.isEmpty())
                System.out.print(stack.pop() + " ");
        }

        System.out.println("(" + stack.size() + " left on stack)");
    }
    
}
