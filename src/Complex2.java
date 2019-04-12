/**
 * 演示如何通过私有化构造方法，公有化静态工厂方法的方式，灵活地防止自己被子类继承。
 * 由于允许多个package-private型实现类，它往往是最灵活的，因此一般会被认为是最佳的备选方案。
 * 对于客户端（位于该包外部）来讲，这种类实际上等价于final型，因为不能直接访问re和im，
 * 又不能直接继承来自其他package，缺少public型或者protected型构造方法的类。
 * 这种方式也可以通过添加或优化静态工厂中的缓存机制从而提高性能。
 *
 * @author LightDance
 */
public class Complex2 {

    private final double re;
    private final double im;

    private Complex2(double re , double im){
        this.re = re;
        this.im = im;
    }

    public static Complex2 valueOf(double re , double im){
        return new Complex2(re , im);
    }

}
