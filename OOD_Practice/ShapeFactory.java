package ood_disign;
//Factory is a design pattern in common usage.
//Implement a ShapeFactory that can generate correct shape
//we have differnt three shapes: Triangle, Square, Rectangle

/**
 * Your object will be instantiated and called as such:
 * ShapeFactory sf = new ShapeFactory();
 * Shape shape = sf.getShape(shapeType);
 * shape.draw();
 */
interface Shape {
    void draw();
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println(" ---- ");
        System.out.println("|    |");
        System.out.println(" ---- ");
    }
    
    // Write your code here
}

class Square implements Shape {
    @Override
   public void draw() {
        System.out.println(" ---- ");
        System.out.println("|    |");
        System.out.println("|    |");
        System.out.println(" ---- ");
   }
    // Write your code here
}

class Triangle implements Shape {
    @Override
   public void draw() {
        System.out.println("  /\\");
        System.out.println(" /  \\");
        System.out.println("/____\\");
   }
    // Write your code here
}

public class ShapeFactory {
    /**
     * @param shapeType a string
     * @return Get object of type Shape
     */
    public Shape getShape(String shapeType) {
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("Rectangle")){
            return new Rectangle();    
        }
        else if(shapeType.equalsIgnoreCase("Square")){
            return new Square();    
        }
        else if(shapeType.equalsIgnoreCase("Triangle")){
            return new Triangle();
        }
        return null;
       
    }
}