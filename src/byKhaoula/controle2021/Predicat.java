package byKhaoula.controle2021;

public interface Predicat<T> {
    boolean test(T t) throws IlligalArgumentException;

}
