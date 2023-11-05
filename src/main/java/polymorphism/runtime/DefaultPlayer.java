package polymorphism.runtime;

public class DefaultPlayer extends VodPlayer {
    @Override
    public void play(String title) {
        System.out.println("Default player is playing " + title);
    }
}
