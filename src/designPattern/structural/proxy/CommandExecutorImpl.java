package designPattern.structural.proxy;

public class CommandExecutorImpl implements  CommandExecutor {

    @Override
    public void run(String command) throws  Exception{

        System.out.println("Executing command :\n" + command);
    }

}
