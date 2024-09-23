package P2;

import javax.swing.JOptionPane;

public class RandomTest {

	public static void main(String[] args) {
		RandomApp app = new RandomApp();
		int choice = 0;
		do {
			String question = app.generateQuestion();
			int answer = Integer.parseInt(JOptionPane.showInputDialog(question));
			if(app.checkAnswer(answer)) {
				JOptionPane.showMessageDialog(null,"Excellent Correct Answer");
			}
			else {
                JOptionPane.showMessageDialog(null,"Incorrect Answer");
            }
			choice = JOptionPane.showConfirmDialog(null, "Continue","Title",JOptionPane.YES_NO_OPTION);
		} while(choice ==0);
		
	}

}
