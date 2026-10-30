import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloWorldTest {
    @Test
    void shouldSayHelloWorld() {
        HelloWorld helloWorld = new HelloWorld();

        assertEquals("Hello, World!", helloWorld.say());
    }
}
