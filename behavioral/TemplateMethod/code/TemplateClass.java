package behavioral.TemplateMethod.code;

public abstract class TemplateClass {
    public void templateMethod() {
        primitiveOperation1();
        primitiveOperation2();
        concreteMethod();
    }

     abstract void primitiveOperation1();
     abstract void primitiveOperation2();

    public void concreteMethod() {
        System.out.println("Concrete Method");

    
    }

}
