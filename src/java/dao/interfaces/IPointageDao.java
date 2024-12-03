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
public interface IPointageDao {
    public void marquerPresent(Employe employe);
    public void marquerAbsent(Employe employe);
}
