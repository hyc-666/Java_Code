package thread_test;
//2、通过实现runnable接口

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;

/**
 * @author hyc
 * @date 2020/5/16
 **/
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        new Thread(runnable).start();
    }
}
