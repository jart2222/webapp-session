package org.aguzman.apiservelt.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.aguzman.apiservelt.webapp.headers.models.Carro;
import org.aguzman.apiservelt.webapp.headers.models.ItemCarro;
import org.aguzman.apiservelt.webapp.headers.models.Producto;
import org.aguzman.apiservelt.webapp.headers.services.ProductoService;
import org.aguzman.apiservelt.webapp.headers.services.ProductoServiceImpl;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/elimar-carro")
public class EliminarCarroServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        ProductoService service = new ProductoServiceImpl();
        Optional<Producto> producto = service.porId(id);
        if (producto.isPresent()) {
            ItemCarro item = new ItemCarro(1, producto.get());
            HttpSession session = req.getSession();
            Carro carro;
            carro = (Carro) session.getAttribute("carro");
            carro.removeItemCarro(item);
        }
        resp.sendRedirect(req.getContextPath() + "/ver-carro");
    }
}
