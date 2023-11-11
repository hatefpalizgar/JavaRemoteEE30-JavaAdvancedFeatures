package access_modifiers.p2;

import access_modifiers.p1.C1;

public class C4 extends C1 {
    public void aMethod() {
        // can access c1.publicField
        System.out.println(publicField);

        // can not access c1.defaultField for being in a different package
        // System.out.println(defaultField);

        // can not access c1.privateField
        // System.out.println(privateField);

        // can access c1.protectedField for being a subclass(child) of C1
        System.out.println(protectedField);
    }
}
