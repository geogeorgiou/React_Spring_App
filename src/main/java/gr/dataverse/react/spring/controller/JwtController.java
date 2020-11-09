package gr.dataverse.react.spring.controller;

import gr.dataverse.react.spring.json.JwtRequest;
import gr.dataverse.react.spring.util.JwtUtil;
import gr.dataverse.react.spring.util.UserAuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/jwt")
public class JwtController {

    //remove this when done (logic goes into UserAuth)
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserAuthUtil userAuth;

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

    @PostMapping("/userAuth")
    public ResponseEntity<?> isUserAuth(HttpServletRequest request, HttpServletResponse response) {

        boolean isAuthUser = userAuth.isUserAuth(request);
        if (!isAuthUser){
            return ResponseEntity
                    .badRequest()
                    .body("Error: user unauthorized!");
        }

        return ResponseEntity.ok("valid");
//        return ResponseEntity.ok("valid="+userAuth.isUserAuth(request));
    }


}


