/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.interfaces;

import metier.entities.Employe;

/**
 *
 * @author HP
 */
public interface IEmployeDao {
    public Employe save(Employe employe);
    public Employe modifier(Employe employe);
}
