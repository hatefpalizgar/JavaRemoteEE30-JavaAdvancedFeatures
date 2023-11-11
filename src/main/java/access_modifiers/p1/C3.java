package access_modifiers.p1;

public class C3 extends C1{
    public void aMethod() {

        // can access c1.publicField
        System.out.println(publicField);

        // can access c1.defaultField
        System.out.println(defaultField);

        // can not access c1.privateField
        // System.out.println(c1.privateField);

        // can access c1.protectedField
        System.out.println(protectedField);
    }
}
