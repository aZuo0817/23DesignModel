package 关系模式11种;

/**
 * 策略模式定义了一系列算法，并将每个算法封装起来，使他们可以相互替换，且算法的变化不会影响到使用算法的客户，
 * 需要设计一个接口，为一些列实现类提供统一的方法，多个实现类实现该接口，设计一个抽象类（可有可无，属于辅助类），提供辅助类函数
 *
 * 策略模式的决定权在用户，系统本身提供不同算法的实现，对各种算法做封装，
 * 因此，策略模式多用在算法决策系统中，外部用户只需要决定用那个算法即可
 */

/*接口*/
interface ICaculator {
    public int caculate(String name);
}

/*辅助类*/
abstract class AbstractCalculator{
    public int[] split(String exp, String opt){
        String[] array = exp.split(opt);
        int[] arrayInt = new int[2];
        arrayInt[0] = Integer.parseInt(array[0]);
        arrayInt[1] = Integer.parseInt(array[1]);
        return arrayInt;
    }
}
/*三个实现类*/
class Plus extends AbstractCalculator implements ICaculator{

    @Override
    public int caculate(String exp) {
        int[] arrayInt = split(exp, "\\+");
        return arrayInt[0] + arrayInt[1];
    }
}
class Minus extends AbstractCalculator implements ICaculator{

    @Override
    public int caculate(String exp) {
        int[] arrayInt = split(exp, "\\-");
        return arrayInt[0] - arrayInt[1];
    }
}

class Multipy extends AbstractCalculator implements ICaculator{

    @Override
    public int caculate(String exp) {
        int[] arrayInt = split(exp, "\\*");
        return arrayInt[0] * arrayInt[1];
    }
}

public class A13策略Strategy {
    public static void main(String[] args) {
        String exp = "2+8";
        ICaculator cal = new Plus();
        int result = cal.caculate(exp);
        System.out.println(result);
    }
}
