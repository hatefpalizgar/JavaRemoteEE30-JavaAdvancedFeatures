package abstraction.interfaces;

import java.io.Serializable;

// 1. Interfaces can extend(inherit) each other just like classes
// 2. Multiple inheritance is ONLY allowed once both sides are interfaces (parent and child)
public interface Playable extends Loveable, Cloneable, Serializable {
    void play();
}
