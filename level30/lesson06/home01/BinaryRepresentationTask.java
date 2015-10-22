package com.javarush.test.level30.lesson06.home01;
import java.util.concurrent.RecursiveTask;
/**
 * Created by Александр on 09.10.2015.
 */
public class BinaryRepresentationTask extends RecursiveTask
{
    private int i;

    public BinaryRepresentationTask(int i)
    {
        this.i = i;
    }

    @Override
    protected Object compute()
    {
        /*int a = i % 2;
        int b = i / 2;
        String result = String.valueOf(a);
        while (b > 0) {
            a = b % 2;
            b = b / 2;
            result = String.valueOf(a) + result;
        }
        return result;*/
        int a = i % 2;
        int b = i / 2;
        //String result = "";

        if (b == 0) {
            return String.valueOf(a);
        }
        else {
            BinaryRepresentationTask task = new BinaryRepresentationTask(b);
            task.fork();
            //result = result + task.join();
            return task.join() + String.valueOf(a);
        }
    }
}