package thread;

import lombok.SneakyThrows;
import repository.Resource;
import repository.Result;

import java.util.Random;

public class Fred implements Runnable
{
    Resource in;
    Result out;
    int sleepTime = 0;

    public Fred(Resource input, Result output)
    {
        in = input;
        out = output;
    }

    @SneakyThrows
    public boolean isPrime(int value)
    {
        Random random = new Random();
        int randTime = random.nextInt(2000);
        sleepTime += randTime;
        Thread.sleep(randTime); // simulate calculations

        if (value <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void run() {
        while(!Thread.interrupted())
        {
            try{
                int value = in.take();
                if(isPrime(value))
                {
                    out.putResult(value);
                }
            }catch(InterruptedException ex){
                System.out.println("Thread with id = " + Thread.currentThread().getId() +
                        " has finished and was working for " + "has finished and was working for " + sleepTime);
                break;
            }
        }
    }
}
