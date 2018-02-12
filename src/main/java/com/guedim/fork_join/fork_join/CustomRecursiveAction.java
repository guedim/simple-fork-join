package com.guedim.fork_join.fork_join;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.logging.Logger;

/**
 * 
 * @author MARIO.GUERRERO
 * View: http://www.baeldung.com/java-fork-join
 */
public class CustomRecursiveAction extends RecursiveAction {
	 
    private static final long serialVersionUID = 1L;
	
	
	private String workload = "";
    private static final int THRESHOLD = 4;
 
    private static Logger logger = Logger.getAnonymousLogger();
 
    public CustomRecursiveAction(String workload) {
        this.workload = workload;
    }
 
    @Override
    protected void compute() {
        if (workload.length() > THRESHOLD) {
            ForkJoinTask.invokeAll(createSubtasks());
        } else {
           processing(workload);
        }
    }
 
    private List<CustomRecursiveAction> createSubtasks() {
        List<CustomRecursiveAction> subtasks = new ArrayList<>();
 
        String partOne = workload.substring(0, workload.length() / 2);
        String partTwo = workload.substring(workload.length() / 2, workload.length());
 
        subtasks.add(new CustomRecursiveAction(partOne));
        subtasks.add(new CustomRecursiveAction(partTwo));
 
        return subtasks;
    }
 
    private void processing(String work) {
    	sleep(2000);
    	String result = work.toUpperCase();
        logger.info("This result - (" + result + ") - was processed by "  + Thread.currentThread().getName());
    }
    
    private void sleep(long ms) {
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}