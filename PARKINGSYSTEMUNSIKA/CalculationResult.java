/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PARKINGSYSTEMUNSIKA;

/**
 *
 * @author salsa
 */
public class CalculationResult {
    private final long durationHours;
    private final int totalCost;

    public CalculationResult(long durationHours, int totalCost) {
        this.durationHours = durationHours;
        this.totalCost = totalCost;
    }

    public long getDurationHours() {
        return durationHours;
    }

    public int getTotalCost() {
        return totalCost;
    }
}
