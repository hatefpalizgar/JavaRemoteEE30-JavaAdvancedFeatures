package access_modifiers.p2;

import access_modifiers.p1.C1;

public class C5 {
    public void aMethod() {
        C1 c1 = new C1();

        // can access c1.publicField
        System.out.println(c1.publicField);

        // can not access c1.defaultField for being in a different package
        // System.out.println(c1.defaultField);

        // can not access c1.privateField
        // System.out.println(c1.privateField);

        // can not access c1.protectedField for being in a different package and not subclass of C1
        // System.out.println(c1.protectedField);
    }
}
