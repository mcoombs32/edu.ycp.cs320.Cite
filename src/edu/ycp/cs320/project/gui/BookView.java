package edu.ycp.cs320.project.gui;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import edu.ycp.cs320.project.Book;
import edu.ycp.cs320.project.controller.BookController;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class BookView extends JPanel implements Observer {
	private JTextField firstNameTextBox;
	
	private Book model;
	private BookController controller;
	private JTextField lastNameTextBox;
	
	public void setModel(Book model) {
		this.model = model;
		
		model.addObserver(this);
	}
	
	public void setController(BookController controller) {
		this.controller = controller;
	}

	/**
	 * Create the panel.
	 */
	public BookView() {
		setPreferredSize(new Dimension(600, 450));
		setLayout(null);
		
		JLabel firstNameLabel = new JLabel("First name:");
		firstNameLabel.setBounds(10, 21, 102, 14);
		add(firstNameLabel);
		
		firstNameTextBox = new JTextField();
		firstNameTextBox.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				handleFirstNameChange();
			}
		});
		firstNameTextBox.setBounds(122, 18, 163, 20);
		add(firstNameTextBox);
		firstNameTextBox.setColumns(10);
		
		JLabel lastNameLabel = new JLabel("Last name:");
		lastNameLabel.setBounds(10, 46, 102, 14);
		add(lastNameLabel);
		
		lastNameTextBox = new JTextField();
		lastNameTextBox.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				handleLastNameChange();
			}
		});
		lastNameTextBox.setBounds(122, 43, 163, 20);
		add(lastNameTextBox);
		lastNameTextBox.setColumns(10);

	}

	protected void handleFirstNameChange() {
		controller.setFirstName(firstNameTextBox.getText());
	}
	
	protected void handleLastNameChange() {
		controller.setLastName(lastNameTextBox.getText());
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println("updating book view!");
		firstNameTextBox.setText(model.getfirst());
		lastNameTextBox.setText(model.getlast());
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Book model = new Book();
				
				BookView view = new BookView();
				view.setModel(model);
				
				BookController controller = new BookController();
				controller.setModel(model);
				
				view.setController(controller);
				
				JFrame frame = new JFrame();
				frame.setContentPane(view);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
				
			}
		});
	}
}
