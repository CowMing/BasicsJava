package design.pattern.structural.proxy;

/**
 * proxy CommandExecutor class
 */
public class CommandExecutorProxy implements CommandExecutor {

    private boolean isAdmin;
    private CommandExecutor executor;

    public CommandExecutorProxy(String user){
        if("Ming".equals(user)){
            isAdmin = true;
        }
        executor = new CommandExecutorImpl();
    }

    @Override
    public void runCommand(String cmd) throws Exception {
        if(cmd.trim().startsWith("rm")){
            if(!isAdmin){
                throw new Exception("rm command is not allowed for non-admin users.");
            }
        }
        executor.runCommand(cmd);
    }
}
