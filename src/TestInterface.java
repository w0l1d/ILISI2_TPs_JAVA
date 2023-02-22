import javax.swing.*;
import java.awt.*;

public class TestInterface extends JFrame {

   public TestInterface() throws HeadlessException {

      JPanel mainPan = new JPanel();
      GridBagLayout grid = new GridBagLayout();
      GridBagConstraints gbc = new GridBagConstraints();
      mainPan.setLayout(grid);
      setTitle("GridBagLayoutExample");
      GridBagLayout layout = new GridBagLayout();
      mainPan.setLayout(layout);

      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.gridwidth = 2;
      mainPan.add(new Button("ButtonOne"), gbc);

      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.gridx = 2;
      gbc.gridy = 0;
      mainPan.add(new Button("Buttontwo"), gbc);

      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.ipady = 20;
      gbc.gridx = 0;
      gbc.gridy = 1;
      mainPan.add(new Button("ButtonThree"), gbc);

      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.gridx = 1;
      gbc.gridy = 1;
      gbc.gridwidth = 2;
      mainPan.add(new Button("ButtonFour"), gbc);

      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.gridx = 0;
      gbc.gridy = 2;
      gbc.gridwidth = 3;
      mainPan.add(new Button("ButtonFive"), gbc);

      setSize(300, 300);
      setPreferredSize(getSize());
      setVisible(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);


      getContentPane().add(mainPan);

   }

   public static void main(String[] args) {
      TestInterface testInterface = new TestInterface();
      testInterface.setDefaultCloseOperation(EXIT_ON_CLOSE);
      testInterface.setVisible(true);
   }

}
