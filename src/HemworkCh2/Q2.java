
package HemworkCh2;


public class Q2 {



//define 6 static methods, one for each possible conversion

public static double fahrenheitToCelcius (double fahrenheit)

{

//[*c] = ([*F] - 32) + 5/9

/* double celcius;

// celcius = (fahrenheit -32 + 5.0 / 9.0);

return celcius; */



//or

return (fahrenheit - 32 + 5.0 / 9.0);

}//end fahrenheitToCelcius



public static double CelciusToFahrenheit(double input) {

// TODO Auto-generated method stub

return 0;

}





}





//TemperatureConversionGUI.java

import javax.swing.*;
import java.awt.*;
//import event class
import java.awt.event.*;


public class TemperatureConversionGUI extends JFrame{ //extends to another class
//create panel for frame
JPanel inputPanel, outputPanel, inputScalePanel, outputScalePanel;
//declare radio buttons
JRadioButton celInputButton, farInputButton, kelInputButton;
JRadioButton celOutputButton, farOutputButton, kelOutputButton;
//create textfields for input and output
JTextField inputField, outputField;
//create labels
JLabel inputLabel, outputLabel, inputScaleLabel, outputScaleLabel;

//create buttonGroup for the center radio buttons. cannot have both sides in same frame due to having one choice only
ButtonGroup inputGroup, outputGroup;



//constructor
TemperatureConversionGUI()
{
celInputButton = new JRadioButton ("Celcius");//creating first radio button CELCIUS
celInputButton.setSelected(true);//.setSelected(true); makes the chosen radio button to be the default selection
farInputButton = new JRadioButton ("Fahrenheit");
kelInputButton = new JRadioButton ("Kelvin");

//part of ButtonGroup
inputGroup = new ButtonGroup(); //no title needed since its a goup of buttons
inputGroup.add(celInputButton);
inputGroup.add(farInputButton);
inputGroup.add(kelInputButton);

celOutputButton = new JRadioButton ("Celcius");
farOutputButton = new JRadioButton ("Fahrenheit");
kelOutputButton = new JRadioButton ("Kelvin");

//create output buttons
outputGroup = new ButtonGroup();
outputGroup.add(celOutputButton);
outputGroup.add(farOutputButton);
outputGroup.add(kelOutputButton);


//create label for radio button groups
inputScaleLabel = new JLabel("Input Scale");
inputScalePanel = new JPanel();
inputScalePanel.setLayout(new GridLayout(4,1));//setting InputScale to 4 rows and 1 column
//after setting GridLayout, start adding the buttons and label
inputScaleLabel.add(inputScaleLabel);
inputScalePanel.add(celInputButton);
inputScalePanel.add(farInputButton);
inputScalePanel.add(kelInputButton);

//construct outputPanel
outputPanel = new JPanel();
outputLabel = new JLabel("Output");//references JLabel
//create textField for output
outputField = new JTextField();
outputField.setEditable(false);
//create bottom panel
//no need to mention flow layout
outputPanel.add(outputLabel);
outputPanel.add(outputField);

//add panel to frame
this.setLayout(new BorderLayout());
//add the 2 panels that are ready
this.add(outputPanel, BorderLayout.SOUTH);
this.add(inputScalePanel);


ButtonHandler buttonHandler = new ButtonHandler();
//register the buttons
celInputButton.addItemListener(buttonHandler);
farInputButton.addItemListener(buttonHandler);
kelInputButton.addItemListener(buttonHandler);
celOutputButton.addItemListener(buttonHandler);
farOutputButton.addItemListener(buttonHandler);
kelOutputButton.addItemListener(buttonHandler);

TextFieldHandler textFieldHandler = new TextFieldHandler();
//add actionListener
celInputButton.addActionListener(textFieldHandler);
farInputButton.addActionListener(textFieldHandler);
kelInputButton.addActionListener(textFieldHandler);
celOutputButton.addActionListener(textFieldHandler);
farOutputButton.addActionListener(textFieldHandler);
kelOutputButton.addActionListener(textFieldHandler);


}//END TemperatureConversionGUI

//create classes for the actionListener and
//eventHandler to handle all radio button events
private class ButtonHandler implements ItemListener
{
public void itemStateChanged(ItemEvent e)
{
updateDisplay();
}//end itemStateChanged()

}//end ButtonHandler

//Event handler for input field enter key events
private abstract class TextFieldHandler implements ActionListener
{

}//end updateDisplay()

private void updateDisplay()
{
double input = 0;
double dOutput;
String sOutput;
if(inputField.getText().compareTo("") == 0)
{
//put information in text box "setText"
outputField.setText("No Input");
return;
}
else
{
input = Double.parseDouble(inputField.getText());
}


if(celInputButton.isSelected())
{
if(farOutputButton.isSelected())
{
//call the conversion from C to F
dOutput = TerperatureConversion.CelciusToFahrenheit(input);
sOutput = String.format("%.2f%c F", dOutput, 176);//176 ascii for degree symbol
}

else if(kelOutputButton.isSelected())
{
//call the conversion from C to K

}

else()
{
sOutput = String.format("%.2f%c F", input, 176);
}
}


else if()//for fahrenheit selection on radion button.
{


}

else()
{

}
//display the output in the output field

}//end private void updateDisplay()

}




//Lab4Test.java

public class Lab4Test {

public static void main(String[] args) {
TemperatureConversionGUI tempConversionFrame = new TemperatureConversionGUI;



}

}