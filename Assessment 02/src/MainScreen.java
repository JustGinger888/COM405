import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class MainScreen extends JFrame implements ActionListener
{
    String stormName;
    String stormWindSpeed;
    String stormTemp;
    String typeOfStorm;
    int dplValue=0;
    int updValue=0;

    private Operations operations = new Operations();
    private GridBagConstraints constraints;

    private JFrame frame;

    private JLabel lblTitle;
    private JLabel lblStormName;
    private JLabel lblStormWind;
    private JLabel lblStormTemp;
    private JLabel lblStormType;

    private JTextField txtStormName;
    private JTextField txtStormWind;
    private JTextField txtStormTemp;

    private JButton btnAdd;
    private JButton btnRemove;
    private JButton btnSearch;
    private JButton btnUpdate;
    private JButton btnSave;
    private JButton btnEscape;

    private JComboBox cbxStormType;

    private JTextArea jtaDisplay;

    private JPanel pnlStormChoice;
    private JPanel pnlStormInfo;
    private JPanel pnlButtons;
    private JPanel pnlDisplay;

    public MainScreen()
    {
        this.setTitle("Storm Advice Centre");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BoxLayout boxLayout = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
        this.setLayout(boxLayout);
        this.pack();
        this.setVisible(true);

        // Set up our components
        initComponents();

        // Create Panels
        createStormChoicePanel();
        createStormPanel();
        createButtonPanel();
        createDisplayPanel();

        this.pack();
        this.setLocationRelativeTo(null);
    }

    public void initComponents() {
        //Labels
        lblTitle = new JLabel("Storm Advice Program");
        lblStormName = new JLabel("Storm Name:");
        lblStormWind = new JLabel("Wind Speed:");
        lblStormTemp = new JLabel("Temperature:");
        lblStormType = new JLabel("Choose a TYPE to add NEW Storm");

        //Text Fields
        txtStormName = new JTextField(20);
        txtStormWind = new JTextField(20);
        txtStormTemp = new JTextField(20);

        //Buttons
        btnAdd = new JButton("Add Storm");
        btnAdd.setPreferredSize(new Dimension(148, 28));
        btnAdd.addActionListener(this);
        btnRemove = new JButton("Remove Storm");
        btnRemove.setPreferredSize(new Dimension(148, 28));
        btnRemove.addActionListener(this);
        btnSearch = new JButton("Search Storm");
        btnSearch.setPreferredSize(new Dimension(148, 28));
        btnSearch.addActionListener(this);
        btnUpdate = new JButton("Update Storm");
        btnUpdate.setPreferredSize(new Dimension(148, 28));
        btnUpdate.addActionListener(this);
        btnSave = new JButton("Save Update");
        btnSave.setPreferredSize(new Dimension(148, 28));
        btnSave.addActionListener(this);
        btnSave.setEnabled(false);
        btnSave.setBackground(Color.LIGHT_GRAY);
        btnEscape = new JButton("Cancel Update");
        btnEscape.setPreferredSize(new Dimension(148, 28));
        btnEscape.addActionListener(this);
        btnEscape.setEnabled(false);
        btnEscape.setBackground(Color.LIGHT_GRAY);


        //Combo Box
        cbxStormType = new JComboBox();
        cbxStormType.addItem("--Select--");
        cbxStormType.addItem("Hurricane");
        cbxStormType.addItem("Tornado");
        cbxStormType.addItem("Blizzard");
        cbxStormType.setBackground(Color.WHITE);

        //Text Area
        jtaDisplay = new JTextArea(5,30);
        jtaDisplay.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        jtaDisplay.setEditable(false);

        //Panels
        pnlStormChoice = new JPanel(new GridBagLayout());
        pnlStormInfo = new JPanel(new GridBagLayout());
        pnlButtons = new JPanel(new GridBagLayout());
        pnlDisplay = new JPanel(new GridBagLayout());
    }

    private void UpdateComponents(){
        btnRemove.setEnabled(false);
        btnRemove.setBackground(Color.LIGHT_GRAY);
        btnSearch.setEnabled(false);
        btnSearch.setBackground(Color.LIGHT_GRAY);
        btnUpdate.setEnabled(false);
        btnUpdate.setBackground(Color.LIGHT_GRAY);
        btnAdd.setEnabled(false);
        btnAdd.setBackground(Color.LIGHT_GRAY);
        btnSave.setEnabled(true);
        btnSave.setBackground(null);
        btnEscape.setEnabled(true);
        btnEscape.setBackground(null);
        cbxStormType.setEnabled(false);
        cbxStormType.setBackground(Color.lightGray);
    }

    private void createStormChoicePanel(){
        GridBagConstraints constraints = new GridBagConstraints();
        pnlStormChoice.setLayout(new GridBagLayout());
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridy = 0;
        constraints.gridx = 0;
        pnlStormChoice.add(lblStormType, constraints);

        //Storm Add Button
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridy = 0;
        constraints.gridx = 1;
        pnlStormChoice.add(cbxStormType, constraints);

        // Border
        pnlStormChoice.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Storm Types"));

        this.add(pnlStormChoice);
    }

    private void createStormPanel() {
        GridBagConstraints constraints = new GridBagConstraints();
        pnlStormInfo.setLayout(new GridBagLayout());
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.gridwidth = 1;

        //Storm Name Label
        constraints.fill = GridBagConstraints.NONE;
        constraints.gridy = 0;
        constraints.gridx = 0;
        pnlStormInfo.add(lblStormName, constraints);
        //Storm Name Text
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        pnlStormInfo.add(txtStormName, constraints);

        //Storm Wind Speed Label
        constraints.fill = GridBagConstraints.NONE;
        constraints.gridy = 1;
        constraints.gridx = 0;
        pnlStormInfo.add(lblStormWind, constraints);
        //Storm Wind Speed Text
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        pnlStormInfo.add(txtStormWind, constraints);

        //Storm Temperature Label
        constraints.fill = GridBagConstraints.NONE;
        constraints.gridy = 2;
        constraints.gridx = 0;
        pnlStormInfo.add(lblStormTemp, constraints);
        //Storm Temperature Text
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        pnlStormInfo.add(txtStormTemp, constraints);

        // Border
        pnlStormInfo.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Storm Details"));

        this.add(pnlStormInfo);

    }

    private void createButtonPanel() {
        GridBagConstraints constraints = new GridBagConstraints();
        pnlButtons.setLayout(new GridBagLayout());
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.gridwidth = 1;
        //Storm Add Button
        constraints.fill = GridBagConstraints.NONE;
        constraints.gridy = 0;
        constraints.gridx = 0;
        pnlButtons.add(btnAdd, constraints);
        //Storm Remove Button
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        pnlButtons.add(btnRemove, constraints);

        //Storm Edit Button
        constraints.fill = GridBagConstraints.NONE;
        constraints.gridy = 1;
        constraints.gridx = 0;
        pnlButtons.add(btnSearch, constraints);
        //Storm Save Button
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        pnlButtons.add(btnUpdate, constraints);

        //Storm Edit Button
        constraints.fill = GridBagConstraints.NONE;
        constraints.gridy = 2;
        constraints.gridx = 0;
        pnlButtons.add(btnSave, constraints);
        //Storm Save Button
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        pnlButtons.add(btnEscape, constraints);

        // Border
        pnlButtons.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Possible Actions"));

        this.add(pnlButtons);

    }

    private void createDisplayPanel() {
        GridBagConstraints constraints = new GridBagConstraints();
        pnlDisplay.setLayout(new GridBagLayout());
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        //Storm Add Button
        constraints.fill = GridBagConstraints.NONE;
        constraints.gridy = 0;
        constraints.gridx = 0;
        pnlDisplay.add(jtaDisplay, constraints);

        // Border
        pnlDisplay.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Storm Information"));

        this.add(pnlDisplay);

    }

    public void ActionVariables() {
        stormName = txtStormName.getText();
        stormWindSpeed = txtStormWind.getText();
        stormTemp = txtStormTemp.getText();
        typeOfStorm = cbxStormType.getSelectedItem().toString();
    }

    public void actionPerformed(ActionEvent ev) {
        ActionVariables();
        if (ev.getSource().equals(btnAdd)) {
            jtaDisplay.setText(null);
            int confirmed = JOptionPane.showConfirmDialog(null, operations.AddOperationControl(stormName, stormWindSpeed, stormTemp, typeOfStorm), "Add Storm Message Box", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
            Storm dplStorm = operations.getCurrentStorms().get(dplValue);
            dplValue++;
            jtaDisplay.append(dplStorm.CategoryAdvice(stormWindSpeed,stormTemp)+"\nName: "+stormName+"\nWind: "+stormWindSpeed+"\nTemp: "+stormTemp);
        }

        else if(ev.getSource().equals(btnRemove)) {
            jtaDisplay.setText(null);
            int confirmed = JOptionPane.showConfirmDialog(null, operations.RemoveOperationControl(stormName), "Remove Storm Message Box", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
            dplValue--;
        }

        else if(ev.getSource().equals(btnSearch)){
            jtaDisplay.setText(null);
            int confirmed = JOptionPane.showConfirmDialog(null, operations.SearchOperationControl(stormName), "Search Storm Message Box", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
            Storm dplStorm = operations.getCurrentStorms().get(operations.indexStorm);
            jtaDisplay.append(dplStorm.CategoryAdvice(dplStorm.stormWindSpeed,dplStorm.stormTemp)+"\nName: "+dplStorm.stormName+"\nWind: "+dplStorm.stormWindSpeed+"\nTemp: "+dplStorm.stormTemp);
        }

        else if(ev.getSource().equals(btnUpdate)) {

            jtaDisplay.setText(null);
            int confirmed = JOptionPane.showConfirmDialog(null, operations.SearchOperationControl(stormName), "Update Storm Message Box", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
            Storm updValue = operations.getCurrentStorms().get(operations.indexStorm);
            jtaDisplay.append(updValue.CategoryAdvice(updValue.stormWindSpeed,updValue.stormTemp)+"\nName: "+updValue.stormName+"\nWind: "+updValue.stormWindSpeed+"\nTemp: "+updValue.stormTemp);
            txtStormName.setText(updValue.stormName);
            txtStormWind.setText(updValue.stormWindSpeed);
            txtStormTemp.setText(updValue.stormTemp);
            UpdateActionPerformed(ev, dplValue);
            UpdateComponents();
        }

    }

    public void UpdateActionPerformed(ActionEvent ev, int dplValue){
        if (ev.getSource().equals(btnSave)){

        }
        else if (ev.getSource().equals(btnUpdate)){

        }
    }

}