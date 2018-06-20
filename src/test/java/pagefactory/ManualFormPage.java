package pagefactory;

import actions.WebActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by ionixx on 4/26/18.
 */
public class ManualFormPage {


    static Properties manualFormLocatorsProps = new Properties();
    static Properties manualFormInputsProps = new Properties();

    WebDriver driver;

    public ManualFormPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

        try{
            InputStream manualFormLocatorsStream = new FileInputStream(System.getProperty("user.dir")+ File.separator+"src"+File.separator+"main"+ File.separator+"java"+File.separator+"locators"+File.separator+"manualform_locators.properties");
            InputStream manualFormInputsStream = new FileInputStream(System.getProperty("user.dir")+ File.separator+"src"+File.separator+"main"+ File.separator+"java"+File.separator+"userinputs"+File.separator+"manualform_inputs.properties");
            manualFormLocatorsProps.load(manualFormLocatorsStream);
            manualFormInputsProps.load(manualFormInputsStream);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String fillManualForm(){
        String message = null;
        try{

            WebActions.actionEnterNumber(driver, manualFormLocatorsProps.getProperty("cash"), manualFormInputsProps.getProperty("cash"));
            WebActions.actionEnterNumber(driver, manualFormLocatorsProps.getProperty("account_receivable"), manualFormInputsProps.getProperty("account_receivable"));
            WebActions.actionEnterNumber(driver, manualFormLocatorsProps.getProperty("tax_credit_receivable"), manualFormInputsProps.getProperty("tax_credit_receivable"));
            WebActions.actionEnterNumber(driver, manualFormLocatorsProps.getProperty("other_current_assets"), manualFormInputsProps.getProperty("other_current_assets"));
            WebActions.actionEnterNumber(driver, manualFormLocatorsProps.getProperty("patents&intangible_assets"), manualFormInputsProps.getProperty("patents&intangible_assets"));
            WebActions.actionEnterNumber(driver, manualFormLocatorsProps.getProperty("fixed_assets"), manualFormInputsProps.getProperty("fixed_assets"));
            WebActions.actionEnterNumber(driver, manualFormLocatorsProps.getProperty("other_assets"), manualFormInputsProps.getProperty("other_assets"));
            WebActions.actionEnterNumber(driver, manualFormLocatorsProps.getProperty("account_payable_and_accrued_liability"), manualFormInputsProps.getProperty("account_payable_and_accrued_liability"));
            WebActions.actionEnterNumber(driver, manualFormLocatorsProps.getProperty("bank_debt"), manualFormInputsProps.getProperty("bank_debt"));
            WebActions.actionEnterNumber(driver, manualFormLocatorsProps.getProperty("other_current_liability"), manualFormInputsProps.getProperty("other_current_liability"));
            WebActions.actionEnterNumber(driver, manualFormLocatorsProps.getProperty("deferred_revenue"), manualFormInputsProps.getProperty("deferred_revenue"));
            WebActions.actionEnterNumber(driver, manualFormLocatorsProps.getProperty("espresso_debt_outstanding"), manualFormInputsProps.getProperty("espresso_debt_outstanding"));
            WebActions.actionEnterNumber(driver, manualFormLocatorsProps.getProperty("senior_secured_debt"), manualFormInputsProps.getProperty("senior_secured_debt"));
            WebActions.actionEnterNumber(driver, manualFormLocatorsProps.getProperty("subordinated_debt"), manualFormInputsProps.getProperty("subordinated_debt"));
            WebActions.actionEnterNumber(driver, manualFormLocatorsProps.getProperty("shareholder_loans"), manualFormInputsProps.getProperty("shareholder_loans"));
            WebActions.actionEnterNumber(driver, manualFormLocatorsProps.getProperty("other_liabilities"), manualFormInputsProps.getProperty("other_liabilities"));
            WebActions.actionEnterNumber(driver, manualFormLocatorsProps.getProperty("share_capital_and_contibuted_capital"), manualFormInputsProps.getProperty("share_capital_and_contibuted_capital"));
            WebActions.actionEnterNumber(driver, manualFormLocatorsProps.getProperty("equity_portion_of_lt_debt"), manualFormInputsProps.getProperty("equity_portion_of_lt_debt"));
            WebActions.actionEnterNumber(driver, manualFormLocatorsProps.getProperty("minority_equity_portion"), manualFormInputsProps.getProperty("minority_equity_portion"));
            WebActions.actionEnterNumber(driver, manualFormLocatorsProps.getProperty("retained_earnings"), manualFormInputsProps.getProperty("retained_earnings"));
            WebActions.actionEnterNumber(driver, manualFormLocatorsProps.getProperty("net_income"), manualFormInputsProps.getProperty("net_income"));
            WebActions.actionEnterNumber(driver, manualFormLocatorsProps.getProperty("recurring_revenues"), manualFormInputsProps.getProperty("recurring_revenues"));
            WebActions.actionEnterNumber(driver, manualFormLocatorsProps.getProperty("non_recurring_revenues"), manualFormInputsProps.getProperty("non_recurring_revenues"));
            WebActions.actionEnterNumber(driver, manualFormLocatorsProps.getProperty("cost_of_goods_sold"), manualFormInputsProps.getProperty("cost_of_goods_sold"));
            WebActions.actionEnterNumber(driver, manualFormLocatorsProps.getProperty("sales_and_marketing_expenses"), manualFormInputsProps.getProperty("sales_and_marketing_expenses"));
            WebActions.actionEnterNumber(driver, manualFormLocatorsProps.getProperty("r&d"), manualFormInputsProps.getProperty("r&d"));
            WebActions.actionEnterNumber(driver, manualFormLocatorsProps.getProperty("g&a"), manualFormInputsProps.getProperty("g&a"));
            WebActions.actionEnterNumber(driver, manualFormLocatorsProps.getProperty("depreciation&amortization"), manualFormInputsProps.getProperty("depreciation&amortization"));
            WebActions.actionEnterNumber(driver, manualFormLocatorsProps.getProperty("interest_income"), manualFormInputsProps.getProperty("interest_income"));
            WebActions.actionEnterNumber(driver, manualFormLocatorsProps.getProperty("irap"), manualFormInputsProps.getProperty("irap"));
            WebActions.actionEnterNumber(driver, manualFormLocatorsProps.getProperty("sr&ed"), manualFormInputsProps.getProperty("sr&ed"));
            WebActions.actionEnterNumber(driver, manualFormLocatorsProps.getProperty("other_income"), manualFormInputsProps.getProperty("other_income"));

            WebActions.actionClick(driver, manualFormLocatorsProps.getProperty("submit_button"));

            message = "Manual Form Submitted Successfully";
        }catch (Exception e){
            e.printStackTrace();
        }
        return message;
    }
}
