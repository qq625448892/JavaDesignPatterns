package Iterator.service;

/**
 * Created by ll on 2017/5/16.
 */
public interface Iterator {

    /*前移*/
    Object previous();

    /*后移*/
    Object next();
    boolean hasNext();

    /*取得第一个元素*/
    Object first();
}
