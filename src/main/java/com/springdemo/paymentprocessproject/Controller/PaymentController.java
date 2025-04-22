package com.springdemo.paymentprocessproject.Controller;

import com.springdemo.paymentprocessproject.DTO.PaymentRequest;
import com.springdemo.paymentprocessproject.DTO.PaymentResponse;
import com.springdemo.paymentprocessproject.DTO.User;
import com.springdemo.paymentprocessproject.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Custom editor to convert user ID to uppercase
        binder.registerCustomEditor(String.class, "id", new org.springframework.beans.propertyeditors.StringTrimmerEditor(true) {
            @Override
            public void setAsText(String text) {
                super.setAsText(text != null ? text.toUpperCase() : null);
            }
        });
    }

    @GetMapping("/fetchuser/{firstName}")
    public String fetchUser(@PathVariable String firstName) {
        // Capitalize the first letter and make the rest lowercase
        String formattedName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
        return "Hello " + formattedName + " ji";
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponse> getPaymentById(@PathVariable Long id) {

        //map incoming data to internal request DTO
         PaymentRequest internalRequestObj = new PaymentRequest();
         internalRequestObj.setPaymentId(id);

         //pass this internal request DTO to further layer for processing
        PaymentResponse paymentResponse = paymentService.getPaymentDetailsById(internalRequestObj);
        //return respond dto
        return ResponseEntity.ok(paymentResponse);
    }

    @GetMapping("/search")
    public String search(@RequestParam String keyword) {
        return "You searched for: " + keyword;
    }

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable String id) {
        return "User ID: " + id;
    }

    @GetMapping("/users/{id}")
    public String getUser(@PathVariable String id, @RequestParam(required = false) String details) {
        return "User ID: " + id + ", Details: " + (details != null ? details : "N/A");
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        // Access the fields from the User object
        String response = "User created with username: " + user.getUsername() + " and email: " + user.getEmailId();
        return ResponseEntity.ok(response);
    }
}
