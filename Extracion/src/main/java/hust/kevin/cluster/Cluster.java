package hust.kevin.cluster;

import java.util.List;

public abstract class Cluster<T> {
	public abstract List<T> getData();
	public abstract float simCaculate(T t1,T t2);
	public abstract List<List<T>> getResult();
}
