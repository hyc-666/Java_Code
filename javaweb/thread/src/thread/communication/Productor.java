package thread.communication;

/**
 * 线程间通信
 * 经典例题:生产者/消费者问题
 * ●生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处
 * 取走产品，店员一次只能持有固定数量的产品(比如:20)，如果生产者试图
 * 生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品了再通
 * 知生产者继续生产;如果店中没有产品了，店员会告诉消费者等一- -下，如
 * 果店中有产品了再通知消费者来取走产品。
 * 9●这里可能出现两个问题:
 * ➢生产者比消费者快时，消费者会漏掉--些数据没有取到。
 * ➢消费者比生产者快时，消费者会取相同的数据。|
 *
 * @author hyc
 * @date 2020/8/9
 */
public class Productor extends Thread{
    private Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始生产。。。");
        while (true){
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produce();
        }
    }
}
class Clerk{
    private int produceNum = 0;

    public Clerk() {
    }

    public Clerk(int produceNum) {
        this.produceNum = produceNum;
    }

    public synchronized void produce() {
        if (produceNum < 20) {
            produceNum++;
            System.out.println("产品+1，剩余量为" + ": " + produceNum);

            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consume() {
        if (produceNum > 0) {
            produceNum--;
            System.out.println("产品-1，剩余量为" + ": " + produceNum);
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Customer extends Thread{
    private Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始消费。。。");
        while (true){
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consume();
        }
    }
}

class ProductTest{
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Productor p = new Productor(clerk);
        Customer c = new Customer(clerk);

        p.setName("生产者1");
        c.setName("消费者1");

        p.start();
        c.start();
    }
}