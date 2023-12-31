package calculator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Frame extends JFrame implements ActionListener{
	JButton oneButton,
			twoButton,
			threeButton,
			fourButton,
			fiveButton,
			sixButton,
			sevenButton,
			eightButton,
			nineButton,
			zeroButton,
			equalButton,
			plusButton,
			minusButton,
			multiplicationButton,
			divisionButton,
			squareButton,
			elementButton,
			percentButton,
			IOFButton,
			IONButton,
			clearButton,
			clearEntryButtom,
			backspaceButtom,
			dotButtom;
	
	JPanel	window,
			box;
	
	JLabel	windowLabel,
			helpBoxLabel;
	
	String	operator="", helpBoxText="", windowText="0";
	
	double	windowContent=0;
	
	double	numberInMemory=0;
	
	boolean	numberInWindowIs0=true;
	
	Frame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		window = new JPanel();
		window.setPreferredSize(new Dimension(300,70));
		window.setLayout(new GridLayout(2,1));
		
		box = new JPanel();
		box.setPreferredSize(new Dimension(300,300));
		box.setLayout(new GridLayout(6,4));
		
		oneButton = new JButton("1");
		oneButton.addActionListener(this);
		twoButton = new JButton("2");
		twoButton.addActionListener(this);
		threeButton = new JButton("3");
		threeButton.addActionListener(this);
		fourButton = new JButton("4");
		fourButton.addActionListener(this);
		fiveButton = new JButton("5");
		fiveButton.addActionListener(this);
		sixButton = new JButton("6");
		sixButton.addActionListener(this);
		sevenButton = new JButton("7");
		sevenButton.addActionListener(this);
		eightButton = new JButton("8");
		eightButton.addActionListener(this);
		nineButton = new JButton("9");
		nineButton.addActionListener(this);
		zeroButton = new JButton("0");
		zeroButton.addActionListener(this);
		
		equalButton = new JButton("=");
		equalButton.addActionListener(this);
		plusButton = new JButton("+");
		plusButton.addActionListener(this);
		minusButton = new JButton("-");
		minusButton.addActionListener(this);
		multiplicationButton = new JButton("*");
		multiplicationButton.addActionListener(this);
		divisionButton = new JButton("/");
		divisionButton.addActionListener(this);
		squareButton = new JButton("x²");
		squareButton.addActionListener(this);
		elementButton = new JButton("√x");
		elementButton.addActionListener(this);
		percentButton = new JButton("%");
		percentButton.addActionListener(this);
		IOFButton = new JButton("1/x");
		IOFButton.addActionListener(this);
		IONButton = new JButton("-x");
		IONButton.addActionListener(this);
		clearButton = new JButton("C");
		clearButton.addActionListener(this);
		clearEntryButtom = new JButton("CE");
		clearEntryButtom.addActionListener(this);
		backspaceButtom = new JButton("←");
		backspaceButtom.addActionListener(this);
		dotButtom = new JButton(".");
		dotButtom.addActionListener(this);
		
		box.add(percentButton);
		box.add(clearEntryButtom);
		box.add(clearButton);
		box.add(backspaceButtom);
		box.add(IOFButton);
		box.add(squareButton);
		box.add(elementButton);
		box.add(divisionButton);
		box.add(sevenButton);
		box.add(eightButton);
		box.add(nineButton);
		box.add(multiplicationButton);
		box.add(fourButton);
		box.add(fiveButton);
		box.add(sixButton);
		box.add(minusButton);
		box.add(oneButton);
		box.add(twoButton);
		box.add(threeButton);
		box.add(plusButton);
		box.add(IONButton);
		box.add(zeroButton);
		box.add(dotButtom);
		box.add(equalButton);
		
		windowLabel = new JLabel("0", SwingConstants.RIGHT);
		windowLabel.setFont(new Font("Serif", Font.PLAIN, 34));
		windowLabel.setForeground(new Color(0xFFFFFF));
		windowLabel.setBackground(new Color(0x333333));
		windowLabel.setOpaque(true);
		
		helpBoxLabel = new JLabel("", SwingConstants.RIGHT);
		helpBoxLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		
		window.add(helpBoxLabel);
		window.add(windowLabel);
		this.add(window);
		this.add(box);
		
		this.pack();
		this.setSize(500,500);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==zeroButton) {
			if(windowText!="0") {windowText+=0;}
			refreshWindow();
		}
		if(e.getSource()==oneButton) {
			hideStartZero();
			windowText+=1;
			refreshWindow();
		}
		if(e.getSource()==twoButton) {
			hideStartZero();
			windowText+=2;
			refreshWindow();
		}
		if(e.getSource()==threeButton) {
			hideStartZero();
			windowText+=3;
			refreshWindow();
		}
		if(e.getSource()==fourButton) {
			hideStartZero();
			windowText+=4;
			refreshWindow();
		}
		if(e.getSource()==fiveButton) {
			hideStartZero();
			windowText+=5;
			refreshWindow();
		}
		if(e.getSource()==sixButton) {
			hideStartZero();
			windowText+=6;
			refreshWindow();
		}
		if(e.getSource()==sevenButton) {
			hideStartZero();
			windowText+=7;
			refreshWindow();
		}
		if(e.getSource()==eightButton) {
			hideStartZero();
			windowText+=8;
			refreshWindow();
		}
		if(e.getSource()==nineButton) {
			hideStartZero();
			windowText+=9;
			refreshWindow();
		}
		if(e.getSource()==backspaceButtom) {
			windowText = removeLastChar(windowText);
			refreshWindow();
		}
		if(e.getSource()==clearEntryButtom) {
			windowText = "0";
			refreshWindow();
		}
		if(e.getSource()==clearButton) {
			restartProgram();
			helpBoxLabel.setText("");
			refreshWindow();
		}
		if(e.getSource()==plusButton) {
			checkOption();
			operator = "+";
			refreshHelpBox();
		}
		if(e.getSource()==minusButton) {
			checkOption();
			operator = "-";
			refreshHelpBox();
		}
		if(e.getSource()==divisionButton) {
			checkOption();
			operator = "/";
			refreshHelpBox();
		}
		if(e.getSource()==multiplicationButton) {
			checkOption();
			operator = "*";
			refreshHelpBox();
		}
		if(e.getSource()==squareButton) {
			//helpBoxLabel.setText(numberInMemory+operator+Double.toString(windowContent)+"²");
			windowText = Double.toString(square(windowContent));
			refreshWindow();
		}
		if(e.getSource()==elementButton) {
			//helpBoxLabel.setText(numberInMemory+operator+"√("+Double.toString(windowContent)+")");
			//windowLabel.setText(Double.toString(element(windowContent)));
		}
		if(e.getSource()==equalButton) {
			equal();
			helpBoxLabel.setText(Double.toString(numberInMemory)+operator);
		}
		if(e.getSource()==dotButtom) {
			if(windowText.contains(".")==false) {
				windowText+=".";
			}
			refreshWindow();
		}
	}

	private void checkOption() {
		//Checks 1 of 3 options every time we use it.
		//1) if there is was no sign before, it safes window content to memory.
		windowText = "0";
		if(operator=="") {
			saveNumberInMemory();
		} else {
			//2) Other way if there is no value in window it just skips,
			//3) or if there is any value, it makes 2 numbers and sign between them equal.
			if((windowContent!=0)||(numberInWindowIs0==false)) {
				equal();
			}
		}
	}

	private void sendResult() {
		//Pops out result of mathematical operation to the window.
		windowLabel.setText(Double.toString(numberInMemory));
	}
	
	private void refreshWindow() {
		//Refreshes window content.
		windowLabel.setText(windowText);
		windowContent = Double.parseDouble(windowText);
	}
	
	private void refreshHelpBox() {
		//Refreshes helpBox content.
		helpBoxLabel.setText(Double.toString(numberInMemory)+operator);
	}

	private void saveNumberInMemory() {
		//Saves number from window to memory.
		numberInMemory = windowContent;
		windowContent = 0;
	}

	private void equal() {
		//Checks for actual operator case,
		//and makes number from memory, window and sign between them equal. 
		oneNumberOption();
		switch(operator) {
			case "+":
				numberInMemory = sum(numberInMemory, windowContent);
				sendResult();
				setWindowTo0();
				break;
			case "-":
				numberInMemory = difference(numberInMemory, windowContent);
				sendResult();
				setWindowTo0();
				break;
			case "*":
				numberInMemory = product(numberInMemory, windowContent);
				sendResult();
				setWindowTo0();
				break;
			case "/":
				try {
					numberInMemory = quotient(numberInMemory, windowContent);
					//To avoid divide  by 0, there is some ArithmeticExpection. 
					if (numberInMemory == Double.POSITIVE_INFINITY ||
							numberInMemory == Double.NEGATIVE_INFINITY)
		                throw new ArithmeticException();
				}
				catch(ArithmeticException ae) {
					windowLabel.setText("You can't divide by 0");
					restartProgram();
					break;
				}
				sendResult();
				setWindowTo0();
				break;
		}
	}
	private void hideStartZero() {
		if(windowText=="0") {windowText = "";}
	}
	
	private void setWindowTo0() {
		windowContent = 0;
		numberInWindowIs0 = true;
	}

	private void oneNumberOption() {
		//Copies 1st number value to 2nd number, if there is only one number.
		if((windowContent==0)&&(numberInWindowIs0==true))
		windowContent = numberInMemory;
	}

	private void restartProgram() {
		//Restarts all arguments to theirs start value.
		windowContent = 0;
		numberInMemory = 0;
		operator = "";
		helpBoxText = "";
		windowText = "0";
		numberInWindowIs0 = true;
	}
	
	public static String removeLastChar(String str) {
		//Removes last char from string
	    return (str == "0" || str.length() == 1) ? "0" : (str.substring(0, str.length() - 1));
	}
	
	//There are some mathematical functions.
	private double sum(double numberOne, double numberTwo) {
		return numberOne+numberTwo;
	}
	private double difference(double numberOne, double numberTwo) {
		return numberOne-numberTwo;
	}
	private double product(double numberOne, double numberTwo) {
		return numberOne*numberTwo;
	}
	private double quotient(double numberOne, double numberTwo) {
		return numberOne/numberTwo;
	}
	private double square(double numberOne) {
		return numberOne*numberOne;
	}
	private double element(double numberOne) {
		return numberOne;
	}
	
}
