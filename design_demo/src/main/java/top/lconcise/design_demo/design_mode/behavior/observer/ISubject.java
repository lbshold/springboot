package top.lconcise.design_demo.design_mode.behavior.observer;

/**
 * @author: liusj
 * @date: 2022/3/23
 */
public interface ISubject {

    void registerObserver(IObserver observer);

    void removeObserver(IObserver observer);

    void notifyObservers(Message message);
}
