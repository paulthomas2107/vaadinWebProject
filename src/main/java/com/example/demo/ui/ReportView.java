package com.example.demo.ui;

import ar.com.fdvs.dj.domain.builders.ColumnBuilder;
import ar.com.fdvs.dj.domain.entities.columns.AbstractColumn;
import com.example.demo.backend.Book;
import com.example.demo.backend.BookRepository;
import com.example.demo.backend.BookService;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.vaadin.reports.PrintPreviewReport;

import javax.annotation.security.RolesAllowed;

@Route("report")
@RolesAllowed("ADMIN")
public class ReportView extends VerticalLayout {

    public ReportView(BookService service) {

        AbstractColumn title;

        PrintPreviewReport<Book> report = new PrintPreviewReport<>();

        report.setItems(service.findAll());
        report.getReportBuilder()
                .setTitle("Book Report")
                .addColumn(title = ColumnBuilder.getNew()
                        .setColumnProperty("title", Book.class)
                        .setTitle("Title")
                        .build());

        add(report);
        setPadding(false);


    }

}
