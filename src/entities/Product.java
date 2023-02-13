/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author user
 */
public class Product {
    private int id;
    private String code;
    private String reference;
    private String nom;
    private double prix;
    private double quantite;

    public Product() {
    }

    public Product(int id, String nom, String reference, double prix, double quantite) {
        this.id = id;
        this.code = "P" + String.format("%03d", this.id);
        this.reference = reference;
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    /*public void setCode(String code) {
        this.code = code;
    }*/

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", code=" + code + ", reference=" + reference + ", nom=" + nom + ", prix=" + prix + ", quantite=" + quantite + '}';
    }
    
    
    
}
