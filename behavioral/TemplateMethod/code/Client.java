package behavioral.TemplateMethod.code;

public class Client {
    public static void main(String[] args) {
        TemplateClass templateClass = new ConcreteTemplate();
        templateClass.templateMethod();

        TemplateClass templateClass2 = new ConcreteTemplate2();
        templateClass2.templateMethod();
    }


}
