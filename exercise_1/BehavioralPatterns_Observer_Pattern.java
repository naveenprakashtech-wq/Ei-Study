package exercise_1;
import java.util.*;
interface Observer {
	void update(String weather);
}
class WeatherStation {
	private List<Observer> observers = new ArrayList<>();
	private String weather;
	public void addObserver(Observer obs) {
		observers.add(obs);
	}
	public void setWeather(String weather) {
		this.weather = weather;
		notifyObservers();
	}
	private void notifyObservers() {
		for (Observer obs : observers) {
			obs.update(weather);
		}
	}
}
class PhoneDisplay implements Observer {
	private String name;
	public PhoneDisplay(String name) {
		this.name = name;
	}
	public void update(String weather) {
		System.out.println(name + " received weather update: " + weather);
	}
}
public class BehavioralPatterns_Observer_Pattern {
	public static void main(String[] args) {
		WeatherStation station = new WeatherStation();
		station.addObserver(new PhoneDisplay("Phone 1"));
     	station.addObserver(new PhoneDisplay("Phone 2"));
     	station.setWeather("Sunny");
     	station.setWeather("Rainy");
	}
}
