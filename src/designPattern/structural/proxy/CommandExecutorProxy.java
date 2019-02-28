package designPattern.structural.proxy;

public class CommandExecutorProxy extends CommandExecutorImpl {

    private String username;
    private String password;
    private boolean isAdmin;

    public CommandExecutorProxy(String username, String password) {
        this.username = username;
        this.password = password;
        if (username.equals("Shivam") && password.equals("SHIVAM")) {
            isAdmin = true;
        }
    }

    @Override
    public void run(String cmd) throws Exception {
        if (isAdmin) {
            super.run(cmd);
        } else {
            if (cmd.trim().startsWith("rm")) {
                throw new Exception("rm command is not allowed for non-admin users.");
            } else {
                super.run(cmd);
            }
        }
    }

}
