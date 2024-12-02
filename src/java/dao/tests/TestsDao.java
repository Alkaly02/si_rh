/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.tests;

import dao.EmployeDao;
import metier.entities.Employe;

/**
 *
 * @author HP
 */
public class TestsDao {
    public static void main(String[] args){
        Employe employe = new Employe("Mamadou", "BA", "Developpeur", 750000.0, "ADMIN RH", 1);
        EmployeDao employeDao = new EmployeDao();

//      Sauvegarde test        
//        employeDao.save(employe);

//      get one emplye test
        Employe searchEmploye = employeDao.getOne(1);
        
//      update employe teste
        Employe employe2 = new Employe("Lamine", "COLY", "PM", 750000.0, "ADMIN RH", 2);
        employe2.setId(1);
        employeDao.edit(employe2);
        
        System.out.println(searchEmploye.getPrenom());
    }
}
