package config.thread;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component("threadPoolExecutor")
public class ThreadPool implements FactoryBean<ThreadPoolExecutor>, InitializingBean {

    @Autowired
    private Factory factory;
    private ThreadPoolExecutor executor;

    public ThreadPoolExecutor getObject() throws Exception {
        return executor;
    }

    public Class<?> getObjectType() {
        return ThreadPoolExecutor.class;
    }

    public void afterPropertiesSet() throws Exception {
        executor = new ThreadPoolExecutor(20, 20, 60,
                TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(50), factory.getThreadFactory());
    }

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }

    public ThreadPoolExecutor getExecutor() {
        return executor;
    }

    public void setExecutor(ThreadPoolExecutor executor) {
        this.executor = executor;
    }
}
