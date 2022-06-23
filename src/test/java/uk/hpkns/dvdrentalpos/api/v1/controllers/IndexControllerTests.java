package uk.hpkns.dvdrentalpos.api.v1.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class IndexControllerTests {

    @Test
    public void testInfo() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getRemoteAddr()).thenReturn("127.0.0.1");

        IndexController ic = new IndexController();
        IndexController.ApiInfo info = ic.info(request);

        assertTrue(info.isAlive());
        assertEquals("127.0.0.1", info.getRemoteAddr());
        assertNotNull(info.getServerTime());
    }
}
