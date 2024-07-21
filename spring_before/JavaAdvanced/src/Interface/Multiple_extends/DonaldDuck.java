package Interface.Multiple_extends;

public class DonaldDuck implements DuckInterface{

    @Override
    public void fly() {
        
    }

    @Override
    public void hunt() {

    }

    @Override
    public void swim() {

    }

    @Override
    public void playInnocent() {
        System.out.println("저는 오리가 아님");
    }
}
