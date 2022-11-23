package com.example.demo.ui;

import com.example.demo.backend.Book;
import com.example.demo.backend.BookService;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.vaadin.crudui.crud.impl.GridCrud;

import javax.annotation.security.RolesAllowed;

@Route("admin")
@RolesAllowed("ADMIN")
public class AdminView extends VerticalLayout {
    public AdminView(BookService service) {
        var crud = new GridCrud<>(Book.class, service);
        crud.getGrid().setColumns("title", "publishedDate", "rating");
        crud.getCrudFormFactory().setVisibleProperties("title", "publishedDate", "rating");

        add(
                new H1("Admin View"),
                crud
         );
    }
}
