/**
 * 链表实现
 * 
 * @author Asia
 * @version 1.0
 */


public class Node{
    Item item;
    Node next;
}

public class link{
    public static void main(String[] args) {
        Node first = new Node();
        Node second = new Node();
        Node third = new Node();

        first.item = "to";
        second.item = "be";
        third.item = "or";

        first.next = second;
        second.next = third;

        // 在表头插入结点
        Node oldfirst = first;
        first = new Node();
        first.item = "not";
        first.next = oldfirst;

        // 链表删除结点
        first = first.next;

        // 链尾加入新结点
        Node oldlast = third;
        Node last = new Node();
        last.item = "not";
        oldlast.next = last;
        
        // 遍历链表
        for (Node x = first; x != null; x = x.next){
            // 处理x.item
        }
    }
}
