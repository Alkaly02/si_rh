/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.interfaces;

import java.util.List;
import metier.entities.Paiement;

/**
 *
 * @author HP
 */
public interface IPaiementDao {
    public List<Paiement> getAll();
    public Paiement getFichePaieByEmployeId(int employeId);
}
