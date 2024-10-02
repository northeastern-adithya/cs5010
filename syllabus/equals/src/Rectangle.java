

public class Rectangle extends AbstractShape {

  public Rectangle() {
    super(ShapeEnum.RECTANGLE);
  }

  protected Rectangle(ShapeEnum shape) {
    super(shape);
  }
}
