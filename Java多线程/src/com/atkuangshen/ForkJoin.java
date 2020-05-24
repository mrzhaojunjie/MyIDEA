package com.atkuangshen;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoin extends RecursiveTask<Long> {
    private Long start;
    private Long end;

    private Long temp = 10000L;
    public ForkJoin(Long start,Long end){
        this.start = start;
        this.end = end;
    }


    @Override
    protected Long compute() {
        if(end - start < temp){
            Long sum = 0L;
            for(Long i = start;i <= end;i++){
                sum += i;
            }
            return sum;
        }else{
            Long middle = (start + end)/2;
            ForkJoin task1 = new ForkJoin(start, middle);
            task1.fork();
            ForkJoin task2 = new ForkJoin(middle+1,end);
            task2.fork();
            return task1.join()+task2.join();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinTask<Long> task = new ForkJoin(0L, 10_0000_0000L);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);
        System.out.println(submit.get());
    }
}
