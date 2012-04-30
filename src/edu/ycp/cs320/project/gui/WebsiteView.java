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
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField firstNameTextBox;

	private Website model;
	private WebsiteController controller;
	private JTextField lastNameTextBox;
	private JTextField URLtextFieldBox;

	private JLabel lblTitle;
	private JLabel lblDate;
	private JTextField TitleTextFieldBox;
	private JTextField DateTextFieldBox;
	private JTextField PublisherTextField;
	private JTextField AccessDateField;
	private JTextField WebsiteName;
	private JLabel lblMedium;
	private JTextField MediumTextField;

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

		//*************** FIRST NAME
		JLabel firstNameLabel = new JLabel("Author First Name:");
		firstNameLabel.setBounds(10, 21, 130, 14);
		add(firstNameLabel);

		firstNameTextBox = new JTextField();
		firstNameTextBox.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				handleFirstNameChange();
			}
		});
		firstNameTextBox.setBounds(167, 18, 163, 20);
		add(firstNameTextBox);
		firstNameTextBox.setColumns(10);


		// **************** LAST NAME
		JLabel lastNameLabel = new JLabel("Author Last Name:");
		lastNameLabel.setBounds(10, 46, 130, 14);
		add(lastNameLabel);

		lastNameTextBox = new JTextField();
		lastNameTextBox.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				handleLastNameChange();
			}
		});
		lastNameTextBox.setBounds(167, 43, 163, 20);
		add(lastNameTextBox);
		lastNameTextBox.setColumns(10);


		//**************** URL
		JLabel URLlabel = new JLabel("URL:");
		URLlabel.setBounds(10, 71, 130, 14);
		add(URLlabel);


		URLtextFieldBox = new JTextField();
		URLtextFieldBox.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e){
				handleURLChange();
			}
		});



		URLtextFieldBox.setBounds(122, 68, 163, 20);

		URLtextFieldBox.setBounds(167, 68, 163, 20);

		add(URLtextFieldBox);
		URLtextFieldBox.setColumns(10);


		lblTitle = new JLabel("Title:");
		lblTitle.setBounds(10, 96, 130, 14);
		add(lblTitle);


		TitleTextFieldBox = new JTextField();
		TitleTextFieldBox.addFocusListener(new FocusAdapter(){
			@Override
			public void focusLost(FocusEvent e){
				handleTitleChange();
			}
		});
		TitleTextFieldBox.setBounds(167, 93, 163, 20);
		add(TitleTextFieldBox);
		TitleTextFieldBox.setColumns(10);




		//******** DATE
		lblDate = new JLabel("Date Created(YYYY):");
		lblDate.setBounds(10, 121, 130, 14);
		add(lblDate);


		DateTextFieldBox = new JTextField();
		DateTextFieldBox = new JTextField();
		DateTextFieldBox.addFocusListener(new FocusAdapter(){
			@Override
			public void focusLost(FocusEvent e){
				handleDateChange();
			}
		});
		DateTextFieldBox.setBounds(167, 118, 163, 20);
		add(DateTextFieldBox);
		DateTextFieldBox.setColumns(10);



		// ********** PUBLISHER
		JLabel lblPublisher = new JLabel("Publisher: ");
		lblPublisher.setBounds(10, 147, 130, 14);
		add(lblPublisher);

		PublisherTextField = new JTextField();
		PublisherTextField.addFocusListener(new FocusAdapter(){
			@Override
			public void focusLost(FocusEvent e){
				handlePublisherChange();
			}
		});
		PublisherTextField.setBounds(167, 144, 163, 20);
		add(PublisherTextField);
		PublisherTextField.setColumns(10);



		// ********* DATE ACCESSED
		JLabel lblAccess = new JLabel("Accessed(MM/DD/YYYY):");
		lblAccess.setBounds(10, 172, 130, 14);
		add(lblAccess);


		AccessDateField = new JTextField();
		AccessDateField.addFocusListener(new FocusAdapter(){
			@Override
			public void focusLost(FocusEvent e){
				handleAccessChange();
			}
		});
		AccessDateField.setBounds(167, 169, 163, 20);
		add(AccessDateField);
		AccessDateField.setColumns(10);



		// *********** WEBSITE NAME
		JLabel lblWebsite = new JLabel("Website Name:");
		lblWebsite.setBounds(10, 197, 130, 14);
		add(lblWebsite);

		WebsiteName = new JTextField();
		WebsiteName.addFocusListener(new FocusAdapter(){
			@Override
			public void focusLost(FocusEvent e){
				handleWebsiteChange();
			}
		});
		WebsiteName.setBounds(167, 194, 163, 20);
		add(WebsiteName);
		WebsiteName.setColumns(10);
		
		lblMedium = new JLabel("Medium:");
		
		lblMedium.setBounds(10, 222, 56, 14);
		add(lblMedium);
		
		MediumTextField = new JTextField();
		MediumTextField.addFocusListener(new FocusAdapter(){
			@Override
			public void focusLost(FocusEvent e){
				handleMediumChange();
			}
		});
		MediumTextField.setBounds(167, 219, 163, 20);
		add(MediumTextField);
		MediumTextField.setColumns(10);

	}

	protected void handleFirstNameChange() {
		controller.setFirstName(firstNameTextBox.getText());
	}

	protected void handleLastNameChange() {
		controller.setLastName(lastNameTextBox.getText());
	}

	protected void handleURLChange() {
		controller.setURL(URLtextFieldBox.getText());
	}

	protected void handleTitleChange(){
		controller.setTitle(TitleTextFieldBox.getText());
	}

	protected void handleDateChange(){
		controller.setDate(DateTextFieldBox.getText());
	}

	protected void handlePublisherChange(){
		controller.setPublisher(PublisherTextField.getText());
	}

	protected void handleAccessChange(){
		controller.setAccess(AccessDateField.getText());
	}

	protected void handleWebsiteChange(){
		controller.setWebsite(WebsiteName.getText());
	}
	protected void handleMediumChange() {
		controller.setmedium(MediumTextField.getText());
		
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println("updating website view!");
		firstNameTextBox.setText(model.getfirst());
		lastNameTextBox.setText(model.getlast());
		URLtextFieldBox.setText(model.geturl());
		TitleTextFieldBox.setText(model.gettitle());
		DateTextFieldBox.setText(model.getdate());
		PublisherTextField.setText(model.getpublisher());
		AccessDateField.setText(model.getaccess());
		WebsiteName.setText(model.getwebsite());
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
