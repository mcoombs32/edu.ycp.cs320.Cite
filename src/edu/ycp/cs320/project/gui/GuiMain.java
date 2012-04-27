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
import edu.ycp.cs320.project.Journal;
import edu.ycp.cs320.project.Periodical;
import edu.ycp.cs320.project.SourceType;
import edu.ycp.cs320.project.Website;
import edu.ycp.cs320.project.controller.BookController;
import edu.ycp.cs320.project.controller.JournalController;
import edu.ycp.cs320.project.controller.MagazineController;
import edu.ycp.cs320.project.controller.WebsiteController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class GuiMain extends JFrame {
	private JComboBox sourceTypeComboBox;
	private JPanel sourceViewContainerPanel;
	
	private Book book;
	private Website website;
	private BookView bookView;
	private WebsiteView websiteView;
	//
	private Periodical periodical;
	private Journal journal;
	private MagazineView magazineView;
	private JournalView journalView;

	/**
	 * Create the frame.
	 */
	public GuiMain() {
		
		setPreferredSize(new Dimension(600, 450));
		//setLayout(null);
		getContentPane().setLayout(null);
		
		sourceViewContainerPanel = new JPanel();
		sourceViewContainerPanel.setBounds(38, 58, 745, 343);
		getContentPane().add(sourceViewContainerPanel);
		sourceViewContainerPanel.setLayout(new CardLayout(0, 0));
		
		sourceTypeComboBox = new JComboBox();
		sourceTypeComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sourceTypeChanged();
			}
		});
		sourceTypeComboBox.setModel(new DefaultComboBoxModel(SourceType.values()));
		sourceTypeComboBox.setBounds(38, 27, 224, 20);
		getContentPane().add(sourceTypeComboBox);
		
		
	}
	
	public void createSourceViews() {
		
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
		
		
		
		// magazine
		this.periodical = new Periodical();
		this.magazineView = new MagazineView();
		magazineView.setModel(periodical);
		MagazineController magazineController = new MagazineController();
		magazineView.setController(magazineController);
		magazineController.setModel(periodical);
		sourceViewContainerPanel.add(magazineView, SourceType.PERIODICAL.toString());
		
		
		// journal
		this.journal = new Journal();
		this.journalView = new JournalView();
		journalView.setModel(journal);
		JournalController journalController = new JournalController();
		journalView.setController(journalController);
		journalController.setModel(journal);
		sourceViewContainerPanel.add(journalView, SourceType.JOURNAL.toString());
	
		
		CardLayout cardLayout = (CardLayout) sourceViewContainerPanel.getLayout();
		cardLayout.show(sourceViewContainerPanel, SourceType.BOOK.toString());
	}

	protected void sourceTypeChanged() {
		SourceType sourceType = (SourceType) sourceTypeComboBox.getSelectedItem();
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
}
