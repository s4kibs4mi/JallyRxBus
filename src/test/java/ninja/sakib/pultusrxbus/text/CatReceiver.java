package ninja.sakib.pultusrxbus.text;

import io.reactivex.functions.Consumer;

public class CatReceiver implements Consumer<Cat> {

    @Override
    public void accept(Cat cat) throws Exception {
        System.out.println(cat.toString());
    }
}
