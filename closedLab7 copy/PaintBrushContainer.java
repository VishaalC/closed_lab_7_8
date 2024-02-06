package closedLab7;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Program to implement a paintbrush and paint containers using generics and annotations
 * @author vishaalc
 */

public class PaintBrushContainer {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        System.out.println("Choose patient: \n1.Red Paint\n2.Blue Paint\n3.Green Paint\n4.DryAir");
        int choice = scan.nextInt();
		switch(choice) {
		case 1:
			PaintBrushCreator.createPaintBrush(new RedPaint());
			break;
		case 2:
			PaintBrushCreator.createPaintBrush(new BluePaint());
			break;
		case 3:
			PaintBrushCreator.createPaintBrush(new GreenPaint());
			break;
		case 4:
			PaintBrushCreator.createPaintBrush(new DryAirContainer());
		}
		scan.close();
	}
}
// paintbrush class
class PaintBrush<T> {
	private String name;
	private int quantity;
	private T BrushObj;
	private Method brushMethod;
	
	// creating and initializing template object
	public void setType(T obj) throws Exception{
		this.BrushObj = obj;
		
		Field field=BrushObj.getClass().getDeclaredField("name");
		Method getMethod = BrushObj.getClass().getDeclaredMethod("doFunction");
		getMethod.setAccessible(true);

		UsedWithBrush annotationVal=field.getAnnotation(UsedWithBrush.class);
		this.name=annotationVal.name();
		this.quantity=annotationVal.quantity();
		this.brushMethod=getMethod;
	}
	
	// return template object
	public T getObj() {
		return BrushObj;
	}
	
	// invoking brushMethod
	public void doFunction() throws Exception {
		brushMethod.invoke(BrushObj);
	}
	
	@Override
	public String toString() {
		return "PaintBrush [name=" + name + ", quantity=" + quantity + ", BrushObj=" + BrushObj + "]";
	}
	
}

class PaintBrushCreator {
	static public <T> void createPaintBrush(T obj) {
		try {
            PaintBrush<T> paintBrush = new PaintBrush<>();
            paintBrush.setType(obj);
            paintBrush.doFunction();
            System.out.println(paintBrush);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}

// annotation used to provide meta data
@Retention(RetentionPolicy.RUNTIME)
@interface UsedWithBrush {
	
	// default values for fields
	String name() default "none";
	int quantity() default 0;
}

// redpaint class with values in metadata
class RedPaint {
	@UsedWithBrush
	(name = "Red Paint", quantity = 2)
	String name;
	
	public void doFunction() {
		System.out.println("Painting the town red");
	}
	
}

// bluepaint class with values in metadata
class BluePaint {
	@UsedWithBrush
	(name = "Blue Paint", quantity = 2)
	String name;
	int quantity;
	
	public void doFunction() {
		System.out.println("Painting the town blue");
	}
}

//greenpain class with values in metadata
class GreenPaint {
	@UsedWithBrush
	(name = "Green Paint", quantity = 2)
	String name;
	int quantity;

	public void doFunction() {
		System.out.println("Painting the town green");
	}
}

// dry air class
class DryAirContainer {
	@UsedWithBrush
	(name="Dry Air")
	String name;
	int quantity;
	
	public void doFunction() {
		System.out.println("Painting the town with nothing");
	}
}

// water class
class WaterContainer {
	@UsedWithBrush
	(name="Water")
	String name;
	int quantity;

	public void doFunction() {
		System.out.println("Painting the town with water?");
	}
}

