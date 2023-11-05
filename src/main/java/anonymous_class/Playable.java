package anonymous_class;

import abstraction.interfaces.Loveable;

public interface Playable extends Loveable {
    void play();
    // inherits love() implicitly from Loveable interface
}
