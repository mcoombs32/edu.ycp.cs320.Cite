package edu.ycp.cs320.project.gui;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


import edu.ycp.cs320.project.Periodical;
import edu.ycp.cs320.project.controller.PeriodicalController;
import javax.swing.JLabel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class PeriodicalView extends JPanel implements Observer {


	private Periodical model;
	private PeriodicalController controller;
	private JTextField firstNameTextBox;
	private JTextField lastNameTextBox;
	private JLabel lblTitle;
	private JLabel lblDate;
	private JTextField TitleTextFieldBox;
	private JTextField DateTextFieldBox;
	private JTextField PublisherTextField;
	private JLabel lblPageNumber;
	private JLabel lblVolume;
	private JLabel lblMagazineName;
	private JTextField PageNumberTextBox;
	private JTextField VolumeTextBox;
	private JTextField MagazineNameTextBox;
	private JTextField MediumtextField;

	public void setModel(Periodical model) {
		this.model = model;

		model.addObserver(this);
	}

	public void setController(PeriodicalController controller) {
		this.controller = controller;
	}

	/**
	 * Create the panel.
	 */
	public PeriodicalView() {

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

		///////////////// TITLE
		lblTitle = new JLabel("Title:");
		lblTitle.setBounds(10, 71, 130, 14);
		add(lblTitle);


		TitleTextFieldBox = new JTextField();
		TitleTextFieldBox.addFocusListener(new FocusAdapter(){
			@Override
			public void focusLost(FocusEvent e){
				handleTitleChange();
			}
		});
		TitleTextFieldBox.setBounds(167, 68, 163, 20);
		add(TitleTextFieldBox);
		TitleTextFieldBox.setColumns(10);




		//******** DATE
		lblDate = new JLabel("Date Created(YYYY):");
		lblDate.setBounds(10, 96, 130, 14);
		add(lblDate);


		DateTextFieldBox = new JTextField();
		DateTextFieldBox = new JTextField();
		DateTextFieldBox.addFocusListener(new FocusAdapter(){
			@Override
			public void focusLost(FocusEvent e){
				handleDateChange();
			}
		});
		DateTextFieldBox.setBounds(167, 93, 163, 20);
		add(DateTextFieldBox);
		DateTextFieldBox.setColumns(10);



		// ********** PUBLISHER
		JLabel lblPublisher = new JLabel("Publisher: ");
		lblPublisher.setBounds(10, 121, 130, 14);
		add(lblPublisher);

		PublisherTextField = new JTextField();
		PublisherTextField.addFocusListener(new FocusAdapter(){
			@Override
			public void focusLost(FocusEvent e){
				handlePublisherChange();
			}
		});
		PublisherTextField.setBounds(167, 118, 163, 20);
		add(PublisherTextField);
		PublisherTextField.setColumns(10);



		//// *********** PAGE NUMBER
		lblPageNumber = new JLabel("Page Number:");
		lblPageNumber.setBounds(10, 146, 130, 14);
		add(lblPageNumber);

		PageNumberTextBox = new JTextField();
		PageNumberTextBox.addFocusListener(new FocusAdapter(){
			@Override
			public void focusLost(FocusEvent e){
				handlePageNumberChange();
			}
		});	
		PageNumberTextBox.setBounds(167, 143, 163, 20);
		add(PageNumberTextBox);
		PageNumberTextBox.setColumns(10);


		///************** VOLUME
		lblVolume = new JLabel("Volume:");
		lblVolume.setBounds(10, 171, 130, 14);
		add(lblVolume);

		VolumeTextBox = new JTextField();
		VolumeTextBox.addFocusListener(new FocusAdapter(){
			@Override
			public void focusLost(FocusEvent e){
				handleVolumeChange();
			}
		});
		VolumeTextBox.setBounds(167, 168, 163, 20);
		add(VolumeTextBox);
		VolumeTextBox.setColumns(10);



		//************** MAGAZINE NAME
		lblMagazineName = new JLabel("Magazine Name:");
		lblMagazineName.setBounds(10, 196, 130, 14);
		add(lblMagazineName);


		MagazineNameTextBox = new JTextField();
		MagazineNameTextBox.addFocusListener(new FocusAdapter(){
			@Override
			public void focusLost(FocusEvent e){
				handleMagazineNameChange();
			}
		});
		MagazineNameTextBox.setBounds(167, 193, 163, 20);
		add(MagazineNameTextBox);
		MagazineNameTextBox.setColumns(10);
		lblMagazineName = new JLabel("Magazine Name:");
		lblMagazineName.setBounds(10, 196, 130, 14);
		add(lblMagazineName);
		
		JLabel lblMedium = new JLabel("Medium");
		lblMedium.setBounds(10, 221, 46, 14);
		add(lblMedium);
		
		MediumtextField = new JTextField();
		MediumtextField.addFocusListener(new FocusAdapter(){
			@Override
			public void focusLost(FocusEvent e){
				handleMediumChange();
			}

			
		});
		MediumtextField.setBounds(167, 218, 163, 20);
		add(MediumtextField);
		MediumtextField.setColumns(10);


		
	}

	protected void handleFirstNameChange() {
		controller.setFirstName(firstNameTextBox.getText());
	}

	protected void handleLastNameChange() {
		controller.setLastName(lastNameTextBox.getText());
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

	protected void handlePageNumberChange(){
		controller.setPageNumber(PageNumberTextBox.getText());
	}

	protected void handleVolumeChange(){
		controller.setVolume(VolumeTextBox.getText());
	}

	protected void handleMagazineNameChange(){
		controller.setMagazineName(MagazineNameTextBox.getText());
	}
	private void handleMediumChange() {
		controller.setmedium(MediumtextField.getText());
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println("updating magazine view!");
		firstNameTextBox.setText(model.getfirst());
		lastNameTextBox.setText(model.getlast());
		TitleTextFieldBox.setText(model.gettitle());
		DateTextFieldBox.setText(model.getdate());
		PublisherTextField.setText(model.getpublisher());
		PageNumberTextBox.setText(model.getpagenumber());
		VolumeTextBox.setText(model.getvolumenumber());
		MagazineNameTextBox.setText(model.getmagazine());
		
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Periodical model = new Periodical();

				PeriodicalView view = new PeriodicalView();
				view.setModel(model);

				PeriodicalController controller = new PeriodicalController();
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
