import demo1.MyStack;
import demo1.MyQueue;

public class Test {
    public static void main(String[] args) {
        // MyStack<Integer> s = new MyStack<Integer>();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // MyStack<Integer> t = new MyStack<Integer>();
        // t.push(4);
        // t.push(5);
        // t.push(6);
        // 
        // System.out.println(s);
        // System.out.println(t);
        // s.transfer(s, t);
        // System.out.println(s);
        // System.out.println(t);
        
        MyStack<Integer> test = new MyStack<Integer>();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        System.out.println(test);
        test.rotate();
        System.out.println(test);
        
        MyQueue<Integer> test1 = new MyQueue<Integer>();
        test1.enqueue(1);
        test1.enqueue(2);
        test1.enqueue(3);
        test1.enqueue(4);
        test1.dequeue();
        test1.dequeue();
        test1.dequeue();
        test1.dequeue();
        test1.enqueue(5);
        test1.enqueue(6);
        test1.enqueue(7);
        test1.enqueue(8);
        test1.enqueue(9);
        test1.enqueue(10);
        test1.enqueue(11);
        test1.enqueue(12);
        System.out.println(test1);
    }
}