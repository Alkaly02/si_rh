/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.interfaces.IDeductionDao;
import metier.entities.Deduction;

/**
 *
 * @author HP
 */
public class DeductionDao implements IDeductionDao{

    @Override
    public Deduction save(Deduction d) {
//        Sauvegarder une deduction ici
        return d;
    }
    
}
