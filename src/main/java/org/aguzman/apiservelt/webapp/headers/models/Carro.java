package org.aguzman.apiservelt.webapp.headers.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Carro {
    private List<ItemCarro> items;

    public Carro() {
        this.items=new ArrayList<>();
    }

    public void addItemCarro(ItemCarro itemCarro){
        if (items.contains(itemCarro)){
            Optional<ItemCarro> optionalItemCarro=items.stream()
                    .filter(i->i.equals(itemCarro))
                    .findAny();
            if (optionalItemCarro.isPresent()){
                ItemCarro i= optionalItemCarro.get();
                i.setCantidad(i.getCantidad()+1);
            }
        }else {
            this.items.add(itemCarro);
        }
    }

    public void removeItemCarro(ItemCarro itemCarro){
        if (items.contains(itemCarro)){
            Optional<ItemCarro> optionalItemCarro=items.stream()
                    .filter(i->i.equals(itemCarro))
                    .findAny();
            if (optionalItemCarro.isPresent()){
                ItemCarro i= optionalItemCarro.get();
                if (i.getCantidad()-1>0){
                    i.setCantidad(i.getCantidad()-1);
                }
                else {
                    items.remove(i);
                }



            }
        }
    }

    public List<ItemCarro> getItems() {
        return items;
    }

    public int getTotal(){
        return items.stream().mapToInt(ItemCarro::getImporte).sum();
    }
}
