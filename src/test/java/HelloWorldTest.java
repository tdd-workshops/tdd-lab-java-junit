import org.junit.Test;
import org.junit.Assert;

public class HelloWorldTest {
    @Test
    public void shouldSayHelloWorld() {
        HelloWorld helloWorld = new HelloWorld();

        Assert.assertEquals("Hello, World!", helloWorld.say());
    }

}