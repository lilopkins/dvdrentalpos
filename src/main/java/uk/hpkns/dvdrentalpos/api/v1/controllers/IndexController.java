package uk.hpkns.dvdrentalpos.api.v1.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/")
public class IndexController {

    @GetMapping("")
    public @ResponseBody ApiInfo info(HttpServletRequest request) {
        return new ApiInfo(request);
    }

    private static class ApiInfo {
        boolean alive = true;
        LocalDateTime serverTime;
        String remoteAddr;

        public ApiInfo(HttpServletRequest request) {
            serverTime = LocalDateTime.now();
            remoteAddr = request.getRemoteAddr();
        }

        public boolean isAlive() {
            return alive;
        }

        public LocalDateTime getServerTime() {
            return serverTime;
        }

        public String getRemoteAddr() {
            return remoteAddr;
        }
    }
}
