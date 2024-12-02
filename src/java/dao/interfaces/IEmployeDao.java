/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.interfaces;

import java.util.List;
import metier.entities.Employe;

/**
 *
 * @author HP
 */
public interface IEmployeDao {
    public Employe save(Employe employe);
    public void edit(Employe employe);
    public List<Employe> getAll();
    public Employe getOne(int id);
}
