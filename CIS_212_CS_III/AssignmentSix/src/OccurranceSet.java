import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
//Assignment 6 Written by Charlie Quinn Student ID: 951334907
public class OccurranceSet<T> implements Set<T> {
	
	HashMap<T, Integer> map = new HashMap();
	int count = 1;

	//works
	@Override
	public boolean add(T e) {
		if(map.containsKey(e))
		{
			count = map.get(e)+1;
			map.put(e, count);
			return true;
		}
		else{
			count = 1;
			map.put(e, count);
			return true;
		}
		
	}

	//works
	@Override
	public boolean addAll(Collection<? extends T> c) {
			boolean changed = false;
			for (T elem : c)
			{
				if(map.containsKey(elem))
				{
					count = map.get(elem)+1;
					map.put(elem, count);
					changed = true;
				}
				else{
					count = 1;
					map.put(elem, count);
				}
			}
			return changed;
			

	}
	
	
	//works
	@Override
	public void clear() {
		map.clear();
		count = 0;
	}

	//works
	@Override
	public boolean contains(Object e) {
		for (Object o : map.keySet()){
			if (o == e){
				return true;
			}
		}
		return false;
	}

	//works
	@Override
	public boolean containsAll(Collection<?> c) {
		boolean ans = true;
		for(Object elem : c){
			if(map.containsKey(elem)==false){
				ans = false;
			}
		}
		
		return ans;
	}

	//works
	@Override
	public boolean isEmpty() {
		if(map.isEmpty())
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

	
	//WORKS
	@Override
	public Iterator<T> iterator() {
		
		
		Object[] n = new Object[map.size()];
		Collection<Integer> v = map.values();
		int i = 0;
		for(Integer el : v)
		{
			n[i] = el;
			i++;
		}
		Arrays.sort(n);
		
		Set<T> a = map.keySet();
		
		HashMap<T, Integer> umap = new HashMap<T, Integer>(map);
		T k;
		ArrayList<T> toReturn = new ArrayList<T>();
		for(Object el : n){
			k = (T) getKeyFromValue(umap, el);
			toReturn.add(k);
			umap.remove(k);
		}
		
		Iterator<T> it = toReturn.iterator();
		
		return it;
	}
	
	//works
	@Override
	public boolean remove(Object e) {
		if(map.containsKey(e))
		{
			map.remove(e);
			return true;
		}
		else
		{
		return false;
		}
	}
	
	//works
	@Override
	public boolean removeAll(Collection<?> c) {
		boolean changed = false;
		for(Object e : c)
		{
			if(map.containsKey(e))
			{
				map.remove(e);
				changed = true;
			}
		}
		return changed;
	}

	
	//works
	@Override
	public boolean retainAll(Collection<?> c) {
		boolean changed = true;
		ArrayList<T> keep = new ArrayList<T>();
		ArrayList<Integer> keepv = new ArrayList<Integer>();
		
		for (T e : map.keySet())
		{
			if(c.contains(e))
			{
				keep.add(e);
				keepv.add(map.get(e));
			}
		}
		if(keep.size() == map.size()) {
			changed = false;
		}
		map.clear();
		
		
		for(int i = 0; i < keep.size(); i++)
		{
			map.put(keep.get(i), keepv.get(i));
			count++;
		}
		return changed;
	}

	
	//works
	@Override
	public int size() {
		return map.size();
	}

	
	//works
	@Override
	public Object[] toArray() {
		Object[] n = new Object[map.size()];
		Collection<Integer> v = map.values();
		int i = 0;
		for(Integer el : v)
		{
			n[i] = el;
			i++;
		}
		Arrays.sort(n);
		
		Set<T> a = map.keySet();
		
		HashMap<T, Integer> umap = new HashMap<T, Integer>(map);
		Object k;
		int g = 0;
		Object[] toReturn = new Object[map.size()];
		for(Object el : n){
			k = getKeyFromValue(umap, el);
			toReturn[g] = k;
			umap.remove(k);
			g++;
		}
		
		return toReturn;
	}
	
	public Object getKeyFromValue(Map MAP, Object V) {
	    for (Object o : MAP.keySet()) {
	      if (MAP.get(o).equals(V)) {
	        return o;
	      }
	    }
	    return null;
	  }
	

	
	//works
	@Override
	public String toString(){
		String returner = "";
		Object[] n = new Object[map.size()];
		Collection<Integer> v = map.values();
		int i = 0;
		for(Integer el : v)
		{
			n[i] = el;
			i++;
		}
		Arrays.sort(n);
		
		Set<T> a = map.keySet();
		
		HashMap<T, Integer> umap = new HashMap<T, Integer>(map);
		Object k;
		int g = 0;
		
		returner = returner +"[";
		int s = n.length;
		for(Object el : n){
			k = getKeyFromValue(umap, el);
			returner = returner + k;
			s--;
			if(s>0){
				returner = returner + ", ";
			}
			umap.remove(k);
			g++;
		}
		returner = returner + "]";
		
		return returner;
	}
	
	
	//not sure what this is for.
	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
}


