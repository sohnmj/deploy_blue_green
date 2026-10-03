package wordbook.backend.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/healthcheck")
public class HealthCheckerController {
    @Value("${server.env}")
    private String env;

    @Value("${server.port}")
    private String serverPort;
    @Value("${server.serverName}")
    private String serverName;
    @GetMapping("/hc")
    public ResponseEntity<?>healthcheck(){
        Map<String,String> responseData=new HashMap<>();
        responseData.put("serverName",serverName);
        responseData.put("serverPort",serverPort);

        return ResponseEntity.ok(responseData);
    }

    @GetMapping("/env")
    public ResponseEntity<?>envcheck(){

        return ResponseEntity.ok(env);
    }
}
