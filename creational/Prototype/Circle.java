import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")  // This makes it a Prototype Bean
public class Circle {
    private int radius;

    public Circle() {
        this.radius = 10; // Default radius
        System.out.println("New Circle Object Created");
    }

    public void draw() {
        System.out.println("Drawing a Circle with radius " + radius);
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
