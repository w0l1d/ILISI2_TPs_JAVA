package com.java.ilisi.tp3;

import javax.swing.*;

public interface AbstractController {

   JComponent getGUI();

   JComponent refreshGUI(AgenceDAO agenceDAO);

}
