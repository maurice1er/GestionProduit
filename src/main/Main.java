/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;
import entities.Product;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import services.ProductService;

/**
 *
 * @author user
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Services
        ProductService productList = new ProductService();
        
        boolean stop = false;
        
        do{
            
            showMainMenu();
            int choix = doChoice(); // System.out.println(choix);
            
            switch(choix){
                case 1:
                    Scanner scFilterByRef = new Scanner(System.in);
                    System.out.println("# RECHERCHE");
                    System.out.print("Entrez la reference du produit à rechercher: ");
                    String ref = scFilterByRef.next();
                    
                    Product pSearch = productList.searchProductByRef(ref);
                    if(pSearch != null) System.out.print(pSearch);
                    
                    //sc.close();
                    break;
                    
                case 2:
                    Scanner scAdd = new Scanner(System.in);
                    System.out.println("# AJOUT");
                    System.out.print("Entrez l'Id du produit ");
                    int idAdd = scAdd.nextInt();
                    System.out.print("Entrez le nom du produit ");
                    String nomAdd = scAdd.next();
                    System.out.print("Entrez la reference du produit ");
                    String refAdd = scAdd.next();
                    System.out.print("Entrez le prix du produit ");
                    double prixAdd = scAdd.nextDouble();
                    System.out.print("Entrez la quantite du produit ");
                    double qteAdd = scAdd.nextDouble();
                    
                    Product pAdd = new Product(idAdd, nomAdd, refAdd, prixAdd, qteAdd);
                    
                    productList.addProduct(pAdd);
                    
                    // sc.close()
                    break;
                    
                case 3:
                    System.out.println("# Supprimer un produit par référence");
                    
                    Scanner scDeleteByRef = new Scanner(System.in);
                    System.out.print("Entrez la reference du produit à supprimer: ");
                    String refDelete = scDeleteByRef.next();
                    
                    productList.deleteProduct(refDelete);
                    
                    break;
                    
                case 4:
                    System.out.println("# Modifier un produit par référence");
                    Scanner scUpdateByRef = new Scanner(System.in);
                    
                    System.out.print("Entrez la reference du produit à modifier: ");
                    String refUpdate = scUpdateByRef.next();
                    
                    Product pUpdateByRef = productList.searchProductByRef(refUpdate);
                    if(pUpdateByRef != null){
                        // afficher le sous menu
                        showSubUpdateMenu();
                        // choisir un element du menu
                        int subChoice = doChoice();
                        
                        switch(subChoice){
                            case 1:
                                // modification du nom                                
                                Scanner scSetName = new Scanner(System.in);

                                System.out.print("Entrez le nouveau nom: ");
                                String name = scSetName.next();
                                
                                pUpdateByRef.setNom(name);
                                break;
                            case 2:
                                // modification du prix
                                Scanner scSetPrice = new Scanner(System.in);

                                System.out.print("Entrez le nouveau prix: ");
                                double price = scSetPrice.nextDouble();
                                pUpdateByRef.setPrix(price);
                                break;
                            case 3:
                                // modification de la quantité
                                Scanner scSetQuantity = new Scanner(System.in);

                                System.out.print("Entrez la nouvelle quantite: ");
                                double quantity = scSetQuantity.nextDouble();
                                pUpdateByRef.setQuantite(quantity);
                                break;
                            case 4:
                                // modification nom, prix, quantité                                
                                Scanner scSetNPQ = new Scanner(System.in);

                                System.out.print("Entrez le nouveau nom: ");
                                String name_ = scSetNPQ.next();
                                System.out.print("Entrez le nouveau prix: ");
                                double price_ = scSetNPQ.nextDouble();
                                System.out.print("Entrez la nouvelle quantite: ");
                                double quantity_ = scSetNPQ.nextDouble();
                                
                                
                                pUpdateByRef.setNom(name_);
                                pUpdateByRef.setPrix(price_);
                                pUpdateByRef.setQuantite(quantity_);
                                break;
                            default:
                                System.out.println("Mauvais choix");
                        }
                        System.out.print(pUpdateByRef);
                    }
                    
                case 5:
                    System.out.println("# Rechercher un produit par son nom");
                    Scanner scFilterByName = new Scanner(System.in);
                    
                    System.out.print("Entrez le nom du produit à rechercher: ");
                    String nom = scFilterByName.next();
                    
                    Product pSearchByName = productList.searchProductByName(nom);
                    if(pSearchByName != null) System.out.print(pSearchByName);
                    
                    break;
                  
                case 6:
                    System.out.println("# Rechercher un produit par intervalle de prix");
                    
                    Scanner scSearchByPriceRange = new Scanner(System.in);
                    
                    System.out.print("Entrez le prix minimum: ");
                    double minPrice = scSearchByPriceRange.nextDouble();
                    System.out.print("Entrez le prix maximum: ");
                    double maxPrice = scSearchByPriceRange.nextDouble();
                    
                    //searchProductByPriceRange
                    List<Product> productFilterByPriceRange = productList.searchProductByPriceRange(minPrice, maxPrice);
                    
                    if(productFilterByPriceRange != null){
                        for(Product p : productFilterByPriceRange){
                            String message = "Produit{" + "id=" + p.getId() + ", code=" + p.getCode() + ", reference=" + p.getReference() + ", nom=" + p.getNom() + ", prix=" + p.getPrix() + ", quantite=" + p.getQuantite() + '}';
                            System.out.println(message);
                        }
                    }
                    break;
                    
                case 7:
                    System.out.println("");
                    int taille = productList.allProduct().toArray().length;
                    System.out.println(taille + " Produit(s)"); 
                    
                    if (taille > 0){
                        System.out.println("# Liste des produits ");
                        for(Product p : productList.allProduct()){
                            
                            String message = "Produit{" + "id=" + p.getId() + ", code=" + p.getCode() + ", reference=" + p.getReference() + ", nom=" + p.getNom() + ", prix=" + p.getPrix() + ", quantite=" + p.getQuantite() + '}';
                            System.out.println(message);
                        }
                        System.out.println("#----- ");
                    }
                    break;
                    
                case 8:
                    System.out.println("Bye bye !!");
                    stop = true;
                    break;
                    
                default:
                    System.out.println("Mauvais choix");
            }
            //break;
            
            
        }while(stop == false);
    }
    
    public static void showMainMenu(){
        // Show menu element
        
        System.out.println("");
        System.out.println("");
        
        System.out.println("------ MENU ------");
        System.out.println("1- Rechercher un produit par référence");
        System.out.println("2- Ajouter un produit au stock");
        System.out.println("3- Supprimer un produit par référence");
        System.out.println("4- Modifier un produit par référence");
        System.out.println("5- Rechercher un produit par nom");
        System.out.println("6- Rechercher un produit par intervalle de prix");
        System.out.println("7- Afficher tous les produits");
        System.out.println("8- Quitter");
        System.out.println("");
    }
    
    public static void showSubUpdateMenu(){
        // Show sub menu element for update
        
        System.out.println("");
        
        System.out.println("------ MODIFICATION ------");
        System.out.println("1- Modification du nom");
        System.out.println("2- Modification du prix");
        System.out.println("3- Modification de la quantité");
        System.out.println("4- Modification nom, prix, quantité");
        System.out.println("");
    }
    
    public static int doChoice(){
        Scanner sc = new Scanner(System.in);
        System.out.println("#-------------------#");
        System.out.print("Faites votre choix: ");
        try{
            return sc.nextInt();
        } catch (Exception e) {
            System.out.println("Entree invalid. Entrez un nombre");
        }
        return -1;
    }
    
}
