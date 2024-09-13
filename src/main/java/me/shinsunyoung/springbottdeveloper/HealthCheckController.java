package me.shinsunyoung.springbottdeveloper;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;

@RestController
public class HealthCheckController {

    @Value("${server.env}")
    private String env;
    @Value("${server.port}")
    private  String serverport;
    @Value("${server.serverAddress}")
    private  String serverAddress;
    @Value("${serverName}")
    private  String serverName;


    @GetMapping("/hc")
    public ResponseEntity<?> healthCheck() {
        Map<String, String> responseData = new TreeMap<>();
        responseData.put("serverName", serverName);
        responseData.put("serverAddress", serverAddress);
        responseData.put("serverport", serverport);
        responseData.put("env", env);
        return ResponseEntity.ok(responseData);
    }

    @GetMapping("/env")
    public ResponseEntity<?> getEnv() {
        return ResponseEntity.ok(env);
    }
}
