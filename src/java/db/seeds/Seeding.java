/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db.seeds;

import dao.CategorieEmployeDao;
import dao.CategorieEmployeDeductionDao;
import dao.DeductionDao;
import dao.interfaces.ICategorieEmployeDao;
import dao.interfaces.ICategorieEmployeDeductionDao;
import dao.interfaces.IDeductionDao;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import metier.entities.CategorieEmploye;
import metier.entities.Deduction;

/**
 *
 * @author HP
 */
public class Seeding {
        
    /*
    Assurance maladie: 5%
    Assurance retraite: 10%
    Assurance chômage: 4%
    Accidents du travail: 2%
    Impôts sur le revenu: 10%
    */
    public static void main(String[] args){
        
        List<Deduction> deductions = new ArrayList<>();
        deductions.add(new Deduction("Assurance maladie", 5.0));
        deductions.add(new Deduction("Assurance retraite", 10.0));
        deductions.add(new Deduction("Assurance chômage", 4.0));
        deductions.add(new Deduction("Accidents du travail", 2.0));
        deductions.add(new Deduction("Impôts sur le revenu", 10.0));
        
        List<CategorieEmploye> categories = new ArrayList<>();
        categories.add(new CategorieEmploye("Temps plein"));
        categories.add(new CategorieEmploye("Contractuel"));
        categories.add(new CategorieEmploye("Freelance"));
        categories.add(new CategorieEmploye("Employé à temps partiel"));
        
//        enregistrement des deductions
        for(Deduction deduction : deductions){
            IDeductionDao deductionDao = new DeductionDao();
            Deduction d = deductionDao.save(deduction);
            deduction.setId(d.getId());
        }
        
//      enregistrement des categories
        for(CategorieEmploye categorie : categories){
            ICategorieEmployeDao categorieDao = new CategorieEmployeDao();
            CategorieEmploye c = categorieDao.save(categorie);
            categorie.setId(c.getId());
        }
        
        // Relation Many-to-Many : IDs des catégories -> 2-3 IDs des déductions
        ICategorieEmployeDeductionDao categorieEmployeDeductionDao = new CategorieEmployeDeductionDao();

        Random random = new Random();
        for (CategorieEmploye categorie : categories) {
            Set<Integer> selectedDeductions = new HashSet<>();
            
            // Sélectionner 2 à 3 déductions aléatoires
            int numberOfDeductions = 2 + random.nextInt(2); // Valeur entre 2 et 3
            while (selectedDeductions.size() < numberOfDeductions) {
                int randomIndex = random.nextInt(deductions.size());
                selectedDeductions.add(deductions.get(randomIndex).getId());
            }

            // Associer les déductions sélectionnées à la catégorie
            for (int deductionId : selectedDeductions) {
                categorieEmployeDeductionDao.save(categorie.getId(), deductionId);
            }
        }
        
        System.out.println("================Seedind Database Done==================");
    }
}
