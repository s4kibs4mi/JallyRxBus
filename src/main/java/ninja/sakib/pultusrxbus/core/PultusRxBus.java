package ninja.sakib.pultusrxbus.core;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

import java.util.HashMap;
import java.util.Map;

public class PultusRxBus<T> {
    private static PultusRxBus ourInstance = new PultusRxBus();

    public static PultusRxBus getInstance() {
        return ourInstance;
    }

    private Subject<T> busSubject;
    private Map<String, Disposable> disposableMap;

    private PultusRxBus() {
        busSubject = PublishSubject.create();
        disposableMap = new HashMap<>();
    }

    public void subscribe(Class<?> clazz, String consumerId, Consumer<T> consumer) {
        if (disposableMap.containsKey(consumerId)) {
            throwIt("Duplicate consumer id.");
        } else {
            disposableMap.put(consumerId,
                    busSubject
                            .filter(event -> isClassOf(event, clazz))
                            .subscribe(consumer)
            );
        }
    }

    private boolean isClassOf(T x, Class<?> y) {
        return isEquals(x.getClass().getSimpleName(), y.getSimpleName());
    }

    private boolean isEquals(String x, String y) {
        return x == y || x.equals(y);
    }

    public void unsubscribe(String consumeId) {
        if (disposableMap.containsKey(consumeId)) {
            disposableMap.get(consumeId).dispose();
            disposableMap.remove(consumeId);
        } else {
            throwIt("Consumer id not found.");
        }
    }

    public void publish(T value) {
        busSubject.onNext(value);
    }

    private void throwIt(String message) {
        try {
            throw new Exception(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
