package thread.threadpool.executor;

public abstract class Task {
    int identifier;

    Task(int identifier) {
        this.identifier = identifier;
    }

    public abstract void run();
}

