package designPattern.structural.proxy;

public class ProxyPatternTest {

    public static void main(String args[]) throws Exception {
        CommandExecutorProxy proxy = new CommandExecutorProxy("Shivam", "shivam");
        proxy.run("ls");
        proxy.run("rm");

    }
}
