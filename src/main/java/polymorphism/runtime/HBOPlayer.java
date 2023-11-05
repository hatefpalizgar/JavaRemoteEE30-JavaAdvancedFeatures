package polymorphism.runtime;

public class HBOPlayer extends VodPlayer {
    @Override
    public void play(String title) {
        System.out.println("HBO is playing: " + title);
    }
}
