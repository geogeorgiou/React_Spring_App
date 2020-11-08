package gr.dataverse.react.spring.controller;


import gr.dataverse.react.spring.json.JwtResponse;
import gr.dataverse.react.spring.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
//remove all the spring sandwich code?
//@Before( @BeforeElement(ConsoleLogger.class))
//@Before( @BeforeElement(JWTValidatorController.class))
public class ValidateController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/validJWT")
    public ResponseEntity<?> getValidJWT(@RequestBody JwtResponse jwtResponse){

        try {
            jwtUtil.decodeJWT(jwtResponse.getJwt());
        }catch (Exception e){
            //return not found OR bad request here?
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok("validated!");
    }


}
