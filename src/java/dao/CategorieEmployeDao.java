/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.interfaces.ICategorieEmployeDao;
import metier.entities.CategorieEmploye;

/**
 *
 * @author HP
 */
public class CategorieEmployeDao implements ICategorieEmployeDao{

    @Override
    public CategorieEmploye save(CategorieEmploye c) {
//        Faire la sauvegarde d'une categorie ici
        return c;
    }
    
}
