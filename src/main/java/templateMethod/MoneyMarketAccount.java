package templateMethod;
/**
* 实现模板类2.
* <br>详细说明
* @date 2015年7月7日 上午9:27:29
 */

public class MoneyMarketAccount extends Account {

    @Override
    protected String doCalculateAccountType() {
        
        return "Money Market";
    }

    @Override
    protected double doCalculateInterestRate() {
        
        return 0.045;
    }

}