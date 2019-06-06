package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import brainGoodBye.Project;

/**
 * This panel displays concise project information.
 * 
 * @author Joey Hunt
 * @author Hunter Lantz
 */
public class Thumbnail extends JPanel implements MouseListener, PropertyChangeListener {
	
	/**
	 * A generated serial UID.
	 */
	private static final long serialVersionUID = 2653951540567950260L;
	
	/**
	 * A project to display the information of.
	 */
	private Project myProject;
	
	private OptionsPanel myOptions;
	
	private Color myColor= Color.pink;
	
	/**
	 * Creates a thumbnail.
	 * 
	 * @author Joey Hunt
	 * @author Hunter Lantz
	 */
	public Thumbnail(final Project project, OptionsPanel options) {
		myProject = project; 
		myOptions=options;
		this.setLayout(new BorderLayout());
		this.setBackground(myColor);
		initialize();
		this.setMaximumSize(new Dimension(4000,100));
		this.addMouseListener(this);
	}
	
	/**
	 * @author Hunter Lantz
	 * @author Joey Hunt
	 */
	private void initialize() {
		final JLabel name = new JLabel("<HTML><U>"+myProject.getName()+"</U></HTML>");
		
		JPanel namePanel = new JPanel();
		namePanel.setBackground(Color.LIGHT_GRAY);
		namePanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		namePanel.setLayout(new BorderLayout());
		namePanel.add(name, BorderLayout.WEST);
		
		
		JPanel costPan = new JPanel();
		costPan.setBackground(Color.LIGHT_GRAY);
		costPan.setLayout(new BoxLayout(costPan, BoxLayout.Y_AXIS));
		costPan.add(new JLabel("<HTML><U>Current Cost:</U> $"+myProject.getSpent()+"</HTML>"));
		costPan.add(new JLabel("<HTML><U>Expected Cost:</U> $"+myProject.totalCost()+"</HTML>"));
		
		JPanel timePan = new JPanel();
		timePan.setBackground(Color.LIGHT_GRAY);
		timePan.setLayout(new BoxLayout(timePan, BoxLayout.Y_AXIS));
		timePan.add(new JLabel("<HTML><U>Current Time:</U> "+myProject.getHoursDone()+" hours</HTML>"));
		timePan.add(new JLabel("<HTML><U>Extimated Total:</U> "+myProject.getTotalHours()+" hours</HTML>"));
		
		JPanel oPanel = new JPanel();
		oPanel.setBackground(Color.LIGHT_GRAY);
		oPanel.setLayout(new BoxLayout(oPanel, BoxLayout.X_AXIS));
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		JLabel date = new JLabel("Last Modified "+dateFormat.format(myProject.getLastModified()));
		date.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		oPanel.add(date);
		oPanel.add(Box.createRigidArea(new Dimension(20,0)));
		JLabel df = new JLabel("SL: "+myProject.getDifficulty());
		df.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		oPanel.add(df);
		oPanel.add(Box.createRigidArea(new Dimension(20,0)));
		JLabel size = new JLabel("Size "+myProject.getSize());
		size.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		oPanel.add(size);
		
		
		add(namePanel, BorderLayout.NORTH);
		add(costPan, BorderLayout.WEST);
		add(timePan, BorderLayout.EAST);
		add(oPanel, BorderLayout.SOUTH);
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		//setPreferredSize(new Dimension(200, 100));
	}
	
	/**
	 * Returns the project associated with this thumbnail.
	 * 
	 * @author Joey Hunt
	 * @return This thumbnail's project.
	 */
	public Project getProject() {
		return myProject;
	}

	/**
	 * @Author for all mouse events Hunter
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		this.setBackground(Color.BLUE);	
		myColor=Color.blue;
		this.firePropertyChange("DClick", false, true);
		myOptions.setSelected(this);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		if(myColor != Color.blue) {
			this.setBackground(Color.red);
		}
		
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		this.setBackground(myColor);
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @Author Hunter
	 */
	@Override
	public void propertyChange(PropertyChangeEvent e) {
		if("DClick".equals(e.getPropertyName())) {
			if(e.getSource()!=this) {
				myColor=Color.pink;
				this.setBackground(myColor);
			}
			
		}
		
	}
}
