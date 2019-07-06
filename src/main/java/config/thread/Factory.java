package config.thread;

import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadFactory;

@Component
public class Factory {

    public ThreadFactory getThreadFactory(){
        ThreadFactory factory = new ThreadFactory() {
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                System.out.println("create thread");
                thread.setName("Thread-" + thread.getId());
                return thread;
            }
        };
        return factory;
    }
}
