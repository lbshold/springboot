package top.lconcise.design_demo.design_mode.behavior.observer;

/**
 * @author: liusj
 * @date: 2022/3/23
 */
public class Demo {

    public static void main(String[] args) {
        IObserver observerA = new ObserverA();
        IObserver observerB = new ObserverB();
        ISubject subject = new ConcreteSubject();
        subject.registerObserver(observerA);
        subject.registerObserver(observerB);
        subject.notifyObservers(new Message());
    }
}
