package it.gpedulla.serviceA;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import it.gpedulla.serviceA.service.impl.ServiceAImpl;

public class ServiceAImplTest {

    private final ServiceAImpl serviceA = new ServiceAImpl();

    @Test
    public void testReplyWithName() {
        String result = serviceA.reply("Giuseppe");
        assertEquals("Hello Giuseppe from service a.", result);
    }

    @Test
    public void testReplyWithNullName() {
        String result = serviceA.reply(null);
        assertEquals("Hello guest from service a.", result);
    }
}

