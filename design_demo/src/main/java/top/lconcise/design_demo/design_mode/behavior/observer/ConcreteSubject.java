package top.lconcise.design_demo.design_mode.behavior.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liusj
 * @date: 2022/3/23
 */
public class ConcreteSubject implements ISubject {

    private List<IObserver> observers = new ArrayList<>();

    @Override
    public void registerObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Message message) {
        for (IObserver observer : observers) {
            observer.update(message);
        }
    }
}
