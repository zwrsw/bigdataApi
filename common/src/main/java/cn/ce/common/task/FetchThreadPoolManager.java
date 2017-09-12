package cn.ce.common.task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FetchThreadPoolManager
{
    static private FetchThreadPoolManager singletonObject = new FetchThreadPoolManager(); 
    private ExecutorService es = null;
    private FetchThreadPoolManager()
    {
       es = Executors.newFixedThreadPool(400);       
    }
    
    public static synchronized FetchThreadPoolManager getInstance()
    {
        if (singletonObject == null)
        {
            singletonObject = new FetchThreadPoolManager();
            
        }
        return singletonObject;
        
    }
    
    public ExecutorService getExecutorService()
    {
        return es;
    }
}
