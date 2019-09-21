package com.cy.pj.common.config;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.tomcat.jni.Pool;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//@Configuration
@ConfigurationProperties("executor")
public class SpringExcutorConfig implements AsyncConfigurer{
	private int corePoolSize=10;
	private int maximumPoolSize=20;
	private int keepAliveTime=30;
	private int queueCapacity=20;
	private ThreadFactory threadFactory=
			new ThreadFactory() {
		private AtomicLong number=new AtomicLong(100);
		@Override
		public Thread newThread(Runnable r) {
			return new Thread(r,"async-thread-"+number.getAndIncrement());
		}
	};
	@Bean("asyncThreadPool")
	public ThreadPoolExecutor newThreadPoolExecutor() {
		ThreadPoolExecutor pool=
				new ThreadPoolExecutor(corePoolSize,
						maximumPoolSize,
						keepAliveTime, 
						TimeUnit.SECONDS, 
						new LinkedBlockingQueue<>(queueCapacity),
						threadFactory);
		return pool;
	}
	
	@Override
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor pool=new ThreadPoolTaskExecutor();
		System.out.println("-------------getAsyncExcutor--------------");
		pool.setCorePoolSize(corePoolSize);
		pool.setMaxPoolSize(maximumPoolSize);
		pool.setKeepAliveSeconds(keepAliveTime);
		pool.setQueueCapacity(queueCapacity);
		//拒绝执行 的处理
		pool.setRejectedExecutionHandler(new RejectedExecutionHandler() {
			@Override
			public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
				//log.error();
			}
		});
		pool.initialize();
		return pool;
	}
	@Override
	public String toString() {
		return "SpringExcutorConfig [corePoolSize=" + corePoolSize + ", maximumPoolSize=" + maximumPoolSize
				+ ", keepAliveTime=" + keepAliveTime + ", queueCapacity=" + queueCapacity + ", threadFactory="
				+ threadFactory + "]";
	}

	public int getCorePoolSize() {
		return corePoolSize;
	}

	public void setCorePoolSize(int corePoolSize) {
		this.corePoolSize = corePoolSize;
	}

	public int getMaximumPoolSize() {
		return maximumPoolSize;
	}

	public void setMaximumPoolSize(int maximumPoolSize) {
		this.maximumPoolSize = maximumPoolSize;
	}

	public int getKeepAliveTime() {
		return keepAliveTime;
	}

	public void setKeepAliveTime(int keepAliveTime) {
		this.keepAliveTime = keepAliveTime;
	}

	public int getQueueCapacity() {
		return queueCapacity;
	}

	public void setQueueCapacity(int queueCapacity) {
		this.queueCapacity = queueCapacity;
	}

	public ThreadFactory getThreadFactory() {
		return threadFactory;
	}

	public void setThreadFactory(ThreadFactory threadFactory) {
		this.threadFactory = threadFactory;
	}

}
