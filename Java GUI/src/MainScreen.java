import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MainScreen extends JFrame implements ActionListener
{
    //private CarPark carPark;
    private GridBagConstraints constraints;

    private JLabel lblTitle;
    private JLabel lblRegNum, lblCarColor, lblCarMake, lblCarModel;
    private JLabel lblStatus;

    private JTextField txtRegNum, txtCarColor, txtCarMake, txtCarModel;

    private JButton btnAdd;
    private JButton btnRemove;

    private CarPark carPark = new CarPark();

    public MainScreen()
    {
        //room = new Classroom("RM605");
        this.setLayout(new GridBagLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        constraints = new GridBagConstraints();

        // Set up our components
        initComponents();

        // Create layout
        layoutComponents();

    }

    public void initComponents()
    {
        lblTitle = new JLabel("Cars in a Car Park");

        lblRegNum = new JLabel("Reg: number:");
        lblCarColor = new JLabel("Car Colour:");
        lblCarMake = new JLabel("Car Make:");
        lblCarModel = new JLabel("Car Model:");

        txtRegNum = new JTextField();
        txtCarColor = new JTextField();
        txtCarMake = new JTextField();
        txtCarModel = new JTextField();

        lblStatus = new JLabel(carPark.EmptySpaces()+" empty spaces.");

        btnAdd = new JButton("Add Car");
        btnAdd.addActionListener(this);
        btnRemove = new JButton("Remove Car");
        btnRemove.addActionListener(this);
    }

    public void layoutComponents() {
        constraints.gridy = 0;
        constraints.gridx = 0;
        constraints.gridwidth = 2;

        this.add(lblTitle, constraints);

        constraints.gridy = 1;
        constraints.gridx = 0;
        constraints.gridwidth = 1;
        this.add(lblRegNum, constraints);

        constraints.gridx = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(txtRegNum, constraints);

        constraints.fill = GridBagConstraints.NONE;
        constraints.gridy = 2;
        constraints.gridx = 0;
        this.add(lblCarColor, constraints);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        this.add(txtCarColor, constraints);

        constraints.fill = GridBagConstraints.NONE;
        constraints.gridy = 3;
        constraints.gridx = 0;
        this.add(lblCarMake, constraints);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        this.add(txtCarMake, constraints);

        constraints.fill = GridBagConstraints.NONE;
        constraints.gridy = 4;
        constraints.gridx = 0;
        this.add(lblCarModel, constraints);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        this.add(txtCarModel, constraints);

        constraints.fill = GridBagConstraints.NONE;
        constraints.gridy = 5;
        constraints.gridx = 0;
        constraints.gridwidth = 2;
        this.add(lblStatus, constraints);

        constraints.fill = GridBagConstraints.NONE;
        constraints.gridy = 6;
        constraints.gridx = 0;
        constraints.gridwidth = 1;
        this.add(btnAdd, constraints);

        constraints.gridx = 1;
        this.add(btnRemove, constraints);
    }

    public void actionPerformed(ActionEvent ev)
    {
        if (ev.getSource().equals(btnAdd))
        {
            String regNum = txtRegNum.getText();
            String color = txtCarColor.getText();
            String make = txtCarMake.getText();
            String model = txtCarModel.getText();


            if(carPark.AddCar(regNum, color, make, model))
            {
                lblStatus.setText(carPark.EmptySpaces()+" empty spaces.");
                JOptionPane.showMessageDialog(null, "Car has been added");

            }
            else
            {
                JOptionPane.showMessageDialog(null, "The room is full");
            }
        }
        else if(ev.getSource().equals(btnRemove))
        {
            String regNum = txtRegNum.getText();
            if (!regNum.equals("")) {
                if (carPark.RemoveCar(regNum)) {
                    lblStatus.setText(carPark.EmptySpaces()+" empty spaces.");
                    JOptionPane.showMessageDialog(null, "Car has been removed");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Could not find Reg. Number");
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Enter a Reg. Number");
            }
        }
    }

}