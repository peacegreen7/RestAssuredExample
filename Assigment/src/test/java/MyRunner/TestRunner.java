package MyRunner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import Tests.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        APITest.class,
        SortTest.class,
        FilterRequest.class,
        ProvideXpath.class,
})

public class TestRunner {

}
