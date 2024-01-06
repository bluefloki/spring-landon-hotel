package edu.wgu.d387_sample_code.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {
    private static String englishGreeting;
    private static String frenchGreeting;

    public String getEnglishGreeting() {
        return englishGreeting;
    }

    public String getFrenchGreeting() {
        return frenchGreeting;
    }

    public static void setEnglishGreeting(String greeting) {
        englishGreeting = greeting;
    }

    public static void setFrenchGreeting(String greeting) {
        frenchGreeting = greeting;
    }

    @GetMapping("/welcome")
    @ResponseBody
    public static String[] getEnglishGreeting(Model model) {
        String[] response = new String[2];

        response[0] = englishGreeting;
        response[1] = frenchGreeting;

        return response;
    }
}
