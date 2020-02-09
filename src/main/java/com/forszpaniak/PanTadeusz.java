package com.forszpaniak;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class PanTadeusz {

    public static void main(String[] args) throws IOException, URISyntaxException {
        //Path currentDir = Path.of(".");
        //System.out.println(currentDir.toAbsolutePath());
        URI uri = PanTadeusz.class.getClassLoader().getResource("pan-tadeusz.txt").toURI();
        System.out.println("OK");
    }
}