/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Product;
import java.util.ArrayList;
import java.util.List;
import repositories.ProductRepository;

/**
 *
 * @author user
 */
public class ProductService implements ProductRepository {
    
    private ArrayList<Product> products;
   
    public ProductService(){
        // initialisation du produit
        products = new ArrayList<Product>();
    }


    @Override
    public List<Product> allProduct() {
        return products; 
    }

    @Override
    public Product searchProductByRef(String ref) {
        boolean found = false;
        for(Product p : products){
            if(p.getReference().equalsIgnoreCase(ref)){
                found = true;
                return p;
            }
        }
        
        if(found == false){System.out.println("Produit non trouvé");}
        
        return null;
    }

    @Override
    public Product updateProduct(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void addProduct(Product p) {
        // unicité de la reference
        if(searchProductByRef(p.getReference()) != null){
            System.out.println("La reference doit être unique");
        }else{
            products.add(p);
        }
    }

    @Override
    public void deleteProduct(String ref) {
        Product pDelete = searchProductByRef(ref);
        if(pDelete != null) {
            int id = pDelete.getId(); // recuperer le product id
            
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getId() == id) {
                    products.remove(i);
                    break;
                }
            }
        }
    }
    
    @Override
    public List<Product> searchProductByPriceRange(double minPrice, double maxPrice){
        boolean found = false;
        ArrayList<Product> productsFilterByRange = new ArrayList<Product>();
        
        for(Product p : products){
            if(p.getPrix() >= minPrice && p.getPrix() <= maxPrice){
                found = true;
                productsFilterByRange.add(p);
            }
        }
        
        if(found == false){
            System.out.println("Produit non trouvé pour prix [" + minPrice + ";" + maxPrice +"]");
            return null;
        }else{
            return productsFilterByRange;
        }
        
    }
    
    
    @Override
    public Product searchProductByName(String name){
        boolean found = false;
        for(Product p : products){
            if(p.getNom().equalsIgnoreCase(name)){
                found = true;
                return p;
            }
        }
        
        if(found == false){System.out.println("Produit non trouvé");}
        
        return null;
    }
    
    

    
}
