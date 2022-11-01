import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.*;

public class Interface implements ActionListener {

  Keyboard scanner = new Keyboard();
  int venomCount = 0;
  int spidermanCount = 0;
  int milesCount = 0;
  JFrame outLine = new JFrame();
  JPanel Gui = new JPanel();
  JLabel comiccode = new JLabel("Enter Comic Code Below");
  JLabel IconV = new JLabel("Venom count is " + venomCount);
  JLabel IconS = new JLabel("Spider-man count is " + spidermanCount);
  JLabel IconSM = new JLabel("Spider-man: Miles count is " + milesCount);
  JLabel totalCost = new JLabel("Cost is");
  JButton purchaseComic = new JButton("Checkout");
  JLabel ticket = new JLabel("");
  JButton cancel = new JButton("Cancel Purchasing session");
  JTextField comicname = new JTextField("");
  JButton addComic = new JButton("Add Comic");
  JButton removeComic = new JButton("Remove Comic");
  JLabel currentComic = new JLabel("");

  public Interface() {
    Gui.setPreferredSize(new Dimension(800, 1000));
    Gui.repaint();
    Gui.revalidate();

    purchaseComic.addActionListener(this);
    cancel.addActionListener(this);
    addComic.addActionListener(this);
    removeComic.addActionListener(this);

    scanner.RetriveComic("Venom #11");
    scanner.RetriveComic("Spider-man #12");
    scanner.RetriveComic("GGC 9.8 Spider-man: Miles Morales #1");

    Gui.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
    Gui.setLayout(new GridLayout(0, 1));
    Gui.add(comiccode);
    Gui.add(comicname);
    Gui.add(addComic);
    Gui.add(removeComic);
    Gui.add(currentComic);
    Gui.add(IconV);
    Gui.add(IconS);
    Gui.add(IconSM);
    Gui.add(totalCost);
    Gui.add(purchaseComic);
    Gui.add(ticket);
    Gui.add(cancel);

    outLine.add(Gui, BorderLayout.CENTER);
    outLine.setSize(1500, 1500);
    outLine.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    outLine.setTitle("Shopping cart");
    outLine.pack();
    outLine.setVisible(true);
  }

  public static void main(String[] args) {
    new Interface();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == addComic) {
      if (Objects.equals(comicname.getText(), "11")) {
        currentComic.setText(
          "Venom #11 and the price is $" + scanner.RetriveComic("Venom #11")
        );

        venomCount++;

        IconV.setText("Venom count is " + venomCount);
      } else if (Objects.equals(comicname.getText(), "12")) {
        currentComic.setText(
          "Spider-man #12 and the price is $" +
          scanner.RetriveComic("Spider-man #12")
        );

        spidermanCount++;

        IconS.setText("Spiderman count is " + spidermanCount);
      } else if (Objects.equals(comicname.getText(), "1")) {
        currentComic.setText(
          "GGC 9.8 Spider-man: Miles Morales #1 and the price is $" +
          scanner.RetriveComic("GGC 9.8 Spider-man: Miles Morales #1")
        );

        milesCount++;

        IconSM.setText("Miles count is " + milesCount);
      } else {
        currentComic.setText(
          "Invalid Comic! Comic codes are Venom : 11          Spider-man : 12          Spider-man:Miles : 1"
        );
      }
    } else if (e.getSource() == removeComic) {
      if (e.getSource() == removeComic) {
        if (Objects.equals(comicname.getText(), "11")) {
          currentComic.setText(
            "Venom and the price is $" + scanner.RetriveComic("Venom #11")
          );
          if (venomCount > 0) {
            venomCount--;
          } else {
            venomCount = 0;
          }
          IconV.setText("Venom count is " + venomCount);
        } else if (Objects.equals(comicname.getText(), "12")) {
          currentComic.setText(
            "Spiderman and the price is $" +
            scanner.RetriveComic("Spider-man #12")
          );

          if (spidermanCount > 0) {
            spidermanCount--;
          } else {
            spidermanCount = 0;
          }

          IconS.setText("Spiderman count is " + spidermanCount);
        } else if (Objects.equals(comicname.getText(), "1")) {
          currentComic.setText(
            "GGC 9.8 Spider-man: Miles Morales #1 and the price is $" +
            scanner.RetriveComic("GGC 9.8 Spider-man: Miles Morales #1")
          );

          if (milesCount > 0) {
            milesCount--;
          } else {
            milesCount = 0;
          }

          IconSM.setText("Miles count is " + milesCount);
        } else {
          currentComic.setText(
            "Invalid Comic! Comic codes are Venom : 11          Spider-man : 12          Spider-man:Miles : 1"
          );
        }
      }
    }

    String FinalCost = String.format(
      "%.2f",
      (
        (venomCount * Float.parseFloat(scanner.RetriveComic("Venom #11"))) +
        (
          spidermanCount *
          Float.parseFloat(scanner.RetriveComic("Spider-man #12"))
        ) +
        (
          milesCount *
          Float.parseFloat(
            scanner.RetriveComic("GGC 9.8 Spider-man: Miles Morales #1")
          )
        )
      )
    );

    if (e.getSource() == purchaseComic) {
      ticket.setText(
        "\n Total cost is as shown:\n " +
        "   |Venom : amount:   " +
        venomCount +
        "      price: $" +
        (venomCount * Float.parseFloat(scanner.RetriveComic("Venom #11"))) +
        "   | Spiderman : amount:   " +
        spidermanCount +
        "      price: $" +
        (
          spidermanCount *
          Float.parseFloat(scanner.RetriveComic("Spider-man #12"))
        ) +
        "   | Miles: amount:   " +
        milesCount +
        "        price: $" +
        (
          milesCount *
          Float.parseFloat(
            scanner.RetriveComic("GGC 9.8 Spider-man: Miles Morales #1")
          )
        ) +
        "   | The final cost is :  $" +
        FinalCost
      );
    }

    if (e.getSource() == cancel) {
      venomCount = 0;
      IconV.setText("Venom count is " + venomCount);
      spidermanCount = 0;
      IconS.setText("Spiderman count is " + spidermanCount);
      milesCount = 0;
      IconSM.setText("Miles count is " + milesCount);
      totalCost.setText("The Final Price is : 0");
    }

    totalCost.setText("The Final Price is :" + FinalCost);
  }
}
