package edu.ycp.cs320.project.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import edu.ycp.cs320.project.Book;
import edu.ycp.cs320.project.Periodical;
import edu.ycp.cs320.project.SourceType;
import edu.ycp.cs320.project.Website;
import edu.ycp.cs320.project.controller.BookController;
import edu.ycp.cs320.project.controller.WebsiteController;
import edu.ycp.cs320.project.gui.BookView;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class GuiMain extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<SourceType> sourceTypeComboBox;
	private JPanel sourceViewContainerPanel;
	
	private Book book;
	private Website website;
	private Periodical periodical;
	private PeriodicalView periodicalView;
	private BookView bookView;
	private WebsiteView websiteView;

	/**
	 * Create the frame.
	 */
	public GuiMain() {
		getContentPane().setLayout(null);
		
		sourceViewContainerPanel = new JPanel();
		sourceViewContainerPanel.setBounds(38, 58, 745, 343);
		getContentPane().add(sourceViewContainerPanel);
		sourceViewContainerPanel.setLayout(new CardLayout(0, 0));
		
		sourceTypeComboBox = new JComboBox<SourceType>();
		sourceTypeComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sourceTypeChanged();
			}
		});
		sourceTypeComboBox.setModel(new DefaultComboBoxModel<SourceType>(SourceType.values()));
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
		
		this.periodical = new Periodical();
		this.periodicalView = new PeriodicalView();
		periodicalView.setModel(periodical);
		PeriodicalController periodicalController = new PeriodicalController();
		
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
