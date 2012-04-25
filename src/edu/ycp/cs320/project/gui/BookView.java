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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private JTextField firstNameTextBox;
	
	private Book model;
	private BookController controller;
	private JTextField lastNameTextBox;
	private JTextField titleBox;
	private JTextField publisherBox;
	private JTextField pubDateBox;
	private JTextField cityTextBox;
	
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
		setPreferredSize(new Dimension(394, 233));
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
		
		JLabel titleLabel = new JLabel("Title:");
		titleLabel.setBounds(10, 71, 46, 14);
		add(titleLabel);
		
		titleBox = new JTextField();
		titleBox.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
			handleTitleChange();
			}
		});
		titleBox.setBounds(122, 68, 163, 20);
		add(titleBox);
		titleBox.setColumns(10);
		
		JLabel publisherLabel = new JLabel("Publisher:");
		publisherLabel.setBounds(10, 96, 79, 14);
		add(publisherLabel);
		
		publisherBox = new JTextField();
		publisherBox.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				handlePublisherChange();
			}
		});
		publisherBox.setBounds(122, 93, 163, 20);
		add(publisherBox);
		publisherBox.setColumns(10);
		
		JLabel pubDateLabel = new JLabel("Publish Date:");
		pubDateLabel.setBounds(10, 121, 79, 14);
		add(pubDateLabel);
		
		pubDateBox = new JTextField();
		pubDateBox.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				handlePubDateChange();
			}
		});
		pubDateBox.setBounds(122, 118, 163, 20);
		add(pubDateBox);
		pubDateBox.setColumns(10);
		
		JLabel cityLabel = new JLabel("City of Publication:");
		cityLabel.setBounds(10, 146, 116, 14);
		add(cityLabel);
		
		cityTextBox = new JTextField();
		cityTextBox.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				handleCityChange();
			}
		});
		cityTextBox.setBounds(122, 143, 163, 20);
		add(cityTextBox);
		cityTextBox.setColumns(10);

	}

	protected void handleCityChange() {
		controller.setcity(cityTextBox.getText());
		
	}

	protected void handlePubDateChange() {
		controller.setPubDate(pubDateBox.getText());
		
	}

	protected void handlePublisherChange() {
		controller.setPub(publisherBox.getText());
		
	}

	protected void handleTitleChange() {
		controller.setTitle(titleBox.getText());
		
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
		titleBox.setText(model.gettitle());
		pubDateBox.setText(model.getPubDate());
		publisherBox.setText(model.getpublisher());
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
