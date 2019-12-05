import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import view.ListView;

public class ListViewTest {
    static final Logger logger =
            LoggerFactory.getLogger(ConcreteFactoryTest.class);
    @Test
    public void testInflate(){
        new ListView();
    }
}
