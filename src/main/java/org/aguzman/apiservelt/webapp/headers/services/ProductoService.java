package org.aguzman.apiservelt.webapp.headers.services;

import org.aguzman.apiservelt.webapp.headers.models.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> listar();
    Optional<Producto> porId(Long id);
}
