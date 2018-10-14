package com.dadagum.team.common.validator;


import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ImageValidator {

    private static Set<String> validSuffixs = new HashSet<>();

    static {
        validSuffixs.add("jpg");
        validSuffixs.add("png");
        validSuffixs.add("bmp");
        validSuffixs.add("gif");
        validSuffixs.add("jpeg");
        validSuffixs.add("svg");
    }

    private static ImageValidator validator = new ImageValidator();

    private static MultipartFile image = null;

    private ImageValidator(){}

    public static ImageValidator getValidator(MultipartFile file){
        image = file;
        return validator;
    }

    public boolean checkAll(){
        System.out.println("in check all");
        return (!checkIfEmpty()) && checkSuffix() && checkIfImage();
    }

    public boolean checkIfEmpty(){
        System.out.println("in check empty");
        return image == null || image.isEmpty();
    }

    public boolean checkSuffix(){
        System.out.println("in check suffix");
        String fileName = image.getOriginalFilename();
        System.out.println("fileName : " + fileName);
        String suffix = fileName.substring(fileName.lastIndexOf('.')+1);
        System.out.println("suffix : " + suffix);
        return validSuffixs.contains(suffix);
    }

    public boolean checkIfImage(){
        System.out.println("in check image");
        Image img = null;
        try {
            img = ImageIO.read(image.getInputStream());
            if (img == null || img.getWidth(null) <= 0 || img.getHeight(null) <= 0)
                return false;
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }



}
