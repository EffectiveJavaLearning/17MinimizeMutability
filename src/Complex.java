/**
 * 一个复数的例子，为实部和虚部提供了getter方法(不提供setter !)，四则运算算法，以及equals等标准对象方法。
 * 需要注意，四则运算返回的是新的Complex类实例，而不是修改本身。这种模式被称为函数(functional)方法，
 * 它大多数重要的不可变类都是这么做的。它将结果返回但却不修改操作数本身。与之相对的是过程(procedural)
 * 或命令式(imperative)方法。它们会将操作结果覆盖到操作数上，导致其状态发生改变。
 *
 * 注意，这里的方法名是介词(plus等)而不是动词(add等)，这也再次强调了运算不会改变其操作数的值。
 * {@link java.math.BigInteger}和{@link java.math.BigDecimal}没有遵守这个命名约定，
 * 并导致了许多使用上的误会与错误。
 *
 * 如果对于函数方法并不熟悉，那么刚开始时可能会感觉别扭，但这种方式能够实现不变性，也有很多优势。
 * 不可变对象一般较为简单，它永远保持初始化时赋予它的那一种状态。若能保证所有不变量在创建时都满足该条件，
 * 那么就可以保证它们在整个生命周期中永远不会再发生变化，无需我们再对保护不变性这一方面编写额外代码。
 *
 * 另一方面，对于可变对象，它们有可能会有非常复杂的状态空间，如果文档中没有提供精确的描述，
 * 那么想要正确无误地使用这样一个可变类几乎是不可能的。
 *
 *
 *
 * @author LightDance
 */
public class Complex {
    private final double re;
    private final double im;

    static final Complex ZERO = new Complex(0, 0);
    static final Complex ONE = new Complex(1, 0);
    static final Complex I = new Complex(0, 1);

    private Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double realPart() {
        return re;
    }

    public double imaginaryPart() {
        return im;
    }

    public Complex plus(Complex c) {
        return new Complex(re + c.re, im + c.im);
    }

    public Complex minus(Complex c) {
        return new Complex(re - c.re, im - c.im);
    }

    public Complex times(Complex c) {
        return new Complex(re * c.re - im * c.im,
                re * c.im + im * c.re);
    }

    public Complex dividedBy(Complex c) {
        double tmp = c.re * c.re + c.im * c.im;
        return new Complex((re * c.re + im * c.im) / tmp,
                (im * c.re - re * c.im) / tmp);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Complex)) {
            return false;
        }
        Complex c = (Complex) o;
        // 浮点数不存在绝对的 == ， 因此用Double.compare()
        return Double.compare(c.re, re) == 0
                && Double.compare(c.im, im) == 0;
    }

    @Override
    public int hashCode() {
        return 31 * Double.hashCode(re) + Double.hashCode(im);
    }

    @Override
    public String toString() {
        return "(" + re + " + " + im + "i)";
    }
}
