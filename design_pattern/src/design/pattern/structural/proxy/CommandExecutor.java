package design.pattern.structural.proxy;

/**
 * simple define execute interface
 */
public interface CommandExecutor {

    void runCommand(String cmd) throws Exception;
}
