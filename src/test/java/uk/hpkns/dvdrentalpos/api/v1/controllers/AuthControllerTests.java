package uk.hpkns.dvdrentalpos.api.v1.controllers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AuthControllerTests {

    @Test
    public void testAuthPayload() {
        AuthController.AuthPayload ap = new AuthController.AuthPayload();
        ap.setUsername("__username");
        ap.setPassword("__password");

        assertEquals("__username", ap.getUsername());
        assertEquals("__password", ap.getPassword());
    }

    @Test
    public void testTokenPayload() {
        AuthController.TokenPayload tpErr = new AuthController.TokenPayload("error");
        AuthController.TokenPayload tpSuc = new AuthController.TokenPayload("username", "scope", "token");

        assertFalse(tpErr.isSuccess());
        assertEquals("error", tpErr.getMessage());

        assertTrue(tpSuc.isSuccess());
        assertEquals("username", tpSuc.getUsername());
        assertEquals("scope", tpSuc.getScope());
        assertEquals("token", tpSuc.getToken());
    }

    @Test
    public void testGetSha1Hash() {
        assertEquals("a94a8fe5ccb19ba61c4c0873d391e987982fbbd3", AuthController.getSha1Hash("test"));
    }
}
