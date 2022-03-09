import repository.Resource;
import repository.Result;
import thread.Fred;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Launcher
{
    public static void main(String[] args)
    {
        List<Thread> threads = new ArrayList<>();

        Resource input = new Resource();
        Result output = new Result();
        for (int i = 0; i < Integer.parseInt(args[0]); i++)
        {
            threads.add(new Thread(new Fred(input, output)));
        }

        threads.forEach(Thread::start);

        Scanner scanner = new Scanner(System.in);
        int in;
        String a;
        while(true)
        {
            a = scanner.nextLine();
            try{
                in = Integer.parseInt(a);
                input.put(in);
            } catch(Exception ex) {
                threads.forEach(Thread::interrupt);
                break;
            }
        }

        System.out.println(output.toString());
    }
}
