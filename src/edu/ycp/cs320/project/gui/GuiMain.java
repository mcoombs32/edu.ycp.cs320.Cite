package edu.ycp.cs320.project.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import java.awt.EventQueue;
import java.awt.Dimension;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
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
import edu.ycp.cs320.project.MapPersistance;
import edu.ycp.cs320.project.Periodical;
import edu.ycp.cs320.project.Source;
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
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GuiMain extends JFrame implements Observer {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<SourceType> sourceTypeComboBox;
	private JPanel sourceViewContainerPanel;
	private PersistanceController perController;
	private CitationController citeController;
	
	private Book book;
	private Citation cite;
	private Website website;
	private Periodical periodical;
	private MapPersistance map;
	
	private int numResults = 0;
	private Citation[] resultList = new Citation[100];
	private String[] title = new String[100];
	private PeriodicalView periodicalView;
	private BookView bookView;
	private WebsiteView websiteView;
	
	private JList<String> resultJList;
	private JTextField searchField;
	private CardLayout cardLayout;
	private FormatType formatType;
	private JournalView journalView;
	private JTextArea outputTextArea;
	private JComboBox<FormatType> formatComboBox;
	private SourceType sourceType;
	private Journal journal;

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
		generateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				generateCitation();
			}

		});
		generateButton.setName("GenerateButton");
		generateButton.setBounds(285, 465, 89, 23);
		getContentPane().add(generateButton);

		JLabel typeLabel = new JLabel("Citation Type:");
		typeLabel.setBounds(38, 26, 96, 14);
		getContentPane().add(typeLabel);

		JLabel formatLabel = new JLabel("Citation Format:");
		formatLabel.setBounds(38, 443, 96, 14);
		getContentPane().add(formatLabel);
		formatComboBox = new JComboBox<FormatType>();

		formatComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formatTypeChanged();
			}
		});

		formatComboBox.setModel(new DefaultComboBoxModel<FormatType>(FormatType.values()));
		formatType = (FormatType) formatComboBox.getSelectedItem();
		formatComboBox.setBounds(38, 468, 224, 20);
		getContentPane().add(formatComboBox);

		searchField = new JTextField();
		searchField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				searchField.setText("");
			}
		});
		searchField.setText("To search for a citation, enter the title here.");
		searchField.setBounds(530, 23, 261, 20);
		getContentPane().add(searchField);
		searchField.setColumns(10);

		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				findCite(searchField.getText().toLowerCase());
			}
		});
		searchButton.setBounds(531, 51, 89, 23);
		getContentPane().add(searchButton);

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
		
		resultJList = new JList<String>();
		resultJList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				handleSavedRecall();
			}
		});
		
	
		resultJList.setBounds(540, 112, 251, 313);
		getContentPane().add(resultJList);


	}

	protected void handleSavedRecall() {
		outputTextArea.append(resultList[resultJList.getSelectedIndex()].getFormattedCite()+"\n");
		
	}

	protected void findCite(String lowerCase) {
		
		if (perController.Search(lowerCase) != null){
			resultList[numResults] = perController.Search(lowerCase);
			title[numResults] = perController.Search(lowerCase).getSource().gettitle();
			numResults++;
		}
		
		else
			outputTextArea.append("Citation not found!\n");
		
		resultJList.setListData(title);
		
	}

	protected void generateCitation() {
		if ((SourceType) sourceTypeComboBox.getSelectedItem() == SourceType.BOOK){
			citeController.setSource(book);
		}
		else if ((SourceType) sourceTypeComboBox.getSelectedItem() == SourceType.JOURNAL){
			citeController.setSource(journal);
		}
		else if ((SourceType) sourceTypeComboBox.getSelectedItem() == SourceType.PERIODICAL){
			citeController.setSource(periodical);
		}
		else if ((SourceType) sourceTypeComboBox.getSelectedItem() == SourceType.WEBSITE){
			citeController.setSource(website);
		}
		citeController.setFormat(formatType);
		citeController.format();
		outputTextArea.append(citeController.getFormattedCite()+"\n");
					
	}

	protected void saveCitation(Citation cite2) {
		perController.save(cite2);

	}

	protected void formatTypeChanged() {

		formatType = (FormatType) formatComboBox.getSelectedItem();
		citeController.setFormat(formatType);

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
		
		this.cite = new Citation();
		this.citeController = new CitationController();
		citeController.setModel(cite);
		
		this.map = new MapPersistance();
		this.perController = new PersistanceController();
		perController.setModel(map);
		
		cardLayout = (CardLayout) sourceViewContainerPanel.getLayout();
		cardLayout.show(sourceViewContainerPanel, SourceType.BOOK.toString());
	}

	protected void sourceTypeChanged() {
		sourceType = (SourceType) sourceTypeComboBox.getSelectedItem();
		CardLayout cardLayout = (CardLayout) sourceViewContainerPanel.getLayout();
		cardLayout.show(sourceViewContainerPanel, sourceType.toString());
		if ((SourceType) sourceTypeComboBox.getSelectedItem() == SourceType.BOOK){
			citeController.setSource(book);
		}
		else if ((SourceType) sourceTypeComboBox.getSelectedItem() == SourceType.JOURNAL){
			citeController.setSource(journal);
		}
		else if ((SourceType) sourceTypeComboBox.getSelectedItem() == SourceType.PERIODICAL){
			citeController.setSource(periodical);
		}
		else if ((SourceType) sourceTypeComboBox.getSelectedItem() == SourceType.WEBSITE){
			citeController.setSource(website);
		}
		
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
