import javax.swing.*;

public class Runner {
    public static void main(String[] args) {
        Runner f = new Runner();
        Object[] option1 = {"NOK", "YEN", "Quit"};
        Object[] option2 = {"Try Again", "Quit"};

        while(true){
            String input = JOptionPane.showInputDialog(null, "Enter value: ");
            System.out.println(input);

            if(f.check(input) == true){
                double Minput = Double.parseDouble(input);

                int choice1 = JOptionPane.showOptionDialog(null, "Choose Which Currency You Wish To Convert",
                        "Currency Converter", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                        option1, option1[2]);

                if (choice1 == 0){
                    f.dollarToNok(Minput);

                    int choice2 = JOptionPane.showOptionDialog(null, "What do you wish to do?", "Currency Converter",
                            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option2, option2[1]);

                    if(choice2 == 0) {

                    } else {break;}

                } else if (choice1 == 1) {
                    f.dollarToJpy(Minput);

                    int choice2 = JOptionPane.showOptionDialog(null, "What do you wish to do?", "Currency Converter",
                            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option2, option2[1]);

                    if(choice2 == 0) {

                    } else {break;}

                } else {break;}
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid Output");

                int choice2 = JOptionPane.showOptionDialog(null, "What do you wish to do?", "Currency Converter",
                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option2, option2[1]);

                if(choice2 == 0) {

                } else {break;}
            }
        }
    }

    public boolean check(String input){
        try{
            double x = Double.parseDouble(input);
            if(x >= 0 || x < 0);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    public void dollarToNok(double Minput) {
        double nok = Minput * 8.2;
        JOptionPane.showMessageDialog(null, "Amount of Nok: " + nok + "kr");
    }

    public void dollarToJpy(double Minput) {
        double jpy = Minput * 112.7;
        JOptionPane.showMessageDialog(null, "Amount of JPY: " + jpy + "Yen");
    }
}