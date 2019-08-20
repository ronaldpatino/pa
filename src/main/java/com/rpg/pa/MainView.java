package com.rpg.pa;


import com.rpg.pa.pojo.Banco;
import com.rpg.pa.service.BancoService;
import com.rpg.pa.views.BancoForm;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.crud.BinderCrudEditor;
import com.vaadin.flow.component.crud.Crud;
import com.vaadin.flow.component.crud.CrudEditor;
import com.vaadin.flow.component.crud.CrudVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.provider.CallbackDataProvider;
import com.vaadin.flow.data.provider.ConfigurableFilterDataProvider;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.dom.DebouncePhase;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

import java.util.Collection;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 * The main view contains a button and a click listener.
 */
@Route("")
@PWA(name = "Project Base for Vaadin", shortName = "Project Base")
public class MainView extends VerticalLayout {
    private static final Logger LOGGER = Logger.getLogger(BancoForm.class.getName());
    public MainView() {
        //BancoForm bancoForm = new BancoForm(this);
        //add(bancoForm);
        BancoService bancoService = new BancoService();
        /*
        GridCrud<Banco> crud = new GridCrud<>(Banco.class);



        crud.setCrudListener(new CrudListener<Banco>() {
            @Override
            public Collection<Banco> findAll() {
                return bancoService.findAll();
            }
            @Override
            public Banco add(Banco banco) {
                return bancoService.save(banco);
            }

            @Override
            public Banco update(Banco banco) {
                return null;
            }

            @Override
            public void delete(Banco banco) {

            }

        });
        addcrud);

         */

        Grid<Banco> grid = new Grid<>(Banco.class);

        Crud<Banco> crud = new Crud<>(Banco.class, grid, createBancoEditor());
        crud.setDataProvider(bancoService);
        crud.addSaveListener(e -> bancoService.save(e.getItem()));
        crud.addDeleteListener(e -> bancoService.delete(e.getItem()));
        crud.addThemeVariants(CrudVariant.NO_BORDER);

        //crud.getGrid().addItemDoubleClickListener(e -> crud.edit(e.getItem(), Crud.EditMode.EXISTING_ITEM));

        Function<String, Stream<Banco>> filter = query -> {
            Stream<Banco> result = bancoService.getStream();
            LOGGER.log(Level.INFO,"BUSCAMOS EN EL VOID");
            if (!query.isEmpty()) {
                final String f = query.toLowerCase();
                result = result.filter(p ->
                        (p.getNombre() != null) && (p.getNombre().toLowerCase().contains(f)));
            }

            return result;
        };

        DataProvider<Banco, String> dataProvider = new CallbackDataProvider<>(
                query -> filter.apply(query.getFilter().orElse("")),
                query -> (int) filter.apply(query.getFilter().orElse("")).count());

        ConfigurableFilterDataProvider<Banco, Void, String> filterableDataProvider
                = dataProvider.withConfigurableFilter();

        grid.setDataProvider(filterableDataProvider);
        TextField searchBar = new TextField();
        searchBar.setPlaceholder("Search...");
        searchBar.setWidth("100%");
        searchBar.setValueChangeMode(ValueChangeMode.EAGER);
        searchBar.setPrefixComponent(VaadinIcon.SEARCH.create());

        Icon closeIcon = new Icon("lumo", "cross");
        closeIcon.setVisible(false);
        ComponentUtil.addListener(closeIcon, ClickEvent.class,
                (ComponentEventListener) e -> searchBar.clear());
        searchBar.setSuffixComponent(closeIcon);

        searchBar.getElement().addEventListener("value-changed", event -> {
            closeIcon.setVisible(!searchBar.getValue().isEmpty());
            filterableDataProvider.setFilter(searchBar.getValue());
        }).debounce(300, DebouncePhase.TRAILING);

        crud.setToolbar(searchBar);
        //crud.getElement().getStyle().set("flex-direction", "column-reverse");

        Span footer = new Span();
        footer.getElement().getStyle().set("flex", "1");
        Button newItemButton = new Button("Agregar Persona");
        newItemButton.addClickListener(e -> crud.edit(new Banco(), Crud.EditMode.NEW_ITEM));

        crud.setToolbar(footer, newItemButton);

        add(crud);
    }

    private CrudEditor createBancoEditor() {
        TextField nombre = new TextField("Nombre");
        FormLayout form = new FormLayout(nombre);
        Binder<Banco> binder = new Binder<>(Banco.class);
        binder.bind(nombre, Banco::getNombre, Banco::setNombre);

        return new BinderCrudEditor<>(binder, form);

    }
}
