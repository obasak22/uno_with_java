package main;

import data.UserStatistics;
import starting.MainFrame;

/**A USER MUST TERMINATE THE PROGRAM IN THIS CLASS
 */

public class Main {
	public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        UserStatistics.startWithStatistics();
	}
}