package edu.ycp.cs320.project.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import edu.ycp.cs320.project.Book;
import edu.ycp.cs320.project.Citation;
import edu.ycp.cs320.project.FormatType;
import edu.ycp.cs320.project.Journal;
import edu.ycp.cs320.project.Periodical;
import edu.ycp.cs320.project.SourceType;
import edu.ycp.cs320.project.Website;

import edu.ycp.cs320.project.controller.BookController;
import edu.ycp.cs320.project.controller.CitationController;
import edu.ycp.cs320.project.controller.JournalController;
import edu.ycp.cs320.project.controller.PeriodicalController;
import edu.ycp.cs320.project.controller.PersistanceController;
import edu.ycp.cs320.project.controller.WebsiteController;

import edu.ycp.cs320.project.gui.BookView;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;

public class GuiMain extends JFrame implements Observer {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<SourceType> sourceTypeComboBox;
	private JPanel sourceViewContainerPanel;
	private Book abook=new Book("Chris","Campagnola", "York College Student Review","2013", "York College of Pennsylvania","York,Pa","Print");
	private PersistanceController perController;
	private CitationController citcontroller;
	private Book book = new Book();
	private Citation cite;
	private Website website;
	private Periodical periodical;
	private PeriodicalView periodicalView;
	private BookView bookView;
	private WebsiteView websiteView;
	private JTextField searchField;
<<<<<<< HEAD

=======
	private Journal journal;

>>>>>>> e4019e5196e6104a54d571f0d56c14dd4f85d4cc
	private JournalView journalView;
	private JTextArea outputTextArea;
	private JComboBox formatComboBox;
	private CitationController controller;
	private Citation model;
	private SourceType sourceType=SourceType.BOOK;
<<<<<<< HEAD
	private Journal journal;
public void setModel(Citation model) {
	this.model = model;

	
}

public void setController(CitationController controller) {
	this.controller = controller;
}

=======
	public void setModel(Citation model) {
		this.model = model;


	}

	public void setController(CitationController controller) {
		this.controller = controller;
	}
>>>>>>> e4019e5196e6104a54d571f0d56c14dd4f85d4cc
	/**
	 * Create the frame.
	 */
	public GuiMain() {

		setPreferredSize(new Dimension(850, 700));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		sourceViewContainerPanel = new JPanel();
		sourceViewContainerPanel.setBounds(38, 82, 447, 343);
		getContentPane().add(sourceViewContainerPanel);
		sourceViewContainerPanel.setLayout(new CardLayout(0, 0));
		sourceTypeComboBox = new JComboBox<SourceType>();
		sourceTypeComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sourceTypeChanged();
			}
		});

		sourceTypeComboBox.setModel(new DefaultComboBoxModel<SourceType>(SourceType.values()));
		sourceTypeComboBox.setBounds(38, 51, 224, 20);
		getContentPane().add(sourceTypeComboBox);

		outputTextArea = new JTextArea();
		outputTextArea.setBounds(38, 499, 768, 180);
		getContentPane().add(outputTextArea);

		JButton generateButton = new JButton("Generate");
		generateButton.setName("GenerateButton");
		generateButton.setBounds(285, 465, 89, 23);
		getContentPane().add(generateButton);

		JLabel typeLabel = new JLabel("Citation Type:");
		typeLabel.setBounds(38, 26, 96, 14);
		getContentPane().add(typeLabel);

		JLabel formatLabel = new JLabel("Citation Format:");
		formatLabel.setBounds(38, 443, 96, 14);
		getContentPane().add(formatLabel);
<<<<<<< HEAD

		formatComboBox = new JComboBox();

=======


		formatComboBox = new JComboBox();
>>>>>>> e4019e5196e6104a54d571f0d56c14dd4f85d4cc
		formatComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Citation b=new Citation (book,book.getSourceType(book));

				formatTypeChanged();

			}
		});

		formatComboBox.setModel(new DefaultComboBoxModel<FormatType>(FormatType.values()));

		formatComboBox.setBounds(38, 468, 224, 20);
		getContentPane().add(formatComboBox);

		searchField = new JTextField();
		searchField.setText("To search for a citation, enter the title here.");
		searchField.setBounds(530, 23, 261, 20);
		getContentPane().add(searchField);
		searchField.setColumns(10);

		JButton searchButton = new JButton("Search");
		searchButton.setBounds(531, 51, 89, 23);
		getContentPane().add(searchButton);

		JTextArea resultArea = new JTextArea();
		resultArea.setBounds(530, 107, 260, 318);
		getContentPane().add(resultArea);

		JLabel lblResults = new JLabel("Results:");
		lblResults.setBounds(530, 82, 61, 14);
		getContentPane().add(lblResults);

		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveCitation(cite);
			}
		});
		saveButton.setBounds(396, 465, 89, 23);
		getContentPane().add(saveButton);


	}

	protected void saveCitation(Citation cite2) {
		perController.save(cite2);

	}

	protected void formatTypeChanged() {

		FormatType formatType = (FormatType) formatComboBox.getSelectedItem();
		Citation a = null;
		//cite.setformattype(formatType);
		if(sourceType==SourceType.BOOK){
			a=new Citation(book,formatType);
			a.setbook(book);
		}
		if(sourceType==SourceType.JOURNAL){
			a=new Citation(journal,formatType);
			a.setjournal(journal);
		}
		if(sourceType==SourceType.WEBSITE){
			a=new Citation(website,formatType);
			a.setwebsite(website);
		}
		if(sourceType==SourceType.PERIODICAL){
			a=new Citation(periodical,formatType);
			a.setmagazine(periodical);
		}
		outputTextArea.setText(a.formatcit());
<<<<<<< HEAD
	
		
		

=======




>>>>>>> e4019e5196e6104a54d571f0d56c14dd4f85d4cc
	}

	public void createSourceViews() {
		this.journal = new Journal();
		this.journalView = new JournalView();
		journalView.setModel(journal);
		JournalController journalController = new JournalController();
		journalView.setController(journalController);
		journalController.setModel(journal);
		sourceViewContainerPanel.add(journalView, SourceType.JOURNAL.toString());


		this.book = new Book();
		this.bookView = new BookView();
		bookView.setModel(book);
		BookController bookController = new BookController();
		bookView.setController(bookController);
		bookController.setModel(book);
		sourceViewContainerPanel.add(bookView, SourceType.BOOK.toString());

		this.website = new Website();
		this.websiteView = new WebsiteView();
		websiteView.setModel(website);
		WebsiteController websiteController = new WebsiteController();
		websiteView.setController(websiteController);
		websiteController.setModel(website);
		sourceViewContainerPanel.add(websiteView, SourceType.WEBSITE.toString());

		this.periodical = new Periodical();
		this.periodicalView = new PeriodicalView();
		periodicalView.setModel(periodical);
		PeriodicalController periodicalController = new PeriodicalController();
		periodicalView.setController(periodicalController);
		periodicalController.setModel(periodical);
		sourceViewContainerPanel.add(periodicalView, SourceType.PERIODICAL.toString());

<<<<<<< HEAD
		// journal
		this.journal = new Journal();
		this.journalView = new JournalView();
		journalView.setModel(journal);
		journalController = new JournalController();
		journalView.setController(journalController);
		journalController.setModel(journal);
		sourceViewContainerPanel.add(journalView, SourceType.JOURNAL.toString());

		
=======
>>>>>>> e4019e5196e6104a54d571f0d56c14dd4f85d4cc

		CardLayout cardLayout = (CardLayout) sourceViewContainerPanel.getLayout();
		cardLayout.show(sourceViewContainerPanel, SourceType.BOOK.toString());
	}

	protected void sourceTypeChanged() {
		sourceType = (SourceType) sourceTypeComboBox.getSelectedItem();
		CardLayout cardLayout = (CardLayout) sourceViewContainerPanel.getLayout();
		cardLayout.show(sourceViewContainerPanel, sourceType.toString());
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				GuiMain frame = new GuiMain();
				frame.createSourceViews();

				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.pack();

				frame.setVisible(true);
			}
		});
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}
}
