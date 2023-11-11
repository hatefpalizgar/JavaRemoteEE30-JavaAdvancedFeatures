package access_modifiers.p1;

public class C1 {
    // public is access modifier/ visibility
    // accessible from any other classes
    public int publicField;

    // default access/visibility modifier (package-private or package-access)
    // accessible only by any class in the same package (here p1)
    int defaultField;

    // private modifier
    // accessible only by the class itself
    private int privateField;

    // protected modifier
    // accessible only by the class itself AND classes in the same package AND its subclasses
    protected int protectedField;


    public void publicMethod(){}
    void defaultMethod(){}
    private void privateMethod(){}
    protected void protectedMethod(){}
}
