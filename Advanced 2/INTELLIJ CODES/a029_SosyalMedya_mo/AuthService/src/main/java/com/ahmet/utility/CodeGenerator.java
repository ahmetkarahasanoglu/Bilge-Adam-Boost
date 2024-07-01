package com.ahmet.utility;

import java.util.UUID;

public class CodeGenerator {


    public static String generateCode() {
        String code = UUID.randomUUID().toString();
        String[] dataArr = code.split("-"); // Örneğin şöyle bir uuid kodunu "-" yazan yerlerden bölerek dizi oluşturacaz:  b8cc9c1b-ae32-4474-9313-63eaf055df60 . Daha sonra aşağıda bunun her bir kısmının ilk harfini alarak bir kod oluşturuyoruz.
        String newCode = "";
        for (String el : dataArr) {
            newCode += el.charAt(0);
        }
        return newCode;
    }

}
