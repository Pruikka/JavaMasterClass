package petrihannonen;

class Car {
    private String name;
    private boolean engine;
    private int cylinders;
    private int wheels;

    public Car(String name, int cylinders) {
        this.name = name;;
        this.cylinders = cylinders;
        this.engine = true;
        this.wheels = 4;
    }

    public String startEngine() {
        return "Cars engine started";
    }

    public String accelerate() {
        return "Car accelerating...";
    }

    public String brake() {
        return "Car slowing down...";
    }

    public String getName() {
        return name;
    }

    public int getCylinders() {
        return cylinders;
    }
}

class Mitsubishi extends Car {
    public Mitsubishi(String name, int cylinders) {
        super(name, cylinders);
    }

    @Override
    public String startEngine() {
        return "Mitsubishi engine started";
    }

    @Override
    public String accelerate() {
        return "Mitsubishi accelerating...";
    }

    @Override
    public String brake() {
        return "Mitsubishi slowing down...";
    }
}

class Ford extends Car {
    public Ford(String name, int cylinders) {
        super(name, cylinders);
    }

    @Override
    public String startEngine() {
        return "Ford engine started";
    }

    @Override
    public String accelerate() {
        return "Ford accelerating...";
    }

    @Override
    public String brake() {
        return "Ford slowing down...";
    }
}

class Holden extends Car {
    public Holden(String name, int cylinders) {
        super(name, cylinders);
    }

    @Override
    public String startEngine() {
        return getClass().getSimpleName() + " engine started";
    }

    @Override
    public String accelerate() {
        return getClass().getSimpleName() + " accelerating...";
    }

    @Override
    public String brake() {
        return getClass().getSimpleName() + " slowing down...";
    }
}

public class Main {

    public static void main(String[] args) {
        Car car = new Car("Base car", 8);
        System.out.println(car.startEngine());
        System.out.println(car.accelerate());
        System.out.println(car.brake());

        Mitsubishi mitsubishi = new Mitsubishi("Outlander VRW 4WD" , 6);
        System.out.println(mitsubishi.startEngine());
        System.out.println(mitsubishi.accelerate());
        System.out.println(mitsubishi.brake());

        Ford ford = new Ford("Ford Falcon" , 6);
        System.out.println(ford.startEngine());
        System.out.println(ford.accelerate());
        System.out.println(ford.brake());

        Holden holden = new Holden("Holden Commodore" , 6);
        System.out.println(holden.startEngine());
        System.out.println(holden.accelerate());
        System.out.println(holden.brake());
    }
}
