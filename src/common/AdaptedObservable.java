package common;

import java.util.Observable;
import java.util.Observer;

public class AdaptedObservable extends Observable {

	public AdaptedObservable(){}
	public AdaptedObservable(Observer obs) {
		super.addObserver(obs);
	}
	public void notifyObservers()
	{
		super.setChanged();
		super.notifyObservers();
	}
}
