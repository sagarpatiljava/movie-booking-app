package com.sagar.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/userServiceFallBack")
    public String userServiceFallback(){
        return "User Service is no available. Please try again later";
    }
    @GetMapping("/bookingServiceFallBack")
    public String bookingServiceFallback(){
        return "Booking Service is no available. Please try again later";
    }
    @GetMapping("/theaterServiceFallBack")
    public String theaterServiceFallback(){
        return "Theater Service is no available. Please try again later";
    }
    @GetMapping("/movieServiceFallBack")
    public String movieServiceFallback(){
        return "Movie Service is no available. Please try again later";
    }
}
