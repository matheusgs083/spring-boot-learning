package br.com.matheusgs083.controllers;

import br.com.matheusgs083.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.matheusgs083.service.MathService;

import static org.apache.tomcat.util.http.parser.HttpParser.isNumeric;

@RestController
@RequestMapping("/math")
public class MathController {

    private final MathService mathService = new MathService();

    @RequestMapping("/sum/{num1}/{num2}")
    public Double sum(@PathVariable("num1") String num1, @PathVariable("num2") String num2) throws Exception {
            if(mathService.isNumeric(num1) || mathService.isNumeric(num2)) throw new UnsupportedMathOperationException("Please set a numeric value!");
            return mathService.convertToDouble(num1) + mathService.convertToDouble(num2);
        }

    @RequestMapping("/subtraction/{num1}/{num2}")
    public Double subtraction(@PathVariable("num1") String num1, @PathVariable("num2") String num2) throws Exception{
        if(mathService.isNumeric(num1) || mathService.isNumeric(num2)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return mathService.convertToDouble(num1) - mathService.convertToDouble(num2);
    }

    @RequestMapping("/division/{num1}/{num2}")
    public Double division(@PathVariable("num1") String num1, @PathVariable("num2") String num2) throws Exception{
        if (mathService.isNumeric(num1) || mathService.isNumeric(num2)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        if (mathService.convertToDouble(num2) == 0) throw  new  UnsupportedMathOperationException("Division by zero is impossible!");
        return mathService.convertToDouble(num1) / mathService.convertToDouble(num2);
    }

}
