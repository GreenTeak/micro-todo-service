//package com.thoughtworks.training.todoserver.feign;
//
//import com.thoughtworks.training.todoserver.model.User;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@FeignClient(name = "user", url = "http://localhost:8081")
//public interface UserFeign {
//    @PostMapping("/verifications")
//    User verifyToken(String token);
//}