package in.ogmatech.techstile.drycleanservice.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HelloWorld {

    @GetMapping("/api/test")
    public String home(){
        return "Hello Raki";
    }

    @GetMapping("/api/hello")
    public String helloUser(){
        //The authenticated user can be fetched using the SecurityContextHolder
        String username = new SecurityContextHolder().getContext().getAuthentication().getName();
        return String.format("Hello '%s'!", username);
    }

    @GetMapping("/api/admin")
    // If controller request asks for the Principal user in
    // the method declararion Spring security will provide it.
    public String helloAdmin(Principal principal){
        return String.format("Welcom '%s'!", principal.getName());

    }

    // A helper class to make our controller output look nice
    public static class RestMsg {
        private String msg;
        public RestMsg(String msg) {
            this.msg = msg;
        }
        public String getMsg() {
            return msg;
        }
        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}
