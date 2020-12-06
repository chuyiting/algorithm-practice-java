import java.util.function.Supplier;
import java.util.function.Function;
import java.util.Optional;
import java.util.function.BiFunction;

class Lazy<T> {
    private Optional<T> value = Optional.empty();
    private Supplier<T> supplier;

    public static <T> Lazy<T> of (T v) {
        return new Lazy(v); 
    }

    public static <T> Lazy<T> of (Supplier<T> s) {
        return new Lazy(s);
    }

    private Lazy(T t) {
        this.value = Optional.of(t);
    }

    private Lazy(Supplier<T> s) {
        this.supplier = s;
    }

    public T get() {
        T returnValue = value.orElseGet(supplier);
        this.value = Optional.of(returnValue);
        return returnValue;
    }

    public <U> Lazy<U> map(Function<? super T, ? extends U> function) {
        return new Lazy(() -> function.apply(get()));
    }

    public <U> Lazy<U> flatMap(Function<?super T, ? extends Lazy<U>> function) {
        return new Lazy(() -> function.apply(get()).get());
    }

    public <U, R> Lazy<R> combine(Lazy<U> another, BiFunction<? super T, ? super U, ? extends R> f) {
        return new Lazy(() -> f.apply(get(), another.get()));
    }

    public String toString() {
        return value.map(v -> v.toString()).orElse("?");
    }

}
