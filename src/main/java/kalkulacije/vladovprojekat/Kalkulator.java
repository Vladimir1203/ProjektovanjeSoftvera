
package kalkulacije.vladovprojekat;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Kalkulator extends JFrame implements ActionListener{
    
    private JButton jButtonAdd;
    private JButton jButtonSubtract;
    private JLabel jLabFirstNumber;
    private JLabel jLabResult;
    private JLabel jLabSecondNumber;
    private JTextField jTxtFirst;
    private JTextField jTxtResult;
    private JTextField jTxtSecond;
    
    public Kalkulator(){
        pack();
        setLocationRelativeTo(null);
        setSize(250,200);
        setTitle("First calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildPanel();
        
    }
    
    private void buildPanel(){
        jButtonAdd = new JButton("ADD");
        jButtonAdd.addActionListener(this);
        jButtonSubtract = new JButton("SUBTRACT");
        jButtonSubtract.addActionListener(this);
        jLabFirstNumber = new JLabel("First number:");
        jLabSecondNumber = new JLabel("Second number:");
        jLabResult = new JLabel("Result:");
        jTxtFirst = new JTextField("");
        jTxtSecond = new JTextField("");
        jTxtResult = new JTextField("");
        jTxtResult.setEditable(false);
        JPanel panel = new JPanel();
        panel.add(jLabFirstNumber);
        panel.add(jTxtFirst);
        panel.add(jLabSecondNumber);
        panel.add(jTxtSecond);
        panel.add(jLabResult);
        panel.add(jTxtResult);
        panel.add(jButtonAdd);       
        panel.add(jButtonSubtract);
        setContentPane(panel);
    }
    
    public void actionPerformed(ActionEvent evt){
        JButton clicked = null;
        Object eventSource = evt.getSource();
        clicked = (JButton)eventSource;
        if(clicked.getText() == "ADD")
                addNumbers();
        else if(clicked.getText() == "SUBTRACT")
                subtractNumbers();
        
       
       
    }                                        
    
    private void addNumbers(){  
        String first, second;
        double result;
        jTxtResult.setText("");
        first = jTxtFirst.getText();
        second = jTxtSecond.getText();
        int prva = 0, druga = 0;
        try{
            double pom1 = Double.parseDouble(first);
        } catch(NumberFormatException e){
            prva = -1;
        }
          try{
            double pom1 = Double.parseDouble(second);
        } catch(NumberFormatException e){
            druga = -1;
        }
          
          if(prva == 0 && druga == 0){
              result = Double.parseDouble(first) + Double.parseDouble(second);
              jTxtResult.setText(Double.toString(result));
              return;
          }
          if(prva == -1 && druga == -1){
              JOptionPane.showMessageDialog(null, "Pogresan unos oba broja!");
              return;
          }
          if(prva == 0 && druga == -1){
              JOptionPane.showMessageDialog(null, "Pogresan unos drugog broja!");
              return;
          }
          if(prva == -1 && druga == 0){
              JOptionPane.showMessageDialog(null, "Pogresan unos prvog broja!");
              return;
          }                                       
    }
    
    private void subtractNumbers(){
        String first, second;
        double result;
        jTxtResult.setText("");
        first = jTxtFirst.getText();
        second = jTxtSecond.getText();
        int prva = 0, druga = 0; //int prva; int druga;
        try{
            double pom1 = Double.parseDouble(first);
        } catch(NumberFormatException e){
            prva = -1;
            //JOptionPane.showMessageDialog(null, "Pogresan unos prvog broja!");
        }
          try{
            double pom1 = Double.parseDouble(second);
        } catch(NumberFormatException e){
            druga = -1;
            //JOptionPane.showMessageDialog(null, "Pogresan unos drugog broja!");
        }
          
          if(prva == 0 && druga == 0){
              result = Double.parseDouble(first) - Double.parseDouble(second);
              jTxtResult.setText(Double.toString(result));
              return;
          }
          if(prva == -1 && druga == -1){
              JOptionPane.showMessageDialog(null, "Pogresan unos oba broja!");
              return;
          }
          if(prva == 0 && druga == -1){
              JOptionPane.showMessageDialog(null, "Pogresan unos drugog broja!");
              return;
          }
          if(prva == -1 && druga == 0){
              JOptionPane.showMessageDialog(null, "Pogresan unos prvog broja!");
              return;
          }
    }
    
    public static void main(String[] args){
        JFrame window = new Kalkulator();
        window.setVisible(true);
        GridLayout gl = new GridLayout(4,2,7,7);
        window.setLayout(gl);
    }
}
