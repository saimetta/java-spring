package main.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class ProductCatalog extends CatalogComponent{
	
    private ArrayList<CatalogComponent> items=new ArrayList<>();
    private String name;
    public ProductCatalog(String name){
        this.name=name;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public String print(){
       List<String> result = new ArrayList<>();
    	for(CatalogComponent comp : items)
        {
            result.add(comp.print());
        }
    	return String.join(" - " , result);
    }
    @Override
    public void add(CatalogComponent catalogComponent){
        items.add(catalogComponent);
    }
    @Override
    public void remove(CatalogComponent catalogComponent){
        items.remove(catalogComponent);
    }
}