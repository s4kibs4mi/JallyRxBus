package ninja.sakib.pultusrxbus.text;

import ninja.sakib.pultusrxbus.core.PultusRxBus;

public class Test {
    public static void main(String args[]) {
        PultusRxBus pultusRxBus = PultusRxBus.getInstance();

        pultusRxBus.subscribe(Cat.class, "123", new CatReceiver());
        pultusRxBus.subscribe(String.class, "124", o -> System.out.println(o.toString()));

        pultusRxBus.publish(new Cat("Meow"));

        pultusRxBus.unsubscribe("124");

        pultusRxBus.publish("HelloWorld");
    }
}
