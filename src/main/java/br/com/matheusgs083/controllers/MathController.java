package br.com.matheusgs083.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @RequestMapping("/sum/{num1}/{num2}")
    public Double sum(@PathVariable("num1") String num1, @PathVariable("num2") String num2) throws Exception {
            if(isNumeric(num1) || isNumeric(num2)) throw new IllegalArgumentException();
            return convertToDouble(num1) + convertToDouble(num2);
        }

    @RequestMapping("/subtraction/{num1}/{num2}")
    public Double subtraction(@PathVariable("num1") String num1, @PathVariable("num2") String num2) throws Exception{
        if(isNumeric(num1) || isNumeric(num2)) throw new IllegalArgumentException();
        return convertToDouble(num1) - convertToDouble(num2);
    }

    private Double convertToDouble(String num) {
        if (num == null || num.isEmpty()){
            throw new IllegalArgumentException();
        }
        String number = num.replaceAll(",", ".");
        return Double.parseDouble(number);
    }

    private boolean isNumeric(String num) {
        if (num == null || num.isEmpty()){
            throw new IllegalArgumentException();
        }
        String number = num.replaceAll(",", ".");
        return !number.matches("[-+]?[0-9]*\\.?[0-9]+");

    }
}
