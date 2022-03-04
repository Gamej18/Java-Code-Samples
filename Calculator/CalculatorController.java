import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class CalculatorController {
    private CalculatorView theView;
    private CalculatorModel theModel;

    public CalculatorController(CalculatorView theView, CalculatorModel theModel)
    {
        this.theView = theView;
        this.theModel = theModel;

        this.theView.addCalculationListener(new CalculateListener());
    }

    class CalculateListener implements ActionListener{
        public void actionPerformed(ActionEvent arg0)
        {
            int firstNumber, secondNumber = 0;

            try
            {
                firstNumber = theView.getFirstNumber();
                secondNumber = theView.getSecondNumber();

                theModel.addTwoNumbers(firstNumber, secondNumber);

                theView.setCalcSolution(theModel.getCalculation());
            }

            catch(NumberFormatException ex)
            {
                theView.displayErrorMessage("Need Two Integer Values");
            }
        }
    }
}
