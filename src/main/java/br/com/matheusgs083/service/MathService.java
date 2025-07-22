package br.com.matheusgs083.service;

import br.com.matheusgs083.exception.UnsupportedMathOperationException;

public class MathService {

    public Double convertToDouble(String num) {
        String number = num.replaceAll(",", ".");
        return Double.parseDouble(number);
    }

    public boolean isNumeric(String num) {
        if (num == null || num.isEmpty()){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        String number = num.replaceAll(",", ".");
        return !number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
