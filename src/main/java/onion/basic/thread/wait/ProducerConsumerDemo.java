package onion.basic.thread.wait;

/*
 * 说明wait,notify或notifyAll的常用范例就是生产者消费者模式。
 * 本例中生产者(Producer)会将生产的产品交给店员(Clerk)，而消费者(Consumer)从店员处取走产品消费，但店员一次只能存储固定数量产品。
 * 若生产者生产速度较快，店员可存储产品的量已满，店员会叫生产者等一下(wait)，如果有空位放产品了再
 * 通知(notify)生产者继续生产；如果消费者速度较快，将店中产品消费完了，店员告诉消费者等一下(wait)，如果
 * 点钟有产品了再通知(notify)来消费。
 *
 */

public class ProducerConsumerDemo
{
	public static void main(String[] args)
	{
		Clerk clerk = new Clerk();
		new Thread(new Producer(clerk)).start();
		new Thread(new Consumer(clerk)).start();
	}
}
