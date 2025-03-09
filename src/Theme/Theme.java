/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Theme;

import java.awt.Color;
import Interface.ThemeInterface;

/**
 *
 * @author Sentinail
 */
public class Theme implements ThemeInterface {
    
    @Override
    public Color getBackground() {
        return Color.decode("#FFFFFF");  // White
    }

    @Override
    public Color getForeground() {
        return Color.decode("#000000");  // Black
    }

    @Override
    public Color getPrimaryBackground() {
        return Color.decode("#A48873"); // Brownish shade
    }

    @Override
    public Color getPrimaryForeground() {
        return Color.decode("#FFFFFF"); // White
    }

    @Override
    public Color getSecondaryBackground() {
        return Color.decode("#FEF4EA"); // Beige
    }

    @Override
    public Color getSecondaryForeground() {
        return Color.decode("#2D303F"); // Dark Blue
    }
}