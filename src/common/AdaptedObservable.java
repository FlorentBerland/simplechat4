package common;

import java.util.Observable;
import java.util.Observer;

public class AdaptedObservable extends Observable {

	public AdaptedObservable(){}
	public AdaptedObservable(Observer obs) {
		this.addObserver(obs);
	}
	public void notifyObsevers()
	{
		this.setChanged();
		super.notifyObservers();
	}
}
