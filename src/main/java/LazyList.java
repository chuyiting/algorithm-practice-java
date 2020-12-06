import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.function.UnaryOperator;
class LazyList<T> {
    List<Lazy<T>> list;
    private LazyList(List<Lazy<T>> list) {
        this.list = list;
    }
    static <T> LazyList<T> generate(int n, T seed, UnaryOperator<T> f) {
        return new LazyList<T>(
                Stream.iterate(Lazy.of(seed),
                        x -> x.map(v -> f.apply(v))) .limit(n) .collect(Collectors.toList())
        ); }
    public T get(int i) {
        return this.list.get(i).get();
    }
    public int indexOf(T v) {
        return this.list.indexOf(Lazy.of(v));
    }
    @Override
    public String toString() {
        return list.toString();
    }

    public static void main(String[] args) {
        LazyList<Integer> list = LazyList.generate(10, 1, x -> x * 2);
        System.out.println(list);
        list.get(4);
        System.out.println(list);
    }
}
