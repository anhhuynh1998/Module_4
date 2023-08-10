package com.example.gift_vinh_gv.controller;

import com.example.gift_vinh_gv.service.auth.AuthService;
import com.example.gift_vinh_gv.service.auth.request.RegisterRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@Controller
public class AuthController {
    private final AuthService authService;
    @GetMapping("/login")
    public String showLogin(){
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterform(Model model){
        RegisterRequest user = new RegisterRequest();
        model.addAttribute("user",user);
        return "register";
    }
    @PostMapping("/register")
    public String registration(@Valid @ModelAttribute("user") RegisterRequest request,
                               BindingResult result,
                               Model model){
        authService.checkUsernameOrPhoneNumberOrEmail(request, result);
        if(result.hasErrors()){
            return "/register";
        }

        authService.register(request);
        return "redirect:/register?success";
    }
}
