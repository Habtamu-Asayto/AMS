/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.database;
 
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped; 
import org.primefaces.component.tabview.TabView;
import org.primefaces.event.TabChangeEvent;

@SessionScoped
@ManagedBean
public class PrototypeView {

    private TabView messagesTab = new TabView();

    public TabView getMessagesTab () {
        return messagesTab;
    }

    public void setMessagesTab(TabView messagesTab ) {
        this.messagesTab = messagesTab;
    }

    public void onTabChange(TabChangeEvent event) {   
        TabView tabView = (TabView) event.getComponent();

        int activeIndex = tabView.getChildren().indexOf(event.getTab());

        this.messagesTab.setActiveIndex(activeIndex);

    }

    
 
}