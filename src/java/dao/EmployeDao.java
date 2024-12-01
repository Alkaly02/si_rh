/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.interfaces.IEmployeDao;
import metier.entities.Employe;

/**
 *
 * @author HP
 */
public class EmployeDao implements IEmployeDao{

    @Override
    public Employe save(Employe employe) {
//      Faire la logique de sauvegarde d'un employe ici
        return employe;
    }

    @Override
    public Employe modifier(Employe employe) {
//        Faire la modification d'un employe ici
        return employe;
    }
    
}
