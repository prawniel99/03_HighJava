package kr.or.ddit.basic.sec02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueTest {
	/*
	 *  Stack ==> 후입선출(LIFO)의 자료구조
	 *  Queue ==> 선입선출(FIFO)의 자료구조
	 *  
	 *  Stack 과 Queue는 LinkedList를 이용하여 사용할 수 있다.
	 */
	public static void main(String[] args) {
		StackQueueTest obj = new StackQueueTest();
		obj.process();
	}
	
	private void process() {
		m1();
		m2();
	}
	
	private void m1() {
		m2();
		System.out.println("종료");
		System.exit(0);
		/*
		 *  Stack의 명령
		 *  1. 자료 입력: push(입력값)
		 *  2. 자료 출력: pop()	 ==> 자료를 꺼내온 후 꺼내온 자료를 Stack에서 삭제한다.
		 *  			  peek() ==> 삭제 없이 자료를 꺼내온다.
		 */
		
		Stack<String> stack = new Stack<String>();
		
		stack.push("홍길동");
		stack.push("일지매");
		stack.push("변학도");
		stack.push("강감찬");
		
		System.out.println("현재 stack의 값들: "+stack);
		// Stack 도 vector 이라고 하네?
		String data = stack.pop();
		System.out.println("꺼내온 값: "+data);
		System.out.println("꺼내온 값: "+stack.pop());
		System.out.println("현재 stack의 값들: "+stack);
		
		System.out.println("\n성춘향 입력");
		stack.push("성춘향");
		System.out.println("현재 stack의 값들: "+stack);
		System.out.println("pop으로 꺼내온 값: "+stack.pop());
		System.out.println("현재 stack의 값들: "+stack);
		
		System.out.println("\npeek로 꺼내오기");
		System.out.println("현재 stack의 값들: "+stack);
		System.out.println("peek로 꺼내온 값: "+stack.peek());
		System.out.println("현재 stack의 값들: "+stack);
		
		ln();
		System.out.println("Queue");
		System.out.println();
		/*
		 *  Queue의 명령
		 *  1. 자료 입력: offer(입력값)
		 *  2. 자료 출력: poll()  ==> 자료를 꺼내오고 꺼내온 데이터를 Queue에서 삭제한다.
		 *                peek()  ==> 삭제 없이 자료를 꺼내온다.
		 */
		
//		Queue<String> cue = new Queue<String>();
		Queue<String> queue = new LinkedList<String>();
		queue.offer("홍길동");
		queue.offer("일지매");
		queue.offer("변학도");
		queue.offer("강감찬");
		
		System.out.println("현재 queue의 값들"+queue);
		String temp = queue.poll();
		System.out.println("꺼내온 값 "+temp);
		System.out.println("꺼내온 값 "+queue.poll());
		ln();
		
		System.out.println("현재 queue의 값들"+queue);
		System.out.println("성춘향 입력 "+queue.offer("성춘향"));
		System.out.println("현재 queue의 값들"+queue);
		ln();
		
		System.out.println("꺼내온 값 "+queue.poll());
		System.out.println("현재 queue의 값들"+queue);
		ln();
		
		System.out.println("peek로 삭제 없이 꺼내오기 "+queue.peek());
		System.out.println("현재 queue의 값들"+queue);
	}
	
	private void m2() {
		Stack<String> stack = new Stack<String>();
		Queue<String> queue = new LinkedList<String>();
		stack.push("1");
		stack.push("2");
		stack.push("3");
		queue.offer("1");
		queue.offer("2");
		queue.offer("3");
		System.out.println("Stack = "+stack+"      "+"Queue = "+queue);
		System.out.println();
		System.out.println("stack.pop() 하면 "+stack.pop());
		System.out.println("Stack"+stack);
		System.out.println("stack.peek() 하면 "+stack.peek());
		System.out.println("Stack"+stack);
		System.out.println();
		System.out.println("queue.poll() 하면 "+queue.poll());
		System.out.println("Queue"+queue);
		System.out.println("queue.peek() 하면 "+queue.peek());
		System.out.println("Queue"+queue);
		System.out.println();
	}
	
	private void ln() {
		System.out.println("\n----------------\n");
	}
}
