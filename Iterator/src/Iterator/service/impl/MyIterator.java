package Iterator.service.impl;

import Collection.service.Collection;
import Iterator.service.Iterator;

/**
 * Created by ll on 2017/5/16.
 */
public class MyIterator implements Iterator {
    private Collection collection;
    private int pos= -1;

    public MyIterator(Collection collection){
        this.collection=collection;
    }

    @Override
    public Object previous() {
        if(pos>0){
            pos--;
        }
        return collection.get(pos);
    }

    @Override
    public Object next() {
        if(pos<collection.size()-1){
            pos++;
        }
        return collection.get(pos);
    }

    @Override
    public boolean hasNext() {
        if(pos<collection.size()-1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Object first() {
        pos=0;
        return collection.get(pos);
    }
}
