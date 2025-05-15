package com.example.inventario.controller;

import com.example.inventario.enitity.Producto;
import com.example.inventario.service.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Validated
@RestController
@RequestMapping(path = "/api/v1/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> getAll(){
        return productoService.getProductos();
    }

    @PostMapping
    public Producto guardarActualizar(@RequestBody Producto producto){
        productoService.guardarActualizar(producto);
        return producto;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id){
        productoService.eliminar(id);
    }

    @GetMapping("/{id}")
    public Optional<Producto> getProductosId(@PathVariable("id") int id){
        return productoService.getProductosId(id);
    }

    @GetMapping("/test")
    public String test() {
        return "API funcionando";
    }
}
