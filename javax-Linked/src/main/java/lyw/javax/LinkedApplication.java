package lyw.javax;

/**
 * @Author: luohx
 * @Description: 链表
 * @Date: 2021/2/24 15:51
 */
public class LinkedApplication {

    public static void main(String[] args) {
        //单链表翻转
        Node head = new Node(0);
        Node cur = head;
        StringBuilder sb = new StringBuilder();
        sb.append(cur.getValue());
        for (int i = 1; i < 10; i++) {
            sb.append(" -> ");
            Node tmp = new Node(i);
            cur.setNext(tmp);
            cur = tmp;
            sb.append(cur.getValue());
        }
        System.out.println("链表数据sb=" + sb.toString());

        //递归
        sb.setLength(0);
        Node newHead = reverse(head);
        sb.append(newHead.getValue());
        Node tmp = newHead;
        while (null != tmp.getNext()) {
            sb.append(" -> ");
            sb.append(tmp.getNext().getValue());
            tmp = tmp.getNext();
        }
        System.out.println("链表翻转-递归，数据sb1=" + sb.toString());

        //遍历
        sb.setLength(0);
        Node newHead0 = reverse0(newHead);
        sb.append(newHead0.getValue());
        Node tmp0 = newHead0;
        while (null != tmp0.getNext()) {
            sb.append(" -> ");
            sb.append(tmp0.getNext().getValue());
            tmp0 = tmp0.getNext();
        }
        System.out.println("链表翻转-遍历，数据sb0=" + sb.toString());

        //k个一组翻转链表


        System.out.println("12");
    }

    public static Node reverseKGroup(Node head, int k) {
        if (null == head || null == head.getNext()) {
            return head;
        }
        int count = 0;
        Node cur = head;
        while (count != k && cur != null) {
            cur = cur.getNext();
            count++;
        }
        if(count == k){
            cur = reverseKGroup(cur, k);//上一次翻转后的头节点
            while (count -- > 0){
                Node tmp = head.getNext();
                head.setNext(cur);
                cur = head;
                head = tmp;
            }
            head = cur;
        }
        return head;
    }


    /**
     * 递归 递归都在java栈中进行,需要考虑jdk支持的栈的深度,在jdk1.8.0_91版本中，当上述链表长度大于12000则会出现StackOverFlowError
     */
    public static Node reverse(Node head) {//3,2
        if (head == null || head.getNext() == null) {
            return head;
        }
        Node temp = head.getNext(); //temp=4,3
        Node newHead = reverse(head.getNext()); //newHead=4,3
        temp.setNext(head);//4->3->2
        head.setNext(null);//3->null,2->null
        return newHead;
    }

    /**
     * 遍历实现，通用实现算法
     */
    public static Node reverse0(Node head) {
        if (null == head || null == head.getNext()) {
            return head;
        }
        Node pre = head;
        Node cur = head.getNext();
        while (null != cur.getNext()) {
            Node tmp = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = tmp;
        }
        cur.setNext(pre);
        head.setNext(null);
        return cur;
    }

}
