import javax.swing.*;

public class Runner {
    public static void main(String[] args) {
        Runner f = new Runner();

        Object[] option1 = {"NOK", "YEN", "EUR", "GBP", "Quit"};
        Object[] option2 = {"Try Again", "Quit"};

        while(true){
            String input = JOptionPane.showInputDialog(null, "Enter value (USD): ");
            System.out.println(input);

            if (input == null) {
                break;
            }

            if(f.check(input)){
                double Minput = Double.parseDouble(input);


                int choice1 = JOptionPane.showOptionDialog(null, "Choose Which Currency You Wish To Convert From USD",
                        "Currency Converter", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                        option1, option1[option1.length - 1]);

                boolean performAnotherConversion = true;

                if (choice1 == 0){
                    f.dollarToNok(Minput);
                } else if (choice1 == 1) {
                    f.dollarToJpy(Minput);
                } else if (choice1 == 2) {
                    f.dollarToEur(Minput);
                } else if (choice1 == 3) {
                    f.dollarToGbp(Minput);
                } else {
                    performAnotherConversion = false;
                }

                if (!performAnotherConversion) {
                    break;
                }


                int choice2 = JOptionPane.showOptionDialog(null, "What do you wish to do?", "Currency Converter",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, option2, option2[1]);

                if(choice2 != 0) {
                    break;
                }


            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid Input. Please enter a valid number.");

                int choice2 = JOptionPane.showOptionDialog(null, "What do you wish to do?", "Currency Converter",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, option2, option2[1]);

                if(choice2 != 0) {
                    break;
                }

            }
        }
        System.out.println("Converter exited.");
    }

    public boolean check(String input){
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
        try{
            double x = Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    public void dollarToNok(double Minput) {
        double nok = Minput * 10.50;
        JOptionPane.showMessageDialog(null, String.format("%.2f USD is %.2f NOK", Minput, nok));
    }

    public void dollarToJpy(double Minput) {
        double jpy = Minput * 150.0;
        JOptionPane.showMessageDialog(null, String.format("%.2f USD is %.2f JPY", Minput, jpy));
    }

    public void dollarToEur(double Minput) {
        double eur = Minput * 0.92;
        JOptionPane.showMessageDialog(null, String.format("%.2f USD is %.2f EUR", Minput, eur));
    }

    public void dollarToGbp(double Minput) {
        double gbp = Minput * 0.79;
        JOptionPane.showMessageDialog(null, String.format("%.2f USD is %.2f GBP", Minput, gbp));
    }
}
