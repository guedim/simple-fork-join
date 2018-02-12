package com.guedim.fork_join.fork_join;

import java.util.concurrent.ForkJoinPool;
import java.util.logging.Logger;

/**
 * ForkJoinSample!
 *
 */
public class ForkJoinSample {
	
	private static Logger logger = Logger.getAnonymousLogger();
	
	public static ForkJoinPool forkJoinPool = new ForkJoinPool(4);
	
	public static void main(String[] args) {
		
		CustomRecursiveAction cra = new CustomRecursiveAction("prueba fork join con varios hilos");
		forkJoinPool.invoke(cra);
		logger.info("Fin del procesamiento !!!");
		
		
	}
}
