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
import edu.ycp.cs320.project.Website;
import edu.ycp.cs320.project.controller.WebsiteController;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class WebsiteView extends JPanel implements Observer {
	private JTextField firstNameTextBox;
	
	private Website model;
	private WebsiteController controller;
	private JTextField lastNameTextBox;
	private JLabel lblUrl;
	private JLabel lblTitle;
	private JLabel lblDate;
	private JTextField URLtextFieldBox;
	private JTextField TitleTextFieldBox;
	private JTextField DateTextFieldBox;
	
	public void setModel(Website model) {
		this.model = model;
		
		model.addObserver(this);
	}
	
	public void setController(WebsiteController controller) {
		this.controller = controller;
	}

	/**
	 * Create the panel.
	 */
	public WebsiteView() {
		setPreferredSize(new Dimension(600, 450));
		setLayout(null);
		
		//FIRST NAME
		JLabel firstNameLabel = new JLabel("Author First Name:");
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
		
		
		// LAST NAME
		JLabel lastNameLabel = new JLabel("Author Last Name:");
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
		
		
		// URL
		lblUrl = new JLabel("URL:");
		lblUrl.setBounds(10, 71, 102, 14);
		add(lblUrl);
		
		
		
		
		
		lblTitle = new JLabel("Title:");
		lblTitle.setBounds(10, 96, 102, 14);
		add(lblTitle);
		
		lblDate = new JLabel("Date:");
		lblDate.setBounds(10, 121, 102, 14);
		add(lblDate);
		
		URLtextFieldBox = new JTextField();
		URLtextFieldBox.setBounds(122, 68, 163, 20);
		add(URLtextFieldBox);
		URLtextFieldBox.setColumns(10);
		
		
		
		// TITLE
		TitleTextFieldBox = new JTextField();
		TitleTextFieldBox.setBounds(122, 93, 163, 20);
		add(TitleTextFieldBox);
		TitleTextFieldBox.setColumns(10);
		
		
		// DATE
		DateTextFieldBox = new JTextField();
		DateTextFieldBox.setBounds(122, 118, 163, 20);
		add(DateTextFieldBox);
		DateTextFieldBox.setColumns(10);

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
				Website model = new Website();
				
				WebsiteView view = new WebsiteView();
				view.setModel(model);
				
				WebsiteController controller = new WebsiteController();
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
