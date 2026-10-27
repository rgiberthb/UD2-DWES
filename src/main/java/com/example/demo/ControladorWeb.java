package com.example.demo;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorWeb {

    @GetMapping(value = "/resultados")
    public String resultadosGet(@RequestParam(required = false) String texto) {
        return respuesta("GET", texto);
    }

    @PostMapping(value = "/resultados")
    public String resultadosPost(@RequestParam(required = false) String texto) {
        return respuesta("POST", texto);
    }

    @GetMapping(value = "/ver")
    public String ver(@RequestParam(required = false) String texto) {
        return "<h1>Recibido en /ver</h1>"
                + "<p>Texto: " + texto + "</p>"
                + "<p><a href=\"/\">Volver</a></p>";
    }

    private String respuesta(String metodo, String texto) {
        String Textocodificado = "";
        if (texto != null) {
        	Textocodificado = URLEncoder.encode(texto, StandardCharsets.UTF_8);
        }
        return "<h1>Recibido por " + metodo + "</h1>"
                + "<p>Texto: " + texto + "</p>"
                + "<p>Texto codificado: " + Textocodificado + "</p>"
                + "<p><a href=\"/ver?texto=" + Textocodificado + "\">Enlace codificado</a></p>"
                + "<p><a href=\"/ver?texto=" + texto + "\">Enlace sin codificar</a></p>"
                + "<p><a href=\"/\">Volver</a></p>";
    }
}
