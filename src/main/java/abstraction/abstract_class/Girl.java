package abstraction.abstract_class;

public class Girl extends Human {
    // by extending Human(abstract class) we are "enforcing"
    // any child class of Human(like Girl here) to have two methods: eat() and breathe()

    // using abstract method, is a sort of signing a "contract"

    // By extending Human, we can be %100 sure that any subclass of Human
    // will certainly have two methods: eat() and breathe()
    @Override
    public void eat() {
        // ...
    }

    @Override
    public void breathe() {
        // ...
    }

}
