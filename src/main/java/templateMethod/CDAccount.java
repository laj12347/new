package templateMethod;
/**
* 实现模板类1.
* <br>详细说明
* @date 2015年7月7日 上午9:27:00
 */
public class CDAccount extends Account {

    @Override
    protected String doCalculateAccountType() {
        return "Certificate of Deposite";
    }

    @Override
    protected double doCalculateInterestRate() {
        return 0.06;
    }

}
