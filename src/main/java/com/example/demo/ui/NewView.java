package com.example.demo.ui;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import javax.annotation.security.RolesAllowed;

@Route("new")
@RolesAllowed("ADMIN")
public class NewView extends VerticalLayout {

    public NewView() {
        add(
                new H1("New Book")
        );
    }

}
