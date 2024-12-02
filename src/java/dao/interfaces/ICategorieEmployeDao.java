/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.interfaces;

import java.util.List;
import metier.entities.CategorieEmploye;

/**
 *
 * @author HP
 */
public interface ICategorieEmployeDao {
    public CategorieEmploye save(CategorieEmploye c);
    public List<CategorieEmploye> get();
}
