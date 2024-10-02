

public abstract class AbstractShape implements Shape{

  protected final ShapeEnum shapeEnum;


  protected AbstractShape(ShapeEnum shapeEnum){
    this.shapeEnum = shapeEnum;
  }

  @Override
  public boolean equals(Object obj){
    if(obj == this){
      return true;
    }
    if(!(obj instanceof AbstractShape)){
      return false;
    }
    AbstractShape other = (AbstractShape) obj;
    boolean isEquals  = false;


    switch (this.shapeEnum){
      case CIRCLE:
        isEquals= other.equalsCircle((Circle) this);
        break;
      case SQUARE:
        isEquals =  other.equalsSquare((Square) this);
        break;
      case RECTANGLE:
        isEquals =  other.equalsRectangle((Rectangle) this);
        break;
    }

    return isEquals;
  }


  protected boolean equalsCircle(Circle circle){
    return  false;
  }

  protected boolean equalsSquare(Square square){
    return  false;
  }

  protected boolean equalsRectangle(Rectangle rectangle){
    return  false;
  }

}
