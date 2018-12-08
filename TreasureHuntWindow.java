
/**
 * Write a description of class TreasureHunt here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random; 

public class TreasureHuntWindow extends JFrame
{    
    private JPanel treasurePanel;
    private JPanel buttonPanel = new JPanel(new GridLayout(10, 10));
    private JLabel treasureLabel;
    private JButton treeButton[] = new JButton[100];
    
    private JButton treasureButton[] = new JButton[100];
    
    private JTextField treasuresLeftTextField;
    private JTextField treasuresFoundTextField;
    private JTextField triesLeftTextField;
    
    private JLabel treasuresLeftLabel;
    private JLabel treasuresFoundLabel;
    private JLabel triesLeftLabel;
    
    Treasure game = new Treasure();
     
    ImageIcon treeImage = new ImageIcon(new ImageIcon("tree.png").getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
    ImageIcon treasureImage = new ImageIcon(new ImageIcon("treasure.png").getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
    ImageIcon trunkImage = new ImageIcon(new ImageIcon("trunk.png").getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
    
    Random rand = new Random();
    
    
    
    /**
     * Constructor for objects of class TreasureHunt
     */
    public TreasureHuntWindow()
    {
        final int WINDOW_WIDTH = 500;
        final int WINDOW_HEIGHT = 500;
        
        // Set this window's title
        setTitle("Treasure Hunt Game");
        
        // Create a label
        treasureLabel = new JLabel("TREASURE HUNT", SwingConstants.CENTER);
        
        // Set the size of the window
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        
        // Specify what happens when the close buttons is clicked
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create a BorderLayout manager
        setLayout(new BorderLayout());
        
        // Build the panel and add it to the frame
        buildTreasurePanel();
        buildButtonPanel();
        
        // Add the panels the frame's content pane
        add(treasureLabel, BorderLayout.NORTH);
        add(treasurePanel, BorderLayout.SOUTH);
        add(buttonPanel, BorderLayout.CENTER);
        
        // Pack and display the window
        
        
        setVisible(true);
        
    }

    /**
     * The buildPanel method adds a label, a text field, and a button to a panel.
     */
    private void buildTreasurePanel()
    {
        // Create a panel
        treasurePanel = new JPanel();
        
        
        
        // Add the label to the panel
        treasurePanel.add(treasureLabel);
        
        // Displays the treasures left
        treasuresLeftLabel = new JLabel("Treasures Left: ");
        treasuresLeftTextField = new JTextField(5);
        treasuresLeftTextField.setText(Integer.toString(game.getTreasuresLeft()));
        treasuresLeftTextField.setEditable(false);
        
        
        // Displays the treasures found
        treasuresFoundLabel = new JLabel("Treasures Found: ");
        treasuresFoundTextField = new JTextField(5);
        treasuresFoundTextField.setText(Integer.toString(game.getTreasuresFound()));
        treasuresFoundTextField.setEditable(false);
        
        
        // Displays the tries left
        triesLeftLabel = new JLabel("Tries Left: ");
        triesLeftTextField = new JTextField(5);
        triesLeftTextField.setText(Integer.toString(game.getTriesLeft()));
        triesLeftTextField.setEditable(false);
        
        
        // Add the labels, text fields, and buttons to the content pane
        treasurePanel.add(treasureLabel);
        treasurePanel.add(treasuresLeftLabel);       
        treasurePanel.add(treasuresLeftTextField);
        treasurePanel.add(treasuresFoundLabel);
        treasurePanel.add(treasuresFoundTextField);
        treasurePanel.add(triesLeftLabel);
        treasurePanel.add(triesLeftTextField);
        
    }
    
    /**
     * The buildButtonPanel method adds buttons to panel.
     */
    private void buildButtonPanel()
    {
        
        int treasureLocation[];
        
        int treasures = 0;
        int randomCoordinate = rand.nextInt(100);

        for (int i = 0; i < 100; i++)
        {
            int treasureNumber = rand.nextInt(5);
            
            treeButton[i] = new JButton();
                        
            treeButton[i].setIcon(treeImage);
            
            do
            {
                if (treasureNumber == 1)
                {
                    treasures += 1;
                    
                    treasureButton[i] = treeButton[i];
                    
                    treasureButton[i].addActionListener(new TreasureButtonListener());
                }
                
                
            }
            while (treasures < 19);
                
            // Register an action listener with the button
            treeButton[i].addActionListener(new ButtonListener());
            
            
            
            
            // Add the button to the panel
            buttonPanel.add(treeButton[i]);
            
            
        }        
        
                
                
            
            
        
    
        buttonPanel.setSize(350, 350);
        buttonPanel.setBackground(Color.blue);
        
        
     
    }
    
    /**
     * Private inner class that handles the event when the user clicks the button.
     */
    private class ButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            ((JButton)e.getSource()).setEnabled(false);
            
            
            ((JButton)e.getSource()).setIcon(trunkImage);
            
            game.buttonClicked();
            
            triesLeftTextField.setText(Integer.toString(game.getTriesLeft()));
            
            
        }
    }
    
    private class TreasureButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            ((JButton)e.getSource()).setBackground(Color.red);
            
            ((JButton)e.getSource()).setIcon(treasureImage);
            
            game.found();
            
            treasuresLeftTextField.setText(Integer.toString(game.getTreasuresLeft()));
            
            treasuresFoundTextField.setText(Integer.toString(game.getTreasuresFound()));
            
            triesLeftTextField.setText(Integer.toString(game.getTriesLeft()));
            
        }
    }
    
    
    
}
