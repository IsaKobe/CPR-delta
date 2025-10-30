package cz.richard;

import com.google.inject.Guice;
import com.google.inject.Injector;
import cz.richard.App.App;
import cz.richard.App.BankInjector;
/**
 * Main class
 */
public class Main {


    /**
     * entrypoint
     *
     * @param args cmd args
     */
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new BankInjector());
        App app = injector.getInstance(App.class);
        app.Run();

    }

}
