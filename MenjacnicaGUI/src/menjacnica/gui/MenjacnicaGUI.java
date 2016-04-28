package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import java.awt.Rectangle;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenjacnicaGUI extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnHelp;
	private JMenuItem mnItmOpen;
	private JMenuItem mnItmSave;
	private JMenuItem mnItmExit;
	private JMenuItem mnItmAbout;
	private JPanel desniPanel;
	private JButton btnDodajKurs;
	private JButton btnIzbrisiKurs;
	private JButton btnIzvrsiZamenu;
	private JScrollPane scrollPane;
	private JTable tabelaMenjacnica;
	private JPanel donjiPanel;
	private JScrollPane scrollPane_1;
	private JTextArea textAreaStatus;
	private JPopupMenu popupMenu;
	private JMenuItem mnItmDodajKurs;
	private JMenuItem mnItmObrisiKurs;
	private JMenuItem mnItmIzvrsiZamenu;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenjacnicaGUI frame = new MenjacnicaGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public MenjacnicaGUI() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				GUIKontroler.zatvoriAplikaciju();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenjacnicaGUI.class.getResource("/resources/euro-simbol.jpg")));
		setTitle("Menjacnica");
		setBounds(100, 100, 678, 388);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getDesniPanel(), BorderLayout.EAST);
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
		contentPane.add(getDonjiPanel(), BorderLayout.SOUTH);
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}
	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.add(getMnItmOpen());
			mnFile.add(getMnItmSave());
			mnFile.add(getMnItmExit());
		}
		return mnFile;
	}
	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.add(getMnItmAbout());
		}
		return mnHelp;
	}
	private JMenuItem getMnItmOpen() {
		if (mnItmOpen == null) {
			mnItmOpen = new JMenuItem("Open");
			mnItmOpen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textAreaStatus.append(GUIKontroler.ucitajFajl());
				}
			});
			mnItmOpen.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/TreeOpen.gif")));
			mnItmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		}
		return mnItmOpen;
	}
	private JMenuItem getMnItmSave() {
		if (mnItmSave == null) {
			mnItmSave = new JMenuItem("Save");
			mnItmSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textAreaStatus.append(GUIKontroler.sacuvajFajl());
				}
			});
			mnItmSave.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
			mnItmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		}
		return mnItmSave;
	}
	private JMenuItem getMnItmExit() {
		if (mnItmExit == null) {
			mnItmExit = new JMenuItem("Exit");
			mnItmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.zatvoriAplikaciju();
				}
			});
			mnItmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_MASK));
		}
		return mnItmExit;
	}
	private JMenuItem getMnItmAbout() {
		if (mnItmAbout == null) {
			mnItmAbout = new JMenuItem("About");
			mnItmAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.aboutDijalog();
				}
			});
		}
		return mnItmAbout;
	}
	private JPanel getDesniPanel() {
		if (desniPanel == null) {
			desniPanel = new JPanel();
			desniPanel.setPreferredSize(new Dimension(130, 10));
			desniPanel.add(getBtnDodajKurs());
			desniPanel.add(getBtnIzbrisiKurs());
			desniPanel.add(getBtnIzvrsiZamenu());
		}
		return desniPanel;
	}
	private JButton getBtnDodajKurs() {
		if (btnDodajKurs == null) {
			btnDodajKurs = new JButton("Dodaj kurs");
			btnDodajKurs.setPreferredSize(new Dimension(120, 23));
		}
		return btnDodajKurs;
	}
	private JButton getBtnIzbrisiKurs() {
		if (btnIzbrisiKurs == null) {
			btnIzbrisiKurs = new JButton("Izbrisi kurs");
			btnIzbrisiKurs.setPreferredSize(new Dimension(120, 23));
		}
		return btnIzbrisiKurs;
	}
	private JButton getBtnIzvrsiZamenu() {
		if (btnIzvrsiZamenu == null) {
			btnIzvrsiZamenu = new JButton("Izvrsi zamenu");
			btnIzvrsiZamenu.setPreferredSize(new Dimension(120, 23));
		}
		return btnIzvrsiZamenu;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			addPopup(scrollPane, getPopupMenu());
			scrollPane.setViewportView(getTabelaMenjacnica());
		}
		return scrollPane;
	}
	private JTable getTabelaMenjacnica() {
		if (tabelaMenjacnica == null) {
			tabelaMenjacnica = new JTable();
			tabelaMenjacnica.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Sifra", "Skraceni naziv", "Prodajni", "Srednji", "Kupovni", "Naziv"
				}
			));
		}
		return tabelaMenjacnica;
	}
	private JPanel getDonjiPanel() {
		if (donjiPanel == null) {
			donjiPanel = new JPanel();
			donjiPanel.setBorder(new TitledBorder(null, "STATUS", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			donjiPanel.setPreferredSize(new Dimension(60, 100));
			donjiPanel.setLayout(new BorderLayout(0, 0));
			donjiPanel.add(getScrollPane_1(), BorderLayout.CENTER);
		}
		return donjiPanel;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setViewportView(getTextAreaStatus());
		}
		return scrollPane_1;
	}
	private JTextArea getTextAreaStatus() {
		if (textAreaStatus == null) {
			textAreaStatus = new JTextArea();
		}
		return textAreaStatus;
	}
	private JPopupMenu getPopupMenu() {
		if (popupMenu == null) {
			popupMenu = new JPopupMenu();
			popupMenu.add(getMnItmDodajKurs());
			popupMenu.add(getMnItmObrisiKurs());
			popupMenu.add(getMnItmIzvrsiZamenu());
		}
		return popupMenu;
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	private JMenuItem getMnItmDodajKurs() {
		if (mnItmDodajKurs == null) {
			mnItmDodajKurs = new JMenuItem("Dodaj kurs");
		}
		return mnItmDodajKurs;
	}
	private JMenuItem getMnItmObrisiKurs() {
		if (mnItmObrisiKurs == null) {
			mnItmObrisiKurs = new JMenuItem("Obrisi kurs");
		}
		return mnItmObrisiKurs;
	}
	private JMenuItem getMnItmIzvrsiZamenu() {
		if (mnItmIzvrsiZamenu == null) {
			mnItmIzvrsiZamenu = new JMenuItem("Izvrsi zamenu");
		}
		return mnItmIzvrsiZamenu;
	}
}
