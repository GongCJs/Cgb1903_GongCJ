package cn.gcjlearn;

        import com.sun.org.apache.bcel.internal.generic.NEW;
        import org.junit.Test;
        import sun.plugin2.util.SystemUtil;

        import java.io.FileInputStream;
        import java.io.FileOutputStream;
        import java.io.OutputStream;
        import java.io.Writer;
        import java.util.Arrays;
        import java.util.Timer;
        import java.util.concurrent.ExecutionException;
        import java.util.concurrent.Future;
        import java.util.concurrent.FutureTask;
        import java.util.concurrent.RunnableFuture;

public class AppTest
{
    @Test
    public void shouldAnswerWithTrue()
    {
        new Thread(() ->{System.out.println("啊啊啊啊");}).start();
    }

    @Test
    public void testCallable(){
        String a;
        RunnableFuture future
                = new FutureTask<String>(
                        () -> {
                            Thread thread = Thread.currentThread();
                            System.out.println(thread.getName());;
                            System.out.println("我是一个Runnable线程，我被执行了");
                            throw new RuntimeException();
                        },"Success");
        new Thread(future).start();
        try {
            Object o = future.get();
            System.out.println(o);
        } catch (InterruptedException e) {
//            e.printStackTrace();
        } catch (ExecutionException e) {
//            e.printStackTrace();
        }

        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        int i = threadGroup.activeCount();
        Thread[] threads = new Thread[i];
        threadGroup.enumerate(threads);
        for (Thread thread : threads){
            Thread.yield();
            System.out.println(thread.getName());
        }
    }



    @Test
    public void testFutureTask(){
        RunnableFuture runnableFuture = new FutureTask<Object>(() -> {
            Thread thread = Thread.currentThread();
            System.out.println("当前线程的名称："+thread.getName());;
            System.out.println("我是Callable线程");
            return "我是一个小小小鸟";
        });
        new Thread(runnableFuture,"龚长江").start();

        try {
            Object o = runnableFuture.get();
            System.out.println("线程的返回值为："+o);
        } catch (InterruptedException e) {
        } catch (ExecutionException e) {
        }
    }

    @Test
    public void testaaa(){
    }
}
