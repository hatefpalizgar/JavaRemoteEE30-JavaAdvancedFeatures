package polymorphism.runtime;

public class NetflixPlayer extends VodPlayer {
    @Override
    public void play(String title) {
        System.out.println("Netflix is playing: " + title);
    }
}
