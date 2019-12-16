import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class MainScreen extends JFrame implements ActionListener
{
    private Storm storm;
    private ArrayList<Storm> currentStorms = new ArrayList<Storm>();
    private GridBagConstraints constraints;

    private JFrame frame;

    private JLabel lblTitle;
    private JLabel lblStormName;
    private JLabel lblStormWind;
    private JLabel lblStormTemp;

    private JTextField txtStormName;
    private JTextField txtStormWind;
    private JTextField txtStormTemp;

    private JButton btnAdd;
    private JButton btnRemove;
    private JButton btnSearch;
    private JButton btnSave;

    private JTextArea jtaDisplay;

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
        createStormPanel();
        createButtonPanel();
        createDisplayPanel();
    }

    public void initComponents() {
        //Labels
        lblTitle = new JLabel("Storm Advice Program");
        lblStormName = new JLabel("Storm Name:");
        lblStormWind = new JLabel("Wind Speed:");
        lblStormTemp = new JLabel("Temperature:");

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
        btnSave = new JButton("Save Storm");
        btnSave.setPreferredSize(new Dimension(148, 28));
        btnSave.addActionListener(this);

        //TextArea
        jtaDisplay = new JTextArea(5,30);
        jtaDisplay.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        jtaDisplay.setEditable(false);

        //Panels
        pnlStormInfo = new JPanel(new GridBagLayout());
        pnlButtons = new JPanel(new GridBagLayout());
        pnlDisplay = new JPanel(new GridBagLayout());
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
        pnlButtons.add(btnSave, constraints);

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

    public void actionPerformed(ActionEvent ev)
    {
        if (ev.getSource().equals(btnAdd))
        {

        }
        else if(ev.getSource().equals(btnRemove))
        {

        }
    }

}