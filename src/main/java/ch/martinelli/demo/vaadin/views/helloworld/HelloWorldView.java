package ch.martinelli.demo.vaadin.views.helloworld;

import ch.martinelli.demo.vaadin.views.MainLayout;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Hello World")
@Route(value = "hello", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class HelloWorldView extends VerticalLayout {

    private final Hello hello;

    public HelloWorldView() {
        var binder = new Binder<Hello>();

        var date = new DatePicker("Date");
        binder.forField(date).bind(Hello::getDate, Hello::setDate);

        var dateTime = new DateTimePicker("DateTime");
        binder.forField(dateTime).bind(Hello::getDateTime, Hello::setDateTime);

        hello = new Hello();
        binder.setBean(hello);

        binder.addStatusChangeListener(e -> {
            System.out.println("hasValidationErrors: " + e.hasValidationErrors());
            System.out.println("Bean: " + e.getBinder().getBean());
        });

        var save = new Button("Save");
        save.addClickListener(e -> {
            System.out.println("Bean: " + binder.getBean());
        });

        add(new FormLayout(date, dateTime, save));
    }

}
