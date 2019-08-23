package com.rpg.pa;



import com.rpg.pa.views.BancoCrudView;
import com.rpg.pa.views.BancoForm;
import com.rpg.pa.views.DefaultView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


@Theme(value = Lumo.class)
@PWA(name = "RPG", shortName = "RPG")
public class MainLayout extends AppLayout {

    private static final Logger LOGGER = Logger.getLogger(MainLayout.class.getName());
    private Map<Tab, Component> tab2Workspace = new HashMap<>();

    public MainLayout() {
        Image img = new Image("https://i.imgur.com/GPpnszs.png", "Vaadin Logo");
        img.setHeight("44px");
        addToNavbar(new DrawerToggle(), img);
        Tabs tabs = new Tabs(
                new Tab(new RouterLink("Home", DefaultView.class)),
                new Tab( new RouterLink("Bancos", BancoCrudView.class )));
        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        addToDrawer(tabs);
    }

    private Tab banco(Class<BancoCrudView> bancoCrudViewClass){
        final Span label = new Span("Bancos");
        final Icon icon  = new Icon(VaadinIcon.PLAY_CIRCLE);
        final Tab  tab   = new Tab( new RouterLink("Bancos", bancoCrudViewClass ));
        tab.setLabel("Bancos");
        tab2Workspace.put(tab, new BancoCrudView());
        return tab;
    }
}
