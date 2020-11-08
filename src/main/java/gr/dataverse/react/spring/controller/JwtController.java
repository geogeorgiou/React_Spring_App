package gr.dataverse.react.spring.controller;

import gr.dataverse.react.spring.json.JwtRequest;
import gr.dataverse.react.spring.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jwt")
public class JwtController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/enc")
    public ResponseEntity<?> encodeJWT(@RequestBody JwtRequest request) {
        return ResponseEntity.ok(
                jwtUtil.createJWT(
                        request.getId(),
                        request.getIssuer(),
                        request.getSubject(),
                        request.getTtlMillis())
        );
    }

    @PostMapping("/dec")
    public ResponseEntity<?> decodeJWT(@RequestBody String jwt){
        return ResponseEntity.ok(jwtUtil.decodeJWT(jwt));
    }


}


