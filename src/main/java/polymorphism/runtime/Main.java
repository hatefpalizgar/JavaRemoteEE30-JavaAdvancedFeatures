package polymorphism.runtime;

/*
 * I recommend you reading my article on Medium website:
 * https://medium.com/swlh/why-and-when-to-use-polymorphism-ffcbf3709509
 **/
public class Main {
    public static void main(String[] args) {
        // To provide argument to a Java application:
        // 1. use IDE 'Modify run configuration' menu
        // 2. pass the argument(s) via Java CLI command
        String player = args[0];
        VodPlayer vodPlayer = null;

        if(player.equals("Netflix")){
            vodPlayer = new NetflixPlayer();
        } else if (player.equals("HBO")){
            vodPlayer = new HBOPlayer();
        } else {
            vodPlayer = new DefaultPlayer();
        }

        // the exact implementation of play() below will be defined during runtime thanks to
        // method overriding (runtime polymorphism)
        vodPlayer.play("FRIENDS_S1E1");

    }
}
