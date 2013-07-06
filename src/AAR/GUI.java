package AAR;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.mcavallo.opencloud.Cloud;
import org.mcavallo.opencloud.Tag;


public class GUI {
	   public static List<String> NameList = new ArrayList<String>();
	   public static List<String> WordList = new ArrayList<String>();
	   public static TreeMap<String,Integer> dictionary = new TreeMap<String,Integer>();

	   protected void initUI() {
	        JFrame frame = new JFrame(String_Load.class.getSimpleName());
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        JPanel panel = new JPanel();
	        Cloud cloud = new Cloud();
	        Random random = new Random();
	        int j = 0;
	        
	        for (int i = 0; i < WordList.size(); i++) {
	        	cloud.addTag(WordList.get(i));
	        }
	        System.out.println(cloud.size());
	        for (Tag tag : cloud.tags()) {
	            final JLabel label = new JLabel(tag.getName());
	            label.setOpaque(false);
	            label.setFont(label.getFont().deriveFont((float) tag.getWeight() * 50));
	            panel.add(label);
	            j++;
	        }
	        System.out.println(j);
	        frame.add(panel);
	        frame.setSize(800, 600);
	        frame.setVisible(true);
	    }   	   
	   
	   public static void main(String [ ] args)
	   {
		   String f = "myfile.txt";
		   String_Load.ReadDoc(f, NameList);
		   Text_Analysis.Run(NameList, WordList, dictionary);
		   SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                new GUI().initUI();
	            }
	        });
	   }
}
